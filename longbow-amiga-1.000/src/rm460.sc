;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 460)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use StdRoom)
(use rhEgo)
(use RTEyeCycle)
(use PPath)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Sound)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm460 0
)

(local
	local0
	[local1 9] = [431 0 2 4 23 34 24 25 25]
	[local10 9] = [431 3 2 4 5 39 25 33 25]
	[local19 3] = [-1 {Arthur} 32]
	[local22 3] = [-1 {Gawaine} 32]
	[local25 3] = [-1 {Lancelot} 32]
	[local28 14] = [1460 0 1 1 2 1 1 1 2 1 1 2 1 0]
	[local42 6] = [1460 11 1 2 1 0]
	[local48 6] = [1460 14 1 2 1 0]
	[local54 6] = [1460 17 1 2 1 0]
	[local60 7] = [1460 20 1 2 1 1 0]
	[local67 7] = [1460 24 1 2 1 2 0]
	[local74 4] = [1460 28 1 0]
	[local78 4] = [1460 29 1 0]
	[local82 6] = [1460 30 2 1 1 0]
	[local88 4] = [1460 33 1 0]
	[local92 5] = [1460 34 1 1 0]
	[local97 4] = [1460 36 1 0]
	[local101 7] = [1460 37 1 2 1 1 0]
	[local108 4] = [1460 42 1 0]
	[local112 4] = [1460 43 1 0]
	[local116 4] = [1460 44 1 0]
	[local120 4] = [1460 45 1 0]
	[local124 5] = [1460 47 1 2 0]
	[local129 4] = [1460 49 1 0]
	[local133 4] = [1460 50 1 0]
	[local137 5] = [1460 51 1 1 0]
	[local142 8] = [1460 53 1 2 1 1 2 0]
	[local150 8] = [1460 58 1 2 1 2 1 0]
	[local158 7] = [1460 63 1 2 1 3 0]
	[local165 12] = [1460 67 1 2 1 2 1 2 1 2 1 0]
	[local177 13] = [1460 76 1 2 1 1 1 2 1 2 1 1 0]
	[local190 5] = [1460 113 1 1 0]
	[local195 4] = [1460 115 1 0]
	[local199 4] = [1460 116 1 0]
	[local203 5] = [1460 123 1 1 0]
	[local208 5] = [1460 125 2 1 0]
	[local213 4] = [1460 127 1 0]
	[local217 4] = [1460 129 1 0]
	[local221 4] = [1460 130 1 0]
	[local225 5] = [1460 144 2 1 0]
	[local230 6] = [1460 146 2 1 1 0]
	[local236 5] = [1460 149 2 1 0]
	[local241 6] = [1460 151 2 1 1 0]
	[local247 8] = [1460 154 2 1 1 2 1 0]
	[local255 6] = [1460 159 2 2 1 0]
	[local261 8] = [1460 162 2 2 1 1 1 0]
	[local269 4] = [1460 184 1 0]
	[local273 4] = [1460 185 1 0]
	[local277 5] = [1460 186 1 2 0]
	[local282 7] = [1460 173 1 2 3 1 0]
	[local289 5] = [1460 136 1 1 0]
	[local294 4] = [1460 138 1 0]
	[local298 7] = [1460 169 1 1 2 1 0]
	[local305 5] = [1460 182 1 1 0]
	[local310 5] = [1460 177 1 1 0]
	[local315 4] = [1460 197 1 0]
	[local319 6] = [1460 199 1 1 1 0]
	[local325 6] = [1460 202 1 1 1 0]
	[local331 4] = [1460 122 1 0]
	[local335 6] = [1460 192 1 2 1 0]
	[local341 5] = [1460 195 1 2 0]
	[local346 5] = [1460 190 1 1 0]
	local351
	local352
	local353
	local354
	[local355 5] = [282 100 279 105 -32768]
	local360 = 12
	local361
	local362
	[local363 8] = [237 112 227 112 224 101 233 100]
)

(procedure (localproc_0 param1)
	((View new:) view: 435 loop: 5 x: 292 y: 121 init:)
	(param1 register: (ScriptID 452 1)) ; aMonk
	((param1 register:) view: 435 loop: 4 x: 248 y: 115 init:)
	((View new:) view: 435 loop: 0 x: 222 y: 129 init:)
	((gCurRoom script:) next: param1)
)

