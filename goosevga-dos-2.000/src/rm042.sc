;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 42)
(include sci.sh)
(use Main)
(use n411)
(use PolyPath)
(use Polygon)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm042 0
)

(local
	local0
	[local1 20] = [434 440 440 422 430 431 429 419 421 426 437 438 438 435 432 428 418 423 425 441]
	[local21 20] = [1 1 1 1 1 1 1 2 1 2 1 2 2 2 2 1 1 2 1 2]
	[local41 20] = [0 0 0 0 0 0 0 1 0 1 0 1 1 1 1 0 0 1 0 1]
	[local61 18] = [57 48 49 44 58 59 50 56 47 45 46 55 41 54 51 52 0 60]
	[local79 44] = [0 4 0 12 0 11 0 4 4 0 12 0 0 11 0 3 6 0 5 13 0 3 0 15 15 15 0 7 8 14 0 0 0 9 9 0 0 0 2 0 0 0 0 1]
	local123
)

(instance rm042 of Rm
	(properties
		picture 42
		style 0
		south 32
	)

	(method (init)
		(proc0_3)
		(proc0_1)
		(super init:)
		(= global345 outCode)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 146 151 142 128 152 123 154 113 184 111 203 116 219 114 192 91 188 105 140 105 141 93 89 92 77 88 62 100 81 107 57 124 116 127 114 151
					yourself:
				)
		)
		(gEgo posn: 129 132 init:)
		(= global341 converse)
		(proc0_8)
		(mother init:)
	)

	(method (doit)
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
		x 170
		y 100
		view 91
		cycleSpeed 15
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
		x 174
		y 97
		view 91
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(proc0_2)
		(if (not (= state newState))
			(if (not global172)
				(proc0_7 gEgo mother)
			)
			(proc0_20)
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
		else
			(proc0_3)
			(client setScript: 0)
			(DoSound sndMASTER_VOLUME global125)
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
				(= register [local1 (= local0 (- global130 41))])
				(= local123 (if (== [local21 local0] 1) mother else gEgo))
				(local123 say: register self)
			)
			(2
				(switch [local41 local0]
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
				(if (= temp0 [local61 (- global123 1)])
					(for ((= temp1 0)) (< temp1 45) ((++ temp1))
						(if (== [global200 temp1] temp0)
							(break)
						)
					)
				else
					(= temp1 9)
				)
				(if (and (== temp0 41) (< [local79 (- temp1 1)] 8))
					(mother say: (+ 598 [local79 (-- temp1)]) self)
				else
					(mother say: (+ 443 [local79 (-- temp1)]) self)
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

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 71 (gEgo x:) 142))
				(= temp1 83)
			)
			(2
				(= temp0 219)
				(= temp1 (proc0_13 87 (gEgo y:) 113))
			)
			(3
				(= temp0 (proc0_13 114 (gEgo x:) 151))
				(= temp1 151)
			)
			(4
				(= temp0 56)
				(= temp1 (proc0_13 87 (gEgo y:) 122))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

