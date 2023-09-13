
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