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
		view 150
		priority 14
		signal 16
	)

	(method (init)
		(super init:)
		(HandsOff)
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
		(HandsOn)
		(driveUpBut dispose:)
		(beamUpBut dispose:)
		(driveDownBut dispose:)
		(beamDownBut dispose:)
		(upArrowBut dispose:)
		(downArrowBut dispose:)
		(driveSlot dispose:)
		(gCurRoom drawPic: (gCurRoom picture:))
		((ScriptID 150 2) setMotion: MoveTo 120 110 (ScriptID 150 2)) ; diskDrive, diskDrive
		(super dispose:)
	)
)

(instance driveUpBut of Prop
	(properties
		x 28
		y 21
		description {drive upload button}
		view 150
		loop 2
		priority 13
		signal 16
	)

	(method (handleEvent event)
		(if (MousedOn self event)
			(event claimed: 1)
			(gCurRoom setScript: buttonScript 0 self)
		)
	)
)

(instance driveDownBut of Prop
	(properties
		x 28
		y 40
		description {drive download button}
		view 150
		loop 3
		priority 13
		signal 16
	)

	(method (handleEvent event)
		(if (MousedOn self event)
			(event claimed: 1)
			(gCurRoom setScript: buttonScript 0 self)
		)
	)
)

(instance beamUpBut of Prop
	(properties
		x 28
		y 59
		description {beam upload button}
		view 150
		loop 4
		priority 13
		signal 16
	)

	(method (handleEvent event)
		(if (MousedOn self event)
			(event claimed: 1)
			(gCurRoom setScript: buttonScript 0 self)
		)
	)
)

(instance beamDownBut of Prop
	(properties
		x 28
		y 78
		description {beam download button}
		view 150
		loop 5
		priority 13
		signal 16
	)

	(method (handleEvent event)
		(if (MousedOn self event)
			(event claimed: 1)
			(gCurRoom setScript: buttonScript 0 self)
		)
	)
)

(instance upArrowBut of Prop
	(properties
		x 143
		y 25
		description {up arrow}
		view 150
		loop 6
		priority 13
		signal 16
	)

	(method (handleEvent event)
		(if (MousedOn self event)
			(event claimed: 1)
			(gCurRoom setScript: buttonScript 0 self)
		)
	)
)

(instance downArrowBut of Prop
	(properties
		x 143
		y 47
		description {down arrow}
		view 150
		loop 7
		priority 13
		signal 16
	)

	(method (handleEvent event)
		(if (MousedOn self event)
			(event claimed: 1)
			(gCurRoom setScript: buttonScript 0 self)
		)
	)
)

(instance driveSlot of Prop
	(properties
		x 64
		y 73
		description {drive slot}
		view 150
		loop 1
		priority 13
		signal 16
	)

	(method (init)
		(if (== ((gInventory at: 15) owner:) (ScriptID 150 2)) ; diskette, diskDrive
			(self setCel: 1 setPri: 15)
		else
			(self setCel: 0 setPri: 13)
		)
		(super init:)
	)

	(method (handleEvent event)
		(if (MousedOn self event)
			(self doVerb: 6 (gInventory indexOf: (gInventory curIcon:)))
		)
	)

	(method (doVerb theVerb invItem)
		(if (and (== theVerb 6) (== invItem 15)) ; Inventory, diskette
			(self setPri: 15 setCycle: End)
			(gEgo put: 15 (ScriptID 150 2)) ; diskette, diskDrive
		else
			(super doVerb: theVerb invItem &rest)
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
						(if (== ((gInventory at: 15) owner:) (ScriptID 150 2)) ; diskette, diskDrive
							(proc704_6 152 1)
						else
							(proc704_6 152 2)
						)
					)
					(beamDownBut
						(cond
							(local5
								(proc704_6 152 3)
							)
							((not local6)
								(proc704_6 152 4)
							)
							(else
								(proc704_6 152 5)
								(= local5 [local2 local6])
								(if (== local6 1)
									(= [local2 1] [local2 2])
									(= [local2 2] 0)
								else
									(= [local2 2] 0)
									(= local6 1)
								)
							)
						)
					)
					(driveUpBut
						(cond
							(local7
								(proc704_6 152 6)
							)
							((== ((gInventory at: 15) owner:) (ScriptID 150 2)) ; diskette, diskDrive
								(if
									(not
										(or (== [local2 1] 2) (== [local2 2] 2))
									)
									(proc704_6 152 7)
									(if [local2 1]
										(= [local2 2] 2)
									else
										(= [local2 1] 2)
										(= local6 1)
									)
									(localproc_0)
									(= local7 1)
								else
									(proc704_6 152 8)
								)
							)
							(else
								(proc704_6 152 2)
							)
						)
					)
					(beamUpBut
						(switch local5
							(0
								(proc704_6 152 9)
							)
							(1
								(proc704_6 152 10)
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
								(proc704_6 152 11)
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
				(register setPri: 13)
				(if (== register beamDownBut)
					(driveCloseUp dispose:)
				)
				(self dispose:)
			)
		)
	)
)

