package toong.com.androidspinner;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private ArrayAdapter dataAdapter;
    private List<String> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);

        dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, listData);
        spinner.setAdapter(dataAdapter);
        listData.add("Item 1");
        findViewById(R.id.button_add_data).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
    }

    private void update() {
        CountDownTimer countDownTimer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Toast.makeText(MainActivity.this, "add item " + (listData.size() + 1), Toast.LENGTH_SHORT).show();
                listData.add("Item " + (listData.size() + 1));
                 dataAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();
    }
}
