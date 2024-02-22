// CLASE AVIONDECOMBATE(HIJA DE AVION)
public class avionDeCombate extends avion {

    // DECLARAMOS LOS ATRIBUTOS DE AVION Y LOS EMCAPSULAMOS PARA QUE NO SEAN
    // MANIPULABLES FUERA DE LA CLASE
    private boolean esFurtivo;

    // CONSTRUCTOR DE LA CLASE AVION DE COMBATE CON LOS PARAMETROS DE LA CLASE PADRE
    public avionDeCombate(int idAvion, int capAvion, int piloto ,boolean esFurtivo) {
        
        // LLAMO AL CONSTRUCTOR DE LA CLASE PADRE
        super(idAvion, capAvion, piloto);

        this.esFurtivo = esFurtivo;
    }

    // METODOS SETTERS Y GETTERS DE LA CLASE AVION DE COMBATE
    public void setEsFurtivo(boolean esFurtivo) {
        this.esFurtivo = esFurtivo;        
    }

    public boolean isEsFurtivo() {
        return esFurtivo;
    }
}
