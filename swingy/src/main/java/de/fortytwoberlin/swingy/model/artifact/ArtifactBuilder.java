package de.fortytwoberlin.swingy.model.artifact;

public class ArtifactBuilder {
    private ArtifactType    type;
    private int             attack;
    private int             defense;
    private int             hitPoints;

    public void setType( ArtifactType p_type ) { type = p_type; }
    public void setAttack( int p_attack ) { attack = p_attack; }
    public void setDefense( int p_defense ) { defense = p_defense; }
    public void setHitPoints( int p_hitPoints ) { hitPoints = p_hitPoints; }

    public Artifact build() {
        return (new Artifact(type, attack, defense, hitPoints));
    }
}
