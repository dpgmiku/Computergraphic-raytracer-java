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
class Hit {
    
    public final Vec3 intersection;
    public final double t;
    public final Material material;
    public final Vec3 normalenvektor;
    
    public Hit(double t, Vec3 intersection, Material material, Vec3 normalenvektor){
        this.t =t;
        this.intersection=intersection;
        this.material=material;       
        this.normalenvektor=normalenvektor;
        
    }
    
    
    
}
