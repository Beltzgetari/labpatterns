package iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import adapter.InvertedIterator;
import domain.Symptom;

public class Covid19PacientIterator implements InvertedIterator {
    private List<Symptom> symptoms;
    private int position;

    public Covid19PacientIterator(ArrayList<Symptom> s) {
        this.symptoms = s;
        //Collections.reverse(symptoms); // Invert the list
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < symptoms.size();
    }

    @Override
    public Symptom next() {
        return symptoms.get(position++);
    }

    @Override
    public Symptom previous() {
        if (hasPrevious()) {
            return symptoms.get(--position);
        }
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return position > 0;
    }

    @Override
    public void goLast() {
        position = symptoms.size() - 1;
    }
}