;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
(include sci.sh)
(use Main)
(use n411)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm023 0
)

(local
	[local0 53] = [2 0 0 0 -5988 136 0 0 171 127 0 0 170 106 0 0 159 99 0 0 81 98 0 0 61 104 0 0 60 114 0 0 94 134 0 0 121 -32630 0 0 -14079 144 221 144 212 133 206 122 203 94 220 -32707 0]
	local53
	local54
	local55
	local56
)

(instance rm023 of Rm
	(properties
		picture 23
		style 0
		north 16
		east 24
		south 30
		west 22
	)

	(method (init)
		(super init:)
		(NormalEgo)
		(if ((gGoals at: 2) egoReturned:)
			(= local53 1)
			(Load rsSCRIPT 423)
		)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(north
				(if (> (gEgo x:) 122)
					(gEgo posn: 190 57)
				else
					(gEgo posn: (proc0_13 32 (gEgo x:) 122) 50)
				)
				(self setScript: global145)
			)
			(south
				(gEgo posn: (proc0_13 global63 (gEgo x:) global62) 150)
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo posn: 10 (proc0_13 72 (gEgo y:) global61))
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 250 (proc0_13 140 (gEgo y:) global61))
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 140 init:)
			)
		)
		(proc0_8)
		(boPeep init:)
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
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(boPeep setLoop: 4 setCycle: 0)
				(theHead init: boPeep)
				(proc411_0 (gEgo head:) theHead)
				(= cycles 2)
			)
			(1
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
				(boPeep setLoop: 0)
				(= cycles 2)
			)
			(1
				(= global131 (+ (boPeep x:) 13))
				(= global132 (- (boPeep y:) 65))
				(= global128 101)
				(self setScript: (ScriptID 400) self) ; envisionScript
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
				(= state -1)
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
					(self cue:)
				)
			)
		)
	)
)

(instance sheepSearch of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (or (!= global130 45) (< (gEgo y:) (client y:)))
			(switch (= state newState)
				(0
					(boPeep setCycle: CT 2 1)
					(= seconds (Random 3 6))
				)
				(1
					(boPeep setCycle: End)
					(= seconds (Random 3 6))
				)
				(2
					(boPeep setCycle: CT 2 -1)
					(= seconds (Random 3 6))
					(if (< 5 (Random 1 8))
						(= state 0)
					)
				)
				(3
					(boPeep setCycle: CT 0 -1)
					(= seconds (Random 3 7))
					(= state -1)
				)
			)
		else
			(client setScript: 0)
		)
	)
)

(instance boPeep of CDActor
	(properties
		y 109
		x 125
		view 72
		signal 18432
		cycleSpeed 7
		illegalBits 0
	)

	(method (init)
		(super init: gestureScript)
		(if ((gGoals at: 2) egoReturned:)
			(boPeep setLoop: 4)
			(theHead init: self)
			(if local53
				((ScriptID 423) init:) ; boPeepsSheep
			)
		else
			(self setScript: sheepSearch)
		)
		(= global109 self)
	)
)

(instance theHead of Head
	(properties
		view 72
		loop 2
		signal 2049
		moveHead 0
	)

	(method (init param1)
		(= global110 self)
		(super init: param1)
	)

	(method (doit)
		(self
			setLoop:
				(cond
					((< (gEgo x:) (- (client x:) 20)) 3)
					((> (gEgo x:) (+ (client x:) 20)) 1)
					(else 2)
				)
		)
		(super doit:)
	)
)

(instance speakers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(boPeep say: register self)
			)
			(1
				(if (-- local55)
					(gEgo say: (++ register) self)
				else
					(self dispose:)
				)
			)
			(2
				(if (-- local55)
					(= state -1)
					(= cycles 1)
					(++ register)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance converse of Script
	(properties)

	(method (cue)
		(client setScript: 0)
		(DoSound sndMASTER_VOLUME global125)
		(if (== gScore gPossibleScore)
			(gCurRoom setScript: (ScriptID 205)) ; walkTo
		else
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
			(HandsOn)
		)
	)

	(method (init &tmp temp0)
		(HandsOff)
		(proc0_7 gEgo boPeep)
		(super init: &rest)
		(= temp0 (gGoals at: 2))
		(proc0_20)
		(cond
			(local56
				(switch local56
					(1
						(= global123 10)
						(self setScript: converse2 self 234)
					)
					(2
						(= global123 10)
						(self setScript: converse4 self 241)
					)
					(else
						(self setScript: converse6 self 245)
					)
				)
			)
			((temp0 egoReturned:)
				(self setScript: converse7 self 246)
			)
			((temp0 egoHas:)
				(self setScript: converse5 self 244)
				(temp0 egoReturned: 1)
				(if (== global123 10)
					(= global123 0)
				)
				(= local56 3)
			)
			((temp0 egoTold:)
				(self setScript: converse3 self 235)
				(= global123 10)
				(= local56 2)
			)
			(else
				(self setScript: converse1 self 229)
				(temp0 egoTold: 1)
				(= local56 1)
				(= global123 10)
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
				(= local55 5)
				(self setScript: speakers self register)
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
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
				(boPeep say: register self)
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
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
				(= local55 6)
				(self setScript: speakers self register)
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance converse4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
			)
			(1
				(= local55 3)
				(self setScript: speakers self register)
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
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
				(boPeep say: register self)
			)
			(2
				(proc411_1)
				(boPeep setScript: 0)
				(self setScript: (ScriptID 323) self) ; rhymeScript
			)
			(3
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
				(boPeep say: register self)
			)
			(2
				(proc411_1)
				(boPeep setCel: 0)
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
				(= local55 5)
				(speakers start: 1)
				(self setScript: speakers self (-- register))
			)
			(2
				(proc411_1)
				(boPeep setCel: 0)
				(self dispose:)
			)
		)
	)
)

