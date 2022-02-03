package com.example.firstcourse.tp1.models.classe.item;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Consumable extends Item {
    protected float healing;
}
