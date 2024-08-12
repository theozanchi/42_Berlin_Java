package de.fortytwoberlin.swingy;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.fortytwoberlin.swingy.model.Director;
import de.fortytwoberlin.swingy.model.artifact.ArtifactBuilder;
import de.fortytwoberlin.swingy.model.hero.Hero;
import de.fortytwoberlin.swingy.model.hero.HeroBuilder;
import de.fortytwoberlin.swingy.model.hero.HeroType;
import de.fortytwoberlin.swingy.model.villain.Villain;
import de.fortytwoberlin.swingy.model.villain.VillainBuilder;
import de.fortytwoberlin.swingy.model.villain.VillainType;

public class DirectorTest {

    private Director director;
    private ArtifactBuilder artifactBuilder;
    private HeroBuilder heroBuilder;
    private VillainBuilder villainBuilder;

    @Before
    public void setUp() {
        director = new Director();
        artifactBuilder = new ArtifactBuilder();
        heroBuilder = new HeroBuilder();
        villainBuilder = new VillainBuilder();
    }

    @Test
    public void testConstructHero() {
        director.constructOtter(heroBuilder, "OtterName");
        Hero hero = heroBuilder.build();

        assertEquals(HeroType.OTTER, hero.getType());
        assertEquals("HeroName", hero.getName());
        assertEquals(1, hero.getLevel());
        assertEquals(0, hero.getExperience());
        assertEquals(9, hero.getAttack());
        assertEquals(2, hero.getDefense());
        assertEquals(5, hero.getHitPoints());
    }

    @Test
    public void testConstructBear() {
        director.constructBear(heroBuilder, "BearName");
        Hero bear = heroBuilder.build();

        assertEquals(HeroType.BEAR, bear.getType());
        assertEquals("BearName", bear.getName());
        assertEquals(1, bear.getLevel());
        assertEquals(0, bear.getExperience());
        assertEquals(4, bear.getAttack());
        assertEquals(8, bear.getDefense());
        assertEquals(3, bear.getHitPoints());
    }

    @Test
    public void testConstructCduMitglieder() {
        director.constructCduMitglieder(villainBuilder);
        Villain cduMitglieder = villainBuilder.build();

        assertEquals(VillainType.CDU_MITGLIEDER, cduMitglieder.getType());
        assertEquals(4, cduMitglieder.getAttack());
        assertEquals(4, cduMitglieder.getDefense());
        assertEquals(4, cduMitglieder.getHitPoints());
    }

    @Test
    public void testConstructFundamentalistChristian() {
        director.constructFudamentalistChristian(villainBuilder);
        Villain fundamentalistChristian = villainBuilder.build();

        assertEquals(VillainType.FUNDAMENTALIST_CHRISTIAN, fundamentalistChristian.getType());
        assertEquals(2, fundamentalistChristian.getAttack());
        assertEquals(3, fundamentalistChristian.getDefense());
        assertEquals(8, fundamentalistChristian.getHitPoints());
    }

    @Test
    public void testConstructCountrysideRelative() {
        director.constructCountrysideRelative(villainBuilder);
        Villain countrysideRelative = villainBuilder.build();

        assertEquals(VillainType.COUNTRYSIDE_RELATIVE, countrysideRelative.getType());
        assertEquals(7, countrysideRelative.getAttack());
        assertEquals(2, countrysideRelative.getDefense());
        assertEquals(4, countrysideRelative.getHitPoints());
    }
}