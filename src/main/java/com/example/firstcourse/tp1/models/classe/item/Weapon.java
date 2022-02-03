package com.example.firstcourse.tp1.models.classe.item;

import com.example.firstcourse.tp1.models.classe.life.LivingBeing;
import com.example.firstcourse.tp1.models.classe.other.Effect;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Weapon extends Equipable {
    protected boolean isThrowable;
    protected List<LivingBeing> targetOnBonusEffect;
    protected Effect effect;
    protected float damage;
//    protected List<Character> usableBy;

}
