;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 480)
(include sci.sh)
(use Main)
(use eRS)
(use n940)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm480 0
)

(local
	soundIdx
	[soundNums 25] = [0 273 274 275 297 467 387 147 161 291 861 911 146 892 752 753 754 755 756 751 526 851 482 483 484]
	[sizeElem 4]
	clr
)

(procedure (FindSize theText) ; UNUSED
	(TextSize @sizeElem theText 0 315)
	(return (/ (- 180 (- [sizeElem 2] [sizeElem 0])) 2))
)

(procedure (Credits theText numLines &tmp margin c)
	(gCurRoom drawPic: 1 13)
	(= c
		(switch (Random 0 5)
			(0 gColVLRed)
			(1 gColLYellow)
			(2 gColVLGreen)
			(3 gColVLBlue)
			(4 gColLMagenta)
			(else gColLCyan)
		)
	)
	(Display
		theText
		dsCOLOR
		c
		dsCOORD
		1
		(- 89 (/ (* 12 numLines) 2))
		dsWIDTH
		318
		dsFONT
		gBigFont
		dsALIGN
		alCENTER
	)
)

(instance rm480 of LLRoom
	(properties
		picture 480
		style 7
	)

	(method (init)
		(LoadMany rsPIC 1)
		(LoadMany rsFONT gGiantFont)
		(LoadMany rsSOUND 100)
		(copter init: setCycle: Fwd)
		(super init:)
		(if (IsFlag 47)
			(gTheMusic number: 462 flags: 1 setLoop: -1 setVol: 127 play:)
		)
		(gTheMusic2 number: 468 flags: 1 setLoop: -1 setVol: 127 play:)
		(self setScript: sCartoon)
	)

	(method (dispose)
		(super dispose: &rest)
		(gTheMusic fade: 0 15 12 1)
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 3)
			)
			(1
				(Say gEgo 480 0 108 self 67 -1 28) ; "Larry? What's that bulge in your leisure suit?"
			)
			(2
				(= ticks 30)
			)
			(3
				(TPrint 480 1 80 {Larry} 108 self 67 -1 28) ; "Oh, Patti! Oh. I know what you mean. Why those are just some miniature video tapes I recorded while on the road."
			)
			(4
				(= ticks 30)
			)
			(5
				(Say gEgo 480 2 108 self 67 -1 28) ; "Hey, fun! That'll give us something to watch at Camp David!"
			)
			(6
				(= ticks 30)
			)
			(7
				(TPrint 480 3 80 {The Vice President} 108 self 67 -1 28) ; ""I just love home movies!" chimes in the Vice President."
			)
			(8
				(= ticks 30)
			)
			(9
				(TPrint 480 4 80 {Larry} 108 self 67 -1 28) ; "Uh, Patti, er, Sir, ah, I don't think... Oh, never mind," Larry says. "Grab your glasses everyone. Patti, I propose a toast to us--and to our wonderful future together!"
			)
			(10
				(= ticks 30)
			)
			(11
				(Say gEgo 480 5 108 self 67 -1 28) ; "Excellent, Larry. Yes--to a great week-end!!"
			)
			(12
				(= ticks 30)
			)
			(13
				(copter setLoop: 0 setCycle: End self)
			)
			(14
				(copter
					cycleSpeed: 8
					setLoop: 1
					setCel: 0
					cycleSpeed: 8
					moveSpeed: 8
					setCycle: End self
					setMotion: MoveTo 165 128
				)
			)
			(15
				(copter
					x: 285
					y: 79
					xStep: 7
					yStep: 7
					setLoop: 2
					setCel: 0
					cycleSpeed: 6
					moveSpeed: 6
					setCycle: Fwd
					setMotion: MoveTo 350 61 self
				)
				(gTheMusic2 fade:)
			)
			(16
				(= ticks 120)
			)
			(17
				(gTheMusic fade: 0 15 12 1 self)
			)
			(18
				(gTheMusic number: 100 flags: 1 setLoop: -1 setVol: 127 play:)
				(= ticks 120)
			)
			(19
				(TPrint 480 6 67 -1 28) ; "And so, all's well that ends well?"
				(TPrint 480 7) ; "Well, well!"
				(= seconds 3)
			)
			(20
				(TPrint 480 8 67 -1 15 70 280) ; "It seems all your "work" videotaping those girls was for naught. Silas Scruemall, producer of "America's Sexiest Home Videos," decided to "simplify the audition process" by magnanimously awarding the show's hostess gig to his current girlfriend."
				(TPrint 480 9) ; ""America's Sexiest Home Videos" went on to become the megahit of the season, proving clearly that P. T. Barnum was right."
				(= seconds 3)
			)
			(21
				(TPrint 480 10 67 -1 15 70 280) ; "Congress never did get around to doing anything to "clean up the airwaves.""
				(TPrint 480 11) ; "It seems every bill ever submitted somehow turned up mysteriously "stuck in committee" while they "examined the evidence!""
				(= seconds 3)
			)
			(22
				(TPrint 480 12 67 -1 15 70 280) ; "After a lengthy trial that increased tabloid sales nationwide, Julius Bigg was found innocent of all charges related to his incident at the White House dinner."
				(TPrint 480 13) ; "In what was quickly dubbed the "custard pie" defense, he pleaded "temporary insanity due to the high sugar content of those White House desserts" and got off with a mild reprimand from the judge and six months of mandatory Jenny Craig meetings."
				(= seconds 3)
			)
			(23
				(TPrint 480 14 67 -1 15 70 280) ; "Reverse Biaz soon found himself out of a job when des Rever Records went bankrupt."
				(TPrint 480 15) ; "Executives realized there's no longer any reason to add subliminal messages to recordings since kids can't figure out how to play their CDs backwards."
				(= seconds 3)
			)
			(24
				(TPrint 480 16 67 -1 15 70 280) ; "K-RAP became a national sensation when they expanded by buying a small television station outside of Atlanta and a 24-hour satellite channel."
				(TPrint 480 17) ; "They promoted P. C. Hammer to his new position as the nation's first "Nude VeeJay." Their new slogan: "K-TV--More Rap, Less Wrap!""
				(= seconds 3)
			)
			(25
				(TPrint 480 18 67 -1 15 70 280) ; "The Mob's pornography business continued its steady decline."
				(TPrint 480 19) ; "But they'll find newer, more profitable investments somewhere."
				(= seconds 3)
			)
			(26
				(TPrint 480 20 67 -1 15 70 280) ; "Piano bars continue to change into karaoke bars and the entertainment industry remains exactly as honest as it has always been."
				(= seconds 3)
			)
			(27
				(TPrint 480 21) ; "But all is not lost: Leisure Suit Larry and Passionate Patti are together again!"
				(= seconds 3)
			)
			(28
				(TPrint 480 22 67 -1 185) ; "...at least for the weekend!"
				(= seconds 3)
			)
			(29
				(Credits {Art Team Manager\n\nCheryl Loyd} 3)
				(= seconds 3)
			)
			(30
				(gCurRoom drawPic: 1 13)
				(= clr
					(switch (Random 0 5)
						(0 gColVLRed)
						(1 gColLYellow)
						(2 gColVLGreen)
						(3 gColVLBlue)
						(4 gColLMagenta)
						(else gColLCyan)
					)
				)
				(Display
					{Animators\n\n}
					dsCOLOR
					clr
					dsCOORD
					1
					35
					dsWIDTH
					318
					dsFONT
					gBigFont
					dsALIGN
					alCENTER
				)
				(Display
					{\n\nCheryl Loyd\nBarry T. Smith\nRoger Hardy Jr.\nDana M. Dean\nKarin Young\nMarc Hudgins\nEric Kasner}
					dsCOLOR
					clr
					dsCOORD
					1
					35
					dsWIDTH
					159
					dsFONT
					gBigFont
					dsALIGN
					alCENTER
				)
				(Display
					{\n\nRichard Powell\nPhyllis Cucchiara\nTerry Falls\nMichael Hutchison\nDesie Hartman\nWillis Wong}
					dsCOLOR
					clr
					dsCOORD
					161
					35
					dsWIDTH
					159
					dsFONT
					gBigFont
					dsALIGN
					alCENTER
				)
				(= seconds 8)
			)
			(31
				(Credits
					{Background Artists\n\nJane Cardinal\nMaurice Morgan\nAndy Hoyos\nCheryl Loyd\nJay Friedmann\nJennifer Shontz\nGloria Garland}
					9
				)
				(= seconds 5)
			)
			(32
				(Credits
					{Programmers\n\nBrian K. Hughes\nCarlos Escobar\nSteve Conrad\nJohn Hartin\nOliver Brelsford\nChris Carr\nAl Lowe}
					8
				)
				(= seconds 5)
			)
			(33
				(Credits {Music Director\n\nMark Seibert} 3)
				(= seconds 3)
			)
			(34
				(gCurRoom drawPic: 1 13)
				(= clr
					(switch (Random 0 5)
						(0 gColVLRed)
						(1 gColLYellow)
						(2 gColVLGreen)
						(3 gColVLBlue)
						(4 gColLMagenta)
						(else gColLCyan)
					)
				)
				(Display
					{Sierra's Creative Interpreter\nDevelopment System\n\n}
					dsCOLOR
					clr
					dsCOORD
					1
					23
					dsWIDTH
					318
					dsFONT
					gBigFont
					dsALIGN
					alCENTER
				)
				(Display
					{\n\n\nJeff Stephenson\nRobert E. Heitman\nDan Foy\nLarry Scott\nJohn Rettig\nJ. Mark Hood\nChris Smith\nTerry McHenry}
					dsCOLOR
					clr
					dsCOORD
					1
					23
					dsWIDTH
					159
					dsFONT
					gBigFont
					dsALIGN
					alCENTER
				)
				(Display
					{\n\n\nEric Hart\nChad Bye\nMark Wilden\nKen Koch\nJohn Crane\nSteve Coallier\nRandy Moss}
					dsCOLOR
					clr
					dsCOORD
					161
					23
					dsWIDTH
					159
					dsFONT
					gBigFont
					dsALIGN
					alCENTER
				)
				(= seconds 8)
			)
			(35
				(Credits {Additional Music\n\nChris Braymen} 3)
				(= seconds 3)
			)
			(36
				(Credits {Additional Written Material\n\nJosh Mandel} 3)
				(= seconds 3)
			)
			(37
				(Credits {Quality Assurance Team Leader\n\nRobin Bradley} 3)
				(= seconds 3)
			)
			(38
				(Credits {Coffee Grinder\n\nC. Escobar} 3)
				(= ticks 100)
			)
			(39
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(gTheMusic2 number: 161 setLoop: 1 play:)
				)
				(= seconds 3)
			)
			(40
				(gCurRoom drawPic: 1 13)
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(TPrint 480 23 80 {AL says} 67 -1 28) ; "Now would be an excellent time for you to save your game. We have a little surprise in store for you."
				)
				(= seconds 5)
			)
			(41
				(gTheMusic fade: self)
			)
			(42
				(if (not (DoSound sndGET_AUDIO_CAPABILITY))
					(+= state 1)
				else
					(gGame setCursor: 999 1)
					(TPrint ; "You did it! You finished the entire game! Congratulations to you from all of us, the creators of "Leisure Suit Larry 5: Passionate Patti Does a Little Undercover Work." We have a little reward for you. Since your computer has a DAC, here's a sample player so you can easily hear all the sounds from this game. We hope you enjoy hearing them again!"
						480
						24
						80
						{Congratulations! You Win!!}
						67
						-1
						15
						70
						280
					)
				)
				(= cycles 2)
			)
			(43
				(if
					(= soundIdx
						(PrintD
							{Aren't you glad you bought a MAC?}
							4
							50
							106
							81
							{Airport PA #1}
							1
							81
							{Airport PA #2}
							2
							81
							{Airport PA #3}
							3
							106
							81
							{Airport PA #4}
							4
							81
							{  Atmosphere  }
							5
							81
							{    Screams    }
							6
							106
							81
							{      Yeow      }
							7
							81
							{     Coffee     }
							8
							81
							{Folding Chair}
							9
							106
							81
							{ Wolf Whistle }
							10
							81
							{   Knocking   }
							11
							81
							{   Glass #1   }
							12
							106
							81
							{   Glass #2   }
							13
							81
							{       Ah       }
							14
							81
							{       Oh       }
							15
							106
							81
							{       AH!       }
							16
							81
							{      OH!      }
							17
							81
							{     Oooh!     }
							18
							106
							81
							{ Crowd Gasp }
							19
							81
							{ Slob Eating }
							20
							81
							{     Flush     }
							21
							106
							81
							{     Belch     }
							22
							81
							{     Barf     }
							23
							81
							{Do Not Touch}
							24
							106
							81
							{< Done >}
							0
							4
							115
							80
							{Thanks for buying "Larry 5!"}
							121
							soundIdx
						)
					)
					(gTheMusic number: [soundNums soundIdx] setLoop: 1 play:)
					(self changeState: state)
				else
					(= cycles 1)
				)
			)
			(44
				(gCurRoom drawPic: 1 13)
				(Display
					{Remember Al Lowe's Slogan:}
					dsCOLOR
					gColYellow
					dsCOORD
					1
					30
					dsWIDTH
					318
					dsFONT
					gNiceFont
					dsALIGN
					alCENTER
				)
				(= cycles 2)
			)
			(45
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(LoadMany rsSOUND 481)
				)
				(= seconds 3)
			)
			(46
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(gTheMusic number: 481 setVol: 127 setLoop: 1 play:)
				)
				(Display
					{Better Babes Through\nTechnology!}
					dsCOLOR
					gColVLRed
					dsCOORD
					1
					90
					dsWIDTH
					318
					dsFONT
					gGiantFont
					dsALIGN
					alCENTER
				)
				(= seconds 5)
			)
			(47
				(= gQuit 1)
			)
		)
	)
)

(instance copter of Actor
	(properties
		x 160
		y 144
		view 480
		loop 3
	)
)

