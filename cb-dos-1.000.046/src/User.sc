;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 996)
(include sci.sh)
(use Main)
(use Interface)
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

	(method (doit)
		(self handleEvent: (Event new:))
	)

	(method (handleEvent event &tmp evType dir)
		(if (event type:)
			(= gLastEvent event)
			(= evType (event type:))
			(if mapKeyToDir
				(MapKeyToDir event)
			)
			(if TheMenuBar
				(TheMenuBar handleEvent: event evType)
			)
			(GlobalToLocal event)
			(if (not (event claimed:))
				(gGame handleEvent: event evType)
			)
			(if
				(and
					controls
					(not (event claimed:))
					(gCast contains: alterEgo)
				)
				(alterEgo handleEvent: event evType)
			)
			(if
				(and
					canInput
					(not (event claimed:))
					(== (event type:) evKEYBOARD)
					(or
						(== (event message:) echo)
						(<= KEY_SPACE (event message:) $00ff)
					)
					(self getInput: event)
					(Parse @inputLine event)
				)
				(event type: evSAID)
			)
			(if (== (event type:) evSAID)
				(if gMMSaidsAnchor
					(gMMSaidsAnchor setScript: (ScriptID 413 0)) ; isInvItem
					((gMMSaidsAnchor script:) handleEvent: event)
				)
				(if (not (event claimed:))
					(self said: event)
				)
			)
		)
		(event dispose:)
		(= gLastEvent 0)
	)

	(method (getInput event &tmp temp0 temp1)
		(if (!= (event type:) 4)
			(= inputLine 0)
		)
		(if (!= (event message:) echo)
			(Format @inputLine 996 0 (event message:)) ; "%c"
		)
		(= temp1 (GetInput @inputLine inputLen prompt 67 x y))
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
		(if TheMenuBar
			(gSortedFeatures addToFront: TheMenuBar)
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

	(method (handleEvent event &tmp temp0)
		(if (not (super handleEvent: event))
			(switch (event type:)
				(evMOUSEBUTTON
					(if
						(and
							(not (& (event modifiers:) emSHIFT))
							(User controls:)
						)
						(self setMotion: MoveTo (event x:) (event y:))
						(User prevDir: 0)
						(event claimed: 1)
					)
				)
				($0040 ; direction
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
			)
		)
		(event claimed:)
	)
)

