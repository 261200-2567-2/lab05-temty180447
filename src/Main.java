import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.*;

import java.io.*;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // สร้างตัวละคร
        Character archer = new Archer("Artemis");
        Character warrior = new Warrior("Leonidas");

        // สร้างอุปกรณ์
        Accessory sword = new Sword(0, 5, 2, 0);  // ดาบ
        Accessory bow = new Bow(0, 8, 0, 0);  // ธนูเพิ่มพลังโจมตี 8
        Accessory shield = new Shield(0, 0, 5, 0);  // โล่
        Accessory boots = new Boots(0, 0, 0, 3);  // รองเท้า

        // สวมอุปกรณ์
        archer.equipAccessory(boots);
        warrior.equipAccessory(shield);
        warrior.equipAccessory(boots);
        archer.equipAccessory(bow);  // นักธนูใส่ธนู

        // คำนวณสเตตัส
        archer.calculateStats();
        warrior.calculateStats();

        //ลองสกิล



        // แสดงสเตตัส
        System.out.println(archer.getName() + " (" + archer.getJob() + "): " + archer.getStats());
        System.out.println(warrior.getName() + " (" + warrior.getJob() + "): " + warrior.getStats());

        // นักธนูโจมตีนักรบ
        archer.attack(warrior);

        // แสดงสถิติหลังการโจมตี
        System.out.println(archer.getName() + " Status: " + archer.getStats());
        System.out.println(warrior.getName() + " Status หลังโดนยิง: " + warrior.getStats());
    }
}