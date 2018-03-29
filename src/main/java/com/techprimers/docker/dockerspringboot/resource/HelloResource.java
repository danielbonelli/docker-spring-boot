package com.techprimers.docker.dockerspringboot.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rest/docker")
public class HelloResource {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@GetMapping("/hello")
	public String hello() {
		return "Hello docker";
	}

    @RequestMapping(path="/greeting",method=RequestMethod.GET)
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return "hola"; //new Greeting(counter.incrementAndGet(),String.format(template, name));
    }
    
    @RequestMapping(path="/blogs")
    public @ResponseBody Iterable<String> getAllUsers() {
        List<String> result = jdbcTemplate.query(
                "SELECT * FROM blog",
                (rs, rowNum) -> rs.getString("author")
        );
       // System.out.println(jdbcTemplate);
        return result;
    }
}
