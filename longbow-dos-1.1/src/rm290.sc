;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use n013)
(use Fair)
(use verseScript)
(use StdRoom)
(use RTEyeCycle)
(use FairFeature)
(use PolyPath)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	rm290 0
)

(local
	local0
	[local1 5] = [1290 10 1 2 0]
	[local6 12] = [1290 13 1 1 1 1 1 2 2 2 1 0]
	[local18 8] = [1290 25 1 2 1 2 1 0]
	[local26 5] = [1290 44 1 2 0]
	[local31 6] = [1290 46 1 2 2 0]
	[local37 12] = [1290 57 1 2 2 2 1 2 2 2 1 0]
	[local49 6] = [1290 69 1 2 1 0]
	[local55 8] = [1290 73 1 2 2 2 1 0]
	[local63 7] = [1290 89 1 2 2 2 0]
	[local70 9] = [1290 106 1 2 2 1 2 2 0]
	[local79 7] = [1290 114 1 2 1 2 0]
	[local86 11] = [1290 121 1 2 2 2 2 1 2 1 0]
	[local97 6] = [1290 130 1 2 2 0]
	[local103 8] = [1290 137 1 1 1 1 2 0]
	[local111 8] = [1290 145 2 2 1 2 2 0]
	[local119 7] = [1290 95 2 1 2 2 0]
	[local126 7] = [1290 99 1 2 1 2 0]
	[local133 3] = [-1 {Apprentice} 21]
	[local136 3] = [-1 {Doomsayer} 21]
	[local139 3] = [-1 {William Woodcock} 21]
	[local142 3] = [-1 {Robert of Fischbach} 21]
	[local145 3] = [-1 {Bertie Bowler} 21]
	[local148 3] = [-1 {Cadwaller} 21]
	[local151 3] = [-1 {Jerry Moore} 21]
	[local154 3] = [-1 {Hippocrates Socrates} 21]
	[local157 3] = [-1 {Ernest} 21]
	[local160 3] = [-1 {Ugly Child} 21]
	[local163 3] = [-1 {Lance Notalot} 21]
	[local166 3] = [-1 {Clyde Clodpate} 21]
	[local169 3] = [-1 {Roddy Bright} 21]
	[local172 3] = [-1 {Rug Seller} 21]
)

