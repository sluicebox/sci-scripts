;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use Waters)
(use n411)
(use PolyPath)
(use Polygon)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm031 0
)

(local
	local0 = 1
	local1
	[local2 12] = [72 133 0 1 133 0 5 147 0 72 148 0]
	local14
	local15
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
		(= global345 outCode)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 129 140 128 315 123 315 196 0 196
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 79 54 61 183 74 195 75 196 80 171 92 153 86 134 86 129 94 152 94 159 100 128 122 59 118 0 113
					yourself:
				)
		)
		(proc0_1)
		(switch gPrevRoomNum
			(north
				(if (< (gEgo x:) 100)
					(gEgo posn: 10 67)
				else
					(gEgo posn: 220 82)
				)
				(self setScript: gStdWalkIn 1 14)
			)
			(west
				(gEgo
					posn: 26 (proc0_13 66 (proc0_14 72 (gEgo y:) 115) 129)
				)
				(self setScript: gStdWalkIn 1 14)
			)
			(east
				(gEgo posn: 231 (proc0_13 86 (gEgo y:) 130))
				(self setScript: gStdWalkIn 1 14)
			)
			(45 ; mapRoom
				(gEgo init:)
			)
			(else
				(gEgo posn: 150 120 init:)
			)
		)
		(water init:)
		(bell1 init:)
		(bell2 init:)
		(bell3 init:)
		(bell4 init:)
		(maid3 init:)
		(maid2 init:)
		(maid1 init:)
		(shell1 init:)
		(shell2 init:)
		(shell3 init:)
		(shell4 init:)
		(mary init:)
		(if ((gGoals at: 14) egoReturned:)
			((Flower new:) init: -6)
			(can init: stopUpd:)
		)
		(if global172
			(self setScript: converse)
		)
		(= global341 converse)
		(proc0_8)
	)

	(method (doit &tmp temp0)
		(water doit:)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl:) $0200)
				(gCurRoom newRoom: north)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(self setScript: gStdWalkOut 0 (gEgo edgeHit:))
			)
		)
	)

	(method (dispose)
		(DoAudio audRATE 11000)
		(DisposeScript 331)
		(DisposeScript 401)
		(= global341 0)
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
		x 118
		y 92
		view 74
		loop 2
		cycleSpeed 12
		illegalBits 0
	)

	(method (init)
		(super init: gestScr)
		(self setCycle: Fwd)
		(= global109 self)
	)

	(method (handleEvent)
		(return 0)
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
		(self stopUpd:)
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
	(properties)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (doVerb)
		(if (not local14)
			(= local14 1)
			(if (not (gCurRoom script:))
				(switch loop
					(1
						(if global157
							(DoAudio audPLAY 46)
						else
							(gSfx number: 46 loop: -1 play:)
						)
					)
					(0
						(if global157
							(DoAudio audRATE 22000)
							(DoAudio audPLAY 43)
						else
							(gSfx number: 43 loop: -1 play:)
						)
					)
				)
			)
			(self setScript: propScript)
		)
	)
)

(instance can of Prop
	(properties
		x 100
		y 92
		view 57
	)
)

(instance bell1 of mouseProp
	(properties
		x 65
		y 72
		view 74
		priority 5
		signal 16400
		cycleSpeed 6
	)

	(method (init)
		(super init:)
		(= global110 self)
	)
)

(instance bell2 of mouseProp
	(properties
		x 87
		y 73
		view 74
		cel 1
		priority 5
		signal 16400
		cycleSpeed 6
	)

	(method (init)
		(super init:)
		(= global111 self)
	)
)

(instance bell3 of mouseProp
	(properties
		x 108
		y 75
		view 74
		cel 2
		signal 16384
		cycleSpeed 6
	)

	(method (init)
		(super init:)
		(= global112 self)
	)
)

(instance bell4 of mouseProp
	(properties
		x 128
		y 77
		view 74
		cel 3
		signal 16384
		cycleSpeed 6
	)

	(method (init)
		(super init:)
		(= global113 self)
	)
)

