/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a10;

import cgtools.Vec3;

/**
 *
 * @author miku
 */
public class Sphere implements Shape {

    public Vec3 position;
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
             Vec3 hitposition = ray.pointAt(t);
             Vec3 normal = (hitposition.minus(position)).skalar(1/r).normalisierung();
             double inclination = Math.acos(normal.y);
             double azimuth = Math.atan2(normal.x, normal.z);
             double u = (azimuth+Math.PI)/(2*Math.PI);
             double v = inclination/Math.PI;
             return new Hit(t, hitposition, material, normal, new Vec3(u,v,0));
      //   return new Hit(t, ray.pointAt(t), material, ray.pointAt(t).minus(position));
        
         }
         
         
         t=(-1)*(p/2)+decide;    
            if (t>=ray.t0&&t<=ray.t1)
         {
     
             Vec3 hitposition = ray.pointAt(t);
             Vec3 normal = (hitposition.minus(position)).skalar(1/r);
             double inclination = Math.acos(normal.y);
             double azimuth = Math.atan2(normal.x, normal.z);
             double u = (azimuth+Math.PI)/(2*Math.PI);
             double v = inclination/Math.PI;
             return new Hit(t, hitposition, material, normal, new Vec3(u,v,0));    }    
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
