package th.ac.su.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.muddzdev.styleabletoastlibrary.StyleableToast;

public class MainActivity extends AppCompatActivity {
    double resulf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button CalButton = findViewById(R.id.button_cal);
        CalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView A = findViewById(R.id.textView_A);

                EditText number_t = findViewById(R.id.editText_t);
                EditText number_s = findViewById(R.id.editText_s);
                String numText;
                String numText1;

                if (!number_t.getText().toString().isEmpty() && !number_s.getText().toString().isEmpty()) {
                    if (number_t.getText().toString().length() >= 0 &&  number_s.getText().toString().length() >= 0) {
                        numText = number_t.getText().toString();
                        numText1 = number_s.getText().toString();
                        double num_t = Double.parseDouble(numText);
                        double num_s = Double.parseDouble(numText1);
                        if(num_s <= 0.00){
                            StyleableToast.makeText(getApplicationContext(),getString(R.string.toast_b),R.style.exampleToast).show();
                        }
                        resulf = (num_t/num_s);

                        if(resulf>=80){
                            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                            dialog.setTitle(R.string.popup_title);
                            dialog.setMessage(R.string.popup);
                            dialog.setNegativeButton("OK", null);
                            dialog.show();
                        }else {
                            A.setText(String.format("%.2f", resulf));
                        }
                        resulf = 0;
                    }
                }else{
                    StyleableToast.makeText(getApplicationContext(),getString(R.string.toast_a),R.style.exampleToast).show();
                }



            }
        });


        Button ClearButton = findViewById(R.id.button_clear);
        ClearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText number_t = findViewById(R.id.editText_t);
                number_t.setText("");
                EditText number_s = findViewById(R.id.editText_s);
                number_s.setText("");

            }
        });


    }




}