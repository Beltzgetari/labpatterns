package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import adapter.Sorting;
import domain.Covid19Pacient;
import domain.Symptom;
import factory.SymptonFactory;

	public class Main {

		public static void main(String[] args) {
			
			SymptonFactory sf = new SymptonFactory();
			Covid19Pacient p=new Covid19Pacient("Ane", 29, sf);
			p.addSymptom(new Symptom("a", 10, 5), 1);
			p.addSymptom(new Symptom("b", 10, 10), 2);
			p.addSymptom(new Symptom("c", 10, 6), 3);
			p.addSymptom(new Symptom("d", 10, 2), 4);
			p.addSymptom(new Symptom("e", 10, 4), 5);
			
			
			 ArrayList<Symptom> pp =  new ArrayList<>(p.getSymptoms());
		     Sorting.sortedIterator(new Covid19PacientIterator(pp), new SymptomNameComparator());

		        // Print symptoms
		        printSymptoms(p);

		        // Sort by severityIndex
		        Sorting.sortedIterator(new Covid19PacientIterator(pp), new SeverityIndexComparator());

		        // Print symptoms
		        printSymptoms(p);
		    }

		    private static void printSymptoms(Covid19Pacient pacient) {
		        System.out.println("Symptoms for " + pacient.getName() + ":");
		        Iterator<Symptom> iterator = pacient.getSymptoms().iterator();
		        while (iterator.hasNext()) {
		            Symptom symptom = iterator.next();
		            System.out.println(symptom.getName() + " - Severity: " + symptom.getSeverityIndex());
		        }
		        System.out.println();
		    }
		}