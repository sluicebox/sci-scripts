;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
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
	rm001 0
)

(local
	local0
	local1
)

(instance rm001 of MGRoom
	(properties
		picture 1
		east 2
		south 8
		edgeN -1
		edgeW -1
	)

	(method (init)
		(super init:)
		(= global305 outCode)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 74 155 73 173 0 183 0 0 258 0 315 66 258 65 207 58 151 43 133 50 102 50 88 46 57 55 35 96 27 110 27 130 75 154
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 217 141 177 134 177 127 258 100 281 115 290 174 201 176 201 155
					yourself:
				)
		)
		(gCurRoom
			addObstacle:
				(= local1
					((Polygon new:)
						type: PBarredAccess
						init: 147 97 155 105 150 120 98 120 93 105 101 97
						yourself:
					)
				)
		)
		(Load rsVIEW 67)
		(Load rsVIEW 153)
		(proc0_1)
		(jackBody init:)
		(jackHead
			init:
				jackBody
				(CelHigh (jackBody view:) (jackBody loop:) (jackBody cel:))
		)
		(jillBody init:)
		(jillHead
			init:
				jillBody
				(CelHigh (jillBody view:) (jillBody loop:) (jillBody cel:))
		)
		(if ((gGoals at: 13) egoReturned:)
			(pail init:)
		)
		(= global301 converse)
		(switch gPrevRoomNum
			(east
				(gEgo posn: 231 (proc0_13 64 (gEgo y:) 102))
				(self setScript: gStdWalkIn)
			)
			(south
				(gEgo posn: (proc0_13 81 (gEgo x:) 175) 139)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(if global172
					(gEgo posn: 141 131 init:)
					(self setScript: converse)
				else
					(gEgo posn: global173 global174 init:)
					(gGame handsOn:)
				)
				(gEgo init:)
			)
			(else
				(gEgo posn: 141 131 init:)
			)
		)
		(proc0_8)
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

	(method (dispose)
		(DisposeScript 301)
		(super dispose: &rest)
	)
)

(instance pail of Actor
	(properties
		x 134
		y 115
		view 56
		signal 26625
	)
)

(instance jackBody of Actor
	(properties
		x 111
		y 111
		view 67
		cycleSpeed 3
		illegalBits 0
		moveSpeed 3
	)

	(method (init)
		(super init: &rest)
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

(instance jackHead of Head
	(properties
		view 67
		loop 2
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
						((< (gEgo x:) (- (client x:) 20)) 3)
						((> (gEgo x:) (+ (client x:) 20)) 4)
						(else 2)
					)
			)
		)
		(super doit:)
	)
)

