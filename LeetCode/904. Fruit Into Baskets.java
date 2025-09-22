class Solution {
	public int totalFruit(int[] fruits) {

		Fruit temp, b = null, a = new Fruit(fruits[0], 0);

		int ans = 2, windowPos = 0, i = 1;
		
		for (; i < fruits.length; i++)
			if (fruits[i] == a.type)
				a.lastIndex = i;
			else {
				b = new Fruit(fruits[i], i);
				break;
			}

		for (; i < fruits.length; i++) {
			if (fruits[i] == a.type)
				a.lastIndex = i;
			else if (fruits[i] == b.type)
				b.lastIndex = i;
			else {
				temp = fruits[i - 1] == a.type ? b : a;
				windowPos = temp.lastIndex + 1;
				temp.type = fruits[i];
				temp.lastIndex = i;
			}
			ans = Math.max(ans, i - windowPos + 1);
		}

		return b == null ? a.lastIndex + 1 : ans;
	}
}

class Fruit {
	int type, lastIndex;

	public Fruit(int type, int lastIndex) {
		this.type = type;
		this.lastIndex = lastIndex;
	}
}
