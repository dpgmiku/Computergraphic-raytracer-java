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
public class MetalMaterial implements Material {

    public Texture albedoFarbe;
    public double streuungsfaktor;

    public MetalMaterial(Texture albedoFarbe, double streuungsfaktor) {

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

        //Vec3 reflexionsrichtung = strahlrichtung.minus((normalenvektor.elementaryMultiply(strahlrichtung)).skalar(2).elementaryMultiply(normalenvektor));
        Vec3 reflexionsrichtung = r.normalisierteRichtung.minus(h.normalenvektor.skalar(2
                * (h.normalenvektor.skalar(r.normalisierteRichtung))));

        Vec3 randomVec = new Vec3(2 * cgtools.Random.random() - 1, 2 * cgtools.Random.random() - 1, 2 * cgtools.Random.random() - 1);
        Vec3 addRanVec = reflexionsrichtung.normalisierung().add(randomVec);
        Vec3 scatteredRichtung = reflexionsrichtung.add(addRanVec.skalar(streuungsfaktor));
        Ray scattered = new Ray(x, scatteredRichtung, r.t0, r.t1);
//meine vermutlich falsche falsche lsg
//if(scatteredRichtung.skalar(normalenvektor) < 0) {
        //         return null;
        //      }

//    while(scatteredRichtung.skalar(h.normalenvektor)<0){
//         randomVec = new Vec3(2 * cgtools.Random.random() - 1, 2 * cgtools.Random.random() - 1, 2 * cgtools.Random.random() - 1);
//        System.out.println("randomVektor: "+randomVec.x + "," + randomVec.y + "," + randomVec.z + ",");
//         addRanVec = reflexionsrichtung.normalisierung().add(randomVec);
//                 System.out.println("addRanVec: "+addRanVec.x + "," + addRanVec.y + "," + addRanVec.z + ",");
//
//        scatteredRichtung = reflexionsrichtung.add(addRanVec.skalar(streuungsfaktor));
//        System.out.println("scatteredRichtung: "+scatteredRichtung.x + "," + scatteredRichtung.y + "," + scatteredRichtung.z + ",");
        //    System.out.println("normalenvektor: "+normalenvektor.x + "," + normalenvektor.y + "," + normalenvektor.z + ",");
        //          System.out.println("skalar: " + scatteredRichtung.skalar(normalenvektor));
//                 scattered = new Ray(x, scatteredRichtung);
//
//
//
//    }
        return new Scattered(scattered, albedoFarbe);

    }

}
