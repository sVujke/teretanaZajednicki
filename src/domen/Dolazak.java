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
public class Dolazak {
    private String dolazakid;
    private Date datum;
    private String smena;
    private boolean radniDan;

    public String getDolazakid() {
        return dolazakid;
    }

    public void setDolazakid(String dolazakid) {
        this.dolazakid = dolazakid;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public String getSmena() {
        return smena;
    }

    public void setSmena(String smena) {
        this.smena = smena;
    }

    public boolean isRadniDan() {
        return radniDan;
    }

    public void setRadniDan(boolean radniDan) {
        this.radniDan = radniDan;
    }
}
