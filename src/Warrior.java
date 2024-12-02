import java.util.*;
import java.io.*;
import java.math.*;

public class Warrior implements Character {
    private String name;
    private Stats stats;
    private List<Accessory> equippedAccessories;

    public Warrior(String name) {
        this.name = name;
        this.stats = new Stats(150, 20, 15, 4); // สเตตัสเริ่มต้น
        this.equippedAccessories = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getJob() {
        return "Warrior";
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
                totalMovementBonus -= 2; // ลดความเร็วการเคลื่อนที่จากอุปกรณ์อื่น
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
        if (skillName.equals("PowerStrike")) {
            System.out.println(name + " ใช้สกิล 'Power Strike'! เพิ่มพลังโจมตีอย่างมาก.");
            stats.setDefense(stats.getDefense() + 15); // เพิ่มพลังป้องกัน
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
