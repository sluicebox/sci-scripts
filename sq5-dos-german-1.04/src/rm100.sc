;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use Interface)
(use Print)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm100 0
)

(local
	[local0 2]
)

(instance myDialog of Dialog
	(properties)

	(method (handleEvent)
		(Palette palANIMATE 96 218 -1)
		(super handleEvent: &rest)
	)
)

(instance rm100 of Rm
	(properties
		picture 300
	)

	(method (init)
		(Palette palSET_FROM_RESOURCE 999 2)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(gGame setCursor: 996 1)
		(gTheIconBar hide: disable:)
		(gUser canInput: 1)
		(self setScript: rmScript)
	)

	(method (dispose)
		(gTheIconBar hide: enable:)
		(= gNormalCursor 999)
		(Palette palSET_FROM_RESOURCE 999 2)
		(gGame setCursor: 996 1)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (and (!= (rmScript state:) 4) (& (event type:) $4005)) ; evVERB | evMOUSEKEYBOARD
			(rmScript changeState: 4)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
		)
	)
)

(instance rmScript of Script
	(properties)

	(method (doit)
		(Palette palANIMATE 96 218 -1)
		(super doit: &rest)
	)

	(method (changeState newState &tmp temp0 [temp1 10])
		(switch (= state newState)
			(0
				(gSq5Music1 number: 1001 loop: 1 play:)
				(sparkle init:)
				(= seconds 4)
			)
			(1
				(if (== (gSq5Music1 prevSignal:) 20)
					(sparkle setCycle: End self)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(2
				(if (== (gSq5Music1 prevSignal:) 30)
					(sparkle x: 60 y: 145 loop: 1 cel: 0 setCycle: End self)
				else
					(-- state)
					(= cycles 1)
				)
			)
			(3
				(= seconds 3)
			)
			(4
				(gSq5Music1 stop:)
				(sparkle hide:)
				(= cycles 5)
			)
			(5
				(sparkle dispose:)
				(= seconds 0)
				(= gNormalCursor 999)
				(gGame setCursor: 999 1)
				(Print
					dialog: myDialog
					font: gUserFont
					width: 150
					mode: 1
					addText: 8 1 0 4 0 0 0 ; "|f5|Space Quest 5:"
					addText: 8 1 0 5 0 10 0 ; "|f5|The Next Mutation"
					addColorButton: 0 8 1 0 6 0 30 0 0 15 23 5 5 5 ; "See Introduction"
					addColorButton: 1 8 1 0 1 0 40 0 0 15 23 5 5 5 ; "Play New Game"
					addColorButton: 2 8 1 0 2 0 50 0 0 15 23 5 5 5 ; "Restore Old Game"
				)
				(switch
					(= temp0
						(Print
							addColorButton: 4 8 1 0 7 0 60 0 0 15 23 5 5 5 ; "Read Technobabble"
							addColorButton: 3 8 1 0 3 0 70 0 0 15 23 5 5 5 ; "Quit"
							init:
						)
					)
					(0
						(gCurRoom newRoom: 104)
					)
					(1
						(gCurRoom newRoom: 110)
					)
					(2
						(gGame restore:)
						(self changeState: state)
					)
					(3
						(= gQuit 1)
					)
					(4
						(-= state 2)
						(gMessager say: 1 0 0 0 self 100) ; "|c5|Sales Order Information|c|  To place a domestic order with Sierra On-Line, call (800) 326-6654 from 7:00 a.m. through 7:00 p.m. Pacific Time, Monday through Friday, for convenient, person-to-person service; or if you prefer, you may place your order via Fax (209) 683-4297 (Please include your name, address, phone number, credit card number and expiration date)."
					)
					(5
						(= temp1 0)
						(= temp0
							(Print
								addText: {Which room do you want?}
								addText: {Other} 110 25
								addEdit: @temp1 6 115 35
								posn: 50 30
								addButton: 100 {Start 100} 5 35
								init:
							)
						)
						(if temp1
							(= temp0 (ReadNumber @temp1))
							(gCurRoom newRoom: temp0)
						else
							(self changeState: state)
						)
					)
				)
			)
		)
	)
)

(instance sparkle of Prop
	(properties
		x 121
		y 54
		view 3001
		priority 15
		signal 16
	)
)

