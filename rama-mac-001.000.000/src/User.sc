;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64996)
(include sci.sh)
(use Main)
(use System)

(instance uEvt of Event
	(properties)

	(method (new)
		(= type (= message (= modifiers (= y (= x (= claimed (= plane 0)))))))
		(GetEvent gEventMask self)
		(return self)
	)
)

(class User of Obj
	(properties
		alterEgo 0
		input 0
		controls 0
		prevDir 0
		x -1
		y -1
		mapKeyToDir 1
		curEvent 0
	)

	(method (init)
		(= curEvent uEvt)
	)

	(method (canInput n)
		(if argc
			(= input n)
		)
		(return input)
	)

	(method (doit)
		(curEvent new:)
		(self handleEvent: curEvent)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 [temp3 2] temp5 temp6 temp7)
		(= gMouseX (event x:))
		(= gMouseY (event y:))
		(= temp0 (event type:))
		(= temp2 (event modifiers:))
		(if (not (gTalkers isEmpty:))
			(self processDialog: gTalkers event)
		)
		(if (not (gPrints isEmpty:))
			(self processDialog: gPrints event)
		)
		(if temp0
			(= gLastEvent event)
			(if (and mapKeyToDir (!= temp0 evKEYUP))
				(MapKeyToDir event)
			)
			(if (== temp0 $0020) ; joyUp
				(= temp0 evKEYBOARD)
				(= temp1 (if (& temp2 emSHIFT) 27 else 13))
				(= temp2 $0000)
				(event type: temp0 message: temp1 modifiers: $0000)
			)
			(event localize: (gCast plane:))
			(= temp0 (event type:))
			(= temp1 (event message:))
			(cond
				((& temp0 $0010) ; direction
					(cond
						((and gDirectionHandler (gDirectionHandler handleEvent: event))
							(return 1)
						)
						(
							(and
								gPMouse
								(or (not (& temp0 evKEYBOARD)) (!= temp1 JOY_NULL))
								(gPMouse handleEvent: event)
							)
							(return 1)
						)
					)
				)
				((& temp0 evKEYBOARD)
					(if (and gKeyDownHandler (gKeyDownHandler handleEvent: event))
						(return 1)
					)
					(if (== (event message:) KEY_ESCAPE)
						(gCurRoom doVerb: 149)
						(return 1)
					)
				)
				((and (& temp0 evMOUSE) gMouseDownHandler (gMouseDownHandler handleEvent: event))
					(return 1)
				)
			)
		)
		(if global123
			(global123 handleEvent: event)
		)
		(if (event claimed:)
			(return 1)
		)
		(if global163
			(event globalize:)
			(OnPlaneAndHighPri init:)
			(KList 19 (gPlanes elements:) 99 OnPlaneAndHighPri event) ; EachElementDo
			(if (not (= temp5 (OnPlaneAndHighPri theObj:)))
				(= temp5 gThePlane)
			)
			(= temp6 (temp5 casts:))
			(= temp7 (temp5 theFtrs:))
		)
		(if (and gExtMouseHandler (gExtMouseHandler handleEvent: event))
			(return 1)
		)
		(if (and temp5 (temp5 handleEvent: event))
			(return 1)
		)
		(= temp0 (event type:))
		(= temp1 (event message:))
		(if (and gCurRoom (gCurRoom handleEvent: event))
			(return 1)
		)
		(if (and temp0 (gGame handleEvent: event))
			(return 1)
		)
		(gTheCursor handleEvent: event)
		(return 0)
	)

	(method (canControl value)
		(if argc
			(= controls value)
			(= prevDir 0)
		)
		(return controls)
	)

	(method (processDialog param1 param2)
		(repeat
			(= gGameTime (+ gTickOffset (GetTime)))
			(param1 eachElementDo: #doit firstTrue: #handleEvent param2)
			(gSounds eachElementDo: #check)
			(FrameOut)
			(breakif (param1 allTrue: #isModeless 2))
			(curEvent new:)
		)
	)
)

(instance findNoun of Code ; UNUSED
	(properties)

	(method (doit theObj theNoun)
		(return (== (theObj noun:) theNoun))
	)
)

(class OnMeAndLowY of Code
	(properties
		theObj 0
		lastY -1
	)

	(method (init)
		(= theObj 0)
		(= lastY -1)
	)

	(method (doit thisObj event)
		(if (and (thisObj onMe: event) (> (thisObj y:) lastY))
			(= theObj thisObj)
			(= lastY (theObj y:))
		)
	)
)

(class OnPlaneAndHighPri of Code
	(properties
		theObj 0
		lastPri -1
	)

	(method (init)
		(= theObj gThePlane)
		(= lastPri 0)
	)

	(method (doit param1 param2)
		(if
			(and
				(!= param1 global124)
				(param1 onMe: param2)
				(> (param1 priority:) lastPri)
			)
			(= theObj param1)
			(= lastPri (theObj priority:))
		)
	)
)

