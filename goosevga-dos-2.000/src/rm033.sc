;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33)
(include sci.sh)
(use Main)
(use Waters2)
(use n411)
(use PolyPath)
(use Polygon)
(use Path)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm033 0
)

(local
	local0
	[local1 19] = [232 131 202 134 161 142 131 149 112 151 86 151 47 149 16 147 -4 148 -32768]
	[local20 9] = [72 155 80 172 139 80 20 146 80]
	local29
)

(instance rm033 of Rm
	(properties
		picture 33
		style 0
		horizon 89
		north 26
		east 34
		west 32
	)

	(method (init)
		(= global345 outCode)
		(Load rsVIEW 146)
		(Load rsVIEW 88)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 132 25 129 94 134 136 134 219 116 315 117 315 196 0 196
					yourself:
				)
		)
		(NormalEgo)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_13 147 (gEgo x:) global60) 101)
				(self setScript: gStdWalkIn 1 12)
			)
			(west
				(gEgo posn: 26 124)
				(self setScript: gStdWalkIn 1 12)
			)
			(east
				(gEgo posn: 231 (proc0_13 95 (gEgo y:) 117))
				(self setScript: gStdWalkIn 1 12)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 124 init:)
			)
		)
		(if (> global170 60)
			(smoke init:)
		)
		(if (> global170 75)
			(water init:)
		)
		(= global111 candle)
		(if (> global170 90)
			(leaf init:)
		)
		(if ((gGoals at: 12) egoReturned:)
			(candle ignoreActors: 1 init: posn: 144 109)
			(gCurRoom
				addObstacle:
					(= local29
						((Polygon new:)
							type: PBarredAccess
							init: 0 79 98 79 143 100 158 100 158 112 100 118 73 125 39 125 0 123
							yourself:
						)
					)
			)
		else
			(gCurRoom
				addObstacle:
					(= local29
						((Polygon new:)
							type: PBarredAccess
							init: 0 79 98 79 142 98 138 114 100 118 73 125 39 125 0 123
							yourself:
						)
					)
			)
		)
		(= global341 converse)
		(proc0_8)
		(jack init:)
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
				(self setScript: gStdWalkOut 0 (gEgo edgeHit:))
			)
		)
	)

	(method (dispose)
		(DisposeScript 402)
		(DisposeScript 983)
		(super dispose:)
	)
)

(instance scratch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 5))
				(= register (Random 1 3))
			)
			(1
				(jack setCycle: End self)
			)
			(2
				(= state (if (-- register) 0 else -1))
				(jack setCycle: Beg self)
			)
		)
	)
)

(instance gestureScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 15 45))
			)
			(1
				(= state -1)
				(= register (- (Random 1 4) 1))
				(if (!= register (jack cel:))
					(jack
						setCycle:
							CT
							register
							(if (< (jack cel:) register) 1 else -1)
							self
					)
				else
					(self cue:)
				)
			)
		)
	)
)

(instance jack of CDActor
	(properties
		x 124
		y 112
		view 88
		priority 8
		signal 24593
		cycleSpeed 5
		illegalBits 0
	)

	(method (init)
		(super init: gestureScript)
		(self setScript: scratch)
		(theHead init: self)
		(= global109 self)
		(= global110 theHead)
	)

	(method (handleEvent)
		(return 0)
	)
)

