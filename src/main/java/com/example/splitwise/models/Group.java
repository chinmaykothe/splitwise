package com.example.splitwise.models;

import ch.qos.logback.core.encoder.ByteArrayUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Table(name = "expense_groups")
public class Group extends  BaseModel{
    private String name;

    @ManyToOne
    private User createdBy;

    @ManyToMany
    private List<User> members = new ArrayList<>();
    @ManyToMany
    private List<User> admin = new ArrayList<>();

}
