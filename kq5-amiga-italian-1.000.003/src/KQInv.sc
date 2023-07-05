;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 758)
(include sci.sh)
(use Main)
(use Interface)
(use KQ5InvWindow)
(use DLetter)
(use KQCursor)
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

	(method (doVerb theVerb &tmp [temp0 3])
		(if (and (== theVerb 2) description)
			(Print 749 description)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(class KQInvSpellItem of KQInvItem
	(properties)

	(method (doVerb theVerb)
		(if (or (== theVerb 4) (== theVerb 2))
			(Print 758 0) ; "Choose the inventory icon to select a spell."
			(return 0)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance KQInv of Inv
	(properties
		normalHeading {Graham is carrying:}
		empty {Nothing!}
		curScore 10049
	)

	(method (init)
		((= gInventory self)
			add:
				Ok_IOK
				(Key_IChiave cursor: keyCursor yourself:)
				(Pie_ITorta cursor: pieCursor yourself:)
				(Golden_Needle_IAgo_d_Oro cursor: needleCursor yourself:)
				(Coin_IMoneta cursor: silverCursor yourself:)
				(Fish_IPesce cursor: fishCursor yourself:)
				(Brass_Bottle_IBottiglia_d_Ottone
					cursor: bottleCursor
					yourself:
				)
				(Staff_IBastone cursor: staffCursor yourself:)
				(Shoe_IScarpa cursor: shoeCursor yourself:)
				(Heart_ICuore cursor: heartCursor yourself:)
				(Harp_IArpa cursor: harpCursor yourself:)
				(Gold_Coin_IMoneta_d_Oro cursor: goldCursor yourself:)
				(Marionette_IMarionetta cursor: puppetCursor yourself:)
				(Pouch_IBorsellino cursor: pouchCursor yourself:)
				(Emeralds_ISmeraldi cursor: threeEmeraldCursor yourself:)
				(Spinning_Wheel_IArcolaio cursor: wheelCursor yourself:)
				(Stick_IBastone cursor: stickCursor yourself:)
				(Honeycomb_IFavo cursor: honeyCursor yourself:)
				(Beeswax_ICera cursor: waxCursor yourself:)
				(Leg_of_Lamb_ICoscia_d_agnello cursor: lambCursor yourself:)
				(Rope_IFune cursor: ropeCursor yourself:)
				(Crystal_ICristallo cursor: crystalCursor yourself:)
				(Hammer_IMartello cursor: hammerCursor yourself:)
				(Shell_IConchiglia cursor: shellCursor yourself:)
				(Bag_of_Peas_ISacchetto_di_Piselli cursor: peasCursor yourself:)
				(Locket_IMedaglione cursor: locketCursor yourself:)
				(Cloak_IMantello cursor: cloakCursor yourself:)
				(Amulet_IAmuleto cursor: amuletCursor yourself:)
				(Wand_IBacchetta
					cursor:
						(if (not (IsFlag 60))
							cwandCursor
						else
							cGlowWandCursor
						)
					yourself:
				)
				(Sled_ISlitta cursor: sledCursor yourself:)
				(Iron_Bar_ISbarra_di_Ferro cursor: ironbarCursor yourself:)
				(Fishhook_IAmo_da_Pesca cursor: hookCursor yourself:)
				(Moldy_Cheese_IFormaggio_Ammuffito
					cursor: cheeseCursor
					yourself:
				)
				(Elf_Shoes__IScarpe_del_Folletto
					cursor: elfShoeCursor
					yourself:
				)
				(Tambourine_ITamburello cursor: tambourineCursor yourself:)
				(Mordack_s_Wand_IBacchetta_di_Mordack
					cursor: mWandCursor
					yourself:
				)
				(Hairpin_IForcina cursor: hairpinCursor yourself:)
				(Cat_Fish_IPesce_Gatto cursor: mFishCursor yourself:)
				(Mongoose_Spell_IIncantesimo_Mangusta
					cursor: cGlowWandCursor
					yourself:
				)
				(Bunny_Spell_IIncantesimo_Coniglio
					cursor: cGlowWandCursor
					yourself:
				)
				(Rain_Spell_IIncantesimo_Pioggia
					cursor: cGlowWandCursor
					yourself:
				)
				(Tiger_Spell_IIncantesimo_Tigre
					cursor: cGlowWandCursor
					yourself:
				)
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

(instance Ok_IOK of KQInvItem
	(properties
		name {Ok}
		view 895
	)
)

(instance Key_IChiave of KQInvItem
	(properties
		name {Key}
		view 892
		loop 2
		cel 4
		signal 2
		description 1
		owner 23
	)
)

(instance Pie_ITorta of KQInvItem
	(properties
		name {Pie}
		view 892
		cel 9
		signal 2
		description 2
		owner 206
	)
)

(instance Golden_Needle_IAgo_d_Oro of KQInvItem
	(properties
		name {Golden Needle}
		view 892
		cel 10
		signal 2
		description 3
		owner 27
	)
)

(instance Coin_IMoneta of KQInvItem
	(properties
		name {Coin}
		view 892
		cel 1
		signal 2
		description 4
		owner 4
	)
)

(instance Fish_IPesce of KQInvItem
	(properties
		name {Fish}
		view 891
		signal 2
		description 5
		owner 4
	)
)

(instance Brass_Bottle_IBottiglia_d_Ottone of KQInvItem
	(properties
		name {Brass Bottle}
		view 891
		cel 1
		signal 2
		description 6
		owner 18
	)

	(method (doVerb theVerb)
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

(instance Staff_IBastone of KQInvItem
	(properties
		name {Staff}
		view 891
		cel 2
		signal 2
		description 7
		owner 17
	)
)

(instance Shoe_IScarpa of KQInvItem
	(properties
		name {Shoe}
		view 892
		cel 6
		signal 2
		description 8
		owner 15
	)
)

(instance Heart_ICuore of KQInvItem
	(properties
		name {Heart}
		view 892
		loop 2
		cel 7
		signal 2
		description 9
		owner 21
	)
)

(instance Harp_IArpa of KQInvItem
	(properties
		name {Harp}
		view 893
		signal 2
		description 10
		owner 9
	)
)

(instance Gold_Coin_IMoneta_d_Oro of KQInvItem
	(properties
		name {Gold Coin}
		view 891
		cel 3
		signal 2
		description 11
		owner 18
	)
)

(instance Marionette_IMarionetta of KQInvItem
	(properties
		name {Marionette}
		view 892
		cel 7
		signal 2
		description 12
	)
)

(instance Pouch_IBorsellino of KQInvItem
	(properties
		name {Pouch}
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
						(PrintDC 758 1) ; "The small leather pouch is drawn tightly closed."
					)
					(global312
						(StrCpy
							@temp0
							(LangSwitch
								{This leather pouch contains }
								{Questo borsellino di pelle contiene }
							)
						)
						(StrCat
							@temp0
							(switch global312
								(3
									(LangSwitch {three} {tre})
								)
								(2
									(LangSwitch {two} {due})
								)
								(1
									(LangSwitch {one} {un})
								)
							)
						)
						(StrCat
							@temp0
							(LangSwitch
								{ beautiful emerald}
								{ meraviglioso smeraldo}
							)
						)
						(StrCat @temp0 (if (> global312 1) {s.} else {.}))
						(PrintDC @temp0)
					)
					(else
						(PrintDC 758 2) ; "The pouch is empty."
					)
				)
			)
			(3
				(if (== global312 -1)
					(= global312 3)
					(ShowView (Format @temp0 758 3) 891 0 6) ; "Upon opening the leather pouch, Graham discovers three sparkling emeralds."
					(gInventory hide:)
					(self loop: 4 cel: 1)
					(gEgo get: 14) ; Emeralds
					(gInventory show: gEgo)
				else
					(PrintDC 758 4) ; "The pouch is already open."
				)
				(return 0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Emeralds_ISmeraldi of KQInvItem
	(properties
		name {Emeralds}
		view 891
		cel 6
		signal 2
	)

	(method (doVerb theVerb &tmp [temp0 50])
		(switch theVerb
			(2
				(StrCpy @temp0 (LangSwitch {The } {Un }))
				(StrCat
					@temp0
					(switch global312
						(3
							(LangSwitch {trio of } {trio di })
						)
						(2
							(LangSwitch {pair of } {paio di })
						)
						(1 {})
					)
				)
				(StrCat
					@temp0
					(LangSwitch {sparkling emerald} {smeraldi luccicanti})
				)
				(StrCat @temp0 (if (> global312 1) {s} else {}))
				(StrCat @temp0 (LangSwitch { dazzle} { abbaglia}))
				(StrCat @temp0 (if (> global312 1) {} else {s}))
				(StrCat @temp0 (LangSwitch { the eyes.} { gli occhi.}))
				(PrintDC @temp0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Spinning_Wheel_IArcolaio of KQInvItem
	(properties
		name {Spinning Wheel}
		view 892
		loop 2
		cel 6
		description 15
		owner 23
	)
)

(instance Stick_IBastone of KQInvItem
	(properties
		name {Stick}
		view 892
		loop 2
		cel 1
		signal 2
		description 16
		owner 11
	)
)

(instance Honeycomb_IFavo of KQInvItem
	(properties
		name {Honeycomb}
		view 891
		cel 7
		signal 2
		description 17
		owner 11
	)
)

(instance Beeswax_ICera of KQInvItem
	(properties
		name {Beeswax}
		view 892
		loop 2
		signal 2
		description 18
	)
)

(instance Leg_of_Lamb_ICoscia_d_agnello of KQInvItem
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
				(StrCpy @temp0 (LangSwitch {This is a } {Questo \8a }))
				(StrCat
					@temp0
					(if global316
						(LangSwitch {left-over, half} {l'avanzo, di met\85})
					else
						(LangSwitch
							{large, mouthwatering}
							{di una grande, succulenta}
						)
					)
				)
				(StrCat @temp0 (LangSwitch { leg of lamb.} { coscia d'agnello}))
				(PrintDC @temp0)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Rope_IFune of KQInvItem
	(properties
		name {Rope}
		view 892
		cel 8
		signal 2
		description 20
		owner 86
	)
)

(instance Crystal_ICristallo of KQInvItem
	(properties
		name {Crystal}
		view 893
		cel 1
		signal 2
		description 21
		owner 38
	)
)

(instance Hammer_IMartello of KQInvItem
	(properties
		name {Hammer}
		view 892
		loop 4
		signal 2
		description 22
	)
)

(instance Shell_IConchiglia of KQInvItem
	(properties
		name {Shell}
		view 893
		cel 2
		signal 2
		description 23
	)
)

(instance Bag_of_Peas_ISacchetto_di_Piselli of KQInvItem
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
					(PrintDC 758 5) ; "A brown empty sack."
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

(instance Locket_IMedaglione of KQInvItem
	(properties
		name {Locket}
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

(instance Cloak_IMantello of KQInvItem
	(properties
		name {Cloak}
		view 892
		cel 2
		signal 2
		description 26
		owner 203
	)
)

(instance Amulet_IAmuleto of KQInvItem
	(properties
		name {Amulet}
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
					(PrintDC 758 6) ; "The amulet glows softly with a power of its own."
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

(instance Wand_IBacchetta of KQInvItem
	(properties
		name {Wand}
		view 892
		signal 2
		description 28
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 60)
					(PrintDC 758 7) ; "Crispin's wand glows brightly with renewed power."
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

(instance Sled_ISlitta of KQInvItem
	(properties
		name {Sled}
		view 892
		cel 3
		signal 2
		description 29
		owner 204
	)
)

(instance Iron_Bar_ISbarra_di_Ferro of KQInvItem
	(properties
		name {Iron Bar}
		view 893
		cel 5
		signal 2
		description 30
		owner 44
	)
)

(instance Fishhook_IAmo_da_Pesca of KQInvItem
	(properties
		name {Fishhook}
		view 893
		cel 11
		signal 2
		description 31
		owner 54
	)
)

(instance Moldy_Cheese_IFormaggio_Ammuffito of KQInvItem
	(properties
		name {Moldy Cheese}
		view 893
		cel 7
		signal 2
		description 32
		owner 67
	)
)

(instance Elf_Shoes__IScarpe_del_Folletto of KQInvItem
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

(instance Tambourine_ITamburello of KQInvItem
	(properties
		name {Tambourine}
		view 892
		loop 2
		cel 3
		signal 2
		description 34
		owner 13
	)
)

(instance Mordack_s_Wand_IBacchetta_di_Mordack of KQInvItem
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
					(PrintDC 758 8) ; "Mordack's wand doesn't seem to have much life left in it."
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

(instance Hairpin_IForcina of KQInvItem
	(properties
		name {Hairpin}
		view 893
		cel 9
		signal 2
		description 36
		owner 55
	)
)

(instance Cat_Fish_IPesce_Gatto of KQInvItem
	(properties
		name {Cat Fish}
		view 893
		cel 10
		signal 2
		description 37
		owner 51
	)
)

(instance Mongoose_Spell_IIncantesimo_Mangusta of KQInvSpellItem
	(properties
		name {Mongoose Spell}
		view 712
		loop 2
		signal 2
		owner 65
	)
)

(instance Bunny_Spell_IIncantesimo_Coniglio of KQInvSpellItem
	(properties
		name {Bunny Spell}
		view 712
		loop 2
		cel 1
		signal 2
		owner 65
	)
)

(instance Rain_Spell_IIncantesimo_Pioggia of KQInvSpellItem
	(properties
		name {Rain Spell}
		view 712
		loop 2
		cel 2
		signal 2
		owner 65
	)
)

(instance Tiger_Spell_IIncantesimo_Tigre of KQInvSpellItem
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

