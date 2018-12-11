# springcloud-zookeeper-ribbon
springcloud整合zookeeper ribbon实现负载均衡

zookeeper自建

启动member项目 可以开启多个服务  端口号改一下就行 集群服务  轮询机智

再启动order服务  在浏览器里调用 order的api  http://localhost:8060/orderToMember 返回 调用集群的服务和端口号  
