;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64037)
(include sci.sh)
(use Main)
(use TPSound)
(use oPopupMenuHandler)
(use TranslucentPlane)
(use CueMe)
(use ModalPlane)
(use PushButton)
(use InventItem)
(use soFlashCyberSniff)
(use Actor)
(use System)

(public
	oInvHandler 0
	proc64037_1 1
	oInvPlane 2
	proc64037_3 3
)

(local
	local0
	local1
)

(procedure (proc64037_3 param1 &tmp temp0 temp1 temp2 temp3)
	(= temp1 ((ScriptID 64037 0) oAllHandledItems:)) ; oInvHandler
	(= temp0 (temp1 size:))
	(for ((= temp2 0)) (< temp2 temp0) ((++ temp2))
		(= temp3 (temp1 at: temp2))
		(if (== param1 (temp3 verb:))
			(return 1)
		)
	)
	(return 0)
)

(procedure (proc64037_1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp1
		(+
			(*
				((ScriptID 64037 0) viewSlotsX:) ; oInvHandler
				(+ ((ScriptID 64037 0) slotIncX:) 3) ; oInvHandler
			)
			3
		)
	)
	(= temp0
		(+
			(= temp0
				(+
					(*
						((ScriptID 64037 0) viewSlotsY:) ; oInvHandler
						(+ ((ScriptID 64037 0) slotIncY:) 3) ; oInvHandler
					)
					3
				)
			)
			15
		)
	)
	(= temp2 (/ (- 640 temp1) 2))
	(= temp3 (Max (/ (- 480 temp0) 2) 0))
	(oInvPlane init: temp2 temp3 (+ temp2 (- temp1 1)) (+ temp3 (- temp0 1)))
	(= temp5 (View new:))
	(temp5 bitmap: (Bitmap 0 temp1 15 255 82 640 480 0)) ; Create
	(Bitmap 5 (temp5 bitmap:) 0 0 (- temp1 1) 14 82) ; AddRect
	(temp5 setPri: 10 init: oInvPlane)
	(= temp4 (MakeMessageText 0 0 50 1 14)) ; "Inventory"
	(= temp6 (TextItem new:))
	(temp6
		text: temp4
		font: 0
		fore: 0
		back: 255
		skip: 255
		nMinWidth: temp1
		x: 0
		y: 0
		priority: 15
		fixPriority: 1
		init: oInvPlane
	)
	(oInvClose x: 2 y: 2 setPri: 20 init: oInvPlane)
	((OpaqueFeature new:) init: oInvPlane)
	((MoveFeature new:) init: oInvPlane y: 15 makeTopBorder: 15)
	((ScriptID 64037 0) init: (oInvPlane getMainCast:)) ; oInvHandler
)

(instance coDoneTalking of CueMe
	(properties)

	(method (cue)
		(= local1 0)
	)
)

(instance soChaseLights of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local1 1)
				(gMessager say: 38 34 0 0 coDoneTalking 11) ; "Cool."
				(= temp0 ((ScriptID 64037 0) oScreenSlots:)) ; oInvHandler
				(= temp3 (temp0 size:))
				(for ((= temp2 0)) (< temp2 temp3) ((++ temp2))
					(if
						(and
							(= temp1 (temp0 at: temp2))
							(== (temp1 ioMine:) ioChaseLights)
						)
						(= local0 temp1)
						(break)
					)
				)
				(if (not local0)
					(PrintDebug {Can't find light slot. DJM})
					(gGame handsOn:)
					(self dispose:)
					(return)
				)
				(local0 cel: 1)
				(= ticks 6)
				(= register 12)
			)
			(1
				(local0 cel: 0)
				(= ticks 6)
			)
			(2
				(local0 cel: 1)
				(= ticks 6)
				(if (and (<= register 0) (not local1))
					(gGame handsOn:)
					(self dispose:)
					(return)
				)
				(-- register)
				(-= state 2)
			)
		)
	)
)

