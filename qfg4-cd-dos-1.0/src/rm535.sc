;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 535)
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
(use Rev)
(use Grooper)
(use Motion)
(use Actor)
(use System)

(public
	rm535 0
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
		addObstacle:
			((Polygon new:)
				type: PBarredAccess
				init: 0 99 33 100 42 112 41 119 0 124
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 9 138 57 125 88 135 87 147 55 153 13 158
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 99 146 128 139 174 150 174 163 125 163 100 156
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 99 123 155 123 155 133 132 135 115 139 94 138
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 151 101 164 86 0 86 0 0 319 0 319 173 292 167 253 165 256 171 226 176 192 166 205 150 249 154 279 139 249 133 234 146 203 144 169 136 168 126 188 119 187 116 172 118 165 123 151 120
				yourself:
			)
			((Polygon new:) type: PBarredAccess init: 0 189 0 177 120 177 122 189 yourself:)
	)
)

(instance rm535 of GloryRm
	(properties
		picture 530
		horizon 78
		north 562
		east 800
		south 543
		west 541
		topX 238
		rightY 120
	)

	(method (newRoom newRoomNumber)
		(= global357 0)
		(switch newRoomNumber
			(541 ; swamp1
				(= global349 1)
				(= global350 0)
			)
			(543 ; swamp3
				(= global349 2)
				(= global350 -1)
			)
		)
		(super newRoom: newRoomNumber)
	)

	(method (init)
		(self setRegions: 10) ; Swamp
		(super init: &rest)
		(tree approachVerbs: 4 init:) ; Do
		(atp1 init:)
		(atp2 init:)
		(atp3 init:)
		(atp4 init:)
		(atp6 init:)
		(atp8 init:)
		(atp9 init:)
		(atp10 init:)
		(atp11 init:)
		(atp12 init:)
		(gWalkHandler add: self)
		(theWater init:)
		(theShore init:)
		(fWater init:)
		(fShore init:)
		(aDoorMat init:)
		(RemapColors 4 253 100 200) ; ToPercentGray
		(if (and gNight (not (IsFlag 459)) (not (gEgo has: 41))) ; theWillowisp
			(egoTell init: gEgo 535 11 128 10)
		)
		((ScriptID 10 2) init:) ; reflection
		(switch gPrevRoomNum
			(800
				(self setScript: sFromEast)
			)
			(562
				(self setScript: sFromNorth)
			)
			(541 ; swamp1
				(self setScript: sFromWest)
			)
			(543 ; swamp3
				(self setScript: sFromSouth)
			)
			(else
				(gCurRoom addObstacle: (fShore heading:))
				(gEgo
					x: 260
					y: 122
					init:
					normalize:
					setScaler: Scaler 100 60 125 65
				)
				(gGlory handsOn:)
			)
		)
		(if (IsFlag 149)
			(gWalkHandler addToFront: atp1 atp2 atp6 atp10 atp11 atp12 fShore)
			(= gFShore fShore)
		)
		(gGlory save: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21 ; theRocks
				(if (not (IsFlag 167))
					(gCurRoom setScript: (ScriptID 32) 0 21) ; project
				)
			)
			(11 ; glideSpell
				(cond
					((fShore onMe: gEgo)
						(self setScript: sGoGlide)
					)
					((IsFlag 167)
						(gMessager say: 0 11 14) ; "Get up on some dry land first so you don't sink while you're casting the spell."
					)
					(else
						(self setScript: sGlideFromTuff)
					)
				)
			)
			(23 ; theCandy
				(cond
					((IsFlag 167)
						(gMessager say: 0 23 14) ; "Try doing that from the shore."
					)
					((IsFlag 149)
						(gMessager say: 0 23 21) ; "You're busy focusing on your Glide spell."
					)
					((not (theShore onMe: (gEgo x:) (gEgo y:)))
						(gMessager say: 0 23 20) ; "Try doing that from the shore."
					)
					(else
						(self setScript: (ScriptID 10 1)) ; sDownCandy
					)
				)
			)
			(3 ; Walk
				(if (>= (gEgo y:) 181)
					(gEgo setPri: -1)
					(super doVerb: theVerb)
				else
					(super doVerb: theVerb)
				)
			)
			(1 ; Look
				(gMessager say: 1 1 0) ; "The heavy odor of decay overwhelms your senses and makes you feel slightly nauseated as you survey this gloomy swamp."
			)
			(91 ; jugglingLightsSpell
				(if (IsFlag 167)
					(gMessager say: 0 11 14) ; "Get up on some dry land first so you don't sink while you're casting the spell."
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
			(cond
				((and (OneOf (gEgo view:) 0 1 2 5) (not (IsFlag 149)))
					(self setScript: sDownWater)
				)
				((IsFlag 167)
					(self setScript: sUpWater)
				)
			)
		)
	)

	(method (addObstacle param1)
		(switch param1
			(poly12
				(self bottomX: 83)
			)
			(poly2
				(self leftY: 114)
			)
		)
		(super addObstacle: param1 &rest)
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
			(gWalkHandler delete: atp1 atp2 atp6 atp10 atp11 atp12 fShore)
			(= gFShore 0)
		)
		(= global107 (gEgo x:))
		(= global108 (gEgo y:))
		(theWater dispose: 1)
		(theShore dispose: 1)
		(egoTell dispose:)
		(aDoorMat dispose:)
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
					loop: 0
					setCycle: Walk
					view: 5
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 5) self
				)
			)
			(2
				(gWalkHandler addToFront: atp1 atp2 atp6 atp10 atp11 atp12 fShore)
				(= gFShore fShore)
				(gGlory handsOn:)
				(gTheIconBar disable: 5)
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
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
				)
				(gEgo setMotion: MoveTo 241 148 self)
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
					loop: 1
					setCycle: Walk
					view: 5
				)
				(gMessager say: 8 6 29 0 self) ; "As you start to Glide, you realize the only way to get back up to the dry areas will be to grab hold of something and pull yourself up."
			)
			(3
				(gWalkHandler addToFront: atp1 atp2 atp6 atp10 atp11 atp12 fShore)
				(= gFShore fShore)
				(gGlory handsOn:)
				(gTheIconBar disable: 5)
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
				(|= global393 $0003)
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
				(gCurRoom east: 0)
				(SetFlag 167)
				(SetFlag 15)
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 99 33 100 42 112 41 119 0 124
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 9 138 57 125 88 135 87 147 55 153 13 158
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 99 146 128 139 174 150 174 163 125 163 100 156
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 101 130 112 122 128 124 155 123 155 133 132 135 115 139 97 136
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 151 101 164 86 0 86 0 0 319 0 319 173 292 167 253 165 256 171 226 176 192 166 205 150 249 154 279 139 249 133 234 146 203 144 169 136 168 126 188 119 187 116 172 118 165 123 151 120
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 0 189 0 177 120 177 122 189
							yourself:
						)
				)
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
						(gMessager say: 8 6 3) ; "You aren't strong enough to maneuver through this mucky moor yet. You'll need to build up your leg muscles a bit before you can get anywhere in this swamp."
					else
						(gMessager say: 8 6 4) ; "As you find yourself sucked into the thick muck, you realize you are never going to be able to move in the swamp this way."
					)
					(SetFlag 359)
				)
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
					(gCurRoom addObstacle: (atp2 heading:))
					(gEgo
						x: -5
						y: (atp2 approachY:)
						init:
						normalize:
						setScaler: Scaler 100 60 125 65
						setMotion:
							PolyPath
							(atp2 approachX:)
							(atp2 approachY:)
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
					(gCurRoom addObstacle: (atp1 heading:))
					(gEgo
						x: (atp1 approachX:)
						y: (atp1 approachY:)
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
				(if (and (== gHeroType 3) (not (IsFlag 393))) ; Paladin
					(SetFlag 393)
					(gMessager say: 8 6 27 0 self) ; "Your "Danger Sense" tingles. You sense deadly danger from the swamp. It might have something to do with the grasping, disembodied arms."
				else
					(= ticks 1)
				)
			)
			(2
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

(instance sClimbTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo
					setPri: (+ (gEgo priority:) 1)
					setScale:
					setMotion: MoveTo 294 153 self
				)
			)
			(1
				(gEgo
					view: 7
					setCel: 0
					setLooper: 0
					setLoop: 3 1
					setCycle: Fwd
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 70) self
				)
			)
			(2
				(gMessager say: 2 4 9 0 self) ; "You can see the desolate, distorted landscape and sodden, sullen swamp swallowed by the engulfing murkiness."
			)
			(3
				(gEgo
					setCycle: Rev
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 70) self
				)
			)
			(4
				(gEgo
					normalize:
					setScaler: Scaler 100 60 125 65
					setMotion: MoveTo 311 150 self
				)
			)
			(5
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
				(ClearFlag 167)
				(gWalkHandler delete: gCurRoom)
				(gEgo setMotion: PolyPath 253 144 self)
			)
			(1
				(if (IsFlag 149)
					(gWalkHandler delete: atp1 atp2 atp6 atp10 atp11 atp12 fShore)
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
				(gCurRoom north: 562)
				(gCurRoom east: 800)
				(ClearFlag 359)
				(ClearFlag 15)
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
					(gCurRoom addObstacle: (fShore heading:))
				)
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

(instance atp1 of SwampView
	(properties
		noun 12
		approachX 227
		approachY 162
		x 257
		y 166
		view 530
		loop 1
		cel 1
	)

	(method (init)
		(super init: &rest)
		(if (not heading)
			(= heading (poly1 init:))
		)
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 7)
			priority: (atp1 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance poly1 of SwampPoly
	(properties)

	(method (init)
		(super init: 210 168 241 168 246 161 283 161 283 158 245 154 209 164)
		(return self)
	)
)

(instance atp2 of SwampView
	(properties
		noun 12
		approachX 28
		approachY 114
		x 10
		y 120
		view 530
		loop 2
		cel 2
	)

	(method (init)
		(super init: &rest)
		(if (not heading)
			(= heading (poly2 init:))
		)
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 16)
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
		(super init: 0 0 319 0 319 189 0 189 0 116 31 116 31 111 0 111)
		(return self)
	)
)

(instance atp6 of SwampView
	(properties
		noun 12
		approachX 202
		approachY 132
		x 205
		y 139
		view 530
		loop 1
	)

	(method (init)
		(super init: &rest)
		(if (not heading)
			(= heading (poly6 init:))
		)
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
	(properties)

	(method (init)
		(super init: 185 133 225 140 225 135 187 129)
		(return self)
	)
)

(instance atp10 of SwampView
	(properties
		noun 12
		approachX 133
		approachY 152
		x 135
		y 158
		view 530
		loop 1
	)

	(method (init)
		(super init: &rest)
		(if (not heading)
			(= heading (poly10 init:))
		)
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 13)
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
		(super init: 116 149 162 155 162 159 114 153)
		(return self)
	)
)

(instance atp11 of SwampView
	(properties
		noun 12
		approachX 49
		approachY 141
		x 53
		y 148
		view 530
		loop 2
	)

	(method (init)
		(super init: &rest)
		(if (not heading)
			(= heading (poly11 init:))
		)
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 13)
			priority: (atp11 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance poly11 of SwampPoly
	(properties)

	(method (init)
		(super init: 25 149 74 142 74 138 60 136 24 145)
		(return self)
	)
)

(instance atp12 of SwampView
	(properties
		noun 12
		approachX 86
		approachY 181
		x 86
		y 190
		view 530
		loop 2
		cel 2
	)

	(method (init)
		(super init: &rest)
		(if (not heading)
			(= heading (poly12 init:))
		)
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 13)
			priority: (atp12 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance poly12 of SwampPoly
	(properties
		type 2
	)

	(method (init)
		(super init: 0 0 319 0 319 192 93 192 93 181 74 181 74 192 0 192)
		(return self)
	)
)

(instance atp3 of View
	(properties
		noun 12
		x 305
		y 189
		view 530
		loop 2
		cel 3
		signal 16384
	)
)

(instance atp4 of View
	(properties
		noun 12
		x 8
		y 189
		view 530
		loop 2
		cel 3
		signal 16384
	)
)

(instance atp8 of View
	(properties
		noun 7
		approachX 118
		approachY 137
		x 120
		y 134
		view 530
		loop 2
		cel 5
		signal 16384
	)
)

(instance atp9 of View
	(properties
		noun 12
		x 219
		y 90
		view 530
		loop 2
		cel 4
		signal 16384
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

(instance fWater of Feature
	(properties
		y 10
	)

	(method (init)
		(= onMeCheck theWater)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (self onMe: (gEgo x:) (gEgo y:)))
					(gCurRoom setScript: sDownWater)
				else
					((ScriptID 10) doVerb: theVerb) ; Swamp
				)
			)
			(else
				((ScriptID 10) doVerb: theVerb) ; Swamp
			)
		)
	)
)

(instance tree of Feature
	(properties
		noun 2
		nsLeft 287
		nsTop 65
		nsRight 299
		nsBottom 146
		sightAngle 40
		approachX 311
		approachY 150
		x 290
		y 153
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (== ((gCurRoom obstacles:) at: 0) (fShore heading:))
				(if (== (gEgo trySkill: 11 100) 1) ; climbing
					(gEgo setScript: sClimbTree)
				else
					(gMessager say: 2 4 10) ; "You're still not very experienced at climbing. Keep practicing and you'll get better at it."
				)
			else
				(gMessager say: 2 4 13) ; "You are too far away to do anything with the tree."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fShore of Feature
	(properties
		approachX 269
		approachY 122
		x 269
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
						(gMessager say: 0 10 14) ; "The muck doesn't give you enough support to make a decent jump. Walk up onto a dry area first."
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
							(gCurRoom setScript: (ScriptID 10 4) 0 self) ; sJumpWater
						else
							(gCurRoom setScript: (ScriptID 10 3) 0 self) ; sToJump
						)
					)
				else
					(gMessager say: 0 10 16) ; "There's nowhere useful to jump to from here."
				)
			)
			(24 ; theFlask
				(super doVerb: theVerb)
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

(instance roomPoly of SwampPoly
	(properties
		type 2
	)

	(method (init)
		(super
			init:
				215
				103
				232
				124
				284
				144
				300
				144
				319
				156
				319
				189
				0
				189
				0
				0
				220
				0
				220
				81
				179
				92
		)
		(return self)
	)
)

(instance theShore of Polygon
	(properties)

	(method (init)
		(super init: 163 96 241 75 265 79 319 74 319 162 274 135 220 120)
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

