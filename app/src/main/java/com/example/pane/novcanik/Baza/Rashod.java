package com.example.pane.novcanik.Baza;

/**
 * Created by Pane on 3/29/2018.
 */

public class Rashod {
    private int id;
    private String opis;
    private Long iznos;
    private int idNaloga;

    public int getIdNaloga() {
        return idNaloga;
    }

    public void setIdNaloga(int idNaloga) {
        this.idNaloga = idNaloga;
    }

    public Rashod(int id, String opis, Long iznos, int idNaloga) {
        this.id = id;
        this.opis = opis;
        this.iznos = iznos;
        this.idNaloga=idNaloga;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Long getIznos() {
        return iznos;
    }

    public void setIznos(Long iznos) {
        this.iznos = iznos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
