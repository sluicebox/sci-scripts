;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use MGRoom)
(use MGNarrator)
(use MoveProp)
(use ROsc)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm005 0
)

(local
	local0
	local1
)

(instance rm005 of MGRoom
	(properties
		picture 5
		east 6
		west 4
		edgeN -1
		edgeS 255
	)

	(method (init)
		(super init:)
		(Load rsVIEW 70)
		(= local0 0)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 309 0 310 130 233 131 245 153 315 157 261 161 312 194 0 196 0 137 38 137 15 152 217 152 211 140 190 137 158 127 149 117 128 117 120 124 101 124 88 115 0 117
					yourself:
				)
		)
		(= global111 ladderFalling)
		(if ((gGoals at: 16) egoHas:)
			(Load rsSCRIPT 305)
		)
		(humpty init:)
		((MoveProp new:) init: 132 0 203 108 5 yourself:)
		((MoveProp new:) init: 132 1 118 88 5 yourself:)
		((MoveProp new:) init: 132 2 112 95 5 yourself:)
		((MoveProp new:) init: 132 3 23 87 5 yourself:)
		((MoveProp new:) init: 132 4 236 118 5 yourself:)
		(= global301 converse)
		(switch gPrevRoomNum
			(west
				(= global305 outCode1)
				(self edgeE: 320)
				(gEgo posn: 38 130)
				(self setScript: gStdWalkIn)
			)
			(east
				(= global305 outCode2)
				(self edgeW: -1)
				(= local1 1)
				(= global301 0)
				(gEgo posn: 244 138)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(if global172
					(gEgo posn: 150 120 init:)
					(self setScript: converse)
				else
					(gEgo posn: global173 global174 init:)
					(if (< global173 225)
						(= global305 outCode1)
						(self edgeE: 320)
					else
						(= global305 outCode2)
						(self edgeW: -1)
						(= local1 1)
						(= global301 0)
					)
					(gGame handsOn:)
				)
			)
			(else
				(= global305 outCode1)
				(self edgeE: 320)
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
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)

	(method (dispose)
		(DisposeScript 305)
		(super dispose:)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(humpty setScript: faceEgoScript setCycle: 0 cel: 0)
				(proc0_7 gEgo humpty)
				(if
					(and
						global129
						(<= global130 47)
						(< (global129 nsTop:) (humpty nsBottom:))
						(or
							(<
								(humpty nsLeft:)
								(global129 nsLeft:)
								(humpty nsRight:)
							)
							(<
								(humpty nsLeft:)
								(global129 nsRight:)
								(humpty nsRight:)
							)
						)
					)
					(if (< (gEgo x:) (global129 x:))
						(global129
							setMotion:
								MoveTo
								(+ (humpty x:) 20)
								(+ (global129 y:) 10)
								self
						)
					else
						(global129
							setMotion:
								MoveTo
								(- (humpty x:) 20)
								(+ (global129 y:) 10)
								self
						)
					)
					(= register 1)
				else
					(= cycles 1)
					(= register 0)
				)
			)
			(1
				(if register
					(proc0_7 global129 humpty)
				)
				(= cycles 2)
			)
			(2
				(humpty setCycle: 0)
				(= cycles 2)
			)
			(3
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
				(humpty setScript: 0 setLoop: 0 setCycle: Fwd cycleSpeed: 10)
				(= cycles 2)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance faceEgoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					setCel: 0
					setLoop:
						(cond
							((< (gEgo x:) (- (client x:) 20)) 2)
							((> (gEgo x:) (+ (client x:) 20)) 4)
							(else 3)
						)
				)
				(= ticks 20)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance gestureScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					setLoop:
						(cond
							((< (gEgo x:) (- (client x:) 20)) 2)
							((> (gEgo x:) (+ (client x:) 20)) 4)
							(else 3)
						)
				)
				(if (== 2 (Random 1 3))
					(client setCel: (Random 0 (- (NumCels client) 1)))
				)
				(= ticks 20)
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance humpty of Actor
	(properties
		x 108
		y 116
		view 70
		yStep 1
		cycleSpeed 10
		illegalBits 0
		xStep 1
	)

	(method (init)
		(if ((gGoals at: 16) egoReturned:)
			(= view 920)
			(= y 101)
			(super init:)
			(ladder init:)
		else
			(super init: &rest)
			(self setCycle: Fwd)
		)
		(self setCycle: Fwd)
		(= global109 self)
	)

	(method (doVerb)
		(return
			(if (gCurRoom script:)
				0
			else
				(gCurRoom setScript: global301)
			)
		)
	)
)

