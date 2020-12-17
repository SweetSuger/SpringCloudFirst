package hao.entity;

/**
 * Created by Administrator on 2020/12/15.
 */
public class RibbonServiceInfo {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ServiceInfo{" +
                "name='" + name + '\'' +
                '}';
    }
}
