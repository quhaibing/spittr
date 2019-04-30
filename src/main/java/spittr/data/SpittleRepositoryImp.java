package spittr.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import spittr.Spittle;

@Component
public class SpittleRepositoryImp implements SpittleRepository {

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();
		spittles.add(new Spittle(1L, "A", new Date()));
		spittles.add(new Spittle(2L, "A", new Date()));
		spittles.add(new Spittle(3L, "A", new Date()));
		spittles.add(new Spittle(4L, "A", new Date()));
		spittles.add(new Spittle(5L, "A", new Date()));
		return spittles;
	}

}
