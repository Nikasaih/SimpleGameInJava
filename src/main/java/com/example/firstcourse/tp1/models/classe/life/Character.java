package com.example.firstcourse.tp1.models.classe.life;

import com.example.firstcourse.tp1.models.classe.item.Equipable;
import com.example.firstcourse.tp1.models.classe.item.Item;
import com.example.firstcourse.tp1.models.classe.item.Weapon;
import com.example.firstcourse.tp1.models.enumerator.Personality;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class Character extends LivingBeing {
    protected boolean principalOrNot;
    protected List<Item> items;
    protected Equipable armors;
    protected Weapon weapons;

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

    public void EquipWeapon(Weapon weapons) {
        this.weapons = weapons;
    }
}
