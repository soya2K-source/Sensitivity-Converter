import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI implementation for DPI Converter
 * Uses Swing components following proper naming conventions
 */
public class DPIConverterGUI extends JFrame {
    
    // Components - following the template naming convention
    private JLabel jLabel1;              // Title
    private JLabel jLabel2;              // Source Game label
    private JLabel jLabel3;              // Target Game label
    private JLabel jLabel4;              // Result label
    private JRadioButton jRadioButton1;  // DPI Mode
    private JRadioButton jRadioButton2;  // Sensitivity Mode
    private JToggleButton jToggleButton1; // Switch games
    private JButton jButton1;             // Convert button
    private JSlider jSlider1;             // Source sensitivity slider
    private JSlider jSlider2;             // Target sensitivity slider
    private JTextField jTextField1;       // Source value display
    private JTextField jTextField2;       // Target value display
    private JComboBox<String> jComboBox1; // Source game selection
    private JComboBox<String> jComboBox2; // Target game selection
    private JLabel jLabelResult;
    private ButtonGroup buttonGroup;
    
    private DPIConverter converter;
    
    public DPIConverterGUI() {
        converter = new DPIConverter();
        initializeComponents();
        setupLayout();
        setupListeners();
    }
    
    /**
     * Initialize all Swing components
     */
    private void initializeComponents() {
        // Frame setup
        setTitle("DPI Converter for Games");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Labels
        jLabel1 = new JLabel("Game DPI/Sensitivity Converter");
        jLabel1.setFont(new Font("Arial", Font.BOLD, 18));
        
        jLabel2 = new JLabel("Source Game:");
        jLabel2.setFont(new Font("Arial", Font.PLAIN, 12));
        
        jLabel3 = new JLabel("Target Game:");
        jLabel3.setFont(new Font("Arial", Font.PLAIN, 12));
        
        jLabel4 = new JLabel("Conversion Mode:");
        jLabel4.setFont(new Font("Arial", Font.PLAIN, 12));
        
        // Radio buttons for conversion mode
        jRadioButton1 = new JRadioButton("DPI Mode", true);
        jRadioButton2 = new JRadioButton("Sensitivity Mode");
        
        buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        
        // Toggle button
        jToggleButton1 = new JToggleButton("Switch Games");
        
        // Game selection dropdowns
        String[] games = converter.getSupportedGames();
        jComboBox1 = new JComboBox<>(games);
        jComboBox1.setSelectedItem("Valorant");
        
        jComboBox2 = new JComboBox<>(games);
        jComboBox2.setSelectedItem("CS2");
        
        // Sliders (0-100 range for sensitivity, scaled for DPI)
        jSlider1 = new JSlider(0, 100, 50);
        jSlider1.setMajorTickSpacing(10);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintTicks(true);
        jSlider1.setPaintLabels(true);
        
        jSlider2 = new JSlider(0, 100, 50);
        jSlider2.setMajorTickSpacing(10);
        jSlider2.setMinorTickSpacing(1);
        jSlider2.setPaintTicks(true);
        jSlider2.setPaintLabels(true);
        
        // Text fields
        jTextField1 = new JTextField("50", 10);
        jTextField1.setEditable(false);
        
        jTextField2 = new JTextField("50", 10);
        jTextField2.setEditable(false);
        
        // Convert button
        jButton1 = new JButton("CONVERT");
        jButton1.setBackground(new Color(52, 152, 219));
        jButton1.setForeground(Color.WHITE);
        jButton1.setFont(new Font("Arial", Font.BOLD, 14));
        jButton1.setPreferredSize(new Dimension(150, 40));
        
        // Result label
        jLabelResult = new JLabel("Select games and enter sensitivity value");
    }
    
