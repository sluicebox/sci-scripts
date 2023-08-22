;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use n411)
(use PolyPath)
(use Polygon)
(use Game)
(use Actor)
(use System)

(public
	rm013 0
)

(local
	local0
)

(instance rm013 of Rm
	(properties
		picture 13
		style 0
		north 6
		east 14
		south 20
		west 12
	)

	(method (init)
		(= global345 outCode)
		(NormalEgo)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 168 0 84 16 91 9 119 40 118 79 136 57 155 52 171
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 170 121 155 126 139 120 157 104 170 102 170 43 136 43 139 101 126 118 109 115 114 106 124 99 101 99 122 81 129 18 315 20 315 108
					yourself:
				)
		)
		(switch gPrevRoomNum
			(39
				(gEgo posn: 143 107 init: loop: 1)
			)
			(north
				(gEgo posn: 70 79)
				(self setScript: global145 0 4)
			)
			(east
				(gEgo posn: 231 (proc0_13 114 (gEgo y:) global59))
				(self setScript: gStdWalkIn 0 4)
			)
			(south
				(gEgo posn: (proc0_13 70 (gEgo x:) global60) 139)
				(self setScript: gStdWalkIn 0 4)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 124 138 init:)
			)
		)
		(if (not ((gGoals at: 4) egoReturned:))
			(= global341 converse)
			(mary init:)
		else
			(mary posn: 179 94 init:)
		)
		(proc0_8)
		(if global172
			(global129 posn: (- (gEgo x:) 7) (+ (gEgo y:) 5))
			(self setScript: converse)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((gEgo inRect: 139 100 161 106)
				(gCurRoom newRoom: 39)
			)
			((== (gEgo onControl:) 4)
				(self setScript: gStdClimbOut)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)

	(method (dispose)
		(DisposeScript 983)
		(super dispose:)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and ((gGoals at: 4) egoReturned:) (global129 script:))
					(-= state 1)
				)
				(= cycles 1)
			)
			(1
				(mary setCel: 0)
				(theHead init: mary)
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
				(theHead dispose:)
				(mary setCel: 1)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance mary of CDActor
	(properties
		x 63
		y 143
		yStep 1
		view 69
		cel 1
		signal 16384
		cycleSpeed 9
		illegalBits 0
		xStep 1
	)

	(method (init)
		(super init:)
		(self stopUpd:)
		(= global109 self)
	)
)

(instance theHead of Head
	(properties
		view 69
		loop 2
		moveHead 0
	)

	(method (init param1)
		(super init: param1)
		(self stopUpd:)
	)

	(method (doit)
		(self
			setLoop:
				(cond
					((< (gEgo y:) (client y:)) 2)
					((> (gEgo y:) (+ (client y:) 10)) 1)
					(else 3)
				)
		)
		(super doit:)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (= state newState)
			(client setScript: 0)
			(DoSound sndMASTER_VOLUME global125)
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
			(if (== gScore gPossibleScore)
				(gCurRoom setScript: (ScriptID 205)) ; walkTo
			else
				(HandsOn)
			)
		else
			(HandsOff)
			(= temp0 (gGoals at: 4))
			(proc0_7 gEgo mary)
			(proc0_20)
			(cond
				(local0
					(switch local0
						(1
							(self setScript: converse2 self 219)
						)
						(else
							(self setScript: converse2 self 225)
						)
					)
				)
				((temp0 egoReturned:)
					(self setScript: converse4 self 227)
				)
				((temp0 egoHas:)
					(temp0 egoReturned: 1)
					(self setScript: converse5 self 226)
					(if (== global123 9)
						(= global123 0)
					)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self 220)
					(= global123 9)
					(= local0 2)
				)
				(else
					(self setScript: converse1 self 213)
					(temp0 egoTold: 1)
					(= global123 9)
					(= local0 1)
				)
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
				(mary say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(mary say: (++ register) self)
			)
			(5
				(gEgo say: (++ register) self)
			)
			(6
				(mary say: (++ register) self)
			)
			(7
				(proc411_1)
				(= global131 (+ (mary x:) 13))
				(= global132 (- (mary y:) 52))
				(= global128 103)
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

(instance converse2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
			)
			(1
				(mary say: register self)
			)
			(2
				(proc411_1)
				(= global131 (+ (mary x:) 13))
				(= global132 (- (mary y:) 52))
				(= global128 103)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(self setScript: atEaseScript self)
			)
			(4
				(= global123 9)
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
				(mary say: register self)
			)
			(2
				(gEgo say: (++ register) self)
			)
			(3
				(mary say: (++ register) self)
			)
			(4
				(gEgo say: (++ register) self)
			)
			(5
				(mary say: (++ register) self)
			)
			(6
				(proc411_1)
				(= global131 (+ (mary x:) 13))
				(= global132 (- (mary y:) 52))
				(= global128 103)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(7
				(self setScript: atEaseScript self)
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
				(self setScript: attentionScript self)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(mary say: (++ register) self)
			)
			(3
				(proc411_1)
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
				(mary say: register self)
			)
			(2
				(proc411_1)
				(self setScript: (ScriptID 313) self) ; rhymeScript
			)
			(3
				(= global341 0)
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
				(= temp0 (proc0_13 17 (gEgo x:) 116))
				(= temp1 65)
			)
			(2
				(= temp0 260)
				(= temp1 (proc0_13 111 (gEgo y:) 152))
			)
			(3
				(= temp0 (proc0_13 57 (gEgo x:) 257))
				(= temp1 158)
			)
			(4
				(= temp0 7)
				(= temp1 (proc0_13 99 (gEgo y:) 120))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

