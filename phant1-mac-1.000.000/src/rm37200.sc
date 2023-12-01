;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37200)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Print)
(use Scaler)
(use Feature)
(use System)

(public
	rm37200 0
)

(instance rm37200 of ScaryRoom
	(properties
		picture 37200
		stepSound 4
		baseView 6000
	)

	(method (init)
		(gEgo init: setScaler: Scaler 71 64 129 116)
		(switch gPrevRoomNum
			(37300
				(gEgo normalize: 613 posn: 49 140)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(gEgo normalize: 612 posn: 50 140)
				(gCurRoom setScript: (ScriptID 0 5) 0 5) ; takeLastStep
			)
		)
		(super init: &rest)
		(if (IsFlag 146)
			(insideCrank init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		else
			(liftCrank init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		)
		(turnAround init: 1)
		(southExit init: 3)
		(hiddenDoor init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		(if (IsFlag 146)
			(insideCrank init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		else
			(liftCrank init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		)
		(gGame handsOn:)
	)
)

(instance sPullLever of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_8)
					(gCurRoom drawPic: 37205 picture: 37205)
					(DoRobot 907 -2 1 gEgo -1 1)
				)
				(1
					(gCurRoom newRoom: 12400)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gCurRoom newRoom: 12400)
				)
			)
		)
	)
)

(instance sGetLift of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Prints {Adrienne turns the crank to get the lift})
					(self cue:)
				)
				(1
					(insideCrank init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
					(liftCrank dispose:)
					(SetFlag 146)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(insideCrank init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
					(liftCrank dispose:)
					(SetFlag 146)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sTo3rdFloor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo hide:)
					(gCurRoom drawPic: 38130 picture: 38130)
					(DoRobot 9644 0 0 gEgo -1 1)
				)
				(1
					(ClearFlag 146)
					(gCurRoom newRoom: 38200)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(ClearFlag 146)
					(gCurRoom newRoom: 38200)
				)
			)
		)
	)
)

(instance hiddenDoor of Feature
	(properties
		sightAngle 40
		approachX 63
		approachY 138
		x 107
		y 79
	)

	(method (init)
		(self createPoly: 60 21 71 20 93 55 86 60 60 22)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sPullLever)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance insideCrank of Feature
	(properties
		nsLeft 46
		nsTop 64
		nsRight 59
		nsBottom 76
		sightAngle 40
		approachX 48
		approachY 122
		x 48
		y 121
		z 55
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sTo3rdFloor)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance liftCrank of Feature
	(properties
		nsLeft 31
		nsTop 64
		nsRight 41
		nsBottom 77
		sightAngle 40
		approachX 48
		approachY 122
		x 38
		y 122
		z 55
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sGetLift)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance turnAround of ExitFeature
	(properties
		nsLeft 36
		nsTop 99
		nsRight 64
		nsBottom 119
		approachX 50
		approachY 110
		x 50
		y 109
		nextRoom 37100
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 34
		nsTop 124
		nsRight 74
		sightAngle 360
		approachX 54
		approachY 160
		x 54
		y 180
		nextRoom 37300
	)
)

