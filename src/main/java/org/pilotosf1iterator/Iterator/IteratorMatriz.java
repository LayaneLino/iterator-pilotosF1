package org.pilotosf1iterator.Iterator;

import org.pilotosf1iterator.Model.Piloto;
import java.util.Iterator;

public class IteratorMatriz implements Iterator<Piloto> {
    private final Piloto[][] matriz;
    private int linha = 0;
    private int coluna = 0;

    public IteratorMatriz(Piloto[][] matriz) {
        this.matriz = matriz;
    }

    @Override
    public boolean hasNext() {
        int l = linha, c = coluna;
        while (l < matriz.length) {
            if (matriz[l][c] != null) return true;
            c++;
            if (c >= matriz[l].length) { c = 0; l++; }
        }
        return false;
    }

    @Override
    public Piloto next() {
        if (!hasNext()) throw new java.util.NoSuchElementException();
        while (linha < matriz.length) {
            if (matriz[linha][coluna] != null) {
                Piloto p = matriz[linha][coluna];
                coluna++;
                if (coluna >= matriz[linha].length) { coluna = 0; linha++; }
                return p;
            }
            coluna++;
            if (coluna >= matriz[linha].length) { coluna = 0; linha++; }
        }
        return null;
    }
}
