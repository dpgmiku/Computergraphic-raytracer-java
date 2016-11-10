/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a04;


/**
 *
 * @author miku
 */
public class Ray {
 
public final Vec3 ursprung;
public final Vec3 normalisierteRichtung;
public final double t0,t1;


public Ray(Vec3 ursprung, Vec3 richtung){
   
    this.ursprung=ursprung;
   this.normalisierteRichtung=richtung;
    t0=0;
    t1=Double.POSITIVE_INFINITY;
    
}


    

public Vec3 pointAt(double t){
    if (t==0) {
        
        return ursprung;
    }
    
    if (t==1) {
        
        return ursprung.add(normalisierteRichtung);
        
    }
    
    return ursprung.add(normalisierteRichtung.skalar(t));
    }
    


}
    
    
    

