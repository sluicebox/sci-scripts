;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 570)
(include sci.sh)
(use Main)
(use GloryRm)
(use TargFeature)
(use DeathIcon)
(use forest)
(use PolyPath)
(use Polygon)
(use Jump)
(use Motion)
(use Actor)
(use System)

(public
	rm570 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
)

(instance rm570 of GloryRm
	(properties
		picture 420
		horizon 70
		north 569
		east 574
		topX 174
		rightY 136
	)

	(method (init)
		(= local6 0)
		(= local0 49)
		(= local1 134)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 76 179 130 179 153 167 181 167 190 160 240 160 279 142 319 142 319 189 0 189 0 0 154 0 154 72 178 83 158 103 117 103 97 96 70 96 50 86 31 86 31 93 65 114 130 114 130 128 55 128 55 143 95 143 95 150 48 154
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 0 319 131 301 131 219 115 239 105 213 98 169 105 195 79 195 0
					yourself:
				)
		)
		(stalk cel: (stalk lastCel:) init:)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(gCurRoom
			addPoly:
				((Polygon new:)
					init: 32 132 82 111 119 111 167 128 215 113 319 150 319 189 0 189
					yourself:
				)
				60
		)
		(atp1 init: setPri: 180)
		(atp2 init: setPri: 148)
		(atp3 init:)
		(atp4 init: setPri: 30)
		(bridge init: setPri: 116)
		(bush init: approachVerbs: 4) ; Do
		(stream1 setPri: 30 setCycle: Fwd init:)
		(stream2 setPri: 30 setCycle: Fwd init:)
		(stream3 setPri: 30 setCycle: Fwd init:)
		(stream4 setPri: 30 setCycle: Fwd init:)
		(streamMat init:)
		(if (== gHeroType 3) ; Paladin
			(gMessager say: 2 6 11) ; "There's something strange about this bush. Maybe it's the eyes. Oh, forget it -- it's probably just an ordinary, everyday bush with blood red berries and tentacle-like branches."
		)
		(if (or (IsFlag 380) (< [gEgoStats 17] 150)) ; health
			(gGlory save: 1)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(87 ; fetchSpell
				(gGlory handsOff:)
				(if (gCast contains: branch)
					(self setScript: (ScriptID 37) branch branch) ; castFetchScript
				else
					((ScriptID 50) doVerb: theVerb) ; forest
				)
			)
			(55 ; theChicken
				(gCurRoom setScript: sThrowChick)
			)
			(11 ; glideSpell
				(if (streamMat onMe: (gEgo x:) (gEgo y:))
					(gMessager say: 2 6 14) ; "The water is too shallow for this spell to work."
				else
					(gMessager say: 9 0 12) ; "The Glide spell only works on liquid; you can't cast it here."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(streamMat dispose:)
		(super dispose:)
	)
)

(instance atp1 of ForestView
	(properties
		x 4
		y 169
		view 422
	)
)

(instance atp2 of ForestView
	(properties
		x 4
		y 47
		view 423
	)
)

(instance atp3 of ForestView
	(properties
		x 229
		y 76
		view 424
		loop 2
		cel 1
	)
)

(instance atp4 of ForestView
	(properties
		x 121
		y 131
		view 424
		cel 3
	)
)

(instance bridge of ForestView
	(properties
		x 306
		y 148
		view 424
		cel 4
	)
)

(instance stream1 of ForestView
	(properties
		x 69
		y 73
		view 420
		loop 2
		signal 16385
		detailLevel 2
	)
)

(instance stream2 of ForestView
	(properties
		x 133
		y 102
		view 420
		loop 4
		signal 16385
		detailLevel 2
	)
)

(instance stream3 of ForestView
	(properties
		x 290
		y 126
		view 420
		loop 6
		signal 16385
		detailLevel 2
	)
)

(instance stream4 of ForestView
	(properties
		x 264
		y 188
		view 424
		loop 4
		signal 16385
		detailLevel 2
	)
)

(instance bush of TargActor
	(properties
		noun 3
		view 860
		signal 20480
	)

	(method (init)
		(self setPri: 115)
		(= x local0)
		(= y local1)
		(super init: &rest)
	)

	(method (getHurt param1)
		(cond
			((== param1 88)
				(if (and (stalk script:) (== ((stalk script:) state:) 0))
					((stalk script:) ticks: 0 cue:)
				)
				(bush setScript: sShakeLoose 0 param1)
			)
			((== param1 21)
				(if (and (stalk script:) (== ((stalk script:) state:) 0))
					((stalk script:) ticks: 0 cue:)
				)
				(bush setScript: sShakeLoose 0 param1)
			)
			((== param1 37)
				(if (and (stalk script:) (== ((stalk script:) state:) 0))
					((stalk script:) ticks: 0 cue:)
				)
				(bush setScript: sShakeLoose 0 param1)
			)
			((OneOf param1 86 93)
				(gMessager say: noun param1 0)
			)
		)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 87) (not local2)) ; fetchSpell
			(gMessager say: 3 87 8) ; "You try to Fetch some berries from the bush, but they seem to be firmly attached to branches."
			(return 1)
		)
		(return
			(if
				(or
					(not (Message msgSIZE 570 noun theVerb 0 1))
					(OneOf theVerb 86 88 93 21 37) ; flameDartSpell, forceBoltSpell, lightningBallSpell, theRocks, theThrowdagger
				)
				(if (OneOf theVerb 21 37) ; theRocks, theThrowdagger
					(stalk setScript: sPeek)
				)
				((ScriptID 50) doVerb: theVerb) ; forest
			else
				(switch theVerb
					(55 ; theChicken
						(gCurRoom doVerb: theVerb)
					)
					(19 ; theRations
						(gCurRoom setScript: sThrowFood 0 19)
					)
					(16 ; theManas
						(gCurRoom setScript: sThrowFood 0 16)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(= local0 x)
		(= local1 y)
		(if
			(and
				(not local6)
				(!= (bush script:) sClaw)
				(<
					(GetDistance
						(gEgo x:)
						(gEgo y:)
						(+ local0 44)
						(- local1 18)
					)
					50
				)
				(!= (gCurRoom script:) sMoveBack)
			)
			(if (not (gCast contains: claw))
				(claw init:)
			else
				(claw show:)
			)
			(bush setScript: sClaw)
		)
	)
)

(instance stalk of Prop
	(properties
		noun 3
		view 861
		signal 16384
	)

	(method (init)
		(= x (+ local0 44))
		(= y local1)
		(super init: &rest)
	)

	(method (doit)
		(= x (+ local0 44))
		(= y local1)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(bush doVerb: theVerb &rest)
	)
)

(instance claw of Prop
	(properties
		noun 3
		x 93
		y 116
		view 861
		loop 2
		signal 16385
	)

	(method (init)
		(= x (+ local0 44))
		(= y (- local1 18))
		(super init: &rest)
	)
)

(instance branch of Actor
	(properties
		noun 4
		x 90
		y 102
		view 861
		loop 4
		signal 16384
	)

	(method (init)
		(= x (+ local0 41))
		(= y (+ local1 -32))
		(super init: &rest)
	)

	(method (dispose)
		(if (== (gCurRoom script:) (ScriptID 27)) ; StartARoom
			((ScriptID 27) caller: 0) ; StartARoom
		)
		(super dispose: &rest)
	)

	(method (cue)
		(gMessager say: 3 87 7) ; "You retrieve the berries from the loose branch and store them carefully in a pocket of your pack."
		(gEgo get: 30 1 solvePuzzle: 429 6) ; theBerries
		(= local2 0)
		(self dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== x (+ local0 41))
					(gMessager say: 4 4 10) ; "You don't dare pick up the branch right now -- it's too close to the bush!"
				else
					(gCurRoom setScript: sGetBranch)
				)
			)
			(87 ; fetchSpell
				(gCurRoom doVerb: theVerb)
			)
			(-87 ; fetchSpell (part 2)
				(branch hide:)
				(bush setScript: 0)
				(if local4
					(bush setScript: sMoveBack)
				)
			)
			(else
				(if
					(or
						(not (Message msgSIZE 570 3 theVerb 0 1))
						(OneOf theVerb 86 88 93 87 21 37 33) ; flameDartSpell, forceBoltSpell, lightningBallSpell, fetchSpell, theRocks, theThrowdagger, theGrapnel
					)
					((ScriptID 50) doVerb: theVerb) ; forest
				else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance chicken of View
	(properties
		noun 7
		x 195
		y 120
		view 862
		signal 16384
	)
)

(instance rock of Actor
	(properties
		view 46
		loop 4
		signal 16385
	)
)

(instance sClaw of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo x:) (bush x:))
					(claw setLoop: 3 1)
				else
					(claw setLoop: 2 1)
				)
				(claw
					signal: (| (claw signal:) $0001)
					show:
					setCel: 0
					x: (- (gEgo x:) 20)
					y: (- local1 13)
					setCycle: End self
				)
				(if (> (gEgo y:) (- local1 14))
					(claw setPri: (+ (bush priority:) 1))
				else
					(claw setPri: (bush priority:))
					(if (< (gEgo x:) (+ local0 61))
						(claw y: (- local1 29))
					)
				)
				(bush
					setLoop: 4 1
					cycleSpeed: (* global433 3)
					signal: (| (bush signal:) $0001)
					setCycle: Fwd
				)
			)
			(1
				(bush setCycle: 0 signal: (& (bush signal:) $fffe))
				(claw hide:)
				(if
					(<
						(GetDistance
							(gEgo x:)
							(gEgo y:)
							(+ local0 44)
							(- local1 18)
						)
						50
					)
					(gEgo takeDamage: 50)
					(if (<= [gEgoStats 17] 0) ; health
						(= local6 1)
						(EgoDead 1 570 43 End 912) ; "You've been bitten by a bury bush and you're bound to be buried."
					else
						(gMessager say: 2 6 2 0 self) ; "That hurt. That REALLY hurt. Think of being stung by a 10-foot-long wasp..."
					)
				else
					(self cue:)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sShakeLoose of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						(not (gEgo has: 30)) ; theBerries
						(not (& ((gInventory at: 28) maskCel:) $0001)) ; thePiepan
						(not (IsFlag 179))
					)
					(++ local2)
				)
				(bush
					setLoop: 4 1
					signal: (| (bush signal:) $0001)
					cycleSpeed: (/ global433 2)
					setCycle: Fwd
				)
				(= ticks 60)
			)
			(1
				(if (== local2 1)
					(branch
						signal: (| (branch signal:) $0001)
						init:
						setPri: (+ (bush priority:) 1)
						setMotion: JumpTo (+ local0 36) (+ local1 1) self
					)
				else
					(self cue:)
				)
				(bush setCycle: 0 signal: (& (bush signal:) $fffe))
			)
			(2
				(branch signal: (& (branch signal:) $fffe))
				(if (== local2 1)
					(switch register
						(21
							(gMessager say: 3 21 0 0 self) ; "You've managed to knock a branch with some berries loose from the bush."
						)
						(88
							(gMessager say: 3 21 0 0 self) ; "You've managed to knock a branch with some berries loose from the bush."
						)
						(else
							(self cue:)
						)
					)
				else
					(self cue:)
				)
			)
			(3
				(if local4
					(bush setScript: sMoveBack)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance sPeek of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(stalk signal: (| (stalk signal:) $0001) setCycle: Beg self)
			)
			(1
				(stalk hide:)
				(self dispose:)
			)
		)
	)
)

