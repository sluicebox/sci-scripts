;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use Teller)
(use n026)
(use OccasionalCycle)
(use Vendor)
(use GloryTalker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm290 0
	salimTalker 1
)

(local
	local0 = 10
	local1
	local2
	local3
	local4
	local5 = 150
	local6 = 150
	local7
	local8
	[local9 14] = [0 -68 -69 -1 2 -70 79 74 75 76 78 77 -110 999]
	[local23 4]
	[local27 21] = [0 -49 -65 -54 -60 -66 -33 -35 -37 -39 -41 -43 -5 -29 -111 -30 85 -81 -57 -47 999]
	[local48 6] = [0 45 80 -44 46 999]
	[local54 3] = [0 -20 999]
	[local57 4] = [0 21 22 999]
	[local61 3] = [0 -112 999]
	[local64 3] = [0 -25 999]
	[local67 5] = [0 -24 26 -27 999]
	[local72 3] = [0 71 999]
	[local75 3] = [0 28 999]
	[local78 3] = [0 -34 999]
	[local81 3] = [0 103 999]
	[local84 3] = [0 36 999]
	[local87 3] = [0 38 999]
	[local90 3] = [0 40 999]
	[local93 3] = [0 42 999]
	[local96 4] = [0 50 51 999]
	[local100 3] = [0 67 999]
	[local103 4] = [0 55 56 999]
	[local107 3] = [0 -61 999]
	[local110 5] = [0 63 62 64 999]
	[local115 3] = [0 53 999]
	[local118 4] = [0 -58 59 999]
	[local122 3] = [0 -19 999]
	[local125 3] = [0 48 999]
	[local128 28]
	[local156 26] = [0 -49 -65 -54 -60 -61 -66 -33 -34 -35 -37 -39 -41 -43 -44 -20 -5 -29 -25 -24 -27 -111 -57 -58 -47 999]
)

(procedure (localproc_0 param1)
	(|= global395 param1)
)

(procedure (localproc_1 param1)
	(&= global395 (~ param1))
)

(procedure (localproc_2 param1)
	(return (& global395 param1))
)

(procedure (localproc_3 param1 &tmp temp0)
	(= temp0 (gInventory at: param1))
	(return (== (temp0 state:) gCurRoom))
)

