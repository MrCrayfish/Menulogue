/*
 * MIT License
 * Copyright (c) 2018-2020 Prospector
 */
package com.terraformersmc.modmenu.api;

import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public interface UpdateChecker {
   @Nullable UpdateInfo checkForUpdates();
}
