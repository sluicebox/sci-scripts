;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use User)
(use System)

(public
	rm014 0
)

(local
	[local0 16] = [1 0 0 -14251 60 86 67 142 62 146 70 99 103 0 -32647 0]
)

(instance rm014 of Rm
	(properties
		picture 14
		style 0
		north 7
		south 21
		west 13
	)

	(method (init)
		(super init:)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(north
				(gEgo posn: 178 49)
				(self setScript: global145)
			)
			(west
				(gEgo posn: global137 (proc0_13 115 (gEgo y:) 153))
				(self setScript: entranceScript)
			)
			(south
				(gEgo posn: (gEgo x:) global139 edgeHit: 0)
				(self setScript: entranceScript)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120)
			)
		)
		(gEgo init:)
		(proc0_8 79 137)
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
			((== (gEgo onControl: 1) 4)
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

(instance entranceScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(switch gPrevRoomNum
					(13
						(= global131 global140)
						(= global132 (gEgo y:))
					)
					(21
						(= global131 (gEgo x:))
						(= global132 global142)
					)
				)
				(gEgo init: setMotion: MoveTo global131 global132 self)
			)
			(1
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
				(proc0_3)
				(gCurRoom
					newRoom:
						(cond
							((< (gEgo x:) global63) 13)
							((> (gEgo y:) global61) 21)
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
					(Timer set60ths: self (+ 4 (DoAudio audPLAY 35)))
				)
				(= state -1)
			)
		)
	)
)

