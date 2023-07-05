;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 206)
(include sci.sh)
(use Main)
(use GloryWindow)
(use n814)
(use Print)
(use IconBar)
(use Inventory)
(use System)

(public
	gloryInv 0
	pageCode 1
	dropInv 2
)

(local
	local0
	local1
)

(class QG1InvItem of InvI
	(properties
		view 950
		signal 2
		modNum 206
		weight 0
		amount 0
		amtDropped 0
		cursorView 2001
	)

	(method (select)
		(if (super select: &rest)
			(Platform 0 4 4 8 (gloryInv indexOf: self))
			((= cursor invCursor) view: cursorView loop: loop cel: cel)
		)
	)

	(method (dumpIt param1 &tmp temp0)
		(= temp0 (if (> param1 amount) amount else param1))
		(+= amtDropped temp0)
		(gEgo use: (gloryInv indexOf: self) temp0)
		(if (not amount)
			(= owner 0)
		)
		(dropInv addToFront: self)
	)

	(method (pickItUp param1 &tmp temp0 [temp1 2])
		(= temp0 (if (> param1 amtDropped) amtDropped else param1))
		(-= amtDropped temp0)
		(gEgo get: (gloryInv indexOf: self) temp0)
		(if (not amtDropped)
			(dropInv hide: delete: self)
			(if (> (dropInv size:) 4)
				(= local1 1)
				((= gInventory dropInv) showSelf:)
			else
				((= gInventory gloryInv) showSelf:)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0 temp1 temp2 [temp3 50] [temp53 30] [temp83 10] [temp93 20])
		(if (== theVerb 9) ; ???
			(return 1)
		)
		(Print font: gUserFont mode: 1)
		(Message msgGET 206 3 (self message:) 0 1 @temp93)
		(return
			(switch theVerb
				(1 ; Look
					(if local1
						(if (== amtDropped 1)
							(Message msgGET 206 3 0 0 22 @temp53) ; "You have dropped your %s."
							(Print addTextF: @temp53 @temp93 init:)
						else
							(Message msgGET 206 3 0 0 23 @temp53) ; "You have dropped %d of your %ss."
							(Print addTextF: @temp53 amtDropped @temp93 init:)
						)
					else
						(= temp1 (= temp2 0))
						(= temp1 (/ weight 60))
						(if
							(and
								(not (= temp2 (/ (mod weight 60) 6)))
								(not temp1)
							)
							(= temp2 1)
						)
						(if (> (self amount:) 1)
							(Message msgGET 206 3 0 0 1 @temp53) ; "You have %d %ss. Each weighs %d.%d pounds."
						else
							(Message msgGET 206 3 0 0 2 @temp53) ; "You have %d %s. It weighs %d.%d pounds."
						)
						(Print addTextF: @temp53 amount @temp93 temp1 temp2 init:)
					)
				)
				(73 ; Drop Inventory
					(Platform 0 4 3 -1)
					(cond
						(
							(and
								(== self dagger)
								(== (self amount:) 1)
								(not (gEgo has: 2)) ; sword
							)
							(Print addText: 3 0 0 4 0 0 206 init:) ; "You don't really want to drop your last weapon."
						)
						(
							(OneOf
								self
								broadsword
								shield
								dispel_potion
								tool_kit
								glowing_gem
								gold_ring
								brass_key
								hand_mirror
								spirea_seed
								magic_acorn
								dust_filled_flask
								green_fur
							)
							(Message msgGET 206 3 0 0 5 @temp53) ; "You don't really want to drop your %s."
							(Print addTextF: @temp53 @temp93 init:)
						)
						((== gCurRoomNum 322)
							(Print addText: 3 0 0 6 0 0 206 init:) ; "It would not be a good idea to drop anything here."
						)
						((> amount 1)
							(self dumpIt: 1)
							(Message msgGET 206 3 0 0 7 @temp53) ; "You drop one of your %ss."
							(Print addTextF: @temp53 @temp93 init:)
						)
						(else
							(Message msgGET 206 3 0 0 8 @temp53) ; "You drop your %s."
							(Print addTextF: @temp53 @temp93 init:)
							(self dumpIt: 1)
							(if (== (gTheIconBar curInvIcon:) self)
								(gTheIconBar curInvIcon: 0)
							)
							(for ((= temp0 0)) (< temp0 40) ((++ temp0))
								(if (== ((gInventory at: temp0) owner:) gEgo)
									(= temp0 41)
								)
							)
							(gInventory hide:)
							(if (> temp0 40)
								(gInventory curIcon: invDrop show:)
							else
								(= local0 1)
								(invPageUp select:)
							)
						)
					)
				)
				(77 ; triggerSpell or Pickup Inventory
					(if (not amtDropped)
						(Print addText: 3 0 0 20 0 0 206 init:) ; "There is nothing to pick up."
					else
						(if (== amtDropped 1)
							(Message msgGET 206 3 0 0 25 @temp53) ; "You pick up your %s."
						else
							(Message msgGET 206 3 0 0 24 @temp53) ; "You pick up one of your %ss."
						)
						(Print addTextF: @temp53 @temp93 init:)
						(self pickItUp: 1)
					)
				)
				(9 0) ; ???
				(else
					(Message msgGET 206 3 0 0 3 @temp53) ; "You can't use your %s on your %s."
					(Message msgGET 206 3 theVerb 0 1 @temp83)
					(Print addTextF: @temp53 @temp83 @temp93 init:)
				)
			)
		)
	)
)

(instance gloryInv of Inv
	(properties
		normalHeading 4017
		empty 4035
	)

	(method (init)
		((= gInventory self)
			window: invWin
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
			add:
				silver
				food_rations
				broadsword
				chainmail_shirt
				leather_jerkin
				shield
				dagger
				lockpick
				tool_kit
				license
				rock
				empty_flask
				healing_potion
				mana_potion
				vigor_potion
				dispel_potion
				brass_key
				glowing_gem
				gold_ring
				undead_unguent
				hand_mirror
				mandrake_root
				small_apple
				vegetable
				magic_acorn
				spirea_seed
				flower
				green_fur
				dust_filled_flask
				water_filled_flask
				mushroom
				vase
				candelabra
				music_box
				candlesticks
				pearls
				claw
				beard_piece
				money_pouch
				paper_scrap
				invPageDown
				invPageUp
				invLook
				invSelect
				invDrop
				invPickup
				invWeight
				ok
				invHelp
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			eachElementDo: #init
			state: 2048
		)
		(gEgo get: 4 get: 1 5 get: 38 4 get: 0 10) ; leather, rations, gold, silver
		(dropInv init:)
	)

	(method (noClickHelp)
		(super noClickHelp: &rest)
		(= curIcon invSelect)
		(gGame setCursor: (invSelect cursor:) 1)
	)

	(method (hide &tmp temp0)
		(Platform 0 4 2 -1)
		(super hide: &rest)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
	)
)

(instance dropInv of Inv
	(properties
		normalHeading 4017
		empty 4035
	)

	(method (hide &tmp temp0)
		(if (== gInventory self)
			(= gInventory gloryInv)
		)
		(= local1 0)
		(for ((= temp0 0)) (< temp0 (- size 4)) ((++ temp0))
			(if ((self at: temp0) amount:)
				((self at: temp0) owner: gEgo)
			)
		)
		(super hide: &rest)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
	)

	(method (showSelf &tmp temp0)
		(for ((= temp0 0)) (< temp0 (- size 4)) ((++ temp0))
			((self at: temp0) owner: gEgo)
		)
		(super showSelf: &rest)
	)

	(method (show)
		(Platform 0 4 3 -1)
		(= curIcon invPickup)
		(super show: &rest)
	)

	(method (noClickHelp)
		(super noClickHelp: &rest)
		(= curIcon invPickup)
		(gGame setCursor: (invPickup cursor:) 1)
	)

	(method (init)
		(self
			window: invWin
			helpIconItem: invHelp
			okButton: ok
			add: invLook invPickup ok invHelp
			eachElementDo: #highlightColor -1
			eachElementDo: #lowlightColor -1
			eachElementDo: #init
			state: 2048
		)
	)
)

(instance invWin of GloryWindow
	(properties
		yOffset 28
	)
)

(instance pageCode of Code
	(properties)

	(method (init &tmp temp0 temp1)
		(if (IsFlag 361)
			(ClearFlag 361)
			(for ((= temp0 0)) (< temp0 (- (dropInv size:) 4)) ((++ temp0))
				((dropInv at: temp0) owner: gEgo)
			)
			((= gInventory dropInv) okButton: ok showSelf:)
		else
			(if
				(or
					(OneOf
						gCurRoomNum
						420 ; bearArena
						480 ; minotaurArena
						430 ; saurusArena
						435 ; mantrayArena
						440 ; cheetaurArena
						445 ; goblinArena
						455 ; ogreArena
						450 ; trollArena
						460 ; dragonArena
						465 ; brigandArena
						470
					)
					(== gCurRoomNum 32) ; wizGame
				)
				(return)
			)
			(invSelect message: -1)
			(= global423 0)
			(invPageUp owner: 0)
			(invPageDown owner: 0)
			(for ((= temp0 0)) (< temp0 40) ((++ temp0))
				((gInventory at: temp0) owner: 0)
				(if
					(and
						(!= temp0 38)
						(or (> ((gInventory at: temp0) amount:) 0) (== temp0 0))
						(< (++ global423) 24)
					)
					((gInventory at: temp0) owner: gEgo)
				)
			)
			(if (> global423 23)
				(invPageDown highlightColor: -1 owner: gEgo)
			)
			(gInventory showSelf:)
		)
	)
)

(instance invPageDown of InvI
	(properties
		view 991
		loop 5
		message 75
		signal 3
		noun 6
		modNum 206
		helpVerb 9
	)

	(method (show)
		(super show:)
		(DrawCel 991 7 0 (+ nsLeft (CelWide view loop cel)) nsTop -1)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(for ((= temp0 0)) (< temp0 40) ((++ temp0))
				(if
					(and
						(!= temp0 38)
						(or (> ((gInventory at: temp0) amount:) 0) (== temp0 0))
					)
					(if (== ((gInventory at: temp0) owner:) gEgo)
						((gInventory at: temp0) owner: 1)
					else
						((gInventory at: temp0) owner: gEgo)
					)
				)
			)
			(invPageUp owner: gEgo highlightColor: -1)
			(= owner 0)
			(gInventory hide: showSelf:)
			(return 0)
		)
	)
)

