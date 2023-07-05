;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 758)
(include sci.sh)
(use Main)
(use Interface)
(use KQ5InvWindow)
(use DLetter)
(use KQCursor)
(use IconBar)
(use Inventory)

(public
	KQInv 0
)

(class KQInvItem of InvI
	(properties)

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp4 (if (and argc param1) highlightColor else lowlightColor))
		(= temp0 nsTop)
		(= temp1 nsLeft)
		(= temp2 nsBottom)
		(= temp3 nsRight)
		(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
		(Graph grUPDATE_BOX (- nsTop 2) (- nsLeft 2) (+ nsBottom 2) (+ nsRight 2) 1)
	)

	(method (doVerb theVerb &tmp [temp0 3])
		(if (and (== theVerb 2) description)
			(Print 749 description)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance KQInv of Inv
	(properties
		normalHeading {Graham is carrying:}
		empty {Nothing!}
		curScore 9693
	)

	(method (init)
		((= gInventory self)
			add:
				Ok
				(Key cursor: keyCursor yourself:)
				(Pie cursor: pieCursor yourself:)
				(Golden_Needle cursor: needleCursor yourself:)
				(Coin cursor: silverCursor yourself:)
				(Fish cursor: fishCursor yourself:)
				(Brass_Bottle cursor: bottleCursor yourself:)
				(Staff cursor: staffCursor yourself:)
				(Shoe cursor: shoeCursor yourself:)
				(Heart cursor: heartCursor yourself:)
				(Harp cursor: harpCursor yourself:)
				(Gold_Coin cursor: goldCursor yourself:)
				(Marionette cursor: puppetCursor yourself:)
				(Pouch cursor: pouchCursor yourself:)
				(Emeralds cursor: threeEmeraldCursor yourself:)
				(Spinning_Wheel cursor: wheelCursor yourself:)
				(Stick cursor: stickCursor yourself:)
				(Honeycomb cursor: honeyCursor yourself:)
				(Beeswax cursor: waxCursor yourself:)
				(Leg_of_Lamb cursor: lambCursor yourself:)
				(Rope cursor: ropeCursor yourself:)
				(Crystal cursor: crystalCursor yourself:)
				(Hammer cursor: hammerCursor yourself:)
				(Shell cursor: shellCursor yourself:)
				(Bag_of_Peas cursor: peasCursor yourself:)
				(Locket cursor: locketCursor yourself:)
				(Cloak cursor: cloakCursor yourself:)
				(Amulet cursor: amuletCursor yourself:)
				(Wand
					cursor:
						(if (not (IsFlag 60))
							cwandCursor
						else
							cGlowWandCursor
						)
					yourself:
				)
				(Sled cursor: sledCursor yourself:)
				(Iron_Bar cursor: ironbarCursor yourself:)
				(Fishhook cursor: hookCursor yourself:)
				(Moldy_Cheese cursor: cheeseCursor yourself:)
				(Elf_Shoes_ cursor: elfShoeCursor yourself:)
				(Tambourine cursor: tambourineCursor yourself:)
				(Mordack_s_Wand cursor: mWandCursor yourself:)
				(Hairpin cursor: hairpinCursor yourself:)
				(Cat_Fish cursor: mFishCursor yourself:)
				(Mongoose_Spell cursor: cGlowWandCursor yourself:)
				(Bunny_Spell cursor: cGlowWandCursor yourself:)
				(Rain_Spell cursor: cGlowWandCursor yourself:)
				(Tiger_Spell cursor: cGlowWandCursor yourself:)
				(invLook cursor: eyeCursor yourself:)
				(invHand cursor: handCursor yourself:)
				(invSelect cursor: gNormalCursor yourself:)
				(invHelp cursor: helpCursor yourself:)
				(ok cursor: arrowCursor yourself:)
			eachElementDo: #highlightColor 0
			eachElementDo:
				#lowlightColor
				(switch global105
					(256 23)
					(32 15)
					(else 7)
				)
			eachElementDo: #init
			window: KQ5InvWindow
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
		)
	)
)

(instance Ok of KQInvItem
	(properties
		view 895
	)
)

(instance Key of KQInvItem
	(properties
		view 892
		loop 2
		cel 4
		signal 2
		description 1
		owner 23
	)
)

(instance Pie of KQInvItem
	(properties
		view 892
		cel 9
		signal 2
		description 2
		owner 206
	)
)

(instance Golden_Needle of KQInvItem
	(properties
		name {Golden Needle}
		view 892
		cel 10
		signal 2
		description 3
		owner 27
	)
)

(instance Coin of KQInvItem
	(properties
		view 892
		cel 1
		signal 2
		description 4
		owner 4
	)
)

(instance Fish of KQInvItem
	(properties
		view 891
		signal 2
		description 5
		owner 4
	)
)

(instance Brass_Bottle of KQInvItem
	(properties
		name {Brass Bottle}
		view 891
		cel 1
		signal 2
		description 6
		owner 18
	)

	(method (doVerb theVerb &tmp [temp0 75])
		(switch theVerb
			(3
				(gInventory hide:)
				(gCurRoom newRoom: 208) ; releaseGenie
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Staff of KQInvItem
	(properties
		view 891
		cel 2
		signal 2
		description 7
		owner 17
	)
)

(instance Shoe of KQInvItem
	(properties
		view 892
		cel 6
		signal 2
		description 8
		owner 15
	)
)

(instance Heart of KQInvItem
	(properties
		view 892
		loop 2
		cel 7
		signal 2
		description 9
		owner 21
	)
)

(instance Harp of KQInvItem
	(properties
		view 893
		signal 2
		description 10
		owner 9
	)
)

(instance Gold_Coin of KQInvItem
	(properties
		name {Gold Coin}
		view 891
		cel 3
		signal 2
		description 11
		owner 18
	)
)

(instance Marionette of KQInvItem
	(properties
		view 892
		cel 7
		signal 2
		description 12
	)
)

(instance Pouch of KQInvItem
	(properties
		view 892
		loop 2
		cel 5
		signal 2
		owner 23
	)

	(method (doVerb theVerb &tmp [temp0 75])
		(switch theVerb
			(2
				(cond
					((== global312 -1)
						(PrintDC 758 0) ; "The small leather pouch is drawn tightly closed."
					)
					(global312
						(StrCpy @temp0 {This leather pouch contains })
						(StrCat
							@temp0
							(switch global312
								(3 {three})
								(2 {two})
								(1 {one})
							)
						)
						(StrCat @temp0 { beautiful emerald})
						(StrCat @temp0 (if (> global312 1) {s.} else {.}))
						(PrintDC @temp0)
					)
					(else
						(PrintDC 758 1) ; "The pouch is empty."
					)
				)
			)
			(3
				(if (== global312 -1)
					(= global312 3)
					(ShowView (Format @temp0 758 2) 891 0 6) ; "Upon opening the leather pouch, Graham discovers three sparkling emeralds."
					(gInventory hide:)
					(self loop: 4 cel: 1)
					(gEgo get: 14) ; Emeralds
					(gInventory show: gEgo)
				else
					(PrintDC 758 3) ; "The pouch is already open."
				)
				(return 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Emeralds of KQInvItem
	(properties
		view 891
		cel 6
		signal 2
	)

	(method (doVerb theVerb &tmp [temp0 50])
		(switch theVerb
			(2
				(StrCpy @temp0 {The })
				(StrCat
					@temp0
					(switch global312
						(3 {trio of })
						(2 {pair of })
						(1 {})
					)
				)
				(StrCat @temp0 {sparkling emerald})
				(StrCat @temp0 (if (> global312 1) {s} else {}))
				(StrCat @temp0 { dazzle})
				(StrCat @temp0 (if (> global312 1) {} else {s}))
				(StrCat @temp0 { the eyes.})
				(PrintDC @temp0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Spinning_Wheel of KQInvItem
	(properties
		name {Spinning Wheel}
		view 892
		loop 2
		cel 6
		description 15
		owner 23
	)
)

(instance Stick of KQInvItem
	(properties
		view 892
		loop 2
		cel 1
		signal 2
		description 16
		owner 11
	)
)

(instance Honeycomb of KQInvItem
	(properties
		view 891
		cel 7
		signal 2
		description 17
		owner 11
	)
)

(instance Beeswax of KQInvItem
	(properties
		view 892
		loop 2
		signal 2
		description 18
	)
)

(instance Leg_of_Lamb of KQInvItem
	(properties
		name {Leg of Lamb}
		view 892
		cel 4
		signal 2
		owner 28
	)

	(method (doVerb theVerb &tmp [temp0 50])
		(switch theVerb
			(2
				(StrCpy @temp0 {This is a })
				(StrCat
					@temp0
					(if global316 {left-over, half} else {large, mouthwatering})
				)
				(StrCat @temp0 { leg of lamb.})
				(PrintDC @temp0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Rope of KQInvItem
	(properties
		view 892
		cel 8
		signal 2
		description 20
		owner 86
	)
)

(instance Crystal of KQInvItem
	(properties
		view 893
		cel 1
		signal 2
		description 21
		owner 38
	)
)

(instance Hammer of KQInvItem
	(properties
		view 892
		loop 4
		signal 2
		description 22
	)
)

(instance Shell of KQInvItem
	(properties
		view 893
		cel 2
		signal 2
		description 23
	)
)

(instance Bag_of_Peas of KQInvItem
	(properties
		name {Bag of Peas}
		view 893
		cel 3
		signal 2
		description 24
		owner 56
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 63)
					(PrintDC 758 4) ; "A brown empty sack."
				else
					(PrintDC 749 description)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Locket of KQInvItem
	(properties
		view 893
		cel 6
		signal 2
		description 25
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3
				(PrintDC
					{Upon opening the locket, Graham sees a portrait of an older couple in regal attire. So as not to damage the picture, he quickly closes it again.}
				)
				(return 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Cloak of KQInvItem
	(properties
		view 892
		cel 2
		signal 2
		description 26
		owner 203
	)
)

(instance Amulet of KQInvItem
	(properties
		view 892
		loop 2
		cel 2
		signal 2
		description 27
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 84)
					(PrintDC 758 5) ; "The amulet glows softly with a power of its own."
				else
					(PrintDC 749 description)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Wand of KQInvItem
	(properties
		view 892
		signal 2
		description 28
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 60)
					(PrintDC 758 6) ; "Crispin's wand glows brightly with renewed power."
				else
					(PrintDC 749 description)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (moveTo)
		(if (and (IsFlag 60) (!= cursor cGlowWandCursor))
			(= loop 4)
			(= cel 2)
			(= cursor cGlowWandCursor)
		)
		(super moveTo: &rest)
	)
)

(instance Sled of KQInvItem
	(properties
		view 892
		cel 3
		signal 2
		description 29
		owner 204
	)
)

(instance Iron_Bar of KQInvItem
	(properties
		name {Iron Bar}
		view 893
		cel 5
		signal 2
		description 30
		owner 44
	)
)

(instance Fishhook of KQInvItem
	(properties
		view 893
		cel 11
		signal 2
		description 31
		owner 54
	)
)

(instance Moldy_Cheese of KQInvItem
	(properties
		name {Moldy Cheese}
		view 893
		cel 7
		signal 2
		description 32
		owner 67
	)
)

(instance Elf_Shoes_ of KQInvItem
	(properties
		name {Elf Shoes }
		view 892
		loop 2
		cel 8
		signal 2
		description 33
		owner 83
	)
)

(instance Tambourine of KQInvItem
	(properties
		view 892
		loop 2
		cel 3
		signal 2
		description 34
		owner 13
	)
)

(instance Mordack_s_Wand of KQInvItem
	(properties
		name {Mordack's Wand}
		view 893
		cel 8
		signal 2
		description 35
		owner 13
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 60)
					(PrintDC 758 7) ; "Mordack's wand doesn't seem to have much life left in it."
				else
					(PrintDC 749 description)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Hairpin of KQInvItem
	(properties
		view 893
		cel 9
		signal 2
		description 36
		owner 55
	)
)

(instance Cat_Fish of KQInvItem
	(properties
		name {Cat Fish}
		view 893
		cel 10
		signal 2
		description 37
		owner 51
	)
)

(instance Mongoose_Spell of KQInvItem
	(properties
		name {Mongoose Spell}
		view 712
		loop 2
		signal 2
		owner 65
	)
)

(instance Bunny_Spell of KQInvItem
	(properties
		name {Bunny Spell}
		view 712
		loop 2
		cel 1
		signal 2
		owner 65
	)
)

(instance Rain_Spell of KQInvItem
	(properties
		name {Rain Spell}
		view 712
		loop 2
		cel 2
		signal 2
		owner 65
	)
)

(instance Tiger_Spell of KQInvItem
	(properties
		name {Tiger Spell}
		view 712
		loop 2
		cel 3
		signal 2
		owner 65
	)
)

(instance ok of IconI
	(properties
		view 901
		loop 3
		cel 0
		nsLeft 40
		cursor 999
		signal 67
		helpStr {Select this Icon to close this window.}
	)

	(method (init)
		(self
			highlightColor: 0
			lowlightColor:
				(cond
					((== global105 256) 19)
					((== global105 32) 10)
					(else 7)
				)
		)
		(super init:)
	)
)

(instance invLook of IconI
	(properties
		view 901
		loop 2
		cel 0
		cursor 7
		message 2
		helpStr {Select this Icon then select an inventory item you'd like a description of.}
	)

	(method (init)
		(self
			highlightColor: 0
			lowlightColor:
				(cond
					((== global105 256) 19)
					((== global105 32) 10)
					(else 7)
				)
		)
		(super init:)
	)
)

(instance invHand of IconI
	(properties
		view 901
		loop 0
		cel 0
		cursor 8
		message 3
		helpStr {This allows you to do something to an item.}
	)

	(method (init)
		(self
			highlightColor: 0
			lowlightColor:
				(cond
					((== global105 256) 19)
					((== global105 32) 10)
					(else 7)
				)
		)
		(super init:)
	)
)

(instance invHelp of IconI
	(properties
		view 901
		loop 1
		cel 0
		cursor 70
		message 6
	)

	(method (init)
		(self
			highlightColor: 0
			lowlightColor:
				(cond
					((== global105 256) 19)
					((== global105 32) 10)
					(else 7)
				)
		)
		(super init:)
	)
)

(instance invSelect of IconI
	(properties
		view 901
		loop 4
		cel 0
		cursor 999
		helpStr {This allows you to select an item.}
	)

	(method (init)
		(self
			highlightColor: 0
			lowlightColor:
				(cond
					((== global105 256) 19)
					((== global105 32) 10)
					(else 7)
				)
		)
		(super init:)
	)
)

(instance keyCursor of KQCursor
	(properties
		number 15
	)

	(method (init)
		(if global400
			(self number: 15 yourself:)
		)
		(super init: &rest)
	)
)

(instance pieCursor of KQCursor
	(properties
		number 16
	)

	(method (init)
		(if global400
			(self number: 16 yourself:)
		)
		(super init: &rest)
	)
)

(instance needleCursor of KQCursor
	(properties
		number 17
	)

	(method (init)
		(if global400
			(self number: 17 yourself:)
		)
		(super init: &rest)
	)
)

(instance silverCursor of KQCursor
	(properties
		number 18
	)

	(method (init)
		(if global400
			(self number: 18 yourself:)
		)
		(super init: &rest)
	)
)

(instance fishCursor of KQCursor
	(properties
		number 19
	)

	(method (init)
		(if global400
			(self number: 19 yourself:)
		)
		(super init: &rest)
	)
)

(instance bottleCursor of KQCursor
	(properties
		number 500
	)

	(method (init)
		(if global400
			(self number: 500 yourself:)
		)
		(super init: &rest)
	)
)

(instance staffCursor of KQCursor
	(properties
		number 21
	)

	(method (init)
		(if global400
			(self number: 21 yourself:)
		)
		(super init: &rest)
	)
)

(instance heartCursor of KQCursor
	(properties
		number 22
	)

	(method (init)
		(if global400
			(self number: 22 yourself:)
		)
		(super init: &rest)
	)
)

(instance harpCursor of KQCursor
	(properties
		number 23
	)

	(method (init)
		(if global400
			(self number: 23 yourself:)
		)
		(super init: &rest)
	)
)

(instance goldCursor of KQCursor
	(properties
		number 18
	)

	(method (init)
		(if global400
			(self number: 18 yourself:)
		)
		(super init: &rest)
	)
)

(instance puppetCursor of KQCursor
	(properties
		number 25
	)

	(method (init)
		(if global400
			(self number: 25 yourself:)
		)
		(super init: &rest)
	)
)

(instance pouchCursor of KQCursor
	(properties
		number 26
	)

	(method (init)
		(if global400
			(self number: 26 yourself:)
		)
		(super init: &rest)
	)
)

(instance oneEmeraldCursor of KQCursor ; UNUSED
	(properties
		number 27
	)

	(method (init)
		(if global400
			(self number: 27 yourself:)
		)
		(super init: &rest)
	)
)

(instance twoEmeraldCursor of KQCursor ; UNUSED
	(properties
		number 27
	)

	(method (init)
		(if global400
			(self number: 27 yourself:)
		)
		(super init: &rest)
	)
)

(instance threeEmeraldCursor of KQCursor
	(properties
		number 27
	)

	(method (init)
		(if global400
			(self number: 27 yourself:)
		)
		(super init: &rest)
	)
)

(instance wheelCursor of KQCursor
	(properties
		number 28
	)

	(method (init)
		(if global400
			(self number: 28 yourself:)
		)
		(super init: &rest)
	)
)

(instance stickCursor of KQCursor
	(properties
		number 29
	)

	(method (init)
		(if global400
			(self number: 29 yourself:)
		)
		(super init: &rest)
	)
)

(instance honeyCursor of KQCursor
	(properties
		number 30
	)

	(method (init)
		(if global400
			(self number: 30 yourself:)
		)
		(super init: &rest)
	)
)

(instance waxCursor of KQCursor
	(properties
		number 31
	)

	(method (init)
		(if global400
			(self number: 31 yourself:)
		)
		(super init: &rest)
	)
)

(instance lambCursor of KQCursor
	(properties
		number 32
	)

	(method (init)
		(if global400
			(self number: 32 yourself:)
		)
		(super init: &rest)
	)
)

(instance ropeCursor of KQCursor
	(properties
		number 33
	)

	(method (init)
		(if global400
			(self number: 33 yourself:)
		)
		(super init: &rest)
	)
)

(instance crystalCursor of KQCursor
	(properties
		number 34
	)

	(method (init)
		(if global400
			(self number: 34 yourself:)
		)
		(super init: &rest)
	)
)

(instance hammerCursor of KQCursor
	(properties
		number 35
	)

	(method (init)
		(if global400
			(self number: 35 yourself:)
		)
		(super init: &rest)
	)
)

(instance shellCursor of KQCursor
	(properties
		number 36
	)

	(method (init)
		(if global400
			(self number: 36 yourself:)
		)
		(super init: &rest)
	)
)

(instance peasCursor of KQCursor
	(properties
		number 37
	)

	(method (init)
		(if global400
			(self number: 37 yourself:)
		)
		(super init: &rest)
	)
)

(instance locketCursor of KQCursor
	(properties
		number 38
	)

	(method (init)
		(if global400
			(self number: 38 yourself:)
		)
		(super init: &rest)
	)
)

(instance cloakCursor of KQCursor
	(properties
		number 39
	)

	(method (init)
		(if global400
			(self number: 39 yourself:)
		)
		(super init: &rest)
	)
)

(instance amuletCursor of KQCursor
	(properties
		number 40
	)

	(method (init)
		(if global400
			(self number: 40 yourself:)
		)
		(super init: &rest)
	)
)

(instance cwandCursor of KQCursor
	(properties
		number 41
	)

	(method (init)
		(if global400
			(self number: 41 yourself:)
		)
		(super init: &rest)
	)
)

(instance sledCursor of KQCursor
	(properties
		number 42
	)

	(method (init)
		(if global400
			(self number: 42 yourself:)
		)
		(super init: &rest)
	)
)

(instance ironbarCursor of KQCursor
	(properties
		number 43
	)

	(method (init)
		(if global400
			(self number: 43 yourself:)
		)
		(super init: &rest)
	)
)

(instance hookCursor of KQCursor
	(properties
		number 44
	)

	(method (init)
		(if global400
			(self number: 44 yourself:)
		)
		(super init: &rest)
	)
)

(instance cheeseCursor of KQCursor
	(properties
		number 45
	)

	(method (init)
		(if global400
			(self number: 45 yourself:)
		)
		(super init: &rest)
	)
)

(instance elfShoeCursor of KQCursor
	(properties
		number 46
	)

	(method (init)
		(if global400
			(self number: 46 yourself:)
		)
		(super init: &rest)
	)
)

(instance tambourineCursor of KQCursor
	(properties
		number 47
	)

	(method (init)
		(if global400
			(self number: 47 yourself:)
		)
		(super init: &rest)
	)
)

(instance mWandCursor of KQCursor
	(properties
		number 48
	)

	(method (init)
		(if global400
			(self number: 48 yourself:)
		)
		(super init: &rest)
	)
)

(instance hairpinCursor of KQCursor
	(properties
		number 49
	)

	(method (init)
		(if global400
			(self number: 49 yourself:)
		)
		(super init: &rest)
	)
)

(instance mFishCursor of KQCursor
	(properties
		number 19
	)

	(method (init)
		(if global400
			(self number: 19 yourself:)
		)
		(super init: &rest)
	)
)

(instance shoeCursor of KQCursor
	(properties
		number 51
	)

	(method (init)
		(if global400
			(self number: 51 yourself:)
		)
		(super init: &rest)
	)
)

(instance halfLambCursor of KQCursor ; UNUSED
	(properties
		number 32
	)

	(method (init)
		(if global400
			(self number: 32 yourself:)
		)
		(super init: &rest)
	)
)

(instance cGlowWandCursor of KQCursor
	(properties
		number 41
	)

	(method (init)
		(if global400
			(self number: 41 yourself:)
		)
		(super init: &rest)
	)
)

(instance emptyBagCursor of KQCursor ; UNUSED
	(properties
		number 54
	)

	(method (init)
		(if global400
			(self number: 54 yourself:)
		)
		(super init: &rest)
	)
)

(instance arrowCursor of KQCursor
	(properties
		number 999
	)

	(method (init)
		(if global400
			(self number: 999 yourself:)
		)
		(super init: &rest)
	)
)

(instance handCursor of KQCursor
	(properties
		number 8
	)

	(method (init)
		(if global400
			(self number: 8 yourself:)
		)
		(super init: &rest)
	)
)

(instance helpCursor of KQCursor
	(properties
		number 70
	)

	(method (init)
		(if global400
			(self number: 70 yourself:)
		)
		(super init: &rest)
	)
)

(instance eyeCursor of KQCursor
	(properties
		number 7
	)

	(method (init)
		(if global400
			(self number: 7 yourself:)
		)
		(super init: &rest)
	)
)

(instance theXCursor of KQCursor ; UNUSED
	(properties
		number 5
	)

	(method (init)
		(if global400
			(self number: 5 yourself:)
		)
		(super init: &rest)
	)
)

