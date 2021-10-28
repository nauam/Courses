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

## Repository to branch or folder

* Inserting the source repository (rep_src) into a branch in a destination repository (branch_dest).

```sh
git clone https://github.com/<user>/<rep_src>.git
cd <rep_src>
git remote rm origin
git remote add origin https://github.com/<user>/<rep_dest>.git
git pull
git branch -M <new branch_dest>
git checkout <new branch_dest>
git add .
git commit -m "rep_src"
git push -u origin <new branch_dest>
```

* Forcing the merge between the main branches and the branch_dest branch.

```sh
git clone https://github.com/<user>/<rep_dest>.git
cd <rep_dest>
git merge origin/<new branch_dest> --allow-unrelated-histories
git add .
git commit -m "rep_src"
git push -u origin main
```
