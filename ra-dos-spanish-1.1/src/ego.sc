;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use StopWalk)
(use Window)
(use Inventory)
(use User)

(class ego of Ego
	(properties
		noun 1
		modNum 19
		sightAngle 180
		view 800
		wearingGown 0
	)

	(method (normalize param1)
		(= view (if argc param1 else 800))
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
			setSpeed: gSpeed
		)
	)

	(method (showInv &tmp temp0)
		(if (Inv firstTrue: #ownedBy gEgo)
			(= temp0 gSystemWindow)
			(= gSystemWindow SysWindow)
			(Inv showSelf: gEgo)
			(if (not (gTheIconBar curInvIcon:))
				(gTheIconBar curIcon: (gTheIconBar at: 0) disable: 5)
				(if (& ((gTheIconBar curIcon:) signal:) $0004)
					(gTheIconBar advanceCurIcon:)
				)
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
			)
			(= gSystemWindow temp0)
			(gNarrator showTitle: 0 name: {Narrator})
		else
			(gMessager say: 1 0 1 0 0 19) ; "Your purse is completely empty, Laura."
		)
	)

	(method (put)
		(if (and (not (gUser canControl:)) (== global121 (gTheIconBar at: 5)))
			(= global121 (gTheIconBar at: 0))
			(gGame setCursor: gWaitCursor)
		)
		(super put: &rest)
	)

	(method (get param1)
		(if (== param1 -1)
			(super get: &rest)
		else
			(super get: param1 &rest)
			(gMessager say: 2 4 0 0 0 19) ; "You pick it up and place it in your purse."
		)
	)
)

