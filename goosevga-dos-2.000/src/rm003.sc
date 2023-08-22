;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use Waters2)
(use n411)
(use PolyPath)
(use Polygon)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm003 0
)

(local
	local0
	[local1 15] = [55 109 80 140 88 80 146 95 80 225 87 80 23 119 80]
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
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 263 121 163 121 161 124 128 124 127 121 109 121 108 124 89 136 47 144 39 151 315 151 315 196 -1 196 0 155 19 155 24 147 0 129 0 0 258 0
					yourself:
				)
		)
		(Load rsVIEW 85)
		(NormalEgo)
		(tommy init:)
		(= global341 converse)
		(switch gPrevRoomNum
			(west
				(= global345 outCode1)
				(gEgo posn: 21 148)
				(self setScript: gStdWalkIn 1 7)
				(= global341 0)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(east
				(= global345 outCode2)
				(gEgo posn: 221 129)
				(self setScript: gStdWalkIn 1 7)
			)
			(else
				(= global345 outCode2)
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
		x 143
		y 119
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
		(self setScript: headMove)
		(= global110 self)
	)

	(method (doit)
		(self setPri: (client priority:))
		(if (not script)
			(self setScript: headMove)
		)
		(super doit:)
	)
)

(instance headMove of Script
	(properties)

	(method (doit)
		(if (not (gCurRoom script:))
			(super doit: &rest)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					setLoop:
						(cond
							((> (Random 0 3) 2)
								(Random 1 3)
							)
							((< (gEgo x:) (- (tommy x:) 20)) 2)
							((> (gEgo x:) (+ (tommy x:) 20)) 3)
							(else 1)
						)
				)
				(= cycles (Random 6 20))
			)
			(1
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance water3 of Waters2
	(properties
		view 122
		cycleSpeed 5
	)

	(method (getLoop)
		(= x [local1 pos])
		(= y [local1 (++ pos)])
		(= cel [local1 (++ pos)])
	)

	(method (saveLoop)
		(= [local1 pos] cel)
		(++ pos)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not (= state newState))
			(HandsOff)
			(proc0_7 gEgo tommy)
			(theHead
				setLoop:
					(cond
						((< (gEgo x:) (- (tommy x:) 20)) 2)
						((> (gEgo x:) (+ (tommy x:) 20)) 3)
						(else 1)
					)
			)
			(= temp0 (gGoals at: 7))
			(proc0_20)
			(proc411_0 (gEgo head:) theHead)
			(cond
				(local0
					(switch local0
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
					(= local0 3)
				)
				((temp0 egoTold:)
					(= global123 7)
					(self setScript: converse3 self 164)
					(= local0 2)
				)
				(else
					(self setScript: converse1 self 156)
					(= global123 7)
					(temp0 egoTold: 1)
					(= local0 1)
				)
			)
		else
			(DoSound sndMASTER_VOLUME global125)
			(client setScript: 0)
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
			(RedrawCast)
			(HandsOn)
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

(instance outCode1 of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 3 (gEgo x:) 28))
				(= temp1 124)
			)
			(2
				(= temp0 29)
				(= temp1 (proc0_13 147 (gEgo y:) 155))
			)
			(3
				(= temp0 (proc0_13 2 (gEgo x:) 18))
				(= temp1 155)
			)
			(4
				(= temp0 -3)
				(= temp1 (proc0_13 130 (gEgo y:) 152))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

(instance outCode2 of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 108 (gEgo x:) 219))
				(= temp1 112)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 121 (gEgo y:) 151))
			)
			(3
				(= temp0 (proc0_13 43 (gEgo x:) 257))
				(= temp1 157)
			)
			(4
				(= temp0 3)
				(= temp1 (proc0_13 107 (gEgo y:) 128))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

