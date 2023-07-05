;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 705)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm705 0
)

(local
	local0
	local1
	local2
	[local3 9] = [1705 0 2 1 2 1 1 2 0]
	[local12 8] = [1705 6 2 1 2 1 2 0]
	[local20 5] = [1705 19 1 2 0]
	[local25 5] = [1705 21 1 1 0]
	[local30 4] = [1705 23 1 0]
	[local34 4] = [1705 24 1 0]
	[local38 8] = [1705 25 2 1 1 2 2 0]
	[local46 4] = [1705 30 1 0]
	[local50 6] = [1705 31 2 1 2 0]
	[local56 4] = [1705 34 1 0]
	[local60 9] = [1705 35 2 1 2 1 1 2 0]
	[local69 4] = [1705 43 1 0]
	[local73 4] = [1705 18 1 0]
	[local77 9] = [61 0 4 5 20 38 22 29 32]
)

(instance rm705 of Rm
	(properties
		picture 705
	)

	(method (init)
		(super init:)
		(squeakSound init: play:)
		(gRgnMusic number: 26 loop: -1 play:)
		(rat1 init:)
		(rat2 init:)
		(rat3 init:)
		(theKnight init: setScript: enterWindow)
		(AddToFeatures theWindow theDoor theFloor theRoom)
		(gTheIconBar disable: 4)
		(SetFlag 34)
	)

	(method (doit)
		(gCurRoom setScript: ratsDoit)
		(cond
			((gEgo script:) 0)
			((IsFlag 110)
				(ClearFlag 110)
				(gTheIconBar disable: 4)
				(if (IsFlag 67)
					(gEgo setScript: winKnightTrust)
				else
					(Converse @local69 @local77 0 self) ; "You'll not win my trust with that."
				)
			)
			(else
				(super doit: &rest)
			)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1705 48 1) ; "I cannot see through stone."
		)
	)

	(method (dispose)
		(gRgnMusic fade: 0 20 12 1)
		(DisposeScript 991)
		(super dispose:)
	)
)

(instance robDoVerb of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(if (and (== theVerb 4) (== invItem 1)) ; Inventory, horn
			(Say 1705 42 1) ; "And bring all the Monks in the Monastery down upon us? Nay, I think not."
		)
	)
)

