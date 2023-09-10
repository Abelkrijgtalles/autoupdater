package nl.abelkrijgtalles.autoupdater;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

import nl.abelkrijgtalles.autoupdater.manager.PluginRegister;
import nl.abelkrijgtalles.autoupdater.object.PluginRegisterResponse;
import nl.abelkrijgtalles.autoupdater.util.FileUtil;

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
     * @throws IOException If the new (JAR)-file couldn't be downloaded.
     */

    public static void registerPlugin(PluginRegister pluginRegister) throws IOException {

        PluginRegisterResponse response = pluginRegister.checkForUpdate();
        Plugin plugin = response.getPlugin();

        if (response.doesNeedsUpdate()) {

            File file = FileUtil.getFileFromPlugin(plugin);
            String link = response.getDownloadURL();
            String downloadLinkPath = response.getDownloadURL().split("/")[-1];
            PluginManager pluginManager = Bukkit.getPluginManager();

            pluginManager.disablePlugin(plugin);

            assert file != null;
            if (!file.delete()) {
                Bukkit.getLogger().info("Failed to delete the old version of " + plugin.getName());
            }
            FileUtil.downloadFile(link, downloadLinkPath);

            Bukkit.getLogger().info(plugin.getName() + " was successfully updated.");
            Bukkit.getLogger().info("Reloading server.");

            Bukkit.reload();

        }

    }

}
