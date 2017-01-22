package com.example.rafik.translatetojapaneseappprototype001;

public class EnglishToJapaneseMenu_Model {

    public int _id;
    public String english_sentence;
    public int variation;
    public int active;
    public String created_at;
    public String updated_at;

    public EnglishToJapaneseMenu_Model(int _id, String english_sentence, int variation, int active) {
        this._id = _id;
        this.english_sentence = english_sentence;
        this.variation = variation;
        this.active = active;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public int get_id() {
        return _id;
    }

    public String getEnglish_sentence() {
        return english_sentence;
    }

    public int getVariation() {
        return variation;
    }

    public int getActive() {
        return active;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void setEnglish_sentence(String english_sentence) {
        this.english_sentence = english_sentence;
    }

    public void setVariation(int variation) {
        this.variation = variation;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
