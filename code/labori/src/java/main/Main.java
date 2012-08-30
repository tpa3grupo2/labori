package main;

import entity.Usuario;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class Main {

	public static void main(String args[]) {

		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(Usuario.class);
		config.configure();
		
		new SchemaExport(config).create(true, true);
	}
}
