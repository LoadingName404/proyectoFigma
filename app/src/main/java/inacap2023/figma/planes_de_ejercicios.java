package inacap2023.figma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class planes_de_ejercicios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planes_de_ejercicios);

        Button menuMenuButton = findViewById(R.id.menuMenuButton);

        menuMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(planes_de_ejercicios.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}