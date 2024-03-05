public class Persona {
    //Atributos
    private int documento;
    private String nombre;
    private String apellido;
    private int edad;
    //Constructor
    public Persona(int documento, String nombre, String apellido, int edad) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
    //Métodos
    //Get and set
    public int getDocumento() {return documento;}
    public String getNombre() {return nombre;}
    public String getApellido() {return apellido;}
    public int getEdad() {return edad;}
}
