package Actividades;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nombreArchivo1, nombreArchivo2;

        // A) PIDE AL USUARIO QUE INTRODUZCA POR TECLADO EL NOMBRE DE DOS FICHEROS
        do {
            System.out.println("Introduce el nombre del primer fichero:");
            nombreArchivo1 = scanner.nextLine().trim().toUpperCase();
        } while (nombreArchivo1.length() < 3);
        System.out.println("El nombre del fichero " + nombreArchivo1 + " es válido.");

        do {
            System.out.println("Introduce el nombre del segundo fichero:");
            nombreArchivo2 = scanner.nextLine().trim().toUpperCase();
        } while (nombreArchivo2.length() < 3);
        System.out.println("El nombre del fichero " + nombreArchivo2 + " es válido.");
        scanner.close();

        // B) OBTÉN LA RUTA DE TU DIRECTORIO ACTUAL
        String directorioActual = System.getProperty("user.dir");
        System.out.println("Directorio actual: " + directorioActual);

        // c) CONSTRUYE LA RUTA RELATIVA AL PRIMER FICHERO
        String rutaCompletaFich1 = directorioActual + File.separator + nombreArchivo1;
        String rutaCompletaFich2 = directorioActual + File.separator + nombreArchivo2;

        // COMPRUEBA SI LOS FICHEROS EXISTEN
        boolean fichero1Existe = comprobarExiste(new File(rutaCompletaFich1));
        boolean fichero2Existe = comprobarExiste(new File(rutaCompletaFich2));

        if (!fichero1Existe) {
            try {
                // CREA EL PRIMER FICHERO SI NO EXISTE
                File fichero1 = new File(rutaCompletaFich1);
                if (fichero1.createNewFile()) {
                    System.out.println("Se ha creado el fichero " + nombreArchivo1);
                } else {
                    System.out.println("El fichero " + nombreArchivo1 + " ya existe.");
                }
            } catch (IOException e) {
                System.out.println("Error al crear el fichero " + nombreArchivo1);
            }
        }

        if (!fichero2Existe) {
            try {
                // CREA EL SEGUNDO FICHERO SI NO EXISTE
                File fichero2 = new File(rutaCompletaFich2);
                if (fichero2.createNewFile()) {
                    System.out.println("Se ha creado el fichero " + nombreArchivo2);
                } else {
                    System.out.println("El fichero " + nombreArchivo2 + " ya existe.");
                }
            } catch (IOException e) {
                System.out.println("Error al crear el fichero " + nombreArchivo2);
            }
        }

        // E) GRABAR DATOS EN EL PRIMER FICHERO
        if (comprobarExiste(new File(rutaCompletaFich1))) {
            escribirEnFichero(nombreArchivo1);
        }

        // F) LEER EL CONTENIDO DEL PRIMER FICHERO
        if (comprobarExiste(new File(rutaCompletaFich1))) {
            leerDeFichero(nombreArchivo1);
        }

        // G) MOSTRAR PROPIEDADES DEL PRIMER FICHERO SI EXISTE
        if (comprobarExiste(new File(rutaCompletaFich1))) {
            mostrarPropiedadesFichero(nombreArchivo1);
        } else {
            System.out.println("El fichero " + nombreArchivo1 + " no existe.");
        }

        // H) COPIAR EL CONTENIDO DEL PRIMER FICHERO AL SEGUNDO
        duplicarFicheros(new File(rutaCompletaFich1), new File(rutaCompletaFich2));

        // I) BORRAR EL PRIMER FICHERO
        borrarFichero(new File(rutaCompletaFich1));

        // J) LEER EL SEGUNDO FICHERO PARA COMPROBAR LA COPIA
        leerDeFichero(nombreArchivo2);

        // K) CREAR EL DIRECTORIO "DIREJER1" SI NO EXISTE
        String rutaDirectorio = directorioActual + File.separator + "dirEjer1";
        if (!comprobarExiste(new File(rutaDirectorio))) {
            try {
                File directorio = new File(rutaDirectorio);
                if (directorio.mkdir()) {
                    System.out.println("Se ha creado el directorio 'dirEjer1'.");
                } else {
                    System.out.println("Error al crear el directorio 'dirEjer1'.");
                }
            } catch (SecurityException e) {
                System.out.println("No tienes permisos para crear el directorio 'dirEjer1'.");
            }
        } else {
            System.out.println("El directorio 'dirEjer1' ya existe.");
        }
    }

    public static boolean leerDeFichero(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            System.out.println("Contenido del fichero " + nombreArchivo + ":");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error al leer el fichero " + nombreArchivo);
            return false;
        }
    }

    public static boolean escribirEnFichero(String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int i = 0; i <= 10; i++) {
                bw.write(String.valueOf(i));
                bw.newLine();
            }
            System.out.println("Se han escrito los números del 0 al 10 en el fichero " + nombreArchivo);
            return true;
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero " + nombreArchivo);
            return false;
        }
    }

    public static boolean borrarFichero(File fichero) {
        if (fichero.delete()) {
            System.out.println("Se ha borrado el fichero " + fichero.getName());
            return true;
        } else {
            System.out.println("No se ha podido borrar el fichero " + fichero.getName());
            return false;
        }
    }

    public static boolean comprobarExiste(File fichero) {
        return fichero.exists();
    }

    public static void duplicarFicheros(File origen, File destino) {
        try (BufferedReader br = new BufferedReader(new FileReader(origen));
                BufferedWriter bw = new BufferedWriter(new FileWriter(destino))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                bw.write(linea);
                bw.newLine();
            }
            System.out.println("Se ha duplicado el contenido de " + origen.getName() + " a " + destino.getName());
        } catch (IOException e) {
            System.out.println("Error al duplicar el fichero " + origen.getName());
        }
    }

    public static void mostrarPropiedadesFichero(String nombreArchivo) {
        File fichero = new File(nombreArchivo);
        System.out.println("Nombre del archivo: " + fichero.getName());
        System.out.println("Ruta absoluta: " + fichero.getAbsolutePath());
        System.out.println("Ruta del directorio padre: " + fichero.getParent());
        System.out.println("Tamaño del fichero: " + fichero.length() + " bytes");
        System.out.println("¿Es un fichero? " + (fichero.isFile() ? "Sí" : "No"));
        System.out.println("Permiso de lectura: " + (fichero.canRead() ? "Sí" : "No"));
        System.out.println("Permiso de escritura: " + (fichero.canWrite() ? "Sí" : "No"));
        System.out.println("Permiso de ejecución: " + (fichero.canExecute() ? "Sí" : "No"));
        System.out.println("¿Está oculto? " + (fichero.isHidden() ? "Sí" : "No"));
    }
}
