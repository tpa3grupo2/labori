package main;

import org.hibernate.tool.hbm2ddl.SchemaExport;
import util.HibernateUtil;

public class Main {

	public static void main(String args[]) {
		new SchemaExport(HibernateUtil.getConfiguration()).create(true, true);
	}
}
