/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabladeposiciones;

import java.io.IOException;
import java.util.List;
import java.io.IOException;

public interface IArchivo {
    public List<TabladePosiciones> leer()throws IOException;
    public TabladePosiciones buscar(String equipo)throws IOException;
    public TabladePosiciones eliminar(String equipo)throws IOException;
    //public TabladePosiciones modificar();
    public boolean escribir(TabladePosiciones tdp)throws IOException;
}
