class RouteDetails{
    double timeSum;
    double totalTripsMade;
    public RouteDetails(double timeSum, double totalTripsMade){
        this.timeSum = timeSum;
        this.totalTripsMade = totalTripsMade;
    }
}
class CheckInDetails{
    String stationName;
    int time;
    public CheckInDetails(String stationName, int time){
        this.stationName = stationName;
        this.time = time;
    }
}
class UndergroundSystem {
    Map<String, RouteDetails> routeDetails = new HashMap<>();
    Map<Integer, CheckInDetails> checkIN= new HashMap<>();
    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIN.put(id, new CheckInDetails(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        String startStation = checkIN.get(id).stationName;
        int startTime = checkIN.get(id).time;
        String route = startStation + "-" + stationName;
        int journeyTime = t - startTime;
        
        RouteDetails routeDetail = routeDetails.getOrDefault(route, new RouteDetails(0.0,0.0));
        
        double totalTripsTime = journeyTime + routeDetail.timeSum;
        double totalTrips = routeDetail.totalTripsMade +1;
        routeDetails.put(route, new RouteDetails(totalTripsTime, totalTrips));
        checkIN.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        RouteDetails routeDetail = routeDetails.get(startStation+ "-" + endStation);
        return routeDetail.timeSum / routeDetail.totalTripsMade;
    }
}
