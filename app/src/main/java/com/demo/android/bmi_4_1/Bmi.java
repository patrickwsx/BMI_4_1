package com.demo.android.bmi_4_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class Bmi extends AppCompatActivity implements View.OnClickListener {
    EditText feild_height;
    EditText feild_weight;
    TextView result;
    TextView suggest;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_bmi );
        findViews();
        setListeners();
    }
    private void findViews(){
        submit =findViewById(R.id.submit);
        feild_height = findViewById(R.id.field_height);
        feild_weight = findViewById(R.id.field_weight);
        result = findViewById(R.id.result);
        suggest = findViewById(R.id.suggest);


    }
    protected void setListeners()
    {
        submit.setOnClickListener(this );
    }

    public void onClick(View v){


        String height = feild_height.getText().toString();
        String weight = feild_height.getText().toString();
        double h = Double.parseDouble(height)/100;
        double w = Double.parseDouble(weight);
        double BMI= w/(h*h);
        DecimalFormat df = new DecimalFormat("0.00");
        result.setText("你的BMI值="+df.format(BMI));

        if(BMI>25)
            suggest.setText("體重超標");
        else if(BMI<20)
            suggest.setText("體重過瘦");
        else
            suggest.setText("標準範圍");
    }
}


