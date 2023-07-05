;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 804)
(include sci.sh)
(use Main)
(use n013)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	sHRoom4 0
)

(instance sHRoom4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 800 0) ; Hounfour
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 98 131 97 137 164 137 164 132 237 132 237 127 156 127 154 116 213 116 214 112 75 112 74 112 74 114 141 114 128 129 56 129 45 131
							yourself:
						)
				)
				(gGkMusic1
					number: 710
					setLoop: -1
					stop:
					play:
					setVol: 0
					fade: 85 5 10 0
				)
				((ScriptID 800 2) doit: 820) ; xDrawThePic
				(whiteBoard init:)
				(keypad init:)
				(chair1 init:)
				(chair2 init:)
				(chair3 init:)
				(chair4 init:)
				(computer1 init:)
				(computer2 init:)
				(computer3 init:)
				(computer4 init:)
				(desk1 init: approachVerbs: 6) ; Open
				(desk2 init: approachVerbs: 6) ; Open
				(desk3 init: approachVerbs: 6) ; Open
				(desk4 init: approachVerbs: 6) ; Open
				(portrait init:)
				(if (gEgo has: 54) ; records
					(inBox1 init: approachVerbs: 7) ; Look
				else
					(book init: approachVerbs: 7) ; Look
				)
				(inBox2 init: approachVerbs: 7) ; Look
				(inBox3 init: approachVerbs: 7) ; Look
				(inBox4 init: approachVerbs: 7) ; Look
				(door1 init: setCel: 5)
				(self setScript: sEnter)
				(gEgo
					normalize: 1
					setScaler: Scaler 100 82 124 112
					posn: 230 127
					init:
					setMotion: MoveTo 215 127 script
				)
			)
			(1
				(gGkMusic1 fade:)
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
				(gEgo setMotion: PolyPath 219 127 self)
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
				(gEgo normalize: 0 setMotion: PolyPath 232 127 self)
			)
			(5
				(if (Random 0 2)
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

(instance sGetBook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 171 116 self)
			)
			(1
				(Face gEgo 171 125 self)
			)
			(2
				(gEgo
					setSpeed: 12
					view: 820
					setCel: 0
					setLoop: 1
					setCycle: CT 3 1
				)
				(gMessager say: 6 12 5 0 self 804) ; "This record book might be the kind of thing Mosely wanted for the FBI."
				(gEgo get: 54) ; records
			)
			(3
				(book dispose:)
				(inBox1 init: approachVerbs: 7) ; Look
				(gEgo setCycle: End self)
			)
			(4
				(gEgo getPoints: -999 2)
				(gEgo normalize: 2)
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
		x 246
		y 129
		priority 1
		fixPriority 1
		view 820
		loop 2
		signal 16417
	)
)

(instance book of View
	(properties
		noun 6
		modNum 804
		approachX 171
		approachY 116
		x 172
		y 121
		z 21
		priority 127
		fixPriority 1
		view 820
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gMessager say: noun theVerb 5 0 0 804) ; "Gabriel looks at the in box and sees a black record book."
				(return 1)
			)
			(12 ; Pickup
				(sHRoom4 setScript: sGetBook)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance keypad of Feature
	(properties
		noun 20
		modNum 800
		nsLeft 225
		nsTop 80
		nsRight 240
		nsBottom 100
		sightAngle 40
		approachX 232
		approachY 86
		x 232
		y 130
		z 38
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(sHRoom4 setScript: sExitToHounfour)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance whiteBoard of Feature
	(properties
		noun 7
		modNum 804
		nsLeft 104
		nsTop 63
		nsRight 191
		nsBottom 93
		sightAngle 40
		approachX 147
		approachY 78
		x 147
		y 110
		z 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gMessager say: noun theVerb 7 0 0 804) ; "The white board contains what looks like calculus equations."
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance chair1 of Feature
	(properties
		noun 2
		modNum 804
		nsLeft 39
		nsTop 123
		nsRight 48
		nsBottom 138
		sightAngle 40
		approachX 43
		approachY 130
		x 43
		y 141
	)
)

(instance chair2 of Feature
	(properties
		noun 2
		modNum 804
		nsLeft 80
		nsTop 102
		nsRight 92
		nsBottom 112
		sightAngle 40
		approachX 86
		approachY 107
		x 86
		y 131
		z 20
	)
)

(instance chair3 of Feature
	(properties
		noun 2
		modNum 804
		nsLeft 182
		nsTop 96
		nsRight 196
		nsBottom 99
		sightAngle 40
		approachX 189
		approachY 97
		x 189
		y 120
		z 23
	)
)

(instance chair4 of Feature
	(properties
		noun 2
		modNum 804
		nsLeft 211
		nsTop 127
		nsRight 238
		nsBottom 138
		sightAngle 40
		approachX 224
		approachY 132
		x 224
		y 142
	)
)

(instance computer1 of Feature
	(properties
		noun 4
		modNum 804
		nsLeft 39
		nsTop 101
		nsRight 53
		nsBottom 122
		sightAngle 40
		approachX 46
		approachY 111
		x 46
		y 141
		z 25
	)
)

(instance computer2 of Feature
	(properties
		noun 4
		modNum 804
		nsLeft 67
		nsTop 87
		nsRight 87
		nsBottom 101
		sightAngle 40
		approachX 77
		approachY 94
		x 77
		y 128
		z 34
	)
)

(instance computer3 of Feature
	(properties
		noun 4
		modNum 804
		nsLeft 202
		nsTop 88
		nsRight 225
		nsBottom 105
		sightAngle 40
		approachX 213
		approachY 96
		x 213
		y 125
		z 29
	)
)

(instance computer4 of Feature
	(properties
		noun 4
		modNum 804
		nsLeft 240
		nsTop 106
		nsRight 264
		nsBottom 128
		sightAngle 40
		approachX 252
		approachY 117
		x 252
		y 141
		z 21
	)
)

(instance desk1 of Feature
	(properties
		noun 1
		modNum 804
		sightAngle 20
		approachX 87
		approachY 131
		x 60
		y 140
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 39 114 98 114 97 137 38 137
					yourself:
				)
		)
		(super init:)
	)
)

