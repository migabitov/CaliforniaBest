package com.digital.nomads.enums.sidebar;

public enum ReportsSubMenu {

    USERS("Users"),
    COURSES("Courses"),
    BRANCHES("Branches"),
    GROUPS("Groups"),
    LEARNING_ACTIVITIES("Learning activities"),
    TRAINING_MATRIX("Training matrix"),
    TIMELINE("Timeline"),
    CUSTOM("Custom");
    private final String name;

    ReportsSubMenu(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getName() {
        return name;
    }
}


