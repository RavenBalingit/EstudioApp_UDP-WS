import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class EstudioApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                System.err.println("No se pudo establecer el Look and Feel del sistema: " + e.getMessage());
            }
            new MainForm();
        });
    }
}