(instance theHead of Head
	(properties
		view 88
		loop 1
		signal 2049
		moveHead 0
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
							((< (gEgo x:) (- (jack x:) 20)) 3)
							((> (gEgo x:) (+ (jack x:) 20)) 1)
							(else 2)
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

(instance smoke of Prop
	(properties
		x 169
		y 49
		view 144
		signal 26656
		cycleSpeed 20
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)

	(method (delete)
		(&= signal $ffdf)
		(super delete:)
	)

	(method (handleEvent)
		(return 0)
	)
)

(instance candle of Prop
	(properties
		x 60
		y 122
		view 55
		cycleSpeed 8
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)

	(method (handleEvent)
		(return 0)
	)
)

(instance water of Waters2
	(properties
		view 146
		priority 12
		signal 24624
		cycleSpeed 9
	)

	(method (getLoop)
		(= x [local20 pos])
		(= y [local20 (++ pos)])
		(= cel [local20 (++ pos)])
	)

	(method (saveLoop)
		(= [local20 pos] cel)
		(++ pos)
	)
)

(instance leaf of Actor
	(properties
		x 262
		y 131
		view 144
		loop 1
		priority 13
		signal 18448
		cycleSpeed 15
		illegalBits 0
		xStep 2
	)

	(method (cue)
		(= cycleSpeed (Random 12 24))
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd setScript: float)
	)

	(method (handleEvent)
		(return 0)
	)
)

(instance floatDown of Path
	(properties)

	(method (at param1)
		(return [local1 param1])
	)
)

(instance float of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(leaf posn: 262 131)
				(= seconds (Random 7 30))
			)
			(1
				(= state -1)
				(leaf setMotion: floatDown self leaf)
			)
		)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not (= state newState))
			(HandsOff)
			(proc0_7 gEgo jack)
			(theHead
				setLoop:
					(cond
						((< (gEgo x:) (- (jack x:) 20)) 3)
						((> (gEgo x:) (+ (jack x:) 20)) 1)
						(else 2)
					)
			)
			(= temp0 (gGoals at: 12))
			(proc0_20)
			(cond
				(local0
					(switch local0
						(1
							(self setScript: converse2 self 272)
						)
						(2
							(self setScript: converse2 self 278)
						)
						(else
							(self setScript: converse6 self 281)
						)
					)
				)
				((temp0 egoReturned:)
					(self setScript: converse7 self 283)
				)
				((temp0 egoHas:)
					(temp0 egoReturned: 1)
					(self setScript: converse5 self 279)
					(if (== global123 12)
						(= global123 0)
					)
					(= local0 3)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self 273)
					(= global123 12)
					(= local0 2)
				)
				(else
					(self setScript: converse1 self 268)
					(temp0 egoTold: 1)
					(= local0 1)
					(= global123 12)
				)
			)
		else
			(client setScript: 0)
			(DoSound sndMASTER_VOLUME global125)
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
				(proc411_0 (gEgo head:) theHead)
				(= cycles 1)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(jack say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
			)
			(4
				(jack say: (++ register) self)
			)
			(5
				(proc411_1)
				(= global131 (+ (jack x:) 13))
				(= global132 (- (jack y:) 52))
				(= global128 111)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(6
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
				(proc411_0 (gEgo head:) theHead)
				(= cycles 1)
			)
			(1
				(jack say: register self)
			)
			(2
				(proc411_1)
				(= global131 (+ (jack x:) 13))
				(= global132 (- (jack y:) 52))
				(= global128 111)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(= global123 12)
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
				(proc411_0 (gEgo head:) theHead)
				(= cycles 1)
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
				(gEgo say: (++ register) self)
			)
			(5
				(jack say: (++ register) self)
			)
			(6
				(proc411_1)
				(= global131 (+ (jack x:) 13))
				(= global132 (- (jack y:) 52))
				(= global128 111)
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
				(theHead dispose:)
				(jack
					setScript: 0
					view: 89
					setLoop: 4
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(jack setLoop: 5 setCel: 0)
				(theHead init: jack view: 88)
				(proc411_0 (gEgo head:) theHead)
				(= cycles 2)
			)
			(2
				(gEgo say: register self)
			)
			(3
				(jack say: (++ register) self)
			)
			(4
				(jack setPri: -1)
				(proc411_1)
				(self setScript: (ScriptID 333) self) ; rhymeScript
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
				(proc411_0 (gEgo head:) jack)
				(= cycles 1)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(jack say: (++ register) self)
			)
			(3
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
				(= cycles 1)
			)
			(1
				(gEgo say: register self)
			)
			(2
				(jack say: (++ register) self)
			)
			(3
				(gEgo say: (++ register) self)
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

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 109 (gEgo x:) 255))
				(= temp1 72)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 91 (gEgo y:) 115))
			)
			(3
				(= temp0 (proc0_13 29 (gEgo x:) 179))
				(= temp1 137)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 124 (gEgo y:) 131))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

