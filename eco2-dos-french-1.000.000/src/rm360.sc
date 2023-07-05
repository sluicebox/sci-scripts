;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 360)
(include sci.sh)
(use Main)
(use ExitFeature)
(use eRS)
(use Village)
(use Scaler)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Rev)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm360 0
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
	[local8 17] = [7 0 244 124 7 1 243 130 7 2 243 132 7 2 243 134 -32768]
	local25
	local26
	local27
	local28
	local29
	local30
)

(instance rm360 of Eco2Room
	(properties
		noun 15
		picture 360
		style 10
		west 330
	)

	(method (init)
		(if (gEgo has: 10)
			(LoadMany rsVIEW 370 81 362 382 221)
		)
		(wSound init: setLoop: -1 play:)
		(if (gEgo has: 10)
			(if (gCurrentRegionFlags test: 35)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 189 282 189 282 176 209 176 190 169 190 155 213 142 166 127 117 127 117 114 0 96
							yourself:
						)
				)
			else
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 189 209 189 209 176 190 169 190 155 213 142 166 127 117 127 117 114 0 96
							yourself:
						)
				)
			)
			(if (not (gCurrentRegionFlags test: 35))
				(chief
					init:
					approachVerbs: 2 19 26 24 4 20 ; Talk, barkCup, sap, clayCup, Do, pods
					setScript: repairRoof
				)
			)
			(cond
				((not (gCurrentRegionFlags test: 36))
					(aPods init:)
					(aCup init:)
				)
				((not (gEgo has: 11))
					(aCup loop: 8 init: setCycle: Fwd)
				)
			)
			(if (not (gCurrentRegionFlags test: 7))
				(tarzan init:)
			else
				(string init:)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 0 189 277 189 277 172 251 172 231 179 190 171 190 157 212 142 172 131 122 131 122 116 0 94
						yourself:
					)
			)
			(LoadMany rsVIEW 2)
			(spider init:)
			(string init:)
		)
		(exitwest init:)
		(exiteast init:)
		(hut init: setOnMeCheck: 1 32)
		(tree init: setOnMeCheck: 1 64)
		(pot init:)
		(river init: setOnMeCheck: 1 2)
		(bank init: setOnMeCheck: 1 256)
		(bush init: setOnMeCheck: 1 2048)
		(acrosstree init: setOnMeCheck: 1 512)
		(ground1 init: setOnMeCheck: 1 4)
		(ground2 init: setOnMeCheck: 1 4096)
		(foliage init: setOnMeCheck: 1 16)
		(doorway init:)
		(bench init:)
		(shore init: setOnMeCheck: 1 16384)
		(waterFall init:)
		(berry init:)
		(gWalkHandler addToFront: self)
		(switch gPrevRoomNum
			(380
				(gCurrentRegionFlags set: 19)
				(super init: &rest)
				(gGameSound1 number: 309 play: setVol: 80)
				(gEgo
					x: 236
					y: 176
					code: normalCheck
					init:
					normalize: 0 1
					setScale: Scaler 100 91 179 105
				)
				(self setScript: moveIt)
			)
			(else
				(= style 12)
				(gGameSound1 setVol: 80)
				(super init: &rest)
				(gEgo
					x: 10
					code: (if (gEgo has: 10) 0 else normalCheck)
					init:
					normalize:
					setScale: Scaler 100 91 179 105
				)
				(if (gCurrentRegionFlags test: 35)
					(gEgo code: normalCheck)
				)
				(self setScript: comeIn)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(= local6 0)
				(gEgo setMotion: PolyPath gMouseX gMouseY)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if (and (gCurrentRegionFlags test: 12) (gCurrentRegionFlags test: 14))
			(gCurrentRegionFlags set: 36)
		)
		(wSound dispose:)
		(gWalkHandler delete: self)
		(gGameSound1 setVol: 127)
		(super dispose:)
	)
)

(instance normalCheck of Code
	(properties)

	(method (doit)
		(cond
			((gCurRoom script:))
			((and (> (gEgo x:) 235) (> (gEgo y:) 160))
				(if (gCurrentRegionFlags test: 35)
					(gCurRoom setScript: inTo380)
				else
					(gCurRoom setScript: spScare)
				)
			)
		)
	)
)

(instance stage1Check of Code
	(properties)

	(method (doit &tmp temp0)
		(cond
			((gCurRoom script:))
			((bank onMe: gEgo)
				(cond
					((gEgo mover:)
						(if ((gEgo mover:) isKindOf: PolyPath)
							(= local0 ((gEgo mover:) finalX:))
							(= local1 ((gEgo mover:) finalY:))
						else
							(= local0 ((gEgo mover:) x:))
							(= local1 ((gEgo mover:) y:))
						)
						(= local25 1)
					)
					((= temp0 ((gEgo looper:) oldMover:))
						(if (temp0 isKindOf: PolyPath)
							(= local0 (temp0 finalX:))
							(= local1 (temp0 finalY:))
						else
							(= local0 (temp0 x:))
							(= local1 (temp0 y:))
						)
						(= local25 1)
						(temp0 dispose:)
						((gEgo looper:) oldMover: 0)
					)
					(else
						(= local25 0)
					)
				)
				(gCurRoom setScript: bankUp)
			)
		)
	)
)

