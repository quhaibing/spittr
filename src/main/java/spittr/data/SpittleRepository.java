package spittr.data;

import java.util.List;

import spittr.Spitter;
import spittr.Spittle;

public interface SpittleRepository {

	/**
	 * 
	 * @param max
	 * @param count
	 * @return
	 */
	List<Spittle> findSpittles(long max, int count);

	Spittle findOne(String spittleId);

	void save(Spitter spitter);

	Spitter findByUsername(String username);
	
}