(instance invPageUp of InvI
	(properties
		view 991
		loop 5
		message 75
		signal 3
		noun 6
		modNum 206
		helpVerb 9
	)

	(method (show)
		(super show:)
		(DrawCel 991 7 0 (+ nsLeft (CelWide view loop cel)) nsTop -1)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(for ((= temp0 0)) (< temp0 40) ((++ temp0))
				(if
					(and
						(!= temp0 38)
						(or (> ((gInventory at: temp0) amount:) 0) (== temp0 0))
					)
					(if (== ((gInventory at: temp0) owner:) 1)
						((gInventory at: temp0) owner: gEgo)
					else
						((gInventory at: temp0) owner: 0)
					)
				)
			)
			(gInventory hide:)
			(= owner 0)
			(if (not local0)
				(invPageDown owner: gEgo highlightColor: -1)
				(= owner 0)
			)
			(= local0 0)
			(gInventory showSelf:)
			(return 0)
		)
	)
)

(instance invLook of IconI
	(properties
		view 991
		loop 2
		cel 0
		cursor 941
		message 1
		signal 129
		noun 4
		modNum 206
		helpVerb 9
	)
)

(instance invSelect of IconI
	(properties
		view 991
		loop 0
		cel 0
		cursor 942
		message 4
		noun 8
		modNum 206
		helpVerb 9
	)
)

