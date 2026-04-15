#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
#include <queue>
#include <cstdint>

using namespace std;

int dx[6] = {1, -1, 0, 0, 0, 0};
int dy[6] = {0, 0, 1, -1, 0, 0};
int dz[6] = { 0, 0, 0, 0, 1, -1 };

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int M, N, H; // M: 가로, N: 세로, H: 높이
    
    cin >> M >> N >> H;

    /* 입력 : 아래층부터 순서대로 주어짐. 각 줄이 한 행임. 즉 N*H줄의 입력이 들어옴*/

    vector<vector<vector<int>>> grid(H, vector<vector<int>>(N, vector<int>(M)));

    for (int h = 0; h < H; h++) {
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                int tmp;
                cin >> tmp;
                grid[h][n][m] = tmp;
            }
        }
    }

    // Multi-Source BFS
    typedef struct{
        int x, y, z;
    }coord;
    queue<coord> q;
    
    for (int h = 0; h < H; h++) {
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (grid[h][n][m] == 1) q.push({ m, n, h });
            }
        }
    }

    while (!q.empty()) {
        coord c = q.front();
        q.pop();

        for (int i = 0; i < 6; i++) {
            int next_x = c.x + dx[i];
            int next_y = c.y + dy[i];
            int next_z = c.z + dz[i];

            if (next_x < 0 || next_x >= M || next_y < 0 || next_y >= N || next_z < 0 || next_z >= H) continue;

            if (grid[next_z][next_y][next_x] == 0) {
                grid[next_z][next_y][next_x] = grid[c.z][c.y][c.x] + 1;
                q.push({ next_x, next_y, next_z });
            }
        }
    }

    int max = 0;

    for (int h = 0; h < H; h++) {
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (grid[h][n][m] == 0) {
                    cout << "-1";
                    return 0;
                }
                if (grid[h][n][m] > max) max = grid[h][n][m];
            }
        }
    }

    cout << max-1;

    return 0;
}