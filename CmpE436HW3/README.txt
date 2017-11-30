This is the eclipse project folder for homework 3.

Student name: Irmak Kavasoglu
Student ID: 2013400090
irmakkavasoglu@gmail.com

Q1:
The classes are in eclipse project files, under src folder in Q1.

A.
For a race which is recognisable by lockset algorithm, see classes:
ObviousRace
ObviousRaceThread
This example has one static variable. The variable has initially 5 value. The thread updates this value. After the thread is started, there is a print. This print may output the initial value if the thread is slow, or the updated value if it was fast, it is a race. Since it is not protected by any locks, lockset algorithm will catch this.


For a race which is not recognisable by lockset algorithm, see classes:
LockSetRace
LockSetRaceThread
BinarySemaphore
This example has two threads and shared mutex and variable. The variable is only changed within a shared mutex, therefore LockSet algorithm doesnt see a race here. But since we don't know which thread will get the lock first, we can get different results in the end due to the race.

B.
For a race which is recognisable by happens before algorithm, see classes:
ObviousRace
ObviousRaceThread
This example has one static variable. The variable has initially 5 value. The thread updates this value. After the thread is started, there is a print. This print may output the initial value if the thread is slow, or the updated value if it was fast, it is a race. Since there is no happens before relation between the print statement and assignment in thread's run method, happens before relation will catch this.

For a race which is not recognisable by happens before algorithm, see classes:
HappensBeforeRace
HBRaceThread
CountingSemaphore
This example has a counting semaphore which has 2 available locks. We don't know which two of the existing 5 threads will get it first and which ones will get it last, but happens before relation is defined between locks and unlocks so the algorithm doesnt see the race.

C.
Since I have run the classes in RoadRunner but I haven't included the RR repo in this homework folder.

RoadRunner's HB methods are working very correctly. But it's LS algorithm doesnt work properly. I did my research and digged out this line from the published paper of the RoadRunner:

"Java locks are reentrant, but to simplify tool implementations, ROADRUNNER does not generate events for re-entrant lock acquires and releases, since they are no-ops."

Therefore the algorithm doesn't recognize java's Semaphores and Locks, leading to false negatives.

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
s2 only has one next node, which is s1. s1 has p, therefore it does not violate this condition. Correct.

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


