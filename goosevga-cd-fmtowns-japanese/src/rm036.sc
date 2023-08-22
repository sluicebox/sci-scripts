;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm036 0
)

(local
	local0
	local1 = 1
)

(instance rm036 of Rm
	(properties
		picture 36
		style 0
		south 10
		vanishingX 145
		vanishingY 24
	)

	(method (init)
		(super init:)
		(= global112 plate)
		(tail init:)
		(gAddToPics add: spinningWheel doit:)
		(NormalEgo)
		(cond
			((== gPrevRoomNum 10)
				(gEgo posn: 128 120)
				(self setScript: gStdWalkIn)
			)
			((== gPrevRoomNum 45) ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 135 119 init:)
			)
		)
		(proc0_8 195 113 127 159)
		((View new:) view: 651 loop: 0 cel: 0 posn: 106 105 init: stopUpd:)
		((View new:) view: 651 loop: 0 cel: 1 posn: 149 106 init: stopUpd:)
		(if ((gGoals at: 8) egoReturned:)
			(plate init:)
		)
		(if ((gGoals at: 8) egoHas:)
			(Load rsVIEW 652)
		)
		(jack init:)
		(wife init:)
		(dog init:)
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
				(if local1
					(dog
						setScript: 0
						cycleSpeed: 1
						setLoop: 6
						setCel: 0
						setCycle: End
					)
				)
				(= cycles 3)
			)
			(1
				(herHead setCycle: End)
				(= cycles 2)
			)
			(2
				(hisHead setCycle: End self)
			)
			(3
				(hisHead setLoop: 2 cel: 0)
				(herHead setLoop: 4 cel: 0)
				(= cycles 2)
			)
			(4
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
				(hisHead setLoop: 1 setCel: 2 setCycle: Beg self)
			)
			(1
				(herHead setLoop: 3 setCel: 2 setCycle: Beg self)
			)
			(2
				(if local1
					(dog setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(3
				(if local1
					(dog cycleSpeed: 3 setLoop: 5 setCel: 0 setScript: snore)
				)
				(self dispose:)
			)
		)
	)
)

(instance gestScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 5 15))
				(client setCel: (- (Random 1 4) 1))
				(= state -1)
			)
		)
	)

	(method (dispose)
		(client setCel: 0)
		(super dispose:)
	)
)

(instance jack of CDActor
	(properties
		y 105
		x 149
		z 15
		view 651
		loop 8
		signal 1
		illegalBits 0
	)

	(method (init)
		(super init: gestScr)
		(hisHead init: self)
		(= global109 self)
	)
)

(instance wife of CDActor
	(properties
		y 105
		x 105
		z 15
		view 651
		loop 9
		signal 16385
		illegalBits 0
	)

	(method (init)
		(super init: gestScr)
		(herHead init: self)
		(= global110 self)
	)
)

(instance hisHead of Head
	(properties
		view 651
		loop 1
		cycleSpeed 2
		moveHead 0
	)

	(method (init param1)
		(super init: param1)
		(self stopUpd:)
	)
)

(instance herHead of Head
	(properties
		view 651
		loop 3
		cycleSpeed 3
		moveHead 0
	)

	(method (init param1)
		(super init: param1)
		(self stopUpd:)
	)
)

(instance dog of Prop
	(properties
		y 117
		x 60
		view 651
		loop 5
		priority 8
		signal 16400
		cycleSpeed 3
	)

	(method (init)
		(super init:)
		(self setScript: snore)
		(= global111 self)
	)
)

(instance snore of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(dog setCel: 0 setCycle: End self)
				(Timer set60ths: self (DoAudio audPLAY (Random 25 26)))
			)
			(2
				(= state 0)
			)
		)
	)
)

(instance spinningWheel of PV
	(properties
		y 116
		x 172
		view 150
	)
)

(instance plate of View
	(properties
		y 103
		x 129
		z 16
		view 51
		loop 1
		cel 9
		signal 26881
	)
)

(instance tail of Prop
	(properties
		y 112
		x 82
		view 651
		loop 7
		signal 257
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(= global113 self)
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
		(HandsOn)
	)

	(method (init &tmp temp0)
		(HandsOff)
		(proc0_7 gEgo plate)
		(super init: &rest)
		(= temp0 (gGoals at: 8))
		(proc0_20)
		(cond
			(local0
				(switch local0
					(1
						(= global123 15)
						(self setScript: converse2 self 338)
					)
					(2
						(= global123 15)
						(self setScript: converse4 self 345)
					)
					(else
						(self setScript: converse6 self 349)
					)
				)
			)
			((temp0 egoReturned:)
				(self setScript: converse7 self 353)
			)
			((temp0 egoHas:)
				(self setScript: converse5 self 346)
				(temp0 egoReturned: 1)
				(if (== global123 15)
					(= global123 0)
				)
				(= local0 3)
			)
			((temp0 egoTold:)
				(self setScript: converse3 self 339)
				(= global123 15)
				(= local0 2)
			)
			(else
				(self setScript: converse1 self 332)
				(= global123 15)
				(temp0 egoTold: 1)
				(= local0 1)
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
				(jack say: (++ register) self)
			)
			(2
				(gEgo say: (++ register) self)
			)
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
				(self setScript: atEaseScript self)
			)
			(7
				(= global131 (- (jack x:) 22))
				(= global132 (- (jack y:) 59))
				(= global128 107)
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
				(jack say: register self)
			)
			(2
				(= global131 (- (jack x:) 22))
				(= global132 (- (jack y:) 59))
				(= global128 107)
				(self setScript: (ScriptID 400) self) ; envisionScript
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

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
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
				(wife say: (++ register) self)
			)
			(5
				(gEgo say: (++ register) self)
			)
			(6
				(jack say: (++ register) self)
			)
			(7
				(= global131 (- (jack x:) 22))
				(= global132 (- (jack y:) 59))
				(= global128 107)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(8
				(self setScript: atEaseScript self)
			)
			(9
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
				(jack say: register self)
			)
			(2
				(= global131 (- (jack x:) 22))
				(= global132 (- (jack y:) 59))
				(= global128 107)
				(self setScript: (ScriptID 400) self) ; envisionScript
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
				(jack say: (++ register) self)
			)
			(3
				(wife say: (++ register) self)
			)
			(4
				(= local1 0)
				(self setScript: (ScriptID 336) self) ; rhymeScript
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
				(self setScript: attentionScript self)
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
				(wife say: (++ register) self)
			)
			(5
				(self setScript: atEaseScript self)
			)
			(6
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
				(self setScript: attentionScript self)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(wife say: (++ register) self)
			)
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
				(self setScript: atEaseScript self)
			)
			(7
				(self dispose:)
			)
		)
	)
)

