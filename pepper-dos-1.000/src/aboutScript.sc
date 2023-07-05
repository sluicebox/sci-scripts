;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 884)
(include sci.sh)
(use Main)
(use Print)
(use DCIcon)
(use System)

(public
	aboutScript 0
)

(local
	local0
)

(instance aboutScript of Code
	(properties)

	(method (dispose)
		(DisposeScript 884)
	)

	(method (doit &tmp [temp0 300] temp300 temp301 temp302)
		((ScriptID 888 0) hide:) ; theControls
		(if
			(or
				(OneOf gCurRoomNum 230 260 370 382 410 330)
				(< (>> (MemoryInfo 4) $0006) 230) ; TotalHunk
			)
			(SetFlag 172)
		else
			(ClearFlag 172)
		)
		(UnLoad 128 800)
		(UnLoad 128 790)
		(UnLoad 128 807)
		(Message msgGET 884 3 0 0 1 @temp0) ; "PEPPER'S ADVENTURES       version %s"
		(while (not local0)
			(switch
				(Print
					font: gUserFont
					addTextF: @temp0 gVersion 10 0
					addText: 3 0 0 2 0 22 884 ; "Tell me more about:"
					addButton: 1 4 0 0 1 0 36 884 ; "Sierra Customer Service"
					addButton: 2 5 0 0 1 0 50 884 ; "The Sierra Sales Desk"
					addButton: 3 6 0 0 1 0 64 884 ; "Sierra Technical Support"
					addButton: 4 7 0 0 1 0 78 884 ; "Technical Trouble-Shooting Tips"
					addButton: 5 8 0 0 1 0 92 884 ; "My Game's Warranty"
					addButton: 6 9 0 0 1 0 106 884 ; "How to get Game Hints"
					addButton: 7 10 0 0 1 0 120 884 ; "Team Tribal Byte"
					addButton: 8 2 0 0 1 0 134 884 ; "EXIT"
					init:
				)
				(1
					(if (not (Print addText: 11 0 0 1 0 0 884 init:)) ; "Call Sierra Customer Service for inquiries about returned merchandise, back orders, defective merchandise, company policy, and general game information. You can call Sierra Customer Service at (800) 743-7725, 8:15 A.M. - 4:45 P.M. Pacific time, Monday-Friday."
						(self dispose:)
						(return)
					)
					(if (not (Print addText: 11 0 0 2 0 0 884 init:)) ; "For Sierra UK Customer Service, call (0) 734 303171 or Fax (0) 734 303201."
						(self dispose:)
						(return)
					)
				)
				(2
					(if (not (Print addText: 12 0 0 1 0 0 884 init:)) ; "To place a domestic order with Sierra On-Line, call (800) 326-6654 from 7:00 a.m. through 7:00 p.m. Pacific Time, Monday through Friday, for convenient, person-to-person service."
						(self dispose:)
						(return)
					)
					(if (not (Print addText: 12 0 0 2 0 0 884 init:)) ; "If you prefer, you may place your order via Fax (209) 683-4297 (please include your name, address, phone number, credit card number and expiration date.)"
						(self dispose:)
						(return)
					)
					(if (not (Print addText: 12 0 0 3 0 0 884 init:)) ; "To place an international order with our Sierra U.K. Sales Office call [0] 734-303171 for convenient, person-to-person service, or Fax in your order to [0] 734-303201. You can also place your international order with our U.S. office at (209) 683-1263 or Fax in your order to (209) 683-4297."
						(self dispose:)
						(return)
					)
				)
				(3
					(if (not (Print addText: 13 0 0 1 0 0 884 init:)) ; "Technical assistance is only a telephone call away. Call (209) 683-8989 for convenient, person-to-person service or if you prefer, you may request assistance by fax (209) 683-3633 or mail."
						(self dispose:)
						(return)
					)
					(if (not (Print addText: 13 0 0 2 0 0 884 init:)) ; "If you choose to write us with your request, please give us detailed information on both your computer system and the nature of your problem. In addition, please include your address and telephone number in case we need additional information."
						(self dispose:)
						(return)
					)
				)
				(4
					(if (not (Print addText: 14 0 0 1 0 0 884 init:)) ; "If you're experiencing any type of technical difficulties with your program, here are some suggestions we recommend you try."
						(self dispose:)
						(return)
					)
					(if (not (Print addText: 14 0 0 2 0 0 884 init:)) ; "1. Boot your system with the Boot Disk you created. (See Boot Disk Instruction in the Sierra Game Manual.) 2. Reinstall the game under a Boot Disk environment."
						(self dispose:)
						(return)
					)
					(if (not (Print addText: 14 0 0 3 0 0 884 init:)) ; "2. If you are experiencing any form of program hesitation or lockups during game play and you are using a Sound Blaster or compatible sound card, the following information is a temporary solution to have you up and running quickly:"
						(self dispose:)
						(return)
					)
					(if (not (Print addText: 14 0 0 4 0 0 884 init:)) ; "For Sound Blaster or compatible sound card users, run the install procedure from the game sub-directory, select the "Adlib" or "PC Internal Speaker" option for music, and select "No Audio/Speech Card for speech where applicable."
						(self dispose:)
						(return)
					)
					(if (not (Print addText: 14 0 0 5 0 0 884 init:)) ; "Note: This temporary solution does not give you the option to hear the sampled sounds or the speech that may be available in your game. For correct sound card functionality, a call to Sierra On-Line's Technical Support is recommended."
						(self dispose:)
						(return)
					)
					(if (not (Print addText: 14 0 0 6 0 0 884 init:)) ; "4. If you are currently using the PS/1 option for speech and are encountering program hesitation or lockups during game play, run the internal procedure from the game sub-directory and select "No Audio/Speech Card" for speech where applicable."
						(self dispose:)
						(return)
					)
				)
				(5
					(if (not (Print addText: 15 0 0 1 0 0 884 init:)) ; "If you find that you need to send for replacement diskettes, send the original disk #1 in the size you need (3.5" or 5.25") to:"
						(self dispose:)
						(return)
					)
					(if (not (Print addText: 15 0 0 2 0 0 884 init:)) ; "U.S. Sierra On-Line P.O. Box 485 Coarsegold, CA 93614 Attention: Returns"
						(self dispose:)
						(return)
					)
					(if (not (Print addText: 15 0 0 3 0 0 884 init:)) ; "U.K. Sierra On-Line Limited Attn: Returns Unit 2, Theale Technology Centre, Station Road Theale, Berkshire RG7 4AA United Kingdom"
						(self dispose:)
						(return)
					)
					(if (not (Print addText: 15 0 0 4 0 0 884 init:)) ; "Be sure to include a note stating your computer type, and the size of diskette you need (5.25" or 3.5"). We will gladly replace your program free of charge for the first 90 days of ownership (please enclose a copy of your dated sales receipt with your request)."
						(self dispose:)
						(return)
					)
					(if (not (Print addText: 15 0 0 5 0 0 884 init:)) ; "After 90 days there is a $10.00 (6 Pound) charge for 3.5" or 5.25" diskettes."
						(self dispose:)
						(return)
					)
				)
				(6
					(if (not (Print addText: 16 0 0 1 0 0 884 init:)) ; "Game hints are available by phone, hint books (order through the Sierra Sales Department), through the Sierra Bulletin Board Service (209-683-4463), TSN (The Sierra Network), or by mail (P.O. Box 200, Coarsegold, CA 93614-0200, Attn: Hint Department)."
						(self dispose:)
						(return)
					)
					(if (not (Print addText: 16 0 0 2 0 0 884 init:)) ; "If you want an immediate response, you can call our 24 hour Hint Line at 900-370-5583 in the U.S. In the U.K., call (0)734 304004. $.75 each minute. Long distance charges are included in the fee. U.K. customers will be charged the normal rate for U.K. telephone calls."
						(self dispose:)
						(return)
					)
					(if (not (Print addText: 16 0 0 3 0 0 884 init:)) ; "Callers under the age of 18 must get their parents' permission before calling the Hint Line. ABSOLUTELY NO HINTS WILL BE PROVIDED THROUGH OUR CUSTOMER SUPPORT LINES. At this time, the automated hint system is only available within the United States."
						(self dispose:)
						(return)
					)
					(if (not (Print addText: 16 0 0 4 0 0 884 init:)) ; "All contents are copyrighted by Sierra On-Line and may not be reproduced in any form without express written permission."
						(self dispose:)
						(return)
					)
				)
				(7
					(if (or (not global213) (> (++ global213) 28))
						(= global213 13)
					)
					(if (not (Print addText: 1 0 6 1 0 0 884 init:)) ; "Team Tribal Byte consists of a chief, a storyteller, stone counters, cave painters, drummers and singers, and one really good scout. They are:"
						(self dispose:)
						(return)
					)
					(if (IsFlag 172)
						(= temp302 2000)
						(= temp300 0)
					else
						(= temp302 880)
						(= temp300 70)
					)
					(if
						(not
							(Print
								addText: 1 0 7 1 temp300 0 884 ; "Mark Seibert:"
								addText: 1 0 7 2 temp300 13 884 ; "Ghost Writer/Cameo Coder/All Around Meddler (Producer, Co-Director, Musician)"
								addText: 1 0 7 3 temp300 39 884 ; "Remember, if you're going to play a game--Go ahead!"
								addIcon:
									(musicIcon
										view: temp302
										cel: 0
										loop: 0
										yourself:
									)
									0
									0
									1
									1
								init:
							)
						)
						(self dispose:)
						(return)
					)
					(UnLoad 128 880)
					(if (IsFlag 172)
						(= temp302 2000)
						(= temp300 0)
					else
						(= temp302 880)
						(= temp300 50)
					)
					(if
						(not
							(Print
								addText: 1 0 5 1 temp300 0 884 ; "Lorelei Shannon:"
								addText: 1 0 5 2 temp300 13 884 ; "Professional Liar (Designer)"
								addText: 1 0 5 3 temp300 39 884 ; "'Tain't no sin to shuck off your skin and dance around in your bones!"
								addIcon:
									(designIcon
										view: temp302
										cel: 0
										loop: 1
										yourself:
									)
									0
									0
									1
									1
								init:
							)
						)
						(self dispose:)
						(return)
					)
					(UnLoad 128 880)
					(if (IsFlag 172)
						(= temp302 2000)
						(= temp300 0)
					else
						(= temp302 889)
						(= temp300 0)
					)
					(if
						(not
							(Print
								addText: 1 0 2 1 0 0 884 ; "Jim Larsen:"
								addText: 1 0 2 2 0 13 884 ; "Awesomely Cool Lead Artist"
								addText: 1 0 2 3 0 26 884 ; "Good judgement comes from experience, and a lot of that comes from bad judgement."
								addIcon:
									(artIcon
										view: temp302
										cel: 0
										loop: 0
										yourself:
									)
									0
									0
									20
									65
								init:
							)
						)
						(self dispose:)
						(return)
					)
					(UnLoad 128 889)
					(if (IsFlag 172)
						(= temp302 2000)
					else
						(= temp302 886)
					)
					(if
						(not
							(Print
								width: 230
								x: 30
								addText: 1 0 2 4 0 0 884 ; "Tony (The Bambino) Margioni:"
								addText: 1 0 2 5 0 13 884 ; "Lead Animator"
								addText: 1 0 2 6 0 26 884 ; "It's not why you should, but why not?"
								addIcon:
									(artIcon
										view: temp302
										cel: 0
										loop: 0
										yourself:
									)
									0
									0
									20
									40
								init:
							)
						)
						(self dispose:)
						(return)
					)
					(if (IsFlag 172)
						(= temp302 2000)
					else
						(= temp302 881)
					)
					(UnLoad 128 886)
					(if
						(not
							(Print
								addText: 1 0 2 7 0 0 884 ; "Terry Falls:"
								addText: 1 0 2 8 0 13 884 ; "Artist in Charge of all Green Pixels"
								addText: 1 0 2 9 0 26 884 ; "Some people never find it Some only pretend But I just want to live happily ever after, now and then."
								addIcon:
									(artIcon
										view: temp302
										cel: 0
										loop: 0
										yourself:
									)
									0
									0
									30
									65
								init:
							)
						)
						(self dispose:)
						(return)
					)
					(UnLoad 128 881)
					(if (IsFlag 172)
						(= temp302 2000)
						(= temp300 0)
					else
						(= temp302 881)
						(= temp300 60)
					)
					(if
						(not
							(Print
								addText: 1 0 2 10 temp300 0 884 ; "Maria (The Bambina) Fruehe:"
								addText: 1 0 2 11 temp300 13 884 ; "Artist and Pixel Maniac"
								addText: 1 0 2 12 temp300 26 884 ; "It is always the Adventurers who accomplish great things."
								addIcon:
									(artIcon
										view: temp302
										cel: 0
										loop: 1
										yourself:
									)
									0
									0
									1
									1
								init:
							)
						)
						(self dispose:)
						(return)
					)
					(UnLoad 128 881)
					(if (IsFlag 172)
						(= temp302 2000)
						(= temp300 0)
					else
						(= temp302 881)
						(= temp300 60)
					)
					(if
						(not
							(Print
								addText: 1 0 2 13 temp300 0 884 ; "Al Roughton:"
								addText: 1 0 2 14 temp300 13 884 ; "Painter"
								addText: 1 0 2 15 temp300 26 884 ; "Divine the hidden.  It's a nice bit o' business."
								addIcon:
									(artIcon
										view: temp302
										cel: 0
										loop: 2
										yourself:
									)
									0
									0
									1
									1
								init:
							)
						)
						(self dispose:)
						(return)
					)
					(UnLoad 128 881)
					(if (IsFlag 172)
						(= temp302 2000)
						(= temp300 0)
					else
						(= temp302 888)
						(= temp300 75)
					)
					(if
						(not
							(Print
								addText: 1 0 1 1 temp300 0 884 ; "Carlos Escobar:"
								addText: 1 0 1 2 temp300 13 884 ; "Lead Programmer and Fire Fighter"
								addText: 1 0 1 global213 temp300 26 884
								addIcon:
									(progIcon
										view: temp302
										cel: 0
										loop: 0
										yourself:
									)
									0
									0
									1
									1
								init:
							)
						)
						(self dispose:)
						(return)
					)
					(UnLoad 128 888)
					(if (IsFlag 172)
						(= temp302 2000)
					else
						(= temp302 882)
					)
					(if
						(not
							(Print
								addText: 1 0 1 4 0 0 884 ; "Kim Bowdish:"
								addText: 1 0 1 5 0 13 884 ; "Programmer and Fearless Mountain Climber"
								addText: 1 0 1 6 0 39 884 ; "Practice random acts of kindness and senseless acts of beauty."
								addIcon:
									(progIcon
										view: temp302
										cel: 0
										loop: 1
										yourself:
									)
									0
									0
									20
									65
								init:
							)
						)
						(self dispose:)
						(return)
					)
					(UnLoad 128 882)
					(if (IsFlag 172)
						(= temp302 2000)
						(= temp300 0)
					else
						(= temp302 882)
						(= temp300 50)
					)
					(if
						(not
							(Print
								addText: 1 0 1 10 temp300 0 884 ; "Thaddeus Pritchard:"
								addText: 1 0 1 11 temp300 13 884 ; "Excellent Programming Dude"
								addText: 1 0 1 12 temp300 26 884 ; "We've got to come together and learn to love and respect our brothers--and our sisters."
								addIcon:
									(progIcon
										view: temp302
										cel: 0
										loop: 2
										yourself:
									)
									0
									0
									1
									1
								init:
							)
						)
						(self dispose:)
						(return)
					)
					(UnLoad 128 882)
					(if (IsFlag 172)
						(= temp302 2000)
					else
						(= temp302 883)
					)
					(if
						(not
							(Print
								addText: 1 0 1 7 0 0 884 ; "Chris Carr:"
								addText: 1 0 1 8 0 13 884 ; "Programmer and Minister of Style"
								addText: 1 0 1 9 0 26 884 ; "He who gets wisdom loves his own soul; he who cherishes understanding prospers."
								addIcon:
									(progIcon
										view: temp302
										cel: 0
										loop: 0
										yourself:
									)
									0
									0
									20
									70
								init:
							)
						)
						(self dispose:)
						(return)
					)
					(UnLoad 128 883)
					(if (IsFlag 172)
						(= temp302 2000)
					else
						(= temp302 890)
						(= temp300 85)
					)
					(if
						(not
							(Print
								addText: 1 0 4 1 temp300 0 884 ; "Neal Grandstaff:"
								addText: 1 0 4 2 temp300 13 884 ; "Magical Music Man"
								addText: 1 0 4 3 temp300 26 884 ; "Live it or live with it."
								addIcon:
									(musicIcon
										view: temp302
										cel: 0
										loop: 0
										yourself:
									)
									0
									0
									0
									0
								init:
							)
						)
						(self dispose:)
						(return)
					)
					(UnLoad 128 890)
					(if (IsFlag 172)
						(= temp302 2000)
					else
						(= temp302 887)
					)
					(if
						(not
							(Print
								width: 170
								addText: 1 0 3 1 0 0 884 ; "Dan Woolard:"
								addText: 1 0 3 2 0 13 884 ; "Cleaning up your act! (Senior QA Analyst)"
								addText: 1 0 3 3 0 39 884 ; "History was but learning is."
								addIcon:
									(qaIcon
										view: temp302
										cel: 0
										loop: 0
										yourself:
									)
									0
									0
									20
									50
								init:
							)
						)
						(self dispose:)
						(return)
					)
					(UnLoad 128 887)
				)
				(8
					(= local0 1)
					(self dispose:)
					(return)
				)
			)
		)
		(self dispose:)
	)
)

(instance artIcon of DCIcon
	(properties
		cycleSpeed 15
	)
)

(instance designIcon of DCIcon
	(properties
		cycleSpeed 15
	)
)

(instance musicIcon of DCIcon
	(properties
		cycleSpeed 15
	)
)

(instance progIcon of DCIcon
	(properties
		cycleSpeed 15
	)
)

(instance qaIcon of DCIcon
	(properties
		cycleSpeed 15
	)
)

