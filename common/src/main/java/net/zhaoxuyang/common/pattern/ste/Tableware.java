package net.zhaoxuyang.common.pattern.ste;

/**
 *
 * @author zhaoxuyang
 */
public class Tableware {
    private final String toolName;

    public Tableware(String toolName){
        this.toolName = toolName;
    }
    
    @Override
    public String toString(){
        return "ToolName:" + toolName;
    }
}
