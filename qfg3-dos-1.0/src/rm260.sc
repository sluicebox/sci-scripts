;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
(include sci.sh)
(use Main)
(use Teller)
(use Vendor)
(use bazaarR)
(use GloryTalker)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm260 0
	kattaTalker 1
	meatTalker 2
	amuletTalker 3
	clothTalker 4
)

(local
	local0
	local1
	local2
	local3
	local4 = 1
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	[local12 17] = [0 -80 -81 -10 -82 43 -84 -38 -39 -40 -41 -42 -47 68 73 -74 999]
	[local29 2]
	[local31 7] = [0 8 -85 9 -78 23 999]
	[local38 2]
	[local40 6] = [0 -47 9 -78 -87 999]
	[local46 3] = [0 48 999]
	[local49 3] = [0 -47 999]
	[local52 3]
	[local55 6] = [0 59 9 -78 -88 999]
	[local61 2]
	[local63 6] = [0 -75 9 78 79 999]
	[local69 4] = [0 76 77 999]
	[local73 3] = [0 -75 999]
	[local76 3]
	[local79 3]
)

(procedure (localproc_0)
	(if (> (++ local3) 2)
		(if (or (== (meatGreet state:) -1) (== (meatGreet state:) 5))
			(= local3 0)
		else
			(= local3 1)
		)
	)
	(= local4 0)
	([local79 local3] cel: 0 setCycle: End aMeatSeller)
)

(instance rm260 of Rm
	(properties
		noun 31
		picture 260
		horizon -300
	)

	(method (init)
		(self setRegions: 51) ; bazaarR
		(gEgo noun: 2 normalize: edgeHit: EDGE_NONE init:)
		(HandsOn)
		(switch gPrevRoomNum
			(250
				(= style -32759)
				(self setScript: from250)
			)
			(else
				(gEgo x: 112 y: 88)
			)
		)
		(super init:)
		(if (or gNight (IsFlag 135))
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 0 319 84 267 68 225 62 190 54 124 64 59 21 149 0
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 0 189 0 68 141 161 125 165 99 177 93 186 319 185 318 189
						yourself:
					)
			)
		else
			(gLongSong fade: 127 10 5 0)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 150 183 150 144 171 144 171 127 213 127 225 153 219 174 193 183
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 0 319 189 0 189 0 66 138 159 99 187 295 187 295 111 241 79 266 73 263 68 234 71 214 59 193 63 201 73 152 84 109 74 103 58 80 60 36 34 64 27 65 0
						yourself:
					)
			)
			(= [local29 0] @local12)
			(egoTeller init: gEgo @local12 @local29)
			(if (not (IsFlag 141))
				(bowl approachVerbs: 4 1 10 59 init: addToPic:) ; Do, Look, Money, theRoyals
			)
			(kattaVendor
				init:
				goods:
					((List new:)
						add:
							((Class_47_1 new: 1)
								price: 5
								quantity: (if (IsFlag 169) 0 else 1)
							)
					)
			)
			(= [local38 0] @local31)
			(kattaTeller init: aKattaMerchant @local31 @local38)
			(aKattaMerchant
				init:
				actions: kattaTeller
				approachVerbs: 2 59 10 ; Talk, theRoyals, Money
				stopUpd:
			)
			(meatVendor
				init:
				goods:
					((List new:)
						add:
							((Class_47_1 new: 3)
								price: 27
								denomination: 1
								quantity: 999
							)
					)
			)
			(= [local52 0] @local40)
			(= [local52 1] @local46)
			(meatTeller init: aMeatSeller @local40 @local52 @local49)
			(aMeatSeller actions: meatTeller approachVerbs: 2 59 10 stopUpd:) ; Talk, theRoyals, Money
			(= [local61 0] @local55)
			(amuletTeller init: aAmuletSeller @local55 @local61)
			(aAmuletUpper actions: amuletTeller approachVerbs: 2 59 10 stopUpd:) ; Talk, theRoyals, Money
			(aAmuletSeller
				actions: amuletTeller
				approachVerbs: 2 59 10 ; Talk, theRoyals, Money
				init:
				stopUpd:
			)
			(clothVendor
				init:
				goods:
					((List new:)
						add:
							((Class_47_1 new: 5)
								price: 10
								quantity: (if (IsFlag 170) 0 else 1)
							)
					)
			)
			(= [local76 0] @local63)
			(= [local76 1] @local69)
			(clothTeller init: aClothSeller @local63 @local76 @local73)
			(aClothSeller actions: clothTeller approachVerbs: 2 59 10 stopUpd:) ; Talk, theRoyals, Money
			(aDrummer init: approachVerbs: 4 2 59 10 setScript: drummerScript) ; Do, Talk, theRoyals, Money
			(= [local79 0] (aMeatSeller init:))
			(= [local79 1] (aAmuletUpper init:))
			(= [local79 2] (aClothSeller init:))
		)
		(if (and (not gNight) (not (IsFlag 135)))
			(musical_sticks init:)
			(upper_katta_carvings init:)
			(lower_katta_carvings init:)
			(kattarug init:)
			(animalcarcass init:)
			(hotdogs init:)
			(tabletop init:)
			(deadducks init:)
			(ham init:)
			(back_meat_table init:)
			(meatstand init:)
			(stairs init:)
			(amuletrack init:)
			(amuletbeads init:)
			(amuletstand init:)
			(clothracks init:)
			(cloth_on_tent init:)
			(clothstand init:)
			(morecloth init:)
			(purpletents init:)
		)
		(water init:)
		(if (and (not gNight) (not (IsFlag 135)))
			(gEgo code: dayCode)
			(meatStuff init: addToPic:)
			(clothStuff init: addToPic:)
			(drumsUpper init: addToPic:)
			(drumsLower init: addToPic:)
			(kattaStuff init: addToPic:)
		else
			(gEgo code: nightCode)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager
					say: 31 1 0 (if (or (IsFlag 135) gNight) 0 else 1)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance dayCode of Code
	(properties)

	(method (doit)
		(if local4
			(localproc_0)
		)
		(cond
			((gCurRoom script:) 0)
			((< (gEgo x:) 5)
				(gCurRoom setScript: sExit)
			)
			((< (gEgo y:) 35)
				(gCurRoom setScript: sExit)
			)
			((& (gEgo onControl: 1) $0004)
				(if (not local7)
					(gCurRoom setScript: kattaGreet)
					(= local7 1)
				)
			)
			((& (gEgo onControl: 1) $0008)
				(if (not local8)
					(gCurRoom setScript: meatGreet)
					(= local8 1)
				)
			)
			((& (gEgo onControl: 1) $0010)
				(if (not local9)
					(gCurRoom setScript: amuletGreet)
					(= local9 1)
				)
			)
			((and (& (gEgo onControl: 1) $0020) (not local10))
				(gCurRoom setScript: clothGreet)
				(= local10 1)
			)
		)
	)
)

