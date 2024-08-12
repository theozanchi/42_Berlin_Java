package de.fortytwoberlin.swingy.model.hero;

public class Hero {
    private final   HeroType    type;
    private final   String      name;
    private         int         level;
    private         int         experience;
    private         int         attack;
    private         int         defense;
    private         int         hitPoints;

    public Hero( HeroType p_type, String p_name, int p_level, int p_experience,
                    int p_attack, int p_defense, int p_hitPoints ) {
        type = p_type;
        name = p_name;
        level = p_level;
        experience = p_experience;
        attack = p_attack;
        defense = p_defense;
        hitPoints = p_hitPoints;
    }

    public HeroType getType( ) { return type; }
    public String getName( ) { return name; }
    public int getLevel( ) { return level; }
    public int getExperience( ) { return experience; }
    public int getAttack( ) { return attack; }
    public int getDefense( ) { return defense; }
    public int getHitPoints( ) { return hitPoints; }
}
