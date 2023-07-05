;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37)
(include sci.sh)
(use Main)
(use n411)
(use PolyPath)
(use Polygon)
(use Game)
(use Actor)
(use System)

(public
	rm037 0
)

(local
	local0
)

(instance rm037 of Rm
	(properties
		picture 37
		style 0
		south 4
	)

	(method (init)
		(super init:)
		(= global345 outCode)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 155 0 0 258 0 258 155 185 155 174 137 179 120 203 100 178 81 152 82 126 83 96 81 65 99 89 130 70 155
					yourself:
				)
		)
		(proc0_1)
		(switch gPrevRoomNum
			(45 ; mapRoom
				(gEgo init:)
			)
			(south
				(gEgo signal: 8192 loop: 3 x: 134 y: global142 init:)
				(self setScript: gStdWalkIn 1 9)
			)
			(else
				(gEgo setLoop: -1 x: 134 y: 120 init:)
			)
		)
		(= global341 converse)
		(proc0_8 59 94 124 155)
		(king init:)
		(if global172
			(self setScript: converse)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== (gEgo onControl:) 16384)
				(self setScript: gStdWalkOut 0 3)
			)
		)
	)
)

(instance king of CDActor
	(properties
		x 133
		y 78
		view 80
		priority 5
		signal 14353
		illegalBits 0
	)

	(method (init)
		(super init:)
		(theHead init: self)
		(if ((gGoals at: 9) egoReturned:)
			(= cel 1)
		)
		(= global109 self)
	)
)

(instance theHead of Head
	(properties
		z 26
		view 80
		loop 1
		priority 6
		signal 30737
		moveHead 0
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not (= state newState))
			(proc0_2)
			(proc0_7 gEgo king)
			(= temp0 (gGoals at: 9))
			(proc0_20)
			(proc411_0 (gEgo head:) theHead)
			(cond
				(local0
					(switch local0
						(1
							(self setScript: converse2 self 363)
						)
						(2
							(self setScript: converse2 self 367)
						)
						(else
							(self setScript: converse6 self 370)
						)
					)
				)
				((temp0 egoReturned:)
					(self setScript: converse7 self 372)
				)
				((temp0 egoHas:)
					(self setScript: converse5 self 368)
					(temp0 egoReturned: 1)
					(if (== global123 16)
						(= global123 0)
					)
					(= local0 3)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self 364)
					(= global123 16)
					(= local0 2)
				)
				(else
					(self setScript: converse1 self 358)
					(= global123 16)
					(temp0 egoTold: 1)
					(= local0 1)
				)
			)
		else
			(client setScript: 0)
			(DoSound sndMASTER_VOLUME global125)
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
			(proc0_5)
			(proc0_3)
		)
	)
)

(instance converse1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(king say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(king say: (++ register) self)
			)
			(4
				(gEgo say: (++ register) self)
			)
			(5
				(king say: (++ register) self)
			)
			(6
				(proc411_1)
				(= global131 (+ (king x:) 33))
				(= global132 (- (king y:) 56))
				(= global128 108)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance converse2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(king say: register self)
			)
			(2
				(proc411_1)
				(= global131 (+ (king x:) 33))
				(= global132 (- (king y:) 56))
				(= global128 108)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(= global123 16)
				(self dispose:)
			)
		)
	)
)

(instance converse3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(king say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(king say: (++ register) self)
			)
			(4
				(proc411_1)
				(= global131 (+ (king x:) 33))
				(= global132 (- (king y:) 56))
				(= global128 108)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance converse5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(king say: (++ register) self)
			)
			(3
				(proc411_1)
				(self setScript: (ScriptID 337) self) ; rhymeScript
			)
			(4
				(= cycles 14)
				(king view: 80 loop: 0 cel: 1)
				(theHead init: king z: 26)
			)
			(5
				(proc0_10)
				(self dispose:)
			)
		)
	)
)

(instance converse6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(king say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(proc411_1)
				(self dispose:)
			)
		)
	)
)

(instance converse7 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(king say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(king say: (++ register) self)
			)
			(4
				(gEgo say: (++ register) self)
			)
			(5
				(king say: (++ register) self)
			)
			(6
				(proc411_1)
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
				(= temp0 (proc0_13 92 (gEgo x:) 182))
				(= temp1 64)
			)
			(2
				(= temp0 207)
				(= temp1 (proc0_13 81 (gEgo y:) 115))
			)
			(3
				(= temp0 (proc0_13 70 (gEgo x:) 185))
				(= temp1 158)
			)
			(4
				(= temp0 57)
				(= temp1 (proc0_13 88 (gEgo y:) 110))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

