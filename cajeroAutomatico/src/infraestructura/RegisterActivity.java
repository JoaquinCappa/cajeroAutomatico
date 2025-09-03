package infraestructura;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import menu.Sesion;
import menu.RepositorioUsuario;
import com.example.tubanco.R;

public class RegisterActivity extends Activity {

    EditText nombre, dni, clave;
    Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nombre = findViewById(R.id.etNombre);
        dni = findViewById(R.id.etDni);
        clave = findViewById(R.id.etClave);
        registrar = findViewById(R.id.btnRegistrar);

        registrar.setOnClickListener(v -> {
            String n = nombre.getText().toString();
            int d = Integer.parseInt(dni.getText().toString());
            String c = clave.getText().toString();

            if (RepositorioUsuario.existeUsuario(d)) {
                Toast.makeText(this, "Ya existe ese DNI", Toast.LENGTH_SHORT).show();
            } else {
                Sesion s = new Sesion(n, d, c);
                RepositorioUsuario.registrarUsuario(s);
                Toast.makeText(this, "Registrado correctamente", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
                finish();
            }
        });
    }
}

