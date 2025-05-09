import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat; // Para formatear el porcentaje
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionDisplayForm extends JDialog {

    private JFrame parentForm;
    private StudySessionManager manager;

    private JLabel lblContadorPreguntas;
    private JTextPane textPaneEnunciadoCodigo;
    private JPanel panelOpcionesEntradas;
    private JScrollPane scrollPaneOpcionesEntradas;
    private JButton btnVerificar;
    private JButton btnSiguiente;
    private JLabel lblFeedback;
    private JScrollPane scrollPaneSugerencias;
    private JPanel panelPalabrasSugeridas;

    private ButtonGroup grupoOpcionesTest;
    private List<JRadioButton> radioButtonsOpciones;

    private List<DropTargetPanel> dropTargetPanels;
    private Map<DropTargetPanel, JLabel> droppedWordsMap;
    private EjercicioRellenarCodigo currentEjercicioRellenar;
    private List<JLabel> draggableWordLabels;

    public QuestionDisplayForm(JFrame parent, StudySessionManager manager, boolean visible) {
        super(parent, "Sesión de Estudio", true);
        this.parentForm = parent;
        this.manager = manager;
        this.droppedWordsMap = new HashMap<>();
        this.draggableWordLabels = new ArrayList<>();

        if (manager == null && visible) {
            return;
        }

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(850, 750);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout(10, 10));

        initComponents();
        if (manager != null) {
             cargarSiguientePregunta();
        }

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (parentForm != null) {
                    parentForm.setVisible(true);
                }
            }
            @Override
            public void windowClosing(WindowEvent e) {
                if (parentForm != null) {
                    parentForm.setVisible(true);
                }
            }
        });
    }

    private void initComponents() {
        JPanel panelSuperior = new JPanel(new BorderLayout());
        lblContadorPreguntas = new JLabel("Pregunta X de Y", SwingConstants.CENTER);
        lblContadorPreguntas.setFont(new Font("Arial", Font.BOLD, 16));
        panelSuperior.add(lblContadorPreguntas, BorderLayout.NORTH);

        panelPalabrasSugeridas = new JPanel();
        panelPalabrasSugeridas.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
        scrollPaneSugerencias = new JScrollPane(panelPalabrasSugeridas);
        scrollPaneSugerencias.setBorder(BorderFactory.createTitledBorder("Arrastra las palabras a los huecos:"));
        scrollPaneSugerencias.setPreferredSize(new Dimension(getWidth(), 120));
        panelSuperior.add(scrollPaneSugerencias, BorderLayout.SOUTH);
        scrollPaneSugerencias.setVisible(false);

        add(panelSuperior, BorderLayout.NORTH);

        textPaneEnunciadoCodigo = new JTextPane();
        textPaneEnunciadoCodigo.setEditable(false);
        textPaneEnunciadoCodigo.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textPaneEnunciadoCodigo.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        JScrollPane scrollPaneEnunciado = new JScrollPane(textPaneEnunciadoCodigo);
        add(scrollPaneEnunciado, BorderLayout.CENTER);

        panelOpcionesEntradas = new JPanel();
        panelOpcionesEntradas.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        scrollPaneOpcionesEntradas = new JScrollPane(panelOpcionesEntradas);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        btnVerificar = new JButton("Verificar Respuesta");
        btnSiguiente = new JButton("Siguiente Pregunta");

        lblFeedback = new JLabel(" ", SwingConstants.CENTER);
        lblFeedback.setFont(new Font("Arial", Font.BOLD, 14));
        lblFeedback.setPreferredSize(new Dimension(400, 25));
        lblFeedback.setOpaque(false);

        btnVerificar.setFont(new Font("Arial", Font.PLAIN, 14));
        btnSiguiente.setFont(new Font("Arial", Font.PLAIN, 14));

        btnVerificar.addActionListener(e -> verificarRespuesta());
        btnSiguiente.addActionListener(e -> {
            if (manager != null) {
                manager.avanzarSiguienteEjercicio();
                cargarSiguientePregunta();
            }
        });

        panelBotones.add(btnVerificar);
        panelBotones.add(btnSiguiente);
        panelBotones.add(lblFeedback);

        JPanel bottomContainer = new JPanel(new BorderLayout());
        bottomContainer.add(scrollPaneOpcionesEntradas, BorderLayout.CENTER);
        bottomContainer.add(panelBotones, BorderLayout.SOUTH);
        add(bottomContainer, BorderLayout.SOUTH);
    }

    private void cargarSiguientePregunta() {
        if (manager == null) return;
        ItemEstudio item = manager.getEjercicioActual(); 

        if (item == null) { 
            int correctas = manager.getRespuestasCorrectas();
            int incorrectas = manager.getRespuestasIncorrectas();
            int total = manager.getTotalIntentos();
            double porcentaje = manager.getPorcentajeAciertos();
            DecimalFormat df = new DecimalFormat("0.00");

            String resumen = String.format(
                "<html><body style='width: 300px;'>" +
                "¡Has completado todos los ejercicios de esta sección!<br><br>" +
                "<b>Resumen de la Sesión:</b><br>" +
                "Ejercicios Correctos: %d<br>" +
                "Ejercicios Incorrectos: %d<br>" +
                "Total de Ejercicios Intentados: %d<br>" +
                "Porcentaje de Aciertos: %s%%" +
                "</body></html>",
                correctas, incorrectas, total, df.format(porcentaje)
            );

            JOptionPane.showMessageDialog(this, resumen, "Fin de la Sesión", JOptionPane.INFORMATION_MESSAGE);
            dispose(); 
            return;
        }

        currentEjercicioRellenar = null;
        droppedWordsMap.clear();
        draggableWordLabels.clear();
        panelPalabrasSugeridas.removeAll();

        lblFeedback.setText(" ");
        lblFeedback.setForeground(Color.BLACK);
        lblFeedback.setVisible(true);

        btnVerificar.setEnabled(true); 
        btnSiguiente.setEnabled(false); 
        scrollPaneSugerencias.setVisible(false);

        lblContadorPreguntas.setText("Ejercicio " + (manager.getIndiceEjercicioActual() + 1) + " de " + manager.getNumeroTotalEjercicios());
        panelOpcionesEntradas.removeAll();

        if (item instanceof PreguntaTest) {
            mostrarPreguntaTest((PreguntaTest) item);
        } else if (item instanceof EjercicioRellenarCodigo) {
            currentEjercicioRellenar = (EjercicioRellenarCodigo) item;
            mostrarEjercicioRellenar(currentEjercicioRellenar);
        }

         if (manager.esUltimoEjercicio() && manager.getIndiceEjercicioActual() == manager.getNumeroTotalEjercicios() -1) {
            btnSiguiente.setText("Finalizar Sesión");
        } else {
            btnSiguiente.setText("Siguiente Ejercicio");
        }


        panelOpcionesEntradas.revalidate();
        panelOpcionesEntradas.repaint();
        panelPalabrasSugeridas.revalidate();
        panelPalabrasSugeridas.repaint();
        textPaneEnunciadoCodigo.setCaretPosition(0);
        scrollPaneOpcionesEntradas.getViewport().setViewPosition(new Point(0,0));

        if (lblFeedback.getParent() != null) {
            lblFeedback.getParent().revalidate();
            lblFeedback.getParent().repaint();
        }
    }

    private void mostrarPreguntaTest(PreguntaTest pregunta) {
        textPaneEnunciadoCodigo.setContentType("text/plain");
        textPaneEnunciadoCodigo.setText(pregunta.getEnunciado());
        panelOpcionesEntradas.setLayout(new BoxLayout(panelOpcionesEntradas, BoxLayout.Y_AXIS));
        grupoOpcionesTest = new ButtonGroup();
        radioButtonsOpciones = new ArrayList<>();

        for (String opcion : pregunta.getOpciones()) {
            JRadioButton radio = new JRadioButton("<html><body style='width: 500px'>" + opcion.replace("<", "&lt;").replace(">", "&gt;") + "</body></html>");
            radio.setFont(new Font("Arial", Font.PLAIN, 13));
            grupoOpcionesTest.add(radio);
            radioButtonsOpciones.add(radio);
            panelOpcionesEntradas.add(radio);
            panelOpcionesEntradas.add(Box.createRigidArea(new Dimension(0, 5)));
        }
        int preferredHeightTest = Math.min(500, pregunta.getOpciones().size() * 35 + 40);
        scrollPaneOpcionesEntradas.setPreferredSize(new Dimension(scrollPaneOpcionesEntradas.getPreferredSize().width, preferredHeightTest));
    }

    private void mostrarEjercicioRellenar(EjercicioRellenarCodigo ejercicio) {
        textPaneEnunciadoCodigo.setContentType("text/plain");
        StyledDocument doc = textPaneEnunciadoCodigo.getStyledDocument();
        Style defaultStyle = doc.getStyle("defaultStyle");
        if (defaultStyle == null) {
            defaultStyle = doc.addStyle("defaultStyle", null);
            StyleConstants.setFontFamily(defaultStyle, "Monospaced");
            StyleConstants.setFontSize(defaultStyle, 14);
        }
        try {
            doc.remove(0, doc.getLength());
            doc.insertString(0, ejercicio.getEnunciado() + "\n\n" + "--- INICIO CÓDIGO ---\n" + ejercicio.getCodigoConHuecos() + "\n--- FIN CÓDIGO ---", defaultStyle);
        } catch (BadLocationException e) {
            System.err.println("Error al insertar texto en JTextPane: " + e.getMessage());
            textPaneEnunciadoCodigo.setText("Error al cargar el ejercicio.");
        }

        panelPalabrasSugeridas.removeAll();
        draggableWordLabels.clear();
        for (String palabra : ejercicio.getElementosSugeridos()) {
            JLabel palabraLabel = new JLabel(palabra);
            palabraLabel.setOpaque(true);
            palabraLabel.setBackground(new Color(220, 220, 255));
            palabraLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)
            ));
            palabraLabel.setFont(new Font("Arial", Font.BOLD, 13));
            palabraLabel.setTransferHandler(new WordSourceTransferHandler(palabra));
            palabraLabel.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    JComponent comp = (JComponent) e.getSource();
                    TransferHandler handler = comp.getTransferHandler();
                    handler.exportAsDrag(comp, e, TransferHandler.COPY);
                }
            });
            panelPalabrasSugeridas.add(palabraLabel);
            draggableWordLabels.add(palabraLabel);
        }
        scrollPaneSugerencias.setVisible(true);
        scrollPaneSugerencias.getViewport().setViewPosition(new Point(0,0));

        panelOpcionesEntradas.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3, 5, 3, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        dropTargetPanels = new ArrayList<>();
        int numHuecos = ejercicio.getNumeroDeHuecos();

        for (int i = 0; i < numHuecos; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            gbc.weightx = 0.0;
            gbc.anchor = GridBagConstraints.WEST;
            JLabel lblHuecoNumero = new JLabel("Hueco " + (i + 1) + ":");
            lblHuecoNumero.setFont(new Font("Arial", Font.PLAIN, 13));
            panelOpcionesEntradas.add(lblHuecoNumero, gbc);

            gbc.gridx = 1;
            gbc.weightx = 1.0;
            gbc.anchor = GridBagConstraints.CENTER;
            DropTargetPanel dropPanel = new DropTargetPanel(i + 1);
            dropTargetPanels.add(dropPanel);
            panelOpcionesEntradas.add(dropPanel, gbc);
        }

        int singleDropPanelHeight = new DropTargetPanel(0).getPreferredSize().height;
        int visibleRows = Math.min(numHuecos, 4);
        int preferredHeightHuecos = visibleRows * (singleDropPanelHeight + gbc.insets.top + gbc.insets.bottom) + 20;
        preferredHeightHuecos = Math.max(100, Math.min(preferredHeightHuecos, 200));

        scrollPaneOpcionesEntradas.setPreferredSize(new Dimension(scrollPaneOpcionesEntradas.getPreferredSize().width, preferredHeightHuecos));
    }


    private void verificarRespuesta() {
        if (manager == null) return;
        ItemEstudio itemActual = manager.getEjercicioActual();

        lblFeedback.setText("");
        lblFeedback.setForeground(Color.BLACK);
        lblFeedback.setVisible(true);

        if (itemActual == null) {
            lblFeedback.setText("Error: No hay ejercicio actual para verificar.");
            lblFeedback.setForeground(Color.RED);
            btnVerificar.setEnabled(false);
            btnSiguiente.setEnabled(true);
            if (lblFeedback.getParent() != null) {
                lblFeedback.getParent().revalidate();
                lblFeedback.getParent().repaint();
            }
            return;
        }

        boolean fueRespuestaCorrecta = false; 

        if (itemActual instanceof PreguntaTest) {
            PreguntaTest pregunta = (PreguntaTest) itemActual;
            if (grupoOpcionesTest.getSelection() == null) {
                lblFeedback.setText("Por favor, selecciona una opción.");
                lblFeedback.setForeground(Color.ORANGE);
                if (lblFeedback.getParent() != null) { 
                    lblFeedback.getParent().revalidate();
                    lblFeedback.getParent().repaint();
                }
                return; 
            }
            String respuestaUsuario = "";
            for (JRadioButton radio : radioButtonsOpciones) {
                if (radio.isSelected()) {
                    String htmlText = radio.getText();
                    respuestaUsuario = htmlText.replaceAll("<[^>]*>", "").replace("&lt;", "<").replace("&gt;", ">").trim();
                    break;
                }
            }
            fueRespuestaCorrecta = pregunta.verificarRespuesta(respuestaUsuario); 
            if (fueRespuestaCorrecta) {
                lblFeedback.setText("¡Correcto!");
                lblFeedback.setForeground(new Color(0, 128, 0));
            } else {
                lblFeedback.setText("<html>Incorrecto. La respuesta correcta era: <br/><b>" + pregunta.getRespuestaCorrecta().replace("<", "&lt;").replace(">", "&gt;") + "</b></html>");
                lblFeedback.setForeground(Color.RED);
            }

        } else if (itemActual instanceof EjercicioRellenarCodigo) {
            if (currentEjercicioRellenar == null) {
                lblFeedback.setText("Error interno: Ejercicio de rellenar no disponible.");
                lblFeedback.setForeground(Color.RED);
                btnVerificar.setEnabled(false);
                btnSiguiente.setEnabled(true);
                if (lblFeedback.getParent() != null) {
                    lblFeedback.getParent().revalidate();
                    lblFeedback.getParent().repaint();
                }
                return;
            }
            boolean todosLosHuecosCorrectos = true;

            if (dropTargetPanels == null || dropTargetPanels.isEmpty()){
                 lblFeedback.setText("Error: No hay huecos definidos para este ejercicio.");
                 lblFeedback.setForeground(Color.RED);
                 todosLosHuecosCorrectos = false;
            } else {
                for (DropTargetPanel dropPanel : dropTargetPanels) {
                    String palabraEnHueco = dropPanel.getDroppedWord();
                    String solucionParaEsteHueco = currentEjercicioRellenar.getSoluciones().get(dropPanel.getBlankNumber());

                    if (palabraEnHueco != null && !palabraEnHueco.isEmpty()) {
                        if (palabraEnHueco.equals(solucionParaEsteHueco)) {
                            dropPanel.setFeedbackColor(new Color(200, 255, 200));
                        } else {
                            dropPanel.setFeedbackColor(new Color(255, 200, 200));
                            todosLosHuecosCorrectos = false;
                        }
                    } else {
                        dropPanel.setFeedbackColor(Color.WHITE);
                        todosLosHuecosCorrectos = false;
                    }
                }
            }
            fueRespuestaCorrecta = todosLosHuecosCorrectos; 
            if (fueRespuestaCorrecta) {
                lblFeedback.setText("¡Todos los huecos son correctos!");
                lblFeedback.setForeground(new Color(0, 128, 0));
            } else {
                if (lblFeedback.getText().isEmpty() || lblFeedback.getText().equals(" ")) {
                     lblFeedback.setText("Algunos huecos son incorrectos o están vacíos. Revisa los colores.");
                     lblFeedback.setForeground(Color.RED);
                }
            }
        }

        if (manager != null) {
            manager.registrarRespuesta(fueRespuestaCorrecta);
        }

        btnVerificar.setEnabled(false);
        btnSiguiente.setEnabled(true);  

        if (manager != null && manager.esUltimoEjercicio() && manager.getIndiceEjercicioActual() == manager.getNumeroTotalEjercicios() -1) {
            btnSiguiente.setText("Finalizar Sesión");
        } else {
            btnSiguiente.setText("Siguiente Ejercicio");
        }


        if (lblFeedback.getParent() != null) {
            lblFeedback.getParent().revalidate();
            lblFeedback.getParent().repaint();
        }
    }

    private class DropTargetPanel extends JPanel {
        private JLabel wordLabel;
        private int blankNumber;
        private String droppedWordText = null;

        public DropTargetPanel(int blankNumber) {
            this.blankNumber = blankNumber;
            this.wordLabel = new JLabel("Arrastra aquí (Hueco " + blankNumber + ")");
            this.wordLabel.setForeground(Color.LIGHT_GRAY);
            this.wordLabel.setFont(new Font("Arial", Font.ITALIC, 12));
            this.wordLabel.setHorizontalAlignment(SwingConstants.CENTER);

            setLayout(new BorderLayout());
            add(wordLabel, BorderLayout.CENTER);
            setPreferredSize(new Dimension(150, 35));
            setBorder(BorderFactory.createDashedBorder(Color.GRAY));
            setBackground(Color.WHITE);

            this.setTransferHandler(new WordDropTargetTransferHandler());
        }

        public void setDroppedWord(String word, JLabel originalDraggableLabel) {
            this.droppedWordText = word;
            this.wordLabel.setText(word);
            this.wordLabel.setForeground(Color.BLACK);
            this.wordLabel.setFont(new Font("Arial", Font.BOLD, 13));
            this.wordLabel.setBackground(new Color(220, 220, 255));
            this.wordLabel.setOpaque(true);
            
            for (Map.Entry<DropTargetPanel, JLabel> entry : new HashMap<>(droppedWordsMap).entrySet()) {
                 if (entry.getValue() == originalDraggableLabel && entry.getKey() != this) {
                    entry.getKey().clearWord();
                }
            }
            droppedWordsMap.put(this, originalDraggableLabel);
            setFeedbackColor(Color.WHITE);
        }
        
        public void clearWord() {
            this.droppedWordText = null;
            this.wordLabel.setText("Arrastra aquí (Hueco " + blankNumber + ")");
            this.wordLabel.setForeground(Color.LIGHT_GRAY);
            this.wordLabel.setFont(new Font("Arial", Font.ITALIC, 12));
            this.wordLabel.setOpaque(false);
            this.wordLabel.setBackground(UIManager.getColor("Panel.background"));
            droppedWordsMap.remove(this);
            setBackground(Color.WHITE);
        }

        public String getDroppedWord() {
            return droppedWordText;
        }

        public int getBlankNumber() {
            return blankNumber;
        }

        public void setFeedbackColor(Color color) {
            if (droppedWordText != null && !droppedWordText.isEmpty()) {
                wordLabel.setBackground(color);
                wordLabel.setOpaque(true);
            } else {
                setBackground(color.equals(Color.WHITE) ? Color.WHITE : new Color(240,240,240));
                wordLabel.setOpaque(false);
            }
            repaint();
        }
    }

    private class WordSourceTransferHandler extends TransferHandler {
        private final String word;

        public WordSourceTransferHandler(String word) {
            this.word = word;
        }

        @Override
        public int getSourceActions(JComponent c) {
            return COPY;
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            return new TransferableWord(word, (JLabel) c);
        }

        @Override
        protected void exportDone(JComponent source, Transferable data, int action) {
        }
    }
    
    public static class TransferableWord implements Transferable {
        public static final DataFlavor WORD_FLAVOR;
        static {
            try {
                WORD_FLAVOR = new DataFlavor(DataFlavor.javaJVMLocalObjectMimeType + ";class=" + TransferableWord.class.getName());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Error inicializando DataFlavor", e);
            }
        }
        
        private String word;
        private JLabel sourceLabel;

        public TransferableWord(String word, JLabel sourceLabel) {
            this.word = word;
            this.sourceLabel = sourceLabel;
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{WORD_FLAVOR, DataFlavor.stringFlavor};
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return flavor.equals(WORD_FLAVOR) || flavor.equals(DataFlavor.stringFlavor);
        }

        @Override
        public Object getTransferData(DataFlavor flavor) {
            if (flavor.equals(WORD_FLAVOR)) {
                return this;
            }
            if (flavor.equals(DataFlavor.stringFlavor)) {
                return word;
            }
            return null;
        }
        
        public String getWord() { return word; }
        public JLabel getSourceLabel() { return sourceLabel; }
    }

    private class WordDropTargetTransferHandler extends TransferHandler {
        @Override
        public boolean canImport(TransferSupport support) {
            return support.isDataFlavorSupported(TransferableWord.WORD_FLAVOR);
        }

        @Override
        public boolean importData(TransferSupport support) {
            if (!canImport(support)) {
                return false;
            }
            DropTargetPanel targetPanel = (DropTargetPanel) support.getComponent();
            Transferable transferable = support.getTransferable();
            try {
                TransferableWord transferableWord = (TransferableWord) transferable.getTransferData(TransferableWord.WORD_FLAVOR);
                
                JLabel sourceLabelDragged = transferableWord.getSourceLabel();
                for (Map.Entry<DropTargetPanel, JLabel> entry : new HashMap<>(droppedWordsMap).entrySet()) {
                     if (entry.getValue() == sourceLabelDragged && entry.getKey() != targetPanel) {
                        entry.getKey().clearWord();
                    }
                }
                
                targetPanel.setDroppedWord(transferableWord.getWord(), sourceLabelDragged);
                return true;
            } catch (Exception e) {
                System.err.println("Error al importar datos de D&D: " + e.getMessage());
                e.printStackTrace();
                return false;
            }
        }
    }
}