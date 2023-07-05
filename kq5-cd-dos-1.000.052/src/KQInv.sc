;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 758)
(include sci.sh)
(use Main)
(use KQ5InvWindow)
(use KQCursor)
(use IconBar)
(use Inventory)
(use User)
(use System)

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

	(method (doVerb theVerb &tmp temp0 temp1 temp2)
		(if (== theVerb 2)
			(Say description)
		else
			(if (User canInput:)
				(= temp0 (gGame setCursor: theXCursor))
				(= global126 0)
				(= temp2 (GetTime))
				(while (< (Abs (- temp2 (GetTime))) 40)
					(breakif (OneOf ((= temp1 (Event new:)) type:) evKEYBOARD evMOUSEBUTTON))
					(temp1 dispose:)
				)
				(if (IsObject temp1)
					(temp1 dispose:)
				)
				(gGame setCursor: temp0 1)
			)
			(super doVerb: theVerb &rest)
		)
	)
)

(instance KQInv of Inv
	(properties
		normalHeading {Graham is carrying:}
		empty {Nothing!}
		curScore 9411
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
		description 84
		owner 23
	)
)

(instance Pie of KQInvItem
	(properties
		view 892
		cel 9
		signal 2
		description 85
		owner 206
	)
)

(instance Golden_Needle of KQInvItem
	(properties
		name {Golden Needle}
		view 892
		cel 10
		signal 2
		description 86
		owner 27
	)
)

(instance Coin of KQInvItem
	(properties
		view 892
		cel 1
		signal 2
		description 87
		owner 4
	)
)

(instance Fish of KQInvItem
	(properties
		view 891
		signal 2
		description 88
		owner 4
	)
)

(instance Brass_Bottle of KQInvItem
	(properties
		name {Brass Bottle}
		view 891
		cel 1
		signal 2
		description 89
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
		description 90
		owner 17
	)
)

(instance Shoe of KQInvItem
	(properties
		view 892
		cel 6
		signal 2
		description 91
		owner 15
	)
)

(instance Heart of KQInvItem
	(properties
		view 892
		loop 2
		cel 7
		signal 2
		description 92
		owner 21
	)
)

(instance Harp of KQInvItem
	(properties
		view 893
		signal 2
		description 93
		owner 9
	)
)

(instance Gold_Coin of KQInvItem
	(properties
		name {Gold Coin}
		view 891
		cel 3
		signal 2
		description 94
		owner 18
	)
)

(instance Marionette of KQInvItem
	(properties
		view 892
		cel 7
		signal 2
		description 95
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
						(Say 96)
					)
					(global312
						(Say
							(switch global312
								(3 97)
								(2 98)
								(1 99)
							)
						)
					)
					(else
						(Say 100)
					)
				)
			)
			(3
				(if (== global312 -1)
					(= global312 3)
					(proc0_30 131 891 0 6)
					(gInventory hide:)
					(self loop: 4 cel: 1)
					(gEgo get: 14) ; Emeralds
					(gInventory show: gEgo)
				else
					(Say 132)
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
				(Say
					(switch global312
						(3 101)
						(2 102)
						(1 103)
					)
				)
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
		description 104
		owner 23
	)
)

(instance Stick of KQInvItem
	(properties
		view 892
		loop 2
		cel 1
		signal 2
		description 105
		owner 11
	)
)

(instance Honeycomb of KQInvItem
	(properties
		view 891
		cel 7
		signal 2
		description 106
		owner 11
	)
)

(instance Beeswax of KQInvItem
	(properties
		view 892
		loop 2
		signal 2
		description 107
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
				(if global316
					(Say 109)
				else
					(Say 108)
				)
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
		description 110
		owner 86
	)
)

(instance Crystal of KQInvItem
	(properties
		view 893
		cel 1
		signal 2
		description 111
		owner 38
	)
)

(instance Hammer of KQInvItem
	(properties
		view 892
		loop 4
		signal 2
		description 112
	)
)

(instance Shell of KQInvItem
	(properties
		view 893
		cel 2
		signal 2
		description 113
	)
)

(instance Bag_of_Peas of KQInvItem
	(properties
		name {Bag of Peas}
		view 893
		cel 3
		signal 2
		description 114
		owner 56
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 63)
					(Say 115)
				else
					(Say description)
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
		description 116
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3
				(Say 133)
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
		description 117
		owner 203
	)
)

(instance Amulet of KQInvItem
	(properties
		view 892
		loop 2
		cel 2
		signal 2
		description 118
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 84)
					(Say 119)
				else
					(Say description)
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
		description 120
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 60)
					(Say 121)
				else
					(Say description)
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
		description 122
		owner 204
	)
)

(instance Iron_Bar of KQInvItem
	(properties
		name {Iron Bar}
		view 893
		cel 5
		signal 2
		description 123
		owner 44
	)
)

(instance Fishhook of KQInvItem
	(properties
		view 893
		cel 11
		signal 2
		description 124
		owner 54
	)
)

(instance Moldy_Cheese of KQInvItem
	(properties
		name {Moldy Cheese}
		view 893
		cel 7
		signal 2
		description 692
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
		description 125
		owner 83
	)
)

