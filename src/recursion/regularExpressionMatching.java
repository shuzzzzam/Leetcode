/**
 * 
 */
package recursion;

/**
 * @author fSociety//partially solved
 *
 */
public class regularExpressionMatching {
	public boolean isMatch(String s, String p) {
        int sIndex = 0, pIndex = 0;
        Character lastCharacter = null;
        return recursion(s, sIndex, p, pIndex, lastCharacter);
    }

	private boolean recursion(String s, int sIndex, String p, int pIndex, Character lastCharacter) {
		if(sIndex == s.length()) {
			if(p.charAt(pIndex) == '*')
                return true;
			if(pIndex == p.length())
				return true;
			return false;
		}
		else if(pIndex == p.length()) {
			return false;
		}
		else {
			if(p.charAt(pIndex) == '.') {
				return recursion(s, sIndex++, p, pIndex++, '.');
			}
			else if(p.charAt(pIndex) == '*') {
				if(lastCharacter == '.') {
					return recursion(s, sIndex, p, pIndex + 1, null) || recursion(s, sIndex + 1, p, pIndex, lastCharacter);
				}
				else {
					if(s.charAt(sIndex) == lastCharacter) {
						return recursion(s, sIndex, p, pIndex + 1, null) || recursion(s, sIndex + 1, p, pIndex, lastCharacter);
					}
					else {
						return recursion(s, sIndex, p, pIndex + 1, null);
					}
				}
			}
			else {
				if(s.charAt(sIndex) == p.charAt(pIndex)) {
					return recursion(s, sIndex + 1, p, pIndex + 1, s.charAt(sIndex));
				}
				else {
					return false;
				}
			}
		}
	}
}
