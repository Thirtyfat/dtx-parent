# dtx-parent
###### 用于研究测试SpringCloud分布式事务控制解决方案，包括2PC、TCC、可靠消息最终一致性，最大努力通知，所用技术包括：Seata，Hmily，RocketMQ等


* 测试场景 
``` java
最终消息一致性
dtx-txmsg-brank1
dtx-txmsg-brank2  
  * bank1本地事务失败，则bank1不发送转账消息。
  * bank2接收转账消息失败，会进行重试发送消息。
  * bank2多次消费同一个消息，实现幂等。
```


* 测试场景
```java 
2PC 
dtx-seata-brank1
dtx-seata-brank2
  * 张三向李四转账成功
  * 李四事务失败，张三事务回滚成功
  * 张三事务失败，李四事务回滚成功
  * 分支事务超时测试，事务回滚
```

* 测试场景
```java 
https://dromara.org/zh-cn/docs/hmily/configuration.html

TCC
dtx-tcc-brank1
dtx-tcc-brank2
两个账户分别在不同的银行(张三在bank1、李四在bank2)，bank1、bank2是两个微服务。交易过程是，张三给李四转账指定金额。
上述交易步骤，要么一起成功，要么一起失败，必须是一个整体性的事务。
    * 张三向李四转账成功。
    * 李四事务失败，张三事务回滚成功。
    * 张三事务失败，李四分支事务回滚成功。
    * 分支事务超时测试
```