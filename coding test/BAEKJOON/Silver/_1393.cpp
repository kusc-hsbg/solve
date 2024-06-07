#include <iostream>
#include <cmath>
using namespace std;

int x_pt, y_pt, X, Y, del_x, del_y;
pair<int, int> near_point;

double getDistance(int x, int y) {
    return pow((x - x_pt), 2) + pow((y - y_pt), 2);
}

int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}

void findNearestPoint() {
    double x = X, y = Y;
    double currentDist = getDistance(X, Y);
    near_point = {X, Y};

    while (true) {
        x += del_x;
        y += del_y;
        double newDist = getDistance(x, y);

        if (newDist > currentDist) {
            break;
        }

        currentDist = newDist;
        near_point = {static_cast<int>(x), static_cast<int>(y)};
    }
}

void simplifyDirection() {
    int gcd_value = gcd(abs(del_x), abs(del_y));

    if (gcd_value != 0) {
        del_x /= gcd_value;
        del_y /= gcd_value;
    }
}

int main() {
    cin >> x_pt >> y_pt;
    cin >> X >> Y >> del_x >> del_y;

    simplifyDirection();
    findNearestPoint();

    cout << near_point.first << " " << near_point.second << endl;

    return 0;
}