import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public interface Accessory {
    int getHpBonus();
    int getAttackBonus();
    int getDefenseBonus();
    int getMovementBonus();
}
