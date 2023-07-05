;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 78)
(include sci.sh)
(use Main)
(use n079)
(use Print)

(public
	proc78_0 0
	proc78_1 1
)

(procedure (proc78_0 param1 param2 &tmp temp0 temp1)
	(if (IsFlag 85)
		(return)
	)
	(= temp1 gTheCursor)
	(gGame setCursor: gNormalCursor)
	(SetCursor 235 80)
	(repeat
		(switch
			(Print
				width: 203
				addTitle: 9 0 4 1 0
				addText: 9 0 0 1 0 0 0 ; "Now would be a good time to save your game."
				addButton: 2 9 0 3 1 0 25 0 ; "Screw it"
				addButton: 1 9 0 2 1 165 25 0 ; "Save"
				x: (if (> argc 1) param1 else -1)
				y: (if (> argc 1) param2 else -1)
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
			addTitle: 11 0 4 1 0
			addText: 11 0 0 1 0 0 0 ; "Would you like to be prompted to save after major sequences in the game?"
			addButton: 100 11 0 2 1 145 35 0 ; "Yes"
			addButton: 200 11 0 3 1 0 35 0 ; "No"
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

