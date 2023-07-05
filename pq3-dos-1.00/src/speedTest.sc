;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 99)
(include sci.sh)
(use Main)
(use Interface)
(use n882)
(use n940)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	speedTest 0
)

(local
	local0
	local1
	local2
	local3
)

(procedure (localproc_0)
	(SetFlag 0)
	(SetFlag 1)
	(SetFlag 8)
	(ClearFlag 9)
	(SetFlag 10)
	(SetFlag 11)
	(SetFlag 12)
	(SetFlag 14)
	(SetFlag 15)
	(SetFlag 17)
	(SetFlag 39)
	(SetFlag 46)
	(SetFlag 47)
	(SetFlag 55)
	(SetFlag 59)
	(SetFlag 68)
	(SetFlag 69)
	(SetFlag 71)
	(SetFlag 72)
	(SetFlag 73)
	(SetFlag 85)
	(SetFlag 89)
	(if (Print 99 0 #button {YES} 1 #button {NO} 0) ; "Stopped lowrider?"
		(SetFlag 13)
		(if (Print 99 1 #button {YES} 1 #button {NO} 0) ; "Got right ticket code?"
			(SetFlag 70)
		)
	)
	(= gDay 2)
	(gEgo get: 28) ; noteBook
	(gEgo get: 29) ; necklace
	(if (Print 99 2 #button {YES} 1 #button {NO} 0) ; "Found the star?"
		(gEgo get: 32) ; bronzeStar
	)
	(if (Print 99 3 #button {YES} 1 #button {NO} 0) ; "Got reporter card?"
		(gEgo get: 38) ; busCard
	)
	(gEgo get: 21) ; compCard
)

(procedure (localproc_1)
	(SetFlag 18)
	(SetFlag 40)
	(SetFlag 75)
	(SetFlag 76)
	(SetFlag 77)
	(SetFlag 78)
	(SetFlag 79)
	(SetFlag 195)
	(if (Print 99 4 #button {YES} 1 #button {NO} 0) ; "Placed news story?"
		(SetFlag 19)
	)
	(= gDay 3)
	(= global134 1)
	(= global141 3)
	(= global142 3)
)

(procedure (localproc_2)
	(SetFlag 24)
	(SetFlag 25)
	(SetFlag 26)
	(SetFlag 27)
	(SetFlag 74)
	(SetFlag 91)
	(= gDay 4)
)

(procedure (localproc_3)
	(SetFlag 22)
	(SetFlag 29)
	(SetFlag 38)
	(SetFlag 49)
	(SetFlag 80)
	(SetFlag 82)
	(SetFlag 84)
	(SetFlag 86)
	(SetFlag 87)
	(SetFlag 205)
	(SetFlag 41)
	(SetFlag 42)
	(SetFlag 43)
	(SetFlag 62)
	(SetFlag 29)
	(SetFlag 188)
	(ClearFlag 28)
	(= global150 1)
	(= gDay 5)
	(= global143 4)
	(= global144 4)
	(proc882_0 8)
)

(procedure (localproc_4)
	(SetFlag 23)
	(SetFlag 32)
	(SetFlag 33)
	(SetFlag 30)
	(SetFlag 31)
	(SetFlag 34)
	(SetFlag 51)
	(SetFlag 88)
	(SetFlag 197)
	(SetFlag 198)
	(SetFlag 204)
	(= gDay 6)
	(= global149 4)
)

(procedure (localproc_5)
	(SetFlag 50)
	(SetFlag 53)
	(gEgo get: 9) ; judicialOrder
	(if (Print 99 5 #button {YES} 1 #button {NO} 0) ; "Turn Morales in?"
		(SetFlag 48)
	)
	(if (Print 99 6 #button {YES} 1 #button {NO} 0) ; "Marie to live?"
		((gInventory at: 37) owner: 36) ; locket
		((gInventory at: 5) owner: 36) ; musicBox
		((gInventory at: 36) owner: 36) ; rose
	)
)

(instance fred of Actor
	(properties)
)

(instance speedTest of Rm
	(properties
		picture 99
		style 100
	)

	(method (init)
		(ScriptID 882)
		(= local2 (FileIO fiOPEN {version} 1))
		(FileIO fiREAD_STRING gVersion 6 local2)
		(FileIO fiCLOSE local2)
		(super init:)
		(gSounds eachElementDo: #stop)
		(while (u> (GetTime) -1024)
		)
		(fred
			view: 99
			setLoop: 0
			illegalBits: 0
			posn: 20 99
			setStep: 1 1
			setMotion: MoveTo 300 100
			setCycle: Fwd
			init:
		)
		(= gSpeed 0)
		(= local1 0)
		(= local3 (if (IsFlag 2) 90 else 40))
	)

	(method (doit)
		(super doit:)
		(if (== (++ local1) 1)
			(= local0 (+ 60 (GetTime)))
		)
		(if (and (u< local0 (GetTime)) (not (self script:)))
			(if (< local1 local3)
				(= gHowFast 0)
				(gGame detailLevel: 1)
			else
				(= gHowFast 2)
			)
			(self setScript: speedScript)
		)
	)

	(method (dispose)
		(DisposeScript 882)
		(super dispose:)
	)
)

(instance speedScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(Palette palSET_INTENSITY 0 255 100)
				(fred setMotion: 0)
				(= cycles 1)
			)
			(1
				(= gSpeed 2)
				(= cycles 1)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(if (== (StrAt gVersion 2) 121)
					(HandsOn)
					(gLongSong stop:)
					(client setScript: cheatScript)
				else
					(gCurRoom newRoom: global104)
				)
			)
		)
	)
)

(instance cheatScript of Script
	(properties)

	(method (changeState newState &tmp temp0 [temp1 5])
		(switch (= state newState)
			(0
				(= temp1 0)
				(= temp0 0)
				(if
					(>
						(= temp0
							(PrintD
								{What day Bub?}
								41
								@temp1
								5
								106
								81
								{Two}
								200
								81
								{Three}
								300
								81
								{Four}
								400
								81
								{Five}
								500
								81
								{Six}
								600
								81
								{Ending}
								700
							)
						)
						0
					)
					(DisposeScript 940)
					(switch temp0
						(200
							(localproc_0)
							(= temp0 18)
						)
						(300
							(localproc_0)
							(localproc_1)
							(= temp0 18)
						)
						(400
							(localproc_0)
							(localproc_1)
							(localproc_2)
							(= temp0 18)
						)
						(500
							(localproc_0)
							(localproc_1)
							(localproc_2)
							(localproc_3)
							(= temp0 18)
						)
						(600
							(localproc_0)
							(localproc_1)
							(localproc_2)
							(localproc_3)
							(localproc_4)
							(= temp0 18)
						)
						(700
							(localproc_0)
							(localproc_1)
							(localproc_2)
							(localproc_3)
							(localproc_4)
							(localproc_5)
							(= temp0 56)
						)
					)
					(if temp1
						(= temp0 (ReadNumber @temp1))
					)
					(gCurRoom newRoom: temp0)
				)
			)
		)
	)
)

