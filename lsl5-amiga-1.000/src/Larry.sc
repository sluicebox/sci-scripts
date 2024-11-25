;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
(include sci.sh)
(use Main)
(use StopWalk)
(use Inventory)
(use User)

(class Larry of Ego
	(properties
		description {Larry}
		sightAngle 180
		view 550
		skating 0
		sitting 0
	)

	(method (doVerb theVerb invItem &tmp [str 80])
		(switch theVerb
			(2 ; Look
				(if skating
					(TPrint 23 0) ; "A guy never looks as good as he does on polystyrene wheels!"
				else
					(TPrint 23 1) ; "You give yourself a thorough once over and remember why you love polyester!"
				)
			)
			(5 ; Talk
				(TPrint 23 2) ; "And to think you used to laugh at your Mother when she would talk to herself!"
			)
			(3 ; Do
				(TPrint 23 3) ; "You carefully smooth the wrinkles from your clothes."
				(TPrint 23 4 #at -1 185) ; "(And spend quite a bit longer in some locations than others!)"
			)
			(10 ; Zipper
				(TPrint 23 5) ; "After a careful check to be sure no one is watching, you slyly "adjust your clothing.""
			)
			(4 ; Inventory
				(switch invItem
					(0 ; Camcorder
						(TPrint 23 6) ; "You adjust your camcorder to make sure it has a clear view out of your pocket."
					)
					(6 ; Hard_Disk_Cafe_Napkin
						(TPrint 23 7) ; "You mop your brow with the napkin. Fortunately, it's still readable."
					)
					(12 ; Money
						(TPrint 23 8) ; "You pay yourself all your money!"
					)
					(16 ; Tramp_Casino_Matchbook
						(TPrint 23 9) ; "You attempt to set yourself on fire."
						(TPrint 23 10 #at -1 185) ; "(You fail.)"
					)
					(18 ; Roller-skates
						((Inv at: 18) doVerb: 3) ; Roller-skates
					)
					(20 ; Doc_Pulliam_s_Card
						(TPrint 23 11) ; "You pick your teeth with the business card."
					)
					(22 ; Doily
						((Inv at: 22) doVerb: 3) ; Doily
					)
					(else
						(Format @str 23 12 ((Inv at: invItem) description:)) ; "You don't need to give yourself %s, Larry; you already have it!"
						(TPrint @str)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (normalize theView)
		(= view (if argc theView else 550))
		(self
			setLoop: -1
			setCel: -1
			setPri: -1
			setMotion: 0
			setCycle: StopWalk -1
			setStep: 3 2
			z: 0
			illegalBits: $8000
			ignoreActors: 0
			moveSpeed: (gGame egoMoveSpeed:)
			cycleSpeed: (gGame egoMoveSpeed:)
		)
	)

	(method (setUpInv)
		((ScriptID 19 0) doit: 23) ; invCode
	)

	(method (showInv)
		(if (Inv firstTrue: #ownedBy 23)
			(Inv showSelf: 23)
			(if (not (gTheIconBar curInvIcon:))
				(gTheIconBar curIcon: (gTheIconBar at: 0) disable: 6)
				(if (& ((gTheIconBar curIcon:) signal:) $0004)
					(gTheIconBar advanceCurIcon:)
				)
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
			)
		else
			(TPrint 23 13) ; "You have nothing, Larry."
		)
	)

	(method (get what &tmp i)
		(for ((= i 0)) (< i argc) ((++ i))
			((gInventory at: [what i]) moveTo: 23)
		)
	)

	(method (has what &tmp theItem)
		(if (= theItem (gInventory at: what))
			(theItem ownedBy: 23)
		)
	)
)

