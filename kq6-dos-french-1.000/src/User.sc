;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 996)
(include sci.sh)
(use Main)
(use System)

(instance uEvt of Event
	(properties)

	(method (new)
		(= type (= message (= modifiers (= y (= x (= claimed (= port 0)))))))
		(GetEvent evALL_EVENTS self)
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

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3)
		(= gMouseX (event x:))
		(= gMouseY (event y:))
		(= temp0 (event type:))
		(= temp2 (event modifiers:))
		(if temp0
			(= gLastEvent event)
			(if mapKeyToDir
				(MapKeyToDir event)
			)
			(if (== temp0 evJOYDOWN)
				(= temp0 evKEYBOARD)
				(= temp1 (if (& temp2 emSHIFT) 27 else 13))
				(= temp2 $0000)
				(event type: temp0 message: temp1 modifiers: $0000)
			)
			(if (and gPrints (gPrints handleEvent: event))
				(return 1)
			)
			(event localize:)
			(= temp0 (event type:))
			(= temp1 (event message:))
			(cond
				((& temp0 $0040) ; direction
					(cond
						((not (gUser canControl:)))
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
								input
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
		(if gTheIconBar
			(gTheIconBar handleEvent: event)
		)
		(= temp0 (event type:))
		(= temp1 (event message:))
		(if (and input (& temp0 evVERB))
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
					(gAddToPics eachElementDo: #perform OnMeAndLowY event)
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
		(if temp0
			(cond
				((gGame handleEvent: event)
					(return 1)
				)
				((and gPrints (gPrints handleEvent: event))
					(return 1)
				)
			)
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

