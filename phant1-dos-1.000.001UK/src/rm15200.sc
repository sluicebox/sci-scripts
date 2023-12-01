;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15200)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Actor)
(use System)

(public
	rm15200 0
)

(instance rm15200 of ScaryRoom
	(properties
		picture 15200
		stepSound 4
	)

	(method (init)
		((ScriptID 30) init:) ; FidgetCode
		(= global125 0)
		(gEgo init: setScaler: Scaler 125 41 134 85 normalize:)
		(southExit init: 3)
		(westExit init: 4)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(15300
				(gEgo normalize: 4 posn: 110 91)
				(westExit approachX: 90 approachY: 91)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(18100
				(gEgo normalize: 5 posn: 130 91)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(18200
				(gEgo normalize: 5 posn: 130 91)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(gEgo normalize: 3 posn: 120 106)
				(westExit approachX: 120 approachY: 90)
				(gCurRoom setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		(cond
			((or (not (OneOf gChapter 2 3)) (not (IsFlag 120))) 0)
			((gGDacSound handle:)
				(gGDacSound setVol: 64)
			)
			(else
				(gGDacSound number: 15020 setLoop: 1 play: setVol: 64)
			)
		)
		(nurseryDoor init: 10)
		(bear init:)
		(if (and (== gChapter 1) (IsFlag 79) (not (IsFlag 181)))
			(bathroomDoor init:)
			(if (not (IsFlag 82))
				(bathroomDoor setHotspot: 4 3 approachVerbs: 4) ; Do, Move, Do
			)
		else
			(bathroom init: 1 approachVerbs: 0)
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if
			(and
				(== gChapter 4)
				(== newRoomNumber 18100)
				(IsFlag 265)
				(not (IsFlag 3))
				(not (IsFlag 247))
			)
			(SetFlag 247)
			(ClearFlag 52)
		)
		(if
			(and
				(== gChapter 4)
				(== newRoomNumber 15100)
				(IsFlag 3)
				(not (IsFlag 5))
				(not (IsFlag 264))
			)
			(SetFlag 264)
		)
		(if
			(and
				(== gChapter 4)
				(== newRoomNumber 15300)
				(IsFlag 5)
				(not (IsFlag 325))
			)
			(SetFlag 325)
			(ClearFlag 264)
		)
		(if
			(and
				(OneOf gChapter 2 3)
				(not (OneOf newRoomNumber 15100 14200))
				(IsFlag 120)
				(gGDacSound handle:)
			)
			(gGDacSound setVol: 32)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance bear of View
	(properties
		x 281
		y 60
		view 15201
		loop 1
	)
)

(instance bathroomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((and (== (gEgo x:) 110) (== (gEgo y:) 91))
						(gEgo setHeading: 90 self)
					)
					((and (== (gEgo x:) 130) (== (gEgo y:) 91))
						(gEgo setHeading: 45 self)
					)
					(else
						(gEgo setHeading: 0 self)
					)
				)
			)
			(1
				(gCurRoom newRoom: 18100)
			)
		)
	)
)

(instance nurseryDoor of ExitFeature
	(properties
		nsLeft 200
		nsTop 0
		nsRight 295
		nsBottom 134
		approachX 120
		approachY 130
		nextRoom 14100
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(if
				(and
					(== gChapter 1)
					(IsFlag 77)
					(not (IsFlag 78))
					(not (IsFlag 79))
				)
				(SetFlag 78)
				(SetFlag 79)
			)
			(gGame handsOff:)
			(if
				(and
					(OneOf gChapter 2 3)
					(IsFlag 120)
					(not (IsFlag 119))
				)
				(if (gGDacSound handle:)
					(gGDacSound stop:)
				)
				(gCurRoom newRoom: 14200)
			else
				(gCurRoom newRoom: 14100)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 44
		nsRight 182
		approachX 120
		approachY 130
		nextRoom 15100
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(if
				(and
					(== gChapter 1)
					(IsFlag 77)
					(not (IsFlag 78))
					(not (IsFlag 79))
				)
				(SetFlag 78)
				(SetFlag 79)
			)
			(gGame handsOff:)
			(gCurRoom newRoom: 15100)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance westExit of ExitFeature
	(properties
		nsLeft 61
		nsTop 34
		nsRight 87
		nsBottom 100
		approachX 110
		approachY 91
		x 44
		y 102
		nextRoom 15300
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(if (and (== gChapter 1) (IsFlag 82) (not (IsFlag 181)))
				(SetFlag 181)
			)
			(gGame handsOff:)
			(gCurRoom newRoom: 15300)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bathroom of ExitFeature
	(properties
		nsLeft 139
		nsTop 55
		nsRight 158
		nsBottom 86
		approachX 143
		approachY 78
		x 153
		y 86
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Exit
			(gGame handsOff:)
			(if (and (== gChapter 1) (>= global172 3) (not (IsFlag 83)))
				(SetFlag 53)
			)
			(gCurRoom setScript: bathroomScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bathroomDoor of View
	(properties
		x 130
		y 89
		view 15200
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (not (IsFlag 82))
				(gGame handsOff:)
				(gCurRoom setScript: donBathroomScr)
			else
				(super doVerb: theVerb)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance donBathroomScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(bathroomDoor hide:)
					(bear hide:)
					(DoRobot 1530 127 12)
					(gCurRoom drawPic: 15330)
					(SetFlag 82)
				)
				(1
					(gEgo normalize: 5 posn: 130 91)
					(bear show:)
					(bathroomDoor show: setHotspot: 0 approachVerbs: 0)
					(gCurRoom drawPic: 15200)
					(self setScript: (ScriptID 0 5) self) ; takeLastStep
				)
				(2
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo normalize: 5 posn: 130 91)
					(bear show:)
					(bathroomDoor show: setHotspot: 0 approachVerbs: 0)
					(gCurRoom drawPic: 15200)
					(SetFlag 82)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