(instance stage2Check of Code
	(properties)

	(method (doit &tmp temp0)
		(cond
			((gCurRoom script:))
			((bank onMe: gEgo)
				(cond
					((gEgo mover:)
						(if ((gEgo mover:) isKindOf: PolyPath)
							(= local0 ((gEgo mover:) finalX:))
							(= local1 ((gEgo mover:) finalY:))
						else
							(= local0 ((gEgo mover:) x:))
							(= local1 ((gEgo mover:) y:))
						)
						(= local25 1)
					)
					((= temp0 ((gEgo looper:) oldMover:))
						(if (temp0 isKindOf: PolyPath)
							(= local0 (temp0 finalX:))
							(= local1 (temp0 finalY:))
						else
							(= local0 (temp0 x:))
							(= local1 (temp0 y:))
						)
						(= local25 1)
						(temp0 dispose:)
						((gEgo looper:) oldMover: 0)
					)
					(else
						(= local25 0)
					)
				)
				(gCurRoom setScript: bankDown)
			)
			((ground1 onMe: gEgo)
				(if (gEgo mover:)
					(if ((gEgo mover:) isKindOf: PolyPath)
						(= local0 ((gEgo mover:) finalX:))
						(= local1 ((gEgo mover:) finalY:))
					else
						(= local0 ((gEgo mover:) x:))
						(= local1 ((gEgo mover:) y:))
					)
					(= local25 1)
				else
					(= local25 0)
				)
				(= local2 277)
				(= local3 58)
				(= local4 0)
				(gEgo code: stage3Check)
				(gCurRoom setScript: crossRiver)
			)
		)
	)
)

(instance stage3Check of Code
	(properties)

	(method (doit)
		(cond
			((gCurRoom script:))
			((ground1 onMe: gEgo)
				(if (gEgo mover:)
					(if ((gEgo mover:) isKindOf: PolyPath)
						(= local0 ((gEgo mover:) finalX:))
						(= local1 ((gEgo mover:) finalY:))
					else
						(= local0 ((gEgo mover:) x:))
						(= local1 ((gEgo mover:) y:))
					)
					(= local25 1)
				else
					(= local25 0)
				)
				(= local2 224)
				(= local3 38)
				(= local4 1)
				(gEgo code: stage2Check)
				(gCurRoom setScript: crossRiver)
			)
		)
	)
)

(instance repairRoof of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(chief
					view: 370
					setLoop: (if (== ((gInventory at: 18) message:) 32) 3 else 0)
					cel: 0
					setCycle: CT 7 1 self
				)
			)
			(1
				(= ticks 20)
			)
			(2
				(chief setCycle: End self)
			)
			(3
				(= ticks 20)
			)
			(4
				(= temp0 -9)
				(= temp1 -2)
				(if (<= (chief x:) 223)
					(*= temp0 -1)
					(*= temp1 -1)
				)
				(chief
					view: (if (== ((gInventory at: 18) message:) 32) 360 else 370)
					setLoop: (if (== ((gInventory at: 18) message:) 32) 6 else 9)
					setStep: 1 1
					moveSpeed: (chief cycleSpeed:)
					setCycle: (myWalk new:)
					setMotion:
						MoveTo
						(+ (chief x:) temp0)
						(+ (chief y:) temp1)
						self
				)
			)
			(5
				(chief stopUpd:)
				(= seconds (Random 3 6))
			)
			(6
				(self changeState: 0)
			)
		)
	)
)

