;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35)
(include sci.sh)
(use Main)
(use Waters)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm035 0
)

(local
	[local0 35] = [2 0 0 0 -14336 98 90 102 121 97 125 82 56 82 58 56 0 -32729 -14078 26 193 54 212 72 207 99 106 110 99 120 76 122 0 -32644 0]
	[local35 15] = [147 114 0 1 135 0 55 135 0 214 131 0 147 130 0]
)

(instance rm035 of Rm
	(properties
		picture 35
		style 0
		north 28
		west 34
	)

	(method (init)
		(super init:)
		(water init:)
		(NormalEgo)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_13 100 (gEgo x:) 192) 57)
				(self setScript: global145)
			)
			(west
				(gEgo posn: 10 (proc0_13 98 (gEgo y:) 130))
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 67 108 init:)
			)
		)
		(proc0_8 174 79)
		(if (!= [global200 gCurRoomNum] 45)
			(cric init:)
		)
	)

	(method (doit &tmp temp0)
		(cric doit:)
		(water doit:)
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
		(DisposeScript 401)
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

(instance water of Waters
	(properties
		priority 15
		view 160
	)

	(method (getLoop)
		(= x [local35 pos])
		(= y [local35 (++ pos)])
		(= cel [local35 (++ pos)])
	)

	(method (saveLoop)
		(= [local35 pos] cel)
		(++ pos)
	)
)