(instance rm460 of StdRoom
	(properties
		picture 460
		east 450
		south 450
		west 450
	)

	(method (init)
		(HandsOff)
		(if (IsFlag 212)
			(SetFlag 213)
		)
		(cond
			((== gPrevRoomNum 450)
				(self setScript: comeIn)
				(super init: 0 1)
				(if (IsFlag 29)
					(gFeatures add: tunnel)
				)
			)
			((or (== gDisguiseNum 3) (== gDisguiseNum 2)) ; jewler (rouge), jewler (no rouge)
				(self setScript: sell)
				(super init: 1)
			)
			((== gDisguiseNum 6) ; fens monk
				(self setScript: deliver)
				(super init: 1)
			)
			(else
				(self setScript: tunnelExit)
				(super init: 1)
			)
		)
		(if (!= gPrevRoomNum 450)
			(gRgnMusic number: 455 loop: -1 play:)
		)
		(cond
			((!= gDisguiseNum 5) 0) ; abbey monk
			((IsFlag 125)
				(localproc_0 betterLeave)
			)
			((IsFlag 117)
				(abbot loop: 2 cel: 4)
				(= local352 2)
			)
			((IsFlag 33)
				(localproc_0 mad)
			)
			((and (== ((Inv at: 11) owner:) gEgo) (IsFlag 31)) ; cask
				((gCurRoom script:) next: drinkingMatch)
			)
			((IsFlag 32)
				(localproc_0 frock)
			)
			((IsFlag 30)
				((gCurRoom script:) next: warn)
			)
		)
		(fire init: setCycle: Fwd)
		(fireSound play:)
		(tapestry init:)
		(tables init:)
		(walls init:)
		(lChairs init:)
		(rChairs init:)
		(windows init:)
		(abbotsChair init:)
		(arthur init:)
		(if (!= gDisguiseNum 0) ; outlaw
			(abbot init:)
			(if (not (IsFlag 117))
				(abbot setCycle: Fwd)
			)
			(gAddToPics add: chair doit:)
			(chrPoly points: @local363)
			(chair onMeCheck: chrPoly)
			(gFeatures add: chair)
			(rMug init:)
			(if (!= gDisguiseNum 5) ; abbey monk
				(rMug addToPic:)
			)
			(if (== ((Inv at: 11) owner:) gCurRoomNum) ; cask
				(caskV init:)
				(if (!= gDisguiseNum 5) ; abbey monk
					(caskV addToPic:)
				)
			)
			(abbotsChair lookStr: 106)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 122 122 209 122 150 176 122 180 56 175 40 166
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 225 118 251 118 251 126 256 118 271 119 314 129 278 186 180 182 160 175
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 99 138 99 111 109 113 121 74 139 39 138 0 156
					yourself:
				)
		)
		(gEgo actions: (ScriptID 452 3)) ; noBlow
	)

	(method (doit &tmp temp0)
		(if (and (not script) (& (gEgo onControl: 1) $4000))
			(gEgo edgeHit: EDGE_RIGHT)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 852)
	)
)

(instance comeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo x: 320 y: 170 setMotion: MoveTo 299 170 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance tunnelExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 29)
				(gEgo
					view: (if (!= gDisguiseNum 0) 28 else 9) ; outlaw
					posn: 183 99
					loop: (if (!= gDisguiseNum 0) 5 else 0) ; outlaw
					cel: 0
					cycleSpeed: 6
					setCycle: End
				)
				(tunnel init: setCycle: End self)
			)
			(1
				(tapestrySound play:)
				(= cycles 2)
			)
			(2
				(tunnel dispose:)
				(NormalEgo 4)
				(= cycles 2)
			)
			(3
				(gFeatures addToFront: tunnel)
				(tunnel signal: 16384)
				(if (or (!= gDisguiseNum 0) (IsFlag 192)) ; outlaw
					(= cycles 1)
				else
					(Say 1460 86 self) ; "As I hoped, the place is empty. The Abbot and his scabrous toadies will all be in the Witch's Court to watch Marian's execution."
					(SetFlag 192)
				)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance leave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== local353 1)
					(gEgo
						posn: 251 126
						cycleSpeed: 10
						setLoop: 9
						setCel: 7
						setPri: 8
						signal: (| (gEgo signal:) $4000)
						setCycle: Beg self
					)
				else
					(self cue:)
				)
			)
			(1
				(gEgo
					view: 23
					setCycle: StopWalk 24
					loop: 0
					setMotion: PolyPath 183 99 self
				)
			)
			(2
				(gEgo
					view: (if (!= gDisguiseNum 0) 28 else 9) ; outlaw
					loop: (if (!= gDisguiseNum 0) 6 else 1) ; outlaw
					cel: 0
					cycleSpeed: 6
					setCycle: End
				)
				(tunnel init: cel: 0 setCycle: End self)
			)
			(3
				(tapestrySound play:)
				(= cycles 2)
			)
			(4
				(gEgo dispose:)
				(tunnel dispose:)
				(gGame setSpeed: global141)
				(= cycles 2)
			)
			(5
				(gCurRoom newRoom: 561) ; tunnel2
			)
		)
	)
)

