;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 43)
(include sci.sh)
(use Main)
(use n411)
(use PAvoider)
(use PolyPath)
(use Polygon)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm043 0
)

(local
	local0
	local1
)

(instance rm043 of Rm
	(properties
		picture 43
		style 0
		south 26
	)

	(method (init)
		(proc0_3)
		(super init:)
		(= global345 outCode)
		(if (== gPrevRoomNum 45) ; mapRoom
			(gEgo init:)
		else
			(gEgo loop: 3 posn: 133 125)
			(self setScript: gStdWalkIn 1 6)
		)
		(proc0_8 154 94 133 165)
		(= global341 converse)
		(candle init:)
		(treeLights init:)
		(fire init:)
		(jack init:)
		(if ((gGoals at: 6) egoHas:)
			(Load rsSCRIPT 985)
		)
		(if ((gGoals at: 6) egoReturned:)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 146 154 141 135 208 135 199 127 179 127 161 89 143 89 140 99 91 100 86 104 69 104 59 113 51 125 119 133 118 153
						yourself:
					)
			)
			(jack posn: 77 101 setLoop: 15)
			(theHead init: jack)
		else
			(gCurRoom
				addObstacle:
					(= local1
						((Polygon new:)
							type: PContainedAccess
							init: 146 154 141 135 208 135 199 127 179 127 174 113 159 113 159 104 172 104 172 89 143 89 140 99 91 100 86 104 69 104 59 113 51 125 119 133 118 153
							yourself:
						)
					)
			)
		)
		(if global172
			(self setScript: converse)
		)
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

	(method (dispose &tmp temp0)
		(if (= temp0 (self timer:))
			(temp0 dispose:)
			(temp0 delete:)
		)
		(super dispose:)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gCurRoom timer:)
					((gCurRoom timer:) dispose:)
				)
				(jack setLoop: 2 setCel: 0 setCycle: CT 4 1 self)
			)
			(1
				(jack setCel: 255)
				(theHead init: jack)
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
				(jack setCel: 4)
				(= cycles 2)
			)
			(1
				(jack setCycle: CT 0 -1 self)
			)
			(2
				(jack setLoop: 1 setCycle: Fwd)
				(self dispose:)
			)
		)
	)
)

(instance jack of CDActor
	(properties
		x 172
		y 110
		view 71
		loop 1
		cycleSpeed 10
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
		(= global109 self)
	)
)

(instance theHead of Head
	(properties
		view 71
		loop 5
		moveHead 0
	)

	(method (init param1)
		(super init: param1)
		(self stopUpd:)
		(= global110 self)
	)

	(method (doit)
		(self
			setLoop:
				(cond
					((< (gEgo y:) (- (client y:) 20)) 6)
					((< (gEgo y:) (+ (client y:) 1)) 5)
					((> (gEgo y:) (+ (client y:) 20)) 3)
					(else 4)
				)
		)
		(super doit:)
	)
)

(instance fire of Prop
	(properties
		x 188
		y 113
		view 71
		priority 2
		signal 24592
		cycleSpeed 10
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance candle of Prop
	(properties
		x 196
		y 84
		view 71
		loop 11
		priority 12
		signal 10256
		cycleSpeed 12
	)

	(method (init)
		(if (> global170 80)
			(self setCycle: Fwd)
		else
			(|= signal $0101)
		)
		(super init: &rest)
	)
)

(instance treeLights of Prop
	(properties
		x 62
		y 134
		view 71
		loop 12
		priority 15
		signal 10256
		cycleSpeed 12
	)

	(method (init)
		(if (> global170 110)
			(self setCycle: Fwd)
		else
			(|= signal $0101)
		)
		(super init: &rest)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(if (not (= state newState))
			(proc0_2)
			(proc0_7 gEgo jack)
			(= temp0 (gGoals at: 6))
			(proc0_20)
			(if (= temp1 (self timer:))
				(temp1 dispose:)
				(temp1 delete:)
			)
			(cond
				(local0
					(switch local0
						(1
							(self setScript: converse2 self 92)
						)
						(2
							(self setScript: converse2 self 98)
						)
						(else
							(self setScript: converse6 self 103)
						)
					)
				)
				((temp0 egoReturned:)
					(self setScript: converse7 self 104)
				)
				((temp0 egoHas:)
					(self setScript: converse5 self 99)
					(temp0 egoReturned: 1)
					(if (== global123 3)
						(= global123 0)
					)
					(= local0 3)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self 93)
					(= global123 3)
					(= local0 2)
				)
				(else
					(self setScript: converse1 self 86)
					(= global123 3)
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
			(if (!= gScore gPossibleScore)
				(proc0_3)
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
				(jack say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(jack say: (++ register) self)
			)
			(5
				(gEgo say: (++ register) self)
			)
			(6
				(jack say: (++ register) self)
			)
			(7
				(self setScript: atEaseScript self)
			)
			(8
				(= global131 (+ (jack x:) 13))
				(= global132 (- (jack y:) 52))
				(= global128 105)
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
				(jack say: register self)
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global131 (+ (jack x:) 13))
				(= global132 (- (jack y:) 52))
				(= global128 105)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(4
				(= global123 3)
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
				(jack say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(jack say: (++ register) self)
			)
			(5
				(gEgo say: (++ register) self)
			)
			(6
				(self setScript: atEaseScript self)
			)
			(7
				(= global131 (+ (jack x:) 13))
				(= global132 (- (jack y:) 52))
				(= global128 105)
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
				(gEgo setAvoider: PAvoider setMotion: MoveTo 141 121 self)
			)
			(1
				(= global247 gCast)
				(gEgo setAvoider: 0 say: register self)
				(proc0_7 gEgo jack)
				(self setScript: attentionScript self)
			)
			(2)
			(3
				(jack say: (++ register) self)
			)
			(4
				(gEgo say: (++ register) self)
			)
			(5
				(jack say: (++ register) self)
			)
			(6
				(proc411_1)
				(self setScript: (ScriptID 343) self) ; rhymeScript
			)
			(7
				((gCurRoom obstacles:) delete: local1)
				(local1 dispose:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 146 154 141 135 208 135 199 127 179 127 161 89 143 89 140 99 91 100 86 104 69 104 59 113 51 125 119 133 118 153
							yourself:
						)
				)
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
				(jack setLoop: 14)
				(theHead init: jack)
				(proc411_0 theHead)
				(= cycles 1)
			)
			(1
				(jack say: register self)
			)
			(2
				(proc411_1)
				(theHead dispose:)
				(jack setLoop: 13 setCycle: Fwd)
				(= cycles 1)
			)
			(3
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
				(jack say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(jack say: (++ register) self)
			)
			(4
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
				(= temp0 (proc0_13 72 (gEgo x:) 177))
				(= temp1 87)
			)
			(2
				(= temp0 207)
				(= temp1 (proc0_13 87 (gEgo y:) 135))
			)
			(3
				(= temp0 (proc0_13 118 (gEgo x:) 601))
				(= temp1 150)
			)
			(4
				(= temp0 48)
				(= temp1 (proc0_13 102 (gEgo y:) 125))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

