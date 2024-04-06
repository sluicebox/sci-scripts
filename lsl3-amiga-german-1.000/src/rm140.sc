;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 140)
(include sci.sh)
(use Main)
(use Interface)
(use Language)
(use File)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	rm140 0
)

(local
	tryCount
	atY
	correct
	suitCel
	question
	hisAnswer
	theAnswer
	thisFile
	theKey
	[filesSeen 99]
	[string 600]
)

(procedure (HighLight i c &tmp [tmpString 600])
	(SaveSubLang)
	(= atY (+ 42 (* i 30)))
	(Format @string 140 8 (+ i 96)) ; "%c."
	(Display @string dsCOORD 150 atY dsCOLOR c dsFONT 4 dsWIDTH 10)
	(GetFarText thisFile (+ (* question 5) i) @tmpString)
	(Display @tmpString dsCOORD 160 atY dsCOLOR c dsFONT 4 dsWIDTH 140)
	(RestoreSubLang)
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

(procedure (SetFlg140 flag)
	(|= [filesSeen (/ flag 16)] (>> $8000 (mod flag 16)))
)

(procedure (TstFlg140 flag)
	(return (if (& [filesSeen (/ flag 16)] (>> $8000 (mod flag 16))) 1 else 0))
)

(procedure (LoadSetup &tmp soundState [str 30])
	(if (!= (LARRY3_DVR open: 1) 0)
		(LARRY3_DVR read: @str 8)
		(= [filesSeen 0] (ReadNumber @str))
		(LARRY3_DVR read: @str 8)
		(= [filesSeen 1] (ReadNumber @str))
		(LARRY3_DVR read: @str 8 close:)
		(= [filesSeen 2] (ReadNumber @str))
	)
)

(procedure (SaveSetup &tmp [str 40])
	(if (!= (LARRY3_DVR open: 2) 0)
		(Format @str 140 13 [filesSeen 0] [filesSeen 1] [filesSeen 2]) ; "%8d%8d%8d"
		(LARRY3_DVR writeString: @str close:)
	)
)

(procedure (CLS)
	(Graph grFILL_BOX 32 150 189 302 1 15)
	(Graph grUPDATE_BOX 32 150 189 302 1)
)

(instance RESOURCE_LL3 of File
	(properties
		name {RESOURCE.LL3}
	)
)

(instance LARRY3_DVR of File
	(properties
		name {LARRY3.DVR}
	)
)

(instance rm140 of Rm
	(properties
		picture 99
	)

	(method (init)
		(Load rsPIC (LangSwitch gCurRoomNum 900))
		(Load rsSOUND 140)
		(Load rsSOUND 141)
		(Load rsFONT 4)
		(LoadSetup)
		(while
			(and
				(< (++ tryCount) 1000)
				(TstFlg140 (- (= thisFile (Random 141 166)) 141))
			)
		)
		(if (>= tryCount 1000)
			(= [filesSeen 0] 0)
			(= [filesSeen 1] 0)
			(= [filesSeen 2] 0)
			(= thisFile (Random 141 166))
		)
		(SetFlg140 (- thisFile 141))
		(SaveSetup)
		(Load rsTEXT thisFile)
		(super init:)
		(= gDemo 0)
		(HandsOn)
		(gUser canInput: 0)
		(gEgo init: hide:)
		(self setScript: RoomScript)
	)
)

(instance RoomScript of Script
	(properties)

	(method (handleEvent event &tmp temp0)
		(if (and (not (event claimed:)) (== state 4))
			(self cue:)
		)
		(if (or (event claimed:) (!= state 1) (super handleEvent: event))
			(return)
		)
		(switch (event type:)
			(evMOUSEBUTTON
				(cond
					((MouseInRect event 141 71 300 91)
						(= hisAnswer 1)
						(self cue:)
					)
					((MouseInRect event 141 101 300 121)
						(= hisAnswer 2)
						(self cue:)
					)
					((MouseInRect event 141 132 300 152)
						(= hisAnswer 3)
						(self cue:)
					)
					((MouseInRect event 141 161 300 186)
						(= hisAnswer 4)
						(self cue:)
					)
				)
			)
			(evKEYBOARD
				(= temp0 (event modifiers:))
				(switch (event message:)
					(KEY_F2
						(event claimed:)
						(TglSound)
					)
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
					(KEY_ALT_x
						(if (& temp0 emCTRL)
							(event claimed: 1)
							(Print 140 0) ; "CHEATER!!! Oh well, O.K. Since it's you, you may go ahead. Pick a filth level from 1-5, where 1 is "clean" and 5 is "dirty.""
							(for
								((= correct 6))
								(u> correct 5)
								(
									(= correct
										(GetNumber
											{from 1-5 ONLY!}
										)
									)
								)
							)
							(self changeState: 4)
						)
					)
				)
			)
		)
	)

	(method (changeState newState &tmp temp0 temp1 [temp2 600])
		(switch (= state newState)
			(0
				(PrintSplit ; "Welcome to "Leisure Suit Larry 3: Passionate Patti in Pursuit of the Pulsating Pectorals!" WARNING! This game contains some material which may be deemed offensive by some players. If you are offended by adult situations, vulgar language, ethnic humor, sexual innuendo or pixelated nudity, you'll be happier playing another game."
					140
					1
					80
					{Hello!   My name is Larry; Larry Laffer!}
					67
					10
					-1
					70
					290
				)
				(Display ; "Use the TAB key to select, then ENTER to continue."
					140
					2
					dsCOORD
					70
					(LangSwitch 150 150 125 125)
					dsALIGN
					alCENTER
					dsCOLOR
					4
					dsWIDTH
					0
					dsFONT
					4
				)
				(if
					(==
						0
						(Print ; "Oops, I don't wanna play no dirty computer games! I'm gonna go watch PBS."
							140
							3
							#at
							10
							30
							#width
							290
							#title
							{Blush!}
							#button
							{Bail\nOut}
							0
							#button
							{Oh, Go Ahead!\nTry to Offend Me!}
							1
						)
					)
					(= gQuit 1)
					(return)
				)
				(= temp0
					(Print ; "What is your age?"
						140
						4
						#at
						10
						30
						#width
						290
						#title
						{Reality Check}
						#button
						{Under 12}
						-1
						#button
						{13 to 17}
						0
						#button
						{18 to 25}
						18
						#button
						{over 25}
						25
					)
				)
				(gMusic fade:)
				(gCurRoom drawPic: 99 7)
				(switch temp0
					(-1
						(Print 140 5) ; "Come back with your legal guardian!"
						(= gQuit 1)
					)
					(0
						(Print 140 6) ; "Welcome to the "Clean" version!"
						(self changeState: 5)
					)
					(else
						(gCurRoom drawPic: (LangSwitch gCurRoomNum 900) 7)
						(aSuit init:)
						(gAddToPics add: atpFace doit:)
						(Format @string 140 7 temp0 temp0) ; "To prove you are at least %d years old, just answer these five simple questions."
						(Print @string #at -1 144)
						(self cue:)
					)
				)
			)
			(1
				(SaveSubLang)
				(= atY 34)
				(GetFarText thisFile (* question 5) @string)
				(= theAnswer (- (StrAt @string 0) 48))
				(for ((= temp1 0)) (<= temp1 (StrLen @string)) ((++ temp1))
					(StrAt @temp2 temp1 (StrAt @string (+ temp1 1)))
				)
				(Display @temp2 dsCOORD 150 atY dsCOLOR 1 dsFONT 4 dsWIDTH 150)
				(= atY 72)
				(= temp1 1)
				(while (< temp1 5)
					(Format @string 140 8 (+ temp1 96)) ; "%c."
					(Display @string dsCOORD 150 atY dsCOLOR 1 dsFONT 4 dsWIDTH 10)
					(GetFarText thisFile (+ (* question 5) temp1) @temp2)
					(Display @temp2 dsCOORD 160 atY dsCOLOR 1 dsFONT 4 dsWIDTH 140)
					(++ temp1)
					(+= atY 30)
				)
			)
			(2
				(RestoreSubLang)
				(if (== hisAnswer theAnswer)
					(HighLight hisAnswer 2)
					(gMusic number: 140 loop: 1 play:)
					(Print 140 9 #at 190 8 #time (LangSwitch 3 3 6 6) #dispose) ; "Correct"
					(++ correct)
					(++ suitCel)
				else
					(HighLight hisAnswer 4)
					(gMusic number: 141 loop: 1 play:)
					(Print 140 10 #at 190 8 #time (LangSwitch 3 3 6 6) #dispose) ; "Wrong"
					(if suitCel
						(-- suitCel)
					)
				)
				(aSuit setCel: suitCel forceUpd:)
				(= seconds 3)
			)
			(3
				(cls)
				(CLS)
				(= hisAnswer 0)
				(if (< (++ question) 5)
					(= state 0)
				)
				(= cycles 11)
			)
			(4
				(SaveSubLang)
				(Format ; "You are so bright! You got %d correct out of 5 questions. Therefore, you get to play this game at the "%s" level! Have fun!!"
					@string
					140
					11
					correct
					(switch correct
						(5 {Totally Raunchiest})
						(4 {Really Filthy})
						(3 {Pretty Dirty})
						(2 {Rather Risque})
						(else {Mother Goose})
					)
					correct
					(switch correct
						(5 {V\94llig Verdorben})
						(4 {Verdorben})
						(3 {Geschmacklos})
						(2 {Gewagt})
						(else {Harmlos})
					)
				)
				(CLS)
				(Display @string dsCOORD 160 60 dsCOLOR 1 dsFONT gUserFont dsWIDTH 130)
				(RestoreSubLang)
				(= seconds 9)
			)
			(5
				(if (== correct 0)
					(++ correct)
				)
				(= gFilthLevel (- correct 1))
				(if (!= (RESOURCE_LL3 open: 2) 0)
					(Format @temp2 140 12 gFilthLevel) ; "%8d"
					(RESOURCE_LL3 writeString: @temp2 close:)
				)
				(gCurRoom newRoom: 290)
			)
		)
	)
)

(instance atpFace of PicView
	(properties
		x 50
		y 52
		view 140
		priority 15
	)
)

(instance aSuit of Prop
	(properties
		x 83
		y 77
		view 140
		loop 1
	)
)

