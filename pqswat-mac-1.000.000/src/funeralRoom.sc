;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 72)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use System)

(public
	funeralRoom 0
)

(instance funeralRoom of PQRoom
	(properties
		picture 0
	)

	(method (init)
		(super init: &rest)
		(= global415 0)
		(self setScript: showFuneral)
	)

	(method (dispose)
		(Lock rsAUDIO 9001 0)
		(gBackMusic fade: 0 2 21 1)
		(super dispose: &rest)
	)
)

(instance showFuneral of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(Load rsAUDIO 9001)
				(Lock rsAUDIO 9001 1)
				(= cycles 1)
			)
			(1
				(gGame showCloseUp: 9000 180 66 self)
			)
			(2
				(gBackMusic number: 9001 setLoop: -1 play:)
				(= cycles 1)
			)
			(3
				(= scratch (proc4_10))
				(switch scratch
					(1
						(if (gTimers contains: (ScriptID 0 7)) ; callUpTimer
							((ScriptID 0 7) dispose: delete:) ; callUpTimer
						)
						((ScriptID 60) doit: global419) ; dispatchPlayer
					)
					(2
						(-- state)
						(= cycles 1)
						(gGame restore:)
					)
					(3
						(SetFlag 113)
						(gGame getDisc: 1)
						(gCurRoom newRoom: 35) ; metroExt
					)
				)
			)
		)
	)
)

