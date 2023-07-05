;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use n411)
(use PolyPath)
(use Polygon)
(use Game)
(use Actor)
(use System)

(public
	rm001 0
)

(local
	local0
	local1
)

(instance rm001 of Rm
	(properties
		picture 1
		style 0
		east 2
		south 8
	)

	(method (init)
		(= global345 outCode)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 74 155 73 173 0 183 0 0 258 0 315 66 258 65 207 58 151 43 133 50 102 50 88 46 57 55 32 96 5 107 8 129 75 154
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 230 139 177 134 177 127 258 114 281 115 290 174 201 176 201 155
					yourself:
				)
		)
		(gCurRoom
			addObstacle:
				(= local1
					((Polygon new:)
						type: PBarredAccess
						init: 155 107 155 117 113 117 113 107
						yourself:
					)
				)
		)
		(Load rsVIEW 67)
		(Load rsVIEW 153)
		(proc0_1)
		(switch gPrevRoomNum
			(east
				(gEgo posn: 231 (proc0_13 64 (gEgo y:) 102))
				(self setScript: gStdWalkIn 1 13)
			)
			(south
				(gEgo posn: (proc0_13 81 (gEgo x:) 175) 139)
				(self setScript: gStdWalkIn 1 13)
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
		(if ((gGoals at: 13) egoReturned:)
			(pail init:)
		)
		(= global341 converse)
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
)

(instance pail of Actor
	(properties
		x 134
		y 115
		view 56
		signal 26624
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
		x 124
		y 113
		view 67
		illegalBits 0
		xStep 2
	)

	(method (init)
		(super init: gestScr)
		(self ignoreActors: 1)
		(= global109 self)
		(JackHead init: self)
	)

	(method (onMe)
		(return 0)
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
		x 143
		y 113
		view 67
		loop 1
		signal 16384
		illegalBits 0
		xStep 2
	)

	(method (init)
		(super init: gestScr)
		(self ignoreActors: 1 setScript: mimicJack)
		(= global110 self)
		(JillHead init: self)
	)

	(method (onMe)
		(return 0)
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

	(method (changeState newState &tmp temp0)
		(if (not (= state newState))
			(proc0_2)
			(= temp0 (gGoals at: 13))
			(proc0_7 gEgo jack)
			(proc0_20)
			(proc411_0 (gEgo head:) JackHead JillHead)
			(cond
				(local0
					(switch local0
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
					(= local0 3)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self 192)
					(= global123 8)
					(= local0 2)
				)
				(else
					(self setScript: converse1 self 181)
					(temp0 egoTold: 1)
					(= local0 1)
					(= global123 8)
				)
			)
		else
			(DoSound sndMASTER_VOLUME global125)
			(client setScript: 0)
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
			(proc0_5)
			(proc0_3)
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
				((gCurRoom obstacles:) delete: local1)
				(local1 dispose:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 85 134 145 134 145 144 85 144
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

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 7 (gEgo x:) 237))
				(= temp1 37)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 65 (gEgo y:) 114))
			)
			(3
				(= temp0 (proc0_13 76 (gEgo x:) 180))
				(= temp1 158)
			)
			(4
				(= temp0 3)
				(= temp1 (proc0_13 107 (gEgo y:) 128))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

