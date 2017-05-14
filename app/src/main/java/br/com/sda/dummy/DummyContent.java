package br.com.sda.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.sda.R;

/**
 * Just dummy content. Nothing special.
 *
 * Created by Andreas Schrade on 14.12.2015.
 */
public class DummyContent {

    /**
     * An array of sample items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<>();

    /**
     * A map of sample items. Key: sample ID; Value: Item.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<>(5);

    static {
        addItem(new DummyItem("1", R.drawable.p1, "Guardians of The Galaxy", "James Guun", "Marvel Studios"));
        addItem(new DummyItem("2", R.drawable.p2, "Alien", "Ridley Scott","Fox Film"));
        addItem(new DummyItem("3", R.drawable.p3, "The Avengers", "Joss Wheldon", "Marvel Studios"));
        addItem(new DummyItem("4", R.drawable.p4, "Silence", "Martin Scorcesse","20th Century Fox"));
        addItem(new DummyItem("5", R.drawable.p5, "Avatar", "Steven Spielberg","Disney"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    public static class DummyItem {
        public final String id;
        public final int photoId;
        public final String title;
        public final String author;
        public final String content;

        public DummyItem(String id, int photoId, String title, String author, String content) {
            this.id = id;
            this.photoId = photoId;
            this.title = title;
            this.author = author;
            this.content = content;
        }
    }
}
