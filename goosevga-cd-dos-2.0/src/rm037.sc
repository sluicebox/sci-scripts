;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37)
(include sci.sh)
(use Main)
(use n411)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm037 0
)

(local
	[local0 24] = [1 0 0 -14264 153 89 129 53 100 99 83 107 91 161 91 168 83 212 106 172 134 186 -32615 0]
	local24
)

(instance rm037 of Rm
	(properties
		picture 37
		style 0
		south 4
	)

	(method (init)
		(super init:)
		(proc0_1)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(45 ; mapRoom
				(gEgo init:)
			)
			(south
				(gEgo signal: 8192 loop: 3 x: 134 y: global142 init:)
				(self setScript: gStdWalkIn)
			)
			(else
				(gEgo setLoop: -1 x: 134 y: 120 init:)
			)
		)
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
			(else
				(event claimed: 1)
				(self setScript: converse)
			)
		)
	)
)

(instance king of CDActor
	(properties
		y 78
		x 133
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

	(method (cue)
		(client setScript: 0)
		(DoSound sndMASTER_VOLUME global125)
		(if global172
			(gCurRoom newRoom: 45) ; mapRoom
		)
		(proc0_3)
	)

	(method (init &tmp temp0)
		(proc0_2)
		(proc0_7 gEgo king)
		(super init: &rest)
		(= temp0 (gGoals at: 9))
		(proc0_20)
		(proc411_0 (gEgo head:) theHead)
		(cond
			(local24
				(switch local24
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
				(= local24 3)
			)
			((temp0 egoTold:)
				(self setScript: converse3 self 364)
				(= global123 16)
				(= local24 2)
			)
			(else
				(self setScript: converse1 self 358)
				(= global123 16)
				(temp0 egoTold: 1)
				(= local24 1)
			)
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

