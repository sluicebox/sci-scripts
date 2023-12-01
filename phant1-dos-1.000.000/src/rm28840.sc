;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28840)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use System)

(public
	rm28840 0
)

(instance rm28840 of ScaryRoom
	(properties
		picture 28840
		stepSound 1
	)

	(method (newRoom)
		(if (== gChapter 5)
			(Palette 2 55 135 100) ; PalIntensity
		)
		(super newRoom: &rest)
	)

	(method (init &tmp temp0 temp1)
		(= temp1 0)
		(cond
			((== gChapter 1)
				(= temp0 904)
			)
			((== gChapter 2)
				(= temp1 915)
				(= temp0 905)
			)
			((== gChapter 3)
				(= temp1 916)
				(= temp0 906)
			)
			((== gChapter 4)
				(= temp1 916)
				(= temp0 906)
			)
			((== gChapter 5)
				(= temp1 917)
				(= temp0 907)
			)
			((== gChapter 6)
				(= temp1 918)
				(= temp0 908)
			)
		)
		(if (== (gGDacSound number:) temp0)
			(if (not (gGDacSound handle:))
				(gGDacSound number: temp0 setLoop: -1 play:)
			)
		else
			(gGDacSound number: temp0 setLoop: -1 play:)
		)
		((ScriptID 30) init:) ; FidgetCode
		(if (== gChapter 5)
			(Palette 2 55 135 70) ; PalIntensity
			(= picture 28841)
			(gEgo fadePalette: 28100)
		)
		(super init: &rest)
		(gEgo
			init:
			fadedY: 90
			brightY: 120
			setScaler: Scaler 100 27 128 54
			normalize:
		)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(28410
				(gEgo view: 6 posn: 5 120)
				(eastExit approachX: 100 approachY: 40)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(gEgo view: 7 posn: 280 100)
				(westExit approachX: 220 approachY: 60)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		(crypt init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		(eastExit init: 11)
		(westExit init: 12)
	)
)

(instance crypt of Feature
	(properties
		nsLeft 207
		nsTop 34
		nsRight 240
		nsBottom 60
		approachX 220
		approachY 60
		x 223
		y 60
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: cryptScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance eastExit of ExitFeature
	(properties
		nsLeft 270
		nsTop 60
		approachX 300
		approachY 120
		nextRoom 28800
	)
)

(instance westExit of ExitFeature
	(properties
		nsTop 60
		nsRight 40
		approachX -10
		approachY 150
		nextRoom 28410
	)
)

(instance cryptScr of Script
	(properties)

	(method (changeState newState)
		(if global115
			(KillRobot)
			(gCurRoom drawPic: (gCurRoom picture:))
			(gEgo normalize: 6 posn: 217 65)
			(= global115 0)
			(gGame handsOn:)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(westExit approachX: 0 approachY: 165)
					(eastExit approachX: 300 approachY: 110)
					(gCurRoom drawPic: (+ 22320 (== gChapter 5)))
					(DoRobot 1640 3 -19)
				)
				(1
					(gCurRoom drawPic: (gCurRoom picture:))
					(gEgo normalize: 6 posn: 217 65)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

