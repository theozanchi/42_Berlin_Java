package de.fortytwoberlin.swingy.model.villain;

public class Villain {
    private final   VillainType type;
    private final   int         attack;
    private final   int         defense;
    private final   int         hitPoints;

    public Villain( VillainType p_type, int p_attack, int p_defense, int p_hitPoints ) {
        type = p_type;
        attack = p_attack;
        defense = p_defense;
        hitPoints = p_hitPoints;
    }

    public VillainType getType( ) { return type; }
    public int getAttack( ) { return attack; }
    public int getDefense( ) { return defense; }
    public int getHitPoints( ) { return hitPoints; }
}
