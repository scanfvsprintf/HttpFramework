# HttpFramework
一个小型的服务器框架</br>
主要成分包含：
请求类Request</br>
响应类Response</br>
分发器类Dispatcher</br>
接口Servlet</br>
主要架构思路：
启动服务器线程接收响应，根据URI，由分发器根据配置文件内容分发至具体的Servlet类处理。之后生成响应并返回至客户端。
