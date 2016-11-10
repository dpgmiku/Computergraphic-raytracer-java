/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a04;

import static kubacki840888.a04.Main.shapes;

/**
 *
 * @author miku
 */
public class Sphere implements Shape {

    Vec3 position;
    Vec3 farbe;
    double r;
    
    public Sphere(Vec3 position, Vec3 farbe, double r)
    {
    this.position=position;
    this.farbe=farbe;
    this.r=r;
    }

    @Override
    public Hit getHit(Ray ray){
     Vec3 d = ray.normalisierteRichtung;
     Vec3 xnull = ray.ursprung;
     double p = d.skalar(2).skalar(xnull.minus(position));
     double q = (xnull.minus(position)).skalar((xnull.minus(position)))-Math.pow(r, 2);
     double decide = Math.pow((p/2),2)-q;
     if (decide<0) return null;
     double t = -(p/2)-(Math.sqrt(decide));
     return new Hit(t,ray.pointAt(t), farbe); 
     
            
    }

   
    
        
}
