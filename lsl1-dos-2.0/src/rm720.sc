;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 720)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use n940)
(use LoadMany)
(use File)
(use User)
(use System)

(public
	rm720 0
)

(local
	atY
	correct
	question
	hisAnswer
	theAnswer
	thisColor
	thisFile
	theKey
	[filesSeen 99]
	[string 300]
	missedOne
	dQuestion
	[dLetter 4]
	[dAnswer 4]
)

(procedure (HighLight i c &tmp [tmpString 200])
	(= atY (+ 32 (* i 30)))
	(Format @string 720 12 (+ i 96)) ; "%c."
	(Display @string dsCOORD 50 atY dsCOLOR c dsFONT gUserFont)
	(GetFarText thisFile (+ (* question 5) i) @tmpString)
	(Display @tmpString dsCOORD 65 atY dsCOLOR c dsFONT gUserFont dsWIDTH 205)
)

(procedure (MouseInRect event left top right bottom &tmp evX evY)
	(= evX (event x:))
	(= evY (event y:))
	(return
		(if
			(and
				(> evX left)
				(> evY top)
				(< evX right)
				(< evY bottom)
			)
			1
		else
			0
		)
	)
)

(procedure (SetFlgTrivia flag)
	(= [filesSeen (/ flag 16)]
		(| [filesSeen (/ flag 16)] (>> $8000 (mod flag 16)))
	)
)

(procedure (TstFlgTrivia flag)
	(return (if (& [filesSeen (/ flag 16)] (>> $8000 (mod flag 16))) 1 else 0))
)

(procedure (LoadSetup &tmp soundState [str 30])
	(if (!= (LARRY_DRV open: 1) 0)
		(LARRY_DRV read: @str 8)
		(= [filesSeen 0] (ReadNumber @str))
		(LARRY_DRV read: @str 8)
		(= [filesSeen 1] (ReadNumber @str))
		(LARRY_DRV read: @str 8 close:)
		(= [filesSeen 2] (ReadNumber @str))
	)
)

(procedure (SaveSetup &tmp [str 40])
	(if (!= (LARRY_DRV open: 2) 0)
		(Format @str 720 18 [filesSeen 0] [filesSeen 1] [filesSeen 2]) ; "%8d%8d%8d"
		(LARRY_DRV writeString: @str close:)
	)
)

(instance rm720 of LLRoom
	(properties
		picture 721
	)

	(method (init &tmp tryCount)
		(LoadMany rsSOUND 710 711 712)
		(LoadSetup)
		(gTheMusic2 number: 710 loop: 1 vol: 127 flags: 1)
		(gTheMusic3 loop: 1 vol: 127 flags: 1)
		(while
			(and
				(< (++ tryCount) 1000) ; UNINIT
				(TstFlgTrivia (- (= thisFile (Random 721 752)) 721))
			)
		)
		(if (>= tryCount 1000) ; UNINIT
			(= [filesSeen 0] 0)
			(= [filesSeen 1] 0)
			(= [filesSeen 2] 0)
			(= thisFile (Random 721 752))
		)
		(SetFlgTrivia (- thisFile 721))
		(SaveSetup)
		(Load rsTEXT thisFile)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(HandsOn)
		(User canControl: 0)
		(gEgo init: hide:)
		(self setScript: RoomScript)
		(gGame setCursor: 999 1 310 185)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)
)

