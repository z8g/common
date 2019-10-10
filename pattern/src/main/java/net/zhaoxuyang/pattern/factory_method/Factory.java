package net.zhaoxuyang.pattern.factory_method;

public class Factory extends AbstractFactory{

    @Override
    public <T extends Product> T createProduct(Class<T> c) {
        Product result = null;
        try {
            result = (T) Class.forName(c.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return (T)result;
    }
}
