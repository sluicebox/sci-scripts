;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 701)
(include sci.sh)
(use Main)
(use TargFeature)
(use Teller)
(use n026)
(use OccasionalCycle)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	monkeysWith 0
	monkeysEnter 1
	manuInCage 2
	openCage 3
	manuLeave 4
	manuEncounter2 5
	cage 6
)

(local
	local0
	[local1 10]
	local11
	local12
	local13
	[local14 10] = [100 130 160 190 220 115 145 175 215 245]
	[local24 10] = [155 147 173 135 170 162 119 133 140 167]
	[local34 6] = [0 26 68 69 67 999]
	[local40 5] = [0 66 -36 31 999]
	[local45 4] = [0 100 999 999]
	[local49 3] = [0 76 999]
	[local52 6]
	[local58 6]
)

(instance monkeysWith of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(for ((= temp0 0)) (< temp0 10) ((++ temp0))
					((= [local1 temp0] (Actor new:))
						view: 985
						loop: (Random 0 3)
						moveSpeed: 0
						cycleSpeed: 0
						signal: 16384
						posn: [local14 temp0] [local24 temp0]
						setCycle: Walk
						init:
					)
				)
				(= cycles 2)
			)
			(1
				(ShakeScreen 1)
				(gMessager say: 5 6 70 0 self 700) ; "Bad thing! Very Bad Thing! Run!"
			)
			(2
				(for ((= temp0 0)) (< temp0 10) ((++ temp0))
					([local1 temp0]
						setScript: (monkeyExit new:) 0 [local1 temp0]
					)
				)
				(= seconds 4)
			)
			(3
				(HandsOn)
				(= seconds 5)
			)
			(4
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if (not (Random 0 30))
			(ShakeScreen 1)
		)
		(super doit:)
	)
)

(instance manuEnter of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(register setMotion: PolyPath [local14 9] [local24 9] self)
			)
			(1
				(= seconds 3)
			)
			(2
				(if local11
					(gEgo solvePuzzle: 212 3 1)
					(gMessager say: 5 6 77 0 self 700) ; "Good! Good! Man-friend kill ugly very bad thing. Man-friend very brave! Man-friend very strong. Manu very happy."
				else
					(gMessager say: 5 6 78 0 self 700) ; "Very bad thing very far away. Man-friend fool very bad thing. Man-friend very smart."
				)
			)
			(3
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance monkeysEnter of Script
	(properties)

	(method (init param1 param2 param3 param4)
		(= lastTicks gGameTime)
		(if (>= argc 1)
			((= client param1) script: self)
			(if (>= argc 2)
				(= caller param2)
				(if (>= argc 3)
					(= register param3)
					(if (>= argc 4)
						(= local11 param4)
					)
				)
			)
		)
		(= state (- start 1))
		(self cue:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 160 156 self)
				(for ((= temp0 0)) (< temp0 10) ((++ temp0))
					((= [local1 temp0] (Actor new:))
						view: 985
						loop: (Random 0 3)
						moveSpeed: 0
						cycleSpeed: 0
						x: (if (Random 0 1) -50 else 350)
						y: (Random 100 500)
						signal: 16384
						setCycle: Walk
						init:
					)
					(if (== temp0 9)
						([local1 temp0] setScript: manuEnter 0 [local1 temp0])
					else
						([local1 temp0]
							setMotion: PolyPath [local14 temp0] [local24 temp0]
						)
					)
				)
			)
			(1
				(Face gEgo 160 200)
				(self dispose:)
			)
		)
	)
)

(instance monkeyExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(register
					setMotion:
						PolyPath
						(if (Random 0 1) -50 else 350)
						(Random 100 500)
						self
				)
			)
			(1
				(register dispose:)
			)
		)
	)
)

(instance manuInCage of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(cage
					init:
					approachX: 154
					approachY: 153
					approachVerbs: 4 20 12 ; Do, theDaggers, theFineDagger
					signal: 16384
				)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 160 133 178 152 110 152 95 133
							yourself:
						)
				)
				(manu700 init: cycleSpeed: 18 setCycle: Fwd)
				(self dispose:)
			)
		)
	)
)

