;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm017 0
)

(instance rm017 of Rm
	(properties
		picture 17
		style 0
		north 10
		east 18
		south 24
		west 16
	)

	(method (init)
		(super init:)
		(if (or (== gPrevRoomNum north) (== gPrevRoomNum west) (== gPrevRoomNum east))
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 246 86 177 77 183 52 160 52 160 76 113 77 67 79 27 79 22 51 46 0 315 0 315 94
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 315 196 0 196 0 88 18 80 32 85 63 84 84 84 151 88 314 105
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 9 312 9 311 194 180 193 151 147 175 122 195 118 210 117 218 113 96 95 94 108 60 124 37 127 79 196 0 196
						yourself:
					)
			)
		)
		(bfly init: setScript: bflyWait)
		(NormalEgo)
		(switch gPrevRoomNum
			(north
				(= global345 outCode1)
				(gEgo edgeHit: EDGE_NONE posn: 172 70)
				(self setScript: gStdWalkIn)
			)
			(south
				(= global345 outCode2)
				(gEgo posn: (proc0_13 58 (gEgo x:) 149) 139)
				(self setScript: gStdWalkIn)
			)
			(west
				(= global345 outCode1)
				(gEgo posn: 47 84)
				(self setScript: gStdWalkIn)
			)
			(east
				(= global345 outCode1)
				(gEgo posn: 231 89)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(= global345 outCode2)
				(gEgo posn: 124 116 init:)
			)
		)
		(if (and global130 (<= global130 47))
			(switch gPrevRoomNum
				(south
					(global129 observeControl: 128)
				)
				(45 ; mapRoom
					(global129 observeControl: (~ (gEgo onControl: 0)))
				)
				(else
					(global129 observeControl: 256)
				)
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
			((& (gEgo onControl: 1) $0010)
				(gStdWalkOut register: 4)
				(self setScript: gStdWalkOut)
			)
			((gEgo inRect: 155 62 185 68)
				(self newRoom: 10)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)
)

(instance bfly of Actor
	(properties
		x 50
		y 64
		yStep 1
		view 151
		priority 6
		signal 26640
		illegalBits 0
		xStep 1
	)

	(method (init)
		(super init:)
		(self setScript: bflyWait)
	)

	(method (doVerb)
		(cond
			((== script bflyWait)
				(self setScript: bflyLand)
			)
			((and (== script bflyLand) (< (script state:) 4))
				(bflyLand cycles: 0 changeState: 4)
			)
			(else
				(super doVerb: &rest)
			)
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
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance bflyLand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bfly
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
				(bfly
					setPri: (+ (gEgo priority:) 1)
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 26) self
				)
			)
			(3
				(bfly cycleSpeed: 5)
				(if
					(or
						(!= (bfly x:) (gEgo x:))
						(!= (bfly y:) (- (gEgo y:) 26))
					)
					(bfly cycleSpeed: 3 setMotion: MoveTo 5 45 self)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(4
				(bfly setPri: 15 setMotion: MoveTo 30 70 self)
			)
			(5
				(bfly setMotion: MoveTo -4 80 self)
			)
			(6
				(= seconds 3)
			)
			(7
				(bfly
					x: 96
					y: 169
					cycleSpeed: 6
					setStep: 2 2
					setLoop: 1
					setCel: 7
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
					setCel: 1
					setCycle: Fwd
					setMotion: MoveTo 130 -10 self
				)
			)
			(10
				(bfly dispose:)
			)
		)
	)
)

(instance outCode1 of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 159 (gEgo x:) 185))
				(= temp1 47)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 88 (gEgo y:) 109))
			)
			(3
				(= temp0 (proc0_13 50 (gEgo x:) 251))
				(= temp1 114)
			)
			(4
				(= temp0 10)
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
				(= temp0 223)
				(= temp1 (proc0_13 111 (gEgo y:) 138))
			)
			(3
				(= temp0 (proc0_13 57 (gEgo x:) 153))
				(= temp1 158)
			)
			(4
				(= temp0 32)
				(= temp1 (proc0_13 117 (gEgo y:) 140))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

