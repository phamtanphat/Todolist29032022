package com.example.todolistsound29032022.data.enums;

public enum PriorityColorEnum {
    HIGH ("#8d66bd"),
    DEFAULT ("#FFBB86FC");

    private String name;

    PriorityColorEnum(String s) {
        name = s;
    }

    public String getName() {
        return this.name;
    }

}
