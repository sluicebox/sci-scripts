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
		(Say 9249 0 1)
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
							100
							101
							102
							103
							104
							114
							105
							106
							107
							108
							109
							650 ; cdIntro
							651 ; cdIntro2
							652 ; cdIntro3
							653 ; cdIntro4
							654 ; cdIntro5
							655 ; cdIntro6
							656 ; cdIntro7
							657
							658 ; cdIntro9
							659 ; cdIntro10
							700
						)
						(theIntroToon doit:)
					)
					((OneOf gCurRoomNum 81 82 83 84 215 681) ; cdElfToon
						(elfToon doit:)
					)
					((OneOf gCurRoomNum 92 39 682) ; cdIceQueen
						(icebellaToon doit:)
					)
					(
						(OneOf
							gCurRoomNum
							46
							111 ; hermit2
							112 ; hermit3
							110 ; hermitRoom
							113 ; hermit4
							89
							51
							660 ; cdHermitRoom
							661 ; cdHermit2
							662 ; cdHermit3
							663 ; cdHermit4
						)
						(hermitToon doit:)
					)
					((OneOf gCurRoomNum 57 96 683) ; cdCassimaToon
						(cassimaToon doit:)
					)
					((OneOf gCurRoomNum 77 680) ; cdMushkaToon
						(gypsyToon doit:)
					)
					((OneOf gCurRoomNum 120 121 122 123 670 671 672 673 701) ; ending, ending2, ending3, ending4, cdEnding, cdEnding2, cdEnding3, cdEnding4
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
		(gGame restart: 0)
	)
)

(instance icebellaToon of Code
	(properties)

	(method (doit)
		(if (IsFlag 40)
			(SetFlag 57)
		)
		(gTheIconBar enable: 0 1 2 3)
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
			(SetFlag 46)
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
		(gCurRoom newRoom: 673) ; cdEnding4
	)
)

