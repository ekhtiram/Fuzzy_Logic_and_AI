/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 *
 * @author Ekhtiram
 */
public class JavaApplication2 {

    public static double HataHesaplama(String saat,Parking_Birmingham r) throws IOException, URISyntaxException{
        
        File file = new File(JavaApplication2.class.getResource("dataSet.txt").toURI()); 
        BufferedReader br = new BufferedReader(new FileReader(file)); 
  
        String st; 
        String[] bos;
        String[] parts;
        String bos2;
        String doluluk=null;
        while ((st = br.readLine()) != null) 
        {
            if(st.charAt(0)==saat.charAt(0) && st.charAt(1)==saat.charAt(1) && st.charAt(3)==saat.charAt(2) && st.charAt(4)==saat.charAt(3))
            {
                parts = st.split(":");
                bos=parts[1].split("\\s+");
                doluluk=bos[1];
            }
           
        }
        double hedef=Double.parseDouble(doluluk);
        double bm=r.getClassValue();
        return ((hedef-bm)/hedef)*100; 
//return 0;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws URISyntaxException, IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("saat (7:59-16:31):");
        String saat = in.next();
        String[] parts = saat.split(":");
        String hours = parts[0];
        String minute = parts[1];
        double hata=0;
        if(Double.parseDouble(parts[1])<60){
            StringBuilder sb = new StringBuilder(parts[0]);
            if(parts[0].length()<2){
                sb.insert(0, '0');
                System.out.println(sb);
            }
            String sSaat=sb+parts[1];
            double dSaat=Double.parseDouble(sSaat);
            System.out.println(dSaat);
            Parking_Birmingham r = new Parking_Birmingham(dSaat);
            hata = HataHesaplama(sSaat,r );
            System.out.println(r.toString());
            System.out.println("Hata : " + hata + "%");
        }
        else {
            System.out.println("Saat duzgun girilmedi");
        }
        
        //JFuzzyChart.get().chart(r.getModel());
    }
    
}
