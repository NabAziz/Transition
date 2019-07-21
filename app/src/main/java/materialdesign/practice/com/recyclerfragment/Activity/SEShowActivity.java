package materialdesign.practice.com.recyclerfragment.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.Serializable;

import materialdesign.practice.com.recyclerfragment.R;
import materialdesign.practice.com.recyclerfragment.Util.ModelClass;

public class SEShowActivity extends AppCompatActivity {

    TextView tvName, tvTitle, tvDescp, tvLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seshow);
        supportPostponeEnterTransition();

      /*  Intent i = new Intent();
        Bundle b = new Bundle();

        ModelClass modelClass = (ModelClass) i.getSerializableExtra("title");     //("title");
        String transition =  b.getString("transition");
*/
        tvName = findViewById(R.id.tvName);
        tvTitle = findViewById(R.id.tvTitle);
        tvDescp = findViewById(R.id.tvDescp);
        tvLink = findViewById(R.id.tvLink);

        ModelClass obj = new ModelClass();
        tvLink.setText(obj.getLink());

        /*tvName.setTransitionName(transition);
        tvTitle.setTransitionName(transition);
        tvDescp.setTransitionName(transition);
        tvLink.setTransitionName(transition);

        tvName.setText(modelClass.getName());
        tvTitle.setText(modelClass.getTitle());
        tvDescp.setText(modelClass.getDescp());
        tvLink.setText(modelClass.getLink());*/
    }
}
