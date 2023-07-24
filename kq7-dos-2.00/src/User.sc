;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64996)
(include sci.sh)
(use Main)
(use ExitButton)
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
		message 10
		dftMessage 10
		useHotspots 1
		need_update 0
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

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= temp5 gMouseX)
		(= temp6 gMouseY)
		(= gMouseX (event x:))
		(if (> (= gMouseY (event y:)) 189)
			(event claimed: 1)
			(return 0)
		)
		(= temp0 (event type:))
		(= temp2 (event modifiers:))
		(if (not (gTalkers isEmpty:))
			(repeat
				(= gGameTime (+ gTickOffset (GetTime)))
				(gTalkers eachElementDo: #doit firstTrue: #handleEvent event)
				(gSounds eachElementDo: #check)
				(gCast doit:)
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
		(if
			(and
				global123
				input
				(not temp0)
				(or
					(!= gMouseX temp5)
					(!= gMouseY temp6)
					(if need_update
						(= need_update 0)
						1
					)
				)
			)
			(OnMeAndLowY init:)
			(cond
				((gThePlane onMe: event)
					(event localize: gThePlane)
					(cond
						(
							(not
								(and
									(gCast contains: gEgo)
									(& (gEgo signal:) $0008)
									(gEgo onMe: event)
								)
							)
							(global123
								eachElementDo: #perform OnMeAndLowY event
							)
						)
						(global308
							(OnMeAndLowY theObj: gEgo)
						)
					)
				)
				(global124
					(event localize: gInterfacePlane)
					(global124 eachElementDo: #perform OnMeAndLowY event)
				)
			)
			(if
				(and
					(= temp4 (OnMeAndLowY theObj:))
					(!= global311 temp4)
					(not global308)
				)
				(= message dftMessage)
			)
			(cond
				(
					(and
						temp4
						(temp4 scratch:)
						(&
							((temp4 scratch:) _respondVerbs:)
							(gKqRespondCode doit: message)
						)
					)
					((OnMeAndLowY theObj:) handleEvent: event)
				)
				((and global311 (!= temp4 global311))
					(cond
						((not global331) 0)
						((== global331 gNormalCursor)
							(global331 view: 999 setCycle: 0 loop: 0 cel: 0)
							(if (== gTheCursor global331)
								(= message dftMessage)
								(global331 init:)
							)
						)
						((== global331 gTheUseObjCursor)
							(global331
								cel: (Max 0 (+ (global331 cel:) 1))
							)
							(if (== gTheCursor global331)
								(global331 init:)
							)
						)
						(else
							(global331
								cel: (Max 0 (+ (global331 cel:) 1))
							)
							(if (== gTheCursor global331)
								(global331 init:)
							)
						)
					)
					(= global331 0)
					(= global311 0)
				)
				(
					(and
						(not (or global311 temp4))
						(not global308)
						(gGame isHandsOn:)
						(!= (gTheCursor view:) 999)
					)
					(gNormalCursor cel: 0 init:)
					(gGame setCursor: gNormalCursor)
				)
			)
			(return 1)
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
			(if (and gSpeechHandler (gSpeechHandler handleEvent: event))
				(return 1)
			)
			(cond
				((& temp0 $0100) ; speechEvent
					(cond
						(
							(and
								(== temp1 JOY_UP)
								(or
									(= temp4
										(gCast firstTrue: #perform findNoun)
									)
									(= temp4
										(gFeatures firstTrue: #perform findNoun)
									)
								)
							)
							(temp4 doVerb: ((gTheIconBar curIcon:) message:))
						)
						((= temp4 (gTheIconBar findIcon: temp1))
							(gTheIconBar select: temp4)
							(gGame setCursor: (temp4 cursor:))
						)
					)
				)
				((& temp0 $0010) ; direction
					(cond
						((and gDirectionHandler (gDirectionHandler handleEvent: event))
							(return 1)
						)
						(
							(and
								(or
									(and
										gTheIconBar
										(==
											(gTheIconBar curIcon:)
											(gTheIconBar walkIconItem:)
										)
									)
									(not gTheIconBar)
								)
								alterEgo
								controls
								(gCast contains: alterEgo)
								(alterEgo handleEvent: event)
							)
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
				((and (& temp0 evKEYBOARD) gKeyDownHandler (gKeyDownHandler handleEvent: event))
					(return 1)
				)
				((and (& temp0 evMOUSE) gMouseDownHandler (gMouseDownHandler handleEvent: event))
					(return 1)
				)
			)
		)
		(if (IsFlag 540)
			((ScriptID 16 0) handleEvent: event) ; skipCartoon
		)
		(if (and gExtMouseHandler (gExtMouseHandler handleEvent: event))
			(return 1)
		)
		(if (event claimed:)
			(return 1)
		)
		(if (and input (or (== temp0 evMOUSEBUTTON) (and (== temp0 evKEYBOARD) (== temp1 KEY_RETURN))))
			(if (== message 10)
				(event type: $5000) ; evVERB | evMOVE
			else
				(event type: evVERB)
			)
			(event message: message)
			(= temp0 (event type:))
			(= temp1 (event message:))
			(if (not (gThePlane onMe: event))
				(event localize: gInterfacePlane)
				(if (global108 handleEvent: event)
					(return 1)
				)
			)
			(event localize: gThePlane)
			(cond
				((and (& temp0 evMOVE) gWalkHandler (gWalkHandler handleEvent: event))
					(return 1)
				)
				(
					(and
						(& temp0 evMOVE)
						(gCast contains: alterEgo)
						controls
						(alterEgo handleEvent: event)
					)
					(return 1)
				)
				(gUseSortedFeatures
					(OnMeAndLowY init:)
					(cond
						(
							(not
								(and
									(gCast contains: gEgo)
									(& (gEgo signal:) $0008)
									(gEgo onMe: event)
								)
							)
							(global123
								eachElementDo: #perform OnMeAndLowY event
							)
						)
						(global308
							(OnMeAndLowY theObj: gEgo)
						)
					)
					(if (not (OnMeAndLowY theObj:))
						(event localize: gInterfacePlane)
						(global124 eachElementDo: #perform OnMeAndLowY event)
					)
					(if
						(and
							(OnMeAndLowY theObj:)
							((OnMeAndLowY theObj:) handleEvent: event)
						)
						(return 1)
					)
				)
			)
			(event localize: gThePlane)
			(if
				(and
					(not (event claimed:))
					(gRegions handleEvent: event)
					(event claimed:)
				)
				(return 1)
			)
		)
		(if (and temp0 (gGame handleEvent: event))
			(return 1)
		)
		(return 0)
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

(instance findNoun of Code
	(properties)

	(method (doit theObj theNoun)
		(return (== (theObj noun:) theNoun))
	)
)

