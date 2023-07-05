;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 540)
(include sci.sh)
(use Main)
(use n013)
(use Morris)
(use verseScript)
(use RTEyeCycle)
(use RandCycle)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm540 0
)

(local
	local0 = 1
	[local1 32] = [107 156 203 0 120 153 185 0 133 150 165 0 100 115 131 0 163 179 195 0 129 145 160 0 109 142 174 0 92 140 188 0]
	[local33 32] = [132 124 116 0 118 113 107 0 104 101 99 0 99 96 93 0 87 84 81 0 82 79 76 0 74 69 63 0 64 57 50 0]
	[local65 31]
	[local96 63] = [1 5 18 0 5 13 17 0 9 5 16 0 13 25 13 0 17 5 17 0 14 25 21 0 13 17 25 0 12 25 29 28 0 0 0 13 1 5 0 20 8 8 0 28 14 20 0 10 18 2 0 22 22 10 0 25 29 17 0 30 30 2 -1]
	[local159 165] = [1794 1793 1792 -1 -1 -1 -1 1794 1793 -1 -1 -1 -1 -1 1794 -1 -1 -1 -1 -1 -1 1794 1538 1537 1536 -1 -1 -1 1794 1538 1537 -1 -1 -1 -1 1794 1538 -1 -1 -1 -1 -1 1794 1538 1282 1281 1280 -1 -1 1794 1538 1282 1281 -1 -1 -1 1794 1538 1282 -1 -1 -1 -1 1794 1538 1281 1025 1024 -1 -1 1794 1538 1282 1026 1025 -1 -1 1794 1538 1281 1026 -1 -1 -1 1794 1538 1282 1027 -1 -1 -1 1794 1538 1028 -1 -1 -1 -1 1794 1029 -1 -1 -1 -1 -1 1794 1538 1027 769 768 -1 -1 1794 1538 1027 769 -1 -1 -1 1794 1538 1027 770 -1 -1 -1 1794 1538 1027 769 512 -1 -1 1794 1538 1027 770 513 -1 -1 1794 1538 1028 514 -1 -1 -1 1794 1538 1282 768 512 256 -1 1794 1538 1028 513 257 -1 -1 1794 1029 258 -1]
	[local324 16] = [167 92 154 92 141 87 131 87 87 80 83 60 195 41 205 95]
	[local340 18] = [32 65 17 56 11 47 0 43 0 47 12 57 9 76 26 91 38 84]
	[local358 12] = [258 133 270 133 284 150 277 163 259 164 250 154]
	[local370 14] = [237 46 263 47 278 41 281 46 263 51 242 63 228 59]
	[local384 8] = [71 61 208 36 228 122 91 143]
	[local392 20] = [98 54 100 17 160 0 193 0 210 17 213 46 193 46 194 33 184 19 165 46]
	[local412 19] = [189 163 100 185 77 159 81 132 101 138 96 147 107 157 126 143 189 124 0]
	[local431 9] = [541 0 2 4 22 31 25 23 5]
	[local440 6] = [1540 0 1 1 1 0]
	[local446 4] = [1540 3 1 0]
	[local450 5] = [1540 4 2 1 0]
	[local455 5] = [1540 6 2 1 0]
	[local460 4] = [1540 8 1 0]
	[local464 5] = [1540 9 2 1 0]
	[local469 8] = [1540 11 1 2 1 2 1 0]
	[local477 4] = [1540 16 1 0]
	[local481 6] = [1540 17 1 2 2 0]
	[local487 4] = [1540 21 1 0]
	[local491 5] = [1540 22 2 1 0]
	[local496 5] = [1540 24 2 1 0]
	[local501 4] = [1540 26 1 0]
	[local505 11] = [1540 27 2 1 1 2 1 1 2 1 0]
	[local516 5] = [1540 35 2 1 0]
	[local521 11] = [1540 37 1 1 0 1540 39 1 1 1 0]
	[local532 5] = [1540 42 1 2 0]
	[local537 5] = [1540 44 2 1 0]
	[local542 12] = [1540 46 2 1 2 1 2 1 2 2 1 0]
	[local554 9] = [1540 55 2 1 2 1 1 1 0]
	[local563 5] = [1540 61 1 1 0]
	[local568 4] = [1540 64 1 0]
	[local572 16] = [1540 65 1 0 1540 66 1 0 1540 67 1 0 1540 68 1 0]
	[local588 4] = [1540 78 1 0]
	[local592 4] = [1540 79 1 0]
	[local596 4] = [1540 80 1 0]
	[local600 4] = [1540 81 1 0]
	[local604 4] = [1540 82 1 0]
	[local608 4] = [1540 83 1 0]
	[local612 4] = [1540 20 1 0]
	[local616 4] = [1540 86 1 0]
	[local620 4] = [1540 88 1 0]
	[local624 4] = [1540 90 1 0]
	[local628 4] = [1540 70 1 0]
	[local632 7] = [1534 23 1 2 1 1 0]
	[local639 4] = [1534 27 1 0]
	[local643 4] = [1534 29 1 0]
	local647
	local648
	local649
	local650
	[local651 9] = [80 87 92 96 85 99 85 78 89]
	[local660 9] = [90 81 91 109 99 122 109 75 118]
	[local669 9] = [207 202 212 207 207 218 215 196 212]
	[local678 9] = [58 68 73 95 82 99 88 56 107]
	[local687 9]
	[local696 9]
)

