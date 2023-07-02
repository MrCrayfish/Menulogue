/*
 * MIT License
 * Copyright (c) 2018-2020 Prospector
 */
package com.terraformersmc.modmenu.api;

import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.menulogue.Menulogue;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;

import java.util.Map;
import java.util.function.Consumer;

public interface ModMenuApi {

    static Screen createModsScreen(Screen previous) {
        return Menulogue.createCatalogueModScreen(previous);
    }

    static Component createModsButtonText() {
        return CommonComponents.EMPTY;
    }

    default ConfigScreenFactory<?> getModConfigScreenFactory() {
        return screen -> null;
    }

    default Map<String, ConfigScreenFactory<?>> getProvidedConfigScreenFactories() {
        return ImmutableMap.of();
    }

    default void attachModpackBadges(Consumer<String> consumer) {
        return;
    }
}