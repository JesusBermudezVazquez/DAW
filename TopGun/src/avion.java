// CLASE AVION(PADRE)
public class avion {

    // DECLARAMOS LOS ATRIBUTOS DE AVION Y LOS EMCAPSULAMOS PARA QUE NO SEAN
    // MANIPULABLES FUERA DE LA CLASE
    private int idAvion;
    private int capAvion;
    private int Piloto;

    // CONSTRUCTOR DE LA CLASE AVION
    public avion(int idAvion, int capAvion, int Piloto) {
        this.idAvion = idAvion;
        this.capAvion = capAvion;
        this.Piloto = Piloto;
    }

    // METODOS SETTERS Y GETTERS DE LA CLASE AVION

    // SETTERS
    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }

    public void setCapAvion(int capAvion) {
        this.capAvion = capAvion;
    }

    public void setPiloto(int Piloto) {
        this.Piloto = Piloto;
    }

    // GETTERS
    public int getIdAvion() {
        return idAvion;
    }

    public int getCapAvion() {
        return capAvion;
    }

    public int getPiloto() {
        return Piloto;
    }

    // METODO PARA MOSTRAR LOS DATOS DEL AVION
    public String mostrarAvion() {

        String datosAvion = "\n\nID: " + idAvion
                + "\nCAPACIDAD: " + capAvion
                + "\nPILOTO: " + Piloto;

                // VALIDO SI LA INSTANCIA DESDE LA QUE SE LLAMA EL METODO ES ALGUNA DE LAS CLASES HIJAS avionDecombate Y avionDeEntrenamiento
                if (this instanceof avionDeCombate) {
                    
                    datosAvion += "\nES FURTIVO: "  + ((avionDeCombate) this).isEsFurtivo();
                }
                if (this instanceof avionDeEentrenamiento) {
                    
                    datosAvion += "\nTIENE DOBLE MANDO: "  + ((avionDeEentrenamiento) this).isTieneDobleMando();
                }


        return datosAvion;
    }
}
