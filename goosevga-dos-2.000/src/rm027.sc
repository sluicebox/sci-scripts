;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27)
(include sci.sh)
(use Main)
(use n411)
(use PolyPath)
(use Polygon)
(use Timer)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm027 0
)

(local
	local0
	local1
	local2
)

(instance rm027 of Rm
	(properties
		picture 27
		style 0
		horizon 41
		north 20
		east 28
		south 34
		west 26
	)

	(method (init &tmp temp0)
		(= global345 outCode)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 142 0 0 113 33 106 48 81 63 74 142
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 105 295 98 207 98 175 76 154 61 147 38 289 10
					yourself:
				)
		)
		(proc0_1)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 137 43)
				(self setScript: global145 0 3)
			)
			(south
				(gEgo posn: (proc0_13 global61 (gEgo x:) global60) 139)
				(self setScript: gStdWalkIn 0 3)
			)
			(west
				(gEgo posn: 26 (proc0_13 140 (gEgo y:) global59))
				(self setScript: gStdWalkIn 0 3)
			)
			(east
				(gEgo posn: 231 (proc0_13 119 (gEgo y:) global59))
				(self setScript: gStdWalkIn 0 3)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120 init:)
			)
		)
		(boy init:)
		(= global111 afterDog)
		(if ((gGoals at: 3) egoReturned:)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 146 111 146 124 102 124 102 111
						yourself:
					)
			)
			(boy setLoop: 5)
			(theHead init: boy)
			(afterDog init:)
		else
			(gCurRoom
				addObstacle:
					(= local2
						((Polygon new:)
							type: PBarredAccess
							init: 134 110 134 124 103 124 103 110
							yourself:
						)
					)
			)
			(boy setCycle: Fwd)
		)
		(= global341 converse)
		(proc0_8)
		(if global172
			(global129 posn: (- (gEgo x:) 8) (+ (gEgo y:) 5))
			(self setScript: converse)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl:) $0004)
				(self setScript: gStdClimbOut)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(self setScript: gStdWalkOut 0 (gEgo edgeHit:))
			)
		)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(boy setLoop: 1 setCel: 0 setCycle: End self)
			)
			(1
				(boy setLoop: 5 setCycle: 0)
				(theHead init: boy)
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
				(boy setLoop: 1 setCel: 255 setCycle: Beg self)
			)
			(1
				(boy setLoop: 6 setCycle: Fwd)
				(= cycles 2)
			)
			(2
				(self dispose:)
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
				(= register (- (Random 1 (NumCels client)) 1))
				(if (!= register (client cel:))
					(client
						setCycle:
							CT
							register
							(if (< (client cel:) register) 1 else -1)
							self
					)
				else
					(= cycles 1)
				)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance boy of CDActor
	(properties
		x 117
		y 121
		view 73
		loop 6
		cycleSpeed 9
	)

	(method (onMe)
		(return 0)
	)

	(method (init)
		(if (< global170 90)
			(super init:)
		else
			(super init: gestureScript)
		)
		(self ignoreActors: 1)
		(= global109 self)
	)
)

(instance theHead of Head
	(properties
		view 73
		loop 2
		signal 1
		moveHead 0
	)

	(method (init param1)
		(super init: param1)
		(= local0 1)
		(= global110 self)
	)

	(method (doit)
		(if local0
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

(instance bark of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(afterDog setCel: 0)
				(= register (Random 1 3))
				(= seconds (Random 1 4))
			)
			(1
				(if (gCurRoom script:)
					(= state -1)
					(= cycles 1)
				else
					(if global157
						(Timer set60ths: self (DoAudio audPLAY (Random 19 22)))
					)
					(afterDog setCycle: End)
				)
			)
			(2
				(afterDog setCel: 0)
				(if (-- register)
					(self changeState: 1)
				else
					(self changeState: 0)
				)
			)
		)
	)
)

(instance afterDog of Prop
	(properties
		x 135
		y 117
		view 46
		loop 6
		cycleSpeed 9
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1 setScript: bark)
	)

	(method (onMe)
		(return 0)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not (= state newState))
			(proc0_2)
			(proc0_7 gEgo boy)
			(= temp0 (gGoals at: 3))
			(proc0_20)
			(cond
				(local1
					(switch local1
						(1
							(self setScript: converse2 self 255)
						)
						(2
							(self setScript: converse2 self 259)
						)
						(else
							(self setScript: converse6 self 261)
						)
					)
				)
				((temp0 egoReturned:)
					(self setScript: converse7 self 264)
				)
				((temp0 egoHas:)
					(self setScript: converse5 self 260)
					(if (== global123 11)
						(= global123 0)
					)
					(= local1 3)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self 256)
					(= global123 11)
					(= local1 2)
				)
				(else
					(self setScript: converse1 self 250)
					(temp0 egoTold: 1)
					(= global123 11)
					(= local1 1)
				)
			)
		else
			(client setScript: 0)
			(DoSound sndMASTER_VOLUME global125)
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
			(proc0_5)
			(if (== gScore gPossibleScore)
				(gCurRoom setScript: (ScriptID 205)) ; walkTo
			else
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
				(boy say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(boy say: (++ register) self)
			)
			(4
				(gEgo say: (++ register) self)
			)
			(5
				(boy say: (++ register) self)
			)
			(6
				(self setScript: atEaseScript self)
			)
			(7
				(= global131 (+ (boy x:) 13))
				(= global132 (- (boy y:) 52))
				(= global128 102)
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
				(boy say: register self)
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global131 (+ (boy x:) 13))
				(= global132 (- (boy y:) 52))
				(= global128 102)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(4
				(= global123 11)
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
				(boy say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(boy say: (++ register) self)
			)
			(4
				(self setScript: atEaseScript self)
			)
			(5
				(= global131 (+ (boy x:) 13))
				(= global132 (- (boy y:) 52))
				(= global128 102)
				(self setScript: (ScriptID 400) self) ; envisionScript
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
				(self setScript: attentionScript self)
			)
			(1
				(boy say: register self)
			)
			(2
				(proc411_1)
				(= cycles 2)
			)
			(3
				(= local0 0)
				(self setScript: (ScriptID 327) self) ; rhymeScript
			)
			(4
				((gCurRoom obstacles:) delete: local2)
				(local2 dispose:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 146 111 146 124 102 124 102 111
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
				(proc411_0 (gEgo head:) theHead)
				(= cycles 1)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(boy say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(proc411_1)
				(boy setCel: 0)
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
				(gEgo say: register self)
			)
			(2
				(boy say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(boy say: (++ register) self)
			)
			(5
				(proc411_1)
				(boy setCel: 0)
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
				(= temp0 (proc0_13 99 (gEgo x:) 149))
				(= temp1 19)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 101 (gEgo y:) 152))
			)
			(3
				(= temp0 (proc0_13 2 (gEgo x:) 258))
				(= temp1 158)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 144 (gEgo y:) 156))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

