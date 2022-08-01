package pl.pjatk.Iterator;

import java.util.LinkedList;

public class Science implements SubjectInterface{
    private LinkedList<String> subjects;

    public Science() {
        this.subjects = new LinkedList<String>();
        subjects.addLast("Maths");
        subjects.addLast("Com. Sc.");
        subjects.addLast("Physics");
    }

    @Override
    public IteratorInterface createIterator() {
        return new ScienceIterator(subjects);
    }
}
