#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main() {
    long long min, max;
    cin >> min >> max;

    long long range = max - min + 1;
    vector<bool> isSquareFree(range, true);

    for (long long i = 2; i * i <= max; ++i) {
        long long square = i * i;
        long long start = ((min + square - 1) / square) * square;
        for (long long j = start; j <= max; j += square) {
            isSquareFree[j - min] = false;
        }
    }

    int count = 0;
    for (bool free : isSquareFree) {
        if (free) count++;
    }

    cout << count << endl;
    return 0;
}
