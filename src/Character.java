import java.util.*;
import java.io.*;

public interface Character {
    String getName();
    String getJob();
    void equipAccessory(Accessory accessory);
    void calculateStats();
    Stats getStats();
    void useSkill(String skillName);

    // เพิ่มฟังก์ชันโจมตี
    void attack(Character target);
}
