;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use Waters)
(use n411)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm031 0
)

(local
	[local0 31] = [2 0 0 0 -14336 117 128 124 134 122 164 97 151 89 114 90 83 101 0 -32671 -14287 68 154 82 150 88 167 97 207 -32690 0]
	local31
	[local32 12] = [72 133 0 1 133 0 5 147 0 72 148 0]
	local44
	local45
)

(instance rm031 of Rm
	(properties
		picture 31
		style 0
		north 24
		east 32
		west 30
	)

	(method (init)
		(super init:)
		(NormalEgo)
		(gEgo setMotion: Freeway (= global75 @local0))
		(switch gPrevRoomNum
			(north
				(if (< (gEgo x:) 100)
					(gEgo posn: 10 67)
				else
					(gEgo posn: 220 82)
				)
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo
					posn: 10 (proc0_13 66 (proc0_14 72 (gEgo y:) 115) 129)
				)
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 250 (proc0_13 86 (gEgo y:) 130))
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
		(water init:)
		(bell1 init:)
		(bell2 init:)
		(bell3 init:)
		(bell4 init:)
		(maid1 init:)
		(maid2 init:)
		(maid3 init:)
		(shell1 init:)
		(shell2 init:)
		(shell3 init:)
		(shell4 init:)
		(mary init:)
		(if ((gGoals at: 14) egoReturned:)
			((Flower new:) init: -6)
		)
		(if global172
			(self setScript: converse)
		)
	)

	(method (doit &tmp temp0)
		(water doit:)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl:) $0200)
				(self setScript: gStdWalkOut 0 1)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(self setScript: gStdWalkOut 0 (gEgo edgeHit:))
			)
		)
	)

	(method (handleEvent event)
		(if (or (event claimed:) (!= (event type:) evVERB) script)
			(return)
		else
			(event claimed: 1)
			(self setScript: converse)
		)
	)

	(method (dispose)
		(DoAudio audRATE 11000)
		(DisposeScript 331)
		(DisposeScript 401)
		(super dispose:)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mary loop: 3 setCel: 0 setCycle: End self)
			)
			(1
				(= cycles 2)
			)
			(2
				(mary setLoop: 4 setCel: 0)
				(theHead init: mary)
				(proc411_0 (gEgo head:) theHead mary)
				(= cycles 2)
			)
			(3
				(DoAudio audRATE 11000)
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
				(mary setLoop: 3 setCel: 255 setCycle: Beg self)
			)
			(1
				(= cycles 2)
			)
			(2
				(mary setLoop: 2 setCycle: Fwd)
				(= cycles 2)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance gestScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 5 15))
				(client setCel: (- (Random 1 5) 1))
				(= state -1)
			)
		)
	)

	(method (dispose)
		(client setCel: 0)
		(super dispose:)
	)
)

(instance mary of CDActor
	(properties
		y 92
		x 118
		view 74
		loop 2
		cycleSpeed 4
		illegalBits 0
	)

	(method (init)
		(super init: gestScr)
		(self setCycle: Fwd)
		(= global109 self)
	)
)

(instance theHead of Head
	(properties
		view 74
		loop 8
		signal 1
		moveHead 0
	)

	(method (init param1)
		(super init: param1)
		(-- y)
		(++ z)
		(= gTheHead theHead)
	)

	(method (doit)
		(self
			setLoop:
				(cond
					((< (gEgo x:) (- (client x:) 40)) 10)
					((> (gEgo x:) (+ (client x:) 40)) 9)
					(else 8)
				)
		)
		(super doit:)
	)
)

(class mouseProp of Prop
	(properties
		signal 257
	)

	(method (handleEvent event)
		(if (proc0_18 self event)
			(event claimed: 1)
			(if (not local44)
				(= local44 1)
				(if (not (gCurRoom script:))
					(switch loop
						(1
							(DoAudio audPLAY 46)
						)
						(0
							(DoAudio audRATE 22000)
							(DoAudio audPLAY 43)
						)
					)
				)
				(self signal: 6 setScript: propScript)
			)
		)
	)
)

(instance bell1 of mouseProp
	(properties
		y 72
		x 65
		view 74
		cycleSpeed 2
	)

	(method (init)
		(super init:)
		(= global110 self)
	)
)

(instance bell2 of mouseProp
	(properties
		y 73
		x 87
		view 74
		cel 1
		cycleSpeed 2
	)

	(method (init)
		(super init:)
		(= global111 self)
	)
)

(instance bell3 of mouseProp
	(properties
		y 75
		x 108
		view 74
		cel 2
		cycleSpeed 2
	)

	(method (init)
		(super init:)
		(= global112 self)
	)
)

(instance bell4 of mouseProp
	(properties
		y 77
		x 128
		view 74
		cel 3
		cycleSpeed 2
	)

	(method (init)
		(super init:)
		(= global113 self)
	)
)

(instance maid1 of mouseProp
	(properties
		y 79
		x 42
		view 74
		loop 5
		cycleSpeed 6
	)

	(method (init)
		(super init:)
		(= global120 self)
	)
)