(instance rm540 of Rm
	(properties
		picture 540
		style 100
		west 310
	)

	(method (init &tmp temp0)
		(HandsOff)
		(if (== gPrevRoomNum 550)
			(= style -32762)
		)
		(super init:)
		(cat1Poly points: @local340)
		(cat2Poly points: @local358)
		(meatPoly points: @local370)
		(brdPoly points: @local384)
		(harryPoly points: @local392)
		(robPoly points: @local412)
		(halfBoard points: @local324)
		(board init: onMeCheck: brdPoly)
		(cat1 init: onMeCheck: cat1Poly)
		(tail init: setCycle: Fwd setScript: meow)
		(cat2 init: onMeCheck: cat2Poly)
		(mugFloor init:)
		(harry init: onMeCheck: harryPoly)
		(rob init: onMeCheck: robPoly)
		(fish init:)
		(bones init:)
		(meat init: onMeCheck: meatPoly)
		(rHead init: setCycle: RandCycle)
		(hHead init: setCycle: RandCycle)
		(floor init:)
		((gTheIconBar at: 0) message: 11)
		(for ((= temp0 0)) (<= temp0 8) ((++ temp0))
			((= [local687 temp0] (piece new:))
				posn: [local669 temp0] [local678 temp0]
				init:
			)
			((= [local696 temp0] (piece new:))
				posn: [local651 temp0] [local660 temp0]
				cel: 1
				init:
			)
		)
		(arm init:)
		(cArm init:)
		(self setScript: offer)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 541)
	)
)

(instance board of Feature
	(properties
		y 30
		lookStr 69 ; "The nine men's Morris game is carved into the surface of this table."
	)

	(method (handleEvent event)
		(= description 1)
		(if
			(not
				(and
					(gCurRoom script:)
					(offer script:)
					(theMorris handleEvent: event)
				)
			)
			(= description 0)
			(super handleEvent: event)
		)
		(event claimed:)
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 3) (not (gCurRoom script:))) ; Do
				(super doVerb: theVerb)
			)
			((and (== theVerb 3) (not (offer script:))) ; Do
				(Converse @local628 @local431) ; "What're you doing, Monk? We haven't started a game yet."
			)
			((or (!= theVerb 3) (not description)) ; Do
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tail of Prop
	(properties
		x 271
		y 182
		view 542
		loop 9
		signal 4096
		cycleSpeed 60
	)

	(method (doVerb)
		(cat2 doVerb: &rest)
	)
)

