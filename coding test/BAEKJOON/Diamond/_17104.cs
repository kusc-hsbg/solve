#include <bits/stdc++.h>
using namespace std;
#define MAXN 1000000
typedef complex<double> cdbl;
bool chk[MAXN+5];
vector<int> primes;

void sieve() {
    for(int i = 2; i <= MAXN; ++i) {
        if(!chk[i]) {
            for(int j = i + i; j <= MAXN; j += i) chk[j] = true;
        }
    }
    for(int i = 3; i <= MAXN; ++i) {
        if(!chk[i]) primes.push_back(i);
    }
}

void fft(vector<cdbl> &a, bool inv) {
    int n = a.size();
    // bit reversal
    for(int i = 1, j = 0; i < n; ++i) {
        int bit = n >> 1;
        while(!((j ^= bit) & bit)) bit >>= 1;
        if(i < j) swap(a[i], a[j]);
    }
    for(int i = 1; i < n; i <<= 1) {
        double x = inv ? M_PI / i : -M_PI / i;
        cdbl w = cdbl(cos(x), sin(x));
        for(int j = 0; j < n; j += i << 1) {
            cdbl p = cdbl(1, 0);
            for(int k = 0; k < i; ++k) {
                cdbl tmp = a[i + j + k] * p;
                a[i + j + k] = a[j + k] - tmp;
                a[j + k] += tmp;
                p *= w;
            }
        }
    }
    if(inv) {
        for(int i = 0; i < n; ++i) a[i] /= n;
    }
}

void multiply(vector<cdbl> &f, vector<cdbl> &g, vector<cdbl> &h) {
    fft(f, false); fft(g, false);
    for(size_t i = 0; i < f.size(); ++i) h[i] = f[i] * g[i];
    fft(h, true);
}

int main() {
    cin.tie(nullptr); ios::sync_with_stdio(false);
    int T; cin >> T;
    sieve();
    vector<cdbl> f(1 << 20), g(1 << 20), ans(1 << 20);
    for(auto p : primes) {
        f[(p - 1) / 2] = g[(p - 1) / 2] = cdbl(1, 0);
    }
    multiply(f, g, ans);
    while(T--) {
        int n; cin >> n;
        if(n == 4) cout << 1 << '\n';
        else cout << ceil((round(ans[n / 2 - 1].real()) / 2)) << '\n';
    }
    return 0;
}
