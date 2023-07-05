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
		message 3
		dftMessage 3
		useHotspots 1
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

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 [temp5 2])
		(event localize: (gCast plane:))
		(= gMouseX (event x:))
		(= gMouseY (event y:))
		(= temp0 (event type:))
		(= temp2 (event modifiers:))
		(if (and (not temp0) input (or (global160 size:) (gInterfaceHotCast size:)))
			(OnMeAndLowY init:)
			(if (not global207)
				(global160 eachElementDo: #perform OnMeAndLowY event)
			)
			(if (not (OnMeAndLowY theObj:))
				(event globalize:)
				(gInterfaceHotCast eachElementDo: #perform OnMeAndLowY event)
			)
			(if
				(and
					(= temp4 (OnMeAndLowY theObj:))
					(!= global118 temp4)
					(not global161)
				)
				(= message dftMessage)
			)
			(cond
				(
					(and
						temp4
						(temp4 scratch:)
						((temp4 scratch:) respondsTo: message)
					)
					((OnMeAndLowY theObj:) handleEvent: event)
				)
				((and global118 (!= temp4 global118))
					(cond
						((not global192) 0)
						((== global192 gNormalCursor)
							(global192 loop: 0 cel: 1)
							(if (== gTheCursor global192)
								(gCurrentControl select: 3 gNormalCursor)
								(= message dftMessage)
								(global192 init:)
							)
						)
						(else
							(if global161
								(global192
									view: (global161 loliteView:)
									loop: (global161 loop:)
									cel: (global161 cel:)
								)
							)
							(if (== gTheCursor global192)
								(= message -1)
								(global192 init:)
							)
						)
					)
					(= global192 0)
					(= global118 0)
					(= global193 0)
				)
			)
		)
		(if (== global206 2)
			(if temp0
				(gCurrentControl handleEvent: event)
				(event globalize:)
				(global116 handleEvent: event)
				(event type: evVERB)
				(event message: message)
				(event localize: (gCast plane:))
				(global160 handleEvent: event)
			)
			(return 1)
		)
		(if (not (gTalkers isEmpty:))
			(repeat
				(= gGameTime (+ gTickOffset (GetTime)))
				(gTalkers eachElementDo: #doit firstTrue: #handleEvent event)
				(gSounds eachElementDo: #check)
				(FrameOut)
				(breakif (gTalkers allTrue: 434 2))
				(curEvent new:)
			)
		)
		(if (not (gPrints isEmpty:))
			(repeat
				(= gGameTime (+ gTickOffset (GetTime)))
				(gPrints eachElementDo: #doit firstTrue: #handleEvent event)
				(gSounds eachElementDo: #check)
				(FrameOut)
				(breakif (gPrints allTrue: 434 2))
				(curEvent new:)
			)
		)
		(if temp0
			(= gLastEvent event)
			(if (and mapKeyToDir (!= temp0 evKEYUP))
				(MapKeyToDir event)
			)
			(switch temp0
				($0020 ; joyUp
					(= temp0 evKEYBOARD)
					(= temp1 (if (& temp2 emSHIFT) 27 else 13))
					(= temp2 $0000)
					(event type: temp0 message: temp1 modifiers: $0000)
				)
				($0040 ; joyDown
					(= temp0 evKEYUP)
					(= temp1 (if (& temp2 emSHIFT) 27 else 13))
					(= temp2 $0000)
					(event type: temp0 message: temp1 modifiers: $0000)
				)
			)
			(if (and gSpeechHandler (gSpeechHandler handleEvent: event))
				(return 1)
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
				((and (& temp0 $000c) gKeyDownHandler (gKeyDownHandler handleEvent: event)) ; evKEYUP | evKEYBOARD
					(return 1)
				)
				((and (& temp0 evMOUSE) gMouseDownHandler (gMouseDownHandler handleEvent: event))
					(return 1)
				)
			)
		)
		(if (and gExtMouseHandler (gExtMouseHandler handleEvent: event))
			(return 1)
		)
		(gCurrentControl handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(event globalize:)
		(if (global116 handleEvent: event)
			(return 1)
		)
		(if global207
			(return 1)
		)
		(if (and input (or (== temp0 evMOUSEBUTTON) (and (== temp0 evKEYBOARD) (== temp1 KEY_RETURN))))
			(if (== message 3)
				(event type: $5000) ; evVERB | evMOVE
			else
				(event type: evVERB)
			)
			(event message: message)
			(= temp0 (event type:))
			(= temp1 (event message:))
			(event localize: (gCast plane:))
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
					(gCast eachElementDo: #perform OnMeAndLowY event)
					(gFeatures eachElementDo: #perform OnMeAndLowY event)
					(if
						(and
							(OnMeAndLowY theObj:)
							((OnMeAndLowY theObj:) handleEvent: event)
						)
						(return 1)
					)
				)
				((gCast handleEvent: event)
					(return 1)
				)
				((gFeatures handleEvent: event)
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
		(event globalize:)
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
		(if
			(and
				(thisObj scratch:)
				(thisObj onMe: event)
				(> (thisObj y:) lastY)
				(or
					(!= thisObj gEgo)
					(and (== thisObj gEgo) (gEgo actions:))
				)
			)
			(= theObj thisObj)
			(= lastY (theObj y:))
		)
	)
)

