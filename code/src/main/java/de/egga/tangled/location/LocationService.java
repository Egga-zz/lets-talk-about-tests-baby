package de.egga.tangled.location;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.util.LengthUnit;
import de.egga.tangled.shop.Shop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.javadocmd.simplelatlng.LatLngTool.distance;
import static java.util.Collections.sort;

/**
 * @author egga
 */
public class LocationService {

    private static final LengthUnit DEFAULT_UNIT = LengthUnit.METER;

    public List<Shop> sortByDistance(final LatLng location, final List<Shop> shops) {
        ArrayList<Shop> clone = new ArrayList<Shop>(shops);

        sort(clone, new Comparator<Shop>() {
            @Override
            public int compare(final Shop o1, final Shop o2) {
                Double distance1 = calculateDistance(o1, location);
                Double distance2 = calculateDistance(o2, location);
                return distance1.compareTo(distance2);
            }
        });

        return clone;
    }

    private double calculateDistance(final Shop o1, final LatLng location) {
        return distance(location, o1.getLocation(), DEFAULT_UNIT);
    }
}
