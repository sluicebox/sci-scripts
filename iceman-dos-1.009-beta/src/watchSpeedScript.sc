;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 392)
(include sci.sh)
(use Interface)
(use subMarine_314)
(use Submarine_806)
(use Motion)
(use System)

(public
	watchSpeedScript 0
)

(instance watchSpeedScript of Script
	(properties)

	(method (doit)
		(if (and (not state) (> (Submarine hSpeed:) register))
			(self cue:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(Print 392 0) ; "You were going too fast for the scope. Although you are able to bring the scope back down, it is now inoperable."
				(if (== register 12)
					(subMarine roomFlags: (| (subMarine roomFlags:) $0200))
					(Submarine flags: (| (Submarine flags:) $0010))
				else
					(subMarine roomFlags: (| (subMarine roomFlags:) $0100))
					(Submarine flags: (| (Submarine flags:) $0020))
				)
				(client setCycle: Beg client)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 392)
	)
)

