package com.example.manan.miwok;

/**
 * Created by Manan on 05-01-2017.
 */

public class Word {


    private String mMiwokTranslation;


    private String mDefaultTranslation;

    private int mImageResourceId = NO_IMAGE;

    private static final int NO_IMAGE = -1;

    private int mAusioResourceId;

    public Word(String DefaultTranslation, String MiwokTranslation, int AudioResourceId) {

        mDefaultTranslation = DefaultTranslation;

        mMiwokTranslation = MiwokTranslation;

        mAusioResourceId = AudioResourceId;
    }


    public Word(String DefaultTranslation, String MiwokTranslation, int ImageResourceId, int AudioResourceId) {

        mDefaultTranslation = DefaultTranslation;

        mMiwokTranslation = MiwokTranslation;

        mImageResourceId = ImageResourceId;

        mAusioResourceId = AudioResourceId;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE;
    }

    public int getAusioResourceId() {
        return mAusioResourceId;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAusioResourceId=" + mAusioResourceId +
                '}';
    }

}


