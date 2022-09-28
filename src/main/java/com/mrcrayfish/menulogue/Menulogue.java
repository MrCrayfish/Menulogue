package com.mrcrayfish.menulogue;

import net.minecraft.client.gui.screens.Screen;

/**
 * Author: MrCrayfish
 */
public class Menulogue
{
    public static Screen createCatalogueModScreen(Screen previousScreen)
    {
        try
        {
            Class<?> clazz = Class.forName("com.mrcrayfish.catalogue.client.screen.CatalogueModListScreen");
            return (Screen) clazz.getDeclaredConstructor(Screen.class).newInstance(previousScreen);
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