(instance abbot of Actor
	(properties
		x 269
		y 132
		z 18
		view 432
		loop 1
		priority 10
		signal 18448
		cycleSpeed 70
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch local352
					(0
						(if (IsFlag 30)
							(Say 1460 88) ; "He looks thirsty and impatient."
						else
							(Say 1460 87) ; "The Abbot is completely absorbed over a small, wooden box. He seems to be doing something to the lid."
						)
					)
					(1
						(Say 1460 89) ; "He has a malicious glitter in his eyes. He hopes to drink me under the table and shame me."
					)
					(2
						(Say 1460 90) ; "Completely cupshotten."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(3 ; Do
				(switch local352
					(0
						(self setScript: tapBefore)
					)
					(1
						(Converse @local199 @local1) ; "Keep your hands on your mug where they belong, Brother."
					)
					(2
						(if (IsFlag 86)
							(Say 1460 120) ; "He has nothing else that I want."
						else
							(gCurRoom setScript: robAbbot)
						)
					)
				)
			)
			(5 ; Talk
				(switch local352
					(0
						(if (IsFlag 30)
							(Converse @local230 @local1 9) ; "I was wondering--"
						else
							(self setScript: talkBefore)
						)
					)
					(1
						(cond
							((> local351 4)
								(super doVerb: theVerb invItem)
							)
							(
								(and
									(or
										(drinkingMatch seconds:)
										(drinkingMatch cycles:)
									)
									(not (drinkingMatch script:))
								)
								(drinkingMatch
									setScript: prodAbbot drinkingMatch
								)
							)
							(else
								(Say 1460 205 1) ; "I should wait until he's stopped drinking to talk to him."
							)
						)
					)
					(2
						(Say 1460 167) ; "I won't learn much from his drunken snores."
					)
				)
			)
			(4 ; Inventory
				(if (== invItem 0) ; bucks
					(switch local352
						(1
							(gMoney doit:)
							(+= local360 (gPennies taken:))
							(+= local361 (gHapennies taken:))
							(+= local362 (gFarthings taken:))
							((gTheIconBar at: 0) message: 1)
							(return)
						)
						(2
							(Say 1460 168 1) ; "It's supposed to be 'rob from the rich, give to the poor', not the other way around."
							(return)
						)
					)
				)
				(if (== local352 2)
					(super doVerb: theVerb invItem)
					(return)
				)
				(giveIt register: invItem)
				(switch invItem
					(0) ; bucks
					(2) ; halfHeart
					(14) ; amethyst
					(11) ; cask
					(18) ; waterRing
					(13 ; robes
						(if (gCurRoom script:)
							(super doVerb: theVerb invItem)
							(return)
						)
					)
					(else
						(super doVerb: theVerb invItem)
						(return)
					)
				)
				(if (== local352 1)
					(giveIt cue:)
					(return)
				)
				(gEgo setMotion: PolyPath 251 126 giveIt)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance giveIt of Script
	(properties)

	(method (cue)
		(switch register
			(0
				(gMoney doit:)
				(+= local360 (gPennies taken:))
				(+= local361 (gHapennies taken:))
				(+= local362 (gFarthings taken:))
				(Converse @local346 @local1) ; "I'm glad to see that you haven't forgotten your Vows of Poverty."
				(return)
			)
			(2
				(SetScore -200)
				(Converse @local298 @local1 999) ; "This is an exquisite piece of emerald and unusually shaped. A generous gift, Brother."
				(gEgo put: 2 gCurRoomNum) ; halfHeart
			)
			(14
				(SetScore -25)
				(Converse @local305 @local1) ; "Now this is a nice chunk of amethyst. Much obliged."
				(gEgo put: 14 gCurRoomNum) ; amethyst
			)
			(11
				(Converse @local310 @local1) ; "I don't want the bloody thing back, it's empty."
			)
			(13
				(gCurRoom setScript: giveRobes)
			)
			(18
				(gCurRoom setScript: waterDeath 0 @local315)
			)
		)
	)
)

(instance waterDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse register @local1 0 self)
			)
			(1
				(= gDeathNum (if (== register @local315) 18 else 17))
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance giveRobes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== global115 1)
					(gCurRoom setScript: waterDeath 0 @local325)
					(return)
				)
				(Converse @local335 @local1 9 self) ; "What are you doing with those? They're still damp."
			)
			(1
				(gEgo setMotion: PolyPath 243 114 self)
				((= register ((ScriptID 452 1) new:)) ; aMonk
					init:
					setCycle: Walk
					posn: 316 106
					setMotion: MoveTo 289 105 self
				)
			)
			(2)
			(3
				(Face gEgo abbot self)
			)
			(4
				(Converse @local341 @local1 10) ; "Take these robes and see they're properly washed."
				(register setMotion: MoveTo 256 122 self)
			)
			(5
				(register loop: 2)
				(abbot loop: 3 cel: 0 cycleSpeed: 12 setCycle: End self)
			)
			(6
				(gEgo put: 13 456) ; robes
				(register setMotion: MoveTo 316 120 goAway)
				(goAway register: register)
				(abbot setCycle: Beg self)
			)
			(7
				(abbot loop: 1 cycleSpeed: 70 setCycle: Fwd)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance caskV of View
	(properties
		x 252
		y 131
		z 7
		view 28
		loop 10
		cel 1
		priority 11
		signal 16657
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(cond
					((not (IsFlag 30))
						(Say 1460 100) ; "He has a small cask from which to fill his mug."
					)
					((== local352 0)
						(Say 1460 101) ; "It's of no use to the Abbot now that it's empty."
					)
					(else
						(Say 1460 102) ; "The Innkeeper does brew a truly fine ale."
					)
				)
			)
			(3 ; Do
				(switch local352
					(0
						(if (IsFlag 30)
							(gCurRoom setScript: grabCask)
						else
							(gCurRoom setScript: tryToGrabCask)
						)
					)
					(1
						(if local354
							(drinkingMatch seconds: 0 cue:)
						else
							(super doVerb: theVerb invItem &rest)
						)
					)
					(2
						(gCurRoom setScript: grabCask)
					)
				)
			)
			(4 ; Inventory
				(if (== invItem 14) ; amethyst
					(Say 1460 189 1) ; "I can think of no way to get the amethyst inside the cask."
				else
					(super doVerb: theVerb invItem)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance chair of PicView
	(properties
		x 235
		y 131
		lookStr 105 ; "The chairs are well made to match the table."
		view 460
		loop 2
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (not local353)
					(gCurRoom setScript: tryToSit)
				else
					(super doVerb: theVerb invItem)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance chrPoly of Polygon
	(properties
		size 4
	)
)

(instance aMug of View ; UNUSED
	(properties
		view 28
	)
)

(instance rMug of View
	(properties
		x 244
		y 142
		z 26
		view 28
		loop 10
		priority 10
		signal 16656
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch local352
					(0
						(Say 1460 95) ; "'Tis a cup."
					)
					(1
						(Say 1460 96) ; "It's empty again."
					)
					(2
						(if local353
							(gCurRoom setScript: lInRMug)
						else
							(Say 1460 99) ; "The mug is empty."
						)
					)
				)
			)
			(3 ; Do
				(switch local352
					(0
						(if (IsFlag 30)
							(Converse @local294 @local1) ; "Get back here quickly with that ale and I MIGHT consider giving you a drop."
						else
							(gCurRoom setScript: mugBefore)
						)
					)
					(1
						(if local354
							(drinkingMatch seconds: 0 cue:)
						else
							(super doVerb: theVerb invItem &rest)
						)
					)
					(2
						(Say 1460 139) ; "Enough ale for me! I may not be drunk, but my bladder will feel the weight all the same."
					)
				)
			)
			(4 ; Inventory
				(if (== invItem 14) ; amethyst
					(if (== local352 1)
						(gEgo put: 14 rMug) ; amethyst
						(drinkingMatch setScript: dropInDrink drinkingMatch)
						(SetScore 50)
					else
						(Say 1460 188 1) ; "If I were to drink from that mug, then I might think about using the amethyst, but it's too valuable to waste."
					)
				else
					(super doVerb: theVerb invItem)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance tunnel of Prop
	(properties
		x 182
		y 98
		nsTop 44
		nsLeft 167
		nsBottom 99
		nsRight 198
		view 460
		loop 1
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(if (and (== theVerb 3) (!= local352 1)) ; Do
			(gCurRoom setScript: leave)
		else
			(tapestry doVerb: theVerb invItem)
		)
	)
)

(instance fire of Prop
	(properties
		x 75
		y 120
		lookStr 109 ; "Clearly, 'tis a fireplace."
		view 460
		signal 16384
	)
)

(instance tapestry of Feature
	(properties
		nsTop 10
		nsLeft 173
		nsBottom 98
		nsRight 302
		lookStr 107 ; "The large, richly woven tapestry covers nearly the entire back wall."
	)

	(method (doVerb theVerb invItem)
		(if (or (!= theVerb 3) (gCurRoom script:)) ; Do
			(super doVerb: theVerb invItem)
		else
			(gCurRoom setScript: feelTap)
		)
	)
)

(instance feelTap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 224 101 self)
			)
			(1
				(NormalEgo 7)
				(Say 1460 121 self) ; "It's extraordinarily thick and heavy."
				(if
					(or
						(not (IsFlag 30))
						(== local352 2)
						(not (gCast contains: abbot))
					)
					(++ state)
				)
			)
			(2
				(Converse @local331 @local1 0 self) ; "Quit feeling the tapestry and do as I instructed you."
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance tables of Feature
	(properties
		onMeCheck 2
		lookStr 104 ; "The tables are built of fine oak."
	)
)

(instance walls of Feature
	(properties
		onMeCheck 1
		lookStr 103 ; "'Tis a refectory, well-built of stone."
	)
)

(instance lChairs of Feature
	(properties
		y 126
		onMeCheck 4
		lookStr 105 ; "The chairs are well made to match the table."
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cond
					((!= local352 0)
						(Say 1460 141 1) ; "I've no time to waste with frivolous chair testing."
					)
					((== gDisguiseNum 0) ; outlaw
						(Say 1460 142 1) ; "This is no time to sit around."
					)
					(else
						(Say 1460 140 1) ; "Why be half-bold? If I'm going to sit, I should sit at the Abbot's right hand, the better to get a look at that box on which he's working."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance rChairs of Feature
	(properties
		y 172
		onMeCheck 64
	)

	(method (doVerb theVerb invItem)
		(lChairs doVerb: theVerb invItem)
	)
)

(instance windows of Feature
	(properties
		onMeCheck 8
		lookStr 108 ; "Aye, 'tis a window."
	)
)

(instance abbotsChair of Feature
	(properties
		onMeCheck 16
		lookStr 143 ; "I'm glad to see that chair empty, though his absence here doesn't bode well for Marian."
	)
)

(instance arthur of Feature
	(properties
		y 99
		onMeCheck 32
	)

	(method (doVerb theVerb invItem)
		(if (and (== theVerb 4) (== invItem 2) (not (gCurRoom script:))) ; Inventory, halfHeart
			(Converse 3 @local282 @local19 0 @local22 3 @local25 2) ; "Look, it's Camelot."
		else
			(tapestry doVerb: theVerb invItem)
		)
	)
)

(instance tryToSit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 251 126 self)
			)
			(1
				(gEgo
					view: 28
					cycleSpeed: 10
					loop: 9
					cel: 0
					setPri: 9
					setCycle: End self
				)
			)
			(2
				(if (== local352 2)
					(= local353 1)
					(gEgo
						setLoop: 0
						cel: 1
						setPri: 10
						posn: 243 113
						setScript: waitToStand
					)
					(rMug dispose:)
					(= cycles 2)
					(return)
				)
				(if (== global115 1)
					(self setScript: waterDeath 0 @local319)
					(return)
				)
				(Converse
					(if (IsFlag 30) @local213 else @local203)
					@local1
					0
					self
				)
			)
			(3
				(if (== local352 2)
					(rMug signal: 16657)
					(gFeatures add: rMug)
					(self dispose:)
					(HandsOn)
					(return)
				)
				(gEgo setCycle: Beg self)
				(if (IsFlag 30)
					(+= state 2)
				)
			)
			(4
				(Converse @local208 @local1 9 self 0) ; "Pardon me, Your Grace. I can't imagine what possessed me."
			)
			(5
				(Converse @local28 @local1 9 self) ; "This bloody puzzle box is driving me mad and I'm down to my last mug of ale."
				(SetFlag 30)
			)
			(6
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance tapBefore of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 245 131 self)
			)
			(1
				(if (== global115 1)
					(self setScript: waterDeath 0 @local319)
					(return)
				)
				(if (IsFlag 30)
					(Converse @local195 @local1 0 self) ; "What are you waiting for? Do as I told you."
					(++ state)
				else
					(Converse @local190 @local1 9 self 0) ; "Eh, what? Don't tap me like that! You startled me half out of my wits."
				)
			)
			(2
				(Converse @local28 @local1 9 self) ; "This bloody puzzle box is driving me mad and I'm down to my last mug of ale."
				(SetFlag 30)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance mugBefore of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 245 131 self)
			)
			(1
				(if (== global115 1)
					(self setScript: waterDeath 0 @local319)
					(return)
				)
				(Converse @local289 @local1 9 self 0) ; "Eh? Who--? You startled me."
			)
			(2
				(Converse @local28 @local1 9 self) ; "This bloody puzzle box is driving me mad and I'm down to my last mug of ale."
			)
			(3
				(HandsOn)
				(SetFlag 30)
				(self dispose:)
			)
		)
	)
)

