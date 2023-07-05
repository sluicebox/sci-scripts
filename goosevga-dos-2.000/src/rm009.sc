;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use n411)
(use PolyPath)
(use Polygon)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm009 0
)

(instance rm009 of Rm
	(properties
		picture 9
		style 0
		horizon 50
		north 2
		east 10
		south 16
		west 8
	)

	(method (init)
		(= global345 outCode)
		(if ((gGoals at: 0) egoHas:)
			(Load rsSCRIPT 309)
			(= gShell2 0)
		)
		(Load rsVIEW 68)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 252 155 249 134 236 117 232 82 232 65 258 42 294 38 295 153
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 84 97 82 128 94 133 100 177 101 177 112 138 112 127 103 93 106 94 113 88 116 54 112 14 112 17 98 0 101
					yourself:
				)
		)
		(proc0_1)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 167 57)
				(if (not ((gGoals at: 0) egoHas:))
					(self setScript: global145)
				)
			)
			(west
				(gEgo posn: 26 (proc0_13 111 (gEgo y:) global59))
				(self setScript: gStdWalkIn 1 0)
			)
			(south
				(gEgo posn: (proc0_13 global61 (gEgo x:) global60) 135)
				(self setScript: gStdWalkIn 1 0)
			)
			(east
				(gEgo posn: 231 (proc0_13 134 (gEgo y:) global59))
				(self setScript: gStdWalkIn 1 0)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120 init:)
			)
		)
		(proc0_8)
		(if ((gGoals at: 0) egoReturned:)
			(muffet init: loop: 0)
			(muffetHead hide:)
		)
		(if global172
			(self setScript: global341)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== (gEgo onControl: 1) 4)
				(self setScript: gStdClimbOut)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)
)

(instance muffet of CDActor
	(properties
		x 153
		y 110
		view 43
		loop 5
	)

	(method (init)
		(super init: gestScr)
		(self setScript: scaredScript)
		(muffetHead init: self)
		(= global341 converse4)
	)

	(method (handleEvent)
		(return 0)
	)
)

(instance muffetHead of Head
	(properties
		x 153
		y 107
		z 13
		view 43
		loop 3
		signal 2048
		moveHead 0
	)

	(method (doit)
		(self
			loop:
				(cond
					((< (gEgo x:) (- x 20)) 4)
					((> (gEgo x:) (+ x 20)) 2)
					(else 3)
				)
		)
		(super doit:)
	)
)

(instance scaredScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(muffet cycleSpeed: 5 setCycle: End self)
			)
			(1
				(= seconds (Random 8 16))
				(= state -1)
			)
		)
	)
)

(instance gestScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 5 15))
				(client setCel: (- (Random 1 3) 1))
				(= state -1)
			)
		)
	)

	(method (dispose)
		(client setCel: 0)
		(super dispose:)
	)
)

(instance converse4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 391)
				(proc0_2)
				(proc0_20)
				(muffetHead show:)
				(muffet cycleSpeed: 6 loop: 5)
				(proc0_7 gEgo muffet)
				(proc411_0 (gEgo head:) muffetHead)
				(= cycles 2)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(muffet say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(proc411_1)
				(proc0_3)
				(= global341 0)
				(muffet cycleSpeed: 15 loop: 0 setScript: scaredScript)
				(muffetHead hide:)
				(DoSound sndMASTER_VOLUME global125)
				(self dispose:)
			)
		)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 13 (gEgo x:) 220))
				(= temp1 51)
			)
			(2
				(= temp0 252)
				(= temp1 (proc0_13 72 (gEgo y:) 147))
			)
			(3
				(= temp0 (proc0_13 2 (gEgo x:) 250))
				(= temp1 158)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 56 (proc0_14 83 (gEgo y:) 102) 151))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