(instance RoomScript of Script
	(properties)

	(method (handleEvent event &tmp evMod [str 33])
		(if (and (== state 5) (not (event claimed:)))
			(self cue:)
		)
		(if (== (event type:) evKEYBOARD)
			(= evMod (event modifiers:))
			(switch (event message:)
				(KEY_F2
					(cond
						((gGame masterVolume:)
							(gGame masterVolume: 0)
						)
						((> gNumVoices 1)
							(gGame masterVolume: 15)
						)
						(else
							(gGame masterVolume: 1)
						)
					)
					(event claimed: 1)
				)
				(KEY_CONTROL
					(gGame quitGame:)
					(event claimed: 1)
				)
				(KEY_ALT_x
					(if (& evMod emCTRL)
						(event claimed: 1)
						(Print 720 0) ; "CHEATER, CHEATER, CHEATER!!!"
						(Print 720 1) ; "Oh well, O.K., since it's you, go on and play, but only this time!"
						(self changeState: 6)
					)
				)
			)
		)
		(if (or (event claimed:) (!= state 1) (super handleEvent: event))
			(return)
		)
		(switch (event type:)
			(evMOUSEBUTTON
				(cond
					((MouseInRect event 41 61 200 81)
						(= hisAnswer 1)
						(self cue:)
					)
					((MouseInRect event 41 91 200 111)
						(= hisAnswer 2)
						(self cue:)
					)
					((MouseInRect event 41 122 200 142)
						(= hisAnswer 3)
						(self cue:)
					)
					((MouseInRect event 41 151 200 176)
						(= hisAnswer 4)
						(self cue:)
					)
				)
			)
			(evKEYBOARD
				(= evMod (event modifiers:))
				(switch (event message:)
					(KEY_a
						(= hisAnswer 1)
						(self cue:)
					)
					(KEY_b
						(= hisAnswer 2)
						(self cue:)
					)
					(KEY_c
						(= hisAnswer 3)
						(self cue:)
					)
					(KEY_d
						(= hisAnswer 4)
						(self cue:)
					)
					(KEY_A
						(= hisAnswer 1)
						(self cue:)
					)
					(KEY_B
						(= hisAnswer 2)
						(self cue:)
					)
					(KEY_C
						(= hisAnswer 3)
						(self cue:)
					)
					(KEY_D
						(= hisAnswer 4)
						(self cue:)
					)
				)
			)
		)
	)

	(method (changeState newState &tmp age i [tmpString 200])
		(switch (= state newState)
			(0
				(Print 720 2 #title {Sturgeon General's Warning}) ; ""Leisure Suit Larry in the Land of the Lounge Lizards" contains some elements of plot which may not be considered appropriate for some children."
				(= dQuestion
					(Display ; "Use the TAB key to select, then ENTER to continue."
						720
						3
						dsCOORD
						1
						156
						dsCOLOR
						gColVLBlue
						dsALIGN
						alCENTER
						dsWIDTH
						318
						dsFONT
						gSmallFont
						dsSAVEPIXELS
					)
				)
				(= age 0)
				(gGame setCursor: 999 1)
				(Animate (gCast elements:) 0)
				(while (not age)
					(= age
						(PrintD
							{So, how old are you, anyway?}
							103
							81
							{under 15}
							15
							81
							{16 to 18}
							16
							81
							{19 to 39}
							19
							103
							81
							{40 to 65}
							40
							81
							{66 to 99}
							66
							81
							{over 100}
							100
							80
							{No lying, please!}
						)
					)
				)
				(Display 720 4 dsRESTOREPIXELS dQuestion)
				(switch age
					(15
						(gTheMusic stop:)
						(gTheMusic3 number: 712 play:)
						(Print 720 5) ; "Sorry, but this game can only be played by adults, or with an adult. Please find an adult, come back, and try again."
						(= gQuit 1)
					)
					(100
						(gTheMusic stop:)
						(gTheMusic3 number: 712 play:)
						(Print 720 6) ; "Oh no, you're not!"
						(= gQuit 1)
					)
					(else
						(switch age
							(16
								(Print 720 7) ; "Shouldn't you be doing your homework?"
							)
							(19
								(Print 720 8) ; "Yeah, sure you are!"
							)
							(40
								(Print 720 9) ; "Gee, that's funny; you look much older!"
							)
							(66
								(Print 720 10) ; "Warning! This game may be hazardous to your health!"
							)
						)
						(Print 720 11) ; "To verify your age, please answer these five simple questions."
						(= cycles 11)
					)
				)
			)
			(1
				(gTheMusic2 play:)
				(GetFarText thisFile (* question 5) @string)
				(= theAnswer (- (StrAt @string 0) 48))
				(for ((= i 0)) (<= i (StrLen @string)) ((++ i))
					(StrAt @tmpString i (StrAt @string (+ i 1)))
				)
				(= thisColor
					(switch question
						(0 gColLYellow)
						(1 gColVLGreen)
						(2 gColVLBlue)
						(3 gColLMagenta)
						(else gColLCyan)
					)
				)
				(= dQuestion
					(Display
						@tmpString
						dsCOORD
						20
						12
						dsCOLOR
						thisColor
						dsFONT
						gUserFont
						dsWIDTH
						277
						dsSAVEPIXELS
					)
				)
				(= atY 62)
				(= i 1)
				(while (< i 5)
					(Format @string 720 12 (+ i 96)) ; "%c."
					(= [dLetter (- i 1)]
						(Display
							@string
							dsCOORD
							50
							atY
							dsCOLOR
							thisColor
							dsFONT
							gUserFont
							dsSAVEPIXELS
						)
					)
					(GetFarText thisFile (+ (* question 5) i) @tmpString)
					(= [dAnswer (- i 1)]
						(Display
							@tmpString
							dsCOORD
							65
							atY
							dsCOLOR
							thisColor
							dsFONT
							gUserFont
							dsWIDTH
							205
							dsSAVEPIXELS
						)
					)
					(++ i)
					(+= atY 30)
				)
			)
			(2
				(if (or (== hisAnswer theAnswer) (== theAnswer 0))
					(HighLight hisAnswer gColLGreen)
					(gTheMusic3 number: 711 play: 127)
					(Print 720 13 #at 200 34 #time 3) ; "Correct"
					(++ correct)
					(++ state)
				else
					(HighLight hisAnswer gColVLRed)
					(gTheMusic3 number: 712 play:)
				)
				(= cycles 22)
			)
			(3
				(if (not missedOne)
					(++ missedOne)
					(if (== correct 4)
						(Print 720 14) ; "Oops. You blew that one! But since you came so close, you get to play in spite of yourself!"
					else
						(Print 720 15) ; "Oops. You blew that one! If you miss another, you can't possibly be old enough to play this game!"
					)
				else
					(Print 720 16 #at -1 19 #width 280) ; "YOU'RE A KID!! Shame on you for trying to deceive a friendly little computer game like this! Come back and try again when you're older (or wiser)."
					(= gQuit 1)
				)
				(= cycles 22)
			)
			(4
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Display 720 4 dsRESTOREPIXELS dQuestion)
				(for ((= i 0)) (< i 4) ((++ i))
					(Display 720 4 dsRESTOREPIXELS [dLetter i])
					(Display 720 4 dsRESTOREPIXELS [dAnswer i])
				)
				(= hisAnswer 0)
				(if (< (++ question) 5)
					(= state 0)
				)
				(= cycles 11)
			)
			(5
				(Format @string 720 17) ; "Thank you. And now, slip into your leisure suit and prepare to enter the "Land of the Lounge Lizards" with "Leisure Suit Larry!""
				(Display @string dsCOORD 60 60 dsCOLOR gColLYellow dsFONT gUserFont dsWIDTH 230)
				(= seconds 6)
			)
			(6
				(gCurRoom newRoom: 100)
			)
		)
	)
)

(instance LARRY_DRV of File
	(properties
		name {LARRY.DRV}
	)
)

