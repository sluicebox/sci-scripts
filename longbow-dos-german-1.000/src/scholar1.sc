;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 312)
(include sci.sh)
(use Main)
(use n013)
(use Fair)
(use verseScript)
(use RTEyeCycle)
(use PPath)
(use Language)
(use Feature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	scholar1 0
)

(local
	local0
	local1
	local2 = 1
	[local3 9] = [323 6 2 4 25 35 20 25 22]
	local12
	[local13 11] = [1312 0 1 2 1 2 0 1312 4 1 0]
	[local24 4] = [1312 5 2 0]
	[local28 4] = [1312 6 1 0]
	[local32 4] = [1312 7 1 0]
	[local36 6] = [1312 8 2 1 2 0]
	[local42 4] = [1312 11 1 0]
	[local46 4] = [1312 14 1 0]
	[local50 4] = [1312 12 2 0]
	[local54 4] = [1312 13 1 0]
	[local58 5] = [1312 21 1 2 0]
	[local63 4] = [1312 19 1 0]
	[local67 4] = [1312 23 1 0]
	[local71 4] = [1312 17 1 0]
	[local75 4] = [1312 20 1 0]
	[local79 5] = [1312 15 1 1 0]
	[local84 4] = [1312 18 1 0]
	[local88 5] = [1312 24 1 2 0]
	[local93 4] = [1312 26 1 0]
	[local97 4] = [1312 27 1 0]
	[local101 7] = [1312 28 2 1 2 2 0]
	[local108 5] = [1312 32 1 1 0]
	local113
	local114
	local115
	local116
	local117
	local118
)

