import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Archer implements Character {
    private String name;
    private Stats stats;
    private List<Accessory> equippedAccessories;

    public Archer(String name) {
        this.name = name;
        this.stats = new Stats(90, 12, 6, 5); // ตัวอย่างสถิติฐาน
        this.equippedAccessories = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getJob() {
        return "Archer";
    }

    @Override
    public void equipAccessory(Accessory accessory) {
        equippedAccessories.add(accessory);
    }

    @Override
    public void calculateStats() {
        int totalMovementBonus = 0;

        // คำนวณค่าทุกอย่างและความเร็วการเคลื่อนที่
        for (Accessory accessory : equippedAccessories) {
            stats.setHp(stats.getHp() + accessory.getHpBonus());
            stats.setAttack(stats.getAttack() + accessory.getAttackBonus());
            stats.setDefense(stats.getDefense() + accessory.getDefenseBonus());

            if (accessory instanceof Boots) {
                totalMovementBonus += accessory.getMovementBonus();
            } else {
                totalMovementBonus -= 1; // ลดความเร็วการเคลื่อนที่จากอุปกรณ์อื่น
            }
        }

        stats.setMovement(stats.getMovement() + totalMovementBonus);
    }

    @Override
    public Stats getStats() {
        return stats;
    }

    @Override
    public void useSkill(String skillName) {
        if (skillName.equals("FeelTheSun")) {
            System.out.println(name + " ใช้สกิล 'Feel the Sun'! เพิ่มพลังโจมตีชั่วคราว.");
            stats.setAttack(stats.getAttack() + 10); // เพิ่มพลังโจมตี
        } else {
            System.out.println("ไม่พบสกิลนี้.");
        }
    }

    // การโจมตี
    @Override
    public void attack(Character target) {
        int damage = stats.getAttack() - target.getStats().getDefense();
        if (damage > 0) {
            int targetHp = target.getStats().getHp();
            target.getStats().setHp(targetHp - damage);
            System.out.println(name + " โจมตี " + target.getName() + " ด้วยความเสียหาย " + damage + "!");
        } else {
            System.out.println(name + " โจมตี " + target.getName() + " แต่ไม่สามารถทำความเสียหายได้!");
        }
    }
}
