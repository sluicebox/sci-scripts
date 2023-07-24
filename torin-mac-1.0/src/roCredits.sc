;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 51500)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use PushButton)
(use n64896)
(use Array)
(use System)

(public
	roCredits 0
)

(local
	creditNum
)

(instance roCredits of TPRoom
	(properties)

	(method (init)
		(super init: &rest)
		(Palette 1 51400) ; PalLoad
		(gGame handsOff:)
		(self setScript: soCredits)
	)
)

(instance soCredits of TPScript
	(properties
		bHasFF 1
		bHasRew 1
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 [temp5 2])
		(switch (= state newState)
			(0
				(self setScript: soPlayCreditsMusic)
				(= creditNum 0)
				(= cycles 1)
			)
			(1
				(= temp2 632)
				(++ creditNum)
				(if (not (= temp0 (MakeMessageText 0 0 0 creditNum 100)))
					(gCurRoom setScript: soGetOut)
					(return)
				)
				(= temp1 (IntArray new: 4))
				(Text 0 (temp1 data:) (temp0 data:) gnDialogFont temp2 1) ; TextSize
				(= temp3 (+ (temp1 at: 2) 1))
				(= temp4 (+ (temp1 at: 3) 1))
				(temp1 dispose:)
				(tv
					fore: 235
					back: 255
					skip: 255
					maxWidth: temp2
					setPri: 255
					border: 0
					text: temp0
					mode: 1
					font: gnDialogFont
					nLeading: 0
					init:
					posn: (/ (- 632 temp3) 2) (/ (- 316 temp4) 2)
					doit:
				)
				(= ticks (Max 240 (/ (* 30 (temp0 size:)) 10)))
			)
			(2
				(tv dispose:)
				(-= state 2)
				(= cycles 1)
			)
		)
	)

	(method (ff)
		(gCurRoom setScript: soGetOut)
	)

	(method (rewind)
		(gCurRoom setScript: self)
	)
)

(instance soGetOut of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goMusic1 fadeOut: 12 20 self)
			)
			(1
				(gGame autorestore: 1)
				(= gQuit 1)
				(self dispose:)
			)
		)
	)
)

(instance soPlayCreditsMusic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goMusic1 setMusic: 0)
				(goMusic1
					number: 51446
					loop: 1
					play: (goMusic1 getCurVol:) self
				)
			)
			(1
				(goMusic1
					number: 30598
					loop: 1
					play: (goMusic1 getCurVol:) self
				)
			)
			(2
				(goMusic1
					number: 14000
					loop: -1
					play: (goMusic1 getCurVol:) 0
				)
			)
			(3
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance tv of TextItem
	(properties)
)

