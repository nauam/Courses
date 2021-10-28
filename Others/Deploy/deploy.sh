#! /bin/bash

git clone https://github.com/<user>/<rep>.git
cd <rep>
git checkout deploy_homolog
mv <software>.conf /etc/<software>.conf
mv docker-compose.yml jenkins.sh nginx.conf version deploy.sh getversion.sh /home/<user>
cd ..
rm -r <rep>