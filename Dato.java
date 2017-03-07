package softwaremineria;

import java.util.*;

public class Dato {
    public List<String> valores;//Como cada dato depende del numero de atributos, este debe ser dinamico

    public Dato()
    {
        valores = new ArrayList<>();
    }
    public List<String> getValores() {
        return valores;
    }
    public void setValores(List<String> valores) {
        this.valores = valores;
    }
    
    public void insertarValor(String nuevoValor)
    {
        valores.add(nuevoValor);
    }
    public int tamano()
    {
        return valores.size();
    }
    
    public String getValorEnPosicion(int posicion)
    {
        String valor=null;
        if(posicion<valores.size())
        {
            valor=valores.get(posicion);
        }
        return valor;
    }
    
    
     
}