(instance scholar1 of Actor
	(properties
		cycleSpeed 10
		xStep 4
		moveSpeed 10
	)

	(method (init param1 param2 param3 param4 param5 &tmp temp0 temp1 temp2)
		(= local1 param2)
		(= local0 param1)
		(if param5
			(if (> local0 0)
				(= param5 (- 801 param5))
			)
			(= temp0 (+ (/ (* param5 (- param4 1)) 801) 1))
		else
			(= temp0 (if (> local0 0) 0 else param4))
		)
		(if (> local0 0)
			(= temp1 (+ temp0 1))
			(= temp2 param4)
		else
			(= temp1 (- temp0 1))
			(= temp2 0)
		)
		(super init:)
		(self
			setLoop: -1
			view: 321
			setCycle: SyncWalk
			posn: (WordAt param3 (*= temp0 2)) (WordAt param3 (+ temp0 1))
			setMotion: PPath param3 temp1 temp2 lv
		)
		(= local114 (scholar1 mover:))
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(cond
					((gCurRoom script:)
						(super doVerb: theVerb &rest)
					)
					(
						(or
							(> (gEgo distanceTo: scholar1) 50)
							(> (scholar1 x:) 312)
							(< (scholar1 x:) 5)
						)
						(Say 1311 0) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
					)
					((== global195 7)
						(super doVerb: theVerb &rest)
					)
					(else
						(switch global195
							(0
								(gCurRoom setScript: converse)
							)
							(1
								(gCurRoom setScript: converse)
							)
							(4
								(gCurRoom setScript: waitForGive)
							)
							(3
								(if (gEgo has: 17) ; handScroll
									(gCurRoom setScript: waitForGive)
								)
							)
							(5
								(gCurRoom setScript: getMon)
							)
						)
					)
				)
			)
			(2 ; Look
				(if local2
					(Say 1311 2) ; "Ah, a Scholar!"
					(= local2 0)
				else
					(Say 1311 3) ; "The Scholar looks the same as he did before."
				)
			)
			(3 ; Do
				(Say 1311 4) ; "There's nothing I wish to take from this fellow."
			)
			(4 ; Inventory
				(if
					(or
						(> (gEgo distanceTo: scholar1) 50)
						(> (scholar1 x:) 312)
						(< (scholar1 x:) 5)
					)
					(Say 1311 1) ; "I must get closer to do that."
				else
					(switch invItem
						(17 ; handScroll
							(if
								(or
									(IsFlag 203)
									(== (gCurRoom script:) waitForGive)
								)
								(gCurRoom setScript: give)
							else
								(gCurRoom setScript: noTake)
							)
						)
						(0 ; bucks
							(gCurRoom setScript: giveMon)
						)
						(else
							(super doVerb: theVerb &rest)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (delete)
		(super delete:)
		(DisposeScript 312)
	)
)

(instance showIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(= register global123)
				else
					(= register (Random 1 11))
					(if (<= register global123)
						(-- register)
					)
				)
				(= local116 (+ 12 (CelHigh 71 12 0)))
				(= local117 (+ 245 (CelWide 71 12 0)))
				(= local118 (Graph grSAVE_BOX 12 245 local116 local117 3))
				(DrawCel 71 12 0 245 12 15 1)
				(DrawCel 71 register 0 256 14 15 1)
				(= cycles 1)
			)
			(1
				(Converse 1 local12 @local3 3 self 1)
			)
			(2
				(= local113 (AyeOrNay))
				(= cycles 2)
			)
			(3
				(Graph grRESTORE_BOX local118)
				(Graph grUPDATE_BOX 12 245 local116 local117 1)
				(= cycles 2)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance converse of Script
	(properties)

	(method (changeState newState &tmp [temp0 125] [temp125 100] [temp225 150])
		(switch (= state newState)
			(0
				(HandsOff)
				(scholar1 loop: (> (scholar1 x:) (gEgo x:)) mover: 0)
				(Face gEgo scholar1)
				(= ticks 10)
			)
			(1
				(if (!= global195 1)
					(Converse @local13 999 @local3 self 0) ; "Good day to you, learned sir."
				else
					(++ state)
					(= cycles 2)
				)
			)
			(2
				(GetFarText 1312 4 @temp0) ; "I've a mind to see the coat-of-arms of The"
				(GetFarText 1317 global123 @temp125)
				(if 1
					(= global216 (Memory memALLOC_CRIT (StrLen @temp0)))
					(= global218 (Memory memALLOC_CRIT (StrLen @temp125)))
					(= global221 (Memory memALLOC_CRIT (StrLen @temp0)))
					(= global223 (Memory memALLOC_CRIT (StrLen @temp125)))
					(StrSplitInTwo global216 global221 @temp0)
					(StrSplitInTwo global218 global223 @temp125)
					(if (== (gGame printLang:) 49)
						(Format @temp225 312 0 global221 global223) ; "%s%s"
					else
						(Format @temp225 312 0 global216 global218) ; "%s%s"
					)
					(Memory memFREE global216)
					(Memory memFREE global218)
					(Memory memFREE global221)
					(Memory memFREE global223)
				)
				((ScriptID 851 2) show: say: @temp225 0 0 0 self) ; talker1
			)
			(3
				(if (< global195 1)
					(Converse @local24 999 @local3 self 1) ; "Ah. Well, let me see."
				else
					(Converse @local50 999 @local3 self 1) ; "Has your knowledge increased? We shall see."
				)
			)
			(4
				(scholar1
					loop: (+ (scholar1 loop:) 2)
					cel: 0
					setCycle: End self
				)
			)
			(5
				(if (!= global195 1)
					(= local12 @local28)
				else
					(= local12 @local32)
				)
				(self setScript: showIt self 0)
			)
			(6
				(= cycles 2)
			)
			(7
				(scholar1 setCycle: Beg self)
			)
			(8
				(if local113
					(Converse 1 @local42 @local3 3 0 1) ; "You are not as knowledgeable as you think."
					(= global195 1)
					(self changeState: 12)
				else
					(scholar1 setCycle: End self)
				)
			)
			(9
				(= local12 @local32)
				(self setScript: showIt self 1)
			)
			(10
				(scholar1 setCycle: Beg self)
			)
			(11
				(if local113
					(SetFlag 203)
					(Converse @local36 999 @local3 0 1) ; "In the name of Queen Eleanor, I bid you welcome."
					(if (< global195 1)
						(SetScore 100)
					else
						(SetScore 50)
					)
					(= global195 2)
					(gCurRoom setScript: waitForGive)
				else
					(Converse 1 @local42 @local3 3 self 1) ; "You are not as knowledgeable as you think."
					(= global195 1)
				)
			)
			(12
				(scholar1
					setCycle: SyncWalk
					mover: local114
					loop: (< (local114 x:) (scholar1 x:))
				)
				(= cycles 2)
			)
			(13
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance waitForGive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(User canInput: 1)
				(gTheIconBar enable: 7 6 curIcon: (gTheIconBar at: 7))
				(= cycles 4)
			)
			(1
				(gGame setCursor: 999 1)
				(= cycles 4)
			)
			(2
				(scholar1 loop: (> (scholar1 x:) (gEgo x:)) mover: 0)
				(if (OneOf global195 4 3)
					(Converse 1 @local46 @local3 3 self 1) ; "What dangerous game do you play? Give me what you've brought for me, quickly!"
				else
					(if (== global195 2)
						(= global195 3)
					)
					(= cycles 2)
				)
			)
			(3
				(= seconds 7)
			)
			(4
				(Converse 1 @local54 @local3 3 self 1) ; "Hurry, my friend! We are not safe here."
			)
			(5
				(HandsOff)
				(scholar1
					setCycle: SyncWalk
					mover: local114
					loop: (< (local114 x:) (scholar1 x:))
				)
				(= ticks 5)
			)
			(6
				(HandsOn)
				(= global195 4)
				(self dispose:)
			)
		)
	)
)

(instance lv of CueObj
	(properties)

	(method (cue &tmp temp0)
		(proc311_1 local1 local0 scholar1)
	)
)

(instance getMon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= global195 5)
					(Converse 1 @local84 @local3 3 self 1) ; "I must leave now. God save the King!"
				else
					(++ state)
					(Converse @local58 999 @local3 self 1) ; "Perhaps I was hasty to turn down your coins."
				)
			)
			(1
				(Converse 1 @local63 999 0 self 1) ; "Aye, with a bit of help from the outlaws of Sherwood Forest!"
			)
			(2
				(gPennies put: 7)
				(gHapennies put: 6)
				(gFarthings put: 5)
				(if (not (IsFlag 58))
					(= global195 6)
				else
					(= global195 7)
					(SetFlag 217)
				)
				(self dispose:)
			)
		)
	)
)

