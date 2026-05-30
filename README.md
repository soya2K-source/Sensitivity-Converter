# Sensitivity Converter for Games

A Java Swing application that converts in-game sensitivity settings across different games and gaming platforms.

## Overview

This project helps gamers convert their sensitivity settings from one game to another, maintaining consistency in aim feel across different titles.

## Features

- 🎮 Support for multiple popular games (RUN/WALK modes)
- 🔄 Real-time sensitivity conversion
- 🎯 Intuitive GUI built with Java Swing
- 📊 Visual sliders for easy adjustments

## Project Structure

```
src/
├── SensitivityConverterApp.java      # Main entry point
├── SensitivityConverterGUI.java      # GUI implementation with Swing components
└── SensitivityConverter.java         # Conversion logic and calculations
```

## Swing Components Used

**Every Swing Component Used:**
1. Label (1x)
2. Radio Button (2x)
3. Toggle Button (1x)
4. Button (1x)
5. Frame (1x)
6. Slider (2x)
7. Text Field (2x)

**Components Which Use Action Listener:**
1. Button
2. Radio Button (1 & 2)
3. Toggle Button

## How to Run

1. Compile the project:
   ```bash
   javac src/*.java
   ```

2. Run the application:
   ```bash
   java -cp src SensitivityConverterApp
   ```

## Usage

1. Select the source game using radio buttons (RUN/WALK)
2. Enter your current sensitivity value
3. Select the target game
4. Click "Convert" to see the equivalent sensitivity
5. Use the toggle button to switch between conversion modes

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Author

Created as a class project.
