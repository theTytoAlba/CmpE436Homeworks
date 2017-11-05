byte y0 = 1; byte y1 = 0; byte s; 
byte pCritical = 0; byte qCritical = 0;

// Q2.a: Mutex check
ltl mutex { [] !(pCritical && qCritical) };
// Q2.b: Starvation check
ltl critical1 { <> pCritical };
ltl critical2 { <> qCritical };
// Q2.c: Always continue to enter check
ltl infCritical1 { []<> pCritical }
ltl infCritical2 { []<> qCritical }

// Process id 0
active proctype P() {
	do
 	:: // non-critical section
	 	atomic {
			y0 = 1;
			s = 0;
		} 

		// wait until condition 
		(y1 == 0 | s != 1);

		// critical section
		atomic {
			pCritical = 1; 
			y0 = 0;
			pCritical = 0;
		}
 	od
}

// Process id 1
active proctype Q() {
	do
 	:: // non-critical section
	 	atomic {
			y1 = 1;
			s = 1;
		} 

		// wait until condition
		(y0 == 0 | s != 0);

		// critical section 
		atomic {
			qCritical = 1;
			y1 = 0;
			qCritical = 0;
		}
 	od
}
