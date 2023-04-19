package com.mrcrayfish.menulogue.integration;

import com.mrcrayfish.menulogue.Menulogue;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.client.gui.screens.Screen;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * Author: MrCrayfish
 */
public class CatalogueConfigFactory
{
    public static Map<String, BiFunction<Screen, ModContainer, Screen>> createConfigProvider()
    {
        Map<String, BiFunction<Screen, ModContainer, Screen>> providers = new HashMap<>();
        FabricLoader.getInstance().getEntrypointContainers("modmenu", ModMenuApi.class).forEach(container ->
        {
            String modId = container.getProvider().getMetadata().getId();
            try
            {
                ModMenuApi entry = container.getEntrypoint();
                ConfigScreenFactory<?> factory = entry.getModConfigScreenFactory();
                providers.put(modId, (previousScreen, modContainer) -> {
                    return factory.create(previousScreen);
                });
                entry.getProvidedConfigScreenFactories().forEach((s, f) -> {
                    providers.putIfAbsent(s, (previousScreen, modContainer) -> {
                        return f.create(previousScreen);
                    });
                });
            }
            catch(Exception e)
            {
                Menulogue.LOGGER.error("Failed to load ModMenuApi entrypoint for {}", modId, e);
            }
        });
        return providers;
    }
}
