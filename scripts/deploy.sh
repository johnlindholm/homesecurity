#!/bin/bash

echo "scp /home/john/IdeaProjects/HomeSecurity/out/artifacts/Core_jar/Core.jar pi@rp2:/home/pi/projects/HomeSecurity"
sshpass -p "Johnli81" scp /home/john/IdeaProjects/HomeSecurity/out/artifacts/Core_jar/Core.jar pi@rp2:/home/pi/projects/HomeSecurity
echo "Done!"
