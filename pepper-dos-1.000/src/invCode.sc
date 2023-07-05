;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 894)
(include sci.sh)
(use Main)
(use ScrollableInventory)
(use TwistyInsetWindow)
(use IconBar)
(use LoadMany)
(use Inventory)
(use User)
(use System)

(public
	invCode 0
	invWin 1
	inventoryCursor 2
)

(class TWInvItem of InvI
	(properties
		view 907
	)

	(method (init)
		(self
			highlightColor: global126
			lowlightColor: 5
			cursor: inventoryCursor
		)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(cond
			((and (!= modNum 894) (Message msgGET modNum noun theVerb 0 1 @temp0))
				(gMessager say: noun theVerb 0 1 0 modNum)
			)
			((and (!= modNum 894) (Message msgGET modNum noun 0 0 1 @temp0))
				(gMessager say: noun 0 0 1 modNum)
			)
			((Message msgGET 894 noun theVerb 0 1 @temp0)
				(gMessager say: noun theVerb 0 1 0 894)
			)
			((Message msgGET 894 noun 0 0 1 @temp0)
				(gMessager say: noun 0 0 1 0 894)
			)
			(else
				(gDoVerbCode doit: theVerb self)
			)
		)
	)

	(method (cue)
		(gInventory showSelf: gEgo)
	)
)

(instance inventoryCursor of Cursor
	(properties
		view 909
	)

	(method (init)
		(if
			(and
				(IsObject (gInventory curIcon:))
				((gInventory curIcon:) isKindOf: TWInvItem)
			)
			(self
				cel: ((gInventory curIcon:) cel:)
				loop: ((gInventory curIcon:) loop:)
			)
		)
		(super init: &rest)
	)
)

(instance twistyInv of ScrollableInventory
	(properties)

	(method (init)
		(invWin
			color: 5
			back: 59
			topBordColor: global123
			lftBordColor: global122
			rgtBordColor: global120
			botBordColor: global119
			insideColor: 5
			topBordColor2: global119
			lftBordColor2: global119
			botBordColor2: global123
			rgtBordColor2: global124
			botBordHgt: 25
		)
		(self
			window: invWin
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
		)
		(self
			add:
				Dog_Harness
				Herb_Cluster
				Herb_Packet
				Baby_Swaddling
				Pebbles
				Bag_of_Marbles
				A_Shilling
				Ima_s_Room_Key
				Fleas
				Package
				Doctrine
				Schematic
				Tomato
				Kite
				Ordinary_String
				Kite_String
				Metal_Rod
				Recipe_Card
				Glass_Jar
				Tin
				Stopper
				A_Brass_Key
				Wood_Cutting_a
				Back_Scratcher
				Tub_Fan
				Paddles
				Press_Lever
				StepStool
				King_s_Letter
				Puzzle_Box
				Love_Letters
				Carpet_Bag
				Special_Edition
				Magnet
				Stick
				Chocolate
				Bonbons
				Notepad
				Pencil
				Bag_Of_Money
				Bens_Key
				Glass
				outfitI
				Wood_Cutting_b
				Wood_Cutting_c
				invLook
				invHand
				invSelect
				invHelp
				invUp
				invDown
				ok
		)
		(self
			eachElementDo: #modNum 894
			eachElementDo: #init
			state: 2048
			upIcon: invUp
			downIcon: invDown
		)
	)

	(method (hide)
		((User curEvent:) claimed: 1)
		(super hide: &rest)
	)
)

(instance invCode of Code
	(properties)

	(method (init)
		((= gInventory twistyInv) init:)
	)
)

(instance invWin of TwistyInsetWindow
	(properties
		priority -1
		topBordHgt 28
		botBordHgt 5
	)

	(method (open)
		(if (== gEgo (ScriptID 895 0)) ; pepper
			(invLook loop: 2 cursor: 995)
			(invHand loop: 0 cursor: 992)
		else
			(invLook loop: 8 cursor: 998)
			(invHand loop: 7 cursor: 991)
		)
		(invLook nsLeft: (- (/ (- (self right:) (self left:)) 2) 98))
		(LoadMany rsVIEW 901 900 902 907)
		(super open: &rest)
	)
)

(instance ok of IconI
	(properties
		view 901
		loop 3
		cel 0
		cursor 999
		signal 67
		lowlightColor 36
		noun 23
		helpVerb 83
	)
)

