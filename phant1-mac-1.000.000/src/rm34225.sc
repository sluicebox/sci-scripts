;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34225)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use Scaler)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm34225 0
)

(local
	local0
)

(instance rm34225 of ScaryRoom
	(properties
		picture 34225
		stepSound 1
	)

	(method (init)
		(KillRobot)
		(= local0 (Set new:))
		((ScriptID 30) init:) ; FidgetCode
		(if (and (== gChapter 1) (gEgo has: 0)) ; invLibKey
			(SetFlag 235)
		)
		(gEgo
			init:
			fadedY: 90
			brightY: 120
			setScaler: Scaler 109 40 135 94
			normalize:
		)
		(if (or (!= (gGDacSound number:) 903) (not (gGDacSound handle:)))
			(gGDacSound number: 903 setLoop: -1 play: setVol: 127)
		)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(34235
				(gEgo normalize: 5 posn: 185 88)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(31100
				(gEgo normalize: 4 posn: 93 113)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
			(else
				(gEgo normalize: 3 posn: 125 126)
				(self setScript: (ScriptID 0 5) 0 10) ; takeLastStep
			)
		)
		(if (not (OneOf gChapter 2 6))
			(Load 140 34010 34011 34012) ; WAVE
			(Lock 140 34010 1) ; WAVE
			(Lock 140 34011 1) ; WAVE
			(Lock 140 34012 1) ; WAVE
			(littleDaryle init:)
		)
		(doorSign init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		(door init: 1)
		(eastExit init: 10)
		(southExit init: 3)
		(if (== gChapter 1)
			(dog init: approachVerbs: 4 setHotspot: 4 3) ; Do, Do, Move
		)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(DoAudio 12 1) ; AudMixCheck
		(Lock 140 34010 0) ; WAVE
		(Lock 140 34011 0) ; WAVE
		(Lock 140 34012 0) ; WAVE
		(super newRoom: newRoomNumber)
	)
)

(instance petDogScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(DoAudio 12 0) ; AudMixCheck
					(dog hide:)
					(DoRobot 1740 91 30)
					(if (not (OneOf gChapter 2 6))
						(daryle init:)
					)
					(peopleMover doit:)
					(gCurRoom drawPic: 34200)
				)
				(1
					(dog show:)
					(gEgo posn: 103 106 normalize: 7)
					(peopleKiller doit:)
					(if (not (OneOf gChapter 2 6))
						(daryle dispose:)
						(littleDaryle init:)
					)
					(gCurRoom drawPic: 34225)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(if (gCast contains: daryle)
						(daryle dispose:)
					)
					(dog show:)
					(gEgo posn: 103 106 normalize: 7)
					(peopleKiller doit:)
					(= global115 0)
					(if (not (OneOf gChapter 2 6))
						(littleDaryle init:)
					)
					(gCurRoom drawPic: 34225)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance lockedDoorScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(if (gCast contains: dog)
						(dog hide:)
					)
					(if (== gChapter 1)
						(bigDoggie init:)
					)
					(peopleMover doit:)
					(if (not (OneOf gChapter 2 6))
						(daryle init:)
					)
					(DoRobot 1720)
					(gCurRoom drawPic: 34200)
				)
				(1
					(if (== gChapter 1)
						(bigDoggie dispose:)
					)
					(peopleKiller doit:)
					(if (not (OneOf gChapter 2 6))
						(daryle dispose:)
						(littleDaryle init:)
					)
					(if (gCast contains: dog)
						(dog show:)
					)
					(gEgo posn: 93 113 normalize: 8 show:)
					(gCurRoom drawPic: 34225)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(if (gCast contains: bigDoggie)
						(bigDoggie dispose:)
					)
					(if (gCast contains: dog)
						(dog show:)
					)
					(if (gCast contains: daryle)
						(daryle dispose:)
					)
					(gEgo posn: 93 113 normalize: 8 show:)
					(peopleKiller doit:)
					(if (not (OneOf gChapter 2 6))
						(littleDaryle init:)
					)
					(gCurRoom drawPic: 34225)
					(= global115 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance lookWindowSign of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo hide:)
					(if (gCast contains: dog)
						(dog hide:)
					)
					(if (== gChapter 1)
						(bigDoggie init:)
					)
					(peopleMover doit:)
					(if (not (OneOf gChapter 2 6))
						(daryle init:)
					)
					(DoRobot 1730 56 3)
					(gCurRoom drawPic: 34200)
				)
				(1
					(if (== gChapter 1)
						(bigDoggie dispose:)
					)
					(peopleKiller doit:)
					(if (OneOf gChapter 1 6)
						(closedSign init:)
					)
					(if (not (OneOf gChapter 2 6))
						(daryle dispose:)
					)
					(gCurRoom drawPic: 34210)
					(= seconds 5)
				)
				(2
					(if (== gChapter 1)
						(bigDoggie init:)
					)
					(if (OneOf gChapter 1 6)
						(closedSign dispose:)
					)
					(if (not (OneOf gChapter 2 6))
						(daryle init:)
					)
					(DoRobot 1731 48 8)
					(gCurRoom drawPic: 34200)
				)
				(3
					(if (== gChapter 1)
						(bigDoggie dispose:)
					)
					(if (not (OneOf gChapter 2 6))
						(daryle dispose:)
						(littleDaryle init:)
					)
					(if (gCast contains: dog)
						(dog show:)
					)
					(gEgo
						posn: 93 113
						normalize: 8
						setScaler: Scaler 109 40 135 94
						show:
					)
					(gCurRoom drawPic: (gCurRoom picture:))
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(if (gCast contains: bigDoggie)
						(bigDoggie dispose:)
					)
					(= global115 0)
					(if (not (OneOf gChapter 2 6))
						(littleDaryle init:)
					)
					(gCurRoom drawPic: (gCurRoom picture:))
					(gEgo
						posn: 93 113
						normalize: 8
						setScaler: Scaler 109 40 135 94
						show:
					)
					(if (gCast contains: daryle)
						(daryle dispose:)
					)
					(if (gCast contains: dog)
						(dog show:)
					)
					(peopleKiller doit:)
					(if (gCast contains: closedSign)
						(closedSign dispose:)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance enterStore of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gEgo hide:)
					(if (not (OneOf gChapter 2 6))
						(littleDaryle hide:)
						(daryle init:)
					)
					(peopleMover doit:)
					(DoRobot 1721 -8 -40 gEgo -1 1)
					(gCurRoom drawPic: 34200)
				)
				(1
					(gCurRoom newRoom: 31100)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gCurRoom newRoom: 31100)
				)
			)
		)
	)
)

