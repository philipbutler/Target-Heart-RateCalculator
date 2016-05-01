package com.example.philipbutler.target_heart_ratecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.text.NumberFormat;
import android.widget.TextView;
import android.widget.EditText;
import android.text.TextWatcher;
import android.text.Editable;


public class MainActivity extends AppCompatActivity {

    private static final NumberFormat integerFormat =
            NumberFormat.getIntegerInstance();

    private int IBPM = 220;
    private int age = 0;
    private int maxBPM = 220;
    private double LOW_PERCENT = 0.5;
    private double HIGH_PERCENT = 0.85;
    private int lowTarget;
    private int highTarget;

    private TextView mhrTextView;
    private TextView trTextView;
    private TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mhrTextView = (TextView) findViewById(R.id.mhrTextView);
        trTextView = (TextView) findViewById(R.id.trTextView);
        EditText ageEditText = (EditText) findViewById(R.id.ageEditText);
        ageEditText.addTextChangedListener(ageEditTextWatcher);
    }

    private void updateFields()
    {
        maxBPM = IBPM - age;
        lowTarget = (int) (maxBPM * LOW_PERCENT);
        highTarget = (int) (maxBPM * HIGH_PERCENT);
        mhrTextView.setText(maxBPM + " BPM");

        trTextView.setText(lowTarget + " BPM - " + highTarget + " BPM");

    }

    private TextWatcher ageEditTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try
            {
                age = Integer.parseInt(s.toString());
            }
            catch (NumberFormatException e)
            {
                age = 0;
            }
            updateFields();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}
