;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28400)
(include sci.sh)
(use Main)
(use ExitFeature)
(use Scaler)
(use Polygon)
(use Feature)

(public
	rm28400 0
)

(instance rm28400 of ScaryRoom
	(properties
		picture 28400
		stepSound 1
	)

	(method (init)
		((ScriptID 30) init:) ; FidgetCode
		(if (== gChapter 5)
			(= picture 28401)
			(gEgo fadePalette: 28100)
		)
		(gEgo
			init:
			fadedY: 90
			brightY: 120
			setScaler: Scaler 34 34 63 48
			normalize:
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 64 45 64 130 53 157 53 191 57 191 52 158 50 125 50 45 60 0 60
					yourself:
				)
		)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(28305
				(gEgo view: 0 posn: 4 60)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(gEgo view: 1 posn: 175 53)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		(eastExit init: 2)
		(westExit init: 4)
		(super init: &rest)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((> (gEgo x:) 175)
				(gGame handsOff:)
				(gCurRoom newRoom: 28410)
			)
		)
	)
)

(instance bridgeFeat of Feature ; UNUSED
	(properties
		nsLeft 46
		nsTop 35
		nsRight 243
		nsBottom 78
		approachX 144
		approachY 78
		x 144
		y 78
	)
)

(instance eastExit of ExitFeature
	(properties
		nextRoom 28410
	)
)

(instance westExit of ExitFeature
	(properties
		nextRoom 28305
	)
)

