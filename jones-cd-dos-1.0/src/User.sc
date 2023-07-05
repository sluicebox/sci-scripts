;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 996)
(include sci.sh)
(use Main)
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
			(if (& (temp0 type:) $0040) ; direction
				(temp0 type: $0040) ; direction
			)
			(if MenuBar
				(MenuBar handleEvent: temp0)
			)
			(if
				(and
					global527
					(not (temp0 claimed:))
					(or (& (temp0 type:) evKEYBOARD) (& (temp0 type:) evMOUSEBUTTON))
				)
				(= global528 1)
			)
			(if controls
				(gGame handleEvent: temp0)
			)
			(gCast handleEvent: temp0)
		)
		(temp0 dispose:)
		(= gLastEvent 0)
	)

	(method (getInput &tmp [temp0 2])
		(return 1)
	)

	(method (canControl value &tmp temp0)
		(if argc
			(= temp0 controls)
			(= controls value)
			(= prevDir 0)
			(if (and global302 (== (global302 playing:) 29) (not global536))
				(= controls 0)
			)
			(if (!= temp0 controls)
				(gGame setCursor: (if controls 999 else 997))
			)
		)
		(return controls)
	)

	(method (said)
		(return 1)
	)
)

