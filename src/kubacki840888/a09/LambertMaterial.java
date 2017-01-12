/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a09;

import cgtools.Vec3;

/**
 *
 * @author miku
 */
public class LambertMaterial implements Material {

    public Texture albedoFarbe;

    public LambertMaterial(Texture albedoFarbe) {

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

        Vec3 scatteredNormalisierterichtung = (h.normalenvektor.normalisierung().add(randomVec));
        Ray scattered = new Ray(scatteredUrsprung, scatteredNormalisierterichtung.normalisierung());

        return new Scattered(scattered, albedoFarbe);
    }
    

}
