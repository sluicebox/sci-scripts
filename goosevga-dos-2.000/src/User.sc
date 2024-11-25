;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 996)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use System)

(local
	[inputLine 23]
	inputLen
)

(procedure (localproc_0 param1)
	(cond
		((& (param1 type:) $0004)
			(if (== (param1 message:) 13)
				(param1 type: 16384)
			)
		)
		((& (param1 type:) $0001)
			(param1 type: 16384)
		)
	)
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
		blocks 1
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
		(GetEvent evALL_EVENTS curEvent)
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
			(if (and (or (== (= evType (event type:)) evKEYBOARD) (== evType evMOUSEBUTTON)) gModelessDialog)
				(gModelessDialog dispose:)
				(event claimed: 1)
			)
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
			(if (and (>= gCurRoomNum 1) (<= gCurRoomNum 45)) ; mapRoom
				(event globalize:)
				(gGControls handleEvent: event)
				(event localize:)
			)
			(localproc_0 event)
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
					(gUseSortedFeatures
						(OnMeAndLowY init:)
						(gCast eachElementDo: #perform OnMeAndLowY event)
						(gFeatures eachElementDo: #perform OnMeAndLowY event)
						(if (OnMeAndLowY theObj:)
							((OnMeAndLowY theObj:) handleEvent: event)
						)
					)
					((gCast handleEvent: event) 1)
					((gFeatures handleEvent: event) 1)
					(controls
						(event message: JOY_UP)
						(alterEgo handleEvent: event)
					)
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

	(method (getInput event &tmp temp0 temp1)
		(if (!= (event type:) 4)
			(= inputLine 0)
		)
		(if (!= (event message:) echo)
			(Format @inputLine 996 0 (event message:)) ; "%c"
		)
		(= temp0 (Sound pause: blocks))
		(= temp1 (GetInput @inputLine inputLen prompt 64 x y))
		(Sound pause: temp0)
		(return temp1)
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

