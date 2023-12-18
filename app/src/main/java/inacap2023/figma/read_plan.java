package inacap2023.figma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class read_plan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_plan);

        Button btnVolver = findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(read_plan.this, planes_de_ejercicios.class);
                startActivity(intent);}
        });

        plan p = (plan) getIntent().getSerializableExtra("plan");

        // definir plan nombre
        TextView planNombre = findViewById(R.id.planNombre);
        // definir plan descripcion
        TextView planDescripcion = findViewById(R.id.planDescripcion);
        // definir imagen

        // setear valores
        planNombre.setText("Nombre: " + p.getNombre());
        planDescripcion.setText("Descripcion: " + p.getDescripcion());
    }
}