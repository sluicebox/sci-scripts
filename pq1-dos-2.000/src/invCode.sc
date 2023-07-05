;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 894)
(include sci.sh)
(use Main)
(use Print)
(use BorderWindow)
(use IconBar)
(use Inventory)
(use System)

(public
	invCode 0
	invWin 1
)

(local
	local0
	local1
	local2
)

(class PQIconItem of IconI
	(properties)

	(method (ownedBy)
		(return 0)
	)
)

(class PQInvItem of InvI
	(properties)

	(method (init)
		(self cursor: inventoryCursor)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(cond
			((== theVerb 1) ; Look
				(= global252 (inventoryCursor cel:))
				(= global253 (inventoryCursor loop:))
				(if (Message msgSIZE 894 noun 1 0 1)
					(= temp0 (CelWide view loop cel))
					(Print
						title: name
						addIcon: view loop cel 0 0
						addText: noun 1 0 1 (+ temp0 4) 0 894
						init:
					)
				else
					(Print title: name addIcon: view loop cel 0 0 init:)
				)
			)
			(
				(or
					(and (== theVerb 9) (== noun 5)) ; Service_Revolver
					(and (== noun 2) (== theVerb 13)) ; Bullets
				)
				(Print x: -1 y: -1 addText: 5 9 0 1 0 0 894 init:) ; "Always ready for action you quickly make sure your piece is loaded. You also make sure your gun is loaded."
			)
			(else
				(Print
					x: -1
					y: -1
					addText:
						0
						53
						0
						(+ (= global223 (mod (++ global223) 3)) 1)
						0
						0
						0
					init:
				)
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
				Service_Revolver
				Pen
				Extender
				Patrol_Car_Keys
				Bullets
				Ticket_Book
				Night_Stick
				Undercover_money
				Ticket
				Handcuffs
				Camaro_Keys
				Undercover_Car_Keys
				No_Bail_Warrant
				Hoffman_File
				Disguise
				Hair_Dye
				Wanted_Poster
				Hoffman_s_License
				Hotel_Room_Key
				Deluxe_Transmitter_Pen
				invLook
				invHand
				invSelect
				invHelp
				ok
			eachElementDo: #highlightColor global126
			eachElementDo: #lowlightColor global130
			eachElementDo: #init
			state: 2048
			window: invWin
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
		)
	)
)

(instance invWin of InsetWindow
	(properties
		priority -1
		topBordHgt 28
		botBordHgt 5
	)

	(method (open)
		(invLook nsLeft: (- (/ (- (self right:) (self left:)) 2) 68))
		(super open:)
	)
)

(instance ok of PQIconItem
	(properties
		view 901
		loop 3
		cel 0
		cursor 999
		signal 67
		noun 24
		modNum 894
		helpVerb 36
	)

	(method (init)
		(= highlightColor global126)
		(= lowlightColor global123)
		(super init:)
	)
)

(instance invLook of PQIconItem
	(properties
		view 901
		loop 2
		cel 0
		cursor 608
		message 1
		signal 129
		noun 25
		modNum 894
		helpVerb 36
	)

	(method (init)
		(= highlightColor global126)
		(= lowlightColor global123)
		(super init:)
	)
)

(instance invHand of PQIconItem
	(properties
		view 901
		loop 0
		cel 0
		cursor 609
		message 4
		noun 26
		modNum 894
		helpVerb 36
	)

	(method (init)
		(= highlightColor global126)
		(= lowlightColor global123)
		(super init:)
	)
)

(instance invHelp of PQIconItem
	(properties
		view 901
		loop 1
		cel 0
		cursor 610
		message 8
		noun 27
		modNum 894
		helpVerb 36
	)

	(method (init)
		(= highlightColor global126)
		(= lowlightColor global123)
		(super init:)
	)
)

(instance invSelect of PQIconItem
	(properties
		view 901
		loop 4
		cel 0
		cursor 999
		noun 28
		modNum 894
		helpVerb 36
	)

	(method (init)
		(= highlightColor global126)
		(= lowlightColor global123)
		(super init:)
	)
)

(instance Service_Revolver of PQInvItem
	(properties
		name {Service Revolver}
		view 25
		loop 1
		cel 4
		cursor 611
		message 9
		signal 2
		noun 2
		modNum 894
		owner 14
	)
)

(instance Pen of PQInvItem
	(properties
		view 25
		loop 3
		cel 5
		cursor 611
		message 10
		signal 2
		noun 1
		modNum 894
		owner 14
	)
)

(instance Extender of PQInvItem
	(properties
		view 25
		loop 1
		cel 3
		cursor 611
		message 11
		signal 2
		noun 3
		modNum 894
		owner 13
	)
)

(instance Patrol_Car_Keys of PQInvItem
	(properties
		name {Patrol Car Keys}
		view 25
		loop 1
		cel 14
		cursor 611
		message 12
		signal 2
		noun 4
		modNum 894
		owner 13
	)
)

(instance Bullets of PQInvItem
	(properties
		view 25
		loop 1
		cel 11
		cursor 611
		message 13
		signal 2
		noun 5
		modNum 894
		owner 14
	)
)

(instance Ticket_Book of PQInvItem
	(properties
		name {Ticket Book}
		view 25
		loop 1
		cel 1
		cursor 611
		message 14
		signal 2
		noun 6
		modNum 894
		owner 14
	)

	(method (doVerb theVerb &tmp [temp0 20])
		(switch theVerb
			(10 ; Pen
				(switch gCurRoomNum
					(41
						(cond
							((not (IsFlag 43))
								(= local0 6)
								(= local1 10)
								(= local2 5)
								(gGame setScript: printIt)
							)
							((or (== ((Inv at: 8) owner:) 41) (gEgo has: 8)) ; Ticket, Ticket
								(= local0 6)
								(= local1 10)
								(= local2 2)
								(gGame setScript: printIt)
							)
							(else
								(= local0 6)
								(= local1 10)
								(= local2 3)
								(gEgo get: 8) ; Ticket
								(gGame setScript: printIt)
							)
						)
					)
					(42
						(= local0 6)
						(= local1 10)
						(= local2 4)
						(gEgo get: 8) ; Ticket
						(gGame setScript: printIt)
						(return 0)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Night_Stick of PQInvItem
	(properties
		name {Night Stick}
		view 25
		loop 1
		cel 2
		cursor 611
		message 16
		signal 2
		noun 8
		modNum 894
	)
)

(instance Undercover_money of PQInvItem
	(properties
		name {Undercover money}
		view 25
		loop 3
		cel 1
		cursor 611
		message 17
		signal 2
		noun 9
		modNum 894
	)
)

(instance Hoffman_s_License of PQInvItem
	(properties
		name {Hoffman's License}
		view 25
		loop 3
		cel 10
		cursor 611
		message 18
		signal 2
		noun 10
		modNum 894
	)

	(method (doVerb theVerb)
		(if (== gCurRoomNum 41)
			(= name {Tawnee Helmut's Drivers License})
			(= noun 10)
		else
			(= name {Bill Barnum's Drivers License})
			(= noun 16)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance Ticket of PQInvItem
	(properties
		view 25
		loop 3
		cel 3
		cursor 611
		message 19
		signal 2
		noun 11
		modNum 894
	)
)

(instance Handcuffs of PQInvItem
	(properties
		view 25
		loop 1
		cel 5
		cursor 611
		message 21
		signal 2
		noun 13
		modNum 894
		owner 14
	)
)

(instance Camaro_Keys of PQInvItem
	(properties
		name {Camaro Keys}
		view 25
		loop 1
		cel 12
		cursor 611
		message 22
		signal 2
		noun 14
		modNum 894
	)
)

(instance Undercover_Car_Keys of PQInvItem
	(properties
		name {Undercover Car Keys}
		view 25
		loop 1
		cel 13
		cursor 611
		message 23
		signal 2
		noun 22
		modNum 894
		owner 13
	)
)

(instance No_Bail_Warrant of PQInvItem
	(properties
		name {No Bail Warrant}
		view 25
		loop 1
		cel 10
		cursor 611
		message 26
		signal 2
		noun 17
	)
)

(instance Hoffman_File of PQInvItem
	(properties
		name {Hoffman File}
		view 25
		loop 1
		cel 15
		cursor 611
		message 27
		signal 2
		noun 18
		modNum 894
	)
)

(instance Disguise of PQInvItem
	(properties
		view 25
		loop 1
		cel 9
		cursor 611
		message 28
		signal 2
		noun 19
		modNum 894
	)
)

(instance Hair_Dye of PQInvItem
	(properties
		name {Hair Dye}
		view 25
		loop 1
		cel 7
		cursor 611
		message 29
		signal 2
		noun 20
		modNum 894
	)
)

(instance Wanted_Poster of PQInvItem
	(properties
		name {Wanted Poster}
		view 25
		loop 3
		cel 6
		cursor 611
		message 51
		signal 2
		noun 30
		modNum 894
	)
)

(instance Hotel_Room_Key of PQInvItem
	(properties
		name {Hotel Room Key}
		view 25
		loop 3
		cel 7
		cursor 611
		message 54
		signal 2
		noun 15
		modNum 894
	)
)

(instance Deluxe_Transmitter_Pen of PQInvItem
	(properties
		name {Deluxe Transmitter Pen}
		view 25
		loop 3
		cel 8
		cursor 611
		message 49
		signal 2
		noun 31
		modNum 894
	)
)

(instance printIt of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(HandsOff)
				(Inv hide:)
				(= ticks 5)
			)
			(1
				(gMessager say: local0 local1 local2 0 self 894)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance inventoryCursor of Cursor
	(properties
		view 25
		loop 1
	)

	(method (init)
		(if (IsObject (gInventory curIcon:))
			(self
				cel: ((gInventory curIcon:) cel:)
				loop: (+ ((gInventory curIcon:) loop:) 1)
			)
			(if (not cel)
				(self cel: global252 loop: global253)
			)
		)
		(super init: &rest)
	)
)

