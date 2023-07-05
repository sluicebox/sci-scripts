;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 113)
(include sci.sh)
(use Main)
(use DText)
(use Str)
(use Print)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm113 0
)

(instance rm113 of Room
	(properties)

	(method (init)
		(gThePlane setRect: 0 0 319 199)
		(= global121 0)
		(gGame setCursor: gNormalCursor 0)
		(User canInput: 1)
		(super init:)
		(self setScript: doDialog)
	)
)

(instance testProp of Prop
	(properties)
)

(instance doDialog of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gGame setCursor: gNormalCursor 1)
				(if
					(==
						(= temp0
							(Print
								font: gUserFont
								x: 5
								y: 0
								addText: {choose start view:}
								addButton: 3 {3} 20 12
								addButton: 7 {7} 10 26
								addButton: 6 {6} 30 26
								addButton: 1 {1} 0 40
								addButton: 0 {0} 40 40
								addButton: 5 {5} 10 54
								addButton: 4 {4} 30 54
								addButton: 2 {2} 20 68
								addButton: -1 {quit} 0 84
								init:
							)
						)
						-1
					)
					(= gQuit 1)
				else
					(testProp
						view: temp0
						loop: 0
						cel: 0
						init:
						posn: 160 140
						setCycle: End self
					)
				)
			)
			(2
				(= temp0
					(Print
						font: gUserFont
						x: 5
						y: 0
						addText: {choose end view:}
						addButton: 3 {3} 20 12
						addButton: 7 {7} 10 26
						addButton: 6 {6} 30 26
						addButton: 1 {1} 0 40
						addButton: 0 {0} 40 40
						addButton: 5 {5} 10 54
						addButton: 4 {4} 30 54
						addButton: 2 {2} 20 68
						init:
					)
				)
				(testProp
					view: (+ 7000 (* (testProp view:) 100) temp0)
					loop: 0
					cel: 0
					setCycle: End self
				)
				(= temp1 (Str format: {ego view: %d} (testProp view:)))
				((= register (DText new:))
					text: (KString 8 (temp1 data:)) ; StrDup
					fore: 1
					back: 0
					x: 30
					y: 180
					setSize: 240
					setPri: 255
					init:
				)
				(temp1 dispose:)
			)
			(3
				(Prints {enter to continue})
				(register dispose:)
				(testProp dispose:)
				(self init:)
			)
		)
	)
)