(instance invLook of IconI
	(properties
		view 901
		loop 2
		cel 0
		cursor 995
		message 6
		signal 129
		lowlightColor 36
		noun 22
		helpVerb 83
	)
)

(instance invHand of IconI
	(properties
		view 901
		loop 0
		cel 0
		cursor 992
		message 7
		lowlightColor 36
		noun 20
		helpVerb 83
	)
)

(instance invHelp of IconI
	(properties
		view 901
		loop 1
		cel 0
		cursor 990
		message 83
		lowlightColor 36
		noun 21
		helpVerb 83
	)
)

(instance invSelect of IconI
	(properties
		view 901
		loop 4
		cel 0
		cursor 999
		lowlightColor 36
		noun 24
		helpVerb 83
	)
)

(instance invUp of IconI
	(properties
		view 901
		loop 5
		cel 0
		cursor 999
		maskView 901
		maskLoop 5
		maskCel 2
		lowlightColor 36
		noun 25
		modNum 894
		helpVerb 83
	)

	(method (select)
		(if (super select: &rest)
			(gInventory scroll: -1)
		)
		(return 0)
	)
)

(instance invDown of IconI
	(properties
		view 901
		loop 6
		cel 0
		cursor 999
		maskView 901
		maskLoop 6
		maskCel 2
		lowlightColor 36
		noun 19
		modNum 894
		helpVerb 83
	)

	(method (select)
		(if (super select: &rest)
			(gInventory scroll: 1)
		)
		(return 0)
	)
)

(instance Dog_Harness of TWInvItem
	(properties
		name {Dog Harness}
		cel 6
		message 17
		signal 2
		noun 11
	)
)

(instance Herb_Cluster of TWInvItem
	(properties
		name {Herb Cluster}
		loop 1
		cel 5
		message 23
		signal 2
		noun 62
	)
)

(instance Herb_Packet of TWInvItem
	(properties
		name {Herb Packet}
		loop 1
		cel 6
		message 24
		signal 2
		noun 50
	)
)

(instance Baby_Swaddling of TWInvItem
	(properties
		name {Baby Swaddling}
		loop 1
		cel 9
		signal 2
	)
)

(instance Pebbles of TWInvItem
	(properties
		loop 2
		message 96
		signal 2
		noun 52
	)
)

