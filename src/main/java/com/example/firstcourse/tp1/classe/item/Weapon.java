package com.example.firstcourse.tp1.classe.item;

import com.example.firstcourse.tp1.classe.life.LivingBeing;
import com.example.firstcourse.tp1.classe.other.Effect;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Weapon extends Equipable {
    protected boolean isThrowable;
    protected List<LivingBeing> targetOnBonusEffect;
    protected Effect effect;
    protected List<Character> usableBy;
}
