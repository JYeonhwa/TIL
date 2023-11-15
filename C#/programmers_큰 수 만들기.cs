using System;
using System.Collections.Generic;
using System.Text;

public class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int kk = number.Length -k;
        int start = 0;
        int nn = 0;
        int idx = 0;
        int mxv = 0;
        while (nn < kk && answer.Length < kk)
        {
            int num = Int32.Parse(number.Substring(start, 1));
            if (mxv < num)
            {
                mxv = num;
                idx = start;
            }
            start++;
            if (start == number.Length - kk + nn+1 || mxv == 9)
            {
                answer.Append(mxv.ToString());
                mxv = 0;
                start = idx+1;
                nn++;
            }
        }
        return answer.ToString();
    }
}