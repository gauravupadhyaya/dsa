import java.util.HashMap;
import java.util.Map;

public class PixelPaint {
    private Map<Integer, Map<Integer, String>> rows;
    private int totalRows = 0;
    private int totalColumns = 0;

    /**
     * Fill given color at given position
     * @param col
     * @param row
     * @param color
     */
    public void fill(int col, int row, String color){
        if(this.rows == null){
            this.rows = new HashMap<>();
        }
        Map<Integer, String> cols = this.rows.get(row);
        if(cols == null){
            cols = new HashMap<>();
            this.rows.put(row, cols);
        }
        cols.put(col, color);
        if(row > totalRows){
            totalRows = row;
        }
        if(col > totalColumns){
            totalColumns = col;
        }
    }

    /**
     * Fill row at and between two columns with given color.
     * @param row
     * @param colFrom
     * @param colTo
     * @param color
     */
    public void fillRow(int row, int colFrom, int colTo, String color){
        for (int i = colFrom; i <= colTo; i++) {
            this.fill(i,row, color);
        }
    }



    /**
     * Fill column at and between two rows with given color.
     * @param col
     * @param rowFrom
     * @param rowTo
     * @param color
     */
    public void fillCol(int col, int rowFrom, int rowTo, String color){
        for (int i = rowFrom; i <= rowTo; i++) {
            this.fill(col, i, color);
        }
    }

    /**
     * Flood and replace color at given pixel position and to all adjacent same color pixels.
     * @param col
     * @param row
     * @param color
     */
    public void flood(int col, int row, String color){
        String oldColor = this.getColor(col, row);
        this.floodRecursive(col, row, oldColor, color);
    }

    /**
     * Flood color in all 4 adjacent pixels recursively.
     * @param col
     * @param row
     * @param oldColor
     * @param newColor
     */
    private void floodRecursive(int col, int row, String oldColor, String newColor){
        if(row > 1 && col >1 && row <= totalRows && col <= totalColumns
                && !this.getColor(col, row).equals(oldColor)){
            return;
        }
        this.fill(col, row, newColor);
        floodRecursive(col+1, row, oldColor, newColor);
        floodRecursive(col-1, row, oldColor, newColor);
        floodRecursive(col, row+1, oldColor, newColor);
        floodRecursive(col, row-1, oldColor, newColor);
    }

    /**
     * Get color at given column and row
     * @param col
     * @param row
     * @return Color as String
     */
    private String getColor(int col, int row){
        if(this.rows != null && this.rows.containsKey(row)){
            Map<Integer, String> cols = this.rows.get(row);
            if(cols != null && cols.containsKey(col)){
                return  cols.get(col);
            }
        }
        return "White";
    }

    /**
     * Print 2D color canvas on console.
     */
    public void print() {
        for (int i = 1; i <= this.totalRows; i++) {
            Map<Integer, String> row = this.rows.get(i);
            for (int j = 1; j <= this.totalColumns; j++) {
                String color = "White";
                if(row != null && row.containsKey(j)){
                    color = row.get(j);
                }
                System.out.printf("%8s", color);
            }
            System.out.println();
        }
    }


    /**
     * Main function with test data as provided in exercise.
     * @param args
     */
    public static void main(String[] args) {
        PixelPaint pixelPaint = new PixelPaint();
        pixelPaint.fill(8, 2, "Yellow");
        pixelPaint.fill(8, 4, "Blue");
        pixelPaint.fill(9, 5, "Blue");
        pixelPaint.fillRow(3,2,7, "Blue");
        pixelPaint.fillRow(4,5,6, "Blue");
        pixelPaint.fillCol(3, 2,6, "Green");
        pixelPaint.flood(6,3, "Red");
        pixelPaint.print();
    }
}
