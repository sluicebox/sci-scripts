;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 78)
(include sci.sh)
(use Main)
(use fileScr)
(use Print)

(public
	proc78_0 0
	proc78_1 1
)

(procedure (proc78_0 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(if (IsFlag 85)
		(return)
	)
	(if (> argc 1)
		(= temp2 param1)
		(= temp3 param2)
	else
		(= temp2 -1)
		(= temp3 -1)
	)
	(= temp1 gTheCursor)
	(gGame setCursor: gNormalCursor)
	(SetCursor 235 100)
	(repeat
		(switch
			(Print
				addTitle: 9 0 4 1 0
				addText: 9 0 0 1 50 1 0 ; "Now would be a good time to save your game."
				addIcon: 972 0 0 0 0
				addButton: 2 9 0 3 1 50 33 0 ; "Screw it"
				addButton: 1 9 0 2 1 155 33 0 ; "Save"
				x: temp2
				y: temp3
				init:
			)
			(1
				(gGame save:)
				(break)
			)
			(2
				(break)
			)
		)
	)
	(gGame setCursor: temp1)
)

(procedure (proc78_1 &tmp temp0)
	(= temp0 gTheCursor)
	(gGame setCursor: gNormalCursor)
	(SetCursor 225 85)
	(switch
		(Print
			width: 150
			addTitle: 11 0 4 1 0
			addText: 11 0 0 1 50 1 0 ; "Would you like to be prompted to save after major sequences in the game?"
			addIcon: 972 0 0 0 0
			addButton: 2 11 0 3 1 50 33 0 ; "No"
			addButton: 1 11 0 2 1 155 33 0 ; "Yes"
			init:
		)
		(100
			(ClearFlag 85)
		)
		(200
			(SetFlag 85)
		)
	)
	(gGame setCursor: temp0)
)

