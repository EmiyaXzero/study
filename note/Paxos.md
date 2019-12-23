# Paxos
**paxos算法是莱斯利·兰伯特于1990年提出的一种基于消息传递且具有高度容错特性的一致性算法，==是目前公认的解决分布式一致性问题的最有效的算法之一==。**

---

**paxos算法主要是解决例如机器宕机网络异常等情况下，快速且正确的在集群内部对某个数据的值保持一致，并且保证不论发生以上任何异常，都不会破坏整个系统的一致性。**


```
client:系统外部角色，请求发起者。
Propser:接受系统请求，向集群提出提议（propose）。并且在发生冲突时，起到冲突调节的作用。
Accpetor：提议投票和接收者，只有在形成发定人数（即多数派）事，提议才会最终被接受。
learner：提议接收者，backup，备份。
```

## basic paxos 四个阶段
- 1.phase 1a:Prepare
 proposer提出一个议案，编号为N，此N大于之歌proposer之前提提案编号。请求acceptors的quorum接受。
- 2.phase 1b:promise
如果N大于此acceptor之前接受的任何编号则接受，否则拒绝。
- 3.phase 2a：Accept
如果达到了多数派，proposer会发出accpet请求，此请求包含提案编号N，以及提案内容。
- 4.phase 2b:accepted
  如果此acceptor在此期间没有收到任何编号大于N的提案，则接受此提案内容，否则忽略。


```
basoc paxos存在的问题：活锁。假如接受之前一直有提案。结局方法：冲突的时候等待一个random time
2轮rpc
```
## Multi Paxos
leader 唯一的一个proposer
