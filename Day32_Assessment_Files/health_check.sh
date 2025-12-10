#!/bin/bash
echo "===== Disk Usage ====="
df -h
echo "===== Memory Usage ====="
free -h
echo "===== Running Java Processes ====="
ps -ef | grep java
