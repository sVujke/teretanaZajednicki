/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vujke
 */
public class Mesto extends AbstractObjekat {
    private String naziv;
    private String ptt;
    private String mestoid;

    public Mesto() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Mesto(String naziv, String ptt, String mestoid) {
        this.naziv = naziv;
        this.ptt = ptt;
        this.mestoid = mestoid;
    }
    
    

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getPtt() {
        return ptt;
    }

    public void setPtt(String ptt) {
        this.ptt = ptt;
    }

    public String getMestoid() {
        return mestoid;
    }

    public void setMestoid(String mestoid) {
        this.mestoid = mestoid;
    }

    @Override
    public String vratiImeTabele() {
        return "mesto";//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiParametre() {
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
        List<AbstractObjekat> mesta = new ArrayList<>();
        
        
            try {
            
            while(rs.next()){
                String mestoid = rs.getString("mestoId");
                String naziv = rs.getString("naziv");
                String ptt = rs.getString("ptt");
                
                Mesto m = new Mesto(naziv, ptt, mestoid);
                mesta.add(m);
            }
            } catch (SQLException ex) {
                Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return mesta;
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
