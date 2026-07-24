class UndergroundSystem {
    // checkIns: id -> [stationName, checkInTime]
    private Map<Integer, Pair<String, Integer>> checkIns;
    // travelStats: "startStation->endStation" -> [totalTime, tripCount]
    private Map<String, Pair<Double, Integer>> travelStats;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        travelStats = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkInInfo = checkIns.get(id);
        String startStation = checkInInfo.getKey();
        int startTime = checkInInfo.getValue();

        String route = startStation + "->" + stationName;
        double travelTime = t - startTime;

        Pair<Double, Integer> stats = travelStats.getOrDefault(route, new Pair<>(0.0, 0));
        travelStats.put(route, new Pair<>(stats.getKey() + travelTime, stats.getValue() + 1));

        checkIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "->" + endStation;
        Pair<Double, Integer> stats = travelStats.get(route);
        return stats.getKey() / stats.getValue();
    }
}
