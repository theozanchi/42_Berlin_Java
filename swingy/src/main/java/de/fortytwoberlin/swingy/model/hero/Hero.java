package de.fortytwoberlin.swingy.model.hero;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Hero {
    @NotNull
    private final HeroType type;

    @NotNull
    private final String name;

    @NotNull
    @Size(min = 1, max = 10)
    private int level;

    @NotNull
    @Size(min = 0, max = 10)
    private int experience;

    @NotNull
    @Size(min = 1, max = 10)
    private int attack;

    @NotNull
    @Size(min = 1, max = 10)
    private int defense;

    @NotNull
    @Size(min = 1, max = 5)
    private int hitPoints;

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
