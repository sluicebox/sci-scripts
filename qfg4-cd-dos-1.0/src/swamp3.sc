;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 543)
(include sci.sh)
(use Main)
(use GloryRm)
(use Swamp)
(use Scaler)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use Grooper)
(use Motion)
(use Actor)
(use System)

(public
	swamp3 0
)

(procedure (localproc_0)
	(gCurRoom
		topX: 116
		leftY: 141
		bottomX: 165
		rightY: 160
		addObstacle:
			((Polygon new:)
				type: PBarredAccess
				init: 123 111 174 97 241 104 241 121 123 121
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 0 104 44 104 47 108 92 108 97 126 0 126
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 262 124 279 118 319 118 319 146 262 146
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 271 168 319 160 319 181 271 181
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 169 168 266 168 266 189 169 189
				yourself:
			)
			((Polygon new:) type: PBarredAccess init: 0 159 48 159 48 175 0 175 yourself:)
			((Polygon new:)
				type: PBarredAccess
				init: 80 137 108 132 140 132 169 139 169 153 152 159 118 153 80 153
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 54 175 108 160 158 170 158 189 54 189
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 194 129 228 123 251 124 259 135 197 135
				yourself:
			)
			((Polygon new:) type: PBarredAccess init: 71 153 29 153 29 136 71 136 yourself:)
	)
)

(instance swamp3 of GloryRm
	(properties
		picture 550
		horizon 104
		north 3
		east 4
		south 2
		west 1
	)

	(method (newRoom newRoomNumber)
		(switch newRoomNumber
			(1
				(= global357 0)
				(++ global350)
			)
			(2
				(= global357 0)
				(++ global349)
			)
			(3
				(++ global357)
				(-- global349)
			)
			(4
				(= global357 0)
				(-- global350)
			)
		)
		(super
			newRoom:
				(cond
					((>= (+ global349 global350) 4) 545)
					((and (== global349 1) (== global350 -1)) 535)
					((and (<= global349 0) (<= global350 0)) 530)
					((> global357 3) 530)
					(else
						(+ (mod (+ (- global349 global350) 2) 3) 541)
					)
				)
		)
	)

	(method (init)
		(self setRegions: 10) ; Swamp
		(super init: &rest)
		(atp1 init:)
		(atp2 init:)
		(atp3 init:)
		(atp4 init:)
		(atp5 init:)
		(atp5Reflect init:)
		(atp6 init:)
		(atp7 init:)
		(atp8 init:)
		(atp9 init:)
		(atp9Reflect init:)
		(atp10 init:)
		(atp10Reflect init:)
		(atp11 init:)
		((ScriptID 10 2) init:) ; reflection
		(gWalkHandler add: gCurRoom)
		(switch gPrevRoomNum
			(535
				(self setScript: fromNorth)
			)
			(542 ; swamp2
				(if (> global107 320)
					(self setScript: fromWest)
				else
					(self setScript: fromNorth)
				)
			)
			(541 ; swamp1
				(if (< global107 0)
					(self setScript: fromEast)
				else
					(self setScript: fromSouth)
				)
			)
			(545
				(cond
					((> global107 320)
						(self setScript: fromWest)
					)
					((< global107 0)
						(self setScript: fromEast)
					)
					(else
						(self setScript: fromSouth)
					)
				)
			)
			(else
				(gEgo
					x: 120
					y: 120
					init:
					normalize:
					setScaler: Scaler 100 60 125 65
				)
				(gGlory handsOn:)
			)
		)
		(if (IsFlag 149)
			(gWalkHandler addToFront: atp1 atp2 atp3 atp4 atp6 atp7 atp8 atp11)
		)
	)

	(method (dispose)
		(if (IsFlag 149)
			(gWalkHandler delete: atp1 atp2 atp3 atp4 atp6 atp7 atp8 atp11)
		)
		(= global107 (gEgo x:))
		(= global108 (gEgo y:))
		(gWalkHandler delete: gCurRoom)
		(super dispose:)
	)

	(method (notify param1)
		(if (and argc (not (gCurRoom script:)) (== param1 -2))
			(gCurRoom setScript: (ScriptID 10 5)) ; sEgoDrownGlide
		else
			(localproc_0)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(if (>= (gEgo y:) 175)
					(gEgo setPri: -1)
				)
			)
			(11 ; glideSpell
				(if (IsFlag 167)
					(gMessager say: 0 11 7) ; "You don't dare cast the Glide spell until you get up on solid land. You'd probably sink if you tried it here."
				else
					(self setScript: sGlideFromTuff)
				)
			)
			(91 ; jugglingLightsSpell
				(if (IsFlag 167)
					(gMessager say: 0 11 7) ; "You don't dare cast the Glide spell until you get up on solid land. You'd probably sink if you tried it here."
				else
					(gCurRoom setScript: (ScriptID 62)) ; castJuggle
				)
			)
			(else
				((ScriptID 10) doVerb: theVerb) ; Swamp
			)
		)
	)

	(method (addObstacle param1)
		(switch param1
			(poly1
				(self rightY: 170)
			)
			(poly2
				(self leftY: 110)
			)
			(poly3
				(self leftY: 163)
			)
			(poly4
				(self topX: 180)
			)
			(poly8
				(self bottomX: 90)
			)
			(poly11
				(self rightY: 132)
			)
		)
		(super addObstacle: param1 &rest)
	)
)

