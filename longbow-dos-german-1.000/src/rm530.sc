;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 530)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use StdRoom)
(use rhEgo)
(use RTEyeCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use MoveFwd)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm530 0
	keeper 1
	gate 2
	payKeeper 3
)

(local
	[local0 9] = [541 0 2 4 22 31 25 23 5]
	[local9 9] = [535 0 2 4 26 38 22 26 27]
	[local18 4] = [1535 42 1 0]
	[local22 8] = [1535 43 1 0 1535 43 1 0]
	[local30 4] = [1535 44 1 0]
	[local34 4] = [1530 26 1 0]
	[local38 4] = [1535 45 1 0]
	[local42 4] = [1535 53 1 0]
	[local46 4] = [1535 55 1 0]
	[local50 4] = [1535 51 1 0]
	[local54 4] = [1535 50 1 0]
	[local58 4] = [1535 48 1 0]
	[local62 4] = [1535 46 1 0]
	[local66 4] = [1535 52 1 0]
	[local70 4] = [1535 54 1 0]
	[local74 9] = [1530 141 2 3 1 3 1 2 0]
	[local83 4] = [1535 47 1 0]
	[local87 8] = [1535 56 1 2 1 2 1 0]
	[local95 4] = [1535 41 1 0]
	[local99 5] = [1535 3 2 1 0]
	[local104 4] = [1535 5 1 0]
	[local108 7] = [1535 33 1 2 1 2 0]
	[local115 7] = [1535 37 1 2 1 2 0]
	[local122 7] = [1535 6 2 1 2 1 0]
	[local129 5] = [1535 10 2 1 0]
	[local134 7] = [1535 12 2 1 1 1 0]
	[local141 4] = [1535 16 1 0]
	[local145 5] = [1535 20 2 1 0]
	[local150 5] = [1535 20 2 1 0]
	[local155 6] = [1535 22 2 1 1 0]
	[local161 6] = [1535 25 2 1 2 0]
	[local167 5] = [1535 28 1 2 0]
	[local172 6] = [1535 30 2 1 1 0]
	[local178 4] = [1530 103 1 0]
	[local182 4] = [1530 104 1 0]
	[local186 6] = [1530 57 1 2 1 0]
	[local192 7] = [1530 60 1 2 1 2 0]
	[local199 5] = [1530 44 1 2 0]
	[local204 4] = [1530 86 1 0]
	[local208 4] = [1530 95 1 0]
	[local212 7] = [1530 49 2 1 2 1 0]
	[local219 4] = [1535 2 1 0]
	[local223 4] = [1530 85 1 0]
	[local227 11] = [1530 1 3 2 4 1 2 1 2 1 0]
	[local238 21] = [1530 24 1 2 0 1530 118 1 2 0 1530 120 1 1 2 0 1530 123 2 1 0]
	local259
	local260
	local261
	local262
	local263
	local264
	local265
	local266
	local267
	local268
	local269
)

(procedure (localproc_0)
	(switch (++ local267)
		(1
			(Converse @local122 @local9 999) ; "I say, can you tell me anything of interest about the Sheriff?"
		)
		(2
			(Converse @local129 @local9 999) ; "I don't suppose your knowledge would increase if it were exposed to a few pieces of silver?"
		)
		(3
			(Converse @local134 @local9 999) ; "So sorry to have bothered you with all my questions. I didn't mean to be a nuisance."
		)
		(else
			(Converse @local141 @local9) ; "I've told you all I know."
		)
	)
)

