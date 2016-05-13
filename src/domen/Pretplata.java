/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.util.Date;

/**
 *
 * @author vujke
 */
public class Pretplata {
    private String pretplata;
    private Date datum;
    private Clan clan;
    private Paket paket;

    public String getPretplata() {
        return pretplata;
    }

    public void setPretplata(String pretplata) {
        this.pretplata = pretplata;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Paket getPaket() {
        return paket;
    }

    public void setPaket(Paket paket) {
        this.paket = paket;
    }
}
