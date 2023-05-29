package com.example.basicLayout;

import java.util.Objects;

public class IntroObject {
    private String id;
    private String name;
    private String detail;
    private String img;
    private String history;
    private int type;
    private String fromId;

    public IntroObject(String id, String name, String detail, String img, String history, int type, String fromId) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.img = img;
        this.history = history;
        this.type = type;
        this.fromId = fromId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    @Override
    public String toString() {
        return "IntroObject{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", img='" + img + '\'' +
                ", history='" + history + '\'' +
                ", type=" + type +
                ", fromId='" + fromId + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntroObject that = (IntroObject) o;
        return getType() == that.getType() && getId().equals(that.getId()) && getName().equals(that.getName()) && Objects.equals(getDetail(), that.getDetail()) && Objects.equals(getImg(), that.getImg()) && Objects.equals(getHistory(), that.getHistory()) && getFromId().equals(that.getFromId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDetail(), getImg(), getHistory(), getType(), getFromId());
    }
}