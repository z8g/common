package other;

import java.util.Arrays;
import java.util.BitSet;

/**
 * 布隆过滤器
 *
 * @author zhaoxuyang
 */
public class BloomFileter implements IpList {

    public static void main(String[] args) {
        BloomFileter bloomFileter = new BloomFileter();
        System.out.println(bloomFileter.contains("127.0.0.1"));//存在，有误判率
        System.out.println(bloomFileter.contains("127.0.0.2"));//不存在，肯定正确
        System.out.println(bloomFileter.contains("0.24.255.234"));//不存在，但误判成存在
    }

    BitSet bitSet;

    public BloomFileter() {
        bitSet = new BitSet(1 << 10);//4*256
        loadIpList();
    }

    @Override
    public boolean contains(String ip) {
        int[] ips = getIpArray(ip);
        for (int i = 0; i < ips.length; i++) {
            int index = ips[i] * i + ips[i];
            if (!bitSet.get(index)) {
                return false;
            }
        }
        return true;
    }

    private void loadIpList() {
        String[] ipArray = {
            "127.0.0.1", "118.24.123.111", "123.111.111.234",
            "0.0.0.0", "118.24.123.111", "255.255.255.255"
        };
        for (String ip : ipArray) {
            int[] ips = getIpArray(ip);
            put(ips);
        }
    }

    /**
     * 将ip字符串转成int数组
     * @param ip
     * @return 
     */
    private int[] getIpArray(String ip) {
        return Arrays.stream(ip.split("\\."))
                .mapToInt(Integer::valueOf)
                .toArray();
    }
    private void put(int[] ips) {
        for (int i = 0; i < ips.length; i++) {
            int index = ips[i] * i + ips[i];
            //System.out.println(index);
            bitSet.set(index);
        }
    }
}
