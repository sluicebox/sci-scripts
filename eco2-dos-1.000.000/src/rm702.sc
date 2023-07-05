;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 702)
(include sci.sh)
(use Main)
(use ExitFeature)
(use eRS)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm702 0
)

(local
	local0
	local1
	local2
)

(instance rm702 of Eco2Room
	(properties
		picture 700
		style 16394
		horizon 80
		north 700
	)

	(method (doVerb)
		(return 0)
	)

	(method (init)
		(tree1 init:)
		(tree3 init:)
		(tree4 init:)
		(tree5 init:)
		(tree6 init:)
		(tree7 init:)
		(roots1 init:)
		(roots2 init:)
		(roots3 init:)
		(roots4 init:)
		(roots5 init:)
		(water init:)
		(exitnorth init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 4 0 4 185 164 185 164 160 210 160 210 185 314 185 314 177 214 175 214 144 267 114 314 114 314 0 319 1 319 189 0 189 0 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 267 89 267 101 236 101 236 89
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 187 104 229 104 229 125 187 125
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 198 86 198 102 167 102 167 86
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 158 82 158 97 131 97 131 82
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 41 110 54 97 102 97 102 120 41 120
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 51 88 51 96 38 109 11 109 11 88
					yourself:
				)
		)
		(gEgo y: 100 init: normalize: setScale: Scaler 100 35 189 80)
		(if (== (gEgo view:) 10)
			(gEgo setCycle: StopWalk 13)
		)
		(super init:)
		((View new:)
			view: 700
			loop: 6
			cel: 0
			x: 320
			y: 7
			noun: 3
			signal: 20496
			priority: 12
			init:
			addToPic:
		)
		(fruit init: addToPic:)
		(lilly1 init:)
		(lilly2 init:)
		(lilly3 init:)
		(if (not (gCurrentRegionFlags test: 1))
			(lilyPad init: setScale: -1 gEgo noun: 1 approachVerbs: 4 47) ; Do, sharpRock
			(lilly1 approachVerbs: 47) ; sharpRock
			(lilly2 approachVerbs: 47) ; sharpRock
			(lilly3 approachVerbs: 47) ; sharpRock
			((= local0 (Polygon new:))
				type: PBarredAccess
				init: 104 133 135 133 135 150 120 150 120 158 69 158 69 127 104 127
				yourself:
			)
			(gCurRoom addObstacle: local0)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 122 143 131 143 131 161 63 161 63 124 122 124
						yourself:
					)
			)
		)
		(gEgo setMotion: PolyPath (gEgo x:) 120)
		(gGame handsOn:)
	)
)

(instance exitnorth of ExitFeature
	(properties
		nsBottom 80
		nsRight 319
		cursor 13
		exitDir 1
	)
)

(instance tree1 of Feature
	(properties
		x 28
		y 69
		noun 3
		nsTop 14
		nsLeft 279
		nsBottom 104
		nsRight 302
		sightAngle 40
		approachX 28
		approachY 59
	)
)

(instance tree3 of Feature
	(properties
		x 111
		y 69
		noun 3
		nsTop 14
		nsLeft 197
		nsBottom 106
		nsRight 219
		sightAngle 40
		approachX 111
		approachY 60
	)
)

(instance tree4 of Feature
	(properties
		x 138
		y 69
		noun 3
		nsTop 40
		nsLeft 175
		nsBottom 88
		nsRight 186
		sightAngle 40
		approachX 138
		approachY 64
	)
)

(instance tree5 of Feature
	(properties
		x 174
		y 69
		noun 3
		nsTop 44
		nsLeft 138
		nsBottom 80
		nsRight 151
		sightAngle 40
		approachX 174
		approachY 62
	)
)

(instance tree6 of Feature
	(properties
		x 244
		y 59
		noun 3
		nsTop 6
		nsLeft 55
		nsBottom 98
		nsRight 94
		sightAngle 40
		approachX 244
		approachY 52
	)
)

(instance tree7 of Feature
	(properties
		x 285
		y 69
		noun 3
		nsTop 24
		nsLeft 24
		nsBottom 84
		nsRight 44
		sightAngle 40
		approachX 285
		approachY 54
	)
)

(instance roots1 of Feature
	(properties
		x 28
		y 115
		noun 5
		nsTop 105
		nsLeft 277
		nsBottom 126
		nsRight 305
		sightAngle 40
		approachX 28
		approachY 115
	)
)

