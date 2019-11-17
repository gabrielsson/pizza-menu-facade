package com.gabrielsson.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
public class Pizza {
    private String name;
    private List<Ingredient> ingredients;

}
