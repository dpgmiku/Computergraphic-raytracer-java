/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a05;

import cgtools.Random;
import cgtools.Vec3;

/**
 *
 * @author miku
 */
public class LambertMaterial implements Material {

    Vec3 albedoFarbe;

    public LambertMaterial(Vec3 albedoFarbe) {

        this.albedoFarbe = albedoFarbe;
    }

    @Override
    public Vec3 emitted(Ray r, Hit h) {
        return new Vec3(0, 0, 0);
    }

    @Override
    public Scattered scattered(Ray r, Hit h) {
        Vec3 scatteredUrsprung = h.intersection;
        Vec3 randomVec = new Vec3(2 * cgtools.Random.random() - 1, 2 * cgtools.Random.random() - 1, 2 * cgtools.Random.random() - 1);

        Vec3 scatteredNormalisierterichtung = (h.normalenvektor.add(randomVec).normalisierung());
        Ray scattered = new Ray(scatteredUrsprung, scatteredNormalisierterichtung);

        return new Scattered(scattered, albedoFarbe, false);
    }

}