(instance rm290 of StdRoom
	(properties
		picture 290
		style 100
		north 260
		east 300
		south 260
		west 280
	)

	(method (init)
		(self setRegions: 311) ; Fair
		(proc311_3)
		(table1 init: approachVerbs: 0)
		(wall init: approachVerbs: 0)
		(barrel1 init: approachVerbs: 0)
		(table2 init: approachVerbs: 0)
		(crate init: approachVerbs: 0)
		(rugs1 init: approachVerbs: 0)
		(rugs2 init: approachVerbs: 0)
		(barrels2 init: approachVerbs: 0)
		(person3 init: approachVerbs: 0)
		(person13 init: approachVerbs: 0)
		(person23 init: approachVerbs: 0)
		(person24 init: approachVerbs: 0)
		(person25 init: approachVerbs: 0)
		(if (< (gEgo y:) 100)
			(tail init: approachVerbs: 0)
			(pigarm init: setScript: sRandom approachVerbs: 0)
			(carm1 init: approachVerbs: 0)
			(carm2 init: approachVerbs: 0)
			(head init: approachVerbs: 0)
			(doom init: approachVerbs: 5) ; Talk
			(arm init: approachVerbs: 5 4) ; Talk, Inventory
			(person1 init: approachVerbs: 5) ; Talk
			(person2 init: approachVerbs: 5) ; Talk
			(person4 init: approachVerbs: 5) ; Talk
			(person5 init: approachVerbs: 5) ; Talk
			(person6 init: approachVerbs: 5) ; Talk
			(person7 init: approachVerbs: 5 4) ; Talk, Inventory
			(person8 init: approachVerbs: 5 4) ; Talk, Inventory
			(person9 init: approachVerbs: 5 4) ; Talk, Inventory
			(person10 init: approachVerbs: 5 4) ; Talk, Inventory
			(person11 init: approachVerbs: 5) ; Talk
			(person12 init: approachVerbs: 5) ; Talk
			(person14 init: approachVerbs: 5) ; Talk
			(person15 init: approachVerbs: 5) ; Talk
			(person16 init: approachVerbs: 0)
			(person17 init: approachVerbs: 0)
			(person18 init: approachVerbs: 0)
			(person19 init: approachVerbs: 0)
			(person20 init: approachVerbs: 0)
			(person21 init: approachVerbs: 0)
			(person22 init: approachVerbs: 0)
			(person26 init: approachVerbs: 0)
			(person27 init: approachVerbs: 0)
			(person28 init: approachVerbs: 0)
			(stall init: approachVerbs: 0)
		else
			(tail init: approachVerbs: 4) ; Inventory
			(pigarm init: setScript: sRandom approachVerbs: 5) ; Talk
			(doom init: approachVerbs: 0)
			(arm init: approachVerbs: 0)
			(head init: approachVerbs: 5) ; Talk
			(carm1 init: approachVerbs: 5 4) ; Talk, Inventory
			(carm2 init: approachVerbs: 5 4) ; Talk, Inventory
			(person1 init: approachVerbs: 0)
			(person2 init: approachVerbs: 0)
			(person4 init: approachVerbs: 0)
			(person5 init: approachVerbs: 0)
			(person6 init: approachVerbs: 0)
			(person7 init: approachVerbs: 0)
			(person8 init: approachVerbs: 0)
			(person9 init: approachVerbs: 0)
			(person10 init: approachVerbs: 0)
			(person11 init: approachVerbs: 0)
			(person12 init: approachVerbs: 0)
			(person14 init: approachVerbs: 0)
			(person15 init: approachVerbs: 0)
			(person16 init: approachVerbs: 5 4) ; Talk, Inventory
			(person17 init: approachVerbs: 5 4) ; Talk, Inventory
			(person18 init: approachVerbs: 5 4) ; Talk, Inventory
			(person19 init: approachVerbs: 5 3) ; Talk, Do
			(person20 init: approachVerbs: 5 3) ; Talk, Do
			(person21 init: approachVerbs: 5) ; Talk
			(person22 init: approachVerbs: 5) ; Talk
			(person26 init: approachVerbs: 5) ; Talk
			(person27 init: approachVerbs: 4 5) ; Inventory, Talk
			(person28 init: approachVerbs: 5) ; Talk
			(stall init: approachVerbs: 3) ; Do
		)
		(if (not (Fair boughtRoseOil:))
			(bottle setPri: 13 init:)
		)
		(if (> (gEgo y:) 100)
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 -1 319 0 319 110 311 110 284 125 203 125 191 104 32 104 30 110 0 110
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 182 164 182 180 175 244 175 268 163 319 163 319 189 0 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 229 127 290 127 304 139 226 139
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 130 304 130 294 124 305 117 319 117
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 160 259 160 259 155 319 155
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 12 131 35 131 55 114 173 115 199 141 231 141 231 155 138 155 124 149 12 149 8 140
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 0 0 319 0 319 25 257 25 245 39 176 39 152 32 158 44 91 44 19 58 0 46
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 294 42 264 42 260 34 293 34
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 78 319 78 319 189 0 189
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 57 298 57 298 49 319 49
						yourself:
					)
			)
		)
		(if (or (not global198) (> global198 270))
			((ScriptID 316) init:) ; marian
		)
		(cond
			((== gPrevRoomNum west)
				(= style 12)
				(if (> (gEgo y:) 180)
					(gEgo y: 180)
				)
				(gEgo x: (- (gEgo x:) 320))
				(super init: (gEgo edgeHit:))
			)
			((== gPrevRoomNum east)
				(= style 11)
				(if (> (gEgo y:) 155)
					(gEgo y: 165)
				)
				(gEgo x: (+ (gEgo x:) 320))
				(super init: (gEgo edgeHit:))
			)
			(else
				(super init:)
			)
		)
		(HandsOn)
	)

	(method (doit)
		(cond
			(script)
			((== (gEgo edgeHit:) 2)
				(HandsOff)
				(gCurRoom setScript: sExitEast)
			)
			((== (gEgo edgeHit:) 4)
				(HandsOff)
				(gCurRoom setScript: sExitWest)
			)
		)
		(super doit:)
	)
)

