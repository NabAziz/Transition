package materialdesign.practice.com.recyclerfragment.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import materialdesign.practice.com.recyclerfragment.Adapter.rvAdapter;
import materialdesign.practice.com.recyclerfragment.R;
import materialdesign.practice.com.recyclerfragment.Util.ModelClass;

//https://www.youtube.com/watch?v=DGdU2EssTE0
//https://proandroiddev.com/playing-with-material-design-transitions-b3ea90c5794c

public class MainActivity extends AppCompatActivity {

    List<ModelClass> data = new ArrayList<>();
    ModelClass modelClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        onLoadData();

        RecyclerView recyclerView = findViewById(R.id.rvList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new rvAdapter(MainActivity.this, data));  /*, title, descp, name, time));*/
        recyclerView.setHasFixedSize(true);
    }

    private void onLoadData() {
        modelClass = new ModelClass();
        data.add(new ModelClass("name1","title1","descp1","link1" ,"time1"));
        data.add(new ModelClass("name2","title1","descp1","link2", "time2" ));
        data.add(new ModelClass("name2","title1","descp1","link1","time2" ));
        data.add(new ModelClass("name2","title1","descp1","link","time2" ));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId())
        {
            case R.id.add:
                Intent i = new Intent(MainActivity.this, AddDataActivity.class);
                startActivity(i);
                break;
    }
        return true;
    }
}
