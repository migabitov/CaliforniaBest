package com.digital.nomads.enums.sidebar;

import lombok.Getter;

@Getter
public enum SubMenu {
    TEXT_BOX("Text Box"),
    CHECK_BOX("Check Box"),
    RADIO_BUTTON("Radio Button"),
    WEB_TABLES("Web Tables"),
    BUTTONS("Buttons"),
    LINKS("Links"),
    BROKEN_LINKS("Broken Links - Images"),
    UPLOAD_DOWNLOAD("Upload and Download"),
    DYNAMIC_PROPERTIES("Dynamic Properties"),
    PRACTICE_FORM("Practice Form");

    private final String name;

    SubMenu(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
