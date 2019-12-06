package com.sujan.sqlite.model;

public class Word {
    private int wordID;
    private String wordName;
    private String wordMeaning;

    public Word(int wordID, String wordName, String wordMeaning) {
        this.wordID = wordID;
        this.wordName = wordName;
        this.wordMeaning = wordMeaning;
    }

    public int getWordID() {
        return wordID;
    }

    public void setWordID(int wordID) {
        this.wordID = wordID;
    }

    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    public String getWordMeaning() {
        return wordMeaning;
    }

    public void setWordMeaning(String wordMeaning) {
        this.wordMeaning = wordMeaning;
    }
}
