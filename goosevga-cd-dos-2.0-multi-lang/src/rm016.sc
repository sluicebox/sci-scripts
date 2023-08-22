;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm016 0
)

(local
	[local0 45] = [4 0 0 0 0 0 -14336 73 38 74 42 101 0 -32659 -6092 67 0 0 52 86 0 0 98 89 0 0 121 79 0 0 104 -32702 0 0 -14078 80 228 63 205 -32740 -14078 92 221 -32612 0]
	local45
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
		(super init:)
		(NormalEgo)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(north
				(gEgo posn: 64 40)
				(self setScript: global145)
			)
			(south
				(gEgo posn: (proc0_13 global63 (gEgo x:) 204) 150)
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo posn: 10 (proc0_13 102 (gEgo y:) global61))
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 250 86)
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
				(++ local45)
				(self setScript: gStdClimbOut)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
			((== (gEgo onControl:) 8)
				(if (not local45)
					(gEgo setPri: 1)
				)
			)
			((== (gEgo onControl:) 1)
				(gEgo setPri: -1)
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

