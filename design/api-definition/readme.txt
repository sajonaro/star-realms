
description:

game api consist of following methods (self explanatory)

 - post  api/connect/{username}, return: unique id of player
 - put   api/{game-id}/game/{player-id}/join , return: HTTP_SUCCESS

 - get   api/game, return: [list of games] object 
 - post  api/game, return: unique game id
 - put   api/game/{player-id}/end,  return: HTTP_SUCCESS
 - put   api/{game-id}/game/start, return: HTTP_SUCCESS 



 - get   api/{game-id}/game/{player-id}/state, return: game state object 
 - put   api/{game-id}/game/{player-id}/move, provide 'move' object, return : HTTP_SUCCESS



 Configuring VULTR steps:
 1)  SSH into host
 2)  sudo apt update && sudo apt upgrade
 3)  useradd -m 'user'
 4)  passwd 'user' 'ENTER'
 5)  groupadd wheel
 6)  usermod -G wheel 'user'
 7)  vim /etc/sudoers  -> wheel ALL=(ALL)  ALL
 8)  su 'user'
 ##gen SSH key (locally):
 9)  ssh-keygen -t rsa -b 4096
 10) scp 'key'.PUB  'user'@ip :
 #on remote host
 11) mkdir .ssh, touch ./.ssh/authorized_keys , cat **.pub >> authorized_keys 