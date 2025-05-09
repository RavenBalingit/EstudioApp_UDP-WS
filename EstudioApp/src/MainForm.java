import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {

    public MainForm() {
        setTitle("Aplicación de Estudio - Java Networking");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 250);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton btnEstudiarUDP = new JButton("Estudiar UDP");
        JButton btnEstudiarWebSockets = new JButton("Estudiar WebSockets");
        JButton btnEstudiarAmbos = new JButton("Estudiar Ambos");

        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        btnEstudiarUDP.setFont(buttonFont);
        btnEstudiarWebSockets.setFont(buttonFont);
        btnEstudiarAmbos.setFont(buttonFont);

        btnEstudiarUDP.addActionListener(e -> abrirVentanaSeleccion(BloqueTematico.UDP));
        btnEstudiarWebSockets.addActionListener(e -> abrirVentanaSeleccion(BloqueTematico.WEB_SOCKETS));
        btnEstudiarAmbos.addActionListener(e -> abrirVentanaSeleccion(BloqueTematico.AMBOS));

        buttonPanel.add(btnEstudiarUDP);
        buttonPanel.add(btnEstudiarWebSockets);
        buttonPanel.add(btnEstudiarAmbos);

        JLabel lblTitle = new JLabel("Selecciona un Bloque Temático", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));

        add(lblTitle, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private void abrirVentanaSeleccion(BloqueTematico bloque) {
        this.setVisible(false);
        new SeleccionTipoEjercicioForm(this, bloque).setVisible(true);
    }
}