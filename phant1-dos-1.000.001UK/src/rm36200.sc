;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36200)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use Actor)
(use System)

(public
	rm36200 0
)

(instance rm36200 of ScaryRoom
	(properties
		picture 36200
		stepSound 4
		baseView 6000
	)

	(method (init)
		(proc1111_6)
		(Palette 2 55 135 70) ; PalIntensity
		(gEgo init: normalize: setScaler: Scaler 71 64 129 116)
		(southExit init: 11)
		(eastExit init: 10)
		(westExit init: 12)
		(switch gPrevRoomNum
			(36400
				(gEgo posn: 71 132 normalize: 617)
				(gCurRoom setScript: (ScriptID 0 5) 0 5) ; takeLastStep
			)
			(36300
				(gEgo normalize: 616 posn: 35 133)
				(gCurRoom setScript: (ScriptID 0 5) 0 5) ; takeLastStep
			)
			(37300
				(gEgo normalize: 614 posn: 71 125)
				(westExit approachX: 48 approachY: 160)
				(gCurRoom setScript: (ScriptID 0 5) 0 5) ; takeLastStep
			)
			(900
				(gGame handsOn:)
			)
			(else
				(gEgo normalize: 615 posn: 117 130)
				(gCurRoom setScript: (ScriptID 0 5) 0 5) ; takeLastStep
				(southExit approachX: 137)
			)
		)
		(if (IsFlag 147)
			(lift init:)
			(insideCrank init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		else
			(liftCrank init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		)
		(gGame handsOn:)
		(super init: &rest)
	)

	(method (newRoom)
		(Palette 2 55 135 100) ; PalIntensity
		(super newRoom: &rest)
	)
)

(instance sGetLift of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo hide:)
					(Palette 2 55 135 100) ; PalIntensity
					(proc1111_7 36205 2 1)
					(gCurRoom drawPic: 36205)
				)
				(1
					(gCurRoom drawPic: 36200)
					(lift init:)
					(Palette 2 55 135 70) ; PalIntensity
					(gEgo
						show:
						normalize: 616
						posn: 76 121
						setHeading: 315 self
					)
				)
				(2
					(lift dispose:)
					(gCurRoom drawPic: 38135)
					(proc1111_7 9648)
					(Palette 2 55 135 100) ; PalIntensity
				)
				(3
					(proc1111_7 9642 0 0 gEgo 0 1)
					(gCurRoom drawPic: 37320)
				)
				(4
					(gEgo hide:)
					(gCurRoom newRoom: 37300)
				)
			)
		else
			(= global115 0)
			(proc1111_6)
			(ClearFlag 147)
			(gCurRoom newRoom: 37300)
		)
	)
)

(instance sGoUp of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(ClearFlag 147)
					(gCurRoom drawPic: 38135)
					(lift dispose:)
					(Palette 2 55 135 100) ; PalIntensity
					(proc1111_7 9648)
				)
				(1
					(gCurRoom drawPic: 37320)
					(proc1111_7 9642 0 0 gEgo 0 1)
				)
				(2
					(gEgo hide:)
					(gCurRoom newRoom: 37300)
				)
			)
		else
			(= global115 0)
			(proc1111_6)
			(ClearFlag 147)
			(gCurRoom newRoom: 37300)
		)
	)
)

(instance lift of View
	(properties
		x 21
		priority 1
		fixPriority 1
		view 36201
	)
)

(instance insideCrank of Feature
	(properties
		nsLeft 30
		nsTop 42
		nsRight 48
		nsBottom 57
		approachX 49
		approachY 105
		x 29
		y 39
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sGoUp)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance liftCrank of Feature
	(properties
		nsLeft 83
		nsTop 38
		nsRight 101
		nsBottom 57
		approachX 78
		approachY 120
		x 79
		y 120
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sGetLift)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance eastExit of ExitFeature
	(properties
		nsLeft 152
		nsTop 21
		nsRight 175
		nsBottom 114
		approachX 164
		approachY 96
		nextRoom 39100
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 64
		nsTop 124
		nsRight 271
		nsBottom 129
		approachX 107
		approachY 160
		nextRoom 36400
	)
)

(instance westExit of ExitFeature
	(properties
		nsLeft 0
		nsTop 22
		nsRight 16
		nsBottom 130
		approachX 48
		approachY 170
		nextRoom 36300
	)
)

