package com.gespofin.cargaprops;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CargadorPropiedades {

	Properties prop = new Properties();

	public CargadorPropiedades() {

		InputStream planillaProps = null;
		planillaProps = this.getClass().getClassLoader().getResourceAsStream("properties/config.properties");

		try {
			prop.load(planillaProps);

		} catch (IOException e) {

		} finally {
			try {
				planillaProps.close();
			} catch (IOException io) {

			}
		}
	}

	public String getPropiedad(String propiedad) {

		return prop.getProperty(propiedad);
	}

}
