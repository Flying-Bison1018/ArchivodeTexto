/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabladeposiciones;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class ArchivoTablaDePosiciones implements IArchivo {
    private File archivo;
    private FileWriter aEscritura;
    private Scanner aLectura;
    
    public ArchivoTablaDePosiciones(){
        this.archivo=new File("Equipos.dat");
    }
    
    public ArchivoTablaDePosiciones(String name){
        this.archivo=new File(name);
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public FileWriter getaEscritura() {
        return aEscritura;
    }

    public void setaEscritura(FileWriter aEscritura) {
        this.aEscritura = aEscritura;
    }

    public Scanner getaLectura() {
        return aLectura;
    }

    public void setaLectura(Scanner aLectura) {
        this.aLectura = aLectura;
    }
    
    public TabladePosiciones RegistrarDatos(String linea[]){
        TabladePosiciones p = new TabladePosiciones();
        p.setEquipo(linea[0]);
        p.setPganados(Integer.valueOf(linea[1]));
        p.setPempatados(Integer.valueOf(linea[2]));
        p.setPperdidos(Integer.valueOf(linea[3]));
        p.setPjugados(Integer.valueOf((linea[4])));
        return p;
        
    }

    @Override
    public List<TabladePosiciones> leer() throws IOException {
        
        List<TabladePosiciones> lista = null;
        
        try {
            this.aLectura=new Scanner(this.archivo);
            lista = new ArrayList();
            while(this.aLectura.hasNext()){
                String linea[]=this.aLectura.nextLine().split(";");
                TabladePosiciones t = this.RegistrarDatos(linea);
                lista.add(t);
            }
            return lista;
            
        } catch (FileNotFoundException ex){
           throw new IOException("Error al leer el achivo");
        }
        finally{
            if (this.aLectura!=null)
                this.aLectura.close();
        }
        
        
        
    }

    @Override
    public TabladePosiciones buscar(String equipo) throws FileNotFoundException, IOException {
        TabladePosiciones buscado = null;
        
        try{
            this.aLectura= new Scanner(this.archivo);
            while(this.aLectura.hasNext()){
                TabladePosiciones t = this.RegistrarDatos(this.aLectura.nextLine().split(";"));
                if(t.getEquipo().equals(equipo)){
                    buscado=t;
                    break;
                }
                    
            }
            return buscado;
            
        }catch (FileNotFoundException ex){
            throw new IOException("No fue posible abrir el archivo para leer");
        }
        finally{
            if(this.aLectura!=null)
                this.aLectura.close();
        }
       
    }

    @Override
    public TabladePosiciones eliminar(String equipo) throws IOException {
       TabladePosiciones eliminado = null;
       List<TabladePosiciones> ListadoTabla= this.leer();
       ArchivoTablaDePosiciones archivoTmp= new ArchivoTablaDePosiciones("ListaTablaTmp.dat");
       for(TabladePosiciones t: ListadoTabla){
           if(t.getEquipo().equals(equipo)){
               eliminado=t;
           }
           else{
               archivoTmp.escribir(t);
           }
       }
       if(!archivoTmp.archivo.exists()){
           archivoTmp.archivo.createNewFile();
       }
       if(this.archivo.delete()){
           if(archivoTmp.archivo.renameTo(this.archivo)){
               return eliminado;
           }
           else {
               throw new IOException("El archivo temporal no fue removido");
               
           }
       }
       else{
           throw new IOException("el archivo original no fue eliminado");
       }
    }

    @Override
    public boolean escribir(TabladePosiciones tdp) throws IOException  {
        
     PrintWriter escritor = null;
     boolean exito = false;
     try{
         this.aEscritura=new FileWriter(this.archivo, true);
         escritor = new PrintWriter(this.aEscritura);
         escritor.println(tdp.TablaDePosiciones());
         exito=true;
         return exito;
     }catch (IOException ioe){
         throw new IOException("Error al abrir el archivo en modo escritura");
     }
     finally{
         if(escritor != null)
             escritor.close();
         if (this.aEscritura!=null){
             this.aEscritura.close();
         }
     }
    }
    
}