(instance rm290 of Rm
	(properties
		noun 25
		picture 290
		vanishingY -100
	)

	(method (init)
		(gLongSong hold: 0 holdVal: 0 setVol: 127)
		(HandsOff)
		(if (localproc_2 16384)
			(localproc_1 16384)
		)
		(cond
			((not global395)
				(localproc_0 1)
				(salim loop: 0 cel: 0)
				(Book show:)
			)
			((localproc_2 1)
				(localproc_1 1)
				(localproc_0 2)
				(salim loop: 2 cel: 0)
				(Book hide:)
			)
			((localproc_2 2)
				(localproc_1 2)
				(localproc_0 4)
			)
			((and (localproc_2 4) (localproc_2 4096))
				(localproc_1 4)
				(localproc_0 8)
			)
		)
		(gEgo
			init:
			x: 135
			y: 192
			normalize:
			setScale: Scaler 113 87 150 110
			noun: 2
		)
		(self setScript: sEnter)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 173 170 181 170 203 158 212 141 207 141 187 143 176 144 163 144 140 144 129 147 110 147 106 139 114 129 125 121 152 124 153 118 139 117 140 114 123 114 116 121 107 127 98 133 83 148 77 165 95 171 95 189 173 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 123 148 150 146 173 146 171 157 162 160 155 161 131 160 125 156
					yourself:
				)
		)
		(salim init:)
		(salimVendor init:)
		(= [local23 0] @local9)
		(= [local128 0] @local27)
		(= [local128 1] @local96)
		(= [local128 2] @local100)
		(= [local128 3] @local103)
		(= [local128 4] @local107)
		(= [local128 5] @local110)
		(= [local128 6] @local115)
		(= [local128 7] @local78)
		(= [local128 8] @local81)
		(= [local128 9] @local84)
		(= [local128 10] @local87)
		(= [local128 11] @local90)
		(= [local128 12] @local93)
		(= [local128 13] @local48)
		(= [local128 14] @local54)
		(= [local128 15] @local57)
		(= [local128 16] @local61)
		(= [local128 17] @local64)
		(= [local128 18] @local67)
		(= [local128 19] @local72)
		(= [local128 20] @local75)
		(= [local128 21] @local67)
		(= [local128 22] @local118)
		(= [local128 23] @local122)
		(= [local128 24] @local125)
		(egoTell init: gEgo @local9 @local23)
		(salimTell init: salim @local27 @local128 @local156)
		(Cushion1 init: setScale: addToPic:)
		(Cushion2 init: setScale: approachVerbs: 4 stopUpd:) ; Do
		(Book init: setScale: stopUpd:)
		(pipe init:)
		(spiderplant init:)
		(pile_o_books init:)
		(up_left_blue_bottle init:)
		(up_left_plant init:)
		(low_left_blue_bottle init:)
		(left_mid_bottles init:)
		(table init:)
		(greenvase init:)
		(beadeddoor init:)
		(giant_red_pot init:)
		(roundpot init:)
		(low_hang_plat init:)
		(small_spider_plant init:)
		(rightpots init:)
		(plantshelf init:)
		(upper_shelf init:)
		(brownbottles init:)
		(morebottles init:)
		(bottles_over_door init:)
		(hookedbottle init:)
		(gWalkHandler addToFront: gCurRoom)
		(cond
			((localproc_3 30)
				(= global405 9999)
			)
			((not global405)
				(= global405 4)
			)
		)
	)

	(method (doit)
		(cond
			(script 0)
			((and (gEgo mover:) (== (gEgo view:) 40))
				(if (IsObject (gEgo looper:))
					((gEgo looper:) dispose:)
				)
				(gEgo setMotion: 0 setScript: stand)
			)
			((> (gEgo y:) 170)
				(HandsOff)
				(self setScript: sExit)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(egoActions doVerb: 3)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(gWalkHandler delete: gCurRoom)
		(super dispose:)
	)
)

(instance sExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 135 185 self)
			)
			(1
				(gEgo setMotion: MoveTo 135 225 self)
			)
			(2
				(gCurRoom newRoom: 270)
			)
		)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 165 160 self)
			)
			(1
				(cond
					((localproc_2 1)
						(salim setLoop: 0)
						(Book show:)
						(= cycles 5)
					)
					((localproc_2 2)
						(salim setLoop: 2)
						(= cycles 5)
					)
					((localproc_2 4)
						(if (mod global396 2)
							(Book hide:)
							(salim setLoop: 0)
							(= cycles 5)
						else
							(Book hide:)
							(salim setLoop: 2)
							(= cycles 5)
						)
					)
					((localproc_2 8)
						(Book show:)
						(salim setLoop: 0)
						(= cycles 5)
					)
					(else
						(Book hide:)
						(salim setLoop: 2)
						(= cycles 5)
					)
				)
			)
			(2
				(cond
					((localproc_2 1)
						(gMessager say: 1 6 10) ; "Oh, hi. You must be the Prince of Shapeir people are talking about. Wow, I've never met a real prince before. Welcome to my apothecary, Prince."
					)
					((localproc_2 2)
						(if (localproc_2 256)
							(gMessager say: 1 6 2) ; "Oh, I'm so glad to see you again. I've thought about Julanar constantly since you told me about her. Is there anything else you remember about her?"
						else
							(gMessager say: 1 6 11) ; "Peace and long life, Prince."
						)
						(= global396 1)
					)
					((localproc_2 4)
						(cond
							((== global396 1)
								(gMessager say: 1 6 12) ; "Welcome, welcome. It's so good to see you again. Wow, it seems like days since you were last here."
								(++ global396)
							)
							((== global396 2)
								(gMessager say: 1 6 13) ; "Good morning to you, good afternoon to you. Good day and good night, and good lifetime to you!"
								(++ global396)
							)
							((== global396 3)
								(gMessager say: 1 6 14) ; "Hail the incoming hero. Greetings for the proposer of peace! Rah, rah, rah!"
								(++ global396)
							)
							((== global396 4)
								(gMessager say: 1 6 15) ; "You're back! Great. I really enjoy our philosophical discussions, you know."
								(++ global396)
							)
							(else
								(gMessager say: 1 6 11) ; "Peace and long life, Prince."
								(= global396 1)
							)
						)
					)
					((localproc_2 8)
						(if (== global396 gDay)
							(gMessager say: 1 6 18) ; "Hey, sorry, but I'm just too busy meditating on the meaning of life, the universe, and everything to make the dispel potions. Come back after I've found the answer."
						else
							(gMessager say: 1 6 17) ; "Hi. I've got myself and things together and made you some nifty dispel potions."
							(= global396 0)
						)
					)
					((== global396 0)
						(gMessager say: 1 6 16) ; "Hello. Did the dispel potion do its stuff for you?"
						(++ global396)
					)
					((== global396 1)
						(gMessager say: 1 6 11) ; "Peace and long life, Prince."
						(++ global396)
					)
					((== global396 2)
						(gMessager say: 1 6 12) ; "Welcome, welcome. It's so good to see you again. Wow, it seems like days since you were last here."
						(++ global396)
					)
					((== global396 3)
						(gMessager say: 1 6 13) ; "Good morning to you, good afternoon to you. Good day and good night, and good lifetime to you!"
						(++ global396)
					)
					((== global396 4)
						(gMessager say: 1 6 14) ; "Hail the incoming hero. Greetings for the proposer of peace! Rah, rah, rah!"
						(++ global396)
					)
					((== global396 5)
						(gMessager say: 1 6 14) ; "Hail the incoming hero. Greetings for the proposer of peace! Rah, rah, rah!"
						(= global396 0)
					)
				)
				(self cue:)
			)
			(3
				(salim setCycle: OccasionalCycle self 1 60 150)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance lookUp of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== (salim loop:) 3)
					(salim setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(1
				(gMessager say: 1 6 32 0 self) ; "Wow, I've never sold one of those. I'll need to look it up in my book."
			)
			(2
				(Book hide:)
				(salim cycleSpeed: 5 loop: 1 setCycle: Fwd)
				(gLongSong2 number: 928 setLoop: -1 play:)
				(= seconds 5)
			)
			(3
				(gLongSong2 stop:)
				(gMessager say: 1 6 4 0 self) ; "Hey, check this out in the pharmacopia. Wow, man! I've already got most of this stuff. There's the bee's knees and the ibis's eyelashes and a clear amethyst crystal."
			)
			(4
				(salim
					cycleSpeed: 18
					cel: 0
					loop: 2
					setCycle: OccasionalCycle self 1 60 150
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance tokeDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSounds eachElementDo: #fade 0 1 15 1)
				(DrawPic 0 -32761 1)
				(gCast eachElementDo: #dispose)
				(= cycles 5)
			)
			(1
				(gMessager say: 3 6 101 0 self) ; "You spend the next couple of years sleeping in alleyways and eating out of garbage cans."
			)
			(2
				(EgoDead 97 0 294 Fwd 291) ; "Then you die, a burned-out drug addict."
			)
		)
	)
)

