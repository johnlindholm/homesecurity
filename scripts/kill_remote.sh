#!/bin/bash

sshpass -p "Johnli81" ssh pi@raspberrypi 'kill -9 $(jps | grep "jar" | grep -oE "[0-9]+?")'
