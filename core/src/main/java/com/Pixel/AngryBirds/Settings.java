package com.Pixel.AngryBirds;

public class Settings {
    private boolean musicEnabled;
    private boolean soundEffectsEnabled;
    private String version;

    public Settings() {
        this.musicEnabled = true;
        this.soundEffectsEnabled = true;
        this.version = "1.0.0";
    }

    public void toggleMusic() {
    }

    public void toggleSoundEffects() {
    }

    public String getVersion() {
        return version;
    }

    // Getters and setters
    public boolean isMusicEnabled() {
        return musicEnabled;
    }

    public void setMusicEnabled(boolean musicEnabled) {
        this.musicEnabled = musicEnabled;
    }

    public boolean isSoundEffectsEnabled() {
        return soundEffectsEnabled;
    }

    public void setSoundEffectsEnabled(boolean soundEffectsEnabled) {
        this.soundEffectsEnabled = soundEffectsEnabled;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

