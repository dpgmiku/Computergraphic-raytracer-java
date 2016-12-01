/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a06;

import cgtools.Mat4;
import cgtools.Vec3;


/**
 *
 * @author miku
 */
public class Kamera {
    
    
    public final double winkel;
    public final double width;
    public final double height;
    public final Vec3 ursprung;
    public final Mat4 transformationsmatrix;
    
    public Kamera(double x, double y, double winkel, Mat4 transformationsmatrix){
        this.width=x;
        this.height=y;
        this.winkel=winkel;
        ursprung = new Vec3(0,0,0);
        this.transformationsmatrix=transformationsmatrix;
    }
    
    public Ray generateRay(double x, double y){
        
    Vec3 normalisierteRichtung= new Vec3(-(width/2.0)+x,(height/2.0)-y,-((height/2.0)/(Math.tan(winkel/2.0))));   
        

        
   return new Ray(transformationsmatrix.transformPoint(ursprung),transformationsmatrix.transformDirection(normalisierteRichtung));     
        
    }
    
    
}
