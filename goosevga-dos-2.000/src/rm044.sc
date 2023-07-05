;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 44)
(include sci.sh)
(use Main)
(use n411)
(use PolyPath)
(use Polygon)
(use Game)
(use Actor)
(use System)

(public
	rm044 0
)

(instance rm044 of Rm
	(properties
		picture 44
		style 0
		south 21
	)

	(method (init)
		(proc0_3)
		(super init:)
		(= global345 outCode)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 7 258 7 257 154 224 155 207 121 221 120 195 106 130 108 130 113 92 115 29 115 19 123 58 137 134 137 187 119 197 196 0 195
					yourself:
				)
		)
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
		(= global341 0)
		(if ((gGoals at: 11) egoReturned:)
			(woman init:)
			(womanBod init:)
			(= global341 converse6)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl:) $4000)
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

	(method (handleEvent)
		(return 0)
	)
)

(instance woman of CDActor
	(properties
		x 114
		y 108
		z 30
		view 79
		loop 8
	)
)

(instance womanBod of View
	(properties
		x 112
		y 108
		view 79
		loop 11
	)

	(method (handleEvent)
		(return 0)
	)
)

(instance converse6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 328)
				(proc0_2)
				(proc0_7 gEgo woman)
				(proc411_0 (gEgo head:) woman)
				(= cycles 1)
			)
			(1
				(proc0_20)
				(gEgo say: register self)
			)
			(2
				(woman say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(woman say: (++ register) self)
			)
			(5
				(proc411_1)
				(DoSound sndMASTER_VOLUME global125)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 38 (gEgo x:) 196))
				(= temp1 101)
			)
			(2
				(= temp0 222)
				(= temp1 (proc0_13 104 (gEgo y:) 120))
			)
			(3
				(= temp0 (proc0_13 190 (gEgo x:) 216))
				(= temp1 143)
			)
			(4
				(= temp0 16)
				(= temp1 (proc0_13 114 (gEgo y:) 128))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

