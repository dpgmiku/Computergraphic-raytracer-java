/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a07;

import cgtools.Mat4;
import cgtools.Vec3;


/**
 *
 * @author miku
 */
public class Kamera {
    
    
    public final double winkel;
    public final int width;
    public final int height;
    public final Mat4 transformationsmatrix;
    
    public Kamera(int x, int y, double winkel, Mat4 transformationsmatrix){
        this.width=x;
        this.height=y;
        this.winkel=winkel;
        this.transformationsmatrix=transformationsmatrix;
    }
    
    public Ray generateRay(double x, double y){
        Vec3 ursprung = new Vec3(0,0,0);
        
    Vec3 normalisierteRichtung= new Vec3(-(width/2.0)+x,(height/2.0)-y,-((height/2.0)/(Math.tan(winkel/2.0))));   
        

        
   return new Ray(transformationsmatrix.transformPoint(ursprung),transformationsmatrix.transformDirection(normalisierteRichtung));     
        
    }
    
    
}
