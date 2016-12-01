/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a06;

import cgtools.Vec3;

/**
 *
 * @author miku
 */
public class Sphere implements Shape {

    Vec3 position;
    Vec3 farbe;
    Material material;
    double r;
    
    public Sphere(Vec3 position, Material material, double r)
    {
    this.position=position;
    this.material=material;
    this.r=r;
    }
    

    
    @Override
    public Hit getHit(Ray r) {
        double t;
 
        Hit h=null;
        double p = r.normalisierteRichtung.skalar(2).skalar(r.ursprung.minus(position));
        double q = ((r.ursprung.minus(position)).skalar(r.ursprung.minus(position)))-(this.r*this.r);
        double decide =(Math.pow(p/2,2)-q);
        if(decide>=0.0)
        {
         t= -(p/2)-Math.sqrt(decide);
         if (t>=0)
         {
         h = new Hit(t, r.pointAt(t), material, r.pointAt(t).minus(position));
         }
         else
         {
         t=-(p/2)+Math.sqrt(decide);    
            if (t>=0)
         {
         h = new Hit(t, r.pointAt(t), material, r.pointAt(t).minus(position));
         }    
         }
        }
         return h;
    }
    

//    @Override
//    public Hit getHit(Ray ray){
//     Vec3 d = ray.normalisierteRichtung.normalisierung();
//     Vec3 xnull = ray.ursprung;
//     double p = 2*d.skalar(xnull.minus(position));
//     double q = (xnull.minus(position)).skalar((xnull.minus(position)))-Math.pow(r, 2);
//     double decide = Math.pow((p/2),2)-q;
//     if (decide<0) return null;
//     double t = -(p/2)-(Math.sqrt(decide));
//     return new Hit(t,ray.pointAt(t), material, ray.pointAt(t).minus(position).normalisierung()); 
//     
//            
//    }



   
    
        
}
