#!/bin/bash

echo "scp /home/john/IdeaProjects/HomeSecurity/out/artifacts/Core_jar/Core.jar pi@raspberrypi:/home/pi/projects/HomeSecurity"
sshpass -p "Johnli81" scp /home/john/IdeaProjects/HomeSecurity/out/artifacts/Core_jar/Core.jar pi@raspberrypi:/home/pi/projects/HomeSecurity
echo "Deployed!"
echo "Starting Core.jar..."
sshpass -p "Johnli81" ssh pi@raspberrypi 'java -jar projects/HomeSecurity/Core.jar'
