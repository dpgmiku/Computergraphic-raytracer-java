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
public interface LightSource{
    
LightSample sample(Group group, Vec3 fromPoint);
        
        
    
}
