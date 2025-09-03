package menu;

public class Sesion {
    private String nombre;
    private int DNI;
    private String clave;

public Sesion(String nombre, int DNI, String clave){
    this.nombre = nombre;
    this.DNI=DNI;
    this.clave=clave;
    }
public String getNombre() {
    return nombre;
}
public int getDNI() {
    return DNI;
}
public String getClave() {
    return clave;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public void setDni(int dni) {
    this.DNI = dni;
}
public void setClave(String clave) {
    this.clave = clave;
}
        private static Map<Integer, Sesion> usuarios = new HashMap<>();

    public static void registrar(Sesion sesion) {
        usuarios.put(sesion.getDNI(), sesion);
    }

    public static Sesion buscar(int dni) {
        return usuarios.get(dni);
    }

    public static boolean validar(int dni, String clave) {
        Sesion sesion = usuarios.get(dni);
        return sesion != null && sesion.getClave().equals(clave);
    }

    public static boolean existe(int dni) {
        return usuarios.containsKey(dni);
    }
}



