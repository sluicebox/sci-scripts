;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 95)
(include sci.sh)
(use System)

(local
	local0
)

(class Audio of Obj
	(properties
		number 0
		loop 1
		paused 0
		doNotStop 0
		stopped 1
	)

	(method (play param1)
		(= local0 0)
		(cond
			((DoAudio audPLAY number)
				(= stopped 0)
				(if (IsObject param1)
					(= local0 param1)
				)
				(self check:)
			)
			((and (IsObject param1) (!= (= local0 param1) 0))
				(local0 cue:)
			)
		)
	)

	(method (stop)
		(= stopped 1)
		(DoAudio audSTOP)
	)

	(method (pause)
		(if (not paused)
			(DoAudio audPAUSE)
			(self paused: 1)
		)
	)

	(method (resume)
		(if paused
			(DoAudio audRESUME)
			(self paused: 0)
		)
	)

	(method (setLoop param1)
		(self loop: param1)
	)

	(method (setRate param1)
		(if argc
			(DoAudio audRATE param1)
		)
	)

	(method (check &tmp temp0)
		(if (and (not stopped) (== (DoAudio audPOSITION) -1) (== loop 1))
			(= doNotStop 0)
			(= stopped 1)
			(if (!= local0 0)
				(= temp0 local0)
				(= local0 0)
				(temp0 cue:)
			)
		)
		(if (and (not stopped) (== (DoAudio audPOSITION) -1) (or (> loop 1) (== loop -1)))
			(self play:)
		)
	)
)

