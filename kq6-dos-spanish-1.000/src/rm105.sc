;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 105)
(include sci.sh)
(use Main)
(use Audio)
(use KQ6Room)
(use RandCycle)
(use LoadMany)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm105 0
)

(local
	local0
	local1 = 1
	[local2 400]
	local402
	local403
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
		(if local1
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
		(= local0 0)
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
					(= gMsgType 1)
					(= local0 1)
				else
					(= gMsgType 1)
					(= local0 0)
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
				(Message msgGET 105 1 0 0 1 @local2) ; "Long ago, in the castle of a kingdom called Daventry...."
				(= local402
					(Display @local2 dsCOORD 12 81 dsWIDTH 300 dsCOLOR 98 dsFONT 3110 dsALIGN alCENTER dsSAVEPIXELS)
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
				(Display 105 1 dsRESTOREPIXELS local402)
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
				(if local0
					(cassMouth init: setPri: 15 setCycle: RandCycle)
					(localAudio number: 3001 play: self)
				else
					(= ticks 40)
				)
			)
			(24
				(Display 105 1 dsRESTOREPIXELS local402)
				(Message msgGET 105 1 0 0 10 @local2) ; "Alexander.... I feel so alone. I don't know what to do.... Alexander, I wish you were here...."
				(= local402
					(Display @local2 dsCOORD 25 150 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
				)
				(if local0
					(localAudio number: 3002 play: self)
				else
					(= ticks 380)
				)
			)
			(25
				(Display 105 1 dsRESTOREPIXELS local402)
				(Message msgGET 105 1 0 0 11 @local2) ; "Cassima! Wait!"
				(= local402 (Display @local2 dsCOORD 25 5 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS))
				(if local0
					(localAudio number: 1007 play:)
				else
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
				(Display 105 1 dsRESTOREPIXELS local402)
				(Message msgGET 105 1 0 0 12 @local2) ; "MOTHER! MOTHER, COME QUICK!"
				(= local402
					(Display @local2 dsCOORD 25 5 dsWIDTH 280 dsCOLOR 98 dsBACKGROUND 0 dsFONT 1 dsSAVEPIXELS)
				)
				(if local0
					(localAudio number: 1008 play: self)
				else
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
				(Message msgGET 105 1 0 0 21 @local2) ; "Three long months Prince Alexander sailed the known seas...and beyond."
				(= local402
					(Display @local2 dsCOORD 12 81 dsWIDTH 300 dsCOLOR 98 dsFONT 3110 dsALIGN alCENTER dsSAVEPIXELS)
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
				(Display 105 1 dsRESTOREPIXELS local402)
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
				(Message msgGET 105 1 0 0 23 @local2) ; "As the ship nears the shore, day turns to night and the sea turns violent...."
				(Display 105 1 dsRESTOREPIXELS local402)
				(= local402
					(Display @local2 dsCOORD 12 81 dsWIDTH 300 dsCOLOR 98 dsFONT 3110 dsALIGN alCENTER dsSAVEPIXELS)
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
				(Display 105 1 dsRESTOREPIXELS local402)
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
				(= local1 0)
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
				(alMouth init: setPri: 15 setCycle: RandCycle hide:)
				(Message msgGET 105 1 0 0 2 @local2) ; "Alexander! Here you are! You're still not thinking about Cassima, are you?"
				(= local402
					(Display @local2 dsCOORD 25 150 dsWIDTH 300 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
				)
				(valMouth init: setPri: 15 setCycle: RandCycle)
				(if local0
					(localAudio number: 2001 play: self)
				else
					(= ticks 319)
				)
			)
			(3
				(alMouth show:)
				(valMouth setCycle: 0 hide:)
				(Display 105 1 dsRESTOREPIXELS local402)
				(Message msgGET 105 1 0 0 3 @local2) ; "Hmmm? I suppose I am."
				(= local402 (Display @local2 dsCOORD 25 5 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS))
				(if local0
					(localAudio number: 1002 play: self)
				else
					(= ticks 116)
				)
			)
			(4
				(alMouth setCycle: 0 hide:)
				(valMouth show: setPri: 15 setCycle: RandCycle)
				(Display 105 1 dsRESTOREPIXELS local402)
				(Message msgGET 105 1 0 0 4 @local2) ; "Son, it's been MONTHS. You've GOT to pull yourself together. After all, you only met her that once...."
				(= local402
					(Display @local2 dsCOORD 25 150 dsWIDTH 300 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
				)
				(if local0
					(localAudio number: 2002 play: self)
				else
					(= ticks 383)
				)
			)
			(5
				(valMouth setCycle: 0 hide:)
				(alMouth show: setPri: 15 setCycle: RandCycle)
				(Display 105 1 dsRESTOREPIXELS local402)
				(Message msgGET 105 1 0 0 5 @local2) ; "I know."
				(= local402 (Display @local2 dsCOORD 25 5 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS))
				(if local0
					(localAudio number: 1003 play: self)
				else
					(= ticks 60)
				)
			)
			(6
				(alMouth setCycle: 0 hide:)
				(valMouth show: setPri: 15 setCycle: RandCycle)
				(Display 105 1 dsRESTOREPIXELS local402)
				(Message msgGET 105 1 0 0 6 @local2) ; "Have you discovered anything about the Land of the Green Isles?"
				(= local402
					(Display @local2 dsCOORD 25 150 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
				)
				(if local0
					(localAudio number: 2004 play: self)
				else
					(= ticks 281)
				)
			)
			(7
				(valMouth setCycle: 0 hide:)
				(alMouth show: setPri: 15 setCycle: RandCycle)
				(Display 105 1 dsRESTOREPIXELS local402)
				(Message msgGET 105 1 0 0 7 @local2) ; "No! No one's even heard of it! It's like she's just vanished!"
				(= local402 (Display @local2 dsCOORD 25 5 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS))
				(if local0
					(localAudio number: 1005 play: self)
				else
					(= ticks 210)
				)
			)
			(8
				(alMouth setCycle: 0 hide:)
				(valMouth show: setPri: 15 setCycle: RandCycle)
				(Display 105 1 dsRESTOREPIXELS local402)
				(Message msgGET 105 1 0 0 8 @local2) ; "I wish I could help. Please try to think about something else, dear."
				(= local402
					(Display @local2 dsCOORD 25 150 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
				)
				(if local0
					(localAudio number: 2005 play: self)
				else
					(= ticks 216)
				)
			)
			(9
				(valMouth setCycle: 0 hide:)
				(alMouth show: setPri: 15 setCycle: RandCycle)
				(Display 105 1 dsRESTOREPIXELS local402)
				(Message msgGET 105 1 0 0 9 @local2) ; "I'll try, Mother."
				(= local402 (Display @local2 dsCOORD 25 5 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS))
				(if local0
					(localAudio number: 1006 play: self)
				else
					(= ticks 278)
				)
			)
			(10
				(= cycles 2)
			)
			(11
				(Display 105 1 dsRESTOREPIXELS local402)
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
				(valMouth init: setPri: 15 setCycle: RandCycle)
				(Display 105 1 dsRESTOREPIXELS local402)
				(Message msgGET 105 1 0 0 13 @local2) ; "Alexander, what on earth? You're white as a ghost!"
				(= local402
					(Display @local2 dsCOORD 25 150 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
				)
				(if local0
					(localAudio number: 2006 play: self)
				else
					(= ticks 259)
				)
			)
			(1
				(valMouth setCycle: 0 hide:)
				(alMouth init: setPri: 15 setCycle: RandCycle)
				(Display 105 1 dsRESTOREPIXELS local402)
				(Message msgGET 105 1 0 0 14 @local2) ; "Mother, I saw Cassima! She was in the mirror!"
				(= local402 (Display @local2 dsCOORD 25 5 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS))
				(if local0
					(localAudio number: 1009 play: self)
				else
					(= ticks 233)
				)
			)
			(2
				(alMouth setCycle: 0 hide:)
				(valMouth show: setPri: 15 setCycle: RandCycle)
				(Display 105 1 dsRESTOREPIXELS local402)
				(Message msgGET 105 1 0 0 15 @local2) ; "In the mirror? The magic mirror?"
				(= local402
					(Display @local2 dsCOORD 25 150 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
				)
				(if local0
					(localAudio number: 2007 play: self)
				else
					(= ticks 176)
				)
			)
			(3
				(valMouth setCycle: 0 hide:)
				(alMouth show: setPri: 15 setCycle: RandCycle)
				(Display 105 1 dsRESTOREPIXELS local402)
				(Message msgGET 105 1 0 0 16 @local2) ; "Yes! And it showed me how to find her!"
				(= local402 (Display @local2 dsCOORD 25 5 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS))
				(if local0
					(localAudio number: 1010 play: self)
				else
					(= ticks 94)
				)
			)
			(4
				(alMouth setCycle: 0 hide:)
				(valMouth show: setPri: 15 setCycle: RandCycle)
				(Display 105 1 dsRESTOREPIXELS local402)
				(Message msgGET 105 1 0 0 17 @local2) ; "How?"
				(= local402
					(Display @local2 dsCOORD 25 150 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
				)
				(if local0
					(localAudio number: 2008 play: self)
				else
					(= ticks 71)
				)
			)
			(5
				(valMouth setCycle: 0 hide:)
				(alMouth show: setPri: 15 setCycle: RandCycle)
				(Display 105 1 dsRESTOREPIXELS local402)
				(Message msgGET 105 1 0 0 18 @local2) ; "The stars! I saw the stars outside her window! I can navigate by the stars!"
				(= local402 (Display @local2 dsCOORD 25 5 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS))
				(if local0
					(localAudio number: 1011 play: self)
				else
					(= ticks 351)
				)
			)
			(6
				(alMouth setCycle: 0 hide:)
				(valMouth show: setPri: 15 setCycle: RandCycle)
				(Display 105 1 dsRESTOREPIXELS local402)
				(Message msgGET 105 1 0 0 19 @local2) ; "Oh, Alexander.... If you really go...."
				(= local402
					(Display @local2 dsCOORD 25 150 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS)
				)
				(if local0
					(localAudio number: 2009 play: self)
				else
					(= ticks 245)
				)
			)
			(7
				(valMouth setCycle: 0 hide:)
				(alMouth show: setPri: 15 setCycle: RandCycle)
				(Display 105 1 dsRESTOREPIXELS local402)
				(Message msgGET 105 1 0 0 20 @local2) ; "It will be alright, Mother. I promise."
				(= local402 (Display @local2 dsCOORD 25 5 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS))
				(if local0
					(localAudio number: 1012 play: self)
				else
					(= ticks 170)
				)
			)
			(8
				(Display 105 1 dsRESTOREPIXELS local402)
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
				(Display 105 1 dsRESTOREPIXELS local402)
				(Message msgGET 105 1 0 0 22 @local2) ; "Land ho! LAND HO! LAND HO!"
				(= local402 (Display @local2 dsCOORD 25 5 dsWIDTH 280 dsCOLOR 98 dsFONT 1 dsSAVEPIXELS))
				(if local0
					(localAudio number: 1013 play: self)
				else
					(= ticks 254)
				)
			)
			(14
				(ocean setMotion: MoveTo -17 39 showMovie)
			)
		)
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

(instance cassEyes of Actor ; UNUSED
	(properties
		x 103
		y 69
		view 140
		cel 1
	)

	(method (init)
		(self setScript: (motionScript new:))
		(super init: &rest)
	)
)

(instance alEyes106 of Actor
	(properties
		x 97
		y 74
		view 109
		loop 3
	)

	(method (init)
		(self setScript: (motionScript new:))
		(super init: &rest)
	)
)

(instance valEyes106 of Actor
	(properties
		x 225
		y 73
		view 109
		loop 7
		cel 1
	)

	(method (init)
		(self setScript: (motionScript new:))
		(super init: &rest)
	)
)

(instance alBrow106 of Actor
	(properties
		x 98
		y 71
		view 109
		loop 2
	)

	(method (init)
		(self setScript: (motionScript new:))
		(super init: &rest)
	)
)

(instance valBrow106 of Actor
	(properties
		x 227
		y 70
		view 109
		loop 6
	)

	(method (init)
		(self setScript: (motionScript new:))
		(super init: &rest)
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

(instance valRArm106 of Actor
	(properties
		x 230
		y 97
		view 109
		loop 4
	)

	(method (init)
		(self setScript: (armScript new:))
		(super init: &rest)
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

(instance cassArms of Actor ; UNUSED
	(properties
		x 85
		y 151
		view 1401
	)

	(method (init)
		(self setScript: (armScript new:))
		(super init: &rest)
	)
)

(instance alRArm106 of Actor
	(properties
		x 38
		y 141
		view 109
		loop 1
	)

	(method (init)
		(self setScript: (armScript new:))
		(super init: &rest)
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

