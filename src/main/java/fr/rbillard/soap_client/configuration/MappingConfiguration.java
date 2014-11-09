package fr.rbillard.soap_client.configuration;

import static org.dozer.loader.api.FieldsMappingOptions.customConverter;
import static org.dozer.loader.api.TypeMappingOptions.oneWay;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.rbillard.soap_client.dto.ActorClientDTO;
import fr.rbillard.soap_client.dto.MovieClientDTO;
import fr.rbillard.soap_client.mapper.converter.XMLGregorianCalendar2DateConverter;
import fr.rbillard.soap_server.ws.ActorDTO;
import fr.rbillard.soap_server.ws.MovieDTO;

@Configuration
public class MappingConfiguration {

	@Bean
	public Mapper mapper() {
		
		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.addMapping( beanMappingBuilder() );
		return mapper;
		
	}
	
	private BeanMappingBuilder beanMappingBuilder() {
		
		return new BeanMappingBuilder() {
			
			@Override
			protected void configure() {
				
				mapping( ActorDTO.class, ActorClientDTO.class, oneWay() )
					.fields( "roles.role", "roles" )
					.fields( "birthDate", "birthDate", customConverter( XMLGregorianCalendar2DateConverter.class ) );
				
				mapping( MovieDTO.class, MovieClientDTO.class, oneWay() )
					.fields( "roles.role", "roles" );
				
			}
			
		};
		
	}
	
}
