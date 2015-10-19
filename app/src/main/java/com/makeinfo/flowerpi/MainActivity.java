package com.makeinfo.flowerpi;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

// import com.makeinfo.flowerpi.API.gitapi;
import com.makeinfo.flowerpi.API.tveapi;
import com.makeinfo.flowerpi.model.PageModel;
import com.makeinfo.flowerpi.model.VideoModel;
import com.makeinfo.flowerpi.model.ProgramModel;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity {

    Button click;
    TextView tv;
    EditText edit_user;
    ProgressBar pbar;
    String API = "http://dev-api.nbcuni.com/tve/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click = (Button) findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.tv);
        edit_user = (EditText) findViewById(R.id.edit);
        pbar = (ProgressBar) findViewById(R.id.pb);
        pbar.setVisibility(View.INVISIBLE);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edit_user.getText().toString();
                pbar.setVisibility(View.VISIBLE);
                RestAdapter restAdapter = new RestAdapter.Builder()
                        .setEndpoint(API).build();
                tveapi tve = restAdapter.create(tveapi.class);

                tve.getPage("usa-roku","home",new Callback<PageModel>() {
                    @Override
                    public void success(PageModel pageModel, Response response) {
                        tv.setText("Github Name :"+pageModel.appId+"\nWebsite :"+pageModel.name+"\nCompany Name :"+pageModel.alias);
                        pbar.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                     tv.setText(error.getMessage());
                        pbar.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
