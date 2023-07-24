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

	(method (doit &tmp temp0)
		(curEvent new:)
		(self handleEvent: curEvent)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 [temp3 3] temp6 temp7 temp8 temp9 temp10 temp11)
		(= temp8 0)
		(if (not (gTalkers isEmpty:))
			(repeat
				(= gGameTime (+ gTickOffset (GetTime)))
				(gTalkers eachElementDo: #doit firstTrue: #handleEvent event)
				(gSounds eachElementDo: #check)
				(FrameOut)
				(breakif (gTalkers allTrue: #isModeless 2))
				(curEvent new:)
			)
			(if (gTalkers isEmpty:)
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
			(if (gPrints isEmpty:)
				(curEvent new:)
			)
		)
		(= gMouseX (event x:))
		(= gMouseY (event y:))
		(= temp0 (event type:))
		(= temp2 (event modifiers:))
		(if (not input)
			(return 0)
		)
		(if
			(and
				(or (& (event type:) evKEYBOARD) (& (event type:) evKEYUP))
				gKeyDownHandler
				(gKeyDownHandler handleEvent: event)
			)
			(return 1)
		)
		(if gPanels
			(if (gPanels contains: global215)
				(global215 handleEvent: event)
				(event claimed: 1)
				(return 1)
			)
			(gPanels eachElementDo: #handleEvent event)
			(if (event claimed:)
				(if (and global105 (not (gPanels contains: (ScriptID 9 2)))) ; PlBagPlane
					(= temp6 global106)
					(= global106 (global105 firstTrue: #onMe event))
					(= temp9 (event plane:))
					(cond
						((not (gPlanes contains: temp9))
							(= temp10 (event x:))
							(= temp11 (event y:))
						)
						((== temp9 (ScriptID 9 4)) ; InvInset
							(event localize: temp9)
							(= temp10 (event x:))
							(= temp11 (event y:))
						)
						(else
							(event globalize:)
							(= temp10 (event x:))
							(= temp11 (event y:))
							(if temp9
								(event localize: temp9)
							)
						)
					)
					(cond
						(
							(and
								temp6
								(not (temp6 isKindOf: ExitFeature))
								(temp6 insetMember:)
								global106
								(not (global106 isKindOf: ExitFeature))
								(not (global106 insetMember:))
							)
							(if (not global110)
								(gGame normalizeCursor:)
							)
							(temp6 disposeArrow:)
						)
						(
							(and
								temp6
								(not (temp6 isKindOf: ExitFeature))
								(temp6 insetMember:)
								global106
								(global106 isKindOf: ExitFeature)
							)
							(if (not global110)
								(gGame normalizeCursor:)
							)
							(temp6 disposeArrow:)
						)
						(
							(and
								global106
								(not (global106 isKindOf: ExitFeature))
								(not (global106 insetMember:))
							)
							0
						)
						((and (not global106) temp6)
							(if (not global110)
								(gGame normalizeCursor:)
							)
							(temp6 disposeArrow:)
						)
						(
							(and
								global106
								(not (global106 isKindOf: ExitFeature))
								(global106 respondsTo: (gUser curVerb:))
								(global106 insetMember:)
								(global106 onMe: temp10 temp11)
								(IsFlag 436)
								(!= global106 temp6)
							)
							(if temp6
								(temp6 disposeArrow:)
							)
							(global106 initArrow:)
						)
					)
				)
				(if (gGame cursHidden:)
					(gGame normalizeCursor:)
				)
				(return 1)
			)
		)
		(event localize: (gCast plane:))
		(if
			(and
				(& (event type:) evMOUSE)
				gMouseDownHandler
				(gMouseDownHandler handleEvent: event)
			)
			(return 1)
		)
		(if (and global105 (not (gPanels contains: (ScriptID 9 2)))) ; PlBagPlane
			(= temp6 global106)
			(cond
				(
					(and
						(not (= global106 (global105 firstTrue: #onMe event)))
						temp6
					)
					(if (not global110)
						(gGame normalizeCursor:)
					)
					(temp6 disposeArrow:)
				)
				(
					(and
						global106
						(global106 isKindOf: ExitFeature)
						(OneOf (gUser curVerb:) 24 5)
					)
					(if (!= global106 temp6)
						(if temp6
							(temp6 disposeArrow:)
						)
						(global106 initArrow:)
					)
				)
				(
					(and
						global106
						(not (global106 isKindOf: ExitFeature))
						(IsFlag 436)
						(global106 respondsTo: (gUser curVerb:))
					)
					(if (!= global106 temp6)
						(if temp6
							(temp6 disposeArrow:)
						)
						(global106 initArrow:)
					)
				)
				(
					(and
						global106
						(not (global106 isKindOf: ExitFeature))
						(global106 respondsTo: (gUser curVerb:))
						(not (IsFlag 436))
						(!= global106 temp6)
					)
					(global106 disposeArrow:)
				)
			)
		)
		(if (global206 size:)
			(event type: (|= temp0 evVERB))
			(event message: curVerb)
			(if (global206 firstTrue: #handleEvent event)
				(return 1)
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
			((& temp0 evMOUSEBUTTON)
				(event type: (|= temp0 evVERB))
				(event message: curVerb)
				(if gPanels
					(for ((= temp7 0)) (< temp7 (gPanels size:)) ((++ temp7))
						(if ((gPanels at: temp7) disposeNotOnMe:)
							(if (== (gPanels at: temp7) (ScriptID 9 2)) ; PlBagPlane
								(= temp8 1)
							)
							((gPanels at: temp7) dispose:)
							(if temp8
								(if (not (gGame liteInterface:))
									((ScriptID 9 1) init:) ; PlInterface
								)
								(gInventory draw:)
							)
						)
					)
				)
				(cond
					(
						(or
							(and
								global105
								(global105 firstTrue: #handleEvent event)
							)
							(gFeatures firstTrue: #handleEvent event)
							(gCast firstTrue: #handleEvent event)
							(and global208 (global208 handleEvent: event))
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

