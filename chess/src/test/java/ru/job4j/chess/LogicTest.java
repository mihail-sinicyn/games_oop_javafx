package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

public class LogicTest {

    @Test (expected = FigureNotFoundException.class)
    public void figureNotFound() throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.move(Cell.A1, Cell.D4);
    }

    @Test (expected = OccupiedCellException.class)
    public void wayBlock() throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        BishopBlack bb1 = new BishopBlack(Cell.A1);
        BishopBlack bb2 = new BishopBlack(Cell.B2);
        logic.add(bb1);
        logic.add(bb2);
        logic.move(Cell.A1, Cell.D4);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void impossibleMove() throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.A1));
        logic.move(Cell.A1, Cell.A7);
    }
}
/**/