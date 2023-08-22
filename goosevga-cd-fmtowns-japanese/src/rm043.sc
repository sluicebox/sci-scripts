;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 43)
(include sci.sh)
(use Main)
(use Avoid)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm043 0
)

(local
	[local0 41] = [2 0 0 0 -14193 85 142 101 92 103 82 108 70 108 57 122 81 128 126 132 126 145 0 -32641 -14169 86 169 90 158 90 171 127 159 133 137 133 137 145 258 -32630 0]
	local41
)

(instance rm043 of Rm
	(properties
		picture 43
		style 0
		south 26
	)

	(method (init)
		(HandsOn)
		(super init:)
		(gEgo setMotion: Freeway (= global75 @local0))
		(if (== gPrevRoomNum 45) ; mapRoom
			(gEgo init:)
		else
			(gEgo loop: 3 posn: 133 125)
			(self setScript: gStdWalkIn)
		)
		(proc0_8 154 94 133 165)
		(candle init:)
		(treeLights init:)
		(fire init:)
		(jack init:)
		(if ((gGoals at: 6) egoHas:)
			(Load rsSCRIPT 985)
		)
		(if ((gGoals at: 6) egoReturned:)
			(jack posn: 77 101 setLoop: 15)
			(theHead init: jack)
		)
		(self cue:)
		(if global172
			(self setScript: converse)
		)
	)

	(method (cue)
		(DoAudio audRATE 5500)
		(Timer set60ths: self (DoAudio audPLAY 590))
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

	(method (dispose &tmp temp0)
		(if (= temp0 (self timer:))
			(temp0 dispose:)
			(temp0 delete:)
		)
		(DoAudio audSTOP)
		(DoAudio audRATE 11000)
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
				(= cycles 2)
			)
			(2
				(DoAudio audRATE 11000)
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
		y 110
		x 172
		view 71
		loop 1
		cycleSpeed 4
		illegalBits 0
		moveSpeed 3
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
		y 113
		x 188
		view 71
		priority 2
		signal 8210
		cycleSpeed 3
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Fwd)
	)
)

(instance candle of Prop
	(properties
		y 84
		x 196
		view 71
		loop 11
		priority 12
		signal 10256
		cycleSpeed 3
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
		y 134
		x 62
		view 71
		loop 12
		priority 15
		signal 10256
		cycleSpeed 3
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

	(method (cue)
		(gCurRoom cue:)
		(client setScript: 0)
		(DoSound sndMASTER_VOLUME global125)
		(if global172
			(gCurRoom newRoom: 45) ; mapRoom
		)
		(HandsOn)
	)

	(method (init &tmp temp0 temp1)
		(HandsOff)
		(proc0_7 gEgo jack)
		(super init: &rest)
		(= temp0 (gGoals at: 6))
		(proc0_20)
		(if (= temp1 (self timer:))
			(temp1 dispose:)
			(temp1 delete:)
		)
		(cond
			(local41
				(switch local41
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
				(= local41 3)
			)
			((temp0 egoTold:)
				(self setScript: converse3 self 93)
				(= global123 3)
				(= local41 2)
			)
			(else
				(self setScript: converse1 self 86)
				(= global123 3)
				(temp0 egoTold: 1)
				(= local41 1)
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
				(gEgo
					setAvoider: (Avoid new:)
					setMotion: MoveTo 141 121 self
				)
			)
			(1
				(DoAudio audRATE 11000)
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
				(self setScript: (ScriptID 343) self) ; rhymeScript
			)
			(7
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
				(= cycles 1)
			)
			(1
				(DoAudio audRATE 11000)
				(jack say: register self)
			)
			(2
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
				(DoAudio audRATE 11000)
				(jack say: register self)
			)
			(1
				(gEgo say: (++ register) self)
			)
			(2
				(jack say: (++ register) self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

