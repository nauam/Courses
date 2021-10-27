#!/bin/sh

git clone https://github.com/qwsoftware/QWControl.git
cd QWControl
git checkout Homolog
cp version /home/qw
cd /home/qw
rm QWControl/ -rf