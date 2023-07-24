;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22)
(include sci.sh)
(use Main)
(use ExitButton)
(use n021)
(use Array)
(use Print)
(use Game)
(use User)
(use System)

(public
	saveRest 0
)

(instance saveRest of Room
	(properties
		style 14
	)

	(method (init)
		(gThePlane setRect: 0 0 319 199)
		(User canInput: 1)
		(super init:)
		(self setScript: doDialog)
	)
)

(instance doDialog of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(= temp0 (IntArray with: 0 0 0 0))
				(gGame setCursor: gNormalCursor)
				(Text 0 (temp0 data:) {A} gUserFont 320) ; TextSize
				(= temp1 (+ (temp0 at: 3) 6))
				(temp0 dispose:)
				(Print
					font: gUserFont
					addText: {What?} 1 (* 0 temp1)
					addButton: 1 {New Game.} 1 (* 1 temp1)
				)
				(if (= temp3 (proc21_0))
					(Print
						addButton: 2 {Old game.} 1 (* 2 temp1)
						addButton: 3 {Quit} 1 (* 3 temp1)
					)
				else
					(Print addButton: 3 {Quit} 1 (* 2 temp1))
				)
				(switch (= temp2 (Print init:))
					(1
						(if (== temp3 10)
							(SetFlag 3)
							(gCurRoom newRoom: 23) ; selectGameRoom
						else
							(ClearFlag 3)
							(gCurRoom newRoom: 20) ; nameGameRoom
						)
					)
					(2
						(ClearFlag 3)
						(gCurRoom newRoom: 23) ; selectGameRoom
					)
					(3
						(if
							(not
								(= gQuit
									(Print
										posn: 71 82
										font: 0
										addText:
											{Are you sure you want to quit?}
											0
											0
										addButton: 1 {Yes} 127 15
										addButton: 0 {No} 168 15
										init:
									)
								)
							)
							(self init:)
						)
					)
				)
			)
		)
	)
)

