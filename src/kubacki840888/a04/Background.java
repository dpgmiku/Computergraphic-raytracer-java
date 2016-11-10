/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a04;

import java.awt.Color;

/**
 *
 * @author miku
 */
public class Background implements Shape {

      static final Vec3 SCHWARZ = new Vec3(0, 0, 0);
    static final Vec3 WHITE = new Vec3(1, 1, 1);
    
    @Override
    public Hit getHit(Ray ray) {
        
        Vec3 entscheiden;
                if (Math.round(ray.normalisierteRichtung.y*10) % 2 == 0) {

                    entscheiden = WHITE;

                } else {
                    entscheiden = SCHWARZ;

                }
                
       return new Hit(Double.POSITIVE_INFINITY, new Vec3(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY), entscheiden);         
    }

    
    
    
        
        
        
    }
    

    

