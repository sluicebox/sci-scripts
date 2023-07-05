;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37)
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
	rm037 0
)

(local
	local0
)

(instance rm037 of MGRoom
	(properties
		picture 37
		south 4
		edgeN -1
		edgeE 320
		edgeW -1
		edgeS 140
	)

	(method (init)
		(proc0_1)
		(= global305 outCode)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 92 76 44 96 54 103 70 108 76 122 76 134 55 155 194 155 180 135 181 122 189 106 212 98 189 88 165 77 154 86 130 89 101 85
					yourself:
				)
		)
		(king init:)
		(kingHead init: king (CelHigh (king view:) (king loop:) (king cel:)))
		(= picture 37)
		(= global305 outCode)
		(= global301 converse)
		(proc0_8 59 94 124 155)
		(switch gPrevRoomNum
			(south
				(gEgo setLoop: 3 posn: 134 139 init:)
				(self setScript: gStdWalkIn)
			)
			(45 ; mapRoom
				(if global172
					(gEgo posn: 134 139 init:)
					(self setScript: converse)
				else
					(gEgo posn: global173 global174 init:)
					(gGame handsOn:)
				)
			)
			(else
				(gEgo posn: 134 139 init:)
				(gGame handsOn:)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((== (gEgo edgeHit:) 3)
				(self setScript: gStdWalkOut 0 3)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(self setScript: gStdWalkOut 0 (gEgo edgeHit:))
			)
		)
	)

	(method (dispose)
		(DisposeScript 337)
		(super dispose: &rest)
	)
)

(instance king of Actor
	(properties
		x 131
		y 57
		view 80
		illegalBits 0
	)

	(method (init)
		(super init:)
		(if ((gGoals at: 9) egoReturned:)
			(= cel 1)
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

(instance kingHead of Head
	(properties
		view 80
		loop 1
	)

	(method (doit)
		(self setPri: (+ (client priority:) 1))
		(if (not script)
			(self setPri: (+ (client priority:) 1))
			(= x 131)
			(= y 33)
			(= z (client z:))
		)
		(super doit:)
	)
)

(instance attentionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global110 kingHead)
				(= cycles 2)
			)
			(1
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
				(= global131 (+ (king x:) 33))
				(= global132 (- (king y:) 36))
				(= global128 108)
				(self setScript: (ScriptID 400) self) ; envisionScript
			)
			(1
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
			(proc0_7 gEgo king)
			(= temp0 (gGoals at: 9))
			(proc0_20)
			(cond
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
				((temp0 egoReturned:)
					(self setScript: converse7 self)
				)
				((temp0 egoHas:)
					(self setScript: converse5 self)
					(temp0 egoReturned: 1)
					(if (== global123 16)
						(= global123 0)
					)
					(= local0 3)
				)
				((temp0 egoTold:)
					(self setScript: converse3 self)
					(= global123 16)
					(= local0 2)
				)
				(else
					(self setScript: converse1 self)
					(= global123 16)
					(temp0 egoTold: 1)
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
				(gMessager say: 17 1 2 0 self) ; "Come in! Come in! Say hello to Old King Cole. Here for a visit, are you?"
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
				(gMessager say: 17 1 3 0 self) ; "Run along now. Bring me my pipe."
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global123 16)
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
				(gMessager say: 17 1 4 0 self) ; "Come on in, child. Always glad to see you. Did you bring me my pipe?"
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
				(gMessager say: 17 1 5 0 self) ; "Don't forget, child. You're going to bring me my pipe."
			)
			(2
				(self setScript: atEaseScript self)
			)
			(3
				(= global123 16)
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
				(gMessager say: 17 1 6 0 self) ; "I brought your pipe, Your Majesty!"
			)
			(2
				(self setScript: (ScriptID 337) self) ; rhymeScript
			)
			(3
				(= cycles 1)
				(king view: 80 loop: 0 cel: 1)
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
				(gMessager say: 17 1 7 0 self) ; "You have pleased me greatly, child. I will put in a special word about you to Mother Goose."
			)
			(2
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
				(gMessager say: 17 1 8 0 self) ; "Here you are again, child. What can I do for you?"
			)
			(2
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
			(24
				(kingHead setCycle: ROsc 10000 0)
			)
			(9
				(self doEgoTalk:)
			)
		)
		(super startAudio: param1 &rest)
	)

	(method (dispose)
		(switch global515
			(24
				(kingHead cel: 0 setCycle: 0)
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
				(= temp0 (proc0_13 92 (gEgo x:) 182))
				(= temp1 64)
			)
			(2
				(= temp0 207)
				(= temp1 (proc0_13 81 (gEgo y:) 115))
			)
			(3
				(= temp0 (proc0_13 70 (gEgo x:) 185))
				(= temp1 141)
			)
			(4
				(= temp0 57)
				(= temp1 (proc0_13 88 (gEgo y:) 110))
			)
		)
		(gEgo setMotion: PolyPath temp0 temp1 0 0)
	)
)

