;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use ExitFeature)
(use eRS)
(use Village)
(use Talker)
(use Scaler)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	rm300 0
	babyTalker 1
)

(local
	local0
	local1
	local2
	local3
	local4
	[local5 49] = [0 0 38 37 0 1 36 47 0 2 38 56 0 3 44 69 0 4 43 81 0 5 42 90 0 6 49 100 0 7 43 113 0 8 40 116 0 9 37 120 0 10 41 156 0 11 45 152 -32768]
	local54
	local55
	local56
	local57
	local58 = 80
	local59
)

(instance rm300 of Eco2Room
	(properties
		noun 11
		picture 300
		style 10
		north 400
		east 330
	)

	(method (init)
		(Load rsMESSAGE 300)
		(if (gEgo has: 10)
			(LoadMany rsVIEW 300 81 318 310 320 351 321 322 950)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 0 319 140 297 117 238 133 184 142 177 151 142 151 139 130 70 100 80 64 78 49 61 39 73 -1
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 114 0 -2 57 -6 57 35 47 74 47 125 47 133 102 151 139 158 139 187 319 187 319 189 0 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 99 121 99 134 55 134 55 121
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 236 155 313 155 313 170 271 170 251 179 227 170
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 236 155 313 155 313 170 271 170 251 179 227 170
						yourself:
					)
			)
			(lizard init:)
			(if (gCurrentRegionFlags test: 73)
				(clayCup x: 81 loop: 6 cel: 9 init:)
			)
			(chief init: setScript: quarr approachVerbs: 2 4 21 23 20) ; Talk, Do, charm, machete, pods
			(if (not (gCurrentRegionFlags test: 1))
				(suiter init: cue:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 236 155 313 155 313 170 271 170 251 179 227 170
							yourself:
						)
				)
			else
				(chief setLoop: 1)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 231 157 289 157 289 178 231 178
							yourself:
						)
				)
			)
			(if (not (gCurrentRegionFlags test: 5))
				(aMachete init:)
			)
			(potteryWork init:)
			(if (gCurrentRegionFlags test: 3)
				(potter init: setLoop: 0 cycleSpeed: 24 setCycle: Fwd)
				(baby init: stopUpd:)
			else
				(potter init: stopUpd:)
				(baby init: setScript: rockBaby)
			)
			(storyTeller init: cue: approachVerbs: 2) ; Talk
			(boy init:)
			(girl init:)
			(sleep1 init:)
			(sleep2 init:)
		else
			(LoadMany rsVIEW 300 301 305 950)
			(LoadMany rsVIEW 300 301 305 950)
			(gDirectionHandler addToFront: self)
			(gKeyDownHandler addToFront: self)
			(gMouseDownHandler addToFront: self)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 0 319 140 297 117 238 133 184 142 177 151 142 151 139 130 70 100 80 64 78 49 61 39 73 -1
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 114 0 -2 52 -4 57 44 37 86 47 125 47 133 102 151 77 169 77 183 319 183 319 189 0 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 99 121 99 134 55 134 55 121
						yourself:
					)
			)
		)
		(exitnorth init:)
		(exiteast init:)
		(mud init: setOnMeCheck: 1 32)
		(path init:)
		(pots init:)
		(largePot init:)
		(longHouse init: setOnMeCheck: 1 8)
		(cookFire init:)
		(foliage init: setOnMeCheck: 1 2)
		(blueFlower init: setOnMeCheck: 1 16)
		(forest init:)
		(tree init: setOnMeCheck: 1 4)
		(switch gPrevRoomNum
			(400
				(super init:)
				(gGameSound1
					number: (if (gEgo has: 10) 309 else 308)
					setLoop: -1
					play:
				)
				(gCurRoom setScript: goUp)
			)
			(330
				(= style 11)
				(super init:)
				(gEgo x: 310 init: normalize: setScale: Scaler 100 58 160 38)
				(gGame handsOn:)
			)
			(else
				(gWalkHandler addToFront: self)
				(super init:)
				(gEgo
					view: 301
					setLoop: 0
					setCel: 0
					x: 39
					y: -10
					setPri: 10
					edgeHit: 1
					init:
					setScale: 0
				)
				(theFruit init:)
				(peccary init:)
				(theRope init:)
				(onTheGround init:)
				(gCurRoom setScript: fallsIn)
			)
		)
		(if (gCurrentRegionFlags test: 4)
			(butterfly init:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gMessager say: 3 4 9) ; "At the moment, Adam is a real stick-in-the-mud. He can't pull himself out."
			)
			(1 ; Look
				(if (gEgo has: 10)
					(gMessager say: 11 1 8) ; "The village is alive with the sounds of people going about their business. They look at Adam curiously and then look quickly away."
				else
					(gMessager say: 11 1 7) ; "A small village has been carefully carved from the dense forest. No one seems to be here, but Adam has the feeling he's being watched."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (< (gEgo y:) 38) (not script))
			(gCurRoom setScript: goDown)
		)
	)

	(method (dispose)
		(gDirectionHandler delete: self)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)
)