(instance Tambourine of KQInvItem
	(properties
		view 892
		loop 2
		cel 3
		signal 2
		description 126
		owner 13
	)
)

(instance Mordack_s_Wand of KQInvItem
	(properties
		name {Mordack's Wand}
		view 893
		cel 8
		signal 2
		description 127
		owner 13
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 60)
					(Say 128)
				else
					(Say description)
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
		description 129
		owner 55
	)
)

(instance Cat_Fish of KQInvItem
	(properties
		name {Cat Fish}
		view 893
		cel 10
		signal 2
		description 88
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
		helpStr 9250
	)

	(method (init)
		(self highlightColor: 0 lowlightColor: (if global159 19 else 7))
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
		helpStr 9251
	)

	(method (init)
		(self highlightColor: 0 lowlightColor: (if global159 19 else 7))
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
		helpStr 9252
	)

	(method (init)
		(self highlightColor: 0 lowlightColor: (if global159 19 else 7))
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
		(self highlightColor: 0 lowlightColor: (if global159 19 else 7))
		(super init:)
	)
)

(instance invSelect of IconI
	(properties
		view 901
		loop 4
		cel 0
		cursor 999
		helpStr 9253
	)

	(method (init)
		(self highlightColor: 0 lowlightColor: (if global159 19 else 7))
		(super init:)
	)
)

(instance keyCursor of KQCursor
	(properties
		view 941
		loop 3
		cel 7
		x 20
		y 6
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
		view 941
		loop 1
		cel 13
		x 10
		y 5
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
		view 941
		loop 1
		cel 14
		x 1
		y 1
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
		view 941
		loop 1
		cel 3
		x 9
		y 6
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
		view 941
		loop 1
		cel 12
		x 10
		y 6
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
		view 941
		loop 3
		cel 6
		x 4
		y 11
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
		view 941
		loop 3
		cel 4
		x 1
		y 1
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
		view 941
		loop 3
		cel 10
		x 10
		y 9
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
		view 941
		loop 1
		cel 9
		x 7
		y 8
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
		view 941
		loop 3
		cel 5
		x 9
		y 6
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
		view 941
		loop 1
		cel 10
		x 5
		y 11
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
		view 941
		loop 3
		cel 8
		x 10
		y 6
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
		view 941
		loop 5
		cel 7
		x 4
		y 4
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
		view 941
		loop 5
		cel 8
		x 4
		y 4
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
		view 941
		loop 5
		cel 9
		x 4
		y 4
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
		view 941
		loop 3
		cel 9
		x 10
		y 10
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
		view 941
		loop 3
		cel 1
		x 10
		y 8
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
		view 941
		loop 1
		cel 15
		x 10
		y 6
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
		view 941
		loop 3
		x 10
		y 7
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
		view 941
		loop 1
		cel 6
		x 7
		y 5
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
		view 941
		loop 1
		cel 11
		x 11
		y 9
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
		view 941
		loop 3
		cel 12
		x 2
		y 8
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
		view 941
		loop 5
		cel 6
		x 4
		y 8
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
		view 941
		loop 3
		cel 15
		x 7
		y 12
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
		view 941
		loop 5
		cel 2
		x 7
		y 12
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
		view 941
		loop 3
		cel 13
		x 14
		y 11
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
		view 941
		loop 1
		cel 4
		x 10
		y 9
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
		view 941
		loop 3
		cel 2
		x 4
		y 10
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
		view 941
		loop 1
		cel 2
		x 13
		y 2
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
		view 941
		loop 1
		cel 5
		x 12
		y 5
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
		view 941
		loop 3
		cel 14
		x 13
		y 13
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
		view 941
		loop 5
		x 5
		y 10
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
		view 941
		loop 5
		cel 4
		x 10
		y 7
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
		view 941
		loop 3
		cel 11
		x 10
		y 10
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
		view 941
		loop 3
		cel 3
		x 13
		y 7
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
		view 941
		loop 5
		cel 5
		x 14
		y 6
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
		view 941
		loop 5
		cel 1
		x 7
		y 11
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
		view 941
		loop 5
		cel 10
		x 13
		y 6
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
		view 941
		loop 1
		cel 8
		x 11
		y 7
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
		view 941
		loop 1
		cel 7
		x 7
		y 5
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
		view 941
		loop 5
		cel 12
		x 7
		y 6
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
		view 941
		loop 5
		cel 3
		x 9
		y 10
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
		view 942
		loop 1
		cel 7
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
		view 942
		loop 1
		cel 2
		x 14
		y 10
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
		view 942
		loop 1
		cel 4
		x 10
		y 15
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
		view 942
		loop 1
		cel 1
		x 12
		y 12
	)

	(method (init)
		(if global400
			(self number: 7 yourself:)
		)
		(super init: &rest)
	)
)

(instance theXCursor of KQCursor
	(properties
		view 942
		cel 10
		x 6
		y 6
	)

	(method (init)
		(if global400
			(self number: 5 yourself:)
		)
		(super init: &rest)
	)
)

