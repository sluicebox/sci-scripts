;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
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
	rm003 0
)

(local
	local0
	local1
	local2
)

(instance rm003 of MGRoom
	(properties
		picture 3
		east 4
		west 2
		edgeN -1
		edgeW 5
		edgeS 255
	)

	(method (init)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 33 151 258 151 258 120 163 120 163 126 123 126 123 120 110 120 97 128 70 139 46 142
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: -10 150 10 150 15 143 -10 127
					yourself:
				)
		)
		(Load rsVIEW 85)
		(= local1 (gGoals at: 7))
		(proc0_1)
		(tommy init:)
		(tommyHead
			init: tommy (CelHigh (tommy view:) (tommy loop:) (tommy cel:))
			doit:
		)
		((MoveProp new:) init: 122 0 27 102 10 setPri: 85 yourself:)
		((MoveProp new:) init: 122 1 137 87 10 setPri: 85 yourself:)
		((MoveProp new:) init: 122 2 147 95 9 setPri: 85 yourself:)
		((MoveProp new:) init: 122 3 221 86 6 setPri: 85 yourself:)
		((MoveProp new:) init: 122 4 23 119 10 setPri: 85 yourself:)
		(soapBox init:)
		(= global301 converse)
		(switch gPrevRoomNum
			(west
				(= global305 outCode1)
				(self edgeE: 320)
				(gEgo posn: 12 143)
				(self setScript: gStdWalkIn)
				(= global301 0)
				(= local2 1)
			)
			(east
				(= global305 outCode2)
				(self edgeW: -1)
				(gEgo posn: 221 129)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(if global172
					(gEgo posn: 201 130 init:)
					(self setScript: converse)
				else
					(if (>= global173 30)
						(= global305 outCode2)
						(self edgeW: -1)
					else
						(= global305 outCode1)
						(self edgeE: 320)
						(= global301 0)
					)
					(gEgo posn: global173 global174 init:)
					(gGame handsOn:)
				)
			)
			(else
				(= global305 outCode2)
				(self edgeW: -1)
				(gEgo posn: 201 130 init:)
			)
		)
		(proc0_8)
	)

	(method (dispose)
		(DisposeScript 303)
		(super dispose: &rest)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((< (gEgo y:) 50)
				(gStdWalkOut register: 2)
				(self setScript: gStdWalkOut)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)
)

(instance sGesture of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 5 15))
			)
			(1
				(= register (- (Random 1 (NumCels tommy)) 1))
				(if (!= register (tommy cel:))
					(tommy
						setCycle:
							CT
							register
							(if (< (tommy cel:) register) 1 else -1)
							self
					)
				else
					(= cycles 1)
				)
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance soapBox of View
	(properties
		x 143
		y 119
		view 85
		cel 1
	)

	(method (init)
		(self setPri: 2)
		(super init:)
	)
)

(instance tommy of Actor
	(properties)

	(method (init)
		(self
			view: 85
			setLoop: 0 1
			cel: (if (local1 egoReturned:) 8 else 0)
			setPri: 90
			posn: 145 115 9
			cycleSpeed: 3
			ignoreControl: 1
			ignoreActors: 1
			illegalBits: 0
		)
		(= global109 self)
		(super init:)
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

(instance tommyHead of Head
	(properties
		view 85
		loop 2
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
				(gCurRoom setScript: global301)
			)
		)
	)

	(method (doit &tmp temp0)
		(self setPri: (client priority:))
		(= x (client x:))
		(= y (+ (client y:) 1))
		(= z (- (CelHigh (client view:) (client loop:) (client cel:)) 1))
		(if (not script)
			(= temp0 (- (gEgo y:) (client y:)))
			(self
				setLoop:
					(cond
						((< (gEgo x:) (- (client x:) temp0)) 2)
						((> (gEgo x:) (+ (client x:) temp0)) 3)
						(else 1)
					)
					1
			)
		)
		(super doit:)
	)
)

(instance sAttention of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tommy cel: 0 setLoop: (if (local1 egoReturned:) 13 else 5) 1)
				(self dispose:)
			)
		)
	)
)