(instance flyStay of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if (and (& (butterfly onControl:) $4000) (not (Random 0 3)))
					(butterfly cycleSpeed: 12 setCycle: Fwd)
					(= seconds (Random 4 6))
				else
					(self changeState: 2)
				)
			)
			(1
				(butterfly cycleSpeed: 4 setCycle: Walk)
				(self cue:)
			)
			(2
				(cond
					((< (butterfly x:) -5)
						(= temp0 (Random 5 20))
					)
					((> (butterfly x:) 330)
						(= temp0 (- 0 (Random 5 20)))
					)
					(else
						(= temp0 (- (Random 10 40) 25))
					)
				)
				(cond
					((< (butterfly y:) 60)
						(= temp1 (Random 5 20))
					)
					((> (butterfly y:) 190)
						(= temp1 (- 0 (Random 5 20)))
					)
					(else
						(= temp1 (- (Random 5 25) 15))
					)
				)
				(butterfly
					setMotion:
						MoveTo
						(+ (butterfly x:) temp0)
						(+ (butterfly y:) temp1)
						self
				)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance rockBaby of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 6))
			)
			(1
				(baby setLoop: 0 setCycle: Fwd)
				(= seconds (Random 1 3))
			)
			(2
				(potter setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(potter setCycle: Beg)
				(baby setLoop: 1 setCycle: Fwd)
				(= seconds (Random 7 15))
			)
			(4
				(baby stopUpd:)
				(potter stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

(instance quarr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(chief
					setLoop: (if (gCurrentRegionFlags test: 1) 1 else 0)
					cel: (chief lastCel:)
					setCycle: Beg self
				)
			)
			(1
				(chief stopUpd:)
				(= seconds (Random 3 7))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance fallsIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local0 1)
				(= register (gEgo cycleSpeed:))
				(= cycles 10)
			)
			(1
				(gGameSound1 number: 601 setLoop: 1 play:)
				(gEgo get: 9 cycleSpeed: 4 setCycle: MCyc @local5 self)
			)
			(2
				(gGameSound1 number: 303 play:)
				(gEgo hide:)
				(splat init: setCycle: End)
				(ShakeScreen 1)
				(peccary setScript: peccaryMoves)
				(= seconds 3)
			)
			(3
				(gEgo
					y: 149
					setLoop: 2
					setCel: 0
					setPri: 12
					ignoreActors:
					cycleSpeed: register
					show:
					setCycle: End
				)
				(splat setCycle: Beg self)
			)
			(4
				(splat dispose:)
				(self dispose:)
			)
		)
	)
)

