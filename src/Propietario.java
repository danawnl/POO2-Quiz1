public class Propietario extends Persona{
    //Atributos
    private String idPropietario;
    //Constructor
    public Propietario(int documento, String nombre, String apellido, int edad, String idPropietario) {
        super(documento, nombre, apellido, edad);
        this.idPropietario = idPropietario;
    }
    //Métodos

    //Get and set
    public String getIdPropietario() {return idPropietario;}
}
