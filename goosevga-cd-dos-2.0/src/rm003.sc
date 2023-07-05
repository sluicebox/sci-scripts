;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use Waters2)
(use n411)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm003 0
)

(local
	[local0 12] = [1 0 0 -14221 116 107 129 81 139 37 -32621 0]
	local12
	[local13 15] = [55 109 80 140 88 80 146 95 80 225 87 80 23 119 80]
)

(instance rm003 of Rm
	(properties
		picture 3
		style 0
		east 4
		west 2
	)

	(method (init)
		(super init:)
		(Load rsVIEW 85)
		(proc0_1)
		(gEgo setMotion: Freeway (= global75 @local0))
		(tommy init:)
		(switch gPrevRoomNum
			(west
				(gEgo posn: 12 145)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(east
				(gEgo posn: 221 129)
				(self setScript: gStdWalkIn)
			)
			(else
				(gEgo posn: 201 130 init:)
				(if global172
					(self setScript: converse)
				)
			)
		)
		(soapBox init:)
		(water3 init:)
		(proc0_8)
	)

	(method (dispose)
		(DisposeScript 303)
		(DisposeScript 402)
		(super dispose:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl: 1) $0002)
				(gStdWalkOut register: 2)
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
			(else
				(event claimed: 1)
				(if (not (& (gEgo onControl: 0) $4000))
					(self setScript: converse)
				)
			)
		)
	)
)

(instance entranceScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(switch gPrevRoomNum
					(2
						(= global131 12)
						(= global132 (gEgo y:))
					)
					(4
						(= global131 212)
						(= global132 132)
					)
				)
				(gEgo init: setMotion: MoveTo global131 global132 self)
			)
			(1
				(proc0_3)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance exitScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gEgo
					setMotion:
						MoveTo
						(if (< (gEgo x:) global140) global137 else global138)
						(gEgo y:)
						self
				)
			)
			(1
				(proc0_3)
				(gCurRoom newRoom: (if (< (gEgo x:) global140) 2 else 4))
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
				(= register (- (Random 1 (NumCels tommy)) 1))
				(if (!= register (tommy cel:))
					(tommy
						setCycle:
							CT
							register
							(if (< (tommy cel:) register) 1 else -1)
							self
					)
				else
					(= cycles 1)
				)
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance soapBox of View
	(properties
		y 119
		x 143
		view 85
		cel 1
		priority 9
		signal 273
	)
)

(instance tommy of CDActor
	(properties)

	(method (init &tmp temp0)
		(= temp0 (gGoals at: 7))
		(self
			setPri: 9
			cycleSpeed: 3
			view: 85
			setLoop: (if (temp0 egoReturned:) 8 else 9)
			setCel: 0
			ignoreControl: 1
			ignoreActors: 1
			illegalBits: 0
			posn: 143 120 9
		)
		(= global109 self)
		(super init: gestureScript)
		(theHead init: self)
	)
)

(instance theHead of Head
	(properties)

	(method (init param1)
		(self moveHead: 0 view: 85 setLoop: 2 stopUpd:)
		(super init: param1)
		(= global110 self)
	)

	(method (doit)
		(self setPri: (client priority:))
		(if (not script)
			(self
				setLoop:
					(cond
						((< (gEgo x:) (- (client x:) 20)) 2)
						((> (gEgo x:) (+ (client x:) 20)) 3)
						(else 1)
					)
			)
		)
		(super doit:)
	)
)

(instance water3 of Waters2
	(properties
		view 122
		cycleSpeed 5
	)

	(method (getLoop)
		(= x [local13 pos])
		(= y [local13 (++ pos)])
		(= cel [local13 (++ pos)])
	)

	(method (saveLoop)
		(= [local13 pos] cel)
		(++ pos)
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
		(proc0_7 gEgo tommy)
		(super init: &rest)
		(= temp0 (gGoals at: 7))
		(proc0_20)
		(proc411_0 (gEgo head:) theHead)
		(cond
			(local12
				(switch local12
					(1
						(self setScript: converse2 self 163)
					)
					(2
						(self setScript: converse2 self 169)
					)
					(else
						(self setScript: converse6 self 175)
					)
				)
			)
			((temp0 egoReturned:)
				(self setScript: converse7 self 176)
			)
			((temp0 egoHas:)
				(self setScript: converse5 self 170)
				(temp0 egoReturned: 1)
				(if (== global123 7)
					(= global123 0)
				)
				(= local12 3)
			)
			((temp0 egoTold:)
				(= global123 7)
				(self setScript: converse3 self 164)
				(= local12 2)
			)
			(else
				(self setScript: converse1 self 156)
				(= global123 7)
				(temp0 egoTold: 1)
				(= local12 1)
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
				(tommy say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(tommy say: (++ register) self)
			)
			(4
				(gEgo say: (++ register) self)
			)
			(5
				(tommy say: (++ register) self)
			)
			(6
				(gEgo say: (++ register) self)
			)
			(7
				(tommy say: (++ register) self)
			)
			(8
				(proc411_1)
				(= global131 (+ (tommy x:) 13))
				(= global132 (- (tommy y:) 64))
				(= global128 106)
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
				(= cycles 1)
			)
			(1
				(tommy say: register self)
			)
			(2
				(proc411_1)
				(= global131 (+ (tommy x:) 13))
				(= global132 (- (tommy y:) 64))
				(= global128 106)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(= global123 7)
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
				(tommy say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(tommy say: (++ register) self)
			)
			(4
				(gEgo say: (++ register) self)
			)
			(5
				(tommy say: (++ register) self)
			)
			(6
				(proc411_1)
				(= global131 (+ (tommy x:) 13))
				(= global132 (- (tommy y:) 64))
				(= global128 106)
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
				(= cycles 1)
			)
			(1
				(proc0_7 gEgo tommy)
				(tommy say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(tommy say: (++ register) self)
			)
			(4
				(gEgo say: (++ register) self)
			)
			(5
				(tommy say: (++ register) self)
			)
			(6
				(proc411_1)
				(self setScript: (ScriptID 303) self) ; rhymeScript
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
				(= cycles 1)
			)
			(1
				(tommy say: register self)
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
				(= cycles 1)
			)
			(1
				(tommy say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(tommy say: (++ register) self)
			)
			(4
				(gEgo say: (++ register) self)
			)
			(5
				(tommy say: (++ register) self)
			)
			(6
				(proc411_1)
				(self dispose:)
			)
		)
	)
)

