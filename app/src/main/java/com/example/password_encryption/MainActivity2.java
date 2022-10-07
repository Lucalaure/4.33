package com.example.password_encryption;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {

    private EditText encryptText;
    private EditText cypherEdit;
    private TextView resultText;
    private Button encryptBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        encryptText =(EditText) findViewById(R.id.text_to_encrypt);
        cypherEdit = (EditText) findViewById(R.id.cypher_edit);
        resultText = (TextView) findViewById(R.id.result_text);
        encryptBtn = (Button) findViewById(R.id.encrypt_btn);

        encryptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = encryptText.getText().toString().toLowerCase(Locale.ROOT);
                Bundle bundle = getIntent().getExtras();
                int num = bundle.getInt("cypher");

                StringBuffer result= new StringBuffer();
                for (int i = 0; i < str.length(); i++) {
                    char ch = (char)(((int)str.charAt(i) + num - 97) % 26 + 97);
                    result.append(ch);
                }

                resultText.setText(result);
            }
        });
    }
}