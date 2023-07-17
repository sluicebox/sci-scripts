;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 530)
(include sci.sh)
(use Main)
(use GloryRm)
(use Swamp)
(use Teller)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Grooper)
(use Motion)
(use Actor)
(use System)

(public
	rm530 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (localproc_0)
	(gCurRoom
		leftY: 146
		bottomX: 185
		addObstacle:
			((Polygon new:)
				type: PBarredAccess
				init: 0 100 24 96 51 99 51 119 0 119
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 103 106 125 99 152 99 162 119 103 119
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 31 131 56 124 88 124 96 143 31 143
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 104 154 113 143 154 143 162 141 227 141 227 156 170 156 164 164 104 165
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 7 156 38 150 83 164 83 179 62 184 34 184 34 168 7 168
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 0 0 319 0 319 180 234 180 229 172 261 149 246 143 244 137 231 129 206 120 143 90 0 90
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 89 189 94 182 144 182 154 189
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 156 137 159 126 212 126 221 137
				yourself:
			)
	)
)

(instance rm530 of GloryRm
	(properties
		noun 1
		picture 530
		horizon 78
		north 556
		east 562
		south 541
		west 542
		topX 238
		rightY 120
	)

	(method (newRoom newRoomNumber)
		(switch newRoomNumber
			(542 ; swamp2
				(= global349 0)
				(= global350 1)
			)
			(541 ; swamp1
				(= global357 0)
				(= global349 1)
				(= global350 0)
			)
		)
		(super newRoom: newRoomNumber)
	)

	(method (init)
		(self setRegions: 10) ; Swamp
		(super init: &rest)
		(atp1 init:)
		(atp2 init:)
		(atp3 init:)
		(atp4 init:)
		(atp5 init:)
		(atp6 init:)
		(atp7 init:)
		(atp8 init:)
		(if (not (IsFlag 363))
			(atp9 init:)
			(skeletonReflect init:)
		)
		(atp10 init:)
		((ScriptID 10 2) init:) ; reflection
		(theWater init:)
		(theShore init:)
		(fShore init:)
		(aDoorMat init:)
		(gWalkHandler add: gCurRoom)
		(RemapColors 4 253 100 200) ; ToPercentGray
		(if (and gNight (not (IsFlag 459)) (not (gEgo has: 41))) ; theWillowisp
			(egoTell init: gEgo 530 10 128 9)
		)
		(switch gPrevRoomNum
			(556
				(self setScript: sFromNorth)
			)
			(562
				(self setScript: sFromEast)
			)
			(542 ; swamp2
				(self setScript: sFromWest)
			)
			(541 ; swamp1
				(self setScript: sFromSouth)
			)
			(543 ; swamp3
				(self setScript: sFromWest)
			)
			(else
				(gGlory handsOn:)
				(self addObstacle: (fShore heading:))
				(gEgo
					x: 260
					y: 122
					init:
					setScaler: Scaler 100 60 125 65
					normalize:
				)
			)
		)
		(if (IsFlag 149)
			(gWalkHandler addToFront: atp3 atp4 atp5 atp6 atp7 atp8 atp10 fShore)
			(= gFShore fShore)
		)
		(gGlory save: 1)
	)

	(method (addObstacle param1)
		(switch param1
			(poly8
				(self bottomX: 113)
			)
			(poly6
				(self leftY: 109)
			)
		)
		(super addObstacle: param1 &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; glideSpell
				(cond
					((fShore onMe: gEgo)
						(self setScript: sGoGlide)
					)
					((IsFlag 167)
						(gMessager say: 0 11 13) ; "You can't concentrate on the spell while you're sinking in this muck. Try getting up on some dry land first."
					)
					(else
						(self setScript: sGlideFromTuff)
					)
				)
			)
			(23 ; theCandy
				(cond
					((IsFlag 167)
						(gMessager say: 0 23 13) ; "That would work better if you were back on the shore."
					)
					((IsFlag 149)
						(gMessager say: 0 23 15) ; "You're too busy concentrating on your Gliding."
					)
					((not (theShore onMe: (gEgo x:) (gEgo y:)))
						(gMessager say: 0 23 16) ; "That would work better if you were back on the shore."
					)
					(else
						(self setScript: (ScriptID 10 1)) ; sDownCandy
					)
				)
			)
			(3 ; Walk
				(if (>= (gEgo y:) 180)
					(gEgo setPri: -1)
				)
				(super doVerb: theVerb)
			)
			(91 ; jugglingLightsSpell
				(if (IsFlag 167)
					(gMessager say: 0 11 13) ; "You can't concentrate on the spell while you're sinking in this muck. Try getting up on some dry land first."
				else
					(gCurRoom setScript: (ScriptID 62)) ; castJuggle
				)
			)
			(else
				((ScriptID 10) doVerb: theVerb) ; Swamp
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (aDoorMat onMe: (gEgo x:) (gEgo y:)) (not script))
			(if (and (OneOf (gEgo view:) 0 1 2 5) (not (IsFlag 149)))
				(self setScript: sDownWater)
			else
				(self setScript: sUpWater)
			)
		)
	)

	(method (notify param1)
		(if (and argc (not (gCurRoom script:)) (== param1 -2))
			(gCurRoom setScript: (ScriptID 10 5)) ; sEgoDrownGlide
		else
			(localproc_0)
		)
	)

	(method (dispose)
		(if (IsFlag 149)
			(gWalkHandler delete: atp3 atp4 atp5 atp6 atp7 atp8 atp10 fShore)
			(= gFShore 0)
		)
		(= global107 (gEgo x:))
		(= global108 (gEgo y:))
		(theWater dispose: 1)
		(theShore dispose: 1)
		(aDoorMat dispose:)
		(egoTell dispose:)
		(gWalkHandler delete: gCurRoom)
		(super dispose:)
	)
)

