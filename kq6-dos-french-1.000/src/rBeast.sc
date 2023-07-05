;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Game)
(use System)

(public
	rBeast 0
)

(class rBeast of Rgn
	(properties)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 500 510 520 530 540))
		(= initialized 0)
		(super newRoom: newRoomNumber &rest)
	)
)

