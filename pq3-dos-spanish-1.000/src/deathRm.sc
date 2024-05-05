;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 877)
(include sci.sh)
(use Main)
(use Interface)
(use RandCycle)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	deathRm 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0)
	(repeat
		(switch
			(Print
				877
				0
				#button
				{Restore}
				1
				#button
				{Restart}
				2
				#button
				{____Quit____}
				3
			)
			(1
				(gGame restore:)
			)
			(2
				(gGame restart:)
			)
			(3
				(= gQuit 1)
				(break)
			)
		)
	)
)

(instance deathRm of Rm
	(properties
		picture 5
	)

	(method (init)
		(super init:)
		(HandsOff)
		(Load rsVIEW 100)
		(gTheIconBar curIcon: (gTheIconBar at: 6))
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
		(if (== global151 -1)
			(localproc_0)
		else
			(gLongSong number: 51 setLoop: -1 flags: 1 play:)
			(jMouth init:)
			(JHand setScript: handScript init:)
			(JOpenHand setScript: openHandScript init:)
			(JArm setScript: armScript init:)
			(JEye setScript: eyeScript init:)
			(self setScript: jimTalkScript)
		)
	)

	(method (dispose)
		(DisposeScript 941)
		(super dispose:)
	)
)

(instance jimTalkScript of Script
	(properties)

	(method (changeState newState &tmp temp0 [temp1 350])
		(switch (= state newState)
			(0
				(switch global151
					(0
						(= local0 506)
						(= local1 (= register 0))
					)
					(1
						(= local0 506)
						(= local1 (= register 1))
					)
					(2
						(= local0 506)
						(= local1 (= register 2))
					)
					(3
						(= local0 506)
						(= local1 (= register 3))
					)
					(4
						(= local0 506)
						(= local1 (= register 4))
					)
					(5
						(= local0 506)
						(= local1 (= register 5))
					)
					(6
						(= local0 506)
						(= register 6)
						(= local1 7)
					)
					(7
						(= local0 506)
						(= local1 (= register 8))
					)
					(8
						(= local0 506)
						(= local1 (= register 9))
					)
					(9
						(= local0 506)
						(= local1 (= register 10))
					)
					(10
						(= local0 506)
						(= local1 (= register 11))
					)
					(11
						(= local0 506)
						(= local1 (= register 12))
					)
					(12
						(= local0 506)
						(= local1 (= register 13))
					)
					(13
						(= local0 506)
						(= local1 (= register 14))
					)
					(14
						(= local0 506)
						(= local1 (= register 15))
					)
					(15
						(= local0 506)
						(= local1 (= register 16))
					)
					(16
						(= local0 506)
						(= register 17)
						(= local1 18)
					)
					(17
						(= local0 506)
						(= local1 (= register 19))
					)
					(18
						(= local0 506)
						(= local1 (= register 20))
					)
					(19
						(= local0 506)
						(= local1 (= register 21))
					)
					(20
						(= local0 506)
						(= local1 (= register 22))
					)
					(21
						(= local0 506)
						(= local1 (= register 23))
					)
					(22
						(= local0 506)
						(= local1 (= register 24))
					)
					(23
						(= local0 506)
						(= local1 (= register 25))
					)
					(24
						(= local0 506)
						(= local1 (= register 26))
					)
					(25
						(= local0 506)
						(= register 27)
						(= local1 28)
					)
					(27
						(= local0 506)
						(= register 30)
						(= local1 31)
					)
					(26
						(= local0 506)
						(= local1 (= register 29))
					)
					(28
						(= local0 506)
						(= local1 (= register 32))
					)
					(29
						(= local0 506)
						(= local1 (= register 33))
					)
					(30
						(= local0 506)
						(= local1 (= register 34))
					)
					(31
						(= local0 506)
						(= local1 (= register 35))
					)
				)
				(= seconds 3)
			)
			(1
				(if (<= register local1)
					(jMouth setCycle: RandCycle)
					(= local2 1)
					(GetFarText local0 register @temp1)
					(= local3
						(Display
							@temp1
							dsCOORD
							186
							0
							dsCOLOR
							global125
							dsALIGN
							alCENTER
							dsWIDTH
							140
							dsSAVEPIXELS
						)
					)
				)
				(cond
					((> register local1)
						(= seconds 2)
					)
					((> (= temp0 (StrLen @temp1)) 12)
						(= seconds (/= temp0 10))
					)
					(else
						(= seconds 3)
					)
				)
			)
			(2
				(= local2 0)
				(if (> register local1)
					(if (== global151 25)
						(gCurRoom newRoom: 310)
					else
						(localproc_0)
					)
				else
					(Display 877 0 dsRESTOREPIXELS local3)
					(++ register)
					(self start: 1 init:)
				)
			)
		)
	)
)

(instance jMouth of Prop
	(properties
		x 163
		y 40
		description {Jim's Mouth}
		view 100
		cycleSpeed 9
	)
)

(instance mouthScript of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(jMouth setCycle: 0)
				(= seconds (Random 0 5))
			)
			(1
				(jMouth setCycle: RandCycle)
				(= seconds (Random 1 8))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance JHand of Prop
	(properties
		x 189
		y 128
		description {Jim's Hand}
		view 100
		loop 2
		cycleSpeed 13
	)
)

(instance handScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(JHand setCycle: 0)
				(= seconds (Random 3 8))
			)
			(1
				(JHand setCycle: RandCycle)
				(= seconds (Random 1 4))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance JOpenHand of Prop
	(properties
		x 193
		y 127
		description {Jim's Hand}
		view 100
		loop 3
		priority 15
		signal 16400
	)
)

(instance openHandScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 6)
			)
			(1
				(if local2
					(= cycles 1)
				else
					(JOpenHand setCycle: End)
					(= seconds (Random 3 6))
				)
			)
			(2
				(if local2
					(= cycles 1)
				else
					(JOpenHand cel: 0)
					(= cycles 1)
				)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance JEye of Prop
	(properties
		x 166
		y 25
		description {Jim's Eye}
		view 100
		loop 1
		cycleSpeed 12
	)
)

(instance eyeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(JEye cel: 1)
				(= cycles 1)
			)
			(2
				(JEye cel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance JArm of Prop
	(properties
		x 111
		y 100
		view 100
		loop 4
		cycleSpeed 13
	)
)

(instance armScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(JArm setCycle: 0)
				(= seconds (Random 20 30))
			)
			(1
				(JArm cycleSpeed: 14 setCycle: End self)
			)
			(2
				(JArm setCycle: Beg self)
			)
			(3
				(self init:)
			)
		)
	)
)

