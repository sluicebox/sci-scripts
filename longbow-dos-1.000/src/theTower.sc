;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 720)
(include sci.sh)
(use Game)
(use System)

(public
	theTower 0
)

(class theTower of Rgn
	(properties
		keep 1
		climbing 0
		outBoat 0
		ivyDone 0
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 701 702 705))
			(self keep: 0)
		)
	)
)

