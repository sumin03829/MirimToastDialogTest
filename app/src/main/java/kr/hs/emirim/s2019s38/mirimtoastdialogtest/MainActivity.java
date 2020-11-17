package kr.hs.emirim.s2019s38.mirimtoastdialogtest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textName,textEmail;
    EditText editName,editEmail;
    TextView textToast;
    View dialogView, toastView;
    Button btnHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textName=findViewById(R.id.text_name);
        textEmail=findViewById(R.id.text_email);
        editName=findViewById(R.id.edit_name);
        editEmail=findViewById(R.id.edth_email);
        btnHere=findViewById(R.id.btn_here);
        btnHere.setOnClickListener(btnHerListener);
    }
    View.OnClickListener btnHerListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dialogView=View.inflate(MainActivity.this,R.layout.dialog1,null);
            AlertDialog.Builder dlg=new AlertDialog.Builder(MainActivity.this);
            dlg.setTitle("사용자 정보 입력");
            dlg.setView(dialogView);
            dlg.setPositiveButton("확인",positiviButtonListener);
            dlg.setNegativeButton("취소",negativeButtonListener);
            dlg.show();

        }
    };

    DialogInterface.OnClickListener positiviButtonListener=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            editName=dialogView.findViewById(R.id.edit_name);
            editEmail=dialogView.findViewById(R.id.edth_email);
            textName.setText(editName.getText().toString()+"님 입니다.");
            textEmail.setText(editEmail.getText().toString());
        }
    };
    DialogInterface.OnClickListener negativeButtonListener=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast toast=new Toast(MainActivity.this);
            toastView=View.inflate(MainActivity.this,R.layout.toast1,null);
            toast.setView(toastView);
            textToast=toastView.findViewById(R.id.text_toast);
            textToast.setText("취소버튼을 누르셨네요");
            toast.setView(toastView);
            toast.show();
        }
    };
}