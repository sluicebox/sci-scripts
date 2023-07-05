;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use System)

(public
	rm019 0
)

(local
	[local0 53] = [4 0 0 0 0 0 -14199 155 39 115 44 103 112 103 152 112 238 110 245 130 218 -32613 -14078 112 254 91 164 91 0 -32680 -14336 84 25 84 35 80 128 77 128 39 96 -32767 -14141 0 155 41 153 80 240 79 258 -32693 0]
)

(instance rm019 of Rm
	(properties
		picture 19
		style 0
		north 12
		east 20
		south 26
		west 18
	)

	(method (init)
		(super init:)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(west
				(gEgo posn: 10 89)
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 250 89)
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo posn: 170 150)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(north
				(gEgo posn: 140 76)
				(self setScript: gStdWalkIn)
			)
			(else
				(gEgo posn: 133 113 init:)
			)
		)
		(proc0_8 199 145)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((gEgo inRect: 114 66 166 74)
				(self newRoom: 12)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)
)

(instance entranceScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(switch gPrevRoomNum
					(18
						(= global131 global140)
						(= global132 (gEgo y:))
					)
					(20
						(= global131 global141)
						(= global132 (gEgo y:))
					)
					(26
						(= global131 (gEgo x:))
						(= global132 global142)
					)
				)
				(gEgo init: setMotion: MoveTo global131 global132 self)
			)
			(1
				(proc0_3)
				(gEgo setLoop: -1 setPri: -1)
				(proc0_3)
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
				(proc0_2)
				(cond
					((> (gEgo x:) global141)
						(= global131 global138)
						(= global132 (gEgo y:))
					)
					((< (gEgo x:) global140)
						(= global131 global137)
						(= global132 (gEgo y:))
					)
					((> (gEgo y:) global142)
						(= global131 (gEgo x:))
						(= global132 global139)
					)
				)
				(gEgo setMotion: MoveTo global131 global132 self)
			)
			(1
				(proc0_3)
				(gCurRoom
					newRoom:
						(cond
							((> (gEgo x:) global141) 20)
							((< (gEgo x:) global140) 18)
							((> (gEgo y:) global142) 26)
						)
				)
			)
		)
	)
)

