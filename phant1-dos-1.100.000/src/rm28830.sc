;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28830)
(include sci.sh)
(use Main)
(use ExitFeature)
(use Scaler)

(public
	rm28830 0
)

(instance rm28830 of ScaryRoom
	(properties
		picture 28830
		stepSound 1
	)

	(method (init)
		((ScriptID 30) init:) ; FidgetCode
		(if (== gChapter 5)
			(= picture 28831)
			(gEgo fadePalette: 28100)
		)
		(super init: &rest)
		(gEgo
			init:
			fadedY: 90
			brightY: 120
			setScaler: Scaler 39 21 95 75
			normalize:
		)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(else
				(gEgo view: 0 posn: 192 84)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		(westExit init: 4)
	)
)

(instance westExit of ExitFeature
	(properties
		nsRight 192
		nsBottom 76
		nextRoom 28825
	)
)