(instance sGlideFromTuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(|= global393 $0003)
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
				)
				(localproc_0)
				(SetFlag 149)
				(self setScript: (ScriptID 12) self) ; castAreaScript
			)
			(1
				(gEgo
					setLoop: -1
					setLoop: Grooper
					loop: 0
					setCycle: Walk
					view: 5
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 5) self
				)
			)
			(2
				(gWalkHandler addToFront: atp1 atp2 atp3 atp4 atp6 atp7 atp8 atp11)
				(gGlory handsOn:)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance fromNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (or (IsFlag 167) (IsFlag 149))
					(localproc_0)
					(if (IsFlag 149)
						(gEgo
							x: 116
							y: 102
							init:
							normalize:
							setScaler: Scaler 100 60 125 65
							setLoop: -1
							setLoop: Grooper
							setCycle: Walk
							view: 5
							loop: 2
							setMotion: PolyPath 116 106 self
						)
					else
						(gEgo
							init:
							normalize:
							view: 536
							x: 116
							y: 102
							scaleSignal: 4
							setScaler: Scaler 100 60 125 65
							moveSpeed: 12
							cycleSpeed: 6
							changeGait: -1 0
							setCycle: StopWalk 538
							setMotion: PolyPath 116 106 self
						)
						((ScriptID 10 2) ; reflection
							x: (gEgo x:)
							y: (gEgo y:)
							loop: (+ (gEgo loop:) 8)
							cel: (gEgo cel:)
							show:
						)
					)
				else
					(gCurRoom addObstacle: (atp4 heading:))
					(gEgo
						x: (atp4 approachX:)
						y: (atp4 approachY:)
						init:
						setScaler: Scaler 100 60 125 65
						normalize: 2
					)
					(= cycles 2)
				)
			)
			(1
				(gGlory handsOn:)
				(if (IsFlag 149)
					(gTheIconBar disable: 5)
				)
				(self dispose:)
			)
		)
	)
)

(instance fromEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (or (IsFlag 167) (IsFlag 149))
					(localproc_0)
					(if (IsFlag 149)
						(gEgo
							x: 310
							y: 160
							init:
							normalize:
							setLoop: -1
							setLoop: Grooper
							setCycle: Walk
							view: 5
							loop: 1
							setMotion: PolyPath 300 160 self
						)
					else
						(gEgo
							init:
							normalize:
							view: 536
							x: 310
							y: 160
							scaleSignal: 4
							setScaler: Scaler 100 60 125 65
							moveSpeed: 12
							cycleSpeed: 6
							changeGait: -1 0
							setCycle: StopWalk 538
							setMotion: PolyPath 300 160 self
						)
						((ScriptID 10 2) ; reflection
							x: (gEgo x:)
							y: (gEgo y:)
							loop: (+ (gEgo loop:) 8)
							cel: (gEgo cel:)
							show:
						)
					)
				else
					(gCurRoom addObstacle: (atp11 heading:))
					(gEgo
						x: 310
						y: (atp11 approachY:)
						init:
						setScaler: Scaler 100 60 125 65
						normalize: 1
						setMotion: PolyPath 300 (atp11 approachY:) self
					)
				)
			)
			(1
				(gGlory handsOn:)
				(if (IsFlag 149)
					(gTheIconBar disable: 5)
				)
				(self dispose:)
			)
		)
	)
)

