;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28860)
(include sci.sh)
(use Main)
(use movieScr)
(use scaryInvInit)
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
	rm28860 0
)

(local
	local0
	local1
)

(instance rm28860 of ScaryRoom
	(properties
		picture 28860
		stepSound 1
	)

	(method (newRoom)
		(if (== gChapter 5)
			(Palette 2 55 135 100) ; PalIntensity
		)
		(super newRoom: &rest)
	)

	(method (init &tmp temp0 temp1 temp2)
		((ScriptID 30) init:) ; FidgetCode
		(= temp2 0)
		(if (== gChapter 5)
			(Palette 2 55 135 70) ; PalIntensity
			(= picture 28861)
			(gEgo fadePalette: 28100)
		)
		(gEgo
			init:
			fadedY: 90
			brightY: 120
			setScaler: Scaler 107 36 130 76
			normalize:
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
					posn: 174 76
					init:
					approachVerbs: 4 ; Do
					setHotspot: 4 3 ; Do, Move
					ignoreActors: 1
					setSpeed: 6
					cel: global225
					setCycle: Fwd
				)
			)
			(else
				(if (and (== gPrevRoomNum 28305) (IsFlag 334))
					(ClearFlag 334)
				)
				(if (not (IsFlag 334))
					(Load 140 28040) ; WAVE
					(Lock 140 28040 1) ; WAVE
					(Load 140 28041) ; WAVE
					(Lock 140 28041 1) ; WAVE
					(Load 140 28042) ; WAVE
					(Lock 140 28042 1) ; WAVE
					(cyrus
						init:
						approachVerbs: 4 ; Do
						setHotspot: 4 3 ; Do, Move
						ignoreActors: 1
						setSpeed: 6
						cel: global225
						setCycle: Fwd
					)
				)
			)
		)
		(switch gPrevRoomNum
			(900
				(if (IsFlag 226)
					(ClearFlag 226)
					(gEgo normalize: 2 posn: 75 93)
					(= picture -1)
					(= temp2 startChapter3)
				else
					(if (not (gEgo x:))
						(gEgo normalize: 2 posn: 75 93)
					)
					(gGame handsOn:)
				)
				(proc28_2)
			)
			(44 ; chapEndRm
				(gGame fadeSpeed: 4)
				(proc28_2)
				(ClearFlag 226)
				(ClearFlag 11)
				(gEgo normalize: 2 posn: 75 93)
				(= picture -1)
				(= temp2 startChapter3)
			)
			(28305
				(gEgo normalize: 6 posn: 50 125)
				(= temp2 (ScriptID 0 5)) ; takeLastStep
			)
			(28863
				(gEgo normalize: 0 posn: 54 79 show:)
				(= temp2 (ScriptID 0 5)) ; takeLastStep
			)
			(else
				(gEgo normalize: 2 posn: 103 85)
				(= temp2 (ScriptID 0 5)) ; takeLastStep
			)
		)
		(if (!= temp2 startChapter3)
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
		)
		(if (and (== gChapter 3) (not (IsFlag 65)) (not (IsFlag 384)))
			(gEgo setScaler: Scaler 100 30 130 76)
			(if (> picture 0)
				(= picture 28863)
			)
			(shadow init: approachVerbs: 4 3 setHotspot: 4 3) ; Do, Move, Do, Move
		)
		(super init: &rest)
		(if temp2
			(self setScript: temp2)
		)
		(gGame fadeSpeed: 100)
		(northExit init: 1)
		(westExit init: 4)
		(southExit init: 12)
	)

	(method (dispose)
		(Lock 140 28040 0) ; WAVE
		(Lock 140 28041 0) ; WAVE
		(Lock 140 28042 0) ; WAVE
		(super dispose: &rest)
	)
)

