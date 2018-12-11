package test;

class TestThread {
    private ThreadLocal<String> name=new ThreadLocal<>();
    public TestThread(String str){
        this.name.set(str);
        System.out.println("---"+this.name.get());
    }
    public String getName(){
        return name.get();
    }
    public void setName(String str){
        this.name.set(str);
    }

}

class Mytest extends Thread{
    private TestThread testThread;
    public Mytest(TestThread testThread,String name){
        super(name);
        this.testThread=testThread;
        }
        public  void run(){
        for(int i=0;i<10;i++){
            if(i==6){
                testThread.setName(getName());
        }
        System.out.println(testThread.getName()+"账户的i值"+i);
        }
        }
        }
        public class Account{
    public static void main (String[] args){
        TestThread tt=new TestThread("初始名");
        new  Mytest(tt,"线程甲").start();
        new Mytest(tt,"线程乙").start();


        }

        }