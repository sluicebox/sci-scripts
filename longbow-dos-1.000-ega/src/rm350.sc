;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 350)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use RTEyeCycle)
(use PolyPath)
(use Polygon)
(use Blk)
(use Feature)
(use MoveFwd)
(use Wander)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm350 0
)

(local
	[local0 4] = [1350 1 1 0]
	[local4 4] = [1350 41 1 0]
	[local8 4] = [1350 29 1 0]
	local12
	local13
	local14
	local15
	[local16 9] = [-1 {TAILOR WOMAN} 6 0 0 0 0 0 0]
	[local25 7] = [1350 45 2 1 1 2 0]
)

(instance rm350 of Rm
	(properties
		picture 350
		style 100
		horizon 110
		north 260
		south 260
	)

	(method (init)
		(super init:)
		(Load rsSCRIPT 939)
		(Load rsVIEW 182)
		(cond
			((== gDay 3)
				(gAddToPics
					add: tailorWoman day9Door
					eachElementDo: #init
					eachElementDo: #approachVerbs 3 4
					doit:
				)
				(gAddToPics
					add: lobbsCover tailorCover
					eachElementDo: #init
					doit:
				)
			)
			((<= 5 gDay 7)
				(lobbsCover cel: 0)
				(gAddToPics
					add: tailorWoman lobbsDoor day9Door
					eachElementDo: #init
					eachElementDo: #approachVerbs 3 4
					doit:
				)
				(gAddToPics
					add: tailorCover lobbsCover
					eachElementDo: #init
					doit:
				)
			)
			((== gDay 8)
				(tailorCover cel: 1 x: 94 y: 78)
				(lobbsCover cel: 0)
				(gAddToPics
					add: tailorDoor lobbsDoor day9Door
					eachElementDo: #init
					eachElementDo: #approachVerbs 3
					doit:
				)
				(gAddToPics
					add: tailorCover lobbsCover
					eachElementDo: #init
					doit:
				)
			)
			((and (== gDay 9) (not (== gDisguiseNum 4))) ; yeoman
				(tailorCover loop: 3 cel: 1 x: 96 y: 78)
				(swineMan init: signal: 1)
				(pig1 init:)
				(pig2 init:)
				(pig2 setScript: pigScript)
				(gAddToPics
					add: tailorDoor
					eachElementDo: #init
					eachElementDo: #approachVerbs 3
					doit:
				)
				(gAddToPics
					add: tailorCover lobbsCover
					eachElementDo: #init
					doit:
				)
			)
			(else
				(tailorCover cel: 1 x: 96 y: 78)
				(lobbsCover cel: 0)
				(gAddToPics
					add: day9Door lobbsDoor tailorDoor
					eachElementDo: #init
					eachElementDo: #approachVerbs 3
					doit:
				)
				(gAddToPics
					add: tailorCover lobbsCover
					eachElementDo: #init
					doit:
				)
			)
		)
		(AddToFeatures bucket leftHut middleHut rightHut tailorHut lobbsHut)
		(chicken init:)
		(cat init: setScript: catChickenScript)
		(if (and (== gDay 9) (not (== gDisguiseNum 4))) ; yeoman
			(flyCage init:)
			(fly
				x: 120
				y: 130
				setStep: 10 8
				init:
				observeBlocks: flyCage
				setMotion: Wander 10
			)
			(fly2
				x: 125
				y: 130
				setStep: 10 8
				init:
				observeBlocks: flyCage
				setMotion: Wander 10
			)
			(if
				(and
					(== (Random 1 9) 4)
					(not (IsFlag 209))
					(not (== gDisguiseNum 4)) ; yeoman
				)
				(SetFlag 209)
				(bigOlFly init: setScript: getBuggy)
			)
		)
		(NormalEgo)
		(if
			(and
				(== gPrevRoomNum 360)
				(not (gCurRoom script:))
				(not (gEgo script:))
			)
			(gEgo posn: 251 145 loop: 5 init:)
		else
			(gEgo posn: 160 180 init:)
		)
		(gEgo setScript: comeIn)
		(if (or (OneOf gDay 5 6 7) (== gDay 8) (== gDay 4))
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 197 89 194 114 188 116 147 129 84 154 78 162 66 173 51 189 0 189 0 58 177 21
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 142 319 189 285 189 285 177 286 168 274 165 254 145 231 142 215 144 197 135 187 121 197 118 202 80
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 284 189 287 187 288 177 274 166 274 140 319 142 319 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 262 146 235 147 220 147 197 135 187 121 196 118 200 97 202 16 319 73 319 95 262 116
						yourself:
					)
			)
			(if (== gDay 9)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 197 89 194 114 188 116 147 129 151 146 84 154 77 155 64 170 51 189 0 189 0 58 177 21
							yourself:
						)
				)
			else
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 197 89 194 114 188 116 147 129 84 154 77 155 64 170 51 189 0 189 0 58 177 21
							yourself:
						)
				)
			)
		)
		(if (gAddToPics contains: lobbsDoor)
			(gEgo observeControl: 4)
		)
	)

	(method (doit)
		(if (not (pig1 script:))
			(pig1 setScript: pigCycle)
		)
		(cond
			((gEgo script:) 0)
			(
				(and
					(== gDay 3)
					(& (gEgo onControl: 1) $0004)
					(== gDisguiseNum 1) ; beggar
				)
				(gEgo setScript: enterShop)
			)
			(
				(and
					(== gDay 9)
					(& (gEgo onControl: 1) $0004)
					(or (== gDisguiseNum 2) (== gDisguiseNum 3)) ; jewler (no rouge), jewler (rouge)
				)
				(gEgo setScript: enterShop)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(if (pig1 script:)
			(pig1 setScript: 0)
		)
		(fly setMotion: 0)
		(fly2 setMotion: 0)
		(flyCage dispose:)
		(DisposeScript 949)
		(DisposeScript 970)
		(DisposeScript 939)
		(super dispose:)
	)
)

(instance lobbsHut of Feature
	(properties
		x 316
		y 28
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (or (== gDay 3) (== gDay 9))
					(if (== gDisguiseNum 4) ; yeoman
						(Say 1350 56 1) ; "It would seem my friend Lobb is gone for the moment."
					else
						(Say 1350 62 1) ; "The shop is open. I can glimpse a workbench and leather tools within."
					)
				else
					(Say 1350 7 1) ; "Lobb's shop is closed up."
				)
			)
			(3 ; Do
				(if (== gDisguiseNum 4) ; yeoman
					(Say 1350 57 1) ; "No point knocking when Lobb is clearly gone."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 316 28 316 41 293 44 283 104 297 108 295 153 252 139 230 118 206 121 205 61 200 56 240 22
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance tailorHut of Feature
	(properties
		x 83
		y 24
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(if (OneOf gDay 3 5 6 7)
				(Say 1350 63 1) ; "It is this woman's shop and home."
			else
				(Say 1350 9 1) ; "The tailor has closed up her shop, I see."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 2 29 83 24 134 62 130 132 64 153 64 89 1 46
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance leftHut of Feature
	(properties
		x 61
		y 50
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1350 10 1) ; "They are ordinary peasants' huts, thatched with straw."
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 1 50 61 90 57 171 36 188 1 188
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance middleHut of Feature
	(properties
		x 84
		y 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1350 10 1) ; "They are ordinary peasants' huts, thatched with straw."
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 84 21 0 26 0 16 231 22 204 48 194 40 181 112 135 129 136 56
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance rightHut of Feature
	(properties
		x 314
		y 46
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1350 10 1) ; "They are ordinary peasants' huts, thatched with straw."
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 314 188 297 188 307 106 287 101 297 46 317 46
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance bucket of Feature
	(properties
		x 223
		y 129
		nsTop 124
		nsLeft 218
		nsBottom 134
		nsRight 229
		lookStr 11 ; "Just a bucket."
	)
)

(instance day9Door of PicView
	(properties
		x 146
		y 122
		approachX 152
		approachY 130
		lookStr 33 ; "It's a door."
		view 350
		loop 2
		priority 8
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1350 60 1) ; "The door is closed."
			)
			(3 ; Do
				(if (!= gDay 9)
					(Say 1350 61 1) ; "It seems empty and I'll not enter univited."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tailorDoor of PicView
	(properties
		x 81
		y 84
		approachX 84
		approachY 175
		view 350
		loop 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (OneOf gDay 3 5 6 7)
					(Say 1350 8 1) ; "The shop is clearly open."
				else
					(Say 1350 9 1) ; "The tailor has closed up her shop, I see."
				)
			)
			(3 ; Do
				(if
					(and
						(or (== gDay 9) (== gDay 8))
						(or (== gDisguiseNum 3) (== gDisguiseNum 2) (== gDisguiseNum 4)) ; jewler (rouge), jewler (no rouge), yeoman
					)
					(gEgo setHeading: 270)
					(Say 1350 36 1) ; "No one is home."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lobbsDoor of PicView
	(properties
		x 281
		y 152
		approachX 250
		approachY 157
		view 350
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (or (== gDay 3) (== gDay 9))
					(if (== gDisguiseNum 4) ; yeoman
						(Say 1350 56 1) ; "It would seem my friend Lobb is gone for the moment."
					else
						(Say 1350 62 1) ; "The shop is open. I can glimpse a workbench and leather tools within."
					)
				else
					(Say 1350 7 1) ; "Lobb's shop is closed up."
				)
			)
			(3 ; Do
				(cond
					((== gDay 8)
						(Say 1350 38 1) ; "Perhaps Lobb is at the Fair."
					)
					((== gDisguiseNum 4) ; yeoman
						(Say 1350 57 1) ; "No point knocking when Lobb is clearly gone."
					)
					(
						(and
							(OneOf gDay 5 6 7)
							(or (== gDisguiseNum 5) (== gDisguiseNum 6)) ; abbey monk, fens monk
						)
						(gEgo setScript: knockLobb)
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

(instance lobbsCover of PicView
	(properties
		x 242
		y 70
		view 350
		loop 1
		cel 1
		priority 10
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(if (or (== gDay 3) (== gDay 9))
					(if (== gDisguiseNum 4) ; yeoman
						(Say 1350 56 1) ; "It would seem my friend Lobb is gone for the moment."
					else
						(Say 1350 62 1) ; "The shop is open. I can glimpse a workbench and leather tools within."
					)
				else
					(Say 1350 7 1) ; "Lobb's shop is closed up."
				)
			)
			(3 ; Do
				(if (== gDisguiseNum 4) ; yeoman
					(Say 1350 57 1) ; "No point knocking when Lobb is clearly gone."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tailorCover of PicView
	(properties
		x 95
		y 76
		view 350
		loop 3
		priority 10
		signal 16
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(if (OneOf gDay 3 5 6 7)
				(Say 1350 63 1) ; "It is this woman's shop and home."
			else
				(Say 1350 9 1) ; "The tailor has closed up her shop, I see."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance handView of Actor
	(properties
		lookStr 65 ; "Pigs do attract flies."
		view 182
		loop 1
		priority 15
		signal 26640
	)
)

(instance tailorWoman of View
	(properties
		x 75
		y 154
		approachX 108
		approachY 164
		view 742
		cel 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(gEgo setScript: tailorLook)
			)
			(3 ; Do
				(Face gEgo tailorWoman)
				(cond
					((or (== gDisguiseNum 5) (== gDisguiseNum 6)) ; abbey monk, fens monk
						(gEgo setScript: tailorDo)
					)
					((== gDisguiseNum 1) ; beggar
						(SetMessageColor 6)
						(Say 1350 44 80 {Tailor Woman}) ; "'ere now, don't you be layin' your filthy hands on me!"
						1
						(SetMessageColor 0)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(5 ; Talk
				(gEgo setScript: tailorTalk)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(if (>= (gMoney doit:) 1)
							(cond
								((and (== gDisguiseNum 1) (== local14 0)) ; beggar
									(= local14 1)
									(Converse 2 @local25 7 0 @local16 3) ; "What's this then? D'ye want some new clothes?"
								)
								(
									(and
										(== gDisguiseNum 1) ; beggar
										(== local14 1)
										(== local15 0)
									)
									(= local15 1)
									(SetMessageColor 6)
									(Say 1350 49 80 {Tailor Woman}) ; "Thank you. If I'd a-know'd how well a beggar fares, I might've tried it meself!"
									(SetMessageColor 0)
								)
								((and (== gDisguiseNum 5) (== local13 0)) ; abbey monk
									(= local13 1)
									(gEgo setScript: giveWomanMoney)
								)
								((and (== gDisguiseNum 6) (== local12 0)) ; fens monk
									(= local12 1)
									(gEgo setScript: giveWomanMon)
								)
								(else
									(SetMessageColor 6)
									(Say 1350 3 80 {Tailor Woman}) ; "Thanks again."
									(SetMessageColor 0)
								)
							)
						)
					)
					(2 ; halfHeart
						(SetMessageColor 6)
						(Say 1350 19 80 {Tailor Woman}) ; "Bless me, Brother Monk! I couldn't accept such a thing."
						(SetMessageColor 0)
					)
					(6 ; gems
						(SetMessageColor 6)
						(Say 1350 19 80 {Tailor Woman}) ; "Bless me, Brother Monk! I couldn't accept such a thing."
						(SetMessageColor 0)
					)
					(7 ; jewels
						(SetMessageColor 6)
						(Say 1350 19 80 {Tailor Woman}) ; "Bless me, Brother Monk! I couldn't accept such a thing."
						(SetMessageColor 0)
					)
					(10 ; fireRing
						(SetMessageColor 6)
						(Say 1350 19 80 {Tailor Woman}) ; "Bless me, Brother Monk! I couldn't accept such a thing."
						(SetMessageColor 0)
					)
					(14 ; amethyst
						(SetMessageColor 6)
						(Say 1350 19 80 {Tailor Woman}) ; "Bless me, Brother Monk! I couldn't accept such a thing."
						(SetMessageColor 0)
					)
					(18 ; waterRing
						(SetMessageColor 6)
						(Say 1350 19 80 {Tailor Woman}) ; "Bless me, Brother Monk! I couldn't accept such a thing."
						(SetMessageColor 0)
					)
					(3 ; slipper
						(SetMessageColor 6)
						(Say 1350 20 80 {Tailor Woman}) ; "I don't repair shoes. You be wanting Lobb across the way there."
						(SetMessageColor 0)
					)
					(5 ; pipe
						(SetMessageColor 6)
						(Say 1350 21 80 {Tailor Woman}) ; "Eh, what would I do with this?"
						(SetMessageColor 0)
					)
					(11 ; cask
						(SetMessageColor 6)
						(Say 1350 22 80 {Tailor Woman}) ; "That looks like it belongs to the innkeeper at the Jerusalem pub. That's a fine ale he brews, eh?"
						(SetMessageColor 0)
					)
					(13 ; robes
						(SetMessageColor 6)
						(Say 1350 23 80 {Tailor Woman}) ; "These robes don't seem t'be in any need of repair."
						(SetMessageColor 0)
					)
					(15 ; comb
						(SetMessageColor 6)
						(Say 1350 25 80 {Tailor Woman}) ; "Fie, what's a filthy beggar like you doing with such a fine comb?!"
						(SetMessageColor 0)
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

(instance swineMan of View
	(properties
		x 157
		y 115
		approachX 167
		approachY 115
		view 740
		loop 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1350 58 1) ; "He has the look of an honest peasant and smell of a pig pen."
			)
			(5 ; Talk
				(gEgo setScript: talkToSwine)
			)
			(3 ; Do
				(Say 1350 59 1) ; "He's too poor to have anything I could want."
			)
			(4 ; Inventory
				(cond
					((== invItem 0) ; bucks
						(if
							(and
								(or (== gDisguiseNum 2) (== gDisguiseNum 3)) ; jewler (no rouge), jewler (rouge)
								(>= (gMoney doit:) 1)
							)
							(if (IsFlag 132)
								(SetMessageColor 6)
								(Say 1350 27 80 {Swineherd}) ; "You're too generous, sir."
								(SetMessageColor 0)
							else
								(gEgo setScript: giveManMoney)
							)
						)
					)
					((== invItem 8) ; rouge
						(SetMessageColor 6)
						(Say 1350 31 80 {Swineherd}) ; "Er...don't rightly know what it is, sir. Best you keep it."
						(SetMessageColor 0)
					)
					(
						(or
							(== invItem 2) ; halfHeart
							(== invItem 6) ; gems
							(== invItem 7) ; jewels
							(== invItem 10) ; fireRing
							(== invItem 14) ; amethyst
							(== invItem 18) ; waterRing
						)
						(SetMessageColor 6)
						(Say 1350 32 80 {Swineherd}) ; "I'm only a lowly swineherd, sir. I--I wouldn't know what to do with such a gift."
						(SetMessageColor 0)
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

(instance fly of Actor
	(properties
		z 15
		view 370
		cel 1
		signal 26640
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1350 65 1) ; "Pigs do attract flies."
		else
			(Say 1350 64 1) ; "Cease wasting time upon this fly."
		)
	)
)

(instance fly2 of Actor
	(properties
		z 15
		view 370
		cel 1
		signal 26640
	)

	(method (doVerb theVerb)
		(if (== theVerb 2) ; Look
			(Say 1350 65 1) ; "Pigs do attract flies."
		else
			(Say 1350 64 1) ; "Cease wasting time upon this fly."
		)
	)
)

(instance bigOlFly of Actor
	(properties
		x 15
		y 210
		lookStr 65 ; "Pigs do attract flies."
		yStep 12
		view 370
		loop 2
		cel 1
		priority 15
		signal 26640
		illegalBits 0
		xStep 18
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1350 66 1) ; "Look! A bug in out game!"
			)
			(3 ; Do
				(bigOlFly setMotion: 0 setScript: smashed)
			)
			(5 ; Talk
				(SetMessageColor 32)
				(Say 1350 68 1) ; "Got any good garbage? A nice ripe carcass maybe? I'm not picky.  Any old stinking thing will do."
				(SetMessageColor 0)
			)
			(4 ; Inventory
				(Say 1350 69 1) ; "Getting silly, are we?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pig1 of Actor
	(properties
		x 115
		y 144
		view 762
		loop 5
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1350 50 1) ; "The pigs must belong to this aromatic swineherd."
			)
			(3 ; Do
				(Say 1350 51 1) ; "I don't believe the sturdy swineherd would stand idly by if I tried to make off with his pig."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pig2 of Actor
	(properties
		x 113
		y 139
		view 762
		loop 6
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1350 50 1) ; "The pigs must belong to this aromatic swineherd."
			)
			(3 ; Do
				(Say 1350 51 1) ; "I don't believe the sturdy swineherd would stand idly by if I tried to make off with his pig."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cat of Actor
	(properties
		x 65
		y 168
		view 767
		loop 2
		cel 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1350 5 1) ; "It's a cat."
			)
			(3 ; Do
				(Say 1350 70 1) ; "I've better things to do than catch cats."
			)
			(5 ; Talk
				(SetMessageColor 32)
				(Say 1350 71 80 {Noble Feline} 1) ; "Are you going to feed me? Well, who needs you then. Bugger off."
				(SetMessageColor 0)
			)
			(4 ; Inventory
				(Say 1350 72 1) ; "In typical cat fashion, it ignores me."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chicken of Actor
	(properties
		x 89
		y 186
		view 761
		loop 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1350 6 1) ; "'Tis a duck."
			)
			(3 ; Do
				(Say 1350 54 1) ; "Why a duck?"
			)
			(5 ; Talk
				(SetMessageColor 32)
				(Say 1350 55 1 80 {Duck}) ; "Please, don't mention duck soup to me."
				(SetMessageColor 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance flyCage of Cage
	(properties)

	(method (init)
		(self top: 123 bottom: 148 left: 97 right: 140)
		(super init:)
	)
)

(instance enterShop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 273 147 self)
			)
			(1
				(gCurRoom newRoom: 360)
			)
		)
	)
)

(instance tailorLook of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face gEgo tailorWoman)
				(= ticks 12)
			)
			(1
				(if (IsFlag 16)
					(Say 1350 12 self) ; "She's the tailor."
				else
					(Say 1350 13 self) ; "Judging from the bits of thread and needles stuck through her apron, I would say this woman is a tailor."
					(SetFlag 16)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance tailorTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo tailorWoman self)
			)
			(1
				(if (== gDay 3)
					(gEgo setScript: day3Talk)
				)
				(if (<= 5 gDay 7)
					(SetMessageColor 6)
					(Say 1350 16 self 80 {Tailor Woman}) ; "If you be wantin' any sewin' done, I'm at your service."
				else
					(self cue:)
				)
			)
			(2
				(SetMessageColor 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance catChickenScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cat setCycle: Beg)
				(catSound number: (Random 354 355) play:)
				(chickenSound play:)
				(chicken
					setLoop: 0
					setCel: 0
					setCycle: Walk
					setMotion: MoveTo 290 166 self
				)
			)
			(1
				(chicken setMotion: MoveTo 310 160 self)
			)
			(2
				(chickenSound stop:)
				(chicken dispose:)
				(catSound number: (Random 354 355) play:)
				(cat
					setLoop: 0
					setCel: 0
					setCycle: Walk
					setMotion: MoveTo 330 170 self
				)
			)
			(3
				(cat hide:)
				(= seconds 10)
			)
			(4
				(catSound number: (Random 354 355) play:)
				(cat
					show:
					setLoop: 1
					setCel: 0
					setCycle: Walk
					setMotion: PolyPath 65 168 self
				)
			)
			(5
				(catSound number: (Random 354 355) play:)
				(cat setLoop: 2 setCel: 0 setCycle: End self)
			)
			(6
				(= seconds 10)
			)
			(7
				(cat setCycle: Beg self)
			)
			(8
				(catSound number: (Random 354 355) play:)
				(cat
					setLoop: 0
					setCel: 0
					setCycle: Walk
					setMotion: MoveTo 330 170 self
				)
			)
			(9
				(cat dispose:)
				(self dispose:)
			)
		)
	)
)

(instance giveWomanMoney of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 5)
			)
			(1
				(SetMessageColor 6)
				(Say 1350 0 80 {Tailor Woman}) ; "What's this for, then? Your robe don't look in need of repair."
				(SetMessageColor 0)
				(= cycles 1)
			)
			(2
				(Converse @local0 999 0 self) ; "It's charity, madame."
			)
			(3
				(SetMessageColor 6)
				(Say 1350 2 self 80 {Tailor Woman}) ; "What, from a monk? Oh, I mean, thank you kindly, Brother!"
				(SetMessageColor 0)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance giveWomanMon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 5)
			)
			(1
				(SetMessageColor 6)
				(Say 1350 40 80 {Tailor Woman}) ; "Does your robe need sewin', Brother?"
				(SetMessageColor 0)
				(= cycles 1)
			)
			(2
				(Converse @local4 999 0 self) ; "Nay, I give it to you to fulfill my vows of poverty."
			)
			(3
				(SetMessageColor 6)
				(Say 1350 42 80 {Tailor Woman}) ; "A right silly vow that sounds to me, Brother, but thank you all the same."
				(SetMessageColor 0)
				(= cycles 1)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance giveManMoney of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 5)
			)
			(1
				(SetFlag 132)
				(SetMessageColor 6)
				(Say 1350 28 80 {Swineherd}) ; "Are you looking for a swineherd, sir?"
				(SetMessageColor 0)
				(= cycles 1)
			)
			(2
				(Converse @local8 999 0 self) ; "Nay, nay, this is a gift."
			)
			(3
				(SetMessageColor 6)
				(Say 1350 30 80 {Swineherd}) ; "You're too generous, sir."
				(SetMessageColor 0)
				(= cycles 1)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance day3Talk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetMessageColor 6)
				(Say 1350 14 80 {Tailor Woman}) ; "Fie, don't you be comin' to me unless you've got the money for a new suit of clothes hidden in them rags."
				(= cycles 1)
			)
			(1
				(Say 1350 15 80 {Tailor Woman}) ; "I do believe you've been patched so many times, the cloth is gone and naught but the patches is left!"
				(SetMessageColor 0)
				(= cycles 1)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance tailorDo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetMessageColor 6)
				(Say 1350 17 80 {Tailor Woman}) ; "If it's a woman you want, monk, there's one down the street that'll fit your needs."
				(= cycles 1)
			)
			(1
				(Say 1350 18 80 {Tailor Woman}) ; "But I'm an 'onest woman and I've no time for monks what're tainted with the way of the flesh."
				(SetMessageColor 0)
				(= cycles 1)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance knockLobb of Script
	(properties)

	(method (dispose)
		(knockSound dispose:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 90)
				(= ticks 180)
			)
			(1
				(knockSound play:)
				(= cycles 2)
			)
			(2
				(SetMessageColor 6)
				(Say 1350 39 self 80 {Tailor Woman}) ; "Lobb's gone away. 'ow he expects t'do business when he's always gone is a wonderment t'me."
				(SetMessageColor 0)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance talkToSwine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo swineMan self)
			)
			(1
				(SetMessageColor 6)
				(Say 1350 26 80 {Swineherd}) ; "If you ever be needing a swineherd, sir, I'm your man."
				(SetMessageColor 0)
				(= cycles 1)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance pigCycle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(pig2 setCycle: CT 3 1)
				(pig1 setCycle: CT 4 1 self)
			)
			(2
				(= cycles 1)
			)
			(3
				(pig2 setCycle: CT 5 1)
				(pig1 setCycle: CT 4 1 self)
			)
			(4
				(= cycles 10)
			)
			(5
				(pig2 setCycle: CT 0 -1)
				(pig1 setCycle: CT 5 1 self)
			)
			(6
				(= cycles 5)
			)
			(7
				(pig2 setCycle: CT 4 1)
				(pig1 setCycle: CT 4 1 self)
			)
			(8
				(if (Random 0 5)
					(-= state 3)
				)
				(= seconds 1)
			)
			(9
				(self dispose:)
			)
		)
	)
)

(instance comeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 160 160 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getBuggy of Script
	(properties)

	(method (dispose)
		(flySound stop: dispose:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(flySound play:)
				(bigOlFly setMotion: MoveTo 165 110 self)
			)
			(1
				(bigOlFly
					setCycle: CT (mod (+ (bigOlFly cel:) (Random 0 7)) 7) 1 self
				)
			)
			(2
				(bigOlFly
					setCel: (bigOlFly cel:)
					setCycle: 0
					heading: (* (bigOlFly cel:) 45)
					setMotion: MoveFwd 20 self
				)
			)
			(3
				(if (Random 0 5)
					(-= state 3)
				)
				(bigOlFly
					setCycle: CT (mod (+ (bigOlFly cel:) (Random 0 7)) 7) 1 self
				)
			)
			(4
				(bigOlFly setCycle: CT 1 1 self)
			)
			(5
				(bigOlFly setLoop: 3 setCel: 0 setCycle: End)
				(= ticks 120)
			)
			(6
				(bigOlFly setCycle: Beg self)
			)
			(7
				(bigOlFly
					setCel: (bigOlFly cel:)
					heading: 0
					setMotion: MoveTo (bigOlFly x:) -15 self
				)
			)
			(8
				(bigOlFly dispose:)
				(self dispose:)
			)
		)
	)
)

(instance smashed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(handView x: (bigOlFly x:) y: (bigOlFly y:) init:)
				(bigOlFly view: 370 setLoop: 4 cel: 0)
				(= seconds 4)
			)
			(1
				(handView
					setMotion: MoveTo (- (handView x:) 3) (handView y:) self
				)
			)
			(2
				(handView
					setMotion: MoveTo (+ (handView x:) 6) (handView y:) self
				)
			)
			(3
				(handView
					setMotion: MoveTo (- (handView x:) 3) (handView y:) self
				)
			)
			(4
				(handView
					setMotion: MoveTo (- (handView x:) 3) (handView y:) self
				)
			)
			(5
				(handView
					setMotion: MoveTo (+ (handView x:) 6) (handView y:) self
				)
			)
			(6
				(handView
					setMotion: MoveTo (- (handView x:) 3) (handView y:) self
				)
			)
			(7
				(handView
					setMotion: MoveTo (- (handView x:) 3) (handView y:) self
				)
			)
			(8
				(handView
					setMotion: MoveTo (+ (handView x:) 6) (handView y:) self
				)
			)
			(9
				(handView
					setMotion: MoveTo (- (handView x:) 3) (handView y:) self
				)
			)
			(10
				(handView dispose:)
				(Say 1350 67 self) ; "Next time, use a flyswatter. This makes such a mess on the screen."
			)
			(11
				(= ticks 6)
			)
			(12
				(bigOlFly
					moveSpeed: 18
					setMotion: MoveTo (bigOlFly x:) 200 self
				)
			)
			(13
				(if (< (bigOlFly y:) 180)
					(-= newState 2)
				else
					(self cue:)
				)
			)
			(14
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance pigScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks (Random 450 700))
			)
			(1
				(pigSound play:)
				(= cycles 2)
			)
			(2
				(= state -1)
				(self cue:)
			)
		)
	)
)

(instance catSound of Sound
	(properties
		flags 1
	)
)

(instance chickenSound of Sound
	(properties
		flags 1
		number 353
		loop -1
	)
)

(instance pigSound of Sound
	(properties
		flags 1
		number 352
	)
)

(instance knockSound of Sound
	(properties
		flags 1
		number 933
	)
)

(instance flySound of Sound
	(properties
		flags 1
		number 363
		loop -1
	)
)

