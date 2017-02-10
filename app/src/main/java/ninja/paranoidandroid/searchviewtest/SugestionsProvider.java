package ninja.paranoidandroid.searchviewtest;

import android.content.SearchRecentSuggestionsProvider;

/**
 * Created by anton on 09.02.17.
 */

public class SugestionsProvider extends SearchRecentSuggestionsProvider {

    public final static String AUTHORITY = "ninja.paranoidandroid.searchviewtest.MySuggestionProvider";
    public final static int MODE = DATABASE_MODE_QUERIES;

    public SugestionsProvider() {
        setupSuggestions(AUTHORITY, MODE);
    }


}
