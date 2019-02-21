package com.jonat.emi.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Article implements Parcelable {
    private String title;
    private String excerpt;
    public boolean highlight;
    private String imageUrl;
    private int commentsNumber;
    public boolean read;

    public Article(String title, String excerpt, boolean highlight, String imageUrl, int commentsNumber) {
        this.title = title;
        this.excerpt = excerpt;
        this.highlight = highlight;
        this.imageUrl = imageUrl;
        this.commentsNumber = commentsNumber;
        this.read = false;
    }


    public boolean isHighlight() {
        return highlight;
    }

    public boolean isRead() {
        return read;
    }

    public int getCommentsNumber() {
        return commentsNumber;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }



    public void setCommentsNumber(int commentsNumber) {
        this.commentsNumber = commentsNumber;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    protected Article(Parcel in) {
        title = in.readString();
        excerpt = in.readString();
        highlight = in.readByte() != 0;
        imageUrl = in.readString();
        commentsNumber = in.readInt();
        read = in.readByte() != 0;
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(excerpt);
        dest.writeByte((byte) (highlight ? 1 : 0));
        dest.writeString(imageUrl);
        dest.writeInt(commentsNumber);
        dest.writeByte((byte) (read ? 1 : 0));
    }
}
