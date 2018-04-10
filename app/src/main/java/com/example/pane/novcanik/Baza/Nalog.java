package com.example.pane.novcanik.Baza;

import java.util.List;

/**
 * Created by Pane on 2/12/2018.
 */

public class Nalog {
    private int _id;
    private String _ime;
    private double _dug;
    private List<Rashod> rashodi;
    private List<Prihod> prihodi;

    public Nalog(){
    }

    public List<Rashod> getRashodi() {
        return rashodi;
    }

    public void setRashodi(List<Rashod> rashodi) {
        this.rashodi = rashodi;
    }

    public List<Prihod> getPrihodi() {
        return prihodi;
    }

    public void setPrihodi(List<Prihod> prihodi) {
        this.prihodi = prihodi;
    }

    public Nalog(int id,String ime,double dug){
        this._dug=dug;
        this._id=id;
        this._ime=ime;
    }
    public Nalog(String ime,double dug){
        this._dug=dug;
        this._ime=ime;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_ime(String _ime) {
        this._ime = _ime;
    }

    public void set_dug(double _dug) {
        this._dug = _dug;
    }

    public int get_id() {
        return _id;
    }

    public String get_ime() {
        return _ime;
    }

    public double get_dug() {
        return _dug;
    }
}