(instance oInvPlane of TranslucentPlane
	(properties)

	(method (setPri &tmp temp0 temp1)
		(= temp0 priority)
		(super setPri: &rest)
		(if (and (== gCurRoomNum 110) (!= priority -1)) ; ro110
			(gCurRoom notify: 4)
		)
		(if (!= temp0 priority)
			(= temp1 ((ScriptID 64000 1) priority:)) ; oMenuPopupPlane
			((ScriptID 64000 1) setPri: 1) ; oMenuPopupPlane
			(UpdatePlane (ScriptID 64000 1)) ; oMenuPopupPlane
			((ScriptID 64000 1) setPri: temp1) ; oMenuPopupPlane
			(UpdatePlane (ScriptID 64000 1)) ; oMenuPopupPlane
		)
	)
)

(instance oInvClose of PushButton
	(properties
		signal 16417
		view 60300
	)

	(method (doSelect)
		((ScriptID 64037 2) setPri: -1) ; oInvPlane
	)
)

(instance oInvHandler of InvHandler
	(properties
		blankID 60299
		viewSlotsX 7
		viewSlotsY 5
		invSlotsX 7
		invSlotsY 5
		screenLocX 3
		screenLocY 81
		slotIncX 51
		slotIncY 67
	)

	(method (removeItem)
		(super removeItem: &rest)
		(self compress:)
	)

	(method (initItems &tmp [temp0 3])
		(self
			add:
				51
				ioViceGrips
				27
				ioNeedle
				1
				ioLockpick
				5
				ioCruiseTicket
				46
				ioScorecard
				54
				ioKeyCard
				8
				ioLewdPhoto
				26
				ioMucilage
				43
				ioStickyPhoto
				30
				ioPhotoID
				29
				ioPassport
				6
				ioMasterKey
				45
				ioSuitcase
				33
				ioPrudeAndProud
				34
				ioBookJacket
				10
				ioEroticBook
				11
				ioEroticAndProud
				12
				ioFirehose
				41
				ioLubricant
				7
				ioDeodorant
				13
				ioHeatBulb
				0
				ioChaseLights
				37
				ioRemote
				14
				ioHorseshoe
				47
				ioToiletPaper
				42
				ioSouvenirDice
				40
				ioShavedDice
				19
				ioLegalDice
				52
				ioMoney
				23
				ioMagPage
				32
				ioPot
				38
				ioSalt
				50
				ioBeaverMilk
				22
				ioLimeJuice
				25
				ioMold
				49
				ioBeaverCheese
				17
				ioKumquat
				16
				ioQuiche
				28
				ioOrgasmPowder
				36
				ioQuichePlus
				39
				ioScrewdriver
				15
				ioJumperWire
				3
				ioKnife
				31
				ioPolyester
				18
				ioKZJelly
				53
				ioHanky
				48
				ioHankyLubed
				2
				ioBowlingBall
				20
				ioInsurance
				44
				ioStock
				21
				ioHairWeaveKit
				9
				ioEarPlugs
				35
				ioNoCoverPrudeBk
				4
				ioCodmaster
				24
				ioMap
		)
	)
)