(instance getBerry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: 1)
				(= local6 0)
				(= cycles 3)
			)
			(1
				(gEgo view: 4 setLoop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(if (gCurrentRegionFlags test: 9)
					(gMessager say: 9 4 20 0 self) ; "Adam picks up a beautiful necklace. It looks like a dolphin's tooth."
				else
					(self cue:)
				)
			)
			(3
				(if (not (gCurrentRegionFlags test: 9))
					(gCurrentRegionFlags set: 9)
					(berry x: 291 y: 52 setLoop: 4 cel: 0 setCycle: Fwd)
				else
					(gCurrentRegionFlags set: 10)
					(berry dispose:)
				)
				(gEgo setCycle: End self)
			)
			(4
				(Village points: 5)
				(gEgo normalize: 0 get: (if (gEgo has: 16) 13 else 16))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance spScare of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0 1)
				(= cycles 3)
			)
			(1
				(gGameSound2 number: 291 setLoop: 1 play:)
				(spider cel: 0 cycleSpeed: 2 setCycle: MCyc @local8 self 1)
			)
			(2
				(gEgo view: 2 setLoop: 10 cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(= ticks 15)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(= register (gEgo cycleSpeed:))
				(gEgo
					view: 0
					setSpeed: 0
					setCycle: Rev
					setMotion: PolyPath (- (gEgo x:) 15) (gEgo y:) self
				)
			)
			(6
				(gEgo normalize: 0 setSpeed: register)
				(spider
					cel: 3
					x: 243
					y: 155
					cycleSpeed: 10
					setCycle: MCyc @local8 self -1
				)
			)
			(7
				(spider stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance comeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath (+ (gEgo x:) 45) 106 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance swingAcross of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 134 76 134 81 157 90 182 90 192 83 181 80 181 48 195 40 233 40 263 55 260 65 319 65 319 189 0 189 0 0 319 0 319 61 288 61 215 31 145 31 145 52 175 52 175 76
							yourself:
						)
				)
				(= cycles 3)
			)
			(1
				(string hide:)
				(gEgo
					view: 361
					setScale: 0
					setLoop: 2
					cel: 0
					x: 119
					y: 18
					setPri: 14
					setCycle: CT 6 1 self
				)
			)
			(2
				(gGameSound2 number: 872 setLoop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(= register (gEgo cycleSpeed:))
				(gEgo setLoop: 4 cel: 0 cycleSpeed: 20 setCycle: End self)
			)
			(4
				(string
					view: 361
					x: 119
					y: 18
					setLoop: 6
					cel: 0
					show:
					approachX: 167
					approachY: 82
				)
				(gEgo
					x: 164
					y: 82
					code: stage1Check
					cycleSpeed: register
					setPri: -1
					normalize: 0
					setScale: Scaler 76 71 84 35
				)
				(Village points: 1 56)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance swingBack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local6 0)
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
				)
				(if (gEgo has: 10)
					(if (gCurrentRegionFlags test: 35)
						(gCurRoom
							addObstacle:
								((Polygon new:)
									type: PContainedAccess
									init: 0 189 282 189 282 176 209 176 190 169 190 155 213 142 166 127 117 127 117 114 0 96
									yourself:
								)
						)
					else
						(gCurRoom
							addObstacle:
								((Polygon new:)
									type: PContainedAccess
									init: 0 189 209 189 209 176 190 169 190 155 213 142 166 127 117 127 117 114 0 96
									yourself:
								)
						)
					)
				else
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PContainedAccess
								init: 0 189 277 189 277 172 251 172 231 179 190 171 190 157 212 142 172 131 122 131 122 116 0 94
								yourself:
							)
					)
				)
				(= cycles 3)
			)
			(1
				(= register (gEgo cycleSpeed:))
				(string hide:)
				(gEgo
					setScale: 0
					view: 361
					setLoop: 3
					cel: 0
					x: 119
					y: 18
					setPri: 14
					setCycle: CT 6 1 self
				)
			)
			(2
				(gGameSound2 number: 872 setLoop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo setLoop: 5 cel: 0 setCycle: End self)
			)
			(4
				(string
					view: 361
					loop: 6
					cel: 1
					show:
					approachX: 113
					approachY: 20
				)
				(gEgo
					x: 96
					y: 111
					cycleSpeed: register
					setScale: Scaler 100 91 179 105
					setPri: -1
					code: normalCheck
					normalize: 0 3
				)
				(Village points: 1 57)
				(if (not caller)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance offerButter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(if (== (gEgo code:) stage1Check)
					(self setScript: swingBack self)
				else
					(= cycles 1)
				)
			)
			(2
				(chief view: 370 setLoop: 4 cel: 0 setCycle: End self)
			)
			(3
				(gEgo
					setMotion: MoveTo (- (chief x:) 28) (- (chief y:) 4) self
				)
			)
			(4
				(gEgo view: 4 setLoop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(5
				(chief view: 371 setLoop: 0 cel: 0 setCycle: End self)
			)
			(6
				(gEgo setCycle: End self)
			)
			(7
				(gMessager say: 13 32 0 0 self) ; "Fly free, my friend. I wished only to look on your beauty for a moment."
			)
			(8
				(chief setLoop: 1 cel: 0 setCycle: End self)
			)
			(9
				(butterfly
					x: (+ (chief x:) 30)
					y: (- (chief y:) 58)
					setStep: 5 3
					moveSpeed: 3
					cycleSpeed: 4
					init:
					setCycle: Walk
					setMotion: MoveTo 330 100 butterfly
				)
				(chief setLoop: 2 cel: 0 setCycle: CT 4 1 self)
			)
			(10
				(chief
					setPri: 1
					setStep: 3 2
					moveSpeed: 6
					cycleSpeed: 6
					setCycle: (rCycle new:)
					setMotion: MoveTo 268 179 self
				)
			)
			(11
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 189 282 189 282 176 209 176 190 169 190 155 213 142 166 127 117 127 117 114 0 96
							yourself:
						)
				)
				(chief dispose:)
				(gCurrentRegionFlags set: 35)
				(gEgo normalize: 0 put: 18 code: normalCheck)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance inTo380 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 5)
			)
			(1
				(gEgo setPri: 1 setMotion: MoveTo 268 179 self)
			)
			(2
				(gCurRoom newRoom: 380)
			)
		)
	)
)

