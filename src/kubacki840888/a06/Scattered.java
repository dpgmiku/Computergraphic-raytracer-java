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
class Scattered {
public final boolean absorbed;
public final Ray scattered;
public final Vec3 albedo;

public Scattered(Ray scattered, Vec3 albedo, boolean absorbed){
this.scattered=scattered;
this.albedo=albedo;
this.absorbed=absorbed;
    
}
    
}
