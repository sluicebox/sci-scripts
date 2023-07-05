;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27)
(include sci.sh)
(use Main)
(use n411)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm027 0
)

(local
	[local0 22] = [1 0 0 -14336 144 68 144 79 75 85 54 103 51 151 50 155 64 214 104 257 -32663 0]
	local22
	local23
)

(instance rm027 of Rm
	(properties
		picture 27
		style 0
		horizon 41
		north 20
		east 28
		south 34
		west 26
	)

	(method (init &tmp temp0)
		(super init:)
		(proc0_1)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(north
				(gEgo posn: 137 43)
				(self setScript: global145)
			)
			(south
				(gEgo posn: (proc0_13 global63 (gEgo x:) global62) 150)
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo posn: 10 (proc0_13 140 (gEgo y:) global61))
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 250 (proc0_13 119 (gEgo y:) global61))
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120 init:)
			)
		)
		(boy init:)
		(= global111 afterDog)
		(if ((gGoals at: 3) egoReturned:)
			(boy setLoop: 5)
			(theHead init: boy)
			(afterDog init:)
		else
			(boy setCycle: Fwd)
		)
		(proc0_8)
		(if global172
			(self setScript: converse)
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

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl:) $0004)
				(self setScript: gStdClimbOut)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(self setScript: gStdWalkOut 0 (gEgo edgeHit:))
			)
		)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(boy setLoop: 1 setCel: 0 setCycle: End self)
			)
			(1
				(boy setLoop: 5 setCycle: 0)
				(theHead init: boy)
				(proc411_0 (gEgo head:) theHead)
				(= cycles 2)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance atEaseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc411_1)
				(theHead dispose:)
				(boy setLoop: 1 setCel: 255 setCycle: Beg self)
			)
			(1
				(boy setLoop: 6 setCycle: Fwd)
				(= cycles 2)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance gestureScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 5 15))
			)
			(1
				(= register (- (Random 1 (NumCels client)) 1))
				(if (!= register (client cel:))
					(client
						setCycle:
							CT
							register
							(if (< (client cel:) register) 1 else -1)
							self
					)
				else
					(= cycles 1)
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance boy of CDActor
	(properties
		y 121
		x 117
		view 73
		loop 6
		cycleSpeed 3
	)

	(method (init)
		(if (< global170 90)
			(super init:)
		else
			(super init: gestureScript)
		)
		(= global109 self)
	)
)

(instance theHead of Head
	(properties
		view 73
		loop 2
		signal 1
		moveHead 0
	)

	(method (init param1)
		(super init: param1)
		(= local22 1)
		(= global110 self)
	)

	(method (doit)
		(if local22
			(self
				setLoop:
					(cond
						((< (gEgo x:) (- (client x:) 20)) 3)
						((> (gEgo x:) (+ (client x:) 20)) 4)
						(else 2)
					)
			)
		)
		(super doit:)
	)
)

(instance bark of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(afterDog setCel: 0)
				(= register (Random 1 3))
				(= seconds (Random 1 4))
			)
			(1
				(if (gCurRoom script:)
					(= state -1)
					(= cycles 1)
				else
					(Timer set60ths: self (DoAudio audPLAY (Random 19 22)))
					(afterDog setCycle: Fwd)
				)
			)
			(2
				(afterDog setCel: 0)
				(if (-- register)
					(self changeState: 1)
				else
					(self changeState: 0)
				)
			)
		)
	)
)

(instance afterDog of Prop
	(properties
		y 117
		x 135
		view 46
		loop 6
		cycleSpeed 2
	)

	(method (init)
		(super init:)
		(self setScript: bark)
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
		(proc0_7 gEgo boy)
		(super init: &rest)
		(= temp0 (gGoals at: 3))
		(proc0_20)
		(cond
			(local23
				(switch local23
					(1
						(self setScript: converse2 self 255)
					)
					(2
						(self setScript: converse2 self 259)
					)
					(else
						(self setScript: converse6 self 261)
					)
				)
			)
			((temp0 egoReturned:)
				(self setScript: converse7 self 264)
			)
			((temp0 egoHas:)
				(self setScript: converse5 self 260)
				(if (== global123 11)
					(= global123 0)
				)
				(= local23 3)
			)
			((temp0 egoTold:)
				(self setScript: converse3 self 256)
				(= global123 11)
				(= local23 2)
			)
			(else
				(self setScript: converse1 self 250)
				(temp0 egoTold: 1)
				(= global123 11)
				(= local23 1)
			)
		)
	)
)

(instance converse1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
			)
			(1
				(boy say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(boy say: (++ register) self)
			)
			(4
				(gEgo say: (++ register) self)
			)
			(5
				(boy say: (++ register) self)
			)
			(6
				(self setScript: atEaseScript self)
			)
			(7
				(= global131 (+ (boy x:) 13))
				(= global132 (- (boy y:) 52))
				(= global128 102)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(8
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
				(self setScript: attentionScript self)
			)
			(1
				(boy say: register self)
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global131 (+ (boy x:) 13))
				(= global132 (- (boy y:) 52))
				(= global128 102)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(4
				(= global123 11)
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
				(self setScript: attentionScript self)
			)
			(1
				(boy say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(boy say: (++ register) self)
			)
			(4
				(self setScript: atEaseScript self)
			)
			(5
				(= global131 (+ (boy x:) 13))
				(= global132 (- (boy y:) 52))
				(= global128 102)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(6
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
				(self setScript: attentionScript self)
			)
			(1
				(boy say: register self)
			)
			(2
				(proc411_1)
				(= cycles 2)
			)
			(3
				(= local22 0)
				(self setScript: (ScriptID 327) self) ; rhymeScript
			)
			(4
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
				(proc411_0 (gEgo head:) theHead)
				(= cycles 1)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(boy say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(proc411_1)
				(boy setCel: 0)
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
				(proc411_0 (gEgo head:) theHead)
				(= cycles 1)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(boy say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(boy say: (++ register) self)
			)
			(5
				(proc411_1)
				(boy setCel: 0)
				(self dispose:)
			)
		)
	)
)

