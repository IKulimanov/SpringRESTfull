package ru.example.application.err;

public class ErrorClient {
    private String type;
    private String name;

    public ErrorClient(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
