import manage.sys.annotation.Permission;

public class Test {

    @Permission("getGoods")
    public String test() {
        return null;
    }

    public static void main(String args[]) {

    }
}
