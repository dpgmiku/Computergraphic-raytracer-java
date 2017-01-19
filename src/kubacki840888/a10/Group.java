/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a10;

import cgtools.Mat4;
import cgtools.Vec3;
import java.util.ArrayList;

/**
 *
 * @author miku
 */
public class Group implements Shape {

    public Shape[] shapes;
    public Transform transform;

    public Group(Shape[] shapes, Transform transform, ArrayList<LightSource> lights) {
        this.shapes = shapes;
        this.transform = transform;

    }

    @Override
    public Hit getHit(Ray ray) {
        Mat4 transformToWorld = transform.original;
        Mat4 transformToLocal = transform.inversion;
        Mat4 transformToLocalTransposed = transformToLocal.transpose();
        Ray rayTransform = new Ray(transformToWorld.transformPoint(ray.ursprung), transformToWorld.transformDirection(ray.normalisierteRichtung), ray.t0, ray.t1);
        Hit hit = null;
        double min = Double.POSITIVE_INFINITY;
        for (Shape shape : shapes) {
            if (shape.getHit(rayTransform) != null && shape.getHit(rayTransform).t <= min) {
                min = shape.getHit(rayTransform).t;
                hit = shape.getHit(rayTransform);

            }
        }
        if (hit != null) {

            hit.intersection = transformToLocal.transformPoint(hit.intersection);
            hit.normalenvektor = transformToLocalTransposed.transformDirection(hit.normalenvektor);

        }
        return hit;
    }

    public boolean visible(Vec3 from_point, Vec3 position) {

        Ray visibility = new Ray(position, position.minus(from_point).normalisierung(), 0.00001, position.minus(from_point).laenge());
        //    System.out.println(getHit(visibility) == null);
        //System.out.println(getHit(visibility) == null);
        return getHit(visibility) == null;

    }

    private double distanceSquared(Vec3 fromPoint, Vec3 toPoint) {
        Vec3 result = fromPoint.minus(toPoint);

        return result.skalar(result);

    }
}
