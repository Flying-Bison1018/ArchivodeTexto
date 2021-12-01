/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabladeposiciones;

import java.io.IOException;
import java.util.List;

public class Test {
    
    public static void main(String[] args) throws IOException {
    
    Registro tabla = new Registro();
    TabladePosiciones M = new TabladePosiciones("Castañazo",15,10,3,2,33);
    TabladePosiciones N = new TabladePosiciones("Atletico",15,8,3,4,27);
    
    try{
        tabla.registrar(M);
        tabla.registrar(N);
        System.out.println("-------------------------");
        TabladePosiciones eliminado = tabla.eliminar("Atletico");
        System.out.println("Equipo eliminado");
        if(eliminado != null)
            imprimirTabladePosiciones(eliminado);
        else{
            System.out.println("el equipo no se encuentra");
            System.out.println("---------------");    
            }    
      TabladePosiciones buscado = tabla.buscar("Castañazo");
      if (buscado != null){
          imprimirTabladePosiciones(buscado);
      }
      else{
          System.out.println("El equipo ha sido encontrado");
          System.out.println("--------------------------");
      }
      
        System.out.println("Tabla del archivo: ");
        List<TabladePosiciones> Tabla = tabla.leer();
        imprimirLista(Tabla);
     
    }catch(IOException ioe){
        System.out.println(ioe);
      }
    
}

public static void imprimirTabladePosiciones(TabladePosiciones tdp){
    System.out.printf("%3s %3s %3s %3d %3d" ,tdp.getEquipo(),tdp.getPjugados(),tdp.getPganados(),tdp.getPempatados(),tdp.getPperdidos(),tdp.getPuntos());
}
public static void imprimirLista(List<TabladePosiciones> lista){
for (TabladePosiciones t: lista){
    imprimirTabladePosiciones(t);
}
}

    
}
    
