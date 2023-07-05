;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use n045)
(use Print)
(use System)

(public
	proc30_0 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (proc30_0 param1 param2 param3 param4 param5 param6)
	(gTheIconBar disable:)
	(gTheCursor view: 999 loop: 0 cel: 0 show:)
	(gGame setCursor: gTheCursor 1)
	(if argc
		(= local0 param1)
		(= local1 param2)
		(= local2 param3)
		(if (> argc 3)
			(if param4
				(= local3 param4)
			else
				(= local3 1)
			)
			(if (> argc 4)
				(= local4 param5)
				(if (== argc 6)
					(= local5 param6)
				else
					(= local5 972)
				)
			else
				(= local4 30)
				(= local5 972)
			)
		else
			(= local3 1)
			(= local4 30)
			(= local5 972)
		)
	else
		(= local0 1)
		(= local1 0)
		(= local2 1)
		(= local3 1)
		(= local4 30)
		(= local5 972)
	)
	(die init:)
)

(instance die of Script
	(properties)

	(method (init)
		(gTheDoits add: self)
		(super init: &rest)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (cue)
		(self changeState: (+ state 1) &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSounds eachElementDo: #stop)
				(gGlobalSound0 number: local5 setLoop: 1 play:)
				(FrameOut)
				(PalVary 0 (+ (gCurRoom picture:) 1) 2 100 2) ; PalVaryStart
				(= ticks 280)
			)
			(1
				(= register 1)
				(proc45_1)
				(while register
					(switch
						(Print
							fore: 0
							addBitmap: 64994 3 0
							width: 192
							mode: 1
							addText: local0 local1 local2 local3 0 10 local4
							addButtonBM: 64994 2 0 1 1 0 2 1 6 59 30
							addButtonBM: 64994 2 0 2 1 0 3 1 69 59 30
							addButtonBM: 64994 2 0 3 1 0 4 1 129 59 30
							init:
						)
						(1
							(gGame restore:)
						)
						(2
							(= register 0)
							(gGame restart: 3)
						)
						(3
							(= gQuit 1)
							(break)
						)
					)
				)
				(proc45_2)
			)
		)
	)
)

