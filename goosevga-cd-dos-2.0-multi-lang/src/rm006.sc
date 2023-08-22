;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6)
(include sci.sh)
(use Main)
(use Waters2)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm006 0
)

(local
	[local0 44] = [3 0 0 0 0 -14336 133 53 127 92 114 107 96 114 89 132 86 153 89 166 89 172 86 180 71 255 65 258 -32724 -14137 155 165 142 168 135 258 -32676 -14308 155 18 145 0 -32621 0]
	[local44 12] = [13 106 80 27 109 80 47 92 80 63 74 80]
)

(instance rm006 of Rm
	(properties
		picture 6
		style 0
		east 7
		south 13
		west 5
	)

	(method (init)
		(super init:)
		(NormalEgo)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(west
				(gEgo posn: global137 145)
				(self setScript: entranceScript)
			)
			(east
				(gEgo posn: global138 92)
				(self setScript: entranceScript)
			)
			(south
				(gEgo posn: 128 global139)
				(self setScript: entranceScript)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 128 120)
			)
		)
		(water6 init:)
		(gEgo init:)
		(proc0_8 136 99)
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

(instance entranceScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch gPrevRoomNum
					(5
						(= global131 global140)
						(= global132 (gEgo y:))
					)
					(7
						(= global131 global141)
						(= global132 (gEgo y:))
					)
					(13
						(= global131 (gEgo x:))
						(= global132 global142)
					)
				)
				(gEgo init: setMotion: MoveTo global131 global132 self)
			)
			(1
				(gEgo setLoop: -1 setPri: -1)
				(HandsOn)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance exitScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((> (gEgo x:) global62)
						(= global131 global138)
						(= global132 (gEgo y:))
					)
					((< (gEgo x:) global63)
						(= global131 global137)
						(= global132 (gEgo y:))
					)
					((> (gEgo y:) global61)
						(= global131 (gEgo x:))
						(= global132 global139)
					)
				)
				(gEgo setMotion: MoveTo global131 global132 self)
			)
			(1
				(HandsOn)
				(gCurRoom
					newRoom:
						(cond
							((> (gEgo x:) global62) 7)
							((< (gEgo x:) global63) 5)
							((> (gEgo y:) global61) 13)
						)
				)
			)
		)
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

(instance water6 of Waters2
	(properties
		view 134
		cycleSpeed 4
	)

	(method (getLoop)
		(= x [local44 pos])
		(= y [local44 (++ pos)])
		(= cel [local44 (++ pos)])
	)

	(method (saveLoop)
		(= [local44 pos] cel)
		(++ pos)
	)
)