(instance ioViceGrips of InventItem
	(properties
		noun 48
		verb 13
		vInventory 60201
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(14 ; Needle
				(gEgo put: ioNeedle)
				(gEgo get: ioLockpick)
				(gOSound1 playSound: 10125)
				((ScriptID 64017 0) set: 12) ; oFlags
				(gCurRoom notify: 9)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioNeedle of InventItem
	(properties
		noun 31
		verb 14
		vInventory 60202
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5 135)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Vice Grips
				(gOSound1 playSound: 10125)
				(gEgo put: self)
				(gEgo get: ioLockpick)
				((ScriptID 64017 0) set: 12) ; oFlags
				(gCurRoom notify: 9)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioLockpick of InventItem
	(properties
		noun 30
		verb 65
		vInventory 60203
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Feel
				(ioNeedle doVerb: 5)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioCruiseTicket of InventItem
	(properties
		noun 10
		vInventory 60204
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance ioScorecard of InventItem
	(properties
		noun 40
		verb 16
		vInventory 60205
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				((ScriptID 40 0) init:) ; oScoreCard
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioKeyCard of InventItem
	(properties
		noun 21
		verb 17
		vInventory 60206
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(20 ; Sticky Photograph
				(gEgo put: self put: ioStickyPhoto get: ioPhotoID)
				((ScriptID 64017 0) set: 6) ; oFlags
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioLewdPhoto of InventItem
	(properties
		noun 24
		verb 18
		vInventory 60207
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(19 ; Mucilage
				(gEgo put: self put: ioMucilage get: ioStickyPhoto)
				((ScriptID 64017 0) set: 11) ; oFlags
				(gMessager say: 24 19 0 0 0 11) ; "Good job. Now the photos of you are not only dirty, they're sticky!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioMucilage of InventItem
	(properties
		noun 29
		verb 19
		vInventory 60208
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(18 ; Dirty Pictures
				(gEgo put: ioLewdPhoto put: self get: ioStickyPhoto)
				((ScriptID 64017 0) set: 11) ; oFlags
				(gMessager say: 24 19 0 0 0 11) ; "Good job. Now the photos of you are not only dirty, they're sticky!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioStickyPhoto of InventItem
	(properties
		noun 43
		verb 20
		vInventory 60209
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(17 ; Your Cabin Keycard
				(gEgo put: ioKeyCard put: self get: ioPhotoID)
				((ScriptID 64017 0) set: 6) ; oFlags
				(gMessager say: 21 20 0 0 0 11) ; "Good idea!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioPhotoID of InventItem
	(properties
		noun 34
		verb 21
		vInventory 60210
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance ioPassport of InventItem
	(properties
		noun 33
		verb 22
		vInventory 60211
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance ioMasterKey of InventItem
	(properties
		noun 27
		verb 23
		vInventory 60212
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance ioSuitcase of InventItem
	(properties
		noun 45
		verb 24
		vInventory 60213
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance ioPrudeAndProud of InventItem
	(properties
		noun 6
		verb 26
		vInventory 60214
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 201)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(201 ; Remove jacket
				(gEgo put: self)
				(gEgo get: ioNoCoverPrudeBk)
				(gEgo get: ioBookJacket)
				((ScriptID 64017 0) set: 8) ; oFlags
			)
			(97 ; Read
				(super doVerb: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioBookJacket of InventItem
	(properties
		noun 5
		verb 27
		vInventory 60215
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(28 ; "The Erotic Adventures of Hercules"
				(gEgo put: self)
				(gEgo put: ioEroticBook)
				(gEgo get: ioEroticAndProud)
				((ScriptID 64017 0) set: 5) ; oFlags
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioEroticBook of InventItem
	(properties
		noun 4
		verb 28
		vInventory 60216
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(27 ; "Prudish and Proud" Book Jacket
				(gEgo put: self)
				(gEgo put: ioBookJacket)
				(gEgo get: ioEroticAndProud)
				((ScriptID 64017 0) set: 5) ; oFlags
			)
			(97 ; Read
				(super doVerb: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioEroticAndProud of InventItem
	(properties
		noun 3
		verb 29
		vInventory 60217
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(97 ; Read
				(super doVerb: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioFirehose of InventItem
	(properties
		noun 15
		verb 30
		vInventory 60218
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance ioLubricant of InventItem
	(properties
		noun 42
		verb 31
		vInventory 60219
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance ioDeodorant of InventItem
	(properties
		noun 11
		verb 32
		vInventory 60220
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 71)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(71 ; Smell
				(proc64896_15 3 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioHeatBulb of InventItem
	(properties
		noun 17
		verb 33
		vInventory 60221
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance ioChaseLights of InventItem
	(properties
		noun 9
		verb 34
		vInventory 60222
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(35 ; Remote Control
				(ioRemote doVerb: 62)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ioRemote of InventItem
	(properties
		noun 38
		verb 35
		vInventory 60223
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 62)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(34 ; Battery Powered Chase Lights
				(self doVerb: 62)
			)
			(62 ; Turn on
				(cond
					(
						(and
							(OneOf gCurRoomNum 360 363) ; ro360, ro363
							((ScriptID 64017 0) test: 85) ; oFlags
						)
						(gCurRoom notify:)
					)
					((and (== gCurRoomNum 250) ((ScriptID 64017 0) test: 85)) ; ro250, oFlags
						((ScriptID 64017 0) set: 4) ; oFlags
						((ScriptID 64017 0) set: 182) ; oFlags
						(gMessager say: 38 3 2 0 0 11) ; "Watch out!"
					)
					(((ScriptID 64017 0) test: 85) ; oFlags
						(gMessager say: 38 3 2 0 0 11) ; "Watch out!"
					)
					((gEgo has: ((ScriptID 64037 0) get: 0)) ; oInvHandler, ioChaseLights
						((ScriptID 64017 0) set: 3) ; oFlags
						(gGame setScript: soChaseLights)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioHorseshoe of InventItem
	(properties
		noun 18
		verb 36
		vInventory 60224
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance ioToiletPaper of InventItem
	(properties
		noun 47
		verb 37
		vInventory 60225
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 5)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				((ScriptID 64017 0) set: 146) ; oFlags
				(super doVerb: theVerb &rest)
			)
			(38 ; Souvenir Dice
				(gEgo put: ioSouvenirDice get: ioShavedDice)
				(oInvSFX playSound: 37004)
				((ScriptID 64017 0) set: 9) ; oFlags
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioSouvenirDice of InventItem
	(properties
		noun 14
		verb 38
		vInventory 60226
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(52 ; Carving Knife
				(gMessager say: 1 234 0 3 0 520) ; "Think again."
			)
			(37 ; Toilet Paper
				(gEgo put: ioSouvenirDice get: ioShavedDice)
				(oInvSFX playSound: 37004)
				((ScriptID 64017 0) set: 9) ; oFlags
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioShavedDice of InventItem
	(properties
		noun 13
		verb 39
		vInventory 60227
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance ioLegalDice of InventItem
	(properties
		noun 12
		verb 40
		vInventory 60228
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(52 ; Carving Knife
				(gMessager say: 1 234 0 3 0 520) ; "Think again."
			)
			(37 ; Toilet Paper
				(gMessager say: 1 234 0 3 0 520) ; "Think again."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioMoney of InventItem
	(properties
		noun 49
		verb 72
		vInventory 60229
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance ioMagPage of InventItem
	(properties
		noun 50
		verb 73
		vInventory 60230
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 97 71)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(97 ; Read
				(if ((ScriptID 64017 0) test: 285) ; oFlags
					(global258 add: 145)
				)
				(super doVerb: theVerb)
				((ScriptID 64017 0) set: 0) ; oFlags
			)
			(71 ; Smell
				(super doVerb: theVerb)
				(proc64896_15 7 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioPot of InventItem
	(properties
		noun 36
		verb 41
		vInventory 60231
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance ioSalt of InventItem
	(properties
		noun 39
		verb 42
		vInventory 60232
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(43 ; Venezuelan Beaver Milk
				(cond
					(
						(and
							(gEgo has: ((ScriptID 64037 0) get: 50)) ; oInvHandler, ioBeaverMilk
							(gEgo has: ((ScriptID 64037 0) get: 22)) ; oInvHandler, ioLimeJuice
							(gEgo has: ((ScriptID 64037 0) get: 25)) ; oInvHandler, ioMold
							(gEgo has: ((ScriptID 64037 0) get: 38)) ; oInvHandler, ioSalt
							(== gCurRoomNum 540) ; ro540
						)
						(oInvPlane setPri: -1)
						(gCurRoom notify:)
					)
					(
						(and
							(gEgo has: ((ScriptID 64037 0) get: 50)) ; oInvHandler, ioBeaverMilk
							(gEgo has: ((ScriptID 64037 0) get: 22)) ; oInvHandler, ioLimeJuice
							(gEgo has: ((ScriptID 64037 0) get: 25)) ; oInvHandler, ioMold
							(gEgo has: ((ScriptID 64037 0) get: 38)) ; oInvHandler, ioSalt
						)
						(gMessager say: 1 42 0 0 0 11) ; "The ship's kitchen would be a perfect place to mix ingredients."
					)
					(else
						(gMessager say: 1 42 4 0 0 11) ; "You COULD prepare something, IF you had a recipe, AND you had all the ingredients."
					)
				)
			)
			(45 ; Lime Juice
				(ioSalt doVerb: 43)
			)
			(44 ; Mold
				(ioSalt doVerb: 43)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioBeaverMilk of InventItem
	(properties
		noun 2
		verb 43
		vInventory 60233
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(42 ; Salt
				(ioSalt doVerb: 43)
			)
			(45 ; Lime Juice
				(ioSalt doVerb: 43)
			)
			(44 ; Mold
				(ioSalt doVerb: 43)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioLimeJuice of InventItem
	(properties
		noun 25
		verb 45
		vInventory 60234
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(42 ; Salt
				(ioSalt doVerb: 43)
			)
			(43 ; Venezuelan Beaver Milk
				(ioSalt doVerb: 43)
			)
			(44 ; Mold
				(ioSalt doVerb: 43)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioMold of InventItem
	(properties
		noun 28
		verb 44
		vInventory 60235
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 71)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(71 ; Smell
				(proc64896_15 8 1)
			)
			(42 ; Salt
				(ioSalt doVerb: 43)
			)
			(43 ; Venezuelan Beaver Milk
				(ioSalt doVerb: 43)
			)
			(45 ; Lime Juice
				(ioSalt doVerb: 43)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioBeaverCheese of InventItem
	(properties
		noun 1
		verb 46
		vInventory 60236
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 71)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(52 ; Carving Knife
				(cond
					(
						(and
							(== gCurRoomNum 540) ; ro540
							(gEgo has: ((ScriptID 64037 0) get: 17)) ; oInvHandler, ioKumquat
						)
						(oInvPlane setPri: -1)
						(gCurRoom notify:)
					)
					((gEgo has: ((ScriptID 64037 0) get: 17)) ; oInvHandler, ioKumquat
						(gMessager say: 1 42 0 0 0 11) ; "The ship's kitchen would be a perfect place to mix ingredients."
					)
					(else
						(gMessager say: 1 42 4 0 0 11) ; "You COULD prepare something, IF you had a recipe, AND you had all the ingredients."
					)
				)
			)
			(47 ; Kumquats
				(if (== gCurRoomNum 540) ; ro540
					(oInvPlane setPri: -1)
					(gCurRoom notify:)
				else
					(gMessager say: 1 42 0 0 0 11) ; "The ship's kitchen would be a perfect place to mix ingredients."
				)
			)
			(71 ; Smell
				(proc64896_15 8 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioKumquat of InventItem
	(properties
		noun 22
		verb 47
		vInventory 60237
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 92 7)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(46 ; Venezuelan Beaver Cheese
				(if (== gCurRoomNum 540) ; ro540
					(oInvPlane setPri: -1)
					(gCurRoom notify:)
				else
					(gMessager say: 1 42 0 0 0 11) ; "The ship's kitchen would be a perfect place to mix ingredients."
				)
			)
			(52 ; Carving Knife
				(cond
					(
						(and
							(== gCurRoomNum 540) ; ro540
							(gEgo has: ((ScriptID 64037 0) get: 49)) ; oInvHandler, ioBeaverCheese
						)
						(oInvPlane setPri: -1)
						(gCurRoom notify:)
					)
					((gEgo has: ((ScriptID 64037 0) get: 49)) ; oInvHandler, ioBeaverCheese
						(gMessager say: 1 42 0 0 0 11) ; "The ship's kitchen would be a perfect place to mix ingredients."
					)
					(else
						(gMessager say: 1 42 4 0 0 11) ; "You COULD prepare something, IF you had a recipe, AND you had all the ingredients."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioQuiche of InventItem
	(properties
		noun 37
		verb 48
		vInventory 60238
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 92 71)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(49 ; Orgasmic Powder
				(gGame setScript: soSpikeQuiche)
			)
			(71 ; Smell
				(super doVerb: theVerb)
				(proc64896_15 8 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance soSpikeQuiche of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 37 49 0 0 self 11) ; "This ought to "spice it up" a little!"
			)
			(1
				(oQuicheSound playSound: 54101 self)
			)
			(2
				(gEgo put: ioQuiche get: ioQuichePlus)
				((ScriptID 64017 0) set: 7) ; oFlags
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance oQuicheSound of TPSound
	(properties)
)

(instance ioOrgasmPowder of InventItem
	(properties
		noun 32
		verb 49
		vInventory 60239
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 92)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(48 ; Kumquat Quiche
				(gGame setScript: soSpikeQuiche)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioQuichePlus of InventItem
	(properties
		noun 51
		verb 74
		vInventory 60240
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 92 71)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(71 ; Smell
				(proc64896_15 8 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioScrewdriver of InventItem
	(properties
		noun 41
		verb 50
		vInventory 60241
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance ioJumperWire of InventItem
	(properties
		noun 20
		verb 51
		vInventory 60242
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance ioKnife of InventItem
	(properties
		noun 8
		verb 52
		vInventory 60243
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance ioPolyester of InventItem
	(properties
		noun 35
		verb 53
		vInventory 60244
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if ((ScriptID 64017 0) test: 285) ; oFlags
					(global252 add: 191)
				)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioKZJelly of InventItem
	(properties
		noun 23
		verb 54
		vInventory 60245
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(55 ; Woman's Handkerchief
				(gEgo put: ioHanky get: ioHankyLubed)
				((ScriptID 64017 0) set: 10) ; oFlags
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioHanky of InventItem
	(properties
		noun 16
		verb 55
		vInventory 60246
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 87)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(54 ; KZ Sexual Lubricant
				(gEgo put: self get: ioHankyLubed)
				((ScriptID 64017 0) set: 10) ; oFlags
			)
			(71 ; Smell
				(super doVerb: theVerb)
				(proc64896_15 4 0)
				((ScriptID 64017 0) set: 2) ; oFlags
			)
			(57 ; Bowling Ball
				(gCurRoom notify: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioHankyLubed of InventItem
	(properties
		noun 26
		verb 56
		vInventory 60247
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(57 ; Bowling Ball
				(gCurRoom notify: 2)
			)
			(71 ; Smell
				(proc64896_15 4 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioBowlingBall of InventItem
	(properties
		noun 7
		verb 57
		vInventory 60248
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 144)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(144 ; Bowl
				(gCurRoom notify: 0)
			)
			(55 ; Woman's Handkerchief
				(gCurRoom notify: 1)
			)
			(56 ; Treated Handkerchief
				(gCurRoom notify: 2)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioInsurance of InventItem
	(properties
		noun 19
		verb 58
		vInventory 60249
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb &rest)
				(global255 add: 182)
				(if ((ScriptID 64017 0) test: 285) ; oFlags
					(global256 add: 182)
				)
				((ScriptID 64017 0) set: 280) ; oFlags
				((ScriptID 64017 0) set: 1) ; oFlags
			)
			(71 ; Smell
				(proc64896_15 4 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioStock of InventItem
	(properties
		noun 44
		verb 59
		vInventory 60250
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance ioHairWeaveKit of InventItem
	(properties
		noun 52
		verb 98
		vInventory 60251
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 61)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(61 ; Open
				(super doVerb: theVerb)
				(gEgo put: self)
				(gEgo get: ioNeedle)
				((ScriptID 64017 0) set: 13) ; oFlags
				(gCurRoom notify: 8)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioEarPlugs of InventItem
	(properties
		noun 53
		verb 137
		vInventory 60252
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance ioNoCoverPrudeBk of InventItem
	(properties
		noun 54
		verb 138
		vInventory 60253
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(97 ; Read
				(super doVerb: 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ioCodmaster of InventItem
	(properties
		noun 46
		verb 25
		vInventory 60255
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance ioMap of InventItem
	(properties
		verb 155
		vInventory 60254
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				((ScriptID 64000 7) doSelect:) ; moMap
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance oInvSFX of TPSound
	(properties)
)

