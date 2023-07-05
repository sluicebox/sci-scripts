;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 98)
(include sci.sh)
(use Main)
(use DButton)
(use DIcon)
(use Dialog)
(use System)

(class QuitDialog of Dialog
	(properties)

	(method (init &tmp temp0 temp1)
		(self add:)
		(= nsLeft (= nsTop (= nsRight (= nsBottom 0))))
		((= plane (gSystemPlane new:)) name: {QuitDialogPlane} back: 0 picture: -2)
		(self add: quitView quitYes quitNo)
		(super init: &rest)
		(self setSize:)
		(= temp0 (- nsRight nsLeft))
		(= temp1 (- nsBottom nsTop))
		(self
			moveTo:
				(+ (>> (- 624 temp0) $0001) 15)
				(+ (>> (- 332 temp1) $0001) 20)
		)
	)

	(method (dispose &tmp temp0)
		(= temp0 plane)
		(super dispose:)
		(temp0 dispose:)
	)

	(method (doit &tmp temp0)
		(if (not (OneOf gCurRoomNum 96 89 88)) ; arthurQuestions, videoMenu, ramaWatch
			(= gQuit 2)
			(self init:)
			(gTheCursor setTempCursor: (ScriptID 0 1)) ; ramanNormalCursor
			(repeat
				(switch (= temp0 (super doit: quitNo))
					(-1
						(= gQuit 0)
					)
					(quitYes
						(= gQuit 1)
					)
					(quitNo
						(= gQuit 0)
					)
				)
				(if (!= gQuit 2)
					(break)
				)
			)
			(self dispose:)
		else
			(= gQuit 1)
		)
		(DisposeScript 98)
	)
)

(class MainMenuDialog of Dialog
	(properties)

	(method (init &tmp temp0 temp1)
		(self add:)
		(= nsLeft (= nsTop (= nsRight (= nsBottom 0))))
		((= plane (gSystemPlane new:))
			name: {MainMenuDialogPlane}
			back: 0
			picture: -2
		)
		(self add: mainMenuView quitYes quitNo)
		(super init: &rest)
		(self setSize:)
		(= temp0 (- nsRight nsLeft))
		(= temp1 (- nsBottom nsTop))
		(self
			moveTo:
				(+ (>> (- 624 temp0) $0001) 15)
				(+ (>> (- 332 temp1) $0001) 20)
		)
	)

	(method (dispose &tmp temp0)
		(= temp0 plane)
		(super dispose:)
		(temp0 dispose:)
	)

	(method (doit &tmp temp0 temp1)
		(self init:)
		(= temp1 -1)
		(gTheCursor setTempCursor: (ScriptID 0 1)) ; ramanNormalCursor
		(repeat
			(switch (= temp0 (super doit: quitYes))
				(-1
					(= temp1 0)
				)
				(quitYes
					(= temp1 1)
				)
				(quitNo
					(= temp1 0)
				)
			)
			(if (!= temp1 -1)
				(break)
			)
		)
		(self dispose:)
		(DisposeScript 98 temp1)
	)
)

(instance mainMenuView of DIcon
	(properties
		loop 1
		view 208
	)

	(method (init &tmp [temp0 2])
		(super init: &rest)
		(self setSize:)
	)
)

(instance quitView of DIcon
	(properties
		view 208
	)

	(method (init &tmp [temp0 2])
		(super init: &rest)
		(self setSize:)
	)
)

(instance quitYes of DButton
	(properties
		loop 3
		view 208
	)

	(method (init)
		(super init: &rest)
		(&= signal $efff)
		(self setSize: moveTo: (+ (quitView x:) 107) (+ (quitView y:) 114))
	)
)

(instance quitNo of DButton
	(properties
		loop 2
		view 208
	)

	(method (init)
		(super init: &rest)
		(&= signal $efff)
		(self setSize: moveTo: (+ (quitView x:) 244) (+ (quitView y:) 114))
	)
)

