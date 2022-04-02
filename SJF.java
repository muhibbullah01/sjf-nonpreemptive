package com.muhib.os;

import java.util.*;
import java.util.Scanner;

public class SJF {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, pos, temp, total = 0;
		float atat = 0, awt = 0;
		System.out.println("Enter Number Processes: ");
		n = sc.nextInt();
		int pid[] = new int[n];
		int at[] = new int[n];
		int bt[] = new int[n];
		int wt[] = new int[n];
		int tat[] = new int[n];
		int ct[] = new int[n];
		
		for(int i=0; i<n; i++) {
			
			System.out.println("Enter Burst Time for Processes "+(i+1));
			bt[i] = sc.nextInt();
			pid[i] = i+1;
		}
		
		//Sorting the process according to burst time
		for(int i=0; i<n; i++) {
			pos = i;
			for(int j=i+1; j<n; j++) {
				if(bt[j] < bt[pos]) {
					pos=j;
				}
			}
			
			temp = bt[i];
			bt[i] = bt[pos];
			bt[pos] = temp;
			
			temp = pid[i];
			pid[i] = pid[pos];
			pid[pos] = temp;
		}
		//Waiting time
		wt[0] = 0;
		
		for(int i=1; i<n; i++) {
			
			wt[i] = 0;
			for(int j=0; j<i; j++) {
				wt[i] += bt[j];
			}
			total += wt[i];
		}
		awt = (float)total/n;
		total = 0;
		System.out.println("Process ID\tBurst"
	            + " Time\tWaiting Time\tTurnaround Time");
		for(int i=0; i<n; i++) {
			
			tat[i] = bt[i]+wt[i];
			total += tat[i];
			System.out.printf("%d\t\t%d\t\t%d\t\t%d\n", pid[i],bt[i],wt[i],tat[i]);
			
		}
		atat = (float)total/n;
		System.out.println("Average Waiting time: "+awt);
		System.out.println("Average Turn-around time: "+atat);
	}

}
