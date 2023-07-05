;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 300)
(include sci.sh)
(use Main)
(use n013)
(use Fair)
(use verseScript)
(use StdRoom)
(use RTEyeCycle)
(use FairFeature)
(use Polygon)
(use Feature)
(use Motion)
(use System)

(public
	rm300 0
)

(local
	[local0 10] = [1300 14 1 1 2 2 1 2 1 0]
	[local10 5] = [1300 26 1 2 0]
	[local15 5] = [1300 123 1 2 0]
	[local20 14] = [1300 30 1 1 2 1 1 1 2 1 1 2 1 0]
	[local34 7] = [1300 49 1 1 2 1 0]
	[local41 11] = [1300 71 1 1 1 2 1 2 1 2 0]
	[local52 6] = [1300 81 1 2 2 0]
	[local58 9] = [1300 88 1 1 2 1 2 1 0]
	[local67 7] = [1300 99 1 2 1 2 0]
	[local74 7] = [1300 104 1 2 2 1 0]
	[local81 3] = [-1 {Guy Gilenyer} 21]
	[local84 3] = [-1 {Oswald Fingerstall} 21]
	[local87 3] = [-1 {Morgan Creek} 21]
	[local90 3] = [-1 {Garrett of York} 21]
	[local93 3] = [-1 {Edgar Sharp} 21]
	[local96 3] = [-1 {Beggar} 21]
	[local99 3] = [-1 {Vendor} 21]
	[local102 3] = [-1 {Mark Crowe} 21]
	[local105 3] = [-1 {Scott Murphy} 21]
)

