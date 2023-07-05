;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use eRS)
(use Print)
(use Window)

(public
	whereTo 0
)

(instance whereTo of FPRoom
	(properties
		picture 780
	)

	(method (init &tmp [temp0 10] temp10 temp11)
		(super init:)
		(= gNormalCursor ((gTheIconBar curIcon:) cursor:))
		(gGame setCursor: 999 1)
		(= temp0 0)
		(= temp10 0)
		(= gAct 4)
		(= temp10
			(Print
				font: gUserFont
				addButton: -230 2 0 0 30 0 13 10 ; "< Act 1 >"
				addButton: -250 2 0 0 31 68 13 10 ; "< Act 2 >"
				addButton: -630 2 0 0 32 0 31 10 ; "< Act 3 >"
				addButton: -220 2 0 0 33 68 31 10 ; "< Act 4 >"
				addButton: -170 2 0 0 34 0 49 10 ; "<Epilogue>"
				addButton: -100 2 0 0 2 68 49 10 ; "< Restore >"
				addButton: -300 2 0 0 1 2 67 10 ; "< Pick a Puzzle >"
				init:
			)
		)
		(= gAct 1)
		(switch temp10
			(-100
				(gGame restore:)
				(= temp10 global107)
			)
			(-230
				(= gAct 1)
				(= temp10 26)
			)
			(-250
				(= gAct 2)
				(gEgo get: -1 37) ; Money
				(= temp10 26)
			)
			(-630
				(= gAct 3)
				(SetFlag 107)
				(gEgo get: -1 45) ; Post_Cards
				(= temp10 26)
			)
			(-220
				(= gAct 4)
				(= temp10 26)
				(gEgo wearingGuns: 1)
			)
			(-170
				(= gAct 5)
				(= temp10 26)
			)
			(-300
				(= gCurPuzzle
					(Print
						posn: 0 20
						font: 1207
						window: SysWindow
						addTitle: 2 0 0 35 10
						addButton: 1 2 0 0 3 0 0 10 ; "Ready for Business"
						addButton: 2 2 0 0 4 100 0 10 ; "Prescription #1"
						addButton: 3 2 0 0 5 216 0 10 ; "Prescription #2"
						addButton: 4 2 0 0 6 0 16 10 ; "Prescription #3"
						addButton: 5 2 0 0 7 100 16 10 ; "Corrected Prescription"
						addButton: 6 2 0 0 8 216 16 10 ; "Preparation G"
						addButton: 7 2 0 0 9 0 32 10 ; "Sheriff Shutdown"
						addButton: 8 2 0 0 10 100 32 10 ; "Gas Mask"
						addButton: 9 2 0 0 11 216 32 10 ; "Flatulent Horses"
						addButton: 10 2 0 0 12 0 48 10 ; "Snail Stampede"
					)
				)
				(= gCurPuzzle
					(Print
						addButton: 11 2 0 0 13 100 48 10 ; "Lemmings"
						addButton: 12 2 0 0 14 216 48 10 ; "Hire a Sidekick"
						addButton: 13 2 0 0 15 0 64 10 ; "Contaminated Water"
						addButton: 14 2 0 0 16 100 64 10 ; "Burning of Coarsegold"
						addButton: 15 2 0 0 17 216 64 10 ; "Madame Ovaree"
						addButton: 16 2 0 0 18 0 80 10 ; "Arm Yourself"
						addButton: 17 2 0 0 19 100 80 10 ; "Target Practice"
						addButton: 18 2 0 0 20 216 80 10 ; "Quickdraw Practice"
						addButton: 19 2 0 0 21 0 96 10 ; "Dress Up"
						addButton: 20 2 0 0 22 100 96 10 ; "Card Shark"
					)
				)
				(cond
					(
						(<
							(= gCurPuzzle
								(Print
									addButton: 22 2 0 0 23 216 96 10 ; "Rowdy Cowhands"
									addButton: 23 2 0 0 24 0 112 10 ; "Lever Brothers"
									addButton: 24 2 0 0 25 84 112 10 ; "Kenny's Quickdraw"
									addButton: 25 2 0 0 26 200 112 10 ; "Schoolhouse Showdown"
									addButton: 26 2 0 0 27 0 128 10 ; "Trapped in Basement"
									addButton: 27 2 0 0 28 116 128 10 ; "Sword Fight"
									addButton: 28 2 0 0 29 216 128 10 ; "Killing Kenny"
									init:
								)
							)
							10
						)
						(= gAct 1)
					)
					((< gCurPuzzle 18)
						(= gAct 2)
					)
					((< gCurPuzzle 22)
						(= gAct 3)
					)
					((< gCurPuzzle 30)
						(= gAct 4)
					)
				)
				(switch gCurPuzzle
					(0
						(gGame restart:)
					)
					(1
						(= temp10 250)
						(gEgo get: -1 16) ; Door_Key
					)
					(2
						(= temp10 620)
						(gEgo get: -1 42) ; Penelope_s_Rx
					)
					(3
						(= temp10 620)
						(gEgo get: -1 22) ; Helen_s_Rx
					)
					(4
						(= temp10 620)
						(gEgo get: -1 32) ; Madame_s_Rx
					)
					(5
						(= temp10 670)
						(gEgo get: -1 32) ; Madame_s_Rx
					)
					(6
						(= temp10 600)
					)
					(7
						(= temp10 600)
					)
					(8
						(gEgo get: -1 5) ; Charcoal
						(gEgo get: -1 24) ; Ice_Pick
						(gEgo get: -1 30) ; Leather_Strap
						(gEgo get: -1 56) ; Tin_Can
						(= temp10 250)
					)
					(9
						(gEgo get: -1 21) ; Gas_Mask
						(gEgo get: -1 41) ; Paper_Sack
						(= temp10 600)
					)
					(10
						(gEgo get: -1 6) ; Church_Key
						(gEgo get: -1 1) ; Beer
						(= temp10 250)
					)
					(11
						(= temp10 200)
						(gEgo get: -1 40) ; Open_Beer
					)
					(12
						(= temp10 200)
						(gEgo get: -1 28) ; Ladder
					)
					(13
						(SetFlag 69)
						(ClearFlag 84)
						(= global138 0)
						(gEgo get: -1 18) ; Empty_Bottles
						(gEgo get: -1 28) ; Ladder
						(gEgo get: -1 48) ; Rope
						((ScriptID 0 13) setReal: (ScriptID 0 13) 0 15) ; deathTimer, deathTimer
						(= temp10 320)
					)
					(14
						(SetFlag 1)
						(SetFlag 69)
						(= temp10 630)
					)
					(15
						(SetFlag 1)
						(= temp10 400)
					)
					(16
						(= temp10 630)
					)
					(17
						(gEgo get: -1 18) ; Empty_Bottles
						(gEgo get: -1 3) ; Bullets
						(gEgo get: -1 44) ; Pistols
						(gEgo get: -1 9) ; Cleaning_Kit
						(= temp10 300)
					)
					(18
						(gEgo get: -1 18) ; Empty_Bottles
						(gEgo get: -1 3) ; Bullets
						(gEgo get: -1 44) ; Pistols
						(gEgo get: -1 9) ; Cleaning_Kit
						(= temp10 300)
					)
					(19
						(gEgo get: -1 44) ; Pistols
						(gEgo get: -1 38) ; Neckerchief
						(gEgo get: -1 10) ; Clothes
						(gEgo get: -1 2) ; Boots
						(gEgo get: -1 53) ; Silver_Filled_Mold
						(= temp10 600)
					)
					(20
						(gEgo wearingGuns: 1)
						(gEgo get: -1 44) ; Pistols
						(SetFlag 54)
						(= temp10 230)
					)
					(22
						(gEgo wearingGuns: 1)
						(gEgo get: -1 39) ; Nitrous_Oxide
						(gEgo get: -1 44) ; Pistols
						(SetFlag 54)
						(= temp10 670)
					)
					(23
						(gEgo wearingGuns: 1)
						(gEgo get: -1 44) ; Pistols
						(SetFlag 54)
						(= temp10 220)
					)
					(24
						(gEgo wearingGuns: 1)
						(gEgo get: -1 44) ; Pistols
						(SetFlag 54)
						(= temp10 220)
					)
					(25
						(gEgo wearingGuns: 1)
						(gEgo get: -1 44) ; Pistols
						(= temp10 720)
					)
					(26
						(gEgo wearingGuns: 1)
						(= temp10 730)
					)
					(27
						(gEgo wearingGuns: 1)
						(gEgo get: -1 49) ; Sharp_Ear
						(= temp10 740)
					)
					(28
						(gEgo wearingGuns: 1)
						(= temp10 720)
					)
					(else
						(= temp10 100)
					)
				)
			)
			(else
				(= temp10 100)
			)
		)
		(if temp0
			(= temp10 (ReadNumber @temp0))
		)
		(= global130 temp10)
		(gGame setCursor: gNormalCursor)
		(self newRoom: 28) ; speedRoom
	)
)

