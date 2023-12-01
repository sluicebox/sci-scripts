;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28110)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Actor)
(use System)

(public
	rm28110 0
)

(instance rm28110 of ScaryRoom
	(properties
		picture 28110
		stepSound 1
	)

	(method (init)
		((ScriptID 30) init:) ; FidgetCode
		(KillRobot)
		(if (== gChapter 5)
			(= picture 28111)
			(gEgo fadePalette: 28100)
		)
		(gEgo
			init:
			fadedY: 90
			brightY: 120
			setScaler: Scaler 75 49 108 59
			ignoreActors: 1
			posn: 110 69
		)
		(car init:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(28600
				(gEgo normalize: 4)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(gEgo normalize: 7)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		(super init: &rest)
		(if (and (>= gChapter 4) (!= gChapter 5) (IsFlag 203))
			(truck init:)
			(if (and (IsFlag 232) (not (IsFlag 337)))
				(truck approachVerbs: 4 3 setHotspot: 4 3) ; Do, Move, Do, Move
			)
		)
		(westExit init: 13)
		(eastExit init: 10)
		(eastExit2 init: 11)
		(gGame handsOn:)
	)
)

(instance sTruck of Script
	(properties)

	(method (dispose)
		(SetFlag 337)
		(car view: 28115 posn: 265 70)
		(truck view: 28110 approachVerbs: 0 setHotspot: 0 posn: 66 113)
		(gCurRoom drawPic: 28110 picture: 28110)
		(gEgo posn: 203 91 normalize: 2)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(car view: 28113 posn: 215 71)
					(truck view: 28112 posn: 12 112)
					(DoRobot 4570 29 40)
					(gCurRoom drawPic: 28112 picture: 28112)
				)
				(1
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(self dispose:)
		)
	)
)

(instance car of View
	(properties
		x 265
		y 70
	)

	(method (init)
		(if (== gChapter 5)
			(= view 28116)
		else
			(= view 28115)
		)
		(super init: &rest)
	)
)

(instance truck of View
	(properties
		approachX 120
		approachY 74
		x 66
		y 113
		view 28110
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sTruck)
		else
			(super doVerb: &rest)
		)
	)
)

(instance westExit of ExitFeature
	(properties
		nsLeft 45
		nsTop 5
		nsRight 165
		nsBottom 81
		approachX 90
		approachY 49
		nextRoom 28600
	)
)

(instance eastExit of ExitFeature
	(properties
		nsLeft 178
		nsTop 0
		nsRight 319
		nsBottom 80
		approachX 150
		approachY 61
		nextRoom 28700
	)
)

(instance eastExit2 of ExitFeature
	(properties
		nsLeft 178
		nsTop 80
		nsRight 319
		nsBottom 135
		approachX 220
		approachY 131
		nextRoom 28100
	)
)

