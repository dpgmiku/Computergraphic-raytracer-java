/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a04;

/**
 *
 * @author miku
 */
class Hit {
    
    public final Vec3 intersection;
    public final double t;
    public final Vec3 color;
    
    
    public Hit(double t, Vec3 intersection, Vec3 color){
        this.t =t;
        this.intersection=intersection;
        this.color=color;
        
        
    }
    
    
}
