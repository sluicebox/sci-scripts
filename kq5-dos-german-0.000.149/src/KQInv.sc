;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 758)
(include sci.sh)
(use Main)
(use Interface)
(use KQ5Window)
(use KQ5InvWindow)
(use DLetter)
(use Language)
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

	(method (doVerb theVerb)
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
		curScore 5566
	)

	(method (init)
		((= gInventory self)
			add:
				Ok
				Key
				Pie
				Golden_Needle
				Coin
				Fish
				Brass_Bottle
				Staff
				Shoe
				Heart
				Harp
				Gold_Coin
				Marionette
				Pouch
				Emeralds
				Spinning_Wheel
				Stick
				Honeycomb
				Beeswax
				Leg_of_Lamb
				Rope
				Crystal
				Hammer
				Shell
				Bag_of_Peas
				Locket
				Cloak
				Amulet
				Wand
				Sled
				Iron_Bar
				Fishhook
				Moldy_Cheese
				Elf_Shoes_
				Tambourine
				Mordack_s_Wand
				Hairpin
				Cat_Fish
				Mongoose_Spell
				Bunny_Spell
				Rain_Spell
				Tiger_Spell
				invLook
				invHand
				invSelect
				invHelp
				ok
			eachElementDo: #highlightColor 0
			eachElementDo: #lowlightColor (KQ5Window back:)
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
		cursor 15
		signal 2
		description 1
		owner 23
	)
)

(instance Pie of KQInvItem
	(properties
		view 892
		cel 9
		cursor 16
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
		cursor 17
		signal 2
		description 3
		owner 27
	)
)

(instance Coin of KQInvItem
	(properties
		view 892
		cel 1
		cursor 18
		signal 2
		description 4
		owner 4
	)
)

(instance Fish of KQInvItem
	(properties
		view 891
		cursor 19
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
		cursor 500
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
			(4
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
		cursor 21
		signal 2
		description 7
		owner 17
	)
)

(instance Shoe of KQInvItem
	(properties
		view 892
		cel 6
		cursor 51
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
		cursor 22
		signal 2
		description 9
		owner 21
	)
)

(instance Harp of KQInvItem
	(properties
		view 893
		cursor 23
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
		cursor 18
		signal 2
		description 11
		owner 18
	)
)

(instance Marionette of KQInvItem
	(properties
		view 892
		cel 7
		cursor 25
		signal 2
		description 12
	)
)

(instance Pouch of KQInvItem
	(properties
		view 892
		loop 2
		cel 5
		cursor 26
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
						(StrCpy
							@temp0
							(LangSwitch
								{This leather pouch contains }
								{Der Lederbeutel enth\84lt }
							)
						)
						(StrCat
							@temp0
							(switch global312
								(3
									(LangSwitch {three} {drei})
								)
								(2
									(LangSwitch {two} {zwei})
								)
								(1
									(LangSwitch {one} {einen})
								)
							)
						)
						(StrCat
							@temp0
							(LangSwitch { beautiful emerald} { wundersch\94ne})
						)
						(StrCat
							@temp0
							(if (> global312 1)
								(LangSwitch {s.} { Edelsteine.})
							else
								(LangSwitch {.} {n Edelstein.})
							)
						)
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
		cursor 27
		signal 2
	)

	(method (doVerb theVerb &tmp [temp0 50])
		(switch theVerb
			(2
				(StrCpy @temp0 (LangSwitch {The } {D}))
				(StrCat
					@temp0
					(switch global312
						(3
							(LangSwitch {trio of } {ie drei })
						)
						(2
							(LangSwitch {pair of } {ie zwei })
						)
						(1
							(LangSwitch {} {er })
						)
					)
				)
				(StrCat @temp0 (LangSwitch {sparkling emerald} {glitzernde}))
				(StrCat
					@temp0
					(if (> global312 1)
						(LangSwitch {s} {n Edelsteine})
					else
						(LangSwitch {} { Edelstein})
					)
				)
				(StrCat @temp0 (LangSwitch { dazzle} {}))
				(StrCat
					@temp0
					(if (> global312 1)
						(LangSwitch {} { blenden})
					else
						(LangSwitch {s} { blendet})
					)
				)
				(StrCat @temp0 (LangSwitch { the eyes.} { Deine Augen.}))
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
		cursor 28
		description 15
		owner 23
	)
)

(instance Stick of KQInvItem
	(properties
		view 892
		loop 2
		cel 1
		cursor 29
		signal 2
		description 16
		owner 11
	)
)

(instance Honeycomb of KQInvItem
	(properties
		view 891
		cel 7
		cursor 30
		signal 2
		description 17
		owner 11
	)
)

(instance Beeswax of KQInvItem
	(properties
		view 892
		loop 2
		cursor 31
		signal 2
		description 18
	)
)

(instance Leg_of_Lamb of KQInvItem
	(properties
		name {Leg of Lamb}
		view 892
		cel 4
		cursor 32
		signal 2
		owner 28
	)

	(method (doVerb theVerb &tmp [temp0 50])
		(switch theVerb
			(2
				(StrCpy @temp0 (LangSwitch {This is a } {Dies ist }))
				(StrCat
					@temp0
					(if global316
						(LangSwitch
							{left-over, half}
							{das \81briggebliebene St\81ck einer}
						)
					else
						(LangSwitch
							{large, mouthwatering}
							{eine gro\e1e, herrliche}
						)
					)
				)
				(StrCat @temp0 (LangSwitch { leg of lamb.} { Lammkeule.}))
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
		cursor 33
		signal 2
		description 20
		owner 86
	)
)

(instance Crystal of KQInvItem
	(properties
		view 893
		cel 1
		cursor 34
		signal 2
		description 21
		owner 38
	)
)

(instance Hammer of KQInvItem
	(properties
		view 892
		loop 4
		cursor 35
		signal 2
		description 22
	)
)

(instance Shell of KQInvItem
	(properties
		view 893
		cel 2
		cursor 36
		signal 2
		description 23
	)
)

(instance Bag_of_Peas of KQInvItem
	(properties
		name {Bag of Peas}
		view 893
		cel 3
		cursor 37
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
		cursor 38
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
		cursor 39
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
		cursor 40
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
		cursor 41
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
		(if (and (IsFlag 60) (!= cursor 53))
			(= loop 4)
			(= cel 2)
			(= cursor 53)
		)
		(super moveTo: &rest)
	)
)

(instance Sled of KQInvItem
	(properties
		view 892
		cel 3
		cursor 42
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
		cursor 43
		signal 2
		description 30
		owner 44
	)
)

(instance Fishhook of KQInvItem
	(properties
		view 893
		cel 11
		cursor 44
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
		cursor 45
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
		cursor 46
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
		cursor 47
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
		cursor 48
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
		cursor 49
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
		cursor 19
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
		cursor 53
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
		cursor 53
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
		cursor 53
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
		cursor 53
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
					((== global105 32) 7)
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
					((== global105 32) 7)
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
					((== global105 32) 7)
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
					((== global105 32) 7)
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
					((== global105 32) 7)
					(else 7)
				)
		)
		(super init:)
	)
)

