;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 996)
(include sci.sh)
(use Main)
(use PolyPath)
(use Motion)
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
		(= gMessageMode (event x:))
		(= gMessager (event y:))
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
			(if gGameTime
				(gGameTime handleEvent: event evType)
			)
			(event localize:)
			(cond
				((& (event type:) $0040) ; direction
					(or
						(and global97 (global97 handleEvent: event))
						(and alterEgo controls (alterEgo handleEvent: event))
						(and gTextSpeed (gTextSpeed handleEvent: event))
						(and gNarrator (gNarrator handleEvent: event))
					)
				)
				((== evType evKEYBOARD)
					(if gPrints
						(gPrints handleEvent: event)
					)
				)
				((and (== evType evMOUSEBUTTON) gWalkHandler)
					(gWalkHandler handleEvent: event)
				)
			)
		)
		(if (not (event claimed:))
			(if gNarrator
				(gNarrator handleEvent: event)
			)
			(if (and (== (event type:) evVERB) input)
				(cond
					(
						(and
							(== (event message:) JOY_NULL)
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
		)
	)

	(method (getInput &tmp [temp0 2]))

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
			(if (and gNarrator (== (gNarrator curInvIcon:) temp0))
				((gNarrator curInvIcon: 0 useIconItem:) cursor: 999)
				(gGame setCursor: 999 1)
			)
		)
	)

	(method (has what &tmp theItem)
		(if (= theItem (gInventory at: what))
			(theItem ownedBy: self)
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
						(== (= temp0 (event message:)) JOY_NULL)
						(& (event type:) evKEYBOARD)
					)
					(event claimed:)
					(return)
				)
				(if (and (== temp0 (User prevDir:)) (IsObject mover))
					(= temp0 JOY_NULL)
				)
				(User prevDir: temp0)
				(self setDirection: temp0)
				(event claimed: 1)
			)
			((& (event type:) evVERB)
				(if (== (event message:) JOY_NULL)
					(self
						setMotion:
							(if gHowFast PolyPath else MoveTo)
							(event x:)
							(event y:)
					)
					(User prevDir: 0)
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

