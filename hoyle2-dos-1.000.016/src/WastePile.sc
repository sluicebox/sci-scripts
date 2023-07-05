;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 305)
(include sci.sh)
(use Main)
(use CardList)

(class WastePile of CardList
	(properties
		dimRule 0
		playDealNumber 3
		gatherForReDeal 1
	)

	(method (giveUpCard)
		(= global302 (self at: (- size 1)))
		(self delete: global302)
		(self showStock:)
		(return global302)
	)

	(method (handleInput param1 &tmp temp0)
		(if (proc0_6 119)
			(if global419
				(= global419 0)
				(= global323 (if global421 1 else 2))
				(= global421 0)
			)
			(return)
		)
		(if (or (proc0_6 126) (proc0_6 127) (proc0_6 101) (proc0_6 118))
			(return)
		)
		(if (= dimmedObj (self isThereADimmedObject: 1))
			(if (self numDimmed:)
				(self whiten:)
			else
				(= temp0 (self howManyDimmedObjects:))
				(cond
					((== global407 1)
						(dimmedObj whiten:)
						(self dim: param1)
					)
					((== temp0 global407)
						(proc0_5 (Format @global100 305 0 global407)) ; "Only %d cards may be selected at a time."
					)
					(else
						(self dim: param1)
					)
				)
			)
		else
			(self dim: param1)
		)
	)

	(method (cue param1)
		(self eachElementDo: #dimmed 0 species 332 0)
		(super cue: (if (and argc param1) param1 else 0))
	)

	(method (whiten)
		(if size
			(for
				((= global301 (self firstDimmed: 1)))
				(< global301 size)
				((++ global301))
				
				((self at: global301) whiten:)
			)
			(self showUpdate:)
		)
	)

	(method (dim param1 &tmp temp0)
		(if size
			(switch dimRule
				(0
					((self lastCard:) dim:)
				)
				(1
					(= param1 (self limitDigDown: param1))
					((self at: param1) dim:)
				)
			)
			(self showUpdate:)
		else
			(proc0_5 (Format @global100 305 1)) ; "No Cards Here."
		)
	)
)