(instance cat1 of Feature
	(properties
		lookStr 73 ; "A mangy old cat he is."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Say 1540 91 1) ; "I'm here to play Morris, not to pet cats."
			)
			(5 ; Talk
				(SetMessageColor 32)
				(Say 1540 94 1) ; "Meowrrrroorrr!"
				(SetMessageColor 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cat2 of Feature
	(properties
		lookStr 75 ; "A fat, ale-drinking cat she is."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Say 1540 91 1) ; "I'm here to play Morris, not to pet cats."
			)
			(5 ; Talk
				(SetMessageColor 32)
				(Say 1540 95 1) ; "prrrrrrrrrrr...."
				(SetMessageColor 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mugFloor of Feature
	(properties
		onMeCheck 4096
		lookStr 71 ; "Wasn't me who spilled it."
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(Say 1540 93 1) ; "I don't need that."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance bones of Feature
	(properties
		onMeCheck 16
		lookStr 76 ; "Cleanliness is not one of this innkeeper's virtues."
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(Say 1540 92 1) ; "That bone is only fit for these tavern cats."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fish of Feature
	(properties
		onMeCheck 256
		lookStr 76 ; "Cleanliness is not one of this innkeeper's virtues."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(SetMessageColor 32)
				(Say 540 0 1) ; "Once I was a happy fish, the sea was my home, now I'm just an excuse for a stupid poem."
				(SetMessageColor 0)
			)
			(3 ; Do
				(Say 1540 92 1) ; "That bone is only fit for these tavern cats."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance harry of Feature
	(properties
		lookStr 63 ; "I've seen such men before, whose love of a game has driven all else from their lives."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(cond
					((not (gCurRoom script:))
						(Converse @local516 @local431 999) ; "Another game?"
					)
					((offer script:)
						(Converse @local572 @local431) ; "I've no patience for chatterin' monks. Shut up and play."
					)
					(else
						(Converse @local568 @local431) ; "I'm waitin' for yer wager, monk, if ye've any to make."
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(if
							(or
								(not (theMorris moves:))
								(and
									(not (IsFlag 186))
									(<= (theMorris moves:) 2)
								)
							)
							(if (gMoney doit:)
								(= local648 (gFarthings taken:))
								(= local649 (gHapennies taken:))
								(= local650 (gPennies taken:))
								(gMoney put:)
							else
								(return)
							)
						)
						(cond
							((not (gCurRoom script:))
								(Converse @local516 @local431 999) ; "Another game?"
							)
							((offer script:)
								(cond
									((IsFlag 186)
										(Converse @local455 @local431 999) ; "I've a mind to increase my bet--"
									)
									((< (theMorris moves:) 2)
										(Converse @local491 @local431 999) ; "Hold, if it's not too late--"
										(SetFlag 186)
										(SetIcon 2)
									)
									(else
										(Converse @local496 @local431 999) ; "I've changed my mind. If you care to take my coins now...?"
									)
								)
							)
							((!= gPrevRoomNum 550)
								(SetFlag 186)
								(offer state: 0 seconds: 0)
								(Converse @local450 @local431 999 offer) ; "Here's my bet, then."
							)
							((IsFlag 186)
								(offer state: (+ (offer state:) 1) seconds: 0)
								(Converse @local464 @local431 999 offer) ; "Here's my wager, since you're so insistent."
							)
							(else
								(SetFlag 186)
								(offer state: (+ (offer state:) 1) seconds: 0)
								(Converse @local481 @local431 999 offer) ; "Ah, found yer courage at last, eh?"
							)
						)
					)
					(18 ; waterRing
						(gCurRoom setScript: pissOff)
					)
					(2 ; halfHeart
						(if local647
							(Converse @local563 @local431) ; "Take yer stone away before I give in to temptation."
						else
							(Converse @local554 @local431 999) ; "Will this emerald do as a wager?"
							(= local647 1)
						)
					)
					(11 ; cask
						(Converse @local632 @local431 999) ; "That's the Innkeeper's and he'll be wanting it back when you're done with it."
					)
					(14 ; amethyst
						(Converse @local639 @local431) ; "Don't be a fool. Ye've won it fair enough. I'll not take it back as charity or as a wager."
					)
					(13 ; robes
						(Converse @local643 @local431) ; "Ye'll never get me to take the vows."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(3 ; Do
				(Say 1540 84 1) ; "Whatever I take from him, I'll do by wagering and playing a fair game, not by force."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance pissOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse @local542 @local431 999 self) ; "I'll wager this ring--"
			)
			(1
				(SetFlag 124)
				(gCurRoom newRoom: 530)
			)
		)
	)
)

(instance meat of Feature
	(properties
		lookStr 77 ; "A leg of mutton that's seen better days."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(SetMessageColor 32)
				(Say 540 1 1) ; "Some called me lamb, Some called me mutton, Now I'm generally Good for nothin'."
				(SetMessageColor 0)
			)
			(3 ; Do
				(Say 1540 92 1) ; "That bone is only fit for these tavern cats."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rob of Feature
	(properties)

	(method (doVerb)
		(gEgo doVerb: &rest)
	)
)

(instance rHead of Prop
	(properties
		x 168
		y 20
		z -150
		view 542
		priority 14
		signal 16400
		cycleSpeed 540
	)

	(method (onMe)
		(return 0)
	)
)

(instance hHead of Prop
	(properties
		x 139
		y 8
		view 543
		priority 13
		signal 16400
		cycleSpeed 200
	)

	(method (doVerb)
		(harry doVerb: &rest)
	)
)

(instance floor of Feature
	(properties
		onMeCheck 1
		lookStr 76 ; "Cleanliness is not one of this innkeeper's virtues."
	)

	(method (handleEvent event)
		(if (not (event claimed:))
			(if (== ((gTheIconBar curIcon:) message:) 11)
				(event claimed: 1)
				((gTheIconBar at: 0) message: 1)
				(if (offer script:)
					(gFarthings get: local648)
					(gHapennies get: local649)
					(gPennies get: local650)
				)
				(gCurRoom newRoom: 530)
			else
				(super handleEvent: event)
			)
		)
	)
)

(instance meow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 520 720))
			)
			(1
				(catSound number: (Random 354 355) play:)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance brdPoly of Polygon
	(properties
		size 4
	)
)

(instance cat1Poly of Polygon
	(properties
		size 9
	)
)

(instance cat2Poly of Polygon
	(properties
		size 6
	)
)

(instance meatPoly of Polygon
	(properties
		size 7
	)
)

(instance harryPoly of Polygon
	(properties
		size 10
	)
)

(instance robPoly of Polygon
	(properties
		size 9
	)
)

(instance halfBoard of Polygon
	(properties
		size 8
	)
)

(instance offer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= gPrevRoomNum 550)
					(+= state 3)
				)
				(= cycles 1)
			)
			(1
				(Converse @local612 @local431 0 self) ; "I'll be generous and let ye go first, Monk."
			)
			(2
				(self setScript: theMorris self)
			)
			(3
				(theMorris moves: 0)
				(cond
					((IsFlag 186)
						(if local0
							(+= state 4)
							(Converse @local501 @local431 0 self) ; "Ye've won, monk. Here's yer amethyst."
						else
							(Converse @local521 @local431 0 self) ; "No need to scowl at me, monk. I won fairly enough."
							(gFarthings get: local648)
							(gHapennies get: local649)
							(gPennies get: local650)
						)
					)
					(local0
						(Converse @local532 @local431 999 self 0) ; "Ye were lucky this time, monk."
					)
					(else
						(Converse @local537 @local431 999 self 0) ; "Fie, you've won it, old man."
					)
				)
				(= gPrevRoomNum 550)
			)
			(4
				(cond
					((IsFlag 186)
						(= cycles 1)
					)
					((== gPrevRoomNum 550)
						(Converse @local469 @local431 999 self) ; "If ye're ready for a wager this time, the offer of my amethyst for yer money still stands."
					)
					(else
						(Converse @local440 @local431 0 self) ; "If ye care for a wager, I'll wager somethin' worth yer while."
					)
				)
			)
			(5
				(HandsOn)
				(SetIcon 1)
				(= seconds 15)
			)
			(6
				(HandsOff)
				(cond
					((IsFlag 186)
						(-= state 2)
						(Converse @local460 @local431 0 self) ; "If ye've no wager to make, ye may as well leave. I'm done with playin' for free."
					)
					((== gPrevRoomNum 550)
						(Converse @local477 @local431 0 self) ; "Still too scared of old Harry, eh? All right, I'll play ye another game wit'out a wager."
					)
					(else
						(Converse @local446 @local431 0 self 0) ; "Maybe yer scared old Harry is too good a player, eh? All right, I'll play ye this game wit'out a wager."
						(= state 0)
					)
				)
			)
			(7
				(= gCurRoomNum 550)
			)
			(8
				(cArm setCycle: ATo (+ @local159 154) self)
			)
			(9
				(gEgo get: 14) ; amethyst
				(SetScore 50)
				(proc13_0 {} 82 771 0 9 108)
				(= seconds 4)
			)
			(10
				(cArm setCycle: ATo (+ @local159 154) -1 self)
			)
			(11
				(Converse @local505 @local431 999 self) ; "What is the magic you claim it has?"
			)
			(12
				(self dispose:)
				(HandsOn)
			)
		)
	)
)

