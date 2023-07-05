;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 280)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use User)
(use System)

(public
	rm280 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5 = 30
	[local6 12] = [27 35 43 51 59 67 91 99 123 131 139 147]
	[local18 12] = [32 40 48 56 64 72 96 104 128 136 144 152]
)

(instance rm280 of Rm
	(properties
		picture 32
	)

	(method (init &tmp [temp0 50])
		(Load rsPIC 32)
		(super init:)
		(= global193 1)
		(User canInput: 0 canControl: 0)
		(User mapKeyToDir: 0)
		(= global592 1)
		(gGame setCursor: gNormalCursor (HaveMouse))
		(Display 280 0 dsCOORD 10 27 dsWIDTH 310 dsCOLOR 0 dsFONT 600) ; "1. MINI MONOLITH~~~~ ...........................1.00 2. MONOLITH ................................2.00 3.  W/POLYCHEEZE ........................3.00 4. FILET-O-ORAT~~~ ..........................2.00 5. JUMBO MONOLITH W/POLYCHEEZE~ ......5.00 6. BIG BELCHER COMBO~~ .....................9.00   INCLUDES: JUMBO MONO W/POLYCHEEZE, SPACE SPUDS   W/EXTRA GREASE AND SLOPPY SLURPER 7. MONOLITH FUN MEAL ....................7.00 8. SPACE SPUDS~ ............................1.00 TANG\02 9.  SMALL .......................1.00 A.  MED~ .........................2.00 B.  ~~~~LARGE~~~ ......................3.00 C. SLOPPY SLURPER~~~ ............4.00"
		(Display 280 0 dsCOORD 11 28 dsWIDTH 310 dsCOLOR 15 dsFONT 600) ; "1. MINI MONOLITH~~~~ ...........................1.00 2. MONOLITH ................................2.00 3.  W/POLYCHEEZE ........................3.00 4. FILET-O-ORAT~~~ ..........................2.00 5. JUMBO MONOLITH W/POLYCHEEZE~ ......5.00 6. BIG BELCHER COMBO~~ .....................9.00   INCLUDES: JUMBO MONO W/POLYCHEEZE, SPACE SPUDS   W/EXTRA GREASE AND SLOPPY SLURPER 7. MONOLITH FUN MEAL ....................7.00 8. SPACE SPUDS~ ............................1.00 TANG\02 9.  SMALL .......................1.00 A.  MED~ .........................2.00 B.  ~~~~LARGE~~~ ......................3.00 C. SLOPPY SLURPER~~~ ............4.00"
		(if (== gPrevRoomNum 25)
			(Display 280 1 dsCOORD 30 175 dsWIDTH 200 dsCOLOR 0 dsFONT 600) ; "Choose number to order"
			(Display 280 1 dsCOORD 31 176 dsWIDTH 200 dsCOLOR 15 dsFONT 600) ; "Choose number to order"
		)
		(Display 280 2 dsCOORD 200 175 dsWIDTH 200 dsCOLOR 0 dsFONT 600) ; "Press Q to quit"
		(Display 280 2 dsCOORD 201 176 dsWIDTH 200 dsCOLOR 15 dsFONT 600) ; "Press Q to quit"
	)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evMOUSEBUTTON
				(cond
					((== gPrevRoomNum 25)
						(cond
							(
								(and
									(<= 190 (event x:) 275)
									(<= 170 (event y:) 183)
								)
								(event claimed: 1)
								(gCurRoom setScript: Quitting)
							)
							(
								(and
									(<= local4 (event x:) local5)
									(<= [local6 0] (event y:) [local18 0])
								)
								(= local3 1)
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (event x:) local5)
									(<= [local6 1] (event y:) [local18 1])
								)
								(= local3 2)
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (event x:) local5)
									(<= [local6 2] (event y:) [local18 2])
								)
								(= local3 3)
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (event x:) local5)
									(<= [local6 3] (event y:) [local18 3])
								)
								(= local3 4)
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (event x:) local5)
									(<= [local6 4] (event y:) [local18 4])
								)
								(= local3 5)
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (event x:) local5)
									(<= [local6 5] (event y:) [local18 5])
								)
								(= local3 6)
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (event x:) local5)
									(<= [local6 6] (event y:) [local18 6])
								)
								(= local3 7)
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (event x:) local5)
									(<= [local6 7] (event y:) [local18 7])
								)
								(= local3 8)
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (event x:) local5)
									(<= [local6 8] (event y:) [local18 8])
								)
								(= local3 9)
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (event x:) local5)
									(<= [local6 9] (event y:) [local18 9])
								)
								(= local3 10)
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (event x:) local5)
									(<= [local6 10] (event y:) [local18 10])
								)
								(= local3 11)
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(<= local4 (event x:) local5)
									(<= [local6 11] (event y:) [local18 11])
								)
								(= local3 12)
								(gCurRoom setScript: ChooseFood)
							)
						)
					)
					((and (<= 190 (event x:) 275) (<= 170 (event y:) 183))
						(event claimed: 1)
						(gCurRoom setScript: Quitting)
					)
				)
			)
			(evKEYBOARD
				(cond
					((== gPrevRoomNum 25)
						(cond
							(
								(or
									(== (event message:) KEY_Q)
									(== (event message:) KEY_q)
								)
								(gCurRoom setScript: Quitting)
							)
							(
								(and
									(>= (event message:) KEY_1)
									(<= (event message:) KEY_9)
								)
								(= local3 (- (event message:) 48))
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(>= (event message:) KEY_A)
									(<= (event message:) KEY_C)
								)
								(= local3 (- (event message:) 55))
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(>= (event message:) KEY_a)
									(<= (event message:) KEY_c)
								)
								(= local3 (- (event message:) 87))
								(gCurRoom setScript: ChooseFood)
							)
						)
					)
					((or (== (event message:) KEY_Q) (== (event message:) KEY_q))
						(gCurRoom setScript: Quitting)
					)
				)
			)
		)
	)
)

