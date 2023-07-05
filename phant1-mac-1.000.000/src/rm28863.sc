;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28863)
(include sci.sh)
(use Main)
(use movieScr)
(use ExitFeature)
(use Scaler)
(use RandCycle)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm28863 0
)

(instance rm28863 of ScaryRoom
	(properties
		picture 28210
	)

	(method (newRoom newRoomNumber)
		(if (== gChapter 5)
			(Palette 2 55 135 100) ; PalIntensity
		)
		(super newRoom: newRoomNumber)
	)

	(method (init &tmp temp0 temp1)
		(= temp1 0)
		(water init:)
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
			(= picture 28211)
			(lamps init:)
			(gEgo fadePalette: 28100)
		)
		(super init: &rest)
		(gEgo init: setScaler: Scaler 104 43 129 81 normalize:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(28820
				(gEgo normalize: 5 posn: 280 110)
				(eastExit approachX: 290 approachY: 120)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(28865
				(gEgo normalize: 4 posn: 191 110)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(gEgo normalize: 7 posn: 243 125)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		(if (and (== gChapter 5) (IsFlag 44) (not (IsFlag 37)))
			(rose init: approachVerbs: 4 3 setHotspot: 4 3) ; Do, Move, Do, Move
		)
		(southExit init: 11)
		(eastExit init: 11)
		(arborExit init: 10)
		(gazeboExit init: 13)
	)
)

(instance water of Prop
	(properties
		y 109
		fixPriority 1
		view 28210
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

(instance lamps of Prop
	(properties
		x 31
		y 86
		fixPriority 1
		view 28211
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self cycleSpeed: 14 setCycle: RandCycle -1)
	)
)

(instance eastExit of ExitFeature
	(properties
		nsLeft 280
		nsTop 110
		nsRight 310
		nsBottom 135
		approachX 283
		approachY 165
		nextRoom 28860
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 170
		nsTop 120
		approachX 283
		approachY 165
		nextRoom 28860
	)
)

(instance gazeboExit of ExitFeature
	(properties
		nsLeft 50
		nsTop 50
		nsRight 100
		nsBottom 100
		approachX 160
		approachY 89
		nextRoom 28865
	)
)

(instance arborExit of ExitFeature
	(properties
		nsLeft 200
		nsTop 50
		nsBottom 100
		approachX 281
		approachY 109
		nextRoom 28820
	)
)

(instance sFx of Sound
	(properties
		flags 4
	)
)

(instance rose of Prop
	(properties
		approachX 160
		approachY 89
		x 159
		y 101
		scaleX 90
		scaleY 90
		fixPriority 1
		view 28865
		scaleSignal 1
	)

	(method (cue)
		(sFx number: 28050 setLoop: 1 play:)
		(self setCycle: End)
	)

	(method (dispose)
		(Lock 140 28050 1) ; WAVE
		(RemapColors 0) ; Off
		(super dispose:)
	)

	(method (init)
		(if (not (IsFlag 377))
			(Load 140 28050) ; WAVE
			(Lock 140 28050 1) ; WAVE
			(self setCycle: CT 7 1 self)
			(SetFlag 377)
		else
			(= cel (self lastCel:))
		)
		(RemapColors 2 238 140) ; ByPercent
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 3) ; Do, Move
			(gCurRoom setScript: seeGazeboVision)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance seeGazeboVision of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo normalize: 7 posn: 191 110)
				(SetFlag 121)
				(SetFlag 37)
				(rose dispose:)
				(gGame handsOff:)
				(Palette 2 55 135 100) ; PalIntensity
				(PlayVMD 0 {5030.vmd} 0) ; Open
				(proc26_0 5030 self)
			)
			(1
				(rose dispose:)
				(gGame handsOn:)
				(ClearFlag 121)
				(gCurRoom drawPic: (gCurRoom picture:))
				(UpdatePlane (gCast plane:))
				(UpdateScreenItem gEgo)
				(self dispose:)
			)
		)
	)
)

