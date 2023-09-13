package com.example.practice.DTO;

public class ItemDTO {
    private String name;
    private String description;
    private String quality;

    public ItemDTO() {
    }

    public ItemDTO(String name, String description, String quality){
        this.name = name;
        this.description = description;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}
