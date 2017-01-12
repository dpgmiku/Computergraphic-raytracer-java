/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a09;

import cgtools.Mat4;
import cgtools.Vec3;

/**
 *
 * @author miku
 */
public class Kamera {
     static final int WIDTH = 480;
    static final int HEIGHT = 270;

    
    public  double winkel;
    public  int width;
    public  int height;
    public  Mat4 transformationsmatrix;
    
    public Kamera(int width, int height, double winkel, Mat4 transformationsmatrix){
        this.width=width;
        this.height=height;
        this.winkel=winkel;
        this.transformationsmatrix=transformationsmatrix;
    }
    
    public Ray generateRay(double x, double y){
        Vec3 ursprung = new Vec3(0,0,0);
        
    Vec3 normalisierteRichtung= new Vec3(-(width/2.0)+x,(height/2.0)-y,-((height/2.0)/(Math.tan(winkel/2.0))));   
        

        
   return new Ray(transformationsmatrix.transformPoint(ursprung),transformationsmatrix.transformDirection(normalisierteRichtung));     
        
    }
    
    
}