(instance moveIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 203 179 self)
			)
			(1
				(gGame handsOn:)
				(gEgo code: normalCheck)
				(self dispose:)
			)
		)
	)
)

(instance bankUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: 1)
				(gEgo setMotion: 0 1)
				(= register (gEgo cycleSpeed:))
				(= cycles 2)
			)
			(1
				(gEgo
					view: 7
					cycleSpeed: 10
					x: (+ (gEgo x:) 1)
					y: (+ (gEgo y:) 1)
					setLoop: 3
					cel: 0
					setCycle: End self
				)
			)
			(2
				(gEgo setLoop: 7 cel: 0 setCycle: End self)
			)
			(3
				(gEgo
					cycleSpeed: register
					x: (- (gEgo x:) 15)
					y: (- (gEgo y:) 34)
					code: stage2Check
					normalize: 0 3
				)
				(if (and local25 (or (< local1 (gEgo y:)) (> local0 245)))
					(if local6
						(gEgo setMotion: PolyPath local0 local1 CueObj)
					else
						(gEgo setMotion: PolyPath local0 local1)
					)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bankDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: 1)
				(gEgo setMotion: 0 1)
				(= register (gEgo cycleSpeed:))
				(= cycles 2)
			)
			(1
				(gEgo setHeading: 0)
				(= cycles 25)
			)
			(2
				(gEgo
					view: 7
					cycleSpeed: 10
					x: (+ (gEgo x:) 13)
					y: (+ (gEgo y:) 34)
					setLoop: 7
					cel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(3
				(gEgo setLoop: 3 cel: (gEgo lastCel:) setCycle: Beg self)
			)
			(4
				(gEgo
					cycleSpeed: register
					x: (- (gEgo x:) 1)
					y: (- (gEgo y:) 1)
					code: stage1Check
					normalize: 0 3
				)
				(if (and (> local1 (gEgo y:)) local25)
					(if local6
						(gEgo setMotion: PolyPath local0 local1 CueObj)
					else
						(gEgo setMotion: PolyPath local0 local1)
					)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance crossRiver of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0 1)
				(= register (gEgo cycleSpeed:))
				(= local5 (gEgo moveSpeed:))
				(= cycles 2)
			)
			(1
				(gEgo
					view: 205
					cycleSpeed: 8
					moveSpeed: 8
					setStep: 2 1
					setLoop: local4
					setMotion: PolyPath local2 local3 self
				)
			)
			(2
				(gEgo
					cycleSpeed: register
					moveSpeed: local5
					normalize: 0 local4
				)
				(= temp0 0)
				(cond
					(local4
						(if (< local0 (gEgo x:))
							(= temp0 1)
						)
					)
					((> local0 (gEgo x:))
						(= temp0 1)
					)
				)
				(if (and temp0 local25)
					(if local6
						(gEgo setMotion: PolyPath local0 local1 CueObj)
					else
						(gEgo setMotion: PolyPath local0 local1)
					)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveDrum of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
				(tarzan setCycle: 0)
			)
			(1
				(if (and (IsObject local26) (local26 isKindOf: Timer))
					(local26 dispose:)
					(= local26 0)
				)
				(gMessager say: 23 17 0 0 self) ; "Great! I won't be in trouble any more. I think I'll go practice!"
			)
			(2
				(gEgo view: 4 setLoop: 7 cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(string init:)
				(tarzan setLoop: 1 cel: 0 x: 98 y: 109 setCycle: End self)
			)
			(4
				(Village points: 5)
				(gEgo setCycle: End self)
			)
			(5
				(tarzan
					setLoop: 2
					cel: 0
					xStep: 5
					cycleSpeed: 2
					moveSpeed: 2
					setCycle: Walk
					setMotion: MoveTo -5 (tarzan y:) self
				)
			)
			(6
				(tarzan dispose:)
				(gEgo put: 9 normalize: 0 6)
				(gCurrentRegionFlags set: 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance putBench of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gEgo view: 5 setLoop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(switch register
					(12
						(if (gCurrentRegionFlags test: 14)
							(gMessager say: 17 20 2 0 self) ; "Ah, those pods! Now the shaman will make up the poultice."
						else
							(gMessager say: 17 20 26 0 self) ; "By all means, leave those for the shaman."
						)
					)
					(11
						(if (gCurrentRegionFlags test: 12)
							(gMessager say: 17 26 31 0 self) ; "Yes, that is everything! I remember now! I will ask the shaman to mix your poultice."
						else
							(gMessager say: 17 26 5 0 self) ; "Oh, that's right, the baby got stung again. The shaman would make a poultice if he had everything."
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(3
				(if (== register 12)
					(aPods show: stopUpd:)
				else
					(aCup show: stopUpd:)
				)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo put: register normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getItem of Script
	(properties)

	(method (changeState newState &tmp [temp0 3])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gEgo view: 5 setLoop: 0 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(if (and (== register 11) (gCurrentRegionFlags test: 36))
					(gMessager say: 17 4 29 0 self) ; "The shaman hopes that will help someone. You may take it."
				else
					(gMessager say: 17 4 36 0 self) ; "Well, you MAY take that. However, the shaman can't mix the poultice without the ingredients!"
				)
			)
			(3
				(if (== register 12)
					(aPods hide:)
				else
					(aCup hide:)
				)
				(gEgo setCycle: End self)
			)
			(4
				(gEgo get: register normalize: 0)
				(if (and (== register 11) (gCurrentRegionFlags test: 36))
					((gInventory at: 11) cel: 15)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkSulk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (IsObject local26)
					(local26 dispose:)
					(= local26 0)
				)
				(tarzan setCycle: 0)
				(= cycles 3)
			)
			(1
				(tarzan cel: 0 setCycle: End self)
			)
			(2
				(gMessager say: 23 register 0 0 self)
			)
			(3
				(waterFall cue:)
				(self dispose:)
				(gGame handsOn:)
			)
		)
	)
)

(instance idealTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(chief setScript: 0)
				(= cycles 3)
			)
			(1
				(chief
					view: 370
					setLoop: (if (== ((gInventory at: 18) message:) 32) 4 else 2)
					cel: 0
					setCycle: End self
				)
			)
			(2
				(chief
					setLoop: (if (== ((gInventory at: 18) message:) 32) 5 else 1)
					cel: 0
					setCycle: ForwardCounter 2 self
				)
			)
			(3
				(gMessager say: 13 local27 local28 0 self)
			)
			(4
				(chief
					setLoop: (if (== ((gInventory at: 18) message:) 32) 4 else 2)
					cel: (chief lastCel:)
					setCycle: Beg self
				)
			)
			(5
				(chief setScript: repairRoof)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance chief of Actor
	(properties
		x 259
		y 187
		noun 13
		approachX 199
		approachY 181
		view 370
		signal 20480
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(= local27 2)
				(Village points: 1 55)
				(cond
					((not (gCurrentRegionFlags test: 4))
						(gCurrentRegionFlags set: 4)
						(= local28 0)
					)
					((not (gCurrentRegionFlags test: 7))
						(= local28 24)
					)
					((not (gCurrentRegionFlags test: 3))
						(= local28 21)
					)
					((not (gCurrentRegionFlags test: 1))
						(= local28 22)
					)
					(else
						(switch local29
							(0
								(++ local29)
								(= local28 14)
							)
							(1
								(++ local29)
								(= local28 15)
							)
							(2
								(++ local29)
								(= local28 16)
							)
							(else
								(= local28 23)
							)
						)
					)
				)
				(if local7
					(gMessager say: noun theVerb 37) ; "Adam is too far away."
				else
					(gCurRoom setScript: idealTalk)
				)
			)
			(32 ; butter
				(self setScript: 0)
				(Village points: 10)
				(gCurRoom setScript: offerButter)
			)
			(20 ; pods
				(if local30
					(gMessager say: noun theVerb 19) ; "If you put those on the bench, the shaman will get around to making a poultice."
				else
					(= local30 1)
					(gMessager say: noun theVerb 0) ; "I do not know why Sumac cannot grow those pods. We have tried very hard."
				)
			)
			(19 ; barkCup
				(= local27 19)
				(= local28 0)
				(Village points: 1 72)
				(gCurRoom setScript: idealTalk)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance butterfly of Actor
	(properties
		x -10
		y 88
		noun 22
		view 81
		priority 15
		signal 16400
	)

	(method (cue)
		(self dispose:)
	)
)

(instance tarzan of Actor
	(properties
		x 120
		y 20
		noun 23
		approachX 80
		approachY 117
		view 362
		signal 20480
		cycleSpeed 16
	)

	(method (init)
		(super init:)
		(self approachVerbs: 17 2 4) ; drum, Talk, Do
		(waterFall cue:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(Village points: 1 77)
				(gCurRoom setScript: talkSulk 0 theVerb)
			)
			(4 ; Do
				(gCurRoom setScript: talkSulk 0 theVerb)
			)
			(17 ; drum
				(gCurRoom setScript: giveDrum)
			)
			(19 ; barkCup
				(Village points: 1 78)
				(gMessager say: noun theVerb) ; "The shaman does not let me use that yet."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance waterFall of Prop
	(properties
		x 243
		y 50
		noun 7
		view 360
		loop 3
		cel 2
		signal 20480
		maxScale 1
		cycleSpeed 10
		detailLevel 4
	)

	(method (init)
		(self setCycle: Fwd)
		(super init:)
	)

	(method (cue)
		(if maxScale
			(= maxScale 0)
			(tarzan cel: 0 setCycle: End self)
		else
			(= maxScale 1)
			(tarzan stopUpd:)
			((= local26 (Timer new:)) setReal: self (Random 4 7))
		)
	)
)

(instance myForwardCounter of ForwardCounter ; UNUSED
	(properties)

	(method (doit &tmp temp0)
		(if (> (= temp0 (self nextCel:)) 3)
			(self cycleDone:)
		else
			(client cel: temp0)
		)
	)

	(method (cycleDone)
		(if (-- count)
			(client cel: 2)
		else
			(= completed 1)
			(self motionCue:)
		)
	)
)

(instance rCycle of Fwd
	(properties)

	(method (cycleDone)
		(client cel: 4)
	)
)

(instance spider of Prop
	(properties
		x 245
		y 124
		noun 21
		view 360
		loop 7
		signal 16384
		cycleSpeed 2
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)
)

(instance string of View
	(properties
		x 118
		y 18
		noun 3
		approachX 90
		approachY 107
		view 361
		loop 6
		cel 1
		signal 16384
	)

	(method (init)
		(super init:)
		(self stopUpd: approachVerbs: 4) ; Do
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= local6 1)
				(CueObj
					state: 0
					cycles: 0
					client: self
					theVerb: (event message:)
				)
				(event claimed: 1)
				(if
					(and
						(gUser canControl:)
						(>
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								approachX
								approachY
							)
							approachDist
						)
						gEco2ApproachCode
						(& _approachVerbs (gEco2ApproachCode doit: (event message:)))
					)
					(gEgo
						setMotion:
							PolyPath
							approachX
							(+ (gEgo z:) approachY)
							CueObj
					)
				else
					(gEgo setMotion: 0)
					(if (self facingMe:)
						(CueObj changeState: 3)
					)
				)
			)
		)
		(event claimed:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== local7 1)
					(= local7 0)
					(gEgo setScript: swingBack)
				else
					(= local7 1)
					(gEgo setScript: swingAcross)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance berry of Prop
	(properties
		x 292
		y 43
		noun 9
		approachX 281
		approachY 62
		view 360
		loop 2
		priority 3
		signal 16400
	)

	(method (init)
		(cond
			((gCurrentRegionFlags test: 10) 0)
			((gCurrentRegionFlags test: 9)
				(self loop: 4 x: 291 y: 52 setCycle: Fwd)
				(super init:)
			)
			(else
				(super init:)
				(self stopUpd:)
			)
		)
		(self approachVerbs: 4) ; Do
	)

	(method (doit)
		(super doit:)
		(if (not (IsEcorderFlag 66))
			(self perform: gCheckEcorderIcon self)
		)
	)

	(method (doVerb theVerb)
		(bush doVerb: theVerb)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(CueObj
					state: 0
					cycles: 0
					client: self
					theVerb: (event message:)
				)
				(= local6 1)
				(event claimed: 1)
				(if
					(and
						(gUser canControl:)
						(>
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								approachX
								approachY
							)
							approachDist
						)
						gEco2ApproachCode
						(& _approachVerbs (gEco2ApproachCode doit: (event message:)))
					)
					(gEgo
						setMotion:
							PolyPath
							approachX
							(+ (gEgo z:) approachY)
							CueObj
					)
				else
					(gEgo setMotion: 0)
					(if (self facingMe:)
						(CueObj changeState: 3)
					)
				)
			)
		)
		(event claimed:)
	)
)

(instance aPods of View
	(properties
		x 213
		y 158
		approachX 198
		approachY 154
		view 360
		loop 5
		priority 13
		signal 16400
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4 26) ; Do, sap
		(cond
			((gCurrentRegionFlags test: 36)
				(self hide:)
			)
			((not (gCurrentRegionFlags test: 12))
				(self hide:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(CueObj
					state: 0
					cycles: 0
					client: self
					theVerb: (event message:)
				)
				(event claimed: 1)
				(if
					(and
						(gUser canControl:)
						(>
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								approachX
								approachY
							)
							approachDist
						)
						gEco2ApproachCode
						(& _approachVerbs (gEco2ApproachCode doit: (event message:)))
					)
					(gEgo
						setMotion:
							PolyPath
							approachX
							(+ (gEgo z:) approachY)
							(and (not local7) CueObj)
					)
				else
					(gEgo setMotion: 0)
					(if (self facingMe:)
						(CueObj changeState: 3)
					)
				)
			)
		)
		(event claimed:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(gCurrentRegionFlags clear: 12)
			(gCurRoom setScript: getItem 0 12)
		else
			(bench doVerb: theVerb)
		)
	)
)

(instance aCup of Prop
	(properties
		x 201
		y 156
		approachX 188
		approachY 160
		view 360
		loop 1
		priority 13
		signal 16400
		cycleSpeed 12
		detailLevel 3
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4 20) ; Do, pods
		(if (not (gCurrentRegionFlags test: 14))
			(self hide:)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(CueObj
					state: 0
					cycles: 0
					client: self
					theVerb: (event message:)
				)
				(event claimed: 1)
				(if
					(and
						(gUser canControl:)
						(>
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								approachX
								approachY
							)
							approachDist
						)
						gEco2ApproachCode
						(& _approachVerbs (gEco2ApproachCode doit: (event message:)))
					)
					(gEgo
						setMotion:
							PolyPath
							approachX
							(+ (gEgo z:) approachY)
							(and (not local7) CueObj)
					)
				else
					(gEgo setMotion: 0)
					(if (self facingMe:)
						(CueObj changeState: 3)
					)
				)
			)
		)
		(event claimed:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (gCurrentRegionFlags test: 36)
				(Village points: 5)
				((gInventory at: 11) cel: 15 message: 30 noun: 43)
			)
			(gCurrentRegionFlags clear: 14)
			(gCurRoom setScript: getItem 0 11)
		else
			(bench doVerb: theVerb)
		)
	)
)

