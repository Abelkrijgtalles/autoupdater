package nl.abelkrijgtalles.autoupdater.util;

import java.util.ArrayList;
import java.util.Collections;

public class ListUtil {

    /**
     * Turn a String[] into a ArrayList<String>.
     *
     * @param list The String[] you want to turn into a ArrayList<String>.
     * @return The String[] turned into a ArrayList<String>.
     */

    public static ArrayList<String> stringListToStringArrayList(String[] list) {

        ArrayList<String> arrayList = new ArrayList<String>();
        Collections.addAll(arrayList, list);

        return arrayList;

    }

    /**
     * Get the last String of a String[].
     *
     * @param list The String[] to use.
     * @return The last element of the String[].
     */

    public static String getLastString(String[] list) {

        ArrayList<String> arrayList = stringListToStringArrayList(list);

        return arrayList.get(arrayList.size() - 1);

    }

}
