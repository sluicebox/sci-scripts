;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64996)
(include sci.sh)
(use Main)
(use System)

(local
	local0 = 5
	local1
)

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

	(method (doit &tmp temp0)
		(curEvent new:)
		(self handleEvent: curEvent)
		(= local1 gGameTime)
		(= local0 5)
		(while global139
			(curEvent new:)
			(curEvent type: (| (curEvent type:) $0001))
			(if
				(or
					(& (curEvent type:) $0002)
					(<= (-= local0 (Abs (- gGameTime local1))) 0)
				)
				(= local0 5)
				(= local1 gGameTime)
				(self handleEvent: curEvent)
			)
			(= gGameTime (+ gTickOffset (GetTime)))
			(FrameOut)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(= gMouseX (event x:))
		(= gMouseY (event y:))
		(= temp0 (event type:))
		(= temp2 (event modifiers:))
		(if (not global139)
			(if (not (gTalkers isEmpty:))
				(repeat
					(= gGameTime (+ gTickOffset (GetTime)))
					(gTalkers
						eachElementDo: #doit
						firstTrue: #handleEvent event
					)
					(gSounds eachElementDo: #check)
					(FrameOut)
					(breakif (gTalkers allTrue: 437 2))
					(curEvent new:)
				)
				(if (gTalkers isEmpty:)
					(curEvent new:)
				)
			)
			(if (not (gPrints isEmpty:))
				(repeat
					(= gGameTime (+ gTickOffset (GetTime)))
					(gPrints
						eachElementDo: #doit
						firstTrue: #handleEvent event
					)
					(gSounds eachElementDo: #check)
					(FrameOut)
					(breakif (gPrints allTrue: 437 2))
					(curEvent new:)
				)
				(if (gPrints isEmpty:)
					(curEvent new:)
				)
			)
			(HotSpotLowY init:)
			(if
				(and
					input
					(gTheHotspotList size:)
					(or
						(gTheHotspotList eachElementDo: #perform HotSpotLowY event)
						(HotSpotLowY theObj:)
					)
				)
				(if (!= global129 (HotSpotLowY theObj:))
					(= global129 (HotSpotLowY theObj:))
					((HotSpotLowY theObj:) setCursor: 1)
				)
			else
				(= temp7 global129)
				(= global129 0)
				(if (and temp7 (== gTheCursor gTheHotspotCursor))
					(temp7 setCursor: 0)
				)
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
					(
						(and
							(& temp0 evKEYBOARD)
							gKeyDownHandler
							(gKeyDownHandler handleEvent: event)
						)
						(return 1)
					)
					(
						(and
							(& temp0 evMOUSE)
							gMouseDownHandler
							(gMouseDownHandler handleEvent: event)
						)
						(return 1)
					)
				)
				(event localize: (gCast plane:))
			)
			(if (and gExtMouseHandler (gExtMouseHandler handleEvent: event))
				(return 1)
			)
		else
			(event localize: (gCast plane:))
		)
		(if gSwatInterface
			(gSwatInterface handleEvent: event)
		)
		(if (event claimed:)
			(return 1)
		)
		(if (and (not global139) global110 (& (event type:) evMOUSE))
			(event globalize:)
			(OnPlaneAndHighPri init:)
			(KList 19 (gPlanes elements:) 99 OnPlaneAndHighPri event) ; EachElementDo
			(if (not (= temp4 (OnPlaneAndHighPri theObj:)))
				(= temp4 gThePlane)
			)
			(= temp6 (temp4 casts:))
			(= temp5 (temp4 theFtrs:))
		else
			(= temp4 gThePlane)
		)
		(if (== temp4 gThePlane)
			(= temp6 gCast)
			(= temp5 gFeatures)
		)
		(event localize: temp4)
		(= temp0 (event type:))
		(= temp1 (event message:))
		(if (and input (& temp0 evVERB))
			(cond
				(gUseSortedFeatures
					(OnMeAndLowY init:)
					(if gAutoRobot
						(gAutoRobot setNowSeen:)
					)
					(if (not (temp6 isKindOf: Cast))
						(temp6
							eachElementDo: #eachElementDo 99 OnMeAndLowY event
						)
					else
						(temp6 eachElementDo: #perform OnMeAndLowY event)
					)
					(temp5 eachElementDo: #perform OnMeAndLowY event)
					(cond
						((and gMyAutoEventCode global139)
							(gMyAutoEventCode doit: event (OnMeAndLowY theObj:))
						)
						(
							(and
								(OnMeAndLowY theObj:)
								((OnMeAndLowY theObj:) handleEvent: event)
							)
							(return 1)
						)
					)
				)
				((temp6 handleEvent: event)
					(return 1)
				)
				((temp5 handleEvent: event)
					(return 1)
				)
			)
			(if (and (not (event claimed:)) (gRegions handleEvent: event))
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

(class HotSpotLowY of Code
	(properties
		theObj 0
		lastY -1
	)

	(method (init)
		(= theObj 0)
		(= lastY -1)
	)

	(method (doit param1 param2)
		(if (and (param1 checkEvent: param2) (> (param1 y:) lastY))
			(= theObj param1)
			(= lastY (theObj y:))
		)
		(return 0)
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
		(if (and (param1 onMe: param2) (> (param1 priority:) lastPri))
			(= theObj param1)
			(= lastPri (theObj priority:))
		)
	)
)

(instance findNoun of Code ; UNUSED
	(properties)

	(method (doit theObj theNoun)
		(return (== (theObj noun:) theNoun))
	)
)

