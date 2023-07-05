;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 763)
(include sci.sh)
(use Main)
(use Interface)
(use Language)
(use Sound)
(use System)

(public
	cartoonCode 0
)

(instance cartoonCode of Code
	(properties)

	(method (doit &tmp temp0 temp1)
		(= temp1 (gGame setCursor: gNormalCursor))
		(= temp0 (Sound pause: 1))
		(switch
			(Print ; "Warning: This cartoon contains material that may be necessary for information or clues to complete this game. Please be sure to check your inventory if you decide to skip."
				763
				0
				#width
				(LangSwitch 240 280)
				#button
				{Watch it}
				0
				#button
				{Skip it}
				1
			)
			(0
				(gGame setCursor: temp1)
			)
			(1
				(Sound fade:)
				(cond
					(
						(OneOf
							gCurRoomNum
							100 ; intro
							101 ; intro2
							102 ; intro3
							103 ; intro4
							104 ; intro5
							114 ; intro5B
							105 ; intro6
							106 ; intro7
							107 ; intro8
							108 ; intro9
							109 ; intro10
						)
						(theIntroToon doit:)
					)
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
					((OneOf gCurRoomNum 120 121 122 123) ; ending, ending2, ending3, ending4
						(endingToon doit:)
					)
				)
			)
		)
		(DoAudio audSTOP)
		(Sound pause: temp0)
		(DisposeScript 763)
	)
)

(instance theIntroToon of Code
	(properties)

	(method (doit)
		(gGame restart:)
	)
)

(instance icebellaToon of Code
	(properties)

	(method (doit)
		(if (IsFlag 40)
			(SetFlag 57)
		)
		(gTheIconBar enable:)
		(gGlobalSound stop:)
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
			(SetScore 4)
		)
		(gCurRoom newRoom: 8)
	)
)

(instance cassimaToon of Code
	(properties)

	(method (doit)
		(gEgo setCycle: KQ5SyncWalk setStep: 3 2 view: 0)
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

(instance endingToon of Code
	(properties)

	(method (doit)
		(if (< (DoSound sndGET_POLYPHONY) 32)
			(gGlobalSound number: 699 loop: -1 playBed:)
		else
			(gGlobalSound number: 799 loop: -1 playBed:)
		)
		(gCurRoom newRoom: 123) ; ending4
	)
)

