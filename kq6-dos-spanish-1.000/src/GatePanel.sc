;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 916)
(include sci.sh)
(use Main)
(use User)
(use Actor)
(use System)

(class GatePanel of View
	(properties
		offsetX 20
		offsetY 14
		maxCol 6
		maxRow 4
		cursorSpace 4
		numButtons 0
		strPointer 0
		strLen 0
		maxLen 0
		row 0
		column 0
		charCount 0
		failed 0
		value 0
	)

	(method (init param1 param2 param3)
		(= strPointer param1)
		(= strLen param2)
		(= maxLen param3)
		(gTheIconBar curIcon: (gTheIconBar at: 1))
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
		(gTheIconBar disable:)
		(SetPort 0)
		(super init:)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gDirectionHandler addToFront: self)
	)

	(method (dispose)
		(= failed (= charCount (= strPointer 0)))
		(super dispose:)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(gDirectionHandler delete: self)
	)

	(method (handleEvent event &tmp temp0)
		(if (User canInput:)
			(event claimed: 1)
			(cond
				((& (event type:) evMOUSEBUTTON)
					(cond
						(
							(or
								(& (= temp0 (event modifiers:)) emSHIFT)
								(& temp0 emCTRL)
								(& temp0 emALT)
							)
							0
						)
						((self onMe: event)
							(self calcValue: event)
						)
						(else
							(gCurRoom notify: 0)
							(self dispose:)
						)
					)
				)
				((& (event type:) $0044) ; direction | evKEYBOARD
					(cond
						((OneOf (event message:) JOY_UPRIGHT JOY_DOWNRIGHT JOY_DOWNLEFT JOY_UPLEFT KEY_TAB) 0)
						((OneOf (event message:) JOY_UP JOY_DOWN JOY_RIGHT JOY_LEFT JOY_NULL)
							(self moveCursorPosn: event)
						)
						((== (event message:) KEY_RETURN)
							(if (self onMe: event)
								(self calcValue: event)
							else
								(gCurRoom notify: 0)
								(self dispose:)
							)
						)
						(27
							(gCurRoom notify: 0)
							(self dispose:)
						)
						(else
							(event claimed: 0)
						)
					)
				)
				(else
					(event claimed: 0)
				)
			)
		)
		(event claimed:)
	)

	(method (calcPosn param1)
		(= column
			(Max 1 (Min (+ (/ (- (param1 x:) x) offsetX) 1) maxCol))
		)
		(= row (Max 0 (Min (/ (- (param1 y:) y) offsetY) maxRow)))
	)

	(method (calcValue param1 &tmp temp0)
		(= temp0 0)
		(= value 0)
		(if strPointer
			(= temp0 (WordAt strPointer charCount))
		)
		(self calcPosn: param1)
		(if
			(and
				(<= (= value (+ column (* row maxCol))) numButtons)
				(self buttonSetup:)
			)
			(self failCheck: temp0)
			(if (and (== (++ charCount) strLen) (not failed))
				(gCurRoom notify: (not failed))
				(self dispose:)
			)
			(if (== charCount maxLen)
				(gCurRoom notify: (not failed))
				(self dispose:)
			)
		)
	)

	(method (moveCursorPosn param1 &tmp temp0 temp1)
		(self calcPosn: param1)
		(= temp0 (- (+ x (* column offsetX)) (/ offsetX 2)))
		(= temp1 (- (+ y (* (+ row 1) offsetY)) cursorSpace))
		(switch (param1 message:)
			(1
				(if (> row 0)
					(-= temp1 offsetY)
				)
			)
			(5
				(if (< row maxRow)
					(+= temp1 offsetY)
				)
			)
			(3
				(if (< column maxCol)
					(+= temp0 offsetX)
				)
			)
			(7
				(if (> column 1)
					(-= temp0 offsetX)
				)
			)
		)
		(SetCursor temp0 temp1)
	)

	(method (buttonSetup &tmp temp0 temp1 temp2 temp3)
		(if (OneOf value 26 27 29 30)
			(return 0)
		)
		(= temp0 (+ (/ (- value 1) 16) 1))
		(= temp1 (mod (- value 1) 16))
		(= temp2 (+ x (* (- column 1) offsetX)))
		(= temp3 (+ y (* row offsetY)))
		(return (self drawButton: temp0 temp1 temp2 temp3))
	)

	(method (failCheck param1)
		(if (and param1 (!= param1 value))
			(= failed 1)
		)
	)

	(method (drawButton param1 param2 param3 param4 &tmp [temp0 20])
		(DrawCel view param1 param2 param3 param4 15)
		(return 1)
	)
)

