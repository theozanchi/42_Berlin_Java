package de.fortytwoberlin.swingy.model.villain;

public class VillainBuilder {
    private VillainType type;
    private int         attack;
    private int         defense;
    private int         hitPoints;

    public void setType( VillainType p_type ) { type = p_type; }
    public void setAttack( int p_attack ) { attack = p_attack; }
    public void setDefense( int p_defense ) { defense = p_defense; }
    public void setHitPoints( int p_hitPoints ) { hitPoints = p_hitPoints; }

    public Villain getResult() {
        return (new Villain(type, attack, defense, hitPoints));
    }
}
