
// IMPORTO CLASE SCANNER
import java.util.Scanner;

// CLASE EJECUTABLE
public class gestion {
    public static void main(String[] args) throws Exception {

        // 1. CREO OBJETOS PILOTO

        piloto piloto1 = new piloto(1, "Pete Maverick", 10000, "Capitan");
        piloto piloto2 = new piloto(2, "Natasha Phoenix", 3000, "Teniente");
        piloto piloto3 = new piloto(3, "Bradley Rooster", 3500, "Teniente");

        // -----------------------------------------------------------------------------------------------------------------------

        // 2. PIDE AL USUARIO QUE INTRODUZCA LOS DATOS DE OTROS DOS PILOTOS

        // DECLARO VARIABLES
        int idPiloto4, horasVueloPiloto4, idPiloto5, horasVueloPiloto5;
        String nomPiloto4, nomPiloto5, rangoPiloto4, rangoPiloto5;

        // INSTANCIO SCANNER
        Scanner scanner = new Scanner(System.in);

        // PILOTO 4
        System.out.println("DATOS DEL PILOTO 4");
        System.out.println("---------------------");

        System.out.println("ID:");
        idPiloto4 = scanner.nextInt();

        // LIMPIO BUFFER
        scanner.nextLine();

        System.out.println("NOMBRE:");
        nomPiloto4 = scanner.nextLine();

        System.out.println("HORAS DE VUELO:");
        horasVueloPiloto4 = scanner.nextInt();

        // LIMPIO BUFFER
        scanner.nextLine();

        System.out.println("RANGO:");
        rangoPiloto4 = scanner.nextLine();

        // CREO OBJETO PILOTO 4
        piloto piloto4 = new piloto(idPiloto4, nomPiloto4, horasVueloPiloto4, rangoPiloto4);

        // PILOTO 5
        System.out.println("\n\nDATOS DEL PILOTO 5");
        System.out.println("---------------------");

        System.out.println("ID:");
        idPiloto5 = scanner.nextInt();

        // LIMPIO BUFFER
        scanner.nextLine();

        System.out.println("NOMBRE:");
        nomPiloto5 = scanner.nextLine();

        System.out.println("HORAS DE VUELO:");
        horasVueloPiloto5 = scanner.nextInt();

        // LIMPIO BUFFER
        scanner.nextLine();

        System.out.println("RANGO:");
        rangoPiloto5 = scanner.nextLine();

        // CREO OBJETO PILOTO 5
        piloto piloto5 = new piloto(idPiloto5, nomPiloto5, horasVueloPiloto5, rangoPiloto5);

        // -----------------------------------------------------------------------------------------------------------------------

        // 3. MUESTRO LA INFORMACIÓN DEL PILOTO MAVERICK Y DE ROOSTER

        // MUESTRO DATOS PILOTO MAVERICK
        System.out.println(piloto1.mostrarPiloto());

        // MUESTRO DATOS PILOTO ROOSTER
        System.out.println(piloto3.mostrarPiloto());

        // -----------------------------------------------------------------------------------------------------------------------

        /*
         * 4. MUESTRA LA INFORMACIÓN DE LOS DOS PILOTOS CUYA INFORMACIÓN TE HA
         * PROPORCIONADO EL USUARIO, UTILIZANDO EL MÉTODO MOSTRARPILOTO().
         */

        // MUESTRO DATOS PILOTO 4
        System.out.println(piloto4.mostrarPiloto());

        // MUESTRO DATOS PILOTO 5
        System.out.println(piloto5.mostrarPiloto());

        // -----------------------------------------------------------------------------------------------------------------------

        /*
         * 5. REALIZA LOS PASOS 1 A 2 PERO CON LA CLASE AVION.(Y ASIGNA PILOTO A DICHOS
         * AVIONES, USA LOS QUE YA TIENES CREADOS EN PUNTOS ANTERIORES)
         */

        // A. CREO OBJETOS AVION ASIGNANDO PILOTO
        avionDeEentrenamiento avionEntrenamiento1 = new avionDeEentrenamiento(1, 3, 1, true);
        avionDeCombate avionDeCombate1 = new avionDeCombate(2, 2, 5, true);
        avionDeCombate avionDeCombate2 = new avionDeCombate(3, 3, 3, true);

        /*
         * B. PIDO AL USUARIO QUE CREE LOS 2 NUEVO AVIONES DE ENTRENAMIENTO Y QUIEN LO
         * VA A CONDUCIR
         */

        // DECLARO VARIABLES
        int idAvion4, capAvion4, piloto4_asignado, idAvion5, capAvion5, piloto5_asignado;
        boolean esFurtivo4, esFurtivo5;

        // AVION 4
        System.out.println("\n\nDATOS DEL AVION 4");
        System.out.println("---------------------");

        System.out.println("ID:");
        idAvion4 = scanner.nextInt();

        System.out.println("CAPACIDAD:");
        capAvion4 = scanner.nextInt();

        System.out.println("PILOTO:");
        piloto4_asignado = scanner.nextInt();

        // LIMPIO BUFFER
        scanner.nextLine();

        System.out.println("TIENE DOBLE MANDO:");
        esFurtivo4 = scanner.nextBoolean();

        // CREO OBJETO AVION 4
        avionDeEentrenamiento avionEntrenamiento2 = new avionDeEentrenamiento(idAvion4, capAvion4, piloto4_asignado, esFurtivo4);

        // AVION 5
        System.out.println("\n\nDATOS DEL AVION 5");
        System.out.println("---------------------");

        System.out.println("ID:");
        idAvion5 = scanner.nextInt();

        System.out.println("CAPACIDAD:");
        capAvion5 = scanner.nextInt();

        System.out.println("PILOTO:");
        piloto5_asignado = scanner.nextInt();

        // LIMPIO BUFFER
        scanner.nextLine();

        System.out.println("TIENE DOBLE MANDO:");
        esFurtivo5 = scanner.nextBoolean();

        // CREO OBJETO AVION 5
        avionDeEentrenamiento avionEntrenamiento3 = new avionDeEentrenamiento(idAvion5, capAvion5, piloto5_asignado,
                esFurtivo5);
        System.out.println(avionEntrenamiento3.mostrarAvion());

        // CIERRO SCANNER
        scanner.close();

        // -----------------------------------------------------------------------------------------------------------------------

        // 6. MUESTRO TODA LA INFORMACIÓN DE LOS AVIONES

        // MUESTRO DATOS AVION ENTRENAMIENTO 1
        System.out.println(avionEntrenamiento1.mostrarAvion());

        // MUESTRO DATOS AVION DE COMBATE 1
        System.out.println(avionDeCombate1.mostrarAvion());

        // MUESTRO DATOS AVION DE COMBATE 3
        System.out.println(avionDeCombate2.mostrarAvion());

        // MUESTRO DATOS AVION ENTRENAMIENTO 2
        System.out.println(avionEntrenamiento2.mostrarAvion());

        // MUESTRO DATOS AVION ENTRENAMIENTO 3
        System.out.println(avionEntrenamiento3.mostrarAvion());
    }
}