(instance getTheItem of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 5)
			)
			(1
				(gEgo view: 301 setLoop: 4 setCycle: End self)
			)
			(2
				(gEgo get: register setCycle: Beg self)
				(Village points: 5)
			)
			(3
				(local4 dispose:)
				(gGame handsOn:)
				(gUser canInput: 1)
				(gUser canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance lassoThePig of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (<= 11 state 13)
			(gEgo x: (- (peccary x:) 48) y: (- (peccary y:) 12))
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (gEgo cycleSpeed:))
				(LoadMany rsVIEW 302 306)
				(= cycles 5)
			)
			(1
				(gEgo view: 302 setLoop: 2 moveSpeed: 6 setCycle: End self)
			)
			(2
				(gEgo setLoop: 3 setCycle: End self)
			)
			(3
				(gEgo setLoop: 4 setCycle: End self)
			)
			(4
				(if (< (peccary x:) 155)
					(if (IsObject theFruit)
						(theFruit dispose:)
					)
					(gGameSound1 number: 307 play:)
					(gGameSound2 number: 311 play:)
					(peccary hide:)
					(Village points: 5)
					(gEgo
						x: (- (peccary x:) 85)
						y: (+ (peccary y:) 1)
						setLoop: 8
					)
				else
					(gEgo setLoop: 7)
				)
				(self cue:)
			)
			(5
				(if (== (gEgo loop:) 8)
					(self changeState: 10)
				else
					(gEgo setCycle: End self)
				)
			)
			(6
				(gEgo view: 302 setLoop: 5 cel: 0 setCycle: End self)
			)
			(7
				(gEgo setLoop: 2 setCel: 0)
				(theRope dispose:)
				(= ticks 10)
			)
			(8
				(gGame handsOn:)
				(gUser canInput: 1)
				(gUser canControl: 0)
				(gEgo cycleSpeed: register)
				(self dispose:)
			)
			(9
				(gGameSound2 number: 311 play:)
				(peccary cycleSpeed: 6 setScript: 0 hide:)
				(self cue:)
			)
			(10
				(gEgo setCycle: End self)
			)
			(11
				(gEgo
					view: 306
					put: 4
					put: 6
					setLoop: 1
					setCel: 0
					setCycle: Fwd
				)
				(peccary
					view: 306
					setLoop: 0
					setCel: 0
					x: (+ (gEgo x:) 103)
					y: (+ (gEgo y:) 1)
					cycleSpeed: 3
					ignoreActors:
					setCycle: Fwd
					show:
					setMotion: MoveTo 169 165 self
				)
			)
			(12
				(peccary
					ignoreActors:
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo 207 163 self
				)
			)
			(13
				(gEgo setLoop: 2 cel: 0 setCycle: End)
				(peccary setMotion: MoveTo 280 163 self)
			)
			(14
				(gWalkHandler delete: gCurRoom)
				(gGameSound2 stop:)
				(peccary cycleSpeed: 6 setStep: 14 8 setMotion: MoveTo 380 161)
				(gEgo
					setLoop: 3
					x: (- (gEgo x:) 47)
					y: (+ (gEgo y:) 11)
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(15
				(gGameSound1 number: 308 setLoop: -1 play:)
				(gEgo setLoop: 4 cycleSpeed: 7 setCycle: End self)
			)
			(16
				(= local0 0)
				(gDirectionHandler delete: gCurRoom)
				(gKeyDownHandler delete: gCurRoom)
				(gMouseDownHandler delete: gCurRoom)
				(gEgo
					normalize: 0 2
					setScale: Scaler 100 58 160 38
					cycleSpeed: register
				)
				(peccary dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance peccaryMoves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGameSound2 number: 305 setLoop: -1 play:)
				(if (not local1)
					(self cue:)
				else
					(peccary
						setLoop: 0
						setCel: 0
						cycleSpeed: 6
						setCycle: Walk
						setMotion: MoveTo (+ local2 28) (+ local3 5) self
					)
				)
			)
			(1
				(if (not local1)
					(peccary setCycle: CT 4 1 self)
				else
					(self cue:)
				)
			)
			(2
				(if (not local1)
					(= seconds 2)
				else
					(peccary setLoop: 2 setCycle: End self)
				)
			)
			(3
				(if (not local1)
					(peccary cycleSpeed: 15 setCel: 4 setCycle: CT 0 -1 self)
				else
					(peccary setLoop: 2 cycleSpeed: 12 setCycle: Beg self)
				)
			)
			(4
				(if (not local1)
					(self cue:)
				else
					(gGame handsOn:)
					(gUser canInput: 1)
					(gUser canControl: 0)
					(if (IsObject theFruit)
						(theFruit setLoop: 9 cel: 0)
						(peccary setCycle: (eatCycle new:) self)
					else
						(peccary setCycle: Fwd)
						(= seconds (Random 4 9))
					)
				)
			)
			(5
				(if (not local1)
					(self cue:)
				else
					(gGame handsOff:)
					(peccary setLoop: 4 setCycle: End self)
				)
			)
			(6
				(peccary
					cycleSpeed: 6
					setLoop: 1
					setCel: 0
					posn: (- (peccary x:) 2) (+ (peccary y:) 1)
					setCycle: Walk
					setMotion: MoveTo 254 177 self
				)
			)
			(7
				(peccary cycleSpeed: 12 setLoop: 5 setCycle: End self)
			)
			(8
				(gGameSound2 stop:)
				(= local1 1)
				(gGame handsOn:)
				(gUser canInput: 1)
				(gUser canControl: 0)
				(client setScript: randomEats)
			)
		)
	)
)

