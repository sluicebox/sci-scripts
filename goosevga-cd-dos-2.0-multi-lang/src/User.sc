;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 996)
(include sci.sh)
(use Main)
(use Interface)
(use n411)
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

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp4 0)
		(= temp0 (Event new:))
		(if (temp0 type:)
			(= gLastEvent temp0)
			(= global177 (!= (= temp1 (temp0 type:)) evKEYBOARD))
			(if mapKeyToDir
				(MapKeyToDir temp0)
			)
			(if TheMenuBar
				(TheMenuBar handleEvent: temp0)
			)
			(gGame handleEvent: temp0)
			(if (not (temp0 claimed:))
				(temp0 localize:)
				(switch (temp0 type:)
					(evMOUSEBUTTON
						(if
							(and
								controls
								(IsObject alterEgo)
								(gCast contains: alterEgo)
							)
							(alterEgo
								setMotion:
									Freeway
									global75
									(temp0 x:)
									(temp0 y:)
							)
							(= prevDir 0)
							(= global161 1)
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
							(if (not global158)
								(= global158 (GetTime))
							)
							(= global161 0)
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
				(not global161)
				(not global177)
				(> (Abs (- temp5 global158)) 29)
			)
			(if (not temp4)
				(if (not (gCurRoom script:))
					(= temp2 JOY_NULL)
					(alterEgo setDirection: 0)
				)
			else
				(= global158 temp4)
			)
		)
		(if
			(and
				(== (temp0 claimed:) 0)
				(== (temp0 type:) evVERB)
				(not (gCurRoom script:))
				(User controls:)
			)
			(HandsOff)
			(temp0 claimed: 1)
			(gEgo setMotion: 0)
			(gEgo loop: 13 cel: 1)
			((gEgo head:) loop: 8 doit:)
			(proc0_20)
			(proc411_0 (gEgo head:))
			(Animate (gCast elements:) 0)
			(gEgo say: (Random 524 573) self)
		)
		(temp0 dispose:)
		(= gLastEvent 0)
	)

	(method (cue)
		(DoSound sndMASTER_VOLUME global125)
		(proc411_1)
		(HandsOn)
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
)

