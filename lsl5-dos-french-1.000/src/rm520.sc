;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 520)
(include sci.sh)
(use Main)
(use eRS)
(use Sound)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm520 0
)

(local
	dispSave1
	dispSave2
)

(procedure (Restore)
	(Display 520 14 dsRESTOREPIXELS dispSave1)
	(Display 520 14 dsRESTOREPIXELS dispSave2)
)

(instance rm520 of LLRoom
	(properties
		lookStr {You are looking at "The Hard Disk Cafe's" exclusive paper membership tape reader. It controls admittance to the club.}
		picture 520
	)

	(method (init)
		(Load rsSOUND 258)
		(HandsOff)
		(SetupExit 1)
		(super init:)
		(gEgo hide:)
		(switch gPrevRoomNum
			(510
				(self setScript: sLobby)
			)
			(else
				(self setScript: sCafe)
			)
		)
	)

	(method (doVerb)
		(self setScript: sTapeout 0 gPrevRoomNum)
	)

	(method (newRoom newRoomNumber)
		(SetupExit 0)
		(super newRoom: newRoomNumber)
	)
)

(instance sLobby of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(if (not (gEgo has: 14)) ; Membership_Tape
					(+= state 2)
				)
				(= cycles 2)
			)
			(1
				(TPrint 520 0) ; "You carefully insert your paper membership tape into the ancient machine."
				(tape init: setCycle: End setMotion: MoveTo 313 18 self)
				(sucking play:)
			)
			(2
				(= seconds 2)
			)
			(3
				(if (not (gEgo has: 14)) ; Membership_Tape
					(Display 520 1 dsCOORD 75 60 dsCOLOR gColDGreen dsWIDTH 150 dsFONT gSmallFont) ; "Welcome to "THE HARD DISK CAFE" customer database. Please insert your membership tape now."
					(= seconds 5)
				else
					(= dispSave1
						(Display ; "Processing..."
							520
							2
							dsCOORD
							75
							60
							dsCOLOR
							gColDGreen
							dsWIDTH
							150
							dsFONT
							gSmallFont
							dsSAVEPIXELS
						)
					)
					(++ state)
					(= seconds 3)
				)
			)
			(4
				(TPrint 520 3 #at -1 185) ; "Since you have no membership tape, you decide there's no use wasting your time here."
				(gCurRoom newRoom: 510)
			)
			(5
				(HandsOn)
				(switch ((Inv at: 14) state:) ; Membership_Tape
					(1
						(Display ; "User #104725029871492 found. Welcome, Mr. Larry Laffer. Tonight you are assigned to Track 45, Sector 4F."
							520
							4
							dsCOORD
							75
							72
							dsCOLOR
							gColDGreen
							dsWIDTH
							150
							dsFONT
							gSmallFont
						)
					)
					(2
						(Display ; "User #104725029871491 found. Welcome, SuperUser Laffer. Go right on in. Sit anywhere you like. Make yourself at home."
							520
							5
							dsCOORD
							75
							72
							dsCOLOR
							gColDGreen
							dsWIDTH
							150
							dsFONT
							gSmallFont
						)
					)
					(3
						(Display ; "SuperUser #1 found. Welcome, Mr. Gilbert Hyatt! Go right on in. Make yourself at home. Sit anywhere you like!"
							520
							6
							dsCOORD
							75
							72
							dsCOLOR
							gColDGreen
							dsWIDTH
							150
							dsFONT
							gSmallFont
						)
					)
				)
				(= seconds 5)
			)
			(6
				(gCurRoom setScript: sTapeout 0 510)
			)
		)
	)
)

(instance sCafe of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(TPrint 520 7) ; "You carefully insert your paper membership tape into the ancient machine."
				(tape init: setCycle: End setMotion: MoveTo 313 18 self)
				(sucking play:)
			)
			(2
				(= seconds 2)
			)
			(3
				(= dispSave1
					(Display ; "Processing..."
						520
						2
						dsCOORD
						75
						60
						dsCOLOR
						gColDGreen
						dsWIDTH
						150
						dsFONT
						gSmallFont
						dsSAVEPIXELS
					)
				)
				(= seconds 3)
			)
			(4
				(switch ((Inv at: 14) state:) ; Membership_Tape
					(1
						(= dispSave2
							(Display ; "User 104725029871491 found. ALERT! ALERT! SysLevUser Error!"
								520
								8
								dsCOORD
								75
								72
								dsCOLOR
								gColDGreen
								dsWIDTH
								150
								dsFONT
								gSmallFont
								dsSAVEPIXELS
							)
						)
						(= register 1)
					)
					(2
						(HandsOn)
						(Points 8 111)
						(Display ; "User #104725029871491 found. Welcome, SuperUser Laffer. You may now enter the "Herman Hollerith Room.""
							520
							9
							dsCOORD
							75
							72
							dsCOLOR
							gColDGreen
							dsWIDTH
							150
							dsFONT
							gSmallFont
						)
					)
					(3
						(HandsOn)
						(Points 12 111)
						(Display ; "SuperUser #1 found. Welcome, Mr. Gilbert Hyatt. Feel free to enter the "Herman Hollerith Room." Sit wherever you wish."
							520
							10
							dsCOORD
							75
							72
							dsCOLOR
							gColDGreen
							dsWIDTH
							150
							dsFONT
							gSmallFont
						)
					)
				)
				(= seconds 5)
			)
			(5
				(if register
					(Restore)
					(Display ; "Listen, Laffer: your lowly clearance level prevents access to the exclusive "Herman Hollerith Room." You were assigned to Track 45, Sector 4F. Now sit there!"
						520
						11
						dsCOORD
						75
						(- 72 (proc0_28 0 0 15 0 0))
						dsCOLOR
						gColDGreen
						dsWIDTH
						150
						dsFONT
						gSmallFont
					)
					(HandsOn)
					(= seconds 6)
				else
					(= cycles 1)
				)
			)
			(6
				(gCurRoom setScript: sTapeout 0 525)
			)
		)
	)
)

(instance sTapeout of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (> ((Inv at: 14) state:) 1) (== gPrevRoomNum 525)) ; Membership_Tape
					(Say gEgo 520 12) ; "Hey! Come on! Gimme back my tape!"
					(TPrint 520 13) ; "That stupid machine ate your tape! You hope you won't need it again, Larry."
					((Inv at: 14) state: 4) ; Membership_Tape
					(gEgo put: 14 0) ; Membership_Tape
					(= cycles 1)
				else
					(sucking play:)
					(tape setCycle: Beg setMotion: MoveTo 302 55 self)
				)
			)
			(1
				(gCurRoom newRoom: register)
			)
		)
	)
)

(instance tape of Actor
	(properties
		x 302
		y 55
		description {your tape}
		sightAngle 90
		lookStr {Your membership tape hangs from the machine's open lip.}
		view 520
		signal 30736
		cycleSpeed 20
	)
)

(instance sucking of Sound
	(properties
		number 258
	)
)

