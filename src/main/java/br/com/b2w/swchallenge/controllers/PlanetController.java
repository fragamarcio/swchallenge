package br.com.b2w.swchallenge.controllers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.b2w.swchallenge.models.Planet;
import br.com.b2w.swchallenge.repositories.PlanetRepository;

@RestController
@RequestMapping("/planets")
public class PlanetController {

	private static final String HTTPS_SWAPI_PLANETS_URI = "https://swapi.co/api/planets/?search=";
	
	@Autowired
	private PlanetRepository repository;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Planet> getPlanets() {
		return repository.findAll();
	}
	

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Planet getPlanet(@PathVariable("id") String id) {
		return repository.findBy_id(new ObjectId(id));
	}
	
	@RequestMapping(value="/name/{name}", method = RequestMethod.GET)
	public Planet getPlanetByName(@PathVariable("name") String name) {
		
		return repository.findByName(name);
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Planet create(@Valid @RequestBody Planet planet) {
	  planet.set_id(ObjectId.get());
	  planet.setFilmsAmount(this.getFilmsAmount(planet.getName()));
	  repository.save(planet);
	  return planet;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void modify(@PathVariable("id") ObjectId id, @Valid @RequestBody Planet planet) {
	  planet.set_id(id);
	  repository.save(planet);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable ObjectId id) {
	  repository.delete(repository.findBy_id(id));
	}
	
	private Long getFilmsAmount(String name) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<HashMap> result = restTemplate.exchange(HTTPS_SWAPI_PLANETS_URI.concat(name), HttpMethod.GET, entity, HashMap.class );
		List resultBody = (List)result.getBody().get("results");
		
		if(resultBody.isEmpty()) {
			return 0L;
		}
		
		List films = ((List)((Map)resultBody.get(0)).get("films"));
		return new Long(films.size());
	}
    
}
