package com.test.playerProblem;

import java.util.Scanner;

public class PlayerInheritance {
	public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int[] hockeyPlayers = new int[11];
        int[] footballPlayers = new int[11];

        for(int i = 0; i < 11; i++)
        {
            hockeyPlayers[i] = sc.nextInt();
        }

        for(int i = 0; i < 11; i++)
        {
            footballPlayers[i] = sc.nextInt();
        }
        
        Sport s = new Sport(hockeyPlayers, footballPlayers);
        try{
            HockeyTeam.class.getMethod("calculateHockeyScore");
            HockeyTeam.class.getMethod("findHighestGoalByIndividualInHockey");
            FootballTeam.class.getMethod("calculateFootballScore");
            FootballTeam.class.getMethod("findHighestGoalByIndividualInFootball");

            if(s instanceof HockeyTeam && s instanceof FootballTeam)
            {
                System.out.println(s.calculateHockeyScore());
                System.out.println(s.calculateFootballScore());
                System.out.println(s.findHighestGoalByIndividualInHockey());
                System.out.println(s.findHighestGoalByIndividualInFootball());
            }
        }
        catch (NoSuchMethodException ex)
        {
            System.out.println("No such function is exits");
        }
    }
}

class Sport implements HockeyTeam, FootballTeam{
	
	int[] hockeyPlayers; 
	int[] footballPlayers;
	
	public Sport(int[] hockeyArr, int[] footBallArr) {
		hockeyPlayers = hockeyArr;
		footballPlayers = footBallArr;
	}

	@Override
	public int calculateFootballScore() {
		int sum = 0;
		for(int goal: footballPlayers) {
			sum = sum + goal;
		}
		return sum;
	}

	@Override
	public int findHighestGoalByIndividualInFootball() {
		int highestGoal = 0;
		for(int goal: footballPlayers) {
			if(goal > highestGoal)
				highestGoal = goal;
		}
		return highestGoal;
	}

	@Override
	public int calculateHockeyScore() {
		int sum = 0;
		for(int goal: hockeyPlayers) {
			sum = sum + goal;
		}
		return sum;
	}

	@Override
	public int findHighestGoalByIndividualInHockey() {
		int highestGoal = 0;
		for(int goal: hockeyPlayers) {
			if(goal > highestGoal)
				highestGoal = goal;
		}
		return highestGoal;
	}
	
}

interface HockeyTeam{
	
	int calculateHockeyScore();
	
	int findHighestGoalByIndividualInHockey();
	
}

interface FootballTeam{
	
	int calculateFootballScore();

	int findHighestGoalByIndividualInFootball();
}
