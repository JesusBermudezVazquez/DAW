// CLASE AVION DE ENTRENAMIENTO(HIJA DE AVION)
public class avionDeEentrenamiento extends avion {

    // DECLARAMOS LOS ATRIBUTOS DE AVION Y LOS EMCAPSULAMOS PARA QUE NO SEAN
    // MANIPULABLES FUERA DE LA CLASE
    private boolean tieneDobleMando;

    // CONSTRUCTOR DE LA CLASE AVION DE ENTRENAMIENTO
    public avionDeEentrenamiento(int idAvion, int capAvion, int piloto , boolean tieneDobleMando) {

        super(idAvion, capAvion, piloto);
        this.tieneDobleMando = tieneDobleMando;
    }

    // METODOS SETTERS Y GETTERS DE LA CLASE AVION DE ENTRENAMIENTO
    public void setTieneDobleMando(boolean tieneDobleMando) {
        this.tieneDobleMando = tieneDobleMando;
    }

    public boolean isTieneDobleMando() {
        return tieneDobleMando;
    }
}
