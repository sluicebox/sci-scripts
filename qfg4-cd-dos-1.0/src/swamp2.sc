;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 542)
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
	swamp2 0
)

(procedure (localproc_0)
	(gCurRoom
		topX: 161
		bottomX: 185
		rightY: 156
		leftY: 160
		addObstacle:
			((Polygon new:)
				type: PBarredAccess
				init: 183 93 198 85 255 85 259 91 300 91 317 106 251 108 238 106 197 106
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 240 128 319 108 319 137 257 139
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 103 122 132 114 161 124 161 132 103 132
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 310 188 198 188 198 174 253 161 308 172
				yourself:
			)
			((Polygon new:) type: PBarredAccess init: 0 126 74 136 74 147 0 148 yourself:)
			((Polygon new:)
				type: PBarredAccess
				init: 26 165 31 159 74 159 81 153 134 152 139 157 157 165 149 174 38 174
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 39 116 65 107 96 113 96 128 67 128 36 128
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 129 181 158 175 168 182 135 189
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 131 141 199 131 249 137 264 152 202 152 140 152
				yourself:
			)
	)
)

(instance swamp2 of GloryRm
	(properties
		picture 550
		horizon 91
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
		(atp3Reflect init:)
		(atp4 init:)
		(atp5 init:)
		(atp6 init:)
		(atp7 init:)
		(atp8 init:)
		(atp9 init:)
		(atp10 init:)
		((ScriptID 10 2) init:) ; reflection
		(gWalkHandler add: gCurRoom)
		(switch gPrevRoomNum
			(545
				(cond
					((> global107 320)
						(self setScript: sFromWest)
					)
					((< global107 0)
						(self setScript: sFromEast)
					)
					((> global108 190)
						(self setScript: sFromNorth)
					)
					(else
						(self setScript: sFromSouth)
					)
				)
			)
			(530
				(self setScript: sFromEast)
			)
			(541 ; swamp1
				(if (> global107 320)
					(self setScript: sFromWest)
				else
					(self setScript: sFromNorth)
				)
			)
			(543 ; swamp3
				(if (< global107 0)
					(self setScript: sFromEast)
				else
					(self setScript: sFromSouth)
				)
			)
			(else
				(gEgo
					x: 160
					y: 100
					init:
					normalize:
					setScaler: Scaler 100 60 125 65
				)
				(gGlory handsOn:)
			)
		)
		(if (IsFlag 149)
			(gWalkHandler addToFront: atp1 atp2 atp4 atp5 atp6 atp7 atp8 atp9)
		)
	)

	(method (dispose)
		(if (IsFlag 149)
			(gWalkHandler delete: atp1 atp2 atp4 atp5 atp6 atp7 atp8 atp9)
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
				(self leftY: 136)
			)
			(poly8
				(self topX: 265)
			)
			(poly9
				(self bottomX: 242)
			)
			(poly7
				(self rightY: 124)
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
				(gWalkHandler addToFront: atp1 atp2 atp4 atp5 atp6 atp7 atp8 atp9)
				(gGlory handsOn:)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance sFromEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (or (IsFlag 167) (IsFlag 149))
					(if (IsFlag 149)
						(localproc_0)
						(gEgo
							x: 310
							y: 155
							init:
							normalize:
							setLoop: -1
							setLoop: Grooper
							setCycle: Walk
							view: 5
							loop: 1
							setMotion: PolyPath 300 155 self
						)
					else
						(gEgo
							init:
							normalize:
							view: 536
							x: 310
							y: 155
							setScaler: Scaler 100 60 125 65
							moveSpeed: 12
							cycleSpeed: 8
							changeGait: -1 0
							illegalBits: 0
							ignoreHorizon:
							setCycle: StopWalk 538
							setMotion: PolyPath 300 155 self
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
					(gCurRoom addObstacle: (atp7 heading:))
					(gEgo
						x: 310
						y: (atp7 approachY:)
						init:
						normalize: 1
						setScaler: Scaler 100 60 125 65
						setMotion: PolyPath 300 (atp7 approachY:) self
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

(instance sFromNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (IsFlag 167) (IsFlag 149))
					(localproc_0)
					(if (IsFlag 149)
						(gEgo
							x: 161
							y: 83
							init:
							normalize:
							setScaler: Scaler 100 60 125 65
							setLoop: -1
							setLoop: Grooper
							setCycle: Walk
							view: 5
							loop: 2
							setMotion: PolyPath 161 95 self
						)
					else
						(gEgo
							init:
							normalize:
							view: 536
							x: 161
							y: 83
							setScaler: Scaler 100 60 125 65
							moveSpeed: 12
							cycleSpeed: 8
							changeGait: -1 0
							illegalBits: 0
							ignoreHorizon:
							setCycle: StopWalk 538
							setMotion: PolyPath 161 95 self
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
						normalize:
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

(instance sFromWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (IsFlag 167) (IsFlag 149))
					(localproc_0)
					(if (IsFlag 149)
						(gEgo
							x: -10
							y: 160
							init:
							normalize:
							setLoop: -1
							setLoop: Grooper
							setCycle: Walk
							view: 5
							loop: 0
							setMotion: PolyPath 20 160 self
						)
					else
						(gEgo
							init:
							normalize:
							view: 536
							x: -10
							y: 160
							setScaler: Scaler 100 60 125 65
							moveSpeed: 12
							cycleSpeed: 8
							changeGait: -1 0
							illegalBits: 0
							ignoreHorizon:
							setCycle: StopWalk 538
							setMotion: PolyPath 20 160 self
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
					(gCurRoom addObstacle: (atp1 heading:))
					(gEgo
						x: -5
						y: (atp1 approachY:)
						init:
						normalize:
						setScaler: Scaler 100 60 125 65
						setMotion: PolyPath 20 (atp1 approachY:) self
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

(instance sFromSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (IsFlag 167) (IsFlag 149))
					(localproc_0)
					(if (IsFlag 149)
						(gEgo
							x: 185
							y: 195
							init:
							normalize:
							setScaler: Scaler 100 60 125 65
							setLoop: -1
							setLoop: Grooper
							setCycle: Walk
							loop: 3
							view: 5
							setMotion: PolyPath 185 187 self
						)
					else
						(gEgo
							init:
							normalize:
							view: 536
							x: 185
							y: 195
							setScaler: Scaler 100 60 125 65
							moveSpeed: 12
							cycleSpeed: 8
							changeGait: -1 0
							illegalBits: 0
							ignoreHorizon:
							setCycle: StopWalk 538
							loop: 3
							setMotion: PolyPath 185 187 self
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
					(gCurRoom addObstacle: (atp9 heading:))
					(gEgo
						x: (atp9 approachX:)
						y: (atp9 approachY:)
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
		approachX 39
		approachY 139
		x 25
		y 147
		view 550
		loop 2
		cel 6
	)

	(method (init)
		(super init: &rest)
		(= heading (poly1 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 11)
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
		(super init: 0 0 319 0 319 189 0 189 0 139 57 140 57 136 0 131)
		(return self)
	)
)

(instance atp2 of SwampView
	(properties
		noun 4
		approachX 59
		approachY 164
		x 68
		y 172
		view 550
		loop 2
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
	(properties)

	(method (init)
		(super init: 40 168 72 169 84 160 130 161 130 156 80 157 72 164 40 163)
		(return self)
	)
)

(instance atp3 of View
	(properties
		noun 5
		x 154
		y 187
		view 550
		loop 2
		cel 4
		signal 16384
	)
)

(instance atp3Reflect of View
	(properties
		x 154
		y 187
		view 550
		loop 6
		cel 4
		signal 16384
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb &rest)
	)
)

(instance atp4 of SwampView
	(properties
		noun 4
		approachX 127
		approachY 125
		x 127
		y 132
		view 550
		loop 3
		cel 2
	)

	(method (init)
		(super init: &rest)
		(= heading (poly4 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 15)
			priority: (atp4 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance poly4 of SwampPoly
	(properties)

	(method (init)
		(super init: 113 127 151 126 153 122 112 123)
		(return self)
	)
)

(instance atp5 of SwampView
	(properties
		noun 4
		approachX 194
		approachY 140
		x 194
		y 151
		view 550
		loop 3
		cel 6
	)

	(method (init)
		(super init: &rest)
		(= heading (poly5 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 11)
			priority: (atp5 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance poly5 of SwampPoly
	(properties)

	(method (init)
		(super init: 157 144 233 142 231 137 158 141)
		(return self)
	)
)

(instance atp6 of SwampView
	(properties
		noun 4
		approachX 67
		approachY 117
		x 63
		y 126
		view 550
		loop 3
		cel 2
	)

	(method (init)
		(super init: &rest)
		(= heading (poly6 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 15)
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
		(super init: 49 122 87 120 86 116 48 117)
		(return self)
	)
)

(instance atp7 of SwampView
	(properties
		noun 4
		approachX 289
		approachY 131
		x 303
		y 137
		view 550
		loop 3
		cel 6
	)

	(method (init)
		(super init: &rest)
		(= heading (poly7 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 11)
			priority: (atp7 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance poly7 of SwampPoly
	(properties
		type 2
	)

	(method (init)
		(super init: 261 132 319 129 319 189 0 189 0 0 319 0 319 121 262 128)
		(return self)
	)
)

(instance atp8 of SwampView
	(properties
		noun 4
		approachX 263
		approachY 97
		x 266
		y 104
		view 550
		loop 3
		cel 1
	)

	(method (init)
		(super init: &rest)
		(= heading (poly8 init:))
		(self approachVerbs: 4) ; Do
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 17)
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
				246
				100
				287
				100
				287
				91
				270
				91
				270
				57
				319
				57
				319
				189
				0
				189
				0
				57
				258
				57
				258
				90
				246
				90
		)
		(return self)
	)
)

(instance atp9 of SwampView
	(properties
		noun 4
		approachX 254
		approachY 178
		x 256
		y 190
		view 550
		loop 3
		cel 6
	)

	(method (init)
		(super init: &rest)
		(= heading (poly9 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 11)
			priority: (atp9 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance poly9 of SwampPoly
	(properties
		type 2
	)

	(method (init)
		(super
			init:
				223
				178
				259
				178
				259
				184
				249
				184
				249
				189
				319
				189
				319
				0
				0
				0
				0
				189
				238
				189
				238
				184
				223
				184
		)
		(return self)
	)
)

(instance atp10 of View
	(properties
		noun 8
		y 79
		view 550
		signal 16384
	)
)

