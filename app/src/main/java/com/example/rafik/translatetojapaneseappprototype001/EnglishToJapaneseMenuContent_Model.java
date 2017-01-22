package com.example.rafik.translatetojapaneseappprototype001;

public class EnglishToJapaneseMenuContent_Model {

    public int _id;
    public int _translation_id;
    public String english_sentence;
    public String japanese_sentence;
    public String english_expression;
    public String description;
    public String specification;
    public int active;
    public String created_at;
    public String updated_at;

    public EnglishToJapaneseMenuContent_Model(){}

    public EnglishToJapaneseMenuContent_Model(int _id, int _translation_id, String english_sentence, String japanese_sentence, String english_expression, String description, String specification, int active) {
        this._id = _id;
        this._translation_id = _translation_id;
        this.english_sentence = english_sentence;
        this.japanese_sentence = japanese_sentence;
        this.english_expression = english_expression;
        this.description = description;
        this.specification = specification;
        this.active = active;
    }

    public int get_id() {
        return _id;
    }

    public int get_translation_id() {
        return _translation_id;
    }

    public String getEnglish_sentence() {
        return english_sentence;
    }

    public String getJapanese_sentence() {
        return japanese_sentence;
    }

    public String getEnglish_expression() {
        return english_expression;
    }

    public String getDescription() {
        return description;
    }

    public String getSpecification() {
        return specification;
    }

    public int getActive() {
        return active;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }


    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_translation_id(int _translation_id) {
        this._translation_id = _translation_id;
    }

    public void setEnglish_sentence(String english_sentence) {
        this.english_sentence = english_sentence;
    }

    public void setJapanese_sentence(String japanese_sentence) {
        this.japanese_sentence = japanese_sentence;
    }

    public void setEnglish_expression(String english_expression) {
        this.english_expression = english_expression;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
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
