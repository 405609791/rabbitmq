# rabbitmq
消息服务：amqp可跨平台、线路层协议规范,rabbitmq实现了rmqp,支持消息集群，多语言客户端

安装费劲，建议使用 docker

docker 
https://hub.docker.com/_/rabbitmq
使用命令
安装docker

cmd执行
docker run -d --hostname my-rabbit --name some-rabbit -P rabbitmq:3-management

执行命令
docker run -d --hostname my-rabbit --name some-rabbit rabbitmq:3-management
CONTAINER ID        IMAGE                   COMMAND                  CREATED             STATUS              PORTS                                                                                                                                                     NAMES
cd1002578821        rabbitmq:3-management   "docker-entrypoint.s…"   37 seconds ago      Up 36 seconds       0.0.0.0:32773->4369/tcp, 0.0.0.0:32772->5671/tcp, 0.0.0.0:32771->5672/tcp, 0.0.0.0:32770->15671/tcp, 0.0.0.0:32769->15672/tcp, 0.0.0.0:32768->25672/tcp   some-rabbit

管理端端口：15672映射到32679
通信端端口：5672 映射到32771
可以页面访问：localhost:32769
账号密码：guest/juest

产看端口：
docker port some-rabbit


循环报错：
org.springframework.amqp.AmqpConnectException: java.net.ConnectException: Connection refused: connect
docker中的rabbitmq重启，端口号发生了变化，导致无法连接
例
//内部端口映射到外部
15672/tcp -> 0.0.0.0:32769
15672 -- 管理界面ui端口----因为是装在docker中所以，看他对应的外部接口。如果是安装在电脑中，直接使用这个端口就行

25672 -- server间内部通信口

rabbitmq 4种模式：
1、direct 与routing key 相同的队列都会收到消息(通过routing key 绑定到directExchange)
2、fanout 与方法绑定的队列，收到消息（RabbitFanoutConfig.FANOUTNAME 绑定到fanoutExchange）
3、topic 用通配符匹配
4、header  通过消息头 header 匹配（使用比较少）



window10 docker 安装
https://www.runoob.com/docker/windows-docker-install.html
docker 学习
https://blog.csdn.net/qq_19348391/article/details/82292253
docker网络模式详解
https://www.cnblogs.com/zuxing/articles/8780661.html