(instance freakOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== local4 1)
					(gMessager say: 3 4 96 0 self) ; "You suddenly feel a little strange and very dizzy."
				else
					(self cue:)
				)
			)
			(1
				(gLongSong pause: 1)
				(sFx number: 291 play:)
				(= local3 (Palette palSAVE))
				(= local1 1)
				(= ticks 270)
			)
			(2
				(gLongSong pause: 0)
				(= local1 0)
				(Palette palRESTORE local3)
				(switch local4
					(1
						(gMessager say: 3 4 98 0 self) ; "WWWoooowwww!!!!"
					)
					(2
						(gMessager say: 3 4 99 0 self) ; "OOhhhh WWWooooowwwwwww!!!!!"
					)
					(3
						(self setScript: tokeDeath)
					)
				)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(if local1
			(cond
				((< local0 20)
					(++ local0)
					(Palette palANIMATE 1 71 1 73 235 1)
				)
				((< local0 40)
					(++ local0)
					(Palette palANIMATE 1 71 1 73 235 -1)
				)
				(else
					(= local0 0)
				)
			)
		)
		(super doit:)
	)
)

(instance sit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 158 150 self)
			)
			(1
				(gEgo view: 40 cel: 0 setLoop: 2 setCycle: End self)
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
					(gEgo looper: 0)
				)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance stand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo
					normalize: 6
					cel: 0
					setMotion: PolyPath (gEgo x:) (- (gEgo y:) 10) self
				)
			)
			(2
				(gEgo setMotion: PolyPath local5 local6)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance standUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 2 5 1 0 self) ; "You tell about how you helped the enchanted tree woman Julanar regain some hope while you were in Shapeir."
			)
			(1
				(gMessager say: 1 6 1 0 self) ; "How extraordinary. The girl of my dreams is real! I'm so thrilled to hear it. I will leave for Shapeir on the next caravan there."
			)
			(2
				(Book show:)
				(salim cel: 0 loop: 3 setCycle: End self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance egoTell of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				-1 ; "Tell about Julanar"
				(and (localproc_2 8192) (not (localproc_2 256)) (localproc_2 3))
				2 ; "Tell about Julanar"
				(and
					(localproc_2 256)
					(not (localproc_2 16384))
					(localproc_2 3)
				)
				-70 ; "Tell about Shapeir"
				(not (or (localproc_2 8192) (localproc_2 512)))
				79 ; "Tell about Dispel Potion"
				(localproc_2 2048)
				74 ; "Tell about Feather"
				(gEgo has: 30) ; theFeather
				75 ; "Tell about Vines"
				(gEgo has: 35) ; theVineFruit
				76 ; "Tell about Guardian"
				(gEgo has: 36) ; theGem
				78 ; "Tell about Gift"
				(gEgo has: 38) ; theHeartGift
				77 ; "Tell about Pool"
				(gEgo has: 37) ; thePeaceWater
		)
	)

	(method (doChild param1 &tmp temp0)
		(cond
			((== param1 -1) ; "Tell about Julanar"
				(if (not (localproc_2 256))
					(gEgo solvePuzzle: 246 10 addHonor: 40)
					(localproc_0 256)
					(localproc_0 16384)
					(salim setScript: standUp)
					(return 0)
				)
			)
			((== param1 -70) ; "Tell about Shapeir"
				(if (not (localproc_2 8192))
					(localproc_0 512)
				)
			)
			((== param1 -68) ; "Say Hello"
				(if (not (localproc_2 64))
					(localproc_0 64)
					(gEgo addHonor: 2)
				)
			)
			((== param1 -69) ; "Say Good-bye"
				(if (not (localproc_2 128))
					(localproc_0 128)
					(gEgo addHonor: 2)
				)
			)
			((== param1 -110) ; "Make Purchase"
				(salimTell doVerb: ((gInventory at: 0) message:)) ; theRoyals
				(return 0)
			)
		)
		(return 1)
	)
)

