package kubacki840888.b01;

import cgtools.Vec3;
import java.util.ArrayList;
import cgtools.Image;

public class MyThread extends Thread {

    Image image;
    int start, finish;
    Kamera kamera;
    Group group;
    int scanrate;
    Scene scene;

    public MyThread(int start, int finish, Kamera kamera, Group group, int scanrate, Scene scene) {
        this.start = start;
        this.finish = finish;
        this.kamera = kamera;
        this.group = group;
        this.scanrate = scanrate;
        this.scene = scene;
        System.out.println(this.start + " - " + this.finish + " : " + this.getName());
    }

    public void run() {
        image = scene.raytrace(kamera, group, scanrate, start, finish);
        System.out.println(this.getName() + " finished");
    }

}
