/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kubacki840888.a02;

import java.awt.Color;

/**
 *
 * @author miku
 */
public class Kreis {
    
    private int x;
    private int y;
    private Color farbe;
    private int r;
    
    
    public Kreis(int x, int y, Color farbe, int r)
    {
    this.x=x;
    this.y=y;
    this.farbe=farbe;
    this.r=r;
    }
    
    public int getX() {
        
       return x;
    }
    
    public int getY() {
        
        return y;
    }
    
    public Color getFarbe(){
        
        return farbe;
    }
    
    public int getRadius(){
        
        return r;
        
    }
    
    public void setX(int x){
        
       this.x=x; 
        
    }
    
    public void setY(int y){
        
        this.y=y;
    }
    
    public void setFarbe(int r, int g, int b){
        
        this.farbe = new Color(r,g,b);
        
        
    }
    
    
    public void setRadius(int r){
        
        this.r =r;
    }
    
}
