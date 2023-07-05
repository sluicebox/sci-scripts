;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 635)
(include sci.sh)
(use Main)
(use northExit)
(use Scaler)
(use Feature)

(public
	woods8Rm 0
)

(instance woods8Rm of ExitRoom
	(properties
		picture 63501
		north 625 ; woods6Rm
		south 640 ; lairExtRm
		west 630 ; woods7Rm
	)

	(method (init)
		(switch gPrevRoomNum
			(630 ; woods7Rm
				(gEgo posn: 155 265 heading: 90)
			)
			(625 ; woods6Rm
				(gEgo posn: 201 205 heading: 180)
			)
			(else
				(gEgo posn: 322 339 heading: 0)
			)
		)
		(gEgo BAD_SELECTOR: setScaler: Scaler 86 19 329 177 init:)
		(super init: &rest)
		(fNorthExit init:)
		(gGame handsOn:)
	)
)

(instance fNorthExit of ExitFeature
	(properties
		approachX 200
		approachY 100
		BAD_SELECTOR 625
		BAD_SELECTOR 0
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 137 191 141 -1 262 1 264 190)
	)
)

