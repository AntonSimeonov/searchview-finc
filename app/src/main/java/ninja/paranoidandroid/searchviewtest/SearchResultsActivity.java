package ninja.paranoidandroid.searchviewtest;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);


        // Get the intent, verify the action and get the query
        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Log.i("search result activity", "query is: " + query);
        }

    }





//    ArrayAdapter<String> adapter;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ListView lv = (ListView)findViewById(R.id.listViewCountry);
//        ArrayList<String> arrayCountry = new ArrayList<>();
//        arrayCountry.addAll(Arrays.asList(getResources().getStringArray(R.array.array_country)));
//
//        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrayCountry);
//        lv.setAdapter(adapter);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_search, menu);
//        MenuItem item = menu.findItem(R.id.menuSearch);
//        SearchView searchView = (SearchView)item.getActionView();
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
//
//                return false;
//            }
//        });
//
//
//        return super.onCreateOptionsMenu(menu);
//    }

    

}