(instance rm530 of StdRoom
	(properties
		picture 530
		south 270
		tpX 180
		tpY 180
	)

	(method (init &tmp temp0)
		(switch gPrevRoomNum
			(803 ; speedTest
				(gEgo x: 140 loop: 1 edgeHit: 1)
			)
			(270
				(gEgo x: 140 loop: 1 edgeHit: 1 setStep: 3 2)
			)
			(else
				(HandsOn)
				(gTheIconBar enable: 0)
				(gEgo edgeHit: 0)
			)
		)
		(++ global159)
		(if (IsFlag 125)
			((ScriptID 532 0) init:) ; party
		)
		(if (== gDay 10)
			(gCurRoom setScript: (ScriptID 533 0)) ; day10
		)
		(super init:)
		(keeper init: setHeading: 270 setCycle: StopWalk 534 approachVerbs: 5 4) ; Talk, Inventory
		(gate init: approachVerbs: 3) ; Do
		(fire init: setCycle: Fwd)
		(morStool init:)
		(morTable init:)
		(walls init:)
		(bar init: approachVerbs: 3) ; Do
		(lamps init:)
		(bottles init: approachVerbs: 3) ; Do
		(cTable init:)
		(cMug init:)
		(stools init:)
		(bTable init:)
		(bBenches init:)
		(tDrunk init:)
		(floor init:)
		(bMug init:)
		(fDrunk init:)
		(casks init:)
		(fireSound play:)
		(cond
			(
				(and
					(== gDisguiseNum 5) ; abbey monk
					(not (IsFlag 125))
					(OneOf gDay 5 6)
				)
				((ScriptID 531 0) init:) ; monkCode
				(if
					(or
						(and
							(not (IsFlag 125))
							(== gDisguiseNum 5) ; abbey monk
							(OneOf gDay 5 6)
							(not (IsFlag 205))
						)
						(== gPrevRoomNum 540)
					)
					((ScriptID 534 0) init:) ; Harry
				)
			)
			((== gDay 10)
				(morTable actions: vbParty)
				(morStool actions: vbParty)
				(gate approachVerbs: 0)
				(gEgo actions: egoActions)
			)
			((IsFlag 125)
				(morTable actions: vbParty)
				(morStool actions: vbParty)
			)
			(else
				(keeper actions: vbGenPub)
				(if (not (IsFlag 125))
					(gate addToPic:)
				)
				(if (OneOf gDisguiseNum 4 0) ; yeoman, outlaw
					((gCurRoom script:) next: inStuff)
				)
				(if (OneOf gDisguiseNum 2 3) ; jewler (no rouge), jewler (rouge)
					((gCurRoom script:) next: inJewelerStuff)
				)
			)
		)
		(= local259 gUseSortedFeatures)
		(= gUseSortedFeatures 1)
		(if (and (not (IsFlag 125)) (!= gDay 10))
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 150 240 168 181 198 176 226 176 226 170 243 170 263 188 314 171 266 183 245 164 284 150 236 157 228 149 198 149 198 127 232 118 232 106 98 106 92 112 168 112 152 129 49 129 85 130 80 140 72 144 45 161 48 165 48 176 41 186
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 175 141 136 188 93 188 97 180 83 180 75 187 49 187 91 148 141 149 147 142
						yourself:
					)
			)
			(bucket init: setScript: pour)
			(= temp0 (Random 1 5))
			(if (== gDisguiseNum 0) ; outlaw
				(= temp0 2)
			)
			(if (== gDisguiseNum 4) ; yeoman
				(= temp0 1)
			)
			(if (< temp0 4)
				(man1 init: setScript: drinking)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 132 133 154 139 131 145 110 140
							yourself:
						)
				)
			)
			(if (and (!= temp0 3) (!= temp0 4))
				(man2 init: addToPic:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 203 170 203 161 235 161 236 169
							yourself:
						)
				)
			)
			(if (and (!= temp0 1) (!= temp0 4))
				(man3 init: addToPic:)
			)
		)
	)

	(method (dispose)
		(= gUseSortedFeatures local259)
		(if (== (gRgnMusic number:) 530)
			(gRgnMusic fade: 50 30 8 0)
		else
			(gRgnMusic stop:)
		)
		(super dispose:)
		(if (gEgo has: 14) ; amethyst
			(SetFlag 205)
		)
		(LoadMany 0 534 531 532 533)
	)
)

