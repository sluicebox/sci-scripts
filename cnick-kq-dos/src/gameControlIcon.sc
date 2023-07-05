;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use checkers)
(use Interface)
(use dummyPublic0)
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
	(properties
		sel_20 {setHelpStrings}
	)

	(method (sel_57)
		(gameControlIcon sel_192: (Format @local0 99 0)) ; "This icon is for the Game Control Panel. It will let you Select a new game , Quit, Replay the current game, Set text speed, Adjust the Volume, and tell you who made the game what it is today."
		(optionsIcon sel_192: (Format @local150 99 1)) ; "This icon is for setting options of the individual games."
		(scoreIcon sel_192: (Format @local200 99 2)) ; "This icon reports the current score of the current game."
		(rulesIcon sel_192: (Format @local250 99 3)) ; "This icon has the rules for each game. To read the rules of a particular game, go to that game first and then choose this Icon."
		(helpIcon sel_192: (Format @local345 99 4)) ; "This icon is the help icon. By choosing this icon and pointing the special cursor on another icon, you will get a description of what the icon is for."
	)
)

(instance gameControlIcon of IconI
	(properties
		sel_20 {gameControlIcon}
		sel_2 700
		sel_3 0
		sel_4 0
		sel_33 982
		sel_14 451
		sel_196 -1
	)

	(method (sel_199)
		(return 1)
	)

	(method (sel_171 &tmp temp0)
		(if (= temp0 (super sel_171: &rest))
			(gTheIconBar sel_102:)
			(gGameControls sel_198:)
		)
		(return temp0)
	)
)

(instance optionsIcon of IconI
	(properties
		sel_20 {optionsIcon}
		sel_2 700
		sel_3 1
		sel_4 0
		sel_33 982
		sel_14 195
		sel_196 -1
	)

	(method (sel_171 &tmp temp0 temp1 temp2)
		(if (= temp0 (super sel_171: &rest))
			(gTheIconBar sel_102:)
			(switch gCurRoomNum
				(100
					(= temp2 110)
				)
				(200 ; checkers
					(= temp2 210)
				)
				(300 ; backgam
					(= temp2 310)
				)
				(400
					(= temp2 410)
				)
				(500
					(= temp2 510)
				)
				(600
					(= temp2 653)
				)
				(else
					(= temp2 0)
				)
			)
			(if temp2
				(gGameControls sel_102:)
				(= temp1 (gSystemWindow sel_26:))
				(gSystemWindow sel_26: 53)
				((ScriptID temp2 0) sel_57:)
				(gSystemWindow sel_26: temp1)
			else
				(Print 99 8) ; "Options are displayed for each game after entering the game."
			)
		)
		(return temp0)
	)
)

(instance scoreIcon of IconI
	(properties
		sel_20 {scoreIcon}
		sel_2 700
		sel_3 3
		sel_4 0
		sel_33 982
		sel_14 195
		sel_196 -1
	)

	(method (sel_171 &tmp temp0 [temp1 20] temp21)
		(if (= temp0 (super sel_171: &rest))
			(gTheIconBar sel_102:)
			(= temp21 (GetPort))
			(switch gCurRoomNum
				(100
					(proc100_2)
				)
				(200 ; checkers
					(proc200_2)
				)
				(300 ; backgam
					(proc303_2)
				)
				(400
					(proc400_2)
				)
				(500
					(proc500_2)
				)
				(600
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
		sel_20 {rulesIcon}
		sel_2 700
		sel_3 4
		sel_4 0
		sel_33 982
		sel_14 195
		sel_196 -1
	)

	(method (sel_171 &tmp temp0 [temp1 20] temp21)
		(if (= temp0 (super sel_171: &rest))
			(gTheIconBar sel_102:)
			(= temp21 (GetPort))
			(switch gCurRoomNum
				(100
					((ScriptID 111 0) sel_57:) ; MISSING SCRIPT
				)
				(200 ; checkers
					((ScriptID 211 0) sel_57:) ; showRules
				)
				(300 ; backgam
					((ScriptID 311 0) sel_57:) ; showRules
				)
				(400
					((ScriptID 411 0) sel_57:) ; MISSING SCRIPT
				)
				(500
					((ScriptID 511 0) sel_57:) ; MISSING SCRIPT
				)
				(600
					((ScriptID 611 0) sel_57:) ; MISSING SCRIPT
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
		sel_20 {helpIcon}
		sel_2 700
		sel_3 5
		sel_4 0
		sel_33 980
		sel_37 6
		sel_14 131
		sel_196 -1
	)
)

