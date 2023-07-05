;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 105)
(include sci.sh)
(use Main)
(use Audio)
(use KQ6Room)
(use Sync)
(use LoadMany)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm105 0
)

(local
	local0 = 1
	[local1 400]
	local401
	local402
)

(instance rm105 of KQ6Room
	(properties
		picture 98
		autoLoad 0
	)

	(method (init)
		(super init: &rest)
		(if (checkForFiles doit:)
			(Palette palSET_INTENSITY 0 256 0)
			(gDirectionHandler addToFront: self)
			(gKeyDownHandler addToFront: self)
			(gMouseDownHandler addToFront: self)
			(self setScript: showMovie)
		else
			(gMessager say: 0 0 1 0 self) ; "The files needed to run the opening cartoon are not available on your hard drive. Please reinstall the game if you wish to see the cartoon."
		)
	)

	(method (doit)
		(if local0
			(localAudio check:)
		)
		(super doit: &rest)
	)

	(method (cue)
		(gGame restart: 1)
	)

	(method (handleEvent)
		(SetVideoMode 0)
		(Cursor showCursor: 1)
		(gGame restart: 1)
	)

	(method (newRoom)
		(= gMsgType 1)
		(= global83 0)
		(gDirectionHandler delete: self)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(LoadMany 0 929)
		(super newRoom: &rest)
	)
)

