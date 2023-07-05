;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 241)
(include sci.sh)
(use Main)
(use n013)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	bookshelf 0
	microwave 1
	fridge 2
	bullBoard 3
	desk 4
	leftFileCab 5
	rightFileCab 6
	trumPost 7
	phone 8
	leftBinder 9
	rightBinder 10
	falconPoster 11
	speaker 12
	deskLamp 13
	leftPlant 14
	rightPlant 15
	winder 16
	suit 17
	mosChair 18
	coffeeCup 19
	getTracker 20
	crash 21
	copper 22
	sitGabDown 23
	frankyInWindow 24
	franky 26
	frankyTalker 27
	interroMosely 28
	geezItsHot 29
	gabsChair 30
	myDVC 31
)

(instance bookshelf of Feature
	(properties
		noun 4
		sightAngle 20
		x 165
		y 96
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 150 22 204 27 206 35 202 37 202 48 206 52 206 66 198 75 179 80 162 80 156 94 145 92
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance microwave of Feature
	(properties
		noun 13
		nsLeft 274
		nsTop 72
		nsRight 305
		nsBottom 91
		sightAngle 20
		x 280
		y 120
	)
)

(instance fridge of Feature
	(properties
		noun 14
		sightAngle 20
		x 280
		y 120
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 267 94 272 91 298 95 276 119 268 119
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance bullBoard of Feature
	(properties
		noun 5
		nsLeft 231
		nsTop 44
		nsRight 279
		nsBottom 74
		sightAngle 20
		x 250
		y 106
	)
)

(instance desk of Feature
	(properties
		noun 7
		sightAngle 20
		x 200
		y 110
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 186 101 161 95 160 84 166 80 179 82 180 87 205 75 239 81 244 99 235 106 222 105 221 93 203 99 205 105 201 105 204 115 186 122
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance leftFileCab of Feature
	(properties
		noun 10
		sightAngle 20
		x 69
		y 106
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 22 98 14 98 15 88 76 71 95 74 96 98 64 108
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance leftPlant of Feature
	(properties
		noun 25
		sightAngle 20
		x 5
		y 189
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 1 66 13 53 8 48 0 47 2 32 13 32 22 30 33 21 49 21 56 37 37 23 26 30 30 34 35 33 53 44 52 50 39 39 25 51 45 55 58 66 46 61 46 65 23 54 12 58 22 60 30 69 37 85 16 66 10 71 17 76 19 86 14 89 13 102 0 104
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightPlant of Feature
	(properties
		noun 25
		sightAngle 20
		x 306
		y 115
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 318 142 276 125 276 120 280 115 280 109 270 111 275 106 286 106 290 104 284 102 294 101 300 101 315 95 308 90 319 88
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance winder of Feature
	(properties
		noun 32
		sightAngle 20
		x 60
		y 80
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 33 39 80 30 80 65 32 77 yourself:)
		)
		(super init: &rest)
	)
)

(instance leftBinder of Feature
	(properties
		noun 2
		sightAngle 20
		x 55
		y 123
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 144 0 104 19 99 77 110 67 115 72 125 78 125 79 129 38 143
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance rightBinder of Feature
	(properties
		noun 2
		sightAngle 20
		x 260
		y 123
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 237 132 242 134 242 130 265 123 313 144 213 143
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance deskLamp of Feature
	(properties
		noun 8
		sightAngle 20
		x 191
		y 80
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 185 82 180 71 197 75 200 74 206 77 192 81 190 79 192 77 184 74 189 83 194 84 186 87 182 86
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance falconPoster of Feature
	(properties
		noun 9
		nsLeft 285
		nsTop 40
		nsRight 317
		nsBottom 83
		sightAngle 20
		x 296
		y 114
	)
)

(instance speaker of Feature
	(properties
		noun 12
		nsLeft 207
		nsTop 34
		nsRight 220
		nsBottom 48
		sightAngle 20
		x 210
		y 100
	)
)

(instance rightFileCab of Feature
	(properties
		noun 10
		sightAngle 20
		x 166
		y 114
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 149 104 160 97 185 101 186 123 167 131 147 128
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance trumPost of Feature
	(properties
		noun 29
		nsLeft 132
		nsTop 30
		nsRight 146
		nsBottom 53
		sightAngle 20
		x 140
		y 40
	)
)

(instance phone of Feature
	(properties
		noun 24
		nsLeft 226
		nsTop 77
		nsRight 236
		nsBottom 83
		sightAngle 30
		x 231
		y 111
	)
)

(instance suit of Feature
	(properties
		noun 28
		nsLeft 92
		nsTop 47
		nsRight 109
		nsBottom 67
		sightAngle 30
		x 102
		y 81
	)
)

(instance mosChair of View
	(properties
		noun 15
		x 229
		y 117
		view 2400
	)
)

(instance coffeeCup of View
	(properties
		noun 34
		sightAngle 20
		x 154
		y 139
		z 40
		view 2400
		cel 3
	)

	(method (init)
		(super init: &rest)
		(self setPri: 123)
	)
)

(instance getTracker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gCurRoom notify:)
					(self setScript: (ScriptID 240 3) self) ; standGabUp
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: PolyPath 220 126 self)
			)
			(2
				(gEgo
					view: 246
					setLoop: 2
					cel: 0
					setSpeed: 14
					setCycle: End self
				)
			)
			(3
				(gEgo get: 18 19 20 getPoints: -999 1 normalize: 1 900) ; tracker
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance crash of Actor
	(properties
		x 129
		y 123
		view 2441
		signal 16417
	)
)

(instance copper of Actor
	(properties
		view 237
		signal 16417
		xStep 4
	)

	(method (init)
		(if (and (== gDay 3) (not (IsFlag 21)))
			(self view: 244 loop: 3 posn: 68 110 cel: 0)
		)
		(super init: &rest)
	)
)

(instance sitGabDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurRoom notify: 1)
				(if (not register)
					(= register (gGame isHandsOn:))
				)
				(gGame handsOff:)
				(gEgo
					moveSpeed: 1
					cycleSpeed: 1
					setMotion: PolyPath 133 124 self
				)
			)
			(1
				(gEgo view: 2401 setLoop: 0 1 cel: 2 setCycle: End self)
			)
			(2
				(if register
					(gGame handsOn:)
					(if (!= register 1)
						(gMessager say: 17 11 register 0)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance frankyInWindow of Actor
	(properties
		noun 11
		x 23
		y 48
		priority 8
		fixPriority 1
		view 2361
		signal 24609
		cycleSpeed 8
	)

	(method (init)
		(super init: &rest)
		(self setScript: frankyAtFiles)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gCurRoom setScript: lookAtFranky)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance frankyAtFiles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 15 30))
			)
			(1
				(SetFlag 245)
				(frankyInWindow
					show:
					setCel: 0
					setLoop: 4
					setCycle: Walk
					setMotion: MoveTo 60 90 self
				)
			)
			(2
				(frankyInWindow
					view: 248
					setCel: 0
					setLoop: 0
					setCycle: End self
				)
			)
			(3
				(frankyInWindow setCel: 0 setLoop: 1 setCycle: Osc 1 self)
			)
			(4
				(frankyInWindow setCel: 0 setLoop: 2 setCycle: End self)
			)
			(5
				(= seconds 3)
			)
			(6
				(frankyInWindow setCycle: Beg self)
			)
			(7
				(frankyInWindow setCel: 0 setLoop: 3 setCycle: End self)
			)
			(8
				(frankyInWindow loop: 4 cel: 0 setCycle: End self)
			)
			(9
				(frankyInWindow
					view: 2361
					setCel: 0
					setLoop: 7
					posn: 52 90
					setCycle: Walk
					setMotion: MoveTo 23 48 self
				)
			)
			(10
				(ClearFlag 245)
				(self init:)
			)
		)
	)
)

(instance franky of Actor
	(properties
		noun 23
		signal 24609
	)

	(method (init)
		(if (IsFlag 34)
			(self view: 242 setCel: 0 setLoop: 5 posn: 169 152)
		else
			(self view: 2362 setCel: 0 setLoop: 2 posn: 70 60)
		)
		(super init: &rest)
	)
)

(instance frankyTalker of Prop
	(properties
		view 2422
	)

	(method (init)
		(self posn: (franky x:) (franky y:))
		(super init: &rest)
	)
)

(instance lookAtFranky of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (gCurRoom notify: 1))
					(self setScript: sitGabDown self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo
					view: 2403
					setCel: 0
					setLoop: 0 1
					setSpeed: 14
					setCycle: End self
				)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(if
					(==
						(= temp0
							(if (IsFlag 463)
								13
							else
								(SetFlag 463 1)
								12
							)
						)
						12
					)
					(gEgo setLoop: 1 1 setCel: 0 setCycle: End)
				else
					(+= state 1)
				)
				(gMessager say: 11 7 temp0 0 self)
			)
			(4
				(gEgo setCel: 3 setCycle: Beg self)
			)
			(5
				(gEgo view: 2401 setLoop: 0 1 cel: 7 setCycle: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance interroMosely of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (gCurRoom notify: 1))
					(self setScript: sitGabDown self)
				else
					(= cycles 1)
				)
			)
			(1
				(gMessager say: 17 10 19 0 self) ; "Can I ask you about some stuff?"
			)
			(2
				(= global178 8)
				(gCurRoom newRoom: 50) ; interrogation
				(self dispose:)
			)
		)
	)
)

