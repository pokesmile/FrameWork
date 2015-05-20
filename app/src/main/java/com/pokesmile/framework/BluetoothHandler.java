package com.pokesmile.framework;

/**
 * This class should handle all the Bluetooth action.
 * Created by Norbert on 2015.05.20..
 */
public class BluetoothHandler {

    private String param1;

    /**
     * Constructor
     *
     * @param param1 First parameter
     */
    public BluetoothHandler(String param1) {
        this.param1 = param1;
        //Set Bluetooth adapter...
    }

    public String getParam1() {
        return param1;
    }
}