(instance roots2 of Feature
	(properties
		x 110
		y 116
		noun 5
		nsTop 107
		nsLeft 196
		nsBottom 125
		nsRight 221
		sightAngle 40
		approachX 110
		approachY 116
	)
)

(instance roots3 of Feature
	(properties
		x 31
		y 96
		noun 5
		nsTop 90
		nsLeft 20
		nsBottom 103
		nsRight 43
		sightAngle 40
		approachX 31
		approachY 96
	)
)

(instance roots4 of Feature
	(properties
		x 74
		y 84
		noun 5
		nsTop 100
		nsLeft 54
		nsBottom 110
		nsRight 94
		sightAngle 40
		approachX 74
		approachY 105
	)
)

(instance roots5 of Feature
	(properties
		x 146
		y 86
		noun 5
		nsTop 83
		nsLeft 137
		nsBottom 90
		nsRight 156
		sightAngle 40
		approachX 146
		approachY 86
	)
)

(instance water of Feature
	(properties
		x 159
		y 5
		z 169
		noun 4
		nsTop 80
		nsBottom 189
		nsRight 319
		sightAngle 360
		approachX 159
		approachY 169
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 55) (not (IsEcorderFlag 14))) ; E-corder
				(self perform: gWriteEcorderData theVerb 14)
			)
			((and (== theVerb 4) (== (gEgo script:) getFruit)) ; Do
				(getFruit cue:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 14))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance fruit of View
	(properties
		x 159
		y 211
		z 200
		noun 6
		view 700
		loop 7
		priority 14
		signal 20496
	)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp1 (event x:))
		(= temp0 (event y:))
		(if (and (< 180 temp1 288) (< 54 temp0 184))
			(= noun 7)
		else
			(= noun 6)
		)
		(if (== (gEgo script:) getFruit)
			(if (and (self onMe: event) (== noun 6))
				(= local2 1)
			)
			(getFruit cue:)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (gCurrentRegionFlags test: 5)
					(super doVerb: theVerb &rest)
				else
					(gEgo setScript: getFruit)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lilyPad of Prop
	(properties
		x 114
		y 139
		view 700
		loop 1
		signal 16384
	)

	(method (doit)
		(if (not (IsEcorderFlag 16))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(55 ; E-corder
				(if (not (IsEcorderFlag 16))
					(self perform: gWriteEcorderData theVerb 16)
				else
					(super doVerb: theVerb)
				)
			)
			(47 ; sharpRock
				(if (gCurrentRegionFlags test: 0)
					(super doVerb: theVerb)
				else
					(gGame points: 5)
					(lilly1 _approachVerbs: 0)
					(lilly2 _approachVerbs: 0)
					(lilly3 _approachVerbs: 0)
					(gCurRoom setScript: cutLilyFree)
				)
			)
			(4 ; Do
				(if (gCurrentRegionFlags test: 0)
					(gGame points: 5)
					(gCurRoom setScript: getLilyPad)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lilly1 of View
	(properties
		x 103
		y 151
		noun 1
		approachX 114
		approachY 139
		view 700
		loop 1
		signal 16384
		scaleSignal 1
		scaleX 72
		scaleY 72
	)

	(method (doit)
		(if (not (IsEcorderFlag 16))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (init)
		(super init: &rest)
		(self addToPic:)
		(= sightAngle 26505)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(super doVerb: theVerb &rest)
		else
			(lilyPad doVerb: theVerb &rest)
		)
	)
)

(instance lilly2 of View
	(properties
		x 91
		y 132
		noun 1
		approachX 114
		approachY 139
		view 700
		loop 1
		signal 16384
		scaleSignal 1
		scaleX 72
		scaleY 72
	)

	(method (doit)
		(if (not (IsEcorderFlag 16))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (init)
		(super init: &rest)
		(self addToPic:)
		(= sightAngle 26505)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(super doVerb: theVerb &rest)
		else
			(lilyPad doVerb: theVerb &rest)
		)
	)
)

(instance lilly3 of View
	(properties
		x 87
		y 143
		noun 1
		approachX 114
		approachY 139
		view 700
		loop 8
		signal 16384
	)

	(method (doit)
		(if (not (IsEcorderFlag 16))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (init)
		(super init: &rest)
		(self addToPic:)
		(= sightAngle 26505)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(super doVerb: theVerb &rest)
		else
			(lilyPad doVerb: theVerb &rest)
		)
	)
)

(instance getFruit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 200 175 self)
			)
			(1
				(gEgo setMotion: MoveTo 193 183 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(sFX number: 717 setLoop: 1 play:)
				(gEgo
					view: 8
					setLoop: 2
					cel: 0
					setPri: 15
					setCycle: End self
				)
			)
			(4
				(gEgo
					setLoop: 0
					yStep: 3
					cel: 4
					ignoreHorizon:
					setScale:
					setCycle: Walk
					setMotion: MoveTo 193 93 self
				)
				(gEgo scaleSignal: 5)
				((= register (Actor new:))
					view: 8
					signal: 16384
					setLoop: 1
					setPri: 13
					cel: 4
					x: 193
					y: 183
					yStep: 3
					scaleSignal: 5
					scaleX: (gEgo scaleX:)
					scaleY: (gEgo scaleY:)
					cycleSpeed: (gEgo cycleSpeed:)
					moveSpeed: (gEgo moveSpeed:)
					setCycle: Walk
					origStep: (gEgo origStep:)
					ignoreHorizon:
					illegalBits: 0
					init:
					setMotion: MoveTo 193 93
				)
			)
			(5
				(User input: 1)
				(gTheIconBar enable: 2 advanceCurIcon:)
			)
			(6
				(User input: 0)
				(gTheIconBar disable: 2)
				(if local2
					(register loop: 3 cel: 0 cycleSpeed: 9 setCycle: End self)
					(gEgo get: 16)
					(gGame points: 5)
					(gCurrentRegionFlags set: 5)
				else
					(self cue:)
				)
			)
			(7
				(= local1 721)
				(register
					setLoop: 1
					cel: (gEgo cel:)
					setCycle: (Backwards new:)
					setMotion: MoveTo 193 183 self
				)
				(gEgo
					cycleSpeed: global136
					setCycle: (Backwards new:)
					setMotion: MoveTo 193 183
				)
			)
			(8
				(register dispose:)
				(= register 0)
				(sFX number: 717 setLoop: 1 play:)
				(gEgo
					setLoop: 2
					cel: (gEgo lastCel:)
					scaleSignal: 1
					setCycle: Beg self
				)
			)
			(9
				(gEgo
					view: 10
					loop: 1
					setLoop: -1
					setScale: Scaler 100 35 189 80
					setCycle: StopWalk 13
					setMotion: MoveTo 175 183 self
				)
			)
			(10
				(gEgo setPri: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if
			(and
				(IsObject register)
				(not (gEgo cel:))
				(< 717 local1 722)
				(== (sFX prevSignal:) -1)
			)
			(sFX number: local1 setLoop: 1 play:)
			(if (== state 4)
				(++ local1)
			else
				(-- local1)
			)
		)
		(super doit:)
	)

	(method (init)
		(= local1 718)
		(super init: &rest)
	)
)

(instance cutLilyFree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 701 loop: 3 cel: 0 setCycle: End self)
				(sFX number: 211 setLoop: 1 play:)
			)
			(1
				(gMessager say: 1 47 1 0 self) ; "Adam saws the stem with the sharp piranha teeth."
			)
			(2
				(gEgo cel: 4 setCycle: Beg self)
				(gCurrentRegionFlags set: 0)
			)
			(3
				(gEgo view: 10 loop: 1 setCycle: StopWalk 13)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getLilyPad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(lilyPad dispose:)
				((gCurRoom obstacles:) delete: local0)
				(local0 dispose:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 122 143 131 143 131 161 63 161 63 124 122 124
							yourself:
						)
				)
				(gEgo
					view: 701
					loop: 4
					y: (+ 2 (gEgo y:))
					cel: 0
					setCycle: End self
				)
				(gCurrentRegionFlags set: 1)
			)
			(1
				(sFX number: 600 setLoop: 1 play:)
				(gEgo view: 702 loop: 4 normalize:)
				(gGameSound1 fade: 0 120 20 1)
				(gGameSound2
					number: 712
					setLoop: -1
					setVol: 0
					play:
					fade: 127 120 20 0
				)
				(= cycles 2)
			)
			(2
				(gEgo setMotion: MoveTo 124 139 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance Backwards of Cycle
	(properties
		cycleDir -1
	)

	(method (doit &tmp temp0)
		(if (not (client isStopped:))
			(if (< (= temp0 (self nextCel:)) 0)
				(self cycleDone:)
			else
				(client cel: temp0)
			)
		)
	)

	(method (cycleDone)
		(client cel: (client lastCel:))
	)
)

(instance sFX of Sound
	(properties)
)

