;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33)
(include sci.sh)
(use Main)
(use Waters2)
(use n411)
(use Path)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm033 0
)

(local
	[local0 45] = [2 0 0 0 -14336 126 9 124 36 128 60 123 87 122 112 119 132 116 140 114 145 106 147 97 140 90 0 -32730 -14336 129 43 129 97 132 141 133 151 128 177 122 216 115 258 -32653 0]
	local45
	[local46 19] = [232 131 202 134 161 142 131 149 112 151 86 151 47 149 16 147 -4 148 -32768]
	[local65 9] = [72 155 80 172 139 80 20 146 80]
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
		(Load rsVIEW 146)
		(Load rsVIEW 88)
		(super init:)
		(proc0_1)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_13 147 (gEgo x:) global62) 101)
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo posn: 10 124)
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 250 (proc0_13 95 (gEgo y:) 117))
				(self setScript: gStdWalkIn)
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
			(candle init: posn: 144 109)
		)
		(proc0_8)
		(jack init:)
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
				(= cycles (Random 5 15))
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
		y 112
		x 124
		view 88
		priority 9
		signal 8193
		cycleSpeed 1
		illegalBits 0
	)

	(method (init)
		(super init: gestureScript)
		(self setScript: scratch)
		(theHead init: self)
		(= global109 self)
		(= global110 theHead)
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

(instance smoke of Prop
	(properties
		y 49
		x 169
		view 144
		signal 26656
		cycleSpeed 6
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)

	(method (delete)
		(&= signal $ffdf)
		(super delete:)
	)
)

(instance candle of Prop
	(properties
		y 122
		x 60
		view 55
		cycleSpeed 2
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)
)

(instance water of Waters2
	(properties
		view 146
		priority 12
		signal 24624
		cycleSpeed 2
	)

	(method (getLoop)
		(= x [local65 pos])
		(= y [local65 (++ pos)])
		(= cel [local65 (++ pos)])
	)

	(method (saveLoop)
		(= [local65 pos] cel)
		(++ pos)
	)
)

(instance leaf of Act
	(properties
		y 131
		x 262
		view 144
		loop 1
		priority 13
		signal 18448
		cycleSpeed 5
		illegalBits 0
		xStep 2
	)

	(method (cue)
		(= cycleSpeed (Random 3 7))
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd setScript: float)
	)
)

(instance floatDown of Path
	(properties)

	(method (at param1)
		(return [local46 param1])
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

	(method (cue)
		(client setScript: 0)
		(DoSound sndMASTER_VOLUME global125)
		(if global172
			(gCurRoom newRoom: 45) ; mapRoom
		)
		(proc0_3)
	)

	(method (init &tmp temp0)
		(proc0_2)
		(proc0_7 gEgo jack)
		(super init: &rest)
		(= temp0 (gGoals at: 12))
		(proc0_20)
		(cond
			(local45
				(switch local45
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
				(= local45 3)
			)
			((temp0 egoTold:)
				(self setScript: converse3 self 273)
				(= global123 12)
				(= local45 2)
			)
			(else
				(self setScript: converse1 self 268)
				(temp0 egoTold: 1)
				(= local45 1)
				(= global123 12)
			)
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