(instance randomEats of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 10 40))
			)
			(1
				(peccary setLoop: 2 setCycle: Fwd)
				(= ticks (Random 120 240))
			)
			(2
				(peccary setCel: 0 setCycle: 0)
				(= ticks (Random 30 120))
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance throwFruit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 5)
			)
			(1
				(gEgo view: 302 setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(theFruit
					view: 302
					x: 73
					y: 121
					moveSpeed: 2
					init:
					setPri: 13
					setStep: 5 3
					setLoop: 1
					cel: 0
					setMotion: MoveTo 97 105 self
				)
			)
			(3
				(= local2 (Random 119 128))
				(= local3 (Random 150 160))
				(theFruit
					setPri: -1
					moveSpeed: 1
					setLoop: 1
					setCycle: End self
					cel: 0
					setMotion: (myMoveTo new:) local2 local3 self
				)
			)
			(4 0)
			(5
				(gGameSound2 number: 722 setLoop: 1 play:)
				(gEgo view: 301 setLoop: 3 cel: 0)
				(= cycles 5)
			)
			(6
				(peccary setScript: peccaryMoves)
				(self dispose:)
			)
		)
	)
)

(instance getNothing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(chief setScript: 0)
				(= cycles 3)
			)
			(1
				(gEgo view: 5 setLoop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(chief setLoop: 2 cel: 0 setCycle: End self)
			)
			(3
				(gMessager say: 18 4 0 0 self) ; "I cannot talk to you - Llusti is most difficult."
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(gEgo normalize: 0)
				(chief setScript: quarr)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getMachete of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 18 4 1 0 self) ; "Ah, my machete! By all means, you may use it."
			)
			(1
				(gEgo view: 5 setLoop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(Village points: 5)
				(= ticks 12)
			)
			(3
				(aMachete dispose:)
				(gEgo get: 14 setCycle: End self)
			)
			(4
				(gCurrentRegionFlags set: 5)
				(gEgo normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 5)
			)
			(1
				(gEgo
					setLoop: (gEgo loop:)
					setPri: 0
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 30) self
				)
			)
			(2
				(gCurRoom newRoom: 400)
			)
		)
	)
)

