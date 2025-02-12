int trap(int* height, int heightSize) {
    if (heightSize == 0) {
        return 0;
    }

    int l = 0;
    int r = heightSize - 1;
    int lmax = height[l];
    int rmax = height[r];
    int water = 0;

    while (l < r) {
        if (lmax < rmax) {
            l++;
            if (height[l] > lmax) {
                lmax = height[l];
            } else {
                water += lmax - height[l];
            }
        } else {
            r--;
            if (height[r] > rmax) {
                rmax = height[r];
            } else {
                water += rmax - height[r];
            }
        }
    }

    return water;
}