;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use Waters2)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm002 0
)

(local
	[local0 36] = [3 0 0 0 0 -14277 155 93 140 0 -32669 -14336 63 74 70 87 89 133 85 145 91 152 104 184 122 216 129 258 -32636 -14078 142 242 142 221 -32613 0]
	[local36 12] = [247 108 80 226 113 80 212 99 80 197 75 80]
)

(instance rm002 of Rm
	(properties
		picture 2
		style 0
		east 3
		south 9
		west 1
	)

	(method (init)
		(super init:)
		(NormalEgo)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(west
				(gEgo posn: 13 (proc0_13 66 (gEgo y:) 92))
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 248 135)
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo posn: (proc0_13 87 (gEgo x:) 209) 150)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120 init:)
			)
		)
		(water2 init:)
		(proc0_8 120 106)
		(if (!= [global200 gCurRoomNum] 45)
			(cric init:)
		)
	)

	(method (doit &tmp temp0)
		(cric doit:)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)

	(method (handleEvent event &tmp [temp0 100])
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (dispose &tmp temp0)
		(if (cric timer:)
			(= temp0 (cric timer:))
			(temp0 dispose:)
			(temp0 delete:)
		)
		(DisposeScript 402)
		(super dispose:)
	)
)

(instance water2 of Waters2
	(properties
		view 139
		cycleSpeed 4
	)

	(method (getLoop)
		(= x [local36 pos])
		(= y [local36 (++ pos)])
		(= cel [local36 (++ pos)])
	)

	(method (saveLoop)
		(= [local36 pos] cel)
		(++ pos)
	)
)

(instance cric of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 9 22))
			)
			(1
				(if (or (not (User controls:)) (gCurRoom script:))
					(= cycles 1)
				else
					(Timer
						set60ths:
							self
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

