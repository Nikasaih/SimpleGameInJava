package com.example.firstcourse.tp1.models.classe.life;


import com.example.firstcourse.tp1.models.enumerator.Personality;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Animal extends NoCharacter {

    public Animal(String name, float health, float damage, float speed, Personality personality) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.personality = personality;
    }
}
