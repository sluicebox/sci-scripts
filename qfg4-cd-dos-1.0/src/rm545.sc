;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 545)
(include sci.sh)
(use Main)
(use GloryRm)
(use TargFeature)
(use Swamp)
(use DeathIcon)
(use Scaler)
(use PolyPath)
(use Polygon)
(use StopWalk)
(use Timer)
(use Grooper)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm545 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0)
	(gGlory handsOff:)
	(if (not (IsFlag 390))
		((Timer new:) setReal: gCurRoom 15)
		(= local3 1)
	)
	(if (not (& (lChernovy signal:) $0008))
		(lChernovy x: (- (gEgo x:) 25) y: (gEgo y:))
	)
	(if (not (& (rChernovy signal:) $0008))
		(rChernovy x: (+ (gEgo x:) 25) y: (gEgo y:))
	)
	(SetFlag 390)
	(gGlory handsOn:)
)

(procedure (localproc_1)
	(gCurRoom
		topX: 162
		rightY: 125
		leftY: 131
		bottomX: 215
		addObstacle:
			((Polygon new:)
				type: PBarredAccess
				init: 122 100 118 109 60 109 50 100 87 94
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 175 111 176 123 114 123 112 114 142 109
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 261 132 262 150 171 151 171 136 216 130
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 319 189 233 189 233 166 245 153 319 153
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 136 140 129 146 62 146 62 133 90 124
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 0 154 74 159 111 153 200 167 205 189 130 189 65 189 2 189
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 319 147 269 147 265 130 319 128
				yourself:
			)
	)
)