(instance nightCode of Code
	(properties)

	(method (doit)
		(cond
			((gCurRoom script:) 0)
			((< (gEgo x:) 5)
				(gCurRoom setScript: sExit)
			)
			((< (gEgo y:) 35)
				(gCurRoom setScript: sExit)
			)
		)
	)
)

(instance giveMoney of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 4 cel: 0 solvePuzzle: 236 3 setCycle: End self)
			)
			(1
				(cond
					((== register 4)
						(cond
							((and [global211 8] (not (IsFlag 141)))
								(cond
									((== ((gInventory at: 0) message:) 59) ; theRoyals
										(gMessager say: 6 6 86 0 self) ; "The drummer looks at your dinars and shakes his head. He doesn't seem to recognize them as money."
									)
									(
										(and
											(== ((gInventory at: 0) amount:) 0) ; theRoyals
											(not global410)
										)
										(gMessager say: 6 6 90 0 self) ; "The thought is very kind, but you find yourself unable to give money to the drummer from your empty purse."
									)
									(else
										(if global410
											(-= global410 1)
										else
											(((gInventory at: 0) ; theRoyals
													amount:
														(-
															((gInventory at: 0) ; theRoyals
																amount:
															)
															1
														)
												)
											)
											(+= global410 99)
										)
										(sFx number: 260 play:)
										(if (< (gEgo trySkill: 8 150) 0) ; sneak
											(gMessager say: 6 6 94 0 self) ; "You try to switch a common for a royal in the money cup, but you are not skilled enough at sneaking. You just lost your common."
										else
											(((gInventory at: 0) ; theRoyals
													amount:
														(+
															((gInventory at: 0) ; theRoyals
																amount:
															)
															1
														)
												)
											)
											(SetFlag 141)
											(gMessager say: 6 6 95 0 self) ; "You stealthily swap your common for a royal from the cup."
										)
									)
								)
							)
							((and [global211 8] (IsFlag 141))
								(gMessager say: 6 6 97 0 self) ; "You'd better not try again, someone might get suspicious."
							)
							((== ((gInventory at: 0) message:) 59) ; theRoyals
								(gMessager say: 6 6 86 0 self) ; "The drummer looks at your dinars and shakes his head. He doesn't seem to recognize them as money."
							)
							(else
								(= register 10)
								(self changeState: (-= state 1))
								(self cue:)
							)
						)
					)
					((== ((gInventory at: 0) amount:) 0) ; theRoyals
						(if (< global410 11)
							(gMessager say: 6 6 90 0 self) ; "The thought is very kind, but you find yourself unable to give money to the drummer from your empty purse."
						else
							(-= global410 10)
							(sFx number: 260 play:)
							(gMessager say: 6 6 24 0 self) ; "The drummer smiles at you as you give him 10 commons."
							(gEgo addHonor: 5)
						)
					)
					(else
						(sFx number: 260 play:)
						(if (< global410 11)
							(((gInventory at: 0) ; theRoyals
									amount: (- ((gInventory at: 0) amount:) 1) ; theRoyals
								)
							)
							(+= global410 90)
						else
							(-= global410 10)
						)
						(gMessager say: 6 6 24 0 self) ; "The drummer smiles at you as you give him 10 commons."
						(gEgo addHonor: 5)
					)
				)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance clothGreet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 263 84 self)
			)
			(1
				(Face gEgo aClothSeller)
				(= cycles 15)
			)
			(2
				(gMessager say: 5 6 80 0 self) ; "Good day, effendi."
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance meatGreet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 181 79 self)
			)
			(1
				(if (aMeatSeller cycler:)
					(= local4 1)
				)
				(aMeatSeller setCel: 8 setLoop: 1 setCycle: CT 0 -1 self)
			)
			(2
				(Face gEgo aMeatSeller self)
			)
			(3
				(aMeatSeller cel: 0 setLoop: 2 setCycle: End self)
			)
			(4
				(switch (mod gDay 6)
					(0
						(gMessager say: 3 6 2 0 self) ; "Good day, Master. How may this worthless son of a dog serve you? Perhaps you would like some meat? May I sell you some meat, please?"
					)
					(1
						(gMessager say: 3 6 3 0 self) ; "Hello, Master, hello. May this mangy cur be of service to you? May I have the pleasure of selling some tasty meat to you?"
					)
					(2
						(gMessager say: 3 6 4 0 self) ; "Master! I am so honored to see you again. May this hairy, dirty dog of an animal please sell some meat to you?"
					)
					(3
						(gMessager say: 3 6 5 0 self) ; "So wonderful, so great, so marvelous to see you again, Master. Will you buy some meat from this filthy, feeble, flea-ridden, fur-covered, father of starving puppies? Pretty please, with catsup on it?"
					)
					(4
						(gMessager say: 3 6 6 0 self) ; "Master, may I roll in the dirt beneath your feet? May I lick your toes? May this musty, mangy, miserable, mindless, misbegotten maggot of a mongrel sell you some meat?"
					)
					(5
						(gMessager say: 3 6 7 0 self) ; "O wondrous and worthy hero of hundreds! O unbelievably great and glorious Master of millions! I am not worthy even to sniff your behind. Please take pity upon this pathetic, piddling, pest-ridden, penniless pauper of a pooch."
					)
				)
			)
			(5
				(HandsOn)
				(aMeatSeller setLoop: 1 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance kattaGreet of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 66 52 self)
			)
			(1
				(if
					(and
						(not (aKattaMerchant loop:))
						(not (aKattaMerchant cel:))
					)
					(aKattaMerchant setCycle: End self)
				else
					(= cycles 15)
				)
				(Face gEgo aKattaMerchant)
			)
			(2
				(switch (mod gDay 6)
					(0
						(gMessager say: 1 6 2 0 self) ; "Greetings, effendi. May I interest you in my carvings of wood?"
					)
					(1
						(gMessager say: 1 6 3 0 self) ; "Good day, effendi."
					)
					(2
						(gMessager say: 1 6 4 0 self) ; "Welcome again, friend of the Katta."
					)
					(3
						(gMessager say: 1 6 5 0 self) ; "Nharak sa'id, Prince of Shapeir."
					)
					(4
						(gMessager say: 1 6 6 0 self) ; "Hello again, my friend."
					)
					(5
						(gMessager say: 1 6 7 0 self) ; "I am most pleased to see you again, peace bringer."
					)
				)
			)
			(3
				(aKattaMerchant setCycle: CT 0 -1 self)
			)
			(4
				(HandsOn)
				(aKattaMerchant stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance amuletGreet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 259 69 self)
			)
			(1
				(Face gEgo aAmuletSeller)
				(= cycles 15)
			)
			(2
				(switch (mod gDay 6)
					(0
						(gMessager say: 4 6 2 0 self) ; "Amulets! Protect yourself from all misfortune! Amulets!"
					)
					(1
						(gMessager say: 4 6 3 0 self) ; "I have an amulet guaranteed to ward off moose."
					)
					(2
						(gMessager say: 4 6 4 0 self) ; "Here is an amulet you should carry, bwana. It protects against arthritis and rheumatism."
					)
					(3
						(gMessager say: 4 6 5 0 self) ; "Amulets! Would you like an amulet which makes all women want to kiss you?"
					)
					(4
						(gMessager say: 4 6 6 0 self) ; "Amulets! This amulet will allow you to sell anything to anyone."
					)
					(5
						(gMessager say: 4 6 7 0 self) ; "Amulets! Here is an amulet that wards away unwanted guests!"
					)
				)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance purchaseLeopard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 2 5 46 0 self) ; "You decide to purchase the carved leopard from the Katta."
			)
			(1
				(kattaVendor purchase:)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance from250 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo x: 20 y: 0 edgeHit: EDGE_NONE setMotion: PolyPath 40 53 self)
			)
			(1
				(gEgo setHeading: 135 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((<= (gEgo x:) 5)
						(= register 250)
						(gEgo setMotion: PolyPath 0 0 self)
					)
					((<= (gEgo y:) 35)
						(= register 250)
						(gEgo setMotion: PolyPath (gEgo x:) 0 self)
					)
				)
			)
			(1
				(gCurRoom newRoom: register)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance drummerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aDrummer setLoop: (Random 0 1) setCycle: Fwd)
				(= seconds (Random 3 8))
			)
			(1
				(if (Random 0 3)
					(self init:)
				else
					(gLongSong stop:)
					(aDrummer setLoop: 0 setCycle: 0 cel: 4)
					(= seconds 15)
				)
			)
			(2
				(gLongSong play:)
				(self init:)
			)
		)
	)
)

