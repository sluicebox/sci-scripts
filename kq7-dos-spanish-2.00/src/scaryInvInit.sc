;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18)
(include sci.sh)
(use Main)
(use ExitButton)
(use OogaBooga)
(use Plane)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	scaryInvInit 0
	proc18_1 1
	reposition 2
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0 &tmp temp0 temp1)
	(= temp0 0)
	(= local0 gCast)
	(if (and gCuees (gCuees isEmpty:))
		(= temp0 gCuees)
		(= gCuees 0)
	)
	(gGame setScript: visionScript)
	(= temp1 (gGame script:))
	(while (gGame script:)
		(= gGameTime (+ gTickOffset (GetTime)))
		(gSounds eachElementDo: #check)
		(if gTalkers
			(gTalkers doit:)
		)
		(gEgo doit:)
		(if (temp1 scratch:)
			((temp1 scratch:) doit:)
		)
		(temp1 doit:)
		(if gCuees
			(gCuees eachElementDo: #doit)
			(if (gCuees isEmpty:)
				(gCuees dispose:)
				(= gCuees 0)
			)
		)
		(FrameOut)
	)
	(if temp0
		(= gCuees temp0)
	)
	(Golden_Comb deleteHotVerb: 61) ; Magic_Statue
	(Magic_Statue deleteHotVerb: 5) ; Golden_Comb
	(gGame handsOn:)
	(gUser need_update: 1)
)

(procedure (proc18_1 param1 &tmp temp0 temp1 temp2)
	(= gInventoryCount 0)
	(for ((= temp2 0)) (< temp2 (gInventory size:)) ((+= temp2 1))
		(if ((gInventory at: temp2) ownedBy: gValOrRoz)
			(++ gInventoryCount)
		)
	)
	(if (< gInventoryCount 7)
		(= temp0 (+ 73 (* gInventoryCount 20)))
	else
		(= temp0 (+ 73 (* (- gInventoryCount 7) 20)))
	)
	(= temp1 (if (< gInventoryCount 7) 19 else 32))
	(param1 x: temp0 y: temp1 owner: gValOrRoz init: global108 show:)
)

(instance pInventory of List
	(properties)
)

(instance scaryInvInit of Code
	(properties)

	(method (doit)
		((= gInventory pInventory)
			add:
				(Golden_Comb owner: -1)
				(Ripped_Petticoat owner: -1)
				(Clay_Pot owner: -1)
				(Stick owner: -1)
				(Flag owner: -1)
				(Turquoise_Piece_a owner: -1)
				(Gourd_Seed owner: -1)
				(Basket owner: -1)
				(Hunting_Horn owner: -1)
				(Glasses owner: -1)
				(Jackalope_Fur owner: -1)
				(Turquoise_Bead owner: -1)
				(Turquoise_Piece_b owner: -1)
				(Puzzle owner: -1)
				(Corn_Kernel owner: -1)
				(Salt_Water owner: -1)
				(Fresh_Water owner: -1)
				(Rope owner: -1)
				(Bug_Reducing_Powder owner: -1)
				(Ear_of_Corn owner: -1)
				(Prickly_Pear owner: -1)
				(Salt_Crystals owner: -1)
				(Turquoise_Shape owner: -1)
				(Toy_Rat owner: -1)
				(Bowl_a owner: -1)
				(Silver_Spoon owner: -1)
				(Baked_Beetles owner: -1)
				(Dragon_Scale owner: -1)
				(Silver_Pellet owner: -1)
				(Shield owner: -1)
				(Shield_Spike owner: -1)
				(Dragon_Toad owner: -1)
				(Enchanted_Rope owner: -1)
				(Bowl_b owner: -1)
				(Wet_Sulfur owner: -1)
				(Lantern owner: -1)
				(Lantern_with_Spark owner: -1)
				(Big_Gem owner: -1)
				(Hammer_and_Chisel owner: -1)
				(Crook owner: -1)
				(Nectar_in_Pot owner: -1)
				(Feather owner: -1)
				(China_Bird owner: -1)
				(Mask owner: -1)
				(Wooden_Nickel owner: -1)
				(Book owner: -1)
				(Rubber_Chicken owner: -1)
				(Magic_Statue owner: -1)
				(Moon owner: -1)
				(Grave_Digger_s_Horn owner: -1)
				(Back_Bone owner: -1)
				(Weird_Pet owner: -1)
				(Defoliant owner: -1)
				(Magic_Wand owner: -1)
				(Veil owner: -1)
				(Scarab owner: -1)
				(Shovel owner: -1)
				(Grave_Digger_s_Rat owner: -1)
				(Extra_Life owner: -1)
				(Foot_In_A_Bag owner: -1)
				(Fragrant_Flower owner: -1)
				(Woolen_Stocking owner: -1)
				(Device owner: -1)
				(Sling owner: -1)
				(Golden_Grape owner: -1)
				(Were_beast_Salve owner: -1)
				(Pomegranate owner: -1)
				(Ambrosia owner: -1)
				(Dream_Catcher owner: -1)
				(Magic_Bridle owner: -1)
				(Tapestry_of_Dreams owner: -1)
				(Crystal_Shaft owner: -1)
				(Femur owner: -1)
				(Horseman_s_Medal owner: -1)
				(Firecracker owner: -1)
				(Horseman_s_Head owner: -1)
				(Horseman_s_Fife owner: -1)
				(Shrieking_Horn owner: -1)
				(Ooga_Booga_Flower owner: -1)
		)
	)
)

(class KQInventory of View
	(properties
		sightAngle 360
		verb 0
		owner 0
		newX 0
		newY 0
		respondVerb 0
		cView 0
		cLoop 0
		cCel 0
		enabled 0
	)

	(method (enable param1)
		(if (and argc (not param1))
			(= enabled 0)
		else
			(= enabled 1)
		)
	)

	(method (recoverSpot &tmp temp0)
		(if
			(and
				respondVerb
				(self ownedBy: gValOrRoz)
				(= temp0 (gInventory firstTrue: #isMyVerb respondVerb))
				(temp0 ownedBy: gValOrRoz)
			)
			(self setHotspot: 0 respondVerb)
		)
	)

	(method (init)
		(if (and (== owner gValOrRoz) (!= (gUser message:) verb))
			(self setPri: 254 ignoreActors: 1 enable: 1)
			(global108 addToFront: self)
			(super init: global108)
		)
	)

	(method (show)
		(if newX
			(= x newX)
			(= y newY)
			(= newX (= newY 0))
		)
		(super show:)
	)

	(method (doVerb theVerb)
		(if (and enabled (OneOf theVerb 8 10)) ; Do, Exit
			(self hide:)
			(gTheInvCursor view: cView loop: cLoop cel: cCel)
			(gUser message: verb)
			(gNormalCursor setCycle: 0)
			(gGame setCursor: gTheInvCursor)
			(= global308 self)
			(= global311 0)
		else
			(gGame pragmaFail:)
			(return 1)
		)
	)

	(method (isMyVerb param1)
		(return (== verb param1))
	)

	(method (moveTo param1)
		(= owner param1)
		(return self)
	)

	(method (ownedBy param1)
		(return (== owner param1))
	)
)

(instance visionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local1 (gEgo cycleSpeed:))
				(Load rsVIEW 9026)
				(= local2 ((ScriptID 13 0) hide_mouth:)) ; aEgoTalker
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				(= cycles 3)
			)
			(1
				(gEgo
					view: 9026
					loop: (if (< 0 (gEgo heading:) 180) 0 else 1)
					cel: 0
					cycleSpeed: 12
					setCycle: CT 21 1 self
				)
			)
			(2
				(visionSound1 number: 1256 setLoop: 1 play:)
				(gEgo setCycle: End self)
			)
			(3
				(= scratch 0)
				(if (== gChapter 3)
					(Load 140 4504) ; WAVE
					(Load 140 887) ; WAVE
					(Load rsPIC 5261)
				else
					(Load rsPIC 5260)
					(Load rsVIEW 5262)
				)
				(Load rsMESSAGE 800)
				(Load rsVIEW 4061)
				(= cycles 3)
			)
			(4
				(= register (Plane new:))
				(register
					setRect: 0 0 319 (gThePlane bottom:)
					back: 0
					picture: (if (== gChapter 3) 5261 else 5260)
					priority: 3000
					init:
					addCast: (= gCast (Cast new:))
				)
				(= scratch (Prop new:))
				(if (== gChapter 5)
					(scratch
						view: 5262
						setCel: 0
						posn: 71 80
						init:
						setCycle: End self
					)
					(gMessager say: 3 5 4 0 0 800) ; "(WORRIED AND ANXIOUS)Statuette, tell me where my daughter is now."
				else
					(scratch
						view: 4061
						loop: 1
						cel: 0
						x: 132
						y: 42
						setPri: 42
						init:
					)
					(gMessager say: 3 5 3 0 0 800) ; "(DESPERATE)Please, statue...tell me where my daughter is!"
					(= ticks 360)
				)
			)
			(5
				(if (== gChapter 5)
					(scratch posn: 137 109 setCel: 0 setCycle: End self)
				else
					(visionSound number: 4504 setLoop: -1 loop: -1 play:)
					(scratch setCycle: CT 13 1 self)
				)
			)
			(6
				(if (== gChapter 5)
					(scratch posn: 146 63 setCel: 0 setCycle: End self)
				else
					(visionSound number: 887 setLoop: 1 loop: 1 play:)
					(scratch setCycle: CT 27 1 self)
				)
			)
			(7
				(if (== gChapter 5)
					(scratch posn: 76 103 setCel: 0 setCycle: End self)
				else
					(scratch setCycle: End self)
					(visionSound number: 887 setLoop: 1 loop: 1 play:)
				)
			)
			(8
				(if (== gChapter 5)
					(scratch posn: 174 87 setCel: 0 setCycle: Fwd)
					(if (== ticks 0)
						(self cue:)
					)
				else
					(= ticks 548)
				)
			)
			(9
				(if ((ScriptID 13 0) mouth:) ; aEgoTalker
					(((ScriptID 13 0) mouth:) plane: 0) ; aEgoTalker
				)
				(visionSound stop:)
				(scratch dispose:)
				(= scratch 0)
				(register dispose:)
				(= gCast local0)
				(= cycles 1)
			)
			(10
				(visionSound1 number: 1256 setLoop: 1 play:)
				(gEgo
					view: 9026
					loop: (gEgo loop:)
					setCycle: CT 20 -1 self
				)
			)
			(11
				(gEgo setCycle: Beg self)
			)
			(12
				((ScriptID 13 0) hide_mouth: local2) ; aEgoTalker
				(gEgo cycleSpeed: local1 normalize: (gEgo loop:))
				(self dispose:)
			)
		)
	)
)

