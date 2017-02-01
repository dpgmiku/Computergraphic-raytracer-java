/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.b01;

import cgtools.Vec3;

/**
 *
 * @author miku
 */
public class BackgroundMaterial implements Material {
    
    Texture texture;
    
    public BackgroundMaterial(Texture texture){
        
    this.texture=texture;
    }

    @Override
    public Vec3 emitted(Ray r, Hit h) {
        
        
       Vec3 entscheiden = texture.sample(new Vec3(h.texturekoordinaten.x,h.texturekoordinaten.y,0));
      
                return entscheiden;
        }

    @Override   
    public Scattered scattered(Ray r, Hit h) {
        
    return null;    
    }
    
}
