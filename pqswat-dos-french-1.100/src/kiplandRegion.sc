;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4054)
(include sci.sh)
(use Main)
(use PQRegion)
(use Timer)
(use Sound)
(use System)

(public
	kiplandRegion 0
	briefingTimer 1
	gunTimer 2
	callEveryOne 3
	egoTakingTooLongTimer 4
)

(class KiplandRegion of PQRegion
	(properties
		curBackSound 0
	)

	(method (init)
		(super init: &rest)
		(= global432 kiplandTalkerStopCode)
		(= initialized 0)
		(if (== gNewRoomNum 2990) ; s2_2990
			(Load rsAUDIO 29801)
		)
	)

	(method (setKeep)
		(= keep (IsFlag 109))
	)

	(method (doVerb theVerb)
		(switch theVerb
			(181
				(self setScript: callEveryOne)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(self changeMusic: 0)
		(= global432 0)
		(if (gTimers contains: briefingTimer)
			(briefingTimer dispose: delete:)
		)
		(if (gTimers contains: gunTimer)
			(gunTimer dispose: delete:)
		)
		(ClearFlag 126)
		(super dispose:)
	)

	(method (changeMusic param1)
		(if (and (gBackMusic handle:) (== curBackSound param1))
			(return)
		)
		(if
			(and
				curBackSound
				(or (not param1) (and argc param1 (!= curBackSound param1)))
			)
			(Lock rsAUDIO curBackSound 0)
		)
		(if (and argc param1 (!= curBackSound param1))
			(= curBackSound param1)
			(Load rsAUDIO curBackSound)
			(Lock rsAUDIO curBackSound 1)
			(gBackMusic stop:)
			(gBackMusic number: curBackSound loop: -1 play:)
		)
	)
)

(instance kiplandRegion of KiplandRegion
	(properties
		number 4054
	)
)

(instance callEveryOne of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: gunTimer)
					(gunTimer dispose: delete:)
				)
				(if (gTimers contains: egoTakingTooLongTimer)
					(egoTakingTooLongTimer dispose: delete:)
				)
				(if (gTimers contains: briefingTimer)
					(briefingTimer dispose: delete:)
				)
				(gGame showCloseUp: 29819 -1 -1 self 1)
			)
			(1
				(if (!= gCurRoomNum 4052) ; s2_405
					(gCurRoom newRoom: 4052) ; s2_405
				else
					(gCurRoom setScript: (ScriptID 4052 3)) ; sFirstTime
				)
			)
		)
	)
)

(instance briefingTimer of Timer
	(properties)

	(method (cue)
		(if (not (gCurRoom script:))
			(SetFlag 232)
			(kiplandRegion doVerb: 181)
		else
			(self setReal: self 10)
		)
	)
)

(instance gunTimer of Timer
	(properties)

	(method (cue)
		(if (kiplandRegion keep:)
			(gunShot number: (Random 2991 2992) loop: 1 play:)
		)
		(self setReal: self (Random 90 120))
	)
)

(instance gunShot of Sound
	(properties)
)

(instance kiplandTalkerStopCode of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(= temp1 (param1 plane:))
		(= temp0 0)
		(if
			(and
				(not (gThePlane onMe: param1))
				(or (param1 localize: gInterfacePlane) 1)
				(or
					((ScriptID 16 10) onMe: param1) ; stopButn
					((ScriptID 16 11) onMe: param1) ; lashButn
				)
			)
			(= temp0 1)
		)
		(if (and temp1 (!= temp1 (param1 plane:)))
			(param1 localize: temp1)
		)
		(return temp0)
	)
)

(instance egoTakingTooLongTimer of Timer
	(properties)

	(method (cue)
		(if (not (gCurRoom script:))
			(SetFlag 232)
			(kiplandRegion doVerb: 181)
		else
			(self setReal: self 10)
		)
	)
)

