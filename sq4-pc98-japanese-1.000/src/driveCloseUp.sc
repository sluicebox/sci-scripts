;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 152)
(include sci.sh)
(use Main)
(use Interface)
(use brain)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	driveCloseUp 0
)

(local
	local0
	local1
	[local2 3]
	local5 = 1
	local6
	local7
)

(procedure (localproc_0 &tmp [temp0 20])
	(if local0
		(proc0_12 local0)
	)
	(if local1
		(proc0_12 local1)
	)
	(Format ; "%s %s"
		@temp0
		152
		0
		(if (== local6 1) {>} else { })
		(switch [local2 1]
			(1 {VOHAUL})
			(2 {ROGER JR})
			(else { })
		)
	)
	(= local0 (proc0_12 @temp0 67 62 10 28 global137 29 global129 70 75))
	(Format ; "%s %s"
		@temp0
		152
		0
		(if (== local6 2) {>} else { })
		(switch [local2 2]
			(1 {VOHAUL})
			(2 {ROGER JR})
			(else { })
		)
	)
	(= local1 (proc0_12 @temp0 67 62 20 28 global137 29 global129 70 75))
)

(instance driveCloseUp of View
	(properties
		x 76
		y 81
		description {control panel}
		view 150
		priority 13
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 152 1) ; "It is the brain's control panel."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(= view 150)
		(super init:)
		(gTheIconBar disable: 0 3 4 5 6 7)
		(self stopUpd:)
		(driveUpBut init:)
		(beamUpBut init:)
		(driveDownBut init:)
		(beamDownBut init:)
		(upArrowBut init:)
		(downArrowBut init:)
		(driveSlot init:)
	)

	(method (dispose)
		(gTheIconBar enable:)
		(driveUpBut dispose:)
		(beamUpBut dispose:)
		(driveDownBut dispose:)
		(beamDownBut dispose:)
		(upArrowBut dispose:)
		(downArrowBut dispose:)
		(driveSlot dispose:)
		((ScriptID 150 2) setMotion: MoveTo 120 110 (ScriptID 150 2)) ; diskDrive, diskDrive
		(super dispose:)
	)
)

(class CompProp of Prop
	(properties)

	(method (init)
		(self view: 150)
		(super init: &rest)
	)
)

(instance driveUpBut of CompProp
	(properties
		x 28
		y 121
		z 100
		description {drive upload button}
		view 150
		loop 2
		priority 12
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 152 2) ; "drive upload button"
			)
			(3 ; Do
				(gCurRoom setScript: buttonScript 0 self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance driveDownBut of CompProp
	(properties
		x 28
		y 140
		z 100
		description {drive download button}
		view 150
		loop 3
		priority 12
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 152 3) ; "drive download button"
			)
			(3 ; Do
				(gCurRoom setScript: buttonScript 0 self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance beamUpBut of CompProp
	(properties
		x 28
		y 159
		z 100
		description {beam upload button}
		view 150
		loop 4
		priority 12
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 152 4) ; "beam upload button"
			)
			(3 ; Do
				(gCurRoom setScript: buttonScript 0 self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance beamDownBut of CompProp
	(properties
		x 28
		y 178
		z 100
		description {beam download button}
		view 150
		loop 5
		priority 12
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 152 5) ; "beam download button"
			)
			(3 ; Do
				(gCurRoom setScript: buttonScript 0 self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance upArrowBut of CompProp
	(properties
		x 143
		y 125
		z 100
		description {up arrow}
		view 150
		loop 6
		priority 12
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 152 6) ; "up arrow"
			)
			(3 ; Do
				(gCurRoom setScript: buttonScript 0 self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance downArrowBut of CompProp
	(properties
		x 143
		y 147
		z 100
		description {down arrow}
		view 150
		loop 7
		priority 12
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 152 7) ; "down arrow"
			)
			(3 ; Do
				(gCurRoom setScript: buttonScript 0 self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance driveSlot of CompProp
	(properties
		x 64
		y 573
		z 500
		description {drive slot}
		view 150
		loop 1
		cel 1
		priority 14
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 152 8) ; "It is the disk drive slot."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance beep of Sound
	(properties
		number 102
	)
)

(instance buttonScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(beep play:)
				(register setPri: 15)
				(= cycles 1)
			)
			(1
				(switch register
					(driveDownBut
						(if (== ((gInventory at: 14) owner:) (ScriptID 150 2)) ; diskette, diskDrive
							(proc704_6 152 9)
						else
							(proc704_6 152 10)
						)
					)
					(beamDownBut
						(cond
							(local5
								(proc704_6 152 11)
								(= register 0)
							)
							((not local6)
								(proc704_6 152 12)
								(= register 0)
							)
							(else
								(proc704_6 152 13)
								(= local5 [local2 local6])
								(if (== local6 1)
									(= [local2 1] [local2 2])
									(= [local2 2] 0)
								else
									(= [local2 2] 0)
									(= local6 1)
								)
								(beep dispose:)
							)
						)
						(if (and register (== local5 1))
							(gCurRoom notify: -1)
						else
							(SetScore 66 25)
						)
					)
					(driveUpBut
						(cond
							(local7
								(proc704_6 152 14)
							)
							((== ((gInventory at: 14) owner:) (ScriptID 150 2)) ; diskette, diskDrive
								(if
									(not
										(or (== [local2 1] 2) (== [local2 2] 2))
									)
									(proc704_6 152 15)
									(if [local2 1]
										(= [local2 2] 2)
									else
										(= [local2 1] 2)
										(= local6 1)
									)
									(localproc_0)
									(= local7 1)
								else
									(proc704_6 152 16)
								)
							)
							(else
								(proc704_6 152 10)
							)
						)
					)
					(beamUpBut
						(switch local5
							(0
								(proc704_6 152 17)
							)
							(1
								(proc704_6 152 18)
								(if [local2 1]
									(= [local2 2] 1)
								else
									(= [local2 1] 1)
									(= local6 1)
								)
								(= local5 0)
								(localproc_0)
							)
							(2
								(proc704_6 152 19)
								(if [local2 1]
									(= [local2 2] 2)
								else
									(= [local2 1] 2)
									(= local6 1)
								)
								(= local5 0)
								(localproc_0)
							)
						)
					)
					(upArrowBut
						(if (> local6 1)
							(-- local6)
							(localproc_0)
						)
					)
					(downArrowBut
						(if (and [local2 2] (< local6 2))
							(++ local6)
							(localproc_0)
						)
					)
				)
				(= cycles 1)
			)
			(2
				(if (== register beamDownBut)
					(driveCloseUp dispose:)
				)
				(if (not register)
					(= register beamDownBut)
				)
				(register setPri: 12)
				(self dispose:)
			)
		)
	)
)

