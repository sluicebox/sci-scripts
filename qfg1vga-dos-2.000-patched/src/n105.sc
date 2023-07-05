;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 105)
(include sci.sh)
(use Main)
(use n814)
(use PolyPath)
(use LoadMany)
(use Sound)
(use Motion)
(use System)

(public
	CastOpen 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
)

(procedure (CastOpen param1 param2 param3 param4 &tmp temp0 temp1)
	(if (not global102)
		(= local7 1)
	)
	(LoadMany rsSOUND 28 35)
	(= local4 0)
	(= local5 0)
	(= temp0 gEgo)
	(= temp1 0)
	(if argc
		(if (> argc 1)
			(= temp1 param2)
		)
		(if (> argc 2)
			(= local4 param3)
			(= local5 param4)
		)
		(= temp0 param1)
	)
	(temp0 setScript: clientCastOpen temp1)
)

(instance clientCastOpen of Script
	(properties)

	(method (dispose)
		(if local7
			(HandsOn)
		)
		(if (IsObject local6)
			(local6 stop: dispose:)
		)
		(NormalEgo)
		(gEgo
			loop: (if (not (gEgo loop:)) 5 else 4)
			priority: local1
			illegalBits: local2
			signal: local0
			cycleSpeed: local3
		)
		(super dispose:)
		(DisposeScript 105)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 10)
			)
			(1
				(HandsOff)
				(= local0 (gEgo signal:))
				(= local1 (gEgo priority:))
				(= local2 (gEgo illegalBits:))
				(= local3 (gEgo cycleSpeed:))
				(NormalEgo)
				(gGame setCursor: gWaitCursor 1)
				(if local4
					(gEgo setMotion: PolyPath local4 local5 self)
				else
					(self cue:)
				)
			)
			(2
				(gGame setCursor: gWaitCursor 1)
				(gEgo
					setMotion: 0
					setHeading:
						(if (OneOf (gEgo loop:) 2 4 0 6) 135 else 225)
						self
				)
			)
			(3
				(gEgo
					view: 521
					setLoop: (if (== (gEgo loop:) 5) 0 else 1)
					setCel: 0
					setPri: (gEgo priority:)
					cycleSpeed: 12
					setCycle: CT 2 1 self
				)
			)
			(4
				((= local6 (Sound new:)) number: 28 priority: 6 init: play:)
				(gEgo setCycle: End self)
			)
			(5
				(gEgo view: 4 loop: 2 setCel: 0)
				(= ticks 20)
			)
			(6
				(if
					(not
						(OneOf
							gCurRoomNum
							10
							13
							15
							16
							29
							30
							31
							41
							65
							67
							73
							76
							82
							83
							84
							91
							93
							94
							96
							97
							141
						)
					)
					(gMessager say: 11 0 0 1 self 558) ; "The spell has no effect."
				else
					(local6 number: 35 play:)
					(= ticks 30)
				)
			)
			(7
				(self dispose:)
			)
		)
	)
)

