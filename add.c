#include<stdio.h>
int main()
{
int bt[20],p[20],wt[20],tat[20],i,j,n,total=0,totalt=0,pos,temp;
float avg_wt,avg_tat;
printf("enter number of process:");
scanf("%d",&n);
printf("\n enter burst time:\n");
for(i=0;i<n;i++)
{
printf("p%d",i+1);
scanf("%d",&bt[i]);
p[i]=i+1;
}
for(i=0;i<n;i++)
{
pos=i;
for(j=i+1;j<n;j++)
{
if(bt[j]<bt[pos])
pos=j;
}
temp=bt[i];
bt[i]=bt[pos];
bt[pos]=temp;
temp=p[i];
p[i]=p[pos];
p[pos]=temp;
}

wt[0]=0;
for(i=1;i<n;i++)
{
wt[i]=0;
for(i=1;i<n;i++)
wt[i]+=bt[j];
total+=wt[i];
}
avg_wt=(float)total/n;
printf("\nprocess\t burst time\t wating time\t turnaround time");
for(i=0;i<n;i++)

{
tat[i]=bt[i]+wt[i];
totalT+tat[i];
printf("\np%d\t\t%d\t\t%\t\t\t%d",p[i],bt[i],wt[i],tat[i]);
}
avg_tat=(float)totalT/n:
printF("\n\n avrage wating time =%f",avg_wt);
printf("\n avrage turnaround time=%f",avg_tat);
}