(instance inStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gDisguiseNum 4) ; yeoman
					(Converse 4 @local227 @local9 0 999 3 19 1 20 2 self) ; "You there! Leave your bow by the door."
				else
					(gRgnMusic number: 542 loop: -1 play:)
					(++ state)
					(Converse @local238 19 20 self) ; "Look! An outlaw!"
				)
			)
			(1
				(self dispose:)
			)
			(2
				(gRgnMusic number: 543 loop: 1 play: self)
			)
			(3
				(= gDeathNum 27)
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance inJewelerStuff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((and (IsFlag 219) (IsFlag 220))
						(= cycles 1)
					)
					((and (IsFlag 219) (== gDisguiseNum 3)) ; jewler (rouge)
						(SetFlag 220)
						(Converse @local108 @local9 999 self) ; "That's a most changeable beard you have, merchant."
					)
					((and (IsFlag 220) (== gDisguiseNum 2)) ; jewler (no rouge)
						(SetFlag 219)
						(Converse @local115 @local9 999 self) ; "A most peculiar beard you have that cannot decide what colour is should be."
					)
					(else
						(if (== gDisguiseNum 3) ; jewler (rouge)
							(SetFlag 220)
						else
							(SetFlag 219)
						)
						(= cycles 1)
					)
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance dieNow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(roger setCycle: Walk init:)
				(giles setCycle: Walk init:)
				(jack setCycle: Walk init:)
				(roger setMotion: PolyPath 202 141 self)
				(giles setMotion: PolyPath 208 163 self)
				(jack setMotion: PolyPath 180 169 self)
			)
			(1)
			(2)
			(3
				(Converse 3 @local74 999 0 19 2 20 3 self 1) ; "Innkeeper, we want mugs of your best."
			)
			(4
				(= gDeathNum 29)
				(gCurRoom newRoom: 170) ; robinDeath
				(self dispose:)
			)
		)
	)
)

(instance payKeeper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((not register)
						(self dispose:)
						(HandsOn)
						(return)
					)
					((== register 1)
						(= local263 @local18)
						(++ state)
					)
					((== register 4)
						(= local263 @local22)
					)
					((> register 4)
						(= local263 @local30)
					)
				)
				(= cycles 1)
			)
			(1
				(self setScript: pullAPint self)
			)
			(2
				(if (or (== register 2) (== register 3))
					(= cycles 1)
				else
					(Converse
						local263
						@local9
						(if ((ScriptID 851 3) underBits:) 999 else 0) ; talker2
						self
					)
				)
			)
			(3
				(cond
					((>= register 4)
						(cond
							((gPennies taken:)
								(gMoney put:)
								(gPennies get: 1)
							)
							((>= (gHapennies taken:) 2)
								(gMoney put:)
								(gHapennies get: 2)
							)
							((gHapennies taken:)
								(gMoney put:)
								(gHapennies get: 1)
								(gFarthings get: 2)
							)
							(else
								(gMoney put:)
								(gFarthings get: 4)
							)
						)
						(= register 2)
					)
					((>= register 2)
						(if (gHapennies taken:)
							(gMoney put:)
							(gHapennies get: 1)
						else
							(gMoney put:)
							(gFarthings get: 2)
						)
						(= register 1)
					)
					(else
						(gMoney put:)
						(self dispose:)
						(HandsOn)
						(return)
					)
				)
				(= local260 (gEgo view:))
				(= local261 (gEgo loop:))
				(= cycles 1)
			)
			(4
				(gEgo
					view: 536
					loop: 4
					cel:
						(switch gDisguiseNum
							(5 0) ; abbey monk
							(4 1) ; yeoman
							(6 2) ; fens monk
							(1 3) ; beggar
							(2 4) ; jewler (no rouge)
							(3 4) ; jewler (rouge)
						)
				)
				(= seconds 3)
				(if (>= (++ local266) 5)
					(= next dieNow)
				)
			)
			(5
				(gEgo view: local260 loop: local261)
				(= ticks 10)
			)
			(6
				(if (== local266 1)
					(= [local34 1]
						(+
							26
							(switch gDisguiseNum
								(5 1) ; abbey monk
								(4 3) ; yeoman
								(6 2) ; fens monk
								(1 0) ; beggar
								(2 4) ; jewler (no rouge)
								(3 4) ; jewler (rouge)
							)
						)
					)
					(Converse @local34 999 0 self) ; "A fine brew."
				else
					(= cycles 1)
				)
			)
			(7
				(if (-- register)
					(-= state 4)
					(= ticks 100)
				else
					(HandsOn)
					(self dispose:)
				)
			)
		)
	)
)

