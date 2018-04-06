package com.company.javapractice.Media;

public class VideoClip extends MP3 {
    private int videoWidth;
    private int videoHeight;

    public VideoClip(String performer, String album, String title, int length, int videoWidth, int videoHeight) {
        super(performer, album, title, length);
        this.videoWidth = videoWidth;
        this.videoHeight = videoHeight;
    }

    public int getVideoWidth() {
        return videoWidth;
    }

    public void setVideoWidth(int videoWidth) {
        this.videoWidth = videoWidth;
    }

    public int getVideoHeight() {
        return videoHeight;
    }

    public void setVideoHeight(int videoHeight) {
        this.videoHeight = videoHeight;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Video clip dimensions: " + videoWidth + " width : " +
                videoHeight + " height. ";
    }
}
