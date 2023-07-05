;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28305)
(include sci.sh)
(use Main)
(use ExitFeature)
(use Scaler)

(public
	rm28305 0
)

(instance rm28305 of ScaryRoom
	(properties
		picture 28305
		stepSound 1
	)

	(method (newRoom newRoomNumber)
		(if (== gChapter 5)
			(Palette 2 55 135 100) ; PalIntensity
		)
		(super newRoom: newRoomNumber)
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
			(= picture 28306)
			(gEgo fadePalette: 28100)
		)
		(gEgo init: fadedY: 90 brightY: 120 setScaler: Scaler 93 60 119 90)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(28100
				(gEgo view: 3 posn: 148 105)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(28860
				(gEgo view: 1 posn: 142 105)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(gEgo view: 2 posn: 145 93)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		(northExit init: 1)
		(southExit init: 3)
		(eastExit init: 2)
		(super init: &rest)
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 10
		nsTop 120
		nsRight 200
		nsBottom 129
		approachX 160
		approachY 160
		nextRoom 28100
	)

	(method (doVerb)
		(if (== gChapter 3)
			(SetFlag 384)
		)
		(super doVerb: &rest)
	)
)

(instance northExit of ExitFeature
	(properties
		nsLeft 50
		nsTop 1
		nsRight 200
		nsBottom 80
		approachX 160
		nextRoom 28410
	)
)

(instance eastExit of ExitFeature
	(properties
		nsLeft 201
		nsTop 1
		nsRight 319
		nsBottom 129
		nextRoom 28860
	)
)

