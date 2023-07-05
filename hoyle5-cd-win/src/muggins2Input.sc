;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 503)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use Piles)
(use GameControls)
(use System)

(public
	muggins2Input 0
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(EnableCursor)
	(= global491 0)
	(= local0 gGameControls)
	(= local1 0)
	((= gGameControls muggins2InputControls)
		window: muggins2InputWindow
		helpIconItem: 0
		okIconItem: 0
		curIcon: (if (not (HaveMouse)) okBttn else 0)
		add:
			(dblRoyalButton
				cel: 0
				theObj: dblRoyalButton
				selector: #doit
				yourself:
			)
			(pairRoyalButton
				cel: 0
				theObj: pairRoyalButton
				selector: #doit
				yourself:
			)
			(run7Button cel: 0 theObj: run7Button selector: #doit yourself:)
			(run6Button cel: 0 theObj: run6Button selector: #doit yourself:)
			(pairButton cel: 0 theObj: pairButton selector: #doit yourself:)
			(run5Button cel: 0 theObj: run5Button selector: #doit yourself:)
			(thirtyOneButton
				cel: 0
				theObj: thirtyOneButton
				selector: #doit
				yourself:
			)
			(run4Button cel: 0 theObj: run4Button selector: #doit yourself:)
			(fifteenButton
				cel: 0
				theObj: fifteenButton
				selector: #doit
				yourself:
			)
			(run3Button cel: 0 theObj: run3Button selector: #doit yourself:)
			(lastCardButton
				cel: 0
				theObj: lastCardButton
				selector: #doit
				yourself:
			)
			(okBttn cel: 0 theObj: okBttn selector: #doit yourself:)
	)
	(gGameControls show:)
)

(instance muggins2Input of Code
	(properties)

	(method (init)
		(localproc_0)
	)
)

(instance muggins2InputWindow of InvisibleWindow
	(properties
		left 214
		top 50
		right 317
		bottom 187
	)

	(method (open &tmp [temp0 6])
		(if (== ((Dealer dealer:) type:) 0)
			(= top 10)
		else
			(= top 55)
		)
		(super open:)
		(proc0_10 503 0 0 0 0 15)
	)
)

(instance muggins2InputControls of HoyleGameControls
	(properties)
)

(class MugginsInputItem of ControlIcon
	(properties
		view 503
		signal 385
		highlightColor -1
		returnValue 0
	)

	(method (doit)
		(= cel (- 2 cel))
		(self show:)
	)
)

(instance dblRoyalButton of MugginsInputItem
	(properties
		nsLeft 8
		nsTop 6
		loop 1
		returnValue 12
	)
)

(instance pairRoyalButton of MugginsInputItem
	(properties
		nsLeft 8
		nsTop 21
		loop 2
		returnValue 6
	)
)

(instance run7Button of MugginsInputItem
	(properties
		nsLeft 8
		nsTop 36
		loop 3
		returnValue 7
	)
)

(instance run6Button of MugginsInputItem
	(properties
		nsLeft 49
		nsTop 36
		loop 4
		returnValue 6
	)
)

(instance pairButton of MugginsInputItem
	(properties
		nsLeft 8
		nsTop 51
		loop 5
		returnValue 2
	)
)

(instance run5Button of MugginsInputItem
	(properties
		nsLeft 49
		nsTop 51
		loop 6
		returnValue 5
	)
)

(instance thirtyOneButton of MugginsInputItem
	(properties
		nsLeft 8
		nsTop 66
		loop 7
		returnValue 2
	)
)

(instance run4Button of MugginsInputItem
	(properties
		nsLeft 49
		nsTop 66
		loop 8
		cel 4
		returnValue 4
	)
)

(instance fifteenButton of MugginsInputItem
	(properties
		nsLeft 8
		nsTop 81
		loop 9
		cel 4
		returnValue 2
	)
)

(instance run3Button of MugginsInputItem
	(properties
		nsLeft 49
		nsTop 81
		loop 10
		cel 4
		returnValue 3
	)
)

(instance lastCardButton of MugginsInputItem
	(properties
		nsLeft 8
		nsTop 96
		loop 11
		cel 4
		returnValue 1
	)
)

(instance okBttn of ControlIcon
	(properties
		nsLeft 8
		nsTop 115
		view 503
		loop 12
		signal 387
		highlightColor -1
	)

	(method (doit)
		(gGameControls hide: dispose:)
		(RedrawCast)
		(= gGameControls local0)
		(= global491 0)
		(if (== (dblRoyalButton cel:) 2)
			(+= global491 12)
		)
		(if (== (pairRoyalButton cel:) 2)
			(+= global491 6)
		)
		(if (== (run7Button cel:) 2)
			(+= global491 7)
		)
		(if (== (run6Button cel:) 2)
			(+= global491 6)
		)
		(if (== (run5Button cel:) 2)
			(+= global491 5)
		)
		(if (== (run4Button cel:) 2)
			(+= global491 4)
		)
		(if (== (run3Button cel:) 2)
			(+= global491 3)
		)
		(if (== (pairButton cel:) 2)
			(+= global491 2)
		)
		(if (== (fifteenButton cel:) 2)
			(+= global491 2)
		)
		(if (== (lastCardButton cel:) 2)
			(+= global491 1)
		)
		(if (== (thirtyOneButton cel:) 2)
			(+= global491 1)
			(if (not global492)
				(+= global491 1)
			)
		)
	)
)

