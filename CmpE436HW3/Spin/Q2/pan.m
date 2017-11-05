#define rand	pan_rand
#define pthread_equal(a,b)	((a)==(b))
#if defined(HAS_CODE) && defined(VERBOSE)
	#ifdef BFS_PAR
		bfs_printf("Pr: %d Tr: %d\n", II, t->forw);
	#else
		cpu_printf("Pr: %d Tr: %d\n", II, t->forw);
	#endif
#endif
	switch (t->forw) {
	default: Uerror("bad forward move");
	case 0:	/* if without executable clauses */
		continue;
	case 1: /* generic 'goto' or 'skip' */
		IfNotBlocked
		_m = 3; goto P999;
	case 2: /* generic 'else' */
		IfNotBlocked
		if (trpt->o_pm&1) continue;
		_m = 3; goto P999;

		 /* CLAIM critical1 */
	case 3: // STATE 1 - _spin_nvr.tmp:4 - [(!(pCritical))] (0:0:0 - 0)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported1 = 0;
			if (verbose && !reported1)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported1 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported1 = 0;
			if (verbose && !reported1)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported1 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[2][1] = 1;
		if (!( !(((int)now.pCritical))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 4: // STATE 6 - _spin_nvr.tmp:6 - [-end-] (0:0:0 - 0)
		
#if defined(VERI) && !defined(NP)
#if NCLAIMS>1
		{	static int reported6 = 0;
			if (verbose && !reported6)
			{	int nn = (int) ((Pclaim *)pptr(0))->_n;
				printf("depth %ld: Claim %s (%d), state %d (line %d)\n",
					depth, procname[spin_c_typ[nn]], nn, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported6 = 1;
				fflush(stdout);
		}	}
#else
		{	static int reported6 = 0;
			if (verbose && !reported6)
			{	printf("depth %d: Claim, state %d (line %d)\n",
					(int) depth, (int) ((Pclaim *)pptr(0))->_p, src_claim[ (int) ((Pclaim *)pptr(0))->_p ]);
				reported6 = 1;
				fflush(stdout);
		}	}
#endif
#endif
		reached[2][6] = 1;
		if (!delproc(1, II)) continue;
		_m = 3; goto P999; /* 0 */

		 /* PROC Q */
	case 5: // STATE 1 - q2.pml:39 - [y1 = 1] (0:0:1 - 0)
		IfNotBlocked
		reached[1][1] = 1;
		(trpt+1)->bup.oval = ((int)now.y1);
		now.y1 = 1;
#ifdef VAR_RANGES
		logval("y1", ((int)now.y1));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 6: // STATE 2 - q2.pml:40 - [s = 1] (0:0:1 - 0)
		IfNotBlocked
		reached[1][2] = 1;
		(trpt+1)->bup.oval = ((int)now.s);
		now.s = 1;
#ifdef VAR_RANGES
		logval("s", ((int)now.s));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 7: // STATE 4 - q2.pml:44 - [(((y0==0)||(s!=1)))] (0:0:0 - 0)
		IfNotBlocked
		reached[1][4] = 1;
		if (!(((((int)now.y0)==0)||(((int)now.s)!=1))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 8: // STATE 5 - q2.pml:48 - [qCritical = 1] (0:0:1 - 0)
		IfNotBlocked
		reached[1][5] = 1;
		(trpt+1)->bup.oval = ((int)qCritical);
		qCritical = 1;
#ifdef VAR_RANGES
		logval("qCritical", ((int)qCritical));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 9: // STATE 6 - q2.pml:49 - [y1 = 0] (0:0:1 - 0)
		IfNotBlocked
		reached[1][6] = 1;
		(trpt+1)->bup.oval = ((int)now.y1);
		now.y1 = 0;
#ifdef VAR_RANGES
		logval("y1", ((int)now.y1));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 10: // STATE 7 - q2.pml:50 - [qCritical = 0] (0:0:1 - 0)
		IfNotBlocked
		reached[1][7] = 1;
		(trpt+1)->bup.oval = ((int)qCritical);
		qCritical = 0;
#ifdef VAR_RANGES
		logval("qCritical", ((int)qCritical));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 11: // STATE 12 - q2.pml:53 - [-end-] (0:0:0 - 0)
		IfNotBlocked
		reached[1][12] = 1;
		if (!delproc(1, II)) continue;
		_m = 3; goto P999; /* 0 */

		 /* PROC P */
	case 12: // STATE 1 - q2.pml:18 - [y0 = 1] (0:0:1 - 0)
		IfNotBlocked
		reached[0][1] = 1;
		(trpt+1)->bup.oval = ((int)now.y0);
		now.y0 = 1;
#ifdef VAR_RANGES
		logval("y0", ((int)now.y0));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 13: // STATE 2 - q2.pml:19 - [s = 0] (0:0:1 - 0)
		IfNotBlocked
		reached[0][2] = 1;
		(trpt+1)->bup.oval = ((int)now.s);
		now.s = 0;
#ifdef VAR_RANGES
		logval("s", ((int)now.s));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 14: // STATE 4 - q2.pml:23 - [(((y1==0)||(s!=0)))] (0:0:0 - 0)
		IfNotBlocked
		reached[0][4] = 1;
		if (!(((((int)now.y1)==0)||(((int)now.s)!=0))))
			continue;
		_m = 3; goto P999; /* 0 */
	case 15: // STATE 5 - q2.pml:27 - [pCritical = 1] (0:0:1 - 0)
		IfNotBlocked
		reached[0][5] = 1;
		(trpt+1)->bup.oval = ((int)now.pCritical);
		now.pCritical = 1;
#ifdef VAR_RANGES
		logval("pCritical", ((int)now.pCritical));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 16: // STATE 6 - q2.pml:28 - [y0 = 0] (0:0:1 - 0)
		IfNotBlocked
		reached[0][6] = 1;
		(trpt+1)->bup.oval = ((int)now.y0);
		now.y0 = 0;
#ifdef VAR_RANGES
		logval("y0", ((int)now.y0));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 17: // STATE 7 - q2.pml:29 - [pCritical = 0] (0:0:1 - 0)
		IfNotBlocked
		reached[0][7] = 1;
		(trpt+1)->bup.oval = ((int)now.pCritical);
		now.pCritical = 0;
#ifdef VAR_RANGES
		logval("pCritical", ((int)now.pCritical));
#endif
		;
		_m = 3; goto P999; /* 0 */
	case 18: // STATE 12 - q2.pml:32 - [-end-] (0:0:0 - 0)
		IfNotBlocked
		reached[0][12] = 1;
		if (!delproc(1, II)) continue;
		_m = 3; goto P999; /* 0 */
	case  _T5:	/* np_ */
		if (!((!(trpt->o_pm&4) && !(trpt->tau&128))))
			continue;
		/* else fall through */
	case  _T2:	/* true */
		_m = 3; goto P999;
#undef rand
	}