(instance geezItsHot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register
					(if (< global179 62)
						(= global179 70)
						96
					else
						73
					)
				)
				(= seconds 3)
			)
			(1
				(gMessager say: 27 0 register 1)
				(= seconds 5)
			)
			(2
				(gMessager say: 27 0 register 2)
				(= seconds 6)
			)
			(3
				(gMessager say: 27 0 register 3 self)
			)
			(4
				(if (== register 96)
					(gGame handsOn:)
					(self dispose:)
				else
					((ScriptID 240 1) ; mosely
						view: 247
						loop: 0
						cel: 0
						setCycle: End self
					)
				)
			)
			(5
				((ScriptID 240 1) setLoop: 1 cel: 0 setCycle: End self) ; mosely
			)
			(6
				((ScriptID 240 1) setLoop: 2 cel: 0 setCycle: End self) ; mosely
			)
			(7
				((ScriptID 240 2) init:) ; moselyCoat
				(SetFlag 99)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance gabsChair of Feature
	(properties
		noun 30
		sightAngle 20
		x 134
		y 99
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 122 108 118 89 124 85 130 101 143 102 143 115 140 120 121 119
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(if (gCurRoom notify: 1)
					(gMessager say: noun theVerb 80 0) ; "Gabriel's already using the chair."
				else
					(gEgo setScript: sitGabDown)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance myDVC of Code
	(properties)

	(method (doit param1 param2 &tmp temp0)
		(if (== (param2 modNum:) -1)
			(= temp0 gCurRoomNum)
		else
			(= temp0 (param2 modNum:))
		)
		(cond
			(
				(and
					gMsgType
					(param2 noun:)
					(not (OneOf param1 8 6 12 10 11 9 7 13))
					(Message msgGET temp0 (param2 noun:) 0 0 1)
				)
				(gMessager say: (param2 noun:) 0 0 0 0 temp0)
			)
			((OneOf param1 7 11 10 12)
				(gMessager say: (gCurRoom noun:) param1 89 0)
			)
			(else
				(gGame pragmaFail: param1)
			)
		)
	)
)