(instance pullAPint of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(keeper setHeading: 90 setMotion: MoveFwd 10 self)
			)
			(1
				(= ticks 45)
			)
			(2
				(keeper setHeading: 270 setMotion: MoveFwd 10 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance pour of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 12))
			)
			(1
				(bucket setMotion: MoveTo 251 100 self)
				(rope init:)
			)
			(2
				(if (or (gCurRoom script:) (keeper script:))
					(= cycles 1)
					(-- state)
				else
					(keeper setMotion: MoveTo 253 117 self)
					(= local264 (keeper actions:))
					(= local265 (gate actions:))
					(keeper actions: vbNoCanDo)
					(gate actions: vbNoCanDo)
				)
			)
			(3
				(= ticks 50)
			)
			(4
				(keeper setMotion: MoveTo 229 108 self)
			)
			(5
				(keeper setHeading: 90 self)
			)
			(6
				(keeper view: 536 loop: 1 cel: 0 setCycle: CT 2 1)
				(= ticks 50)
			)
			(7
				(keeper setCycle: CT 0 -1 self)
			)
			(8
				(keeper loop: 3 setCycle: End self)
			)
			(9
				(keeper
					view: 533
					setCycle: StopWalk 534
					setMotion: MoveTo 253 120 self
				)
				(bucket setMotion: MoveTo 251 40 self)
			)
			(10
				(keeper setMotion: MoveTo 265 133 self)
			)
			(11
				(keeper setHeading: 270 self)
			)
			(12
				(keeper actions: local264)
				(gate actions: local265)
			)
			(13
				(rope dispose:)
				(bucket dispose:)
			)
		)
	)
)

(instance drinking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 12))
			)
			(1
				(client setCycle: CT 2 1 self)
			)
			(2
				(client setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance notBehindBar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local262 (keeper heading:))
				(keeper setHeading: 180 self)
			)
			(1
				(Converse @local204 @local9 0 self) ; "Keep out. You don't belong back there."
			)
			(2
				(keeper setHeading: local262)
				(gEgo setHeading: 270 setMotion: MoveFwd 60 self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance dontBow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Say 1530 127 self) ; "That seems a sure way to get myself killed by these unpleasant louts of the Sheriff's."
			)
			(1
				(Say 1530 128 self) ; "Besides, I promised the Innkeeper no trouble, at least not of my doing."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance usePipe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say 1530 138 self) ; "A piercing blast in his ear might possibly wake him."
			)
			(1
				(Say 1530 139 1) ; "Then again, it might not."
				(self dispose:)
			)
		)
	)
)

(instance fire of Prop
	(properties
		x 22
		y 144
		lookStr 48 ; "The fire barely warms these cool rooms."
		view 530
		priority 11
		signal 18448
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (== global115 2)
					(Say 1530 89 1) ; "With Fire Ring on my hand, I'd be safe from the flames, but not from the unwanted attention it might draw."
				else
					(Say 1530 88 1) ; "Burnt fingers are no help."
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance gate of Prop
	(properties
		x 164
		y 102
		approachX 190
		approachY 115
		view 530
		loop 2
		priority 6
		signal 26641
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (< (gEgo distanceTo: self) 25)
					(Say 1530 74 1) ; "I can see several casks of ale stored in the cellar beyond."
				else
					(Say 1530 73 1) ; "A heavy iron door bars the way into a beer cellar."
				)
			)
			(3 ; Do
				(if (== gDay 10)
					(Converse @local182 @local9 0 self) ; "Don't try to force your way past me, outlaw. I fought in the Crusades and I've no fear of any man that faces me fairly."
				else
					(Converse @local178 @local9 0 self) ; "You've no business back there."
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance rope of View
	(properties
		x 251
		y -18
		view 536
		loop 5
		cel 1
		priority 6
		signal 26640
	)

	(method (doit)
		(= y (- (bucket y:) 55))
	)
)

(instance bucket of Actor
	(properties
		x 251
		y 37
		yStep 1
		view 536
		loop 5
		priority 6
		signal 26640
		moveSpeed 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 123)
					(Say 1530 46 0 1) ; "It's the bucket the soldiers in the castle above use to buy ale."
				else
					(SetScore 10 123)
					(Say 1530 43 self 1) ; "It's a bucket, lowered on a rope through a hole in the sandstone roof!"
				)
			)
			(3 ; Do
				(Say 1530 87 1) ; "That's for the soldiers. They paid for it."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)

	(method (cue)
		(Converse @local199 999 @local9) ; "Innkeeper, what's the meaning of the lowered bucket?"
	)
)

