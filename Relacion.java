package softwaremineria;

import java.util.List;
import java.util.ArrayList;

public class Relacion {//De esta clase solo se hace un objeto :v
    public String nombre;//Nombre de la relacion
    public List<Atributo> atributos;//Lista de atributos
    public String valorNulo;//Valor faltante
    public List<Dato> instancia;//Guarda los valores que van a tabla
    public List<String> comentarios;//Guarda todos los comentarios para guardarlos en archivo despues
    
    Relacion()
    {
        nombre="";
        instancia= new ArrayList<>();
        atributos = new ArrayList<>();
        valorNulo="";
        comentarios = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Atributo> getAtributos() {
        return atributos;
    }

    public void setAtributos(List<Atributo> atributos) {
        this.atributos = atributos;
    }

    public String getValorNulo() {
        return valorNulo;
    }

    public void setValorNulo(String valorNulo) {
        this.valorNulo = valorNulo;
    }

    public List<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }
    public Atributo getAtributoEnPosicion(int posicion)
    {
        Atributo atributo= new Atributo();
        if(atributos.size()>posicion)
        {
            atributo=atributos.get(posicion); 
        }
        return atributo;
    }
    public String getComentarioEnPosicion(int posicion)
    {
        String comentario="";
        if(comentarios.size()>posicion)
        {
            comentario=comentarios.get(posicion); 
        }
        return comentario;
    }
    public void agregarAtributo(String nombre, String tipo, String expresionRegular)
    {
        atributos.add(new Atributo(nombre,tipo,expresionRegular));
    }

    public List<Dato> getInstancia() {
        return instancia;
    }

    public void setInstancia(List<Dato> instancia) {
        this.instancia = instancia;
    }
    
}
