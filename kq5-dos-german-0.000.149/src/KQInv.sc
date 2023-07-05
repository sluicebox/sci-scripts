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
				Ok_GIn_Ordnung
				Key_GSchl_ssel
				Pie_GTorte
				Golden_Needle_GGoldene_Nadel
				Coin_GM_nze
				Fish_GFisch
				Brass_Bottle_GMessingflasche
				Staff_GStab
				Shoe_GSchuh
				Heart_GHerz
				Harp_GHarfe
				Gold_Coin_GGoldm_nze
				Marionette_GMarionette
				Pouch_GBeutel
				Emeralds_GEdelsteine
				Spinning_Wheel_GSpinnrad
				Stick_GStock
				Honeycomb_GHonigwabe
				Beeswax_GBienenwachs
				Leg_of_Lamb_GLammkeule
				Rope_GSeil
				Crystal_GKristall
				Hammer_GHammer
				Shell_GMuschel
				Bag_of_Peas_GErbsensack
				Locket_GMedaillon
				Cloak_GUmhang
				Amulet_GAmulett
				Wand_GZauberstab
				Sled_GSchlitten
				Iron_Bar_GEisenstange
				Fishhook_GAngelhaken
				Moldy_Cheese_GSchimmliger_K_se
				Elf_Shoes__GElfenschuhe
				Tambourine_GTamburin
				Mordack_s_Wand_GMordack_s_Zauberstab
				Hairpin_GHaarnadel
				Cat_Fish_GKatzenfisch
				Mongoose_Spell_GMungospruch
				Bunny_Spell_GH_schenspruch
				Rain_Spell_GRegenspruch
				Tiger_Spell_GTigerspruch
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

(instance Ok_GIn_Ordnung of KQInvItem
	(properties
		name {Ok}
		view 895
	)
)

(instance Key_GSchl_ssel of KQInvItem
	(properties
		name {Key}
		view 892
		loop 2
		cel 4
		cursor 15
		signal 2
		description 1
		owner 23
	)
)

(instance Pie_GTorte of KQInvItem
	(properties
		name {Pie}
		view 892
		cel 9
		cursor 16
		signal 2
		description 2
		owner 206
	)
)

(instance Golden_Needle_GGoldene_Nadel of KQInvItem
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

(instance Coin_GM_nze of KQInvItem
	(properties
		name {Coin}
		view 892
		cel 1
		cursor 18
		signal 2
		description 4
		owner 4
	)
)

(instance Fish_GFisch of KQInvItem
	(properties
		name {Fish}
		view 891
		cursor 19
		signal 2
		description 5
		owner 4
	)
)

(instance Brass_Bottle_GMessingflasche of KQInvItem
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

(instance Staff_GStab of KQInvItem
	(properties
		name {Staff}
		view 891
		cel 2
		cursor 21
		signal 2
		description 7
		owner 17
	)
)

(instance Shoe_GSchuh of KQInvItem
	(properties
		name {Shoe}
		view 892
		cel 6
		cursor 51
		signal 2
		description 8
		owner 15
	)
)

(instance Heart_GHerz of KQInvItem
	(properties
		name {Heart}
		view 892
		loop 2
		cel 7
		cursor 22
		signal 2
		description 9
		owner 21
	)
)

(instance Harp_GHarfe of KQInvItem
	(properties
		name {Harp}
		view 893
		cursor 23
		signal 2
		description 10
		owner 9
	)
)

(instance Gold_Coin_GGoldm_nze of KQInvItem
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

(instance Marionette_GMarionette of KQInvItem
	(properties
		name {Marionette}
		view 892
		cel 7
		cursor 25
		signal 2
		description 12
	)
)

(instance Pouch_GBeutel of KQInvItem
	(properties
		name {Pouch}
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

(instance Emeralds_GEdelsteine of KQInvItem
	(properties
		name {Emeralds}
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

(instance Spinning_Wheel_GSpinnrad of KQInvItem
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

(instance Stick_GStock of KQInvItem
	(properties
		name {Stick}
		view 892
		loop 2
		cel 1
		cursor 29
		signal 2
		description 16
		owner 11
	)
)

(instance Honeycomb_GHonigwabe of KQInvItem
	(properties
		name {Honeycomb}
		view 891
		cel 7
		cursor 30
		signal 2
		description 17
		owner 11
	)
)

(instance Beeswax_GBienenwachs of KQInvItem
	(properties
		name {Beeswax}
		view 892
		loop 2
		cursor 31
		signal 2
		description 18
	)
)

(instance Leg_of_Lamb_GLammkeule of KQInvItem
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

(instance Rope_GSeil of KQInvItem
	(properties
		name {Rope}
		view 892
		cel 8
		cursor 33
		signal 2
		description 20
		owner 86
	)
)

(instance Crystal_GKristall of KQInvItem
	(properties
		name {Crystal}
		view 893
		cel 1
		cursor 34
		signal 2
		description 21
		owner 38
	)
)

(instance Hammer_GHammer of KQInvItem
	(properties
		name {Hammer}
		view 892
		loop 4
		cursor 35
		signal 2
		description 22
	)
)

(instance Shell_GMuschel of KQInvItem
	(properties
		name {Shell}
		view 893
		cel 2
		cursor 36
		signal 2
		description 23
	)
)

(instance Bag_of_Peas_GErbsensack of KQInvItem
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

(instance Locket_GMedaillon of KQInvItem
	(properties
		name {Locket}
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

(instance Cloak_GUmhang of KQInvItem
	(properties
		name {Cloak}
		view 892
		cel 2
		cursor 39
		signal 2
		description 26
		owner 203
	)
)

(instance Amulet_GAmulett of KQInvItem
	(properties
		name {Amulet}
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

(instance Wand_GZauberstab of KQInvItem
	(properties
		name {Wand}
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

(instance Sled_GSchlitten of KQInvItem
	(properties
		name {Sled}
		view 892
		cel 3
		cursor 42
		signal 2
		description 29
		owner 204
	)
)

(instance Iron_Bar_GEisenstange of KQInvItem
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

(instance Fishhook_GAngelhaken of KQInvItem
	(properties
		name {Fishhook}
		view 893
		cel 11
		cursor 44
		signal 2
		description 31
		owner 54
	)
)

(instance Moldy_Cheese_GSchimmliger_K_se of KQInvItem
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

(instance Elf_Shoes__GElfenschuhe of KQInvItem
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

(instance Tambourine_GTamburin of KQInvItem
	(properties
		name {Tambourine}
		view 892
		loop 2
		cel 3
		cursor 47
		signal 2
		description 34
		owner 13
	)
)

(instance Mordack_s_Wand_GMordack_s_Zauberstab of KQInvItem
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

(instance Hairpin_GHaarnadel of KQInvItem
	(properties
		name {Hairpin}
		view 893
		cel 9
		cursor 49
		signal 2
		description 36
		owner 55
	)
)

(instance Cat_Fish_GKatzenfisch of KQInvItem
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

(instance Mongoose_Spell_GMungospruch of KQInvItem
	(properties
		name {Mongoose Spell}
		view 712
		loop 2
		cursor 53
		signal 2
		owner 65
	)
)

(instance Bunny_Spell_GH_schenspruch of KQInvItem
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

(instance Rain_Spell_GRegenspruch of KQInvItem
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

(instance Tiger_Spell_GTigerspruch of KQInvItem
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

