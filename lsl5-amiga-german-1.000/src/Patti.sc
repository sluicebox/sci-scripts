;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use Language)
(use StopWalk)
(use Inventory)
(use User)

(class Patti of Ego
	(properties
		description {Patti}
		sightAngle 180
		view 570
	)

	(method (doVerb theVerb invItem &tmp [str 95])
		(if (and (IsObject actions) (actions doit: theVerb invItem))
			(return 1)
		)
		(return
			(switch theVerb
				(2 ; Look
					(TPrint 24 0) ; "You look yourself over. You like what you see. "Although I could stand to lose a few pounds," you think."
				)
				(5 ; Talk
					(Say gEgo 24 1) ; ""I really enjoy these little talks," you say to yourself."
				)
				(3 ; Do
					(if (IsFlag 35)
						(TPrint 24 2) ; "You begin to adjust a bra strap before remembering you'd need a crowbar!"
					else
						(TPrint 24 3) ; "You begin to adjust your bra strap before remembering you'd need a bra!"
					)
				)
				(10 ; Zipper
					(TPrint 24 4) ; "Maintaining your cool, you surreptitiously check the zipper on your dress. It's fine."
				)
				(4 ; Inventory
					(switch invItem
						(4 ; A_Blank_Videotape_c
							(TPrint 24 5) ; "As much as you'd love to celebrate, you hate to drink alone!"
						)
						(5 ; Michelle_Milken_s_Resume
							(TPrint 24 6) ; "You can't listen to the gold record--without equipment."
						)
						(8 ; Boarding_Pass
							(TPrint 24 7) ; "You slide the letter opener inside the back of your dress and scratch that itch that's been driving you crazy!"
							(Say gEgo 24 8) ; "Ahhh!"
						)
						(13 ; Credit_Cards
							(if (IsFlag 35)
								(Points -5)
								(TPrint 24 9) ; "You gladly remove your double-barrelled bra."
								(ClearFlag 35)
							else
								(Points 5)
								(TPrint 24 10) ; "You slip your genuine F.B.I. bra over your shoulders."
								(Say gEgo 24 11) ; "YOW! That sucker's cold!"
								(SetFlag 35)
							)
						)
						(else
							(if 1
								(= global200
									(Memory
										memALLOC_CRIT
										(StrLen ((Inv at: invItem) description:))
									)
								)
								(= global203
									(Memory
										memALLOC_CRIT
										(StrLen ((Inv at: invItem) description:))
									)
								)
								(StrSplitInTwo
									global200
									global203
									((Inv at: invItem) description:)
								)
								(Format @str 24 12 global200 global203) ; "You don't need to give yourself %s, Patti; you already have it!"
								(Memory memFREE global200)
								(Memory memFREE global203)
							)
							(TPrint @str)
						)
					)
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)

	(method (normalize theView)
		(= view (if argc theView else 570))
		(self
			setLoop: -1
			setCel: -1
			setPri: -1
			setMotion: 0
			setCycle: StopWalk -1
			setStep: 3 2
			z: 0
			illegalBits: -32768
			ignoreActors: 0
			moveSpeed: (gGame egoMoveSpeed:)
			cycleSpeed: (gGame egoMoveSpeed:)
		)
	)

	(method (setUpInv)
		((ScriptID 19 0) doit: 24) ; invCode
	)

	(method (showInv)
		(if (Inv firstTrue: #ownedBy 24)
			(Inv showSelf: 24)
			(if (not (gTheIconBar curInvIcon:))
				(gTheIconBar curIcon: (gTheIconBar at: 0) disable: 6)
				(if (& ((gTheIconBar curIcon:) signal:) $0004)
					(gTheIconBar advanceCurIcon:)
				)
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
			)
		else
			(TPrint 24 13) ; "You have nothing, Patti."
		)
	)

	(method (get what &tmp i)
		(for ((= i 0)) (< i argc) ((++ i))
			((gInventory at: [what i]) moveTo: 24)
		)
	)

	(method (has what &tmp theItem)
		(if (= theItem (gInventory at: what))
			(theItem ownedBy: 24)
		)
	)
)

