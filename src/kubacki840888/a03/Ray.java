/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a03;

/**
 *
 * @author miku
 */
public class Ray {
 
Vec3 ursprung;
Vec3 normalisierteRichtung;


public Ray(Vec3 ursprung, Vec3 richtung){
   
    this.ursprung=ursprung;
   this.normalisierteRichtung=richtung;
    
    
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
    
    
    

