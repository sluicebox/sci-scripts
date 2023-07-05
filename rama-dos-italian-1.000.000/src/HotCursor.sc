;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Cursor)
(use System)

(class HotCursor of Cursor
	(properties
		verb 2
		cursorView 0
		hilited 0
		curType 1
		invItem 0
		DirCursor 0
		normalCursorView 0
	)

	(method (init param1)
		(if argc
			(self normalCursorView: param1)
			(self cursorView: normalCursorView)
			(= view (cursorView view:))
			(= loop (cursorView loop:))
			(= cel (cursorView cel:))
		)
		(super init:)
	)

	(method (hilite param1)
		(if (or (and argc param1) (and (not hilited) (!= curType 4)))
			(if (self isDirCursor:)
				(if invItem
					(self setInvCursor:)
				else
					(self setNormalCursor:)
				)
			)
			(= hilited 1)
			(++ cel)
			(super init:)
		)
	)

	(method (lolite param1)
		(if (or hilited (and argc param1))
			(= hilited 0)
			(= view (cursorView view:))
			(= loop (cursorView loop:))
			(= cel (cursorView cel:))
			(super init:)
		)
	)

	(method (setDirCursor param1)
		(if (not scratch)
			(= curType 2)
			(= hilited 0)
			(if (!= cursorView param1)
				(= cursorView param1)
				(self lolite: 1)
			)
		)
	)

	(method (setInvCursor param1 param2 &tmp temp0)
		(if argc
			(if (and invItem (!= invItem param1))
				(invItem owner: -1)
			)
			(= invItem param1)
			(= temp0 (invItem owner:))
			(param1 owner: -3)
		else
			(= temp0 (invItem owner:))
		)
		(= curType 3)
		(= verb (invItem verb:))
		(if (!= cursorView invItem)
			(= cursorView invItem)
			(if (and (> argc 1) param2)
				(self lolite:)
			else
				(self lolite: 1)
				(FrameOut)
			)
			(if (not (OneOf temp0 -2 -3))
				(= scratch 1)
			)
		)
	)

	(method (setNormalCursor param1 &tmp temp0)
		(= curType 1)
		(= verb 2)
		(= invItem 0)
		(= temp0 normalCursorView)
		(cond
			(argc
				(if (!= cursorView param1)
					(= cursorView param1)
					(self lolite: 1)
				)
			)
			((!= cursorView normalCursorView)
				(= cursorView normalCursorView)
				(self lolite: 1)
			)
		)
		(return temp0)
	)

	(method (setTempCursor param1 param2)
		(= curType 4)
		(if argc
			(if (or (!= cursorView param1) hilited)
				(= cursorView param1)
				(self lolite: 1)
			)
			(if (!= verb param2)
				(= verb param2)
			)
		else
			(if (or (!= cursorView normalCursorView) hilited)
				(= cursorView normalCursorView)
				(self lolite: 1)
			)
			(= verb 2)
		)
	)

	(method (isNormalCursor)
		(return (== curType 1))
	)

	(method (isDirCursor)
		(return (== curType 2))
	)

	(method (isInvCursor)
		(return (== curType 3))
	)

	(method (isTempCursor)
		(return (== curType 4))
	)

	(method (handleEvent event)
		(cond
			((event type:) 0)
			((event claimed:) 0)
			(else
				(cond
					(scratch
						(= scratch 0)
					)
					(invItem
						(self setInvCursor:)
					)
					(else
						(self setNormalCursor:)
					)
				)
				(self lolite:)
			)
		)
	)
)

