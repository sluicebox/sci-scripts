;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 280)
(include sci.sh)
(use Main)
(use Interface)
(use FileSelector)
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
	local5
	local6
	local7
	local8 = 30
	[local9 12] = [27 35 43 51 59 67 91 99 123 131 139 147]
	[local21 12] = [32 40 48 56 64 72 96 104 128 136 144 152]
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
		(= local2
			{1. MINI MONOLITH ............................................... 1.00\n2. MONOLITH .......................................................... 2.00\n3.   W/POLYCHEEZE ......................................... 3.00\n4. FILET-O-ORAT~ ............................................... 2.00\n5. JUMBO MONOLITH W/POLYCHEEZE ...... 5.00\n6. BIG BELCHER COMBO .................................... 9.00\n    INCLUDES: JUMBO MONO W/POLYCHEEZE, SPACE SPUDS\n    W/EXTRA GREASE AND SLOPPY SLURPER\n7. MONOLITH FUN MEAL .................................. 7.00\n8. SPACE SPUDS~ ................................................ 1.00\n\nTANG\02\n9. SMALL~ ..................................... 1.00\nA. MED ........................................... 2.00\nB. LARGE ...................................... 3.00\nC. SLOPPY SLURPER ............ 4.00}
		)
		(= local0 (LangSwitch 145 115))
		(= local1 (LangSwitch 146 116))
		(SaveSubLang)
		(Display local2 dsCOORD 10 26 dsWIDTH 310 dsCOLOR 0 dsFONT 600)
		(Display local2 dsCOORD 11 27 dsWIDTH 310 dsCOLOR 15 dsFONT 600)
		(if (== gPrevRoomNum 25)
			(Display 280 0 dsCOORD 195 122 dsWIDTH 110 dsCOLOR 0 dsFONT 600) ; "Choose number to order"
			(Display 280 0 dsCOORD 196 123 dsWIDTH 110 dsCOLOR 15 dsFONT 600) ; "Choose number to order"
		)
		(Display 280 1 dsCOORD local0 174 dsWIDTH 200 dsCOLOR 0 dsFONT 600) ; "Press Q to quit"
		(Display 280 1 dsCOORD local1 175 dsWIDTH 200 dsCOLOR 15 dsFONT 600) ; "Press Q to quit"
		(RestoreSubLang)
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
									(<= local7 (event x:) local8)
									(<= [local9 0] (event y:) [local21 0])
								)
								(= local6 1)
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(<= local7 (event x:) local8)
									(<= [local9 1] (event y:) [local21 1])
								)
								(= local6 2)
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(<= local7 (event x:) local8)
									(<= [local9 2] (event y:) [local21 2])
								)
								(= local6 3)
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(<= local7 (event x:) local8)
									(<= [local9 3] (event y:) [local21 3])
								)
								(= local6 4)
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(<= local7 (event x:) local8)
									(<= [local9 4] (event y:) [local21 4])
								)
								(= local6 5)
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(<= local7 (event x:) local8)
									(<= [local9 5] (event y:) [local21 5])
								)
								(= local6 6)
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(<= local7 (event x:) local8)
									(<= [local9 6] (event y:) [local21 6])
								)
								(= local6 7)
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(<= local7 (event x:) local8)
									(<= [local9 7] (event y:) [local21 7])
								)
								(= local6 8)
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(<= local7 (event x:) local8)
									(<= [local9 8] (event y:) [local21 8])
								)
								(= local6 9)
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(<= local7 (event x:) local8)
									(<= [local9 9] (event y:) [local21 9])
								)
								(= local6 10)
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(<= local7 (event x:) local8)
									(<= [local9 10] (event y:) [local21 10])
								)
								(= local6 11)
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(<= local7 (event x:) local8)
									(<= [local9 11] (event y:) [local21 11])
								)
								(= local6 12)
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
								(= local6 (- (event message:) 48))
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(>= (event message:) KEY_A)
									(<= (event message:) KEY_C)
								)
								(= local6 (- (event message:) 55))
								(gCurRoom setScript: ChooseFood)
							)
							(
								(and
									(>= (event message:) KEY_a)
									(<= (event message:) KEY_c)
								)
								(= local6 (- (event message:) 87))
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
				(switch local6
					(0)
					(1
						(+= global244 1)
						(= local5 1)
					)
					(2
						(+= global244 2)
						(= local5 1)
					)
					(3
						(+= global244 3)
						(= local5 1)
					)
					(4
						(+= global244 2)
						(= local5 1)
					)
					(5
						(+= global244 5)
						(= local5 1)
					)
					(6
						(+= global244 9)
						(= local5 1)
						(= global101 1)
					)
					(7
						(+= global244 7)
						(if (not (gEgo has: 7)) ; Monolith_Decoder_Ring
							(= global249 1)
						)
						(= local5 1)
					)
					(8
						(+= global244 1)
						(= local5 1)
					)
					(9
						(+= global244 1)
						(= local4 1)
					)
					(10
						(+= global244 2)
						(= local4 1)
					)
					(11
						(+= global244 3)
						(= local4 1)
					)
					(12
						(+= global244 4)
						(= local4 1)
					)
				)
				(Print 280 2 #at -1 95 #width 70 #font 600 #dispose #mode 1) ; "Thank You"
				(= cycles 30)
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
					(if (not local4)
						(Print ; "Would you like something to drink with that?"
							280
							3
							#icon
							(LangSwitch 38 305)
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
						4
						#icon
						(LangSwitch 38 305)
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
						5
						#icon
						(LangSwitch 38 305)
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
					(if (not local4)
						(Print ; "Special today: A free drink with every purchase!"
							280
							6
							#icon
							(LangSwitch 38 305)
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
					(if (not local5)
						(Print ; "Special today: A free Filet-O-Orat with every purchase!"
							280
							7
							#icon
							(LangSwitch 38 305)
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

