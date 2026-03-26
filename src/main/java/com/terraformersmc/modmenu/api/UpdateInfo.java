/*
 * MIT License
 * Copyright (c) 2018-2020 Prospector
 */
package com.terraformersmc.modmenu.api;

import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public interface UpdateInfo {

    boolean isUpdateAvailable();

    @Nullable
    default Component getUpdateMessage() {
        return null;
    }

    String getDownloadLink();

    UpdateChannel getUpdateChannel();
}
