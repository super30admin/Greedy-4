/*
 * 
 * class Solution {
 * public int shortestWay(String source, String target) {
 * // Tc: O(sl * tl) Sc: O(1)
 * int sl = source.length();
 * int tl = target.length();
 * 
 * if (sl == 0 && tl == 0)
 * return 0;
 * int cnt = 0;
 * HashSet<Character> set = new HashSet<>();
 * 
 * for (int i = 0; i < sl; i++) {
 * char ch = source.charAt(i);
 * set.add(ch);
 * }
 * 
 * int sp = 0;
 * int tp = 0;
 * 
 * while (tp < tl) {
 * cnt++;
 * while (sp < sl && tp < tl) {
 * if (!set.contains(target.charAt(tp)))
 * return -1;
 * if (source.charAt(sp) == target.charAt(tp)) {
 * sp++;
 * tp++;
 * } else {
 * sp++;
 * }
 * }
 * sp = 0;
 * }
 * return cnt;
 * }
 * }
 * 
 * 
 * 
 * /*
 * 
 * 
 * class Solution {
 * public int shortestWay(String source, String target) {
 * // Tc: O(sl*tl) Sc: O(1)
 * int sl = source.length();
 * int tl = target.length();
 * 
 * if (sl == 0 && tl == 0)
 * return 0;
 * int cnt = 0;
 * int sp = 0;
 * int tp = 0;
 * while (tp < tl) {
 * cnt++;
 * int pos = tp;
 * while (sp < sl && tp < tl) {
 * if (source.charAt(sp) == target.charAt(tp)) {
 * sp++;
 * tp++;
 * } else {
 * sp++;
 * }
 * }
 * 
 * if (pos == tp)
 * return -1;
 * sp = 0;
 * }
 * return cnt;
 * }
 * }
 * 
 */