#!/bin/python3


import os
import sys

def matchUp_total(team, x, y):
    #print(str(x) + " " + str(y))
    # we can prove that if its team x's turn to attack and total strength of team_x >= total strength of team_y, then x wins! 
    # team stores cumsum 
    
    
    # matching up team x against team y 
    # return the winning team 
    team_x = team[x]
    team_y = team[y]        
    #print(team_x)
    #print(team_y)
    
    if len(team_x) == 0:
        return(y)
    if len(team_y) == 0:
        return(x)
    
    x_attacker = len(team_x) - 1
    y_attacker = len(team_y) - 1
    
    

    while True:
        if team_x[x_attacker] >= team_y[y_attacker]:
            # y is wiped out
            winner = x
            break
        if x_attacker > 0:
            attacker_x_str = team_x[x_attacker] - team_x[x_attacker-1]
        else:
            attacker_x_str = team_x[x_attacker] 
        
        if attacker_x_str >= y_attacker + 1:
            # y is wiped out
            winner = x
            break
        
        # y survives, now its y's turn to attack            
        y_attacker = (y_attacker+1 ) -  attacker_x_str - 1
        #print(y_attacker)
        if team_x[x_attacker] <= team_y[y_attacker]:
            # x is wiped out for sure 
            winner = y
            break
        if y_attacker > 0:
            attacker_y_str = team_y[y_attacker] - team_y[y_attacker-1]
        else:
            attacker_y_str = team_y[y_attacker]
        
        
        if attacker_y_str >= x_attacker + 1:
            winner = y
            break
        x_attacker = (x_attacker+1 ) -  attacker_y_str - 1
        
        
    
    return(winner)

def fightingPits(k, fighters, queries):
    #
    # Write your code here.
    #
    
    # process fighters
    team = {}
    for i in range(1, k +1):
        team[i] = []
    
    for fighter in fighters:
        #newitem = team[fighter[1]][-1] + fighter[0]
        team[fighter[1]].append(fighter[0])
        
    for k,v in team.items():
        sorted_v = [0] + sorted(v)
        # get cumsum
        for i in range(1,len(sorted_v)):
            sorted_v[i] = sorted_v[i] + sorted_v[i-1]
                
        team[k] = sorted_v[1:]
    
    #count = 0 
    
    # process queries 
    out = []
    for query in queries:
        if query[0]==1:
            if len(team[query[2]]) > 0:
                newitem = team[query[2]][-1] + query[1]
            else:
                newitem = query[1]
            team[query[2]].append(newitem) 
            # team[query[2]] = sorted(team[query[2]]) this line is not needed since new fighter is always the strongest 
        else:
            #count += 1
            winner = matchUp_total(team, query[1], query[2])
#             if count == 102:
#                 print(query[1])
#                 print(query[2])
#                 print(team[query[1]])
#                 print(team[query[2]])
#                 print(winner)
            out.append(winner)
    
    return(out)
    #
    # Write your code here.
    #

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nkq = input().split()

    n = int(nkq[0])

    k = int(nkq[1])

    q = int(nkq[2])

    fighters = []

    for _ in range(n):
        fighters.append(list(map(int, input().rstrip().split())))

    queries = []

    for _ in range(q):
        queries.append(list(map(int, input().rstrip().split())))

    result = fightingPits(k, fighters, queries)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
