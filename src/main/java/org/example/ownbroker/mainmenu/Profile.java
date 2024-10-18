package org.example.ownbroker.mainmenu;

/**
 * @param platform e.g., "Invest Trading212"
 */
public record Profile(String name, String apiKey, String platform) {

    public String getFullProfileName() {
        if (name == null || name.isEmpty()) {
            return platform; // No name provided, return only the platform
        }
        return platform + ", " + name;
    }
}
