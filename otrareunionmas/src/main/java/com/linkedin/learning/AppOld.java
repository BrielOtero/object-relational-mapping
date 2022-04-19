package com.linkedin.learning;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;

import com.linkedin.learning.otrareunionmas.dao.ActaDao;
import com.linkedin.learning.otrareunionmas.dao.ReunionDao;
import com.linkedin.learning.otrareunionmas.dao.SalaDao;
import com.linkedin.learning.otrareunionmas.dominio.Acta;
import com.linkedin.learning.otrareunionmas.dominio.Persona;
import com.linkedin.learning.otrareunionmas.dominio.Reunion;
import com.linkedin.learning.otrareunionmas.dominio.Sala;

public class AppOld {
	public static void main(String[] args) {
		ReunionDao dao = new ReunionDao();
		List<Reunion> reuniones2 = dao.getAll();
		System.out.println("*** " + reuniones2);

		Persona marta = new Persona("E001","Marta","García López");
		Persona pedro = new Persona("E002","Pedro","Gómez Fernández");

		// Set<Persona> equipo = new HashSet();
		// equipo.add(marta);
		// equipo.add(pedro);

		Reunion r = new Reunion(LocalDateTime.now(), "Reunión de Test");
		r.addParticipante(marta);
		r.addParticipante(pedro);

		// System.out.println(r);
		// r.setParticipantes(equipo);
		dao.save(r);
		System.out.println(r);

		ActaDao actaDao = new ActaDao();
		Acta a = new Acta("Reunion anulada", r);
		actaDao.save(a);

		Reunion r1= new Reunion(LocalDateTime.now(), "Otra Reunión de Test");
		pedro.addReunion(r1);
		dao.save(r1);

		// Set<Reunion> reunionesMarta = new HashSet();
		// reunionesMarta.add(r);

		// marta.setReuniones(reunionesMarta);

		// Set<Reunion> reunionesPedro = new HashSet();
		// reunionesPedro.add(r);
		// reunionesPedro.add(r1);

		// pedro.setReuniones(reunionesPedro);

		Reunion r2 = new Reunion(LocalDateTime.now().plus(2, ChronoUnit.DAYS), "Reunión de pasado mañana");
		System.out.println(r2);
		dao.save(r2);
		
		try {
			System.out.println("Tu próxima reunión es: " + dao.proximaReunion());
		} catch (NoResultException nre) {
			System.out.println("No tienes ninguna reunióñ a la vista");
		}

		Reunion r3 = new Reunion(LocalDateTime.now().plus(1,ChronoUnit.DAYS), "Reunión de mañana");
		dao.save(r3);

		List<Reunion> reunionesManyana = dao.reunionesManyana();
		System.out.println("Para mañana: "+reunionesManyana);

		SalaDao salaDao = new SalaDao();

		// Sala s = new Sala("S202", "Sala grande", 25);
		// salaDao.save(s);

		// System.out.println("Paso 1 "+salaDao.getAll());

		// s.setDescripcion("Sala Grande reformada");
		// salaDao.update(s);

		// System.out.println("Paso 2 "+salaDao.getAll());

		// Sala s2 = new Sala("99", "Trastero", 1);
		// salaDao.save(s2);

		// System.out.println("Paso 3 "+salaDao.getAll());

		// salaDao.delete(s2);

		// System.out.println("Paso 4 "+salaDao.getA
	}
	
}
