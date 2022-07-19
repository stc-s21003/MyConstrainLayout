package jp.suntech.s21003.myconstrainlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

class Global{
    public  static  String msg;
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btConfirm = findViewById(R.id.btConfirm);
        Button btSend = findViewById(R.id.btSend);
        Button btClear = findViewById(R.id.btClear);


        ClickListener listener = new ClickListener();

        btConfirm.setOnClickListener(listener);
        btSend.setOnClickListener(listener);
        btClear.setOnClickListener(listener);

    }
    private class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            EditText mail_title = findViewById(R.id.etMTitle);
            EditText name = findViewById(R.id.etName);
            EditText mail = findViewById(R.id.etMail);
            EditText comment = findViewById(R.id.etComment);

            String titleStr=mail_title.getText().toString();
            String nameStr=name.getText().toString();
            String mailStr=mail.getText().toString();
            String commentStr=comment.getText().toString();

            String show="メールタイトル :"+titleStr+"\n名前 :"+nameStr+"\nメールアドレス :"+mailStr+"\n質問内容 :"+commentStr;

            Global.msg=show;

            int id = view.getId();
            switch (id) {
                case R.id.btSend:
                    Toast.makeText(MainActivity.this,show,Toast.LENGTH_LONG).show();
                    break;

                case R.id.btClear:
                    mail_title.setText("");
                    name.setText("");
                    mail.setText("");
                    comment.setText("");

                case R.id.btConfirm:
                    DialogFragment dialogFragment = new DialogFragment();
                    dialogFragment.show(getSupportFragmentManager(),"dialogFragment");
                    break;


            }
        }
    }
}


