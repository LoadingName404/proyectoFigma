package inacap2023.figma;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class planes_de_ejercicios extends AppCompatActivity {

    // Variables de clase
    private ArrayAdapter<plan> adapter;
    private ArrayList<plan> listado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planes_de_ejercicios);

        // Configuración inicial
        setupUI();

        // Cargar planes desde la base de datos
        cargarPlanes();

        // Configurar el botón del menú
        setupMenuButton();

        // Configurar la lista de planes
        setupListView();

        // Configurar el botón agregar
        setupAgregarButton();
    }

    private void setupUI() {
        this.listado = new ArrayList<>();
        this.adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
    }

    private void setupMenuButton() {
        Button menuMenuButton = findViewById(R.id.menuMenuButton);

        menuMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(planes_de_ejercicios.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupListView() {
        ListView listViewPlanes = findViewById(R.id.listViewPlanes);
        listViewPlanes.setAdapter(adapter);

        listViewPlanes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                plan p = listado.get(posicion);
                Intent intent = new Intent(planes_de_ejercicios.this, read_plan.class);
                intent.putExtra("plan", p);
                startActivity(intent);
            }
        });
    }

    private void setupAgregarButton() {
        ActivityResultLauncher<Intent> activityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            plan p = (plan) data.getSerializableExtra("plan");
                            listado.add(p);
                            adapter.add(p);
                            adapter.notifyDataSetChanged();

                            // Guardar el nuevo plan en la base de datos
                            guardarPlanEnDB(p);
                        }
                    }

                    private void guardarPlanEnDB(plan p) {
                        planDB db = new planDB(planes_de_ejercicios.this);
                        db.open();
                        db.guardarPlan(p);
                        db.close();
                    }
                }
        );

        // Boton agregar
        Button btnAgregar = findViewById(R.id.btnAgregar);
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(planes_de_ejercicios.this, add_plan.class);
                activityLauncher.launch(intent);
            }
        });
    }

    private void cargarPlanes() {
        planDB db = new planDB(this);
        db.open();
        listado = db.getPlanes();
        db.close();

        for (plan p : listado) {
            Log.i("PLAN", p.getNombre());
        }
    }
}