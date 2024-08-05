public interface Flyable {  
    void    updateConditions();
    void    registerTower(WeatherTower weatherTower);
    long    getId();
}