(instance dog of View
	(properties
		approachX 87
		approachY 75
		x 87
		y 106
		view 34226
		loop 1
	)

	(method (init)
		(super init:)
		(self setPri: 1)
	)

	(method (handleEvent event)
		(cond
			((== (gEgo x:) 185)
				(= approachX 160)
				(= approachY 128)
			)
			((and (== (gEgo heading:) 315) (== (gEgo x:) 93))
				(= global163 self)
			)
			(else
				(= approachX 20)
				(= approachY 73)
			)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gGame handsOff:)
				(gCurRoom setScript: petDogScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bigDoggie of View
	(properties
		x 177
		y 117
		view 34203
	)
)

(instance closedSign of View
	(properties
		x 125
		y 93
		view 34210
	)
)

(instance doorSign of Feature
	(properties
		approachX 85
		approachY 105
		x 38
		y 82
	)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 0 60 43 61 43 93 -1 101 yourself:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: lookWindowSign)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance door of ExitFeature
	(properties
		nsLeft 50
		nsTop 55
		nsRight 73
		nsBottom 97
		sightAngle 1
		approachX 20
		approachY 73
		x 120
		y 117
	)

	(method (handleEvent event)
		(if (== (gEgo x:) 185)
			(= approachX 160)
			(= approachY 128)
		else
			(= approachX 20)
			(= approachY 73)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21 ; Exit
				(if (OneOf gChapter 1 6)
					(gCurRoom setScript: lockedDoorScr)
				else
					(gCurRoom setScript: enterStore)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance eastExit of ExitFeature
	(properties
		nsLeft 242
		nsTop 61
		nsRight 295
		nsBottom 83
		approachX 300
		approachY 20
		x 320
		y 30
		nextRoom 34235
	)
)

(instance southExit of ExitFeature
	(properties
		x 150
		y 200
		nextRoom 34100
		appYOffset 20
	)

	(method (handleEvent event)
		(if (and (== (gEgo y:) 113) (== (gEgo x:) 93) (self onMe: event))
			(= approachX 120)
			(= approachY 200)
		else
			(= approachX 150)
			(= approachY 200)
		)
		(super handleEvent: event)
	)
)

(instance daryle of Prop
	(properties
		x 218
		y 99
		view 34201
	)

	(method (init)
		(DoAudio 12 0) ; AudMixCheck
		(littleDaryle dispose:)
		(super init:)
		(self setCycle: Fwd cycleSpeed: 9)
	)

	(method (doit &tmp temp0)
		(if
			(and
				(OneOf cel 3 10 16 22 28 38 53 59 68)
				(not (daryleSound handle:))
			)
			(switch (Random 0 3)
				(0
					(= temp0 34010)
				)
				(1
					(= temp0 34011)
				)
				(else
					(= temp0 34012)
				)
			)
			(daryleSound number: temp0 play:)
		)
		(super doit:)
	)
)

(instance littleDaryle of Prop
	(properties
		x 102
		y 95
		view 34225
	)

	(method (init)
		(DoAudio 12 0) ; AudMixCheck
		(super init:)
		(self setCycle: Fwd cycleSpeed: 9)
	)

	(method (doit &tmp temp0)
		(if
			(and
				(OneOf cel 3 10 16 22 28 38 53 59 68)
				(not (daryleSound handle:))
			)
			(switch (Random 0 3)
				(0
					(= temp0 34010)
				)
				(1
					(= temp0 34011)
				)
				(else
					(= temp0 34012)
				)
			)
			(daryleSound number: temp0 play:)
		)
		(super doit:)
	)
)

(instance daryleSound of Sound
	(properties)
)

(instance dave of Prop
	(properties
		x 139
		y 135
		view 34205
	)

	(method (init)
		(super init:)
		(self setCycle: End self cycleSpeed: 9)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance desi of Prop
	(properties
		x 138
		y 30
		view 34208
	)

	(method (init)
		(super init:)
		(self setCel: 0 setCycle: End self cycleSpeed: 8)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance robin of Prop
	(properties
		x 143
		y 104
		view 34207
	)

	(method (init)
		(super init:)
		(self setCel: 0 setCycle: End self cycleSpeed: 8)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance mrsPhanco of Prop
	(properties
		x 140
		y 27
		view 34209
	)

	(method (init)
		(super init:)
		(self setCel: 0 setCycle: End self cycleSpeed: 8)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance peopleMover of Code
	(properties)

	(method (doit)
		(switch (Random 0 7)
			(1
				(if (not (IsFlag 386))
					(desi init: setPri: 200 1)
					(SetFlag 386)
				)
			)
			(2
				(if (not (IsFlag 388))
					(mrsPhanco init: setPri: 200 1)
					(SetFlag 388)
				)
			)
			(3
				(if (not (IsFlag 389))
					(dave init: setPri: 200 1)
					(SetFlag 389)
				)
			)
			(4
				(if (not (IsFlag 387))
					(robin init: setPri: 200 1)
					(SetFlag 387)
				)
			)
		)
	)
)

(instance peopleKiller of Code
	(properties)

	(method (doit)
		(if (gCast contains: desi)
			(desi setCycle: 0 cel: 0 dispose:)
		)
		(if (gCast contains: dave)
			(dave setCycle: 0 cel: 0 dispose:)
		)
		(if (gCast contains: robin)
			(robin setCycle: 0 cel: 0 dispose:)
		)
		(if (gCast contains: mrsPhanco)
			(mrsPhanco setCycle: 0 dispose:)
		)
	)
)

