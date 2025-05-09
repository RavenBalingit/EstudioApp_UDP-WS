import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SeleccionTipoEjercicioForm extends JDialog {

    private BloqueTematico bloqueSeleccionado;
    private JFrame parentForm; 

    public SeleccionTipoEjercicioForm(JFrame parent, BloqueTematico bloque) {
        super(parent, "Seleccionar Tipo de Ejercicio", true);
        this.parentForm = parent; 
        this.bloqueSeleccionado = bloque;

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout(10,10));

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnPreguntasTest = new JButton("Preguntas Test");
        JButton btnRellenarCodigo = new JButton("Ejercicios de Rellenar Código");

        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        btnPreguntasTest.setFont(buttonFont);
        btnRellenarCodigo.setFont(buttonFont);

        btnPreguntasTest.addActionListener(e -> iniciarSesionEstudio(TipoEjercicio.TEST));
        btnRellenarCodigo.addActionListener(e -> iniciarSesionEstudio(TipoEjercicio.RELLENAR_CODIGO));

        buttonPanel.add(btnPreguntasTest);
        buttonPanel.add(btnRellenarCodigo);

        JLabel lblTitle = new JLabel("Tema: " + bloque.toString(), SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));

        add(lblTitle, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                boolean questionDisplayActive = false;
                for (Window window : Window.getWindows()) {
                    if (window instanceof QuestionDisplayForm && window.isVisible()) {
                        questionDisplayActive = true;
                        break;
                    }
                }
                if (parentForm != null && !questionDisplayActive) {
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

    private void iniciarSesionEstudio(TipoEjercicio tipo) {
        dispose();
        StudySessionManager manager = new StudySessionManager(bloqueSeleccionado, tipo);

        if (!manager.hayEjerciciosDisponibles()) {
            JOptionPane.showMessageDialog(parentForm, 
                "No hay ejercicios disponibles para la selección: " + bloqueSeleccionado + " - " + tipo,
                "Sin Ejercicios",
                JOptionPane.INFORMATION_MESSAGE);
            if (parentForm != null) {
                parentForm.setVisible(true); 
            }
            return;
        }
        new QuestionDisplayForm(parentForm, manager, true).setVisible(true);
    }
}