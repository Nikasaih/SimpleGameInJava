package com.example.firstcourse.tp1.classe.life;

import com.example.firstcourse.tp1.classe.item.Equipable;
import com.example.firstcourse.tp1.classe.item.Item;
import com.example.firstcourse.tp1.enumerator.Personality;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class Character extends LivingBeing {
    protected boolean principalOrNot;
    protected List<Item> items;
    protected Equipable armors;
    protected Equipable weapons;

    public Character(boolean principalOrNot, List<Item> items, String name, float health, float damage, float speed, Personality personality) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.speed = speed;
        this.personality = personality;
    }

    public void EquipeArmor(Equipable newArmor) {
        armors = newArmor;
    }

    public void EquipWeapon(Equipable weapons) {
        this.weapons = weapons;
    }
}
