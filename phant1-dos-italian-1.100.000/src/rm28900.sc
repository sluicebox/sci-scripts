;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28900)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Talker)
(use Scaler)
(use Motion)
(use Actor)
(use System)

(public
	rm28900 0
)

(instance rm28900 of ScaryRoom
	(properties
		picture 29200
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
				(= temp0 9040)
			)
			((== gChapter 2)
				(= temp1 915)
				(= temp0 9050)
			)
			((== gChapter 3)
				(= temp1 916)
				(= temp0 9060)
			)
			((== gChapter 4)
				(= temp1 916)
				(= temp0 9060)
			)
			((== gChapter 5)
				(= temp1 917)
				(= temp0 9070)
			)
			((== gChapter 6)
				(= temp1 918)
				(= temp0 9080)
			)
		)
		(if (!= gChapter 5)
			(if (== (gGDacSound number:) temp0)
				(if (not (gGDacSound handle:))
					(gGDacSound number: temp0 setLoop: -1 play:)
				)
			else
				(gGDacSound number: temp0 setLoop: -1 play:)
			)
		)
		((ScriptID 30) init:) ; FidgetCode
		(if (== gChapter 5)
			(= picture 29201)
			(Palette 2 55 135 70) ; PalIntensity
			(gEgo fadePalette: 28100)
		)
		(super init: &rest)
		(gEgo
			init:
			fadedY: 90
			brightY: 120
			setScaler: Scaler 93 46 140 101
			normalize:
		)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(28800
				(gEgo view: 0 posn: 4 106)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(gEgo view: 1 posn: 287 77)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		(if (not (IsFlag 187))
			(lens init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
			(lens cycleSpeed: 6 setCycle: Blink 120 ignoreActors:)
		)
		(water init:)
		(westExit init: 4)
		(eastExit init: 2)
	)
)

(instance water of Prop
	(properties
		x 123
		y 53
		fixPriority 1
		view 29200
	)

	(method (init)
		(if (== gChapter 5)
			(++ view)
		)
		(super init: &rest)
		(= cycleSpeed 14)
		(self setCycle: Fwd)
	)
)

(instance lens of Prop
	(properties
		approachX 165
		approachY 105
		x 163
		y 105
		view 4433
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gGame handsOff:)
			(gCurRoom setScript: getLensScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance westExit of ExitFeature
	(properties
		nsTop 50
		nsBottom 117
		nextRoom 28800
	)
)

(instance eastExit of ExitFeature
	(properties
		nsTop 50
		nsBottom 117
		approachX 400
		approachY 100
		nextRoom 21100
	)
)

(instance getLensScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (< (gEgo x:) 160)
						(DoRobot 4430 -5 -2)
					else
						(DoRobot 4432 48 -24)
					)
					(water posn: 1 62 view: 29205)
					(gCurRoom drawPic: 29205)
					(SetFlag 187)
					(lens dispose:)
				)
				(1
					(gEgo hide:)
					(water hide:)
					(gCurRoom drawPic: 4431)
					(= ticks 480)
					(gEgo get: 12) ; invLensPiece
				)
				(2
					(gEgo show:)
					(water show:)
					(gCurRoom drawPic: 29205)
					(if (< (gEgo x:) 160)
						(DoRobot 4431 33 -8)
					else
						(DoRobot 4433 31 -25)
					)
				)
				(3
					(gCurRoom drawPic: (+ 29200 (== gChapter 5)))
					(water view: 29200 x: 123 y: 53)
					(gEgo normalize: 4 posn: 160 110)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(KillRobot)
			(gEgo get: 12) ; invLensPiece
			(gCurRoom drawPic: (+ 29200 (== gChapter 5)))
			(water view: 29200 x: 123 y: 53 show:)
			(gEgo show: normalize: 4 posn: 160 110)
			(= global115 0)
			(gGame handsOn:)
			(self dispose:)
		)
	)
)

