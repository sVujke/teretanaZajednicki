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
public class IstorijatPaketa {
    private boolean aktivan;
    private Date datumOdabira;
    private Clan clan;
    private Paket paket;

    public boolean isAktivan() {
        return aktivan;
    }

    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    public Date getDatumOdabira() {
        return datumOdabira;
    }

    public void setDatumOdabira(Date datumOdabira) {
        this.datumOdabira = datumOdabira;
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