(instance rm545 of GloryRm
	(properties
		picture 550
		horizon 100
		north 3
		east 4
		south 2
		west 1
	)

	(method (init)
		(self setRegions: 10) ; Swamp
		(super init: &rest)
		(leftTree init:)
		(rightTree init:)
		(bush1 init:)
		(bush2 init:)
		(bush3 init:)
		(bush4 init:)
		(rock1 init:)
		(reflectRock1 init:)
		(bush5 init:)
		(bush6 init:)
		(bush7 init:)
		(bush8 init:)
		(skeleton init:)
		(reflectSkeleton init:)
		(tombStone init:)
		((ScriptID 10 2) init:) ; reflection
		(if (!= gPrevRoomNum 810) ; combat
			(= global480 300)
			(= global481 300)
			(ClearFlag 369)
			(ClearFlag 370)
		)
		(gEgo solvePuzzle: 436 6)
		(if (and (== gPrevRoomNum 810) (== gCombatResult 1)) ; combat
			(EgoDead 3) ; "Overwhelmed by the power of the Chernovy Wizard's magic, you finally succumb and sink into the swamp."
		else
			(if (not (IsFlag 361))
				(if
					(or
						(OneOf gPrevRoomNum 541 542 543) ; swamp1, swamp2, swamp3
						(and
							(== gPrevRoomNum 810) ; combat
							(not (IsFlag 369))
							(> global480 0)
						)
					)
					(++ local0)
					(lChernovy
						setStep: 3 2
						x:
							(if (== gPrevRoomNum 810) ; combat
								global476
							else
								(lChernovy x:)
							)
						y:
							(if (== gPrevRoomNum 810) ; combat
								global477
							else
								(lChernovy y:)
							)
						loop: (if (< (gEgo y:) (lChernovy y:)) 6 else 0)
						setCycle: Fwd
						cycleSpeed: 8
						setScaler: Scaler 100 60 125 65
						setScript: sTakeTurns
						init:
					)
					(if (== gPrevRoomNum 810) ; combat
						(rChernovy init: hide:)
					)
				)
				(if
					(and
						(not (== gHeroType 2)) ; Thief
						(or
							(OneOf gPrevRoomNum 541 542 543) ; swamp1, swamp2, swamp3
							(and
								(== gPrevRoomNum 810) ; combat
								(> global481 0)
								(not (IsFlag 370))
							)
						)
					)
					(++ local0)
					(rChernovy
						setStep: 3 2
						x:
							(if (== gPrevRoomNum 810) ; combat
								global476
							else
								(rChernovy x:)
							)
						y:
							(if (== gPrevRoomNum 810) ; combat
								global477
							else
								(rChernovy y:)
							)
						setScaler: Scaler 100 60 125 65
						setCycle: Fwd
						cycleSpeed: 8
						loop: (if (< (gEgo y:) (lChernovy y:)) 7 else 1)
						init:
					)
					(if (== gPrevRoomNum 810) ; combat
						(lChernovy init: hide: setScript: sTakeTurns)
					)
				else
					(rChernovy hide:)
				)
			)
			(gWalkHandler add: gCurRoom)
			(switch gPrevRoomNum
				(810 ; combat
					(self setScript: sCombatEnter)
				)
				(543 ; swamp3
					(cond
						((and (< global107 320) (< global108 200))
							(self setScript: sFromWest)
						)
						((< global107 320)
							(self setScript: sFromNorth)
						)
						(else
							(self setScript: sFromWest)
						)
					)
				)
				(541 ; swamp1
					(cond
						((> global108 200)
							(self setScript: sFromNorth)
						)
						((< global107 0)
							(self setScript: sFromEast)
						)
						(else
							(self setScript: sFromWest)
						)
					)
				)
				(542 ; swamp2
					(cond
						((< global107 0)
							(self setScript: sFromEast)
						)
						((> global108 190)
							(self setScript: sFromNorth)
						)
						((and (> global107 320) (> global108 0))
							(self setScript: sFromWest)
						)
						(else
							(self setScript: sFromWest)
						)
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
		)
		(if (IsFlag 149)
			(gWalkHandler
				addToFront: bush8 bush1 bush2 bush3 bush4 bush5 bush6 bush7
			)
		)
		(if (!= gPrevRoomNum 810) ; combat
			(gGlory save: 1)
		)
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
					((== newRoomNumber 810) ; combat
						(SetFlag 378)
						810
					)
					((== newRoomNumber 1) 542)
					((and (== global349 1) (== global350 -1)) 535)
					((and (<= global349 0) (<= global350 0)) 530)
					((> global357 3) 530)
					(else
						(+ (mod (+ (- global349 global350) 2) 3) 541)
					)
				)
		)
	)

	(method (addObstacle param1)
		(switch param1
			(poly6
				(self rightY: 135)
			)
			(poly7
				(self topX: 100)
			)
			(polyStone
				(self leftY: 168)
			)
			(poly5
				(self bottomX: 150)
			)
		)
		(super addObstacle: param1 &rest)
	)

	(method (dispose)
		(if (IsFlag 149)
			(gWalkHandler delete: bush8 bush1 bush2 bush3 bush4 bush5 bush6 bush7)
		)
		(= global107 (gEgo x:))
		(= global108 (gEgo y:))
		(gWalkHandler delete: gCurRoom)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(if (>= (gEgo y:) 190)
					(gEgo setPri: -1)
				)
			)
			(11 ; glideSpell
				(cond
					((IsFlag 167)
						(gMessager say: 0 11 17) ; "Get up on some dry land first so you don't sink while you're casting the spell."
					)
					(local3
						(gMessager say: 6 6 16) ; "You can't see a thing through the spell-induced darkness."
					)
					(else
						(self setScript: sGlideFromTuff)
					)
				)
			)
			(91 ; jugglingLightsSpell
				(if local3
					(Palette 2 0 255 100) ; PalIntensity
					(= local3 0)
					(if (gCurRoom timer:)
						(timer dispose:)
						(= timer 0)
					)
				)
				(gCurRoom setScript: (ScriptID 62)) ; castJuggle
			)
			(83 ; dazzleSpell
				(if (and local3 (>= [gEgoStats 19] [global367 3])) ; mana
					(gCurRoom setScript: (ScriptID 12) 0 83) ; castAreaScript
					(Palette 2 0 255 100) ; PalIntensity
					(= local3 0)
					(if (gCurRoom timer:)
						(timer dispose:)
						(= timer 0)
					)
				)
			)
			(86 ; flameDartSpell
				(gCurRoom setScript: (ScriptID 32 0) 0 theVerb) ; project
			)
			(88 ; forceBoltSpell
				(gCurRoom setScript: (ScriptID 32 0) 0 theVerb) ; project
			)
			(93 ; lightningBallSpell
				(gCurRoom setScript: (ScriptID 32 0) 0 theVerb) ; project
			)
			(79 ; frostSpell
				(gCurRoom setScript: (ScriptID 32 0) 0 theVerb) ; project
			)
			(95 ; invisibleSpell
				(gEgo hide:)
			)
			(21 ; theRocks
				(cond
					((IsFlag 149)
						(gMessager say: 0 11 18) ; "You need to get to some dry land before trying to throw a rock."
						(return 1)
					)
					((IsFlag 167)
						(gMessager say: 6 6 18) ; "You are unable to throw a rock while mired in this muck."
					)
					(else
						(gCurRoom setScript: (ScriptID 32 0) 0 theVerb) ; project
					)
				)
			)
			(10 ; Jump
				(if local3
					(gMessager say: 6 6 16) ; "You can't see a thing through the spell-induced darkness."
				else
					((ScriptID 10) doVerb: theVerb) ; Swamp
				)
			)
			(else
				((ScriptID 10) doVerb: theVerb) ; Swamp
			)
		)
	)

	(method (notify param1)
		(if (and argc (not (gCurRoom script:)) (== param1 -2))
			(gCurRoom setScript: (ScriptID 10 5)) ; sEgoDrownGlide
		else
			(localproc_1)
		)
	)

	(method (cue)
		(if local3
			(= local3 0)
			(Palette 2 0 255 100) ; PalIntensity
		)
	)
)

