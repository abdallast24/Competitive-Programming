class Solution {
	private String s;

	public boolean splitString(String s) {
		this.s = s;
		return backTrack(-1l, 0);
	}

	private boolean backTrack(long last, int j) {

		if (j == s.length()) // can split s
			return true;

		long cur = 0l;

		for (int i = j; i < s.length(); i++) {

			cur = cur * 10 + (s.charAt(i) - '0'); // add current char

			if (cur < 0 || last == -1 && i + 1 == s.length()) // overflow || found only one substring
				break;

			if ((last == -1 || last - cur == 1) && backTrack(cur, i + 1)) // first substring || difference between last,cur numbers is 1
				return true;

		}
		
		return false;
	}

}
