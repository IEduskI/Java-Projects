package models;

public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private int edad;
    private String sexo;
    private String email;
    private int activo;

    public Empleado() {
    }

    public Empleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Empleado(String nombre, String apellido, int edad, String sexo, String email, int activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
        this.email = email;
        this.activo = activo;
    }

    public Empleado(int idEmpleado, String nombre, int edad, String sexo, String email) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.email = email;
    }

    public Empleado(int idEmpleado, String nombre, String apellido, int edad, String sexo, String email, int activo) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sexo = sexo;
        this.email = email;
        this.activo = activo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empleado{");
        sb.append("idEmpleado=").append(idEmpleado);
        sb.append(", nombre=").append(nombre);
        sb.append(", apellido=").append(apellido);
        sb.append(", edad=").append(edad);
        sb.append(", sexo=").append(sexo);
        sb.append(", email=").append(email);
        sb.append(", activo=").append(activo);
        sb.append('}');
        return sb.toString();
    }
    
    
}
