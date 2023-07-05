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
		(GetEvent 32767 self)
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

	(method (handleEvent event &tmp eType eMsg eMod dir aObj)
		(= gMouseX (event x:))
		(= gMouseY (event y:))
		(= eType (event type:))
		(= eMod (event modifiers:))
		(if eType
			(= gLastEvent event)
			(if mapKeyToDir
				(MapKeyToDir event)
			)
			(if (== eType evJOYDOWN)
				(= eType evKEYBOARD)
				(= eMsg (if (& eMod emSHIFT) 27 else 13))
				(= eMod $0000)
				(event type: eType message: eMsg modifiers: $0000)
			)
			(if (and global75 (global75 handleEvent: event))
				(return 1)
			)
			(if (and gPrints (gPrints handleEvent: event))
				(return 1)
			)
			(event localize:)
			(= eType (event type:))
			(= eMsg (event message:))
			(cond
				((& eType evSAID)
					(cond
						(
							(and
								(== eMsg JOY_UP)
								(or
									(= aObj
										(gCast firstTrue: #perform findNoun)
									)
									(= aObj
										(gFeatures firstTrue: #perform findNoun)
									)
									(= aObj
										(gAddToPics firstTrue: #perform findNoun)
									)
								)
							)
							(aObj doVerb: ((gTheIconBar curIcon:) message:))
						)
						((= aObj (gTheIconBar findIcon: eMsg))
							(gTheIconBar select: aObj)
							(gGame setCursor: (aObj cursor:))
						)
					)
				)
				((& eType $0040) ; direction
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
								(or (not (& eType evKEYBOARD)) (!= eMsg JOY_NULL))
								(gPMouse handleEvent: event)
							)
							(return 1)
						)
					)
				)
				((and (& eType evKEYBOARD) gKeyDownHandler (gKeyDownHandler handleEvent: event))
					(return 1)
				)
				((and (& eType evMOUSE) gMouseDownHandler (gMouseDownHandler handleEvent: event))
					(return 1)
				)
			)
		)
		(if gTheIconBar
			(gTheIconBar handleEvent: event)
		)
		(= eType (event type:))
		(= eMsg (event message:))
		(if (and input (& eType evVERB))
			(cond
				((and (& eType evMOVE) gWalkHandler (gWalkHandler handleEvent: event))
					(return 1)
				)
				(
					(and
						(& eType evMOVE)
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
				((gAddToPics handleEvent: event)
					(return 1)
				)
			)
			(if (and (not (event claimed:)) (gRegions handleEvent: event))
				(return 1)
			)
		)
		(if eType
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

(instance findNoun of Code
	(properties)

	(method (doit theObj theNoun)
		(return (== (theObj noun:) theNoun))
	)
)

