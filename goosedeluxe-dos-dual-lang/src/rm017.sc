;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use MGRoom)
(use PolyPath)
(use Polygon)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm017 0
)

(instance rm017 of MGRoom
	(properties
		picture 17
		north 10
		east 18
		south 24
		west 16
	)

	(method (init)
		(super init:)
		(gEgo init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 315 94 246 86 177 77 183 52 160 52 160 76 113 77 67 79 11 70 -30 70 -30 88 0 88 18 80 32 85 63 84 84 84 151 88 314 105
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 92 102 85 117 70 128 22 135 67 167 161 169 150 158 151 139 169 112 132 105 93 100
					yourself:
				)
		)
		(bfly init:)
		(switch gPrevRoomNum
			(north
				(= global305 outCode1)
				(self edgeS: 255)
				(gEgo edgeHit: EDGE_NONE posn: 172 70)
				(self setScript: gStdWalkIn)
			)
			(south
				(= global305 outCode2)
				(self edgeN: -1)
				(gEgo posn: (proc0_13 58 (gEgo x:) 149) 139)
				(self setScript: gStdWalkIn)
			)
			(west
				(= global305 outCode1)
				(self edgeS: 255)
				(gEgo posn: 47 84)
				(self setScript: gStdWalkIn)
			)
			(east
				(= global305 outCode1)
				(self edgeS: 255)
				(gEgo posn: 231 89)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(if (>= global174 100)
					(= global305 outCode2)
					(self edgeN: -1)
				else
					(= global305 outCode1)
					(self edgeS: 255)
				)
				(gEgo posn: global173 global174 init:)
				(gGame handsOn:)
			)
			(else
				(= global305 outCode2)
				(self edgeN: -1)
				(gEgo posn: 100 139 init:)
				(gGame handsOn:)
			)
		)
		(proc0_8 92 152)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== gScore gPossibleScore)
				(++ gScore)
				(self setScript: (ScriptID 205)) ; walkTo
			)
			((gEgo inRect: 159 54 179 69)
				(bflySound loop: 1 stop:)
				(gCurRoom newRoom: 10)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(bflySound loop: 1 stop:)
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)
)

(instance bfly of Actor
	(properties
		x 44
		y 66
		view 151
		yStep 1
		xStep 1
		moveSpeed 4
	)

	(method (init)
		(super init:)
		(self setPri: 180 ignoreActors: ignoreHorizon: setScript: bflyWait)
	)

	(method (doVerb)
		(if (and (== script bflyWait) (< (bfly distanceTo: gEgo) 90))
			(self setScript: bflyLand)
		else
			(super doVerb: &rest)
		)
	)

	(method (doit)
		(if
			(and
				(== script bflyLand)
				(< (script state:) 4)
				(> (bfly distanceTo: gEgo) 90)
			)
			(bfly setMotion: 0)
			(bflyLand cycles: 0 changeState: 4)
		else
			(super doit: &rest)
		)
	)
)

(instance bflyWait of Script
	(properties)

	(method (doit)
		(if (< (bfly distanceTo: gEgo) 60)
			(bfly setScript: bflyLand)
		else
			(super doit:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 4))
			)
			(1
				(bfly setCycle: End self)
			)
			(2
				(bfly setCycle: Beg self)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance bflyLand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bflySound number: 812 loop: -1 play:)
				(bfly
					setLoop: 0 1
					setCycle: Fwd
					setMotion:
						MoveTo
						(- (gEgo x:) 12)
						(- (gEgo y:) 40)
						self
				)
			)
			(1
				(bfly
					setMotion:
						MoveTo
						(+ (gEgo x:) 12)
						(- (gEgo y:) 35)
						self
				)
			)
			(2
				(bfly setMotion: MoveTo (gEgo x:) (- (gEgo y:) 28) self)
			)
			(3
				(bfly cycleSpeed: 5)
				(if
					(or
						(!= (bfly x:) (gEgo x:))
						(!= (bfly y:) (- (gEgo y:) 28))
					)
					(bfly cycleSpeed: 3 setMotion: MoveTo 5 45 self)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(4
				(bflySound number: 812 loop: -1 play:)
				(bfly setMotion: MoveTo 30 70 self)
			)
			(5
				(bfly setMotion: MoveTo -4 80 self)
			)
			(6
				(bflySound fade: 0 10 3 1)
				(= seconds 3)
			)
			(7
				(bflySound number: 810 play:)
				(bfly
					x: 96
					y: 169
					cycleSpeed: 6
					setStep: 2 2
					setLoop: 1
					cel: 7
					setCycle: Beg self
					setMotion: MoveTo 110 30
				)
			)
			(8
				(= cycles 1)
			)
			(9
				(bfly
					setLoop: 2
					cel: 1
					cycleSpeed: 15
					setCycle: Fwd
					setMotion: MoveTo 130 -10 self
				)
			)
			(10
				(bflySound loop: 1 stop:)
				(client dispose:)
			)
		)
	)
)

(instance bflySound of Sound
	(properties)
)

(instance outCode1 of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 160 (gEgo x:) 183))
				(= temp1 54)
			)
			(2
				(= temp0 262)
				(= temp1 (proc0_13 88 (gEgo y:) 109))
			)
			(3
				(= temp0 (proc0_13 50 (gEgo x:) 251))
				(= temp1 114)
			)
			(4
				(= temp0 -5)
				(= temp1 (proc0_13 66 (gEgo y:) 81))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

(instance outCode2 of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 95 (gEgo x:) 215))
				(= temp1 91)
			)
			(2
				(= temp0 262)
				(= temp1 (proc0_13 111 (gEgo y:) 138))
			)
			(3
				(= temp0 (proc0_13 57 (gEgo x:) 153))
				(= temp1 166)
			)
			(4
				(= temp0 -5)
				(= temp1 (proc0_13 117 (gEgo y:) 140))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

