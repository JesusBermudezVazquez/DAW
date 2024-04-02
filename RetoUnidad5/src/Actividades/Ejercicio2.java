package Actividades;

import java.io.*;

public class Ejercicio2 {

    public static void main(String[] args) {
        // DIRECTORIO
        String directorio = "C:\\Users\\jesus\\DEV\\daw\\programacion\\05_unidad\\tarea\\RetoUnidad5\\archivos";

        // A) MUESTRA EL DIRECTORIO ACTUAL POR CONSOLA Y CREA EL DIRECTORIO Y FICHEROS
        File directorioActual = new File(directorio);
        System.out.println("Directorio actual: " + directorioActual.getAbsolutePath());

        File dirEjer2 = new File(directorioActual, "dirEjer2");
        if (!dirEjer2.exists()) {
            if (dirEjer2.mkdir()) {
                System.out.println("Directorio dirEjer2 creado");
            } else {
                System.out.println("Error al crear directorio dirEjer2");
            }
        }

        File unoTxt = new File(dirEjer2, "uno.txt");
        File dosTxt = new File(dirEjer2, "dos.txt");

        try {
            if (!unoTxt.exists()) {
                if (unoTxt.createNewFile()) {
                    System.out.println("Archivo uno.txt creado");
                } else {
                    System.out.println("Error al crear archivo uno.txt");
                }
            }
            if (!dosTxt.exists()) {
                if (dosTxt.createNewFile()) {
                    System.out.println("Archivo dos.txt creado");
                } else {
                    System.out.println("Error al crear archivo dos.txt");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // B) ABRE EL FICHERO "DOS.TXT" PARA ESCRITURA
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dosTxt))) {
            // C) PIDE AL USUARIO QUE INTRODUZCA NOMBRES
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String nombre;
            System.out.println("Introduce nombres (termina con '-'): ");
            while (!(nombre = reader.readLine()).equals("-")) {
                writer.write(nombre);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // E) ABRE EL FICHERO "DOS.TXT" PARA LECTURA Y MUESTRA SU CONTENIDO
        try (BufferedReader reader = new BufferedReader(new FileReader(dosTxt))) {
            System.out.println("\nContenido de dos.txt:");
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