(instance openCage of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 109)
				(if local0
					(gEgo setHeading: 270 self)
				else
					(= state 3)
					(self cue:)
				)
				(cage approachVerbs:)
			)
			(1
				(gEgo view: 4 loop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(= cycles 20)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize: setHeading: 100)
				(cage cel: 1)
				(gLongSong2 number: 481 setLoop: 1 play:)
				(manu700
					setLoop: 2
					cel: 0
					setCycle: Walk
					cycleSpeed: 0
					moveSpeed: 0
					setMotion: MoveTo 350 160 self
				)
			)
			(5
				(gEgo solvePuzzle: 315 8)
				(= seconds 3)
			)
			(6
				(manu700
					setLoop: 3
					x: 330
					y: 34
					signal: (| (manu700 signal:) $0010)
					priority: 15
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: MoveTo 291 45 self
				)
			)
			(7
				(manu700
					loop: 4
					z: 100
					y: (+ (manu700 y:) 100)
					setCycle: OccasionalCycle manu700 1 50 100
				)
				(= [local52 0] @local34)
				(= [local58 0] @local40)
				(manuTell init: manu700 @local34 @local52)
				(egoTell init: gEgo @local40 @local58)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance manuEncounter2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(manu700
					init:
					setCycle: Walk
					x: 330
					y: 34
					signal: (| (manu700 signal:) $0010)
					priority: 15
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: MoveTo 291 45 self
					setLoop: 3
				)
			)
			(1
				(manu700
					z: 100
					y: (+ (manu700 y:) 100)
					loop: 4
					setCycle: OccasionalCycle manu700 1 50 100
				)
				(gMessager say: 5 6 9) ; "Man-friend! Manu very happy to see man-friend."
				(= [local58 0] @local45)
				(egoTell init: gEgo @local45 @local58)
				(= [local52 0] @local49)
				(manuTell init: manu700 @local49 @local52)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance manuLead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ClearFlag 105)
				(= cycles 20)
			)
			(1
				(SetFlag 93)
				(manu700
					z: 0
					y: (- (manu700 y:) 100)
					setLoop: 2
					setCycle: Walk
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: MoveTo 340 34
				)
				(gEgo setMotion: PolyPath 350 160 self solvePuzzle: 316 3)
			)
		)
	)
)

(instance manuLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(manu700
					z: 0
					y: (- (manu700 y:) 100)
					setLoop: 2
					setCycle: Walk
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: MoveTo 340 34 self
				)
				(egoTell dispose:)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance manu700 of TargActor
	(properties
		x 131
		y 146
		noun 5
		view 987
		loop 1
		cel 3
		priority 7
		signal 24592
		cycleSpeed 1
		moveSpeed 0
	)

	(method (init)
		(self approachVerbs: 12 13 11) ; theFineDagger, theFineSpear, theSword
		(super init:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 12 13 11) ; theFineDagger, theFineSpear, theSword
			(EgoDead 7) ; "Wow, that was an impressive victory! You've managed to defeat a defenseless monkey nearly 1/4 your size. Your Karma overcomes you when the monkey's uncle, King Kong, crushes you. Try to be kinder to animals in your next incarnation."
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (getHurt)
		(EgoDead 7) ; "Wow, that was an impressive victory! You've managed to defeat a defenseless monkey nearly 1/4 your size. Your Karma overcomes you when the monkey's uncle, King Kong, crushes you. Try to be kinder to animals in your next incarnation."
	)
)

(instance cage of View
	(properties
		x 133
		y 147
		noun 8
		view 987
	)

	(method (doVerb theVerb)
		(cond
			((or (== theVerb 4) (== theVerb 20)) ; Do, theDaggers
				(if (not (IsFlag 109))
					(= local0 1)
					(manu700 setScript: openCage)
				else
					(super doVerb: theVerb &rest)
				)
			)
			((== theVerb -75) ; openSpell
				(manu700 setScript: openCage)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance egoTell of Teller
	(properties)

	(method (dispose)
		(if client
			(client actions: 0)
		)
		(super dispose:)
	)

	(method (doChild param1)
		(cond
			((== param1 -10) ; "Agree"
				(gEgo setScript: manuLead)
				(return 1)
			)
			((== param1 -36)
				(gEgo setScript: manuLeave)
			)
			(else
				(++ local13)
				(gMessager say: 2 5 11 1 0 700) ; "You decline Manu's offer."
				(if (< local13 3)
					(gMessager say: 2 5 11 (+ local13 1) 0 700)
				else
					(gMessager say: 2 5 11 5 0 700) ; "Man-friend make Manu very sad. Manu not happy monkey. Man-friend come to monkey village with Manu. Manu very happy monkey. Man-friend very happy man-friend."
					(gMessager say: 2 5 11 6 0 700) ; "You reluctantly agree to go to the village."
					(gEgo setScript: manuLead)
				)
				(return 0)
			)
		)
	)
)

(instance manuTell of Teller
	(properties)

	(method (doDialog &tmp temp0)
		(= temp0 (super doDialog: &rest))
		(if (== global365 8)
			(if (!= temp0 -999)
				(++ local12)
			)
			(if (== local12 3)
				(client setScript: manuLeave)
			)
		else
			(= [local45 1] -10)
			(= [local45 2] -11)
		)
		(return temp0)
	)
)

