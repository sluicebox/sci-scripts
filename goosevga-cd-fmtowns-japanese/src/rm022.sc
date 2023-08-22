;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm022 0
)

(local
	[local0 14] = [1 0 0 -14263 155 49 138 78 115 60 103 90 -32696 0]
)

(instance rm022 of Rm
	(properties
		picture 22
		style 0
		north 15
		east 23
		south 29
	)

	(method (init)
		(super init:)
		(NormalEgo)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_13 87 (gEgo x:) 140) 72)
				(self setScript: global145)
			)
			(south
				(gEgo posn: (proc0_13 78 (gEgo x:) global62) 150)
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 250 (proc0_13 81 (gEgo y:) global61))
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120 init:)
			)
		)
		(proc0_8 155 130)
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
				(self setScript: gStdClimbOut)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)

	(method (dispose &tmp temp0)
		(if (cric timer:)
			(= temp0 (cric timer:))
			(temp0 dispose:)
			(temp0 delete:)
		)
		(super dispose:)
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

