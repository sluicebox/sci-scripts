;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm025 0
)

(local
	local0
	[local1 61] = [4 0 0 0 0 0 -14336 143 78 143 88 146 111 146 117 138 120 126 0 -32642 -14336 91 42 92 104 95 120 101 148 100 179 83 0 -32753 -14078 102 230 103 215 106 196 106 191 99 193 90 191 82 258 -32722 -14078 145 165 146 155 144 147 126 258 -32642 0]
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
		style 16
		horizon 80
		north 18
		east 26
		south 32
		west 24
	)

	(method (init)
		(super init:)
		(NormalEgo)
		(gEgo setMotion: Freeway (= global75 @local1))
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
						10
						(proc0_13 88 (proc0_14 130 (gEgo y:) 139) global61)
				)
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo
					posn:
						250
						(proc0_13 97 (proc0_14 131 (gEgo y:) 141) global61)
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
		y 71
		x 135
		view 148
		priority 11
		cycleSpeed 3
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

