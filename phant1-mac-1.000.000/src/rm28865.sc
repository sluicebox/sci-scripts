;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28865)
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
	rm28865 0
)

(local
	local0
	local1
)

(instance rm28865 of ScaryRoom
	(properties
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
		(SetFlag 121)
		(if (== gChapter 5)
			(= picture 28711)
			(lamp1 init:)
			(lamp2 init:)
			(Palette 2 55 135 70) ; PalIntensity
			(gEgo fadePalette: 28100)
		else
			(= picture 28710)
		)
		(cond
			((or (!= gChapter 4) (IsFlag 325) (IsFlag 185))
				(if (>= gChapter 4)
					(stump init:)
				)
			)
			((not (IsFlag 182))
				(cyrus
					view: 4389
					posn: 203 62
					init:
					ignoreActors: 1
					setSpeed: 6
					cel: global225
					setCycle: Fwd
				)
			)
			((not (IsFlag 334))
				(Load 140 28040) ; WAVE
				(Lock 140 28040 1) ; WAVE
				(Load 140 28041) ; WAVE
				(Lock 140 28041 1) ; WAVE
				(Load 140 28042) ; WAVE
				(Lock 140 28042 1) ; WAVE
				(cyrus
					init:
					ignoreActors: 1
					setSpeed: 6
					cel: global225
					setCycle: Fwd
				)
			)
		)
		(gEgo
			posn: 148 81
			fadedY: 90
			brightY: 120
			init:
			normalize: 2
			setScaler: Scaler 218 52 162 73
		)
		(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
		(super init:)
		(if (and (== gChapter 5) (IsFlag 44) (not (IsFlag 37)))
			(rose init: setHotspot: 4 3) ; Do, Move
		)
		(northExit init: 1)
	)

	(method (dispose)
		(Lock 140 28040 0) ; WAVE
		(Lock 140 28041 0) ; WAVE
		(Lock 140 28042 0) ; WAVE
		(ClearFlag 121)
		(super dispose: &rest)
	)
)

(instance seeGazeboVision of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rose dispose:)
				(SetFlag 121)
				(SetFlag 37)
				(gEgo normalize: 2)
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

(instance northExit of ExitFeature
	(properties
		nsLeft 135
		nsTop 1
		nsRight 155
		nsBottom 90
		nextRoom 28863
	)
)

(instance stump of View
	(properties
		x 182
		y 64
		view 4371
	)
)

(instance sfx of Sound
	(properties
		flags 4
	)
)

(instance cyrus of Actor
	(properties
		x 182
		y 64
		view 4370
	)

	(method (dispose)
		(= global225 cel)
		(super dispose:)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if (IsFlag 182)
			(= temp0 16)
			(-- temp0)
			(cond
				((not local1)
					(if (== cel temp0)
						(= local1 1)
						(sfx number: (Random 28040 28042) setLoop: 1 play:)
					)
				)
				((!= cel temp0)
					(= local1 0)
				)
			)
		)
	)
)

(instance lamp1 of Prop
	(properties
		x 40
		y 65
		priority 150
		fixPriority 1
		view 28711
	)

	(method (init)
		(super init: &rest)
		(self cycleSpeed: 14 setCycle: RandCycle -1)
	)
)

(instance lamp2 of Prop
	(properties
		x 246
		y 65
		priority 150
		fixPriority 1
		view 28711
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self cycleSpeed: 14 setCycle: RandCycle -1)
	)
)

(instance rose of Prop
	(properties
		x 147
		y 89
		scaleX 90
		scaleY 90
		view 28865
		scaleSignal 1
	)

	(method (init)
		(= cel (self lastCel:))
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

