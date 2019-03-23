import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class BattleshipBoardTest {

	public static final String CLASSNAME = "BattleshipBoard";
	public static final String FILENAME = CLASSNAME + ".java";

	@Test
	public void test_getBoard_construction() {
		BattleshipBoard testA = new BattleshipBoard()
		actualValues = a.getBoard()
		String[][] expectedValues = new String[11][11];
		for (Integer row = 0; row < 11; row++) {
			for (Integer column = 0; column <11; column++) {
				if (row == 0) {
					grid[row][column] = " " + column.toString() + " ";
				}
				else if (column == 0) {
					grid[row][column] = " " + row.toString() + " ";
					if (row == 10) {
						grid[row][column] = row.toString() + " ";
					}
				}
				else {
					grid[row][column] = " . ";
				}
			}
		}
		assertEquals("These grids should be the exact same.", actualValues, expectedValues)
	}

	@Test
	public void test_placeShip_valid() {
		BattleshipBoard testA = new BattleshipBoard();
		testA.placeShip(testA, "D", "x", 1, 1); //2 Squares
		testA.placeShip(testA, "S", "x", 3, 3); //3 Squares
		testA.placeShip(testA, "C", "y", 1, 10); //3 Squares
		testA.placeShip(testA, "B", "x", 10, 1); //4 Squares
		testA.placeShip(testA, "A", "y", 2, 7); //5 Squares
		actualValues = testA.getBoard();

		String[][] expectedValues = new String[11][11];
		for (Integer row = 0; row < 11; row++) {
			for (Integer column = 0; column <11; column++) {
				if (row == 0) {
					grid[row][column] = " " + column.toString() + " ";
				}
				else if (column == 0) {
					grid[row][column] = " " + row.toString() + " ";
					if (row == 10) {
						grid[row][column] = row.toString() + " ";
					}
				}
				else {
					if ((row == 1) & (column == 1 | column == 2)) {
						grid[row][column] = " D ";
					}
					if ((row == 3) & (column == 3 | column == 4 | column == 5)) {
						grid[row][column] = " S ";
					}
					if ((row == 1 | row == 2 | row == 3) & (column == 10)) {
						grid[row][column] = " C ";
					}
					if ((row == 10) & (column == 1 | column == 2 | column == 3 | column == 4)) {
						grid[row][column] = " B ";
					}
					if ((row == 2 | row == 3 | row == 4 | row == 5 | row == 6) & (column == 7)) {
						grid[row][column] = " A ";
					}
					else {
						grid[row][column] = " . ";
					}
				}
			}
		}

		assertEquals("These values should correctly be added to the Board", actualValues, expectedValues);
	}

	@Test
	public void test_validPlaceShip_validAndInvalid() {
		BattleshipBoard testA = new BattleshipBoard();
		testA.placeShip(testA, "B", "x", 10, 1);
		testA.placeShip(testA, "C", "y", 1, 10);
		actualValue1 = testA.validPlaceShip(testA, 1, 10, "B", "x"); //fix the arguments pls thnx
		actualValue2 = testA.validPlaceShip(testA, 10, 1, "C", "y");
		actualValue3 = testA.validPlaceShip(testA, 1, 1, "D", "x");
		actualValue4 = testA.validPlaceShip(testA, 7, 11, "A", "y");
		actualValue5 = testA.validPlaceShip(testA, 11, 3, "S", "x");

		expectedValue1 = false;
		expectedValue2 = false;
		expectedValue3 = true;
		expectedValue4 = false;
		expectedValue5 = false;

		assertEquals("Ships override.", actualValue1, expectedValue1);
		assertEquals("Ships override.", actualValue2, expectedValue2);
		assertEquals("Ship placement should be valid.", actualValue3, expectedValue3);
		assertEquals("Ship placement off the board.", actualValue4, expectedValue4);
		assertEquals("Ship placement off the board.", actualValue5, expectedValue5);
	}
}