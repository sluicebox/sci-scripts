;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 800)
(include sci.sh)
(use Main)
(use Interface)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

(local
	[local0 23]
	local23
)

(instance uEvt of Event
	(properties)
)

(class PUser of Obj
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

	(method (init param1 param2)
		(= inputLineAddr (if argc param1 else @local0))
		(= local23 (if (== argc 2) param2 else 45))
		(= curEvent uEvt)
	)

	(method (canInput param1)
		(if argc
			(= input param1)
		)
		(return input)
	)

	(method (doit)
		(curEvent type: 0 message: 0 modifiers: 0 y: 0 x: 0 claimed: 0 port: 0)
		(GetEvent 32767 curEvent)
		(self handleEvent: curEvent)
	)

	(method (handleEvent event &tmp temp0 temp1)
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
			(= temp0 (event type:))
			(if gTheMenuBar
				(gTheMenuBar handleEvent: event temp0)
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
				((== temp0 evKEYBOARD)
					(if gKeyDownHandler
						(gKeyDownHandler handleEvent: event)
					)
				)
				((and (== temp0 evMOUSEBUTTON) gMouseDownHandler)
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
				)
				(cond
					((event claimed:) 1)
					((gRegions handleEvent: event) 1)
				)
			)
			(if (and (event type:) (not (event claimed:)))
				(gGame handleEvent: event)
			)
			(if
				(and
					input
					(not (event claimed:))
					(== (event type:) evKEYBOARD)
					(or
						(== (event message:) echo)
						(<= KEY_SPACE (event message:) $00ff)
					)
					(self getInput: event)
					(Parse @local0 event)
				)
				(event type: evSAID)
				(self said: event)
			)
		)
	)

	(method (getInput param1 &tmp temp0)
		(if (!= (param1 type:) 4)
			(= local0 0)
		)
		(if (!= (param1 message:) echo)
			(Format @local0 800 0 (param1 message:)) ; "%c"
		)
		(gSounds pause: 1)
		(= temp0 (GetInput @local0 local23 prompt 67 x y))
		(gSounds pause: 0)
		(return temp0)
	)

	(method (canControl param1)
		(if argc
			(= controls param1)
			(= prevDir 0)
		)
		(return controls)
	)

	(method (said param1 &tmp temp0)
		(param1 message: (and verbMessager (verbMessager doit: param1)))
		(if gUseSortedFeatures
			(proc984_0)
		else
			(gSFeatures add: gCast gFeatures)
		)
		(if gTheMenuBar
			(gSFeatures addToFront: gTheMenuBar)
		)
		(if global66
			(gSFeatures addToFront: global66)
		)
		(gSFeatures addToEnd: gGame handleEvent: param1 release:)
		(if (and (== (param1 type:) 128) (not (param1 claimed:)))
			(gGame pragmaFail: @local0)
		)
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

	(method (get param1 &tmp temp0)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			((gInventory at: [param1 temp0]) moveTo: self)
		)
	)

	(method (put param1 param2 &tmp temp0)
		(if (self has: param1)
			((= temp0 (gInventory at: param1))
				moveTo: (if (== argc 1) -1 else param2)
			)
			(if (and gTheIconBar (== (gTheIconBar curInvIcon:) temp0))
				((gTheIconBar curInvIcon: 0 useIconItem:) cursor: 999)
				(gGame setCursor: 999 1)
			)
		)
	)

	(method (has param1 &tmp temp0)
		(if (= temp0 (gInventory at: param1))
			(temp0 ownedBy: self)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if script
			(script handleEvent: event)
		)
		(cond
			((or (event claimed:) (not (gCast contains: self))) 1)
			((& (event type:) $0040) ; direction
				(if
					(and
						(== (= temp0 (event message:)) (gUser prevDir:))
						(IsObject mover)
					)
					(= temp0 JOY_NULL)
				)
				(gUser prevDir: temp0)
				(self setDirection: temp0)
				(event claimed: 1)
			)
			((or (== (event type:) evVERB) (== (event type:) evMOUSEBUTTON))
				(if (or (== (event message:) JOY_UP) (== (event type:) evMOUSEBUTTON))
					(self
						setMotion:
							(if gUseObstacles PolyPath else MoveTo)
							(event x:)
							(+ (event y:) z)
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

	(method (doit param1 param2)
		(if (and (param1 onMe: param2) (> (param1 y:) lastY))
			(= theObj param1)
			(= lastY (theObj y:))
		)
	)
)

