;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 99)
(include sci.sh)
(use Main)
(use eRS)
(use Print)

(public
	deathRoom 0
)

(instance deathRoom of LBRoom
	(properties
		picture 780
		horizon 120
		north 350
	)

	(method (init &tmp temp0 temp1)
		(super init:)
		(gGameMusic1 number: 99 flags: 1 loop: 1 play:)
		(if (== global145 15)
			(= temp1 86)
		else
			(= temp1 62)
		)
		(= temp0 (+ global145 1))
		(Animate (gCast elements:) 0)
		(repeat
			(switch
				(Print
					addText: 1 45 temp0 0 100 0
					addIcon: 99 0 global145 0 0
					addButton: 1 2 0 0 1 0 temp1 99 ; "Restore"
					addButton: 2 2 0 0 2 (Localize 70 70 62 70 70) temp1 99 ; "Restart"
					addButton: 3 2 0 0 3 140 temp1 99 ; "Quit"
					init:
				)
				(1
					(gGame restore:)
				)
				(2
					(gGame restart:)
				)
				(3
					(= gQuit 1)
					(break)
				)
			)
		)
	)
)

