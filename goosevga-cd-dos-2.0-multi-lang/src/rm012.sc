;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use n411)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm012 0
)

(local
	[local0 37] = [2 0 0 0 -14228 155 108 143 42 143 41 126 95 126 109 114 140 113 126 -32768 -14162 0 150 108 152 123 184 131 199 131 208 147 159 151 153 -32613 0]
	local37
)

(instance rm012 of Rm
	(properties
		picture 12
		style 0
		south 19
	)

	(method (init)
		(Load rsVIEW 125)
		(super init:)
		(NormalEgo)
		(door init:)
		(= global111 wifeBareFoot)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(38
				(gEgo loop: 13 cel: 1 posn: 144 117 init:)
				(self setScript: closeDoor)
			)
			(south
				(gEgo posn: 138 150)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 138 150 init:)
			)
		)
		(proc0_8)
		(peter init:)
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
				(HandsOff)
				(self setScript: converse)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(gEgo inRect: 125 96 161 116)
					(not ((gGoals at: 10) egoReturned:))
				)
				(self setScript: openDoor)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)

	(method (dispose)
		(DisposeScript 312)
		(super dispose:)
	)
)

(instance openDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Timer set60ths: self (DoAudio audPLAY 38))
				(door setCycle: End self)
			)
			(1)
			(2
				(gCurRoom newRoom: 38)
			)
		)
	)
)

(instance closeDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(door setCycle: CT 2 -1 self)
			)
			(1
				(door setCycle: Beg self)
				(DoAudio audPLAY 36)
			)
			(2
				(door stopUpd:)
				(if global133
					(gCurRoom setScript: converse)
				else
					(HandsOn)
					(gCurRoom setScript: 0)
				)
			)
		)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(peter setCycle: CT 4 1 self)
			)
			(1
				(peter setCel: 255)
				(theHead init: peter)
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
				(peter setCel: 4)
				(= cycles 2)
			)
			(1
				(peter setCycle: CT 0 -1 self)
			)
			(2
				(= global131 (+ (peter x:) 33))
				(= global132 (- (peter y:) 52))
				(= global128 97)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance atten2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(peter setLoop: 10)
				(theHead init: peter z: 35)
				(proc411_0 (gEgo head:) theHead)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance atEase2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc411_1)
				(theHead dispose:)
				(peter setLoop: 7 setCel: 5)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance peter of CDActor
	(properties
		y 123
		x 174
		view 77
		cycleSpeed 3
		illegalBits 0
		xStep 2
	)

	(method (init)
		(super init:)
		(if ((gGoals at: 10) egoReturned:)
			(peter posn: 107 112 setLoop: 7 setCel: 5)
			(wifeBareFoot init:)
		)
		(= global109 self)
	)
)

(instance theHead of Head
	(properties
		loop 2
		moveHead 0
	)

	(method (doit)
		(self
			setLoop:
				(cond
					((< (gEgo x:) (- (client x:) 20)) 1)
					((> (gEgo x:) (+ (client x:) 20)) 3)
					(else 2)
				)
		)
		(super doit:)
	)
)

(instance door of Prop
	(properties
		y 108
		x 132
		view 125
		loop 1
		signal 1
		cycleSpeed 1
	)

	(method (init)
		(super init:)
		(self setCel: (if (== gPrevRoomNum 38) 255 else 0))
		(= global110 door)
	)

	(method (dispose)
		(super dispose:)
		(self addToPic:)
	)

	(method (delete)
		(&= signal $ffdf)
		(super delete:)
	)
)

(instance wifeBareFoot of CDActor
	(properties
		y 100
		x 142
		z 12
		view 77
		loop 9
		signal 1
	)
)

(instance converse of Script
	(properties)

	(method (cue)
		(client setScript: 0)
		(if global172
			(gCurRoom newRoom: 45) ; mapRoom
		)
		(HandsOn)
		(DoSound sndMASTER_VOLUME global125)
	)

	(method (init &tmp temp0)
		(proc0_7 gEgo peter)
		(super init: &rest)
		(= temp0 (gGoals at: 10))
		(proc0_20)
		(cond
			(local37
				(switch local37
					(1
						(self setScript: converse2 self 296)
					)
					(2
						(self setScript: converse2 self 301)
					)
					(else
						(self setScript: converse6 self 304)
					)
				)
			)
			((temp0 egoReturned:)
				(self setScript: converse7 self 305)
			)
			((temp0 egoHas:)
				(self setScript: converse5 self 302)
				((gGoals at: 18) egoReturned: 1)
				(temp0 egoReturned: 1)
				(if (== global123 13)
					(= global123 0)
				)
				(= local37 3)
			)
			((temp0 egoTold:)
				(self setScript: converse3 self 297)
				(= global123 13)
				(= local37 2)
			)
			(else
				(self setScript: converse1 self 287)
				(temp0 egoTold: 1)
				(= global123 13)
				(= local37 1)
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
				(peter say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(peter say: (++ register) self)
			)
			(5
				(gEgo say: (++ register) self)
			)
			(6
				(peter say: (++ register) self)
			)
			(7
				(gEgo say: (++ register) self)
			)
			(8
				(peter say: (++ register) self)
			)
			(9
				(gEgo say: (++ register) self)
			)
			(10
				(self setScript: atEaseScript self)
			)
			(11
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
				(peter say: register self)
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global123 13)
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
				(peter say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(peter say: (++ register) self)
			)
			(4
				(gEgo say: (++ register) self)
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

(instance converse5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(peter setLoop: 4 setCycle: CT 4 1 self)
			)
			(1
				(peter setCel: 255)
				(theHead init: peter)
				(proc411_0 (gEgo head:) theHead)
				(= cycles 2)
			)
			(2
				(gEgo say: register self)
			)
			(3
				(peter say: (++ register) self)
			)
			(4
				(proc411_1)
				(self setScript: (ScriptID 312) self) ; rhymeScript
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
				(self setScript: atten2 self)
			)
			(1
				(peter say: register self)
			)
			(2
				(self setScript: atEase2 self)
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
				(self setScript: atten2 self)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(peter say: (++ register) self)
			)
			(3
				((Head new:) moveHead: 0 init: wifeBareFoot setLoop: 11 z: 16)
				(global247 add: (wifeBareFoot head:))
				(wifeBareFoot say: (++ register) self)
			)
			(4
				((wifeBareFoot head:) dispose:)
				(self setScript: atEase2 self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

