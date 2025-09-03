package menu;

import java.util.HashMap;
import java.util.Map;

public class RepositorioUsuario {

    public static Map<Integer, Sesion> usuarios = new HashMap<>();

    public static void registrarUsuario(Sesion sesion) {
        usuarios.put(sesion.getDNI(), sesion);
    }

    public static Sesion buscarUsuario(int dni) {
        return usuarios.get(dni);
    }

    public static boolean validarLogin(int dni, String clave) {
        Sesion s = usuarios.get(dni);
        if (s == null) return false;
        return s.getClave().equals(clave);
    }

    public static boolean existeUsuario(int dni) {
        return usuarios.containsKey(dni);
    }
}

