# 为什么Java String设计为不可变的
[资料文档](https://www.baeldung.com/java-string-immutable)

有以下几个方面原因
* String Pool
* Security
* Performance
* Synchronization
* Hashcode Caching

## String Pool
字符串是使用最广泛的数据结构。缓存且重新使用可以节省大量堆内存使用空间。
```
String str1 = "Hello World!";
String str2 = "Hello World!";
str1 == str2; //true
String str3 = new String("Hello Wrold!");
str1 == str3; //false
str1 == str3.intern();//true
```

## Security
```
void criticalMethod(String userName) {
    // perform security checks
    if (!isAlphaNumeric(userName)) {
        throw new SecurityException(); 
    }
     
    // do some secondary tasks
    initializeDatabase();
     
    // critical task
    connection.executeUpdate("UPDATE Customers SET Status = 'Active' " +
      " WHERE UserName = '" + userName + "'");
}
```
如果在字符串是可变，上面这段代码可能会产生安全性的问题，在检查完安全性之后，数据插入数据库之前 userName 被外部改变，
这时可能出现安全性问题。
## Hashcode Caching
HashMap、HashTable、HashSet 等以 String 为 key 时，需要计算 key 的 hash 值。不可变性才能保证 String 的 hash 值
不会被改变。
## Synchronization
不可变性可以被多个线程之间共享。
## Performance
即可重用节省堆内存，快速的 hash 操作。 String Pool、Hashcode Caching。