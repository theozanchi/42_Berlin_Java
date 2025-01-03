package de.fortytwoberlin.swingy.model.hero;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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

    public Hero(HeroType p_type, String p_name, int p_level, int p_experience,
                    int p_attack, int p_defense, int p_hitPoints) {
        type = p_type;
        name = p_name;
        level = p_level;
        experience = p_experience;
        attack = p_attack;
        defense = p_defense;
        hitPoints = p_hitPoints;
    }

    public HeroType getType() { return type; }
    public String getName() { return name; }
    public int getLevel() { return level; }
    public int getExperience() { return experience; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getHitPoints() { return hitPoints; }

    public static ArrayList<Hero> loadHeroes(File file) {
        String          line;
        String[]        heroInfos;
        ArrayList<Hero> heroes = new ArrayList<Hero>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((line = reader.readLine()) != null) {
                heroInfos = line.split(",");
                heroes.add(new Hero(HeroType.valueOf(heroInfos[0]),
                                    heroInfos[1],
                                    Integer.parseInt(heroInfos[2]),
                                    Integer.parseInt(heroInfos[3]),
                                    Integer.parseInt(heroInfos[4]),
                                    Integer.parseInt(heroInfos[5]),
                                    Integer.parseInt(heroInfos[6])));
            }
            reader.close();
        } catch (Exception e) { e.getStackTrace(); }

        return (heroes);
    }

    public void saveHero(File file) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(this.getType().ordinal() + ","
                            + this.getName() + ","
                            + this.getLevel() + ","
                            + this.getExperience() + ","
                            + this.getAttack() + ","
                            + this.getHitPoints());
            writer.newLine();
            writer.close();
        } catch (Exception e) { e.getStackTrace(); } 
    }
}
