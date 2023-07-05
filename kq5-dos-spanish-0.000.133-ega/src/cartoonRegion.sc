;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 763)
(include sci.sh)
(use Main)
(use Interface)
(use Language)
(use Sound)
(use Motion)
(use Game)
(use System)

(public
	cartoonRegion 0
)

(instance cartoonRegion of Rgn
	(properties)

	(method (init)
		((= gMouseDownHandler myMouseDownHandler) addToFront: self)
		((= gKeyDownHandler myKeyDownHandler) addToFront: self)
		(super init: &rest)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (event type:)
			(= temp1 (gGame setCursor: 999 1))
			(= temp0 (Sound pause: 1))
			(if (OneOf gCurRoomNum 100 101 102 103 104 114 105 106 107 108 109) ; intro, intro2, intro3, intro4, intro5, intro5B, intro6, intro7, intro8, intro9, intro10
				(event claimed: 1)
				(switch
					(Print ; "Warning: This is the opening cartoon of the game, and should be viewed to receive an overview of the plot."
						763
						0
						#width
						(LangSwitch 240 280)
						#button
						{Skip it}
						0
						#button
						{Watch it}
						1
						#button
						{Restore A Game}
						2
					)
					(0
						(gGame restart:)
					)
					(1
						(gGame setCursor: temp1)
					)
					(2
						(gGame restore:)
					)
				)
			else
				(event claimed: 1)
				(switch
					(Print ; "Warning: This cartoon contains material that may be necessary for information or clues to complete this game. Please be sure to check your inventory if you decide to skip."
						763
						1
						#width
						(LangSwitch 240 280)
						#button
						{Skip it}
						0
						#button
						{Watch it}
						1
					)
					(0
						(Sound fade:)
						(cond
							((OneOf gCurRoomNum 81 82 83 84 215)
								(elfToon doit:)
							)
							((OneOf gCurRoomNum 92 39)
								(icebellaToon doit:)
							)
							((OneOf gCurRoomNum 46 111 112 110 113 89 51) ; hermit2, hermit3, hermitRoom, hermit4
								(hermitToon doit:)
							)
							((OneOf gCurRoomNum 57 96)
								(cassimaToon doit:)
							)
							((OneOf gCurRoomNum 77)
								(gypsyToon doit:)
							)
						)
					)
					(1
						(gGame setCursor: temp1)
					)
				)
			)
			(Sound pause: temp0)
		)
	)

	(method (dispose)
		(myMouseDownHandler release: dispose:)
		(myKeyDownHandler release: dispose:)
		(= gMouseDownHandler (= gKeyDownHandler 0))
		(super dispose:)
	)
)

(instance myMouseDownHandler of EventHandler
	(properties)
)

(instance myKeyDownHandler of EventHandler
	(properties)
)

(instance icebellaToon of Code
	(properties)

	(method (doit)
		(if (IsFlag 40)
			(SetFlag 57)
		)
		(gTheIconBar enable:)
		(gCurRoom newRoom: 35)
	)
)

(instance gypsyToon of Code
	(properties)

	(method (doit)
		(if (not (gEgo has: 27)) ; Amulet
			(gEgo get: 27) ; Amulet
			(SetScore 2)
		)
		(gCurRoom newRoom: 13)
	)
)

(instance elfToon of Code
	(properties)

	(method (doit)
		(if (not (gEgo has: 33)) ; Elf_Shoes
			(gEgo get: 33) ; Elf_Shoes
			(SetScore 2)
		)
		(gCurRoom newRoom: 8)
	)
)

(instance cassimaToon of Code
	(properties)

	(method (doit)
		(gEgo setCycle: SyncWalk setStep: 3 2 view: 0)
		(SetFlag 111)
		(= gCurRoomNum -1)
		(gCurRoom newRoom: 57)
	)
)

(instance hermitToon of Code
	(properties)

	(method (doit)
		(SetFlag 112)
		(= gCurRoomNum -1)
		(gCurRoom newRoom: 51)
	)
)

