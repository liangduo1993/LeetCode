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
// not finish
public class _03_maxPointsOnALine {

	public int maxPoints(Point[] points) {

		if (points.length == 1)
			return 1;

		Map<String, Integer> lineMap = new HashMap<>();

		int maxCount = 0;

		for (Point x : points) {
			lineMap.clear();
			int dup = 0;
			int currentMax = 0;
			String k;
			for (Point y : points) {
				if (x == y)
					continue;
				Double x1 = (double)x.x;
				Double x2 = (double)y.x;
				Double y1 = (double)x.y;
				Double y2 = (double)y.y;
				if (x.x == y.x && x.y == y.y) {
					dup++;
					continue;
				}
				if (x.x == y.x && x.y != y.y) {
					k = "";
				} else {
					k = String.valueOf((y1 - y2) / (x1 - x2));
				}
				if (!lineMap.containsKey(k))
					lineMap.put(k, 1);
				else {
					int value = lineMap.get(k);
					lineMap.remove(k);
					lineMap.put(k, ++value);
				}
			}
//			System.out.println(x.x + ":" + x.y);
//			System.out.println(lineMap);
			if (lineMap.size() > 0) {
				for (Integer i : lineMap.values()) {
					currentMax = Math.max(currentMax, i);
				}
				currentMax += dup + 1;
			} else {
				currentMax = dup + 1;
			}
			if (currentMax >= maxCount)
				maxCount = currentMax;
		}

		return maxCount;
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

	// (84,250),(0,0),(1,0),(0,-70),(0,-70),(1,-1),(21,10),(42,90),(-42,-230)
	//[(1,1),(1,1),(2,2),(2,2)]

	public static void main(String[] args) {
		_03_maxPointsOnALine test = new _03_maxPointsOnALine();
//		Point[] points = new Point[] { test.new Point(84, 250), test.new Point(0, 0), test.new Point(1, 0),
//				test.new Point(0, -70), test.new Point(0, -70), test.new Point(1, -1), test.new Point(21, 10),
//				test.new Point(42, 90), test.new Point(-42, -230)
//
//		};
		Point[] points = new Point[] { test.new Point(1, 1), test.new Point(1,1), test.new Point(2,2),
				test.new Point(2,2)
		};
		System.out.println(test.maxPoints(points));

	}

}
