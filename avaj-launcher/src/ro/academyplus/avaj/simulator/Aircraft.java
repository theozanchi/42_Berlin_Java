public abstract class Aircraft implements Flyable{
    protected   long        id;
    protected   String      name;
    protected   Coordinates coordinates;
    private     Tower       tower;

    protected Aircraft( long p_id, String p_name, Coordinates p_coordinate ) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinate;
    }

    public long         getId( ) { return (id); }
    public String       getName( ) { return (name); }
    public Coordinates  getCoordinates( ) { return (coordinates); }

    public void registerTower( WeatherTower weatherTower)  {
        this.tower = weatherTower;
        tower.register(this);
    }

    protected void land( ) {
        Logger.log(getName() + " (" + getId() + "): landing.");
        tower.unregister(this);
    }
}
