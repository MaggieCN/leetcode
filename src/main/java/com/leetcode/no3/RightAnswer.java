package com.leetcode.no3;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author MaggieCN
 * @Date 2021/10/14
 * @Description
1.将字符串中的字符取出，使用HashMap存取对应字符。key对应字符，value对应字符下标。用Hashmap来判断字符串中字符是否重复

2.设Left为区间左端点下标，right为区间右端点下标。即区间长度=right-left+1；

3.区间左端点left不动，让right这个右端点往后遍历，如果发现准备放入map的字符已经在Hashmap中存在，
那么只需要将左端点更新到在map已经存在的字符的右边一个位置，即已存在字符的下标+1。
比如aba,左端点下标开始是0，第二个a准备存入map时，发现map中已经存在a了，所以将区间左端点下标更新为第一个a的右边位置，即第一个a的下标+1。
子串ab，因此变成子串 ba。

至于为什么左端点要更新到已存在字符的右边一个位置，因为关键字是最长子串。
如 aba，由于遍历字符串时，第二个a发现map已经存在了字符a，为了保证题意的最长子串。
由于子串ab ,和子串ba的长度显然都是2，二者长度等价。
而ab子串不可能再变长（ab子串右边是a，限制了子串的成长）。
而ba子串向后面遍历字符串还有可能接像c,d等其他字符，子串长度成长空间更大，显然符合求最长子串的题意。
要选出更长的子串，Left必须更新。

4.注意：left = Math.max(left,map.get(s.charAt(i))+1); 之所以这里要取最大值，而不是直接让left = map.get(s.charAt(i))+1
是因为 存在 abba这种回文情况，如果left = map.get(s.charAt(i))+1 ，当第二个b存入map时，Left更新为2。
当第二个a,准备存入时，如果不取最大值，会导致本来是left本来是2,更新变成为1，出现了left往回退的情况。而left = Math.max(left,map.get(s.charAt(i))+1)就会避免这个情况。
另外由于是HashMap的原因， map.get(s.charAt(i))的值如果存在，肯定是前一次相同字符存储好的下标。
所以每次对新的字符判断map是否存在后， 无论是否更新left，也都要在map中更新每次新字符对应的新下标。
比如abba，首先子串为ab，后面子串更新为ba后，b的下标更新为2而不是1,a的下标更新为3，而不是1.
如果不更新新字符对应下标 比如abbabc这种情况，后面遍历到第三个b时，本来left要更新到第二个b的后面也就第二个a的位置，
但因为没在map中将第二个b的位置替换为第一个b的位置，而导致出错。

 */
public class RightAnswer {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap();
        int len = s.length(),ans = 0;         //len =字符串长度，ans为返回答案
        for( int right = 0,left = 0; right<len; right++)
        {
            if (map.containsKey(s.charAt(right))) left = Math.max(left,map.get(s.charAt(right))+1);
            //取最大值防止区间左端点回退情况
            ans = Math.max(ans,right-left+1); //区间右端点下标-区间左端点下标 +1 = 区间长度
            map.put(s.charAt(right),right); //注意，更新字符对应的下标。
        }
        return ans;
    }
}
