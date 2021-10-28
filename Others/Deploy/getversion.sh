#!/bin/sh

git clone https://github.com/<user>/<rep>.git
cd <rep>
git checkout <branch>
cp version /home/<user>
cd /home/<user>
rm <rep>/ -rf