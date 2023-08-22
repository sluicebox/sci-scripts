;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7)
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
	rm007 0
)

(local
	local0
	local1
)

(instance rm007 of Rm
	(properties
		picture 7
		style 0
		south 14
		west 6
	)

	(method (init &tmp temp0 temp1)
		(= global345 outCode)
		(NormalEgo)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 94 125 82 111 103 110 136 111 141 112 150 121 120 123
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 180 0 105 47 142 18 155 13 183
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 300 0 296 176 210 177 210 150 247 150 239 86 232 74 220 70 53 64 0 68
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 232 82 232 93 160 93 160 82
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 25 91 58 96 57 104 31 105
					yourself:
				)
		)
		(gCurRoom
			addObstacle:
				(= local1
					((Polygon new:)
						type: PBarredAccess
						init: 232 82 232 93 160 93 160 82
						yourself:
					)
				)
		)
		(Load rsVIEW 86)
		(= temp0 (gEgo x:))
		(= temp1 (gEgo y:))
		(switch gPrevRoomNum
			(west
				(= temp1 (proc0_13 69 temp1 111))
				(gEgo posn: 26 temp1 init:)
				(self setScript: gStdWalkIn 1 5)
			)
			(south
				(= temp0 (proc0_13 51 temp0 201))
				(gEgo setPri: -1 posn: temp0 139 init:)
				(self setScript: gStdWalkIn 1 5)
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
		(= global341 converse)
		(cow init:)
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
		x 119
		y 116
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

	(method (handleEvent)
		(return 0)
	)
)

(instance cow of Actor
	(properties
		x 208
		y 90
		yStep 8
		view 86
		loop 5
		cel 4
		signal 24577
		cycleSpeed 15
		illegalBits 0
		xStep 8
		moveSpeed 15
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

	(method (onMe)
		(return 0)
	)
)

(instance cowHead of Prop
	(properties
		x 186
		y 78
		z 1
		view 86
		loop 15
		signal 16384
		cycleSpeed 18
	)

	(method (handleEvent)
		(return 0)
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

(instance dog of Actor
	(properties
		x 50
		y 100
		view 86
		loop 9
		signal 24576
		cycleSpeed 6
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

	(method (onMe)
		(return 0)
	)
)

(instance moon of View
	(properties
		x 107
		y 37
		view 86
		loop 8
		cel 2
		signal 16384
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

	(method (changeState newState &tmp temp0)
		(if (not (= state newState))
			(proc0_7 gEgo cat)
			(HandsOff)
			(= temp0 (gGoals at: 5))
			(proc0_20)
			(cond
				(local0
					(if (== local0 82)
						(self setScript: converse6 self local0)
					else
						(self setScript: converse2 self local0)
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
					(= local0 82)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self 74)
					(= global123 2)
					(= local0 79)
				)
				(else
					(self setScript: converse1 self 68)
					(temp0 egoTold: 1)
					(= global123 2)
					(= local0 73)
				)
			)
		else
			(DoSound sndMASTER_VOLUME global125)
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
			(RedrawCast)
			(HandsOn)
			(if (== gScore gPossibleScore)
				(gCurRoom setScript: (ScriptID 205)) ; walkTo
			else
				(self dispose:)
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
				((gCurRoom obstacles:) delete: local1)
				(local1 dispose:)
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

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 17 (gEgo x:) 229))
				(= temp1 53)
			)
			(2
				(= temp0 248)
				(= temp1 (proc0_13 73 (gEgo y:) 149))
			)
			(3
				(= temp0 (proc0_13 18 (gEgo x:) 210))
				(= temp1 158)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 69 (gEgo y:) 104))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

