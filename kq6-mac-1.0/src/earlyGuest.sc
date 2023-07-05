;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 741)
(include sci.sh)
(use Main)
(use rgCastle)
(use System)

(public
	earlyGuest 0
)

(instance earlyGuest of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 741)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 80 5) view: 724 loop: 4 cel: 0 x: 129 y: 155 init:) ; guard1
				((ScriptID 80 6) view: 726 loop: 4 cel: 1 x: 151 y: 153 init:) ; guard2
				((ScriptID 80 0) setupGuards:) ; rgCastle
				(= cycles 2)
			)
			(1
				((ScriptID 80 6) setHeading: 180 self) ; guard2
			)
			(2
				(gMessager say: 1 0 10 1 self) ; "Uh, oh! Alexander's walked right into a couple of guard dogs!"
			)
			(3
				(gMessager say: 1 0 10 2 self) ; "Look! An early guest. Are you on the bride or the groom's side?"
			)
			(4
				((ScriptID 80 5) setHeading: 180 self) ; guard1
			)
			(5
				(gMessager say: 1 0 10 3 self) ; "That's no guest! That's the foreigner the vizier warned us about! Grab him!"
			)
			(6
				(= cycles 2)
			)
			(7
				(gCurRoom moveOtherGuard: 1 spotEgo: (proc80_7))
				(self dispose:)
			)
		)
	)
)

