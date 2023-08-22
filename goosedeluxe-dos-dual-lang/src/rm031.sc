;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use MGRoom)
(use MGNarrator)
(use Head)
(use MoveProp)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm031 0
)

(local
	local0
	local1
	local2
	local3
	local4 = 21
)

(instance rm031 of MGRoom
	(properties
		picture 31
		north 24
		east 32
		west 30
		edgeN 44
		edgeS 255
	)

	(method (init)
		(= global305 outCode)
		(= local2 0)
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
					init: 0 79 54 61 183 74 195 75 196 80 171 92 153 86 133 86 133 94 152 94 159 100 128 122 59 118 0 113
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 257 76 215 74 172 70 133 63 90 53 90 10 256 10
					yourself:
				)
		)
		(proc0_1)
		((MoveProp new:) init: 161 0 99 146 13 yourself:)
		((MoveProp new:) init: 161 1 39 141 13 yourself:)
		((MoveProp new:) init: 161 2 26 154 13 yourself:)
		((MoveProp new:) init: 161 3 107 155 13 yourself:)
		(mary init:)
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
		(if ((gGoals at: 14) egoReturned:)
			(for ((= local3 0)) (< local3 5) ((++ local3))
				((Flower new:)
					init:
					x: (+ local4 (* local3 15))
					cel: 1
					setCycle: End
				)
			)
			(can init:)
		)
		(= global301 converse)
		(switch gPrevRoomNum
			(north
				(if (< (gEgo x:) 100)
					(gEgo posn: 50 67)
				else
					(gEgo posn: 220 82)
				)
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo
					posn: 26 (proc0_13 66 (proc0_14 72 (gEgo y:) 115) 129)
				)
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 231 (proc0_13 86 (gEgo y:) 117))
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
				(if global172
					(gEgo posn: 150 120)
					(self setScript: converse)
				else
					(gGame handsOn:)
				)
			)
			(else
				(gEgo posn: 150 120 init:)
				(gGame handsOn:)
			)
		)
		(proc0_8)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== (gEgo edgeHit:) EDGE_TOP)
				(self setScript: gStdClimbOut)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut 0 (gEgo edgeHit:))
			)
		)
	)

	(method (dispose)
		(DisposeScript 331)
		(= global301 0)
		(super dispose:)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo y:) 65)
					(if (< (gEgo x:) 113)
						(gEgo setMotion: PolyPath 76 51 self)
					else
						(gEgo setMotion: PolyPath 177 67 self)
					)
				else
					(= cycles 1)
				)
			)
			(1
				(proc0_7 gEgo mary)
				(= cycles 1)
			)
			(2
				(mary loop: 3 setCel: 0 setCycle: End self)
			)
			(3
				(= cycles 2)
			)
			(4
				(mary setLoop: 4 setCel: 0)
				(maryHead
					init: mary (CelHigh (mary view:) (mary loop:) (mary cel:))
				)
				(= cycles 2)
			)
			(5
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
				(maryHead dispose:)
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

(instance gestScr of Script ; UNUSED
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

(instance mary of Actor
	(properties
		x 118
		y 92
		view 74
		loop 2
		cycleSpeed 12
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
		(= global109 self)
	)

	(method (doVerb)
		(return
			(if (gCurRoom script:)
				0
			else
				(gCurRoom setScript: converse)
			)
		)
	)
)

(instance maryHead of Head
	(properties
		view 74
		loop 8
	)

	(method (init)
		(super init: &rest)
		(= global152 self)
	)

	(method (doit)
		(self setPri: (client priority:))
		(if (not script)
			(self setPri: (client priority:))
			(= x (client x:))
			(= y (client y:))
			(= z
				(-
					(+
						(client z:)
						(CelHigh (client view:) (client loop:) (client cel:))
					)
					1
				)
			)
			(self
				setLoop:
					(cond
						((< (gEgo x:) (- (client x:) 40)) 9)
						((> (gEgo x:) (+ (client x:) 40)) 10)
						(else 8)
					)
			)
		)
		(super doit:)
	)
)

(class mouseProp of Prop
	(properties)

	(method (init)
		(super init: &rest)
	)

	(method (doVerb)
		(if (not local1)
			(= local1 1)
			(if (not (gCurRoom script:))
				(switch loop
					(1
						(gSfx number: 46 loop: 1 play:)
					)
					(0
						(gSfx number: 43 loop: 1 play:)
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
		priority 5
		view 74
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
		priority 5
		view 74
		cel 1
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
		cycleSpeed 12
	)

	(method (init)
		(super init:)
		(= global121 self)
	)
)

(instance maid3 of mouseProp
	(properties
		x 17
		y 91
		view 74
		loop 7
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
				(if (not (gCurRoom script:))
					(gSfx loop: 1 stop:)
				)
				(client setScript: 0)
				(= local1 0)
			)
		)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not (= state newState))
			(gGame handsOff:)
			(= global516 gNarrator)
			(= gNarrator mgNarrator)
			(= temp0 (gGoals at: 14))
			(proc0_20)
			(cond
				(local2
					(switch local2
						(1
							(self setScript: converse2 self 0)
						)
						(2
							(self setScript: converse4 self 0)
						)
						(else
							(self setScript: converse6 self 0)
						)
					)
				)
				((temp0 egoReturned:)
					(self setScript: converse7 self 0)
				)
				((temp0 egoHas:)
					(self setScript: converse5 self 0)
					(temp0 egoReturned: 1)
					(if (== global123 1)
						(= global123 0)
					)
					(= local2 3)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self 0)
					(= global123 1)
					(= local2 2)
				)
				(else
					(self setScript: converse1 self 0)
					(temp0 egoTold: 1)
					(= global123 1)
					(= local2 1)
				)
			)
		else
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
			(proc0_5)
			(= gNarrator global516)
			(gGame handsOn:)
			(self dispose:)
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
				(gMessager say: 14 1 2 0 self) ; "Hi! What's your name?"
			)
			(2
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
				(gMessager say: 14 1 3 0 self) ; "Are you still here? Please find my watering can. My little plants are so thirsty."
			)
			(2
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
				(gMessager say: 14 1 4 0 self) ; "Hello, again. Do you have my watering can?"
			)
			(2
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

(instance converse4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
			)
			(1
				(gMessager say: 14 1 5 0 self) ; "Hurry up now! I need my watering can."
			)
			(2
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

(instance converse5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
			)
			(1
				(gLongSong fade:)
				(gMessager say: 14 1 6 0 self) ; "I found your watering can, Mary."
			)
			(2
				(self setScript: (ScriptID 331) self) ; rhymeScript
			)
			(3
				(self setScript: atEaseScript self)
			)
			(4
				(= local3 0)
				(self setScript: poppingFlowers self)
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
				(gMessager say: 14 1 7 0 self) ; "Thank you for finding my watering can. I don't think I would have ever found it without you!"
			)
			(2
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
				(gMessager say: 14 1 8 0 self) ; "Hi."
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance poppingFlowers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((Flower new:) init: x: (+ local4 (* local3 15)) setCycle: End)
				(= cycles 1)
			)
			(1
				(gSfx number: 595 play:)
				(= ticks 15)
			)
			(2
				(if (< local3 4)
					(= state -1)
					(++ local3)
					(= cycles 1)
				else
					(self dispose:)
				)
			)
		)
	)
)

(class Flower of Prop
	(properties
		x 21
		y 98
		priority 8
		view 74
		loop 11
		cycleSpeed 8
		flowers 0
	)
)

(instance mgNarrator of MGNarrator
	(properties
		modeless 2
	)

	(method (startAudio param1)
		(switch global515
			(15
				(maryHead setCycle: ROsc 10000 0)
			)
			(9
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(15
				(maryHead cel: 0 setCycle: 0)
			)
			(9
				(self doEgoQuiet:)
			)
		)
		(super dispose:)
	)
)

(instance outCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 6 (gEgo x:) 82))
				(= temp1 44)
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