(instance exitwest of ExitFeature
	(properties
		nsTop 91
		nsBottom 132
		nsRight 16
		cursor 12
		exitDir 4
	)
)

(instance exiteast of ExitFeature
	(properties
		nsTop 121
		nsLeft 233
		nsBottom 178
		nsRight 258
		cursor 11
		exitDir 2
	)

	(method (doit)
		(if (not (gCurrentRegionFlags test: 35))
			(return 1)
		)
		(return
			(cond
				((self onMe: gMouseX (- gMouseY 10))
					(if (== retCursor -1)
						(= retCursor (gTheCursor cel:))
					)
					(if (== lastCursor -1)
						(= lastCursor 1)
						(gGame setCursor: cursor)
					)
				)
				((!= lastCursor -1)
					(if (OneOf (gTheCursor cel:) 10 11 12 13)
						(gGame setCursor: retCursor)
						(= retCursor -1)
					)
					(= lastCursor -1)
				)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(cond
			((not (gUser input:)))
			((not (self onMe: gMouseX (- gMouseY 10))))
			(
				(or
					(and (== (event type:) evKEYBOARD) (!= (event message:) KEY_RETURN))
					(and (== (event type:) evMOUSEBUTTON) (event modifiers:))
					(not (OneOf (event type:) evMOUSEBUTTON evKEYBOARD))
				)
				(= lastCursor -1)
			)
			((OneOf (gTheCursor cel:) 10 11 12 13)
				(= temp0 (= temp1 0))
				(= temp0
					(if toX
						toX
					else
						(switch exitDir
							(1 gMouseX)
							(3 gMouseX)
							(2 320)
							(4 0)
							(else 999)
						)
					)
				)
				(= temp1
					(if toY
						toY
					else
						(switch exitDir
							(1 0)
							(3 190)
							(2
								(- gMouseY 10)
							)
							(4
								(- gMouseY 10)
							)
							(else 999)
						)
					)
				)
				(gEgo setMotion: PolyPath 251 182)
				(event claimed: 1)
			)
			(else
				(event claimed: 0)
			)
		)
		(event claimed:)
	)
)

(instance hut of Feature
	(properties
		x 277
		y 97
		noun 1
		onMeCheck 32
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 65))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 65))
			(super doVerb: theVerb)
		)
	)
)

