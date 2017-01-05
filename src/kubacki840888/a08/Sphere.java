/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a08;

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
    public Hit getHit(Ray ray) {
 
       
        double p = 2*ray.normalisierteRichtung.skalar(ray.ursprung.minus(position));
        double q = ray.ursprung.minus(position).skalar(ray.ursprung.minus(position))-Math.pow(r,2);
        double decide =Math.sqrt(Math.pow(p/2,2)-q);
        if(decide>=0)
        {
         double t= (-1)*(p/2)-decide;
         if (t>=ray.t0 && t<=ray.t1)
         {
         return new Hit(t, ray.pointAt(t), material, ray.pointAt(t).minus(position));
         }
         
         
         t=-(p/2)+decide;    
            if (t>=ray.t0&&t<=ray.t1)
         {
      
        return new Hit(t, ray.pointAt(t), material, ray.pointAt(t).minus(position));
         }    
         }
        
         return null;
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
