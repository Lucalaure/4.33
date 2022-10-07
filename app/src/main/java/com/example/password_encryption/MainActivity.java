package com.example.password_encryption;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText cypherEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cypherEdit = (EditText) findViewById(R.id.cypher_edit);
        cypherEdit.setFilters(new InputFilter[]{new InputFilterMinMax("1", "25")});
    }

    public void enter(View view) {
        Intent intent = new Intent(getBaseContext(), MainActivity2.class);

        Bundle bundle = new Bundle();
        int num = Integer.parseInt(cypherEdit.getText().toString());
        bundle.putInt("cypher", num);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}