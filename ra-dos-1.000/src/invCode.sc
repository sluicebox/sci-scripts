;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
(include sci.sh)
(use Main)
(use BorderWindow)
(use IconBar)
(use Osc)
(use ForwardCounter)
(use Timer)
(use Sound)
(use Inventory)
(use Actor)
(use System)

(public
	invCode 0
	invWin 1
)

(class LBIconItem of IconI
	(properties)

	(method (ownedBy)
		(return 0)
	)
)

(class LBInvItem of InvI
	(properties)

	(method (init)
		(= lowlightColor global168)
		(super init:)
	)

	(method (doVerb theVerb)
		(gNarrator name: name showTitle: 1)
		(cond
			((== theVerb 1) ; Look
				(gMessager say: noun 1 0 0 0 15)
			)
			((== theVerb 8) ; magnifier
				(gMessager say: noun 8 0 0 0 15)
			)
			((not (OneOf theVerb 3 4 2 6 12 13)) ; Walk, Do, Talk, Ask, ???, Exit Icon
				(gMessager say: 0 47 0 0 0 15) ; "While this IS an interesting approach, it serves no practical purpose other than your temporary amusement."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance invCode of Code
	(properties)

	(method (init)
		(= gInventory Inv)
		(Inv
			init:
			window: invWin
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
			add:
				Coupon
				Claim_Ticket
				Notebook
				Sandwich
				Baseball
				Desk_Key
				Press_Pass
				Pocket_Watch
				Skeleton_Key
				Meat
				Wire_Cutters
				Dagger_of_Ra
				Work_Boot
				Smelling_Salts
				Snake_Oil
				Lantern
				Cheese
				Garter
				Dinosaur_Bone
				Snake_Lasso
				Ankh_Medallion
				Pippin_s_Notepad
				Magnifying_Glass
				Light_Bulb
				Watney_s_File
				Animal_Hairs
				Bifocals
				Red_Hair
				Water_Glass
				Carbon_Paper
				Yvette_s_Shoe
				Grapes
				Evening_Gown
				Charcoal
				Wire
				Mummy
				invLook
				invHand
				invSelect
				invHelp
				ok
			eachElementDo: #highlightColor global157
			eachElementDo: #modNum 15
			eachElementDo: #init
			state: 2048
		)
	)
)

(instance invWin of InsetWindow
	(properties
		priority -1
		topBordHgt 28
		botBordHgt 5
	)

	(method (open &tmp temp0 temp1 temp2)
		(= temp0 0)
		(for
			((= temp1 (gInventory first:)))
			temp1
			((= temp1 (gInventory next: temp1)))
			
			(if (not ((= temp2 (NodeValue temp1)) isKindOf: InvI))
				(+= temp0 (CelWide (temp2 view:) (temp2 loop:) (temp2 cel:)))
			)
		)
		(super open:)
		(invLook nsLeft: (/ (- (- right left) temp0) 2))
	)
)

(instance ok of LBIconItem
	(properties
		view 991
		loop 3
		cel 0
		cursor 999
		signal 67
		noun 17
		helpVerb 12
	)

	(method (init)
		(super init:)
		(= lowlightColor global177)
	)
)

(instance invLook of LBIconItem
	(properties
		view 991
		loop 2
		cel 0
		cursor 1
		message 1
		signal 129
		noun 16
		helpVerb 12
	)

	(method (init)
		(super init:)
		(= lowlightColor global177)
	)
)

(instance invHand of LBIconItem
	(properties
		view 991
		loop 0
		cel 0
		cursor 2
		message 4
		noun 14
		helpVerb 12
	)

	(method (init)
		(super init:)
		(= lowlightColor global177)
	)
)

(instance invHelp of LBIconItem
	(properties
		view 991
		loop 1
		cel 0
		cursor 9
		message 12
		signal 3
		noun 15
		helpVerb 12
	)

	(method (init)
		(super init:)
		(= lowlightColor global177)
	)
)

(instance invSelect of LBIconItem
	(properties
		view 991
		loop 4
		cel 0
		cursor 999
		noun 18
		helpVerb 12
	)

	(method (init)
		(super init:)
		(= lowlightColor global177)
	)
)

(instance Coupon of LBInvItem
	(properties
		view 83
		loop 1
		cursor 83
		message 10
		signal 2
		noun 7
	)
)

(instance Claim_Ticket of LBInvItem
	(properties
		name {Claim Ticket}
		view 59
		loop 1
		cursor 59
		message 5
		signal 2
		noun 6
	)
)

(instance Notebook of LBInvItem
	(properties
		view 50
		loop 1
		cursor 50
		message 14
		signal 2
		noun 24
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gInventory hide:)
				(gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
				(return)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Sandwich of LBInvItem
	(properties
		view 53
		loop 1
		cursor 53
		message 15
		signal 2
		noun 29
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; pressPass
				(gMessager say: noun 11 0 0 0 15) ; "You really enjoy a good pastrami and press pass sandwich now and then."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Baseball of LBInvItem
	(properties
		view 54
		loop 1
		cursor 54
		message 7
		signal 2
		noun 1
	)
)

(instance Desk_Key of LBInvItem
	(properties
		name {Desk Key}
		view 52
		loop 1
		cursor 52
		message 16
		signal 2
		noun 9
	)
)

(instance Press_Pass of LBInvItem
	(properties
		name {Press Pass}
		view 51
		loop 1
		cursor 51
		message 11
		signal 2
		noun 27
	)
)

(instance Pocket_Watch of LBInvItem
	(properties
		name {Pocket Watch}
		view 75
		loop 1
		cursor 75
		message 17
		signal 2
		noun 26
	)
)

(instance Skeleton_Key of LBInvItem
	(properties
		name {Skeleton Key}
		view 58
		loop 1
		cursor 58
		message 18
		signal 2
		noun 30
	)
)

(instance Meat of LBInvItem
	(properties
		view 64
		loop 1
		cursor 64
		message 19
		signal 2
		noun 22
	)
)

(instance Wire_Cutters of LBInvItem
	(properties
		name {Wire Cutters}
		view 76
		loop 1
		cursor 76
		message 21
		signal 2
		noun 38
	)
)

(instance Dagger_of_Ra of LBInvItem
	(properties
		name {Dagger of Ra}
		view 71
		loop 1
		cursor 71
		message 22
		signal 2
		noun 8
	)
)

(instance Work_Boot of LBInvItem
	(properties
		name {Work Boot}
		view 70
		loop 1
		cursor 70
		message 23
		signal 2
		noun 40
	)
)

(instance Smelling_Salts of LBInvItem
	(properties
		name {Smelling Salts}
		view 68
		loop 1
		cursor 68
		message 24
		signal 2
		noun 31
	)
)

(instance Snake_Oil of LBInvItem
	(properties
		name {Snake Oil}
		view 61
		loop 1
		cursor 61
		message 25
		signal 2
		noun 33
		owner 520
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator name: name showTitle: 1)
				(cond
					((== global150 4)
						(gMessager say: 33 1 9 0 0 15) ; "A full bottle of "DR. MORIBUND'S GUARANTEED SNAKE OIL.""
					)
					((== global150 3)
						(gMessager say: 33 1 10 0 0 15) ; "A bottle of "DR. MORIBUND'S GUARANTEED SNAKE OIL." It's three-quarters-full."
					)
					((== global150 2)
						(gMessager say: 33 1 11 0 0 15) ; "A bottle of "DR. MORIBUND'S GUARANTEED SNAKE OIL." It's half-full."
					)
					((== global150 1)
						(gMessager say: 33 1 12 0 0 15) ; "A bottle of "DR. MORIBUND'S GUARANTEED SNAKE OIL." It's one-quarter-full."
					)
					(else
						(gMessager say: 33 1 8 0 0 15) ; "An empty bottle of "DR. MORIBUND'S GUARANTEED SNAKE OIL.""
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Lantern of LBInvItem
	(properties
		view 84
		loop 1
		cursor 84
		message 26
		signal 2
		noun 19
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (== cel 0)
					(gInventory hide:)
					(gCurRoom setScript: sCrankLantern)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Cheese of LBInvItem
	(properties
		view 63
		loop 1
		cursor 63
		message 27
		signal 2
		noun 5
	)
)

(instance Garter of LBInvItem
	(properties
		view 80
		loop 1
		cursor 80
		message 28
		signal 2
		noun 12
	)
)

(instance Dinosaur_Bone of LBInvItem
	(properties
		name {Dinosaur Bone}
		view 65
		loop 1
		cursor 65
		message 29
		signal 2
		noun 10
	)
)

(instance Snake_Lasso of LBInvItem
	(properties
		name {Snake Lasso}
		view 62
		loop 1
		cursor 62
		message 30
		signal 2
		noun 32
	)
)

(instance Ankh_Medallion of LBInvItem
	(properties
		name {Ankh Medallion}
		view 73
		loop 1
		cursor 73
		message 31
		signal 2
		noun 23
	)
)

(instance Pippin_s_Notepad of LBInvItem
	(properties
		name {Pippin's Notepad}
		view 79
		loop 1
		cel 1
		cursor 79
		message 32
		signal 2
		noun 25
	)

	(method (doVerb theVerb)
		(switch theVerb
			(43 ; charcoal
				(gInventory hide:)
				(SetFlag 35)
				(self cel: 0 signal: 2)
				(gGame setScript: sRubPad)
			)
			(1 ; Look
				(= noun (if (IsFlag 35) 46 else 45))
				(super doVerb: theVerb)
			)
			(8 ; magnifier
				(= noun (if (IsFlag 35) 46 else 45))
				(super doVerb: theVerb)
			)
			(39 ; carbonPaper
				(gMessager say: 25 39 0 0 0 15) ; "Not enough of the carbon paper comes off on the notepad to make any difference."
			)
			(4 ; Do
				(gMessager say: 25 4 0 0 0 15) ; "It feels like good quality paper."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Magnifying_Glass of LBInvItem
	(properties
		name {Magnifying Glass}
		view 55
		loop 1
		cursor 55
		message 8
		signal 2
		noun 21
	)
)

(instance Light_Bulb of LBInvItem
	(properties
		name {Light Bulb}
		view 67
		loop 1
		cursor 67
		message 33
		signal 2
		noun 20
	)
)

(instance Watney_s_File of LBInvItem
	(properties
		name {Watney's File}
		view 72
		loop 1
		cursor 72
		message 34
		signal 2
		noun 37
	)
)

(instance Animal_Hairs of LBInvItem
	(properties
		name {Animal Hairs}
		view 82
		loop 1
		cursor 82
		message 35
		signal 2
		noun 35
	)
)

(instance Bifocals of LBInvItem
	(properties
		view 78
		loop 1
		cursor 78
		message 36
		signal 2
		noun 2
	)
)

(instance Red_Hair of LBInvItem
	(properties
		name {Red Hair}
		view 74
		loop 1
		cursor 74
		message 37
		signal 2
		noun 28
	)
)

(instance Water_Glass of LBInvItem
	(properties
		name {Water Glass}
		view 57
		loop 1
		cursor 57
		message 38
		signal 2
		noun 36
	)
)

(instance Carbon_Paper of LBInvItem
	(properties
		name {Carbon Paper}
		view 77
		loop 1
		cel 1
		cursor 77
		message 39
		signal 2
		noun 3
	)
)

(instance Yvette_s_Shoe of LBInvItem
	(properties
		name {Yvette's Shoe}
		view 85
		loop 1
		cursor 85
		message 40
		signal 2
		noun 41
	)
)

(instance Grapes of LBInvItem
	(properties
		view 81
		loop 1
		cursor 81
		message 41
		signal 2
		noun 13
	)
)

(instance Evening_Gown of LBInvItem
	(properties
		name {Evening Gown}
		view 60
		loop 1
		cursor 60
		message 42
		signal 2
		noun 11
	)
)

(instance Charcoal of LBInvItem
	(properties
		view 56
		loop 1
		cursor 56
		message 43
		signal 2
		noun 4
	)
)

(instance Wire of LBInvItem
	(properties
		view 66
		loop 1
		cursor 66
		message 44
		signal 2
		noun 39
	)
)

(instance Mummy of LBInvItem
	(properties
		view 87
		loop 1
		cursor 87
		message 9
		signal 2
		noun 42
	)
)

(instance sCrankLantern of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(lanternCrank
					init:
					posn: (- (gEgo x:) 10) (- (gEgo y:) 40)
					setCel: 0
					setLoop: 3
					setCycle: ForwardCounter 3 self
				)
			)
			(1
				(lanternCrank setLoop: 4 setCel: 0)
				(= ticks 120)
			)
			(2
				(lanternCrank dispose:)
				(Lantern cel: (- 1 (Lantern cel:)))
				(= temp0 (if (Lantern cel:) 88 else 84))
				(gTheIconBar
					curIcon: (gTheIconBar useIconItem:)
					curInvIcon: (Lantern cursor: temp0 yourself:)
					enable: (gTheIconBar at: 5)
				)
				(lanternTimer setReal: lanternTimer 0 3)
				((gTheIconBar curIcon:) cursor: temp0)
				(gGame handsOn: setCursor: ((gTheIconBar at: 5) cursor:))
				(gTheIconBar select: (gTheIconBar at: 5))
				(self dispose:)
			)
		)
	)
)

(instance lanternCrank of Prop
	(properties
		view 84
		loop 3
		priority 15
		signal 16
		cycleSpeed 12
	)
)

(instance sRubPad of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (Sound new:))
				(rubbingPad init: setLoop: 2 cel: 2)
				(= ticks 120)
			)
			(1
				(rubbingPad
					setLoop: 1
					cel: 0
					cycleSpeed: 6
					setCycle: OscRubPad 4 register self
				)
			)
			(2
				(rubbingPad setLoop: 2 cel: 4)
				(= ticks 60)
			)
			(3
				(gTheIconBar
					curIcon: (gTheIconBar useIconItem:)
					enable: (gTheIconBar at: 5)
				)
				(rubbingPad dispose:)
				(gGame handsOn:)
				(gEgo put: 33) ; charcoal
				(register dispose:)
				(self dispose:)
			)
		)
	)
)

(instance rubbingPad of Prop
	(properties
		x 130
		y 70
		view 563
		loop 1
		priority 15
		signal 16
	)
)

(instance lanternTimer of Timer
	(properties)

	(method (cue)
		(if (< gCurRoomNum 730)
			(Lantern cel: 0 cursor: 84)
			(if (== (gTheIconBar curInvIcon:) Lantern)
				((gTheIconBar useIconItem:) cursor: 84)
			)
			(if (== gTheCursor 88)
				(gGame setCursor: 84)
			)
		)
	)
)

(class OscRubPad of Osc
	(properties
		soundOsc 1
	)

	(method (init param1 param2 param3 param4)
		(if (>= argc 2)
			(= howManyCycles param2)
			(if (>= argc 3)
				(= soundOsc param3)
				(if (>= argc 4)
					(= caller param4)
				)
			)
		)
		(super init: param1 param2 param4)
	)

	(method (cycleDone)
		(soundOsc number: 51 play:)
		(super cycleDone:)
	)
)

