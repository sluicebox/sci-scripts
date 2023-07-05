;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 996)
(include sci.sh)
(use Main)
(use Interface)
(use n984)
(use Sound)
(use Motion)
(use Menu)
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
			(if TheMenuBar
				(TheMenuBar handleEvent: temp0)
			)
			(GlobalToLocal temp0)
			(gGame handleEvent: temp0)
			(if (not (temp0 claimed:))
				(switch (temp0 type:)
					(evMOUSEBUTTON
						(if
							(and
								controls
								(IsObject alterEgo)
								(gCast contains: alterEgo)
							)
							(alterEgo setMotion: MoveTo (temp0 x:) (temp0 y:))
							(= prevDir 0)
							(temp0 claimed: 1)
						)
					)
					($0040 ; direction
						(if
							(and
								controls
								(IsObject alterEgo)
								(gCast contains: alterEgo)
							)
							(= temp2 (temp0 message:))
							(if
								(and
									(== temp1 evKEYBOARD)
									(== temp2 prevDir)
									(IsObject (alterEgo mover:))
								)
								(= temp2 JOY_NULL)
							)
							(= prevDir (if (== temp1 evKEYBOARD) temp2 else 0))
							(alterEgo setDirection: temp2)
							(temp0 claimed: 1)
						)
					)
					(else
						(gCast handleEvent: temp0)
					)
				)
			)
			(if
				(and
					(not (temp0 claimed:))
					(== (temp0 type:) evKEYBOARD)
					(or (== (temp0 message:) echo) (<= KEY_SPACE (temp0 message:) $007f))
					canInput
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
		(if TheMenuBar
			(gSortedFeatures addToFront: TheMenuBar)
		)
		(if global54
			(SortedAdd alterEgo gSortedFeatures gCast gFeatures)
		else
			(gSortedFeatures add: gCast gFeatures)
		)
		(gSortedFeatures addToEnd: gGame handleEvent: event release:)
		(if (and (== (event type:) 128) (not (event claimed:)))
			(gGame pragmaFail: @inputLine)
		)
	)
)

