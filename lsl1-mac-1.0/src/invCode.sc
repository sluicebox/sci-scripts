;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 814)
(include sci.sh)
(use Main)
(use Interface)
(use BorderWindow)
(use IconBar)
(use Inventory)
(use System)

(public
	invCode 0
)

(instance invCode of Code
	(properties)

	(method (init &tmp i)
		(Inv
			init:
			add:
				wallet
				breathSpray
				watch
				apple
				ring
				whiskey
				remoteControl
				rose
				lubber
				candy
				discoPass
				pocketKnife
				wine
				magazine
				hammer
				pills
				ribbon
				graffiti
				invLook
				invHand
				invSelect
				invHelp
				ok
			eachElementDo: #highlightColor gColLBlue
			eachElementDo: #lowlightColor gColDBlue
			eachElementDo: #init
			window: invWin
			helpIconItem: invHelp
			selectIcon: invSelect
			okButton: ok
		)
		(watch owner: gEgo)
		(wallet owner: gEgo)
		(breathSpray owner: gEgo)
		(invWin
			color: 0
			back: gColWindow
			topBordColor: gColWindow
			lftBordColor: gColWindow
			rgtBordColor: gColWindow
			botBordColor: gColWindow
			insideColor: gColDBlue
			topBordColor2: gColMagenta
			lftBordColor2: gColMagenta
			botBordColor2: gColLMagenta
			rgtBordColor2: gColLMagenta
		)
	)
)

(instance invWin of InsetWindow
	(properties
		topBordHgt 28
		botBordHgt 5
	)

	(method (open)
		(invLook nsLeft: (- (/ (- (self right:) (self left:)) 2) 68))
		(super open:)
	)
)

(instance invLook of IconI
	(properties
		view 851
		loop 2
		cel 0
		nsTop 0
		cursor 101
		message 2
		signal 129
		helpStr {To look more closely at an object, first click here, then click on the item.}
	)

	(method (init)
		(self lowlightColor: gColLCyan)
		(super init:)
	)
)

(instance invHand of IconI
	(properties
		view 851
		loop 0
		cel 0
		cursor 102
		message 3
		helpStr {Use this when you want to do something to an item.}
	)

	(method (init)
		(self lowlightColor: gColLGreen)
		(super init:)
	)
)

(instance invSelect of IconI
	(properties
		view 851
		loop 4
		cel 0
		cursor 999
		helpStr {To use an item in the game, first click here, then click on the item, then click on OK.}
	)

	(method (init)
		(self lowlightColor: gColLMagenta)
		(super init:)
	)
)

(instance invHelp of IconI
	(properties
		view 851
		loop 1
		cel 0
		cursor 150
		message 6
		helpStr {This icon tells you about other icons.}
	)

	(method (init)
		(self lowlightColor: gColLRed)
		(super init:)
	)
)

(instance ok of IconI
	(properties
		view 851
		loop 3
		cel 0
		cursor 999
		signal 67
		helpStr {Click here to close this window and return to the game.}
	)

	(method (init)
		(self lowlightColor: gColLYellow)
		(super init:)
	)
)

(class LLinvItem of InvI
	(properties
		signal 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print
					(+ 850 (Inv indexOf: self))
					(Inv indexOf: self)
					#icon
					900
					loop
					cel
				)
				(UnLoad 131 (+ 850 (Inv indexOf: self)))
			)
			(3 ; Do
				(Printf 814 0 (self description:)) ; "You might try using %s on yourself."
			)
			(4 ; Inventory
				(if (!= (Inv indexOf: self) invItem)
					(Print (+ 850 invItem) (Inv indexOf: self)) ; ???
				else
					(Print 814 1) ; "Click the OK button to close this window."
				)
				(UnLoad 131 (+ 850 invItem)) ; ???
			)
		)
	)
)

