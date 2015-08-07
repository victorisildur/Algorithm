import java.util.Map;
import java.util.HashMap;

public class Solution {
	public boolean isIsomorphic(String s, String t) {
		if(s.length() != t.length())
			return false;
		Map<Character, Integer> mapS = new HashMap<Character, Integer>();
		Map<Character, Integer> mapT = new HashMap<Character, Integer>();
		for(int i=0, cntS=0, cntT=0; i<s.length(); i++) {
			Character chS = s.charAt(i);
			Character chT = t.charAt(i);
			if( !mapS.containsKey(chS) ) {
				mapS.put(chS, ++cntS);
			}
			if( !mapT.containsKey(chT) ) {
				mapT.put(chT, ++cntT);
			}
			if( mapS.get(chS) != mapT.get(chT) )
				return false;
		}
		return true;
	}
}
