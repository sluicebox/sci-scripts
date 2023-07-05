;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use debugHandler_99)
(use Print)
(use System)

(public
	rm26 0
)

(instance rm26 of KQRoom
	(properties)

	(method (init)
		(super init:)
		(gGame handsOn:)
		(self setScript: showOpening)
	)
)

(instance showOpening of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(if global116
					(if
						(Print
							font: gSmallFont
							addText: {Include scrolling?}
							addButton: 1 {<Yes>} 0 10
							addButton: 0 {<No>} 0 24
							init:
						)
						(= global109 1)
						(Print
							font: gSmallFont
							addText: {Include DAC Music?}
							addButton: 1 {<Yes>} 0 10
							addButton: 0 {<No>} 0 24
							init:
						)
						(SetFlag 21)
						(gCurRoom newRoom: 1400)
					else
						(SetFlag 21)
						(Print
							font: gSmallFont
							addText: {Include DAC Music?}
							addButton: 1 {<Yes>} 0 10
							addButton: 0 {<No>} 0 24
							init:
						)
						(= global109 0)
						(gCurRoom newRoom: 1250)
					)
				else
					(gEgo x: 400)
					(proc99_1)
				)
			)
		)
	)
)

