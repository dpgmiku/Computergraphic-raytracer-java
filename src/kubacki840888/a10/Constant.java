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
public class Constant implements Texture {
    Vec3 color;
    public Constant(Vec3 color){
    this.color=color;    
       }

    public Vec3 sample(Vec3 uv) {
        return color;
    }
    
}
