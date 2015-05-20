package com.pokesmile.framework;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Norbert on 2015.05.20..
 */
public enum MenuSection {
    MAIN_MENU(0),
    ONLINE_MODULES(1),
    OFFLINE_MODULES(2),
    DEVICES(3),
    COUPONS(4),
    SETTINGS(5),
    EXIT(6),
    UNKNOWN(-1);

    private static Map<Integer, MenuSection> map = new HashMap<Integer, MenuSection>();

    static {
        for (MenuSection menu : MenuSection.values()) {
            map.put(menu.menuSection, menu);
        }
    }

    private int menuSection;

    MenuSection(int menu) {
        this.menuSection = menu;
    }

    public static MenuSection valueOf(int menu) {
        return map.get(menu);
    }

    @Override
    public String toString() {
        switch (this) {
            case MAIN_MENU:
                return "Main Menu";
            case ONLINE_MODULES:
                return "Online Modules";
            case OFFLINE_MODULES:
                return "Offline Modules";
            case DEVICES:
                return "Devices";
            case COUPONS:
                return "Coupons";
            case SETTINGS:
                return "Settings";
            case EXIT:
                return "Exit";
            default:
                return "Unknown";
        }
    }
}
