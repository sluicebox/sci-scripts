;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 501)
(include sci.sh)
(use Game)

(public
	Germany 0
)

(class Germany of Rgn
	(properties
		number 501
		keep 1
		lookPuzzleBook1 0
		readPuzzleBook1 0
		lookPuzzleBook2 0
		readPuzzleBook2 0
		lookPuzzleBook3 0
		readPuzzleBook3 0
		lookPuzzleBook4 0
		readPuzzleBook4 0
		lookPuzzleBook5 0
		readPuzzleBook5 0
		potOnAltar 0
		egoCutHimself 0
		saltInPot 0
		handsAreWashed 0
		cutHair 0
		didTheRitual 0
		windowIsOpen 0
	)

	(method (newRoom newRoomNumber)
		(= initialized 1)
		(super newRoom: newRoomNumber &rest)
	)
)