(instance roger of Actor
	(properties
		x 118
		y 240
		view 753
		loop 3
	)
)

(instance giles of Actor
	(properties
		x 128
		y 270
		view 753
		loop 3
	)
)

(instance jack of Actor
	(properties
		x 118
		y 300
		view 753
		loop 3
	)
)

(instance keeper of Actor
	(properties
		x 265
		y 133
		approachX 220
		approachY 148
		view 533
		loop 1
		signal 24576
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1535 0 1) ; "He has a stern face and gruff manner."
			)
			(3 ; Do
				(Say 1535 1 1) ; "He doesn't look like a man I'd lay hands upon without careful thought."
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(keeper setScript: payKeeper 0 (gMoney doit:))
					)
					(2 ; halfHeart
						(Converse @local38 @local9) ; "I prefer to deal in silver or gold. I've had too much trouble with jewels."
					)
					(3 ; slipper
						(Converse @local62 @local9) ; "What would I want with that?"
					)
					(4 ; net
						(Converse @local62 @local9) ; "What would I want with that?"
					)
					(5 ; pipe
						(Converse @local66 @local9) ; "I don't want it."
					)
					(6 ; gems
						(Converse @local42 @local9) ; "I don't want your stones, Monk."
					)
					(7 ; jewels
						(Converse @local46 @local9) ; "It's nice enough, but too much just to pay for mug of ale."
					)
					(8 ; rouge
						(if (not (SetFlag 204))
							(Converse @local87 @local9 999) ; "What is it?"
						else
							(Converse @local62 @local9) ; "What would I want with that?"
						)
					)
					(9 ; message
						(Converse @local66 @local9) ; "I don't want it."
					)
					(10 ; fireRing
						(Converse @local50 @local9) ; "I don't take rings, only silver."
					)
					(12 ; puzzleBox
						(Converse @local54 @local9) ; "I've no use for that."
					)
					(13 ; robes
						(Converse @local95 @local9) ; "The last thing I want is one of your robes, Monk."
					)
					(14 ; amethyst
						(Converse @local58 @local9) ; "That's old Harry's rock. I'll not take that for payment."
					)
					(15 ; comb
						(Converse @local83 @local9) ; "I prefer coins for payment."
					)
					(16 ; fulkScroll
						(Converse @local62 @local9) ; "What would I want with that?"
					)
					(17 ; handScroll
						(Converse @local54 @local9) ; "I've no use for that."
					)
					(18 ; waterRing
						(Converse @local70 @local9) ; "If you want ale, pay with a coin. I've no interest in rings."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance man1 of Prop
	(properties
		x 131
		y 139
		lookStr 79 ; "The Sheriff's men know where good ale is to be found."
		view 531
		signal 24576
		cycleSpeed 9
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Say 1530 116 1) ; "The less said to them, the better."
			)
			(3 ; Do
				(Say 1530 110 1) ; "It would be most unwise for me to lay hands upon a sheriff's man."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance man2 of Prop
	(properties
		x 219
		y 171
		lookStr 79 ; "The Sheriff's men know where good ale is to be found."
		view 753
		loop 1
		signal 16384
		detailLevel 3
	)

	(method (doVerb)
		(man1 doVerb: &rest)
	)
)

(instance man3 of Prop
	(properties
		x 30
		y 181
		lookStr 79 ; "The Sheriff's men know where good ale is to be found."
		view 753
	)

	(method (doVerb)
		(man1 doVerb: &rest)
	)
)

