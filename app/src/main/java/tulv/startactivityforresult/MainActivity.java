package tulv.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtNumberA,edtNumberB;
    Button btnStart;
    public static final int REQUEST_CODE=2000;
    public static final String NUMBER_A="NUMBER_A";
    public static final String NUMBER_B="NUMBER_B";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidget();
        setEvent();
    }

    public void getWidget(){
        edtNumberA=(EditText)findViewById(R.id.edt_number_A);
        edtNumberB=(EditText)findViewById(R.id.edt_number_B);
        btnStart=(Button)findViewById(R.id.btn_start);

    }

    public void setEvent(){
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(edtNumberA.getText().toString())&& !TextUtils.isEmpty(edtNumberA.getText().toString())){
                    int a=Integer.parseInt(edtNumberA.getText().toString());
                    int b=Integer.parseInt(edtNumberB.getText().toString());
                    Intent intent=new Intent(MainActivity.this,ResultActivity.class);
                    intent.putExtra(NUMBER_A,a);
                    intent.putExtra(NUMBER_B,b);
                    startActivityForResult(intent,REQUEST_CODE);
                }

            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE){
            switch (resultCode)
            {
                case ResultActivity.RESULT_PIN:
                    Toast.makeText(MainActivity.this, ""+data.getIntExtra(ResultActivity.RESULT,0), Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    }
}