(instance desk2 of Feature
	(properties
		noun 1
		modNum 804
		sightAngle 20
		approachX 134
		approachY 123
		x 60
		y 110
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 72 97 126 97 126 118 117 124 59 124 59 102
					yourself:
				)
		)
		(super init:)
	)
)

(instance desk3 of Feature
	(properties
		noun 1
		modNum 804
		sightAngle 20
		approachX 155
		approachY 123
		x 190
		y 110
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 222 99 225 104 225 123 165 123 163 120 163 99
					yourself:
				)
		)
		(super init:)
	)
)

(instance desk4 of Feature
	(properties
		noun 1
		modNum 804
		sightAngle 20
		approachX 183
		approachY 132
		x 190
		y 140
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 171 124 265 124 279 129 279 138 171 138
					yourself:
				)
		)
		(super init:)
	)
)

(instance portrait of Feature
	(properties
		noun 5
		modNum 804
		sightAngle 20
		approachY 124
		x 60
		y 130
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 67 62 67 96 45 101 44 59
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gMessager say: noun theVerb 7 0 0 804) ; "A portrait of a beautiful, intelligent-looking woman is on the wall."
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inBox1 of Feature
	(properties
		noun 6
		modNum 804
		nsLeft 166
		nsTop 98
		nsRight 180
		nsBottom 102
		sightAngle 40
		approachX 155
		approachY 123
		x 173
		y 122
		z 22
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gMessager say: noun theVerb 6 0 0 804) ; "There's nothing else of interest in that in box."
				(return 1)
			)
			(12 ; Pickup
				(gMessager say: noun theVerb 6 0 0 804) ; "There's nothing else worth taking in that in box."
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inBox2 of Feature
	(properties
		noun 6
		modNum 804
		nsLeft 113
		nsTop 94
		nsRight 122
		nsBottom 100
		sightAngle 40
		approachX 134
		approachY 123
		x 117
		y 121
		z 24
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gMessager say: noun theVerb 4 0 0 804) ; "Gabriel looks at the papers in the in box, but sees nothing of interest."
				(return 1)
			)
			(12 ; Pickup
				(gMessager say: noun theVerb 4 0 0 804) ; "There's nothing worth taking in that in box."
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inBox3 of Feature
	(properties
		noun 6
		modNum 804
		nsLeft 76
		nsTop 111
		nsRight 91
		nsBottom 118
		sightAngle 40
		approachX 87
		approachY 131
		x 83
		y 146
		z 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gMessager say: noun theVerb 4 0 0 804) ; "Gabriel looks at the papers in the in box, but sees nothing of interest."
				(return 1)
			)
			(12 ; Pickup
				(gMessager say: noun theVerb 4 0 0 804) ; "There's nothing worth taking in that in box."
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inBox4 of Feature
	(properties
		noun 6
		modNum 804
		nsLeft 175
		nsTop 118
		nsRight 201
		nsBottom 127
		sightAngle 40
		approachX 183
		approachY 132
		x 188
		y 161
		z 39
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gMessager say: noun theVerb 4 0 0 804) ; "Gabriel looks at the papers in the in box, but sees nothing of interest."
				(return 1)
			)
			(12 ; Pickup
				(gMessager say: noun theVerb 4 0 0 804) ; "There's nothing worth taking in that in box."
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

