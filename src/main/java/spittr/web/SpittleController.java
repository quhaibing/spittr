package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import spittr.Spittle;
import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

	private SpittleRepository spittleRepository;

	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}

	/**
	 * 
	 * 获取所有Spittles,前台展示
	 * 
	 * 修改： 2019/05/03 添加通过查询参数获取客户端数据
	 * 
	 * 
	 * 
	 * 
	 * @param max
	 * @param count
	 * @return
	 */
	@RequestMapping(method = GET)
	public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = "0") long max,
			@RequestParam(value = "count", defaultValue = "20") int count) {
		return spittleRepository.findSpittles(max, count);
	}

	/**
	 * 
	 * 通过spittleId获取spittle
	 * 
	 * @param spittleId
	 * @return
	 */
	@RequestMapping(value = "/{spittleId}", method = GET)
	public Spittle spittle(@PathVariable("spittleId") String spittleId) {
		return spittleRepository.findOne(spittleId);
	}
}
