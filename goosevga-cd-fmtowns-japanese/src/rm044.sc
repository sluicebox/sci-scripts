;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 44)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm044 0
)

(local
	[local0 39] = [2 0 0 0 -14321 118 63 135 133 135 184 119 193 119 202 145 0 -32623 -14310 108 40 120 120 117 136 112 138 109 192 110 212 119 203 120 215 145 258 -32623 0]
)

(instance rm044 of Rm
	(properties
		picture 44
		style 0
		south 21
	)

	(method (init)
		(HandsOn)
		(super init:)
		(gEgo setMotion: Freeway (= global75 @local0))
		(if (== gPrevRoomNum 45) ; mapRoom
			(gEgo init:)
		else
			(gEgo loop: 3 posn: 199 121 init:)
		)
		(table init:)
		(proc0_8 177 104 211 124)
		(if global150
			(global150 z: 13)
		)
		(if (and global130 (> global130 47))
			(global129 z: 13)
		)
		(if ((gGoals at: 11) egoReturned:)
			(woman init:)
			(womanBod init:)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((!= (event type:) evVERB)
				(return)
			)
			(script
				(return)
			)
			(((gGoals at: 11) egoReturned:)
				(event claimed: 1)
				(HandsOff)
				(self setScript: converse6 self 328)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== (gEgo onControl:) 16384)
				(gCurRoom newRoom: 21)
			)
		)
	)
)

(instance table of View
	(properties
		view 149
		priority 2
		signal 26897
	)

	(method (init)
		(self posn: 177 104)
		(super init:)
	)
)

(instance woman of CDActor
	(properties
		y 108
		x 115
		z 29
		view 79
		loop 9
	)
)

(instance womanBod of View
	(properties
		y 108
		x 112
		view 79
		loop 11
	)
)

(instance converse6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_20)
				(proc0_7 gEgo woman)
				(gEgo say: register self)
			)
			(1
				(woman say: (++ register) self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(woman say: (++ register) self)
			)
			(4
				(DoSound sndMASTER_VOLUME global125)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

