;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use n411)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm001 0
)

(local
	[local0 33] = [2 0 0 0 -14335 111 35 100 62 58 87 52 118 56 145 52 151 48 216 65 258 -32701 -14078 112 169 125 174 138 215 141 198 -32613 0]
	local33
)

(instance rm001 of Rm
	(properties
		picture 1
		style 0
		east 2
		south 8
	)

	(method (init)
		(super init:)
		(Load rsVIEW 67)
		(Load rsVIEW 153)
		(proc0_1)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(east
				(gEgo posn: 255 (proc0_13 64 (gEgo y:) 102))
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo posn: (proc0_13 81 (gEgo x:) 175) 150)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 141 131 init:)
			)
		)
		(jack init:)
		(jill init:)
		(proc0_8)
		(if global172
			(self setScript: converse)
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
)

(instance gestScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 7 17))
				(client setCel: (- (Random 1 (NumCels client)) 1))
				(= state -1)
			)
		)
	)

	(method (dispose)
		(client setCel: 0)
		(super dispose:)
	)
)

(instance mimicJack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(jill setCel: (jack cel:) setLoop: (+ (jack loop:) 1))
				(JillHead setCel: (JackHead cel:))
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance jack of CDActor
	(properties
		y 113
		x 124
		view 67
		cycleSpeed 3
		illegalBits 0
		xStep 2
		moveSpeed 2
	)

	(method (init)
		(super init: gestScr)
		(= global109 self)
		(JackHead init: self)
	)
)

(instance JackHead of Head
	(properties
		view 67
		loop 2
		moveHead 0
	)

	(method (doit)
		(self setPri: (client priority:))
		(if (not script)
			(self setPri: (client priority:))
			(= x (client x:))
			(= y (client y:))
			(= z (CelHigh (client view:) (client loop:) (client cel:)))
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

(instance jill of CDActor
	(properties
		y 113
		x 143
		view 67
		loop 1
		cycleSpeed 3
		illegalBits 0
		xStep 2
	)

	(method (init)
		(super init: gestScr)
		(self setScript: mimicJack)
		(= global110 self)
		(JillHead init: self)
	)
)

(instance JillHead of Head
	(properties
		view 67
		loop 5
		moveHead 0
	)

	(method (doit)
		(self setPri: (client priority:))
		(if (not script)
			(self setPri: (client priority:))
			(= x (client x:))
			(= y (client y:))
			(= z (CelHigh (client view:) (client loop:) (client cel:)))
			(self
				setLoop:
					(cond
						((< (gEgo x:) (- (client x:) 20)) 6)
						((> (gEgo x:) (+ (client x:) 20)) 7)
						(else 5)
					)
			)
		)
		(super doit:)
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
		(proc0_2)
		(super init: &rest)
		(= temp0 (gGoals at: 13))
		(proc0_7 gEgo jack)
		(proc0_20)
		(proc411_0 (gEgo head:) JackHead JillHead)
		(cond
			(local33
				(switch local33
					(1
						(= global123 8)
						(self setScript: converse2 self 190)
					)
					(2
						(= global123 8)
						(self setScript: converse4 self 198)
					)
					(else
						(self setScript: converse6 self 204)
					)
				)
			)
			((temp0 egoReturned:)
				(self setScript: converse7 self 208)
			)
			((temp0 egoHas:)
				(self setScript: converse5 self 200)
				(temp0 egoReturned: 1)
				(if (== global123 8)
					(= global123 0)
				)
				(= local33 3)
			)
			((temp0 egoTold:)
				(self setScript: converse3 self 192)
				(= global123 8)
				(= local33 2)
			)
			(else
				(self setScript: converse1 self 181)
				(temp0 egoTold: 1)
				(= local33 1)
				(= global123 8)
			)
		)
	)
)

(instance converse1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(jill setScript: 0)
				(gEgo say: register self)
			)
			(2
				(jack say: (++ register) self)
			)
			(3
				(jill say: (++ register) self)
			)
			(4
				(jill setScript: mimicJack)
				(= global246 jill)
				(jack say: (++ register) self)
			)
			(5
				(jill setScript: 0)
				(= global246 0)
				(jack say: (++ register) self)
			)
			(6
				(jill setScript: 0)
				(jill say: (++ register) self)
			)
			(7
				(jack say: (++ register) self)
			)
			(8
				(gEgo say: (++ register) self)
			)
			(9
				(jill setScript: mimicJack)
				(= global246 jill)
				(jack say: (++ register) self)
			)
			(10
				(= global246 0)
				(proc411_1)
				(jill setScript: mimicJack)
				(= global131 (+ (jack x:) 13))
				(= global132 (- (jack y:) 54))
				(= global128 112)
				(self setScript: (ScriptID 400) self) ; envisionScript
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
				(= cycles 1)
			)
			(1
				(jill setScript: 0)
				(jack say: register self)
			)
			(2
				(jill setScript: 0)
				(jill say: (++ register) self)
			)
			(3
				(proc411_1)
				(= global131 (+ (jack x:) 13))
				(= global132 (- (jack y:) 54))
				(= global128 112)
				(self setScript: (ScriptID 400) self) ; envisionScript
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
				(= cycles 1)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(jill say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(jill say: (++ register) self)
			)
			(5
				(jill setScript: 0)
				(jack say: (++ register) self)
			)
			(6
				(gEgo say: (++ register) self)
			)
			(7
				(proc411_1)
				(= global131 (+ (jack x:) 13))
				(= global132 (- (jack y:) 54))
				(= global128 112)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(8
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
				(= cycles 1)
			)
			(1
				(jill setScript: 0)
				(jack say: register self)
			)
			(2
				(jill setScript: 0)
				(jill say: (++ register) self)
			)
			(3
				(proc411_1)
				(= global131 (+ (jack x:) 13))
				(= global132 (- (jack y:) 54))
				(= global128 112)
				(self setScript: (ScriptID 400) self) ; envisionScript
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
				(= cycles 1)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(jill setScript: mimicJack)
				(= global246 jill)
				(jack say: (++ register) self)
			)
			(3
				(jill setScript: 0)
				(= global246 0)
				(jack say: (++ register) self)
			)
			(4
				(jill say: (++ register) self)
			)
			(5
				(proc411_1)
				(jack setScript: 0)
				(jill setScript: 0)
				(self setScript: (ScriptID 301) self) ; rhymeScript
			)
			(6
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
				(= cycles 1)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(jack say: (++ register) self)
			)
			(3
				(jill say: (++ register) self)
			)
			(4
				(jack say: (++ register) self)
			)
			(5
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
				(= cycles 1)
			)
			(1
				(jill setScript: 0)
				(gEgo say: register self)
			)
			(2
				(jack say: (++ register) self)
			)
			(3
				(jill say: (++ register) self)
			)
			(4
				(gEgo say: (++ register) self)
			)
			(5
				(jill setScript: mimicJack)
				(= global246 jill)
				(jack say: (++ register) self)
			)
			(6
				(= global246 0)
				(proc411_1)
				(jill setScript: 0)
				(self dispose:)
			)
		)
	)
)

