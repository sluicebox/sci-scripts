;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use MGRoom)
(use MGNarrator)
(use Head)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Actor)
(use System)

(public
	rm013 0
)

(local
	local0
)

(instance rm013 of MGRoom
	(properties
		picture 13
		north 6
		east 14
		south 20
		edgeN 76
		edgeW -1
	)

	(method (init)
		(= global305 outCode)
		(super init:)
		(gEgo init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 74 0 74 68 74 78 16 91 9 119 40 118 78 124 82 140 50 155 52 191 315 191 315 111 170 122 153 126 141 121 144 115 157 104 165 100 170 97 170 92 156 93 139 101 126 118 109 115 108 99 105 96 122 81 129 18 129 0
					yourself:
				)
		)
		(if (not ((gGoals at: 4) egoReturned:))
			(= global301 converse)
			(mary init:)
		)
		(switch gPrevRoomNum
			(39
				(gEgo posn: 145 105 setLoop: 1 cel: 0)
				(gGame handsOn:)
			)
			(north
				(gEgo posn: (proc0_13 100 (gEgo x:) 104) 76)
				(self setScript: gStdClimbIn)
			)
			(east
				(gEgo posn: 231 (proc0_13 114 (gEgo y:) (gCurRoom edgeS:)))
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo posn: (proc0_13 102 (gEgo x:) (gCurRoom edgeE:)) 139)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(if global172
					(gEgo posn: 124 138)
					(global129 posn: (- (gEgo x:) 7) (+ (gEgo y:) 5))
					(self setScript: converse)
				else
					(gEgo posn: global173 global174)
					(gGame handsOn:)
				)
			)
			(else
				(gEgo posn: 124 138)
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
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdClimbOut)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
			((gEgo inRect: 155 40 177 101)
				(gCurRoom newRoom: 39)
			)
		)
	)

	(method (dispose)
		(DisposeScript 313)
		(if ((gGoals at: 4) egoReturned:)
			(DisposeScript 604)
		)
		(super dispose: &rest)
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
				(mary cel: 0)
				(maryHead
					init: mary (CelHigh (mary view:) (mary loop:) (mary cel:))
				)
				(proc0_7 gEgo mary)
				(maryHead
					setLoop:
						(cond
							((< (gEgo y:) (mary y:)) 2)
							((> (gEgo y:) (+ (mary y:) 10)) 1)
							(else 3)
						)
						1
				)
				(= cycles 1)
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
				(maryHead dispose:)
				(mary setLoop: 0 1 cel: 1)
				(= cycles 1)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance mary of Actor
	(properties
		x 65
		y 143
		view 69
		cel 1
		yStep 1
		cycleSpeed 9
		xStep 1
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors: 1)
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
		view 69
		loop 2
	)

	(method (init)
		(super init: &rest)
		(= global110 self)
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
						((< (gEgo y:) (client y:)) 2)
						((> (gEgo y:) (+ (client y:) 10)) 1)
						(else 3)
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
			(gGame handsOff:)
			(= global516 gNarrator)
			(= gNarrator mgNarrator)
			(= temp0 (gGoals at: 4))
			(proc0_20)
			(cond
				(local0
					(switch local0
						(1
							(self setScript: converse2 self 1)
						)
						(else
							(self setScript: converse4 self 1)
						)
					)
				)
				((temp0 egoReturned:)
					(self setScript: converse6 self 1)
				)
				((temp0 egoHas:)
					(temp0 egoReturned: 1)
					(self setScript: converse5 self 1)
					(if (== global123 9)
						(= global123 0)
					)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self 1)
					(= global123 9)
					(= local0 2)
				)
				(else
					(self setScript: converse1 self 1)
					(temp0 egoTold: 1)
					(= global123 9)
					(= local0 1)
				)
			)
		else
			(client setScript: 0)
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
			)
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
				(gMessager say: 8 1 2 0 self) ; "Hi. What's your name?"
			)
			(2
				(= global131 (+ (mary x:) 13))
				(= global132 (- (mary y:) 52))
				(= global128 103)
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
				(gMessager say: 8 1 3 0 self) ; "My little lamb's not here. Maybe Little Bo Peep has him. Go check with her."
			)
			(2
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
				(gMessager say: 8 1 4 0 self) ; "Have you brought back my little lamb yet?"
			)
			(2
				(= global131 (+ (mary x:) 13))
				(= global132 (- (mary y:) 52))
				(= global128 103)
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
				(gMessager say: 8 1 5 0 self) ; "My lamb might have wandered over to the shoehouse. He just loves children, you know. Try over there."
			)
			(2
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

(instance converse5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
			)
			(1
				(gLongSong fade:)
				(gMessager say: 8 1 6 0 self) ; "There's my little lamb! Oh, lambie, dear, I missed you so much! Thank you for finding him!"
			)
			(2
				(self setScript: (ScriptID 313) self) ; rhymeScript
			)
			(3
				(= global301 0)
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
				(if (Random 0 1)
					(gMessager say: 1 1 33 (Random 1 29) self 0)
				else
					(gMessager say: 1 1 34 (Random 1 21) self 0)
				)
			)
			(1
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
				(= temp0 (proc0_13 100 (gEgo x:) 104))
				(= temp1 76)
			)
			(2
				(= temp0 270)
				(= temp1 (proc0_13 111 (gEgo y:) 152))
			)
			(3
				(= temp0 (proc0_13 57 (gEgo x:) 257))
				(= temp1 158)
			)
			(4
				(= temp0 7)
				(= temp1 (proc0_13 94 (gEgo y:) 118))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 2)
	)
)

