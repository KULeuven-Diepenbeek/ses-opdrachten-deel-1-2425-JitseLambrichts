import contextlib
import unittest
from checkneighbours import get_same_neighbours_ids

class TestFunctions(unittest.TestCase):

    def test_gegevenVoorbeeldgridWith4Height4IndexToCheck5_wanneerGetSameNeighboursIds_dan2en4en10(self):
        # Arrange
        voorbeeld_grid = [ 0, 0, 1, 0,
                          1, 1, 0, 2,
                          2, 0, 1, 3,
                          0, 1, 1, 1 ]
        # Act
        result = get_same_neighbours_ids(voorbeeld_grid, 4, 4, 5)
        # Assert
        self.assertEqual(result, [2,4,10])
    

    def test_gegevenGegGridWidth4Height4Index12_wanneerCheck_danResult9(self):
        # Arrange
        voorbeeld_grid = [ 0, 0, 1, 0,
                          1, 1, 0, 2,
                          2, 0, 1, 3,
                          0, 1, 1, 1 ]
        
        # Act 
        result = get_same_neighbours_ids(voorbeeld_grid, 4, 4, 12)

        # Assert
        self.assertEqual(result, [9])
    

    def test_gegevenNewGridWidth10Height4Index25_wanneerCheck_danResult14_26_34(self):
        # Arrange
        voorbeeld_grid = [  3, 1, 5, 0, 4, 2, 1, 3, 5, 4,
                            0, 2, 1, 5, 3, 4, 2, 0, 1, 3, 
                            5, 4, 2, 0, 1, 3, 3, 4, 0, 2,
                            1, 5, 3, 4, 3, 0, 1, 3, 5, 4 ]

        # Act 
        result = get_same_neighbours_ids(voorbeeld_grid, 10, 4, 25)

        # Assert
        self.assertEqual(result, [14, 26, 34])


    def test_gegevenGegGridWidth4Height4Index20_wanneerCheck_danIndexOutOfBoundsException(self):
        # Arrange
        voorbeeld_grid = [ 0, 0, 1, 0,
                          1, 1, 0, 2,
                          2, 0, 1, 3,
                          0, 1, 1, 1 ]
        # Act & Assert
        with self.assertRaises(ValueError) as exc_info:
            get_same_neighbours_ids(voorbeeld_grid, 4, 4, 20)

        self.assertIn("/ Index out of bound", str(exc_info.exception))


    def test_gegevenGridZonderBurenWidth3Height3Index8_wanneerCheck_danResultEmpty(self):
        # Arrange
        voorbeeld_grid = [ 1, 2, 3, 
                           4, 5, 1, 
                           2, 3, 4 ]
    
        # Act
        result = get_same_neighbours_ids(voorbeeld_grid, 3, 3, 4)

        # Assert
        self.assertEqual(result, [ ])
    

    def test_gegevenGegGridWidth4Height4IndexNegatief_wanneerCheck_danIndexOutOfBoundException(self):
        # Arrange
        voorbeeld_grid = [ 0, 0, 1, 0,
                           1, 1, 0, 2,
                           2, 0, 1, 3,
                           0, 1, 1, 1 ]
        
        # Act & assert
        with self.assertRaises(ValueError) as exc_info:
            get_same_neighbours_ids(voorbeeld_grid, 4, 4, -1)
        
        self.assertIn("/ Index out of bound", str(exc_info.exception))
    

    def test_gegevenGrid4x4MaarWidth3Height3Index5_wanneerCheck_danIllegalArgumentException(self):
        # Arrange
        voorbeeld_grid = [ 0, 0, 1, 0,
                           1, 1, 0, 2,
                           2, 0, 1, 3,
                           0, 1, 1, 1 ]
        
        # Act & assert
        with self.assertRaises(ValueError) as exc_info:
            get_same_neighbours_ids(voorbeeld_grid, 3, 3, 5)
        
        self.assertIn("/ Illegal argument", str(exc_info.exception))
    

if __name__ == '__main__':
    unittest.main()