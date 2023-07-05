;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use n1111)
(use Sound)
(use System)

(public
	eatMelonScr 0
)

(instance eatMelonScr of Script
	(properties)

	(method (dispose)
		(= register -1)
		(= scratch 0)
		(if (!= state 7)
			(PalVary 1 2) ; PalVaryReverse
		)
		(super dispose: &rest)
	)

	(method (doit)
		(super doit:)
		(if (and (!= register -1) (== (PalVary 2) register)) ; PalVaryInfo
			(= register -1)
			(self cue:)
		)
	)

	(method (handleEvent event)
		(if (and (& (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(= ticks (= seconds (= cycles 0)))
			(event claimed: 1)
			(self changeState: 5)
		)
		(super handleEvent: event)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(PalVary 0 -1 1 100 0 192) ; PalVaryStart
				(gCurRoom doVerb: 25)
				(= register 100)
				(if (not (SetFlag 151))
					(proc1111_31 42)
				)
			)
			(1
				(PalVary 1 2 25) ; PalVaryReverse
				(melonExtendedSound play:)
				(= ticks 60)
			)
			(2
				(PalVary 0 -1 2 100 0 192) ; PalVaryStart
				(= ticks 120)
			)
			(3
				(PalVary 1 2) ; PalVaryReverse
				(= cycles 1)
			)
			(4
				(gKeyDownHandler addToFront: self)
				(= ticks 560)
			)
			(5
				(gKeyDownHandler delete: self)
				(PalVary 0 -1 1 100 0 192) ; PalVaryStart
				(gCurRoom doVerb: 26)
				(= register 100)
			)
			(6
				(PalVary 1 2) ; PalVaryReverse
				(= ticks 120)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance melonExtendedSound of Sound
	(properties
		flags 5
		number 100
	)
)

