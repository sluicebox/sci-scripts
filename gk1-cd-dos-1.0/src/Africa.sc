;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 701)
(include sci.sh)
(use Game)
(use System)

(public
	Africa 0
)

(class Africa of Rgn
	(properties
		tileLoc1 105
		tileLoc2 8
		tileLoc3 110
		tileLoc4 1
		tileLoc5 8
		tileLoc6 109
		tileLoc8 3
		tileLoc9 101
		tileLoc10 106
		tileLoc11 4
	)

	(method (newRoom newRoomNumber)
		(= initialized 0)
		(= keep (OneOf newRoomNumber 700 710))
		(super newRoom: newRoomNumber &rest)
	)
)

