;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
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
	rm023 0
)

(local
	local0
	[local1 2]
	local3
)

(instance rm023 of MGRoom
	(properties
		picture 23
		north 16
		east 24
		south 30
		west 22
		edgeN 48
	)

	(method (init)
		(if (and ((gGoals at: 2) egoReturned:) (not global172))
			(= local0 1)
			(Load rsSCRIPT 423)
		else
			(= local0 0)
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 315 140 200 140 200 103 220 61 164 51 136 48 223 0 315 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 64 98 170 98 170 137 64 137
					yourself:
				)
		)
		(boPeep init:)
		(= global305 outCode)
		(= global301 converse)
		(proc0_1)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_13 36 (gEgo x:) 135) 48)
				(self setScript: gStdClimbIn)
			)
			(south
				(gEgo
					posn:
						(proc0_13
							(gCurRoom edgeW:)
							(gEgo x:)
							(gCurRoom edgeE:)
						)
						139
				)
				(self setScript: gStdWalkIn)
			)
			(west
				(gEgo posn: 26 (proc0_13 72 (gEgo y:) (gCurRoom edgeS:)))
				(self setScript: gStdWalkIn)
			)
			(east
				(gEgo posn: 231 (proc0_13 141 (gEgo y:) (gCurRoom edgeS:)))
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(gEgo init:)
				(if global172
					(gEgo posn: 48 128)
					(self setScript: converse)
				else
					(gEgo posn: global173 global174)
					(gGame handsOn:)
				)
			)
			(else
				(gEgo posn: 48 128 init:)
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
			((== (gEgo edgeHit:) 1)
				(self setScript: gStdClimbOut)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gStdWalkOut register: (gEgo edgeHit:))
				(self setScript: gStdWalkOut)
			)
		)
	)

	(method (dispose)
		(DisposeScript 323)
		(if ((gGoals at: 2) egoReturned:)
			(DisposeScript 603)
		)
		(super dispose: &rest)
	)
)

(instance gestureScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 5 15))
			)
			(1
				(= state -1)
				(= register (- (Random 1 (NumCels client)) 1))
				(if (!= register (client cel:))
					(client
						setCycle:
							CT
							register
							(if (< (client cel:) register) 1 else -1)
							self
					)
				else
					(self cue:)
				)
			)
		)
	)
)

(instance sheepSearch of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(if (or (!= global130 45) (< (gEgo y:) (client y:)))
			(switch (= state newState)
				(0
					(boPeep setCycle: CT 2 1)
					(= seconds (Random 3 6))
				)
				(1
					(boPeep setCycle: End)
					(= seconds (Random 3 6))
				)
				(2
					(boPeep setCycle: CT 2 -1)
					(= seconds (Random 3 6))
					(if (< 5 (Random 1 8))
						(= state 0)
					)
				)
				(3
					(boPeep setCycle: CT 0 -1)
					(= seconds (Random 3 7))
					(= state -1)
				)
			)
		else
			(client setScript: 0)
		)
	)
)

