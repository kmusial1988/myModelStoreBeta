package Store.utils;/*
package Store.utils;

import vinylStoreHiber.model.Vinyl;

import java.util.ArrayList;
import java.util.List;

public class filterUtils {

    public static List<Vinyl> filterVinyls(List<Vinyl> vinyls, String filter) {

        if (filter == null){ return vinyls;}
        List<Vinyl> filteredVinyls = new ArrayList<>();

        for (Vinyl vinyl : vinyls) {
            if (vinyl.getTitle().toUpperCase().contains(filter.toUpperCase()) ||
                    vinyl.getAuthor().toUpperCase().contains(filter.toUpperCase())) {
                filteredVinyls.add(vinyl);
            }
        }
        return filteredVinyls;
    }
}
*/
