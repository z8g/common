package other;

import java.io.Serializable;
import java.util.BitSet;

/**
 * 布隆过滤器
 * @author zhaoxuyang
 */
public class BloomFileter implements Serializable,IpList{

    private static final long serialVersionUID = 172137471279432L;
    
    public static void main(String[] args) {
        BloomFileter bloomFileter = new BloomFileter();
        System.out.println(bloomFileter.contains("127.0.0.1"));
    }
    
    BitSet bitSet;
    
    public BloomFileter(){
        bitSet = new BitSet();
        loadIpList();
    }

    @Override
    public boolean contains(String ip) {
        int bitIndex = getBitIndex(ip);
        return bitSet.get(bitIndex);
    }

    private void loadIpList() {
        String[] ipArray = {
          "127.0.0.1","118.24.123.111","123.111.111.234"
        };
        for(String ip :ipArray){
            int bitIndex = getBitIndex(ip);
            bitSet.set(bitIndex);
        }
    }
    private int getBitIndex(String ip){
        int hash = ip.hashCode();
        return ((hash >>> (Integer.SIZE- 1)) ^ 1);
    }
}
