package be.ses;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class CheckNeighboursInGridTest {
    //VOORBEELD OPDRACHTEN
    @Test
    public void gegevenGegGridWidth4Height4Index5_wanneerCheck_danResult2_4_10() {
        //Arrange
        List<Integer> grid = Arrays.asList(
            0, 0, 1, 0,
            1, 1, 0, 2,
            2, 0, 1, 3,
            0, 1, 1, 1
        );

        //Act
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, 4, 4, 5);

        //Assert
        assertThat(result).containsExactlyInAnyOrder(2,4,10);
    }
    
    //INDEX_TO_CHECK IN DE LINKERONDERHOEK
    @Test
    public void gegevenGegGridWidth4Height4Index12_wanneerCheck_danResult9() {
        //Arrange
        List<Integer> grid = Arrays.asList(
            0, 0, 1, 0,
            1, 1, 0, 2,
            2, 0, 1, 3,
            0, 1, 1, 1
        );

        //Act
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, 4, 4, 12);

        //Assert
        assertThat(result).containsExactlyInAnyOrder(9);
    }

    //GROTERE ARRAY
    @Test
    public void gegevenNewGridWidth10Height4Index25_wanneerCheck_danResult14_26_34() {
        //Arrange
        List<Integer> grid = Arrays.asList( 
            3, 1, 5, 0, 4, 2, 1, 3, 5, 4,
            0, 2, 1, 5, 3, 4, 2, 0, 1, 3, 
            5, 4, 2, 0, 1, 3, 3, 4, 0, 2,
            1, 5, 3, 4, 3, 0, 1, 3, 5, 4
        );

        //Act
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, 10, 4, 25);

        //Assert
        assertThat(result).containsExactlyInAnyOrder(14, 26, 34);
    }

    //INDEX_TO_CHECK ERBUITEN
    @Test
    public void gegevenGegGridWidth4Height4Index20_wanneerCheck_danIndexOutOfBoundsException() {
        //When
        Throwable thrown = catchThrowable(() -> {
            //Arrange
            List<Integer> grid = Arrays.asList(
                0, 0, 1, 0,
                1, 1, 0, 2,
                2, 0, 1, 3,
                0, 1, 1, 1
            );

            //Act     
            CheckNeighboursInGrid.getSameNeighboursIds(grid, 4, 4, 20);
        });

        //Assert
        assertThat(thrown)
            .isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("/ Index out of bound");
    }

    @Test
    public void gegevenGridZonderBurenWidth3Height3Index8_wanneerCheck_danResultEmpty() {
        //Arrange
        List<Integer> grid = Arrays.asList(
            1, 2, 3, 
            4, 5, 1, 
            2, 3, 4
        );

        //Act 
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, 3, 3, 4);

        //Assert
        assertThat(result).isEmpty();
    }

    //NEGATIEVE INDEX
    @Test
    public void gegevenGegGridWidth4Height4IndexNegatief_wanneerCheck_danIndexOutOfBoundsException() {
        //When
        Throwable thrown = catchThrowable(() -> {
            //Arrange
            List<Integer> grid = Arrays.asList(
                0, 0, 1, 0,
                1, 1, 0, 2,
                2, 0, 1, 3,
                0, 1, 1, 1
            );

            //Act     
            CheckNeighboursInGrid.getSameNeighboursIds(grid, 4, 4, 20);
        });

        //Assert
        assertThat(thrown)
            .isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("/ Index out of bound");
    }

    //GRID NIET HETZELFDE ALS WIDTH * HEIGHT
    @Test
    public void gegevenGrid4x4MaarWidth3Height3Index5_wanneerCheck_danIllegalArgumentException() {
        //When 
        Throwable thrown = catchThrowable(()-> {
            //Arrange 
            List<Integer> grid = Arrays.asList(
                0, 0, 1, 0,
                1, 1, 0, 2,
                2, 0, 1, 3,
                0, 1, 1, 1
            );

            //Act  
            CheckNeighboursInGrid.getSameNeighboursIds(grid, 3, 3, 5);
        });

        //Assert
        assertThat(thrown)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("/ Illegal Argument");
    }
}
