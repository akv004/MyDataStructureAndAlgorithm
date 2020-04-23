package my.aws.topratedmovies;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
import java.util.TreeSet;

public class TopRatedMoviesInTheNetworkOfMovies {
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	// RETURN AN EMPTY SET IF NO SIMILAR MOVIE TO THE GIVEN MOVIE IS FOUND
	
	public static void main(String args[]){
		
		Set<Movie> set = getMovieRecommendations( new Movie(1, 12), 1);
		System.out.println(set);
	}
	
	public static Set<Movie>  getMovieRecommendations(Movie movie, int N) {
        if (movie == null)
        	return null;
        
        LinkedList<Movie> queue = new LinkedList<Movie>();
        HashSet<Movie> hashset = new HashSet<Movie>();
        
        // Local class for TreeSet to compare Movies by rating
    	class MovieComparatorByRating implements Comparator<Movie> {
    		public int compare(Movie o1, Movie o2) {
    			return (o2.rating - o1.rating) > 0 ? 1:-1;
    		}
    	}
    	
        // heap to keep the n top rated movies
        TreeSet<Movie> heap = new TreeSet<Movie>(new MovieComparatorByRating());
        
        queue.addAll(movie.similarMovies);
        hashset.addAll(movie.similarMovies);
        heap.addAll(movie.similarMovies);
        while (heap.size() > N)
        	heap.pollLast();
        
        while (!queue.isEmpty()) {
        	Movie m = queue.poll();
        	for (Movie mm : m.similarMovies) {
        		if (!hashset.contains(mm)) {
        			queue.add(mm);
        			hashset.add(mm);
        			heap.add(mm);
        			
        	        while (heap.size() > N)
        	        	heap.pollLast();
        		}
        	}
        }
        
        
        // Convert tree to a list structure and return 
        // O(n), where n=numTopRatedSimilarMovies
        List<Movie> list = new ArrayList<Movie>(N);
        for (Movie m : heap)
            list.add(m);
        Set<Movie> set = new HashSet<Movie>(list);
        return set;
    
	}

}

class Movie {    
    public final int movieId;
    public final float rating;
    public List<Movie> similarMovies; // Similarity is bidirectional
 
    public Movie(int movieId, float rating) {
        this.movieId = movieId;
        this.rating = rating;
        similarMovies = new ArrayList<Movie>();
    }
 
    public int getId() {
        return movieId;
    }
 
    public float getRating() {
        return rating;
    }
 
    public void addSimilarMovie(Movie movie) {
        similarMovies.add(movie);
        movie.similarMovies.add(this);
    }
 
    public List<Movie> getSimilarMovies() {
        return similarMovies;
    }
    
      @Override
    public boolean equals(Object obj) {
    	if (this == obj)
    		return true;
    	if (obj instanceof Movie) {
    		// Assuming the movie id is unique
    		if (this.movieId == ((Movie)obj).movieId)
    			return true;
    	}
		return false;
    }
    
    @Override
    public int hashCode() {
    	// Randomly picking the hashcode
    	int idHash = 17 * this.movieId;
    	int ratingHash = 13 * (int)this.rating;
    	return idHash + ratingHash;
    }
    
}