(instance sCombatEnter of Script
	(properties)

	(method (changeState newState &tmp [temp0 3])
		(switch (= state newState)
			(0
				(if (or (IsFlag 167) (IsFlag 149))
					(localproc_1)
					(if (IsFlag 149)
						(gEgo
							init:
							setScaler: Scaler 100 60 125 65
							setLoop: -1
							setLoop: Grooper
							setCycle: Walk
							loop: 2
							view: 5
						)
					else
						(gEgo
							init:
							scaleSignal: 4
							setScaler: Scaler 100 60 125 65
							moveSpeed: 12
							cycleSpeed: 6
							changeGait: -1 0
							setCycle: StopWalk 538
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
					(gCurRoom addObstacle: (bush3 heading:))
					(gEgo
						x: (bush3 approachX:)
						y: (bush3 approachY:)
						init:
						setScaler: Scaler 100 60 125 65
						normalize: 2
					)
					(if (IsFlag 390)
						(localproc_0)
					)
				)
				(= cycles 3)
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

(instance sGlideFromTuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(|= global393 $0003)
				(if (and (< (gEgo x:) 80) (>= (gEgo y:) 170))
					(gEgo setMotion: PolyPath 80 170 self)
				else
					(= ticks 1)
				)
			)
			(1
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
				)
				(localproc_1)
				(SetFlag 149)
				(self setScript: (ScriptID 12) self) ; castAreaScript
			)
			(2
				(gEgo
					setLoop: -1
					setLoop: Grooper
					loop: 0
					setCycle: Walk
					view: 5
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 5) self
				)
			)
			(3
				(gWalkHandler
					addToFront: bush8 bush1 bush2 bush3 bush4 bush5 bush6 bush7
				)
				(gGlory handsOn:)
				(gTheIconBar disable: 5)
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
				(gGlory handsOff:)
				(if (or (IsFlag 167) (IsFlag 149))
					(localproc_1)
					(if (IsFlag 149)
						(gEgo
							x: 236
							y: 102
							init:
							normalize:
							setScaler: Scaler 100 60 125 65
							setLoop: -1
							setLoop: Grooper
							setCycle: Walk
							view: 5
							loop: 2
							setMotion: PolyPath 236 106 self
						)
					else
						(gEgo
							init:
							normalize:
							view: 536
							x: 236
							y: 102
							scaleSignal: 4
							setScaler: Scaler 100 60 125 65
							moveSpeed: 12
							cycleSpeed: 6
							changeGait: -1 0
							setCycle: StopWalk 538
							setMotion: PolyPath 236 106 self
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
					(gCurRoom addObstacle: (bush7 heading:))
					(gEgo
						x: (bush7 approachX:)
						y: (bush7 approachY:)
						init:
						setScaler: Scaler 100 60 125 65
						normalize: 2
					)
					(= cycles 2)
				)
			)
			(1
				(if (and (not (IsFlag 361)) (== gHeroType 3)) ; Paladin
					(gMessager say: 6 6 7) ; "You sense terrible danger here. There is a great evil about this place!"
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

(instance sFromEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (or (IsFlag 167) (IsFlag 149))
					(localproc_1)
					(if (IsFlag 149)
						(gEgo
							x: 310
							y: 135
							init:
							normalize:
							setLoop: -1
							setLoop: Grooper
							setCycle: Walk
							view: 5
							loop: 1
							setMotion: PolyPath 300 135 self
						)
					else
						(gEgo
							init:
							normalize:
							view: 536
							x: 310
							y: 135
							scaleSignal: 4
							setScaler: Scaler 100 60 125 65
							moveSpeed: 12
							cycleSpeed: 6
							changeGait: -1 0
							setCycle: StopWalk 538
							setMotion: PolyPath 300 135 self
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
					(gCurRoom addObstacle: (bush6 heading:))
					(gEgo
						x: 310
						y: (bush6 approachY:)
						init:
						setScaler: Scaler 100 60 125 65
						normalize: 1
						setMotion: PolyPath 300 (bush6 approachY:) self
					)
				)
			)
			(1
				(if (and (not (IsFlag 361)) (== gHeroType 3)) ; Paladin
					(gMessager say: 6 6 7) ; "You sense terrible danger here. There is a great evil about this place!"
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
				(if (or (IsFlag 167) (IsFlag 149))
					(localproc_1)
					(if (IsFlag 149)
						(gEgo
							x: -10
							y: 135
							init:
							normalize:
							setScaler: Scaler 100 60 125 65
							setLoop: -1
							setLoop: Grooper
							setCycle: Walk
							view: 5
							loop: 0
							setMotion: PolyPath 20 135 self
						)
					else
						(gEgo
							init:
							normalize:
							view: 536
							x: -10
							y: 135
							scaleSignal: 4
							setScaler: Scaler 100 60 125 65
							moveSpeed: 12
							cycleSpeed: 6
							changeGait: -1 0
							setCycle: StopWalk 538
							setMotion: PolyPath 20 135 self
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
					(gCurRoom addObstacle: (bush8 heading:))
					(gEgo
						x: 10
						y: (bush8 approachY:)
						init:
						normalize: 0
						setScaler: Scaler 100 60 125 65
						setMotion: PolyPath 20 (bush8 approachY:) self
					)
				)
			)
			(1
				(if (and (not (IsFlag 361)) (== gHeroType 3)) ; Paladin
					(gMessager say: 6 6 7) ; "You sense terrible danger here. There is a great evil about this place!"
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

(instance sShowPuzzle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 4 43 5 0 self) ; "The Dark One Sign clicks into the depression in the stone. You find that you can now turn the Sign like a dial."
			)
			(1
				((ScriptID 85 0) init: show: dispose:) ; tomb
				(DisposeScript 85)
				(= cycles 1)
			)
			(2
				(if (IsFlag 361)
					(gMessager say: 6 6 9 0 self) ; "Finally you feel the Dark One Sign settle. You pull on it, opening the Tomb, and retrieve a damp but readable scroll from its depths. It is the Dark One's Bone Ritual."
					(gEgo solvePuzzle: 437 2 get: 52) ; theBoneRit
				else
					(gGlory handsOn:)
					(self dispose:)
				)
			)
			(3
				(gMessager say: 6 6 8 0 self) ; "You retrieve the Dark One Sign from the monolith."
			)
			(4
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTakeTurns of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 60)
			)
			(1
				(if
					(and
						(not (== (lChernovy view:) 842))
						(not (& (lChernovy signal:) $0008))
					)
					(if (< (gEgo y:) (lChernovy y:))
						(lChernovy setCel: 0 setCycle: 0 setLoop: 12 1)
					else
						(lChernovy setCel: 0 setCycle: 0 setLoop: 8 1)
					)
					(= cycles 6)
				else
					(= cycles 1)
				)
			)
			(2
				(if
					(and
						(not (== (lChernovy view:) 842))
						(not (& (lChernovy signal:) $0008))
					)
					(ChernovySpell init: lChernovy)
					(FrameOut)
				else
					(= ticks 1)
				)
			)
			(3
				(if
					(and
						(not (== (lChernovy view:) 842))
						(not (& (lChernovy signal:) $0008))
					)
					(if (< (gEgo y:) (lChernovy y:))
						(lChernovy setLoop: 6 setCycle: Fwd)
					else
						(lChernovy setLoop: 0 setCycle: Fwd)
					)
				)
				(= cycles 60)
			)
			(4
				(if
					(and
						(not (== (rChernovy view:) 842))
						(not (& (rChernovy signal:) $0008))
					)
					(if (< (gEgo y:) (lChernovy y:))
						(rChernovy setCel: 0 setLoop: 13 1 setCycle: 0)
					else
						(rChernovy setCel: 0 setLoop: 9 1 setCycle: 0)
					)
					(= cycles 6)
				else
					(= cycles 1)
				)
			)
			(5
				(if
					(and
						(not (== (rChernovy view:) 842))
						(not (& (rChernovy signal:) $0008))
					)
					(ChernovySpell init: rChernovy)
					(FrameOut)
				else
					(= ticks 1)
				)
			)
			(6
				(if
					(and
						(not (== (rChernovy view:) 842))
						(not (& (rChernovy signal:) $0008))
					)
					(if (< (gEgo y:) (lChernovy y:))
						(rChernovy setLoop: 7 setCycle: Fwd)
					else
						(rChernovy setLoop: 1 setCycle: Fwd)
					)
				)
				(self changeState: 0)
			)
		)
	)
)

(instance sCheckLoop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setLoop: 14 setMotion: 0 setCycle: End self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance tombStone of View
	(properties
		noun 4
		x 6
		y 90
		priority 165
		fixPriority 1
		view 550
		cel 6
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(43 ; theDarksign
				(cond
					((not (bush8 onMe: (gEgo x:) (gEgo y:)))
						(gMessager say: 4 4 2) ; "You are too far from the tomb to do anything to it."
					)
					(local0
						(gMessager say: 4 4 3) ; "You can't do anything with the monolith as long as the Chernovy are guarding it. You'll need to deal with them first."
					)
					((IsFlag 437)
						(gMessager say: 4 43 4) ; "You already have the Ritual; there is nothing else you can do with the monolith."
					)
					(else
						(gCurRoom setScript: sShowPuzzle)
					)
				)
			)
			(1 ; Look
				(super doVerb: theVerb)
			)
			(2 ; Talk
				(super doVerb: theVerb)
			)
			(3 ; Walk
				(super doVerb: theVerb)
			)
			(else
				(cond
					((not (bush8 onMe: (gEgo x:) (gEgo y:)))
						(gMessager say: 4 4 2) ; "You are too far from the tomb to do anything to it."
					)
					(local0
						(gMessager say: 4 4 3) ; "You can't do anything with the monolith as long as the Chernovy are guarding it. You'll need to deal with them first."
					)
					((IsFlag 361)
						(gMessager say: 4 43 4) ; "You already have the Ritual; there is nothing else you can do with the monolith."
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
		)
	)
)

(instance bush8 of SwampView
	(properties
		approachX 80
		approachY 170
		x 38
		y 187
		view 550
		cel 5
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(= heading (polyStone init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x y
			priority: (bush8 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance polyStone of SwampPoly
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
				173
				51
				180
				92
				171
				90
				166
				48
				172
				0
				165
		)
		(return self)
	)
)

(instance bush1 of SwampView
	(properties
		approachX 283
		approachY 178
		x 279
		y 188
		view 550
		loop 2
		cel 3
		signal 16384
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
			priority: (bush1 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance poly1 of SwampPoly
	(properties)

	(method (init)
		(super init: 283 182 297 178 285 173 267 176)
		(return self)
	)
)

(instance bush2 of SwampView
	(properties
		approachX 230
		approachY 131
		x 215
		y 147
		view 550
		loop 3
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(= heading (poly2 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 11)
			priority: (bush2 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance poly2 of SwampPoly
	(properties)

	(method (init)
		(super init: 249 132 229 127 206 134 228 137)
		(return self)
	)
)

(instance bush3 of SwampView
	(properties
		approachX 147
		approachY 113
		x 146
		y 122
		view 550
		loop 3
		cel 5
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(= heading (poly3 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 8)
			priority: (bush3 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance poly3 of SwampPoly
	(properties)

	(method (init)
		(super init: 162 114 145 109 126 112 143 117)
		(return self)
	)
)

(instance bush4 of SwampView
	(properties
		approachX 92
		approachY 130
		x 87
		y 142
		view 550
		loop 3
		cel 2
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(= heading (poly4 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 16)
			priority: (bush4 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance poly4 of SwampPoly
	(properties)

	(method (init)
		(super init: 108 132 92 127 71 132 89 136)
		(return self)
	)
)

(instance bush5 of SwampView
	(properties
		approachX 168
		approachY 181
		x 153
		y 190
		view 550
		loop 3
		signal 16384
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
			priority: (bush5 priority:)
			fixPriority: 1
			signal: 20480
			init:
		)
	)
)

(instance poly5 of SwampPoly
	(properties
		type 2
	)

	(method (init)
		(super
			init:
				138
				178
				138
				184
				144
				184
				144
				189
				0
				189
				0
				0
				319
				0
				319
				189
				154
				189
				154
				184
				186
				184
				186
				178
		)
		(return self)
	)
)

(instance bush6 of SwampView
	(properties
		approachX 300
		approachY 135
		x 319
		y 145
		view 550
		loop 3
		cel 6
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(= heading (poly6 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 11)
			priority: (bush6 priority:)
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
		(super init: 319 130 290 130 290 138 319 138 319 189 0 189 0 0 319 0)
		(return self)
	)
)

(instance bush7 of SwampView
	(properties
		approachX 93
		approachY 98
		x 90
		y 107
		view 550
		loop 3
		cel 5
		signal 16384
	)

	(method (init)
		(super init: &rest)
		(= heading (poly7 init:))
		(= extra (View new:))
		(extra
			view: view
			loop: (+ loop 4)
			cel: cel
			posn: x (+ y 8)
			priority: (bush7 priority:)
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
		(super
			init:
				86
				95
				70
				95
				70
				100
				106
				100
				106
				95
				93
				95
				93
				85
				319
				85
				319
				189
				0
				189
				0
				85
				86
				85
		)
		(return self)
	)
)

(instance skeleton of View
	(properties
		x 308
		y 162
		view 550
		loop 1
		cel 3
		signal 20480
	)
)

(instance reflectSkeleton of View
	(properties
		x 308
		y 175
		view 550
		loop 5
		cel 3
		signal 20480
	)
)

(instance rock1 of View
	(properties
		x 118
		y 146
		view 550
		loop 2
		cel 4
		signal 20480
	)

	(method (doVerb theVerb)
		(bush4 doVerb: theVerb)
	)
)

(instance reflectRock1 of View
	(properties
		x 118
		y 146
		view 550
		loop 6
		cel 4
		signal 20480
	)
)

(instance leftTree of View
	(properties
		y 81
		view 550
		signal 20480
	)
)

(instance rightTree of View
	(properties
		x 319
		y 65
		view 550
		cel 1
		signal 20480
	)
)

(instance lChernovy of TargActor
	(properties
		noun 7
		x 60
		y 175
		z 10
		view 840
		signal 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 79) ; frostSpell
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)

	(method (cue)
		(-- local0)
		(self hide:)
	)

	(method (getHurt param1 param2)
		(if (and (== param1 90) (> (++ local2) 1))
			(Palette 2 0 85 0) ; PalIntensity
			(Palette 2 112 255 0) ; PalIntensity
			(lChernovy setScript: 0)
			(localproc_0)
		)
		(if (== param1 21)
			(-= global481 param2)
		else
			(-= global480 (/ (* param2 70) 100))
		)
		(if (and (not (== view 842)) (not (& signal $0008)) (<= global480 0))
			(self view: 842 setLoop: 0 1 setCel: 0 z: -18 setCycle: CT 6 1 self)
		)
	)

	(method (doit &tmp temp0)
		(if
			(and
				(not (& signal $0800))
				(not (== loop 6))
				(not (== loop 12))
				(< (gEgo y:) (self y:))
			)
			(self setLoop: 6)
		)
		(if
			(and
				(not (& signal $0800))
				(not (== loop 0))
				(not (== loop 8))
				(>= (gEgo y:) (self y:))
			)
			(self setLoop: 0)
		)
		(cond
			((== (gCurRoom script:) (ScriptID 62)) 0) ; castJuggle
			((== (gCurRoom script:) (ScriptID 12)) 0) ; castAreaScript
			(
				(and
					(not local4)
					(not local3)
					(> global481 0)
					(not (IsFlag 369))
					(not (& signal $0008))
					(<= (gEgo distanceTo: self) 30)
				)
				(= local4 1)
				(= gCombatMonsterNum 840) ; chernovy
				(= global156 global481)
				(SetFlag 369)
				(= global476 (rChernovy x:))
				(= global477 (rChernovy y:))
				(gCurRoom newRoom: 810) ; combat
			)
		)
		(super doit: &rest)
	)
)

(instance rChernovy of TargActor
	(properties
		noun 7
		x 290
		y 175
		z 10
		view 840
		loop 1
		signal 1
	)

	(method (doVerb theVerb)
		(if (== theVerb 79) ; frostSpell
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)

	(method (cue)
		(-- local0)
		(self hide:)
	)

	(method (getHurt param1 param2)
		(if (and (== param1 90) (> (++ local2) 1))
			(Palette 2 0 85 0) ; PalIntensity
			(Palette 2 112 255 0) ; PalIntensity
			(lChernovy setScript: 0)
			(localproc_0)
		)
		(if (== param1 21)
			(-= global481 param2)
		else
			(-= global481 (/ (* param2 70) 100))
		)
		(if (and (not (== view 842)) (not (& signal $0008)) (<= global481 0))
			(self view: 842 setLoop: 1 1 z: -18 setCel: 0 setCycle: CT 6 1 self)
		)
	)

	(method (doit)
		(if
			(and
				(not (& signal $0800))
				(not (== loop 7))
				(not (== loop 13))
				(< (gEgo y:) (self y:))
			)
			(self setLoop: 7)
		)
		(if
			(and
				(not (& signal $0800))
				(not (== loop 1))
				(not (== loop 9))
				(>= (gEgo y:) (self y:))
			)
			(self setLoop: 1)
		)
		(cond
			((== (gCurRoom script:) (ScriptID 62)) 0) ; castJuggle
			((== (gCurRoom script:) (ScriptID 12)) 0) ; castAreaScript
			(
				(and
					(not local4)
					(not local3)
					(> global481 0)
					(not (IsFlag 370))
					(not (& signal $0008))
					(<= (gEgo distanceTo: self) 30)
				)
				(= local4 1)
				(= gCombatMonsterNum 840) ; chernovy
				(= global156 global481)
				(SetFlag 370)
				(= global476 (lChernovy x:))
				(= global477 (lChernovy y:))
				(gCurRoom newRoom: 810) ; combat
			)
		)
		(super doit: &rest)
	)
)

(class ChernovySpell of Actor
	(properties
		priority 190
		fixPriority 1
		view 21
		signal 24577
		cuedOnce 0
		curDamage 23
	)

	(method (cue &tmp temp0 temp1 temp2)
		(= temp2
			(/
				(*
					(= temp0 (/ (* 100 (gEgo scaleY:)) (gEgo maxScale:)))
					(CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				100
			)
		)
		(= temp1
			(/
				(*
					temp0
					(CelWide (gEgo view:) (gEgo loop:) (gEgo cel:))
				)
				200
			)
		)
		(if (not cuedOnce)
			(sTakeTurns cue:)
			(if
				(and
					(<= (- (gEgo y:) temp2) (self y:) (gEgo y:))
					(<= (- (gEgo x:) temp1) (self x:) (+ (gEgo x:) temp1))
					(IsFlag 8)
				)
				(if (& (gEgo signal:) $0008)
					(gEgo show:)
					(gMessager say: 6 6 11) ; "Evidently the Chernovy's magic is so powerful that they could see you despite your Invisibility spell. In any case, the attack has now broken your spell."
				)
				(revSpell init: local1 self)
				(= cuedOnce 1)
				(self cue:)
			else
				(self setScript: (sCheckLoop new:) self)
				(= cuedOnce 1)
			)
		else
			(if
				(and
					(<= (- (gEgo y:) temp2) (self y:) (gEgo y:))
					(<= (- (gEgo x:) temp1) (self x:) (+ (gEgo x:) temp1))
				)
				(if (not (IsFlag 8))
					(gEgo takeDamage: curDamage)
				)
				(if (& (gEgo signal:) $0008)
					(gEgo show:)
					(gMessager say: 6 6 11) ; "Evidently the Chernovy's magic is so powerful that they could see you despite your Invisibility spell. In any case, the attack has now broken your spell."
				)
				(if (<= [gEgoStats 17] 0) ; health
					(EgoDead 3) ; "Overwhelmed by the power of the Chernovy Wizard's magic, you finally succumb and sink into the swamp."
				)
			)
			(self dispose:)
		)
	)

	(method (init param1 &tmp temp0)
		(if (< (Random 0 100) 26)
			(= temp0 (- 100 (Random 20 50)))
		else
			(= temp0 0)
		)
		(self
			cuedOnce: 0
			x:
				(+
					(param1 x:)
					(cond
						((== param1 lChernovy)
							(if (== (param1 loop:) 12) 15 else 40)
						)
						((== (param1 loop:) 13) -15)
						(else -40)
					)
				)
			y:
				(-
					(param1 y:)
					(if (or (== (param1 loop:) 12) (== (param1 loop:) 13))
						57
					else
						37
					)
				)
			setStep: 8 5
			setLoop: 4 1
			moveSpeed: 0
			setScaler: Scaler 100 60 125 65
			setCycle: Fwd
			setMotion: MoveTo (+ (gEgo x:) temp0) (- (gEgo y:) 25) self
		)
		(super init:)
		(= local1 param1)
	)
)

(class revSpell of Actor
	(properties
		priority 190
		fixPriority 1
		view 21
		signal 24577
		cuedOnce 0
		curDamage 23
	)

	(method (cue)
		(if (not cuedOnce)
			(= cuedOnce 1)
			(local1 getHurt: 90 curDamage)
			(self setScript: (sCheckLoop new:) self)
		else
			(self dispose:)
		)
	)

	(method (init param1 param2)
		(self
			cuedOnce: 0
			x: (param2 x:)
			y: (param2 y:)
			setStep: 8 5
			setLoop: 4 1
			moveSpeed: 0
			setScaler: Scaler 100 60 125 65
			setCycle: Fwd
			setMotion: MoveTo (param1 x:) (- (param1 y:) 25) self
		)
		(super init:)
	)
)

(instance qReverseFX of Sound ; UNUSED
	(properties)
)