(instance tree of Feature
	(properties
		x 68
		y 5
		noun 10
		onMeCheck 64
	)
)

(instance bench of Feature
	(properties
		x 208
		y 152
		noun 17
		nsTop 155
		nsLeft 195
		nsBottom 170
		nsRight 222
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
		(self approachVerbs: 4 26 19 20) ; Do, sap, barkCup, pods
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 67))
			(self perform: gCheckEcorderIcon self)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(CueObj
					state: 0
					cycles: 0
					client: self
					theVerb: (event message:)
				)
				(event claimed: 1)
				(if (== (event message:) KEY_CAPITAL)
					(= approachX 198)
					(= approachY 154)
				else
					(= approachX 188)
					(= approachY 160)
				)
				(if
					(and
						(gUser canControl:)
						(>
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								approachX
								approachY
							)
							approachDist
						)
						gEco2ApproachCode
						(& _approachVerbs (gEco2ApproachCode doit: (event message:)))
					)
					(gEgo
						setMotion:
							PolyPath
							approachX
							(+ (gEgo z:) approachY)
							(and (not local7) CueObj)
					)
				else
					(gEgo setMotion: 0)
					(if (self facingMe:)
						(CueObj changeState: 3)
					)
				)
			)
		)
		(event claimed:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 67))
			(switch theVerb
				(19 ; barkCup
					(if (gEgo has: 10)
						(gMessager say: noun theVerb 0) ; "I think the shaman was going to fill that! It's of no use to him empty."
					else
						(gMessager say: noun theVerb 30) ; "Adam has no reason to do that yet."
					)
				)
				(26 ; sap
					(if (gEgo has: 10)
						(gCurrentRegionFlags set: 14)
						(Village points: 1 74)
						(gCurRoom setScript: putBench 0 11)
					else
						(gMessager say: noun theVerb 30) ; "Adam has no reason to do that yet."
					)
				)
				(20 ; pods
					(if (gEgo has: 10)
						(gCurrentRegionFlags set: 12)
						(Village points: 1 75)
						(gCurRoom setScript: putBench 0 12)
					else
						(gMessager say: noun theVerb 30) ; "Adam has no reason to do that yet."
					)
				)
				(4 ; Do
					(if (or (not (gEgo has: 10)) (gCurrentRegionFlags test: 19))
						(gMessager say: noun theVerb 18) ; "Moving the bench won't help."
					else
						(gMessager say: noun theVerb 0 1) ; "Moving the shaman's bench is not a good idea."
					)
				)
				(1 ; Look
					(cond
						(
							(or
								(not (gEgo has: 10))
								(== ((gInventory at: 11) message:) 30)
								(gCurrentRegionFlags test: 19)
							)
							(gMessager say: noun theVerb 18) ; "A bench leans against the small hut."
						)
						((gCurrentRegionFlags test: 36)
							(gMessager say: noun theVerb 29) ; "An odd-smelling poultice is sitting on the bench."
						)
						((and (gCurrentRegionFlags test: 12) (gCurrentRegionFlags test: 14))
							(gMessager say: noun theVerb 2) ; "All the ingredients for the bee sting poultice are ready for the shaman."
						)
						((gCurrentRegionFlags test: 12)
							(gMessager say: noun theVerb 33) ; "The pods are waiting for the shaman."
						)
						((gCurrentRegionFlags test: 14)
							(gMessager say: noun theVerb 34) ; "The cup of sap waits for the shaman."
						)
						(else
							(gMessager say: noun theVerb 0) ; "The shaman's medicine bench leans against the hut. The shaman likes to keep ingredients on it."
						)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance river of Feature
	(properties
		x 115
		y 10
		noun 6
		onMeCheck 2
	)
)

(instance bank of Feature
	(properties
		x 110
		y 8
		noun 8
		onMeCheck 256
		approachX 178
		approachY 61
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4) ; Do
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(CueObj
					state: 0
					cycles: 0
					client: self
					theVerb: (event message:)
				)
				(event claimed: 1)
				(if
					(and
						(gUser canControl:)
						local7
						(>
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								approachX
								approachY
							)
							approachDist
						)
						gEco2ApproachCode
						(& _approachVerbs (gEco2ApproachCode doit: (event message:)))
					)
					(gEgo
						setMotion:
							PolyPath
							approachX
							(+ (gEgo z:) approachY)
							CueObj
					)
				else
					(gEgo setMotion: 0)
					(if (self facingMe:)
						(CueObj changeState: 3)
					)
				)
			)
		)
		(event claimed:)
	)
)

