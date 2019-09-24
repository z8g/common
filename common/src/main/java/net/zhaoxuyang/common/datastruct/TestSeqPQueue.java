package net.zhaoxuyang.common.datastruct;

/**
 *
 * @author Administrator
 */
public class TestSeqPQueue {
    public static void main(String[] args) throws Exception{
        SeqPQueue queue = new SeqPQueue();
        Element temp;
        queue.append(new Element(1,30));
        queue.append(new Element(2,20));
        queue.append(new Element(3,40));
        queue.append(new Element(4,60));
        queue.append(new Element(5,50));
        queue.append(new Element(6,70));
        queue.append(new Element(7,20));
        queue.append(new Element(8,30));
        
        while(queue.notEmpty()){
            temp = (Element) queue.delete();
            System.out.println(temp.getData() + ":" + temp.getPriority());
        }
        
    }
}
