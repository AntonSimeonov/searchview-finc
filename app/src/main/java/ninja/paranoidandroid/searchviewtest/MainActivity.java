package ninja.paranoidandroid.searchviewtest;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.provider.SearchRecentSuggestions;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.widget.SearchView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

   // ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ListView lv = (ListView)findViewById(R.id.lv_activity_main);
//        ArrayList<String> arrayCountry = new ArrayList<>();
//        arrayCountry.addAll(Arrays.asList(getResources().getStringArray(R.array.array_country)));
//
//        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrayCountry);
//        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView)item.getActionView();
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);

        if(searchManager.getSearchableInfo(new ComponentName(this, SearchResultsActivity.class)) != null){
            Log.i("MainActivity", "In onCreateOptionsMenu(), is not NULL" );
        }else{
            Log.i("MainActivity", "In onCreateOptionsMenu(), is NULL" );
        }

        searchView.setSearchableInfo(searchManager.getSearchableInfo(new ComponentName(this, SearchResultsActivity.class)));
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

//                Intent intent = new Intent(MainActivity.this, SearchResultsActivity.class);
//                startActivity(intent);

                Log.i("MainActivity", "In onQueryTextSubmit, query: " + query);
                SearchRecentSuggestions suggestions = new SearchRecentSuggestions(MainActivity.this, SugestionsProvider.AUTHORITY, SugestionsProvider.MODE);
                suggestions.saveRecentQuery(query, null);


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //adapter.getFilter().filter(newText);

                return false;
            }
        });

        return true;
    }
}