(instance ladder of View
	(properties
		x 108
		y 115
		view 59
		loop 1
	)
)

(instance ladderFalling of Prop
	(properties
		x 108
		y 115
		view 59
		loop 1
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (not (= state newState))
			(gGame handsOff:)
			(= global516 gNarrator)
			(= gNarrator mgNarrator)
			(= temp0 (gGoals at: 16))
			(proc0_20)
			(cond
				(local1
					(gEgo loop: 2)
					(self setScript: converse7 self 1)
				)
				(local0
					(switch local0
						(1
							(self setScript: converse2 self 1)
						)
						(2
							(self setScript: converse4 self 1)
						)
						(else
							(self setScript: converse7 self 1)
						)
					)
				)
				((temp0 egoReturned:)
					(humpty setLoop: 3 1 setCel: 4 setCycle: 0 cycleSpeed: 4)
					(self setScript: converse6 self 1)
				)
				((temp0 egoHas:)
					(self setScript: converse5 self 1)
					(if (== global123 6)
						(= global123 0)
					)
					(= local0 3)
				)
				((temp0 egoTold:)
					(= global123 6)
					(self setScript: converse3 self 1)
					(= local0 2)
				)
				(else
					(self setScript: converse1 self 1)
					(temp0 egoTold: 1)
					(= global123 6)
					(= local0 1)
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
				(gMessager say: 4 1 2 0 self) ; "What are you doing, Mr. Egg?"
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global131 (+ (humpty x:) 13))
				(= global132 (- (humpty y:) 54))
				(= global128 115)
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
				(gMessager say: 4 1 3 0 self) ; "I don't see any ladders around here. Perhaps you should look somewhere else."
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global131 (+ (humpty x:) 13))
				(= global132 (- (humpty y:) 54))
				(= global128 115)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(4
				(= global123 6)
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
				(gMessager say: 4 1 4 0 self) ; "Hi, Mr. Dumpty."
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global131 (+ (humpty x:) 13))
				(= global132 (- (humpty y:) 54))
				(= global128 115)
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
				(gMessager say: 4 1 5 0 self) ; "Go ask around. Maybe someone has a ladder to give you. Without it, I'll NEVER get to sit on that wall!"
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global131 (+ (humpty x:) 13))
				(= global132 (- (humpty y:) 54))
				(= global128 115)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(4
				(= global123 6)
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
				(gMessager say: 4 1 6 0 self) ; "Here's a ladder, Mr. Dumpty!"
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global110 ladder)
				(self setScript: (ScriptID 305) self) ; rhymeScript
			)
			(4
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
				(gGame handsOff:)
				(proc0_7 gEgo humpty)
				(= cycles 1)
			)
			(1
				(gMessager say: 4 1 7 0 self) ; "How are you feeling, Mr. Dumpty?"
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
			(10
				(humpty setCycle: ROsc 10000 0)
			)
			(9
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(10
				(humpty cel: 0 setCycle: 0)
			)
			(9
				(self doEgoQuiet:)
			)
		)
		(super dispose:)
	)
)

(instance outCode1 of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 11 (gEgo x:) 156))
				(= temp1 104)
			)
			(2
				(= temp0 219)
				(= temp1 (proc0_13 133 (gEgo y:) 152))
			)
			(3
				(= temp0 (proc0_13 15 (gEgo x:) 217))
				(= temp1 155)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 118 (gEgo y:) 138))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

(instance outCode2 of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(switch gTheCursor
			(5
				(= temp0 (proc0_13 230 (gEgo x:) 256))
				(= temp1 127)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 132 (gEgo y:) 155))
			)
			(3
				(= temp0 (proc0_13 239 (gEgo x:) 259))
				(= temp1 158)
			)
			(4
				(= temp0 228)
				(= temp1 (proc0_13 131 (gEgo y:) 154))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

