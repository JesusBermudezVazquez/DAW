// CLASE PILOTO
public class piloto {

     // DECLARAMOS LOS ATRIBUTOS DE AVION Y LOS EMCAPSULAMOS PARA QUE NO SEAN
     // MANIPULABLES FUERA DE LA CLASE
     private int idPiloto;
     private String nomPiloto;
     private int horasVueloPiloto;
     private String rangoPiloto;

     // CONSTRUCTOR DE LA CLASE PILOTO
     public piloto(int idPiloto, String nomPiloto, int horasVueloPiloto, String rangoPiloto) {
          this.idPiloto = idPiloto;
          this.nomPiloto = nomPiloto;
          this.horasVueloPiloto = horasVueloPiloto;
          this.rangoPiloto = rangoPiloto;
     }

     // METODOS SETTERS Y GETTERS DE LA CLASE PILOTO

     // SETTERS
     public void setIdPiloto(int idPiloto) {
          this.idPiloto = idPiloto;
     }

     public void setNomPiloto(String nomPiloto) {
          this.nomPiloto = nomPiloto;
     }

     public void setHorasVueloPiloto(int horasVueloPiloto) {
          this.horasVueloPiloto = horasVueloPiloto;
     }

     public void setRangoPiloto(String rangoPiloto) {
          this.rangoPiloto = rangoPiloto;
     }

     // GETTERS
     public int getIdPiloto() {
          return idPiloto;
     }

     public String getNomPiloto() {
          return nomPiloto;
     }

     public int getHorasVueloPiloto() {
          return horasVueloPiloto;
     }

     public String getRangoPiloto() {
          return rangoPiloto;
     }

     // METODO PARA MOSTRAR LOS DATOS DEL PILOTO
     public String mostrarPiloto() {

          String datosPiloto = "\n\nID: " + idPiloto + "\nNOMBRE: " + nomPiloto + "\nHORAS DE VUELO: " + horasVueloPiloto + "\nRANGO: " + rangoPiloto;

          return datosPiloto;
     }
}
