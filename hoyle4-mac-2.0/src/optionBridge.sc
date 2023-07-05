;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 790)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use Piles)
(use Print)
(use GameControls)
(use System)

(public
	optionBridge 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(= local0 gGameControls)
	(= local1 global271)
	(iconSort init:)
	(iconDummy init:)
	(iconRandom init:)
	((= gGameControls bridgeOptions)
		window: bridgeWindow
		helpIconItem: iconHelp
		okIconItem: iconOK
		curIcon: (if (not (HaveMouse)) iconOK else 0)
		add:
			(iconSort theObj: iconSort selector: #doit yourself:)
			(iconDummy theObj: iconDummy selector: #doit yourself:)
			(iconReview theObj: iconReview selector: #doit yourself:)
			(iconRedeal theObj: iconRedeal selector: #doit yourself:)
			(iconRebid theObj: iconRebid selector: #doit yourself:)
			(iconReplay theObj: iconReplay selector: #doit yourself:)
			(iconRandom theObj: iconRandom selector: #doit yourself:)
			(iconSave theObj: iconSave selector: #doit yourself:)
			iconHelp
			(iconOK theObj: iconOK selector: #doit yourself:)
	)
	(gGameControls show:)
	(DisposeScript 790)
)

(instance optionBridge of Code
	(properties)

	(method (init)
		(localproc_0)
	)
)

(instance bridgeWindow of InvisibleWindow
	(properties
		top 49
		left 83
		bottom 162
		right 237
	)

	(method (open &tmp temp0)
		(super open:)
		(DrawCel 790 0 0 0 0 15)
		(Graph grUPDATE_BOX top left (+ bottom 1) (+ right 1) 1)
	)
)

(instance bridgeOptions of HoyleGameControls
	(properties)
)

(instance iconSort of ControlIcon
	(properties
		view 790
		loop 1
		cel 0
		nsLeft 5
		nsTop 5
		signal 387
		highlightColor -1
		noun 1
		modNum 790
		helpVerb 4
	)

	(method (init)
		(= cel (if (== global271 3) 0 else 2))
	)

	(method (doit)
		(switch global271
			(3
				(= global271 4)
				(= cel 2)
			)
			(4
				(= global271 3)
				(= cel 0)
			)
		)
		(= global290 (!= local1 global271))
		(= global394 global271)
		(self show:)
	)
)

(instance iconDummy of ControlIcon
	(properties
		view 790
		loop 2
		cel 0
		nsLeft 5
		nsTop 22
		signal 387
		highlightColor -1
		noun 2
		modNum 790
		helpVerb 4
	)

	(method (init)
		(= cel
			(switch global432
				(1 0)
				(0 2)
				(2 4)
			)
		)
	)

	(method (doit &tmp temp0 temp1)
		(switch global432
			(1
				(= global432 0)
				(= cel 2)
				((global117 atLocation: 2) eachElementDo: #deleteKeyMouse)
				((global117 atLocation: 4) eachElementDo: #deleteKeyMouse)
				((global117 atLocation: 1) eachElementDo: #deleteKeyMouse)
				((global117 atLocation: 3) eachElementDo: #deleteKeyMouse)
				(if (and global429 global431)
					(= temp1 ((Dealer curPlayer:) type:))
					(cond
						((== (global431 location:) 3)
							(global431 type: 1)
							(global429 type: 1)
							((global117 atLocation: 1) flip: 1)
						)
						((== (global431 location:) 1)
							((global117 atLocation: 1)
								eachElementDo: #addKeyMouse
							)
							((global117 atLocation: 3)
								eachElementDo: #addKeyMouse
							)
						)
						(else
							((global117 atLocation: 3)
								eachElementDo: #addKeyMouse
							)
						)
					)
					(if
						(and
							(gCurRoom script:)
							(== ((gCurRoom script:) state:) 11)
						)
						(= global438 1)
					)
				)
			)
			(0
				(= global432 2)
				(= cel 4)
				(global117
					eachElementDo: #type 0
					eachElementDo: #flip 1
					eachElementDo: #sort 1
				)
				((global117 atLocation: 2)
					eachElementDo: #addKeyMouse
					eachElementDo: #offsetX 20
					eachElementDo: #offsetY 4
				)
				((global117 atLocation: 4)
					eachElementDo: #addKeyMouse
					eachElementDo: #offsetX 20
					eachElementDo: #offsetY 4
				)
				((global117 atLocation: 1) eachElementDo: #addKeyMouse)
				((global117 atLocation: 3) eachElementDo: #addKeyMouse)
				(= global438 0)
			)
			(2
				(= global432 1)
				(= cel 0)
				((global117 atLocation: 2)
					type: 1
					flip: 0
					eachElementDo: #deleteKeyMouse
				)
				((global117 atLocation: 4)
					type: 1
					flip: 0
					eachElementDo: #deleteKeyMouse
				)
				((global117 atLocation: 1)
					type: 1
					flip: 0
					eachElementDo: #deleteKeyMouse
				)
				((global117 atLocation: 3) eachElementDo: #addKeyMouse)
				(if global431
					(= temp1 ((Dealer curPlayer:) type:))
					(if global430
						(global431 flip: 1)
						(switch (global431 location:)
							(3
								(global431 type: 0)
								(global429 type: 0)
								((global117 atLocation: 1) flip: 1)
								((global117 atLocation: 1)
									eachElementDo: #addKeyMouse
								)
							)
							(2
								((global117 atLocation: 2) flip: 1)
							)
							(4
								((global117 atLocation: 4) flip: 1)
							)
							(1
								((global117 atLocation: 1)
									type: 0
									flip: 1
									eachElementDo: #addKeyMouse
								)
								((global117 atLocation: 3) type: 0)
							)
						)
					else
						(if
							(or
								(== (global431 location:) 3)
								(== (global431 location:) 1)
							)
							(global431 type: 0)
							(global429 type: 0)
						)
						(if (== (global431 location:) 3)
							(global429 flip: 1)
						)
					)
				)
				(if
					(and
						(gCurRoom script:)
						(== ((gCurRoom script:) state:) 11)
						(IsObject (Dealer curPlayer:))
					)
					(= global438 1)
				)
			)
		)
		(self show:)
	)
)

(instance iconReview of ControlIcon
	(properties
		view 790
		loop 3
		cel 0
		nsLeft 5
		nsTop 39
		signal 387
		highlightColor -1
		noun 3
		modNum 790
		helpVerb 4
	)

	(method (doit)
		(if global437
			(= global436 1)
			(iconOK doit:)
		else
			(= local2 (GetPort))
			(Message msgGET 790 3 0 0 1 @global550) ; "Bidding can be reviewed after the bidding is complete."
			(Print addText: @global550 init:)
			(SetPort local2)
		)
	)
)

(instance iconRedeal of ControlIcon
	(properties
		view 790
		loop 4
		cel 0
		nsLeft 96
		nsTop 39
		signal 387
		highlightColor -1
		noun 4
		modNum 790
		helpVerb 4
	)

	(method (doit)
		(= global459 3)
		(if (< ((gCurRoom script:) state:) 7)
			(Message msgGET 790 4 0 0 2 @global550) ; "It is too soon to redeal. Try again after the bidding begins."
			(Print addText: @global550 init:)
		)
		(if
			(or
				(== ((gCurRoom script:) state:) 11)
				(== ((gCurRoom script:) state:) 12)
			)
			(Message msgGET 790 4 0 0 1 @global550) ; "A redeal will take place after the current trick is complete."
			(Print addText: @global550 init:)
		)
		(iconOK doit:)
	)
)

(instance iconRebid of ControlIcon
	(properties
		view 790
		loop 5
		cel 0
		nsLeft 96
		nsTop 56
		signal 387
		highlightColor -1
		noun 5
		modNum 790
		helpVerb 4
	)

	(method (doit)
		(= global459 2)
		(if
			(or
				(== ((gCurRoom script:) state:) 11)
				(== ((gCurRoom script:) state:) 12)
			)
			(Message msgGET 790 5 0 0 1 @global550) ; "Rebidding of the hand will take place after the trick is complete."
			(Print addText: @global550 init:)
		)
		(iconOK doit:)
	)
)

(instance iconReplay of ControlIcon
	(properties
		view 790
		loop 6
		cel 0
		nsLeft 5
		nsTop 56
		signal 387
		highlightColor -1
		noun 6
		modNum 790
		helpVerb 4
	)

	(method (doit)
		(if (>= ((gCurRoom script:) state:) 11)
			(= global459 1)
			(if
				(or
					(== ((gCurRoom script:) state:) 11)
					(== ((gCurRoom script:) state:) 12)
				)
				(Message msgGET 790 6 0 0 1 @global550) ; "Replaying of the hand will take place after the trick is completed."
				(Print addText: @global550 init:)
			)
		)
		(iconOK doit:)
	)
)

(instance iconRandom of ControlIcon
	(properties
		view 790
		loop 9
		cel 0
		nsLeft 5
		nsTop 73
		signal 387
		highlightColor -1
		noun 9
		modNum 790
		helpVerb 4
	)

	(method (init)
		(= cel
			(switch global442
				(1 2)
				(0 0)
			)
		)
	)

	(method (doit)
		(switch (= global442 (if global442 0 else 1))
			(1
				(= cel 2)
			)
			(0
				(= cel 0)
			)
		)
		(self show:)
	)
)

(instance iconSave of ControlIcon
	(properties
		view 790
		loop 10
		cel 0
		nsLeft 104
		nsTop 73
		signal 387
		highlightColor -1
		noun 10
		modNum 790
		helpVerb 4
	)

	(method (doit)
		(iconOK doit:)
		(= global444 1)
	)
)

(instance iconHelp of ControlIcon
	(properties
		view 790
		loop 7
		cel 0
		nsLeft 5
		nsTop 90
		cursor 995
		signal 387
		highlightColor -1
		noun 7
		modNum 790
		helpVerb 4
	)
)

(instance iconOK of ControlIcon
	(properties
		view 790
		loop 8
		cel 0
		nsLeft 77
		nsTop 90
		signal 387
		highlightColor -1
		noun 8
		modNum 790
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(gGameControls hide: dispose:)
		(proc0_1)
		(= gGameControls local0)
		(gBridge_opt doit: 3)
	)
)

