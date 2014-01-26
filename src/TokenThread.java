public class TokenThread implements Runnable {
   String name; // name of thread
   Thread t;
   boolean suspendFlag;
   boolean holdTkn = true;
   public TokenThread() {
      name = "token";
      t = new Thread(this, name);
      suspendFlag = false;
      t.start(); // Start the thread
   }
   // This is the entry point for thread.
   public void run() {
      try {
            int i = 0; 
            while(true){
                if(holdTkn == false && Main.form.hasToken() == true){
                    Main.form.sendToken(Main.form.nextAddress);
                }
                Thread.sleep(Main.form.sleepTime);
                synchronized(this) {
                  while(suspendFlag)
                     wait();
                }
            }
      } catch (InterruptedException e) {
         System.err.println(name + " interrupted.");
      }
   }
    void mysuspend() {
        suspendFlag = true;
    }
    synchronized void myresume() {
        suspendFlag = false;
        notify();
    }

    void holdToken() {
        holdTkn = true;
        this.mysuspend();
    }

    void startTokenPassing() {
        holdTkn = false;
        this.myresume();
    }
}
