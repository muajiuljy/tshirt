package fi.vamk.e1601126.Tshirts;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	// private static final String RequestMethod = null;
	@Autowired
	private OrderRepository orderRepository;

	@RequestMapping("/orders")
	public Iterable<Order> orders() {
		return orderRepository.findAll();
	}

	@RequestMapping("/order/{id}")
	public Optional<Order> getOrder(@PathVariable("id") int id) {
		return orderRepository.findById(id);
	}

	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public @ResponseBody Order create(@RequestBody Order item) {
		return orderRepository.save(item);
	}

	@RequestMapping(value = "/order", method = RequestMethod.PUT)
	public @ResponseBody Order update(@RequestBody Order item) {
		return orderRepository.save(item);
	}

	@RequestMapping(value = "/order", method = RequestMethod.DELETE)
	public void delete(@RequestBody Order item) {
		orderRepository.delete(item);
		// do business logic
	}
}
