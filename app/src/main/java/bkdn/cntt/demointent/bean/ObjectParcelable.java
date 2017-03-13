package bkdn.cntt.demointent.bean;


import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by Administrator on 09/03/2017.
 */

public class ObjectParcelable implements Parcelable {
    private float a;
    private float b;

    protected ObjectParcelable(Parcel in) {
        a = in.readFloat();
        b = in.readFloat();
    }

    public ObjectParcelable(float a, float b) {
        this.b = b;
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public static final Creator<ObjectParcelable> CREATOR = new Creator<ObjectParcelable>() {
        @Override
        public ObjectParcelable createFromParcel(Parcel in) {
            return new ObjectParcelable(in);
        }

        @Override
        public ObjectParcelable[] newArray(int size) {
            return new ObjectParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(a);
        dest.writeFloat(b);
    }
}
