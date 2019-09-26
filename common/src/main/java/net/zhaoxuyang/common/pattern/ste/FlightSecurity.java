package net.zhaoxuyang.common.pattern.ste;

/**
 *
 * @author zhaoxuyang
 */
public class FlightSecurity {

    private int count = 0;
    private String boardingPass = null;
    private String idCard = "null";

    /**
     * 加synchronized关键字是实现该模式的核心
     *
     * @param boardingPass
     * @param idCard
     */
    public synchronized void pass(String boardingPass, String idCard) {
        this.boardingPass = boardingPass;
        this.idCard = idCard;
        this.count++;
        check();
        
        System.out.println(this);
    }

    private void check() {
        if (boardingPass.charAt(0) != idCard.charAt(0)) {
            throw new RuntimeException("Exception:" + toString());
        }
    }

    @Override
    public String toString() {
        return "count:" + count
                + ", boardingPass:" + boardingPass
                + ",idCard:" + idCard;
    }
}
