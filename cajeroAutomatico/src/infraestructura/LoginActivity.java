package infraestructura;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import menu.RepositorioUsuario;
import menu.Sesion;
import com.example.tubanco.R;

public class LoginActivity extends Activity {

    EditText dni, clave;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dni = findViewById(R.id.etDni);
        clave = findViewById(R.id.etClave);
        login = findViewById(R.id.btnLogin);

        login.setOnClickListener(v -> {
            int d = Integer.parseInt(dni.getText().toString());
            String c = clave.getText().toString();

            if (RepositorioUsuario.validarLogin(d, c)) {
                Sesion s = RepositorioUsuario.buscarUsuario(d);
                Intent i = new Intent(this, MainActivity.class);
                i.putExtra("nombre", s.getNombre());
                startActivity(i);
                finish();
            } else {
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
