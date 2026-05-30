/**
 * Main entry point for the Sensitivity Converter application
 */
public class SensitivityConverterApp {
    public static void main(String[] args) {
        // Launch the GUI on the Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(() -> {
            SensitivityConverterGUI gui = new SensitivityConverterGUI();
            gui.setVisible(true);
        });
    }
}
