;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use Waters2)
(use n411)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm005 0
)

(local
	[local0 28] = [3 0 0 0 0 -14196 114 154 127 187 139 218 -32625 -14104 150 249 139 256 -32642 -14316 155 37 139 24 136 0 -32630 0]
	local28
	[local29 15] = [203 108 80 118 88 80 112 95 80 23 87 80 236 118 80]
)

(instance rm005 of Rm
	(properties
		picture 5
		style 0
		east 6
		west 4
	)

	(method (init)
		(Load rsVIEW 70)
		(super init:)
		(if ((gGoals at: 16) egoHas:)
			(Load rsSCRIPT 305)
		)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(west
				(gEgo posn: 38 130)
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 250 143)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120 init:)
				(if global172
					(self setScript: converse)
				)
			)
		)
		(= global111 water)
		(water init:)
		(proc0_8)
		(humpty init:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl: 1) $0002)
				(gStdWalkOut register: 4)
				(self setScript: gStdWalkOut)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
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
			((and (not (& (gEgo onControl: 0) $4000)) (!= local28 3))
				(event claimed: 1)
				(self setScript: converse)
			)
		)
	)

	(method (dispose)
		(DisposeScript 402)
		(super dispose:)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(humpty setScript: faceEgoScript)
				(= cycles 2)
			)
			(1
				(proc411_0 (gEgo head:) humpty)
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
				(humpty setScript: 0 setLoop: 0 setCycle: Fwd)
				(= cycles 2)
			)
			(1
				(proc411_1)
				(self dispose:)
			)
		)
	)
)

(instance faceEgoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					setCel: 0
					setLoop:
						(cond
							((< (gEgo x:) (- (client x:) 20)) 2)
							((> (gEgo x:) (+ (client x:) 20)) 4)
							(else 3)
						)
				)
				(= cycles 1)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance gestureScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					setLoop:
						(cond
							((< (gEgo x:) (- (client x:) 20)) 2)
							((> (gEgo x:) (+ (client x:) 20)) 4)
							(else 3)
						)
				)
				(if (== 2 (Random 1 3))
					(client setCel: (Random 0 (- (NumCels client) 1)))
				)
				(= cycles 2)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance humpty of CDActor
	(properties
		y 116
		x 108
		yStep 1
		view 70
		cycleSpeed 3
		illegalBits 0
		xStep 1
	)

	(method (init)
		(if ((gGoals at: 16) egoReturned:)
			(= view 920)
			(= y 101)
			(super init:)
			(theHead init: self)
			(ladder init:)
		else
			(super init: gestureScript)
		)
		(self setCycle: Fwd)
		(= global109 self)
	)
)

(instance theHead of Head
	(properties
		y 101
		x 108
		z 15
		view 920
		loop 1
		signal 16384
		moveHead 0
	)

	(method (init param1)
		(super init: param1)
		(= z 15)
	)
)

(instance water of Waters2
	(properties
		view 132
		priority 1
		signal 24624
		cycleSpeed 5
	)

	(method (getLoop)
		(= x [local29 pos])
		(= y [local29 (++ pos)])
		(= cel [local29 (++ pos)])
	)

	(method (saveLoop)
		(= [local29 pos] cel)
		(++ pos)
	)
)

(instance ladder of View
	(properties
		y 115
		x 108
		view 59
		loop 1
	)
)

(instance converse of Script
	(properties)

	(method (cue)
		(DoSound sndMASTER_VOLUME global125)
		(client setScript: 0)
		(if global172
			(gCurRoom newRoom: 45) ; mapRoom
		)
		(HandsOn)
	)

	(method (init &tmp temp0)
		(HandsOff)
		(proc0_7 gEgo humpty)
		(super init: &rest)
		(= temp0 (gGoals at: 16))
		(proc0_20)
		(cond
			(local28
				(switch local28
					(1
						(self setScript: converse2 self 143)
					)
					(2
						(self setScript: converse2 self 149)
					)
					(else
						(self cue:)
					)
				)
			)
			((temp0 egoReturned:)
				(self setScript: converse6 self 152)
			)
			((temp0 egoHas:)
				(self setScript: converse5 self 150)
				(if (== global123 6)
					(= global123 0)
				)
				(= local28 3)
			)
			((temp0 egoTold:)
				(= global123 6)
				(self setScript: converse3 self 144)
				(= local28 2)
			)
			(else
				(self setScript: converse1 self 137)
				(temp0 egoTold: 1)
				(= global123 6)
				(= local28 1)
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
				(gEgo say: register self)
			)
			(2
				(humpty say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(humpty say: (++ register) self)
			)
			(5
				(gEgo say: (++ register) self)
			)
			(6
				(humpty say: (++ register) self)
			)
			(7
				(self setScript: atEaseScript self)
			)
			(8
				(= global131 (+ (humpty x:) 13))
				(= global132 (- (humpty y:) 54))
				(= global128 115)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(9
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
				(humpty say: register self)
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global131 (+ (humpty x:) 13))
				(= global132 (- (humpty y:) 54))
				(= global128 115)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(4
				(= global123 6)
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
				(gEgo say: register self)
			)
			(2
				(humpty say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(humpty say: (++ register) self)
			)
			(5
				(gEgo say: (++ register) self)
			)
			(6
				(self setScript: atEaseScript self)
			)
			(7
				(= global131 (+ (humpty x:) 13))
				(= global132 (- (humpty y:) 54))
				(= global128 115)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(8
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
				(gEgo say: register self)
			)
			(2
				(humpty say: (++ register) self)
			)
			(3
				(self setScript: atEaseScript self)
			)
			(4
				(= global110 ladder)
				(self setScript: (ScriptID 305) self) ; rhymeScript
			)
			(5
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
				(= cycles 2)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(humpty say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(humpty say: (++ register) self)
			)
			(5
				(proc411_1)
				(self dispose:)
			)
		)
	)
)

