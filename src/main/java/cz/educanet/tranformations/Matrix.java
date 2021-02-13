package cz.educanet.tranformations;

import kotlin.NotImplementedError;

import java.util.Arrays;

public class Matrix implements IMatrix {

    private final double[][] rawArray;

    public Matrix(double[][] rawArray) {
        this.rawArray = rawArray;
    }

    @Override
    public int getRows() {
        return rawArray.length;
    }

    @Override
    public int getColumns() {
        if (getRows() > 0)
            return rawArray[0].length;

        return 0;
    }

    @Override
    public IMatrix times(IMatrix matrix) {
        Matrix returned = null;
        double disposable;
        for (int m = 0; m < getRows(); m++) {
            double[] horniNasobci = new double[getColumns()];
            for (int i = 0; i < getColumns(); i++) {
                horniNasobci[i] = get(m, i);
            }
            for (int needstohappen = 0; needstohappen < matrix.getColumns(); needstohappen++) {
                double[] levyNasobci = new double[matrix.getRows()];
                for (int i = 0; i < matrix.getRows(); i++) {
                    levyNasobci[i] = get(i, needstohappen);
                }

                disposable = 0;
                for (int n = 0; n < horniNasobci.length; n++) {
                    disposable = disposable + horniNasobci[n] * levyNasobci[n];
                }
                returned[m][needstohappen] = disposable;
            }
        }
        return returned; // TODO:
    }

    @Override
    public IMatrix times(Number scalar) {
        throw new NotImplementedError(); // TODO:
    }

    @Override
    public IMatrix add(IMatrix matrix) {
        throw new NotImplementedError(); // TODO:
    }

    @Override
    public double get(int n, int m) {
        return rawArray[m][n]; // TODO:
    }

    //region Optional
    @Override
    public IMatrix transpose() {
        return null;
    }

    @Override
    public double determinant() {
        return 0;
    }

    //endregion
    //region Generated
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;

        for (int i = 0; i < rawArray.length; i++) {
            if (!Arrays.equals(rawArray[i], matrix.rawArray[i]))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rawArray);
    }
    //endregion
}
