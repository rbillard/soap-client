package fr.rbillard.soap_client.mapper.converter;

import javax.xml.datatype.XMLGregorianCalendar;

import org.dozer.CustomConverter;
import org.dozer.MappingException;

import fr.rbillard.soap_client.utils.DateUtils;

public class XMLGregorianCalendar2DateConverter implements CustomConverter {

	@Override
	public Object convert( Object existingDestinationFieldValue, Object sourceFieldValue, Class<?> destinationClass,
			Class<?> sourceClass ) {
		
		if ( sourceFieldValue == null ) {
			return null;
		}

		if ( sourceFieldValue instanceof XMLGregorianCalendar ) {
			
			XMLGregorianCalendar xmlGregorianCalendar = (XMLGregorianCalendar) sourceFieldValue;
			return DateUtils.getDate( xmlGregorianCalendar );
			
		} else {
			
			throw new MappingException("Converter XMLGregorianCalendar2DateConverter used incorrectly. Arguments passed in were:"
					 + existingDestinationFieldValue + " and " + sourceFieldValue);
			
		}
		
	}

}
