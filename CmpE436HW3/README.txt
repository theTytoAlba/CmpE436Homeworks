This is the eclipse project folder for homework 3.

Student Name: Irmak Kavasoglu
Student ID: 2013400090

The RoadRunner folder has the suggested racer repo files.

Q1:
A.
For a race which is recognisable by lockset algorithm, see classes:

For a race which is not recognisable by lockset algorithm, see classes:

B.
For a race which is recognisable by happens before algorithm, see classes:

For a race which is not recognisable by happens before algorithm, see classes:

C.
RoadRunner is inside this repo. You can run it using the commands in the install.txt file.
I have added the project classes under test folder as well. So you can run:
 
rrrun -tool=HB test.Q1.HappensBeforeRace (there is a race but hb won’t find it)


for happens before algorithm.

Q2:
The promela code is inside the Spin folder, under Q2.

A.
The mutex ltl tests mutual exclusion. It doesn't get any violations when we run it.

B.
The critical1 and critical2 are testing if the qCritical/pCritical is eventually 1. When we run the ltl's, we get "unreached in xx" warnings. This is because in some cases (1 out of 12 to quote spin), one process cannot leave the wait condition.

Example case: initially y0=y1=0. Process p does its atomic section; y0=1, y1=s=0. Process q does its atomic section; y0=y1=s=1. Process p starts waiting because y0 is not 0 and s is 1. Process q enters critical section because s is not 0, runs the atomic part; y0=s=1, y1=0. Before process p can process the wait, process q enters the non-critical atomic section; y0=y1=s=1. So process p has to wait again, and we are back at the same state as its first wait. Therefore, eventually-entering claim does not hold.

C.
The infCritical1 and infCritical2 are testing if they always eventually enter the critical section. Since B says they might not eventually enter, they definitely cannot always eventually enter.
