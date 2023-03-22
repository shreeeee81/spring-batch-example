package com.javatechie.spring.batch.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.javatechie.spring.batch.entity.Customer;
import com.javatechie.spring.batch.repository.CustomerRepository;




@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepo;
	
	
	
	
	
	
	
	public List<Customer> getAll() throws InterruptedException, ExecutionException{
		CompletableFuture<List<Customer>> cus = CompletableFuture.supplyAsync(() ->{
			return customerRepo.findAll();
			
		});
		
		return cus.get();
		
	}
	
	public List<Customer> getStreamAll(){
		List<Customer>  cus= customerRepo.findAll();
		
	   cus.parallelStream().forEach( a-> System.out.println(a.getCountry() +" "+a.getContactNo()));
	   List<Customer> str =cus.parallelStream().filter( e -> e.getGender().equals("Female")).map( Customer  -> Customer ).sorted((o1,o2) ->o1.getDob().compareToIgnoreCase(o2.getDob())).collect(Collectors.toList());
	   Customer custor = cus.parallelStream().filter( e -> e.getGender().equals("Female")).reduce((sum1,sum2) -> sum1).get();
	   System.out.println(str);
	   return cus;
		
	}
	
	
	public void storedataIntoRedis() {
		List<Customer>  cus= customerRepo.findAll();
		
		Map<String, Customer> map = cus.stream().collect(Collectors.toMap(Customer:: getContactNo, Function.identity()));
		map.entrySet().parallelStream().forEach(obj ->{
			 
		});
		
		
		
	}
	
	
	
	

}