(instance egoTeller of Teller
	(properties)

	(method (showDialog &tmp temp0)
		(= local1 (proc51_1))
		(= temp0 (gEgo distanceTo: local1))
		(switch local1
			(aKattaMerchant
				(if (> temp0 35)
					(gMessager say: 6 6 83) ; "Which merchant do you want to talk to?"
					(return -999)
				)
			)
			(aMeatSeller
				(if (> temp0 35)
					(gMessager say: 6 6 83) ; "Which merchant do you want to talk to?"
					(return -999)
				)
			)
			(aClothSeller
				(if (> temp0 25)
					(gMessager say: 6 6 83) ; "Which merchant do you want to talk to?"
					(return -999)
				)
			)
			(else
				(if (> temp0 15)
					(gMessager say: 6 6 83) ; "Which merchant do you want to talk to?"
					(return -999)
				)
			)
		)
		(if
			(!=
				(gEgo heading:)
				(GetAngle (gEgo x:) (gEgo y:) (local1 x:) (local1 y:))
			)
			(Face gEgo local1)
		)
		((Timer new:) setCycle: self (+ (gEgo cycleSpeed:) 10))
		(= iconValue 0)
		(return -999)
	)

	(method (cue)
		(= query
			(super
				showDialog:
					-80 ; "Greet"
					-81
					-10 ; "Tell about Shapeir"
					(and
						(!= local6 2)
						(!= local6 4)
						(!= local6 6)
						(== local1 aKattaMerchant)
					)
					-38 ; "Tell about Shema"
					(and (== local1 aKattaMerchant) (== local6 2))
					-39 ; "Tell about Shameen"
					(and (== local1 aKattaMerchant) (== local6 4))
					-40 ; "Tell More about Shapeir"
					(and (== local1 aKattaMerchant) (== local6 6))
					-41 ; "Tell about Peace"
					(and (== local1 aKattaMerchant) (== local5 3))
					-42 ; "Tell about War"
					(and (== local1 aKattaMerchant) (== local5 5))
					-82 ; "Buy Carving"
					(== local1 aKattaMerchant)
					43 ; "Tell about Leopard Lady"
					(and
						(== local1 aKattaMerchant)
						(IsFlag 38)
						(not (IsFlag 146))
					)
					-84 ; "Make Thief's Sign"
					(== gHeroType 2) ; Thief
					-47 ; "Buy Meat"
					(== local1 aMeatSeller)
					68 ; "Buy Amulet"
					(== local1 aAmuletSeller)
					73 ; "Buy Cloth"
					(== local1 aClothSeller)
					-74 ; "Buy Robe"
					(and (== local1 aClothSeller) (not (IsFlag 114)))
			)
		)
		(= local2 1)
		(if iconValue
			(= query iconValue)
		)
		(egoTeller respond:)
	)

	(method (respond)
		(if (not local2)
			(super respond:)
		else
			(= local2 0)
			(cond
				((not query)
					(return 1)
				)
				((== query -999)
					(return 1)
				)
				((== query 999)
					(self doParent:)
					(return 0)
				)
				((and (< query 0) (not (self doChild: query)))
					(return 1)
				)
			)
			(if (< query 0)
				(= query (- query))
			)
			(gMessager say: (client noun:) 5 query 0)
			(return 1)
		)
	)

	(method (doChild &tmp [temp0 2])
		(switch query
			(-80 ; "Greet"
				(cond
					((== local1 aKattaMerchant)
						(= query 36)
					)
					((== local1 aMeatSeller)
						(= query 56)
					)
					((== local1 aAmuletUpper)
						(= query 66)
					)
					((== local1 aClothSeller)
						(= query 70)
					)
				)
			)
			(-81 ; "Say Good-bye"
				(cond
					((== local1 aKattaMerchant)
						(= query 37)
					)
					((== local1 aMeatSeller)
						(= query 57)
					)
					((== local1 aAmuletUpper)
						(= query 67)
					)
					((== local1 aClothSeller)
						(= query 71)
					)
				)
			)
			(-10 ; "Tell about Shapeir"
				(if (not (IsFlag 233))
					(gEgo addHonor: 25)
				)
				(gEgo solvePuzzle: 233 3)
				(if (== local6 6)
					(gEgo addHonor: 5)
					(gMessager say: 2 5 40) ; "You tell about the Katta merchants you met and aided in Shapeir."
					(return 0)
				else
					(return query)
				)
			)
			(-84 ; "Make Thief's Sign"
				(cond
					((== local1 aKattaMerchant)
						(= query 35)
					)
					((== local1 aMeatSeller)
						(= query 55)
					)
					((== local1 aAmuletUpper)
						(= query 69)
					)
					((== local1 aClothSeller)
						(= query 72)
					)
				)
			)
			(-82 ; "Buy Carving"
				(kattaTeller doVerb: 10)
				(return 0)
			)
			(-38 ; "Tell about Shema"
				(gEgo addHonor: 10)
				(return 1)
			)
			(-39 ; "Tell about Shameen"
				(gEgo addHonor: 10)
				(return 1)
			)
			(-40 ; "Tell More about Shapeir"
				(gEgo addHonor: 5)
				(return 1)
			)
			(-41 ; "Tell about Peace"
				(gEgo addHonor: 5)
				(return 1)
			)
			(-42 ; "Tell about War"
				(gEgo addHonor: 5)
				(return 1)
			)
			(-47 ; "Buy Meat"
				(if (== ((gInventory at: 0) message:) 59) ; theRoyals
					(gMessager say: 3 6 86) ; "Uh, Master, this is ... that is.... well, I can't take this money, Master. Sorry."
				else
					(meatVendor purchase:)
				)
				(return 0)
			)
			(-74 ; "Buy Robe"
				(if (== ((gInventory at: 0) message:) 59) ; theRoyals
					(gMessager say: 5 6 86) ; "This is not the money of Tarna. Before you can buy something, you must visit the money changer."
				else
					(clothVendor purchase:)
				)
				(return 0)
			)
		)
	)
)

