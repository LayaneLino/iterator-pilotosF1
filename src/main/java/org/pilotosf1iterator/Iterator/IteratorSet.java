package org.pilotosf1iterator.Iterator;

import org.pilotosf1iterator.Model.Piloto;

import java.util.Iterator;
import java.util.Set;

public class IteratorSet implements Iterator<Piloto> {
    private final Iterator<Piloto> iterator;

    public IteratorSet(Set<Piloto> set) {
        this.iterator = set.iterator();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Piloto next() {
        return iterator.next();
    }

}
