;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38200)
(include sci.sh)
(use Main)
(use n1111)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	rm38200 0
)

(instance rm38200 of ScaryRoom
	(properties
		picture 38200
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
		(global114 play: 4050)
		(gEgo init: setScale: 0 normalize:)
		(switch gPrevRoomNum
			(16200
				(crank approachX: 75 approachY: 140)
				(lift approachX: 75 approachY: 140)
				(gEgo posn: 43 135 normalize: 614)
				(gGame handsOn:)
			)
			(900
				(gGame handsOn:)
			)
			(else
				(gEgo posn: 240 124 normalize: 615)
				(crank approachX: 250 approachY: 110)
				(lift approachX: 250 approachY: 110)
				(self setScript: (ScriptID 0 5)) ; takeLastStep
			)
		)
		(myHandle init: approachVerbs: 4 3 setHotspot: 4 3) ; Do, Move, Do, Move
		(if (not (IsFlag 146))
			(lift init: approachVerbs: 4 3 setHotspot: 4 3) ; Do, Move, Do, Move
		else
			(crank init: approachVerbs: 4 3 setHotspot: 4 3) ; Do, Move, Do, Move
		)
		(super init: &rest)
	)
)

(instance sOpenDoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_8)
					(gGame handsOff:)
					(Palette 2 55 135 100) ; PalIntensity
					(lift dispose:)
					(gCurRoom drawPic: 38205 picture: 38205)
					(DoRobot 904 -8 -44 gEgo -1 1)
				)
				(1
					(cond
						((== gChapter 5)
							(global114 play: 913)
						)
						((== gChapter 6)
							(global114 play: 914)
						)
						((== gChapter 7)
							(global114 play: 9140)
						)
					)
					(gCurRoom newRoom: 16200)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(cond
				((== gChapter 5)
					(global114 play: 913)
				)
				((== gChapter 6)
					(global114 play: 914)
				)
				((== gChapter 7)
					(global114 play: 9140)
				)
			)
			(gCurRoom newRoom: 16200)
		)
	)
)

(instance sGoDown of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo hide:)
					(lift dispose:)
					(gCurRoom drawPic: 37325)
					(Palette 2 55 135 100) ; PalIntensity
					(DoRobot 9645 25 1 gEgo 0)
				)
				(1
					(gCurRoom drawPic: 38130)
					(DoRobot 9643 0 0 gEgo -1 1)
				)
				(2
					(gEgo hide:)
					(gCurRoom newRoom: 37100)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(gCurRoom newRoom: 37100)
		)
	)
)

(instance sCrankElevator of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(Palette 2 55 135 100) ; PalIntensity
					(gCurRoom drawPic: 37325)
					(DoRobot 37325 5 4)
				)
				(1
					(gCurRoom drawPic: 38200)
					(lift init:)
					(Palette 2 55 135 70) ; PalIntensity
					(gEgo posn: 237 117 normalize: 610 setHeading: 0 self)
				)
				(2
					(Palette 2 55 135 100) ; PalIntensity
					(lift dispose:)
					(gCurRoom drawPic: 37325)
					(DoRobot 9645 25 1 gEgo 0)
				)
				(3
					(gCurRoom drawPic: 38130 picture: 38130)
					(DoRobot 9643 0 0 gEgo -1 1)
				)
				(4
					(gEgo hide:)
					(gCurRoom newRoom: 37100)
				)
			)
		else
			(= global115 0)
			(KillRobot)
			(gCurRoom newRoom: 37100)
		)
	)
)

(instance lift of View
	(properties
		x 238
		y 104
		fixPriority 1
		view 38200
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(SetFlag 146)
			(gCurRoom setScript: sGoDown)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance crank of Feature
	(properties
		nsLeft 266
		nsRight 291
		nsBottom 36
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(SetFlag 146)
			(gCurRoom setScript: sCrankElevator)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance myHandle of Feature
	(properties
		approachX 45
		approachY 116
	)

	(method (init)
		(= onMeCheck
			((Polygon new:) type: PTotalAccess init: 55 43 55 51 62 51 62 43 yourself:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sOpenDoor)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

