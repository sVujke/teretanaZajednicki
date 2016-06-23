/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author vujke
 */
public class IstorijatPaketa extends AbstractObjekat{
    private boolean aktivan;
    private Date datumOdabira;
    private Clan clan;
    private Paket paket;

    public IstorijatPaketa() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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

    @Override
    public String vratiImeTabele() {
        return "istorijatpaketa";
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiParametre() {
        //return String.format("'%s', '%s', '%s', '%s'", aktivan, datumOdabira, );
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AbstractObjekat> izRsUTabelu(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUpdateUpit() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSlozeniPK() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
