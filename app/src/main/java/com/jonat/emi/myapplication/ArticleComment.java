package com.jonat.emi.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class ArticleComment implements Parcelable {

    private String title;
    private String excerpt;
    private boolean highlight;
    private boolean read;
    private int CommentNumber;


    public ArticleComment(String title, String exceprt, boolean highlight, boolean read, int CommentNumber){
        this.title = title;
        this.highlight = highlight;
        this.excerpt = exceprt;
        this.read = read;
        this.CommentNumber = CommentNumber;
    }

    public boolean isHighlight() {
        return highlight;
    }

    public boolean isRead() {
        return read;
    }

    public void setCommentNumber(int commentNumber) {
        CommentNumber = commentNumber;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    public void setHighlight(boolean highlight) {
        this.highlight = highlight;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExcerpt() {
        return excerpt;
    }

    public int getCommentNumber() {
        return CommentNumber;
    }

    public String getTitle() {
        return title;
    }


    protected ArticleComment(Parcel in) {
        title = in.readString();
        excerpt = in.readString();
        highlight = in.readByte() != 0;
        read = in.readByte() != 0;
        CommentNumber = in.readInt();
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
        dest.writeString(excerpt);
        dest.writeByte((byte) (highlight ? 1 : 0));
        dest.writeByte((byte) (read ? 1 : 0));
        dest.writeInt(CommentNumber);
    }
}
