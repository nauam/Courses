# courses

* Git Credentials

```sh
echo "https://user:pass@github.com" > .git-credentials
git config --global credential.helper store
```

* Create a new repository on the command line

```sh
echo "# a" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/nauam/a.git
git push -u origin main
```

* Push an existing repository from the command line

```sh
git remote add origin https://github.com/nauam/a.git
git branch -M main
git push -u origin main
```

* Repository to branch or folder

```sh
git clone 
git remote rm origin
git remote add origin https://github.com/nauam/courses.git
git pull
git branch -M UnB
git checkout UnB
git add .
git commit -m "UnB-OO_Pomodoro"
git push -u origin UnB
```

```sh
git clone https://github.com/nauam/courses.git
cd courses
git branch
git merge origin/UnB --allow-unrelated-histories
git add .
git commit -m "UnB-OO_Pomodoro"
git push -u origin main
```