(instance morStool of Feature
	(properties
		x 200
		y 192
		onMeCheck 2
		approachX 190
		approachY 175
	)

	(method (init)
		(self
			approachVerbs:
				(if
					(and
						(not (IsFlag 125))
						(== gDisguiseNum 5) ; abbey monk
						(OneOf gDay 5 6)
						(not (IsFlag 205))
					)
					3
				else
					0
				)
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if
					(and
						(not (IsFlag 125))
						(== gDisguiseNum 5) ; abbey monk
						(OneOf gDay 5 6)
						(not (IsFlag 205))
					)
					(Say 1530 55) ; "If I sit here, I'll undoubtedly have to play a game of Morris with this fellow."
				else
					(Say 1530 56) ; "It's a rough hewn stool."
				)
			)
			(3 ; Do
				(if
					(and
						(not (IsFlag 125))
						(== gDisguiseNum 5) ; abbey monk
						(OneOf gDay 5 6)
						(not (IsFlag 205))
					)
					(cond
						((or (gEgo has: 14) (IsFlag 124)) ; amethyst
							((ScriptID 534 0) doVerb: 5) ; Harry
						)
						((IsFlag 215)
							((ScriptID 534 0) cue:) ; Harry
						)
						(local269
							(SetFlag 215)
							(Converse @local192 9 @local0 (ScriptID 534 0)) ; "You're a good Morris player?", Harry
						)
						(else
							(= local269 1)
							(Converse @local186 9 @local0) ; "Mind if I sit here?"
						)
					)
				else
					(Say 1530 96 1) ; "Not much point sitting at the game table without an opponent."
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance morTable of Feature
	(properties
		x 217
		y 189
		onMeCheck 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if
					(and
						(> gDay 4)
						(IsFlag 205)
						(not (SetFlag 198))
						(not
							(and
								(not (IsFlag 125))
								(== gDisguiseNum 5) ; abbey monk
								(OneOf gDay 5 6)
								(not (IsFlag 205))
							)
						)
					)
					(Converse @local212 @local9 999) ; "Your Morris seems to be gathering dust."
				else
					(Say 1530 53) ; "A Nine-Men's Morris game is carved into the top of this table."
				)
			)
			(3 ; Do
				(if
					(and
						(not (IsFlag 125))
						(== gDisguiseNum 5) ; abbey monk
						(OneOf gDay 5 6)
						(not (IsFlag 205))
					)
					(Converse @local208 @local0 0) ; "Now don't ye go losing none of the playing pieces, Monk."
				else
					(Say 1530 94 1) ; "There's nothing I wish to take from the Morris table."
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance walls of Feature
	(properties
		onMeCheck 1
		lookStr 75 ; "These rooms were made by enlarging natural caves within the sandstone bluff."
	)
)

(instance bar of Feature
	(properties
		x 240
		y 135
		onMeCheck 8
		approachX 226
		approachY 148
		lookStr 40 ; "This high bench keeps customers from helping themselves."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Converse @local223 @local9) ; "It's a ha'penny for a mug and don't get any ideas about helping yourself."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance lamps of Feature
	(properties
		onMeCheck 16
		lookStr 47 ; "The lantern light is dim, but welcome."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1530 92 1) ; "No need to aggravate this Innkeeper by trifling with his lanterns."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance bottles of Feature
	(properties
		x 276
		y 135
		onMeCheck 32
		approachX 284
		approachY 150
		lookStr 42 ; "He has casks and bottles behind the bar."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(keeper setScript: notBehindBar)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance cTable of Feature
	(properties
		x 111
		y 163
		onMeCheck 64
		lookStr 64 ; "The tables are roughly made."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1530 90 1) ; "Nothing of interest to me there."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance cMug of Feature
	(properties
		x 133
		y 167
		onMeCheck 128
		lookStr 65 ; "Someone's left a mug of half-drunk ale."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1530 91 1) ; "I can do without someone else's mug."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance stools of Feature
	(properties
		onMeCheck 256
		lookStr 56 ; "It's a rough hewn stool."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1530 97 1) ; "I'll feel safer standing for the moment."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance bTable of Feature
	(properties
		x 104
		y 113
		onMeCheck 512
		lookStr 66 ; "This table has become a bed for this besotted cup-knight."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1530 98 1) ; "Nothing I want there."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance bBenches of Feature
	(properties
		x 104
		y 113
		onMeCheck 1024
		lookStr 67 ; "The benches are as roughly made as the tables."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1530 97 1) ; "I'll feel safer standing for the moment."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance tDrunk of Feature
	(properties
		x 92
		y 118
		onMeCheck 2048
		lookStr 68 ; "A true ale-knight, deep in his cups."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1530 99 1) ; "The trumpets of the Doomsday wouldn't wake this fellow."
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(Say 1530 129 1) ; "That would be a waste of good silver."
					)
					(11 ; cask
						(Say 1530 133 1) ; "He's had more than enough already."
					)
					(14 ; amethyst
						(Say 1530 135 1) ; "It's far too late for the amethyst to do him any good."
					)
					(5 ; pipe
						(gEgo setScript: usePipe)
					)
					(6 ; gems
						(Say 1530 140 1) ; "This man is stoned enough."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(5 ; Talk
				(Say 1530 125 1) ; "May as well talk to myself."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance floor of Feature
	(properties
		onMeCheck 4096
		lookStr 76 ; "The floors are cold and hard packed after centuries of use."
	)
)

(instance bMug of Feature
	(properties
		x 113
		y 114
		nsTop 92
		nsLeft 111
		nsBottom 97
		nsRight 117
		lookStr 69 ; "The mug belongs to this drunken fellow, I wager."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1530 100 1) ; "I can live without that."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance fDrunk of Feature
	(properties
		x 64
		y 137
		onMeCheck 8192
		lookStr 70 ; "Those are the feet of a man who is beyond drunk. A man who may never again be sober."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1530 101 1) ; "I might as soon try to wake the dead."
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(Say 1530 129 1) ; "That would be a waste of good silver."
					)
					(11 ; cask
						(Say 1530 134 1) ; "I doubt this man will ever be sober enough to drink again."
					)
					(14 ; amethyst
						(Say 1530 136 1) ; "A dozen amethysts wouldn't help this man."
					)
					(3 ; slipper
						(Say 1530 132 1) ; "Nay, wouldn't fit."
					)
					(6 ; gems
						(Say 1530 140 1) ; "This man is stoned enough."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(5 ; Talk
				(Say 1530 126 1) ; "It would be like talking to the floor."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance casks of Feature
	(properties
		onMeCheck 16384
		lookStr 72 ; "It's another cask."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say 1530 93 1) ; "They're fine where they are."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance vbParty of SpecialDoVerb
	(properties)

	(method (doVerb)
		(Say 1530 54 1) ; "I've no time to think about Nine-Men's Morris now!"
		(return 1)
	)
)

(instance vbNoCanDo of SpecialDoVerb
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(return 0)
			)
			(else
				(Converse @local219 @local9) ; "Wait a moment. I'm busy."
				(return 1)
			)
		)
	)
)

(instance egoActions of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(1 ; horn
						(Say 1530 147 1) ; "I dare not wind my horn here."
					)
					(else
						(gDoVerbCode doit: theVerb invItem &rest)
					)
				)
			)
		)
	)
)

