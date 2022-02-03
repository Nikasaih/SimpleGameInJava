package com.example.firstcourse.tp1.models.classe.life;

import com.example.firstcourse.tp1.models.enumerator.Personality;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LivingBeing {
    protected String name;
    protected float health;
    protected float damage;
    protected float speed;
    protected Personality personality;

    public void TakeDamage(float dmg) {
        health -= dmg;
    }

    public boolean isAlive() {
        return health > 0.0f;
    }
}
