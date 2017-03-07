package softwaremineria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.*;
import java.io.*;


public class LeerArchivos {
    
    Relacion relacion = new Relacion();
    //Expresiones para comprobar que la liena sea
    String patronComentario="^\\s*[%].*";
    String patronNombre="^\\s*@relation\\s+(\\w+)";
    String patronAtributo="^\\s*@attribute\\s+([^\\s]+)\\s+(\\w+)\\s+(.+)";
    String patronAtributo2="^\\s*@attribute\\s+([^\\s]+)\\s+(\\w+)";
    String patronValorNulo="^\\s*@missingValue\\s+(.+)";
    String patronDatos="^\\s*@data";
    String patronValores="^[^,][,[^,]]*";
    
    Pattern patron;
    Matcher mat;
    
    
    public Relacion muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        boolean sonDatos=false;
        while((cadena = b.readLine())!=null) {
            
            if(sonDatos)
            {
                int tamano= relacion.getAtributos().size();
                
                patron=Pattern.compile(patronValores);
                mat=patron.matcher(cadena);
                if(mat.matches());
                {
                    String[] valores = cadena.split(",");
                    Dato valoresAInstancia= new Dato();
                    //System.out.println("Valores: ");
                    for(int i=0;i<valores.length;i++)
                    {
                        valoresAInstancia.insertarValor(valores[i]);
                       // System.out.println(valores[i]);
                    }
                    relacion.instancia.add(valoresAInstancia);//Agrega una nueva instancia
                }
            }
            patron=Pattern.compile(patronComentario);
            mat=patron.matcher(cadena);
            if(mat.matches())
            {
                relacion.getComentarios().add(cadena);//Guarda el comentario con los %% incluidos
            }
            else
            {
                patron=Pattern.compile(patronNombre);
                mat=patron.matcher(cadena);
                if(mat.matches())
                {
                    //Tiene que quitar el patron original
                    relacion.setNombre(mat.group(1));
                }
                else
                {
                    patron=Pattern.compile(patronAtributo);
                    mat=patron.matcher(cadena);
                    if(mat.matches())
                    {
                        relacion.agregarAtributo(mat.group(1),mat.group(2),mat.group(3));
                    }
                    else
                    {
                        patron=Pattern.compile(patronValorNulo);
                        mat=patron.matcher(cadena);
                        if(mat.matches())
                        {
                            relacion.setValorNulo(mat.group(1));
                        }
                        else
                        {
                            patron=Pattern.compile(patronDatos);
                            mat=patron.matcher(cadena);
                            if(mat.matches())
                            {
                                sonDatos = true;
                            }
                        }
                    }
                }
            }
           
        }
         //Se guarda todo en relacion
         /*   System.out.println("Comentario: "+relacion.getComentarioEnPosicion(0));
            System.out.println("Relacion: "+relacion.getNombre());
            System.out.println("Atributo 1: ");
            System.out.println(relacion.getAtributoEnPosicion(0).getNombre());
            System.out.println(relacion.getAtributoEnPosicion(0).getTipo());
            System.out.println(relacion.getAtributoEnPosicion(0).getExpresionRegular());
        */
        b.close();
        
        return relacion;
    }
    
    public void guardarContenido(String archivo, Relacion relacion) throws FileNotFoundException, IOException {
        try (FileWriter f = new FileWriter(archivo)) {
            PrintWriter b = new PrintWriter(f);
            for(String actual:relacion.comentarios)
            {
                b.write(actual+"\n");
            }
            b.write("@relation " + relacion.nombre + "\n");
            
            for(Atributo actual:relacion.atributos){
                b.write("@attribute " + actual.nombre +" "+actual.tipo + " " +actual.expresionRegular + "\n");
            }
            
            if(!relacion.valorNulo.equals("")){
                b.write("@missingValue "+relacion.valorNulo+"\n");
            }
            
            b.write("@data\n");
            boolean inicio=false;
            for(Dato actual:relacion.instancia){
                
                inicio=false;
                for(String actual2:actual.valores){
                    if(!inicio)
                    {
                        b.write(actual2);
                        inicio=true;
                    }   
                    else
                    {
                        b.write(","+actual2);
                    }
                    
                }
                b.write("\n");
            }
        }
        catch(Exception e)
        {
            System.out.println("Error 1 "+e);
        }
    }

    /*public static void main(String[] args) throws IOException {
        muestraContenido("/usr/share/doc/weka/examples/");
    }*/
}