public class Shield implements Accessory {
    private int hpBonus;
    private int attackBonus;
    private int defenseBonus;
    private int movementBonus;

    public Shield(int hpBonus, int attackBonus, int defenseBonus, int movementBonus) {
        this.hpBonus = hpBonus;
        this.attackBonus = attackBonus;
        this.defenseBonus = defenseBonus;
        this.movementBonus = movementBonus;
    }

    @Override
    public int getHpBonus() {
        return hpBonus;
    }

    @Override
    public int getAttackBonus() {
        return attackBonus;
    }

    @Override
    public int getDefenseBonus() {
        return defenseBonus;
    }

    @Override
    public int getMovementBonus() {
        return movementBonus;
    }
}
