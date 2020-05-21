package com.example.togglebutton;

import androidx.appcompat.app.AppCompatActivity;

import android.net.sip.SipSession;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ToggleButton toggleButton1,toggleButton2;
     private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
addListnerOnButtonClick();
    }

    public void addListnerOnButtonClick()
    {
    toggleButton1=findViewById(R.id.toggleButton);
    toggleButton2=findViewById(R.id.toggleButton2);
    submit=findViewById(R.id.button);

    submit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            StringBuilder result= new StringBuilder();
            result.append("togglebutton1 :").append(toggleButton1.getText());
            result.append("togglebutton2 :").append(toggleButton2.getText());

            Toast.makeText(getApplicationContext(),result.toString(), Toast.LENGTH_LONG).show();

        }
    });

    }
}
