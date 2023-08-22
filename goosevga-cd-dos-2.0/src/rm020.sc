;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use Waters2)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm020 0
)

(local
	[local0 56] = [3 0 0 0 0 -14336 88 9 102 16 145 59 145 46 117 110 115 111 99 134 98 165 -32613 -14138 155 163 98 173 98 154 82 159 73 137 66 123 52 180 -32768 -14264 0 101 50 85 71 65 77 46 80 15 79 0 79 0 -32768 0]
	[local56 6] = [129 148 80 237 133 80]
)

(instance rm020 of Rm
	(properties
		picture 20
		style 0
		horizon 50
		north 13
		south 27
		west 19
		vanishingX 40
		vanishingY -90
	)

	(method (init &tmp temp0)
		(super init:)
		(water init:)
		(NormalEgo)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(north
				(gEgo posn: 114 50)
				(self setScript: global145)
			)
			(west
				(gEgo posn: 7 84)
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo setPri: -1 posn: 187 153)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120)
			)
		)
		(gEgo init:)
		(proc0_8 43 114)
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
			((== 1 (gEgo edgeHit:))
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
		(DisposeScript 402)
		(super dispose:)
	)
)

(instance water of Waters2
	(properties
		view 135
		cycleSpeed 5
	)

	(method (getLoop)
		(= x [local56 pos])
		(= y [local56 (++ pos)])
		(= cel [local56 (++ pos)])
	)

	(method (saveLoop)
		(= [local56 pos] cel)
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

