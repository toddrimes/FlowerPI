package com.makeinfo.flowerpi;

import android.app.ListActivity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.graphics.Point;
import android.widget.HorizontalScrollView;
import android.content.Context;

import android.widget.ListView;
import android.widget.Toast;

// import com.makeinfo.flowerpi.API.gitapi;
import com.makeinfo.flowerpi.API.tveapi;
import com.makeinfo.flowerpi.model.PageModel;
import com.makeinfo.flowerpi.model.Module;
import com.makeinfo.flowerpi.model.Datum;
import com.makeinfo.flowerpi.adapter;
import com.makeinfo.flowerpi.model.VideoModel;
import com.makeinfo.flowerpi.model.ProgramModel;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends ListActivity {

    List<Datum> datumList;
    HorizontalScrollView hscroll;
    String API = "http://dev-api.nbcuni.com/tve/";
    Module firstModule = null;
    Datum firstDatum = null;
    String firstImage = null;

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(API).build();
        tveapi tve = restAdapter.create(tveapi.class);
        android.view.Display display = ((android.view.WindowManager)getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        Point thePoint = new Point();
        display.getSize(thePoint);

        tve.getPage("usa-roku", "testhomepage", new Callback<PageModel>() {

            @Override
            public void success(PageModel pageModel, Response response) {
                Module firstModule = pageModel.modules.get(0);
                if (null != firstModule) datumList = firstModule.data;
                if (null != firstDatum) firstImage = firstDatum.hdposterurl;

                adapter adapt = new adapter(getApplicationContext(), R.layout.item_file, datumList);
                //ListView listView = (ListView) findViewById(R.id.list);
                setListAdapter(adapt);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });



    }
}