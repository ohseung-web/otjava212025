package bookself;

public interface Queue {
   void enQueue(String title);
   String deQueue(); // 꺼네기, FIFO
   int getSize();
}