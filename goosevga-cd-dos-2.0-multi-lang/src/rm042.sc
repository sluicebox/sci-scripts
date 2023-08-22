;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42)
(include sci.sh)
(use Main)
(use n411)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm042 0
)

(local
	[local0 55] = [2 0 0 0 -14212 82 124 97 85 95 82 91 77 91 66 96 75 97 76 103 76 114 65 123 118 123 118 144 107 138 0 -32630 -14210 82 126 97 169 96 170 91 183 92 214 117 154 117 137 123 137 144 146 138 258 -32630 0]
	local55
	[local56 20] = [434 440 440 422 430 431 429 419 421 426 437 438 438 435 432 428 418 423 425 441]
	[local76 20] = [1 1 1 1 1 1 1 2 1 2 1 2 2 2 2 1 1 2 1 2]
	[local96 20] = [0 0 0 0 0 0 0 1 0 1 0 1 1 1 1 0 0 1 0 1]
	[local116 18] = [57 48 49 44 58 59 50 56 47 45 46 55 41 54 51 52 0 60]
	[local134 44] = [0 4 0 12 0 11 0 4 4 0 12 0 0 11 0 3 6 0 5 13 0 3 0 15 15 15 0 7 8 14 0 0 0 9 9 0 0 0 2 0 0 0 0 1]
	local178
)

(instance rm042 of Rm
	(properties
		picture 42
		style 0
		south 32
	)

	(method (init)
		(HandsOn)
		(NormalEgo)
		(super init:)
		(gEgo setMotion: Freeway (= global75 @local0))
		(if (== gPrevRoomNum 45) ; mapRoom
			(gEgo init:)
		else
			(gEgo posn: 129 132 init:)
		)
		(proc0_8)
		(mother init:)
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
				(HandsOff)
				(proc0_7 gEgo mother)
				(self setScript: converse)
			)
		)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mother setCycle: CT 0 1 self)
			)
			(1
				(mother setLoop: 1)
				(theHead init: mother)
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
				(mother setLoop: 0 setCycle: Fwd)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance mother of CDActor
	(properties
		y 100
		x 170
		view 91
		cycleSpeed 5
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance theHead of Head
	(properties
		view 91
		moveHead 0
	)

	(method (init param1)
		(super init: param1)
		(self setLoop: 2)
	)

	(method (doit)
		(self
			setLoop:
				(cond
					((< (gEgo x:) (- (client x:) 20)) 2)
					((> (gEgo x:) (+ (client x:) 20)) 4)
					(else 3)
				)
		)
		(super doit:)
	)
)

(instance fire of Prop ; UNUSED
	(properties
		y 97
		x 174
		view 91
		cycleSpeed 3
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance converse of Script
	(properties)

	(method (cue)
		(HandsOn)
		(client setScript: 0)
		(DoSound sndMASTER_VOLUME global125)
	)

	(method (init &tmp temp0)
		(proc0_20)
		(super init: &rest)
		(= temp0 (gGoals at: 14))
		(cond
			(global130
				(self setScript: converse2 self 418)
			)
			(global123
				(self setScript: converse3 self 459)
			)
			(else
				(self setScript: converse1 self)
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
				(mother say: (Random 412 417) self)
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

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
			)
			(1
				(= register [local56 (= local55 (- global130 41))])
				(= local178 (if (== [local76 local55] 1) mother else gEgo))
				(local178 say: register self)
			)
			(2
				(switch [local96 local55]
					(0
						(= cycles 1)
					)
					(1
						(mother say: (++ register) self)
					)
					(else
						(gEgo say: (++ register) self)
					)
				)
			)
			(3
				(self setScript: atEaseScript self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance converse3 of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
			)
			(1
				(gEgo say: (+ 459 (- global123 1)) self)
			)
			(2
				(if (= temp0 [local116 (- global123 1)])
					(for ((= temp1 0)) (< temp1 45) ((++ temp1))
						(if (== [global200 temp1] temp0)
							(break)
						)
					)
				else
					(= temp1 9)
				)
				(mother say: (+ 443 [local134 (-- temp1)]) self)
			)
			(3
				(self setScript: atEaseScript self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

