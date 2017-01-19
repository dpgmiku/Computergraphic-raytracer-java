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
public class Ray {

    public Vec3 ursprung;
    public Vec3 normalisierteRichtung;
    public double t0;
    public double t1;

    public Ray(Vec3 ursprung, Vec3 richtung, double t0, double t1) {

        this.ursprung = ursprung;
        this.normalisierteRichtung = richtung.normalisierung();
        this.t0 = t0;
        this.t1 = t1;
        //   t0=0.00001;
        //  t1=Double.POSITIVE_INFINITY;

    }

    public Vec3 pointAt(double t) {

        return ursprung.add(normalisierteRichtung.skalar(t));
    }

}
