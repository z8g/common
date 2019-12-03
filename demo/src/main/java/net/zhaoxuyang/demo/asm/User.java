
package net.zhaoxuyang.demo.asm;

/**
 *
 * @author zhaoxuyang
 */
public class User {
    private String name;
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void goMethod(){
        System.out.println("go");
    }
    
    @Override
    public String toString() {
        return "User{" + "name=" + name + ", id=" + id + '}';
    }
    
}
