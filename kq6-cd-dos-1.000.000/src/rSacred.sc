;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Game)
(use System)

(public
	rSacred 0
)

(class rSacred of Rgn
	(properties
		geniePresent 0
		marePresent 0
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 300 310 320 330 340 350 370 380 390))
		(= initialized 0)
		(super newRoom: newRoomNumber &rest)
	)
)

