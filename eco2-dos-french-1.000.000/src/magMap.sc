;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12)
(include sci.sh)
(use Main)
(use Inset)
(use PseudoMouse)
(use User)
(use Actor)
(use System)

(public
	magMap 0
	bigMap 1
)

(local
	local0
)

(instance bogusView of View
	(properties
		x 1000
		y 1000
		view 823
	)
)

(instance magMap of Inset
	(properties
		picture 822
	)

	(method (init)
		(super init: &rest)
		(SetFlag 5)
		(SetFlag 7)
		(bogusView init:)
		(gTheIconBar disable:)
		(gGame setCursor: 996)
		(SetCursor 2 117 48 202 136 823 0 0 822 53)
		(Animate (gCast elements:) 0)
		(User canInput: 1)
		(= local0 gPMouse)
		(= gPMouse PseudoMouse)
	)

	(method (doit)
		(gGame setCursor: 996)
	)

	(method (handleEvent event)
		(if
			(or
				(& (event type:) evMOUSEBUTTON)
				(and
					(& (event type:) evKEYBOARD)
					(not
						(OneOf
							(event message:)
							KEY_TAB
							KEY_SHIFTTAB
							KEY_UP
							KEY_DOWN
							KEY_LEFT
							KEY_RIGHT
							JOY_UP
							JOY_RIGHT
							JOY_DOWN
							JOY_LEFT
						)
					)
				)
			)
			(SetCursor -1)
			(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
			(event claimed: 1)
			(self dispose:)
			(gTheIconBar enable:)
		else
			(super handleEvent: event)
		)
	)

	(method (dispose)
		(super dispose:)
		(= gPMouse local0)
		(= local0 0)
		(ClearFlag 5)
		(ClearFlag 7)
		(bogusView dispose:)
		(gGame handsOn:)
		(gTheIconBar enable: 8)
		(DisposeScript 12)
	)
)

(instance bigMap of Inset
	(properties
		view 824
		priority 15
		disposeNotOnMe 1
	)

	(method (init)
		(= x (/ (- 320 (CelWide view loop cel)) 2))
		(= y (/ (- 200 (CelHigh view loop cel)) 2))
		(super init: &rest)
	)

	(method (dispose)
		(super dispose:)
		(gTheIconBar enable: 6 5)
		(gTheIconBar enable: 8)
		(DisposeScript 12)
	)
)

