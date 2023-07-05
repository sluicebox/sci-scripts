;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64962)
(include sci.sh)
(use Main)
(use WriteFeature)

(class Cursor of Obj
	(properties
		type -1
		x 0
		y 0
		view 999
		loop 0
		cel 0
	)

	(method (init)
		(if gTheCursor
			(gTheCursor dispose:)
		)
		(SetCursor view loop cel)
		(SetCursor x y)
		(SetCursor -2)
		(SetCursor 1)
		(= type 0)
		(&= state $fff0)
		(= gTheCursor self)
	)

	(method (cage)
		(if (== argc 4)
			(SetCursor &rest)
			(|= state $0004)
		else
			(SetCursor -2)
			(&= state $fffb)
		)
	)

	(method (hide)
		(if (not (& state $0002))
			(SetCursor 0)
			(|= state $0002)
		)
	)

	(method (normalize)
		(= type 0)
		(&= state $fff7)
		(self set: 999 0 0)
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
		(SetCursor param1 param2 cel)
	)

	(method (setCel whichCel)
		(= cel whichCel)
		(SetCursor view loop cel)
	)

	(method (setLoop whichLoop)
		(= loop whichLoop)
		(SetCursor view loop cel)
	)

	(method (setView whichView)
		(= view whichView)
		(SetCursor view loop cel)
	)

	(method (show)
		(if (& state $0002)
			(SetCursor 1)
			(&= state $fffd)
		)
	)

	(method (showHandsOff)
		(= type 2)
		(self set: 997 0 0)
	)

	(method (showWait)
		(= type 1)
		(|= state $0008)
		(self set: 998 0 0)
	)
)

(class HotCursor of Cursor
	(properties
		hotObject 0
	)

	(method (init param1)
		(super init:)
		(if (and argc param1)
			(self isActive: 1)
		)
		(return self)
	)

	(method (forceUpdate param1)
		(if argc
			(if param1
				(|= state $2000)
			else
				(&= state $dfff)
			)
		)
		(return (& state $2000))
	)

	(method (handleEvent event param2 &tmp temp0)
		(cond
			(
				(and
					(== type 0)
					param2
					(param2 respondsTo: #hotObject)
					(= temp0 (param2 hotObject: event))
				)
				(if (or (not hotObject) (!= hotObject temp0) (& state $2000))
					(|= state $1000)
					(self showHot: (= hotObject temp0))
				)
			)
			(hotObject
				(&= state $efff)
				(= hotObject 0)
				(self showHot: 0)
			)
		)
		(&= state $dfff)
	)

	(method (isActive param1)
		(if argc
			(if param1
				(|= state $0001)
				(= gSaveFileSelText self)
			else
				(&= state $fffe)
				(= gSaveFileSelText 0)
				(if (& state $1000)
					(self showHot: 0)
				)
			)
		)
		(return (not (not (& state $0001))))
	)

	(method (showHot param1)
		(if argc
			(if param1
				(PrintDebug {Cursor highlighted from object %d\n} param1)
			else
				(PrintDebug {Cursor back to normal\n})
			)
		else
			(PrintDebug {Cursor shows default highlight\n})
		)
	)
)