(instance rm300 of StdRoom
	(properties
		picture 300
		style 11
		north 260
		east 310
		south 260
		west 290
	)

	(method (init)
		(self setRegions: 311) ; Fair
		(proc311_3)
		(if (< (gEgo y:) 100)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 39 305 39 202 58 140 34 45 34 45 24 0 24
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 77 241 77 217 60 262 51 311 51 319 61 319 189 0 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 154 49 178 59 170 64 138 64 132 56
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 39 40 39 40 54 0 54
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 237 182 242 175 298 175 289 189 26 189 26 182
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 118 121 118 83 137 0 137
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 124 319 138 122 138 141 124
						yourself:
					)
			)
		)
		(swordsArm init:)
		(merchantArm init: addToPic:)
		(markArm init: addToPic:)
		(furs init: approachVerbs: 3) ; Do
		(person9 init: approachVerbs: 0)
		(person11 init: approachVerbs: 0)
		(person12 init: approachVerbs: 0)
		(person14 init: approachVerbs: 0)
		(person22 init: approachVerbs: 0)
		(person23 init: approachVerbs: 0)
		(person26 init: approachVerbs: 0)
		(if (< (gEgo y:) 100)
			(sheepsArm init: approachVerbs: 0)
			(beggarArm init: approachVerbs: 0 setScript: sRandom)
			(knivesArm init: approachVerbs: 0)
			(person21 init: approachVerbs: 0)
			(person16 init: approachVerbs: 0)
			(person1 init: approachVerbs: 5) ; Talk
			(person2 init: approachVerbs: 5) ; Talk
			(person3 init: approachVerbs: 5) ; Talk
			(person4 init: approachVerbs: 5) ; Talk
			(person5 init: approachVerbs: 5) ; Talk
			(person6 init: approachVerbs: 5) ; Talk
			(person7 init: approachVerbs: 5) ; Talk
			(person8 init: approachVerbs: 5) ; Talk
			(person10 init: approachVerbs: 5 4) ; Talk, Inventory
			(person13 init: approachVerbs: 4 5) ; Inventory, Talk
			(person15 init: approachVerbs: 0)
			(person17 init: approachVerbs: 0)
			(person18 init: approachVerbs: 0)
			(person19 init: approachVerbs: 0)
			(person20 init: approachVerbs: 0)
			(person24 init: approachVerbs: 0)
			(person25 init: approachVerbs: 0)
			(person27 init: approachVerbs: 0)
			(person28 init: approachVerbs: 0)
			(table1 init: approachVerbs: 3) ; Do
		else
			(person1 init: approachVerbs: 0)
			(person2 init: approachVerbs: 0)
			(person3 init: approachVerbs: 0)
			(person4 init: approachVerbs: 0)
			(person5 init: approachVerbs: 0)
			(person6 init: approachVerbs: 0)
			(person7 init: approachVerbs: 0)
			(person8 init: approachVerbs: 0)
			(person10 init: approachVerbs: 0)
			(person13 init: approachVerbs: 0)
			(person16 init: approachVerbs: 3 5) ; Do, Talk
			(knivesArm init: approachVerbs: 5) ; Talk
			(person15 init: approachVerbs: 5) ; Talk
			(person17 init: approachVerbs: 5) ; Talk
			(person18 init: approachVerbs: 5) ; Talk
			(person19 init: approachVerbs: 5) ; Talk
			(person20 init: approachVerbs: 5 4) ; Talk, Inventory
			(person24 init: approachVerbs: 5) ; Talk
			(person25 init: approachVerbs: 5) ; Talk
			(person27 init: approachVerbs: 5) ; Talk
			(person28 init: approachVerbs: 5) ; Talk
			(table1 init: approachVerbs: 0)
			(sheepsArm init: approachVerbs: 3 5) ; Do, Talk
			(beggarArm init: approachVerbs: 4 3 5 setScript: sRandom) ; Inventory, Do, Talk
			(person21 init: approachVerbs: 4 3 5) ; Inventory, Do, Talk
		)
		(gFeatures
			add:
				baskets
				wheel
				table2
				wall
				knives
				tools
				leather
				box
				swords
				mysteries
				mysteries2
			eachElementDo: #init
		)
		(cond
			((== gPrevRoomNum west)
				(= style 12)
				(cond
					((and (> (gEgo y:) 38) (< (gEgo y:) 55))
						(gEgo y: 55)
					)
					((and (< (gEgo y:) 137) (> (gEgo y:) 100))
						(gEgo y: 137)
					)
				)
				(gEgo x: (- (gEgo x:) 320))
				(super init: (gEgo edgeHit:))
			)
			((== gPrevRoomNum east)
				(= style 11)
				(cond
					((and (< (gEgo y:) 138) (> (gEgo y:) 124))
						(gEgo y: 138)
					)
					((and (> (gEgo y:) 100) (< (gEgo y:) 118))
						(gEgo y: 118)
					)
					((and (< (gEgo y:) 100) (> (gEgo y:) 51))
						(gEgo y: 51)
					)
					((< (gEgo y:) 48)
						(gEgo y: 48)
					)
				)
				(if (and (< (gEgo y:) 138) (> (gEgo y:) 124))
					(gEgo y: 138)
				)
				(gEgo x: (+ (gEgo x:) 320))
				(super init: (gEgo edgeHit:))
			)
			(else
				(= style 100)
				(super init:)
			)
		)
		(HandsOn)
		(if (or (not global198) (> global198 270))
			((ScriptID 316) init:) ; marian
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script)
			((= temp0 (gEgo edgeHit:))
				(switch temp0
					(3
						(HandsOff)
						(gCurRoom setScript: sExitSouth)
					)
					(2
						(HandsOff)
						(gCurRoom setScript: sExitEast)
					)
					(4
						(HandsOff)
						(gCurRoom setScript: sExitWest)
					)
				)
			)
		)
		(super doit:)
	)
)

(instance beggarArm of FairProp
	(properties
		x 34
		y 169
		approachX 46
		approachY 182
		view 300
		loop 3
		priority 14
		signal 16400
		detailLevel 1
	)

	(method (doVerb)
		(person21 doVerb: &rest)
	)
)

(instance sheepsArm of FairProp
	(properties
		x 143
		y 107
		approachX 156
		approachY 140
		view 300
		loop 2
		priority 11
		signal 16400
		detailLevel 1
	)

	(method (doVerb)
		(person16 doVerb: &rest)
	)
)

