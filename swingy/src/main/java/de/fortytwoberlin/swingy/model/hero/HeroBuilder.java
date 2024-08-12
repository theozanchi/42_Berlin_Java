package de.fortytwoberlin.swingy.model.hero;

public class HeroBuilder {
    private HeroType    type;
    private String      name;
    private int         level;
    private int         experience;
    private int         attack;
    private int         defense;
    private int         hitPoints;

    public void setType( HeroType p_type ) { type = p_type; }
    public void setName( String p_name ) { name = p_name; }  
    public void setLevel( int p_level ) { level = p_level; }
    public void setExperience( int p_experience ) { experience = p_experience; }
    public void setAttack( int p_attack ) { attack = p_attack; }
    public void setDefense( int p_defense ) { defense = p_defense; }
    public void setHitPoints( int p_hitPoints ) { hitPoints = p_hitPoints; }

    public Hero getResult() {
        return (new Hero(type, name, level, experience, attack, defense, hitPoints));
    }

}
