/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a07;

import cgtools.Mat4;

/**
 *
 * @author miku
 */
public class Transform {
public final Mat4 transformation;
public final Mat4 inversion;

public Transform(Mat4 transformation){
    this.transformation=transformation;
    this.inversion=transformation.invertFull();
    
    
}
}