(instance talkBefore of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Converse @local225 @local1 9 self 0) ; "Could I be of service to you, Your Grace?"
			)
			(1
				(Converse @local28 @local1 9) ; "This bloody puzzle box is driving me mad and I'm down to my last mug of ale."
				(SetFlag 30)
				(self dispose:)
			)
		)
	)
)

(instance tryToGrabCask of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 245 131 self)
			)
			(1
				(if (== global115 1)
					(self setScript: waterDeath 0 @local319)
					(return)
				)
				(Converse @local217 @local1 0 self) ; "Hold on there! Let me make sure it's empty first."
			)
			(2
				(abbot setCycle: 0 loop: 0 cel: 4)
				(= seconds 3)
			)
			(3
				(abbot setCel: 3)
				(= cycles 1)
			)
			(4
				(Converse @local221 @local1 9 self 0) ; "Not a bloody drop left."
			)
			(5
				(Converse @local28 @local1 9 self) ; "This bloody puzzle box is driving me mad and I'm down to my last mug of ale."
			)
			(6
				(abbot loop: 1 setCycle: Fwd)
				(SetFlag 30)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance grabCask of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 245 131 self)
			)
			(1
				(if (== global115 1)
					(self setScript: waterDeath 0 @local319)
					(return)
				)
				(gEgo view: 28 setLoop: 8)
				(gEgo
					cel: (gEgo lastCel:)
					cycleSpeed: 10
					setCycle: Beg self
				)
				(caskV dispose:)
			)
			(2
				(gEgo cycleSpeed: (gEgo moveSpeed:) get: 11) ; cask
				(if (== local352 2)
					(Say 1460 131 self) ; "This empty cask may yet serve me again."
				else
					(SetScore 25)
					(= cycles 1)
				)
				(NormalEgo)
				((gEgo looper:) doit:)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance drinkingMatch of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 3)
			)
			(1
				(Converse @local67 @local1 9 self) ; "Do you have my ale?"
			)
			(2
				(gEgo setMotion: PolyPath 251 126 self)
			)
			(3
				(gEgo
					view: 28
					setLoop: 8
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(4
				(caskV init:)
				(gEgo put: 11 gCurRoomNum cel: 0) ; cask
				(SetFlag 207)
				(= cycles 1)
			)
			(5
				(if (== global115 1)
					(gCurRoom setScript: waterDeath 0 @local325)
					(return)
				)
				(Converse @local74 @local1 9 self 0) ; "You're slow, but at least you did the task."
			)
			(6
				(= notKilled 1)
				(Converse @local78 @local1 9 self 0) ; "I've a mind to put this ale to the test. Have a seat and drink with me, Brother."
			)
			(7
				(if (AyeOrNay)
					(Converse @local97 @local1 9 self) ; "Then be seated and we'll see how your stomach fares against mine."
				else
					(Converse @local82 @local1 9) ; "Nay, I think not, if it please Your Grace."
					(NormalEgo)
					(gEgo
						cycleSpeed: (gEgo moveSpeed:)
						setMotion: PolyPath 150 200 self
					)
					(SetFlag 33)
					(self dispose:)
				)
			)
			(8
				(= local353 1)
				(gEgo loop: 9 cel: 0 setPri: 9 setCycle: End)
				(= ticks 20)
			)
			(9
				(gEgoHead view: 28)
				((= register ((ScriptID 452 1) new:)) ; aMonk
					init:
					setCycle: Walk
					posn: 316 106
					setMotion: MoveTo 289 105 self
				)
			)
			(10
				(Converse @local101 @local1 10) ; "Brother Bruce, is that you?"
				(register setMotion: MoveTo 256 122 self)
			)
			(11
				(abbot cycleSpeed: 12 loop: 3 cel: 0 setCycle: End self)
			)
			(12
				((gInventory at: 12) moveTo: 470) ; puzzleBox
				(register setMotion: MoveTo 316 120 goAway)
				(goAway register: register)
				(abbot setCycle: Beg self)
			)
			(13
				(= notKilled 1)
				(Converse @local108 @local1) ; "And now, let's fill our mugs."
				(= register 0)
				(gEgo posn: 243 113 setLoop: 0 setCel: 1 setPri: 10)
				(rMug dispose:)
				(= cycles 2)
			)
			(14
				(gFeatures add: rMug)
				(= local352 1)
				(HandsOn)
				(gTheIconBar disable: 0)
				(gTheIconBar disable: 5)
				(= cycles 1)
			)
			(15
				(HandsOn)
				(gTheIconBar disable: 0)
				(gTheIconBar disable: 5)
				(abbot loop: 0 cel: 4)
				(= seconds 2)
			)
			(16
				(abbot cel: 3)
				(= ticks 12)
			)
			(17
				(if script
					(-- state)
					(return)
				)
				(rMug signal: 8)
				(gEgo setCel: 0)
				(= ticks 60)
			)
			(18
				(if (and (== register 4) (!= ((Inv at: 14) owner:) rMug)) ; amethyst
					(gCurRoom setScript: rPassOut)
				else
					(gEgo cycleSpeed: 10 setCycle: End self)
					(abbot setCycle: Beg)
					(++ register)
				)
			)
			(19
				(gEgo setCycle: CT 1 -1 self)
				(abbot setCycle: CT 3 1)
			)
			(20
				(mugSound play:)
				(rMug signal: 26897)
				(= local354 1)
				(= seconds 7)
			)
			(21
				(if script
					(-- state)
					(return)
				)
				(= local354 0)
				(HandsOff)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(if (== register 6)
					(gCurRoom setScript: aPassOut)
				else
					(Converse @local112 @local1) ; "Have another mug!"
					(-= state 7)
					(= cycles 1)
				)
			)
		)
	)
)

