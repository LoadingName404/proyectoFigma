package inacap2023.figma;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add_plan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_plan);

        final long id = System.currentTimeMillis(); // Asignar un valor único a la id


        Button btnAddPlan = (Button) findViewById(R.id.btnAddPlan);

        btnAddPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(add_plan.this, planes_de_ejercicios.class);
                startActivity(intent);
            }
        });

        Button btnGuardarPlan = (Button) findViewById(R.id.btnGuardarPlan);

        btnGuardarPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txtPlanNombre = (EditText) findViewById(R.id.txtPlanNombre);
                EditText txtPlanDescripcion = (EditText) findViewById(R.id.txtPlanDescripcion);

                String nombre = txtPlanNombre.getText().toString();
                String descripcion = txtPlanDescripcion.getText().toString();

                if (nombre.isEmpty() || descripcion.isEmpty()) {
                    if (nombre.isEmpty()) {
                        txtPlanNombre.setError("Campo requerido");
                    }
                    if (descripcion.isEmpty()) {
                        txtPlanDescripcion.setError("Campo requerido");
                    }
                } else {
                    plan p = new plan(String.valueOf(id), nombre, descripcion);

                    Intent intent = new Intent();
                    intent.putExtra("plan", p);
                    setResult(Activity.RESULT_OK, intent);
                    finish();
                }
            }
        });
    }
}