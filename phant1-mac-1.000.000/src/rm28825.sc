;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28825)
(include sci.sh)
(use Main)
(use ExitFeature)
(use Scaler)
(use Polygon)

(public
	rm28825 0
)

(instance rm28825 of ScaryRoom
	(properties
		picture 28825
		stepSound 1
	)

	(method (init)
		(if (== gChapter 5)
			(= picture 28826)
			(gEgo fadePalette: 28100)
		)
		((ScriptID 30) init:) ; FidgetCode
		(super init: &rest)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 49 78 86 70 152 68 166 72 184 72 171 68 279 66 274 60 73 60 43 70
					yourself:
				)
		)
		(gEgo
			init:
			fadedY: 90
			brightY: 120
			setScaler: Scaler 22 15 71 59
			normalize:
		)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(28820
				(gEgo view: 0 posn: 60 72)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(gEgo view: 1 posn: 266 63)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		(eastExit init: 2)
		(westExit init: 4)
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			((< (gEgo x:) 60)
				(gCurRoom newRoom: 28820)
			)
			((> (gEgo x:) 266)
				(gCurRoom newRoom: 28830)
			)
		)
	)
)

(instance westExit of ExitFeature
	(properties
		nsRight 80
		nsBottom 76
		nextRoom 28410
	)
)

(instance eastExit of ExitFeature
	(properties
		nextRoom 28830
	)
)

