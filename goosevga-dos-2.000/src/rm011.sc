;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm011 0
)

(instance rm011 of Rm
	(properties
		picture 11
		style 0
		horizon 9
		north 4
		south 18
	)

	(method (init)
		(= global345 outCode)
		(Load rsVIEW 138)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 315 0 315 196 205 196 224 155 230 146 191 131 164 124 159 108 163 96 118 96 121 85
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 1 196 -3 28 95 85 82 95 49 93 33 115 59 118 36 149 67 196
					yourself:
				)
		)
		(NormalEgo)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_13 85 (gEgo x:) 120) 92)
				(self setScript: global145)
			)
			(south
				(gEgo posn: (proc0_13 95 (gEgo x:) 170) 139)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120 init:)
			)
		)
		(flag1 init:)
		(flag2 init:)
		(flag3 init:)
		(flag4 init:)
		(proc0_8 73 140)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== (gEgo onControl:) 4)
				(self setScript: gStdClimbOut)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)
)

(instance flag1 of Prop
	(properties)

	(method (init)
		(self view: 138 loop: 0 posn: 97 23 cycleSpeed: 4 setCycle: Fwd)
		(super init:)
	)
)

(instance flag2 of Prop
	(properties)

	(method (init)
		(self view: 138 loop: 1 posn: 161 21 cycleSpeed: 4 setCycle: Fwd)
		(super init:)
	)
)

(instance flag3 of Prop
	(properties)

	(method (init)
		(self view: 138 loop: 2 cel: 0 posn: 141 19 cycleSpeed: 4 setCycle: Fwd)
		(super init:)
	)
)

(instance flag4 of Prop
	(properties)

	(method (init)
		(self view: 138 loop: 2 cel: 1 posn: 99 41 cycleSpeed: 4 setCycle: Fwd)
		(super init:)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 80 (gEgo x:) 128))
				(= temp1 63)
			)
			(2
				(= temp0 229)
				(= temp1 (proc0_13 98 (gEgo y:) 152))
			)
			(3
				(= temp0 (proc0_13 44 (gEgo x:) 219))
				(= temp1 158)
			)
			(4
				(= temp0 32)
				(= temp1 (proc0_13 98 (gEgo y:) 153))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