(instance invPickup of IconI
	(properties
		view 991
		loop 8
		cel 0
		cursor 938
		message 77
		noun 7
		modNum 206
		helpVerb 9
	)

	(method (select &tmp temp0 temp1)
		(if (super select: &rest)
			(= temp0 0)
			(for ((= temp1 0)) (< temp1 40) ((++ temp1))
				(if ((gloryInv at: temp1) amtDropped:)
					(= temp0 1)
				)
			)
			(if (= local1 temp0)
				(if (== gInventory gloryInv)
					(SetFlag 361)
					(gInventory hide:)
				)
				(return 1)
			else
				(Print addText: 3 0 0 20 0 0 206 init:) ; "There is nothing to pick up."
				(return 0)
			)
		)
	)
)

(instance invDrop of IconI
	(properties
		view 991
		loop 6
		cel 0
		cursor 939
		message 73
		noun 1
		modNum 206
		helpVerb 9
	)
)

(instance invWeight of IconI
	(properties
		view 991
		loop 4
		cel 0
		cursor 949
		message 9
		signal 67
		noun 9
		modNum 206
		helpVerb 9
	)

	(method (select &tmp temp0 [temp1 60])
		(if (super select: &rest)
			(= temp0 (WtCarried))
			(Message msgGET 206 9 0 0 1 @temp1) ; "You are now carrying %d pounds of equipment, supplies, and whatever else you've picked up along the way."
			(Print
				font: gUserFont
				mode: 1
				addTextF: @temp1 temp0 (if (== temp0 1) {} else {s})
				init: youOnlyLoveMeForMyCueMethod
			)
			(return 0)
		)
	)
)

