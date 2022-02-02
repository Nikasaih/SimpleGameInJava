package com.example.firstcourse.tp1.program;

import com.example.firstcourse.tp1.classe.life.*;
import com.example.firstcourse.tp1.classe.life.Character;
import com.example.firstcourse.tp1.enumerator.Personality;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Game {

    final String playerActionInFight = String.format("run : %s \n" +
                    "attack : %s", PlayerAction.RUN_AWAY.ordinal(),
            PlayerAction.ATTACK.ordinal());

    final static BufferedReader cmdReader = new BufferedReader(
            new InputStreamReader(System.in));

    final Character currentPlayer = new Character(true, new ArrayList<>(), "player", 100, 10, 1, Personality.PEACEFULL);

    List<NoCharacter> enemyList;
    Float bonusDmgWhenRunAwayFail = 1.1f;

    public void play() throws IOException, InterruptedException {
        enemyList = CreateNewGameEnemyList();
        NoCharacter currentEnemy;
        while (enemyList.size() > 0 && currentPlayer.isAlive()) {
            currentEnemy = enemyList.get(0);
            playerActionWhenMeetingEnemy(currentEnemy);
        }
    }

    public void playerActionWhenMeetingEnemy(NoCharacter currentEnemy) throws IOException, InterruptedException {
        AnnouceFighter(currentPlayer, currentEnemy);
        boolean isFighting = true;
        while (isFighting && currentPlayer.isAlive()) {
            printCurrentLifeOfFighter(currentPlayer, currentEnemy);
            System.out.println(playerActionInFight);
            String input = cmdReader.readLine();

            if (input.equals(Integer.toString(PlayerAction.RUN_AWAY.ordinal()))) {
                if (canPlayerRunAway(currentPlayer.getSpeed(), currentEnemy.getSpeed())) {
                    enemyList.remove(currentEnemy);
                    isFighting = false;
                } else {
                    currentPlayer.TakeDamage(currentEnemy.getDamage() * bonusDmgWhenRunAwayFail);
                }

            } else if (input.equals(Integer.toString(PlayerAction.ATTACK.ordinal()))) {
                currentEnemy.TakeDamage(currentPlayer.getDamage());
                if (!currentEnemy.isAlive()) {
                    enemyList.remove(currentEnemy);
                    isFighting = false;
                }
                currentPlayer.TakeDamage(currentEnemy.getDamage());
            }
        }

        ClearConsoleAfterXTime(1000);
    }

    public boolean canPlayerRunAway(float playerSpeed, float currentEnemySpeed) {
        return playerSpeed > currentEnemySpeed;
    }

    public List<NoCharacter> CreateNewGameEnemyList() {
        Animal wolf = new Animal("wolf", 10, 5, 0, Personality.AGGRESSIV);
        Animal lion = new Animal("Lion", 20, 10, 0, Personality.AGGRESSIV);
        NatureElement fire = new NatureElement("Fire Monster", 30, 50, 10, Personality.AGGRESSIV);

        List<NoCharacter> enemyList = new ArrayList<>();
        enemyList.add(wolf);
        enemyList.add(lion);
        enemyList.add(fire);

        return enemyList;
    }

    public void ClearConsoleAfterXTime(float time) {
        //TODO clear console after X time
    }

    void AnnouceFighter(LivingBeing fighter1, LivingBeing fighter2) {
        System.out.println(
                String.format("%s meet %s \n", fighter1.getName(), fighter2.getName()));
    }

    void printCurrentLifeOfFighter(LivingBeing fighter1, LivingBeing fighter2) {
        System.out.println(
                String.format(
                        "%s with %s\n" +
                                "%s with %s\n",
                        fighter1.getName(), fighter1.getHealth(), fighter2.getName(), fighter2.getHealth()));
    }
}
