package net.zhaoxuyang.pattern.ste;

/**
 *
 * @author zhaoxuyang
 */
public class FlightSecurityTest {

    static class Passengers extends Thread {

        private final FlightSecurity flightSecurity;
        private final String idCard;
        private final String boardingPass;

        public Passengers(FlightSecurity flightSecurity,
                String idCard, String boardingPass) {
            this.flightSecurity = flightSecurity;
            this.idCard = idCard;
            this.boardingPass = boardingPass;
        }
  
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                flightSecurity.pass(boardingPass, idCard);
            }
        }
    }

    public static void main(String[] args) {
        final FlightSecurity flightSecurity = new FlightSecurity();
        new Passengers(flightSecurity, "A123", "AF12345").start();
        new Passengers(flightSecurity, "B123", "BF12345").start();
        new Passengers(flightSecurity, "C123", "CF12345").start();
    }
}
