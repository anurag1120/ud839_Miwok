package com.example.android.miwok;

public class Word {
    private String miwok;
    private String english;
    //Instead of storing image if we save image's resource id memory will be saved
    private int ImageResourceId;
    private int AudioResourceId;
    public Word(String english,String miwok,int imageResourceId,int audioResourceId){
        this.miwok=miwok;
        this.english=english;
        this.AudioResourceId=audioResourceId;
        this.ImageResourceId=imageResourceId;
    }
    public Word(String english,String miwok,int audioResourceId){
        this.miwok=miwok;
        this.english=english;
        this.AudioResourceId=audioResourceId;
        this.ImageResourceId=-1;
    }
    public String getDefaultTranslation(){
        return english;
    }
    public  String getMiwokTranslation(){
        return miwok;
    }
    public int getImageResourceId() {
        return ImageResourceId;
    }
    public int getAudioResourceId(){ return AudioResourceId;}
}
