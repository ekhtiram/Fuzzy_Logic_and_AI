/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.File;
import java.net.URISyntaxException;
import net.sourceforge.jFuzzyLogic.FIS;

/**
 *
 * @author User
 */
public class Parking_Birmingham {
    private double saat;
    private FIS fis;
    
        public Parking_Birmingham(double saat) throws URISyntaxException{
            this.saat = saat;
            
            
            File dosya = new File(getClass().getResource("modal.fcl").toURI());
            fis = FIS.load(dosya.getPath(),true);
            fis.setVariable("saat",saat);
            fis.evaluate();
        }
        
        @Override
        public String toString(){
            String cikti = "saat: "+ saat;
            cikti += "\ndoluluk: "+fis.getVariable("doluluk").getValue();
            return cikti;
        }
        public double getClassValue(){
            return fis.getVariable("doluluk").getValue();
        }
        FIS getModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