(instance person1 of FairFeature
	(properties
		x 13
		y 12
		nsTop -1
		nsLeft 7
		nsBottom 25
		nsRight 20
		sightAngle 90
		approachX 20
		approachY 58
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 9) ; "The Doomsayer's apprentice."
			)
			(5 ; Talk
				(if (> (gEgo y:) 100)
					(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(Converse @local1 6 @local133 0 1) ; "I don't suppose there's much future in being a Doomsayer's 'prentice?"
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person2 of FairFeature
	(properties
		x 44
		y 12
		nsTop -1
		nsLeft 36
		nsBottom 25
		nsRight 53
		sightAngle 90
		approachX 20
		approachY 58
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 12) ; "A Doomsayer."
			)
			(5 ; Talk
				(if (> (gEgo y:) 100)
					(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(Converse @local6 @local136 6 0 1) ; "The End is Coming! The Millenium draws to an end and the Time of Judgement is upon us!"
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person3 of FairFeature
	(properties
		x 64
		y 50
		nsTop 36
		nsLeft 49
		nsBottom 65
		nsRight 79
		sightAngle 90
		approachX 63
		approachY 64
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 22) ; "A pair of women gossiping."
			)
			(5 ; Talk
				(Say 1290 4 1) ; "I've nothing to say to that person."
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person4 of FairFeature
	(properties
		x 91
		y 19
		nsTop -1
		nsLeft 79
		nsBottom 39
		nsRight 104
		sightAngle 90
		onMeCheck 4
		approachX 89
		approachY 54
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 23) ; "A townsman."
			)
			(5 ; Talk
				(Say 1290 4 1) ; "I've nothing to say to that person."
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person5 of FairFeature
	(properties
		x 105
		y 18
		nsLeft 93
		nsBottom 37
		nsRight 122
		sightAngle 90
		approachX 89
		approachY 54
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 24) ; "A man holding a bag full of something alive."
			)
			(5 ; Talk
				(if (> (gEgo y:) 100)
					(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(Converse @local18 6 @local139 0 1) ; "What is it that squirms in your bag?"
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person6 of FairFeature
	(properties
		x 139
		y 20
		nsTop -1
		nsLeft 126
		nsBottom 41
		nsRight 152
		sightAngle 90
		approachX 113
		approachY 43
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 31) ; "A woman carrying a rolled rug."
			)
			(5 ; Talk
				(if (> (gEgo y:) 100)
					(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(SetMessageColor 21)
					(Say 1290 32 80 {Mistress Baker}) ; "Shhh, I be listening to the Doomsayer."
					(SetMessageColor 0)
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person7 of FairFeature
	(properties
		x 173
		y 17
		nsTop -1
		nsLeft 163
		nsBottom 36
		nsRight 184
		sightAngle 90
		approachX 169
		approachY 39
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 33) ; "A gambler."
			)
			(5 ; Talk
				(if (> (gEgo y:) 100)
					(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(SetMessageColor 21)
					(Say 1290 34 80 {Todd Powers}) ; "Can't you see when a man's concentratin'? I've never seen such unlucky dice."
					(SetMessageColor 0)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(SetMessageColor 21)
						(Say 1290 35 80 {Todd Powers}) ; "'Tis Robert of Fischbach wot takes the wagers."
						(Say 1290 36 80 {Todd Powers}) ; "He has a pocketful of mine already."
						(SetMessageColor 0)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person8 of FairFeature
	(properties
		x 192
		y 19
		nsTop 1
		nsLeft 182
		nsBottom 37
		nsRight 202
		sightAngle 90
		approachX 182
		approachY 43
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 37) ; "A gambler."
			)
			(5 ; Talk
				(if (> (gEgo y:) 100)
					(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(SetMessageColor 21)
					(Say 1290 38 80 {Robert of Mallory}) ; "If you want to gamble, show your coins."
					(SetMessageColor 0)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(SetMessageColor 21)
						(Say 1290 39 80 {Robert of Mallory}) ; "Place your wager with me mate, Robert of Fischbach. He's the gent on the right."
						(SetMessageColor 0)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person9 of FairFeature
	(properties
		x 209
		y 19
		nsTop 2
		nsLeft 201
		nsBottom 36
		nsRight 218
		sightAngle 90
		approachX 209
		approachY 43
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 40) ; "A gambler."
			)
			(5 ; Talk
				(if (> (gEgo y:) 100)
					(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(SetMessageColor 21)
					(Say 1290 41 80 {Sir Brian de Hughes}) ; "Do not speak to me, I'm losing."
					(SetMessageColor 0)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(SetMessageColor 21)
						(Say 1290 42 80 {Sir Brian de Hughes}) ; "This man to my right has taken plenty of my money, he's sure to take yours as well."
						(SetMessageColor 0)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person10 of FairFeature
	(properties
		x 235
		y 18
		nsTop 1
		nsLeft 220
		nsBottom 36
		nsRight 245
		sightAngle 90
		onMeCheck 4
		approachX 225
		approachY 41
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 43) ; "A gambler throwing dice."
			)
			(5 ; Talk
				(cond
					((> (gEgo y:) 100)
						(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
					)
					((not (Fair doneGambled:))
						(Converse @local26 6 @local142 0 1) ; "I've a mind to throw the dice."
						(Fair doneGambled: 1)
					)
					((Fair firstAfterGambling:)
						(Converse @local31 6 @local142 0 1) ; "Is that another pair of dice I see you palming with such skill?"
						(Fair firstAfterGambling: 0)
					)
					(else
						(Say 1290 49) ; "If not for the danger of drawing attention to myself, I'd dump this fellow upon his head and see how many weighted dice fall from his sleeves!"
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(if (>= (gMoney doit:) 1)
							(gEgo setScript: gamble)
						)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person11 of FairFeature
	(properties
		x 239
		y 17
		nsLeft 230
		nsBottom 34
		nsRight 249
		sightAngle 90
		approachX 249
		approachY 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 54) ; "A woman gambler."
			)
			(5 ; Talk
				(if (> (gEgo y:) 100)
					(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(SetMessageColor 21)
					(Say 1290 55 80 {Mistress Goff}) ; "Give me my turn. Andrew needs a new pair of shoes."
					(SetMessageColor 0)
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person12 of FairFeature
	(properties
		x 272
		y 22
		nsLeft 261
		nsBottom 44
		nsRight 284
		sightAngle 90
		approachX 249
		approachY 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 56) ; "A man carrying a bent stick."
			)
			(5 ; Talk
				(cond
					((> (gEgo y:) 100)
						(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
					)
					((Fair firstCricket:)
						(Converse @local37 6 @local145 0 1) ; "What is the purpose of your odd-looking stick?"
						(Fair firstCricket: 0)
					)
					(else
						(Say 1290 66) ; "I shall not waste further speech with this unfortunate lunatic."
					)
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person13 of FairFeature
	(properties
		x 218
		y 57
		nsTop 50
		nsLeft 200
		nsBottom 64
		nsRight 237
		sightAngle 90
		approachX 223
		approachY 63
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 67) ; "The rare Nottingham Giant Armadillo."
			)
			(5 ; Talk
				(Say 1290 1 1) ; "What could one possibly say to a rare Giant Nottingham Armadillo?"
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person14 of FairFeature
	(properties
		x 250
		y 92
		z 40
		nsTop 40
		nsLeft 242
		nsBottom 65
		nsRight 259
		sightAngle 90
		approachX 246
		approachY 76
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 68) ; "A man fascinated by the large creature in the cage."
			)
			(5 ; Talk
				(if (> (gEgo y:) 100)
					(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(Converse @local49 6 @local148 0 1) ; "How came you by this creature?"
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person15 of FairFeature
	(properties
		x 287
		y 91
		z 40
		nsTop 39
		nsLeft 278
		nsBottom 64
		nsRight 296
		sightAngle 90
		approachX 282
		approachY 72
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 72) ; "A man reading something."
			)
			(5 ; Talk
				(if (> (gEgo y:) 100)
					(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(Converse @local55 6 @local151 0 1) ; "You look perplexed, good man."
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person16 of FairFeature
	(properties
		x 43
		y 117
		nsTop 95
		nsLeft 30
		nsBottom 140
		nsRight 56
		sightAngle 90
		approachX 76
		approachY 151
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 78) ; "A woman writing something."
			)
			(5 ; Talk
				(cond
					((< (gEgo y:) 100)
						(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
					)
					((Fair firstChristy:)
						(gEgo setScript: christy)
						(Fair firstChristy: 0)
					)
					(else
						(SetMessageColor 21)
						(Say 1290 84 80 {Christy Marx}) ; "It's been wonderful talking to you, but I have a lot of writing to do."
						(Say 1290 85 80 {Christy Marx}) ; "But don't be shy about writing to me!"
						(SetMessageColor 0)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(SetMessageColor 21)
						(Say 1290 86 80 {Christy Marx}) ; "Very thoughtful of you, but you might need it elsewhere."
						(SetMessageColor 0)
					)
					(17 ; handScroll
						(SetMessageColor 21)
						(Say 1290 87 80 {Christy Marx}) ; "You're not supposed to to give this to me. I hope you paid attention to what Marian told you."
						(SetMessageColor 0)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person17 of FairProp
	(properties
		x 142
		y 142
		z 30
		approachX 105
		approachY 151
		view 290
		priority 10
		signal 16400
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 88) ; "An Apothecary."
			)
			(5 ; Talk
				(cond
					((< (gEgo y:) 100)
						(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
					)
					((not (Fair boughtRoseOil:))
						(Converse @local63 6 @local154 0 1) ; "Tell me of your wares."
					)
					(else
						(SetMessageColor 21)
						(Say 1290 93 80 {Hippocrates Socrates}) ; "Do not worry about your purchase, yeoman. The lady will receive it with your compliments in a most discreet fashion."
						(SetMessageColor 0)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(if (not (Fair boughtRoseOil:))
							(if (< (gMoney doit:) 8)
								(gMoney put:)
								(SetMessageColor 21)
								(Say 1290 94 80 {Hippocrates Socrates}) ; "Forgive my impertinence, sir, but I've nothing to sell you at that price."
								(SetMessageColor 0)
							else
								(pigarm setScript: 0)
								(gCurRoom setScript: buyOil)
							)
						else
							(Say 1290 103) ; "Marian will think me profligate if I send too much. What I've purchased will do nicely."
						)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person18 of FairFeature
	(properties
		x 166
		y 127
		nsTop 102
		nsLeft 156
		nsBottom 153
		nsRight 176
		sightAngle 90
		approachX 137
		approachY 159
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 104) ; "A man with a bag of possessions."
			)
			(5 ; Talk
				(if (< (gEgo y:) 100)
					(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(Converse @local70 6 @local157 0 1) ; "What do you carry in your bag?"
				)
			)
			(3 ; Do
				(Say 1290 105) ; "I'll keep my hands to myself, or I might be mistaken for a thief."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person19 of FairFeature
	(properties
		x 217
		y 138
		nsTop 123
		nsLeft 208
		nsBottom 153
		nsRight 227
		sightAngle 90
		approachX 195
		approachY 158
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 112) ; "An ugly child."
			)
			(5 ; Talk
				(if (< (gEgo y:) 100)
					(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(Converse @local79 6 @local160 0 1) ; "Where are your parents? Have they abandoned you?"
				)
			)
			(3 ; Do
				(SetMessageColor 21)
				(Say 1290 113 80 {Ugly Child}) ; "Touch me and I'll bite you."
				(SetMessageColor 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person20 of FairFeature
	(properties
		x 265
		y 132
		nsTop 125
		nsLeft 233
		nsBottom 139
		nsRight 298
		sightAngle 90
		approachX 226
		approachY 131
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 118) ; "A drunk on a rug."
			)
			(3 ; Do
				(Say 1290 119) ; "One might as well move a log."
			)
			(5 ; Talk
				(Say 1290 8) ; "I'll get no answer from this sot."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person21 of FairFeature
	(properties
		x 259
		y 102
		z 10
		nsTop 76
		nsLeft 245
		nsBottom 109
		nsRight 274
		sightAngle 90
		approachX 249
		approachY 116
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 120) ; "A despondent man sitting upon a box."
			)
			(5 ; Talk
				(if (< (gEgo y:) 100)
					(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(Converse @local86 6 @local163 0 1) ; "What is your sorrow?"
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person22 of FairFeature
	(properties
		x 307
		y 103
		nsTop 79
		nsLeft 298
		nsBottom 128
		nsRight 316
		sightAngle 90
		approachX 285
		approachY 125
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 129) ; "A silly peasant."
			)
			(5 ; Talk
				(if (< (gEgo y:) 100)
					(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(Converse @local97 6 @local166 0 1) ; "Rumour has it that you are silly."
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person23 of FairFeature
	(properties
		x 11
		y 273
		z 100
		nsTop 157
		nsBottom 189
		nsRight 23
		sightAngle 90
		approachX 23
		approachY 177
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 133) ; "A peasant girl with her parents."
			)
			(5 ; Talk
				(Say 1290 4 1) ; "I've nothing to say to that person."
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person24 of FairFeature
	(properties
		x 49
		y 268
		z 100
		nsTop 148
		nsLeft 26
		nsBottom 189
		nsRight 73
		sightAngle 90
		approachX 23
		approachY 177
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 134) ; "A contented looking family of peasants."
			)
			(5 ; Talk
				(Say 1290 4 1) ; "I've nothing to say to that person."
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person25 of FairFeature
	(properties
		x 129
		y 283
		z 100
		nsTop 178
		nsLeft 114
		nsBottom 189
		nsRight 145
		sightAngle 90
		approachX 113
		approachY 188
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 135) ; "A woman selling eggs and vegetables."
			)
			(5 ; Talk
				(Say 1290 4 1) ; "I've nothing to say to that person."
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person26 of FairFeature
	(properties
		x 192
		y 267
		z 100
		nsTop 148
		nsLeft 174
		nsBottom 186
		nsRight 211
		sightAngle 90
		approachX 204
		approachY 176
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 136) ; "A man grooming a pig."
			)
			(5 ; Talk
				(if (< (gEgo y:) 100)
					(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(Converse @local103 @local169 6 0 1) ; "Greetings, sir. I see you're admiring my large and stalwart boar."
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person27 of FairFeature
	(properties
		x 229
		y 274
		z 100
		nsTop 160
		nsLeft 199
		nsBottom 189
		nsRight 260
		sightAngle 90
		approachX 228
		approachY 175
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 142) ; "A healthy looking boar."
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(Say 1290 143) ; "And thus was the piggy bank invented."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(5 ; Talk
				(SetMessageColor 21)
				(Say 1290 0 1) ; "Know what I like about Robin Hood? I hear he robs from the rich and gives to the pork."
				(SetMessageColor 0)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance person28 of FairFeature
	(properties
		x 291
		y 267
		z 100
		nsTop 151
		nsLeft 270
		nsBottom 184
		nsRight 312
		sightAngle 90
		approachX 253
		approachY 165
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 144) ; "A woman selling rugs."
			)
			(5 ; Talk
				(if (< (gEgo y:) 100)
					(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(Converse @local111 6 @local172 0 1) ; "These are most excellent rugs, tightly woven, expertly dyed."
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance table1 of FairFeature
	(properties
		x 297
		y 13
		nsTop 4
		nsLeft 280
		nsBottom 23
		nsRight 315
		sightAngle 90
		approachX 297
		approachY 32
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 150) ; "A box of knickknacks."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wall of FairFeature
	(properties
		x 159
		y 81
		nsTop 64
		nsBottom 99
		nsRight 319
		sightAngle 90
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 151) ; "The wall runs the length of the Fair and divides the merchants."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance barrel1 of FairFeature
	(properties
		x 24
		y 57
		nsTop 52
		nsLeft 4
		nsBottom 63
		nsRight 44
		sightAngle 90
		approachX 16
		approachY 71
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 152) ; "A barrel."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance table2 of FairFeature
	(properties
		x 16
		y 95
		nsTop 84
		nsLeft 3
		nsBottom 107
		nsRight 29
		sightAngle 90
		approachX 45
		approachY 108
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 153) ; "The small table holds the woman's inkpots and writing supplies."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance barrels2 of FairFeature
	(properties
		x 79
		y 118
		nsTop 94
		nsLeft 58
		nsBottom 142
		nsRight 101
		sightAngle 90
		approachX 106
		approachY 108
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 154) ; "Barrels."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stall of FairFeature
	(properties
		x 152
		y 98
		nsTop 47
		nsLeft 111
		nsBottom 149
		nsRight 193
		sightAngle 90
		approachX 105
		approachY 151
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 155) ; "The Apothecary's stall."
			)
			(3 ; Do
				(SetMessageColor 21)
				(Say 1290 156 80 {Hippocrates Socrates}) ; "Speak up if I may be of assistance."
				(SetMessageColor 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance crate of FairFeature
	(properties
		x 225
		y 109
		nsTop 96
		nsLeft 207
		nsBottom 122
		nsRight 243
		sightAngle 90
		approachX 207
		approachY 123
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 157) ; "'Tis a sorry lot of junk sitting atop the crate."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rugs1 of FairFeature
	(properties
		x 281
		y 114
		nsTop 109
		nsLeft 259
		nsBottom 119
		nsRight 303
		sightAngle 90
		approachX 249
		approachY 116
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 158) ; "They're rolled rugs."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rugs2 of FairFeature
	(properties
		x 289
		y 155
		nsTop 149
		nsLeft 260
		nsBottom 162
		nsRight 318
		sightAngle 90
		approachX 264
		approachY 150
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 159) ; "Those are large, rolled rugs."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bottle of View
	(properties
		x 156
		y 83
		view 290
		loop 1
	)
)

(instance doom of FairProp
	(properties
		x 48
		y 105
		z 100
		sightAngle 45
		approachX 20
		approachY 58
		view 290
		loop 2
		priority 1
		signal 16400
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 12) ; "A Doomsayer."
			)
			(5 ; Talk
				(if (> (gEgo y:) 100)
					(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(Converse @local6 @local136 6 0 1) ; "The End is Coming! The Millenium draws to an end and the Time of Judgement is upon us!"
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance arm of FairProp
	(properties
		x 224
		y 10
		sightAngle 45
		approachX 249
		approachY 40
		view 290
		loop 3
		priority 1
		signal 16400
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 43) ; "A gambler throwing dice."
			)
			(5 ; Talk
				(cond
					((> (gEgo y:) 100)
						(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
					)
					((not (Fair doneGambled:))
						(Converse @local26 6 @local142 0 1) ; "I've a mind to throw the dice."
						(Fair doneGambled: 1)
					)
					((Fair firstAfterGambling:)
						(Converse @local31 6 @local142) ; "Is that another pair of dice I see you palming with such skill?"
						(Fair firstAfterGambling: 0)
					)
					(else
						(Say 1290 49) ; "If not for the danger of drawing attention to myself, I'd dump this fellow upon his head and see how many weighted dice fall from his sleeves!"
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(gMoney doit:)
						(gEgo setScript: gamble)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance head of FairProp
	(properties
		x 258
		y 106
		z 20
		sightAngle 45
		approachX 249
		approachY 116
		view 290
		loop 4
		priority 7
		signal 16400
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 120) ; "A despondent man sitting upon a box."
			)
			(5 ; Talk
				(if (< (gEgo y:) 100)
					(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(Converse @local86 6 @local163 0 1) ; "What is your sorrow?"
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance carm1 of FairProp
	(properties
		x 36
		y 105
		sightAngle 45
		approachX 76
		approachY 151
		view 290
		loop 5
		priority 10
		signal 16400
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 78) ; "A woman writing something."
			)
			(5 ; Talk
				(cond
					((< (gEgo y:) 100)
						(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
					)
					((Fair firstChristy:)
						(gEgo setScript: christy)
						(Fair firstChristy: 0)
					)
					(else
						(SetMessageColor 21)
						(Say 1290 84 80 {Christy Marx}) ; "It's been wonderful talking to you, but I have a lot of writing to do."
						(Say 1290 85 80 {Christy Marx}) ; "But don't be shy about writing to me!"
						(SetMessageColor 0)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(SetMessageColor 21)
						(Say 1290 86 80 {Christy Marx}) ; "Very thoughtful of you, but you might need it elsewhere."
						(SetMessageColor 0)
					)
					(17 ; handScroll
						(SetMessageColor 21)
						(Say 1290 87 80 {Christy Marx}) ; "You're not supposed to to give this to me. I hope you paid attention to what Marian told you."
						(SetMessageColor 0)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance carm2 of FairProp
	(properties
		x 50
		y 105
		sightAngle 45
		approachX 76
		approachY 151
		view 290
		loop 6
		priority 10
		signal 16400
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 78) ; "A woman writing something."
			)
			(5 ; Talk
				(cond
					((< (gEgo y:) 100)
						(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
					)
					((Fair firstChristy:)
						(gEgo setScript: christy)
						(Fair firstChristy: 0)
					)
					(else
						(SetMessageColor 21)
						(Say 1290 84 80 {Christy Marx}) ; "It's been wonderful talking to you, but I have a lot of writing to do."
						(Say 1290 85 80 {Christy Marx}) ; "But don't be shy about writing to me!"
						(SetMessageColor 0)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(SetMessageColor 21)
						(Say 1290 86 80 {Christy Marx}) ; "Very thoughtful of you, but you might need it elsewhere."
						(SetMessageColor 0)
					)
					(17 ; handScroll
						(SetMessageColor 21)
						(Say 1290 87 80 {Christy Marx}) ; "You're not supposed to to give this to me. I hope you paid attention to what Marian told you."
						(SetMessageColor 0)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pigarm of FairProp
	(properties
		x 203
		y 165
		sightAngle 45
		approachX 204
		approachY 176
		view 290
		loop 7
		priority 14
		signal 16400
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 136) ; "A man grooming a pig."
			)
			(5 ; Talk
				(if (< (gEgo y:) 100)
					(Say 1290 7) ; "With all the noise of the Fair, I must get closer if I'm to be heard."
				else
					(Converse @local103 @local169 6 0 1) ; "Greetings, sir. I see you're admiring my large and stalwart boar."
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tail of FairProp
	(properties
		x 257
		y 163
		sightAngle 45
		approachX 204
		approachY 176
		view 290
		loop 8
		priority 14
		signal 16400
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say 1290 142) ; "A healthy looking boar."
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						(Say 1290 143) ; "And thus was the piggy bank invented."
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(3 ; Do
				(Say 1290 3 1) ; "I'll keep my hands to myself around here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance gamble of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetMessageColor 21)
				(arm setCycle: Beg self)
			)
			(1
				(SayModeless 1290 50 self 80 {Robert of Fischbach}) ; "Patch's wager is laid. I'll throw first."
			)
			(2
				(arm setCycle: End self)
			)
			(3
				(SayModeless 1290 51 self 80 {Robert of Fischbach}) ; "A good throw! Best that if you can, Patch. Here's the dice."
			)
			(4
				(gEgo setMotion: PolyPath 195 45 self)
			)
			(5
				(gEgo view: 52 setCycle: End self)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(SayModeless 1290 52 self 80 {Robert of Fischbach}) ; "You lose. Next wager?"
				(SetMessageColor 0)
			)
			(8
				(SayModeless 1290 53 self) ; "Methinks the man has more than one pair of dice up his sleeves."
			)
			(9
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance christy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetMessageColor 21)
				(Say 1290 79 self 80 {Christy Marx}) ; "Congratulations! You've found me!"
			)
			(1
				(Say 1290 80 self 80 {Christy Marx}) ; "I suppose you'll want to be rewarded. Here, I'll give you some points."
			)
			(2
				(SetScore 600)
				(Say 1290 81 self 80 {Christy Marx}) ; "Oops. Got a little carried away there. Excuse me while I fix it."
			)
			(3
				(SetScore -900)
				(Say 1290 82 self 80 {Christy Marx}) ; "Sorry. Didn't mean to do that! Let me give it one more try."
			)
			(4
				(SetScore 300)
				(Say 1290 83 self 80 {Christy Marx}) ; "I think I'd better leave well enough alone."
			)
			(5
				(HandsOn)
				(SetMessageColor 0)
				(self dispose:)
			)
		)
	)
)

(instance buyOil of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				(if (not (person17 cel:))
					(self cue:)
				else
					(person17 setCycle: Beg self)
				)
			)
			(2
				(= ticks 10)
			)
			(3
				(SetScore 25)
				(Fair boughtRoseOil: 1)
				(Converse @local119 6 @local154 self 1) ; "What's your desire, sir?"
			)
			(4
				(person17 setCycle: End self)
			)
			(5
				(bottle hide:)
				(= cycles 2)
			)
			(6
				(person17 setCycle: Beg self)
			)
			(7
				(bottle posn: 141 114 show:)
				(= cycles 3)
			)
			(8
				(Converse @local126 6 @local154 self 1) ; "Aye, that is perfect! But I cannot take it to the Lady myself, for reasons of delicacy."
			)
			(9
				(HandsOn)
				(pigarm setScript: sRandom)
				(self dispose:)
			)
		)
	)
)

(instance sRandom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (Random 0 8)
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
						(self changeState: 50)
					)
					(5
						(self changeState: 60)
					)
					(6
						(self changeState: 70)
					)
					(else
						(= state -1)
						(= ticks (Random 20 60))
					)
				)
			)
			(10
				(person17
					startUpd:
					cycleSpeed: (Random 10 20)
					setCycle: End self
				)
			)
			(11
				(person17 cycleSpeed: (Random 10 20) setCycle: Beg self)
			)
			(12
				(person17 stopUpd:)
				(= state -1)
				(= ticks (Random 20 60))
			)
			(20
				(doom startUpd: cycleSpeed: (Random 10 20) setCycle: End self)
			)
			(21
				(doom cycleSpeed: (Random 10 20) setCycle: Beg self)
			)
			(22
				(doom stopUpd:)
				(= state -1)
				(= ticks (Random 20 60))
			)
			(30
				(head startUpd: cycleSpeed: (Random 10 20) setCycle: End self)
			)
			(31
				(head cycleSpeed: (Random 10 20) setCycle: Beg self)
			)
			(32
				(head stopUpd:)
				(= state -1)
				(= ticks (Random 20 60))
			)
			(40
				(carm1 startUpd: cycleSpeed: (Random 10 20) setCycle: End self)
			)
			(41
				(carm1 cycleSpeed: (Random 10 20) setCycle: Beg self)
			)
			(42
				(carm1 stopUpd:)
				(= state -1)
				(= ticks (Random 20 60))
			)
			(50
				(carm2 startUpd: cycleSpeed: (Random 10 20) setCycle: End self)
			)
			(51
				(carm2 cycleSpeed: (Random 10 20) setCycle: Beg self)
			)
			(52
				(carm2 stopUpd:)
				(= state -1)
				(= ticks (Random 20 60))
			)
			(60
				(pigarm startUpd: cycleSpeed: (Random 10 20) setCycle: End self)
			)
			(61
				(pigarm cycleSpeed: (Random 10 20) setCycle: Beg self)
			)
			(62
				(pigarm stopUpd:)
				(= state -1)
				(= ticks (Random 20 60))
			)
			(70
				(tail startUpd: cycleSpeed: (Random 10 20) setCycle: End self)
			)
			(71
				(tail cycleSpeed: (Random 10 20) setCycle: Beg self)
			)
			(72
				(tail stopUpd:)
				(= state -1)
				(= ticks (Random 20 60))
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
					(gCurRoom newRoom: 300)
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
					(gCurRoom newRoom: 280)
				else
					(-- state)
					(= cycles 1)
				)
			)
		)
	)
)

