package com.example.new_part7;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                Toast.makeText(MainActivity.this,"请先登录",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button2:
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                final View view1= LayoutInflater.from(MainActivity.this).inflate(R.layout.login_successed,null);
                Button button=(Button) view1.findViewById(R.id.button);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText editText1=(EditText) view1.findViewById(R.id.editText1);
                        EditText editText2=(EditText)view1.findViewById(R.id.editText2);
                        String name=editText1.getText().toString();
                        String passWords=editText2.getText().toString();
                        if(name.equals("abc")&&passWords.equals("123")){
                            Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this,"用户名或密码不正确",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setView(view1).show();
                break;
        }
    }
}