(instance goUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 0
					x: 61
					y: 68
					setScale: Scaler 100 58 160 38
					setPri: 0
					setLoop: 2
					init:
					setCycle: Walk
					setMotion: MoveTo 61 37 self
				)
			)
			(1
				(gEgo setLoop: -1 setPri: 1 setMotion: MoveTo 61 60 self)
			)
			(2
				(gEgo normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getButterfly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Village points: 5)
				(= register (gEgo cycleSpeed:))
				(= cycles 3)
			)
			(1
				(gEgo
					view: 5
					setLoop: 1
					cycleSpeed: 6
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(2
				(clayCup init:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo
					view: 0
					setLoop: 1
					setCycle: Rev
					setMotion: MoveTo (+ (gEgo x:) 15) (gEgo y:) self
				)
			)
			(4
				(gEgo setCycle: 0)
				(= cycles 3)
			)
			(5
				(butterfly
					cycleSpeed: 3
					setCycle: Walk
					setMotion: MoveTo 29 101 self
				)
			)
			(6
				(butterfly dispose:)
				(clayCup
					cycleSpeed: 10
					x: 81
					setLoop: 6
					cel: 0
					setCycle: End self
				)
			)
			(7
				(gEgo put: 18 normalize: 0 1 cycleSpeed: register)
				(gCurrentRegionFlags clear: 4)
				(gCurrentRegionFlags set: 73)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Village points: 5)
				(= register (gEgo cycleSpeed:))
				(= cycles 3)
			)
			(1
				(gCurrentRegionFlags clear: 73)
				(gEgo
					view: 5
					setLoop: 1
					cycleSpeed: 6
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(2
				((gInventory at: 18) loop: 2 cel: 3 message: 32 noun: 60)
				(clayCup dispose:)
				(gEgo setCycle: End self)
			)
			(3
				(gEgo get: 18 normalize: 0 1 cycleSpeed: register)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveMed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(baby setScript: 0)
				(= cycles 3)
			)
			(1
				(gEgo view: 4 setLoop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(2
				(potter setLoop: 1 cel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(3
				(gMessager say: 4 30 0 0 self) ; "The shaman's poultice for bee stings! You are very kind. I know it will help my baby."
			)
			(4
				(potter setCycle: Beg self)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(gMessager say: 11 0 10 0 self) ; "Adam takes a beautiful clay cup from the potter."
			)
			(7
				(potter setLoop: 1 cel: 0 setCycle: End self)
			)
			(8
				(baby setCycle: 0 setLoop: 1 cel: 0 stopUpd:)
				(potter setLoop: 0 cycleSpeed: 30 setCycle: Fwd)
				(gCurrentRegionFlags set: 3)
				(gEgo get: 15 put: 11 normalize: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(butterfly setMotion: MoveTo 91 74 self)
			)
			(1
				(if (gEgo has: 18)
					(butterfly setCycle: Fwd setMotion: MoveTo 30 84 self)
				else
					(butterfly setScript: flyStay)
					(self dispose:)
				)
			)
			(2
				(= local59 1)
				(butterfly cycleSpeed: 12)
				(self dispose:)
			)
		)
	)
)

(instance peccary of Actor
	(properties
		x 129
		y 160
		noun 15
		view 305
		loop 5
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 33))
			(switch theVerb
				(65 ; rainforest_fruit
					(gCurRoom setScript: throwFruit)
				)
				(14 ; vine
					(gCurRoom setScript: lassoThePig)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 33))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance theFruit of Actor
	(properties
		x 62
		y 134
		noun 27
		view 300
		loop 2
		signal 16384
	)

	(method (init)
		(super init:)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 12))
			(if (== theVerb 4) ; Do
				(= local4 theFruit)
				(gCurRoom setScript: getTheItem 0 4)
			else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(if (and (not (IsEcorderFlag 12)) (gEgo has: 6))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance splat of Prop
	(properties
		x 42
		y 145
		view 301
		loop 1
		cel 4
		priority 14
		signal 16400
		detailLevel 2
	)
)

(instance theRope of View
	(properties
		x 58
		y 135
		noun 31
		view 300
		signal 16385
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= local4 theRope)
			(gCurRoom setScript: getTheItem 0 6)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance butterfly of Actor
	(properties
		x 330
		y 100
		noun 19
		approachX 105
		approachY 134
		yStep 3
		view 81
		loop 5
		priority 15
		signal 24592
		maxScale 1
		cycleSpeed 3
		xStep 5
		moveSpeed 4
	)

	(method (setHeading param1)
		(if (not (& signal $0800))
			(super setHeading: param1 &rest)
			(= loop
				(switch loop
					(0 0)
					(1 1)
					(2 3)
					(3 2)
					(6 0)
					(4 0)
					(5 1)
					(7 1)
				)
			)
		)
	)

	(method (init)
		(super init:)
		(if (gEgo has: 18)
			(self approachVerbs: 72) ; sweetDrink
		)
		(self setCycle: Walk setScript: enterIn)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 35))
			(switch theVerb
				(72 ; sweetDrink
					(if (and (gCurrentRegionFlags test: 4) (not (self mover:)))
						(gCurRoom setScript: getButterfly)
					)
				)
				(1 ; Look
					(if local59
						(gMessager say: noun theVerb 6) ; "The butterfly pauses on the bright blue flowers."
					else
						(gMessager say: noun theVerb 0) ; "The blue butterfly darts and weaves just out of reach. It seems to tease Adam to catch it."
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 35))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance baby of Prop
	(properties
		x 89
		y 153
		noun 6
		approachX 143
		approachY 168
		view 318
		loop 1
		cel 1
		priority 13
		signal 16400
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 13 4 1 23) ; amulet, Do, Look, machete
			(if (gCurrentRegionFlags test: 3)
				(gMessager say: noun theVerb 1)
			else
				(super doVerb: theVerb)
			)
		else
			(switch theVerb
				(2 ; Talk
					(Village points: 1 76)
					(cond
						((gCurrentRegionFlags test: 35)
							(gMessager say: noun theVerb 13) ; "Please, do as the Shaman asks! You must enter his hut."
						)
						(local54
							(gMessager say: noun theVerb 15) ; "Oh, please don't, loud voices make him cry harder!"
						)
						((gCurrentRegionFlags test: 3)
							(gMessager say: noun theVerb 1) ; "Ssssh. I'm finally getting some work done."
						)
						(else
							(= local54 1)
							(super doVerb: theVerb)
						)
					)
				)
				(30 ; medicine
					(potter doVerb: theVerb)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4 2 30 26 19 25) ; Do, Talk, medicine, sap, barkCup, berries
	)
)

(instance potter of Prop
	(properties
		x 106
		y 169
		noun 4
		approachX 143
		approachY 168
		view 310
		cel 3
		priority 12
		signal 20496
		cycleSpeed 24
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4 2 30 26 19 25) ; Do, Talk, medicine, sap, barkCup, berries
	)

	(method (doVerb theVerb)
		(switch theVerb
			(21 ; charm
				(if local56
					(gMessager say: noun theVerb 3) ; "Please, I do not need the love charm. You keep it."
				else
					(= local56 1)
					(gCurrentRegionFlags set: 11)
					(Village points: 5)
					(gMessager say: noun theVerb 0) ; "I think I found your necklace! It was in those berry bushes."
				)
			)
			(1 ; Look
				(if (gCurrentRegionFlags test: 3)
					(gMessager say: noun theVerb 1) ; "The potter is busily working while the baby sleeps."
				else
					(gMessager say: noun theVerb 0) ; "A potter sits near the muddy hole. Her work is unfinished and she has a worried expression on her face."
				)
			)
			(2 ; Talk
				(Village points: 1 46)
				(cond
					((gCurrentRegionFlags test: 35)
						(gMessager say: noun theVerb 13) ; "You must see the shaman. I know he will help you."
					)
					((gCurrentRegionFlags test: 3)
						(gMessager say: noun theVerb 1) ; "He is sleeping quietly. We thank you and wish you well."
					)
					(local57
						(gMessager say: noun theVerb 15) ; "I must rock my baby. Oh, he feels so sick!"
					)
					(else
						(= local57 1)
						(gMessager say: noun theVerb 0) ; "Aieee, I cannot talk to you now, small one. The baby cries and cries and will not stop."
					)
				)
			)
			(19 ; barkCup
				(Village points: 1 66)
				(gMessager say: noun theVerb) ; "That's the shaman's medicine cup. He has often mixed a poultice for my baby in it."
			)
			(30 ; medicine
				(Village points: 5)
				(gCurRoom setScript: giveMed)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance chief of Prop
	(properties
		x 248
		y 170
		noun 13
		approachX 263
		approachY 154
		view 320
		signal 20480
		cycleSpeed 16
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 59))
			(switch theVerb
				(19 ; barkCup
					(if local55
						(gMessager say: noun theVerb 3) ; "I cannot discuss the shaman further. You must find the shaman."
					else
						(= local55 1)
						(Village points: 1 67)
						(gMessager say: noun theVerb 0) ; "I am not the shaman, young one. He would be angry if I used his medicine cup."
					)
				)
				(4 ; Do
					(if (gCurrentRegionFlags test: 1)
						(gMessager say: noun theVerb 1) ; "Never come between a chief and his iguana."
					else
						(gMessager say: noun theVerb 0) ; "I cannot speak to you now!"
					)
				)
				(1 ; Look
					(if (gCurrentRegionFlags test: 1)
						(gMessager say: noun theVerb 1) ; "The chief is relaxing. He's teaching his pet iguana a trick or two."
					else
						(gMessager say: noun theVerb 0) ; "A serious-looking older man talks sternly to a younger man."
					)
				)
				(2 ; Talk
					(Village points: 1 47)
					(cond
						((gCurrentRegionFlags test: 35)
							(gMessager say: noun theVerb 13) ; "The shaman will permit you to enter his hut now."
						)
						((gCurrentRegionFlags test: 1)
							(gMessager say: noun theVerb 1) ; "Ah, that one finally saw the error of his ways."
						)
						(else
							(super doVerb: theVerb)
						)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 59))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance suiter of Prop
	(properties
		x 304
		y 168
		noun 14
		approachX 273
		approachY 155
		view 351
		cel 1
		signal 20480
		maxScale 0
		cycleSpeed 10
	)

	(method (init)
		(super init:)
		(self approachVerbs: 21 2 20 4) ; charm, Talk, pods, Do
	)

	(method (cue)
		(if (< maxScale 3)
			(++ maxScale)
			(self cel: (+ (self cel:) 1) stopUpd:)
			((Timer new:) setReal: self (Random 3 6))
		else
			(= maxScale 0)
			(self cel: 0 stopUpd:)
			((Timer new:) setReal: self (Random 2 6))
		)
	)
)

(instance storyTeller of Prop
	(properties
		x 184
		y 127
		noun 23
		approachX 192
		approachY 143
		view 321
		signal 20480
		maxScale 1
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: noun theVerb 0) ; "An old man sits in the shade of the long house. He is telling stories to two young children."
			)
			(2 ; Talk
				(gMessager say: noun 0 0) ; "The storyteller is weaving a tale. He has no time for anything else."
			)
			(else
				(gMessager say: noun 0 0) ; "The storyteller is weaving a tale. He has no time for anything else."
			)
		)
	)

	(method (cue)
		(if maxScale
			(= maxScale 0)
			(self setLoop: 0 cel: 0 setCycle: End self)
		else
			(= maxScale 1)
			(self stopUpd:)
			((Timer new:) setReal: self (Random 2 5))
		)
	)
)

(instance sleep1 of Prop
	(properties
		x 259
		y 58
		noun 32
		view 322
		signal 20480
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance sleep2 of Prop
	(properties
		x 260
		y 83
		noun 32
		view 322
		loop 1
		signal 20480
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance girl of View
	(properties
		x 210
		y 99
		noun 25
		view 321
		loop 2
		priority 8
		signal 20496
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance boy of View
	(properties
		x 182
		y 86
		noun 24
		view 321
		loop 1
		signal 20480
	)

	(method (init)
		(super init:)
		(self addToPic:)
	)
)

(instance aMachete of View
	(properties
		x 272
		y 176
		noun 18
		approachX 261
		approachY 176
		view 300
		loop 4
		signal 16384
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4 stopUpd:) ; Do
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (gCurrentRegionFlags test: 1)
				(gEgo setScript: getMachete)
			else
				(gCurRoom setScript: getNothing)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance clayCup of Prop
	(properties
		x 82
		y 137
		noun 30
		approachX 105
		approachY 134
		view 300
		loop 3
		signal 16384
	)

	(method (init)
		(super init:)
		(self stopUpd: approachVerbs: 4) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: getIt)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance exiteast of ExitFeature
	(properties
		nsTop 122
		nsLeft 311
		nsBottom 164
		nsRight 319
		cursor 11
		exitDir 2
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
				(event claimed: 1)
				(if local0
					(gMessager say: 3 4 9) ; "At the moment, Adam is a real stick-in-the-mud. He can't pull himself out."
				else
					(gEgo setMotion: PolyPath temp0 temp1)
				)
			)
			(else
				(event claimed: 0)
			)
		)
		(event claimed:)
	)
)

(instance exitnorth of ExitFeature
	(properties
		nsTop 5
		nsLeft 48
		nsBottom 45
		nsRight 82
		cursor 13
		exitDir 1
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
				(event claimed: 1)
				(if local0
					(gMessager say: 3 4 9) ; "At the moment, Adam is a real stick-in-the-mud. He can't pull himself out."
				else
					(gEgo setMotion: PolyPath temp0 temp1)
				)
			)
			(else
				(event claimed: 0)
			)
		)
		(event claimed:)
	)
)

(instance onTheGround of Feature
	(properties
		x 56
		y 134
		noun 11
		nsTop 134
		nsLeft 56
		nsBottom 189
		nsRight 148
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(65 ; rainforest_fruit
				(gCurRoom setScript: throwFruit)
			)
			(14 ; vine
				(gCurRoom setScript: lassoThePig)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mud of Feature
	(properties
		x 37
		y 160
		noun 3
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if local0
				(gMessager say: 3 4 9) ; "At the moment, Adam is a real stick-in-the-mud. He can't pull himself out."
			else
				(gMessager say: 3 4 0) ; "Hey, I'm not jumpin' in. It's not my idea of a good time."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance path of Feature
	(properties
		x 66
		y 77
		noun 22
		nsTop 43
		nsLeft 53
		nsBottom 112
		nsRight 79
	)
)

(instance pots of Feature
	(properties
		x 76
		y 126
		noun 26
		nsTop 120
		nsLeft 56
		nsBottom 132
		nsRight 96
		approachX 105
		approachY 134
	)

	(method (init)
		(super init:)
		(if (gCurrentRegionFlags test: 4)
			(self approachVerbs: 72) ; sweetDrink
		)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 72) (gCurrentRegionFlags test: 4) (not (butterfly mover:))) ; sweetDrink
			(gCurRoom setScript: getButterfly)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance largePot of Feature
	(properties
		x 159
		y 139
		noun 9
		nsTop 131
		nsLeft 147
		nsBottom 147
		nsRight 171
	)
)

(instance longHouse of Feature
	(properties
		x 160
		y 5
		noun 1
		onMeCheck 8
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
		(if (not (IsEcorderFlag 58))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 58))
			(super doVerb: theVerb)
		)
	)
)

(instance lizard of Feature
	(properties
		x 268
		y 185
		noun 8
		nsTop 161
		nsLeft 261
		nsBottom 170
		nsRight 275
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
		(if (not (IsEcorderFlag 34))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 34))
			(super doVerb: theVerb)
		)
	)
)

(instance potteryWork of Feature
	(properties
		x 81
		y 182
		noun 4
		nsTop 155
		nsLeft 71
		nsBottom 170
		nsRight 92
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
		(if (not (IsEcorderFlag 57))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 57))
			(super doVerb: theVerb)
		)
	)
)