(instance jillBody of Actor
	(properties
		x 134
		y 111
		view 67
		loop 1
		cycleSpeed 3
	)

	(method (init)
		(= global110 self)
		(super init: &rest)
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

(instance jillHead of Head
	(properties
		view 67
		loop 5
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
			(gGame handsOff:)
			(= global516 gNarrator)
			(= gNarrator mgNarrator)
			(= temp0 (gGoals at: 13))
			(proc0_7 gEgo jackBody)
			(cond
				(local0
					(switch local0
						(1
							(= global123 8)
							(self setScript: converse2 self 1)
						)
						(2
							(= global123 8)
							(self setScript: converse4 self 1)
						)
						(else
							(self setScript: converse6 self 1)
						)
					)
				)
				((temp0 egoReturned:)
					(self setScript: converse7 self 1)
				)
				((temp0 egoHas:)
					(self setScript: converse5 self 1)
					(temp0 egoReturned: 1)
					(if (== global123 8)
						(= global123 1)
					)
					(= local0 3)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self 1)
					(= global123 8)
					(= local0 2)
				)
				(else
					(self setScript: converse1 self 1)
					(temp0 egoTold: 1)
					(= local0 1)
					(= global123 8)
				)
			)
		else
			(client setScript: 0)
			(if global172
				(gCurRoom newRoom: 45) ; mapRoom
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
				(jillBody setScript: 0)
				(jackBody setScript: 0)
				(= gJillBody 0)
				(= ticks 1)
			)
			(2
				(gMessager say: 2 1 2 register self)
			)
			(3
				(jackBody cel: 1)
				(gMessager say: 2 1 2 (++ register) self)
			)
			(4
				(jillBody cel: (jackBody cel:))
				(gMessager say: 2 1 2 (++ register) self)
				(= gJillBody jillBody)
			)
			(5
				(jackBody cel: 2)
				(jillBody cel: (jackBody cel:))
				(gMessager say: 2 1 2 (++ register) self)
				(= gJillBody 0)
			)
			(6
				(jackBody cel: 0)
				(gMessager say: 2 1 2 (++ register) self)
			)
			(7
				(jillBody cel: (jackBody cel:))
				(gMessager say: 2 1 2 (++ register) self)
			)
			(8
				(= gJillBody jillBody)
				(jackBody cel: 2)
				(jillBody cel: (jackBody cel:))
				(gMessager say: 2 1 2 (++ register) self)
			)
			(9
				(= gJillBody 0)
				(gMessager say: 2 1 2 (++ register) self)
			)
			(10
				(= gJillBody jillBody)
				(jackBody cel: 0)
				(jillBody cel: (jackBody cel:))
				(gMessager say: 2 1 2 (++ register) self)
			)
			(11
				(= gJillBody 0)
				(= global131 (+ (jackBody x:) 13))
				(= global132 (- (jackBody y:) 54))
				(= global128 112)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(12
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
				(jackBody cel: 1)
				(gMessager say: 2 1 3 register self)
			)
			(2
				(jillBody cel: (jackBody cel:))
				(gMessager say: 2 1 3 (++ register) self)
			)
			(3
				(= global131 (+ (jackBody x:) 13))
				(= global132 (- (jackBody y:) 54))
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
				(self setScript: attentionScript self)
			)
			(1
				(gMessager say: 2 1 4 register self)
			)
			(2
				(jackBody cel: 1)
				(gMessager say: 2 1 4 (++ register) self)
			)
			(3
				(gMessager say: 2 1 4 (++ register) self)
			)
			(4
				(jillBody cel: (jackBody cel:))
				(gMessager say: 2 1 4 (++ register) self)
			)
			(5
				(jackBody cel: 0)
				(gMessager say: 2 1 4 (++ register) self)
			)
			(6
				(jillBody cel: (jackBody cel:))
				(gMessager say: 2 1 4 (++ register) self)
			)
			(7
				(= global131 (+ (jackBody x:) 13))
				(= global132 (- (jackBody y:) 54))
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
				(self setScript: attentionScript self)
			)
			(1
				(= cycles 1)
			)
			(2
				(jackBody cel: 3)
				(gMessager say: 2 1 5 register self)
			)
			(3
				(jillBody cel: (jackBody cel:))
				(gMessager say: 2 1 5 (++ register) self)
			)
			(4
				(= global131 (+ (jackBody x:) 13))
				(= global132 (- (jackBody y:) 54))
				(= global128 112)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(5
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
				(gMessager say: 2 1 6 register self)
			)
			(2
				(jackBody cel: 2)
				(jillBody cel: (jackBody cel:))
				(= gJillBody jillBody)
				(gMessager say: 2 1 6 (++ register) self)
			)
			(3
				(jackBody cel: 1)
				(= gJillBody 0)
				(gMessager say: 2 1 6 (++ register) self)
			)
			(4
				(jillBody cel: (jackBody cel:))
				(gMessager say: 2 1 6 (++ register) self)
			)
			(5
				(= global111 jackHead)
				(= global112 jillHead)
				(gLongSong stop:)
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
				(self setScript: attentionScript self)
			)
			(1
				(gMessager say: 2 1 7 register self)
			)
			(2
				(jackBody cel: 1)
				(gMessager say: 2 1 7 (++ register) self)
			)
			(3
				(jillBody cel: 3)
				(gMessager say: 2 1 7 (++ register) self)
			)
			(4
				(jackBody cel: (jillBody cel:))
				(gMessager say: 2 1 7 (++ register) self)
			)
			(5
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
				(gMessager say: 2 1 8 register self)
			)
			(2
				(jackBody cel: 1)
				(gMessager say: 2 1 8 (++ register) self)
			)
			(3
				(jillBody cel: 1)
				(gMessager say: 2 1 8 (++ register) self)
			)
			(4
				(jackBody cel: 0)
				(jillBody cel: (jackBody cel:))
				(gMessager say: 2 1 8 (++ register) self)
			)
			(5
				(gMessager say: 2 1 8 (++ register) self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo y:) 126)
					(gEgo
						setMotion:
							PolyPath
							(proc0_13 100 (gEgo x:) 150)
							126
							self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(proc0_7 gEgo jackBody)
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
			(4
				(jackHead setCycle: ROsc 10000 0)
			)
			(5
				(jillHead setCycle: ROsc 10000 0)
			)
			(6
				(jackHead setCycle: ROsc 10000 0)
				(jillHead setCycle: ROsc 10000 0)
			)
			(3
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(4
				(jackHead cel: 0 setCycle: 0)
			)
			(5
				(jillHead cel: 0 setCycle: 0)
			)
			(6
				(jackHead cel: 0 setCycle: 0)
				(jillHead cel: 0 setCycle: 0)
			)
			(3
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
				(= temp0 (proc0_13 7 (gEgo x:) 237))
				(= temp1 37)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 65 (gEgo y:) 114))
			)
			(3
				(= temp0 (proc0_13 76 (gEgo x:) 180))
				(= temp1 178)
			)
			(4
				(= temp0 3)
				(= temp1 (proc0_13 107 (gEgo y:) 128))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

