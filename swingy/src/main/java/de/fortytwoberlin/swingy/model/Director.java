package de.fortytwoberlin.swingy.model;

import de.fortytwoberlin.swingy.model.artifact.ArtifactBuilder;
import de.fortytwoberlin.swingy.model.artifact.ArtifactType;
import de.fortytwoberlin.swingy.model.hero.HeroBuilder;
import de.fortytwoberlin.swingy.model.hero.HeroType;
import de.fortytwoberlin.swingy.model.villain.VillainBuilder;
import de.fortytwoberlin.swingy.model.villain.VillainType;

public class Director {
    public void constructHighHeels( ArtifactBuilder builder ) {
        builder.setType(ArtifactType.HIGH_HEELS);
        builder.setAttack(10);
    }

    public void constructButtPlug( ArtifactBuilder builder ) {
        builder.setType(ArtifactType.BUTT_PLUG);
        builder.setDefense(10);
    }

    public void constructHousePlant( ArtifactBuilder builder ) {
        builder.setType(ArtifactType.HOUSE_PLANT);
        builder.setHitPoints(10);
    }

    public void constructOtter( HeroBuilder builder, String p_name ) {
        builder.setType(HeroType.OTTER);
        builder.setName(p_name);
        builder.setLevel(1);
        builder.setExperience(0);
        builder.setAttack(5);
        builder.setDefense(5);
        builder.setHitPoints(5);
    }

    public void constructTwink( HeroBuilder builder, String p_name ) {
        builder.setType(HeroType.TWINK);
        builder.setName(p_name);
        builder.setLevel(1);
        builder.setExperience(0);
        builder.setAttack(9);
        builder.setDefense(2);
        builder.setHitPoints(5);
    }

    public void constructBear( HeroBuilder builder, String p_name ) {
        builder.setType(HeroType.BEAR);
        builder.setName(p_name);
        builder.setLevel(1);
        builder.setExperience(0);
        builder.setAttack(4);
        builder.setDefense(8);
        builder.setHitPoints(3);
    }

    public void constructCduMitglieder( VillainBuilder builder ) {
        builder.setType(VillainType.CDU_MITGLIEDER);
        builder.setAttack(4);
        builder.setDefense(4);
        builder.setHitPoints(4);
    }

    public void constructFudamentalistChristian( VillainBuilder builder ) {
        builder.setType(VillainType.FUNDAMENTALIST_CHRISTIAN);
        builder.setAttack(2); //Should have light attack but repetitive
        builder.setDefense(3);
        builder.setHitPoints(8);
    }

    public void constructCountrysideRelative( VillainBuilder builder ) {
        builder.setType(VillainType.COUNTRYSIDE_RELATIVE); //Should bring emotional damage, makes the gameplay slow
        builder.setAttack(7); 
        builder.setDefense(2);
        builder.setHitPoints(4);
    }

}
