package nl.abelkrijgtalles.autoupdater.object;

import org.bukkit.plugin.Plugin;

import java.net.MalformedURLException;
import java.net.URL;

public class PluginRegisterResponse {

    private Plugin plugin;

    private boolean needsUpdate;

    private String downloadURL;

    /**
     * The response of RegisterPlugin.findPlugin().
     *
     * @param plugin The plugin that registers itself.
     * @param needsUpdate Whether the plugin needs an update or not.
     * @param downloadURL The download link of the new jar-file.
     */

    public PluginRegisterResponse(Plugin plugin, boolean needsUpdate, String downloadURL) {
        this.plugin = plugin;
        this.needsUpdate = needsUpdate;
        this.downloadURL = downloadURL;
    }

    /**
     * <b>This should only be used if the plugin doesn't need an update.</b>
     * The response of RegisterPlugin.findPlugin().
     *
     * @param plugin The plugin that registers itself.
     * @param needsUpdate <b>This should be false.</b> Whether the plugin needs an update or not.
     * @throws IllegalArgumentException If needsUpdate is true.
     */

    public PluginRegisterResponse(Plugin plugin, boolean needsUpdate) {
        if (needsUpdate) {

            throw new IllegalArgumentException("You can only call this method with one argument if needsUpdate is false. If the plugin needs and update, set needsUpdate to true and downloadURL to the jar file.");

        } else {

            this.plugin = plugin;
            this.needsUpdate = false;

        }
    }

    /**
     * Set if the plugin needs an update.
     *
     * @param needsUpdate The value you want needsUpdate to have.
     */

    public void setNeedsUpdate(boolean needsUpdate) {
        this.needsUpdate = needsUpdate;
    }

    /**
     * Does the plugin need an update.
     *
     * @return Whether the plugin needs an update or not.
     */

    public boolean doesNeedsUpdate() {
        return needsUpdate;
    }

    /**
     * Get the URL of the download link for the jar-file.
     *
     * @return The URL of the download link for the jar-file.
     */

    public String getDownloadURL() {
        return downloadURL;
    }

    /**
     * Set the download URL of the new plugins jar-file.
     *
     * @param downloadURL The value you want downloadURL to be.
     * @throws IllegalArgumentException If downloadURL isn't a valid URL.
     */

    public void setDownloadURL(String downloadURL) {
        try {

            new URL(downloadURL);

        } catch (MalformedURLException e) {

            throw new IllegalArgumentException("downloadURL must be a valid URL");

        }

        this.downloadURL = downloadURL;
    }

    /**
     * Get the plugin that registers itself.
     *
     * @return The object of the plugin.
     */

    public Plugin getPlugin() {
        return plugin;
    }

    /**
     * Set the plugin that registers itself.
     *
     * @param plugin The plugin that registers itself.
     */

    public void setPlugin(Plugin plugin) {
        this.plugin = plugin;
    }
}
