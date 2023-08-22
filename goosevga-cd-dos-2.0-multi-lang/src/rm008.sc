;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm008 0
)

(local
	[local0 12] = [1 0 0 -14321 107 51 110 53 118 17 -32631 0]
)

(instance rm008 of Rm
	(properties
		picture 8
		style 0
		north 1
		east 9
		south 15
	)

	(method (init)
		(super init:)
		(NormalEgo)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_13 53 (gEgo x:) 133) 82)
				(self setScript: global145)
			)
			(east
				(gEgo posn: 248 (proc0_13 91 (gEgo y:) global61))
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo posn: (proc0_13 123 (gEgo x:) global62) 150)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120 init:)
			)
		)
		(proc0_8 130 118)
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
			((== (gEgo onControl:) 4)
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

