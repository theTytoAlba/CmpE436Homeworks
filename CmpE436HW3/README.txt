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
The critical1 and critical2 are testing if the qCritical/pCritical is eventually 1. We do not get any rule violation. This is because if process p is waiting, process q will do its noncritical atomic part and set s to 1, allowing process p to break the wait. Vice versa applies.

C.
The infCritical1 and infCritical2 are testing if they always eventually enter the critical section. Because of the critical1 and critical2, we know that we have both processes eventually enter the critical section. Since they are 2 processes, they will either always swich the critical section or one will eventually get into the full control of the critical section, making the other one lack the "always eventually entering" feature. But if this was true, we would have to have a case where one process doesn't meet the eventually entering feature. Since previous section explains that this does not happen, we can say that they will always enter the critical section one after the other. So this holds.

Q3:

A.
The tree is in q3tree.png in this level.

B.
The cases for s0 |= φ and s2 |= φ are:

i. 
s0 |= ¬p → r 
For s0; if there is no p, there is going to be r.
This is correct because the only state p doesnt exist is s0 and it has r.
s2 |= ¬p → r
For s2; if there is no p, there is going to be r.
s2 only has one next node, which is s1.

ii.
s0 |= Ft
For s0; there will eventually be a t.
form s0, we can go to s0 again. There is nothing stopping us from staying in s0 state forever. Since there is no t in s0, this is not correct.

s2 |= Ft
For s2; there will eventually be a t.
The only next node of s2 is s1, and it has t. Correct.

iii.
s0 |= Fq
For s0; there will eventually be a q.
form s0, we can go to s0 again. There is nothing stopping us from staying in s0 state forever. Since there is no q in s0, this is not correct.

s2 |= Fq
For s2; there will eventually be a q.
s2 itself has a q, therefore this holds.

iv.
s0 |= G (r ∨ q)
For s0, there is always either r or q present.
We can go to 4 states from s0:
 - s0 has r
 - s1 has r
 - s3 has q
 - s2 has r and q.
So this holds.

s2 |= G (r ∨ q)
For s2, there is always either r or q present.
We can go to 2 states from s2:
 - s1 has r
 - s2 has r and q.
So this holds.