(instance aDoorMat of Polygon
	(properties)

	(method (init)
		(super init: 251 127 274 136 262 155 238 140)
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
					loop: 1
					setCycle: Walk
					view: 5
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 5) self
				)
			)
			(2
				(gWalkHandler
					addToFront: atp3 atp4 atp5 atp6 atp7 atp8 atp10 fShore
				)
				(= gFShore fShore)
				(gGlory handsOn:)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance sGetBone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 292 160 self)
			)
			(1
				(gEgo view: 4 setCel: 0 setLoop: 3 setCycle: End self)
			)
			(2
				(SetFlag 363)
				(gMessager say: 5 4 0 0 self) ; "You pick up a single slimy bone."
			)
			(3
				(gEgo get: 29 1 setCycle: Beg self) ; theBones
			)
			(4
				(gEgo normalize:)
				(gEgo loop: 1)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sUpWater of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 253 144 self)
			)
			(1
				(if (IsFlag 149)
					(gWalkHandler
						delete: atp3 atp4 atp5 atp6 atp7 atp8 atp10 fShore
					)
					(gEgo normalize: setMotion: MoveTo 267 118 self)
				else
					(gEgo
						view: 5354
						loop: 0
						cel: 0
						cycleSpeed: 6
						x: (+ (gEgo x:) 9)
						y: (+ (gEgo y:) 21)
						setCycle: End self
					)
					((ScriptID 10 2) hide:) ; reflection
				)
				(&= global393 $fffc)
			)
			(2
				(gCurRoom north: 556)
				(ClearFlag 359)
				(ClearFlag 167)
				(ClearFlag 15)
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
					(gCurRoom addObstacle: (fShore heading:))
				)
				((ScriptID 10 2) hide:) ; reflection
				(if (IsFlag 149)
					(gEgo
						moveSpeed: gTempEgoSpeed
						setScaler: Scaler 100 60 125 65
						cycleSpeed: gTempEgoSpeed
					)
					(ClearFlag 149)
				else
					(gEgo
						x: (+ (gEgo x:) 15)
						y: (- (gEgo y:) 28)
						view: 5
						changeGait: local1
						moveSpeed: gTempEgoSpeed
						cycleSpeed: gTempEgoSpeed
						setScaler: Scaler 100 60 125 65
						normalize:
					)
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGoGlide of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(|= global393 $0003)
				(gEgo code: 0 setMotion: MoveTo 241 148 self)
			)
			(1
				(SetFlag 149)
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
				)
				(localproc_0)
				(self setScript: (ScriptID 12) self) ; castAreaScript
			)
			(2
				(gEgo
					setLoop: -1
					setLoop: Grooper
					setCycle: Walk
					view: 5
					loop: 1
				)
				(gMessager say: 11 6 19 0 self) ; "As you start to Glide, you realize the only way to get back up to the dry areas will be to grab hold of something and pull yourself up."
			)
			(3
				(gWalkHandler
					addToFront: atp3 atp4 atp5 atp6 atp7 atp8 atp10 fShore
				)
				(= gFShore fShore)
				(gGlory handsOn:)
				(gTheIconBar disable: 5)
				(self dispose:)
			)
		)
	)
)

