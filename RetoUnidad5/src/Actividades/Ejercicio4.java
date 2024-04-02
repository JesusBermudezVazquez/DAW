package Actividades;

import java.io.*;

// DEFINICIÓN DE LA CLASE PERSONA
class Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nombre;
    private int edad;
    private String genero;
    private String ocupacion;

    // CONSTRUCTOR
    public Persona(String nombre, int edad, String genero, String ocupacion) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
        this.ocupacion = ocupacion;
    }

    // GETTERS Y SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
}

// CLASE PRINCIPAL EJERCICIO4
public class Ejercicio4 {

    static String directorio = "C:\\Users\\jesus\\DEV\\daw\\programacion\\05_unidad\\tarea\\RetoUnidad5\\archivos";

    // MÉTODO PARA ESCRIBIR OBJETOS PERSONA EN EL ARCHIVO
    public static void escribirObjetos() {

        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(directorio
                + "\\persona.dat"))) {

            // ESCRIBIR 3 OBJETOS PERSONA EN EL ARCHIVO
            salida.writeObject(new Persona("Juan", 30, "Masculino", "Ingeniero"));
            salida.writeObject(new Persona("María", 25, "Femenino", "Doctora"));
            salida.writeObject(new Persona("Pedro", 40, "Masculino", "Abogado"));

            System.out.println("Objetos escritos en el archivo.");

        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    // MÉTODO PARA LEER OBJETOS PERSONA DESDE EL ARCHIVO
    public static void leerObjetos() {

        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(directorio +
                "\\persona.dat"))) {

            // LEER OBJETOS PERSONA DEL ARCHIVO Y MOSTRARLOS
            while (true) {

                try {
                    Persona persona = (Persona) entrada.readObject();
                    System.out.println("Nombre: " + persona.getNombre() + ", Edad: " + persona.getEdad() +
                            ", Género: " + persona.getGenero() + ", Ocupación: " + persona.getOcupacion());
                } catch (EOFException e) {
                    break; // FIN DEL ARCHIVO
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer del archivo: " + e.getMessage());
        }
    }

    // MÉTODO MAIN
    public static void main(String[] args) {

        // ESCRIBIR OBJETOS EN EL ARCHIVO
        escribirObjetos();

        // LEER OBJETOS DEL ARCHIVO
        leerObjetos();
    }
}