(instance goAway of Script
	(properties)

	(method (cue)
		(register dispose:)
	)
)

(instance dropInDrink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse 1 @local269 9 3 self) ; "That is an exceptionally fine tapestry, Your Grace, but is that a flaw I see in the center?"
			)
			(1
				(= cycles 1)
			)
			(2
				(= ticks 30)
			)
			(3
				(abbot cycleSpeed: 6 loop: 6 cel: 0 setCycle: End self)
			)
			(4
				(gEgo
					cycleSpeed: 15
					setLoop: 7
					setCel: 0
					setCycle: CT 0 1 self
				)
			)
			(5
				(plopSound play:)
				(= ticks 45)
			)
			(6
				(Converse @local273 @local1 0 self) ; "What flaw? I don't see a flaw."
			)
			(7
				(abbot setCycle: Beg self)
			)
			(8
				(= ticks 30)
			)
			(9
				(Converse @local277 @local1 9 self) ; "Must be something wrong with your eyes."
				(gEgo setLoop: 0 setCel: 1)
				(abbot loop: 0 cel: 3 cycleSpeed: 11)
			)
			(10
				(= seconds 2)
			)
			(11
				(if (or (client seconds:) (client cycles:))
					(= caller 0)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance aPassOut of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 31)
				(SetFlag 117)
				(= local352 2)
				(HandsOff)
				(Converse @local129 9 0 self) ; "Another mug, Your Grace?"
			)
			(1
				(= lastTicks (+ gTickOffset (GetTime)))
				(= ticks 20)
			)
			(2
				(abbot setLoop: 2 setCel: 0 setCycle: End self)
			)
			(3
				(mugSound play:)
				(abbot setScript: snoreScript)
				(= ticks 20)
				(= notKilled 1)
			)
			(4
				(Converse 1 @local133 @local10 3 self) ; "By my trosh...my trofsh...my...bleh...blurp...blagh..."
			)
			(5
				(Converse @local137 9) ; "Thank the Virgin for that amethyst. This truly is strong ale."
				(HandsOn)
				(gEgo setScript: waitToStand)
				(self dispose:)
			)
		)
	)
)

