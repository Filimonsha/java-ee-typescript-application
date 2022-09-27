package com.example.itmoweb2.utility;

public class AreaHit {
    public static boolean checkAreaHit(double x,double y, double r){
        if(x >= 0 && y <= (-x/2 +r)) return true;

        else if(x >= 0 && y <= 0 && x <= (r/2) && y >= -r) return true;

        else return x <= 0 && y <= 0 && (Math.pow(y, 2) + Math.pow(x, 2)) <= Math.pow(r, 2);
    }
}
