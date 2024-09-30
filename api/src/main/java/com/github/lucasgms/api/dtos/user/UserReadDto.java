package com.github.lucasgms.api.dtos.user;

public class UserReadDto {
    private long id;
    private String name;
    private String email;

    public UserReadDto() {}

    public UserReadDto(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
