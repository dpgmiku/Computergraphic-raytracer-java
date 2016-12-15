/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a07;

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
    
    public Hit(double t, Vec3 intersection, Material material, Vec3 normalenvektor){
        this.t =t;
        this.intersection=intersection;
        this.material=material;       
        this.normalenvektor=normalenvektor;
        
    }
    
    
    
}
