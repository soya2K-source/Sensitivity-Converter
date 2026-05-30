# DPI Converter for Games

A Java Swing application that converts mouse DPI settings across different popular games, maintaining consistent aiming feel and sensitivity across different titles.

## Overview

This project helps gamers convert their DPI (dots per inch) and in-game sensitivity settings from one game to another, maintaining consistency in aim feel across different games and gaming platforms.

## Features

- 🎮 Support for multiple popular games (Valorant, Roblox, CS2, Crossfire, Overwatch, and more)
- 🔄 Real-time DPI to sensitivity conversion
- 🎯 Intuitive GUI built with Java Swing
- 📊 Visual sliders for easy adjustments
- 💾 Quick conversion between any supported games

## Supported Games

- **Valorant** (1.0x multiplier baseline)
- **CS2** (Counter-Strike 2)
- **Overwatch 2**
- **Roblox**
- **Crossfire**
- **Apex Legends**

## Project Structure

```
src/
├── DPIConverterApp.java           # Main entry point
├── DPIConverterGUI.java           # GUI implementation with Swing components
└── DPIConverter.java              # DPI conversion logic and calculations
```

## Swing Components Used

**Every Swing Component Used:**
1. Label (4x)
2. Radio Button (2x)
3. Toggle Button (1x)
4. Button (1x)
5. Frame (1x)
6. Slider (2x)
7. Text Field (2x)
8. ComboBox (2x) - For game selection

**Components Which Use Action Listener:**
1. Button (Convert)
2. Radio Button (Game Mode selection)
3. Toggle Button (Switch modes)
4. ComboBox (Game selection)

## How to Run

1. Compile the project:
   ```bash
   javac *.java
   ```

2. Run the application:
   ```bash
   java DPIConverterApp
   ```

## Usage

1. Select source game from dropdown
2. Enter your current DPI value
3. Enter your in-game sensitivity
4. Select target game from dropdown
5. Click "CONVERT" to calculate equivalent sensitivity
6. Use toggle button to switch conversion modes
7. View the converted DPI/sensitivity values

## DPI Conversion Formula

The converter uses game-specific multipliers to calculate equivalent sensitivity:
```
Converted Sensitivity = (Source Sensitivity × Source Game Multiplier) / Target Game Multiplier
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Author

Created as a class project for DPI/Sensitivity conversion learning.
