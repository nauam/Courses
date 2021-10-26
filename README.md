# QW Control Deploy

<p align="center">
    <img src="https://img.shields.io/static/v1?label=node&message=v12&color=green&style=for-the-badge&logo=node.js"/> <img src="https://img.shields.io/static/v1?label=vuepress&message=v1.8&color=green&style=for-the-badge&logo=vuepress"/>
    <img src="http://img.shields.io/static/v1?label=STATUS&message=Build&color=green&style=for-the-badge"/> <img src="http://img.shields.io/static/v1?label=OS&message=Debian&color=green&style=for-the-badge"/>
</p>

## Getting starting
### Servidor

```sh
git clone https://github.com/qwsoftware/QWControl_Docs.git
cd QWControl_Docs
git checkout deploy_homolog
mv qwcontrol.conf /etc/qwcontrol.conf
mv docker-compose.yml jenkins.sh nginx.conf version /home/qw
cd ..
rm QWControl/ -rf

export TAG=v1.2.4.8
docker-compose up -d
```
