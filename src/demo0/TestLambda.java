package demo0;

public class TestLambda {

    // 减少实现类，直接写成静态内部类
    static class Like2 implements ILike{
        @Override
        public void lambda() {
            System.out.println("222");
        }
    }

    public static void main(String[] args) {
        // 利用实现类实现
        ILike like = new Like();
        like.lambda();

        // 利用静态内部类实现
        like = new Like2();
        like.lambda();

        // 我们也可以不同静态内部类，可以使用局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("333");
            }
        }
        // 利用局部内部类实现
        like = new Like3();
        like.lambda();

        // 再或者就是匿名内部类了
        like = new Like() {
            @Override
            public void lambda() {
                System.out.println("444");
            }
        };
        // 利用匿名内部类实现
        like.lambda();

        // 最终简化-> lambda
        like = ()->{
            System.out.println("555");
        };
        like.lambda();
    }
}

// 定义一个函数式接口
interface ILike {
    void lambda();
}
// 实现类
class Like implements ILike{
    @Override
    public void lambda() {
        System.out.println("111");
    }
}