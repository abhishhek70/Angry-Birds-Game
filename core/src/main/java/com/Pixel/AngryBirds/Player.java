package com.Pixel.AngryBirds;

public class Player {
    private String userName;
    private int playerLevel;
    private int maxLevelCleared;
    private int totalStars;
    private int experience;

    public Player(String userName) {
        this.userName = userName;
        this.playerLevel = 1;
        this.maxLevelCleared = 0;
        this.totalStars = 0;
        this.experience = 0;
    }

    public void updateStats() {
    }

    public void levelUp() {
    }

    // Getters and setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public int getMaxLevelCleared() {
        return maxLevelCleared;
    }

    public void setMaxLevelCleared(int maxLevelCleared) {
        this.maxLevelCleared = maxLevelCleared;
    }

    public int getTotalStars() {
        return totalStars;
    }

    public void setTotalStars(int totalStars) {
        this.totalStars = totalStars;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}

