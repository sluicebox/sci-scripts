;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37300)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use Actor)
(use System)

(public
	rm37300 0
)

(instance rm37300 of ScaryRoom
	(properties
		picture 37300
		stepSound 4
		baseView 6000
	)

	(method (newRoom)
		(Palette 2 55 135 100) ; PalIntensity
		(super newRoom: &rest)
	)

	(method (init)
		(Palette 2 55 135 70) ; PalIntensity
		(KillRobot)
		(gEgo init: setScaler: Scaler 85 79 145 116 normalize:)
		(switch gPrevRoomNum
			(36200
				(ClearFlag 147)
				(gEgo posn: 120 135 normalize: 612)
				(gCurRoom setScript: (ScriptID 0 5) 0 5) ; takeLastStep
			)
			(900
				(gGame handsOn:)
			)
			(else
				(crankTo36200 approachY: 145)
				(liftCrank approachY: 145)
				(gEgo posn: 280 145 normalize: 611)
				(gCurRoom setScript: (ScriptID 0 5) 0 5) ; takeLastStep
			)
		)
		(super init: &rest)
		(eastExit init: 2)
		(if (not (IsFlag 147))
			(lift init:)
			(crankTo36200 init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		else
			(liftCrank init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		)
	)
)

(instance lift of View
	(properties
		x 80
		y 127
		priority 1
		fixPriority 1
		view 37300
	)
)

(instance sTo36200 of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Palette 2 55 135 100) ; PalIntensity
					(SetFlag 147)
					(lift dispose:)
					(gCurRoom drawPic: 37320 picture: 37320)
					(DoRobot 9641 0 0 gEgo 0)
				)
				(1
					(gCurRoom drawPic: 38135)
					(DoRobot 9647 0 0 gEgo -1 1)
				)
				(2
					(gEgo hide:)
					(gCurRoom newRoom: 36200)
				)
			)
		else
			(= global115 0)
			(gCurRoom newRoom: 36200)
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
					(SetFlag 147)
					(Palette 2 55 135 100) ; PalIntensity
					(gCurRoom drawPic: 37320)
					(DoRobot 37320 -4 2)
				)
				(1
					(gCurRoom drawPic: 37300)
					(lift init:)
					(Palette 2 55 135 70) ; PalIntensity
					(gEgo posn: 120 135 normalize: 611 setHeading: 0 self)
				)
				(2
					(Palette 2 55 135 100) ; PalIntensity
					(lift dispose:)
					(gCurRoom drawPic: 37320)
					(DoRobot 9641 0 0 gEgo 0)
				)
				(3
					(gCurRoom drawPic: 38135)
					(DoRobot 9647 0 0 gEgo -1 1)
				)
				(4
					(gEgo hide:)
					(gCurRoom newRoom: 36200)
				)
			)
		else
			(= global115 0)
			(KillRobot)
			(gEgo hide:)
			(gCurRoom newRoom: 36200)
		)
	)
)

(instance crankTo36200 of Feature
	(properties
		nsLeft 104
		nsTop 53
		nsRight 118
		nsBottom 68
		approachX 111
		approachY 60
		x 111
		y 60
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sTo36200)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance liftCrank of Feature
	(properties
		nsLeft 82
		nsTop 56
		nsRight 93
		nsBottom 70
		sightAngle 40
		approachX 104
		approachY 129
		x 104
		y 121
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

(instance eastExit of ExitFeature
	(properties
		approachX 330
		approachY 145
		nextRoom 37100
	)
)

