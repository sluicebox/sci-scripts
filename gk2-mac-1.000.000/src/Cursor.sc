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

	(method (cage)
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
		hotObjList 0
		isHot 0
		isHighlighted 0
		oldX -1
		oldY -1
		curHotObject 0
		curVerb -1
		effTop 0
		effBottom 0
		effLeft 0
		effRight 0
		effTop2 0
		effBottom2 0
		effRight2 0
		effLeft2 0
		restrictMe 0
		cursorBad 0
		check 0
	)

	(method (initialize)
		(= view 999)
		(self init: &rest)
		(= hotObjList (Set new:))
		(gUser hotCursor: self)
		(gUser curVerb: (= curVerb 62))
	)

	(method (dispose)
		(if isHot
			(self highlight: 0)
		)
		(= check (= isHot 0))
		(= oldX (= oldY (= curVerb -1)))
		(hotObjList release: dispose:)
		(= hotObjList 0)
		(super dispose: &rest)
	)

	(method (add param1)
		(= check (= isHot 1))
		(if (param1 respondsTo: #view)
			(hotObjList addToFront: param1)
		else
			(hotObjList add: param1)
		)
		(return param1)
	)

	(method (addToFront param1)
		(hotObjList delete: param1)
		(hotObjList addToFront: param1)
		(= check (= isHot 1))
		(return param1)
	)

	(method (contains param1)
		(hotObjList contains: param1)
	)

	(method (delete param1 &tmp [temp0 3])
		(hotObjList delete: param1)
		(= check 1)
		(if (== curHotObject param1)
			(self highlight: 0)
		)
		(if (hotObjList isEmpty:)
			(= isHot 0)
		)
	)

	(method (flashBad &tmp temp0 temp1)
		(SetCursor 999 2 0)
		(= temp0 (+ (GetTime) 30))
		(while (> temp0 (GetTime))
		)
		(= gGameTime (+ gTickOffset (GetTime)))
		(self update:)
	)

	(method (cage param1 param2 param3 param4 param5 param6 param7 param8)
		(cond
			((== argc 4)
				(= effTop param2)
				(= effBottom param4)
				(= effLeft param1)
				(= effRight param3)
				(= restrictMe 1)
			)
			((== argc 8)
				(= effTop2 param6)
				(= effBottom2 param8)
				(= effLeft2 param5)
				(= effRight2 param7)
				(= restrictMe 1)
			)
			(else
				(= restrictMe 0)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if isHot
			(if
				(and
					restrictMe
					(or
						(< (event x:) effLeft)
						(> (event x:) effRight)
						(< (event y:) effTop)
						(> (event y:) effBottom)
					)
					(or
						(< (event x:) effLeft2)
						(> (event x:) effRight2)
						(< (event y:) effTop2)
						(> (event y:) effBottom2)
					)
				)
				(if (not cursorBad)
					(= cursorBad 1)
					(SetCursor 999 2 0)
				)
			else
				(if cursorBad
					(= cursorBad 0)
					(self update:)
				)
				(= temp2 (!= oldX (= oldX (event x:))))
				(= temp3 (!= oldY (= oldY (event y:))))
				(cond
					((= temp4 (!= curVerb (= curVerb (gUser curVerb:))))
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
											(hotObjList firstTrue: #onMe event)
										)
									)
									curHotObject
								)
								(return)
							)
							((= curHotObject temp1)
								(self highlight: 1)
							)
							(isHighlighted
								(self highlight: 0)
							)
						)
					)
				)
			)
		)
	)

	(method (highlight param1)
		(= isHighlighted param1)
		(self setProps: isHighlighted)
		(self init:)
	)

	(method (setProps param1 &tmp temp0)
		(if (and param1 (curHotObject respondsTo: #setCursor))
			(curHotObject setCursor: self)
			(CursorSound highlight: 1)
		else
			(if (== curVerb 62)
				(= view 999)
				(= loop (= cel 0))
			else
				(= view 996)
				(= loop (<< (>> (= temp0 (gUser curInvNum:)) $0004) $0001))
				(= cel (& temp0 $000f))
			)
			(if param1
				(++ loop)
				(CursorSound highlight:)
			)
		)
	)

	(method (showWait)
		(SetCursor 997 0 0)
	)

	(method (update)
		(= curVerb (gUser curVerb:))
		(self setProps: isHighlighted)
		(self init:)
	)

	(method (normalize)
		(gCurInvView update:)
		(gUser curVerb: 62)
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

