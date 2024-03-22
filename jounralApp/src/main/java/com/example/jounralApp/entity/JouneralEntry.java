package com.example.jounralApp.entity;

import lombok.Data;

@Data
public class JouneralEntry {
    private long id;
    private String title;
    private String content;

    // TODO[kuldeep][1/12/2023] Remove the getter and setter and do the alternate option for this

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
}