(instance salimTell of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				-33 ; "Apothecary"
				(localproc_2 1)
				-35 ; "Apothecary"
				(localproc_2 2)
				-37 ; "Apothecary"
				(localproc_2 4)
				-39 ; "Apothecary"
				(localproc_2 8)
				-41 ; "Apothecary"
				(localproc_2 32)
				-5 ; "Potions"
				(and (localproc_2 7) (not (localproc_2 1024)))
				-24 ; "Water"
				(not (localproc_3 37))
				-27 ; "Fruit"
				(not (localproc_3 35))
				26 ; "Gift from the Heart"
				(not (localproc_3 38))
				-81 ; "Dream"
				(and (localproc_2 512) (localproc_2 3))
				-29 ; "Dispel Potion"
				(and (localproc_2 3) (localproc_2 1024))
				-111 ; "Dispel Potion"
				(and
					(localproc_2 1024)
					(localproc_2 4)
					(not (localproc_2 4096))
				)
				-30 ; "Dispel Potion"
				(and
					(localproc_2 4096)
					(not (localproc_2 32))
					(== global396 gDay)
				)
				85 ; "Dispel Potion"
				(and (localproc_2 8) (!= global396 gDay))
				-44 ; "Healing"
				(not (localproc_3 30))
				80 ; "Healing"
				(localproc_3 30)
				-49 ; "Name"
				(localproc_2 1)
				-65 ; "Salim"
				(localproc_2 2)
				-54 ; "Salim"
				(localproc_2 4)
				-60 ; "Salim"
				(localproc_2 8)
				-66 ; "Salim"
				(localproc_2 32)
				-57 ; "Plants"
				(localproc_2 3)
				-47 ; "Tarna"
				(localproc_2 1)
				-58 ; "Tree"
				(localproc_2 1)
		)
	)

	(method (doVerb theVerb &tmp [temp0 20] temp20)
		(cond
			((== theVerb 59) ; theRoyals
				(gMessager say: 1 59 31) ; "Hey, this money's funny, here. You need to take a trip to the money changer downstairs to get some of Tarna's cash before you can buy something here."
			)
			((== theVerb 10) ; Money
				(if (not (salimVendor goods:))
					(if (< global405 0)
						(= temp20 0)
					else
						(= temp20 global405)
					)
					(if (not (localproc_2 -32768))
						(if (localproc_2 8)
							(if (== gHeroType 1) ; Magic User
								(= global471 3)
							else
								(= global471 2)
							)
						else
							(= global471 1)
						)
					)
					(salimVendor
						goods:
							((List new:)
								add:
									((Class_47_1 new: 29)
										price: 10
										quantity: temp20
									)
									((Class_47_1 new: 27)
										price: 20
										quantity: 9999
									)
									((Class_47_1 new: 28)
										price: 20
										quantity: 9999
									)
									((Class_47_1 new: 30)
										price: 30
										quantity: global471
									)
							)
					)
				)
				(salimVendor purchase:)
				(return 1)
			)
			((== theVerb 48) ; thePeaceWater
				(if (IsFlag 58)
					(if (IsFlag 243)
						(gMessager say: 1 6 113) ; "Gee, thanks, but I have all I need of that for now."
						(return 1)
					else
						(gEgo drop: 37 1 solvePuzzle: 243 3) ; thePeaceWater
						((gInventory at: 37) state: gCurRoom) ; thePeaceWater
						(gMessager say: 1 48 23) ; "Great. This peace water will really mellow the potion."
						(cond
							((and (localproc_3 35) (localproc_3 38))
								(localproc_1 3)
								(localproc_0 4)
								(localproc_0 4096)
								(= global396 gDay)
								(salimTell stuffArray: @local27 0)
								(gMessager say: 1 6 82) ; "Wow, now I can get started making up dispel potions. I got some serious studying to do first, so you better come back some other day if you want to buy the dispel potions."
							)
							((== (salimTell curArray:) @local72)
								(salimTell stuffArray: @local67 0)
							)
						)
						(return 1)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			((== theVerb 46) ; theVineFruit
				(if (IsFlag 58)
					(if (IsFlag 242)
						(gMessager say: 1 6 113) ; "Gee, thanks, but I have all I need of that for now."
						(return 1)
					else
						(gEgo drop: 35 1 solvePuzzle: 242 3) ; theVineFruit
						((gInventory at: 35) state: gCurRoom) ; theVineFruit
						(gMessager say: 1 46 23) ; "Gee, you got this stuff. Hope you didn't get hurt."
						(cond
							((and (localproc_3 37) (localproc_3 38))
								(localproc_1 3)
								(localproc_0 4)
								(localproc_0 4096)
								(= global396 gDay)
								(salimTell stuffArray: @local27 0)
								(gMessager say: 1 6 82) ; "Wow, now I can get started making up dispel potions. I got some serious studying to do first, so you better come back some other day if you want to buy the dispel potions."
							)
							((== (salimTell curArray:) @local75)
								(salimTell stuffArray: @local67 0)
							)
						)
						(return 1)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			((== theVerb 49) ; theHeartGift
				(if (IsFlag 58)
					(if (IsFlag 244)
						(gMessager say: 1 6 113) ; "Gee, thanks, but I have all I need of that for now."
						(return 1)
					else
						(gEgo drop: 38 1 solvePuzzle: 244 3) ; theHeartGift
						((gInventory at: 38) state: gCurRoom) ; theHeartGift
						(gMessager say: 1 49 23) ; "Wow, the aura on this thing is out of sight! Awesome, man. I can make up some truly strong potions with this stuff."
						(if (and (localproc_3 35) (localproc_3 37))
							(localproc_0 4096)
							(localproc_1 3)
							(localproc_0 4)
							(= global396 gDay)
							(gMessager say: 1 6 82) ; "Wow, now I can get started making up dispel potions. I got some serious studying to do first, so you better come back some other day if you want to buy the dispel potions."
							(salimTell stuffArray: @local27 0)
						)
						(return 1)
					)
				else
					(super doVerb: theVerb &rest)
				)
			)
			((== theVerb 41) ; theFeather
				(gEgo drop: 30 get: 12 3 solvePuzzle: 241 3) ; theFeather, theHealPills
				((gInventory at: 30) state: gCurRoom) ; theFeather
				(gMessager say: 1 41 23) ; "Hey, great! You got the feather! Now I can make some more of the pills that heal. Here, take what's left of my healing pills in trade for this fine feather."
				(if (not (IsFlag 241))
					(gEgo addHonor: 10)
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doChild param1 &tmp temp0)
		(cond
			((== param1 -20) ; "Feather"
				(if (not (IsFlag 83))
					(SetFlag 83)
				)
				(if (localproc_2 1)
					(super doChild: param1)
				else
					(return 1)
				)
			)
			((== param1 -57) ; "Plants"
				(if (localproc_2 1)
					(super doChild: param1)
				else
					(return 1)
				)
			)
			((== param1 -19) ; "Dream"
				(localproc_0 8192)
				(return 1)
			)
			((== param1 -81) ; "Dream"
				(localproc_0 8192)
				(return 1)
			)
			((== param1 -112) ; "Dispel Potion"
				(if (not (IsFlag 58))
					(localproc_0 1024)
					(SetFlag 58)
					(salimTell stuffArray: @local27 0)
					(gCurRoom setScript: lookUp)
				)
				(return 0)
			)
			((== param1 -29) ; "Dispel Potion"
				(if (localproc_2 4096)
					(return 1)
				else
					(super doChild: param1)
				)
			)
			((== param1 -30) ; "Dispel Potion"
				(return 1)
			)
			((== param1 -44) ; "Healing"
				(if (localproc_2 32)
					(return 1)
				else
					(super doChild: param1)
				)
			)
			(else
				(super doChild: param1)
			)
		)
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(cond
					((gCurRoom script:) 0)
					((== (gEgo view:) 40)
						(= local5 ((User curEvent:) x:))
						(= local6 ((User curEvent:) y:))
						(gCurRoom setScript: stand)
						(return 1)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Cushion1 of View
	(properties
		x 186
		y 136
		noun 32
		view 290
		signal 16400
		scaleX 132
		scaleY 132
	)
)

(instance Cushion2 of View
	(properties
		x 145
		y 153
		noun 31
		approachX 155
		approachY 160
		view 290
		priority 10
		signal 16400
		scaleX 155
		scaleY 155
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (!= (gEgo view:) 40)
					(gCurRoom setScript: sit)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Book of View
	(properties
		x 192
		y 133
		noun 15
		view 290
		loop 1
		priority 10
		signal 16400
		scaleX 132
		scaleY 132
	)
)

(instance salim of Prop
	(properties
		x 186
		y 134
		noun 1
		view 292
		cycleSpeed 18
	)
)

(instance salimTalker of GloryTalker
	(properties
		x 1
		view 293
		loop 1
		cel 1
		talkWidth 265
		back 57
		textX 25
		textY 95
		backColor 116
	)

	(method (init)
		(super init: salimBrow salimEyes salimMouth &rest)
	)
)

(instance salimEyes of Prop
	(properties
		nsTop 31
		nsLeft 39
		view 293
		loop 2
		priority 15
		signal 16
	)
)

(instance salimBrow of Prop
	(properties
		x 50
		y 50
		nsTop 21
		nsLeft 31
		view 293
		loop 3
		priority 14
		signal 16
	)
)

(instance salimMouth of Prop
	(properties
		nsTop 47
		nsLeft 42
		view 293
		priority 15
		signal 16
	)
)

(instance salimVendor of Vendor
	(properties
		noun 26
	)

	(method (transact param1 param2)
		(= local7 self)
		(switch param1
			(0
				(proc47_3 param1 param2)
				(if (not ((goods at: param1) quantity:))
					(= global405 -1)
					(gEgo get: 12 param2) ; theHealPills
					(gMessager say: 1 6 3 0 self) ; "Bummer dude, that's the last of my healing pills. I'll need a feather from a honey bird before I can make any more."
				else
					(if (not (> global405 4))
						(-= global405 param2)
					)
					(gEgo get: 12 param2) ; theHealPills
					(self cue:)
				)
			)
			(1
				(gEgo get: 13 param2) ; theManaPills
				(proc47_3 param1 param2)
				(self cue:)
			)
			(2
				(gEgo get: 11 param2) ; theCurePills
				(proc47_3 param1 param2)
				(self cue:)
			)
			(3
				(cond
					((not (localproc_2 1024))
						(localproc_0 1024)
						(SetFlag 58)
						(salimTell stuffArray: @local27 0)
						(self setScript: lookUp self)
					)
					((not (localproc_2 -32768))
						(cond
							((not (localproc_2 4096))
								(gMessager say: 1 6 84 0 self) ; "Hey, like, I can't make the potions without more stuff. I don't have all the ingredients yet."
							)
							((== global396 gDay)
								(gMessager say: 1 6 114 0 self) ; "I'll make up you up some dispel potions, but I've got some serious studying to do first, so you better come back some other day if you want the dispel potions."
							)
							(else
								(localproc_1 8)
								(localproc_0 32)
								(if (localproc_2 256)
									(gEgo
										get: 16 global471 ; theDispell
										solvePuzzle: 245 6
									)
									(= global471 0)
									((goods at: param1) quantity: 0)
									(localproc_0 -32768)
									(gMessager say: 1 6 6 0 self) ; "Well, making a dispel potion did take up many of my ingredients and time, but what is that measured against happiness? Since you have made my future with Julanar, I give you the gift of the dispel potions."
								else
									(gEgo get: 16 param2 solvePuzzle: 245 6) ; theDispell
									(-= global471 param2)
									(proc47_3 param1 param2)
									(localproc_0 -32768)
									(self cue:)
								)
							)
						)
					)
					(else
						(gEgo get: 16 param2) ; theDispell
						(-= global471 param2)
						(proc47_3 param1 param2)
						(self cue:)
					)
				)
			)
		)
	)

	(method (doBargain param1)
		(switch param1
			(1
				(gMessager say: 1 6 87 0 self) ; "You got a deal."
			)
			(2
				(gMessager say: 1 6 88 0 self) ; "Hey, money isn't everything, but it does pay the rent. That's not enough cash to pay for the ingredients, let alone this pad."
			)
			(3
				(gMessager say: 1 6 90 0 self) ; "Gee, I hate to seem material or mundane, but I do need more money than that."
			)
			(4
				(gMessager say: 1 6 89 0 self) ; "How about just a little bit more to cover my time."
			)
			(5
				(gMessager say: 1 6 91 0 self) ; "No can do, man. That's way too low for me to go."
			)
			(6
				(gMessager say: 1 6 92 0 self) ; "Man, you are one rude dude if you cheat me like that. If you want it, pay for it."
			)
			(else
				(self cue:)
			)
		)
	)
)

(instance pipe of Feature
	(properties
		x 143
		y 120
		noun 3
		nsTop 100
		nsLeft 130
		nsBottom 131
		nsRight 156
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(19 ; theTinderbox
				(if (== (gEgo view:) 40)
					(if (not local2)
						(= local2 1)
						(gMessager say: 3 19 93) ; "You light the pipe with your tinderbox."
					else
						(gMessager say: 3 19 94) ; "The water pipe is already lit."
					)
				else
					(gMessager say: 3 6 100) ; "The pipe hoses are too short to reach while you are standing up."
				)
			)
			(4 ; Do
				(if (== (gEgo view:) 40)
					(if local2
						(++ local4)
						(rm290 setScript: freakOut)
					else
						(gMessager say: 3 4 95) ; "Nothing happens when you try to smoke the unlit pipe."
					)
				else
					(gMessager say: 3 6 100) ; "The pipe hoses are too short to reach while you are standing up."
				)
			)
			(1 ; Look
				(if local2
					(gMessager say: 3 1 94) ; "You can hear the smoke bubbling up through the water at the base of the pipe."
				else
					(gMessager say: 3 1 95) ; "You can see a water pipe of truly prodigious proportions."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance spiderplant of Feature
	(properties
		x 86
		y 52
		noun 4
		nsTop 35
		nsLeft 67
		nsBottom 70
		nsRight 105
		sightAngle 180
	)
)

(instance pile_o_books of Feature
	(properties
		name {pile-o-books}
		x 53
		y 155
		noun 5
		nsTop 146
		nsLeft 40
		nsBottom 164
		nsRight 66
		sightAngle 180
	)
)

(instance up_left_blue_bottle of Feature
	(properties
		name {up-left-blue-bottle}
		x 39
		y 76
		noun 6
		nsTop 71
		nsLeft 35
		nsBottom 82
		nsRight 44
		sightAngle 180
	)
)

(instance up_left_plant of Feature
	(properties
		name {up-left-plant}
		x 42
		y 33
		noun 7
		nsTop 18
		nsLeft 34
		nsBottom 48
		nsRight 51
		sightAngle 180
	)
)

(instance low_left_blue_bottle of Feature
	(properties
		name {low-left-blue-bottle}
		x 38
		y 135
		noun 8
		nsTop 131
		nsLeft 35
		nsBottom 140
		nsRight 42
		sightAngle 180
	)
)

(instance left_mid_bottles of Feature
	(properties
		name {left-mid-bottles}
		x 44
		y 99
		noun 9
		nsTop 91
		nsLeft 35
		nsBottom 107
		nsRight 53
		sightAngle 180
	)
)

(instance table of Feature
	(properties
		x 90
		y 114
		noun 10
		nsTop 100
		nsLeft 80
		nsBottom 128
		nsRight 100
		sightAngle 180
	)
)

(instance greenvase of Feature
	(properties
		x 73
		y 132
		noun 11
		nsTop 120
		nsLeft 68
		nsBottom 144
		nsRight 79
		sightAngle 180
	)
)

(instance beadeddoor of Feature
	(properties
		x 130
		y 86
		noun 12
		nsTop 63
		nsLeft 118
		nsBottom 109
		nsRight 143
		sightAngle 180
	)
)

(instance giant_red_pot of Feature
	(properties
		name {giant-red-pot}
		x 166
		y 95
		noun 13
		nsTop 77
		nsLeft 156
		nsBottom 113
		nsRight 176
		sightAngle 180
	)
)

(instance roundpot of Feature
	(properties
		x 199
		y 162
		noun 14
		nsTop 156
		nsLeft 190
		nsBottom 169
		nsRight 209
		sightAngle 180
	)
)

(instance low_hang_plat of Feature
	(properties
		name {low-hang-plat}
		x 216
		y 97
		noun 16
		nsTop 79
		nsLeft 204
		nsBottom 116
		nsRight 228
		sightAngle 180
	)
)

(instance small_spider_plant of Feature
	(properties
		name {small-spider-plant}
		x 162
		y 51
		noun 17
		nsTop 43
		nsLeft 148
		nsBottom 59
		nsRight 176
		sightAngle 180
	)
)

(instance rightpots of Feature
	(properties
		x 258
		y 112
		noun 18
		nsTop 98
		nsLeft 248
		nsBottom 126
		nsRight 269
		sightAngle 180
	)
)

(instance plantshelf of Feature
	(properties
		x 230
		y 46
		noun 19
		nsTop 40
		nsLeft 194
		nsBottom 52
		nsRight 266
		sightAngle 180
	)
)

(instance upper_shelf of Feature
	(properties
		name {upper-shelf}
		x 189
		y 32
		noun 20
		nsTop 29
		nsLeft 164
		nsBottom 36
		nsRight 214
		sightAngle 180
	)
)

(instance brownbottles of Feature
	(properties
		x 231
		y 131
		noun 21
		nsTop 116
		nsLeft 221
		nsBottom 146
		nsRight 242
		sightAngle 180
	)
)

(instance morebottles of Feature
	(properties
		x 243
		y 78
		noun 22
		nsTop 68
		nsLeft 227
		nsBottom 88
		nsRight 259
		sightAngle 180
	)
)

(instance bottles_over_door of Feature
	(properties
		name {bottles-over-door}
		x 132
		y 48
		noun 23
		nsTop 44
		nsLeft 121
		nsBottom 52
		nsRight 143
		sightAngle 180
	)
)

(instance hookedbottle of Feature
	(properties
		x 65
		y 101
		noun 24
		nsTop 92
		nsLeft 61
		nsBottom 111
		nsRight 69
		sightAngle 180
	)
)

(instance sFx of Sound
	(properties)
)

