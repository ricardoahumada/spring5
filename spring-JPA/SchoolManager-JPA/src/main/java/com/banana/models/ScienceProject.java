package com.banana.models;

import lombok.*;

import javax.persistence.Entity;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class ScienceProject extends Project{
    String subject;
}