(instance invHelp of IconI
	(properties
		view 991
		loop 1
		cel 0
		cursor 949
		message 9
		noun 2
		modNum 206
		helpVerb 9
	)

	(method (show)
		(super show:)
		(DrawCel 991 7 0 (+ nsLeft (CelWide view loop cel)) nsTop -1)
	)
)

(instance ok of IconI
	(properties
		view 991
		loop 3
		cel 0
		cursor 949
		message 9
		signal 67
		noun 5
		modNum 206
		helpVerb 9
	)
)

(instance silver of QG1InvItem
	(properties
		message 10
		noun 3
		weight 1
	)

	(method (doVerb theVerb &tmp [temp0 50] temp50 temp51)
		(if (== theVerb 9) ; ???
			(return 1)
		)
		(Print font: gUserFont mode: 1)
		(return
			(switch theVerb
				(1 ; Look
					(if local1
						(Message msgGET 206 3 0 0 21 @temp0) ; "You have dropped %d silver%s."
						(Print
							addTextF:
								@temp0
								amtDropped
								(if (> amtDropped 1) {s} else {})
							init:
						)
					else
						(= temp50 (= temp51 0))
						(= temp50
							(/
								(= temp51
									(/ (+ (money_pouch amount:) amount) 6)
								)
								10
							)
						)
						(if (and (not (= temp51 (mod temp51 10))) (not temp50))
							(= temp51 1)
						)
						(cond
							((and amount (money_pouch amount:))
								(Message msgGET 206 3 0 0 9 @temp0) ; "You have %d gold piece%s and %d silver piece%s, weighing %d.%d pounds."
								(Print
									addTextF:
										@temp0
										(money_pouch amount:)
										(if (> (money_pouch amount:) 1)
											{s}
										else
											{}
										)
										amount
										(if (> amount 1) {s} else {})
										temp50
										temp51
									init:
								)
							)
							(amount
								(Message msgGET 206 3 0 0 10 @temp0) ; "You have %d silver piece%s, weighing %d.%d pounds."
								(Print
									addTextF:
										@temp0
										amount
										(if (> amount 1) {s} else {})
										temp50
										temp51
									init:
								)
							)
							((money_pouch amount:)
								(Message msgGET 206 3 0 0 11 @temp0) ; "You have %d gold piece%s, weighing %d.%d pounds."
								(Print
									addTextF:
										@temp0
										(money_pouch amount:)
										(if (> (money_pouch amount:) 1)
											{s}
										else
											{}
										)
										temp50
										temp51
									init:
								)
							)
							(else
								(switch (Random 0 5)
									(0
										(Print addText: 3 0 0 12 0 0 206 init:) ; "A moth flies from your money pouch. That is all."
									)
									(1
										(Print addText: 3 0 0 13 0 0 206 init:) ; "No silver threads or golden needles... your pouch is empty."
									)
									(else
										(Print addText: 3 0 0 14 0 0 206 init:) ; "Your money pouch is empty."
									)
								)
							)
						)
					)
				)
				(73 ; Drop Inventory
					(cond
						((== gCurRoomNum 322)
							(Print addText: 3 0 0 6 0 0 206 init:) ; "It would not be a good idea to drop anything here."
						)
						((> amount 10)
							(Print addText: 3 0 0 15 0 0 206 init:) ; "You drop ten silvers."
							(self dumpIt: 10)
						)
						((> amount 1)
							(Print addText: 3 0 0 16 0 0 206 init:) ; "You drop the rest of your silvers, all but one that you keep for luck."
							(self dumpIt: (- amount 1))
						)
						(else
							(Print addText: 3 0 0 17 0 0 206 init:) ; "You start to drop your gold, but think better of it."
						)
					)
				)
				(77 ; triggerSpell or Pickup Inventory
					(cond
						((> amtDropped 10)
							(Print addText: 3 0 0 18 0 0 206 init:) ; "You pick up ten silvers."
							(self pickItUp: 10)
						)
						((not amtDropped)
							(Print addText: 3 0 0 20 0 0 206 init:) ; "There is nothing to pick up."
						)
						(else
							(Print addText: 3 0 0 19 0 0 206 init:) ; "You pick up the rest of your silvers."
							(self pickItUp: amtDropped)
						)
					)
				)
				(9 0) ; ???
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance money_pouch of QG1InvItem
	(properties
		name {money pouch}
		loop 6
		message 49
		noun 3
		weight 1
	)
)

(instance food_rations of QG1InvItem
	(properties
		name {food rations}
		cel 1
		message 11
		noun 3
		weight 20
		cursorView 2002
	)
)

(instance broadsword of QG1InvItem
	(properties
		cel 4
		message 12
		noun 3
		weight 420
		cursorView 2005
	)
)

(instance chainmail_shirt of QG1InvItem
	(properties
		name {chainmail shirt}
		loop 2
		cel 14
		message 13
		noun 3
		weight 2100
		cursorView 2031
	)
)

(instance leather_jerkin of QG1InvItem
	(properties
		name {leather jerkin}
		cel 6
		message 14
		noun 3
		weight 1200
		cursorView 2007
	)
)

(instance shield of QG1InvItem
	(properties
		cel 7
		message 15
		noun 3
		weight 720
		cursorView 2008
	)
)

(instance dagger of QG1InvItem
	(properties
		cel 5
		message 16
		noun 3
		weight 120
		cursorView 2006
	)
)

(instance lockpick of QG1InvItem
	(properties
		loop 2
		cel 4
		message 17
		noun 3
		weight 5
		cursorView 2021
	)
)

(instance tool_kit of QG1InvItem
	(properties
		name {tool kit}
		loop 2
		cel 5
		message 18
		noun 3
		weight 30
		cursorView 2022
	)
)

(instance license of QG1InvItem
	(properties
		loop 2
		cel 6
		message 19
		noun 3
		weight 2
		cursorView 2023
	)
)

(instance rock of QG1InvItem
	(properties
		loop 2
		cel 2
		message 20
		noun 3
		weight 30
		cursorView 2019
	)
)

(instance empty_flask of QG1InvItem
	(properties
		name {empty flask}
		loop 2
		cel 7
		message 21
		noun 3
		weight 10
		cursorView 2024
	)
)

(instance healing_potion of QG1InvItem
	(properties
		name {healing potion}
		loop 4
		message 22
		noun 3
		weight 40
		cursorView 2034
	)
)

(instance mana_potion of QG1InvItem
	(properties
		name {mana potion}
		loop 4
		cel 1
		message 23
		noun 3
		weight 40
		cursorView 2041
	)
)

(instance vigor_potion of QG1InvItem
	(properties
		name {vigor potion}
		loop 4
		cel 2
		message 24
		noun 3
		weight 40
		cursorView 2040
	)
)

(instance dispel_potion of QG1InvItem
	(properties
		name {dispel potion}
		loop 4
		cel 3
		message 25
		noun 3
		weight 40
		cursorView 2038
	)
)

(instance brass_key of QG1InvItem
	(properties
		name {brass key}
		cel 3
		message 26
		noun 3
		weight 15
		cursorView 2004
	)
)

(instance glowing_gem of QG1InvItem
	(properties
		name {glowing gem}
		cel 10
		message 27
		noun 3
		weight 6
		cursorView 2011
	)
)

(instance gold_ring of QG1InvItem
	(properties
		name {gold ring}
		loop 2
		message 28
		noun 3
		weight 10
		cursorView 2017
	)
)

(instance undead_unguent of QG1InvItem
	(properties
		name {undead unguent}
		loop 4
		cel 4
		message 29
		noun 3
		weight 40
		cursorView 2039
	)
)

(instance hand_mirror of QG1InvItem
	(properties
		name {hand mirror}
		loop 4
		cel 5
		message 30
		noun 3
		weight 30
		cursorView 2033
	)
)

(instance mandrake_root of QG1InvItem
	(properties
		name {mandrake root}
		cel 2
		message 31
		noun 3
		weight 30
		cursorView 2003
	)
)

(instance small_apple of QG1InvItem
	(properties
		name {small apple}
		cel 9
		message 32
		noun 3
		weight 15
		cursorView 2010
	)
)

(instance vegetable of QG1InvItem
	(properties
		loop 2
		cel 15
		message 33
		noun 3
		weight 30
		cursorView 2030
	)
)

(instance magic_acorn of QG1InvItem
	(properties
		name {magic acorn}
		loop 4
		cel 6
		message 34
		noun 3
		weight 3
		cursorView 2032
	)
)

(instance spirea_seed of QG1InvItem
	(properties
		name {spirea seed}
		loop 2
		cel 1
		message 35
		noun 3
		weight 60
		cursorView 2018
	)
)

(instance flower of QG1InvItem
	(properties
		loop 2
		cel 3
		message 36
		noun 3
		weight 1
		cursorView 2020
	)
)

(instance green_fur of QG1InvItem
	(properties
		name {green fur}
		loop 2
		cel 8
		message 37
		noun 3
		weight 3
		cursorView 2025
	)
)

(instance dust_filled_flask of QG1InvItem
	(properties
		name {dust-filled flask}
		loop 2
		cel 9
		message 38
		noun 3
		weight 10
		cursorView 2026
	)
)

(instance water_filled_flask of QG1InvItem
	(properties
		name {water-filled flask}
		loop 2
		cel 10
		message 39
		noun 3
		weight 40
		cursorView 2027
	)
)

(instance mushroom of QG1InvItem
	(properties
		loop 2
		cel 11
		message 40
		noun 3
		weight 10
		cursorView 2028
	)
)

(instance vase of QG1InvItem
	(properties
		cel 11
		message 41
		noun 3
		weight 30
		cursorView 2012
	)
)

(instance candelabra of QG1InvItem
	(properties
		cel 12
		message 42
		noun 3
		weight 180
		cursorView 2013
	)
)

(instance music_box of QG1InvItem
	(properties
		name {music box}
		cel 13
		message 43
		noun 3
		weight 45
		cursorView 2014
	)
)

(instance candlesticks of QG1InvItem
	(properties
		cel 14
		message 44
		noun 3
		weight 60
		cursorView 2015
	)
)

(instance pearls of QG1InvItem
	(properties
		cel 15
		message 45
		noun 3
		weight 30
		cursorView 2016
	)
)

(instance claw of QG1InvItem
	(properties
		loop 2
		cel 12
		message 46
		noun 3
		weight 20
		cursorView 2029
	)
)

(instance beard_piece of QG1InvItem
	(properties
		name {beard piece}
		loop 2
		cel 13
		message 47
		noun 3
		weight 60
		cursorView 2035
	)
)

(instance paper_scrap of QG1InvItem
	(properties
		name {paper scrap}
		cel 8
		message 53
		noun 3
		weight 1
		cursorView 2009
	)
)

(instance invCursor of Cursor
	(properties
		view 950
	)
)

(instance youOnlyLoveMeForMyCueMethod of Script
	(properties)

	(method (cue &tmp temp0 [temp1 120])
		(= temp0 (MaxLoad))
		(Message msgGET 206 9 0 0 2 @temp1) ; "You can carry up to %d pound%s of equipment without getting a severe backache."
		(Print
			font: gUserFont
			mode: 1
			addTextF: @temp1 temp0 (if (== temp0 1) {} else {s})
			init:
		)
	)
)

