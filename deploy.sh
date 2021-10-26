#! /bin/bash

git clone https://github.com/qwsoftware/QWControl_Docs.git
cd QWControl_Docs
git checkout deploy_homolog
mv qwcontrol.conf /etc/qwcontrol.conf
mv docker-compose.yml jenkins.sh nginx.conf version deploy.sh /home/qw
cd ..
rm QWControl/ -rf