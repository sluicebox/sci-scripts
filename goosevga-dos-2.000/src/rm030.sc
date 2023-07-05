;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use Waters2)
(use PolyPath)
(use Polygon)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm030 0
)

(local
	[local0 18] = [72 114 80 73 128 80 113 143 80 117 126 80 240 148 80 182 142 80]
)

(instance rm030 of Rm
	(properties
		picture 30
		style 0
		north 23
		east 31
		west 29
	)

	(method (init)
		(= global345 outCode)
		(Load rsVIEW 163)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 95 94 94 129 92 141 91 138 96 107 107 126 109 169 93 175 98 175 111 185 123 196 129 243 129 315 127 315 196 0 196
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 315 115 228 114 233 99 315 71
					yourself:
				)
		)
		(proc0_1)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_13 150 (gEgo x:) global60) 40)
				(self setScript: global145)
			)
			(west
				(gEgo posn: 36 (proc0_13 66 (gEgo y:) 96))
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo
					posn: 231 (proc0_13 54 (proc0_14 92 (gEgo y:) 115) 131)
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
		(proc0_8 167 80)
		(water30 init:)
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
			((& (gEgo onControl:) $0004)
				(self setScript: gStdClimbOut 0 1)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(self setScript: gStdWalkOut 0 (gEgo edgeHit:))
			)
		)
	)

	(method (dispose &tmp temp0)
		(DisposeScript 402)
		(super dispose:)
	)
)

(instance water30 of Waters2
	(properties
		view 163
		priority 14
		signal 24624
	)

	(method (getLoop)
		(= x [local0 pos])
		(= y [local0 (++ pos)])
		(= cel [local0 (++ pos)])
	)

	(method (saveLoop)
		(= [local0 pos] cel)
		(++ pos)
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
				(= temp0 (proc0_13 6 (gEgo x:) 251))
				(= temp1 16)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 44 (proc0_14 87 (gEgo y:) 116) 128))
			)
			(3
				(= temp0 (proc0_13 106 (gEgo x:) 250))
				(= temp1 134)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 58 (gEgo y:) 93))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

