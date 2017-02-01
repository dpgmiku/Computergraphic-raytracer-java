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
class Hit {
    
    public  Vec3 intersection;
    public  double t;
    public  Material material;
    public  Vec3 normalenvektor;
    public Vec3 texturekoordinaten;
    
    public Hit(double t, Vec3 intersection, Material material, Vec3 normalenvektor, Vec3 texturekoordinaten){
        this.t =t;
        this.intersection=intersection;
        this.material=material;       
        this.normalenvektor=normalenvektor.normalisierung();
        this.texturekoordinaten=texturekoordinaten;
        
    }
    
    
    
}