(instance maid2 of mouseProp
	(properties
		y 85
		x 30
		view 74
		loop 6
		cycleSpeed 6
	)

	(method (init)
		(super init:)
		(= gMaid2 self)
	)
)

(instance maid3 of mouseProp
	(properties
		y 91
		x 17
		view 74
		loop 7
		cycleSpeed 6
	)

	(method (init)
		(super init:)
		(= global122 self)
	)
)

(instance shell1 of mouseProp
	(properties
		y 75
		x 60
		view 74
		loop 1
	)

	(method (init)
		(super init:)
		(= global133 self)
	)
)

(instance shell2 of mouseProp
	(properties
		y 77
		x 82
		view 74
		loop 1
	)

	(method (init)
		(super init:)
		(= global134 self)
	)
)

(instance shell3 of mouseProp
	(properties
		y 78
		x 106
		view 74
		loop 1
	)

	(method (init)
		(super init:)
		(= gShell3 self)
	)
)

(instance shell4 of mouseProp
	(properties
		y 80
		x 128
		view 74
		loop 1
	)

	(method (init)
		(super init:)
		(= gShell4 self)
	)
)

(instance propScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(client setCycle: Beg self)
			)
			(2
				(= local44 0)
				(if (not (gCurRoom script:))
					(DoAudio audSTOP)
				)
				(DoAudio audRATE 11000)
				(client setScript: 0 signal: 257)
			)
		)
	)
)

(instance water of Waters
	(properties
		priority 15
		view 161
	)

	(method (getLoop)
		(= x [local32 pos])
		(= y [local32 (++ pos)])
		(= cel [local32 (++ pos)])
	)

	(method (saveLoop)
		(= [local32 pos] cel)
		(++ pos)
	)
)

(instance speakers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mary say: register self)
			)
			(1
				(if (-- local31)
					(gEgo say: (++ register) self)
				else
					(self dispose:)
				)
			)
			(2
				(if (-- local31)
					(= state -1)
					(= cycles 1)
					(++ register)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance converse of Script
	(properties)

	(method (cue)
		(DoSound sndMASTER_VOLUME global125)
		(if (!= gScore gPossibleScore)
			(client setScript: 0)
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
			(HandsOn)
		)
	)

	(method (init &tmp temp0)
		(HandsOff)
		(proc0_7 gEgo mary)
		(super init: &rest)
		(= temp0 (gGoals at: 14))
		(proc0_20)
		(cond
			(local45
				(switch local45
					(1
						(self setScript: converse2 self 54)
					)
					(2
						(self setScript: converse2 self 60)
					)
					(else
						(self setScript: converse6 self 63)
					)
				)
			)
			((temp0 egoReturned:)
				(self setScript: converse7 self 64)
			)
			((temp0 egoHas:)
				(self setScript: converse5 self 61)
				(temp0 egoReturned: 1)
				(if (== global123 1)
					(= global123 0)
				)
				(= local45 3)
			)
			((temp0 egoTold:)
				(self setScript: converse3 self 55)
				(= global123 1)
				(= local45 2)
			)
			(else
				(self setScript: converse1 self 48)
				(temp0 egoTold: 1)
				(= global123 1)
				(= local45 1)
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
				(= local31 7)
				(speakers start: 1)
				(self setScript: speakers self (-- register))
			)
			(2
				(proc411_1)
				(= global131 (+ (mary x:) 23))
				(= global132 (- (mary y:) 69))
				(= global128 113)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(self setScript: atEaseScript self)
			)
			(4
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
				(= global131 (+ (mary x:) 23))
				(= global132 (- (mary y:) 69))
				(= global128 113)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
				(self setScript: atEaseScript self)
			)
			(4
				(= global123 1)
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
				(= local31 5)
				(self setScript: speakers self register)
			)
			(2
				(proc411_1)
				(= global131 (+ (mary x:) 23))
				(= global132 (- (mary y:) 69))
				(= global128 113)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(3
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
				(gEgo say: register self)
			)
			(2
				(mary say: (++ register) self)
			)
			(3
				(proc411_1)
				(self setScript: (ScriptID 331) self) ; rhymeScript
			)
			(4
				(self setScript: atEaseScript self)
				((Flower new:) init: 4)
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
				(self setScript: attentionScript self)
			)
			(1
				(mary say: register self)
			)
			(2
				(proc411_1)
				(self setScript: atEaseScript self)
			)
			(3
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
				(proc411_1)
				(self setScript: atEaseScript self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(class Flower of Prop
	(properties
		y 98
		x 21
		view 74
		loop 11
		priority 8
		signal 6161
		cycleSpeed 3
		flowers 0
	)

	(method (init param1)
		(= flowers param1)
		(super init:)
		(cond
			((> flowers 0)
				(= cel 0)
				(self setCycle: End self)
			)
			((> flowers -10)
				(self setCel: 255 cue:)
			)
		)
	)

	(method (cue)
		(if flowers
			((self new:) x: (+ x 15) init: (-- flowers))
		)
		(= signal 2321)
	)
)

