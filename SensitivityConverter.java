/**
 * Core logic for DPI conversion between different games
 */
public class DPIConverter {
    
    // Game multiplier constants (normalized to Valorant = 1.0)
    private static final double VALORANT_MULTIPLIER = 1.0;
    private static final double CS2_MULTIPLIER = 0.8;
    private static final double OVERWATCH_MULTIPLIER = 1.15;
    private static final double APEX_MULTIPLIER = 0.9;
    private static final double ROBLOX_MULTIPLIER = 0.95;
    private static final double CROSSFIRE_MULTIPLIER = 1.1;
    
    /**
     * Convert DPI/Sensitivity between two games
     * @param sourceSensitivity The source game sensitivity
     * @param sourceGame The source game name
     * @param targetGame The target game name
     * @return The converted sensitivity for target game
     */
    public double convertDPI(double sourceSensitivity, String sourceGame, String targetGame) {
        double sourceMultiplier = getGameMultiplier(sourceGame);
        double targetMultiplier = getGameMultiplier(targetGame);
        
        // Convert from source game to neutral baseline, then to target game
        double neutralValue = sourceSensitivity / sourceMultiplier;
        return neutralValue * targetMultiplier;
    }
    
    /**
     * Get the sensitivity multiplier for a specific game
     * @param gameName The game name
     * @return The multiplier for that game (normalized to Valorant = 1.0)
     */
    public double getGameMultiplier(String gameName) {
        if (gameName == null) return VALORANT_MULTIPLIER;
        
        switch (gameName.toUpperCase()) {
            case "VALORANT":
                return VALORANT_MULTIPLIER;
            case "CS2":
            case "COUNTER-STRIKE 2":
                return CS2_MULTIPLIER;
            case "OVERWATCH 2":
            case "OVERWATCH":
                return OVERWATCH_MULTIPLIER;
            case "APEX LEGENDS":
            case "APEX":
                return APEX_MULTIPLIER;
            case "ROBLOX":
                return ROBLOX_MULTIPLIER;
            case "CROSSFIRE":
                return CROSSFIRE_MULTIPLIER;
            default:
                return VALORANT_MULTIPLIER;
        }
    }
    
    /**
     * Get all supported games
     * @return Array of supported game names
     */
    public String[] getSupportedGames() {
        return new String[]{
            "Valorant",
            "CS2",
            "Overwatch 2",
            "Apex Legends",
            "Roblox",
            "Crossfire"
        };
    }
    
    /**
     * Validate DPI value
     * @param dpi The DPI value to validate
     * @return true if valid (between 50 and 3200), false otherwise
     */
    public boolean isValidDPI(double dpi) {
        return dpi >= 50 && dpi <= 3200;
    }
    
    /**
     * Validate sensitivity value
     * @param sensitivity The sensitivity value to validate
     * @return true if valid (between 0 and 100), false otherwise
     */
    public boolean isValidSensitivity(double sensitivity) {
        return sensitivity >= 0 && sensitivity <= 100;
    }
    
    /**
     * Calculate effective sensitivity (DPI * In-Game Sensitivity)
     * @param dpi The mouse DPI
     * @param inGameSensitivity The in-game sensitivity setting
     * @return The effective sensitivity value
     */
    public double calculateEffectiveSensitivity(double dpi, double inGameSensitivity) {
        return (dpi / 800.0) * inGameSensitivity; // Normalized to 800 DPI baseline
    }
}
