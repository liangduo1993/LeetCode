package exhaustion;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on
 * the same straight line.
 * 
 * @author Liang
 *
 */

public class maxPointsOnALine {

	public int maxPoints(Point[] points) {

		if (points.length == 1)
			return 1;

		Map<Line, Integer> lineMap = new HashMap<>();

		int maxCount = 0;

		for (Point x : points) {
			lineMap.clear();
			int dup = 0;
			int currentMax = 0;
			for (Point y : points) {
				if (x == y)
					continue;
				int x1 = x.x;
				int x2 = y.x;
				int y1 = x.y;
				int y2 = y.y;
				if (x1 == x2 && y1 == y2) {
					dup++;
					continue;
				}
				Line currentLine;
				if (x1 == x2 && y1 != y2) {
					currentLine = new Line(-1, x1);
				} else {
					double k = (y1 - y2) / (x1 - x2);
					double b = (y1 * x2 - y2 * x1) / (x2 - x1);
					currentLine = new Line(k, b);
				}

				if (!lineMap.containsKey(currentLine))
					lineMap.put(currentLine, 1);
				else {
					int value = lineMap.get(currentLine);
					lineMap.remove(currentLine);
					lineMap.put(currentLine, ++value);
				}
			}
			if (lineMap.size() >= 1) {
				Integer[] array = lineMap.values().toArray(new Integer[lineMap.size()]);
				currentMax = getMax(array) + dup + 1;
			} else {
				currentMax = dup + 1;
			}
			if (currentMax >= maxCount)
				maxCount = currentMax;
		}

		return maxCount;
	}

	public int getMax(Integer[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	class Line {
		double k;
		double b;

		

		

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			long temp;
			temp = Double.doubleToLongBits(b);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			temp = Double.doubleToLongBits(k);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Line other = (Line) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (Double.doubleToLongBits(b) != Double.doubleToLongBits(other.b))
				return false;
			if (Double.doubleToLongBits(k) != Double.doubleToLongBits(other.k))
				return false;
			return true;
		}

		public Line(double k, double b) {
			this.k = k;
			this.b = b;
		}

		@Override
		public String toString() {
			return "Line [k=" + k + ", b=" + b + "]";
		}

		private maxPointsOnALine getOuterType() {
			return maxPointsOnALine.this;
		}
	}

	class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}

	public static void main(String[] args) {
		maxPointsOnALine test = new maxPointsOnALine();
		Point[] points = new Point[] { test.new Point(0, 0), test.new Point(1, 1), test.new Point(2, 2),
				test.new Point(3, 3), test.new Point(4, 4)

		};
		System.out.println(test.maxPoints(points));

	}

}
