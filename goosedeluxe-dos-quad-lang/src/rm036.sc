;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 36)
(include sci.sh)
(use Main)
(use MGRoom)
(use MGNarrator)
(use Head)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm036 0
)

(local
	local0
	local1 = 1
)

(instance rm036 of MGRoom
	(properties
		picture 36
		south 10
		vanishingX 145
		vanishingY 24
		edgeN -1
		edgeE 320
		edgeW -1
		edgeS 125
	)

	(method (init)
		(super init:)
		(= global305 outCode)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 142 139 142 119 138 109 105 109 101 110 89 110 85 115 106 115 114 121 111 155 0 155 0 0 258 0 258 155 142 155
					yourself:
				)
		)
		(= global112 plate)
		(tail init:)
		(spinningWheel init:)
		(proc0_1)
		(proc0_8 195 113 127 159)
		((View new:) view: 651 loop: 0 cel: 0 x: 104 y: 105 priority: 105 init:)
		((View new:) view: 651 loop: 0 cel: 1 x: 148 y: 105 priority: 105 init:)
		(if ((gGoals at: 8) egoReturned:)
			(plate init:)
		)
		(if ((gGoals at: 8) egoHas:)
			(Load rsVIEW 652)
		)
		(jack init:)
		(wife init:)
		(dog init:)
		(= global301 converse)
		(cond
			((== gPrevRoomNum 10)
				(gEgo posn: 128 120)
				(self setScript: gStdWalkIn)
			)
			((== gPrevRoomNum 45) ; mapRoom
				(gEgo init:)
				(if global172
					(gEgo posn: 135 119)
					(self setScript: converse)
				else
					(gGame handsOn:)
				)
			)
			(else
				(gEgo posn: 135 119 init:)
				(gGame handsOn:)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((> (gEgo y:) 125)
				(self setScript: gStdWalkOut 0 3)
			)
		)
	)

	(method (dispose)
		(DisposeScript 336)
		(super dispose: &rest)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local1
					(dog
						setScript: 0
						cycleSpeed: 5
						setLoop: 6
						setCel: 0
						setCycle: End
					)
				)
				(= ticks 12)
			)
			(1
				(herHead setCycle: End)
				(= cycles 6)
			)
			(2
				(hisHead setCycle: End self)
			)
			(3
				(hisHead setLoop: 2 cel: 0)
				(herHead setLoop: 4 cel: 0)
				(= cycles 2)
			)
			(4
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
				(hisHead setLoop: 1 setCel: 2 setCycle: Beg self)
			)
			(1
				(herHead setLoop: 3 setCel: 2 setCycle: Beg self)
			)
			(2
				(if local1
					(dog setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(3
				(if local1
					(dog cycleSpeed: 9 setLoop: 5 setCel: 0)
				)
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
				(client setCel: (- (Random 1 4) 1))
				(= state -1)
			)
		)
	)

	(method (dispose)
		(client setCel: 0)
		(super dispose:)
	)
)

