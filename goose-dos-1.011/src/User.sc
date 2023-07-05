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

(instance uEvt of Event ; UNUSED
	(properties)
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
		curEvent 0
	)

	(method (init inLine length)
		(= inputLineAddr (if argc inLine else @inputLine))
		(= inputLen (if (== argc 2) length else 45))
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp4 0)
		(= temp0 (Event new:))
		(if (temp0 type:)
			(= gLastEvent temp0)
			(= temp1 (temp0 type:))
			(= global141 0)
			(if (!= temp1 evKEYBOARD)
				(= global141 1)
			)
			(if mapKeyToDir
				(MapKeyToDir temp0)
			)
			(if TheMenuBar
				(TheMenuBar handleEvent: temp0)
			)
			(gGame handleEvent: temp0)
			(if (not (temp0 claimed:))
				(switch (temp0 type:)
					(evMOUSEBUTTON
						(if
							(and
								controls
								(not (& (temp0 modifiers:) emSHIFT))
								(User controls:)
								(IsObject alterEgo)
								(gCast contains: alterEgo)
							)
							(alterEgo
								setMotion: MoveTo (temp0 x:) (- (temp0 y:) 10)
							)
							(User prevDir: 0)
							(= prevDir 0)
							(= global203 1)
							(= global201 1)
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
							(if (not global202)
								(= global202 (GetTime))
							)
							(= global203 0)
							(= temp4 (GetTime))
							(= temp2 (temp0 message:))
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
		)
		(= temp5 (GetTime))
		(if
			(and
				(not global203)
				(not global141)
				(> (Abs (- temp5 global202)) 29)
			)
			(if (not temp4)
				(if (not global102)
					(= temp2 JOY_NULL)
					(alterEgo setDirection: 0)
				)
			else
				(= global202 temp4)
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
)

