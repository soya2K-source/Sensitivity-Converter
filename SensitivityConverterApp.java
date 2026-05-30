/**
 * Main entry point for the DPI Converter application
 */
public class DPIConverterApp {
    public static void main(String[] args) {
        // Launch the GUI on the Event Dispatch Thread
        javax.swing.SwingUtilities.invokeLater(() -> {
            DPIConverterGUI gui = new DPIConverterGUI();
            gui.setVisible(true);
        });
    }
}
