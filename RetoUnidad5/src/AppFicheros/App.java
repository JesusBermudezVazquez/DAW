package AppFicheros;

// IMPORTO TODAS LAS CLASES DE LA LIBRERIA IO
import java.io.*;

public class App {

    // DECLARO VARIABLES ESTATICAS PARA PODER USARLAS EN TODA LA CLASE
    private static InputStreamReader isr;
    private static BufferedReader br;
    // private static PrintWriter pw;
    private static File file;
    private static FileWriter escribir;
    private static FileReader leer;

    // DECLARO UNA VARIABLE ESTATICA PARA GUARDAR EL DIRECTORIO
    static String directorio = "C:\\Users\\jesus\\DEV\\daw\\programacion\\05_unidad\\tarea\\RetoUnidad5\\archivos";

    public static void main(String[] args) throws Exception {

        /*
         * CREO OBGETOS
         * 1. INPUTSTREAMREADER: LEE LOS BYTES Y LOS DECODIFICA EN CARACTERES
         * 2. BUFFEREDREADER: LEE TEXTO DE UN FLUJO DE ENTRADA DE CARACTERES
         * POR ESO VAN ANIDADOS. OTRA OPCION SERIA:
         * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         */
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);

        // LLAMO A LOS METODO
        mostrarMenu();
        selector();
    }

    private static void selector() throws IOException {

        // CREO UN OBJETO DE TIPO CONSOLE PARA PODER USAR EL METODO printf()
        Console console = System.console();

        String selecion = "";

        while (true) {

            selecion = br.readLine();

            try {

                /*
                 * COMPARO CADENAS CON EL METODO equalsIgnoreCase() QUE COMPARA CADENAS Y IGNORA
                 * SI ES MAYUSCULAS O MINUSCULA
                 */
                if (selecion.equalsIgnoreCase("a")) {
                    crearArchivo();
                } else if (selecion.equalsIgnoreCase("b")) {
                    leerArchivo();
                } else if (selecion.equalsIgnoreCase("c")) {
                    modificarArchivo();
                } else if (selecion.equalsIgnoreCase("d")) {
                    borrarFichero();
                } else if (selecion.equalsIgnoreCase("e")) {
                    mostrarArchivos();
                } else if (selecion.equalsIgnoreCase("f")) {
                    duplicarFicheros();
                } else if (selecion.equalsIgnoreCase("g")) {
                    mostrarMenu();
                } else if (selecion.equalsIgnoreCase("h")) {
                    salir();
                    break;
                } else {
                    console.printf("Opcion desconocida. Escribe \"[G]\" para ver el menu de opciones");
                }
                /*
                 * NumberFormatException ES UNA EXCEPCION QUE SE LANZA CUANDO SE INTENTA
                 * CONVERTIR UNA CADENA(NO VALIDA EJEMPLO: "abc") DE CARACTERES EN UN NUMERO
                 */
            } catch (NumberFormatException error) {
                /*
                 * MUESTRO UN MENSAJE DE ERROR CON EL METODO getLocalizedMessage() QUE DEVUELVE
                 * UNA CADENA QUE DESCRIBE ESTA EXCEPCION
                 */
                console.printf("Error: " + error.getLocalizedMessage());
            }
        }

    }

    // METODO PARA CREAR UN ARCHIVO TXT
    private static void crearArchivo() {

        // DECLARO VARIABLES
        String nombre_archivo = "";
        int caracteres;
        boolean existe = false;

        // CREO UN OBJETO DE TIPO CONSOLE PARA PODER USAR EL METODO printf()
        Console console = System.console();

        // 1. VALIDO QUE TENGA MAS DE 3 CARACTERES
        do {

            // MUESTRO MENSAJE Y OBTENGO RESPUESTA
            nombre_archivo = console.readLine("\n Introduce el nombre del nuevo archivo: ");

            // CUENTO CARACTERES
            caracteres = nombre_archivo.length();

            existe = false;

            if (caracteres < 3) {

                console.printf(
                        "\nEl nombre del archivo debe tener al menos 3 caracteres o ya existe. Intentalo de nuevo.\n");
            } else {

                // CONCATENO
                nombre_archivo = nombre_archivo.toLowerCase() + ".txt";
                existe = comprobarExiste(nombre_archivo);

                if (existe) {
                    console.printf("\nEl archivo " + nombre_archivo + " ya existe. Intentalo de nuevo.\n");
                }
            }
        } while (caracteres < 3 || existe);

        // 2. CREO EL ARCHIVO
        try {

            // CREO EL ARCHIVO
            file = new File(directorio + "\\" + nombre_archivo);
            file.createNewFile();

            // MUESTRO MENSAJE
            console.printf("\nEl archivo " + nombre_archivo + " se ha creado correctamente.\n");

            /*
             * IOException. SI HAY UN ERROR A LA HORA DE ABRIR ESCRIBIR, MANIPULAR, ABRIR..
             * UN ARCHVIVO SALTA EL ERROR
             */
        } catch (IOException error) {

            // MUESTRO MENSAJE DE ERROR
            console.printf("\nError: " + error.getLocalizedMessage());
        }

    }

    // METODO PARA LEER FICHERO
    private static void leerArchivo() {

        Console console = System.console();

        // MUESTRO LOS ARCHIVOS
        mostrarArchivos();

        String archivo = console.readLine("\nEscribe el nombre del archivo que quieres ver: ");

        try {

            boolean existe = comprobarExiste(archivo);

            if (existe) {

                // CREO UN OBJETO DE TIPO FILE PARA LEER EL ARCHIVO
                file = new File(directorio + "\\" + archivo.toLowerCase());

                // CREO UN OBJETO DE TIPO FILE READER PARA LEER EL ARCHIVO
                leer = new FileReader(file);

                // DECLARO Y INICIALIZO EL BUFFER
                BufferedReader buffer = new BufferedReader(leer);

                // LEE EL ARCHIVO LÍNEA POR LÍNEA
                String linea;
                while ((linea = buffer.readLine()) != null) {
                    console.printf(linea);
                }

                // CIERRO EL ARCHIVO
                buffer.close();

            } else {
                console.printf("El archivo " + archivo + " no existe. Pulsa [G] para volver el menú\n");
            }

        } catch (IOException error) {
            console.printf("Error: " + error.getLocalizedMessage());
        }
    }

    // METODO PARA MODIFICAR FICHERO
    private static void modificarArchivo() throws IOException {

        Console console = System.console();
        mostrarArchivos();

        console.printf("\nEscribe el nombre del archivo que quieres modificar.\n");

        String selecion = br.readLine();

        try {

            boolean existe = comprobarExiste(selecion);

            if (existe) {

                // CREO OBGETO FILE WRITE PARA ESCRIBIR EN EL ARCHIVO
                escribir = new FileWriter(directorio + "\\" + selecion, true);

                String texto = console.readLine("Escribe el texto que quieres añadir al archivo: ");

                // UTILIZO METODO write() PARA ESCRIBIR EN EL ARCHIVO
                escribir.write(texto);

                // CIERRO EL ARCHIVO
                escribir.close();

            } else {
                console.printf("El archivo " + selecion + " no existe. Pulsa [G] para volver el menú\n");
            }

        } catch (NumberFormatException error) {
            /*
             * MUESTRO UN MENSAJE DE ERROR CON EL METODO getLocalizedMessage() QUE DEVUELVE
             * UNA CADENA QUE DESCRIBE ESTA EXCEPCION
             */
            console.printf("Error: " + error.getLocalizedMessage());
        }

        System.out.println(selecion);

    }

    // METODO PARA BORRAR ARCHIVO
    private static void borrarFichero() throws IOException {

        Console console = System.console();
        mostrarArchivos();

        String archivo = console.readLine("\nEscribe el nombre del archivo que quieres borrar: ");

        try {

            boolean existe = comprobarExiste(archivo);

            if (existe) {

                // CREO UN OBJETO DE TIPO FILE PARA BORRAR EL ARCHIVO
                file = new File(directorio + "\\" + archivo.toLowerCase());

                // BORRO EL ARCHIVO
                file.delete();

                // MUESTRO MENSAJE
                console.printf("\nEl archivo " + archivo + " se ha borrado correctamente.\n");

            } else {
                console.printf("El archivo " + archivo + " no existe. Pulsa [G] para volver el menú\n");
            }

        } catch (NumberFormatException error) {
            /*
             * MUESTRO UN MENSAJE DE ERROR CON EL METODO getLocalizedMessage() QUE DEVUELVE
             * UNA CADENA QUE DESCRIBE ESTA EXCEPCION
             */
            console.printf("Error: " + error.getLocalizedMessage());
        }
    }

    // METODO PARA MOSTRAR ARCHIVOS GUARDADOS
    private static void mostrarArchivos() {

        Console console = System.console();

        // DECLARO VARIABLES
        File[] archivos;
        int numero_archvo = 0, numero = 0;
        boolean existe = false;
        console.printf(
                "\nSe van a mostrar los archivos del directorio. Indica el número del archivo si quieres ver la info.\n\n");

        // CONCATENO
        file = new File(directorio);
        archivos = file.listFiles();
        // DECLARO ARRAYS INICIALIZACION CON EL TOTAL DE ARCHIVOS
        int numeros[] = new int[file.listFiles().length];

        // MUESTRO LOS ARCHIVOS

        for (File file : archivos) {
            console.printf("[" + numero_archvo + "] " + file.getName() + "\n");

            // METO EN UN ARRAT LOS NUMEROS DE LOS ARCHIVOS
            numeros[numero_archvo] = numero_archvo;
            numero_archvo++;
        }

        String archivo = console.readLine(
                "\nEscribe el número del archivo si quieres ver la info. Si no cualquier otro caracter que no sea el número de archivo para continuar.\n");

        for (int i = 0; i < numeros.length; i++) {

            // UTILIZO TRY CATCH PARA EVITAR QUE SALTE UN ERROR SI EL USUARIO INTRODUCE UNA
            // STRING
            try {
                if (numeros[i] == Integer.parseInt(archivo)) {
                    existe = true;
                    break;
                } else {
                    existe = false;
                }
            } catch (NumberFormatException error) {

                existe = false;
            }

        }

        if (existe) {

            numero = Integer.parseInt(archivo);

            // MOSTRAMOS EL NOMBRE DEL ARCHIVO

            String archivo_detalle = "\n" + "Nombre del archivo: " + archivos[numero].getName() + "\n";
            // MOSTRAMOS LA RUTA ABSOLUTA DEL ARCHIVO
            archivo_detalle += "Ruta absoluta: " + archivos[numero].getAbsolutePath() + "\n";
            // MOSTRAMOS LA RUTA DEL DIRECTORIO PADRE
            archivo_detalle += "Ruta del directorio padre: " + archivos[numero].getParent() + "\n";
            // MOSTRAMOS EL TAMAÑO DEL FICHERO EN BYTES
            archivo_detalle += "Tamaño del fichero: " + archivos[numero].length() + " bytes" + "\n";
            // INDICAMOS SI ES UN FICHERO
            archivo_detalle += "¿Es un fichero?: " + archivos[numero].isFile() + "\n";
            // INDICAMOS SI ES UN DIRECTORIO
            archivo_detalle += "¿Es un directorio?: " + archivos[numero].isDirectory() + "\n";
            // INDICAMOS SI TIENE PERMISO DE LECTURA
            archivo_detalle += "Permiso de lectura: " + archivos[numero].canRead() + "\n";
            // INDICAMOS SI TIENE PERMISO DE ESCRITURA
            archivo_detalle += "Permiso de escritura: " + archivos[numero].canWrite() + "\n";
            // INDICAMOS SI TIENE PERMISO DE EJECUCIÓN
            archivo_detalle += "Permiso de ejecución: " + archivos[numero].canExecute() + "\n";
            // INDICAMOS SI ESTÁ OCULTO
            archivo_detalle += "¿Está oculto?: " + archivos[numero].isHidden() + "\n";

            console.printf(archivo_detalle);
        }

    }

    // METODO PARA DUPLICAR FICHEROS
    private static void duplicarFicheros() {

        Console console = System.console();
        mostrarArchivos();

        String archivos = console.readLine(
                "\nEscribe el nombre del archivo que quieres copiar el contenido y separado por una coma donde los quieres pegar.\n");

        // SEPARO LOS ARCHIVOS POR COMAS
        String[] archivo = archivos.split(",");

        // FUNCION TRIM() PARA ELIMINAR LOS ESPACIOS EN BLANCO
        String archivo_copy = archivo[0].trim().toLowerCase();
        String archivo_paste = archivo[1].trim().toLowerCase();

        // COMPRUEBO QUE EXISTAN LOS ARCHIVOS
        boolean existe_copy = comprobarExiste(archivo_copy);
        boolean existe_paste = comprobarExiste(archivo_paste);

        if (!existe_copy) {

            console.printf("El archivo " + archivo_copy + " no existe. Pulsa [G] para volver el menú\n");
        } else if (!existe_paste) {

            console.printf("El archivo " + archivo_paste + " no existe. Pulsa [G] para volver el menú\n");
        } else {

            try {

                // CREO UN OBJETO DE TIPO FILE PARA LEER EL ARCHIVO
                leer = new FileReader(directorio + "\\" + archivo_copy.toLowerCase());

                // CREO OBGETO FILE WRITE PARA ESCRIBIR EN EL ARCHIVO
                escribir = new FileWriter(directorio + "\\" + archivo_paste);

                // LEE EL ARCHIVO LÍNEA POR LÍNEA
                int linea;
                while ((linea = leer.read()) != -1) {

                    // UTILIZO METODO write() PARA ESCRIBIR EN EL ARCHIVO
                    escribir.write(linea);
                }

                // CIERRO ARCHIVOS
                leer.close();
                escribir.close();

                console.printf(
                        "\nEl archivo " + archivo_copy + " se ha duplicado correctamente en " + archivo_paste + "\n");

            } catch (IOException error) {
                console.printf("Error: " + error.getLocalizedMessage());
            }
        }
    }

    // METODO PARA MOSTRAR MENUS
    private static void mostrarMenu() {

        // CREO UN OBJETO DE TIPO CONSOLE PARA PODER USAR EL METODO printf()
        Console console = System.console();

        // CREO MENU CONCATENANDO PARA QUE SEA MAS LEGIBLE EN CODIGO
        String menu = "\n====================================\n";
        menu += "  Menu \n";
        menu += "====================================\n";
        menu += "[A] - Crear archivo.\n";
        menu += "[B] - Leer archivo.\n";
        menu += "[C] - Modificar archivo.\n";
        menu += "[D] - Borrar archivo.\n";
        menu += "[E] - Ver archivos.\n";
        menu += "[F] - Duplicar.\n";
        menu += "[G] - Menu.\n";
        menu += "[H] - Salir.\n";

        // MUESTRO POR CONSOLA EL MENU
        console.printf(menu);
    }

    // METODO PARA VALIDAR QUE NO EXISTA EL ARCHIVO
    public static boolean comprobarExiste(String nombre_archivo) {

        nombre_archivo = nombre_archivo.toLowerCase();

        boolean existe = false;

        file = new File(directorio);

        /*
         * CREO ARRAY PARA GUARDAR EL NOMBRE DEL ARCHIVO QUE HAY EN EL DIRECTORIO
         * DESTINO. POR SI HAY ALGUNO QUE SE LLAME IGUAL NO LO MACHAQUE
         */
        File[] archivos = file.listFiles();

        // 2. VALIDO QUE NO EXISTA EL ARCHIVO CON EL MISMO NOMBRE
        for (File file : archivos) {
            if (file.getName().equalsIgnoreCase(nombre_archivo)) {
                existe = true;
            }
        }

        return existe;
    }

    // METODO PARA SALIR
    private static void salir() {

        // CIERRA EL BUFFEREDREADER
        try {
            br.close();
        } catch (IOException error) {

            /*
             * METODO printStacktrace() MUESTRA EL ERROR QUE DA, METODO DONDE SE PRODUCE EL
             * ERROR Y CUALES SON LOS METODOS QUE HAN DESENCADENADO EL MISMO
             */
            error.printStackTrace();
        }
        // PARALIZO LA VIRTUAL MACHINE
        System.exit(0);
    }
}