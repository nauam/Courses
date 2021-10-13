# courses


git clone 
git remote rm origin
git remote add origin https://github.com/nauam/courses.git
git pull
git branch -M UnB
git checkout UnB
git add .
git commit -m "UnB-OO_Pomodoro"
git push -u origin UnB

git clone https://github.com/nauam/courses.git
cd courses
git branch
git merge origin/UnB --allow-unrelated-histories
git add .
git commit -m "UnB-OO_Pomodoro"
git push -u origin main
