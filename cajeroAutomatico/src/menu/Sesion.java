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
}