(instance Golden_Comb of KQInventory
	(properties
		name {Golden Comb}
		modNum 0
		view 300
		verb 5
		cView 990
		cCel 1
	)

	(method (doVerb theVerb)
		(if
			(and
				(== theVerb 61) ; Magic_Statue
				(not (IsFlag 137))
				(not (IsFlag 338))
				(not (OneOf gCurRoomNum 1155 1410 1601 1105 1255 1260 1460))
				(!= (gEgo view:) 1201)
				(not (gCurRoom inset:))
			)
			(cond
				((and (== gChapter 3) (not (IsFlag 201)))
					(SetFlag 201)
					(localproc_0)
				)
				((and (== gChapter 5) (not (IsFlag 550)))
					(SetFlag 550)
					(localproc_0)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		else
			(super doVerb: theVerb)
		)
		(return 1)
	)
)

(instance Ripped_Petticoat of KQInventory
	(properties
		name {Ripped Petticoat}
		modNum 0
		view 301
		verb 6
		cView 990
		cCel 3
	)

	(method (doVerb theVerb)
		(if (== theVerb 11) ; Stick
			(gTheInvCursor
				view: (Flag cView:)
				loop: (Flag cLoop:)
				cel: (Flag cCel:)
			)
			(if (== gTheCursor gTheInvCursor)
				(gTheInvCursor init:)
			)
			(Stick owner: -1 hide:)
			(-- gInventoryCount)
			(Ripped_Petticoat owner: -1 hide:)
			(-- gInventoryCount)
			(gEgo get: 4) ; Flag
			(Flag hide:)
			(gUser message: 13)
			(= global308 Flag)
			(reposition doit:)
			(= global311 0)
			(self setHotspot: 0)
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance Clay_Pot of KQInventory
	(properties
		name {Clay Pot}
		modNum 0
		view 302
		verb 12
		cView 990
		cCel 5
	)
)

(instance Stick of KQInventory
	(properties
		modNum 0
		view 303
		verb 11
		cView 990
		cCel 7
	)

	(method (doVerb theVerb)
		(if (== theVerb 6) ; Ripped_Petticoat
			(gTheInvCursor
				view: (Flag cView:)
				loop: (Flag cLoop:)
				cel: (Flag cCel:)
			)
			(if (== gTheCursor gTheInvCursor)
				(gTheInvCursor init:)
			)
			(Stick owner: -1 hide:)
			(-- gInventoryCount)
			(Ripped_Petticoat owner: -1 hide:)
			(-- gInventoryCount)
			(gEgo get: 4) ; Flag
			(Flag hide:)
			(gUser message: 13)
			(= global308 Flag)
			(reposition doit:)
			(= global311 0)
			(self setHotspot: 0)
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance Flag of KQInventory
	(properties
		modNum 0
		view 304
		verb 13
		cView 990
		cCel 9
	)
)

(instance Turquoise_Piece_a of KQInventory
	(properties
		name {Turquoise Piece}
		modNum 0
		view 305
		verb 20
		cView 990
		cCel 11
	)

	(method (doVerb theVerb)
		(if (== theVerb 22) ; Turquoise_Piece_b
			(-= gInventoryCount 2)
			(gEgo get: 13) ; Puzzle
			(gTheInvCursor view: (Puzzle cView:) loop: 1 cel: 11)
			(if (== gTheCursor gTheInvCursor)
				(gTheInvCursor init:)
			)
			(Turquoise_Piece_a owner: -1 hide: setHotspot: 0)
			(Turquoise_Piece_b owner: -1 hide: setHotspot: 0)
			(Puzzle hide:)
			(gUser message: 23)
			(= global308 Puzzle)
			(reposition doit:)
			(= global331 0)
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance Gourd_Seed of KQInventory
	(properties
		name {Gourd Seed}
		modNum 0
		view 306
		verb 15
		cView 990
		cCel 13
	)
)

(instance Basket of KQInventory
	(properties
		modNum 0
		view 307
		verb 17
		cView 990
		cCel 15
	)
)

(instance Hunting_Horn of KQInventory
	(properties
		name {Hunting Horn}
		modNum 0
		view 308
		verb 18
		cView 990
		cLoop 1
		cCel 1
	)
)

(instance Glasses of KQInventory
	(properties
		modNum 0
		view 309
		verb 19
		cView 990
		cLoop 1
		cCel 3
	)
)

(instance Were_beast_Salve of KQInventory
	(properties
		name {Were-beast Salve}
		modNum 0
		view 365
		verb 72
		cView 992
		cCel 7
	)

	(method (doVerb theVerb)
		(if (== theVerb 21) ; Jackalope_Fur
			(SetFlag 218)
			(gEgo put: 10) ; Jackalope_Fur
			(visionSound number: 12 setLoop: 1 loop: 1 play: setVol: 127)
			(= view 379)
			(= cLoop 6)
			(= cCel 1)
			(UpdateScreenItem self)
			(FrameOut)
			(gNormalCursor setCycle: 0 cel: 0 init:)
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance Jackalope_Fur of KQInventory
	(properties
		name {Jackalope Fur}
		modNum 0
		view 310
		verb 21
		cView 990
		cLoop 1
		cCel 5
	)

	(method (doVerb theVerb)
		(if (== theVerb 72) ; Were-beast_Salve
			(SetFlag 218)
			(gEgo put: 10) ; Jackalope_Fur
			(visionSound number: 12 setLoop: 1 loop: 1 play: setVol: 127)
			(Were_beast_Salve view: 379 cLoop: 6 cCel: 1)
			(gTheInvCursor view: 992 loop: 6 cel: 1 init:)
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance Turquoise_Bead of KQInventory
	(properties
		name {Turquoise Bead}
		modNum 0
		view 311
		verb 16
		cView 990
		cLoop 1
		cCel 7
	)
)

(instance Turquoise_Piece_b of KQInventory
	(properties
		name {Turquoise Piece}
		modNum 0
		view 312
		verb 22
		cView 990
		cLoop 1
		cCel 9
	)

	(method (doVerb theVerb)
		(if (== theVerb 20) ; Turquoise_Piece_a
			(-= gInventoryCount 2)
			(gEgo get: 13) ; Puzzle
			(gTheInvCursor view: (Puzzle cView:) loop: 1 cel: 11)
			(if (== gTheCursor gTheInvCursor)
				(gTheInvCursor init:)
			)
			(Turquoise_Piece_a owner: -1 hide: setHotspot: 0)
			(Turquoise_Piece_b owner: -1 hide: setHotspot: 0)
			(Puzzle hide:)
			(gUser message: 23)
			(= global308 Puzzle)
			(reposition doit:)
			(= global331 0)
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance Puzzle of KQInventory
	(properties
		modNum 0
		view 313
		verb 23
		cView 990
		cLoop 1
		cCel 11
	)
)

(instance Corn_Kernel of KQInventory
	(properties
		name {Corn Kernel}
		modNum 0
		view 314
		verb 24
		cView 990
		cLoop 1
		cCel 13
	)
)

(instance Salt_Water of KQInventory
	(properties
		name {Salt Water}
		modNum 0
		view 315
		verb 27
		cView 990
		cLoop 1
		cCel 15
	)
)

(instance Fresh_Water of KQInventory
	(properties
		name {Fresh Water}
		modNum 0
		view 316
		verb 28
		cView 990
		cLoop 2
		cCel 1
	)
)

(instance Rope of KQInventory
	(properties
		modNum 0
		view 317
		verb 25
		cView 990
		cLoop 2
		cCel 3
	)
)

(instance Bug_Reducing_Powder of KQInventory
	(properties
		name {Bug Reducing Powder}
		modNum 0
		view 318
		verb 26
		cView 990
		cLoop 2
		cCel 5
	)
)

(instance Ear_of_Corn of KQInventory
	(properties
		name {Ear of Corn}
		modNum 0
		view 319
		verb 30
		cView 990
		cLoop 2
		cCel 9
	)
)

(instance Prickly_Pear of KQInventory
	(properties
		name {Prickly Pear}
		modNum 0
		view 320
		verb 50
		cView 990
		cLoop 2
		cCel 11
	)
)

(instance Toy_Rat of KQInventory
	(properties
		name {Toy Rat}
		modNum 0
		view 323
		verb 32
		cView 991
		cCel 1
	)
)

(instance Bowl_a of KQInventory
	(properties
		name {Bowl}
		modNum 0
		view 324
		verb 33
		cView 991
		cCel 3
	)
)

(instance Silver_Spoon of KQInventory
	(properties
		name {Silver Spoon}
		modNum 0
		view 325
		verb 34
		cView 991
		cCel 5
	)
)

(instance Baked_Beetles of KQInventory
	(properties
		name {Baked Beetles}
		modNum 0
		view 326
		verb 35
		cView 991
		cCel 7
	)
)

(instance Dragon_Scale of KQInventory
	(properties
		name {Dragon Scale}
		modNum 0
		view 327
		verb 36
		cView 991
		cCel 9
	)
)

(instance Silver_Pellet of KQInventory
	(properties
		name {Silver Pellet}
		modNum 0
		view 328
		verb 37
		cView 991
		cCel 11
	)

	(method (doVerb theVerb)
		(if (== theVerb 84) ; Woolen_Stocking
			(gTheInvCursor
				view: (Sling cView:)
				loop: (Sling cLoop:)
				cel: (Sling cCel:)
			)
			(if (== gTheCursor gTheInvCursor)
				(gTheInvCursor init:)
			)
			(Silver_Pellet owner: -1 hide:)
			(-- gInventoryCount)
			(Woolen_Stocking owner: -1 hide:)
			(-- gInventoryCount)
			(gEgo get: 63) ; Sling
			(Sling hide:)
			(gUser message: 86)
			(= global308 Sling)
			(reposition doit:)
			(= global311 0)
			(self setHotspot: 0)
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance Shield of KQInventory
	(properties
		modNum 0
		view 329
		verb 38
		cView 991
		cCel 13
	)
)

(instance Shield_Spike of KQInventory
	(properties
		name {Shield Spike}
		modNum 0
		view 330
		verb 97
		cView 991
		cLoop 3
		cCel 13
	)
)

(instance Dragon_Toad of KQInventory
	(properties
		name {Dragon Toad}
		modNum 0
		view 331
		verb 39
		cView 991
		cCel 15
	)
)

(instance Enchanted_Rope of KQInventory
	(properties
		name {Enchanted Rope}
		modNum 0
		view 332
		verb 40
		cView 990
		cLoop 3
		cCel 1
	)
)

(instance Bowl_b of KQInventory
	(properties
		name {Bowl}
		modNum 0
		view 333
		verb 95
		cView 991
		cLoop 3
		cCel 15
	)
)

(instance Wet_Sulfur of KQInventory
	(properties
		name {Wet Sulfur}
		modNum 0
		view 334
		verb 41
		cView 991
		cLoop 1
		cCel 5
	)
)

(instance Lantern of KQInventory
	(properties
		modNum 0
		view 335
		verb 43
		cView 991
		cLoop 1
		cCel 7
	)
)

(instance Lantern_with_Spark of KQInventory
	(properties
		name {Lantern with Spark}
		modNum 0
		view 336
		verb 44
		cView 991
		cLoop 1
		cCel 9
	)
)

(instance Big_Gem of KQInventory
	(properties
		name {Big Gem}
		modNum 0
		view 337
		verb 45
		cView 991
		cLoop 1
		cCel 11
	)
)

(instance Hammer_and_Chisel of KQInventory
	(properties
		name {Hammer and Chisel}
		modNum 0
		view 338
		verb 46
		cView 991
		cLoop 1
		cCel 13
	)
)

(instance Salt_Crystals of KQInventory
	(properties
		name {Salt Crystals}
		modNum 0
		view 321
		verb 51
		cView 990
		cLoop 2
		cCel 7
	)
)

(instance Turquoise_Shape of KQInventory
	(properties
		name {Turquoise Shape}
		modNum 0
		view 322
		verb 53
		cView 991
		cLoop 2
		cCel 1
	)
)

(instance Crook of KQInventory
	(properties
		modNum 0
		view 339
		verb 52
		cView 991
		cLoop 2
		cCel 3
	)
)

(instance Nectar_in_Pot of KQInventory
	(properties
		name {Nectar in Pot}
		modNum 0
		view 340
		verb 54
		cView 991
		cLoop 2
		cCel 5
	)
)

(instance Feather of KQInventory
	(properties
		modNum 0
		view 341
		verb 55
		cView 991
		cLoop 2
		cCel 7
	)
)

(instance China_Bird of KQInventory
	(properties
		name {China Bird}
		modNum 0
		view 342
		verb 56
		cView 991
		cLoop 2
		cCel 9
	)
)

(instance Mask of KQInventory
	(properties
		modNum 0
		view 343
		verb 57
		cView 991
		cLoop 2
		cCel 11
	)
)

(instance Wooden_Nickel of KQInventory
	(properties
		name {Wooden Nickel}
		modNum 0
		view 344
		verb 59
		cView 991
		cLoop 2
		cCel 13
	)
)

(instance Book of KQInventory
	(properties
		modNum 0
		view 345
		verb 58
		cView 991
		cLoop 2
		cCel 15
	)
)

(instance Rubber_Chicken of KQInventory
	(properties
		name {Rubber Chicken}
		modNum 0
		view 346
		verb 60
		cView 991
		cLoop 4
		cCel 1
	)
)

(instance Magic_Statue of KQInventory
	(properties
		name {Magic Statue}
		modNum 0
		view 347
		verb 61
		cView 991
		cLoop 3
		cCel 3
	)

	(method (doVerb theVerb)
		(if
			(and
				(not (IsFlag 137))
				(== theVerb 5) ; Golden_Comb
				(not (IsFlag 338))
				(not (OneOf gCurRoomNum 1155 1410 1601 1105 1255 1260 1460))
				(!= (gEgo view:) 1201)
				(not (gCurRoom inset:))
			)
			(cond
				((and (== gChapter 3) (not (IsFlag 201)))
					(SetFlag 201)
					(localproc_0)
				)
				((and (== gChapter 5) (not (IsFlag 550)))
					(SetFlag 550)
					(localproc_0)
					(self deleteHotVerb: 5) ; Golden_Comb
				)
				(else
					(super doVerb: theVerb)
				)
			)
		else
			(super doVerb: theVerb)
		)
		(return 1)
	)
)

(instance Grave_Digger_s_Horn of KQInventory
	(properties
		name {Grave Digger's Horn}
		modNum 0
		view 349
		verb 65
		cView 991
		cLoop 3
		cCel 5
	)
)

(instance Back_Bone of KQInventory
	(properties
		name {Back Bone}
		modNum 0
		view 350
		verb 66
		cView 991
		cLoop 3
		cCel 7
	)
)

(instance Weird_Pet of KQInventory
	(properties
		name {Weird Pet}
		modNum 0
		view 351
		verb 67
		cView 991
		cLoop 3
		cCel 9
	)
)

(instance Defoliant of KQInventory
	(properties
		modNum 0
		view 352
		verb 68
		cView 991
		cLoop 3
		cCel 11
	)
)

(instance Magic_Wand of KQInventory
	(properties
		name {Magic Wand}
		modNum 0
		view 353
		verb 69
		cView 992
		cCel 1
	)

	(method (doVerb theVerb)
		(if
			(and
				scratch
				(& (scratch _respondVerbs:) (gKqRespondCode doit: theVerb))
				(not (gCurRoom inset:))
				(== theVerb 74) ; Scarab
				(not (gCast contains: (ScriptID 4001 3))) ; myBoogeyMan
				(not (OneOf gCurRoomNum 4010 4600 4700 4550 4200 4300))
			)
			(if (!= gCurRoomNum 5200)
				(SetFlag 170)
				(OogaBooga cue:)
			else
				(gCurRoom notify:)
				(gEgo put: 55) ; Scarab
				(Flag hide:)
				(reposition doit:)
				(= global311 0)
				(self setHotspot: 0)
			)
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance Veil of KQInventory
	(properties
		modNum 0
		view 354
		verb 70
		cView 992
		cCel 3
	)
)

(instance Moon of KQInventory
	(properties
		modNum 0
		view 348
		verb 71
		cView 992
		cCel 5
	)
)

(instance Pomegranate of KQInventory
	(properties
		modNum 0
		view 366
		verb 73
		cView 992
		cCel 9
	)
)

(instance Scarab of KQInventory
	(properties
		modNum 0
		view 355
		verb 74
		cView 992
		cCel 11
	)

	(method (doVerb theVerb)
		(if
			(and
				scratch
				(& (scratch _respondVerbs:) (gKqRespondCode doit: theVerb))
				(not (gCurRoom inset:))
				(== theVerb 69) ; Magic_Wand
				(not (gCast contains: (ScriptID 4001 3))) ; myBoogeyMan
				(not (OneOf gCurRoomNum 4010 4600 4700 4550 4200 4300))
			)
			(if (!= gCurRoomNum 5200)
				(SetFlag 170)
				(OogaBooga cue:)
			else
				(gCurRoom notify:)
				(self owner: -1 hide:)
				(-- gInventoryCount)
				(gEgo put: 55) ; Scarab
				(Flag hide:)
				(gUser message: 69)
				(= global308 Magic_Wand)
				(reposition doit:)
				(= global311 0)
				(self setHotspot: 0)
			)
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance Shovel of KQInventory
	(properties
		modNum 0
		view 356
		verb 75
		cView 992
		cCel 13
	)
)

(instance Ambrosia of KQInventory
	(properties
		modNum 0
		view 367
		verb 76
		cView 992
		cCel 15
	)
)

(instance Grave_Digger_s_Rat of KQInventory
	(properties
		name {Grave Digger's Rat}
		modNum 0
		view 357
		verb 78
		cView 992
		cLoop 3
		cCel 1
	)
)

(instance Extra_Life of KQInventory
	(properties
		name {Extra Life}
		modNum 0
		view 358
		verb 77
		cView 992
		cLoop 1
		cCel 1
	)
)

(instance Foot_In_A_Bag of KQInventory
	(properties
		name {Foot-In-A-Bag}
		modNum 0
		view 359
		verb 79
		cView 992
		cLoop 1
		cCel 3
	)
)

(instance Fragrant_Flower of KQInventory
	(properties
		name {Fragrant Flower}
		modNum 0
		view 360
		verb 80
		cView 992
		cLoop 1
		cCel 5
	)
)

(instance Dream_Catcher of KQInventory
	(properties
		name {Dream Catcher}
		modNum 0
		view 368
		verb 81
		cView 992
		cLoop 1
		cCel 7
	)
)

(instance Magic_Bridle of KQInventory
	(properties
		name {Magic Bridle}
		modNum 0
		view 369
		verb 82
		cView 992
		cLoop 1
		cCel 9
	)
)

(instance Tapestry_of_Dreams of KQInventory
	(properties
		name {Tapestry of Dreams}
		modNum 0
		view 370
		verb 83
		cView 992
		cLoop 1
		cCel 11
	)
)

(instance Woolen_Stocking of KQInventory
	(properties
		name {Woolen Stocking}
		modNum 0
		view 361
		verb 84
		cView 992
		cLoop 1
		cCel 13
	)

	(method (doVerb theVerb)
		(if (== theVerb 37) ; Silver_Pellet
			(gTheInvCursor
				view: (Sling cView:)
				loop: (Sling cLoop:)
				cel: (Sling cCel:)
			)
			(if (== gTheCursor gTheInvCursor)
				(gTheInvCursor init:)
			)
			(Silver_Pellet owner: -1 hide:)
			(-- gInventoryCount)
			(Woolen_Stocking owner: -1 hide:)
			(-- gInventoryCount)
			(gEgo get: 63) ; Sling
			(Sling hide:)
			(gUser message: 86)
			(= global308 Sling)
			(reposition doit:)
			(= global311 0)
			(self setHotspot: 0)
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance Device of KQInventory
	(properties
		modNum 0
		view 362
		verb 85
		cView 992
		cLoop 1
		cCel 15
	)
)

(instance Crystal_Shaft of KQInventory
	(properties
		name {Crystal Shaft}
		modNum 0
		view 380
		verb 87
		cView 992
		cLoop 2
		cCel 1
	)
)

(instance Sling of KQInventory
	(properties
		modNum 0
		view 363
		verb 86
		cView 992
		cLoop 2
		cCel 3
	)
)

(instance Golden_Grape of KQInventory
	(properties
		name {Golden Grape}
		modNum 0
		view 364
		verb 88
		cView 992
		cLoop 2
		cCel 5
	)
)

(instance Femur of KQInventory
	(properties
		modNum 0
		view 372
		verb 90
		cView 992
		cLoop 2
		cCel 7
	)
)

(instance Horseman_s_Medal of KQInventory
	(properties
		name {Horseman's Medal}
		modNum 0
		view 373
		verb 89
		cView 992
		cLoop 2
		cCel 9
	)
)

(instance Firecracker of KQInventory
	(properties
		modNum 0
		view 374
		verb 92
		cView 992
		cLoop 4
		cCel 3
	)
)

(instance Horseman_s_Head of KQInventory
	(properties
		name {Horseman's Head}
		modNum 0
		view 375
		verb 93
		cView 992
		cLoop 2
		cCel 13
	)
)

(instance Horseman_s_Fife of KQInventory
	(properties
		name {Horseman's Fife}
		modNum 0
		view 376
		verb 94
		cView 992
		cLoop 2
		cCel 15
	)
)

(instance Shrieking_Horn of KQInventory
	(properties
		name {Shrieking Horn}
		modNum 0
		view 377
		verb 100
		cView 992
		cLoop 5
		cCel 1
	)
)

(instance Ooga_Booga_Flower of KQInventory
	(properties
		name {Ooga Booga Flower}
		modNum 0
		view 378
		verb 101
		cView 992
		cLoop 4
		cCel 1
	)
)

(instance reposition of Code
	(properties)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp3 0)
		(for ((= temp4 0)) (< temp4 (gInventory size:)) ((+= temp4 1))
			(= temp2 (gInventory at: temp4))
			(if (temp2 ownedBy: gValOrRoz)
				(if (< temp3 7)
					(= temp0 (+ 73 (* temp3 20)))
				else
					(= temp0 (+ 73 (* (- temp3 7) 20)))
				)
				(= temp1 (if (< temp3 7) 19 else 32))
				(if (temp2 isNotHidden:)
					(temp2 posn: temp0 temp1)
					(UpdateScreenItem temp2)
				else
					(temp2 newX: temp0 newY: temp1)
				)
				(++ temp3)
			)
		)
	)
)

(instance visionSound of Sound
	(properties)
)

(instance visionSound1 of Sound
	(properties)
)

