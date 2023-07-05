;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 996)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Menu)
(use System)

(local
	[local0 23]
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
	)

	(method (doit &tmp temp0 temp1 temp2)
		(= temp0 (Event new:))
		(if (temp0 type:)
			(= gLastEvent temp0)
			(= temp1 (temp0 type:))
			(MapKeyToDir temp0)
			(if MenuBar
				(MenuBar handleEvent: temp0)
			)
			(GlobalToLocal temp0)
			(gGame handleEvent: temp0)
			(if (not (temp0 claimed:))
				(switch (temp0 type:)
					(evMOUSEBUTTON
						(if (and controls (IsObject alterEgo))
							(alterEgo setMotion: MoveTo (temp0 x:) (temp0 y:))
							(= prevDir 0)
							(temp0 claimed: 1)
						)
					)
					($0040 ; direction
						(if (and controls (IsObject alterEgo))
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
						(gCast eachElementDo: #handleEvent temp0)
					)
				)
			)
			(if
				(and
					(== (temp0 type:) evKEYBOARD)
					(not (temp0 claimed:))
					(or (== (temp0 message:) echo) (<= KEY_SPACE (temp0 message:) $007f))
					canInput
					(self getInput: temp0)
					(Parse @local0 temp0)
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
			(= local0 0)
		)
		(if (!= (event message:) echo)
			(Format @local0 996 0 (event message:)) ; "%c"
		)
		(= temp0 (Sound pause: blocks))
		(= inputLineAddr @local0)
		(= temp1 (GetInput @local0 45 prompt 67 x y))
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
		(if MenuBar
			(MenuBar handleEvent: event)
		)
		(if global54
			(proc984_0 gSortedFeatures gCast gFeatures)
			(gSortedFeatures eachElementDo: #handleEvent event)
		else
			(gCast eachElementDo: #handleEvent event)
			(gFeatures eachElementDo: #handleEvent event)
		)
		(gGame handleEvent: event)
		(if (and (== (event type:) 128) (not (event claimed:)))
			(gGame pragmaFail: @local0)
		)
	)
)

