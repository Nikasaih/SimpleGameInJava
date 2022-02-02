package com.example.firstcourse.tp1.classe.item;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Consumable extends Item {
    protected float healing;
}