(instance noTake of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(scholar1 loop: (> (scholar1 x:) (gEgo x:)) mover: 0)
				(Face gEgo scholar1 self)
			)
			(1
				(Face scholar1 gEgo)
				(= ticks 10)
			)
			(2
				(Converse @local88 999 @local3 self 1) ; "Perhaps this scroll would be of interest to you?"
			)
			(3
				(scholar1
					setCycle: SyncWalk
					mover: local114
					loop: (< (local114 x:) (scholar1 x:))
				)
				(= cycles 2)
			)
			(4
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance giveMon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(scholar1 loop: (> (scholar1 x:) (gEgo x:)) mover: 0)
				(Face gEgo scholar1 self)
			)
			(1
				(if (>= (gMoney doit:) 1)
					(gMoney put:)
					(Face scholar1 gEgo)
					(= cycles 2)
				else
					(self changeState: 4)
				)
			)
			(2
				(cond
					((== global195 5)
						(Converse @local101 999 @local3 self 1) ; "Why do you give me this?"
					)
					((OneOf global195 6 7)
						(Converse 1 @local97 @local3 3 self 1) ; "Nay, the coins are for you."
					)
					(else
						(Converse 1 @local93 @local3 3 self 1) ; "I've nothing to sell you for that price."
					)
				)
			)
			(3
				(if (== global195 5)
					(if (AyeOrNay)
						(self setScript: getMon self)
					else
						(Converse 1 @local108 @local3 3 self 1) ; "As you will. Now I must be gone."
					)
				else
					(= cycles 2)
				)
			)
			(4
				(scholar1
					setCycle: SyncWalk
					mover: local114
					loop: (< (local114 x:) (scholar1 x:))
				)
				(= cycles 2)
			)
			(5
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance give of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 17) ; handScroll
				(HandsOn)
				(gTheIconBar disable: 5)
				(= cycles 5)
			)
			(1
				(HandsOff)
				(SetFlag 58)
				(Face gEgo scholar1)
				(= ticks 10)
			)
			(2
				(if (== global195 4)
					(Converse 1 @local79 @local3 3 self 0) ; "You are either an overly cautious man or a demented one."
				else
					(Converse 1 @local67 @local3 3 self 0) ; "Excellent! I thank you, yeoman."
				)
			)
			(3
				(if (== global195 4)
					(SetScore 25)
				else
					(SetScore 50)
				)
				(Converse 1 @local71 @local3 3 self 1) ; "I have little money with me, but please accept what coins I have. Use them as you see fit."
			)
			(4
				(if (AyeOrNay)
					(self setScript: getMon self)
				else
					(= global195 5)
					(Converse 1 @local75 @local3 3 self 1) ; "As you wish. I will be in the Fair a short time more should you change your mind. Farewell!"
				)
			)
			(5
				(scholar1
					setCycle: SyncWalk
					mover: local114
					loop: (< (local114 x:) (scholar1 x:))
				)
				(= cycles 2)
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

