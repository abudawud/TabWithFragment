package project.envoss.com.calculatorbalok.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by xkill on 25/10/18.
 */

public class Book implements Parcelable {
    private String title;
    private String author;
    private String penerbit;
    private int tahun;

    public Book() {

    }

    public Book(String title, String author, String penerbit, int tahum){
        this.title = title;
        this.author = author;
        this.penerbit = penerbit;
        this.tahun = tahum;
    }

    public int getTahun() {
        return tahun;
    }

    public String getAuthor() {
        return author;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.author);
        dest.writeString(this.penerbit);
        dest.writeInt(this.tahun);
    }

    protected Book(Parcel in) {
        this.title = in.readString();
        this.author = in.readString();
        this.penerbit = in.readString();
        this.tahun = in.readInt();
    }

    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            return new Book(source);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };
}
