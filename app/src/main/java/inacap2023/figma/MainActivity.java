package inacap2023.figma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button menuUserButton = findViewById(R.id.menuUserButton);
        Button menuPlanesButton = findViewById(R.id.menuPlanesButton);
        Button menuCalenButton = findViewById(R.id.menuCalenButton);
        Button menuBlogButton = findViewById(R.id.menuBlogButton);
        Button menuDesafioButton = findViewById(R.id.menuDesafioButton);
        Button menuLogroButton = findViewById(R.id.menuLogroButton);

        menuUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Perfil_de_usuario.class);
                startActivity(intent);
            }
        });
        menuPlanesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, planes_de_ejercicios.class);
                startActivity(intent);
            }
        });
        menuBlogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, blogs.class);
                startActivity(intent);
            }
        });
    }
}