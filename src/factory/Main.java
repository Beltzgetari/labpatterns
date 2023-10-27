package factory;

import domain.Covid19Pacient;
import domain.Medicament;
import factory.SymptonFactory;

public class Main {

	public static void main(String[] args) {
		SymptonFactory sf = new SymptonFactory();
		
		Covid19Pacient p1 = new Covid19Pacient("aitor", 35, sf);
		new PacientSymptomGUI(p1);
		
		Medicament m = new Medicament("Ibuprofeno", sf);
		MedicalGUI mgui = new MedicalGUI(m);
		
	}

}
