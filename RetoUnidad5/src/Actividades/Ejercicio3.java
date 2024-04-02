package Actividades;

// IMPORTAMOS LAS CLASES NECESARIAS
import java.io.*;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {

        // CREAMOS UN OBJETO SCANNER PARA LEER LOS NÚMEROS INTRODUCIDOS POR CONSOLA
        Scanner scanner = new Scanner(System.in);

        try {

            String directorio = "C:\\Users\\jesus\\DEV\\daw\\programacion\\05_unidad\\tarea\\RetoUnidad5\\archivos";

            // CREAMOS UN OBJETO FILEOUTPUTSTREAM PARA ESCRIBIR EN EL FICHERO "tres.dat"
            FileOutputStream fos = new FileOutputStream(directorio + "\\tres.dat");

            // CREAMOS UN OBJETO OBJECTOUTPUTSTREAM PARA ESCRIBIR OBJETOS EN EL FICHERO
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            // LEEMOS LOS NÚMEROS INTRODUCIDOS POR CONSOLA HASTA QUE SE INTRODUZCA UNO
            // NEGATIVO
            int num;
            do {
                System.out.println("Introduce un número positivo (un número negativo para terminar):");
                num = scanner.nextInt();
                if (num >= 0) {
                    // ESCRIBIMOS EL NÚMERO EN EL FICHERO SI ES POSITIVO
                    oos.writeInt(num);
                }
            } while (num >= 0);

            // CERRAMOS EL SCANNER Y EL OBJECTOUTPUTSTREAM
            scanner.close();
            oos.close();

        } catch (IOException e) {
            // MANEJAMOS LAS EXCEPCIONES DE ENTRADA/SALIDA
            e.printStackTrace();
        }
    }
}
