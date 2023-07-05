;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use n411)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm009 0
)

(local
	[local0 62] = [3 0 0 0 0 -14336 102 12 101 11 112 21 114 44 114 53 113 95 118 95 108 129 105 137 95 93 81 0 -32685 -6015 105 0 0 132 114 0 0 171 116 0 0 178 107 0 0 170 98 0 0 135 -32671 0 0 -14079 141 236 122 229 88 233 -32703 0]
)

(instance rm009 of Rm
	(properties
		picture 9
		style 0
		horizon 50
		north 2
		east 10
		south 16
		west 8
	)

	(method (init)
		(if ((gGoals at: 0) egoHas:)
			(Load rsSCRIPT 309)
			(= global134 0)
		)
		(Load rsVIEW 68)
		(super init:)
		(proc0_1)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(north
				(gEgo posn: 167 57)
				(self setScript: global145)
			)
			(west
				(gEgo posn: 10 (proc0_13 111 (gEgo y:) global61))
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo posn: (proc0_13 global63 (gEgo x:) global62) 150)
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 250 (proc0_13 134 (gEgo y:) global61))
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120 init:)
			)
		)
		(proc0_8)
		(if ((gGoals at: 0) egoReturned:)
			(muffet init:)
			(muffetHead hide:)
		)
	)

	(method (doit &tmp temp0)
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
)

(instance muffet of CDActor
	(properties
		y 110
		x 153
		view 43
	)

	(method (init)
		(super init: gestScr)
		(self setScript: scaredScript)
		(muffetHead init: self z: (CelHigh view 5 0))
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((!= (event type:) evVERB)
				(return)
			)
			((gCurRoom script:)
				(return)
			)
			(else
				(event claimed: 1)
				(gCurRoom setScript: converse4 0 391)
			)
		)
	)
)

(instance muffetHead of Head
	(properties
		y 110
		x 153
		z 16
		view 43
		loop 3
		signal 2048
		moveHead 0
	)

	(method (doit)
		(self
			setLoop:
				(cond
					((< (gEgo x:) (- x 20)) 4)
					((> (gEgo x:) (+ x 20)) 2)
					(else 3)
				)
		)
		(super doit:)
	)
)

(instance scaredScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(muffet cycleSpeed: 5 setCycle: End self)
			)
			(1
				(= seconds (Random 8 16))
				(= state -1)
			)
		)
	)
)

(instance gestScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 5 15))
				(client setCel: (- (Random 1 3) 1))
				(= state -1)
			)
		)
	)

	(method (dispose)
		(client setCel: 0)
		(super dispose:)
	)
)

(instance converse4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(proc0_20)
				(muffetHead show:)
				(muffet cycleSpeed: 0 loop: 5)
				(proc0_7 gEgo muffet)
				(proc411_0 (gEgo head:) muffetHead)
				(= cycles 2)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(muffet say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(proc411_1)
				(proc0_3)
				(self dispose:)
				(muffet cycleSpeed: 5 loop: 0 setScript: scaredScript)
				(muffetHead hide:)
				(DoSound sndMASTER_VOLUME global125)
			)
		)
	)
)

