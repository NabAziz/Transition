package materialdesign.practice.com.recyclerfragment.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import materialdesign.practice.com.recyclerfragment.R;
import materialdesign.practice.com.recyclerfragment.Util.ModelClass;

public class AddDataActivity extends AppCompatActivity {

    EditText etName, etTitle, etDescp, etLink;
    String name, title, descp, link;
    Button btnBack;
    List<ModelClass> enteredData = new ArrayList<>();
    ModelClass modelClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        etName = findViewById(R.id.etName);
        etTitle = findViewById(R.id.etTitle);
        etDescp = findViewById(R.id.etDescp);
        etLink = findViewById(R.id.etLink);

        modelClass = new ModelClass();

        name = etName.getText().toString();
        modelClass.setName(name);

        title = etTitle.getText().toString();
        modelClass.setTitle(title);

        descp = etDescp.getText().toString();
        modelClass.setDescp(descp);

        link = etLink.getText().toString();
        modelClass.setLink(link);



        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name == null || title == null || descp == null || link == null )
                {
                    Toast.makeText(AddDataActivity.this, "Enter all fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    enteredData.add(modelClass);
                    Intent i = new Intent(AddDataActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });

    }
}
