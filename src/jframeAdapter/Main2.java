package jframeAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import domain.Covid19Pacient;
import domain.Symptom;
import factory.SymptonFactory;

public class Main2 {

    public static void main(String[] args) {

        SymptonFactory sf = new SymptonFactory();
        Covid19Pacient p = new Covid19Pacient("Aitor", 29, sf);
        p.addSymptom(new Symptom("disnea", 10, 10), 2);
        p.addSymptom(new Symptom("cefalea", 10, 10), 1);
        p.addSymptom(new Symptom("astenia", 10, 10), 3);

        Covid19Pacient p2 = new Covid19Pacient("Xabi", 29, sf);
        p2.addSymptom(new Symptom("disnea", 10, 10), 2);
        p2.addSymptom(new Symptom("cefalea", 10, 10), 1);
        p2.addSymptom(new Symptom("diarrea", 10, 10), 3);

        Covid19PacientModelAdapter pacientModelAdapter = new Covid19PacientModelAdapter(p);
        Covid19PacientModelAdapter pacientModelAdapter2 = new Covid19PacientModelAdapter(p2);

        JTable table = new JTable(pacientModelAdapter);
        JTable table2 = new JTable(pacientModelAdapter2);

        JPanel panel = new JPanel();
        panel.add(new JScrollPane(table));
        panel.add(new JScrollPane(table2));

        JFrame j = new JFrame();
        j.add(panel);

        j.setTitle(p.getName() + "'s symptoms");
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.pack();
        j.setVisible(true);
    }
}