(instance bush of Feature
	(properties
		x 315
		y 10
		noun 9
		onMeCheck 2048
		approachX 281
		approachY 62
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
		(self approachVerbs: 4) ; Do
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 66))
			(self perform: gCheckEcorderIcon self)
		)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 66))
			(switch theVerb
				(4 ; Do
					(if local7
						(cond
							((gCurrentRegionFlags test: 10)
								(gMessager say: noun theVerb 0) ; "There are no more ripe berries."
							)
							((gEgo has: 10)
								(gCurRoom setScript: getBerry)
							)
							(else
								(gMessager say: noun theVerb 18) ; "The berries aren't ripe yet."
							)
						)
					else
						(gMessager say: noun theVerb 10) ; "Adam's arms aren't that long."
					)
				)
				(1 ; Look
					(if (gCurrentRegionFlags test: 9)
						(if (gEgo has: 13)
							(super doVerb: theVerb)
						else
							(gMessager say: noun theVerb 20) ; "A necklace has fallen between the branches."
						)
					else
						(gMessager say: noun theVerb 0) ; "Lush bushes are loaded with bright red berries."
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance acrosstree of Feature
	(properties
		x 14
		y 153
		noun 2
		onMeCheck 512
	)
)

(instance ground1 of Feature
	(properties
		x 91
		y 11
		noun 7
		onMeCheck 4
	)
)

(instance ground2 of Feature
	(properties
		x 91
		y 10
		noun 11
		onMeCheck 4096
	)
)

(instance doorway of Feature
	(properties
		x 246
		y 151
		noun 12
		nsTop 121
		nsLeft 233
		nsBottom 181
		nsRight 260
	)
)

(instance pot of Feature
	(properties
		x 149
		y 84
		noun 4
		nsTop 79
		nsLeft 142
		nsBottom 89
		nsRight 156
	)
)

(instance foliage of Feature
	(properties
		x 107
		y 134
		noun 24
		onMeCheck 16
	)
)

(instance shore of Feature
	(properties
		x 50
		y 10
		noun 20
		onMeCheck 16384
	)
)

(instance myWalk of Walk
	(properties)

	(method (init)
		(super init: &rest)
		(if (<= (chief x:) 223)
			(= cycleDir 1)
		else
			(= cycleDir -1)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (self nextCel:))
		(cond
			((== cycleDir -1)
				(if (< temp0 0)
					(self cycleDone:)
				else
					(client cel: temp0)
				)
			)
			((> temp0 (client lastCel:))
				(self cycleDone:)
			)
			(else
				(client cel: temp0)
			)
		)
	)

	(method (cycleDone)
		(if (== cycleDir -1)
			(client cel: (client lastCel:))
		else
			(client cel: 0)
		)
	)
)

(instance wSound of Sound
	(properties
		number 365
	)
)

