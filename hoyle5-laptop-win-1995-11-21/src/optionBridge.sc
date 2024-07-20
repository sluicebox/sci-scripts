;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 790)
(include sci.sh)
(use Main)
(use InvisibleWindow)
(use Piles)
(use Str)
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
	((= gGameControls bridgeOptions)
		plane: bridgeWindow
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
	(properties)

	(method (init &tmp temp0)
		(= top 113)
		(= left (/ (- gScreenWidth 312) 2))
		(= bottom 317)
		(= right (+ (/ (- gScreenWidth 312) 2) 312))
		(= priority 20)
		(= inLeft left)
		(= inTop top)
		(= inRight right)
		(= inBottom bottom)
		(super init:)
		(proc0_10 790 0 0 0 0 15 self)
	)
)

(instance bridgeOptions of HoyleGameControls
	(properties)
)

(instance iconSort of ControlIcon
	(properties
		noun 1
		modNum 790
		nsLeft 19
		nsTop 19
		x 19
		y 19
		signal 387
		mainView 790
		mainLoop 1
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(= mainCel (if (== global271 3) 0 else 2))
		(self setPri: 21)
		(super init: &rest)
	)

	(method (doit)
		(switch global271
			(3
				(= global271 4)
				(= mainCel 2)
			)
			(4
				(= global271 3)
				(= mainCel 0)
			)
		)
		(= global290 (!= local1 global271))
		(= gSortMode global271)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconDummy of ControlIcon
	(properties
		noun 2
		modNum 790
		nsLeft 19
		nsTop 47
		x 19
		y 47
		signal 387
		mainView 790
		mainLoop 2
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(= mainCel
			(switch global432
				(1 0)
				(0 2)
				(2 4)
			)
		)
		(self setPri: 21)
		(super init: &rest)
	)

	(method (doit &tmp temp0 temp1)
		(switch global432
			(1
				(= global432 0)
				(= mainCel 2)
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
				(= mainCel 4)
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
				(= mainCel 0)
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
						(Dealer curPlayer:)
					)
					(= global438 1)
				)
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconReview of ControlIcon
	(properties
		noun 3
		modNum 790
		nsLeft 19
		nsTop 75
		x 19
		y 75
		signal 387
		mainView 790
		mainLoop 3
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(if global437
			(= global436 1)
			(iconOK doit:)
		else
			(= temp0 (Str new:))
			(Message msgGET 790 3 0 0 1 (temp0 data:)) ; "Bidding can be reviewed after the bidding is complete."
			(Print
				ticks: 400
				fore: 0
				margin: 10
				mode: 1
				margin: 10
				addBitmap: 917 4 0
				addText: temp0 20 25
				init:
			)
			(temp0 dispose:)
		)
	)
)

(instance iconRedeal of ControlIcon
	(properties
		noun 4
		modNum 790
		nsLeft 157
		nsTop 75
		x 157
		y 75
		signal 387
		mainView 790
		mainLoop 4
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(= global459 3)
		(= temp0 (Str new:))
		(if (< ((gCurRoom script:) state:) 7)
			(Message msgGET 790 4 0 0 2 (temp0 data:)) ; "It is too soon to redeal. Try again after the bidding begins."
			(Print
				ticks: 400
				fore: 0
				margin: 10
				mode: 1
				addBitmap: 917 4 0
				addText: temp0 10 25
				init:
			)
		)
		(if
			(or
				(== ((gCurRoom script:) state:) 11)
				(== ((gCurRoom script:) state:) 12)
			)
			(Message msgGET 790 4 0 0 1 (temp0 data:)) ; "A redeal will take place after the current trick is complete."
			(Print
				ticks: 400
				fore: 0
				margin: 10
				mode: 1
				addBitmap: 917 4 0
				addText: temp0 17 25
				init:
			)
		)
		(temp0 dispose:)
		(iconOK doit:)
	)
)

(instance iconRebid of ControlIcon
	(properties
		noun 5
		modNum 790
		nsLeft 157
		nsTop 103
		x 157
		y 103
		signal 387
		mainView 790
		mainLoop 5
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(= global459 2)
		(if
			(or
				(== ((gCurRoom script:) state:) 11)
				(== ((gCurRoom script:) state:) 12)
			)
			(= temp0 (Str new:))
			(Message msgGET 790 5 0 0 1 (temp0 data:)) ; "Rebidding of the hand will take place after the trick is complete."
			(Print
				ticks: 400
				fore: 0
				margin: 10
				mode: 1
				addBitmap: 917 4 0
				addText: temp0 10 25
				init:
			)
			(temp0 dispose:)
		)
		(iconOK doit:)
	)
)

(instance iconReplay of ControlIcon
	(properties
		noun 6
		modNum 790
		nsLeft 19
		nsTop 103
		x 19
		y 103
		signal 387
		mainView 790
		mainLoop 6
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(if (>= ((gCurRoom script:) state:) 11)
			(= global459 1)
			(if
				(or
					(== ((gCurRoom script:) state:) 11)
					(== ((gCurRoom script:) state:) 12)
				)
				(= temp0 (Str new:))
				(Message msgGET 790 6 0 0 1 (temp0 data:)) ; "Replaying of the hand will take place after the trick is completed."
				(Print
					ticks: 400
					fore: 0
					margin: 10
					mode: 1
					addBitmap: 917 4 0
					addText: temp0 10 25
					init:
				)
				(= temp0 (Str new:))
			)
		)
		(iconOK doit:)
	)
)

(instance iconRandom of ControlIcon
	(properties
		noun 9
		modNum 790
		nsLeft 19
		nsTop 131
		x 19
		y 131
		signal 387
		mainView 790
		mainLoop 9
		highlightColor -1
		helpVerb 4
	)

	(method (init)
		(= mainCel
			(switch global442
				(1 2)
				(0 0)
			)
		)
		(super init: &rest)
	)

	(method (doit)
		(switch (= global442 (if global442 0 else 1))
			(1
				(= mainCel 2)
			)
			(0
				(= mainCel 0)
			)
		)
		(self show:)
		(FrameOut)
		(UpdateScreenItem self)
	)
)

(instance iconSave of ControlIcon
	(properties
		noun 10
		modNum 790
		nsLeft 157
		nsTop 131
		x 157
		y 131
		signal 387
		mainView 790
		mainLoop 10
		highlightColor -1
		helpVerb 4
	)

	(method (doit)
		(iconOK doit:)
		(= global444 1)
	)
)

(instance iconHelp of ControlIcon
	(properties
		noun 7
		modNum 790
		nsLeft 19
		nsTop 159
		x 19
		y 159
		signal 387
		mainView 790
		mainLoop 7
		cursorView 995
		highlightColor -1
		helpVerb 4
	)
)

(instance iconOK of ControlIcon
	(properties
		noun 8
		modNum 790
		nsLeft 157
		nsTop 159
		x 157
		y 159
		signal 387
		mainView 790
		mainLoop 8
		highlightColor -1
		helpVerb 4
	)

	(method (doit &tmp temp0)
		(gGameControls hide:)
		(RedrawCast)
		(= gGameControls local0)
		(gBridge_opt doit: 3)
	)
)

