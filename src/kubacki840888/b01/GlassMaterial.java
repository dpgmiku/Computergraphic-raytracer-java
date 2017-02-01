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
public class GlassMaterial implements Material {

    Texture albedoMaterial;

    public GlassMaterial(Texture albedoMaterial) {
        this.albedoMaterial = albedoMaterial;
    }

    @Override
    public Vec3 emitted(Ray r, Hit h) {

        return new Vec3(0, 0, 0);
    }

    @Override
    public Scattered scattered(Ray ray, Hit h) {
        Vec3 normale = h.normalenvektor;
        double r = 1.0 / 1.5;
        double c = normale.skalar(ray.normalisierteRichtung) * (-1);

        Ray scattered = null;
        double schlick = Math.pow((1.0 - 1.5) / (1.0 + 1.5), 2);
        if (normale.skalar(ray.normalisierteRichtung) > 0) {
            normale = normale.skalar(-1);
            r = 1.5 / 1.0;
        }
        double dis = 1 - r * r * (1 - c * c);

        if (dis > 0) {
            if (schlick < cgtools.Random.random()) {
                Vec3 transmission = ray.normalisierteRichtung.skalar(r).add(normale.skalar((r * c - Math.sqrt(dis))));
                scattered = new Ray(h.intersection, transmission, ray.t0, ray.t1);

                return new Scattered(scattered, albedoMaterial);

            } else {
                Vec3 reflexion = ray.normalisierteRichtung.minus(normale.skalar(2 * (normale.skalar(ray.normalisierteRichtung))));
                scattered = new Ray(h.intersection, reflexion, ray.t0, ray.t1);

                return new Scattered(scattered, albedoMaterial);
            }

        } else {
            Vec3 reflexion = ray.normalisierteRichtung.minus(normale.skalar(2 * (normale.skalar(ray.normalisierteRichtung))));
            scattered = new Ray(h.intersection, reflexion, ray.t0, ray.t1);

            return new Scattered(scattered, albedoMaterial);
        }

    }

}
