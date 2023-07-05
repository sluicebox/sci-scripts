;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 996)
(include sci.sh)
(use Main)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

(instance uEvt of Event
	(properties)
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
		(curEvent type: 0 message: 0 modifiers: 0 y: 0 x: 0 claimed: 0 port: 0)
		(GetEvent 32767 curEvent)
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
				(
					(and
						(& temp0 evKEYBOARD)
						(gUser canInput:)
						gKeyDownHandler
						(gKeyDownHandler handleEvent: event)
					)
					(return 1)
				)
				(
					(and
						(& temp0 evMOUSE)
						(gUser canInput:)
						gMouseDownHandler
						(gMouseDownHandler handleEvent: event)
					)
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

(class Ego of Actor
	(properties
		signal 8192
		edgeHit 0
	)

	(method (init)
		(super init:)
		(if (not cycler)
			(self setCycle: Walk)
		)
	)

	(method (doit)
		(super doit:)
		(= edgeHit
			(cond
				((<= x 0) 4)
				((>= x 319) 2)
				((>= y 189) 3)
				((<= y (gCurRoom horizon:)) 1)
				(else 0)
			)
		)
	)

	(method (get what &tmp i)
		(for ((= i 0)) (< i argc) ((++ i))
			((gInventory at: [what i]) moveTo: self)
		)
	)

	(method (put what recipient &tmp temp0)
		(if (self has: what)
			((= temp0 (gInventory at: what))
				moveTo: (if (== argc 1) -1 else recipient)
			)
			(if (and gTheIconBar (== (gTheIconBar curInvIcon:) temp0))
				(gTheIconBar
					curInvIcon: 0
					disable: ((gTheIconBar useIconItem:) cursor: 999 yourself:)
				)
			)
		)
	)

	(method (has what &tmp theItem)
		(if (= theItem (gInventory at: what))
			(theItem ownedBy: self)
		)
	)

	(method (setSpeed param1)
		(if argc
			(= moveSpeed (= cycleSpeed param1))
		)
		(return moveSpeed)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(= temp1 (event type:))
		(= temp2 (event message:))
		(cond
			((and script (script handleEvent: event)) 1)
			((& temp1 $0040) ; direction
				(if (and (== (= temp0 temp2) JOY_NULL) (& temp1 evKEYBOARD))
					(event claimed:)
					(return)
				)
				(if
					(and
						(& temp1 evKEYBOARD)
						(== temp0 (gUser prevDir:))
						(IsObject mover)
					)
					(= temp0 JOY_NULL)
				)
				(gUser prevDir: temp0)
				(self setDirection: temp0)
				(event claimed: 1)
			)
			((& temp1 evVERB)
				(if (& temp1 evMOVE)
					(switch gUseObstacles
						(0
							(self
								setMotion: MoveTo (event x:) (+ (event y:) z)
							)
						)
						(1
							(self
								setMotion:
									PolyPath
									(event x:)
									(+ (event y:) z)
							)
						)
						(2
							(self
								setMotion:
									PolyPath
									(event x:)
									(+ (event y:) z)
									0
									0
							)
						)
					)
					(gUser prevDir: 0)
					(event claimed: 1)
				else
					(super handleEvent: event)
				)
			)
			(else
				(super handleEvent: event)
			)
		)
		(event claimed:)
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