(instance sAtEase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tommy setLoop: 0 1 cel: (if (local1 egoReturned:) 8 else 0))
				(= cycles 1)
			)
			(1
				(if (local1 egoReturned:)
					(= cycles 1)
				else
					(= global131 (+ (tommy x:) 13))
					(= global132 (- (tommy y:) 64))
					(= global128 106)
					(self setScript: (ScriptID 400) self) ; envisionScript
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState)
		(if (not (= state newState))
			(gGame handsOff:)
			(= global516 gNarrator)
			(= gNarrator mgNarrator)
			(proc0_7 gEgo tommy)
			(proc0_20)
			(cond
				(local2
					(self setScript: converse8 self 1)
				)
				(local0
					(switch local0
						(1
							(self setScript: converse2 self)
						)
						(2
							(self setScript: converse4 self)
						)
						(else
							(self setScript: converse6 self)
						)
					)
				)
				((local1 egoReturned:)
					(self setScript: converse7 self)
				)
				((local1 egoHas:)
					(self setScript: converse5 self)
					(local1 egoReturned: 1)
					(if (== global123 7)
						(= global123 0)
					)
					(= local0 3)
				)
				((local1 egoTold:)
					(= global123 7)
					(self setScript: converse3 self)
					(= local0 2)
				)
				(else
					(self setScript: converse1 self)
					(= global123 7)
					(local1 egoTold: 1)
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
				(self setScript: sAttention self)
			)
			(1
				(gMessager say: 3 1 2 0 self) ; "Moon, June, loon, spoon, dune..."
			)
			(2
				(self setScript: sAtEase self)
			)
			(3
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
				(self setScript: sAttention self)
			)
			(1
				(gMessager say: 3 1 3 0 self) ; "My breadknife's not around here, I can tell you that. Maybe Old King Cole has it. Why don't you check with him?"
			)
			(2
				(self setScript: sAtEase self)
			)
			(3
				(= global123 7)
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
				(self setScript: sAttention self)
			)
			(1
				(gMessager say: 3 1 4 0 self) ; "Match, catch, latch, patch..."
			)
			(2
				(self setScript: sAtEase self)
			)
			(3
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
				(self setScript: sAttention self)
			)
			(1
				(gMessager say: 3 1 5 0 self) ; "You won't find my breadknife standing around here. Go ask Jack Sprat and his wife. Maybe they've seen it."
			)
			(2
				(self setScript: sAtEase self)
			)
			(3
				(= global123 7)
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
				(self setScript: sAttention self)
			)
			(1
				(proc0_7 gEgo tommy)
				(gLongSong fade:)
				(gMessager say: 3 1 6 0 self) ; "Laddie, caddy, baddy, raddy. No, that won't do!"
			)
			(2
				(self setScript: (ScriptID 303) self) ; rhymeScript
			)
			(3
				(self setScript: sAtEase self)
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
				(self setScript: sAttention self)
			)
			(1
				(gMessager say: 3 1 7 0 self) ; "Hey, thanks for finding my breadknife. I couldn't have sung for my supper without it."
			)
			(2
				(self setScript: sAtEase self)
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
				(self setScript: sAttention self)
			)
			(1
				(gMessager say: 3 1 8 0 self) ; "Lamb, ham, scram, ummm..."
			)
			(2
				(self setScript: sAtEase self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance converse8 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo loop: 2)
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
			(8
				(tommyHead setCycle: ROsc 10000 0)
			)
			(9
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(8
				(tommyHead cel: 0 setCycle: 0)
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
				(= temp0 (proc0_13 3 (gEgo x:) 28))
				(= temp1 124)
			)
			(2
				(= temp0 29)
				(= temp1 (proc0_13 147 (gEgo y:) 155))
			)
			(3
				(= temp0 (proc0_13 2 (gEgo x:) 18))
				(= temp1 155)
			)
			(4
				(= temp0 -3)
				(= temp1 (proc0_13 130 (gEgo y:) 152))
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
				(= temp0 (proc0_13 108 (gEgo x:) 219))
				(= temp1 112)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 121 (gEgo y:) 151))
			)
			(3
				(= temp0 (proc0_13 43 (gEgo x:) 257))
				(= temp1 157)
			)
			(4
				(= temp0 3)
				(= temp1 (proc0_13 107 (gEgo y:) 128))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

