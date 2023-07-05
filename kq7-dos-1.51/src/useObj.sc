;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27)
(include sci.sh)
(use Main)
(use Actor)

(class useObj of View
	(properties
		verb 0
		myCursorView 0
		myCursorLoop 0
		myCursorCel 0
		position 0
	)

	(method (doVerb theVerb)
		(if (== theVerb 8) ; Do
			(self setHotspot: 0)
			(if (not myCursorView)
				(gTheUseObjCursor view: view loop: loop cel: cel init:)
			else
				(gTheUseObjCursor
					view: myCursorView
					loop: myCursorLoop
					cel: myCursorCel
					init:
				)
			)
			(gNormalCursor setCycle: 0)
			(= global308 self)
			(gUser message: verb)
			(gGame setCursor: gTheUseObjCursor 1)
			(self hide:)
			(if position
				(= position 0)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (show)
		(super show:)
		(self x: (global311 x:) y: (+ (global311 y:) 1))
		(= global308 0)
		(gUser message: (gUser dftMessage:))
		(if (gUser canInput:)
			(gNormalCursor view: 999 loop: 0 setCel: 0 init:)
		)
		(gGame setCursor: gNormalCursor 1)
	)
)

