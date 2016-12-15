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
public interface Material {
    Vec3 emitted(Ray r, Hit h);
    Scattered scattered(Ray r, Hit h);
    
    
}
