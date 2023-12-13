package inacap2023.figma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class planes_de_ejercicios extends AppCompatActivity {

    ArrayAdapter<plan> adapter;
    ArrayList<plan> listado;
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

        this.listado = new ArrayList<plan>();
        this.adapter = new ArrayAdapter<plan>(this, android.R.layout.simple_list_item_1);

        plan c1 = new plan("Plan 1", "Este es el plan 1", "https://i.imgur.com/1QZzJ9o.png");
        plan c2 = new plan("Plan 2", "Este es el plan 2", "https://i.imgur.com/1QZzJ9o.png");
        plan c3 = new plan("Plan 3", "Este es el plan 3", "https://i.imgur.com/1QZzJ9o.png");

        this.listado.add(c1);
        this.listado.add(c2);
        this.listado.add(c3);

        this.adapter.add(c1);
        this.adapter.add(c2);
        this.adapter.add(c3);

        ListView listViewPlanes = findViewById(R.id.listViewPlanes);

        listViewPlanes.setAdapter(adapter);
    }
}