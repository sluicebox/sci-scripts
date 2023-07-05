;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm025 0
)

(local
	local0
)

(procedure (localproc_0 &tmp temp0 temp1 temp2)
	(= temp2 (= temp0 0))
	(while (< temp0 (gCast size:))
		(= temp1 (gCast at: temp0))
		(if (== (temp1 view:) 45)
			(switch temp2
				(0
					(= global109 temp1)
				)
				(1
					(= global110 temp1)
				)
				(2
					(= global111 temp1)
				)
				(3
					(= global112 temp1)
				)
			)
			(++ temp2)
		)
		(++ temp0)
	)
	(global109 observeControl: 384)
	(global110 observeControl: 384)
	(global111 observeControl: 384)
	(global112 observeControl: 384)
)

(procedure (localproc_1 param1 param2 param3 &tmp temp0)
	(if param1
		(param1 ignoreControl: param3)
		(if (& (param1 onControl:) param2)
			(= temp0
				(if (param1 mover:)
					((param1 mover:) distance:)
				else
					20
				)
			)
			(if (== param2 128)
				(param1 setMotion: NearTo 135 154 temp0 param2)
			else
				(param1 setMotion: NearTo 135 114 temp0 param2)
			)
			(return 1)
		)
	)
	(return 0)
)

(instance rm025 of Rm
	(properties
		picture 25
		style -32761
		horizon 80
		north 18
		east 26
		south 32
		west 24
	)

	(method (init)
		(= global345 outCode)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 127 117 127 117 141 72 141 0 141
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 274 34 281 102 233 99 219 103 194 102 200 77
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 14 181 79 151 97 119 101 103 92 0 89
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 158 128 310 128 310 142 158 142
					yourself:
				)
		)
		(proc0_1)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 181 83)
				(if (== global130 45)
					(= local0 global145)
					(= global145 overHill)
				)
				(self setScript: global145)
			)
			(south
				(gEgo posn: 130 150)
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo
					posn:
						26
						(proc0_13 88 (proc0_14 130 (gEgo y:) 139) global59)
				)
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo
					posn:
						231
						(proc0_13 97 (proc0_14 131 (gEgo y:) 141) global59)
				)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120 init:)
			)
		)
		(proc0_8 56 102)
		(sparkle init:)
		(if (and global130 (<= global130 47))
			(global129 observeControl: 384)
			(= global109 global129)
			(if (and (== global130 45) (!= script overHill))
				(localproc_0)
			)
		)
		(if (== gScore gPossibleScore)
			(proc0_11 160 110)
		)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(if
			(and
				global129
				(<= global130 47)
				(= temp0 (& (gEgo onControl:) $0180))
			)
			(= temp1 (^ temp0 $0180))
			(if (localproc_1 global109 temp1 temp0)
				(= global109 0)
			)
			(if (== global130 45)
				(if (localproc_1 global110 temp1 temp0)
					(= global110 0)
				)
				(if (localproc_1 global111 temp1 temp0)
					(= global111 0)
				)
				(if (localproc_1 global112 temp1 temp0)
					(= global112 0)
				)
			)
		)
		(cond
			(script
				(script doit:)
			)
			((== gScore gPossibleScore)
				(self setScript: (ScriptID 205)) ; walkTo
			)
			((& (gEgo onControl:) $0004)
				(self setScript: gStdClimbOut)
			)
			((= temp2 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)
)

(instance sparkle of Prop
	(properties
		x 135
		y 71
		view 148
		priority 11
	)

	(method (init)
		(super init:)
		(self setCycle: End self)
	)

	(method (cue)
		(self dispose:)
	)
)

(instance overHill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: local0 self)
			)
			(1
				(localproc_0)
				(self dispose:)
				(= global145 local0)
			)
		)
	)
)

(class NearTo of Motion
	(properties
		oldDist 20
		cBad 384
	)

	(method (init param1 param2 param3 param4 param5)
		(= oldDist param4)
		(= cBad param5)
		(super init: param1 param2 param3)
	)

	(method (doit &tmp temp0)
		(if (> (GetDistance x y (client x:) (client y:) gPerspective) 20)
			(super doit:)
		else
			(cond
				((not global109)
					(= global109 client)
				)
				((not global110)
					(= global110 client)
				)
				((not global111)
					(= global111 client)
				)
				((not global112)
					(= global112 client)
				)
			)
			(client setMotion: NewFollow gEgo oldDist)
		)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 173 (gEgo x:) 209))
				(= temp1 64)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 101 (proc0_14 127 (gEgo y:) 142) 155))
			)
			(3
				(= temp0 (proc0_13 3 (gEgo x:) 255))
				(= temp1 158)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 90 (proc0_14 127 (gEgo y:) 142) 141))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