(instance theRoom of Feature
	(properties
		x 69
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1705 12 1) ; "These stone walls are impenetrable."
			)
			(3 ; Do
				(Say 1705 46 1) ; "The walls are solid. The only way out is by the door or window."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 69 1 243 0 242 189 68 189
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance theFloor of Feature
	(properties
		x 82
		y 171
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1705 44 1) ; "The wooden floor is covered with dirty straw in which large, filty rats cavort."
			)
			(3 ; Do
				(Say 1705 45 1) ; "There's nothing I want on the floor."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 83 189 82 171 132 176 165 171 179 175 192 175 210 180 227 189
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance theWindow of Feature
	(properties
		x 90
		y 67
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1705 13 1) ; "The window I came through is the only one in this prison room."
			)
			(3 ; Do
				(Say 1705 14 1) ; "By the Virgin, I'll not leave here without the knight!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 90 114 92 77 99 69 111 67 118 74 118 115
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance theDoor of Feature
	(properties
		x 174
		y 87
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1705 15 1) ; "The heavy door has a small barred window. I must get the Knight away from here before a monk comes to check on him."
			)
			(3 ; Do
				(Say 1705 16 1) ; "It's solidly bolted from the outside, of course."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 174 174 176 115 179 100 185 92 194 87 205 88 213 93 219 100 218 181
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance rat1 of Prop
	(properties
		x 100
		y 188
		lookStr 11 ; "These rats are fearless."
		view 705
		loop 5
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1705 11 1) ; "These rats are fearless."
			)
			(3 ; Do
				(Say 1705 47 1) ; "They'd make good rat stew, but I've no time for that now."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rat2 of Prop
	(properties
		x 95
		y 182
		lookStr 11 ; "These rats are fearless."
		view 705
		loop 2
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1705 11 1) ; "These rats are fearless."
			)
			(3 ; Do
				(Say 1705 47 1) ; "They'd make good rat stew, but I've no time for that now."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rat3 of Prop
	(properties
		x 107
		y 176
		lookStr 11 ; "These rats are fearless."
		view 705
		loop 5
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1705 11 1) ; "These rats are fearless."
			)
			(3 ; Do
				(Say 1705 47 1) ; "They'd make good rat stew, but I've no time for that now."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theKnight of Actor
	(properties
		x 195
		y 188
		view 706
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1705 17 1) ; "He has the bearing of a true knight. Judging from the wound upon his head, he must have fought hard before he was captured."
			)
			(3 ; Do
				(Converse @local73 @local77 0 self) ; "Beware, stranger. I may be injured and unarmed, but I'll go nowhere with you willingly unless you prove yourself to me."
			)
			(5 ; Talk
				(if (== local2 0)
					(Converse @local20 2 @local77 self) ; "Sir, I swear by the Blessed Lady--"
					(= local2 1)
				else
					(Converse @local25 @local77 0 self) ; "If you are truly Robin Hood, you'll know what I require of you."
				)
			)
			(4 ; Inventory
				(cond
					((OneOf invItem 16 0 2 14) ; fulkScroll, bucks, halfHeart, amethyst
						(Converse @local30 @local77 0) ; "I want nothing from you but proof that I should trust you."
					)
					((== invItem 1) ; horn
						(Converse @local34 @local77 0) ; "What should I do with this, pretend it's the horn of Jericho and try to make the walls tumble down?"
					)
					((== invItem 18) ; waterRing
						(if (not local1)
							(= local1 1)
							(Converse @local38 2 @local77) ; "Why do you give me this ring?"
						else
							(Converse @local46 @local77 0) ; "I will not take this ring. If you cannot prove yourself by other means, then take yourself away as you came."
						)
					)
					((== invItem 10) ; fireRing
						(if (not local0)
							(Converse @local50 2 @local77) ; "What is the meaning of this token?"
						else
							(Converse @local56 @local77 0) ; "Ply me no more with this ring. Either prove yourself or be gone."
						)
					)
					((== invItem 9) ; message
						(SetFlag 154)
						(SetScore 100)
						(Converse @local60 2 @local77) ; "What is this?"
						(gEgo put: 9) ; message
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance enterWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 708
					loop: 0
					cel: 0
					x: 99
					y: 109
					illegalBits: 0
					actions: robDoVerb
					init:
					ignoreControl: -32768
					setCycle: End self
				)
			)
			(1
				(gEgo setLoop: 0 setCel: 6 x: 98 y: 108 cycleSpeed: 36)
				(= ticks 12)
			)
			(2
				(gEgo setLoop: 1 setCel: 0 x: 137 y: 150)
				(= ticks 12)
			)
			(3
				(gEgo setLoop: 1 setCel: 2 x: 146 y: 169)
				(theKnight setLoop: 0 setCel: 1)
				(= ticks 12)
			)
			(4
				(gEgo
					setLoop: 1
					setCel: 2
					x: 150
					y: 184
					moveSpeed: 6
					cycleSpeed: 6
				)
				(= ticks 12)
			)
			(5
				(NormalEgo 0 702 703)
				(= ticks 12)
			)
			(6
				(Converse @local3 2 @local77 self) ; "Who are you? How did you climb the tower? I see no rope."
			)
			(7
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 110 188 189 188 172 176 115 176
							yourself:
						)
				)
				(HandsOn)
				(gTheIconBar disable: 4)
				(self dispose:)
			)
		)
	)
)

(instance winKnightTrust of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetScore 50)
				(theKnight setCycle: End self)
			)
			(1
				(Converse @local12 3 @local77 self) ; "Good. Now I know you're the right man."
			)
			(2
				(gCurRoom newRoom: 710)
				(self dispose:)
			)
		)
	)
)

(instance ratsDoit of Script
	(properties)

	(method (doit)
		(if (< (gEgo distanceTo: rat3) 50)
			(rat3 setCel: 0 cycleSpeed: 18 setCycle: End)
		)
		(if (< (gEgo distanceTo: rat2) 50)
			(rat2 setCel: 0 setCycle: End)
		)
		(if (< (gEgo distanceTo: rat1) 50)
			(rat1 setCel: 0 setCycle: End)
		)
	)
)

(instance squeakSound of Sound
	(properties
		flags 1
		number 671
		loop -1
	)
)