(instance swordsArm of FairProp
	(properties
		x 307
		y 100
		view 300
		loop 1
		priority 11
		signal 16400
		detailLevel 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 70) ; "A man selling swords."
			)
			(5 ; Talk
				(if (< (gEgo y:) 100)
					(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(Converse @local41 @local93 6) ; "The sharpest and most resilient of Damascene steel."
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(SetMessageColor 21)
						(Say 1300 79 80 {Edgar Sharp}) ; "Do not be insulting."
						(SetMessageColor 0)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance merchantArm of FairProp
	(properties
		x 257
		y 41
		view 300
		loop 5
		priority 7
		signal 16400
		detailLevel 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 48) ; "A man selling knives."
			)
			(5 ; Talk
				(if (> (gEgo y:) 100)
					(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(Converse @local34 @local90 6) ; "I'm the most skilled smith in all of York in the making of daggers and small blades."
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(SetMessageColor 21)
						(Say 1300 53 80 {Garrett of York}) ; "I'll not part with any blades for that price."
						(SetMessageColor 0)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance markArm of FairProp
	(properties
		x 248
		y 161
		view 300
		loop 4
		priority 14
		signal 16400
		detailLevel 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 98) ; "A man in earnest conversation with a friend."
			)
			(5 ; Talk
				(if (< (gEgo y:) 100)
					(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(Converse @local67 @local105 @local102) ; "Think of the potential! 'Two Guys From Nottingham' has a real ring to it."
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person1 of FairFeature
	(properties
		x 9
		y 25
		nsBottom 50
		nsRight 19
		sightAngle 90
		approachX 14
		approachY 55
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 6) ; "Two elderly women."
			)
			(5 ; Talk
				(if (> (gEgo y:) 100)
					(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(SetMessageColor 21)
					(Say 1300 7 80 {Gammer Hedda}) ; "Aren't you a handsome one! Remind me of my sixth husband, you do."
					(SetMessageColor 0)
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person2 of FairFeature
	(properties
		x 32
		y 88
		z 40
		nsTop 32
		nsLeft 25
		nsBottom 65
		nsRight 39
		sightAngle 90
		approachX 40
		approachY 56
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 8) ; "A peasant man listening to a streetmonger."
			)
			(5 ; Talk
				(if (> (gEgo y:) 100)
					(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(SetMessageColor 21)
					(Say 1300 9 80 {Clyde Kadiddlehopper}) ; "Shhh! We're listening."
					(SetMessageColor 0)
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person3 of FairFeature
	(properties
		x 46
		y 80
		z 30
		nsTop 34
		nsLeft 38
		nsBottom 67
		nsRight 55
		sightAngle 90
		approachX 40
		approachY 56
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 10) ; "A peasant man listening to a streetmonger."
			)
			(5 ; Talk
				(if (> (gEgo y:) 100)
					(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(SetMessageColor 21)
					(Say 1300 11 80 {Ichabod Idlebody}) ; "Care to join us in a venture, sir? We're going to buy this Trojan wheel and make a fortune."
					(Say 1300 12 80 {Ichabod Idlebody}) ; "All we need is someone to buy it for us and we'll do the rest."
					(SetMessageColor 0)
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person4 of FairFeature
	(properties
		x 65
		y 89
		z 40
		nsTop 32
		nsLeft 54
		nsBottom 67
		nsRight 76
		sightAngle 90
		approachX 40
		approachY 56
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 13) ; "A streetmonger with a large wooden wheel."
			)
			(5 ; Talk
				(if (> (gEgo y:) 100)
					(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(Converse @local0 @local81 6) ; "I swear a mighty oath that every word I say is true."
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person5 of FairFeature
	(properties
		x 100
		y 16
		nsTop 1
		nsLeft 91
		nsBottom 31
		nsRight 110
		sightAngle 90
		approachX 122
		approachY 34
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 21) ; "A woman selling baskets."
			)
			(5 ; Talk
				(if (> (gEgo y:) 100)
					(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(SetMessageColor 21)
					(Say 1300 22 80 {Winifred Weaver}) ; "Baskets! Baskets! Big baskets! Little baskets!"
					(Say 1300 23 80 {Winifred Weaver}) ; "Deep baskets! Shallow baskets! Heavy baskets! Light baskets!"
					(SetMessageColor 0)
					(Say 1300 24) ; "Truly, a basket case."
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person6 of FairFeature
	(properties
		x 154
		y 64
		z 30
		nsTop 6
		nsLeft 142
		nsBottom 63
		nsRight 166
		sightAngle 90
		onMeCheck 16
		approachX 134
		approachY 57
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 25) ; "A young man with a bow."
			)
			(5 ; Talk
				(cond
					((> (gEgo y:) 100)
						(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
					)
					((> gRoomCount 42)
						(Converse @local15 6 @local84) ; "If you mean to compete in the tournament, I fear you're too late."
					)
					(else
						(Converse @local10 6 @local84) ; "Do you mean to compete in the tournament, my friend?"
					)
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person7 of FairFeature
	(properties
		x 176
		y 18
		nsTop -1
		nsLeft 168
		nsBottom 38
		nsRight 185
		sightAngle 90
		approachX 182
		approachY 46
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 28) ; "A woman who looks unhappy with the food."
			)
			(5 ; Talk
				(if (> (gEgo y:) 100)
					(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(SetMessageColor 21)
					(Say 1300 122 80 {Mistress Hayasher}) ; "I would dearly love some raw fish and rice."
					(SetMessageColor 0)
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person8 of FairFeature
	(properties
		x 185
		y 81
		z 30
		nsTop 39
		nsLeft 170
		nsBottom 63
		nsRight 201
		sightAngle 90
		onMeCheck 8
		approachX 197
		approachY 74
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 29) ; "A man selling pieces of metal-studded leather."
			)
			(5 ; Talk
				(cond
					((> (gEgo y:) 100)
						(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
					)
					((Fair firstTalkMorgan:)
						(Converse @local20 @local87 6) ; "Sturdy leather decorated with metal studs. Once belonged to Sir Kevin, Earl of Kostner."
						(Fair firstTalkMorgan: 0)
					)
					(else
						(SetMessageColor 21)
						(Say 1300 41 80 {Morgan Creek}) ; "5 marks for a piece of Sir Kevin's leather, and no sniffing allowed in the vicinity."
						(SetMessageColor 0)
					)
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person9 of FairFeature
	(properties
		x 206
		y 18
		z -10
		nsTop 3
		nsLeft 196
		nsBottom 53
		nsRight 216
		sightAngle 90
		approachX 182
		approachY 46
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 42) ; "A peasant woman."
			)
			(5 ; Talk
				(Say 1300 2 1) ; "I've nothing to say to that person."
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person10 of FairFeature
	(properties
		x 228
		y 7
		nsLeft 218
		nsBottom 15
		nsRight 239
		sightAngle 90
		approachX 220
		approachY 45
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 43) ; "A vendor of breads."
			)
			(5 ; Talk
				(if (> (gEgo y:) 100)
					(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(SetMessageColor 21)
					(Say 1300 44 80 {Bruce the Baker}) ; "Freshly baked bread, best in the shire."
					(SetMessageColor 0)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(Say 1300 45) ; "The smell of the fresh bread is tempting, but I can get Tuck's good bread in my own camp."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person11 of FairFeature
	(properties
		x 267
		y 8
		nsLeft 254
		nsBottom 16
		nsRight 281
		sightAngle 90
		approachX 251
		approachY 45
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 46) ; "A man sated on bread and wine."
			)
			(5 ; Talk
				(Say 1300 2 1) ; "I've nothing to say to that person."
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person12 of FairFeature
	(properties
		x 290
		y 20
		nsLeft 283
		nsBottom 40
		nsRight 297
		sightAngle 90
		approachX 251
		approachY 45
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 47) ; "A man from another village."
			)
			(5 ; Talk
				(Say 1300 2 1) ; "I've nothing to say to that person."
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person13 of FairFeature
	(properties
		x 262
		y 86
		z 40
		nsTop 28
		nsLeft 251
		nsBottom 65
		nsRight 273
		sightAngle 90
		onMeCheck 8
		approachX 253
		approachY 48
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 48) ; "A man selling knives."
			)
			(5 ; Talk
				(if (> (gEgo y:) 100)
					(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(Converse @local34 @local90 6) ; "I'm the most skilled smith in all of York in the making of daggers and small blades."
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(if (>= (gMoney doit:) 1)
							(gMoney put:)
							(SetMessageColor 21)
							(Say 1300 53 80 {Garrett of York}) ; "I'll not part with any blades for that price."
							(SetMessageColor 0)
						)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person14 of FairFeature
	(properties
		x 305
		y 86
		z 40
		nsTop 32
		nsLeft 296
		nsBottom 61
		nsRight 314
		sightAngle 90
		approachX 271
		approachY 47
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 54) ; "A man looking at knives."
			)
			(5 ; Talk
				(Say 1300 2 1) ; "I've nothing to say to that person."
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance knivesArm of FairProp
	(properties
		x 27
		y 113
		approachX 52
		approachY 134
		view 300
		priority 12
		signal 16400
	)

	(method (doVerb)
		(person15 doVerb: &rest)
	)
)

(instance person15 of FairFeature
	(properties
		x 25
		y 110
		nsTop 92
		nsLeft 9
		nsBottom 129
		nsRight 41
		sightAngle 90
		approachX 52
		approachY 134
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 55) ; "A man selling tools."
			)
			(5 ; Talk
				(if (< (gEgo y:) 100)
					(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(SetMessageColor 21)
					(Say 1300 56 80 {Cuthbert Codswallop}) ; "Tools and implements for men of many trades, though not, I fear, for your trade, yeoman."
					(SetMessageColor 0)
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person16 of FairFeature
	(properties
		x 151
		y 103
		nsTop 75
		nsLeft 139
		nsBottom 131
		nsRight 164
		sightAngle 90
		approachX 156
		approachY 140
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 57) ; "A pilcher selling his furs."
			)
			(5 ; Talk
				(if (< (gEgo y:) 100)
					(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(SetMessageColor 21)
					(Say 1300 58 80 {Ned Courage}) ; "Finest quality furs to adorn a man or lady."
					(Say 1300 59 80 {Ned Courage}) ; "I've rabbit and fox and wolf and bear and exotic furs from across the seas."
					(Say 1300 60 80 {Ned Courage}) ; "Suitable all manner of garments--collar, hats, cloaks, boots, cuffs!"
					(SetMessageColor 0)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(Say 1300 61) ; "Why should I buy furs when I can hunt them myself in Sherwood?"
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person17 of FairFeature
	(properties
		x 212
		y 119
		nsTop 104
		nsLeft 197
		nsBottom 134
		nsRight 228
		sightAngle 90
		approachX 213
		approachY 118
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 62) ; "A woman and her child."
			)
			(5 ; Talk
				(if (< (gEgo y:) 100)
					(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(SetMessageColor 21)
					(Say 1300 63 80 {Ned Courage}) ; "You've no business talking to my wife."
					(SetMessageColor 0)
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person18 of FairFeature
	(properties
		x 249
		y 205
		z 100
		nsTop 77
		nsLeft 240
		nsBottom 133
		nsRight 258
		sightAngle 90
		approachX 267
		approachY 120
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 64) ; "A tall young man eyeing the swords."
			)
			(5 ; Talk
				(if (< (gEgo y:) 100)
					(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(SetMessageColor 21)
					(Say 1300 65 80 {Erik the Tall}) ; "I'd dearly love to have one of those swords."
					(Say 1300 66 80 {Erik the Tall}) ; "Truly, I would have respect then or heads would roll."
					(SetMessageColor 0)
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person19 of FairFeature
	(properties
		x 273
		y 223
		z 100
		nsTop 111
		nsLeft 259
		nsBottom 136
		nsRight 288
		sightAngle 90
		approachX 267
		approachY 120
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 67) ; "A lazy man looking at the swords."
			)
			(5 ; Talk
				(if (< (gEgo y:) 100)
					(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(SetMessageColor 21)
					(Say 1300 68 80 {Lester Luskin}) ; "Swinging a sword is far too much work."
					(Say 1300 69 80 {Lester Luskin}) ; "I'd rather sit here and look at them until I feel strong enough to stand up."
					(SetMessageColor 0)
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person20 of FairFeature
	(properties
		x 302
		y 154
		z 50
		nsTop 76
		nsLeft 289
		nsBottom 132
		nsRight 316
		sightAngle 90
		approachX 267
		approachY 120
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 70) ; "A man selling swords."
			)
			(5 ; Talk
				(if (< (gEgo y:) 100)
					(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(Converse @local41 @local93 6) ; "The sharpest and most resilient of Damascene steel."
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(if (>= (gMoney doit:) 1)
							(gMoney put:)
							(SetMessageColor 21)
							(Say 1300 79 80 {Edgar Sharp}) ; "Do not be insulting."
							(SetMessageColor 0)
						)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person21 of FairFeature
	(properties
		x 44
		y 266
		z 100
		nsTop 143
		nsLeft 27
		nsBottom 189
		nsRight 61
		sightAngle 90
		approachX 46
		approachY 182
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 80) ; "A one-legged beggar."
			)
			(5 ; Talk
				(if (< (gEgo y:) 100)
					(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(Converse @local52 6 @local96) ; "How did you lose your leg?"
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(if (>= (gMoney doit:) 1)
							(SetMessageColor 21)
							(Say 1300 84 80 {Beggar}) ; "My thanks."
							(SetMessageColor 0)
							(SetScore 10 150)
						)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person22 of FairFeature
	(properties
		x 86
		y 268
		z 100
		nsTop 147
		nsLeft 76
		nsBottom 189
		nsRight 97
		sightAngle 90
		approachX 94
		approachY 166
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 85) ; "A woman of the town."
			)
			(5 ; Talk
				(Say 1300 2 1) ; "I've nothing to say to that person."
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person23 of FairFeature
	(properties
		x 108
		y 266
		z 100
		nsTop 144
		nsLeft 95
		nsBottom 189
		nsRight 122
		sightAngle 90
		approachX 94
		approachY 166
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 86) ; "A fat woman."
			)
			(5 ; Talk
				(Say 1300 2 1) ; "I've nothing to say to that person."
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person24 of FairFeature
	(properties
		x 164
		y 280
		z 100
		nsTop 171
		nsLeft 151
		nsBottom 189
		nsRight 178
		sightAngle 90
		approachX 163
		approachY 183
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 87) ; "A man selling Mysterious Objects."
			)
			(5 ; Talk
				(if (< (gEgo y:) 100)
					(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(HandsOff)
					(gCurRoom setScript: talkScript)
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person25 of FairFeature
	(properties
		x 209
		y 271
		z 100
		nsTop 154
		nsLeft 196
		nsBottom 189
		nsRight 222
		sightAngle 90
		approachX 221
		approachY 177
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 95) ; "A woman watching a man stand on his head."
			)
			(5 ; Talk
				(if (< (gEgo y:) 100)
					(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(SetMessageColor 21)
					(Say 1300 96 80 {Rowena Sly}) ; "Oh, look! His face is turning the loveliest shade of purple."
					(SetMessageColor 0)
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person26 of FairFeature
	(properties
		x 237
		y 272
		z 100
		nsTop 156
		nsLeft 223
		nsBottom 189
		nsRight 252
		sightAngle 90
		approachX 221
		approachY 177
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 97) ; "A man standing on his head. Mayhap he's imbibed too much scrumpy cider."
			)
			(5 ; Talk
				(Say 1300 2 1) ; "I've nothing to say to that person."
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person27 of FairFeature
	(properties
		x 257
		y 267
		z 100
		nsTop 146
		nsLeft 245
		nsBottom 189
		nsRight 269
		sightAngle 90
		approachX 267
		approachY 171
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 98) ; "A man in earnest conversation with a friend."
			)
			(5 ; Talk
				(if (< (gEgo y:) 100)
					(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(Converse @local67 @local105 @local102) ; "Think of the potential! 'Two Guys From Nottingham' has a real ring to it."
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person28 of FairFeature
	(properties
		x 276
		y 270
		z 100
		nsTop 152
		nsLeft 264
		nsBottom 189
		nsRight 289
		sightAngle 90
		approachX 267
		approachY 171
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 103) ; "A man listening to his friend."
			)
			(5 ; Talk
				(if (< (gEgo y:) 100)
					(Say 1300 5) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(Converse @local74 @local102 @local105) ; "Look at this place! They don't use janitors here. A Sanitation Specialist would die from breathing the air."
				)
			)
			(3 ; Do
				(Say 1300 1 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance baskets of FairFeature
	(properties
		x 94
		y 15
		nsTop -1
		nsLeft 48
		nsBottom 32
		nsRight 141
		sightAngle 90
		approachX 121
		approachY 35
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 108) ; "Baskets."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wheel of FairFeature
	(properties
		x 105
		y 82
		z 30
		nsTop 38
		nsLeft 78
		nsBottom 66
		nsRight 133
		sightAngle 90
		onMeCheck 4
		approachX 76
		approachY 64
		_approachVerbs 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 109) ; "A large wooden wheel."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance table1 of FairFeature
	(properties
		x 222
		y 23
		nsLeft 155
		nsBottom 47
		nsRight 290
		sightAngle 90
		onMeCheck 4
		approachX 180
		approachY 45
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 110) ; "A baker's table."
			)
			(3 ; Do
				(SetMessageColor 21)
				(Say 1300 111 80 {Bruce the Baker}) ; "Try to make off with me bread and I'll cut your fingers off."
				(SetMessageColor 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance table2 of FairFeature
	(properties
		x 274
		y 35
		z -20
		nsTop 42
		nsLeft 230
		nsBottom 68
		nsRight 319
		sightAngle 90
		approachX 271
		approachY 47
		_approachVerbs 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 112) ; "A table of knives on display."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wall of Feature
	(properties
		x 159
		y 82
		nsTop 63
		nsBottom 102
		nsRight 319
		sightAngle 45
		onMeCheck 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 113) ; "The wall runs the length of the Fair and divides the merchants."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance knives of FairFeature
	(properties
		x 23
		y 89
		nsTop 73
		nsLeft 2
		nsBottom 106
		nsRight 45
		sightAngle 90
		approachX 52
		approachY 134
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 114) ; "A display of edged tools."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tools of FairFeature
	(properties
		x 72
		y 102
		nsTop 73
		nsLeft 47
		nsBottom 131
		nsRight 98
		sightAngle 90
		onMeCheck 4
		approachX 52
		approachY 134
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 115) ; "A display of tools of various sorts."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance furs of Feature
	(properties
		x 148
		y 84
		nsTop 58
		nsLeft 98
		nsBottom 110
		nsRight 199
		sightAngle 90
		onMeCheck 32
		approachX 120
		approachY 116
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 116) ; "Many fine furs."
			)
			(3 ; Do
				(SetMessageColor 21)
				(Say 1300 117 80 {Ned Courage}) ; "Do not fondle my furs!"
				(SetMessageColor 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance leather of FairFeature
	(properties
		x 215
		y 74
		nsTop 61
		nsLeft 187
		nsBottom 87
		nsRight 243
		sightAngle 90
		approachX 214
		approachY 78
		_approachVerbs 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 118) ; "Pieces of studded leather."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance box of FairFeature
	(properties
		x 215
		y 101
		sightAngle 45
		approachX 201
		approachY 111
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 234 94 239 100 197 101 193 96
			yourself:
		)
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 119) ; "A box, perhaps to carry the swords."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance swords of FairFeature
	(properties
		x 270
		y 93
		nsTop 71
		nsLeft 238
		nsBottom 116
		nsRight 303
		sightAngle 90
		approachX 234
		approachY 116
		_approachVerbs 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 120) ; "The wavy patterns in the steel tell me these are true Damascene swords."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mysteries of FairFeature
	(properties
		x 131
		y 179
		nsTop 169
		nsLeft 100
		nsBottom 189
		nsRight 162
		sightAngle 90
		_approachVerbs 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 121) ; "They are Mysterious Objects."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mysteries2 of FairFeature
	(properties
		x 183
		y 177
		nsTop 166
		nsLeft 157
		nsBottom 188
		nsRight 210
		sightAngle 90
		_approachVerbs 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1300 121) ; "They are Mysterious Objects."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gEgo x:) 187)
					(gEgo
						setMotion:
							MoveTo
							(+ (gEgo x:) 40)
							(+ (gEgo y:) 60)
							self
					)
				else
					(gEgo
						setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 60) self
					)
				)
			)
			(1
				(gCurRoom newRoom: 260)
			)
		)
	)
)

(instance sRandom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (Random 0 3)
					(0
						(self changeState: 10)
					)
					(1
						(self changeState: 20)
					)
					(2
						(self changeState: 30)
					)
					(3
						(self changeState: 40)
					)
					(4
						(self changeState: 60)
					)
					(5
						(self changeState: 50)
					)
				)
			)
			(10
				(beggarArm cycleSpeed: (Random 5 15) setCycle: End self)
			)
			(11
				(beggarArm stopUpd:)
				(= cycles (/ (Random 25 80) (+ gHowFast 1)))
			)
			(12
				(beggarArm cycleSpeed: (Random 5 15) setCycle: Beg self)
			)
			(13
				(beggarArm stopUpd:)
				(= state -1)
				(= ticks (Random 5 10))
			)
			(20
				(knivesArm cycleSpeed: (Random 5 20) setCycle: End self)
			)
			(21
				(knivesArm stopUpd:)
				(= cycles (/ (Random 25 80) (+ gHowFast 1)))
			)
			(22
				(knivesArm cycleSpeed: (Random 5 20) setCycle: Beg self)
			)
			(23
				(knivesArm stopUpd:)
				(= state -1)
				(= ticks (Random 5 10))
			)
			(30
				(sheepsArm setCycle: End self)
			)
			(31
				(sheepsArm stopUpd:)
				(= cycles (/ (Random 25 80) (+ gHowFast 1)))
			)
			(32
				(sheepsArm setCycle: Beg self)
			)
			(33
				(sheepsArm stopUpd:)
				(= state -1)
				(= ticks (Random 5 10))
			)
			(40
				(swordsArm cycleSpeed: (Random 5 10) setCycle: End self)
			)
			(41
				(swordsArm stopUpd:)
				(= cycles (/ (Random 25 80) (+ gHowFast 1)))
			)
			(42
				(swordsArm cycleSpeed: (Random 5 10) setCycle: Beg self)
			)
			(43
				(swordsArm stopUpd:)
				(= state -1)
				(= ticks (Random 5 10))
			)
			(50
				(merchantArm cycleSpeed: (Random 5 10) setCycle: End self)
			)
			(51
				(merchantArm stopUpd:)
				(= cycles (/ (Random 25 80) (+ gHowFast 1)))
			)
			(52
				(merchantArm cycleSpeed: (Random 5 10) setCycle: Beg self)
			)
			(53
				(merchantArm stopUpd:)
				(= state -1)
				(= ticks (Random 5 10))
			)
			(60
				(markArm cycleSpeed: (Random 5 10) setCycle: End self)
			)
			(61
				(markArm stopUpd:)
				(= cycles (/ (Random 25 80) (+ gHowFast 1)))
			)
			(62
				(markArm cycleSpeed: (Random 5 10) setCycle: Beg self)
			)
			(63
				(markArm stopUpd:)
				(= state -1)
				(= ticks (Random 5 10))
			)
		)
	)
)

(instance talkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Converse @local58 @local99 6 self) ; "Mysterious Objects! Come buy a Mysterious Object!"
			)
			(1
				(Say 1300 94 self) ; "Methinks this man is several arrows short of a quiver."
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sExitEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 335 (gEgo y:) self)
			)
			(1
				(if (not (Fair walkingOut:))
					(gCurRoom newRoom: 310)
				else
					(-- state)
					(= cycles 1)
				)
			)
		)
	)
)

(instance sExitWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo -15 (gEgo y:) self)
			)
			(1
				(if (not (Fair walkingOut:))
					(gCurRoom newRoom: 290)
				else
					(-- state)
					(= cycles 1)
				)
			)
		)
	)
)

