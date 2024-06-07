#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<int> arr(n);
    for (int i = 0; i < n; ++i) {
        cin >> arr[i];
    }

    vector<long long> prefix_sum(n + 1, 0);
    for (int i = 1; i <= n; ++i) {
        prefix_sum[i] = (prefix_sum[i - 1] + arr[i - 1]) % m;
    }

    unordered_map<int, long long> mod_count;
    for (int i = 0; i <= n; ++i) {
        mod_count[prefix_sum[i]]++;
    }

    long long result = 0;
    for (auto &pair : mod_count) {
        long long count = pair.second;
        result += count * (count - 1) / 2;
    }

    cout << result << "\n";
    return 0;
}
