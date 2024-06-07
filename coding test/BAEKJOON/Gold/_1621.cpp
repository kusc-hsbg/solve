#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

int main() {
    int N, K, C;
    cin >> N >> K >> C;

    vector<int> weights(N);
    for (int i = 0; i < N; ++i) {
        cin >> weights[i];
    }

    vector<long long> dp(N + 1, LLONG_MAX);
    vector<int> count(N + 1, 0);
    vector<int> lastK(N + 1, -1);
    dp[0] = 0;

    for (int i = 1; i <= N; ++i) {
        dp[i] = dp[i - 1] + weights[i - 1];
        count[i] = count[i - 1];
        lastK[i] = -1;

        if (i >= K) {
            long long kCarry = dp[i - K] + C;
            if (kCarry < dp[i]) {
                dp[i] = kCarry;
                count[i] = count[i - K] + 1;
                lastK[i] = i - K;
            } else if (kCarry == dp[i] && count[i - K] + 1 < count[i]) {
                count[i] = count[i - K] + 1;
                lastK[i] = i - K;
            }
        }
    }

    cout << dp[N] << endl;
    cout << count[N] << endl;

    vector<int> positions;
    for (int i = N; i > 0;) {
        if (lastK[i] != -1) {
            positions.push_back(lastK[i] + 1);
            i = lastK[i];
        } else {
            i--;
        }
    }

    sort(positions.begin(), positions.end());
    for (int pos : positions) {
        cout << pos << " ";
    }
    cout << endl;

    return 0;
}
