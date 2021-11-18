package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack bishop = new BishopBlack(Cell.B8);
        Cell position = bishop.position();
        assertThat(position, is(Cell.B8));
    }

    @Test
    public void copy() {
        BishopBlack bishop = new BishopBlack(Cell.B8);
        Figure copy = bishop.copy(Cell.E6);
        assertThat(copy.position(), is(Cell.E6));
    }

    @Test
    public void way() {
        BishopBlack bishop = new BishopBlack(Cell.C1);
        Cell[] cells = bishop.way(Cell.G5);
        Cell[] expected = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(cells, is(expected));
    }

    @Test (expected = ImpossibleMoveException.class)
    public void notDiagonal() {
        BishopBlack bishop = new BishopBlack(Cell.A1);
        bishop.way(Cell.A4);
    }

}
