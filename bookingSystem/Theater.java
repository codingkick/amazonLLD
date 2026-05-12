package questions.bookingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Theater {
    private String name;
    private String location;
    private List<Movie> movies;
    private Map<String, Seat> seats;
    private List<Show> shows;
    public Theater(String name, String location, List<Movie> movies, Map<String, Seat> seats) {
        this.name = name;
        this.location = location;
        this.movies = movies;
        this.seats = seats;
        this.shows = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public String getLocation() {
        return location;
    }
    public List<Movie> getMovies() {
        return movies;
    }
    public Map<String, Seat> getSeats() {
        return seats;
    }
    public List<Show> getShows() {
        return shows;
    }
    public void addShow(Show show) {
        shows.add(show);
        show.setTheater(this);
    }
}
