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
public class PointLight implements LightSource {

    Vec3 position;
    Vec3 intensity;

    public PointLight(Vec3 position, Vec3 intensity) {
        this.position = position;
        this.intensity = intensity;

    }

    @Override
    public LightSample sample(Group group, Vec3 fromPoint) {
        Vec3 incident = position.minus(fromPoint).normalisierung();
        Vec3 radiance = null;

        if (group.visible(position, fromPoint)) {

            radiance = intensity.skalar(1 / distanceSquared(fromPoint, position));
            return new LightSample(radiance, incident);

        }
        return new LightSample(new Vec3(1, 1, 1), incident);
    }

    private double distanceSquared(Vec3 fromPoint, Vec3 toPoint) {
        Vec3 result = fromPoint.minus(toPoint);

        return result.skalar(result);

    }
}
