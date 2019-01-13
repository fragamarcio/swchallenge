package br.com.b2w.swchallenge.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.b2w.swchallenge.models.Planet;

public interface PlanetRepository extends MongoRepository<Planet, String>{
	
	Planet findBy_id(ObjectId _id);
	Planet findByName(String name);

}
