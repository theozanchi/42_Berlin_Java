package main.java.de.fortytwoberlin.coordinates;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates( int longitude, int latitude, int height ) {
        this.longitude = Math.max(0,longitude);
        this.latitude = Math.max(0,latitude);
        this.height = Math.min(100, Math.max(0, height));
    }

    public int  getLongitude( ) { return (longitude); }
    public int  getLatitude( ) { return (latitude); }
    public int  getHeight( ) { return ( height ); }

    public void  updateLongitude( int incr ) {
        longitude = Math.max(0, longitude + incr);
    }
    public void  updateLatitude( int incr ) {
        latitude = Math.max(0, latitude + incr);
    }
    public void  updateHeight( int incr ) {
        height = Math.min(100, Math.max(0, height + incr));
    }
}
