import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI implementation for Sensitivity Converter
 * Uses Swing components following proper naming conventions
 */
public class SensitivityConverterGUI extends JFrame {
    
    // Components - following the template naming convention
    private JLabel jLabel1;
    private JRadioButton jRadioButton1;  // RUN
    private JRadioButton jRadioButton2;  // WALK
    private JToggleButton jToggleButton1;
    private JButton jButton1;            // Convert button
    private JSlider jSlider1;            // Source sensitivity
    private JSlider jSlider2;            // Target sensitivity
    private JTextField jTextField1;      // Source value display
    private JTextField jTextField2;      // Target value display
    private JLabel jLabelResult;
    private ButtonGroup buttonGroup;
    
    private SensitivityConverter converter;
    
    public SensitivityConverterGUI() {
        converter = new SensitivityConverter();
        initializeComponents();
        setupLayout();
        setupListeners();
    }
    
    /**
     * Initialize all Swing components
     */
    private void initializeComponents() {
        // Frame setup
        setTitle("Sensitivity Converter for Games");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Label
        jLabel1 = new JLabel("Game Sensitivity Converter");
        jLabel1.setFont(new Font("Arial", Font.BOLD, 18));
        
        // Radio buttons
        jRadioButton1 = new JRadioButton("RUN Mode", true);
        jRadioButton2 = new JRadioButton("WALK Mode");
        
        buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        
        // Toggle button
        jToggleButton1 = new JToggleButton("Switch Games");
        
        // Sliders (0-100 range)
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
        
        // Result label
        jLabelResult = new JLabel("Enter sensitivity and click Convert");
    }
    
    /**
     * Setup the layout using GridBagLayout
     */
    private void setupLayout() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        // Title
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        mainPanel.add(jLabel1, gbc);
        
        // Mode selection
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(new JLabel("Select Mode:"), gbc);
        
        gbc.gridx = 1;
        mainPanel.add(jRadioButton1, gbc);
        
        gbc.gridy = 2;
        gbc.gridx = 0;
        mainPanel.add(new JLabel(""), gbc);
        
        gbc.gridx = 1;
        mainPanel.add(jRadioButton2, gbc);
        
        // Toggle button
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        mainPanel.add(jToggleButton1, gbc);
        
        // Source sensitivity
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        mainPanel.add(new JLabel("Source Sensitivity:"), gbc);
        
        gbc.gridx = 1;
        mainPanel.add(jTextField1, gbc);
        
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        mainPanel.add(jSlider1, gbc);
        
        // Target sensitivity
        gbc.gridy = 6;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        mainPanel.add(new JLabel("Target Sensitivity:"), gbc);
        
        gbc.gridx = 1;
        mainPanel.add(jTextField2, gbc);
        
        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        mainPanel.add(jSlider2, gbc);
        
        // Convert button
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        mainPanel.add(jButton1, gbc);
        
        // Result display
        gbc.gridy = 9;
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
        
        // Radio button 1 listener
        jRadioButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabelResult.setText("RUN Mode selected");
            }
        });
        
        // Radio button 2 listener
        jRadioButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jLabelResult.setText("WALK Mode selected");
            }
        });
        
        // Toggle button listener
        jToggleButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mode = jToggleButton1.isSelected() ? "Games Switched" : "Games Normal";
                jLabelResult.setText(mode);
            }
        });
        
        // Convert button listener
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performConversion();
            }
        });
    }
    
    /**
     * Perform the sensitivity conversion
     */
    private void performConversion() {
        try {
            int sourceValue = jSlider1.getValue();
            String mode = jRadioButton1.isSelected() ? "RUN" : "WALK";
            boolean switched = jToggleButton1.isSelected();
            
            double convertedValue = converter.convert(sourceValue, mode, switched);
            jSlider2.setValue((int) convertedValue);
            jTextField2.setText(String.format("%.2f", convertedValue));
            
            jLabelResult.setText("Conversion successful! " + mode + " mode");
        } catch (NumberFormatException ex) {
            jLabelResult.setText("Error: Please enter valid numbers");
        }
    }
}
