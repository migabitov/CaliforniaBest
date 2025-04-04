package com.digital.nomads.enums.sidebar;

public enum MainMenu {
    HOME("Home"),
    USERS("Users"),
    COURSES("Courses"),
    COURSE_STORE("Course store"),
    GROUPS("Groups"),
    BRANCHES("Branches"),
    AUTOMATIONS("Automations"),
    NOTIFICATIONS("Notifications"),
    REPORTS("Reports"),
    SKILLS("Skills"),
    ACCOUNT_SETTINGS("Account & Settings"),
    SUBSCRIPTIONS("Subscription");

    private final String name;

    MainMenu(String name) {
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
