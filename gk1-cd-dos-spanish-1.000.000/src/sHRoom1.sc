;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 801)
(include sci.sh)
(use Main)
(use n013)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	sHRoom1 0
)

(instance sHRoom1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 800 0) ; Hounfour
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 257 137 209 116 75 116 38 137
							yourself:
						)
				)
				((ScriptID 800 2) doit: 880) ; xDrawThePic
				(gGkMusic1
					number: 226
					setLoop: -1
					stop:
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 5 10 0
				)
				(gold1 init:)
				(gold2 init:)
				(gold3 init:)
				(cash1 init:)
				(cash2 init:)
				(moneyBags init:)
				(keypad init:)
				(door1 init: setCel: 5)
				(self setScript: sEnter)
				(gEgo
					normalize: 1
					posn: 230 126
					init:
					setMotion: MoveTo 215 126 script
				)
			)
			(1
				(gGkMusic1 fade:)
				(self dispose:)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(gGkSound1 number: 812 play:)
				(door1 setCycle: Beg self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitToHounfour of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 219 126 self)
			)
			(1
				(gEgo view: 801 setCel: 0 setLoop: 0 setCycle: CT 3 1 self)
			)
			(2
				(gEgo setCel: 4 setCycle: End self)
				(gGkSound1 setLoop: 1 number: 802 play:)
			)
			(3
				(door1 setCycle: End self)
				(gGkSound1 setLoop: 1 number: 811 play:)
			)
			(4
				(gEgo normalize: 0 setMotion: PolyPath 235 128 self)
			)
			(5
				(if (not (Random 0 2))
					(gEgo
						view: 802
						setSpeed: 12
						setLoop: 1
						setCel: 0
						setCycle: End self
					)
				else
					(= cycles 1)
				)
			)
			(6
				(gGame handsOn:)
				(client cue:)
			)
		)
	)
)

(instance sGrabMoney of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 135 118 self)
			)
			(1
				(if (not (IsFlag 286))
					(gMessager say: 3 12 1 0 0 801) ; "(TO HIMSELF)I know it's dirty money, but it's for a good cause. Me."
				)
				(cond
					((not (IsFlag 286))
						(SetFlag 286)
						(gEgo get: 62 getPoints: 187 1) ; lotsCash
					)
					((and (IsFlag 286) (not (IsFlag 287)))
						(SetFlag 287)
					)
					(else
						(SetFlag 288)
					)
				)
				(gGkSound1 setLoop: 1 number: 881 play:)
				(gEgo
					view: 880
					setSpeed: 12
					setLoop: 0
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(gEgo normalize: 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance door1 of Prop
	(properties
		noun 4
		modNum 800
		x 249
		y 126
		priority 1
		fixPriority 1
		view 880
		loop 1
		signal 16417
	)
)

(instance gold1 of Feature
	(properties
		noun 1
		modNum 801
		nsLeft 70
		nsTop 52
		nsRight 109
		nsBottom 69
		sightAngle 40
		approachX 89
		approachY 60
		x 89
		y 117
		z 57
	)
)

(instance gold2 of Feature
	(properties
		noun 3
		modNum 801
		nsLeft 181
		nsTop 55
		nsRight 218
		nsBottom 70
		sightAngle 40
		approachX 199
		approachY 62
		x 199
		y 116
		z 54
	)
)

(instance moneyBags of Feature
	(properties
		noun 2
		modNum 801
		nsLeft 128
		nsTop 52
		nsRight 162
		nsBottom 67
		sightAngle 40
		approachX 145
		approachY 59
		x 145
		y 115
		z 56
	)
)

(instance cash1 of Feature
	(properties
		noun 3
		modNum 801
		nsLeft 75
		nsTop 72
		nsRight 218
		nsBottom 115
		sightAngle 40
		approachX 146
		approachY 93
		x 146
		y 93
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(if (not (IsFlag 288))
					(sHRoom1 setScript: sGrabMoney)
				else
					(gMessager say: noun theVerb 4 0 0 801) ; "(TO HIMSELF. TALKING ABOUT MONEY)I hate to say it, but I can't carry any more."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cash2 of Feature
	(properties
		noun 3
		modNum 801
		nsTop 45
		nsRight 7
		nsBottom 63
		sightAngle 20
		approachX 248
		approachY 124
		x 160
		y 179
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 47 149 52 133 49 117 85 103 106 105 104 120 109 120 111 133 136 133 137 138 178 131 186 136 186 122 216 125 238 123 240 111 250 117 249 107 280 107 280 141
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; Pickup
				(if (not (IsFlag 288))
					(sHRoom1 setScript: sGrabMoney)
				else
					(gMessager say: noun theVerb 4 0 0 801) ; "(TO HIMSELF. TALKING ABOUT MONEY)I hate to say it, but I can't carry any more."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gold3 of Feature
	(properties
		noun 1
		modNum 801
		nsTop 45
		nsRight 7
		nsBottom 63
		sightAngle 20
		approachX 248
		approachY 124
		x 160
		y 179
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 40 137 40 31 57 31 60 67 76 72 80 105 49 117 51 135 46 137 41 137
					yourself:
				)
		)
		(super init:)
	)
)

(instance keypad of Feature
	(properties
		noun 20
		modNum 800
		nsLeft 228
		nsTop 80
		nsRight 237
		nsBottom 92
		sightAngle 40
		approachX 232
		approachY 86
		x 232
		y 127
		z 38
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(sHRoom1 setScript: sExitToHounfour)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

