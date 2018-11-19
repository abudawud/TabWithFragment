package project.envoss.com.calculatorbalok.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xkill on 14/11/18.
 */

public class DataMahasiswa implements Parcelable {
    private String nama;
    private String tLahir;
    private Double ipk;
    private Integer usia;

    public DataMahasiswa() {
    }

    public String getNama() {
        return nama;
    }

    public String gettLahir() {
        return tLahir;
    }

    public Double getIpk() {
        return ipk;
    }

    public Integer getUsia() {
        return usia;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void settLahir(String tLahir) {
        this.tLahir = tLahir;
    }

    public void setIpk(Double ipk) {
        this.ipk = ipk;
    }

    public void setUsia(Integer usia) {
        this.usia = usia;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.tLahir);
        dest.writeValue(this.ipk);
        dest.writeValue(this.usia);
    }

    protected DataMahasiswa(Parcel in) {
        this.nama = in.readString();
        this.tLahir = in.readString();
        this.ipk = (Double) in.readValue(Double.class.getClassLoader());
        this.usia = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<DataMahasiswa> CREATOR = new Parcelable.Creator<DataMahasiswa>() {
        @Override
        public DataMahasiswa createFromParcel(Parcel source) {
            return new DataMahasiswa(source);
        }

        @Override
        public DataMahasiswa[] newArray(int size) {
            return new DataMahasiswa[size];
        }
    };
}