(instance kattaTeller of Teller
	(properties)

	(method (showDialog)
		(super showDialog: 23 (gEgo has: 28)) ; "Sapphire Pin", thePin
	)

	(method (doChild)
		(switch query
			(-78 ; "Rumors"
				(if (IsFlag 38)
					(= query 27)
				else
					(switch (mod gDay 6)
						(0
							(= query 11)
							(= local5 1)
						)
						(1
							(= query 13)
							(= local5 2)
						)
						(2
							(= query 12)
							(= local5 3)
						)
						(3
							(= query 14)
							(= local5 4)
						)
						(4
							(= query 15)
							(= local5 5)
						)
						(5
							(= query 16)
							(= local5 6)
						)
					)
				)
			)
			(-85 ; "Katta"
				(if (IsFlag 38)
					(= query 28)
				else
					(switch (mod gDay 6)
						(0
							(= query 17)
							(= local6 1)
						)
						(1
							(= query 18)
							(= local6 2)
						)
						(2
							(= query 19)
							(= local6 3)
						)
						(3
							(= query 20)
							(= local6 4)
						)
						(4
							(= query 21)
							(= local6 5)
						)
						(5
							(= query 22)
							(= local6 6)
						)
					)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(59 ; theRoyals
				(gMessager say: 1 6 86) ; "I am most sorry, but I cannot take dinars here. You must go first to the money changer. It is good to see coin of my homeland again, though."
			)
			(10 ; Money
				(cond
					((and (IsFlag 108) (not (IsFlag 146)))
						(gMessager say: 2 5 45) ; "You decide to buy the carved leopard."
						(SetFlag 146)
						(gEgo get: 32 solvePuzzle: 232 2) ; theLeopard
					)
					((not (IsFlag 146))
						(if (== ((gInventory at: 0) message:) 59) ; theRoyals
							(gMessager say: 1 6 86) ; "I am most sorry, but I cannot take dinars here. You must go first to the money changer. It is good to see coin of my homeland again, though."
						else
							(gCurRoom setScript: purchaseLeopard)
						)
					)
					(else
						(gMessager say: 2 5 44) ; "You see many fine carvings of animals, but nothing you really need."
					)
				)
			)
			(54 ; theNote
				(SetFlag 108)
				(gEgo drop: 43 addHonor: 50 solvePuzzle: 234 5) ; theNote
				(gMessager say: 1 54 0) ; "Thank you for your kindness in bringing me this note from my aunt Shema. It is so wonderful to have news of home. It is sad to be so far from Shapeir and those for which I care."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance meatTeller of Teller
	(properties)

	(method (doChild)
		(switch query
			(-78 ; "Rumors"
				(switch (mod gDay 6)
					(0
						(= query 11)
					)
					(1
						(= query 13)
					)
					(2
						(= query 12)
					)
					(3
						(= query 14)
					)
					(4
						(= query 15)
					)
					(5
						(= query 16)
					)
				)
			)
			(-87 ; "Meat Seller"
				(switch (mod gDay 6)
					(0
						(= query 49)
					)
					(1
						(= query 50)
					)
					(2
						(= query 51)
					)
					(3
						(= query 52)
					)
					(4
						(= query 53)
					)
					(5
						(= query 54)
					)
				)
			)
			(else
				(super doChild: &rest)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(59 ; theRoyals
				(gMessager say: 3 6 86) ; "Uh, Master, this is ... that is.... well, I can't take this money, Master. Sorry."
			)
			(10 ; Money
				(meatVendor purchase:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance amuletTeller of Teller
	(properties)

	(method (doChild)
		(switch query
			(-78 ; "Rumors"
				(switch (mod gDay 6)
					(0
						(= query 11)
					)
					(1
						(= query 13)
					)
					(2
						(= query 12)
					)
					(3
						(= query 14)
					)
					(4
						(= query 15)
					)
					(5
						(= query 16)
					)
				)
			)
			(-88 ; "Amulet Seller"
				(switch (mod gDay 6)
					(0
						(= query 60)
					)
					(1
						(= query 61)
					)
					(2
						(= query 62)
					)
					(3
						(= query 63)
					)
					(4
						(= query 64)
					)
					(5
						(= query 65)
					)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 59) (== theVerb 10)) ; theRoyals, Money
			(gMessager say: 2 5 68) ; "You look around the stand at the various amulets of dubious quality, and you decide to waste your money elsewhere."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance clothTeller of Teller
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(59 ; theRoyals
				(gMessager say: 5 6 86) ; "This is not the money of Tarna. Before you can buy something, you must visit the money changer."
			)
			(10 ; Money
				(if (IsFlag 114)
					(gMessager say: 2 5 73) ; "You do not see anything you really need right now."
				else
					(clothVendor purchase:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance aKattaMerchant of Actor
	(properties
		x 76
		y 46
		noun 1
		approachX 63
		approachY 52
		view 252
		signal 16
		detailLevel 3
	)
)

(instance aMeatSeller of Actor
	(properties
		x 175
		y 68
		noun 3
		approachX 181
		approachY 79
		view 264
		loop 1
		priority 3
		signal 16400
		cycleSpeed 8
		detailLevel 3
	)

	(method (init)
		(super init:)
		(return self)
	)

	(method (cue)
		([local79 local3] stopUpd:)
		(= local4 1)
	)
)

(instance aAmuletUpper of Actor
	(properties
		x 247
		y 66
		z 30
		noun 4
		approachX 259
		approachY 69
		view 266
		priority 3
		signal 16400
		cycleSpeed 8
		detailLevel 3
	)

	(method (init)
		(super init:)
		(return self)
	)
)

(instance aAmuletSeller of Prop
	(properties
		x 247
		y 65
		noun 4
		approachX 259
		approachY 69
		view 266
		loop 1
		priority 3
		signal 16400
		cycleSpeed 8
		detailLevel 3
	)
)

(instance aClothSeller of Actor
	(properties
		x 281
		y 87
		noun 5
		approachX 263
		approachY 84
		view 248
		loop 1
		signal 20480
		cycleSpeed 8
		detailLevel 3
	)

	(method (init)
		(super init:)
		(return self)
	)
)

(instance aDrummer of Prop
	(properties
		x 185
		y 175
		noun 29
		approachX 138
		approachY 151
		view 256
		cel 5
		priority 11
		signal 16400
		cycleSpeed 9
	)

	(method (doVerb theVerb)
		(switch theVerb
			(59 ; theRoyals
				(bowl doVerb: theVerb)
			)
			(10 ; Money
				(bowl doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance kattaTalker of GloryTalker
	(properties
		x 5
		y 90
		view 253
		loop 1
		talkWidth 140
		back 57
		textX 140
		textY 3
		backColor 12
	)

	(method (init)
		(super init: kattaBust kattaEyes kattaMouth &rest)
	)
)

(instance kattaMouth of Prop
	(properties
		nsTop 45
		nsLeft 42
		view 253
	)
)

(instance kattaEyes of Prop
	(properties
		nsTop 33
		nsLeft 47
		view 253
		loop 2
	)
)

(instance kattaBust of View
	(properties
		nsTop 23
		nsLeft 42
		view 253
		loop 3
	)
)

(instance meatTalker of GloryTalker
	(properties
		x 200
		y 90
		view 265
		loop 1
		talkWidth 140
		back 57
		textX -178
		textY 3
		backColor 29
	)

	(method (init)
		(super init: meatBust meatEyes meatMouth &rest)
	)
)

(instance meatMouth of Prop
	(properties
		nsTop 36
		nsLeft 39
		view 265
	)
)

(instance meatEyes of Prop
	(properties
		nsTop 29
		nsLeft 36
		view 265
		loop 2
	)
)

(instance meatBust of View
	(properties
		nsTop 24
		nsLeft 44
		view 265
		loop 3
	)
)

(instance amuletTalker of GloryTalker
	(properties
		x 5
		y 90
		view 267
		loop 1
		talkWidth 140
		back 57
		textX 145
		textY 3
		backColor 12
	)

	(method (init)
		(super init: amuletBust amuletEyes amuletMouth &rest)
	)
)

(instance amuletMouth of Prop
	(properties
		nsTop 42
		nsLeft 48
		view 267
	)
)

(instance amuletEyes of Prop
	(properties
		nsTop 33
		nsLeft 48
		view 267
		loop 2
	)
)

(instance amuletBust of View
	(properties
		nsTop 13
		nsLeft 43
		view 267
		loop 3
	)
)

(instance clothTalker of GloryTalker
	(properties
		x 200
		y 90
		view 249
		loop 1
		talkWidth 140
		back 57
		textX -175
		textY 3
		backColor 25
	)

	(method (init)
		(super init: clothBust clothEyes clothMouth &rest)
	)
)

(instance clothMouth of Prop
	(properties
		nsTop 48
		nsLeft 32
		view 249
	)
)

(instance clothEyes of Prop
	(properties
		nsTop 36
		nsLeft 29
		view 249
		loop 2
	)
)

(instance clothBust of View
	(properties
		nsTop 27
		nsLeft 27
		view 249
		loop 3
	)
)

(instance kattaVendor of Vendor
	(properties
		noun 1
	)

	(method (transact param1 param2)
		(= local0 self)
		(SetFlag 146)
		(gEgo get: 32 param2 solvePuzzle: 232 2) ; theLeopard
		(proc47_3 param1 param2)
		(if param2
			(gMessager say: 1 6 24 0 self) ; "Thank you so much for this purchase. I hope you will be pleased with it."
		)
		(SetFlag 169)
	)

	(method (doBargain param1)
		(switch param1
			(1
				(gMessager say: 1 6 31 0 self) ; "I will be delighted to accept your generous offer."
			)
			(2
				(gMessager say: 1 6 32 0 self) ; "Please, sir, I would rather accept this for my work."
			)
			(3
				(gMessager say: 1 6 33 0 self) ; "I do not wish to offend you, effendi, but I cannot accept less than this."
			)
			(4
				(gMessager say: 1 6 34 0 self) ; "If you will just offer this much, I will be happy to give you the leopard carving. I hate to haggle, but it is expected for a merchant to do so."
			)
			(5
				(gMessager say: 1 6 29 0 self) ; "Forgive me, effendi, but I do not wish to bargain further with you."
			)
			(6
				(gMessager say: 1 6 30 0 self) ; "I am most sorry, effendi, but I take more pride in my work, and you show it too little respect."
			)
			(else
				(self cue:)
			)
		)
	)
)

(instance meatVendor of Vendor
	(properties
		noun 3
	)

	(method (transact param1 param2)
		(= local0 self)
		(gEgo get: 18 param2) ; theMeat
		(proc47_3 param1 param2)
		(gMessager say: 3 6 24 0 self) ; "O most magnanimous, magnificent, munificent, beneficent, benevolent, malevolent, non-violent, ultraviolet, ultra-liberal lover of small furry animals!"
	)

	(method (bargain)
		(= local11 [gEgoStats 13]) ; communication
		(= [gEgoStats 13] 550) ; communication
		(super bargain: &rest)
	)

	(method (doBargain)
		(= [gEgoStats 13] local11) ; communication
		(gMessager say: 3 6 31 0 self) ; "Oh, goody, goody, goody! If the good Master offers a price I will accept it! I am the most lucky Kalb in the world!"
	)
)

(instance clothVendor of Vendor
	(properties
		noun 5
	)

	(method (transact param1 param2)
		(= local0 self)
		(gEgo get: 40 param2 solvePuzzle: 235 2) ; theRobe
		(proc47_3 param1 param2)
		(if param2
			(gMessager say: 5 6 24 0 self) ; "Thank you, effendi."
			(SetFlag 170)
			(SetFlag 114)
		)
	)

	(method (doBargain param1)
		(switch param1
			(1
				(gMessager say: 5 6 31 0 self) ; "That will be acceptable, effendi."
			)
			(2
				(gMessager say: 5 6 32 0 self) ; "The cloth from which the robe is made is worth more than you offer."
			)
			(3
				(gMessager say: 5 6 33 0 self) ; "That offer will pay for the work of the one who made the robe. However, you must still pay for the material."
			)
			(4
				(gMessager say: 5 6 34 0 self) ; "That offer is barely enough to cover the cost, effendi. However, I, too, need to make some profit."
			)
			(5
				(gMessager say: 5 6 29 0 self) ; "I am sorry, effendi, but we cannot agree to a price."
			)
			(6
				(gMessager say: 5 6 30 0 self) ; "I do not allow myself to be cheated. If you wish to buy something, you must pay its worth."
			)
			(else
				(self cue:)
			)
		)
	)
)

(instance bowl of View
	(properties
		x 154
		y 145
		noun 30
		approachX 138
		approachY 151
		view 260
		loop 1
		cel 2
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(59 ; theRoyals
				(gMessager say: 6 6 86) ; "The drummer looks at your dinars and shakes his head. He doesn't seem to recognize them as money."
			)
			(10 ; Money
				(if (not (IsFlag 236))
					(gEgo addHonor: 20)
				)
				(gCurRoom setScript: giveMoney 0 theVerb)
			)
			(4 ; Do
				(gCurRoom setScript: giveMoney 0 theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance meatStuff of View
	(properties
		x 48
		y 7
		view 260
		signal 16400
	)

	(method (onMe)
		(return 0)
	)
)

(instance clothStuff of View
	(properties
		x 207
		y 7
		view 260
		cel 1
		priority 2
		signal 16400
	)

	(method (onMe)
		(return 0)
	)
)

(instance drumsUpper of View
	(properties
		x 180
		y 112
		noun 8
		view 260
		loop 1
		cel 1
		priority 10
		signal 20496
	)
)

(instance drumsLower of View
	(properties
		x 156
		y 154
		noun 8
		view 260
		loop 1
		priority 12
		signal 20496
	)
)

(instance kattaStuff of View
	(properties
		x 73
		y 38
		view 260
		cel 2
		priority 1
		signal 16400
	)

	(method (onMe)
		(return 0)
	)
)

(instance water of Feature
	(properties
		x 10
		y 150
		noun 7
		onMeCheck 64
	)
)

(instance musical_sticks of Feature
	(properties
		x 189
		y 118
		noun 9
		nsTop 112
		nsLeft 176
		nsBottom 125
		nsRight 203
		sightAngle 180
	)
)

(instance upper_katta_carvings of Feature
	(properties
		x 60
		y 42
		noun 10
		nsTop 30
		nsLeft 53
		nsBottom 42
		nsRight 67
		sightAngle 180
	)
)

(instance lower_katta_carvings of Feature
	(properties
		x 81
		y 44
		noun 11
		nsTop 44
		nsLeft 72
		nsBottom 53
		nsRight 90
		sightAngle 180
	)
)

(instance kattarug of Feature
	(properties
		x 80
		y 34
		noun 12
		nsTop 33
		nsLeft 53
		nsBottom 51
		nsRight 108
		sightAngle 180
	)
)

(instance animalcarcass of Feature
	(properties
		x 141
		y 24
		noun 13
		nsTop 6
		nsLeft 133
		nsBottom 43
		nsRight 150
		sightAngle 180
	)
)

(instance hotdogs of Feature
	(properties
		x 153
		y 25
		noun 14
		nsTop 6
		nsLeft 150
		nsBottom 44
		nsRight 156
		sightAngle 180
	)
)

(instance tabletop of Feature
	(properties
		x 152
		y 53
		noun 15
		nsTop 49
		nsLeft 137
		nsBottom 58
		nsRight 167
		sightAngle 180
	)
)

(instance deadducks of Feature
	(properties
		x 183
		y 19
		noun 16
		nsTop 4
		nsLeft 175
		nsBottom 29
		nsRight 191
		sightAngle 180
	)
)

(instance ham of Feature
	(properties
		x 197
		y 22
		noun 17
		nsTop 12
		nsLeft 192
		nsBottom 32
		nsRight 202
		sightAngle 180
	)
)

(instance back_meat_table of Feature
	(properties
		x 192
		y 50
		noun 18
		nsTop 35
		nsLeft 179
		nsBottom 52
		nsRight 206
		sightAngle 180
	)
)

(instance meatstand of Feature
	(properties
		x 159
		y 15
		noun 19
		nsTop -1
		nsLeft 107
		nsBottom 59
		nsRight 211
		sightAngle 180
	)
)

(instance stairs of Feature
	(properties
		x 125
		y 173
		noun 20
		nsTop 158
		nsLeft 90
		nsBottom 189
		nsRight 161
		sightAngle 180
	)
)

(instance amuletrack of Feature
	(properties
		x 228
		y 46
		noun 21
		nsTop 33
		nsLeft 219
		nsBottom 59
		nsRight 237
		sightAngle 180
	)
)

(instance amuletbeads of Feature
	(properties
		x 224
		y 22
		noun 22
		nsTop 12
		nsLeft 211
		nsBottom 33
		nsRight 237
		sightAngle 180
	)
)

(instance amuletstand of Feature
	(properties
		x 243
		y 20
		noun 23
		nsTop 4
		nsLeft 213
		nsBottom 57
		nsRight 273
		sightAngle 180
	)
)

(instance clothracks of Feature
	(properties
		x 308
		y 81
		noun 24
		nsTop 69
		nsLeft 298
		nsBottom 94
		nsRight 319
		sightAngle 180
	)
)

(instance cloth_on_tent of Feature
	(properties
		x 304
		y 33
		noun 25
		nsTop 21
		nsLeft 289
		nsBottom 45
		nsRight 319
		sightAngle 180
	)
)

(instance clothstand of Feature
	(properties
		x 282
		y 73
		noun 26
		nsTop 61
		nsLeft 246
		nsBottom 85
		nsRight 319
		sightAngle 180
	)
)

(instance morecloth of Feature
	(properties
		x 297
		y 50
		noun 28
		nsTop 43
		nsLeft 276
		nsBottom 58
		nsRight 319
		sightAngle 180
	)
)

(instance purpletents of Feature
	(properties
		x 299
		y 153
		noun 27
		nsTop 119
		nsLeft 280
		nsBottom 188
		nsRight 319
		sightAngle 180
	)
)

(instance sFx of Sound
	(properties)
)