(instance cookFire of Feature
	(properties
		x 306
		y 105
		noun 7
		nsTop 92
		nsLeft 293
		nsBottom 118
		nsRight 319
	)
)

(instance foliage of Feature
	(properties
		x 160
		y 173
		noun 10
		onMeCheck 2
	)
)

(instance blueFlower of Feature
	(properties
		x 19
		y 30
		noun 2
		onMeCheck 16
	)
)

(instance forest of Feature
	(properties
		x 81
		y 12
		noun 28
		nsLeft 58
		nsBottom 25
		nsRight 104
	)
)

(instance tree of Feature
	(properties
		x 196
		y 3
		noun 29
		onMeCheck 4
	)
)

(instance eatCycle of End
	(properties)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp1 (client lastCel:))
		(if (> endCel temp1)
			(= endCel temp1)
		)
		(= temp0 (self nextCel:))
		(client
			cel:
				(cond
					((> temp0 temp1) 0)
					((< temp0 0) temp1)
					(else temp0)
				)
		)
		(if (and (== gGameTime cycleCnt) (== endCel (client cel:)))
			(if (IsObject theFruit)
				(if (< (= temp2 (+ (theFruit cel:) 1)) 8)
					(theFruit cel: temp2)
					(client cel: 0)
				else
					(self cycleDone:)
				)
			else
				(self cycleDone:)
			)
		)
	)
)

(instance myMoveTo of MoveTo
	(properties)

	(method (doit)
		(super doit:)
		(if (not (-- local58))
			(= local58 80)
			(++ dy)
		)
	)
)

(instance babyTalker of Narrator
	(properties
		back 62
	)
)

