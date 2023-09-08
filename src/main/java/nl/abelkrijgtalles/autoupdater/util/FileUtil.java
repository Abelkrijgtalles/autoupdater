package nl.abelkrijgtalles.autoupdater.util;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;

public class FileUtil {

    /**
     * Download a file from a URL to a specific path.
     *
     * @param fileUrl The URL you want to download the file from.
     * @param path    The path you want to use to save the downloaded file.
     * @throws IOException If the file couldn't be downloaded.
     */

    public static void downloadFile(String fileUrl, String path) throws IOException {

        try {

            URL url = new URL(fileUrl);
            URLConnection connection = url.openConnection();
            InputStream inputStream = connection.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(path);

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {

                outputStream.write(buffer, 0, bytesRead);

            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {

            throw new IOException(e);

        }

    }

    /**
     * Get the (JAR)-file of a plugin with only the plugin object.
     *
     * @param plugin The object of the plugin.
     * @return The (JAR)-file of the plugin.
     */

    public static File getFileFromPlugin(Plugin plugin) {

        try {

            Method getFileMethod = JavaPlugin.class.getDeclaredMethod("getFile");
            getFileMethod.setAccessible(true);

            try {

                return (File) getFileMethod.invoke(plugin);

            } catch (IllegalAccessException | InvocationTargetException ignore) {
            }

        } catch (NoSuchMethodException ignore) {
        }

        return null;
    }

}
