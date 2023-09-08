package nl.abelkrijgtalles.autoupdater.util;

import org.bukkit.Bukkit;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class FileUtil {

    /**
     * Download a file from a URL to a specific path.
     *
     * @param fileUrl The URL you want to download the file from.
     * @param path    The path you want to use to save the downloaded file.
     */

    public static void DownloadFile(String fileUrl, String path) {

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

            Bukkit.getLogger().info("Successfully downloaded file from %s to %s.".formatted(fileUrl, path));

        } catch (IOException e) {

            Bukkit.getLogger().warning("Could not download file from %s to %s.".formatted(fileUrl, path));

        }

    }

}
