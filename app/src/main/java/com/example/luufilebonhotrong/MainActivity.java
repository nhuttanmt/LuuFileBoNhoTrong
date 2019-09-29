package com.example.luufilebonhotrong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    Button btnLuu, btnDoc;
    TextView tv;
    String filename = "Data";
    String content = "kjdhflakfjsdjkfhsdkfhdskfh";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDoc = findViewById(R.id.buttonDoc);
        btnLuu = findViewById(R.id.buttonLuu);
        tv = findViewById(R.id.textView);

        // Doc va luu file
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FileOutputStream fileOutputStream = null;

                try {
                    fileOutputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                    fileOutputStream.write(content.getBytes());
                    fileOutputStream.close();
                    Toast.makeText(MainActivity.this, "Luu thanh cong", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileInputStream in = openFileInput(filename);
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    StringBuffer buffer = new StringBuffer();
                    String line = null;
                    while ((line = br.readLine()) != null)
                    {
                        buffer.append(line).append("\n");
                    }
                    tv.setText(buffer.toString());

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
