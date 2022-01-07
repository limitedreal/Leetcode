package main;

public class Main {
    static Main instance=null;
    public static Main getInstance1(){
        if(instance!=null){
            synchronized (Main.class){
                if(instance!=null){
                    instance=new Main();
                }
            }
        }
        return instance;
    }
    public static Main getInstance2(){
        return Inner.inner;
    }
    static class Inner{
        static Main inner=new Main();
    }

}