(instance wallet of LLinvItem
	(properties
		view 900
		cursor 0
		description {your wallet}
	)

	(method (doVerb theVerb invItem &tmp choice [str 200])
		(switch theVerb
			(2 ; Look
				(if (or (== gCurRoomNum 250) (== gCurRoomNum 260))
					(Print 814 2) ; "Your wallet is mostly empty since you stuck all your money into this machine!"
				else
					(Print (Format @str 814 3 gLarryDollars) #icon view loop cel) ; "Your wallet contains some wrinkled business cards, lots of notes, some credit cards (which won't work in this game), and $%d.00 in cash."
				)
			)
			(3 ; Do
				(switch
					(Print ; "You reach in your wallet and grab the..."
						814
						4
						#icon
						view
						loop
						cel
						#button
						{Credit Cards}
						0
						#button
						{Business Cards}
						1
						#button
						{Notes}
						2
					)
					(0
						(Print 814 5) ; "What a shame! Not one single business in Lost Wages accepts credit cards from the First National Bank of Iraq."
					)
					(1
						(Print 814 6) ; "The only business card you have reads, "Sierra On-Line, Inc. (209) 683-8989""
					)
					(2
						(Print 814 7) ; "Remember to buy more Al Lowe games!"
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance breathSpray of LLinvItem
	(properties
		view 900
		cel 1
		cursor 1
		description {your breath spray}
	)
)

(instance watch of LLinvItem
	(properties
		view 900
		cel 2
		cursor 2
		description {your wrist watch}
	)

	(method (doVerb theVerb invItem &tmp [str 100])
		(switch theVerb
			(2 ; Look
				(Print
					(Format ; "Gee, a genuine BowlX! At least the time is accurate -- it's %02d:%02d."
						@str
						814
						8
						(>> gLarryTime $000c)
						(& (>> gLarryTime $0006) $003f)
					)
					#icon
					view
					loop
					cel
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance apple of LLinvItem
	(properties
		view 900
		loop 2
		cursor 3
		description {the apple}
		owner 300
	)
)

(instance ring of LLinvItem
	(properties
		view 900
		loop 2
		cel 1
		cursor 4
		description {the diamond ring}
		owner 130
	)
)

(instance whiskey of LLinvItem
	(properties
		view 900
		loop 2
		cel 2
		cursor 5
		description {your glass of whiskey}
		owner 110
	)
)

(instance remoteControl of LLinvItem
	(properties
		view 900
		loop 2
		cel 3
		cursor 6
		description {your remote control}
		owner 120
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 814 9) ; "You press the button on the remote control and..."
				(Print 814 10) ; "...nothing happens."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance rose of LLinvItem
	(properties
		view 900
		loop 2
		cel 4
		cursor 7
		description {the rose}
		owner 120
	)
)

(instance lubber of LLinvItem
	(properties
		view 900
		loop 2
		cel 5
		cursor 8
		description {your prophylactic}
		owner 510
	)
)

(instance candy of LLinvItem
	(properties
		view 900
		loop 2
		cel 6
		cursor 9
		description {the box of candy}
		owner 150
	)
)

(instance discoPass of LLinvItem
	(properties
		view 900
		loop 2
		cel 7
		cursor 10
		description {the disco pass}
		owner 330
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 814 11 #mode 1 #icon view loop cel) ; "The passcard reads: "Lost Wages Disco Admit One Member and Guest Remember: every Monday is Ladies Night!""
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance pocketKnife of LLinvItem
	(properties
		view 900
		loop 2
		cel 8
		cursor 11
		description {your pocketknife}
		owner 500
	)
)

(instance wine of LLinvItem
	(properties
		view 900
		loop 2
		cel 9
		cursor 12
		description {your wine}
		owner 510
	)
)

(instance magazine of LLinvItem
	(properties
		view 900
		loop 2
		cel 10
		cursor 13
		description {your magazine}
		owner 510
	)

	(method (doVerb theVerb invItem)
		(if (or (== theVerb 2) (== theVerb 3)) ; Look, Do
			(Print 814 12) ; "Well, well. It looks like this month's issue is filled with intelligent, literary articles laden with redeeming social value. For example, here's an article about how professional window washers secure themselves to the sides of tall buildings with a rope tied around their waist..."
			(Print 814 13) ; "Nah! Who wants to read that crap? You quickly flip through the pages until you discover..."
			(Points 85 1)
			(Print 814 14 #icon view loop 15) ; "Whoaaah! Nice centerfold this month!!"
		else
			(super doVerb: theVerb invItem)
		)
	)
)

(instance hammer of LLinvItem
	(properties
		view 900
		loop 2
		cel 11
		cursor 14
		description {Lefty's hammer}
		owner 160
	)
)

(instance pills of LLinvItem
	(properties
		view 900
		loop 2
		cel 12
		cursor 15
		description {the bottle of pills}
		owner 160
	)
)

(instance ribbon of LLinvItem
	(properties
		view 900
		loop 2
		cel 13
		cursor 16
		description {the ribbon}
		owner 390
	)
)

(instance graffiti of LLinvItem
	(properties
		view 900
		loop 2
		cel 14
		cursor 17
		description {the password}
		owner 130
	)
)

