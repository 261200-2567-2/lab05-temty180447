import java.util.Scanner;
import java.lang.Math;
import java.util.*;
import java.io.*;


public class Stats {
    private int hp;
    private int attack;
    private int defense;
    private int movement;

    public Stats(int hp, int attack, int defense, int movement) {
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.movement = movement;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getMovement() {
        return movement;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    @Override
    public String toString() {
        return "HP: " + hp + ", Attack: " + attack + ", Defense: " + defense + ", Movement: " + movement;
    }
}
