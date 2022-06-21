package com.example.todolistsound29032022.data.model;

import com.example.todolistsound29032022.data.enums.PriorityColorEnum;

public class Todo {
    private int id;
    private String title;
    private String description;
    private long createTime;
    private long deadlineTime;
    private String imagePath;
    private String voicePath;
    private PriorityColorEnum priorityColor;

    public Todo(int id, String title, String description, long createTime, long deadlineTime, String imagePath, String voicePath, PriorityColorEnum priorityColor) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createTime = createTime;
        this.deadlineTime = deadlineTime;
        this.imagePath = imagePath;
        this.voicePath = voicePath;
        this.priorityColor = priorityColor;
    }

    public Todo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getDeadlineTime() {
        return deadlineTime;
    }

    public void setDeadlineTime(long deadlineTime) {
        this.deadlineTime = deadlineTime;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getVoicePath() {
        return voicePath;
    }

    public void setVoicePath(String voicePath) {
        this.voicePath = voicePath;
    }

    public PriorityColorEnum getPriorityColor() {
        return priorityColor;
    }

    public void setPriorityColor(PriorityColorEnum priorityColor) {
        this.priorityColor = priorityColor;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", deadlineTime=" + deadlineTime +
                ", imagePath='" + imagePath + '\'' +
                ", voicePath='" + voicePath + '\'' +
                ", priorityColor=" + priorityColor +
                '}';
    }
}
