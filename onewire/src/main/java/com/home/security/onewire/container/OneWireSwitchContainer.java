package com.home.security.onewire.container;

import java.io.IOException;

public abstract interface OneWireSwitchContainer {
    public abstract boolean isOn()
            throws IOException;

    public abstract void turnAllOn()
            throws IOException;

    public abstract void turnAllOff()
            throws IOException;
}