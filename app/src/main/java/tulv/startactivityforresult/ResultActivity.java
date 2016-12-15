package tulv.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView tv_number_A, tv_number_B;
    Button btnResult;
    int a, b;
    public static final String RESULT = "RESULT";
    public static final int RESULT_PIN = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getWidget();
        getData();
        setEvent();
    }

    public void getWidget() {
        tv_number_A = (TextView) findViewById(R.id.tv_number_A);
        tv_number_B = (TextView) findViewById(R.id.tv_number_B);
        btnResult = (Button) findViewById(R.id.btn_result);
    }

    public void setEvent() {
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int result = a + b;
                Intent intent = new Intent();
                intent.putExtra(RESULT, result);
                setResult(RESULT_PIN, intent);
                finish();
            }
        });
    }

    public void getData() {
        Intent intent = getIntent();
        a = intent.getIntExtra(MainActivity.NUMBER_A, 0);
        b = intent.getIntExtra(MainActivity.NUMBER_B, 0);
        tv_number_A.setText(a+"");
        tv_number_B.setText(b+"");
    }
}
