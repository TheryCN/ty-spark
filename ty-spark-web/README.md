# Run master
spark-class org.apache.spark.deploy.master.Master

# Run many workers
spark-class org.apache.spark.deploy.worker.Worker spark://ip:port
(default port is 7077)

# Run shell
spark-shell --master spark://ip:port