(instance waitToStand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= local353 0)
				(HandsOff)
				(= register (gEgo mover:))
				(gEgo mover: 0 setPri: -1 posn: 248 128 setLoop: 9)
				(gEgo
					cel: (gEgo lastCel:)
					cycleSpeed: 10
					setCycle: Beg self
				)
				(gFeatures delete: rMug)
				(rMug init:)
			)
			(2
				(gEgo
					cycleSpeed: (gEgo moveSpeed:)
					setMotion: MoveTo 251 126 self
				)
			)
			(3
				(NormalEgo 2)
				(if (and register (register isMemberOf: PolyPath))
					(gEgo
						mover: register
						setMotion:
							PolyPath
							(register finalX:)
							(register finalY:)
							(register caller:)
					)
				else
					(gEgo
						mover: register
						setMotion:
							PolyPath
							(register x:)
							(register y:)
							(register caller:)
					)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if (gEgo mover:)
			(self cue:)
		)
	)
)

(instance rPassOut of Script
	(properties)

	(method (doit)
		(if (and (not local0) (== (gEgo cel:) 3))
			(mugSound play:)
			(= local0 1)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse @local116 9 0 self) ; "'tish potent ale indeed. My head shpins....I...I...."
			)
			(1
				(gEgo cycleSpeed: 10 loop: 2 cel: 0 setCycle: End)
				((= register ((ScriptID 452 1) new:)) ; aMonk
					init:
					setCycle: Walk
					posn: 316 106
					setMotion: MoveTo 289 105 self
				)
			)
			(2
				(Converse @local120 @local1) ; "Hah. No schtum--schum--stomach f'r'ale."
				(register setMotion: MoveTo 255 130 self)
				(abbot setCycle: Beg self)
			)
			(3
				(abbot setCycle: CT 3 1)
			)
			(4
				(register view: 28 setLoop: 4 cycleSpeed: 1 setCycle: End self)
				(gEgo loop: 3 cel: 0 setCycle: End self)
			)
			(5)
			(6
				(Converse @local124 10 @local1 self) ; "Abbot! I know this face! It's the outlaw, Robin Hood!"
			)
			(7
				(= gDeathNum 16)
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance prodAbbot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch local351
					(0
						(Converse @local236 @local1 9 self) ; "We should toast--to long life for King Richard."
					)
					(1
						(Converse @local241 @local1 9 self) ; "You're certain Prince John will succeed in preventing the King's ransom from being paid?"
					)
					(2
						(Converse @local247 @local1 9 self) ; "50,000 marks is no small sum. He must guard it well."
					)
					(3
						(Converse @local255 @local1 9 self) ; "If I were the Prince, I'd never dare to send such a treasure through Sherwood Forest."
					)
					(4
						(Converse @local261 @local1 9 self) ; "Still, you could send the Baron LeFevre a warning about the outlaws."
						(SetScore 25)
					)
				)
				(++ local351)
			)
			(1
				(= seconds 2)
			)
			(2
				(if (or (client seconds:) (client cycles:))
					(= caller 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance robAbbot of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Say 1460 117 self) ; "Hmmm...the contents of the Abbot's purse would make a worthwhile addition to mine."
			)
			(1
				(if local353
					(+= state 2)
				)
				(if (and (== local360 12) (not local361) (not local362))
					(= cycles 1)
				)
				(if (== ((Inv at: 2) owner:) gCurRoomNum) ; halfHeart
					(gEgo get: 2) ; halfHeart
					(= cycles 0)
				)
				(if (not cycles)
					(Say 1460 118 self) ; "And I'll be glad to recover what I so rashly gave him before!"
				)
			)
			(2
				(gEgo setMotion: PolyPath 251 126 self)
			)
			(3
				(gEgo
					view: 28
					cycleSpeed: 10
					loop: 9
					cel: 0
					setPri: 9
					setCycle: End self
				)
			)
			(4
				(gEgo posn: 243 113 setPri: 10 setLoop: 1 setCel: 0)
				(rMug dispose:)
				(= cycles 2)
			)
			(5
				(gEgo setCycle: CT 0 1 self)
				(rMug signal: 16657)
				(gFeatures add: rMug)
			)
			(6
				(SetScore 10 86)
				(gPennies put: local360)
				(gHapennies put: local361)
				(gFarthings put: local362)
				(Say 1460 119 self) ; "By the time he notices his purse is empty, I should be far from here."
			)
			(7
				(if (not local353)
					(= local353 1)
					(gEgo setScript: waitToStand)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lInRMug of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo loop: 0 cel: 2)
				(= ticks 30)
			)
			(1
				(Say 1460 97 self) ; "By the Blessed Lady, there's not a trace of the amethyst left! It's entirely dissolved."
			)
			(2
				(Say 1460 98 self) ; "That really IS potent ale!"
			)
			(3
				(gEgo cel: 1)
				(self dispose:)
			)
		)
	)
)