(instance maid1 of mouseProp
	(properties
		x 42
		y 79
		view 74
		loop 5
		signal 20480
		cycleSpeed 12
	)

	(method (init)
		(super init:)
		(= global120 self)
	)
)

(instance maid2 of mouseProp
	(properties
		x 30
		y 85
		view 74
		loop 6
		signal 20480
		cycleSpeed 12
	)

	(method (init)
		(super init:)
		(= gMaid2 self)
	)
)

(instance maid3 of mouseProp
	(properties
		x 17
		y 91
		view 74
		loop 7
		signal 20480
		cycleSpeed 12
	)

	(method (init)
		(super init:)
		(= global122 self)
	)
)

(instance shell1 of mouseProp
	(properties
		x 60
		y 75
		view 74
		loop 1
		signal 16384
	)

	(method (init)
		(super init:)
		(= global133 self)
	)
)

(instance shell2 of mouseProp
	(properties
		x 82
		y 77
		view 74
		loop 1
		signal 16384
	)

	(method (init)
		(super init:)
		(= gShell2 self)
	)
)

(instance shell3 of mouseProp
	(properties
		x 106
		y 78
		view 74
		loop 1
		signal 16384
	)

	(method (init)
		(super init:)
		(= gShell3 self)
	)
)

(instance shell4 of mouseProp
	(properties
		x 128
		y 80
		view 74
		loop 1
		signal 16384
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
				(client startUpd: setCycle: End self)
			)
			(1
				(client setCycle: Beg self)
			)
			(2
				(if (not (gCurRoom script:))
					(if global157
						(DoAudio audSTOP)
						(DoAudio audRATE 11000)
					else
						(gSfx loop: 1 stop:)
					)
				)
				(client stopUpd: setScript: 0)
				(= local14 0)
			)
		)
	)
)

(instance water of Waters
	(properties
		priority 14
		view 161
	)

	(method (getLoop)
		(= x [local2 pos])
		(= y [local2 (++ pos)])
		(= cel [local2 (++ pos)])
	)

	(method (saveLoop)
		(= [local2 pos] cel)
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
				(if (-- local1)
					(gEgo say: (++ register) self)
				else
					(self dispose:)
				)
			)
			(2
				(if (-- local1)
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

	(method (changeState newState &tmp temp0)
		(if (not (= state newState))
			(proc0_2)
			(proc0_7 gEgo mary)
			(= temp0 (gGoals at: 14))
			(proc0_20)
			(cond
				(local15
					(switch local15
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
					(= local15 3)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self 55)
					(= global123 1)
					(= local15 2)
				)
				(else
					(self setScript: converse1 self 48)
					(temp0 egoTold: 1)
					(= global123 1)
					(= local15 1)
				)
			)
		else
			(DoSound sndMASTER_VOLUME global125)
			(if (!= gScore gPossibleScore)
				(if global172
					(gCurRoom newRoom: 45) ; mapRoom
				)
				(proc0_5)
				(proc0_3)
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
				(self setScript: attentionScript self)
			)
			(1
				(= local1 7)
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
				(= local1 5)
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
				(= local0 0)
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
		x 21
		y 98
		view 74
		loop 11
		priority 8
		signal 22545
		flowers 0
	)

	(method (init param1)
		(= flowers param1)
		(super init:)
		(cond
			(local0 0)
			(global157
				(DoAudio audPLAY 595)
			)
			(else
				(gSfx number: 595 play:)
			)
		)
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
			(Wait 0)
			(Wait 3)
			((self new:) x: (+ x 15) init: (-- flowers))
		)
		(= signal 2321)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 6 (gEgo x:) 253))
				(= temp1 35)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 73 (gEgo y:) 122))
			)
			(3
				(= temp0 (proc0_13 4 (gEgo x:) 252))
				(= temp1 131)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 50 (proc0_14 75 (gEgo y:) 115) 128))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

