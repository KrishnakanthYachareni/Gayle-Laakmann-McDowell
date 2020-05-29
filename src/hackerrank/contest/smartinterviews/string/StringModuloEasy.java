package hackerrank.contest.smartinterviews.string;

/**
 * You are given 2 numbers N & P. Print N % P.
 *
 * @link https://www.hackerrank.com/contests/smart-interviews/challenges/si-string-modulo
 * <p>
 * Ref: https://www.hackerearth.com/practice/notes/get-the-modulo-of-a-very-large-number-that-cannot-be-stored-in-any-data-type-in-cc-1/
 */
public final class StringModuloEasy {
    public static void main(String[] args) {
        String n = "1085377843";
        long p = 81765943;
        long ans = stringModulo(n, p);
        System.out.println(ans);
    }

    public static long stringModulo(String n, long p) {
        long ans = 0;
        for (char ch : n.toCharArray()) {
            ans = (ans * 10 + (long)ch - '0') % p;
        }
        return ans;
    }
//Equivalent C++ code
 /*
 #include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

    int main() {
        *//* Enter your code here. Read input from STDIN. Print output to STDOUT *//*
        int t;
        cin>>t;
        string n;
        long long p;
        while(t--){
            cin >> n;
            cin >> p;
            long long res = 0;
            for(std::string::iterator it = n.begin(); it != n.end(); ++it) {
                res = (res*10 + (int)(*it) - '0') %p;
            }
            cout << res;
            cout << "\n";
        }
        return 0;
    }*/
}