;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64913)
(include sci.sh)
(use WriteFeature)

(class LineSelector of Obj
	(properties
		scrollBar 0
		items 0
		pageSize 0
		topItemNum -1
		lineHeight -1
	)

	(method (init param1 param2)
		(if argc
			((= items param1) init:)
			(if (> argc 1)
				(= scrollBar param2)
			)
		)
		(if (and scrollBar (> (items size:) pageSize))
			(scrollBar
				clientMax: (- (items size:) pageSize)
				clientPageSize: pageSize
				init:
			)
		)
		(self
			cue:
				(if (== topItemNum -1)
					(= topItemNum 0)
				else
					topItemNum
				)
		)
	)

	(method (dispose)
		(if scrollBar
			(scrollBar dispose:)
		)
		(items dispose:)
		(= items (= pageSize 0))
		(= lineHeight (= topItemNum -1))
		(super dispose:)
	)

	(method (cue param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp4 (- topItemNum param1))
		(= temp0 (* lineHeight temp4))
		(= temp5 (+ param1 pageSize -1))
		(= temp1 (items first:))
		(for ((= temp6 0)) temp1 ((++ temp6))
			(= temp2 (items value: temp1))
			(= temp3 (temp2 y:))
			(temp2 y: (+ temp3 temp0))
			(cond
				((or (< temp6 param1) (> temp6 temp5))
					(temp2 hide:)
				)
				((temp2 isVisible:)
					(temp2 update:)
				)
				(else
					(temp2 show:)
				)
			)
			(= temp1 (items next: temp1))
		)
		(= topItemNum param1)
	)
)

(class MultiLineSelector of LineSelector
	(properties
		topLineNum -1
		numLines -1
	)

	(method (init param1 param2 &tmp temp0 temp1)
		(if argc
			((= items param1) init:)
			(if (> argc 1)
				(= scrollBar param2)
			)
		)
		(= temp0 (= numLines 0))
		(= temp1 (items size:))
		(while (< temp0 temp1)
			(+= numLines ((items at: temp0) numLines:))
			(if (> ((items at: temp0) numLines:) pageSize)
				(PrintDebug {Item %d larger than page} temp0)
				(Empty self)
			)
			(++ temp0)
		)
		(if (and scrollBar (> numLines pageSize))
			(scrollBar
				clientMax: (- numLines pageSize)
				clientPageSize: pageSize
				init:
			)
		)
		(self
			cue:
				(if (== topItemNum -1)
					(= topItemNum 0)
				else
					topItemNum
				)
		)
	)

	(method (dispose)
		(= topLineNum (= numLines -1))
		(super dispose:)
	)

	(method (cue param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(= temp1 (- topLineNum param1))
		(= temp0 (* lineHeight temp1))
		(= temp6 (+ param1 pageSize -1))
		(= temp2 (items first:))
		(for ((= temp7 0)) temp2 ((= temp7 (+ temp8 1)))
			(= temp3 (items value: temp2))
			(= temp8 (+ temp7 (temp3 numLines:) -1))
			(= temp4 (temp3 y:))
			(temp3 y: (+ temp4 temp0))
			(cond
				((or (< temp8 param1) (> temp7 temp6))
					(temp3 hide:)
				)
				((temp3 isVisible:)
					(temp3 update:)
				)
				(else
					(temp3 show:)
				)
			)
			(= temp2 (items next: temp2))
		)
		(= topLineNum param1)
	)
)

(class MaskingSelector of MultiLineSelector
	(properties)

	(method (cue param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9)
		(= temp1 (- topLineNum param1))
		(= temp0 (* lineHeight temp1))
		(= temp6 (+ param1 pageSize -1))
		(= temp2 (items first:))
		(for ((= temp7 0)) temp2 ((= temp7 (+ temp8 1)))
			(= temp3 (items value: temp2))
			(= temp8 (+ temp7 (temp3 numLines:) -1))
			(= temp4 (temp3 y:))
			(temp3 y: (+ temp4 temp0))
			(if (or (< temp8 param1) (> temp7 temp6))
				(temp3 hide:)
			else
				(if
					(and
						(>= (= temp9 (- temp7 param1)) 0)
						(< (= temp9 (- temp8 temp6)) 0)
					)
					(= temp9 0)
				)
				(if (!= temp9 (temp3 maskLines:))
					(temp3 mask: 1 maskLines: temp9)
				)
				(if (temp3 isVisible:)
					(temp3 update:)
				else
					(temp3 show:)
				)
			)
			(= temp2 (items next: temp2))
		)
		(= topLineNum param1)
	)
)

