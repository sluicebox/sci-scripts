;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28410)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm28410 0
)

(instance rm28410 of ScaryRoom
	(properties
		picture 28410
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
		(water init:)
		(if (== gChapter 5)
			(Palette 2 55 135 70) ; PalIntensity
			(= picture 28411)
			(gEgo fadePalette: 28100)
		)
		(cond
			((or (!= gChapter 4) (IsFlag 325) (IsFlag 185)) 0)
			((not (IsFlag 182))
				(cyrus init: setSpeed: 6 ignoreActors: 1 setCycle: Fwd)
			)
			(else
				(if (and (!= gPrevRoomNum 28820) (IsFlag 334))
					(ClearFlag 334)
				)
				(if (not (IsFlag 334))
					(cyrus init: setSpeed: 6 ignoreActors: 1)
					(cyrus
						cel:
							(if (== gPrevRoomNum 28820)
								global225
							else
								(Random 0 (cyrus lastCel:))
							)
						setCycle: Fwd
					)
				)
			)
		)
		(gEgo init: setScaler: Scaler 64 30 129 65 normalize:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(28840
				(gEgo normalize: 6 posn: 20 95)
				(westExit1 approachX: 40 approachY: 80)
				(westExit2 approachX: 0 approachY: 110)
				(eastExit approachX: 320 approachY: 80)
				(if (and (IsFlag 189) (not (IsFlag 203)))
					(self setScript: hearTruckScr)
				else
					(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
				)
			)
			(28305
				(gEgo view: 1 posn: 287 66)
				(westExit1 approachX: 0 approachY: 80)
				(westExit2 approachX: approachY: 80)
				(eastExit approachX: 320 approachY: 70)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(gEgo normalize: 0 posn: 20 66)
				(westExit1 approachX: 0 approachY: 80)
				(westExit2 approachX: 100 approachY: 40)
				(eastExit approachX: 320 approachY: 66)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		(westExit1 init: 13)
		(westExit2 init: 12)
		(eastExit init: 2)
		(super init: &rest)
	)
)

(instance hearTruckScr of Script
	(properties)

	(method (changeState newState)
		(if global115
			(proc1111_6)
			(if (gCast contains: cyrus)
				(cyrus show:)
			)
			(gCurRoom drawPic: 28410)
			(water show:)
			(gCurRoom setScript: (ScriptID 0 5)) ; takeLastStep
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gCurRoom picture: 28415)
					(water hide:)
					(proc1111_7 4560 87 -7)
					(if (gCast contains: cyrus)
						(cyrus hide:)
					)
					(SetFlag 203)
				)
				(1
					(if (gCast contains: cyrus)
						(cyrus show:)
					)
					(gCurRoom drawPic: 28410)
					(water show:)
					(gCurRoom setScript: (ScriptID 0 5)) ; takeLastStep
				)
			)
		)
	)
)

(instance westExit1 of ExitFeature
	(properties
		nsLeft -20
		nsTop 50
		nsRight 19
		nsBottom 76
		nextRoom 28820
	)
)

(instance westExit2 of ExitFeature
	(properties
		nsLeft -20
		nsTop 84
		nsRight 20
		nsBottom 106
		nextRoom 28840
	)
)

(instance eastExit of ExitFeature
	(properties
		nextRoom 28305
	)
)

(instance bridgeFeat of Feature ; UNUSED
	(properties
		nsLeft 132
		nsTop 41
		nsRight 280
		nsBottom 93
		x 206
		y 93
	)
)

(instance cyrus of Actor
	(properties
		x 103
		y 52
		scaleX 64
		scaleY 64
		view 4371
		scaleSignal 1
	)

	(method (init)
		(if (IsFlag 182)
			(self view: 4370 posn: 103 52)
		else
			(self view: 4389 posn: 120 53)
		)
		(super init: &rest)
		(|= signal $1000)
		(self setCycle: Fwd)
	)

	(method (dispose)
		(= global225 cel)
		(super dispose:)
	)
)

(instance water of Prop
	(properties
		x 163
		y 129
		fixPriority 1
		view 28410
	)

	(method (init)
		(if (== gChapter 5)
			(++ view)
			(= x 167)
		)
		(super init: &rest)
		(= cycleSpeed 14)
		(self setCycle: Fwd)
	)
)