(instance sell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NormalEgo 0)
				((= register (ScriptID 452 1)) ; aMonk
					ignoreActors: 1
					init:
					setCycle: Walk
					posn: 316 106
					setMotion: PPath @local355 self
				)
				(gEgo posn: 326 106 setMotion: MoveTo 289 131 self)
			)
			(1)
			(2
				(if (== global115 1)
					(gCurRoom setScript: waterDeath 0 @local319)
					(return)
				)
				(if (== gDisguiseNum 3) ; jewler (rouge)
					(Converse @local177 @local1 5 self) ; "Magnificent jewels and very fine goldsmithing! I commend you upon your work."
				else
					(Converse @local177 @local1 4 self) ; "Magnificent jewels and very fine goldsmithing! I commend you upon your work."
				)
			)
			(3
				(register setMotion: MoveTo 326 106 self)
				(gEgo setMotion: MoveTo 316 106)
			)
			(4
				(gCurRoom newRoom: 440)
			)
		)
	)
)

(instance deliver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NormalEgo 0)
				((= register (ScriptID 452 1)) ; aMonk
					ignoreActors: 1
					init:
					setCycle: Walk
					posn: 316 106
					setMotion: PPath @local355 self
				)
				(gEgo x: 326 y: 106 setMotion: MoveTo 289 131 self)
			)
			(1)
			(2
				(if (== global115 1)
					(gCurRoom setScript: waterDeath 0 @local319)
					(return)
				)
				(Converse @local165 @local1 8 self) ; "What can I do for you, Brother?"
			)
			(3
				(register setMotion: MoveTo 326 106 self)
				(gEgo setMotion: MoveTo 316 106)
			)
			(4
				(gCurRoom newRoom: 440)
			)
		)
	)
)

