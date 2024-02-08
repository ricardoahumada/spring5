package com.banana.models;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    private Long id;
    private String street;
    private School escuela;
}
