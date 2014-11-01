package fr.rbillard.soap_client.utils;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public final class DateUtils {

	private DateUtils() {

	}

	public static XMLGregorianCalendar getXMLGregorianCalendar( Date date ) {

		if ( date == null ) {
			 return null;
		}
		
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime( date );
		try {
			return DatatypeFactory.newInstance().newXMLGregorianCalendar( gregorianCalendar );
		} catch ( DatatypeConfigurationException e ) {
			return null;
		}

	}

	public static Date getDate( XMLGregorianCalendar xmlGregorianCalendar ) {
		
		if ( xmlGregorianCalendar == null ) {
			return null;
		}
		return xmlGregorianCalendar.toGregorianCalendar().getTime();
		
	}

}
