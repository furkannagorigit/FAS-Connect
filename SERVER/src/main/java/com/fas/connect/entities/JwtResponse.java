package com.fas.connect.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@AllArgsConstructor
public class JwtResponse {
    private final String token;
}