    /**
     * Setup the layout using GridBagLayout
     */
    private void setupLayout() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(245, 245, 245));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        int row = 0;
        
        // Title
        gbc.gridx = 0;
        gbc.gridy = row++;
        gbc.gridwidth = 2;
        mainPanel.add(jLabel1, gbc);
        
        // Game selection section
        gbc.gridy = row++;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        mainPanel.add(jLabel2, gbc);
        
        gbc.gridx = 1;
        mainPanel.add(jComboBox1, gbc);
        
        gbc.gridy = row++;
        gbc.gridx = 0;
        mainPanel.add(jLabel3, gbc);
        
        gbc.gridx = 1;
        mainPanel.add(jComboBox2, gbc);
        
        // Mode selection
        gbc.gridy = row++;
        gbc.gridx = 0;
        mainPanel.add(jLabel4, gbc);
        
        gbc.gridx = 1;
        mainPanel.add(jRadioButton1, gbc);
        
        gbc.gridy = row++;
        gbc.gridx = 1;
        mainPanel.add(jRadioButton2, gbc);
        
        // Toggle button
        gbc.gridy = row++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        mainPanel.add(jToggleButton1, gbc);
        
        // Source sensitivity
        gbc.gridy = row++;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        mainPanel.add(new JLabel("Source Value:"), gbc);
        
        gbc.gridx = 1;
        mainPanel.add(jTextField1, gbc);
        
        gbc.gridy = row++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        mainPanel.add(jSlider1, gbc);
        
        // Target sensitivity
        gbc.gridy = row++;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        mainPanel.add(new JLabel("Target Value:"), gbc);
        
        gbc.gridx = 1;
        mainPanel.add(jTextField2, gbc);
        
        gbc.gridy = row++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        mainPanel.add(jSlider2, gbc);
        
        // Convert button
        gbc.gridy = row++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(jButton1, gbc);
        
        // Result display
        gbc.gridy = row++;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(jLabelResult, gbc);
        
        add(mainPanel);
    }
    
    /**
     * Setup action listeners for components
     */
    private void setupListeners() {
        // Slider 1 listener
        jSlider1.addChangeListener(e -> {
            int value = jSlider1.getValue();
            jTextField1.setText(String.valueOf(value));
        });
        
        // Slider 2 listener
        jSlider2.addChangeListener(e -> {
            int value = jSlider2.getValue();
            jTextField2.setText(String.valueOf(value));
        });
        
        // Radio button 1 listener (DPI Mode)
        jRadioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabelResult.setText("DPI Mode selected - Conversions based on DPI sensitivity");
            }
        });
        
        // Radio button 2 listener (Sensitivity Mode)
        jRadioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabelResult.setText("Sensitivity Mode selected - Conversions based on in-game sensitivity");
            }
        });
        
        // Toggle button listener
        jToggleButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jToggleButton1.isSelected()) {
                    // Swap the games
                    String temp = (String) jComboBox1.getSelectedItem();
                    jComboBox1.setSelectedItem(jComboBox2.getSelectedItem());
                    jComboBox2.setSelectedItem(temp);
                    jLabelResult.setText("Games switched!");
                } else {
                    jLabelResult.setText("Ready to convert");
                }
            }
        });
        
        // Convert button listener
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performConversion();
            }
        });
        
        // ComboBox listeners
        jComboBox1.addActionListener(e -> jLabelResult.setText("Source game changed"));
        jComboBox2.addActionListener(e -> jLabelResult.setText("Target game changed"));
    }
    
    /**
     * Perform the DPI/Sensitivity conversion
     */
    private void performConversion() {
        try {
            int sourceValue = jSlider1.getValue();
            String sourceGame = (String) jComboBox1.getSelectedItem();
            String targetGame = (String) jComboBox2.getSelectedItem();
            
            if (sourceGame.equals(targetGame)) {
                jLabelResult.setText("Error: Source and target games must be different!");
                return;
            }
            
            double convertedValue = converter.convertDPI(sourceValue, sourceGame, targetGame);
            
            // Cap the value at 100 for display
            int displayValue = Math.min((int) convertedValue, 100);
            jSlider2.setValue(displayValue);
            jTextField2.setText(String.format("%.2f", convertedValue));
            
            String mode = jRadioButton1.isSelected() ? "DPI" : "Sensitivity";
            jLabelResult.setText("✓ Conversion successful! " + sourceGame + " → " + targetGame + " (" + mode + " mode)");
        } catch (NumberFormatException ex) {
            jLabelResult.setText("Error: Please enter valid numbers");
        } catch (Exception ex) {
            jLabelResult.setText("Error: " + ex.getMessage());
        }
    }
}
