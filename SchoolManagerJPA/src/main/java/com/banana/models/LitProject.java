package com.banana.models;

import lombok.*;

import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class LitProject extends Project {
    LocalDate fecha;
}
