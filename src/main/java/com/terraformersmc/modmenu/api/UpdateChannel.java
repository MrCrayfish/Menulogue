/*
 * MIT License
 * Copyright (c) 2018-2020 Prospector
 */
package com.terraformersmc.modmenu.api;

public enum UpdateChannel {
    ALPHA,
    BETA,
    RELEASE;

    public static UpdateChannel getUserPreference() {
        return RELEASE;
    }
}