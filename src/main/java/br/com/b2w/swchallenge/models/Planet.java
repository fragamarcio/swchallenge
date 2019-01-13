/**
 * 
 */
package br.com.b2w.swchallenge.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Planet POJO Object.
 * 
 * @author Marcio Fraga
 *
 */
@Document
@JsonIgnoreProperties(ignoreUnknown = true)
public class Planet {

	@Id
	private ObjectId _id;
	
	private String name;
	private String climate;
	private String terrain;
	private Long filmsAmount;
	
	
	public Planet() {}

	

	/**
	 * @return the _id
	 */
	public String get_id() {
		return _id.toHexString();
	}

	/**
	 * @param _id the _id to set
	 */
	public void set_id(ObjectId _id) {
		this._id = _id;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the climate
	 */
	public String getClimate() {
		return climate;
	}



	/**
	 * @param climate the climate to set
	 */
	public void setClimate(String climate) {
		this.climate = climate;
	}



	/**
	 * @return the terrain
	 */
	public String getTerrain() {
		return terrain;
	}



	/**
	 * @param terrain the terrain to set
	 */
	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}



	/**
	 * @return the filmsAmount
	 */
	public Long getFilmsAmount() {
		return filmsAmount;
	}



	/**
	 * @param filmsAmount the filmsAmount to set
	 */
	public void setFilmsAmount(Long filmsAmount) {
		this.filmsAmount = filmsAmount;
	}

	
	
	
}
