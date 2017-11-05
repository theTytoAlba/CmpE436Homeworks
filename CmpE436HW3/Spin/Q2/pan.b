	switch (t->back) {
	default: Uerror("bad return move");
	case  0: goto R999; /* nothing to undo */

		 /* CLAIM critical1 */
;
		;
		
	case 4: // STATE 6
		;
		p_restor(II);
		;
		;
		goto R999;

		 /* PROC Q */

	case 5: // STATE 1
		;
		now.y1 = trpt->bup.oval;
		;
		goto R999;

	case 6: // STATE 2
		;
		now.s = trpt->bup.oval;
		;
		goto R999;
;
		;
		
	case 8: // STATE 5
		;
		qCritical = trpt->bup.oval;
		;
		goto R999;

	case 9: // STATE 6
		;
		now.y1 = trpt->bup.oval;
		;
		goto R999;

	case 10: // STATE 7
		;
		qCritical = trpt->bup.oval;
		;
		goto R999;

	case 11: // STATE 12
		;
		p_restor(II);
		;
		;
		goto R999;

		 /* PROC P */

	case 12: // STATE 1
		;
		now.y0 = trpt->bup.oval;
		;
		goto R999;

	case 13: // STATE 2
		;
		now.s = trpt->bup.oval;
		;
		goto R999;
;
		;
		
	case 15: // STATE 5
		;
		now.pCritical = trpt->bup.oval;
		;
		goto R999;

	case 16: // STATE 6
		;
		now.y0 = trpt->bup.oval;
		;
		goto R999;

	case 17: // STATE 7
		;
		now.pCritical = trpt->bup.oval;
		;
		goto R999;

	case 18: // STATE 12
		;
		p_restor(II);
		;
		;
		goto R999;
	}

