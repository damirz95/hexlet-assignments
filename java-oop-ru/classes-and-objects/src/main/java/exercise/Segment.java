package exercise;

// BEGIN
class Segment {
    private Point point1;
    private Point point2;

    public Segment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }
    public Point getBeginPoint() {
        return point1;
    }
    public Point getEndPoint() {
        return point2;
    }
    public Point getMidPoint() {
        int[] resultX = new int[(Math.abs(point1.getX()) + Math.abs(point2.getX()) + 1)];
        int indexX = 0;
        int[] resultY = new int[(Math.abs(point1.getY()) + Math.abs(point2.getY()) + 1)];
        int indexY = 0;
        for (int i = Math.min(point2.getX(), point1.getX()); i < Math.max(point2.getX(), point1.getX()); i++) {
            resultX[indexX] = i;
            indexX++;
        }
        for (int i = Math.min(point2.getY(), point1.getY()); i < Math.max(point2.getY(), point1.getY()); i++) {
            resultY[indexY] = i;
            indexY++;
        }
        int x = resultX[Math.round(resultX.length / 2)];
        int y = resultY[Math.round(resultY.length / 2)];
        return new Point(x, y);
    }
}
// END
