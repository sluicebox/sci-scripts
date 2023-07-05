;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 702)
(include sci.sh)
(use Main)
(use Interface)

(public
	Room2Alley 0
	AlleyID2Alley 1
)

(local
	[alleyIndex 151] = [0 1 1 82 7 0 3 1 82 7 0 2 1 82 7 0 4 1 82 7 120 2 159 20 12 199 1 91 56 32 200 1 1 82 6 229 2 127 40 36 269 1 12 66 7 271 1 138 20 28 300 1 25 40 0 303 1 25 40 3 303 3 25 40 2 310 1 148 40 24 310 4 50 36 20 315 2 51 44 20 315 3 25 40 16 320 1 178 4 24 320 3 102 4 16 330 2 103 8 20 335 1 35 76 24 335 3 33 76 16 335 4 34 72 20 380 3 200 42 127 390 1 200 42 113 390 4 218 37 108 460 2 241 10 108 460 1 242 6 112 440 1 253 14 120 429 4 200 42 120 -1]
)

(procedure (Room2Alley &tmp i alleyID)
	(for
		((= i 0))
		(and
			(!= [alleyIndex i] -1)
			(or
				(!= [alleyIndex i] gPrevRoomNum)
				(!= [alleyIndex (+ i 1)] gRoomExitDir)
			)
		)
		((+= i 5))
	)
	(if (== [alleyIndex i] -1)
		(Printf 702 0 gPrevRoomNum gRoomExitDir) ; "Error: no alley index entry for room %d, heading %d"
		(= gQuit 1)
	)
	(= alleyID [alleyIndex (+ i 2)])
	(= gXEgo [alleyIndex (+ i 3)])
	(= gYEgo [alleyIndex (+ i 4)])
	(AlleyID2Alley alleyID)
)

(procedure (AlleyID2Alley id &tmp alleyEntry)
	(= gAlleyScript (+ (/ id 10) 710))
	(= alleyEntry (mod id 10))
	(ScriptID gAlleyScript alleyEntry)
)