(instance sThrowChick of Script
	(properties)

	(method (doit)
		(= local0 (bush x:))
		(= local1 (bush y:))
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= gTempEgoSpeed (gEgo cycleSpeed:))
				(gEgo setMotion: PolyPath 195 120 self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(gEgo
					view: 4
					setLoop: 3 1
					setCel: 0
					setSpeed: global433
					setCycle: End self
				)
			)
			(3
				(chicken init: setPri: (- (bush priority:) 1))
				(gEgo drop: 36 1 setCycle: Beg self) ; theChicken
			)
			(4
				(gEgo normalize: 1 setMotion: PolyPath 285 137 self)
				(if
					(and
						(gCast contains: stalk)
						(stalk script:)
						(== ((stalk script:) state:) 0)
					)
					((stalk script:) ticks: 0 cue:)
				)
				(bush
					signal: (| (bush signal:) $0001)
					setLoop: 0 1
					setCycle: Fwd
					setSpeed: global433
					setMotion: MoveTo 165 133 self
				)
			)
			(5
				(chicken dispose:)
				(gEgo setSpeed: gTempEgoSpeed setHeading: 270)
			)
			(6
				(bush
					setLoop: 0 1
					setCycle: 0
					setCel: 0
					signal: (& (bush signal:) $fffe)
				)
				(= local4 1)
				(SetFlag 261)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 76 179 130 179 153 167 181 167 190 160 240 160 291 142 319 142 319 189 0 189 0 0 154 0 154 72 178 83 158 103 117 103 97 96 70 96 50 86 31 86 31 93 60 108 32 108 54 129 55 143 95 143 95 150 48 154
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 319 0 319 130 295 130 255 122 248 127 114 127 114 113 162 113 195 79 195 0
							yourself:
						)
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetBranch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= gTempEgoSpeed (gEgo cycleSpeed:))
				(gEgo setMotion: PolyPath (branch x:) (branch y:) self)
			)
			(1
				(gEgo setHeading: 270 self)
			)
			(2
				(gEgo
					view: 4
					setLoop: 3 1
					setCel: 0
					setSpeed: global433
					setCycle: End self
				)
			)
			(3
				(branch dispose:)
				(= local2 0)
				(gMessager say: 4 4 0 0 self) ; "You strip the berries from the loose branch and carefully store them in a pocket of your backpack."
			)
			(4
				(gEgo get: 30 1 solvePuzzle: 429 6 setCycle: Beg self) ; theBerries
			)
			(5
				(gEgo setSpeed: gTempEgoSpeed normalize: 1)
				(if local4
					(gCurRoom setScript: sMoveBack 0 1)
				else
					(gGlory handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sMoveBack of Script
	(properties)

	(method (doit)
		(= local0 (bush x:))
		(= local1 (bush y:))
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4 0)
				(= gTempEgoSpeed gEgoGait)
				(if (== (bush script:) sClaw)
					(bush setScript: 0)
				)
				(claw hide:)
				(bush
					setLoop: 0 1
					setCycle: Fwd
					signal: (| (bush signal:) $0001)
					setSpeed: global433
					setMotion: MoveTo 49 134 self
				)
				(if register
					(gGlory handsOff:)
					(gEgo setMotion: PolyPath 136 165 self)
				)
			)
			(1
				(if (not register)
					(self cue:)
				)
			)
			(2
				(bush
					setLoop: 0 1
					setCycle: 0
					setCel: 0
					signal: (| (bush signal:) $0001)
				)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 76 179 130 179 153 167 181 167 190 160 240 160 279 142 319 142 319 189 0 189 0 0 154 0 154 72 178 83 158 103 117 103 97 96 70 96 50 86 31 86 31 93 65 114 130 114 130 128 55 128 55 143 95 143 95 150 48 154
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 319 0 319 131 301 131 219 115 239 105 213 98 169 105 195 79 195 0
							yourself:
						)
				)
				(if register
					(gEgo setHeading: 0 self)
				else
					(= register 0)
					(self dispose:)
				)
			)
			(3
				(= register 0)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sThrowFood of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= temp0
					(GetAngle (gEgo x:) (gEgo y:) (bush x:) (bush y:))
				)
				(= local5 (gEgo cycleSpeed:))
				(gEgo
					view: 9
					setLoop:
						(cond
							((< temp0 90) 2)
							((< temp0 180) 0)
							((< temp0 270) 1)
							(else 3)
						)
						1
					setCel: 0
					setSpeed: global433
					setCycle: End self
				)
				(if (not (gCast contains: stalk))
					(stalk init:)
				)
				(stalk setScript: sPeek)
			)
			(1
				(rock
					init:
					x: (gEgo x:)
					y: (- (gEgo y:) 25)
					setLoop: 4 1
					setStep: 8 6
					setMotion: MoveTo (bush x:) (- (bush y:) 30) self
				)
				(gEgo setSpeed: local5 normalize: (+ (gEgo loop:) 4))
			)
			(2
				(rock dispose:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance streamMat of Polygon
	(properties)

	(method (init)
		(super init: 178 101 156 101 168 93 172 97 184 97 179 101)
	)
)

