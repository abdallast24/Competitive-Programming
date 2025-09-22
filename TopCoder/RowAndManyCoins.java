public class RowAndManyCoins {
	 int cnt, bestCnt, firstIndex, bestFirstIndex, lastIndex, bestLastIndex;
	 char[] row;

	public String getWinner(String cells) {

		int len = cells.length();
		cells += '0';
		char player = 'A';
		row = cells.toCharArray();
		while (true) {
			getBlock((player=='A')?'B':'A');
			len -= bestCnt;
			if (bestFirstIndex != -1)
				for (int i = bestFirstIndex; i <= bestLastIndex; i++) // put coin
					row[i] = '0';

			if (len == 0 && player == 'A' || bestCnt == 0 && player == 'B')
				return "Bob";
			if (len == 0 && player == 'B' || bestCnt == 0 && player == 'A')
				return "Alice";

			player = (player == 'A') ? 'B' : 'A';

		}

	}

	public void getBlock(char ch) {
		cnt = bestCnt = 0; // initialize
		firstIndex = bestFirstIndex = -1;

		for (int i = 0; i < row.length; i++)
			if (row[i] == ch) {
				
				if (firstIndex == -1) 
					firstIndex = lastIndex = i;
				 else 
					lastIndex = i;
				
				cnt++;

			} 
			else 
			{
				if (cnt > bestCnt) {
					bestCnt = cnt;
					bestFirstIndex = firstIndex;
					bestLastIndex = lastIndex;
				}
				cnt = 0;
				firstIndex = -1;
			}

	}

}
