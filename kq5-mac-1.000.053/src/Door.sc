;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 767)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)

(class Door of Prop
	(properties
		openDoorNumber 122
		closeDoorNumber 124
	)

	(method (setCycle param1)
		(if (and argc (IsObject param1))
			(gGlobalSound3
				number:
					(if (param1 isKindOf: Beg)
						(self closeDoorNumber:)
					else
						(self openDoorNumber:)
					)
				loop: 1
				play:
			)
		)
		(super setCycle: param1 &rest)
	)
)

