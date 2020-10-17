package es.b04.log;

import java.util.ArrayList;

public class Usuario {
    protected static int id;
    protected String nombre;
    protected String pass;
    protected String email;
    protected String sexo;
    protected int edad;

    public Usuario(String nombre, String pass, String email, String sexo, int edad) {
        this.nombre = nombre;
        this.pass = pass;
        this.email = email;
        this.sexo = sexo;
        this.edad = edad;
    }
    public Usuario() {
        this.nombre = "";
        this.pass = "";
        this.email = "";
        this.sexo = "";
        this.edad = 0;
    }
    public Usuario(Usuario copia) {
        this.nombre = copia.nombre;
        this.pass = copia.pass;
        this.email = copia.email;
        this.sexo = copia.sexo;
        this.edad = copia.edad;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Usuario.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
