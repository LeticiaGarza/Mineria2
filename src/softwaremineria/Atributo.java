package softwaremineria;

public class Atributo {//Clase para los atributos
    
    public String nombre;
    public String tipo;
    public String expresionRegular;
    
    public Atributo(String nombre, String tipo, String expresionRegular)
    {
        this.nombre=nombre;
        this.tipo=tipo;
        this.expresionRegular=expresionRegular;
    }
    public Atributo()
    {
        this.nombre="";
        this.tipo="";
        this.expresionRegular="";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getExpresionRegular() {
        return expresionRegular;
    }

    public void setExpresionRegular(String expresionRegular) {
        this.expresionRegular = expresionRegular;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}
