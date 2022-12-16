package com.miguelortega.clienterest.service;

import java.util.List;
import java.util.logging.Logger;

import com.miguelortega.clienterest.model.Piloto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PilotoServiceRestClientImpl implements PilotoService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public PilotoServiceRestClientImpl(RestTemplate theRestTemplate, 	@Value("${crm.rest.url}") String theUrl) {
		
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Piloto> obtenerPilotos() {
		
		logger.info("***OBTENER LISTA DE PILOTOS DESDE EL SERVICE REST CLIENTE");
		logger.info("in getPilotos(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Piloto>> responseEntity =
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
													new ParameterizedTypeReference<List<Piloto>>() {});

		// get the list of pilotos from response
		List<Piloto> pilotos = responseEntity.getBody();

		logger.info("in getPilotos(): pilotos" + pilotos);
		
		return pilotos;
	}

	@Override
	public Piloto obtenerPiloto(int theId) {
		logger.info("***OBTENER UN PILOTO DESDE EL SERVICE REST CLIENTE");

		logger.info("in getPiloto(): Calling REST API " + crmRestUrl);

		// make REST call
		Piloto thePiloto =
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
						Piloto.class);

		logger.info("in guardarPiloto(): thePiloto=" + thePiloto);
		
		return thePiloto;
	}

	@Override
	public void guardarPiloto(Piloto thePiloto) {

		logger.info("in guardarPiloto(): Calling REST API " + crmRestUrl);
		
		int pilotoId = thePiloto.getId();

		// make REST call
		if (pilotoId == 0) {
			// add employee
			logger.info("***SALVAR UN PILOTO DESDE EL SERVICE REST CLIENTE");

			restTemplate.postForEntity(crmRestUrl, thePiloto, String.class);
		
		} else {
			// update employee
			logger.info("***ACTUALIZAR UN PILOTO DESDE EL SERVICE REST CLIENTE");

			restTemplate.put(crmRestUrl, thePiloto);
		}

		logger.info("in guardarPiloto(): success");
	}

	@Override
	public void eliminarPiloto(int theId) {
		logger.info("***BORRAR UN PILOTO DESDE EL SERVICE REST CLIENTE");

		logger.info("in eliminarPiloto(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in eliminarPiloto(): deleted piloto theId=" + theId);
	}

}
