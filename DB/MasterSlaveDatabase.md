# 主从服务器配置

 购买云服务器两台，阿里云或腾讯云,安装配置MySQL



##一、安装mysql

###1. 安装需要使用root账号，如果不会设置root账号的请自行google。安装mysql过程中，需要设置mysql的root账号的密码，不要忽略了。

    sudo apt install mysql-server
    sudo apt install mysql-client
    sudo apt install libmysqlclient-dev

###2. 以上3个软件包安装完成后，使用如下命令查询是否安装成功：

    sudo netstat -tap | grep mysql 

###查询结果如下图所示，表示安装成功。

    root@xyz:~# netstat -tap | grep mysql

tcp6       0      0 [::]:mysql              [::]:*                  LISTEN      7510/mysqld     


##二、设置mysql远程访问

###1. 编辑mysql配置文件，把其中bind-address = 127.0.0.1注释了

    sudo vim /etc/mysql/mysql.conf.d/mysqld.cnf 

###2. 使用root进入mysql命令行，执行如下2个命令，示例中mysql的root账号密码：root

    sudo su
    mysql -uroot -p
    // grant all privileges on 库名.表名 to '用户名'@'IP地址' identified by '密码' with grant option;
    // flush privileges;
    grant all on *.* to root@'%' identified by 'root' with grant option;
    flush privileges;

###3. 重启mysql

    /etc/init.d/mysql restart

 ###重启成功后，在其他计算机上，便可以登录。



##三、主从库配置

###主库从库的ip地址

Master：

    172.27.0.12    132.232.121.57    VM-0-12-ubuntu

Slave：

    172.27.0.2     132.232.120.84    VM-0-2-ubuntu

### 编辑主库MySQL的配置文件

Master MySQL

    mysql -uroot -p密码
    mysql> show databases;
    mysql> quit;

    sudo vim /etc/mysql/mysql.conf.d/mysqld.cnf  #未必在此位置，也未必是此文件  

[mysqld]

#
# * Basic Settings
#

server-id=1
log-bin=master-bin
log-bin-index=master-bin.index



    /etc/init.d/mysql stop

    /etc/init.d/mysql start  # 重启

    mysql -uroot -p密码

    mysql> show master status;



+-------------------+----------+--------------+------------------+-------------------+

| File              | Position | Binlog_Do_DB | Binlog_Ignore_DB | Executed_Gtid_Set |

+-------------------+----------+--------------+------------------+-------------------+

| master-bin.000001 |      796 |              |                  |                   |

+-------------------+----------+--------------+------------------+-------------------+

1 row in set (0.00 sec)



    mysql> create user repl;

    mysql> GRANT REPLICATION SLAVE ON *.* TO 'repl'@'132.232.120.84' IDENTIFIED BY 'ren';

           GRANT REPLICATION SLAVE ON *.* TO 'repl'@'从库ip' IDENTIFIED BY '密码'

    mysql> flush privileges;



### 编辑从库MySQL的配置文件

Slave MySQL

    mysql -uroot -p密码
    mysql> show databases;
    mysql> quit;

    sudo vim /etc/mysql/mysql.conf.d/mysqld.cnf #未必在此位置，也未必是此文件
文件内容如下：
```sh
[mysqld]

#
# * Basic Settings
#
server-id=2
relay-log-index=slave-relay-bin.index
relay-log=slave-relay-bin
```

    /etc/init.d/mysql stop
    /etc/init.d/mysql start # 重启

    mysql -uroot -p密码
    mysql> show databases;
    mysql> change master to master_host='132.232.121.57',master_port=3306,master_user='repl',master_password='ren',master_log_file='master-bin.000001',master_log_pos=0;
    # change master to master_host='主库ip',master_port=3306,master_user='repl',master_password='ren',master_log_file='show master status->File',master_log_pos=0;

    mysql> start slave; #开启主从同步
    mysql> show databases;
    mysql> show slave status \G;  # 查看是否有错误

    #如果存在错误则
    mysql> stop slave;   #停止主从同步，处理错误

结果如下（show slave status \G;）
```sh
*************************** 1. row ***************************
               Slave_IO_State: Waiting for master to send event
                  Master_Host: 132.232.121.57
                  Master_User: repl
                  Master_Port: 3306
                Connect_Retry: 60
              Master_Log_File: master-bin.000001
          Read_Master_Log_Pos: 1244
               Relay_Log_File: slave-relay-bin.000002
                Relay_Log_Pos: 1459
        Relay_Master_Log_File: master-bin.000001
             Slave_IO_Running: Yes
            Slave_SQL_Running: Yes
              Replicate_Do_DB:
          Replicate_Ignore_DB:
           Replicate_Do_Table:
       Replicate_Ignore_Table:
      Replicate_Wild_Do_Table:
  Replicate_Wild_Ignore_Table:
                   Last_Errno: 0
                   Last_Error:
                 Skip_Counter: 0
          Exec_Master_Log_Pos: 1244
              Relay_Log_Space: 1666
              Until_Condition: None
               Until_Log_File:
                Until_Log_Pos: 0
           Master_SSL_Allowed: No
           Master_SSL_CA_File:
           Master_SSL_CA_Path:
              Master_SSL_Cert:
            Master_SSL_Cipher:
               Master_SSL_Key:
        Seconds_Behind_Master: 0
Master_SSL_Verify_Server_Cert: No
                Last_IO_Errno: 0
                Last_IO_Error:
               Last_SQL_Errno: 0
               Last_SQL_Error:
  Replicate_Ignore_Server_Ids:
             Master_Server_Id: 1
                  Master_UUID: 6e8ced5d-a6d0-11e8-9fe8-5254008b5ccd
             Master_Info_File: /var/lib/mysql/master.info
                    SQL_Delay: 0
          SQL_Remaining_Delay: NULL
      Slave_SQL_Running_State: Slave has read all relay log; waiting for more up datas
           Master_Retry_Count: 86400
                  Master_Bind:
      Last_IO_Error_Timestamp:
     Last_SQL_Error_Timestamp:
               Master_SSL_Crl:
           Master_SSL_Crlpath:
           Retrieved_Gtid_Set:
            Executed_Gtid_Set:
                Auto_Position: 0
         Replicate_Rewrite_DB:
                 Channel_Name:
           Master_TLS_Version:
1 row in set (0.00 sec)
```

#四、测试

### 在主库新建数据库

### 编辑主库MySQL的配置文件

Master MySQL

    mysql -uroot -p密码
    mysql> create database o2o;

###查看从库情况

Slave MySQL
    mysql -uroot -p密码
    mysql> show databases;

```sh
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| o2o                |
| performance_schema |
| sys                |
+--------------------+
5 rows in set (0.00 sec)
```

### Master

    mysql> drop database o2o;
    mysql> show master status;
    mysql> select user,host from mysql.user;

### Slave

    mysql> show databases;
    mysql> show slave status \G;

###对比show master status;的Position 与

    show slave status \G;的Read_Master_Log_Pos
    
#五、主从同步故障修复

 暂空
