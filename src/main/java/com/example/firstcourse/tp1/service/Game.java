package com.example.firstcourse.tp1.service;

import com.example.firstcourse.tp1.models.classe.item.Weapon;
import com.example.firstcourse.tp1.models.classe.life.*;
import com.example.firstcourse.tp1.models.classe.life.Character;
import com.example.firstcourse.tp1.models.enumerator.Personality;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Game {

    final String playerActionInFight = String.format("run : %s \n" +
                    "attack : %s", PlayerAction.RUN_AWAY.ordinal(),
            PlayerAction.ATTACK.ordinal());

    final static BufferedReader cmdReader = new BufferedReader(
            new InputStreamReader(System.in));

    final Character currentPlayer = new Character(true, new ArrayList<>(), "player", 100, 10, 1, Personality.PEACEFULL);

    List<NoCharacter> enemyList;
    Float bonusDmgWhenRunAwayFail = 1.1f;

    //LOGGER------------------------------------
    private static final Logger logger
            = Logger.getLogger(String.valueOf(Game.class));

    public void play() throws IOException, InterruptedException {
        enemyList = CreateNewGameEnemyList();
        Weapon sword = new Weapon(false, new ArrayList<>(), null, 10);
        logger.info("Generation d'une épee :: " + sword.toString());

        currentPlayer.EquipWeapon(sword);
        NoCharacter currentEnemy;
        while (enemyList.size() > 0 && currentPlayer.isAlive()) {
            currentEnemy = enemyList.get(0);
            playerActionWhenMeetingEnemy(currentEnemy);
        }

        if (currentPlayer.isAlive()) {
            System.out.println("Congratulation, you win");
        } else {
            System.out.println("You loose");
        }
    }

    private void playerActionWhenMeetingEnemy(NoCharacter currentEnemy) throws IOException, InterruptedException {
        AnnounceFighter(currentPlayer, currentEnemy);
        boolean isFighting = true;
        while (isFighting && currentPlayer.isAlive()) {
            printCurrentLifeOfFighter(currentPlayer, currentEnemy);
            System.out.println(playerActionInFight);
            String input = cmdReader.readLine();

            if (input.equals(Integer.toString(PlayerAction.RUN_AWAY.ordinal()))) {
                isFighting = TryRunAway(currentEnemy, isFighting);

            } else if (input.equals(Integer.toString(PlayerAction.ATTACK.ordinal()))) {
                isFighting = Fight(currentEnemy, isFighting);
            }
        }
        ClearConsoleAfterXTime(1000);
    }

    private boolean Fight(NoCharacter currentEnemy, boolean isFighting) {
        float weaponDamage = currentPlayer.getWeapons() != null ? currentPlayer.getWeapons().getDamage() : 0;

        currentEnemy.TakeDamage(currentPlayer.getDamage() + weaponDamage);
        if (!currentEnemy.isAlive()) {
            enemyList.remove(currentEnemy);
            return false;
        }
        currentPlayer.TakeDamage(currentEnemy.getDamage());
        return isFighting;
    }

    private boolean TryRunAway(NoCharacter currentEnemy, boolean isFighting) {
        if (canPlayerRunAway(currentPlayer.getSpeed(), currentEnemy.getSpeed())) {
            enemyList.remove(currentEnemy);
            isFighting = false;
        } else {
            currentPlayer.TakeDamage(currentEnemy.getDamage() * bonusDmgWhenRunAwayFail);
        }
        return isFighting;
    }

    public boolean canPlayerRunAway(float playerSpeed, float currentEnemySpeed) {
        return playerSpeed > currentEnemySpeed;
    }

    private List<NoCharacter> CreateNewGameEnemyList() {
        Animal wolf = new Animal("wolf", 10, 5, 0, Personality.AGGRESSIV);
        Animal lion = new Animal("Lion", 20, 10, 0, Personality.AGGRESSIV);
        NatureElement fire = new NatureElement("Fire Monster", 30, 50, 10, Personality.AGGRESSIV);

        List<NoCharacter> enemyList = new ArrayList<>();
        enemyList.add(wolf);
        enemyList.add(lion);
        enemyList.add(fire);
        logger.info("Generation des enemies :: " + String.join(", ", enemyList.toString()));
        return enemyList;
    }

    private void ClearConsoleAfterXTime(float time) {
        //TODO clear console after X time
        System.out.println("\n----------------------------------\n");
    }

    private void AnnounceFighter(LivingBeing fighter1, LivingBeing fighter2) {
        System.out.println(
                String.format("%s meet %s \n", fighter1.getName(), fighter2.getName()));
    }

    private void printCurrentLifeOfFighter(LivingBeing fighter1, LivingBeing fighter2) {
        System.out.println(
                String.format(
                        "%s with %s hp\n" +
                                "%s with %s hp\n",
                        fighter1.getName(), fighter1.getHealth(), fighter2.getName(), fighter2.getHealth()));
    }
}
