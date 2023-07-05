;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 996)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Menu)
(use Actor)
(use System)

(local
	[inputLine 23]
	inputLen
)

(class User of Obj
	(properties
		alterEgo 0
		canInput 0
		controls 0
		echo 32
		prevDir 0
		prompt {Enter input}
		inputLineAddr 0
		x -1
		y -1
		blocks 1
		mapKeyToDir 1
	)

	(method (init inLine length)
		(= inputLineAddr (if argc inLine else @inputLine))
		(= inputLen (if (== argc 2) length else 45))
	)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp0 (Event new:))
		(if (temp0 type:)
			(= gLastEvent temp0)
			(= temp1 (temp0 type:))
			(if mapKeyToDir
				(MapKeyToDir temp0)
			)
			(if MenuBar
				(MenuBar handleEvent: temp0 temp1)
			)
			(GlobalToLocal temp0)
			(if (not (temp0 claimed:))
				(gGame handleEvent: temp0 temp1)
			)
			(if
				(and
					controls
					(not (temp0 claimed:))
					(gCast contains: alterEgo)
				)
				(alterEgo handleEvent: temp0 temp1)
			)
			(if
				(and
					canInput
					(not (temp0 claimed:))
					(== (temp0 type:) evKEYBOARD)
					(or (== (temp0 message:) echo) (<= KEY_SPACE (temp0 message:) $007f))
					(self getInput: temp0)
					(Parse @inputLine temp0)
				)
				(temp0 type: evSAID)
				(self said: temp0)
			)
		)
		(temp0 dispose:)
		(= gLastEvent 0)
	)

	(method (getInput event &tmp temp0 temp1)
		(if (!= (event type:) 4)
			(= inputLine 0)
		)
		(if (!= (event message:) echo)
			(Format @inputLine 996 0 (event message:)) ; "%c"
		)
		(= temp0 (Sound pause: blocks))
		(= temp1 (GetInput @inputLine inputLen prompt 67 x y))
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

	(method (said event)
		(if global54
			(proc984_0 alterEgo gSortedFeatures gCast gFeatures)
		else
			(gSortedFeatures add: gCast gFeatures)
		)
		(if MenuBar
			(gSortedFeatures addToFront: MenuBar)
		)
		(gSortedFeatures addToEnd: gGame handleEvent: event release:)
		(if (and (== (event type:) 128) (not (event claimed:)))
			(gGame pragmaFail: @inputLine)
		)
	)
)

(class Ego of Act
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
				((<= y (gCurRoom horizon:)) 1)
				((>= x 319) 2)
				((>= y 189) 3)
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
		)
	)

	(method (has what &tmp theItem)
		(if (= theItem (gInventory at: what))
			(theItem ownedBy: self)
		)
	)

	(method (handleEvent event theEvType &tmp temp0 temp1)
		(= temp0
			(if (>= argc 2)
				theEvType
			else
				(event type:)
			)
		)
		(if (not (super handleEvent: event))
			(switch (event type:)
				(evMOUSEBUTTON
					(if (not (& (event modifiers:) emSHIFT))
						(self setMotion: MoveTo (event x:) (event y:))
						(User prevDir: 0)
						(event claimed: 1)
					)
				)
				($0040 ; direction
					(= temp1 (event message:))
					(if
						(and
							(== temp0 4)
							(== temp1 (User prevDir:))
							(IsObject mover)
						)
						(= temp1 JOY_NULL)
					)
					(User prevDir: (if (== temp0 4) temp1 else 0))
					(self setDirection: temp1)
					(event claimed: 1)
				)
			)
		)
		(event claimed:)
	)
)

