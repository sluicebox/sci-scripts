;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 996)
(include sci.sh)
(use Main)
(use Actor)
(use System)

(local
	[inputLine 23]
	inputLen
)

(instance uEvt of Event
	(properties)
)

(class User of Obj
	(properties
		alterEgo 0
		input 0
		controls 0
		echo 32
		prevDir 0
		prompt {Enter input}
		inputLineAddr 0
		x -1
		y -1
		mapKeyToDir 1
		curEvent 0
		verbMessager 0
	)

	(method (init inLine length)
		(= inputLineAddr (if argc inLine else @inputLine))
		(= inputLen (if (== argc 2) length else 45))
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

	(method (handleEvent event &tmp evType dir)
		(= gMouseX (event x:))
		(= gMouseY (event y:))
		(if (event type:)
			(= gLastEvent event)
			(if mapKeyToDir
				(MapKeyToDir event)
			)
			(if (== (event type:) evJOYDOWN)
				(event
					type: evKEYBOARD
					message: (if (& (event modifiers:) emSHIFT) 27 else 13)
					modifiers: $0000
				)
			)
			(= evType (event type:))
			(event localize:)
			(cond
				((& (event type:) $0040) ; direction
					(or
						(and gPMouse (gPMouse handleEvent: event))
						(and gDirectionHandler (gDirectionHandler handleEvent: event))
						(and alterEgo controls (alterEgo handleEvent: event))
						(and gTheIconBar (gTheIconBar handleEvent: event))
					)
				)
				((== evType evKEYBOARD)
					(if gKeyDownHandler
						(gKeyDownHandler handleEvent: event)
					)
				)
				((and (== evType evMOUSEBUTTON) gMouseDownHandler)
					(gMouseDownHandler handleEvent: event)
				)
			)
		)
		(if (not (event claimed:))
			(if gTheIconBar
				(gTheIconBar handleEvent: event)
			)
			(if (and (== (event type:) evVERB) input)
				(cond
					(
						(and
							(== (event message:) JOY_UP)
							controls
							(alterEgo handleEvent: event)
						)
						1
					)
					((gCast handleEvent: event) 1)
					((gFeatures handleEvent: event) 1)
				)
				(cond
					((event claimed:) 1)
					((gRegions handleEvent: event) 1)
				)
			)
			(if (and (event type:) (not (event claimed:)))
				(gGame handleEvent: event)
			)
		)
	)

	(method (getInput &tmp temp0))

	(method (canControl value)
		(if argc
			(= controls value)
			(= prevDir 0)
		)
		(return controls)
	)

	(method (said &tmp temp0))
)

(class Ego of Actor
	(properties
		signal 8192
		edgeHit 0
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