(instance checkForFiles of Code
	(properties)

	(method (doit &tmp [temp0 20])
		(Format @temp0 105 0) ; "LAND.SEQ"
		(if (FileIO fiEXISTS @temp0)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance localAudio of Audio
	(properties)
)

(instance showMovie of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gTheIconBar disable: height: -100 activateHeight: -100)
				(User controls: 1)
				(Cursor showCursor: 0)
				(if (DoSound sndGET_AUDIO_CAPABILITY)
					(= gMsgType 2)
					(= global83 1)
				else
					(= gMsgType 1)
					(= global83 0)
				)
				(= cycles 1)
			)
			(1
				(DrawPic 107)
				(SetVideoMode 1)
				(Animate 0)
				(for ((= temp0 0)) (< temp0 100) ((++ temp0))
					(Palette palSET_INTENSITY 0 256 temp0)
					(for ((= temp1 0)) (< temp1 30) ((++ temp1))
					)
				)
				(= cycles 1)
			)
			(2
				((ScriptID 107 2) doit: 1 self) ; fadeThePic
			)
			(3
				(gGlobalSound loop: 1 number: 105 play:)
				(Message msgGET 105 1 0 0 1 @local1) ; "Long ago, in the castle of a kingdom called Daventry...."
				(= local401
					(Display @local1 dsCOORD 12 81 dsWIDTH 300 dsCOLOR 98 dsFONT 3110 dsALIGN alCENTER dsSAVEPIXELS)
				)
				(= cycles 1)
			)
			(4
				((ScriptID 107 2) doit: 0 self) ; fadeThePic
			)
			(5
				(= seconds 6)
			)
			(6
				((ScriptID 107 2) doit: 1 self) ; fadeThePic
			)
			(7
				(Display 105 1 dsRESTOREPIXELS local401)
				(= seconds 2)
			)
			(8
				(self setScript: alAndValTalkOne self)
			)
			(9
				((ScriptID 107 2) doit: 1 self) ; fadeThePic
			)
			(10
				(= seconds 2)
			)
			(11
				(DrawPic 104)
				(flameThree init: setCycle: Fwd)
				(= cycles 1)
			)
			(12
				((ScriptID 107 2) doit: 0 self) ; fadeThePic
			)
			(13
				(= seconds 2)
			)
			(14
				(= seconds 2)
			)
			(15
				(gGlobalSound fade:)
				(= cycles 10)
			)
			(16
				(gGlobalSound number: 106 play:)
				(= seconds 5)
			)
			(17
				(flameThree dispose:)
				(= cycles 1)
			)
			(18
				(gGlobalSound stop:)
				(gGlobalSound number: 107 play:)
				(ShowMovie {FS3A.SEQ} 8)
				(ShowMovie {FS3B.SEQ} 8)
				(= cycles 1)
			)
			(19
				((ScriptID 107 2) doit: 1 self) ; fadeThePic
			)
			(20
				(DrawPic 141)
				(= cycles 1)
			)
			(21
				((ScriptID 107 2) doit: 0 self) ; fadeThePic
			)
			(22
				(= cycles 10)
			)
			(23
				(if global83
					(cassMouth init:)
					(localAudio number: 3001 play: self)
					(cassMouth setCycle: MouthSync 3001)
				else
					(= ticks 40)
				)
			)
			(24
				(if global83
					(localAudio number: 3002 play: self)
					(cassMouth setCycle: MouthSync 3002)
				else
					(Display 105 1 dsRESTOREPIXELS local401)
					(Message msgGET 105 1 0 0 10 @local1) ; "Alexander.... I feel so alone. I don't know what to do.... Alexander, I wish you were here...."
					(= local401
						(Display @local1 dsCOORD 25 150 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
					)
					(= ticks 380)
				)
			)
			(25
				(if global83
					(localAudio number: 1007 play:)
				else
					(Display 105 1 dsRESTOREPIXELS local401)
					(Message msgGET 105 1 0 0 11 @local1) ; "Cassima! Wait!"
					(= local401
						(Display @local1 dsCOORD 25 5 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
					)
					(= ticks 104)
				)
				(cassMouth dispose:)
				((ScriptID 107 2) doit: 1 self) ; fadeThePic
			)
			(26
				(DrawPic 107)
				(= cycles 2)
			)
			(27
				(Palette palSET_INTENSITY 0 231 100)
				(gGlobalSound fade: 20 0 2 self)
			)
			(28
				(gGlobalSound number: 108 play:)
				(if global83
					(localAudio number: 1008 play: self)
				else
					(Display 105 1 dsRESTOREPIXELS local401)
					(Message msgGET 105 1 0 0 12 @local1) ; "MOTHER! MOTHER, COME QUICK!"
					(= local401
						(Display @local1 dsCOORD 25 5 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
					)
					(= ticks 130)
				)
			)
			(29
				(ShowMovie {PAN.SEQ} 8)
				(= cycles 1)
			)
			(30
				(self setScript: alAndValTalkTwo self)
			)
			(31
				(DrawPic 107 9)
				(= cycles 2)
			)
			(32
				(gGlobalSound stop: number: 109 loop: -1 play: self)
				(Message msgGET 105 1 0 0 21 @local1) ; "Three long months Prince Alexander sailed the known seas...and beyond."
				(= local401
					(Display @local1 dsCOORD 12 81 dsWIDTH 300 dsCOLOR 98 dsFONT 3110 dsALIGN alCENTER dsSAVEPIXELS)
				)
				((ScriptID 107 2) doit: 0 self) ; fadeThePic
			)
			(33
				(= seconds 3)
			)
			(34
				((ScriptID 107 2) doit: 1 self) ; fadeThePic
			)
			(35
				(Display 105 1 dsRESTOREPIXELS local401)
				(= cycles 2)
			)
			(36
				(Palette palSET_INTENSITY 0 231 100)
			)
			(37
				(ShowMovie {BOAT.SEQ} 8)
				(ShowMovie {OPEN.SEQ} 8)
				(ShowMovie {SCAN.SEQ} 8)
				(= cycles 1)
			)
			(38
				(DrawPic 107)
				(scope
					init:
					setPri: 6
					illegalBits: 0
					ignoreActors: 1
					setLoop: 1
				)
				(ocean
					init:
					setPri: 4
					ignoreHorizon: 1
					illegalBits: 0
					ignoreActors: 1
					setLoop: 0
					setScript: moveOcean
				)
			)
			(39
				(ocean dispose:)
				(scope dispose:)
				(DrawPic 107)
				(= cycles 1)
			)
			(40
				(ShowMovie {LAND.SEQ} 8)
				((ScriptID 107 2) doit: 1 self) ; fadeThePic
			)
			(41
				(DrawPic 107)
				(gGlobalSound fade: 20 0 2 self)
			)
			(42
				(gGlobalSound stop: number: 110 loop: 1 play: self)
				(Message msgGET 105 1 0 0 23 @local1) ; "As the ship nears the shore, day turns to night and the sea turns violent...."
				(Display 105 1 dsRESTOREPIXELS local401)
				(= local401
					(Display @local1 dsCOORD 12 81 dsWIDTH 300 dsCOLOR 98 dsFONT 3110 dsALIGN alCENTER dsSAVEPIXELS)
				)
				(= cycles 1)
			)
			(43
				((ScriptID 107 2) doit: 0 self) ; fadeThePic
			)
			(44
				(= seconds 7)
			)
			(45
				((ScriptID 107 2) doit: 1 self) ; fadeThePic
			)
			(46
				(Display 105 1 dsRESTOREPIXELS local401)
				(Palette palSET_INTENSITY 0 231 100)
				(= cycles 2)
			)
			(47
				(DrawPic 107)
				(ShowMovie {NSHP.SEQ} 8)
				((ScriptID 107 2) doit: 1 self) ; fadeThePic
			)
			(48
				(DrawPic 107)
			)
			(49
				(= local0 0)
				(self setScript: (ScriptID 107 0) self) ; startOfCredits
			)
			(50
				(for ((= temp0 100)) (> temp0 0) ((-- temp0))
					(Palette palSET_INTENSITY 0 256 temp0)
					(for ((= temp1 0)) (< temp1 30) ((++ temp1))
					)
				)
				(= cycles 1)
			)
			(51
				(DrawPic 98)
				(= cycles 1)
			)
			(52
				(SetVideoMode 0)
				(Cursor showCursor: 1)
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance alAndValTalkOne of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 106)
				(alEyes106 init:)
				(valEyes106 init:)
				(alBrow106 init:)
				(valBrow106 init:)
				(alLArm106 init:)
				(alRArm106 init:)
				(valRArm106 init:)
				(valLArm106 init:)
				(flameFour init: setPri: 15 setCycle: Fwd)
				(= cycles 1)
			)
			(1
				((ScriptID 107 2) doit: 0 self) ; fadeThePic
			)
			(2
				(alMouth init: setPri: 15 setCycle: Fwd hide:)
				(if global83
					(localAudio number: 2001 play: self)
					(valMouth init: setPri: 15 setCycle: MouthSync 2001)
				else
					(valMouth init: setPri: 15 setCycle: Fwd)
					(Message msgGET 105 1 0 0 2 @local1) ; "Alexander! Here you are! You're still not thinking about Cassima, are you?"
					(= local401
						(Display @local1 dsCOORD 25 150 dsWIDTH 300 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
					)
					(= ticks 319)
				)
			)
			(3
				(alMouth show:)
				(valMouth setCycle: 0 hide:)
				(if global83
					(localAudio number: 1002 play: self)
					(alMouth show: setCycle: MouthSync 1002)
				else
					(Display 105 1 dsRESTOREPIXELS local401)
					(Message msgGET 105 1 0 0 3 @local1) ; "Hmmm? I suppose I am."
					(= local401
						(Display @local1 dsCOORD 25 5 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
					)
					(= ticks 116)
				)
			)
			(4
				(alMouth setCycle: 0 hide:)
				(valMouth show: setPri: 15 setCycle: Fwd)
				(if global83
					(localAudio number: 2002 play: self)
					(valMouth show: setPri: 15 setCycle: MouthSync 2002)
				else
					(Display 105 1 dsRESTOREPIXELS local401)
					(Message msgGET 105 1 0 0 4 @local1) ; "Son, it's been MONTHS. You've GOT to pull yourself together. After all, you only met her that once...."
					(= local401
						(Display @local1 dsCOORD 25 150 dsWIDTH 300 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
					)
					(= ticks 383)
				)
			)
			(5
				(valMouth setCycle: 0 hide:)
				(alMouth show: setPri: 15 setCycle: Fwd)
				(if global83
					(localAudio number: 1003 play: self)
					(alMouth show: setPri: 15 setCycle: MouthSync 1003)
				else
					(Display 105 1 dsRESTOREPIXELS local401)
					(Message msgGET 105 1 0 0 5 @local1) ; "I know."
					(= local401
						(Display @local1 dsCOORD 25 5 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
					)
					(= ticks 60)
				)
			)
			(6
				(alMouth setCycle: 0 hide:)
				(valMouth show: setPri: 15 setCycle: Fwd)
				(if global83
					(localAudio number: 2004 play: self)
					(valMouth show: setPri: 15 setCycle: MouthSync 2004)
				else
					(Display 105 1 dsRESTOREPIXELS local401)
					(Message msgGET 105 1 0 0 6 @local1) ; "Have you discovered anything about the Land of the Green Isles?"
					(= local401
						(Display @local1 dsCOORD 25 150 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
					)
					(= ticks 281)
				)
			)
			(7
				(valMouth setCycle: 0 hide:)
				(alMouth show: setPri: 15 setCycle: Fwd)
				(if global83
					(localAudio number: 1005 play: self)
					(alMouth show: setPri: 15 setCycle: MouthSync 1005)
				else
					(Display 105 1 dsRESTOREPIXELS local401)
					(Message msgGET 105 1 0 0 7 @local1) ; "No! No one's even heard of it! It's like she's just vanished!"
					(= local401
						(Display @local1 dsCOORD 25 5 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
					)
					(= ticks 210)
				)
			)
			(8
				(alMouth setCycle: 0 hide:)
				(valMouth show: setPri: 15 setCycle: Fwd)
				(if global83
					(localAudio number: 2005 play: self)
					(valMouth show: setPri: 15 setCycle: MouthSync 2005)
				else
					(Display 105 1 dsRESTOREPIXELS local401)
					(Message msgGET 105 1 0 0 8 @local1) ; "I wish I could help. Please try to think about something else, dear."
					(= local401
						(Display @local1 dsCOORD 25 150 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
					)
					(= ticks 216)
				)
			)
			(9
				(valMouth setCycle: 0 hide:)
				(alMouth show: setPri: 15 setCycle: Fwd)
				(if global83
					(localAudio number: 1006 play: self)
					(alMouth show: setPri: 15 setCycle: MouthSync 1006)
				else
					(Display 105 1 dsRESTOREPIXELS local401)
					(Message msgGET 105 1 0 0 9 @local1) ; "I'll try, Mother."
					(= local401
						(Display @local1 dsCOORD 25 5 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
					)
					(= ticks 278)
				)
			)
			(10
				(= cycles 2)
			)
			(11
				(Display 105 1 dsRESTOREPIXELS local401)
				(alBrow106 dispose:)
				(alEyes106 dispose:)
				(valBrow106 dispose:)
				(valEyes106 dispose:)
				(alLArm106 dispose:)
				(alRArm106 dispose:)
				(valRArm106 dispose:)
				(valLArm106 dispose:)
				(flameFour dispose:)
				(valMouth dispose:)
				(alMouth dispose:)
				(gTheIconBar disable: height: 0 activateHeight: 0)
				(self dispose:)
			)
		)
	)
)

(instance alAndValTalkTwo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DrawPic 106)
				(alEyes106 init:)
				(valEyes106 init:)
				(alBrow106 init:)
				(valBrow106 init:)
				(alLArm106 init:)
				(alRArm106 init:)
				(valRArm106 init:)
				(valLArm106 init:)
				(flameFour init: setPri: 15 setCycle: Fwd)
				(valMouth init: setPri: 15 setCycle: Fwd)
				(if global83
					(localAudio number: 2006 play: self)
					(valMouth init: setPri: 15 setCycle: MouthSync 2006)
				else
					(Display 105 1 dsRESTOREPIXELS local401)
					(Message msgGET 105 1 0 0 13 @local1) ; "Alexander, what on earth? You're white as a ghost!"
					(= local401
						(Display @local1 dsCOORD 25 150 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
					)
					(= ticks 259)
				)
			)
			(1
				(valMouth setCycle: 0 hide:)
				(alMouth init: setPri: 15 setCycle: Fwd)
				(if global83
					(localAudio number: 1009 play: self)
					(alMouth init: setPri: 15 setCycle: MouthSync 1009)
				else
					(Display 105 1 dsRESTOREPIXELS local401)
					(Message msgGET 105 1 0 0 14 @local1) ; "Mother, I saw Cassima! She was in the mirror!"
					(= local401
						(Display @local1 dsCOORD 25 5 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
					)
					(= ticks 233)
				)
			)
			(2
				(alMouth setCycle: 0 hide:)
				(valMouth show: setPri: 15 setCycle: Fwd)
				(if global83
					(localAudio number: 2007 play: self)
					(valMouth show: setPri: 15 setCycle: MouthSync 2007)
				else
					(Display 105 1 dsRESTOREPIXELS local401)
					(Message msgGET 105 1 0 0 15 @local1) ; "In the mirror? The magic mirror?"
					(= local401
						(Display @local1 dsCOORD 25 150 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
					)
					(= ticks 176)
				)
			)
			(3
				(valMouth setCycle: 0 hide:)
				(alMouth show: setPri: 15 setCycle: Fwd)
				(if global83
					(localAudio number: 1010 play: self)
					(alMouth show: setPri: 15 setCycle: MouthSync 1010)
				else
					(Display 105 1 dsRESTOREPIXELS local401)
					(Message msgGET 105 1 0 0 16 @local1) ; "Yes! And it showed me how to find her!"
					(= local401
						(Display @local1 dsCOORD 25 5 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
					)
					(= ticks 94)
				)
			)
			(4
				(alMouth setCycle: 0 hide:)
				(valMouth show: setPri: 15 setCycle: Fwd)
				(if global83
					(localAudio number: 2008 play: self)
					(valMouth show: setPri: 15 setCycle: MouthSync 2008)
				else
					(Display 105 1 dsRESTOREPIXELS local401)
					(Message msgGET 105 1 0 0 17 @local1) ; "How?"
					(= local401
						(Display @local1 dsCOORD 25 150 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
					)
					(= ticks 71)
				)
			)
			(5
				(valMouth setCycle: 0 hide:)
				(alMouth show: setPri: 15 setCycle: Fwd)
				(if global83
					(localAudio number: 1011 play: self)
					(alMouth show: setPri: 15 setCycle: MouthSync 1011)
				else
					(Display 105 1 dsRESTOREPIXELS local401)
					(Message msgGET 105 1 0 0 18 @local1) ; "The stars! I saw the stars outside her window! I can navigate by the stars!"
					(= local401
						(Display @local1 dsCOORD 25 5 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
					)
					(= ticks 351)
				)
			)
			(6
				(alMouth setCycle: 0 hide:)
				(valMouth show: setPri: 15 setCycle: Fwd)
				(if global83
					(localAudio number: 2009 play: self)
					(valMouth show: setPri: 15 setCycle: MouthSync 2009)
				else
					(Display 105 1 dsRESTOREPIXELS local401)
					(Message msgGET 105 1 0 0 19 @local1) ; "Oh, Alexander.... If you really go...."
					(= local401
						(Display @local1 dsCOORD 25 150 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
					)
					(= ticks 245)
				)
			)
			(7
				(valMouth setCycle: 0 hide:)
				(alMouth show: setPri: 15 setCycle: Fwd)
				(if global83
					(localAudio number: 1012 play: self)
					(alMouth show: setPri: 15 setCycle: MouthSync 1012)
				else
					(Display 105 1 dsRESTOREPIXELS local401)
					(Message msgGET 105 1 0 0 20 @local1) ; "It will be alright, Mother. I promise."
					(= local401
						(Display @local1 dsCOORD 25 5 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
					)
					(= ticks 170)
				)
			)
			(8
				(Display 105 1 dsRESTOREPIXELS local401)
				((ScriptID 107 2) doit: 1 self) ; fadeThePic
			)
			(9
				(alEyes106 dispose:)
				(valEyes106 dispose:)
				(alBrow106 dispose:)
				(valBrow106 dispose:)
				(alLArm106 dispose:)
				(alRArm106 dispose:)
				(valRArm106 dispose:)
				(valLArm106 dispose:)
				(flameFour dispose:)
				(valMouth dispose:)
				(alMouth dispose:)
				(gTheIconBar disable: height: 0 activateHeight: 0)
				(self dispose:)
			)
		)
	)
)

(instance moveOcean of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ocean setMotion: MoveTo -17 36)
				(= cycles 9)
			)
			(1
				(ocean setMotion: MoveTo 300 36)
				(= cycles 5)
			)
			(2
				(ocean setMotion: MoveTo -17 36)
				(= cycles 7)
			)
			(3
				(ocean posn: (ocean x:) (+ (ocean y:) 1))
				(= cycles 2)
			)
			(4
				(ocean posn: (ocean x:) (+ (ocean y:) 1))
				(= cycles 9)
			)
			(5
				(ocean posn: (ocean x:) (- (ocean y:) 1))
				(= cycles 2)
			)
			(6
				(ocean posn: (ocean x:) (- (ocean y:) 1))
				(= cycles 9)
			)
			(7
				(ocean setMotion: MoveTo 300 36)
				(= cycles 4)
			)
			(8
				(ocean posn: (ocean x:) (- (ocean y:) 1))
				(= cycles 2)
			)
			(9
				(ocean posn: (ocean x:) (- (ocean y:) 1))
				(= cycles 9)
			)
			(10
				(ocean setMotion: MoveTo -17 36)
				(= cycles 6)
			)
			(11
				(ocean posn: (ocean x:) (+ (ocean y:) 1))
				(= cycles 2)
			)
			(12
				(ocean posn: (ocean x:) (+ (ocean y:) 1))
				(= seconds 6)
			)
			(13
				(if global83
					(localAudio number: 1013 play: self)
				else
					(Display 105 1 dsRESTOREPIXELS local401)
					(Message msgGET 105 1 0 0 22 @local1) ; "Land ho! LAND HO! LAND HO!"
					(= local401
						(Display @local1 dsCOORD 25 5 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
					)
					(= ticks 254)
				)
			)
			(14
				(ocean setMotion: MoveTo -17 39 showMovie)
			)
		)
	)
)

(class EyesAndBrows of Actor
	(properties)

	(method (init)
		(self setScript: (motionScript new:))
		(super init: &rest)
	)
)

(instance motionScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 5))
			)
			(1
				(client setCycle: End self)
			)
			(2
				(= cycles (Random 5 7))
			)
			(3
				(client setCycle: Beg self)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance cassEyes of EyesAndBrows ; UNUSED
	(properties
		x 103
		y 69
		view 140
		cel 1
	)
)

(instance alEyes106 of EyesAndBrows
	(properties
		x 97
		y 74
		view 109
		loop 3
	)
)

(instance valEyes106 of EyesAndBrows
	(properties
		x 225
		y 73
		view 109
		loop 7
		cel 1
	)
)

(instance alBrow106 of EyesAndBrows
	(properties
		x 98
		y 71
		view 109
		loop 2
	)
)

(instance valBrow106 of EyesAndBrows
	(properties
		x 227
		y 70
		view 109
		loop 6
	)
)

(instance cassMouth of Actor
	(properties
		x 111
		y 86
		view 1091
		cel 7
	)
)

(instance valMouth of Actor
	(properties
		x 242
		y 70
		view 106
		cel 2
	)
)

(instance alMouth of Actor
	(properties
		x 71
		y 65
		view 106
		loop 1
		cel 6
	)
)

(class Arms of Actor
	(properties)

	(method (init)
		(self setScript: (armScript new:))
		(super init: &rest)
	)
)

(instance armScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 5))
			)
			(1
				(switch client
					(valRArm106
						(if (valMouth cycler:)
							(client setCycle: End self)
						else
							(self init:)
						)
					)
					(alRArm106
						(if (alMouth cycler:)
							(alLArm106 setCycle: End self)
						else
							(self init:)
						)
					)
				)
			)
			(2
				(if (== client valRArm106)
					(= seconds 10)
				else
					(= cycles 10)
				)
			)
			(3
				(client setCycle: Beg self)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance valRArm106 of Arms
	(properties
		x 230
		y 97
		view 109
		loop 4
	)

	(method (setCycle param1)
		(valLArm106 setCycle: param1)
		(super setCycle: param1 &rest)
	)
)

(instance valLArm106 of Prop
	(properties
		x 288
		y 142
		view 109
		loop 5
		cel 2
	)
)

(instance cassArms of Arms ; UNUSED
	(properties
		x 85
		y 151
		view 1401
	)
)

(instance alRArm106 of Arms
	(properties
		x 38
		y 141
		view 109
		loop 1
	)

	(method (setCycle param1)
		(alLArm106 setCycle: param1)
		(super setCycle: param1 &rest)
	)
)

(instance alLArm106 of Prop
	(properties
		x 110
		y 141
		view 109
	)
)

(instance flameOne of Actor ; UNUSED
	(properties
		x 209
		y 59
		view 102
		cel 5
	)
)

(instance flameTwo of Actor ; UNUSED
	(properties
		x 208
		y 70
		view 103
		loop 1
		cel 2
	)
)

(instance flameThree of Actor
	(properties
		x 208
		y 70
		view 104
		cel 5
	)
)

(instance flameFour of Prop
	(properties
		x 176
		y 87
		view 106
		loop 2
		cel 2
	)
)

(instance scope of Actor
	(properties
		x 204
		y 128
		view 107
		loop 1
		priority 6
		illegalBits 0
	)
)

(instance ocean of Actor
	(properties
		x 190
		y 36
		view 107
		priority 4
		illegalBits 0
	)
)

