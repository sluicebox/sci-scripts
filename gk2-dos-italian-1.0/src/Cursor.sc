;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64962)
(include sci.sh)
(use Main)
(use Sound)
(use Actor)
(use System)

(class Cursor of View
	(properties
		view 0
		hidden 0
	)

	(method (init)
		(SetCursor view loop cel)
		(return self)
	)

	(method (BAD_SELECTOR)
		(if (== argc 4)
			(SetCursor &rest)
		else
			(SetCursor -2)
		)
	)

	(method (hide)
		(if (not hidden)
			(SetCursor 0)
			(= hidden 1)
		)
	)

	(method (posn theX theY)
		(SetCursor theX theY)
		(= x (= gMouseX theX))
		(= y (= gMouseY theY))
	)

	(method (set param1 param2 param3)
		(= view param1)
		(= loop param2)
		(= cel param3)
		(self init:)
	)

	(method (setCel whichCel)
		(= cel whichCel)
		(self init:)
	)

	(method (setLoop whichLoop)
		(= loop whichLoop)
		(self init:)
	)

	(method (setView whichView)
		(= view whichView)
		(self init:)
	)

	(method (show)
		(if hidden
			(SetCursor 1)
			(= hidden 0)
		)
	)
)

(class GKHotCursor of Cursor
	(properties
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR -1
		BAD_SELECTOR -1
		BAD_SELECTOR 0
		BAD_SELECTOR -1
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		BAD_SELECTOR 0
		check 0
	)

	(method (initialize)
		(= view 999)
		(self init: &rest)
		(= BAD_SELECTOR (Set new:))
		(gUser BAD_SELECTOR: self)
		(gUser BAD_SELECTOR: (= BAD_SELECTOR 62))
	)

	(method (dispose)
		(if BAD_SELECTOR
			(self highlight: 0)
		)
		(= check (= BAD_SELECTOR 0))
		(= BAD_SELECTOR (= BAD_SELECTOR (= BAD_SELECTOR -1)))
		(BAD_SELECTOR release: dispose:)
		(= BAD_SELECTOR 0)
		(super dispose: &rest)
	)

	(method (add param1)
		(= check (= BAD_SELECTOR 1))
		(if (param1 respondsTo: #view)
			(BAD_SELECTOR addToFront: param1)
		else
			(BAD_SELECTOR add: param1)
		)
		(return param1)
	)

	(method (addToFront param1)
		(BAD_SELECTOR delete: param1)
		(BAD_SELECTOR addToFront: param1)
		(= check (= BAD_SELECTOR 1))
		(return param1)
	)

	(method (contains param1)
		(BAD_SELECTOR contains: param1)
	)

	(method (delete param1 &tmp [temp0 3])
		(BAD_SELECTOR delete: param1)
		(= check 1)
		(if (== BAD_SELECTOR param1)
			(self highlight: 0)
		)
		(if (BAD_SELECTOR isEmpty:)
			(= BAD_SELECTOR 0)
		)
	)

	(method (BAD_SELECTOR &tmp temp0 temp1)
		(SetCursor 999 2 0)
		(= temp0 (+ (GetTime) 30))
		(while (> temp0 (GetTime))
		)
		(= gGameTime (+ gTickOffset (GetTime)))
		(self update:)
	)

	(method (BAD_SELECTOR param1 param2 param3 param4 param5 param6 param7 param8)
		(cond
			((== argc 4)
				(= BAD_SELECTOR param2)
				(= BAD_SELECTOR param4)
				(= BAD_SELECTOR param1)
				(= BAD_SELECTOR param3)
				(= BAD_SELECTOR 1)
			)
			((== argc 8)
				(= BAD_SELECTOR param6)
				(= BAD_SELECTOR param8)
				(= BAD_SELECTOR param5)
				(= BAD_SELECTOR param7)
				(= BAD_SELECTOR 1)
			)
			(else
				(= BAD_SELECTOR 0)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if BAD_SELECTOR
			(if
				(and
					BAD_SELECTOR
					(or
						(< (event x:) BAD_SELECTOR)
						(> (event x:) BAD_SELECTOR)
						(< (event y:) BAD_SELECTOR)
						(> (event y:) BAD_SELECTOR)
					)
					(or
						(< (event x:) BAD_SELECTOR)
						(> (event x:) BAD_SELECTOR)
						(< (event y:) BAD_SELECTOR)
						(> (event y:) BAD_SELECTOR)
					)
				)
				(if (not BAD_SELECTOR)
					(= BAD_SELECTOR 1)
					(SetCursor 999 2 0)
				)
			else
				(if BAD_SELECTOR
					(= BAD_SELECTOR 0)
					(self update:)
				)
				(= temp2 (!= BAD_SELECTOR (= BAD_SELECTOR (event x:))))
				(= temp3 (!= BAD_SELECTOR (= BAD_SELECTOR (event y:))))
				(cond
					(
						(= temp4
							(!=
								BAD_SELECTOR
								(= BAD_SELECTOR (gUser BAD_SELECTOR:))
							)
						)
						(self update:)
					)
					((or temp2 temp3 check)
						(= check 0)
						(cond
							(
								(==
									(= temp1
										(if
											(and
												global135
												(gEgo onMe: event)
											)
											gEgo
										else
											(BAD_SELECTOR
												firstTrue: #onMe event
											)
										)
									)
									BAD_SELECTOR
								)
								(return)
							)
							((= BAD_SELECTOR temp1)
								(self highlight: 1)
							)
							(BAD_SELECTOR
								(self highlight: 0)
							)
						)
					)
				)
			)
		)
	)

	(method (highlight param1)
		(= BAD_SELECTOR param1)
		(self BAD_SELECTOR: BAD_SELECTOR)
		(self init:)
	)

	(method (BAD_SELECTOR param1 &tmp temp0)
		(if (and param1 (BAD_SELECTOR respondsTo: #setCursor))
			(BAD_SELECTOR setCursor: self)
			(CursorSound highlight: 1)
		else
			(if (== BAD_SELECTOR 62)
				(= view 999)
				(= loop (= cel 0))
			else
				(= view 996)
				(= loop
					(<< (>> (= temp0 (gUser BAD_SELECTOR:)) $0004) $0001)
				)
				(= cel (& temp0 $000f))
			)
			(if param1
				(++ loop)
				(CursorSound highlight:)
			)
		)
	)

	(method (BAD_SELECTOR)
		(SetCursor 997 0 0)
	)

	(method (update)
		(= BAD_SELECTOR (gUser BAD_SELECTOR:))
		(self BAD_SELECTOR: BAD_SELECTOR)
		(self init:)
	)

	(method (BAD_SELECTOR)
		(gCurInvView update:)
		(gUser BAD_SELECTOR: 62)
		(self show: update:)
	)
)

(class CursorSound of Sound
	(properties
		playing 0
	)

	(method (highlight)
		(if (not playing)
			(= playing 1)
		)
	)

	(method (cue)
		(= playing 0)
	)
)

