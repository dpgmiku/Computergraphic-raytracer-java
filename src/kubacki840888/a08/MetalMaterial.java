/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a08;

import cgtools.Vec3;

/**
 *
 * @author miku
 */
public class MetalMaterial implements Material {

    Vec3 albedoFarbe;
    double streuungsfaktor;

    public MetalMaterial(Vec3 albedoFarbe, double streuungsfaktor) {

        this.albedoFarbe = albedoFarbe;
        this.streuungsfaktor = streuungsfaktor;
    }

    @Override
    public Vec3 emitted(Ray r, Hit h) {
        return new Vec3(0, 0, 0);
    }

    @Override
    public Scattered scattered(Ray r, Hit h) {
        Vec3 x = h.intersection;
        Vec3 strahlrichtung = r.normalisierteRichtung;
        Vec3 normalenvektor = h.normalenvektor;
        //Vec3 reflexionsrichtung = strahlrichtung.minus((normalenvektor.elementaryMultiply(strahlrichtung)).skalar(2).elementaryMultiply(normalenvektor));
        Vec3 reflexionsrichtung = strahlrichtung.minus(normalenvektor.skalar(2 * (normalenvektor.skalar(strahlrichtung))));

        Vec3 randomVec = new Vec3(2 * cgtools.Random.random() - 1, 2 * cgtools.Random.random() - 1, 2 * cgtools.Random.random() - 1);
        Vec3 addRanVec = reflexionsrichtung.normalisierung().add(randomVec);
        Vec3 scatteredRichtung = reflexionsrichtung.add(addRanVec.skalar(streuungsfaktor));
                Ray scattered = new Ray(x, scatteredRichtung);
        if (scatteredRichtung.skalar(normalenvektor) < 0) {
            return null;
        }
//    while(scatteredRichtung.skalar(normalenvektor)<0){
//         randomVec = new Vec3(2 * cgtools.Random.random() - 1, 2 * cgtools.Random.random() - 1, 2 * cgtools.Random.random() - 1);
//        addRanVec = reflexionsrichtung.normalisierung().add(randomVec);
//        scatteredRichtung = reflexionsrichtung.add(addRanVec.skalar(streuungsfaktor));
//  
//                 scattered = new Ray(h.intersection, scatteredRichtung);
//
//        
//        
//    }   



        return new Scattered(scattered, albedoFarbe);

    }

}
