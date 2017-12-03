Student name: Irmak Kavasoglu
Student ID: 2013400090
irmakkavasoglu@gmail.com

Q1:
It is not possible to generate the Lamport's clock using only one vector clock. The explanation follows.

If we were able to convert a vector clock to a Lamport's clock, we would know that there is only one Lamport's clock corresponding to a vector clock. However, there can be more than one case which generates the same vector clock, and the Lamport clocks of the vector clock can be different.

Example:
__Case 1__
(1,0,0)                                   (2,2,3)
                                        /
(0,1,0)                         (0,2,3)
                              /
(0,0,1) -> (0,0,2) -> (0,0,3)

Consider the case above. The Lamport's clocks are as follows:
(1,0,0) = (0,1,0) = (0,0,1) = 1
(0,0,2) = 2
(0,0,3) = 2
(0,2,3) = 4
(2,2,3) = 5

__Case 2__
(1,0,0)                           (2,2,3)
                                /
(0,1,0) -> (0,2,0)             /          
                   \          /
(0,0,1) -> (0,0,2)   (0,2,3)

Consider the case above. The Lamport's clocks are as follows:
(1,0,0) = (0,1,0) = (0,0,1) = 1
(0,0,2) = (0,2,0) = 2
(0,2,3) = 3
(2,2,3) = 4

We can see that in case 1 and case 2, the vector clock (0,2,3) can correspond to both 3 and 4. Also, vector clock (2,2,3) can correspond to 4 or 5. Therefore, we can not declare a convert function which takes in a vector clock and gives the Lamport's clock, because there can be more than one corresponding Lamport's clocks.

__An alternative solution__
The pseudocode here, and explanation below it.

////////////
function convert(vectorClock);

input: a vector clock named vectorClock, it is an array of integers.
output: an integer for the logical clock value.

logicalClock <- 0
for all value in vectorClock do
	logicalClock <- logicalClock + value
end for

return logicalClock
///////////

Vector clocks may not be able to tell us the actual Lamport's clock value directly but they can preserve the happens before relations.

We need to take into consideration 2 things.
1. Preserving event order in processes
2. Preseving happens before relations.

The convert function simply sums up all the values of the vector clock to produce a logical clock. Let's see how this works for the 2 constraints we have.

1. Preserving event order in processes
The vector clock always ticks for each event in the process i. Let's have a clock A[] for process i, at time t_0. For any time t > t_0, we know that A[i] > A_new[i]. We also know that other values in A, either stays the same or gets larger if we receive some message and update their values. Therefore, we can say that the sum of the clock A will always be smaller than sum of A_new. First condition holds.

2. Preserving happens before relations
When there is a message, there is a happens before relation. The way that the vector clock handles this is to use a max function; the receiving process will update its clock values to the maximum value of its own clock and the received clock. This makes sure that A_new > A and A_new > B, where the B is the received clock. We surely know that this process also means the sum of all values inside the clock satisfies the same condition, therefore the second condition holds too.

Therefore we can use this function to create a total order, which should be good enough to use in a function which requires Lamport's clock values.

Q2:
s → t iff ((s.v[s.p] ≤ t.v[s.p]) and (s.v[t.p] < t.v[t.p]))

We will prove this in 2 parts:
Part 1: (s → t) => ((s.v[s.p] ≤ t.v[s.p]) and (s.v[t.p] < t.v[t.p]))
Part 2: ((s.v[s.p] ≤ t.v[s.p]) and (s.v[t.p] < t.v[t.p])) => (s → t)

Before we start proving, let's remember the definition of s -> t.

__Definition__
In slide 5.2, page 21:

s → t iff s.v < t.v

So what does s.v < t.v mean? 
- For every i, s.v[i] <= t.v[i]
– For at least one i, s.v[i] < t.v[i]

__Part 1__
(s → t) => ((s.v[s.p] ≤ t.v[s.p]) and (s.v[t.p] < t.v[t.p]))

From the definition, we know that 
s → t iff s.v < t.v 
and therefore
s → t => s.v < t.v
and also
s.v < t.v => s.v[i] ≤ t.v[i] where there is at least one s.v[i] < t.v[i]
which makes
s → t =>  s.v[i] ≤ t.v[i] where there is at least one s.v[j] < t.v[j]

If we put s.p in the place of i, we can see that (s.v[s.p] ≤ t.v[s.p]) holds. We also know that if s happened before t, there is going to be a message from s to t, and upon receiving the message t will immediately increase it's t.v[t.p]. Therefore (s.v[t.p] < t.v[t.p]) happens and we satisfy the "at least one strictly less element" condition. Part 1 proven.

__Part 2__
((s.v[s.p] ≤ t.v[s.p]) and (s.v[t.p] < t.v[t.p])) => (s → t)

From the definition we know that
s → t iff s.v < t.v 
and therefore
s.v < t.v => s → t
which makes
s.v[i] ≤ t.v[i] (where there is at least one s.v[j] < t.v[j]) =>  s → t 

Since for i = t.p, there is a strictly less condition, so we satisfy the at least one strictly less condition. Now we need to reach s.v[i] ≤ t.v[i].

The value of v[i] is always maximum in the ith process, because only ith clock can tick it. So we know that i.v[s.p] ≤ s.v[s.p]. If we also know that (s.v[s.p] ≤ t.v[s.p]), we can replace i with t and we can get

s.v[s.p] ≤ t.v[s.p]) and t.v[s.p] ≤ s.v[s.p] => t.v[s.p] = s.v[s.p].

If we know that both process t and s has the value of s the same, s must have sent a message to t (this can happen via other processes) so t can update the value of s to match the value of s in process s; and s shouldn't have any following event because if it had, the value of s in process s would increase (and break the equality).

We know that if s has just sent a message to t, it also sent the other processes' values, and upon receiving, t has updated its vector by taking the maximum of the value in its own vector and the message's vector. Now we can say that s.v[i] ≤ t.v[i] where (s.v[t.p] < t.v[t.p]), hence (s → t). Part 2 proven.

Proof complete.