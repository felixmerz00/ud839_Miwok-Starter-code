package com.example.android.miwok;

// Represents one Word

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private int mAudioResourceId;

    // Constant value that represents no image was provided for this word
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String defaultTranslation, String miwokTranslation, int audioId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioId;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imgId, int audioId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imgId;
        mAudioResourceId = audioId;
    }

    public String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public void setDefaultTranslation(String defaultTranslation){
        mDefaultTranslation = defaultTranslation;
    }

    public String getMiwokTranslation(){ return mMiwokTranslation;
    }

    public void setMiwokTranslation(String miwokTranslation) {
        miwokTranslation = mMiwokTranslation;
    }

    public int getImageResourceId() {return mImageResourceId;}

    //Returns whether or not there is an image for this word.
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    public int getAudioResourceId() {return mAudioResourceId;}

    //Returns the string representation of the Word object.
    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }
}
