;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 625)
(include sci.sh)
(use Main)
(use northExit)
(use Scaler)

(public
	woods6Rm 0
)

(instance woods6Rm of ExitRoom
	(properties
		picture 62501
		east 600 ; woods1Rm
		south 635 ; woods8Rm
		west 620 ; woods5Rm
	)

	(method (init)
		(switch gPrevRoomNum
			(620 ; woods5Rm
				(gEgo posn: 243 288 heading: 90)
			)
			(600 ; woods1Rm
				(gEgo posn: 565 320 heading: 270)
			)
			(else
				(gEgo posn: 307 341 heading: 0)
			)
		)
		(gEgo normalize: setScaler: Scaler 81 24 320 165 init:)
		(super init: &rest)
		(gGame handsOn:)
	)
)

