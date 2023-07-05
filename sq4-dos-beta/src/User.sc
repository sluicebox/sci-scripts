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
		blocks 1
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
		(if (event type:)
			(= gLastEvent event)
			(= evType (event type:))
			(if mapKeyToDir
				(MapKeyToDir event)
			)
			(if global58
				(global58 handleEvent: event evType)
			)
			(event localize:)
			(= global60 (event x:))
			(= global61 (event y:))
			(switch (event type:)
				(evKEYBOARD
					(if gSq4KeyDownHandler
						(gSq4KeyDownHandler handleEvent: event)
					)
				)
				(evMOUSEBUTTON
					(or
						(and alterEgo (alterEgo handleEvent: event))
						(and gGameControls (gGameControls handleEvent: event))
					)
				)
				($0040 ; direction
					(or
						(and alterEgo (alterEgo handleEvent: event))
						(and gFtrInitializer (gFtrInitializer handleEvent: event))
					)
				)
			)
		)
		(if (not (event claimed:))
			(if gIconBar
				(gIconBar handleEvent: event)
			)
			(if (and (== (event type:) evVERB) input)
				(if gUseSortedFeatures
					(OnMeAndLowY init:)
					(gCast eachElementDo: #perform OnMeAndLowY event)
					(gFeatures eachElementDo: #perform OnMeAndLowY event)
					(if (OnMeAndLowY theObj:)
						((OnMeAndLowY theObj:) handleEvent: event)
					)
				else
					(or
						(gCast handleEvent: event)
						(gFeatures handleEvent: event)
					)
				)
			)
			(if (not (event claimed:))
				(gGame handleEvent: event evType)
			)
		)
		(= gLastEvent 0)
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

	(method (put what recipient)
		(if (self has: what)
			((gInventory at: what) moveTo: (if (== argc 1) -1 else recipient))
			(if gIconBar
				((gIconBar curInvIcon: 0 at: 6) cursor: 999)
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
		(if (not (event claimed:))
			(switch (event type:)
				(evMOUSEBUTTON
					(if
						(and
							(User controls:)
							(not (event modifiers:))
							(or
								(not gIconBar)
								(== (gIconBar indexOf: (gIconBar curIcon:)) 0)
							)
							(gCast contains: self)
						)
						(self
							setMotion:
								(if global57 PolyPath else MoveTo)
								(event x:)
								(event y:)
						)
						(User prevDir: 0)
						(event claimed: 1)
					)
				)
				($0040 ; direction
					(cond
						(
							(or
								(not (User controls:))
								(not (gCast contains: self))
							)
							(event claimed:)
							(return)
						)
						((not (IsObject gIconBar)))
						((!= (gIconBar indexOf: (gIconBar curIcon:)) 0)
							(event claimed:)
							(return)
						)
					)
					(if
						(and
							(== (= temp0 (event message:)) (User prevDir:))
							(IsObject mover)
						)
						(= temp0 JOY_NULL)
					)
					(User prevDir: temp0)
					(self setDirection: temp0)
					(event claimed: 1)
				)
				(evVERB
					(super handleEvent: event)
				)
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

