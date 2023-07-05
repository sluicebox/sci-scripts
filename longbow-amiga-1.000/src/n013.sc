;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	proc13_0 0
	proc13_1 1
	proc13_2 2
	Say 4
	SayModeless 5
	SetMessageColor 6
	proc13_7 7
)

(local
	local0
	local1
	[local2 4]
	local6
)

(procedure (localproc_0 param1 param2 &tmp temp0 [temp1 500])
	(if (u< (= temp0 param2) 1000)
		(= temp0 @temp1)
		(Format @temp1 param2 &rest)
	)
	(if param1
		(= local1 (StrLen temp0))
	else
		(TextSize @[local2 0] temp0 gUserFont 0)
	)
)

(procedure (proc13_0 param1 param2 &tmp temp0)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(localproc_0 0 param1 param2)
	(= temp0 (if (> [local2 2] 24) 200 else 0))
	(cond
		((== argc 1)
			(Print param1 #width temp0 #mode 1)
		)
		((u< param1 1000)
			(Print param1 param2 #width temp0 #mode 1 &rest)
		)
		(else
			(Print param1 70 temp0 30 1 param2 &rest)
		)
	)
)

(procedure (proc13_1 param1)
	(proc13_0 param1 &rest 67 -1 5)
)

(procedure (proc13_2 param1 &tmp temp0)
	(localproc_0 0 param1 &rest)
	(= temp0 [local2 2])
	(proc13_0 param1 &rest 67 -1 (- 170 temp0))
)

(procedure (Say param1 param2 param3 &tmp [temp0 200])
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(= local6 (== gTheCursor 5))
	(GetFarText param1 param2 @temp0)
	(= local0 (+ global162 (* global163 (StrLen @temp0))))
	(cond
		((< argc 3)
			(gGame setCursor: 5 (not (HaveMouse)))
			(proc13_0 @temp0 67 -1 5)
			(proc13_7)
		)
		((and (IsObject param3) (param3 respondsTo: #notKilled))
			(if (not (param3 notKilled:))
				(param3 cue: 0)
			else
				(gGame setCursor: 5 (not (HaveMouse)))
				(stopMessage init: param3)
				(proc13_0
					@temp0
					67
					-1
					5
					108
					stopMessage
					25
					(Max (/ local0 60) 3)
					&rest
				)
			)
		)
		((IsObject param3)
			(gGame setCursor: 5 (not (HaveMouse)))
			(stopMessage init: param3)
			(proc13_0
				@temp0
				67
				-1
				5
				25
				(Max (/ local0 60) 3)
				108
				stopMessage
				&rest
			)
		)
		((== param3 1)
			(gGame setCursor: 5 (not (HaveMouse)))
			(stopMessage init: 0)
			(proc13_0
				@temp0
				67
				-1
				5
				25
				(Max (/ local0 60) 3)
				108
				stopMessage
				&rest
			)
		)
		(else
			(gGame setCursor: 5 (not (HaveMouse)))
			(proc13_0 @temp0 67 -1 5 param3 &rest)
			(proc13_7)
		)
	)
)

(procedure (SayModeless param1 param2 param3 &tmp [temp0 200])
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
	(= local6 (== gTheCursor 5))
	(GetFarText param1 param2 @temp0)
	(= local0 (+ global162 (* global163 (StrLen @temp0))))
	(cond
		((< argc 3)
			(gGame setCursor: 5 (not (HaveMouse)))
			(proc13_2 @temp0)
			(proc13_7)
		)
		((and (IsObject param3) (param3 respondsTo: #notKilled))
			(if (not (param3 notKilled:))
				(param3 cue: 0)
			else
				(gGame setCursor: 5 (not (HaveMouse)))
				(stopMessage init: param3)
				(proc13_2 @temp0 108 stopMessage 25 (/ local0 60) &rest)
			)
		)
		((IsObject param3)
			(gGame setCursor: 5 (not (HaveMouse)))
			(stopMessage init: param3)
			(proc13_2 @temp0 25 (/ local0 60) 108 stopMessage &rest)
		)
		((== param3 1)
			(gGame setCursor: 5 (not (HaveMouse)))
			(stopMessage init: 0)
			(proc13_2 @temp0 25 (/ local0 60) 108 stopMessage &rest)
		)
		(else
			(gGame setCursor: 5 (not (HaveMouse)))
			(proc13_2 @temp0 param3 &rest)
			(proc13_7)
		)
	)
)

(procedure (SetMessageColor param1 &tmp temp0)
	(= temp0 (not (IsFlag 0)))
	(if (u> param1 33)
		(= param1 33)
	)
	(gSystemWindow
		color:
			(switch param1
				(0 global187)
				(1 global180)
				(2 global176)
				(3 global184)
				(4 global181)
				(5 global172)
				(6 global176)
				(7 global172)
				(8
					(if temp0 global181 else global180)
				)
				(9 global172)
				(10 global185)
				(11 global177)
				(12 global177)
				(13 global177)
				(14
					(if temp0 global171 else global182)
				)
				(15 global171)
				(16
					(if (== global202 64) global179 else global171)
				)
				(17 global184)
				(18 global171)
				(19 global171)
				(20 global185)
				(21 global175)
				(22 global185)
				(23 global180)
				(24 global185)
				(25
					(if temp0 global185 else global183)
				)
				(26
					(if (== global202 64) global175 else global183)
				)
				(27 global170)
				(28 global183)
				(29 global185)
				(30 global175)
				(31 global184)
				(32 global170)
				(33 global184)
			)
		back:
			(switch param1
				(0 global186)
				(1 global176)
				(2 global180)
				(3 global176)
				(4 global176)
				(5 global184)
				(6 global185)
				(7
					(if temp0 global181 else global180)
				)
				(8 global172)
				(9 global185)
				(10 global171)
				(11 global180)
				(12 global181)
				(13 global185)
				(14 global176)
				(15 global181)
				(16 global178)
				(17 global171)
				(18 global183)
				(19 global184)
				(20 global176)
				(21 global184)
				(22 global177)
				(23 global174)
				(24 global171)
				(25 global175)
				(26 global176)
				(27 global180)
				(28 global170)
				(29 global170)
				(30 global181)
				(31 global174)
				(32 global185)
				(33 global175)
			)
	)
)

(procedure (proc13_7 &tmp temp0)
	(= temp0 (if (& (gInventory state:) $0020) gInventory else gTheIconBar))
	(gGame
		setCursor:
			(cond
				(local6 5)
				(global143 gWaitCursor)
				(else
					((temp0 curIcon:) cursor:)
				)
			)
			1
	)
)

(instance stopMessage of Script
	(properties)

	(method (init param1)
		(= register 1)
		(= caller param1)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (cue)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(proc13_7)
		(if (IsObject caller)
			(caller cue: register)
		)
	)

	(method (handleEvent event)
		(event claimed: 1)
		(if
			(or
				(and (& (event modifiers:) emSHIFT) (& (event type:) evMOUSEBUTTON))
				(and (& (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			)
			(= register 0)
		)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
	)
)

