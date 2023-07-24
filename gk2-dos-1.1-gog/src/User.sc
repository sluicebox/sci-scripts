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
		hotCursor 0
		curVerb -1
		curInvNum -1
		primaDonnas -1
	)

	(method (init)
		(= curEvent uEvt)
		(= primaDonnas (List new:))
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

	(method (handleEvent event &tmp temp0 temp1 temp2 [temp3 3])
		(if (not (gTalkers isEmpty:))
			(repeat
				(= gGameTime (+ gTickOffset (GetTime)))
				(gTalkers eachElementDo: #doit)
				(gTalkers firstTrue: #handleEvent event)
				(gSounds eachElementDo: #check)
				(FrameOut)
				(breakif (gTalkers allTrue: #isModeless 2))
				(curEvent new:)
			)
		)
		(if (not (gPrints isEmpty:))
			(repeat
				(= gGameTime (+ gTickOffset (GetTime)))
				(gPrints eachElementDo: #doit firstTrue: #handleEvent event)
				(gSounds eachElementDo: #check)
				(FrameOut)
				(breakif (gPrints allTrue: #isModeless 2))
				(curEvent new:)
			)
		)
		(if (primaDonnas size:)
			(primaDonnas eachElementDo: #handleEvent event)
			(if (event claimed:)
				(return 1)
			)
		)
		(if (not input)
			(return 0)
		)
		(= gMouseX (event x:))
		(= gMouseY (event y:))
		(= temp0 (event type:))
		(= temp2 (event modifiers:))
		(if gPanels
			(gPanels eachElementDo: #handleEvent event)
			(cond
				((event claimed:)
					(return 1)
				)
				(global135
					(event localize: (gCast plane:))
				)
			)
		)
		(cond
			((event claimed:)
				(return 1)
			)
			((and hotCursor (not temp0))
				(hotCursor handleEvent: event)
				(return 0)
			)
			(
				(and
					(hotCursor restrictMe:)
					(or
						(< (event x:) (hotCursor effLeft:))
						(> (event x:) (hotCursor effRight:))
						(< (event y:) (hotCursor effTop:))
						(> (event y:) (hotCursor effBottom:))
					)
					(or
						(< (event x:) (hotCursor effLeft2:))
						(> (event x:) (hotCursor effRight2:))
						(< (event y:) (hotCursor effTop2:))
						(> (event y:) (hotCursor effBottom2:))
					)
				)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(& temp0 evMOUSEBUTTON)
					(& (event modifiers:) emSHIFT)
					(not (OneOf curVerb 135 111))
				)
				(gUser curVerb: 62)
				((gUser hotCursor:) update:)
			)
			((& temp0 evMOUSEBUTTON)
				(event type: (|= temp0 evVERB))
				(event message: curVerb)
				(cond
					(
						(or
							(gCast firstTrue: #handleEvent event)
							(gFeatures firstTrue: #handleEvent event)
							(gRegions handleEvent: event)
						)
						(return 1)
					)
					((and alterEgo controls (gCast contains: alterEgo))
						(event type: (|= temp0 evMOVE))
						(event localize: gThePlane)
						(if (alterEgo handleEvent: event)
							(return 1)
						)
					)
				)
			)
			(else
				(gGame handleEvent: event)
			)
		)
		(event claimed:)
	)

	(method (canControl value)
		(if argc
			(= controls value)
			(= prevDir 0)
		)
		(return controls)
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

(instance findNoun of Code ; UNUSED
	(properties)

	(method (doit theObj theNoun)
		(return (== (theObj noun:) theNoun))
	)
)