(instance Bag_of_Marbles of TWInvItem
	(properties
		name {Bag of Marbles}
		loop 2
		cel 1
		message 123
		signal 2
	)

	(method (doVerb theVerb)
		(if (IsFlag 13)
			(= noun 42)
		else
			(= noun 41)
		)
		(switch theVerb
			(7 ; Do
				(gGame points: 430 1)
				(gInventory hide:)
				(if (IsFlag 13)
					(ClearFlag 13)
					(gMessager say: 42 7 0 1 TWInvItem 894) ; "Pepper closes the bag of marbles."
					(self cel: 1)
				else
					(SetFlag 13)
					(gMessager say: 41 7 0 1 TWInvItem 894) ; "Pepper opens the bag. Hey, marbles!"
					(self cel: 2)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance A_Shilling of TWInvItem
	(properties
		name {A Shilling}
		loop 8
		cel 2
		message 111
		signal 2
		noun 63
	)
)

(instance Ima_s_Room_Key of TWInvItem
	(properties
		name {Ima's Room Key}
		loop 2
		cel 3
		message 32
		signal 2
		noun 18
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(if (== gEgo (ScriptID 895 0)) ; pepper
					(gMessager say: 18 7 0 0 0 894) ; "Pepper already has Ima's room key."
				else
					(gMessager say: 18 30 0 0 0 894) ; "Lockjaw already has Ima's room key."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Fleas of TWInvItem
	(properties
		loop 2
		cel 4
		message 34
		signal 2
		noun 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(if (== gEgo (ScriptID 895 0)) ; pepper
					(gMessager say: 17 7 0 0 0 894) ; MISSING MESSAGE
				else
					(gMessager say: 17 30 0 0 0 894) ; "Lockjaw already has the fleas. They go everywhere with him."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Package of TWInvItem
	(properties
		loop 3
		message 36
		signal 2
		noun 3
	)

	(method (doVerb theVerb &tmp temp0 temp1 temp2 temp3)
		(switch theVerb
			(6 ; Look
				(if (IsFlag 140)
					(gGame points: 440 1)
					(gMessager say: (self noun:) 6 0 0 0 894)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(7 ; Do
				(gInventory hide:)
				(if (not (IsFlag 141))
					(= temp3 1)
				else
					(cond
						((not (IsFlag 8))
							(SetFlag 8)
							(= temp3 2)
							(= temp0 2)
							(= temp1 37)
							(= temp2 5)
							(gGame points: 429 1)
						)
						((not (IsFlag 140))
							(SetFlag 140)
							(= temp0 1)
							(= temp3 3)
							(= temp1 38)
							(= temp2 6)
							(gGame points: 439 1)
						)
						(else
							(ClearFlag 140)
							(= temp0 2)
							(= temp1 37)
							(= temp2 5)
						)
					)
					(gInventory curIcon: self)
					(self cel: temp0 message: temp1 noun: temp2)
					(inventoryCursor init:)
				)
				(switch temp3
					(1
						(gMessager say: 3 7 2 1 TWInvItem 894) ; "Pepper would never DREAM of opening someone else's mail without permission. That's a FELONY!"
					)
					(2
						(gMessager say: 3 7 1 1 TWInvItem 894) ; "Pepper opens the package. There's an electricity book inside."
					)
					(else
						(gInventory showSelf: gEgo)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Doctrine of TWInvItem
	(properties
		loop 3
		cel 3
		message 39
		signal 2
		noun 43
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: (self noun:) 6 0 0 0 894)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Schematic of TWInvItem
	(properties
		loop 3
		cel 4
		message 40
		signal 2
		noun 61
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gGame points: 438 1)
				(gMessager say: (self noun:) 6 0 0 0 894)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Tomato of TWInvItem
	(properties
		loop 3
		cel 5
		message 41
		signal 2
		noun 70
	)
)

(instance Kite of TWInvItem
	(properties
		loop 3
		cel 8
		message 44
		signal 2
		noun 35
	)
)

(instance Ordinary_String of TWInvItem
	(properties
		name {Ordinary String}
		loop 3
		cel 9
		message 45
		signal 2
		noun 49
	)
)

(instance Kite_String of TWInvItem
	(properties
		name {Kite String}
		loop 4
		message 46
		signal 2
		noun 36
	)
)

(instance Recipe_Card of TWInvItem
	(properties
		name {Recipe Card}
		loop 4
		cel 2
		message 48
		signal 2
		noun 59
	)
)

(instance Tin of TWInvItem
	(properties
		loop 4
		cel 8
		message 50
		signal 2
		noun 69
	)

	(method (doVerb theVerb)
		(switch theVerb
			((OneOf theVerb 97 49) ; ???, Glass_Jar [empty]
				(gInventory hide:)
				(gMessager say: noun theVerb 0 1 TWInvItem 894)
				(gEgo put: 19 gCurRoomNum) ; Tin
				(gInventory curIcon: Glass_Jar)
				(SetFlag 25)
				(Glass_Jar cel: 5 message: 53 noun: 33)
				(inventoryCursor init:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Stopper of TWInvItem
	(properties
		loop 4
		cel 9
		message 51
		signal 2
		noun 68
	)

	(method (doVerb theVerb)
		(switch theVerb
			(144 ; Glass_Jar [tin+water]
				(gInventory hide:)
				(gMessager say: noun theVerb 0 1 TWInvItem 894) ; "Pepper adds the stopper to the Leyden jar. A perfect fit!"
				(gEgo put: 20 gCurRoomNum) ; Stopper
				(gInventory curIcon: Glass_Jar)
				(SetFlag 26)
				(Glass_Jar cel: 10 message: 144 noun: 32)
				(inventoryCursor init:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance A_Brass_Key of TWInvItem
	(properties
		name {A Brass Key}
		loop 5
		message 56
		signal 2
		noun 60
	)
)

(instance Back_Scratcher of TWInvItem
	(properties
		name {Back Scratcher}
		loop 5
		cel 2
		message 60
		signal 2
		noun 1
	)
)

(instance Tub_Fan of TWInvItem
	(properties
		name {Tub Fan}
		loop 5
		cel 3
		message 108
		signal 2
		noun 72
	)
)

(instance Paddles of TWInvItem
	(properties
		loop 5
		cel 4
		message 61
		signal 2
		noun 51
	)
)

(instance Press_Lever of TWInvItem
	(properties
		name {Press Lever}
		loop 5
		cel 5
		message 62
		signal 2
		noun 38
	)
)

(instance StepStool of TWInvItem
	(properties
		loop 5
		cel 6
		message 63
		signal 2
		noun 66
	)
)

(instance King_s_Letter of TWInvItem
	(properties
		name {King's Letter}
		loop 5
		cel 7
		message 64
		signal 2
		noun 34
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(if (== gEgo (ScriptID 895 0)) ; pepper
					(gMessager say: 34 7 0 0 0 894) ; "Pepper already has the king's letter."
				else
					(gMessager say: 34 30 0 0 0 894) ; "Lockjaw already has the king's letter."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Puzzle_Box of TWInvItem
	(properties
		name {Puzzle Box}
		loop 5
		cel 8
		message 65
		signal 2
		noun 58
	)

	(method (cue)
		(gInventory hide:)
		(gCurRoom newRoom: 116)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(if (IsFlag 98)
					(gMessager say: 58 7 11 1 0 894) ; "Pepper already solved the puzzle box. She doesn't need to do it again."
				else
					(gGame handsOff:)
					(gMessager say: 58 7 0 1 self 894) ; "Pepper decides to try her hand at solving the puzzle box."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Love_Letters of TWInvItem
	(properties
		name {Love Letters}
		loop 5
		cel 9
		message 67
		signal 2
		noun 39
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gGame points: 435 1)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Carpet_Bag of TWInvItem
	(properties
		name {Carpet Bag}
		loop 6
		signal 2
	)

	(method (doVerb theVerb)
		(if (IsFlag 14)
			(= noun 8)
			(= message 69)
		else
			(= noun 7)
			(= message 68)
		)
		(switch theVerb
			(7 ; Do
				(gGame points: 436 1)
				(gInventory hide:)
				(if (IsFlag 14)
					(gMessager say: noun 7 0 1 TWInvItem 894)
					(ClearFlag 14)
					(self cel: 0)
				else
					(gMessager say: noun 7 0 1 TWInvItem 894)
					(SetFlag 14)
					(self cel: 1)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance Special_Edition of TWInvItem
	(properties
		name {Special Edition}
		loop 6
		cel 2
		message 70
		signal 2
		noun 64
	)
)

(instance Magnet of TWInvItem
	(properties
		loop 6
		cel 3
		message 71
		signal 2
		noun 40
	)
)

(instance Stick of TWInvItem
	(properties
		loop 6
		cel 5
		message 73
		signal 2
		noun 67
	)
)

(instance Chocolate of TWInvItem
	(properties
		loop 6
		cel 7
		message 74
		signal 2
		noun 9
	)
)

(instance Bonbons of TWInvItem
	(properties
		loop 6
		cel 6
		message 75
		signal 2
		noun 4
	)
)

(instance Bag_Of_Money of TWInvItem
	(properties
		name {Bag Of Money}
		loop 7
		cel 1
		message 79
		signal 2
		noun 45
	)
)

(instance Bens_Key of TWInvItem
	(properties
		name {Bens Key}
		loop 8
		cel 3
		message 124
		signal 2
		noun 2
	)
)

(instance Glass of TWInvItem
	(properties
		loop 7
		cel 2
		message 80
		signal 2
	)
)

(instance outfitI of TWInvItem
	(properties
		loop 7
		cel 5
		message 114
		noun 13
	)

	(method (show &tmp temp0)
		(= temp0 0)
		(if (IsFlag 80)
			(+= temp0 1)
		)
		(if (IsFlag 82)
			(+= temp0 2)
		)
		(if (IsFlag 81)
			(+= temp0 4)
		)
		(switch temp0
			(1
				(self cel: 3 message: 114 noun: 13)
			)
			(2
				(self cel: 2 message: 81 noun: 37)
			)
			(3
				(self cel: 6 message: 147 noun: 12)
			)
			(4
				(self cel: 4 message: 82 noun: 46)
			)
			(5
				(self cel: 5 message: 148 noun: 14)
			)
			(6
				(self cel: 7 message: 149 noun: 16)
			)
			(7
				(self cel: 8 message: 122 noun: 10)
			)
			(else
				(self cel: 8 message: 122 noun: 10)
			)
		)
		(super show: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gMessager say: noun 7 0 0 0 894) ; "Pepper already has the dress. She'd rather not touch it any more than she has to."
			)
			(6 ; Look
				(gMessager say: noun 6 0 0 0 894) ; "It's Ima's fancy dress."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Glass_Jar of TWInvItem
	(properties
		name {Glass Jar}
		loop 4
		cel 3
		message 52
		signal 2
		noun 26
	)

	(method (show)
		(if (IsFlag 23)
			(self cel: 4 message: 49 noun: 28)
		)
		(if (IsFlag 25)
			(self cel: 5 message: 53 noun: 33)
		)
		(if (and (IsFlag 25) (IsFlag 142))
			(self cel: 11 message: 144 noun: 32)
		)
		(if (IsFlag 26)
			(self cel: 10 message: 145 noun: 31)
		)
		(if (IsFlag 28)
			(self cel: 6 message: 54 noun: 29)
		)
		(if (IsFlag 144)
			(self cel: 7 message: 55 noun: 27)
		)
		(super show: &rest)
	)

	(method (doVerb theVerb &tmp [temp0 1200])
		(switch theVerb
			(50 ; Tin
				(if (IsFlag 23)
					(gGame points: 431 1)
					(gInventory hide:)
					(gMessager say: noun theVerb 0 1 TWInvItem 894) ; "Pepper has to get rid of the cabbage before she can put the tin in the jar."
					(gEgo put: 19 gCurRoomNum) ; Tin
					(gInventory curIcon: self)
					(SetFlag 25)
					(self cel: 5 message: 53 noun: 33)
					(inventoryCursor init:)
				else
					(= noun 26)
					(super doVerb: theVerb &rest)
				)
			)
			(51 ; Stopper
				(cond
					((and (IsFlag 25) (IsFlag 142))
						(gGame points: 432 1)
						(gInventory hide:)
						(gMessager say: noun theVerb 0 1 TWInvItem 894) ; "Pepper has to get rid of the cabbage before she can put the stopper in the jar."
						(gEgo put: 20 gCurRoomNum) ; Stopper
						(gInventory curIcon: self)
						(SetFlag 26)
						(self cel: 10 message: 144 noun: 32)
						(inventoryCursor init:)
					)
					((IsFlag 25)
						(= noun 33)
						(super doVerb: theVerb &rest)
					)
					((IsFlag 23)
						(= noun 28)
						(super doVerb: theVerb &rest)
					)
					(else
						(= noun 26)
						(super doVerb: theVerb &rest)
					)
				)
			)
			(47 ; Metal_Rod
				(cond
					((and (IsFlag 25) (IsFlag 142) (IsFlag 26))
						(gInventory hide:)
						(gGame points: 433 1)
						(= noun 31)
						(gMessager say: noun theVerb 0 1 TWInvItem 894) ; "Pepper has to get rid of the cabbage before she can put the iron rod in the jar."
						(gEgo put: 16 gCurRoomNum) ; Metal_Rod
						(gInventory curIcon: self)
						(SetFlag 28)
						(self cel: 6 message: 54 noun: 29)
						(inventoryCursor init:)
					)
					((and (IsFlag 25) (not (IsFlag 142)) (not (IsFlag 26)))
						(= noun 33)
						(super doVerb: theVerb &rest)
					)
					((and (IsFlag 25) (IsFlag 142) (not (IsFlag 26)))
						(= noun 32)
						(super doVerb: theVerb &rest)
					)
					((IsFlag 23)
						(= noun 28)
						(super doVerb: theVerb &rest)
					)
					(else
						(= noun 26)
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(if (not (Message msgGET 894 noun theVerb 0 1 @temp0))
					(= noun 30)
					(= message 125)
				)
				(super doVerb: theVerb &rest)
				(if (OneOf theVerb 50 51 47) ; Tin, Stopper, Metal_Rod
					(gInventory showSelf: gEgo)
				)
			)
		)
	)
)

(instance Metal_Rod of TWInvItem
	(properties
		name {Metal Rod}
		loop 4
		cel 1
		message 47
		signal 2
		noun 44
	)

	(method (doVerb theVerb)
		(switch theVerb
			(145 ; Glass_Jar [tin+water+stopper]
				(gInventory hide:)
				(gMessager say: noun theVerb 0 1 TWInvItem 894) ; "Pepper puts the iron rod through the center of the stopper. The Leyden jar is done!"
				(gEgo put: 16 gCurRoomNum) ; Metal_Rod
				(gInventory curIcon: Glass_Jar)
				(SetFlag 28)
				(Glass_Jar cel: 6 message: 54 noun: 29)
				(inventoryCursor init:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Notepad of TWInvItem
	(properties
		loop 8
		message 76
		signal 2
	)

	(method (doVerb theVerb)
		(if (IsFlag 15)
			(= noun 48)
			(= message 110)
		else
			(= noun 47)
			(= message 109)
		)
		(switch theVerb
			(78 ; Pencil
				(if (not (IsFlag 15))
					(SetFlag 15)
					(gGame points: 437 2)
					(gInventory hide:)
					(self cel: 1)
					(gMessager say: noun 78 0 0 self 894)
				else
					(gMessager say: noun 0 0 0 0 894)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Pencil of TWInvItem
	(properties
		loop 7
		message 78
		signal 2
		noun 53
	)

	(method (doVerb theVerb)
		(switch theVerb
			(76 ; Notepad
				(if (not (IsFlag 15))
					(SetFlag 15)
					(gInventory hide:)
					(Notepad cel: 1)
					(gMessager say: noun 76 0 0 self 894) ; "Pepper runs the pencil lightly over the notepad. Hey, some numbers are appearing!"
				else
					(gMessager say: noun 0 0 0 0 894) ; "That won't do much for the pencils."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Wood_Cutting_a of TWInvItem
	(properties
		name {Wood Cutting}
		loop 5
		cel 1
		message 95
		signal 2
		noun 55
	)

	(method (show)
		(cond
			((IsFlag 88)
				(self message: 139)
			)
			((IsFlag 87)
				(self message: 141)
			)
			(else
				(self message: 135)
			)
		)
		(super show: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gInventory hide:)
				(cond
					((IsFlag 88)
						(gMessager say: 55 6 4 0 self 894) ; "This proverb says: "Tart words make no Friends: A spoonful of honey will catch more flies than a Gallon of Vinegar."  In other words: "Don't say mean things to people. They'll like you better if you're nice.""
					)
					((IsFlag 87)
						(gMessager say: 55 6 3 0 self 894) ; "This proverb says: "Early to Bed and early to rise, makes a man healthy, wealthy and wise."  In other words: "You'll do well if you work hard and don't party too much!""
					)
					(else
						(gMessager say: 55 6 5 0 self 894) ; "This proverb says: "Quarrels never could last long, if on one side only lay the wrong."  In other words, "Stop quarreling over silly things that don't matter. You're probably BOTH wrong!""
					)
				)
			)
			(7 ; Do
				(gInventory hide:)
				(gMessager say: 54 7 0 0 self 894) ; "Pepper already has the proverb."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Wood_Cutting_b of TWInvItem
	(properties
		name {Wood Cutting}
		loop 5
		cel 1
		message 95
		signal 2
		noun 57
	)

	(method (show)
		(cond
			((IsFlag 88)
				(self message: 136)
			)
			((IsFlag 87)
				(self message: 140)
			)
			(else
				(self message: 137)
			)
		)
		(super show: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gInventory hide:)
				(cond
					((IsFlag 88)
						(gMessager say: 57 6 8 0 self 894) ; "This proverb says: "Avoid dishonest gain: No price can recompense the pangs of Vice."  In other words: "Don't cheat people out of their money. You'll regret it if you do.""
					)
					((IsFlag 87)
						(gMessager say: 57 6 10 0 self 894) ; "This proverb says: "Beware the Gossip who speaks ill of thy neighbors. With thy neighbors she likely speaks ill of thee."  In other words: "If somebody tells you gossip about someone else, you can BET they're spreading gossip about you, too!""
					)
					(else
						(gMessager say: 57 6 9 0 self 894) ; "This proverb says: "Eat few Suppers, and you'll need few Medicines."  In other words: "Don't pig out! You'll make yourself sick!""
					)
				)
			)
			(7 ; Do
				(Wood_Cutting_a doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Wood_Cutting_c of TWInvItem
	(properties
		name {Wood Cutting}
		loop 5
		cel 1
		message 95
		signal 2
		noun 56
	)

	(method (show)
		(if (IsFlag 87)
			(self message: 138)
		else
			(self message: 143)
		)
		(super show: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gInventory hide:)
				(if (IsFlag 87)
					(gMessager say: 56 6 6 0 self 894) ; "This proverb says: "Wealth is not his who has it, but his who enjoys it."  In other words: "Don't waste your money, but DO have fun with it! Don't be cheap!""
				else
					(gMessager say: 56 6 7 0 self 894) ; "This proverb says: "All things are easy to Industry, all things difficult to Sloth."  In other words: "Don't be lazy! Life will be a lot more fun if you get off your tail and DO something!""
				)
			)
			(7 ; Do
				(Wood_Cutting_a doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

