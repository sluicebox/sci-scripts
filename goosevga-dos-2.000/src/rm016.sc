;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use PolyPath)
(use Polygon)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm016 0
)

(local
	local0
)

(instance rm016 of Rm
	(properties
		picture 16
		style 0
		north 9
		east 17
		south 23
		west 15
	)

	(method (init)
		(= global345 outCode)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 198 178 196 155 213 154 258 102 292 104 290 177
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 222 51 192 6 280 7 287 75 258 77
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 99 85 81 85 60 84 53 81 57 69 96 69 114 78 101 85
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 73 36 78 37 98 13 104 0 106
					yourself:
				)
		)
		(NormalEgo)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 64 40)
				(self setScript: global145)
			)
			(south
				(gEgo posn: (proc0_13 global61 (gEgo x:) 204) 139)
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo posn: 26 (proc0_13 102 (gEgo y:) global59))
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 231 86)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120 init:)
			)
		)
		(proc0_8 54 127)
		(if
			(and
				global157
				(!= [global200 gCurRoomNum] 45)
				(!= [global200 gCurRoomNum] 44)
				(!= global130 45)
				(!= global130 44)
			)
			(cricObj init: setScript: cric)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== (gEgo onControl:) 4)
				(++ local0)
				(self setScript: gStdClimbOut)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
			((== (gEgo onControl:) 8)
				(if (not local0)
					(gEgo setPri: 1)
				)
			)
			((== (gEgo onControl:) 1)
				(gEgo setPri: -1)
			)
		)
	)

	(method (dispose &tmp temp0)
		(super dispose:)
	)
)

(instance cricObj of Prop
	(properties
		x -10
		y -10
		view 895
		cel 7
		signal 16384
	)
)

(instance cric of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 360 600))
			)
			(1
				(if
					(or
						(not (User controls:))
						(gCurRoom script:)
						(!= (DoAudio audPOSITION) -1)
					)
					(= cycles 1)
				else
					(= ticks
						(+
							4
							(DoAudio
								audPLAY
								(if (Random 0 1)
									35
								else
									(Random 574 577)
								)
							)
						)
					)
				)
				(= state -1)
			)
		)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 6 (gEgo x:) 207))
				(= temp1 20)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 78 (gEgo y:) 99))
			)
			(3
				(= temp0 (proc0_13 1 (gEgo x:) 188))
				(= temp1 158)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 46 (proc0_14 72 (gEgo y:) 106) 154))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

