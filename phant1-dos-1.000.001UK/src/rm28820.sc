;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28820)
(include sci.sh)
(use Main)
(use ExitFeature)
(use Scaler)
(use Motion)
(use Actor)

(public
	rm28820 0
)

(instance rm28820 of ScaryRoom
	(properties
		picture 28820
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
			(= picture 28821)
			(gEgo fadePalette: 28100)
		)
		(super init: &rest)
		(water init:)
		(gEgo init: fadedY: 90 brightY: 120 setScaler: Scaler 111 33 172 74)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(28410
				(gEgo normalize: 0 posn: 80 72)
				(southWestExit
					approachX: (southExit approachX:)
					approachY: (southExit approachY:)
				)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(28815
				(gEgo normalize: 3 posn: 182 125)
				(westExit approachX: 175)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(28863
				(gEgo normalize: 0 posn: 120 125)
				(westExit approachX: 175)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(gEgo normalize: 3 posn: 182 125)
				(westExit approachX: 175)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		(southExit init: 3)
		(southWestExit init: 4)
		(westExit init: 13)
	)
)

(instance westExit of ExitFeature
	(properties
		nsRight 180
		nsBottom 76
		approachX 60
		approachY 67
		nextRoom 28410
	)

	(method (doVerb)
		(if (== gChapter 3)
			(SetFlag 384)
		)
		(super doVerb: &rest)
	)
)

(instance southWestExit of ExitFeature
	(properties
		nsTop 100
		nsRight 80
		approachX 30
		approachY 125
		nextRoom 28863
	)
)

(instance water of Prop
	(properties
		y 119
		view 28820
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

(instance southExit of ExitFeature
	(properties
		approachX 182
		approachY 200
		nextRoom 28815
	)
)

