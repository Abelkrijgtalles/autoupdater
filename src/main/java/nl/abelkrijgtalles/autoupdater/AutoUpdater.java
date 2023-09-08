package nl.abelkrijgtalles.autoupdater;

import org.bukkit.plugin.java.JavaPlugin;

import nl.abelkrijgtalles.autoupdater.manager.PluginRegister;
import nl.abelkrijgtalles.autoupdater.object.PluginRegisterResponse;

public final class AutoUpdater extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    /**
     * Register your plugin to AutoUpdater.
     *
     * @param pluginRegister The class that has implemented PluginRegister.
     */

    public static void registerPlugin(PluginRegister pluginRegister) {

        PluginRegisterResponse response = pluginRegister.checkForUpdate();

        if (response.doesNeedsUpdate()) {

            String link = response.getDownloadURL();

        }

    }

}
