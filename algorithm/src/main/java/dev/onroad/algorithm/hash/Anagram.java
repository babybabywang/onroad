package dev.onroad.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author echo huang
 * @version 1.0
 * @date 2019-08-09 00:39
 * @description 242. 有效的字母异位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 1.  排序在比较  nlogn  快排的时间复杂度
 */
public class Anagram {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sort = new HashMap<>();
        Map<Character, Integer> sort1 = new HashMap<>();
        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            sort.put(s.charAt(i), sort.get(s.charAt(i))==null?0: sort.get(s.charAt(i)) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            sort1.put(t.charAt(i), sort1.get(t.charAt(i))==null?0: sort1.get(t.charAt(i)) + 1);
        }
        return sort.equals(sort1);
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        System.out.println(anagram.isAnagram("aacc", "ccac"));
    }
}
