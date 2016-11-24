/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a05;

import cgtools.Vec3;
/**
 *
 * @author miku
 */
public class Background implements Shape {
    
    public final Material material;

      static final Vec3 SCHWARZ = new Vec3(0, 0, 0);
    static final Vec3 WHITE = new Vec3(1, 1, 1);
    
    public Background(Material material){
     this. material=material;  
    }
    
    
    @Override
    public Hit getHit(Ray ray) {
        
        
                
       return new Hit(Double.POSITIVE_INFINITY, new Vec3(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY), material, null);         
    }

    
    
    
        
        
        
    }
    

    

