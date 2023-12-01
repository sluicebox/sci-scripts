;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36400)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use Actor)
(use System)

(public
	rm36400 0
)

(instance rm36400 of ScaryRoom
	(properties
		picture 36400
		stepSound 4
		baseView 6000
	)

	(method (newRoom)
		(Palette 2 55 135 100) ; PalIntensity
		(super newRoom: &rest)
	)

	(method (init)
		(KillRobot)
		(global114 play: 4050)
		(Palette 2 55 135 70) ; PalIntensity
		(gEgo
			init:
			normalize: (if (== gPrevRoomNum 36200) 613 else 612)
			setScaler: Scaler 72 39 145 90
			posn: 90 (if (== gPrevRoomNum 36200) 145 else 110)
		)
		(if (== gPrevRoomNum 900)
			(gGame handsOn:)
		else
			(gCurRoom setScript: (ScriptID 0 5) 0 5) ; takeLastStep
		)
		(southExit init: 11)
		(door init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		(if (>= gChapter 6)
			(bottle init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		)
		(super init: &rest)
		(gGame handsOn:)
	)
)

(instance sBottle of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo hide:)
					(Palette 2 55 135 100) ; PalIntensity
					(gCurRoom drawPic: 495 picture: 495)
					(bottle hide:)
					(= seconds 5)
				)
				(1
					(gEgo show: posn: 124 133 normalize: 616)
					(gCurRoom drawPic: 36400 picture: 36400)
					(Palette 2 55 135 70) ; PalIntensity
					(bottle show:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(bottle show:)
			(Palette 2 55 135 70) ; PalIntensity
			(gEgo show: posn: 124 133 normalize: 616)
			(gCurRoom drawPic: 36400)
			(= global115 0)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

(instance sOpenDoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(proc1111_8)
					(Palette 2 55 135 100) ; PalIntensity
					(DoRobot 906 88 -10 gEgo -1 1)
					(gCurRoom drawPic: 36405 picture: 36405)
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
					(gCurRoom newRoom: 8200)
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
			(gCurRoom newRoom: 8200)
		)
	)
)

(instance bottle of View
	(properties
		x 134
		y 124
		view 495
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sBottle)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance door of Feature
	(properties
		nsLeft 97
		nsTop 55
		nsRight 116
		nsBottom 65
		approachX 110
		approachY 92
		x 96
		y 90
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurRoom setScript: sOpenDoor)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsTop 125
		approachX 117
		approachY 158
		nextRoom 36200
	)

	(method (handleEvent)
		(= approachX (gEgo x:))
		(super handleEvent: &rest)
	)
)