(instance startChapter3 of Script
	(properties)

	(method (changeState newState)
		(if global115
			(switch (= state newState)
				(0
					(proc1111_6)
					(gGame handsOn:)
					(gCurRoom drawPic: 28863)
					(ClearFlag 125)
					(SetFlag 55)
					(= global115 0)
					(gEgo show:)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(SetFlag 121)
					(gEgo hide:)
					(gGame handsOff:)
					(= gChapter 3)
					(SetFlag 418)
					(if (< gVideoSpeed 425)
						(PlayVMD 0 {30705.vmd}) ; Open
						(proc26_0 30705 self)
					else
						(PlayVMD 0 {3070.vmd}) ; Open
						(proc26_0 3070 self)
					)
				)
				(1
					(= cycles 1)
				)
				(2
					(ClearFlag 418)
					(PlayVMD 0 {3071.vmd}) ; Open
					(proc26_0 3071 self)
				)
				(3
					(gEgo show:)
					(gGame handsOn:)
					(gCurRoom drawPic: 28863)
					(ClearFlag 125)
					(SetFlag 55)
					(self dispose:)
				)
			)
		)
	)

	(method (dispose)
		(ClearFlag 121)
		(gCurRoom picture: 28863)
		(gGDacSound number: 906 setLoop: -1 play:)
		(super dispose: &rest)
	)
)

(instance meetCyrus of Script
	(properties)

	(method (changeState newState)
		(if global115
			(proc1111_6)
			(if register
				(register dispose:)
			)
			(= register 0)
			(gEgo show: posn: 150 120 normalize: 6)
			(gateExit init: 13)
			(westExit dispose:)
			(northExit dispose:)
			(southExit init: 3 nextRoom: 28815)
			(= gPrevRoomNum 28863)
			(gCurRoom drawPic: 27910)
			(shadow dispose:)
			(= global115 0)
			(gGame handsOn:)
			(self dispose:)
		else
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(SetFlag 65)
					(SetFlag 231)
					(shadow dispose:)
					(proc1111_7 3190 -3 13)
					(gCurRoom drawPic: 27910)
				)
				(1
					(proc1111_7 3191 -29 -43 gEgo 110)
					(gCurRoom drawPic: 28863)
				)
				(2
					(gEgo show: posn: 150 120 normalize: 6)
					(gateExit init: 13)
					(northExit dispose:)
					(westExit dispose:)
					(southExit init: 3 nextRoom: 28815)
					(= gPrevRoomNum 28863)
					(gCurRoom drawPic: 27910)
					((= register (Prop new:))
						view: 3192
						loop: 0
						cel: 0
						posn: 262 90
						init:
						cycleSpeed: 7
						setCycle: End self
					)
				)
				(3
					(register dispose:)
					(= register 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance stump of View
	(properties
		x 144
		y 75
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
		x 144
		y 75
		view 4370
	)

	(method (dispose)
		(= global225 cel)
		(super dispose:)
	)

	(method (init)
		(super init: &rest)
		(|= signal $1000)
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

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= global125 1)
			(gCurRoom newRoom: 28815)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance gateExit of ExitFeature
	(properties
		modNum 0
		nsLeft 239
		nsTop 25
		nsRight 275
		nsBottom 90
		sightAngle 40
		approachX 259
		approachY 89
		x 257
		y 57
		nextRoom 28305
	)
)

(instance shadow of Feature
	(properties
		approachX 100
		approachY 150
		x 230
		y 80
	)

	(method (init)
		(super init: &rest)
		(self
			approachVerbs: 4 ; Do
			setHotspot: 4 3 ; Do, Move
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 142 0 155 7 170 13 193 31 223 37 234 52 223 132 298 132 295 0 226 0 233 22 217 21 200 15 188 0 169 0 170 4 152 0
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: meetCyrus)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance northExit of ExitFeature
	(properties
		nsLeft 82
		nsTop 30
		nsRight 180
		nsBottom 80
		nextRoom 28815
	)
)

(instance southExit of ExitFeature
	(properties
		nsLeft 1
		nsTop 110
		nsRight 300
		nsBottom 129
		approachX 15
		approachY 140
		nextRoom 28305
	)

	(method (handleEvent)
		(if (== gPrevRoomNum 28863)
			(= approachX (gEgo x:))
		)
		(super handleEvent: &rest)
	)
)

(instance westExit of ExitFeature
	(properties
		nsLeft 1
		nsTop 30
		nsRight 15
		nsBottom 90
		approachX -10
		approachY 100
		nextRoom 28863
	)
)

