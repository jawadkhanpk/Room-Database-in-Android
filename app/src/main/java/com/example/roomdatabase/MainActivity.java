package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText etFirstName, etLastName;
    Button btnInsertToRoom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstName = findViewById(R.id.idEtFirstName);
        etLastName = findViewById(R.id.idEtLastName);
        btnInsertToRoom = findViewById(R.id.idBtnInsertToRoom);

        btnInsertToRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new BgThread().start();
            }
        });
    }
        class BgThread extends Thread{
            public  void run(){
             super.run();

                AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "room_db").build();

                UserDao userDao = db.userDao();
                userDao.insertRecord(new User(8, etFirstName.getText().toString(),etLastName.getText().toString()));
//                etFirstName.setText("");
//                etLastName.setText("");

            }
        }
    }
