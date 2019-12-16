# dtx-parent

* 测试场景 
``` java
dtx-txmsg-brank1
dtx-txmsg-brank2  
  * bank1本地事务失败，则bank1不发送转账消息。
  * bank2接收转账消息失败，会进行重试发送消息。
  * bank2多次消费同一个消息，实现幂等。
```


* 测试场景
```java 
dtx-seata-brank1
dtx-seata-brank2
  * 张三向李四转账成功
  * 李四事务失败，张三事务回滚成功
  * 张三事务失败，李四事务回滚成功
  * 分支事务超时测试，事务回滚
```