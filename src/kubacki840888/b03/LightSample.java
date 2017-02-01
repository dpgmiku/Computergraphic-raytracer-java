/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.b03;

import cgtools.Vec3;

/**
 *
 * @author miku
 */
public class LightSample {

    Vec3 radiance;
    Vec3 incident;

    public LightSample(Vec3 radiance, Vec3 incident) {
        this.radiance = radiance;
        this.incident = incident;

    }

}
