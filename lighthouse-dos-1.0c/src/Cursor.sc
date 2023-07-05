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

(class HotCursor of Cursor
	(properties
		check 0
		curVerb -1
		hotObjList 0
		isHot 0
		isHighlighted 0
		oldX -1
		oldY -1
		curHotObject 0
	)

	(method (initialize)
		(= view 999)
		(self init: &rest)
		(= hotObjList (Set new:))
		(gUser hotCursor: self)
		(gUser curVerb: (= curVerb 5))
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

	(method (add param1 &tmp [temp0 5])
		(= check (= isHot 1))
		(hotObjList add: param1)
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

	(method (handleEvent event &tmp [temp0 2] temp2 temp3 temp4)
		(if isHot
			(= temp2 (!= oldX (= oldX (event x:))))
			(= temp3 (!= oldY (= oldY (event y:))))
			(cond
				((= temp4 (!= curVerb (= curVerb (gUser curVerb:))))
					(self update:)
				)
				((or temp2 temp3 check)
					(or temp2 temp3)
					check
					(= check 0)
					(if (and isHighlighted (curHotObject onMe: event))
						(return)
					)
					(cond
						((= curHotObject (hotObjList firstTrue: #onMe event))
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
			(if (== curVerb 5)
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