(instance boPeep of Actor
	(properties
		x 125
		y 109
		view 72
		cycleSpeed 7
		illegalBits 0
	)

	(method (init)
		(super init:)
		(if ((gGoals at: 2) egoReturned:)
			(boPeep setLoop: 4)
			(boPeepHead
				init:
					boPeep
					(CelHigh (boPeep view:) (boPeep loop:) (boPeep cel:))
			)
			(if local0
				((ScriptID 423) init:) ; boPeepsSheep
			)
		else
			(self setScript: sheepSearch)
		)
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

(instance boPeepHead of Head
	(properties
		view 72
		loop 1
	)

	(method (init)
		(= global110 self)
		(super init: &rest)
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
						((> (gEgo x:) (+ (client x:) 20)) 1)
						(else 2)
					)
			)
		)
		(super doit:)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if ((gGoals at: 2) egoHas:)
					(if (< (gEgo x:) 120)
						(= temp0 50)
					else
						(= temp0 181)
					)
					(= temp1 146)
					(gEgo setMotion: PolyPath temp0 temp1 self)
				else
					(gEgo setMotion: PolyPath 104 141 self 0)
				)
			)
			(1
				(proc0_7 gEgo boPeep)
				(boPeep setLoop: 4 setCycle: 0)
				(boPeepHead
					init:
						boPeep
						(CelHigh (boPeep view:) (boPeep loop:) (boPeep cel:))
				)
				(= cycles 2)
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
				(boPeep setLoop: 0)
				(boPeepHead dispose:)
				(= cycles 2)
			)
			(1
				(if (not local0)
					(= global131 (+ (boPeep x:) 13))
					(= global132 (- (boPeep y:) 65))
					(= global128 101)
					(self setScript: (ScriptID 400) self) ; envisionScript
				else
					(= cycles 1)
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

	(method (changeState newState &tmp temp0)
		(if (not (= state newState))
			(gGame handsOff:)
			(= global516 gNarrator)
			(= gNarrator mgNarrator)
			(proc0_7 gEgo boPeep)
			(= temp0 (gGoals at: 2))
			(proc0_20)
			(cond
				(local3
					(switch local3
						(1
							(= global123 10)
							(self setScript: converse2 self)
						)
						(2
							(= global123 10)
							(self setScript: converse4 self)
						)
						(else
							(self setScript: converse6 self)
						)
					)
				)
				((temp0 egoReturned:)
					(self setScript: converse7 self)
				)
				((temp0 egoHas:)
					(self setScript: converse5 self)
					(temp0 egoReturned: 1)
					(if (== global123 10)
						(= global123 0)
					)
					(= local3 3)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self)
					(= global123 10)
					(= local3 2)
				)
				(else
					(self setScript: converse1 self)
					(temp0 egoTold: 1)
					(= local3 1)
					(= global123 10)
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
				(gMessager say: 12 1 2 0 self) ; "Here, sheep! Where are you, sheep?"
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

(instance converse2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
			)
			(1
				(gMessager say: 12 1 3 0 self) ; "I can't find my sheep anywhere! Perhaps Miss Muffet has seen them. Try asking her."
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

(instance converse3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
			)
			(1
				(gMessager say: 12 1 4 0 self) ; "Here, sheep, sheep, sheep! Here, sheep!"
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

(instance converse4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
			)
			(1
				(gMessager say: 12 1 5 0 self) ; "Here, sheep! Here, sheep!"
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

(instance converse5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
			)
			(1
				(proc0_7 gEgo boPeep)
				(gLongSong fade:)
				(gMessager say: 12 1 6 0 self) ; "My sheep! And look at those tails wagging! Thank you ever so much for finding them!"
			)
			(2
				(self setScript: (ScriptID 323) self) ; rhymeScript
				(= local0 1)
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

(instance converse6 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: attentionScript self)
			)
			(1
				(gMessager say: 12 1 7 0 self) ; "I'm so glad I have my sheep back! You're such a good child."
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(boPeep setCel: 0)
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
				(gMessager say: 12 1 8 0 self) ; "Hi. I see you still have your sheep."
			)
			(1
				(boPeep setCel: 0)
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
			(21
				(boPeepHead setCycle: ROsc 10000 0)
			)
			(9
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(21
				(boPeepHead cel: 0 setCycle: 0)
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
				(= temp0 (proc0_13 36 (gEgo x:) 135))
				(= temp1 48)
			)
			(2
				(= temp0 264)
				(= temp1 (proc0_13 140 (gEgo y:) 156))
			)
			(3
				(= temp0 (proc0_13 1 (gEgo x:) 258))
				(= temp1 158)
			)
			(4
				(= temp0 -1)
				(= temp1 (proc0_13 30 (gEgo y:) 152))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

