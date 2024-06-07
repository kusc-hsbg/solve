#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cstring>

using namespace std;

const int MAX = 10001;
vector<int> adj[MAX];
bool visited[MAX];
int hackable[MAX];

int bfs(int start) {
    int count = 0;
    queue<int> q;
    q.push(start);
    visited[start] = true;
    
    while (!q.empty()) {
        int current = q.front();
        q.pop();
        count++;
        
        for (int next : adj[current]) {
            if (!visited[next]) {
                visited[next] = true;
                q.push(next);
            }
        }
    }
    
    return count;
}

int main() {
    int N, M;
    cin >> N >> M;
    
    for (int i = 0; i < M; i++) {
        int A, B;
        cin >> A >> B;
        adj[B].push_back(A);
    }
    
    int max_hack = 0;
    for (int i = 1; i <= N; i++) {
        memset(visited, false, sizeof(visited));
        hackable[i] = bfs(i);
        max_hack = max(max_hack, hackable[i]);
    }
    
    for (int i = 1; i <= N; i++) {
        if (hackable[i] == max_hack) {
            cout << i << " ";
        }
    }
    cout << endl;

    return 0;
}
