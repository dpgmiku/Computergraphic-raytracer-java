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
public class Kamera {
    
    
    double winkel;
    double width;
    double height;
    Vec3 ursprung;
   
    
    public Kamera(double x, double y, double winkel){
        this.width=x;
        this.height=y;
        this.winkel=winkel;
        ursprung = new Vec3(0,0,0);
    }
    
    public Ray generateRay(int x, int y){
        
    Vec3 normalisierteRichtung= new Vec3(-(width/2)+x,(height/2)-y,-((height/2)/(Math.tan(winkel/2))));   
        
        
        
   return new Ray(ursprung,normalisierteRichtung.normalisierung());     
        
    }
    
    
}
