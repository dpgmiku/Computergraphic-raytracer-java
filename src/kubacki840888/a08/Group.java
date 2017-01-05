/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a08;

import cgtools.Mat4;

/**
 *
 * @author miku
 */
public class Group implements Shape {

    Shape[] shapes;
    Transform transform;

    public Group(Shape[] shapes, Transform transform) {
        this.shapes = shapes;
        this.transform = transform;
    }

    @Override
    public Hit getHit(Ray ray){
        Mat4 transformToWorld = transform.transformation;
        Mat4 transformToLocal = transform.inversion;
        Mat4 transformToLocalTransposed = transformToLocal.transpose();
        ray = new Ray(transformToWorld.transformPoint(ray.ursprung), transformToWorld.transformDirection(ray.normalisierteRichtung));

        Hit hit = null;
        double min = Double.POSITIVE_INFINITY;
        for (Shape shape : shapes) {
                if (shape.getHit(ray) != null && shape.getHit(ray).t <= min) {
                    min = shape.getHit(ray).t;
                    hit = shape.getHit(ray);

                
            }
        }
        if (hit!=null){
                
         hit.intersection=transformToLocal.transformPoint(hit.intersection);
         hit.normalenvektor=transformToLocalTransposed.transformDirection(hit.normalenvektor);
         
            
        }
        return hit;
    }

}