(instance fromWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (IsFlag 167) (IsFlag 149))
					(localproc_0)
					(if (IsFlag 149)
						(gEgo
							x: -10
							y: 141
							init:
							normalize:
							setScaler: Scaler 100 60 125 65
							setLoop: -1
							setLoop: Grooper
							setCycle: Walk
							view: 5
							loop: 0
							setMotion: PolyPath 20 141 self
						)
					else
						(gEgo
							init:
							normalize:
							view: 536
							x: -10
							y: 155
							scaleSignal: 4
							setScaler: Scaler 100 60 125 65
							moveSpeed: 12
							cycleSpeed: 6
							changeGait: -1 0
							setCycle: StopWalk 538
							setMotion: PolyPath 20 155 self
						)
						((ScriptID 10 2) ; reflection
							x: (gEgo x:)
							y: (gEgo y:)
							loop: (+ (gEgo loop:) 8)
							cel: (gEgo cel:)
							show:
						)
					)
				else
					(gCurRoom addObstacle: (atp2 heading:))
					(gEgo
						x: -5
						y: (atp2 approachY:)
						init:
						normalize: 0
						setScaler: Scaler 100 60 125 65
						setMotion: PolyPath 20 (atp2 approachY:) self
					)
				)
			)
			(1
				(gGlory handsOn:)
				(if (IsFlag 149)
					(gTheIconBar disable: 5)
				)
				(self dispose:)
			)
		)
	)
)

(instance fromSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (IsFlag 167) (IsFlag 149))
					(localproc_0)
					(if (IsFlag 149)
						(gEgo
							x: 165
							y: 195
							init:
							normalize:
							setScaler: Scaler 100 60 125 65
							setLoop: -1
							setLoop: Grooper
							setCycle: Walk
							loop: 3
							view: 5
							setMotion: PolyPath 165 187 self
						)
					else
						(gEgo
							init:
							normalize:
							view: 536
							x: 165
							y: 195
							scaleSignal: 4
							setScaler: Scaler 100 60 125 65
							moveSpeed: 12
							cycleSpeed: 6
							changeGait: -1 0
							setCycle: StopWalk 538
							loop: 3
							setMotion: PolyPath 165 187 self
						)
						((ScriptID 10 2) ; reflection
							x: (gEgo x:)
							y: (gEgo y:)
							loop: (+ (gEgo loop:) 8)
							cel: (gEgo cel:)
							show:
						)
					)
				else
					(gCurRoom addObstacle: (atp8 heading:))
					(gEgo
						x: (atp8 approachX:)
						y: (atp8 approachY:)
						init:
						normalize: 3
						setScaler: Scaler 100 60 125 65
					)
					(= cycles 2)
				)
			)
			(1
				(gGlory handsOn:)
				(if (IsFlag 149)
					(gTheIconBar disable: 5)
				)
				(self dispose:)
			)
		)
	)
)

