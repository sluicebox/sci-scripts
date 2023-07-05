;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 235)
(include sci.sh)
(use Main)
(use eRS)
(use Inset)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	rm235 0
)

(local
	local0 = 1
)

(instance rm235 of LBRoom
	(properties
		modNum 230
		noun 24
		picture 235
	)

	(method (init)
		(Load rsVIEW 235)
		(super init:)
		(closeupBlotterLF init:)
		(closeupBlotterLB init:)
		(closeupBlotterRF init:)
		(closeupBlotterRB init:)
		(pencilHolder init:)
		(drawer init:)
		(restOfBlotter init:)
		(if (IsFlag 29)
			(keyInDrawerC init:)
		)
		(proc0_8 1)
		(gGame handsOn:)
	)

	(method (dispose)
		(proc0_8 0)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 24 1 0 0 0 230) ; "This is now your desk. It's very old and looks like it hasn't been cleaned thoroughly in years, but it's sturdy and serviceable."
			)
			(13 ; Exit Icon
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sLiftMat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch register
					(0
						(if (gCast contains: cornerUpLF)
							(cornerUpLF dispose:)
						else
							(cornerUpLF init:)
						)
					)
					(1
						(if (gCast contains: cornerUpLB)
							(cornerUpLB dispose:)
						else
							(cornerUpLB init:)
						)
					)
					(2
						(if (gCast contains: cornerUpRF)
							(cornerUpRF dispose:)
							(keyUnder dispose:)
						else
							(if (and (not (gEgo has: 5)) (not (IsFlag 29))) ; deskKey
								(keyUnder init:)
							)
							(cornerUpRF init:)
						)
					)
					(3
						(if (gCast contains: cornerUpRB)
							(cornerUpRB dispose:)
						else
							(cornerUpRB init:)
						)
					)
				)
				(= cycles 1)
			)
			(1
				(cond
					((and (gCast contains: cornerUpRF) (== register 2))
						(if (and (not (gEgo has: 5)) (not (IsFlag 29))) ; deskKey
							(gMessager say: 10 4 1 0 self 230) ; "You peel up a corner of the blotter to reveal a small key."
						else
							(gMessager say: 10 4 2 0 self 230) ; "You only find some lint under the desk blotter."
						)
					)
					((and (gCast contains: cornerUpRB) (== register 3))
						(gMessager say: 10 4 2 0 self 230) ; "You only find some lint under the desk blotter."
					)
					((and (gCast contains: cornerUpLB) (== register 1))
						(gMessager say: 10 4 2 0 self 230) ; "You only find some lint under the desk blotter."
					)
					((and (gCast contains: cornerUpLF) (== register 0))
						(gMessager say: 10 4 2 0 self 230) ; "You only find some lint under the desk blotter."
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sUseKeyOnDrawer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(gEgo put: 5) ; deskKey
				((ScriptID 21 1) doit: 774) ; dropCluesCode, Desk Key
				(SetFlag 29)
				(gMessager say: 9 16 0 0 self 230) ; "You unlock the drawer. Unfortunately, the key permanently jams itself in the lock. Let's hope you never want to lock this drawer again!"
			)
			(1
				(openDrawer init:)
				(sFX number: 42 play:)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance openDrawer of View
	(properties
		x 66
		y 120
		noun 20
		modNum 230
		view 235
		loop 1
		signal 16385
	)

	(method (init)
		(super init:)
		(if (not (gEgo has: 6)) ; pressPass
			(pressPass init:)
		)
		(if (IsFlag 29)
			(keyInDrawerC dispose:)
		)
		(keyInDrawerO init:)
	)

	(method (dispose)
		(super dispose:)
		(pressPass dispose:)
		(keyInDrawerO dispose:)
		(if (IsFlag 29)
			(keyInDrawerC init:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(4 ; Do
				(sFX number: 42 play:)
				(openDrawer dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cornerUpLF of View
	(properties
		x 69
		y 100
		noun 19
		modNum 230
		view 235
		priority 8
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cornerUpRF of View
	(properties
		x 200
		y 100
		noun 19
		modNum 230
		view 235
		cel 1
		priority 8
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cornerUpRB of View
	(properties
		x 174
		y 83
		noun 19
		modNum 230
		view 235
		cel 2
		priority 8
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cornerUpLB of View
	(properties
		x 97
		y 85
		noun 19
		modNum 230
		view 235
		cel 3
		priority 8
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance keyUnder of View
	(properties
		x 216
		y 118
		noun 21
		modNum 230
		view 235
		loop 3
		priority 9
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gEgo get: 5) ; deskKey
				((ScriptID 21 0) doit: 774) ; addCluesCode, Desk Key
				(keyUnder dispose:)
			)
			(1 ; Look
				(gCurRoom setInset: inKey)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance keyInDrawerO of View
	(properties
		x 154
		y 155
		noun 22
		modNum 230
		view 235
		loop 2
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance keyInDrawerC of View
	(properties
		x 154
		y 132
		noun 23
		modNum 230
		view 235
		loop 2
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pressPass of View
	(properties
		x 92
		y 137
		noun 27
		modNum 15
		view 235
		loop 4
		cel 1
		priority 14
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				((ScriptID 22 0) doit: $0001) ; triggerAndClock
				(gGame points: 1 128)
				(gEgo get: 6) ; pressPass
				((ScriptID 21 0) doit: 775) ; addCluesCode, Press Pass
				(pressPass dispose:)
			)
			(13 ; Exit Icon
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(1 ; Look
				(gCurRoom setInset: inPressPass)
				(gMessager say: 27 1 0 0 0 15) ; "A Press Pass. It reads: PRESS...your pants while you wait. LO FAT'S CHINESE LAUNDRY, 5858 Broadway Avenue, New York."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance inPressPass of Inset
	(properties
		view 235
		loop 4
		x 85
		y 129
		disposeNotOnMe 1
		modNum 15
		noun 27
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				((ScriptID 22 0) doit: $0001) ; triggerAndClock
				(gGame points: 1 128)
				(gEgo get: 6) ; pressPass
				((ScriptID 21 0) doit: 775) ; addCluesCode, Press Pass
				(pressPass dispose:)
				(inPressPass dispose:)
			)
			(1 ; Look
				(gMessager say: 27 1 0 0 0 15) ; "A Press Pass. It reads: PRESS...your pants while you wait. LO FAT'S CHINESE LAUNDRY, 5858 Broadway Avenue, New York."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance inKey of Inset
	(properties
		view 235
		loop 3
		cel 1
		x 187
		y 92
		hideTheCast 1
		disposeNotOnMe 1
		modNum 15
		noun 9
	)

	(method (init)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 9 1 0 0 0 15) ; "A common, everyday, ordinary key. Quite dull and boring, actually."
			)
			(4 ; Do
				(gEgo get: 5) ; deskKey
				((ScriptID 21 0) doit: 774) ; addCluesCode, Desk Key
				(inKey dispose:)
				(keyUnder dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance closeupBlotterRF of Feature
	(properties
		y 109
		noun 10
		modNum 230
		sightAngle 40
		onMeCheck 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sLiftMat 0 2)
			)
			(13 ; Exit Icon
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance closeupBlotterRB of Feature
	(properties
		y 95
		noun 10
		modNum 230
		sightAngle 40
		onMeCheck 8192
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sLiftMat 0 3)
			)
			(13 ; Exit Icon
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance closeupBlotterLB of Feature
	(properties
		y 95
		noun 10
		modNum 230
		sightAngle 40
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sLiftMat 0 1)
			)
			(13 ; Exit Icon
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance closeupBlotterLF of Feature
	(properties
		y 109
		noun 10
		modNum 230
		sightAngle 40
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sLiftMat 0 0)
			)
			(13 ; Exit Icon
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance restOfBlotter of Feature
	(properties
		y 109
		noun 26
		modNum 230
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pencilHolder of Feature
	(properties
		x 227
		y 78
		noun 8
		modNum 230
		nsTop 64
		nsLeft 219
		nsBottom 92
		nsRight 236
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Exit Icon
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance drawer of Feature
	(properties
		x 155
		y 137
		noun 9
		modNum 230
		nsTop 128
		nsLeft 67
		nsBottom 146
		nsRight 244
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(cond
					((gCast contains: openDrawer)
						(sFX number: 42 play:)
						(openDrawer dispose:)
					)
					((IsFlag 29)
						(sFX number: 42 play:)
						(openDrawer init:)
					)
					(local0
						(gMessager say: 9 4 3 0 0 230) ; "The desk drawer is locked."
					)
					((not (gEgo has: 6)) ; pressPass
						(sFX number: 42 play:)
						(openDrawer init:)
					)
					(else
						(gMessager say: 9 4 4 0 0 230) ; "There's nothing at all left in the drawer, unless you count the lint and dust in the corners."
					)
				)
			)
			(16 ; deskKey
				(gCurRoom setScript: sUseKeyOnDrawer)
			)
			(13 ; Exit Icon
				(proc0_8 0)
				(gCurRoom newRoom: 230)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sFX of Sound
	(properties
		flags 5
		number 42
	)
)

