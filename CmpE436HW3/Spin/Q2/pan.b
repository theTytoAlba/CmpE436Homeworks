	switch (t->back) {
	default: Uerror("bad return move");
	case  0: goto R999; /* nothing to undo */

		 /* CLAIM infCritical2 */
;
		;
		;
		;
		
	case 5: // STATE 13
		;
		p_restor(II);
		;
		;
		goto R999;

		 /* CLAIM infCritical1 */
;
		;
		;
		;
		
	case 8: // STATE 13
		;
		p_restor(II);
		;
		;
		goto R999;

		 /* CLAIM critical2 */
;
		;
		
	case 10: // STATE 6
		;
		p_restor(II);
		;
		;
		goto R999;

		 /* CLAIM critical1 */
;
		;
		
	case 12: // STATE 6
		;
		p_restor(II);
		;
		;
		goto R999;

		 /* CLAIM mutex */
;
		
	case 13: // STATE 1
		goto R999;

	case 14: // STATE 10
		;
		p_restor(II);
		;
		;
		goto R999;

		 /* PROC Q */

	case 15: // STATE 2
		;
		now.s = trpt->bup.ovals[1];
		now.y1 = trpt->bup.ovals[0];
		;
		ungrab_ints(trpt->bup.ovals, 2);
		goto R999;
;
		;
		
	case 17: // STATE 7
		;
		now.qCritical = trpt->bup.ovals[2];
		now.y1 = trpt->bup.ovals[1];
		now.qCritical = trpt->bup.ovals[0];
		;
		ungrab_ints(trpt->bup.ovals, 3);
		goto R999;

	case 18: // STATE 12
		;
		p_restor(II);
		;
		;
		goto R999;

		 /* PROC P */

	case 19: // STATE 2
		;
		now.s = trpt->bup.ovals[1];
		now.y0 = trpt->bup.ovals[0];
		;
		ungrab_ints(trpt->bup.ovals, 2);
		goto R999;
;
		;
		
	case 21: // STATE 7
		;
		now.pCritical = trpt->bup.ovals[2];
		now.y0 = trpt->bup.ovals[1];
		now.pCritical = trpt->bup.ovals[0];
		;
		ungrab_ints(trpt->bup.ovals, 3);
		goto R999;

	case 22: // STATE 12
		;
		p_restor(II);
		;
		;
		goto R999;
	}