(instance atp1 of SwampView
	(properties
		noun 4
		approachX 298
		approachY 172
		x 315
		y 179
		view 550
		loop 2
		cel 3
	)

	(method (init)
		(super init: &rest)
		(= heading (poly1 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 10)
			priority: (atp1 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance poly1 of SwampPoly
	(properties
		type 2
	)

	(method (init)
		(super init: 292 173 319 173 319 189 0 189 0 0 319 0 319 166 292 166)
		(return self)
	)
)

(instance atp2 of SwampView
	(properties
		noun 4
		approachX 58
		approachY 119
		x 53
		y 123
		view 550
		loop 3
		cel 1
	)

	(method (init)
		(super init: &rest)
		(= heading (poly2 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 17)
			priority: (atp2 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance poly2 of SwampPoly
	(properties
		type 2
	)

	(method (init)
		(super
			init:
				0
				0
				319
				0
				319
				189
				0
				189
				0
				113
				37
				113
				47
				119
				85
				119
				85
				112
				52
				112
				37
				107
				0
				107
		)
		(return self)
	)
)

(instance atp3 of SwampView
	(properties
		noun 4
		approachX 18
		approachY 166
		x 11
		y 174
		view 550
		loop 3
		cel 2
	)

	(method (init)
		(super init: &rest)
		(= heading (poly3 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 15)
			priority: (atp3 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance poly3 of SwampPoly
	(properties
		type 2
	)

	(method (init)
		(super init: 0 0 319 0 319 189 0 189 0 167 34 166 34 161 0 161)
		(return self)
	)
)

(instance atp4 of SwampView
	(properties
		noun 4
		approachX 176
		approachY 109
		x 178
		y 121
		view 550
		loop 3
		cel 6
	)

	(method (init)
		(super init: &rest)
		(= heading (poly4 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 11)
			priority: (atp4 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance poly4 of SwampPoly
	(properties
		type 2
	)

	(method (init)
		(super
			init:
				146
				104
				167
				104
				167
				90
				0
				90
				0
				189
				319
				189
				319
				90
				184
				90
				184
				105
				199
				105
				199
				114
				146
				114
		)
		(return self)
	)
)

(instance atp5 of View
	(properties
		noun 5
		x 56
		y 152
		view 550
		loop 2
		cel 4
		signal 16384
	)
)

(instance atp5Reflect of View
	(properties
		x 56
		y 152
		view 550
		loop 6
		cel 4
		signal 16384
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb &rest)
	)
)

(instance atp6 of SwampView
	(properties
		noun 4
		approachX 223
		approachY 129
		x 226
		y 134
		view 550
		loop 2
		cel 5
	)

	(method (init)
		(super init: &rest)
		(= heading (poly6 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 8)
			priority: (atp6 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance poly6 of SwampPoly
	(properties)

	(method (init)
		(super init: 201 130 251 129 251 125 198 125)
		(return self)
	)
)

(instance atp7 of SwampView
	(properties
		noun 4
		approachX 128
		approachY 141
		x 126
		y 151
		view 550
		loop 2
		cel 3
	)

	(method (init)
		(super init: &rest)
		(= heading (poly7 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 10)
			priority: (atp7 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance poly7 of SwampPoly
	(properties)

	(method (init)
		(super init: 89 146 159 146 157 141 86 141)
		(return self)
	)
)

(instance atp8 of SwampView
	(properties
		noun 4
		approachX 105
		approachY 177
		x 108
		y 191
		view 550
		loop 3
		cel 6
	)

	(method (init)
		(super init: &rest)
		(= heading (poly8 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 11)
			priority: (atp8 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance poly8 of SwampPoly
	(properties
		type 2
	)

	(method (init)
		(super
			init:
				64
				186
				84
				186
				84
				189
				0
				189
				0
				0
				319
				0
				319
				189
				95
				189
				95
				186
				112
				186
				112
				178
				64
				178
		)
		(return self)
	)
)

(instance atp9 of View
	(properties
		noun 9
		x 209
		y 188
		view 550
		cel 4
		signal 16384
	)
)

(instance atp9Reflect of View
	(properties
		x 209
		y 205
		view 550
		loop 4
		cel 4
		signal 16384
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb &rest)
	)
)

(instance atp10 of View
	(properties
		noun 8
		x 305
		y 132
		view 550
		cel 2
		signal 16384
	)
)

(instance atp10Reflect of View
	(properties
		x 305
		y 154
		priority 9
		fixPriority 1
		view 550
		loop 4
		cel 2
		signal 20480
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb &rest)
	)
)

(instance atp11 of SwampView
	(properties
		noun 4
		approachX 288
		approachY 136
		x 319
		y 145
		view 550
		loop 2
	)

	(method (init)
		(super init: &rest)
		(= heading (poly11 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 11)
			priority: (atp11 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance poly11 of SwampPoly
	(properties
		type 2
	)

	(method (init)
		(super init: 276 136 319 136 319 189 0 189 0 0 319 0 319 129 276 129)
		(return self)
	)
)

