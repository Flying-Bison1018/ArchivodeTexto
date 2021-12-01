/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabladeposiciones;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author PC
 */
public class Registro {
    private  ArchivoTablaDePosiciones datos;
    
 public Registro(){
     this.datos= new ArchivoTablaDePosiciones();
 }

    public ArchivoTablaDePosiciones getDatos() {
        return datos;
    }

    public void setDatos(ArchivoTablaDePosiciones datos) {
        this.datos = datos;
    }
 
    public boolean registrar(TabladePosiciones tp) throws IOException{
        return this.datos.escribir(tp);
    }
    
    public TabladePosiciones eliminar(String eq) throws IOException{
        return this.datos.eliminar(eq);
    }
    public TabladePosiciones buscar(String eq) throws IOException{
        return this.datos.buscar(eq);
    }
    public List<TabladePosiciones>leer() throws IOException{
        return this.datos.leer();
    }
}
