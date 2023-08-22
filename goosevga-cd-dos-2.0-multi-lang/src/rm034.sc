;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34)
(include sci.sh)
(use Main)
(use Waters2)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm034 0
)

(local
	[local0 31] = [2 0 0 0 -14078 48 130 59 138 80 172 86 256 -32683 -14336 110 58 107 75 102 99 106 109 115 187 124 242 124 258 -32642 0]
	[local31 9] = [64 136 80 133 146 80 211 143 80]
)

(instance rm034 of Rm
	(properties
		picture 34
		style 0
		horizon 59
		north 27
		east 35
		west 33
	)

	(method (init)
		(super init:)
		(water init:)
		(NormalEgo)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_13 83 (gEgo x:) 128) 60)
				(self setScript: global145)
			)
			(west
				(gEgo posn: 10 (proc0_13 77 (gEgo y:) 113))
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 250 (proc0_13 79 (gEgo y:) 129))
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120 init:)
			)
		)
		(proc0_8 180 103)
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
			((& (gEgo onControl:) $0004)
				(self setScript: gStdClimbOut 0 1)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(self setScript: gStdWalkOut 0 (gEgo edgeHit:))
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

(instance water of Waters2
	(properties
		view 136
		cycleSpeed 3
	)

	(method (getLoop)
		(= x [local31 pos])
		(= y [local31 (++ pos)])
		(= cel [local31 (++ pos)])
	)

	(method (saveLoop)
		(= [local31 pos] cel)
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