(instance ChooseFood of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch local3
					(0)
					(1
						(+= global244 1)
						(= local2 1)
					)
					(2
						(+= global244 2)
						(= local2 1)
					)
					(3
						(+= global244 3)
						(= local2 1)
					)
					(4
						(+= global244 2)
						(= local2 1)
					)
					(5
						(+= global244 5)
						(= local2 1)
					)
					(6
						(+= global244 9)
						(= local2 1)
						(= global101 1)
					)
					(7
						(+= global244 7)
						(if (not (gEgo has: 7)) ; Monolith_Decoder_Ring
							(= global249 1)
						)
						(= local2 1)
					)
					(8
						(+= global244 1)
						(= local2 1)
					)
					(9
						(+= global244 1)
						(= local1 1)
					)
					(10
						(+= global244 2)
						(= local1 1)
					)
					(11
						(+= global244 3)
						(= local1 1)
					)
					(12
						(+= global244 4)
						(= local1 1)
					)
				)
				(Print 280 3 #at -1 95 #width 50 #font 600 #dispose) ; "Thank You"
				(= cycles 10)
			)
			(1
				(cls)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance Quitting of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (== gPrevRoomNum 25) global244)
					(if (not local1)
						(Print ; "Would you like something to drink with that?"
							280
							4
							#icon
							38
							4
							0
							#mode
							1
							#title
							{Pushy Counter Clerk}
							#button
							{ Yes }
							1
							#button
							{ Yes }
							2
						)
					)
					(Print ; "Would you like some Space Spuds with that??"
						280
						5
						#icon
						38
						4
						1
						#mode
						1
						#title
						{Pushy Counter Clerk}
						#button
						{ Yes }
						1
						#button
						{ Yes }
						2
					)
					(Print ; "Would you like a Blattfruit Pie with that??"
						280
						6
						#icon
						38
						4
						2
						#mode
						1
						#title
						{Pushy Counter Clerk}
						#button
						{ Yes }
						1
						#button
						{ Yes }
						2
					)
					(if (not local1)
						(Print ; "Special today: A free drink with every purchase!"
							280
							7
							#icon
							38
							4
							0
							#mode
							1
							#title
							{While Supplies Last}
							#button
							{ Okay }
							1
						)
					)
					(if (not local2)
						(Print ; "Special today: A free Filet-O-Orat with every purchase!"
							280
							8
							#icon
							38
							4
							0
							#mode
							1
							#title
							{While Supplies Last}
							#button
							{ Okay }
							1
						)
					)
					(= global592 0)
					(= global193 0)
					(if (> global244 9999)
						(= global244 9999)
					)
					(User mapKeyToDir: 1)
					(cls)
					(gCurRoom newRoom: 25)
				else
					(= global592 0)
					(= global193 0)
					(User mapKeyToDir: 1)
					(gCurRoom newRoom: gPrevRoomNum)
				)
			)
		)
	)
)

