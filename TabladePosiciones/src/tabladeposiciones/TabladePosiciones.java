/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabladeposiciones;

/**
 *
 * @author PC
 */
public class TabladePosiciones {
    private String equipo;
    private int Pjugados;
    private int Pganados;
    private int Pempatados;
    private int Pperdidos;
    private int puntos;

    public TabladePosiciones(String equipo, int Pjugados, int Pganados, int Pempatados, int Pperdidos, int puntos) {
        this.equipo = equipo;
        this.Pjugados = Pjugados;
        this.Pganados = Pganados;
        this.Pempatados = Pempatados;
        this.Pperdidos = Pperdidos;
        this.puntos = puntos;
    }
    
    public TabladePosiciones(){
        
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getPjugados() {
        return Pjugados;
    }

    public void setPjugados(int Pjugados) {
        this.Pjugados = Pjugados;
    }

    public int getPganados() {
        return Pganados;
    }

    public void setPganados(int Pganados) {
        this.Pganados = Pganados;
    }

    public int getPempatados() {
        return Pempatados;
    }

    public void setPempatados(int Pempatados) {
        this.Pempatados = Pempatados;
    }

    public int getPperdidos() {
        return Pperdidos;
    }

    public void setPperdidos(int Pperdidos) {
        this.Pperdidos = Pperdidos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    public String TablaDePosiciones(){
        return this.Pganados+";"+
                this.Pempatados+";"+
                this.Pperdidos+";"+
                this.Pjugados+";"+
                this.puntos;
    }

    
}
