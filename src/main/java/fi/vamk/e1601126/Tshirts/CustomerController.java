package fi.vamk.e1601126.Tshirts;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	//private static final String RequestMethod = null;
	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping("/customers")
	public Iterable<Customer> customers(){
		return customerRepository.findAll();
	}
	
	@RequestMapping("/customer/{id}")
	public Optional<Customer> getCustomer(@PathVariable("id") int id){
		return customerRepository.findById(id);
	}
	
	@RequestMapping(value = "/customer" , method = RequestMethod.POST,produces = {"application/json","application/xml"})
    public @ResponseBody Customer create(@RequestBody Customer item) {
    	return customerRepository.save(item);
} 
	
    @RequestMapping(value = "/customer" , method = RequestMethod.PUT)
    public @ResponseBody Customer update(@RequestBody Customer item) {
    	return customerRepository.save(item);
    } 
    
    @RequestMapping(value = "/customer" , method = RequestMethod.DELETE)
    public void delete(@RequestBody Customer item) {
    	customerRepository.delete(item);
        //do business logic
    } 
}
