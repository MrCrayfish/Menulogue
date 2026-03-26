/*
 * MIT License
 * Copyright (c) 2018-2020 Prospector
 */
package com.terraformersmc.modmenu.util;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import net.minecraft.client.gui.screens.Screen;

public class NullScreenFactory<S extends Screen> implements ConfigScreenFactory<S> {
    @Override
    public S create(Screen parent) {
        return null;
    }
}
