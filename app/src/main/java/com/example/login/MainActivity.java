package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.login.Model.Users;
import com.example.login.data.MyDbHandler;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=(EditText) findViewById(R.id.txtname);
        pass=(EditText) findViewById(R.id.txtpass);
        email=(EditText) findViewById(R.id.txtemail);

    }

    public void addUser(View view) {
        MyDbHandler db =new MyDbHandler(MainActivity.this);
        String n = name.getText().toString();
        String p = pass.getText().toString();
        String e = email.getText().toString();
        Users dj = new Users();
        dj.setName(n);
        dj.setEmail(e);
        dj.setPass(p);

        db.adduser(dj);

        List<Users> allUsers = db.getAllUsers();
        for(Users users:allUsers) {
            Log.d("userDB","\n\n" + "ID : " +users.getId() + "\n" +
                    "Name : " +users.getName() + "\n" +
                    "Email-ID : " +users.getEmail() + "\n" +
                    "Password : " + users.getPass() + "\n");
        }

        Toast.makeText(getApplicationContext(),"User Added Succesfully...",Toast.LENGTH_SHORT).show();

    }

    public void onResetClicked(View view) {
        email.setText("");
        pass.setText("");
        name.setText("");
    }
}
