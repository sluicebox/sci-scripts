;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 808)
(include sci.sh)
(use Main)
(use eRS)
(use StopWalk)
(use Motion)
(use User)
(use System)

(public
	nosePick 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance nosePick of Code
	(properties)

	(method (doit)
		(if
			(and
				(User canControl:)
				(User canInput:)
				(IsObject gCurRoom)
				(gCurRoom isKindOf: SQRoom)
				(not (gCurRoom script:))
				(gEgo normal:)
				(not (& (gEgo signal:) $0008))
				(gEgo isStopped:)
				(IsObject (gEgo cycler:))
				((gEgo cycler:) isKindOf: StopWalk)
				(== (gEgo view:) ((gEgo cycler:) vStopped:))
				(== ((gEgo cycler:) vStopped:) 4)
			)
			(if (!= local0 (GetTime 1)) ; SysTime12
				(= local0 (GetTime 1)) ; SysTime12
				(if (> (++ local1) 120)
					(HandsOff)
					(gCurRoom setScript: nPS)
				)
			)
		else
			(= local1 0)
		)
	)
)

(instance nPS of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(Load rsVIEW 65)
				(if (!= (gEgo loop:) 2)
					(gEgo setHeading: 180 self)
				else
					(= cycles 1)
				)
			)
			(1
				(= temp0 (Random 0 2))
				(= local3 (gEgo signal:))
				(= local4 (gEgo priority:))
				(= local5 (gEgo illegalBits:))
				(= local6 (gEgo cycleSpeed:))
				(gEgo
					view: 65
					setLoop: temp0
					cycleSpeed: 12
					cel: 0
					setCycle: End self
				)
				(Animate (gCast elements:) 0)
			)
			(2
				(NormalEgo 2 0 4)
				(gEgo
					signal: local3
					priority: local4
					illegalBits: local5
					cycleSpeed: local6
				)
				(= local0 (= start 0))
				(= local1 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

