;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use domino1)
(use checkers)
(use Interface)
(use dummyPublic0)
(use pachisi)
(use yacht)
(use snakes)
(use IconBar)
(use System)

(public
	gameControlIcon 0
	optionsIcon 1
	scoreIcon 2
	rulesIcon 3
	helpIcon 4
	setHelpStrings 5
)

(local
	[local0 150]
	[local150 50]
	[local200 50]
	[local250 95]
	[local345 110]
)

(instance setHelpStrings of Code
	(properties)

	(method (doit)
		(gameControlIcon helpStr: (Format @local0 99 0)) ; "This icon is for the Game Control Panel. It will let you Select a new game , Quit, Replay the current game, Set text speed, Adjust the Volume, and tell you who made Hoyle 3 what it is today."
		(optionsIcon helpStr: (Format @local150 99 1)) ; "This icon is for setting options of the individual games."
		(scoreIcon helpStr: (Format @local200 99 2)) ; "This icon reports the current score of the current game."
		(rulesIcon helpStr: (Format @local250 99 3)) ; "This icon has the rules for each game. To read the rules of a particular game, go to that game first and then choose this Icon."
		(helpIcon helpStr: (Format @local345 99 4)) ; "This icon is the help icon. By choosing this icon and pointing the special cursor on another icon, you will get a description of what the icon is for."
	)
)

(instance gameControlIcon of IconI
	(properties
		view 700
		loop 0
		cel 0
		cursor 999
		signal 451
		highlightColor -1
	)

	(method (highlight)
		(return 1)
	)

	(method (select &tmp temp0)
		(if (= temp0 (super select: &rest))
			(gTheIconBar hide:)
			(gGameControls show:)
		)
		(return temp0)
	)
)

(instance optionsIcon of IconI
	(properties
		view 700
		loop 1
		cel 0
		cursor 999
		signal 195
		highlightColor -1
	)

	(method (select &tmp temp0 temp1 temp2)
		(if (= temp0 (super select: &rest))
			(gTheIconBar hide:)
			(switch gCurRoomNum
				(100 ; domino1
					(= temp2 110)
				)
				(200 ; checkers
					(= temp2 210)
				)
				(300 ; backgam
					(= temp2 310)
				)
				(400 ; pachisi
					(= temp2 410)
				)
				(500 ; yacht
					(= temp2 510)
				)
				(600 ; snakes
					(= temp2 653)
				)
				(else
					(= temp2 0)
				)
			)
			(if temp2
				(gGameControls hide:)
				(= temp1 (gSystemWindow back:))
				(gSystemWindow back: 53)
				((ScriptID temp2 0) doit:)
				(gSystemWindow back: temp1)
			else
				(Print 99 8) ; "Options are displayed for each game after entering the game."
			)
		)
		(return temp0)
	)
)

(instance scoreIcon of IconI
	(properties
		view 700
		loop 3
		cel 0
		cursor 999
		signal 195
		highlightColor -1
	)

	(method (select &tmp temp0 [temp1 20] temp21)
		(if (= temp0 (super select: &rest))
			(gTheIconBar hide:)
			(= temp21 (GetPort))
			(switch gCurRoomNum
				(100 ; domino1
					(proc100_2)
				)
				(200 ; checkers
					(proc200_2)
				)
				(300 ; backgam
					(proc303_2)
				)
				(400 ; pachisi
					(proc400_2)
				)
				(500 ; yacht
					(proc500_2)
				)
				(600 ; snakes
					(proc600_2)
				)
				(else
					(Print 99 9) ; "You must be in a game to show the score."
				)
			)
			(SetPort temp21)
		)
		(return temp0)
	)
)

(instance rulesIcon of IconI
	(properties
		view 700
		loop 4
		cel 0
		cursor 999
		signal 195
		highlightColor -1
	)

	(method (select &tmp temp0 [temp1 20] temp21)
		(if (= temp0 (super select: &rest))
			(gTheIconBar hide:)
			(= temp21 (GetPort))
			(switch gCurRoomNum
				(100 ; domino1
					((ScriptID 111 0) doit:) ; showRules
				)
				(200 ; checkers
					((ScriptID 211 0) doit:) ; showRules
				)
				(300 ; backgam
					((ScriptID 311 0) doit:) ; showRules
				)
				(400 ; pachisi
					((ScriptID 411 0) doit:) ; showRules
				)
				(500 ; yacht
					((ScriptID 511 0) doit:) ; showRules
				)
				(600 ; snakes
					((ScriptID 611 0) doit:) ; showRules
				)
				(else
					(Print 99 10) ; "You must be in a game to read Rules."
				)
			)
			(SetPort temp21)
		)
		(return temp0)
	)
)

(instance helpIcon of IconI
	(properties
		view 700
		loop 5
		cel 0
		cursor 29
		message 6
		signal 131
		highlightColor -1
	)
)

