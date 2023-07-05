;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
(include sci.sh)
(use Main)
(use n411)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm007 0
)

(local
	[local0 27] = [2 0 0 0 -6055 130 0 0 160 123 0 0 147 108 0 0 72 -32659 0 0 -14310 155 50 141 0 -32667 0]
	local27
)

(instance rm007 of Rm
	(properties
		picture 7
		style 0
		south 14
		west 6
	)

	(method (init &tmp temp0 temp1)
		(proc0_1)
		(super init:)
		(Load rsVIEW 86)
		(= temp0 (gEgo x:))
		(= temp1 (gEgo y:))
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(west
				(= temp1 (proc0_13 69 temp1 111))
				(gEgo posn: 10 temp1 init:)
				(self setScript: gStdWalkIn)
			)
			(south
				(= temp0 (proc0_13 51 temp0 201))
				(gEgo setPri: -1 posn: temp0 150 init:)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120 init:)
			)
		)
		(proc0_8)
		(cat init:)
		(dog init:)
		(moon init:)
		(cow init:)
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
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)
)

(instance tapScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theHead dispose:)
				(cat setLoop: 0 setCel: 0 setCycle: End self)
			)
			(1
				(cat setCycle: End self)
			)
			(2
				(cat setCycle: End self)
			)
			(3
				(cat setLoop: 14 setCel: 0)
				(theHead init: cat)
				(proc411_0 (gEgo head:) theHead)
				(= cycles 2)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance cat of CDActor
	(properties
		y 116
		x 119
		z 10
		view 86
		loop 14
		signal 16385
		illegalBits 0
		xStep 2
	)

	(method (init)
		(if ((gGoals at: 5) egoReturned:)
			(= cel 1)
		)
		(super init:)
		(theHead init: self)
		(= global109 self)
	)
)

(instance theHead of Head
	(properties
		view 86
		loop 1
		moveHead 0
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

(instance cow of Act
	(properties
		y 90
		x 208
		yStep 8
		view 86
		loop 5
		cel 4
		signal 8193
		cycleSpeed 5
		illegalBits 0
		xStep 8
	)

	(method (init)
		(if (> global170 70)
			(cowHead init:)
			(self setScript: cowScript)
		else
			(|= signal $0101)
		)
		(super init:)
		(= global110 self)
	)
)

(instance cowHead of Prop
	(properties
		y 78
		x 186
		z 1
		view 86
		loop 15
		signal 16384
		cycleSpeed 5
	)
)

(instance cowScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cowHead setCycle: Fwd hide:)
				(cow setCycle: End self)
			)
			(1
				(cowHead show:)
				(cow stopUpd:)
				(= state -1)
				(= seconds (Random 5 12))
			)
		)
	)
)

(instance dog of Act
	(properties
		y 100
		x 50
		view 86
		loop 9
		signal 8192
		cycleSpeed 1
		illegalBits 0
	)

	(method (init)
		(if (> global170 90)
			(self setCycle: Fwd)
		else
			(|= signal $0101)
		)
		(super init:)
		(= global111 self)
	)
)

(instance moon of View
	(properties
		y 37
		x 107
		view 86
		loop 8
		cel 2
	)

	(method (init)
		(super init:)
		(= global112 self)
	)

	(method (doit)
		(= cel (if (< (cow y:) y) 3 else 2))
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
		(proc0_3)
	)

	(method (init &tmp temp0)
		(proc0_7 gEgo cat)
		(proc0_2)
		(super init: &rest)
		(= temp0 (gGoals at: 5))
		(proc0_20)
		(cond
			(local27
				(if (== local27 82)
					(self setScript: converse6 self local27)
				else
					(self setScript: converse2 self local27)
				)
			)
			((temp0 egoReturned:)
				(self setScript: converse7 self 83)
			)
			((temp0 egoHas:)
				(self setScript: converse5 self 80)
				(if (== global123 2)
					(= global123 0)
				)
				(= local27 82)
			)
			((temp0 egoTold:)
				(self setScript: converse3 self 74)
				(= global123 2)
				(= local27 79)
			)
			(else
				(self setScript: converse1 self 68)
				(temp0 egoTold: 1)
				(= global123 2)
				(= local27 73)
			)
		)
	)
)

(instance converse1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: tapScript self)
			)
			(1
				(cat say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(cat say: (++ register) self)
			)
			(4
				(gEgo say: (++ register) self)
			)
			(5
				(cat say: (++ register) self)
			)
			(6
				(proc411_1)
				(= global131 (+ (cat x:) 1))
				(= global132 (- (cat y:) 75))
				(= global128 104)
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
				(self setScript: tapScript self)
			)
			(1
				(cat say: register self)
			)
			(2
				(proc411_1)
				(= global131 (+ (cat x:) 1))
				(= global132 (- (cat y:) 75))
				(= global128 104)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(= global123 2)
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
				(self setScript: tapScript self)
			)
			(1
				(cat say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(cat say: (++ register) self)
			)
			(4
				(gEgo say: (++ register) self)
			)
			(5
				(cat say: (++ register) self)
			)
			(6
				(proc411_1)
				(= global131 (+ (cat x:) 1))
				(= global132 (- (cat y:) 75))
				(= global128 104)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(7
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
				(cowHead dispose:)
				(cow setScript: 0)
				(self setScript: tapScript self)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(cat say: (++ register) self)
			)
			(3
				(proc411_1)
				(self setScript: (ScriptID 307) self) ; rhymeScript
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
				(= cycles 2)
			)
			(1
				(cat say: register self)
			)
			(2
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
				(proc411_0 (gEgo head:) theHead)
				(= cycles 2)
			)
			(1
				(cat say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(cat say: (++ register) self)
			)
			(4
				(proc411_1)
				(self dispose:)
			)
		)
	)
)

