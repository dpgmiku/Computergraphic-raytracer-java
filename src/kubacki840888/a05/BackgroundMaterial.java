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
public class BackgroundMaterial implements Material {

    @Override
    public Vec3 emitted(Ray r, Hit h) {
       Vec3 entscheiden;
                if (Math.round(r.normalisierteRichtung.y*50) % 2 == 0) {

                    entscheiden = new Vec3(1,1,1);

                } else {
                    entscheiden = new Vec3(0,0,0);

                }
                return entscheiden;
        }

    @Override   
    public Scattered scattered(Ray r, Hit h) {
        
    return null;    
    }
    
}
