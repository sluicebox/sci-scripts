;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use eRS)
(use ego)
(use Print)

(public
	whereTo 0
)

(instance whereTo of LBRoom
	(properties
		picture 780
	)

	(method (init &tmp [temp0 10] temp10 temp11)
		(super init:)
		(= temp0 0)
		(= temp10 0)
		(= temp10
			(Print
				addText: 2 0 4 1 0 0 10 ; "Where to, Laura?"
				addEdit: @temp0 5 115 0
				addButton: 105 2 0 0 1 0 18 10 ; "Andrea Doria"
				addButton: 140 2 0 0 2 100 18 10 ; "Train"
				addButton: 210 2 0 0 3 0 36 10 ; "Newspaper"
				addButton: 260 2 0 0 4 100 36 10 ; "Lo Fat's"
				addButton: 280 2 0 0 5 0 54 10 ; "Police Station"
				addButton: 300 2 0 0 6 100 54 10 ; "Speakeasy"
				addButton: -200 2 0 0 7 0 72 10 ; "Museum"
				addButton: 250 2 0 0 8 100 72 10 ; "Taxi"
				addButton: -300 2 0 0 33 0 90 10 ; "Pick an Act"
				addButton: -100 2 0 0 9 100 90 10 ; "< Restore >"
				init:
			)
		)
		(if temp0
			(= temp10 (ReadNumber @temp0))
		)
		(if (== temp10 -100)
			(gGame restore:)
			(= temp10 0)
		)
		(if (== temp10 -300)
			(switch
				(= temp10
					(Print
						addText: 2 0 4 3 0 0 10 ; "Which act?"
						addButton: 1 2 0 3 1 0 20 10 ; "Act 1"
						addButton: 2 2 0 3 2 0 40 10 ; "Act 2"
						addButton: 3 2 0 3 3 0 60 10 ; "Act 3"
						addButton: 4 2 0 3 4 0 80 10 ; "Act 4"
						addButton: 5 2 0 3 5 0 100 10 ; "Act 5"
						addButton: 6 2 0 3 6 0 120 10 ; "Act 6"
						init:
					)
				)
				(1
					(= gAct 0)
					(= gScore 0)
				)
				(2
					(proc0_13)
					(= gAct 1)
					(= gScore 5)
				)
				(3
					(proc0_14)
					(= gAct 2)
					(= gScore 12)
				)
				(4
					(proc0_15)
					(= gAct 3)
					(= gScore 43)
				)
				(5
					(proc0_16)
					(= gAct 4)
					(= gScore 58)
				)
				(6
					(proc0_17)
					(= gAct 5)
					(= gScore 61)
				)
			)
			(= temp10 26)
			(ego get: -1 2)
		)
		(if (== temp10 -200)
			(= temp10 -1)
			(= temp11 0)
			(while (== temp10 -1)
				(if (not temp11)
					(Print
						addText: 2 0 4 2 0 0 10 ; "OK, where in the Museum?"
						addEdit: @temp0 5 165 0
						addButton: 350 2 0 0 10 0 18 10 ; "Rotunda"
						addButton: 420 2 0 0 12 140 18 10 ; "Mastodon Room"
						addButton: 430 2 0 0 13 0 36 10 ; "Pterodactyl Room"
						addButton: 440 2 0 0 14 140 36 10 ; "Medieval Armory"
						addButton: 450 2 0 0 15 0 54 10 ; "Egyptian Exhibit"
						addButton: 480 2 0 0 16 140 54 0 ; MISSING MESSAGE
					)
					(= temp10
						(Print
							addButton: 490 2 0 0 17 0 72 10 ; "Life Mask Room"
							addButton: 500 2 0 0 18 140 72 10 ; "Old Masters Room"
							addButton: 560 2 0 0 19 0 90 10 ; "Carrington's Office"
							addButton: 520 2 0 0 20 140 90 10 ; "Olympia's Office"
							addButton: 550 2 0 0 21 0 108 10 ; "Yvette's Office"
							addButton: -1 2 0 0 23 140 108 10 ; "< Stairs >"
							init:
						)
					)
				else
					(= temp10
						(Print
							addText: 2 0 4 2 0 0 10 ; "OK, where in the Museum?"
							addEdit: @temp0 5 165 0
							addButton: 600 2 0 0 24 0 18 10 ; "Museum Basement"
							addButton: 650 2 0 0 25 140 18 10 ; "Heimlich's Office"
							addButton: 610 2 0 0 26 0 36 10 ; "Alcohol Lab"
							addButton: 630 2 0 0 27 140 36 10 ; "Mammology Lab"
							addButton: 640 2 0 0 32 0 54 10 ; "Ernie's Office"
							addButton: 730 2 0 0 28 140 54 10 ; "Sphynx Tunnel"
							addButton: 720 2 0 0 29 0 72 10 ; "Furnace Room"
							addButton: 710 2 0 0 30 140 72 10 ; "Sun Altar Room"
							addButton: 700 2 0 0 31 0 90 10 ; "Mummy Storage"
							addButton: -1 2 0 0 23 140 90 10 ; "< Stairs >"
							init:
						)
					)
				)
				(if temp0
					(= temp10 (ReadNumber @temp0))
				)
				(if (== temp10 -1)
					(= temp11 (- 1 temp11))
				)
			)
		)
		(if (not temp10)
			(= temp10 105)
		)
		(self newRoom: temp10)
	)
)