(instance sUpShore of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= gTempEgoSpeed (gEgo cycleSpeed:))
				(gEgo
					code: 0
					view: 5354
					loop: 0
					cel: 0
					cycleSpeed: 12
					x: (+ (gEgo x:) 9)
					y: (+ (gEgo y:) 21)
					setCycle: End self
				)
			)
			(1
				(gCurRoom north: 562)
				(ClearFlag 167)
				(ClearFlag 15)
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 215 103 231 118 279 136 319 149 319 189 0 189 0 0 220 0 220 81 179 92
								yourself:
							)
					)
				)
				((ScriptID 10 2) hide:) ; reflection
				(gEgo
					x: (+ (gEgo x:) 15)
					y: (- (gEgo y:) 28)
					view: 5
					moveSpeed: gTempEgoSpeed
					cycleSpeed: gTempEgoSpeed
					normalize:
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDownWater of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gWalkHandler add: gCurRoom)
				(= gTempEgoSpeed (gEgo cycleSpeed:))
				(gEgo setMotion: MoveTo 256 147 self)
			)
			(1
				(= local1 gEgoGait)
				(= gEgoGait 0) ; walking
				(gEgo
					view: 5354
					loop: 3
					cel: 0
					cycleSpeed: 12
					x: (- (gEgo x:) 12)
					y: (+ (gEgo y:) 25)
					setCycle: End self
				)
			)
			(2
				(gCurRoom north: 0)
				(|= global393 $0003)
				(SetFlag 167)
				(SetFlag 15)
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
				)
				(localproc_0)
				(gEgo
					view: 536
					x: (- (gEgo x:) 9)
					y: (- (gEgo y:) 21)
					setLoop: -1
					loop: 5
					moveSpeed: 12
					cycleSpeed: 12
					setCycle: StopWalk 538
				)
				((ScriptID 10 2) ; reflection
					x: (gEgo x:)
					y: (gEgo y:)
					loop: (+ (gEgo loop:) 8)
					cel: (gEgo cel:)
					show:
				)
				(if (== (gEgo trySkill: 0 300) -1) ; strength
					(if (or (== gHeroType 0) (== gHeroType 3)) ; Fighter, Paladin
						(gMessager say: 11 6 6) ; "You aren't strong enough to maneuver through this mucky moor yet. You'll need to build up your leg muscles a bit before you can get anywhere in this swamp."
					else
						(gMessager say: 11 6 7) ; "As you find yourself sucked into the thick muck, you realize you are never going to be able to move in the swamp this way."
					)
					(SetFlag 359)
				)
				(gGlory handsOn:)
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
				(gCurRoom addObstacle: (fShore heading:))
				(gEgo
					x: 238
					y: 70
					init:
					normalize:
					setScaler: Scaler 100 60 125 65
					setMotion: PolyPath 238 80 self
				)
			)
			(1
				(gGlory handsOn:)
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
				(gCurRoom addObstacle: (fShore heading:))
				(gEgo
					x: 314
					y: 122
					init:
					normalize:
					setScaler: Scaler 100 60 125 65
					setMotion: PolyPath 300 122 self
				)
			)
			(1
				(gGlory handsOn:)
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
				(gGlory handsOff:)
				(if (or (IsFlag 149) (IsFlag 167))
					(localproc_0)
					(if (IsFlag 149)
						(gEgo
							x: -5
							y: 129
							init:
							normalize:
							setLoop: -1
							setLoop: Grooper
							setCycle: Walk
							view: 5
							setMotion: PolyPath 10 129 self
						)
					else
						(gEgo
							x: -5
							y: 129
							init:
							normalize:
							view: 536
							setLoop: -1
							loop: 5
							moveSpeed: 12
							cycleSpeed: 12
							setCycle: StopWalk 538
							setMotion: PolyPath 10 129 self
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
					(gCurRoom addObstacle: (atp6 heading:))
					(gEgo
						x: -5
						y: (atp6 approachY:)
						init:
						normalize:
						setScaler: Scaler 100 60 125 65
						setMotion:
							PolyPath
							(atp6 approachX:)
							(atp6 approachY:)
							self
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
				(gGlory handsOff:)
				(if (or (IsFlag 149) (IsFlag 167))
					(localproc_0)
					(if (IsFlag 149)
						(gEgo
							x: 175
							y: 200
							init:
							normalize:
							setLoop: -1
							setLoop: Grooper
							setCycle: Walk
							loop: 3
							view: 5
							setMotion: PolyPath 175 180 self
						)
					else
						(gEgo
							init:
							normalize:
							view: 536
							x: 175
							y: 200
							scaleSignal: 4
							setScaler: Scaler 100 60 125 65
							moveSpeed: 12
							cycleSpeed: 6
							changeGait: -1 0
							setCycle: StopWalk 538
							loop: 3
							setMotion: PolyPath 175 180 self
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

(instance atp1 of View
	(properties
		x 24
		y 48
		view 530
		signal 16384
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(instance atp2 of View
	(properties
		noun 2
		x 285
		y 149
		priority 1
		fixPriority 1
		view 530
		cel 1
		signal 20480
	)
)

(instance atp3 of SwampView
	(properties
		noun 7
		approachX 43
		approachY 157
		x 7
		y 151
		view 530
		loop 1
		cel 4
	)

	(method (init)
		(super init: &rest)
		(= heading (poly3 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x y
			priority: (atp3 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance poly3 of SwampPoly
	(properties)

	(method (init)
		(super init: 10 161 49 161 49 157 16 157)
		(return self)
	)
)

(instance atp4 of SwampView
	(properties
		noun 7
		approachX 144
		approachY 152
		x 163
		y 156
		view 530
		loop 1
		cel 1
	)

	(method (init)
		(super init: &rest)
		(= heading (poly4 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 7)
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
		(super
			init:
				116
				158
				149
				156
				161
				150
				209
				149
				209
				144
				157
				145
				146
				151
				116
				152
		)
		(return self)
	)
)

(instance atp5 of SwampView
	(properties
		noun 7
		approachX 73
		approachY 131
		x 72
		y 140
		view 530
		loop 1
		cel 2
	)

	(method (init)
		(super init: &rest)
		(= heading (poly5 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 16)
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
		(super init: 43 137 88 136 88 130 43 131)
		(return self)
	)
)

(instance atp6 of SwampView
	(properties
		noun 7
		approachX 23
		approachY 106
		x 16
		y 114
		view 530
		loop 2
	)

	(method (init)
		(super init: &rest)
		(= heading (poly6 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 13)
			priority: (atp6 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance poly6 of SwampPoly
	(properties
		type 2
	)

	(method (init)
		(super init: 0 0 319 0 319 189 0 189 0 111 40 110 40 104 0 105)
		(return self)
	)
)

(instance atp7 of SwampView
	(properties
		noun 7
		approachX 139
		approachY 113
		x 140
		y 117
		view 530
		loop 1
		cel 2
	)

	(method (init)
		(super init: &rest)
		(= heading (poly7 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 16)
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
		(super init: 111 113 157 113 157 107 112 107)
		(return self)
	)
)

(instance atp8 of SwampView
	(properties
		noun 7
		approachX 115
		approachY 184
		x 120
		y 189
		view 530
		loop 1
		cel 3
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(= heading (poly8 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 16)
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
		(super init: 110 180 120 180 120 189 319 189 319 0 0 0 0 189 110 189)
		(return self)
	)
)

(instance atp9 of View
	(properties
		noun 5
		x 275
		y 175
		view 530
		loop 3
		signal 16384
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (IsFlag 363)
				(gMessager say: 5 4 11) ; "You already got a good bone; leave the rest of them alone."
				(return 1)
			else
				(if (== ((gCurRoom obstacles:) at: 0) (fShore heading:))
					(gEgo setScript: sGetBone)
				else
					(gMessager say: 5 4 12) ; "The skeleton is out of reach from here."
				)
				(return 1)
			)
		)
		(return (super doVerb: theVerb &rest))
	)
)

(instance skeletonReflect of View
	(properties
		x 275
		y 189
		view 530
		loop 7
		signal 20480
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb &rest)
	)
)

(instance atp10 of SwampView
	(properties
		noun 7
		approachX 180
		approachY 130
		x 180
		y 135
		view 530
		loop 2
		cel 2
	)

	(method (init)
		(super init: &rest)
		(= heading (poly10 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 16)
			priority: (atp10 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance poly10 of SwampPoly
	(properties)

	(method (init)
		(super init: 164 129 183 132 207 127 181 121)
		(return self)
	)
)

(instance theWater of Polygon
	(properties)

	(method (init)
		(super init: 0 99 166 99 236 116 319 147 319 189 0 189)
	)

	(method (dispose param1)
		(if (and argc param1)
			(super dispose:)
		)
	)
)

(instance fShore of Feature
	(properties
		approachX 264
		approachY 122
		x 220
		y 119
	)

	(method (init)
		(= onMeCheck theShore)
		(= heading (roomPoly init:))
		(super init:)
	)

	(method (handleEvent event)
		(= local2 (event x:))
		(= local3 (event y:))
		(super handleEvent: event)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(3 ; Walk
				(gCurRoom setScript: sUpWater)
			)
			(4 ; Do
				(if (not (self onMe: (gEgo x:) (gEgo y:)))
					(gCurRoom setScript: sUpWater)
				else
					(super doVerb: theVerb)
				)
			)
			(10 ; Jump
				(if (not (self onMe: (gEgo x:) (gEgo y:)))
					(if (or (IsFlag 149) (IsFlag 167))
						(gMessager say: 0 10 13) ; "The muck doesn't give you enough support to make a decent jump. Walk up onto a dry area first."
					else
						(if (< [gEgoStats 15] 150) ; acrobatics
							(= temp0 150)
						else
							(= temp0 [gEgoStats 15]) ; acrobatics
						)
						(= local4 (/ temp0 3))
						(= local5 (gEgo distanceTo: self))
						(if (<= local4 local5)
							(gEgo
								setHeading:
									(GetAngle
										(gEgo x:)
										(gEgo y:)
										local2
										local3
									)
							)
							((ScriptID 10) notify: local5 local4) ; Swamp
							(gCurRoom setScript: (ScriptID 10 4) 0) ; sJumpWater
						else
							(gCurRoom setScript: (ScriptID 10 3) 0 self) ; sToJump
						)
					)
				else
					(gMessager say: 0 10 14) ; "There's nowhere useful to jump to from here."
				)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if heading
			(heading dispose: 1)
		)
		(super dispose:)
	)
)

(instance theShore of Polygon
	(properties)

	(method (init)
		(super init: 163 96 241 75 265 79 319 74 319 150 274 135 217 106)
	)

	(method (dispose param1)
		(if (and argc param1)
			(super dispose:)
		)
	)
)

(instance roomPoly of Polygon
	(properties
		type PBarredAccess
	)

	(method (init)
		(super
			init: 215 103 232 124 309 143 308 156 272 156 282 162 319 162 319 189 0 189 0 0 220 0 220 81 179 92
		)
		(return self)
	)

	(method (dispose param1)
		(if (and argc param1)
			(super dispose:)
		)
	)
)

(instance egoTell of Teller
	(properties)
)

(instance splash of Prop ; UNUSED
	(properties
		signal 16384
	)
)

