;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64962)
(include sci.sh)
(use Main)
(use Actor)

(class Cursor of View
	(properties
		view 0
		hidden 0
	)

	(method (init)
		(SetCursor view loop cel)
		(return self)
	)

	(method (posn theX theY)
		(SetCursor theX theY)
		(= x (= gMouseX theX))
		(= y (= gMouseY theY))
	)

	(method (setView whichView)
		(= view whichView)
		(self init:)
	)

	(method (setLoop whichLoop)
		(= loop whichLoop)
		(self init:)
	)

	(method (setCel whichCel)
		(= cel whichCel)
		(self init:)
	)

	(method (show)
		(if hidden
			(SetCursor 1)
			(= hidden 0)
		)
	)

	(method (hide)
		(if (not hidden)
			(SetCursor 0)
			(= hidden 1)
		)
	)
)

