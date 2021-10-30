## Basic overview of the system design.

1. **[DNS](https://www.cloudflare.com/learning/dns/glossary/dns-root-server/):**
DNS stands for `Domain Name System` and it’s a backbone technology that makes the world wide web possible.
At the most basic level DNS provides a key/value lookup from a domain name (e.g., `google.com`) to an IP address (e.g., `85.129.83.120`),
which is required in order for your computer to route a request to the appropriate server.

2. **[Horizontal vs Vertical Scaling](https://stackoverflow.com/questions/11707879/difference-between-scaling-horizontally-and-vertically-for-databases):** `horizontal` scaling means that you scale by adding more machines into your pool of resources 
whereas `vertical` scaling means that you scale by adding more power (e.g., CPU, RAM) to an existing machine.

3. **[Load Balancer](https://www.f5.com/services/resources/glossary/load-balancer):** A load balancer is a device that acts as a reverse proxy and distributes network or application traffic across a number of servers and which evenly distributes incoming traffic among web servers that are defined in a
   load-balanced set. Load balancers are used to increase capacity (concurrent users) and reliability of applications. Standard algorithms are:
   1. Round-robin
   2. Weighted round-robin 
   3. Least connections 
   4. Least response time
4. **[Database Replication](https://www.geeksforgeeks.org/data-replication-in-dbms/):** is the process of storing data in more than one site or node. It is useful in improving the availability of data. It is simply copying data from a database from one server to another server so that all the users can share the same data without any inconsistency.
The result is a distributed database in which users can access data relevant to their tasks without interfering with the work of others.

5. **[Cache](https://akshay-iyangar.github.io/system-design/grokking-system-design/system-design-basics/caching.html):** A cache is a temporary storage area that stores the result of expensive responses or frequently
   accessed data in memory so that subsequent requests are served more quickly.

6. **[Content delivery network (CDN)]():** A CDN is a network of geographically dispersed servers used to deliver static content. CDN
   servers cache static content like images, videos, CSS, JavaScript files, etc. Dynamic content caching enables the caching of HTML pages that are based on request path, query strings, cookies,
   and request headers.

7. **[Key characteristics](https://akshay-iyangar.github.io/system-design/grokking-system-design/system-design-basics/key-charactersitics-of-distributed-systems.html)** of a distributed system include:
   1. **Scalability:** Scalability is the capability of a system, process, or a network to grow and manage increased demand. Any distributed system that can continuously evolve in order to support the growing amount of work is considered to be scalable.
   2. **Reliability:** Reliability is the probability a system will fail in a given period. In simple terms, a distributed system is considered reliable if it keeps delivering its services even when one or several of its software or hardware components fail.
   3. **Availability** By definition, availability is the time a system remains operational to perform its required function in a specific period. It is a simple measure of the percentage of time that a system, service, or a machine remains operational under normal conditions.
   4. **Efficiency:**  Two standard measures of its efficiency are the response time (or latency) that denotes the delay to obtain the first item and the throughput (or bandwidth) which denotes the number of items delivered in a given time unit (e.g., a second).

8. **[Stateless Server](https://www.proud2becloud.com/stateful-vs-stateless-the-good-the-bad-and-the-ugly/):**
   1. The server processes requests based only on information relayed with each request and doesn’t rely on information from earlier requests – this means that the server doesn’t need to hold onto state information between requests (or the state can be held into an external service, like a database)
   2. Different requests can be processed by different servers
   3. The fact that any service instance can retrieve al service state necessary to execute a behavior from elsewhere enables resiliency, elasticity, and the ability for any available service instance to execute any task at all
   
9. **[Stateful Server](https://www.proud2becloud.com/stateful-vs-stateless-the-good-the-bad-and-the-ugly/):**
   1. Stateful services are either a database or based on an internet protocol that needs a tight state handling on a single host
   2. The server processes requests based on the information relayed with each request and information stored from earlier requests
   3. The same server must be used to process all requests linked to the same state information, or the state information needs to be shared with all servers that need it
   
10. **[Data Centers]():** In normal operation, users are
    geoDNS-routed, also known as geo-routed, to the closest data center, with a split traffic of
    x% in US-East and (100 – x)% in US-West. geoDNS is a DNS service that allows domain
    names to be resolved to IP addresses based on the location of a user. 

11. **[Message Queue](https://medium.com/must-know-computer-science/system-design-message-queues-245612428a22):** A message queue is a durable component, stored in memory, that supports asynchronous
    communication. It serves as a buffer and distributes asynchronous requests. The basic
    architecture of a message queue is simple. Input services, called producers/publishers, create
    messages, and publish them to a message queue. Other services or servers, called
    consumers/subscribers, connect to the queue, and perform actions defined by the messages.

12. **[Logging]():** Monitoring error logs is important because it helps to identify errors and problems
    in the system. You can monitor error logs at per server level or use tools to aggregate them to
    a centralized service for easy search and viewing.
13. **[Metrics]():** Collecting different types of metrics help us to gain business insights and understand
    the health status of the system. Some following metrics are useful:
    1. Host level metrics: CPU, Memory, disk I/O, etc. 
    2. Aggregated level metrics: for example, the performance of the entire database tier, cache tier, etc. 
    3. Key business metrics: daily active users, retention, revenue, etc.
    
14. **[Automation]():** When a system gets big and complex, we need to build or leverage automation
    tools to improve productivity. Continuous integration is a good practice, in which each code
    check-in is verified through automation, allowing teams to detect problems early. Besides,
    automating your build, test, deploy process, etc. could improve developer productivity
    significantly.

15. **[Sharding](https://www.mongodb.com/features/database-sharding-explained):** Sharding is a method for distributing a single dataset across multiple databases, which can then be stored on multiple machines. 
This allows for larger datasets to be split in smaller chunks and stored in multiple data nodes, increasing the total storage capacity of the system.