(instance jack of Actor
	(properties
		x 148
		y 89
		priority 89
		view 651
		loop 8
	)

	(method (init)
		(super init:)
		(hisHead init: self (CelHigh (self view:) (self loop:) (self cel:)))
		(= global109 self)
		(= global120 hisHead)
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

(instance wife of Actor
	(properties
		x 103
		y 91
		priority 91
		view 651
		loop 9
	)

	(method (init)
		(super init:)
		(herHead init: self (CelHigh (self view:) (self loop:) (self cel:)))
		(= global110 self)
		(= global121 herHead)
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

(instance hisHead of Head
	(properties
		x 148
		y 76
		priority 76
		view 651
		loop 1
		cel 2
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

(instance herHead of Head
	(properties
		x 105
		y 75
		priority 75
		view 651
		loop 3
		cel 2
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

(instance dog of Prop
	(properties
		x 63
		y 112
		priority 112
		view 651
		loop 5
		cel 1
	)

	(method (init)
		(super init:)
		(self setScript: snore)
		(= global111 self)
	)
)

(instance snore of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(dog setCel: 0 setCycle: End self)
				(gSfx number: 25 loop: 1 play: self)
			)
			(2
				(= state 0)
			)
		)
	)

	(method (dispose)
		(gSfx client: 0)
		(super dispose: &rest)
	)
)

(instance spinningWheel of View
	(properties
		x 172
		y 116
		view 150
	)
)

(instance plate of View
	(properties
		x 128
		y 104
		z 16
		view 51
		loop 1
		cel 9
	)
)

(instance tail of Prop
	(properties
		x 82
		y 106
		priority 106
		view 651
		loop 7
	)

	(method (init)
		(super init:)
		(= global113 self)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not (= state newState))
			(gGame handsOff:)
			(= global516 gNarrator)
			(= gNarrator mgNarrator)
			(proc0_7 gEgo plate)
			(= temp0 (gGoals at: 8))
			(proc0_20)
			(cond
				(local0
					(switch local0
						(1
							(= global123 15)
							(self setScript: converse2 self)
						)
						(2
							(= global123 15)
							(self setScript: converse4 self)
						)
						(else
							(= local1 1)
							(self setScript: converse6 self)
						)
					)
				)
				((temp0 egoReturned:)
					(self setScript: converse7 self 0)
				)
				((temp0 egoHas:)
					(self setScript: converse5 self 0)
					(temp0 egoReturned: 1)
					(if (== global123 15)
						(= global123 0)
					)
					(= local0 3)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self 0)
					(= global123 15)
					(= local0 2)
				)
				(else
					(self setScript: converse1 self 0)
					(= global123 15)
					(temp0 egoTold: 1)
					(= local0 1)
				)
			)
		else
			(client setScript: 0)
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
			(if (not (dog script:))
				(dog view: 651 loop: 5 setScript: snore)
			)
			(proc0_5)
			(= gNarrator global516)
			(gGame handsOn:)
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
				(gMessager say: 16 1 2 register self)
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global131 (- (jack x:) 22))
				(= global132 (- (jack y:) 59))
				(= global128 107)
				(self setScript: (ScriptID 400) self) ; envisionScript
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
				(gMessager say: 16 1 3 register self)
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global131 (- (jack x:) 22))
				(= global132 (- (jack y:) 59))
				(= global128 107)
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
				(self setScript: attentionScript self)
			)
			(1
				(gMessager say: 16 1 4 register self)
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global131 (- (jack x:) 22))
				(= global132 (- (jack y:) 59))
				(= global128 107)
				(self setScript: (ScriptID 400) self) ; envisionScript
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
				(gMessager say: 16 1 5 register self)
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global131 (- (jack x:) 22))
				(= global132 (- (jack y:) 59))
				(= global128 107)
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
				(self setScript: attentionScript self)
			)
			(1
				(gLongSong fade:)
				(gMessager say: 16 1 6 register self)
			)
			(2
				(= local1 0)
				(self setScript: (ScriptID 336) self) ; rhymeScript
			)
			(3
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
				(gMessager say: 16 1 7 register self)
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
				(gMessager say: 16 1 8 register self)
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

(instance mgNarrator of MGNarrator
	(properties
		modeless 2
	)

	(method (startAudio param1)
		(switch global515
			(17
				(hisHead setCycle: ROsc 10000 0)
			)
			(14
				(herHead setCycle: ROsc 10000 0)
			)
			(23
				(hisHead setCycle: ROsc 10000 0)
				(herHead setCycle: ROsc 10000 0)
			)
			(9
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(17
				(hisHead cel: 0 setCycle: 0)
			)
			(14
				(herHead cel: 0 setCycle: 0)
			)
			(23
				(hisHead cel: 0 setCycle: 0)
				(herHead cel: 0 setCycle: 0)
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
				(= temp0 (proc0_13 106 (gEgo x:) 138))
				(= temp1 104)
			)
			(2
				(= temp0 148)
				(= temp1 (proc0_13 109 (gEgo y:) 122))
			)
			(3
				(= temp0 (proc0_13 110 (gEgo x:) 148))
				(= temp1 166)
			)
			(4
				(= temp0 81)
				(= temp1 (proc0_13 112 (gEgo y:) 121))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

