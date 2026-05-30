/**
 * Core logic for sensitivity conversion between different games
 */
public class SensitivityConverter {
    
    // Sensitivity multipliers for different games
    private static final double RUN_MODE_MULTIPLIER = 1.0;
    private static final double WALK_MODE_MULTIPLIER = 0.75;
    private static final double GAME_A_MULTIPLIER = 1.0;
    private static final double GAME_B_MULTIPLIER = 1.25;
    
    /**
     * Convert sensitivity value based on game mode
     * @param sourceValue The source sensitivity value
     * @param mode The game mode (RUN or WALK)
     * @param switched Whether games are switched
     * @return The converted sensitivity value
     */
    public double convert(int sourceValue, String mode, boolean switched) {
        double multiplier = calculateMultiplier(mode, switched);
        return sourceValue * multiplier;
    }
    
    /**
     * Calculate the conversion multiplier based on mode and switch state
     * @param mode The game mode
     * @param switched Whether games are switched
     * @return The multiplier to apply
     */
    private double calculateMultiplier(String mode, boolean switched) {
        double modeMultiplier = "RUN".equalsIgnoreCase(mode) ? 
            RUN_MODE_MULTIPLIER : WALK_MODE_MULTIPLIER;
        
        double gameMultiplier = switched ? 
            GAME_B_MULTIPLIER : GAME_A_MULTIPLIER;
        
        return modeMultiplier * gameMultiplier;
    }
    
    /**
     * Convert sensitivity between specific games
     * @param sourceValue The source sensitivity
     * @param sourceGame The source game identifier
     * @param targetGame The target game identifier
     * @return The converted sensitivity
     */
    public double convertBetweenGames(int sourceValue, String sourceGame, String targetGame) {
        double sourceMultiplier = getGameMultiplier(sourceGame);
        double targetMultiplier = getGameMultiplier(targetGame);
        
        // Convert from source game to neutral, then to target game
        double neutral = sourceValue / sourceMultiplier;
        return neutral * targetMultiplier;
    }
    
    /**
     * Get the sensitivity multiplier for a specific game
     * @param gameName The game name
     * @return The multiplier for that game
     */
    private double getGameMultiplier(String gameName) {
        switch (gameName.toUpperCase()) {
            case "VALORANT":
                return 1.0;
            case "CS2":
                return 0.8;
            case "OVERWATCH":
                return 1.15;
            case "APEX":
                return 0.9;
            default:
                return 1.0;
        }
    }
    
    /**
     * Validate sensitivity value
     * @param value The sensitivity value to validate
     * @return true if valid, false otherwise
     */
    public boolean isValidSensitivity(double value) {
        return value >= 0 && value <= 100;
    }
}
