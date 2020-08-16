# JavaNote12345
将.idea目录加入ignore清单：

$ echo '.idea' >> .gitignore

 从git中删除idea：
$ git rm -cached -r .idea

将.gitignore文件加入git：
$ git add .gitignore

Commit gitignore文件，将.idea从源代码仓库中删除：
 $ git commit -m 'gitignore commit and remove .idea'

Push到服务器：
  $ git push
