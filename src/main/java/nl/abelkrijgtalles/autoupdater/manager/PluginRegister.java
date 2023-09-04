package nl.abelkrijgtalles.autoupdater.manager;

import nl.abelkrijgtalles.autoupdater.object.PluginRegisterResponse;

public interface PluginRegister {

    /**
     * This is a function to check for updates in your plugin.
     *
     * @return This must return a PluginRegisterResponse with either the arguments (true, and your download link for the jar file) if there is an update and only false if there isn't.
     */

    PluginRegisterResponse checkForUpdate();

}
