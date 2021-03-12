package com.example.npuassignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultView;
    private EditText etView;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etView = findViewById(R.id.et);
        resultView = findViewById(R.id.result);
        btn = findViewById(R.id.btn);
        listeners();
    }

    private void listeners() {
        etView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                btn.setEnabled(s.toString().length() != 0);
            }
        });

        btn.setOnClickListener(v -> {
            resultView.setText(String.format("The approximate temperature outside is %.1f degrees Celsius.",
                    Float.valueOf(etView.getText().toString())/3 + 4));
        });
    }


}