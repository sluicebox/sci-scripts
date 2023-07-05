;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 140)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use System)

(public
	openFromBelow 0
)

(procedure (localproc_0 &tmp [temp0 200])
	(Format @temp0 &rest)
	(Print @temp0 #at 120 10)
)

(instance openFromBelow of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 140)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 352)
				(client view: 82 loop: 2 cel: 0 cycleSpeed: 1 setCycle: End)
				(= cycles 20)
			)
			(1
				(localproc_0 140 0)
				(self cue:)
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(ClearFlag 352)
				(client stopUpd: setScript: 0)
			)
		)
	)
)