(instance vbGenPub of SpecialDoVerb
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(switch gDisguiseNum
					(1 ; beggar
						(if local267
							(Converse @local150 @local9 999) ; "'ave you no charity in your heart?"
						else
							(++ local267)
							(Converse @local145 @local9 999) ; "'ave you no charity in your heart?"
						)
					)
					(5 ; abbey monk
						(if local267
							(Converse @local104 @local9) ; "I'm not in the mood for idle chatter."
						else
							(++ local267)
							(Converse @local172 @local9 999) ; "Shall I pray for your soul?"
						)
					)
					(6 ; fens monk
						(switch (++ local267)
							(1
								(Converse @local155 @local9 999) ; "You glare at me, Innkeeper. What have I done to you?"
							)
							(2
								(Converse @local161 @local9 999) ; "You judge me harshly. Perhaps I'm not quite as I seem."
							)
							(else
								(Converse @local167 @local9 999) ; "You talk strangely, Monk."
							)
						)
					)
					(4 ; yeoman
						(if local267
							(Converse @local104 @local9) ; "I'm not in the mood for idle chatter."
						else
							(Converse @local99 @local9 999) ; "What's the secret of your fine ale?"
							(++ local267)
						)
					)
					(2 ; jewler (no rouge)
						(localproc_0)
					)
					(3 ; jewler (rouge)
						(localproc_0)
					)
				)
			)
			(10 ; Longbow
				(keeper setScript: dontBow)
			)
			(else
				(return 0)
			)
		)
	)
)

(instance gateSound of Sound ; UNUSED
	(properties
		flags 1
		number 532
	)
)

(instance fireSound of Sound
	(properties
		flags 1
		number 537
		loop -1
	)
)

