package com.digital.nomads.enums.sidebar;

public enum SettingsSubMenu {
    PORTAL("Portal"),
    USERS("Users"),
    USER_TYPES("User types"),
    COURSES("Courses"),
    CATEGORIES("Categories"),
    SKILLS("Skills"),
    GAMIFICATION("Gamification"),
    ECOMMERCE("E-commerce"),
    INTEGRATIONS("Integrations"),
    SECURITY("Security"),
    IMPORT_EXPORT("Import-Export");

    private final String name;

    SettingsSubMenu(String name) {
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
