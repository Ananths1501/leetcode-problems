int findDelayedArrivalTime(int at, int dt) {
    int t=at+dt;
    return t%24;
}