package biz.hahamo.dev.javaee.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class to split long lists into a list of smaller lists
 * 
 * @author GHajba
 * 
 */
public class CollectionUtils {

    protected CollectionUtils() {

    }

    public static <T> List<List<T>> splitLongList(final List<T> source, final int size) {

        if (source == null) {
            return null; // you could use org.apache.commons.lang.Validate.notNull(source);
        }

        int necessaryLists = (int) Math.ceil(source.size() / (float) size);
        List<List<T>> sList = new ArrayList<List<T>>(necessaryLists);

        if (size == 0 || source.size() <= size) {
            sList.add(source);
            return sList;
        }

        for (int i = 0; i < necessaryLists; i++) {
            if (i != (necessaryLists - 1)) {
                sList.add(source.subList(i * size, (i + 1) * size));
            } else {
                sList.add(source.subList(i * size, source.size()));
            }
        }

        return sList;
    }

}
