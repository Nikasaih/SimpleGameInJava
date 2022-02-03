package com.example.firstcourse.tp1.models.classe.other;

import com.example.firstcourse.tp1.models.enumerator.Personality;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class Effect {
    protected String description;
    protected float damage;
    protected float duration;
    protected List<Personality> toto = new ArrayList<>();

}
