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
	)

	(method (select)
		(if (super select: &rest)
			((= cursor invCursor) view: 960 loop: loop cel: cel)
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
							(Print addTextF: @temp3 @temp53 @temp93 init:)
						else
							(Message msgGET 206 3 0 0 23 @temp53) ; "You have dropped %d of your %ss."
							(Print
								addTextF: @temp3 @temp53 amtDropped @temp93
								init:
							)
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
						(Print
							addTextF: @temp3 @temp53 amount @temp93 temp1 temp2
							init:
						)
					)
				)
				(73 ; Drop Inventory
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
								sword
								shield
								disenchant
								thiefKit
								magicGem
								ring
								brassKey
								magicMirror
								seed
								acorn
								fairyDust
								greenFur
							)
							(Message msgGET 206 3 0 0 5 @temp53) ; "You don't really want to drop your %s."
							(Print addTextF: @temp3 @temp53 @temp93 init:)
						)
						((== gCurRoomNum 322)
							(Print addText: 3 0 0 6 0 0 206 init:) ; "It would not be a good idea to drop anything here."
						)
						((> amount 1)
							(self dumpIt: 1)
							(Message msgGET 206 3 0 0 7 @temp53) ; "You drop one of your %ss."
							(Print addTextF: @temp3 @temp53 @temp93 init:)
						)
						(else
							(Message msgGET 206 3 0 0 8 @temp53) ; "You drop your %s."
							(Print addTextF: @temp3 @temp53 @temp93 init:)
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
						(Print addTextF: @temp3 @temp53 @temp93 init:)
						(self pickItUp: 1)
					)
				)
				(9 0) ; ???
				(else
					(Message msgGET 206 3 0 0 3 @temp53) ; "You can't use your %s on your %s."
					(Message msgGET 206 3 theVerb 0 1 @temp83)
					(Print addTextF: @temp3 @temp53 @temp83 @temp93 init:)
				)
			)
		)
	)
)

