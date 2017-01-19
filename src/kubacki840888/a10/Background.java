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
public class Background implements Shape {

    public final Material material;

    public Background(Material material) {
        this.material = material;
    }

    @Override
    public Hit getHit(Ray ray) {
        Hit hit = null;
        if (ray.t1 == Double.POSITIVE_INFINITY) {
            Vec3 hitposition = ray.pointAt(ray.t1);
            Vec3 normal = ray.normalisierteRichtung;
            double inclination = Math.acos(normal.y);
            double azimuth = Math.atan2(normal.x, normal.z);
            double u = (azimuth + Math.PI) / (2 * Math.PI);
            double v = inclination / Math.PI;
            hit = new Hit(ray.t1, hitposition, material, new Vec3(0, 0, 0), new Vec3(u, v, 0));

        }

        return hit;
    }

}
