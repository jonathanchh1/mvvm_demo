package com.jonat.emi.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class ArticleComment implements Parcelable {
    private String title;
    private boolean highlight;
    private String excerpt;
    private String imageUrl;
    private int CommentsNumber;
    private boolean read;

    public ArticleComment(String title, boolean highlight, String excerpt, String imageUrl,
                          int commentsNumber, boolean Read){
        this.title = title;
        this.highlight = highlight;
        this.excerpt = excerpt;
        this.imageUrl = imageUrl;
        this.CommentsNumber = commentsNumber;
        this.read = Read;
    }



    protected ArticleComment(Parcel in) {
        title = in.readString();
        highlight = in.readByte() != 0;
        excerpt = in.readString();
        imageUrl = in.readString();
        CommentsNumber = in.readInt();
        read = in.readByte() != 0;
    }


    public String getTitle() {
        return title;
    }

    public boolean isRead() {
        return read;
    }

    public boolean isHighlight() {
        return highlight;
    }



    public String getExcerpt() {
        return excerpt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getCommentsNumber() {
        return CommentsNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCommentsNumber(int commentsNumber) {
        CommentsNumber = commentsNumber;
    }

    public static final Creator<ArticleComment> CREATOR = new Creator<ArticleComment>() {
        @Override
        public ArticleComment createFromParcel(Parcel in) {
            return new ArticleComment(in);
        }

        @Override
        public ArticleComment[] newArray(int size) {
            return new ArticleComment[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeByte((byte) (highlight ? 1 : 0));
        dest.writeString(excerpt);
        dest.writeString(imageUrl);
        dest.writeInt(CommentsNumber);
        dest.writeByte((byte) (read ? 1 : 0));
    }
}