(instance gloryInv of Inv
	(properties
		normalHeading 3819
		empty 3837
	)

	(method (init)
		((= gInventory self)
			window: invWin
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
			add:
				silver
				rations
				sword
				chainMail
				leather
				shield
				dagger
				lockPick
				thiefKit
				thiefLicense
				rock
				flask
				healingPotion
				manaPotion
				staminaPotion
				disenchant
				brassKey
				magicGem
				ring
				ghostOil
				magicMirror
				mandrake
				fruit
				vegetables
				acorn
				seed
				flowers
				greenFur
				fairyDust
				flyingWater
				mushroom
				vase
				candelabra
				musicBox
				candleSticks
				pearls
				cheetaurClaw
				trollBeard
				gold
				paper
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
		(super hide: &rest)
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
	)
)

(instance dropInv of Inv
	(properties
		normalHeading 3819
		empty 3837
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
						425 ; minotaurArena
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

	(method (select &tmp temp0 [temp1 60] [temp61 60])
		(if (super select: &rest)
			(= temp0 (WtCarried))
			(Message msgGET 206 9 0 0 1 @temp1) ; "You are now carrying %d pounds of equipment, supplies, and whatever else you've picked up along the way."
			(Print
				font: gUserFont
				mode: 1
				addTextF: @temp61 @temp1 temp0 (if (== temp0 1) {} else {s})
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
		weight 1
	)

	(method (doVerb theVerb &tmp [temp0 40] [temp40 50] temp90 temp91)
		(if (== theVerb 9) ; ???
			(return 1)
		)
		(Print font: gUserFont mode: 1)
		(return
			(switch theVerb
				(1 ; Look
					(if local1
						(Message msgGET 206 3 0 0 21 @temp40) ; "You have dropped %d silver%s."
						(Print
							addTextF:
								@temp0
								@temp40
								amtDropped
								(if (> amtDropped 1) {s} else {})
							init:
						)
					else
						(= temp90 (= temp91 0))
						(= temp90
							(/ (= temp91 (/ (+ (gold amount:) amount) 6)) 10)
						)
						(if (and (not (= temp91 (mod temp91 10))) (not temp90))
							(= temp91 1)
						)
						(cond
							((and amount (gold amount:))
								(Message msgGET 206 3 0 0 9 @temp40) ; "You have %d gold piece%s and %d silver piece%s, weighing %d.%d pounds."
								(Print
									addTextF:
										@temp0
										@temp40
										(gold amount:)
										(if (> (gold amount:) 1) {s} else {})
										amount
										(if (> amount 1) {s} else {})
										temp90
										temp91
									init:
								)
							)
							(amount
								(Message msgGET 206 3 0 0 10 @temp40) ; "You have %d silver piece%s, weighing %d.%d pounds."
								(Print
									addTextF:
										@temp0
										@temp40
										amount
										(if (> amount 1) {s} else {})
										temp90
										temp91
									init:
								)
							)
							((gold amount:)
								(Message msgGET 206 3 0 0 11 @temp40) ; "You have %d gold piece%s, weighing %d.%d pounds."
								(Print
									addTextF:
										@temp0
										@temp40
										(gold amount:)
										(if (> (gold amount:) 1) {s} else {})
										temp90
										temp91
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

(instance gold of QG1InvItem
	(properties
		loop 6
		message 49
		weight 1
	)
)

(instance rations of QG1InvItem
	(properties
		cel 1
		message 11
		weight 20
	)
)

(instance sword of QG1InvItem
	(properties
		cel 4
		message 12
		weight 420
	)
)

(instance chainMail of QG1InvItem
	(properties
		loop 2
		cel 14
		message 13
		weight 2100
	)
)

(instance leather of QG1InvItem
	(properties
		cel 6
		message 14
		weight 1200
	)
)

(instance shield of QG1InvItem
	(properties
		cel 7
		message 15
		weight 720
	)
)

(instance dagger of QG1InvItem
	(properties
		cel 5
		message 16
		weight 120
	)
)

(instance lockPick of QG1InvItem
	(properties
		loop 2
		cel 4
		message 17
		weight 5
	)
)

(instance thiefKit of QG1InvItem
	(properties
		loop 2
		cel 5
		message 18
		weight 30
	)
)

(instance thiefLicense of QG1InvItem
	(properties
		loop 2
		cel 6
		message 19
		weight 2
	)
)

(instance rock of QG1InvItem
	(properties
		loop 2
		cel 2
		message 20
		weight 30
	)
)

(instance flask of QG1InvItem
	(properties
		loop 2
		cel 7
		message 21
		weight 10
	)
)

(instance healingPotion of QG1InvItem
	(properties
		loop 4
		message 22
		weight 40
	)
)

(instance manaPotion of QG1InvItem
	(properties
		loop 4
		cel 1
		message 23
		weight 40
	)
)

(instance staminaPotion of QG1InvItem
	(properties
		loop 4
		cel 2
		message 24
		weight 40
	)
)

(instance disenchant of QG1InvItem
	(properties
		loop 4
		cel 3
		message 25
		weight 40
	)
)

(instance brassKey of QG1InvItem
	(properties
		cel 3
		message 26
		weight 15
	)
)

(instance magicGem of QG1InvItem
	(properties
		cel 10
		message 27
		weight 6
	)
)

(instance ring of QG1InvItem
	(properties
		loop 2
		message 28
		weight 10
	)
)

(instance ghostOil of QG1InvItem
	(properties
		loop 4
		cel 4
		message 29
		weight 40
	)
)

(instance magicMirror of QG1InvItem
	(properties
		loop 4
		cel 5
		message 30
		weight 30
	)
)

(instance mandrake of QG1InvItem
	(properties
		cel 2
		message 31
		weight 30
	)
)

(instance fruit of QG1InvItem
	(properties
		cel 9
		message 32
		weight 15
	)
)

(instance vegetables of QG1InvItem
	(properties
		loop 2
		cel 15
		message 33
		weight 30
	)
)

(instance acorn of QG1InvItem
	(properties
		loop 4
		cel 6
		message 34
		weight 3
	)
)

(instance seed of QG1InvItem
	(properties
		loop 2
		cel 1
		message 35
		weight 60
	)
)

(instance flowers of QG1InvItem
	(properties
		loop 2
		cel 3
		message 36
		weight 1
	)
)

(instance greenFur of QG1InvItem
	(properties
		loop 2
		cel 8
		message 37
		weight 3
	)
)

(instance fairyDust of QG1InvItem
	(properties
		loop 2
		cel 9
		message 38
		weight 10
	)
)

(instance flyingWater of QG1InvItem
	(properties
		loop 2
		cel 10
		message 39
		weight 40
	)
)

(instance mushroom of QG1InvItem
	(properties
		loop 2
		cel 11
		message 40
		weight 10
	)
)

(instance vase of QG1InvItem
	(properties
		cel 11
		message 41
		weight 30
	)
)

(instance candelabra of QG1InvItem
	(properties
		cel 12
		message 42
		weight 180
	)
)

(instance musicBox of QG1InvItem
	(properties
		cel 13
		message 43
		weight 45
	)
)

(instance candleSticks of QG1InvItem
	(properties
		cel 14
		message 44
		weight 60
	)
)

(instance pearls of QG1InvItem
	(properties
		cel 15
		message 45
		weight 30
	)
)

(instance cheetaurClaw of QG1InvItem
	(properties
		loop 2
		cel 12
		message 46
		weight 20
	)
)

(instance trollBeard of QG1InvItem
	(properties
		loop 2
		cel 13
		message 47
		weight 60
	)
)

(instance paper of QG1InvItem
	(properties
		cel 8
		message 53
		weight 1
	)
)

(instance invCursor of Cursor
	(properties
		view 950
	)
)

(instance youOnlyLoveMeForMyCueMethod of Script
	(properties)

	(method (cue &tmp temp0 [temp1 60] [temp61 60])
		(= temp0 (MaxLoad))
		(Message msgGET 206 9 0 0 2 @temp1) ; "You can carry up to %d pound%s of equipment without getting a severe backache."
		(Print
			font: gUserFont
			mode: 1
			addTextF: @temp61 @temp1 temp0 (if (== temp0 1) {} else {s})
			init:
		)
	)
)