(instance piece of Prop
	(properties
		lookStr 69 ; "The nine men's Morris game is carved into the surface of this table."
		view 542
		loop 10
		priority 3
		signal 20752
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					((offer script:)
						(Say 1540 87 1) ; "I'm using the black pieces on the right side of the board."
					)
					((!= (theMorris state:) -1)
						(Say 1540 89 1) ; "The piece remains where it was placed."
					)
					(else
						(Say 1540 85 1) ; "I'll use the black pieces on the right side of the board."
					)
				)
			)
			(3 ; Do
				(cond
					((offer script:)
						(if noun
							(theMorris
								handleEvent:
									((User curEvent:) x: x y: y claimed: 0)
							)
						else
							(Converse @local620 @local431) ; "Ye've got a piece. Decide where ye want to place it."
						)
					)
					((!= (theMorris state:) -1)
						(Converse @local624 @local431) ; "Leave them pieces be, Monk. They're mine and I'll take care of resetting the board."
					)
					(else
						(Converse @local616 @local431) ; "These're all my pieces. Hand-carved'em myself. But if ye play a game, I'll let ye use'em."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance arm of Prop
	(properties
		x 196
		y 20
		z -121
		view 542
		loop 8
		priority 10
		signal 20496
		cycleSpeed 0
	)

	(method (doVerb)
		(gEgo doVerb: &rest)
	)
)

(instance cArm of Prop
	(properties
		x 102
		y 8
		z -32
		view 543
		loop 8
		priority 10
		signal 20496
		cycleSpeed 0
	)

	(method (doVerb)
		(harry doVerb: &rest)
	)
)

(instance theMorris of Morris
	(properties)

	(method (changeState newState &tmp [temp0 100] temp100 temp101 temp102 temp103)
		(switch (= state newState)
			(0
				(arm init: setCel: 0)
				(= us (= them 9))
				(gGame setCursor: gNormalCursor (HaveMouse))
				(= cycles 1)
			)
			(1
				(if (< moves 18)
					(= register [local687 (/ moves 2)])
					(arm setCel: 0)
				)
				(= doFrom (= doTo (= doTake -20)))
				(= cycles 1)
			)
			(2
				(HandsOn)
				(SetIcon 2)
				(= seconds 50)
			)
			(3
				(if seconds
					(= seconds 0)
				else
					(HandsOff)
					(Converse @local487 @local431 0 self) ; "Take yer turn, monk, or am I meant to wait 'til Doomsday?"
					(-= state 2)
					(return)
				)
				(if (< moves 18)
					(register hide:)
					(arm
						setCycle:
							ATo
							(+ @local159 (* 14 (/ (* 3 (+ 1 doTo)) 4)))
							self
					)
				else
					(arm
						setCycle:
							ATo
							(+ @local159 (* 14 (/ (* 3 (+ 1 doFrom)) 4)))
							self
					)
				)
			)
			(4
				(arm
					setCycle:
						ATo
						(+ @local159 (* 14 (/ (* 3 (+ 1 doTo)) 4)))
						-1
						self
				)
				(if (< moves 18)
					(clickSound play:)
				)
				(= ticks (+ 1 (arm cycleSpeed:)))
				(if (>= moves 18)
					(register hide:)
				)
			)
			(5
				(register
					show:
					posn: [local1 doTo] [local33 doTo]
					noun: 1
					setPri: -1
				)
				(if (>= moves 18)
					(clickSound play:)
				)
				(= register 0)
			)
			(6
				(= temp100 usThreat)
				(= temp101 usMills)
				(= temp102 themThreat)
				(= temp103 themMills)
				(= doTake -20)
				(self doMove: 16 1)
				(if (not (self inMill: doTo))
					(+= state 3)
				)
				(self unDoMove: 16 1)
				(= usThreat temp100)
				(= usMills temp101)
				(= themThreat temp102)
				(= themMills temp103)
				(arm setCel: 0 setLoop: 8)
				(= cycles 1)
			)
			(7
				(HandsOn)
				(gTheIconBar curIcon: (gTheIconBar at: 2))
				(= seconds 30)
			)
			(8
				(if seconds
					(= seconds 0)
					(arm
						setCycle:
							ATo
							(+ @local159 (* 14 (/ (* 3 (+ 1 doTake)) 4)))
							self
					)
				else
					(HandsOff)
					(Converse @local487 @local431 0 self) ; "Take yer turn, monk, or am I meant to wait 'til Doomsday?"
					(-= state 2)
				)
			)
			(9
				([local65 doTake] dispose:)
				(= [local65 doTake] 0)
				(arm
					setCycle:
						ATo
						(+ @local159 (* 14 (/ (* 3 (+ 1 doTake)) 4)))
						-1
						self
				)
			)
			(10
				(arm setCel: 0 setLoop: 8)
				(= cycles 2)
			)
			(11
				(self doMove: 16 1)
				(if (<= us 2)
					(self dispose:)
					(return)
				)
				(if (>= moves 18)
					(= scan 3)
				)
				(if (== moves 1)
					(= doTo [local96 (+ doTo (* 31 (Random 0 1)))])
				else
					(= local0 (self minimax: scan 0 1 16 32767))
				)
				(if (== doTo -20)
					(self dispose:)
					(return)
				)
				(self doMove: 1 16)
				(= doFrom (self lowerize: doFrom))
				(= doTo (self lowerize: doTo))
				(= doTake (self lowerize: doTake))
				(if (<= moves 18)
					((= register [local696 (- (/ moves 2) 1)]) hide:)
					(cArm
						setCycle:
							ATo
							(+ @local159 (* 14 (- 23 (/ (* 3 (+ 1 doTo)) 4))))
							self
					)
				else
					(cArm
						setCycle:
							ATo
							(+ @local159 (* 14 (- 23 (/ (* 3 (+ 1 doFrom)) 4))))
							self
					)
				)
			)
			(12
				(cArm
					setCycle:
						ATo
						(+ @local159 (* 14 (- 23 (/ (* 3 (+ 1 doTo)) 4))))
						-1
						self
				)
				(if (<= moves 18)
					(clickSound play:)
				)
				(= cycles (+ 1 (cArm cycleSpeed:)))
			)
			(13
				(if (<= moves 18)
					((= [local65 doTo] register) noun: 1 show:)
				else
					(clickSound play:)
					(= [local65 doTo] [local65 doFrom])
					(= [local65 doFrom] 0)
				)
				([local65 doTo] posn: [local1 doTo] [local33 doTo])
			)
			(14
				(if (== doTake -20)
					(++ state)
					(= cycles 1)
				else
					(cArm
						setCycle:
							ATo
							(+ @local159 (* 14 (- 23 (/ (* 3 (+ 1 doTake)) 4))))
							self
					)
				)
			)
			(15
				([local65 doTake] dispose:)
				(= [local65 doTake] 0)
				(cArm
					setCycle:
						ATo
						(+ @local159 (* 14 (- 23 (/ (* 3 (+ 1 doTake)) 4))))
						-1
						self
				)
			)
			(16
				(cArm setCel: 0 setLoop: 8)
				(if (and (> them 2) (!= local0 32767))
					(= state 0)
					(= cycles 1)
				else
					(self dispose:)
				)
			)
		)
	)

	(method (dispose)
		(= local0 (or (== local0 -32768) (<= us 2)))
		(super dispose: &rest)
	)

	(method (handleEvent event &tmp temp0 temp1 [temp2 3])
		(if (event claimed:)
			(return)
		)
		(if
			(and
				(or (== state 2) (== state 7))
				(& (= temp0 (OnControl CONTROL (event x:) (event y:))) $eeee)
				(== (gTheIconBar curIcon:) (gTheIconBar at: 2))
			)
			(event claimed: 1)
			(= temp1 -1)
			(while (and (not (& temp0 $0001)) (< temp1 16))
				(++ temp1)
				(>>= temp0 $0001)
			)
			(= temp0 temp1)
			(if (AvoidPath (event x:) (event y:) halfBoard)
				(+= temp0 16)
			)
			(cond
				((or (< moves 18) (!= doFrom -20))
					(cond
						((!= doTo -20)
							(cond
								((not (IsObject [local65 temp0]))
									(Converse @local588 @local431) ; "There's not a piece there, Monk."
								)
								((not ([local65 temp0] cel:))
									(Converse @local592 @local431) ; "Are you sure you know how to play Morris? That's your own piece you're trying to take."
								)
								((not (self isValid: doFrom doTo temp0))
									(Converse @local596 @local431) ; "'ere now! You can't take a piece from a mill when there's other pieces you can take. That's the rule."
								)
								(else
									(= doTake temp0)
									(= cycles 1)
									(HandsOff)
								)
							)
						)
						((IsObject [local65 temp0])
							(Converse @local600 @local431) ; "Are your eyes bad, Monk? There's already a piece there."
						)
						((or (self isValid: doFrom temp0 -20) (== temp0 doFrom))
							(= [local65 temp0] register)
							(register
								signal: (| (register signal:) $0100)
								setCycle: 0
								setCel: 0
							)
							(if (== temp0 doFrom)
								(= doFrom -20)
							else
								(= doTo temp0)
								(= cycles 1)
								(HandsOff)
							)
						)
						(1
							(Converse @local604 @local431) ; "Don't you try to cheat Ol Harry! You can't move to that spot from where you are!"
						)
					)
				)
				((not (IsObject [local65 temp0]))
					(Converse @local588 @local431) ; "There's not a piece there, Monk."
				)
				(([local65 temp0] cel:)
					(Converse @local608 @local431) ; "'ere now! That's my piece you're trying to move."
				)
				(else
					(= doFrom temp0)
					(= register [local65 doFrom])
					(= [local65 doFrom] 0)
					(register
						signal: (& (register signal:) $feff)
						setCycle: Fwd
					)
				)
			)
		)
		(event claimed:)
	)
)

(class ATo of CT
	(properties
		endCel -1
		pnts 0
	)

	(method (init param1 param2 param3 param4 &tmp temp0)
		(= client param1)
		(= pnts param2)
		(if (>= argc 3)
			(if (IsObject param3)
				(= caller param3)
			else
				(if (< (= cycleDir param3) 0)
					(while (!= (WordAt pnts (++ endCel)) -1)
					)
				)
				(if (>= argc 4)
					(= caller param4)
				)
			)
		)
	)

	(method (doit &tmp temp0)
		(if (== (client cel:) (self nextCel:))
			(return)
		)
		(if (== (= temp0 (WordAt pnts (+= endCel cycleDir))) -1)
			(self cycleDone:)
		else
			(client cel: (& temp0 $00ff))
			(client loop: (& (>> temp0 $0008) $00ff))
		)
	)
)

(instance clickSound of Sound
	(properties
		flags 1
		number 533
	)
)

(instance catSound of Sound
	(properties
		flags 1
	)
)

