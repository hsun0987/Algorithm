#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#include <queue>

using namespace std;

int dx[4] = { 1, -1, 0, 0 };
int dy[4] = { 0, 0, 1, -1 };

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    /*
    하루가 지나면 인접한(상하좌우) '안익은' 토마토가 익어요.
    Q: 토마토가 전부 익는 최소 일수

    최단이니깐 BFS
    초기 큐에 1인거 다 넣어야댐

    grid 자체의 요소를 +1씩 해서 넘겨준다면, 경로길이가 되지. 경로 길이가 곧 날짜다
    */

    int M, N;
    cin >> M >> N;
    vector<vector<int>> grid(N, vector<int>(M));

    int xi, yi;
    int cnta = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            int tmp;
            cin >> tmp;
            grid[i][j] = tmp;
        }
    }

    queue<pair<int, int>> q; // x, y

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (grid[i][j] == 1) {
                q.push({ j, i });
            }
        }
    }

    vector<vector<int>> visited(N, vector<int>(M, 0));

    while (!q.empty()) {
        pair<int, int> now = q.front();
        q.pop();

        int state = grid[now.second][now.first];
        if (state != -1 && state != 0) {
            for (int i = 0; i < 4; i++) {
                int next_x = now.first + dx[i];
                int next_y = now.second + dy[i];

                if (next_x < 0 || next_x >= M || next_y < 0 || next_y >= N)
                    continue;

                if (grid[next_y][next_x] == 0) {
                    grid[next_y][next_x] = grid[now.second][now.first] + 1;
                    q.push({ next_x, next_y });
                }
            }
        }
    }

    int m = 0;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if (grid[i][j] == 0) {
                cout << -1;
                return 0;
            }
            if (m < grid[i][j]) m = grid[i][j];
        }
    }

    cout << m-1;

    return 0;
}

/*

아 1이 여러개면 그건 또 병렬적이네...

*/