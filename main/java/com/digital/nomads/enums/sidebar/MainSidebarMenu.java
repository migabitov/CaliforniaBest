package com.digital.nomads.enums.sidebar;

import lombok.Getter;

@Getter
public enum MainSidebarMenu {
    ELEMENTS("Elements"),
    FORMS("Forms"),
    ALERTS_FRAME_WINDOWS("Alerts, Frame & Windows"),
    WIDGETS("Widgets");
    private final String name;

    MainSidebarMenu(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