(instance frock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== ((Inv at: 11) owner:) gEgo) ; cask
					(Converse @local54 @local1 10 self) ; "Does he have a full cask with him?"
				else
					(Converse @local60 @local1 999 self) ; "You pig's pizzle! Where have you been? I could've brewed my own ale by now!"
				)
			)
			(1
				(register setMotion: PolyPath (gEgo x:) (gEgo y:))
				(= seconds 2)
			)
			(2
				(= gDeathNum 15)
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance warn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 32)
				(if (== ((Inv at: 11) owner:) gEgo) ; cask
					(Converse @local48 @local1 999 self) ; "Well, where's my ale?"
				else
					(Converse @local42 @local1 999 self) ; "Where's my ale?"
					(++ state)
				)
			)
			(1
				(gEgo setMotion: PolyPath 321 190 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance betterLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 169 102 self)
			)
			(1
				(Face gEgo abbot self)
				(if (IsFlag 114)
					(+= state 2)
				)
			)
			(2
				(if
					(or
						(== ((Inv at: 12) owner:) gEgo) ; puzzleBox
						(== ((Inv at: 10) owner:) gEgo) ; fireRing
					)
					(Converse @local142 @local1 10 self) ; "I'll not rest until that box is found, do you hear me?!"
				else
					(Converse @local150 @local1 10 self) ; "I won't tolerate this petty thievery. I want those robes found. Do you think wool grows on trees?"
				)
			)
			(3
				(HandsOn)
				(gTheIconBar disable: 5)
				(tunnel actions: escape)
				(= seconds 4)
			)
			(4
				(HandsOff)
				(Face register gEgo)
				(= cycles 1)
			)
			(5
				(Converse 3 @local158 10 1 999 0 @local1 3 self) ; "Hold fast there, Brother. What were you doing in the tunnels?"
			)
			(6
				(register setMotion: PolyPath (gEgo x:) (gEgo y:))
				(= seconds 2)
			)
			(7
				(= gDeathNum 17)
				(gCurRoom newRoom: 170) ; robinDeath
			)
		)
	)
)

(instance escape of SpecialDoVerb
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(SetFlag 114)
			(betterLeave dispose:)
		)
		(return 0)
	)
)

(instance mad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Converse
					(if (IsFlag 112)
						@local92
					else
						(+= state 2)
						@local88
					)
					@local1
					0
					self
				)
			)
			(1
				(register setMotion: PolyPath (gEgo x:) (gEgo y:))
				(= seconds 2)
			)
			(2
				(= gDeathNum 15)
				(gCurRoom newRoom: 170) ; robinDeath
			)
			(3
				(gEgo setMotion: MoveTo 321 190 self)
			)
			(4
				(SetFlag 112)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance snoreScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 10))
			)
			(1
				(snoreSound play:)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance fireSound of Sound
	(properties
		flags 1
		number 537
		loop -1
	)
)

(instance mugSound of Sound
	(properties
		flags 1
		number 457
	)
)

(instance tapestrySound of Sound
	(properties
		flags 1
		number 458
	)
)

(instance snoreSound of Sound
	(properties
		flags 1
		number 535
	)
)

(instance plopSound of Sound
	(properties
		flags 1
		number 22
	)
)

