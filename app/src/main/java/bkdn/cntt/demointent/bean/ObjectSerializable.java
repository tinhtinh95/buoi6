package bkdn.cntt.demointent.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 09/03/2017.
 */

public class ObjectSerializable implements Serializable{

   private float a;
    private float b;

    public ObjectSerializable(float a, float b) {
        this.b = b;
        this.a = a;
    }

    public float getA() {

        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }
}
