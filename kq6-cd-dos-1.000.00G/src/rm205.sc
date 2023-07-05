;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 205)
(include sci.sh)
(use Main)
(use KQ6Print)
(use KQ6Room)
(use Kq6Talker)
(use Body)
(use Print)
(use Messager)
(use Scaler)
(use Motion)
(use Actor)
(use System)

(public
	rm205 0
)

(local
	local0
	local1
)

(instance rm205 of KQ6Room
	(properties
		picture 200
	)

	(method (init)
		(super init: &rest)
		(gGlobalSound number: 915 loop: -1 play:)
		(gGlobalSound2 number: 916 loop: -1 play:)
		(= gMessager demoMessager)
		(= gEgo ego)
		(royalRing init:)
		(gEgo init: posn: 168 120)
		(ourCursor init: illegalBits: 0 ignoreActors: 1 ignoreHorizon: 1)
		(Cursor showCursor: 0)
		(= gMsgType 1)
		(gGame handsOff:)
		(self setScript: helpScript)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (handleEvent event)
		(if
			(and
				(not (event modifiers:))
				(& (event type:) evMOUSEKEYBOARD)
				(not (event claimed:))
			)
			(restartCode doit:)
			(return 1)
		)
	)
)

(instance restartCode of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(Cursor showCursor: 1)
		(gGame setCursor: gNormalCursor)
		(if (and argc param1)
			(= temp0 1)
		else
			(= temp0
				(Print
					posn: 70 70
					font: 4
					addText: 0 0 5 1 0 0 ; "Do you want to leave the demo?"
					addButton: 1 0 0 5 3 0 20 ; "Yes. I know all this stuff already."
					addButton: 0 0 0 5 2 0 38 ; "No. I'm fascinated."
					init:
				)
			)
		)
		(if temp0
			(gGlobalSound fade:)
			(gGlobalSound2 fade:)
			(DrawPic 98)
			(gMouseDownHandler delete: gCurRoom)
			(gKeyDownHandler delete: gCurRoom)
			(gGame restart: 1)
		else
			(Cursor showCursor: 0)
		)
		(super doit:)
	)
)

(instance ego of Body
	(properties
		modNum 0
		sightAngle 45
		view 900
	)

	(method (reset param1 param2)
		(if (> argc 0)
			(gEgo loop: param1)
		)
		(gEgo
			view: (if (> argc 1) param2 else 900)
			signal: 4096
			z: 0
			setLoop: -1
			setLoop: gEgoGroop
			setPri: -1
			setMotion: 0
			illegalBits: 0
			ignoreActors: 0
			ignoreHorizon: 1
			setStep: 5 3
			setCycle: Walk
			normal: 1
			setSpeed: currentSpeed
		)
		(if (and oldScaleSignal (== view 900))
			(cond
				((& oldScaleSignal $0002)
					(= scaleSignal oldScaleSignal)
					(= maxScale oldMaxScale)
				)
				((or oldMaxScale oldBackSize oldFrontY oldBackY)
					(gEgo
						setScale:
							Scaler
							oldMaxScale
							oldBackSize
							oldFrontY
							oldBackY
					)
				)
				(else
					(gEgo setScale:)
				)
			)
			(= oldScaleSignal
				(= oldMaxScale (= oldBackSize (= oldFrontY (= oldBackY 0))))
			)
		)
	)
)

(instance demoMessager of Messager
	(properties)

	(method (findTalker param1 &tmp temp0)
		(= temp0
			(switch param1
				(2 Alex_Demo)
				(else gNarrator)
			)
		)
	)
)

(instance helpScript of Script
	(properties)

	(method (changeState newState &tmp temp0 [temp1 5])
		(switch (= state newState)
			(0
				(gEgo reset: 2)
				(= cycles 2)
			)
			(1
				(gMessager say: 0 0 6 0 self) ; "During this demo, press the ENTER key on your keyboard or your left mouse button to clear each message. To exit this demo, press any key or click a mouse button when a text box is NOT on the screen."
			)
			(2
				(gMessager say: 0 0 0 1 self) ; "Hello. I'm Prince Alexander of Daventry, and I'm the one you'll be leading around on this quest. The success of my search for Cassima depends on you, so I thought I'd show you how to run things."
			)
			(3
				(gTheIconBar disable:)
				(ourCursor setCel: 7 setMotion: MoveTo 23 23 self)
			)
			(4
				(theWalkIcon init: stopUpd:)
				(theHandIcon init: stopUpd:)
				(theLookIcon init: stopUpd:)
				(theTalkIcon init: stopUpd:)
				(theCurInvIcon init: stopUpd:)
				(theCurInvIconMask init: stopUpd:)
				(theInvIcon init: stopUpd:)
				(theControlIcon init: stopUpd:)
				(= cycles 2)
			)
			(5
				(if (FileIO fiEXISTS {g})
					(ourCursor hide:)
					(Cursor showCursor: 1)
					(= temp1 0)
					(= temp0 0)
					(gGame setCursor: gNormalCursor)
					(repeat
						(breakif
							(!=
								(= temp0
									(Print
										font: gSmallFont
										addText: {Which script?}
										addEdit: @temp1 5 80
										addButton:
											1
											{1.       Continue       }
											0
											20
										addButton:
											2
											{2.     OtherIcons       }
											0
											34
										addButton:
											3
											{3.    InventoryScript   }
											0
											48
										addButton:
											4
											{4.  ControlPanelScript  }
											0
											62
										init:
									)
								)
								0
							)
						)
					)
					(if temp1
						(= temp0 (ReadNumber @temp1))
					)
					(switch temp0
						(1
							(helpScript cue:)
						)
						(2
							(client setScript: otherIconsScript)
						)
						(3
							(client setScript: inventoryScript)
						)
						(4
							(client setScript: controlPanelScript)
						)
					)
					(ourCursor show:)
					(Cursor showCursor: 0)
				else
					(helpScript cue:)
				)
			)
			(6
				(gMessager say: 0 0 0 2 self) ; "All my actions are controlled through ICONS. The icons are available through the ICON BAR. For mouse users, move your mouse cursor to the top of the screen. For keyboard users, press the ESCAPE key or the Del key on your numeric pad. For joystick, press the right or 'B' button. The icon bar will then appear, like this:"
			)
			(7
				(gMessager say: 0 0 0 3 self) ; "The icons on the icon bar are; the WALK icon..."
			)
			(8
				(theWalkIcon setCel: 1)
				(= seconds 2)
			)
			(9
				(theWalkIcon setCel: 0)
				(ourCursor setMotion: MoveTo 67 23 self)
			)
			(10
				(gMessager say: 0 0 0 4 self) ; "...the HAND icon..."
			)
			(11
				(theHandIcon setCel: 1)
				(= seconds 2)
			)
			(12
				(theHandIcon setCel: 0)
				(ourCursor setMotion: MoveTo 108 23 self)
			)
			(13
				(gMessager say: 0 0 0 5 self) ; "...the LOOK icon..."
			)
			(14
				(theLookIcon setCel: 1)
				(= seconds 2)
			)
			(15
				(theLookIcon setCel: 0)
				(ourCursor setMotion: MoveTo 154 23 self)
			)
			(16
				(gMessager say: 0 0 0 6 self) ; "...the TALK icon..."
			)
			(17
				(theTalkIcon setCel: 1)
				(= seconds 2)
			)
			(18
				(theTalkIcon setCel: 0)
				(ourCursor setMotion: MoveTo 202 23 self)
			)
			(19
				(gMessager say: 0 0 0 7 self) ; "...the CURRENT inventory icon window (when there is one)..."
			)
			(20
				(ourCursor setMotion: MoveTo 253 23 self)
			)
			(21
				(gMessager say: 0 0 0 8 self) ; "...the INVENTORY button..."
			)
			(22
				(theInvIcon setCel: 1)
				(= seconds 2)
			)
			(23
				(theInvIcon setCel: 0)
				(ourCursor setMotion: MoveTo 297 23 self)
			)
			(24
				(gMessager say: 0 0 0 9 self) ; "...and the SYSTEMS button."
			)
			(25
				(theControlIcon setCel: 1)
				(= seconds 2)
			)
			(26
				(theControlIcon setCel: 0)
				(= cycles 1)
			)
			(27
				(gMessager say: 0 0 0 10 self) ; "You can select an icon to use by 'clicking' on that icon on the icon bar. You 'click' with your left mouse button, your keyboard ENTER key, or your joystick FIRE button."
			)
			(28
				(ourCursor setMotion: MoveTo 23 23 self)
			)
			(29
				(= seconds 2)
			)
			(30
				(theWalkIcon setCel: 1)
				(= seconds 2)
			)
			(31
				(theWalkIcon setCel: 0)
				(ourCursor setCel: 0)
				(= cycles 15)
			)
			(32
				(theWalkIcon hide:)
				(theHandIcon hide:)
				(theLookIcon hide:)
				(theTalkIcon hide:)
				(theCurInvIcon hide:)
				(theCurInvIconMask hide:)
				(theInvIcon hide:)
				(theControlIcon hide:)
				(ourCursor setMotion: MoveTo 118 90 self)
			)
			(33
				(gMessager say: 0 0 0 11 self) ; "You can also select icons by clicking your right mouse button. This will cycle through all the action cursors; WALK, HAND, LOOK, TALK, and CURRENT inventory item icon. Key 5 on your keyboard's numeric pad cycles icons the same way."
			)
			(34
				(= seconds 2)
			)
			(35
				(ourCursor setCel: 1)
				(= seconds 1)
			)
			(36
				(ourCursor setCel: 2)
				(= seconds 1)
			)
			(37
				(ourCursor setCel: 3)
				(= seconds 1)
			)
			(38
				(ourCursor setCel: 0)
				(= seconds 1)
			)
			(39
				(ourCursor setCel: 1)
				(= seconds 1)
			)
			(40
				(gMessager say: 0 0 0 12 self) ; "As a short cut, if you have a middle mouse button, click it to cycle only between your active icon and the WALK icon. This is handy in a new area, for example, where you spend most of your time WALKing and LOOKing. Key 0 (or Ins) on your keyboard's numeric pad does the same thing."
			)
			(41
				(= seconds 2)
			)
			(42
				(ourCursor setCel: 0)
				(= seconds 1)
			)
			(43
				(ourCursor setCel: 1)
				(= seconds 1)
			)
			(44
				(ourCursor setCel: 0)
				(= seconds 1)
			)
			(45
				(ourCursor setCel: 1)
				(= seconds 1)
			)
			(46
				(gMessager say: 0 0 0 13 self) ; "Once you've selected an icon, click that icon wherever you wish to execute that action. Again, you can 'click' or execute the icon with the left mouse button, the ENTER key, or the FIRE button on your joystick."
			)
			(47
				(gMessager say: 0 0 0 14 self) ; "Okay. Got it? Let's try a few."
			)
			(48
				(ourCursor setMotion: MoveTo 23 23 self)
			)
			(49
				(theWalkIcon show: stopUpd:)
				(theHandIcon show: stopUpd:)
				(theLookIcon show: stopUpd:)
				(theTalkIcon show: stopUpd:)
				(theCurInvIcon show: stopUpd:)
				(theCurInvIconMask show: stopUpd:)
				(theInvIcon show: stopUpd:)
				(theControlIcon show: stopUpd:)
				(ourCursor setCel: 7)
				(= cycles 2)
			)
			(50
				(gMessager say: 0 0 0 15 self) ; "WALK. Use the WALK icon to move me from location to location in the game. Select the WALK icon and press it where you would like me to move. Like this:"
			)
			(51
				(= seconds 2)
			)
			(52
				(theWalkIcon setCel: 1)
				(= seconds 2)
			)
			(53
				(theWalkIcon setCel: 0)
				(ourCursor setCel: 0)
				(= cycles 15)
			)
			(54
				(theWalkIcon hide:)
				(theHandIcon hide:)
				(theLookIcon hide:)
				(theTalkIcon hide:)
				(theCurInvIcon hide:)
				(theCurInvIconMask hide:)
				(theInvIcon hide:)
				(theControlIcon hide:)
				(ourCursor setMotion: MoveTo 217 158 self)
			)
			(55
				(gEgo setMotion: MoveTo 217 158 self)
			)
			(56
				(= seconds 2)
			)
			(57
				(ourCursor setMotion: MoveTo 168 120 self)
			)
			(58
				(= seconds 2)
			)
			(59
				(gEgo setMotion: MoveTo 168 120 self)
			)
			(60
				(gEgo reset: 2)
				(= cycles 2)
			)
			(61
				(ourCursor setMotion: MoveTo 108 23 self)
			)
			(62
				(theWalkIcon show: stopUpd:)
				(theHandIcon show: stopUpd:)
				(theLookIcon show: stopUpd:)
				(theTalkIcon show: stopUpd:)
				(theCurInvIcon show: stopUpd:)
				(theCurInvIconMask show: stopUpd:)
				(theInvIcon show: stopUpd:)
				(theControlIcon show: stopUpd:)
				(ourCursor setCel: 7)
				(= cycles 2)
			)
			(63
				(gMessager say: 0 0 0 16 self) ; "LOOK. The LOOK icon triggers a printed message about objects and locations on the screen. Very often, clues and information about puzzles are in LOOK messages, so always click the LOOK icon everywhere on a new screen. To look at something, select the LOOK icon, and click it on whatever you want to look at."
			)
			(64
				(gMessager say: 0 0 0 17 self) ; "For example, see that glinting object on the sand near the water? Glinting objects are always a good idea to check out. Let's LOOK at it and see what the game has to say about it:"
			)
			(65
				(theLookIcon setCel: 1)
				(= seconds 2)
			)
			(66
				(theLookIcon setCel: 0)
				(ourCursor setCel: 1)
				(= cycles 15)
			)
			(67
				(theWalkIcon hide:)
				(theHandIcon hide:)
				(theLookIcon hide:)
				(theTalkIcon hide:)
				(theCurInvIcon hide:)
				(theCurInvIconMask hide:)
				(theInvIcon hide:)
				(theControlIcon hide:)
				(ourCursor setMotion: MoveTo 104 134 self)
			)
			(68
				(= cycles 2)
			)
			(69
				(gMessager say: 0 0 0 18 self) ; "Alexander's royal insignia ring lies abandoned on the sand. It must have slipped from his finger during the shipwreck. Fortunately, it was not lost in the sea."
			)
			(70
				(gMessager say: 0 0 0 19 self) ; "Hmmm. My royal insignia ring, eh? That might come in handy, don't you think? I'll show you how to get it with the next icon."
			)
			(71
				(ourCursor setMotion: MoveTo 67 23 self)
			)
			(72
				(theWalkIcon show: stopUpd:)
				(theHandIcon show: stopUpd:)
				(theLookIcon show: stopUpd:)
				(theTalkIcon show: stopUpd:)
				(theCurInvIcon show: stopUpd:)
				(theCurInvIconMask show: stopUpd:)
				(theInvIcon show: stopUpd:)
				(theControlIcon show: stopUpd:)
				(ourCursor setCel: 7)
				(= cycles 2)
			)
			(73
				(gMessager say: 0 0 0 20 self) ; "HAND. The HAND icon means 'manipulate object' and can be used to pick up things, open things, close things, move things, search things, and so on. Select the HAND icon and click it on an object that you want to manipulate."
			)
			(74
				(gMessager say: 0 0 0 21 self) ; "Let's pick up that ring on the sand now. Select HAND and click it on the ring. The ring is small, so be careful to click the tip of the finger on the HAND icon right on the ring, or the game will think you are trying to manipulate the sand."
			)
			(75
				(theHandIcon setCel: 1)
				(= seconds 2)
			)
			(76
				(theHandIcon setCel: 0)
				(ourCursor setCel: 2)
				(= cycles 15)
			)
			(77
				(theWalkIcon hide:)
				(theHandIcon hide:)
				(theLookIcon hide:)
				(theTalkIcon hide:)
				(theCurInvIcon hide:)
				(theCurInvIconMask hide:)
				(theInvIcon hide:)
				(theControlIcon hide:)
				(ourCursor setMotion: MoveTo 104 131 self)
			)
			(78
				(gEgo
					moveSpeed: 4
					cycleSpeed: 4
					setMotion: MoveTo 134 136 self
				)
			)
			(79
				(self setScript: takeRingScr self)
			)
			(80
				(gEgo
					moveSpeed: 4
					cycleSpeed: 4
					setMotion: MoveTo 168 120 self
				)
			)
			(81
				(gEgo reset: 2)
				(= cycles 2)
			)
			(82
				(gMessager say: 0 0 0 22 self) ; "Alexander picks up his royal insignia ring from the beach."
			)
			(83
				(gMessager say: 0 0 0 23 self) ; "The game also just told you what I did; I got the ring. Messages help make my actions more clear in most cases."
			)
			(84
				(client setScript: otherIconsScript)
			)
		)
	)
)

(instance otherIconsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ourCursor setMotion: MoveTo 154 23 self)
			)
			(1
				(theWalkIcon show: stopUpd:)
				(theHandIcon show: stopUpd:)
				(theLookIcon show: stopUpd:)
				(theTalkIcon show: stopUpd:)
				(theCurInvIcon show: stopUpd:)
				(theCurInvIconMask show: stopUpd:)
				(theInvIcon show: stopUpd:)
				(theControlIcon show: stopUpd:)
				(ourCursor setCel: 7)
				(= cycles 2)
			)
			(2
				(gMessager say: 0 0 3 1 self) ; "TALK. The TALK icon lets you talk to objects in the game. You can try TALKing to anything, although only speaking creatures will generally talk back. Select the TALK icon and click the icon on the object or person that you would like to talk to."
			)
			(3
				(theTalkIcon setCel: 1)
				(= seconds 2)
			)
			(4
				(theTalkIcon setCel: 0 stopUpd:)
				(ourCursor setCel: 3)
				(= cycles 2)
			)
			(5
				(theWalkIcon hide:)
				(theHandIcon hide:)
				(theLookIcon hide:)
				(theTalkIcon hide:)
				(theCurInvIcon hide:)
				(theCurInvIconMask hide:)
				(theInvIcon hide:)
				(theControlIcon hide:)
				(= cycles 2)
			)
			(6
				(gMessager say: 0 0 3 2 self) ; "Um.... There's actually no one here right now, so let's try talking to the ocean."
			)
			(7
				(ourCursor setMotion: MoveTo 79 162 self)
			)
			(8
				(gMessager say: 0 0 3 3 self) ; "The currents continue to murmur, but they do not reply to Alexander."
			)
			(9
				(gMessager say: 0 0 3 4 self) ; "You get the idea. Just over that hill behind me, you'll meet some people you can talk to. Try the TALK icon on them. It's a good idea to use the TALK icon frequently. The other characters in the game usually know more about what's going on than I do, and they can give you lots of important information."
			)
			(10
				(ourCursor setMotion: MoveTo 202 23 self)
			)
			(11
				(theWalkIcon show: stopUpd:)
				(theHandIcon show: stopUpd:)
				(theLookIcon show: stopUpd:)
				(theTalkIcon show: stopUpd:)
				(theCurInvIcon show: stopUpd:)
				(theCurInvIconMask show: stopUpd:)
				(theInvIcon show: stopUpd:)
				(theControlIcon show: stopUpd:)
				(ourCursor setCel: 7)
				(= cycles 2)
			)
			(12
				(gMessager say: 0 0 3 5 self) ; "The window next to TALK shows the CURRENT inventory icon. Right now, the window is empty--but we'll fix that by going into inventory."
			)
			(13
				(client setScript: inventoryScript)
			)
		)
	)
)

(instance inventoryScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ourCursor setMotion: MoveTo 253 23 self)
			)
			(1
				(gMessager say: 0 0 2 1 self) ; "Your INVENTORY is the group of objects--such as the ring--that you collect during the game. Click on the INVENTORY button on your icon bar to bring up the INVENTORY WINDOW. The inventory window shows you all the items you have. Right now, all we have is a ring."
			)
			(2
				(theInvIcon setCel: 1)
				(= seconds 2)
			)
			(3
				(theInvIcon setCel: 0)
				(= cycles 15)
			)
			(4
				(theWalkIcon hide:)
				(theHandIcon hide:)
				(theLookIcon hide:)
				(theTalkIcon hide:)
				(theCurInvIcon hide:)
				(theCurInvIconMask hide:)
				(theInvIcon hide:)
				(theControlIcon hide:)
				(= cycles 2)
			)
			(5
				(theInvWindow init: setPri: 15 stopUpd: addToPic:)
				(invEye init: stopUpd:)
				(invHand init: stopUpd:)
				(invArrow init: stopUpd:)
				(invTalk init: stopUpd:)
				(invMore init: stopUpd:)
				(invOk init: stopUpd:)
				(= local1 1)
				(= local0 1)
				(= cycles 2)
			)
			(6
				(gMessager say: 0 0 2 2 self) ; "Look! More icons! These are really similar to the icons on the icon bar, except these icons operate on the items in your inventory window. For example, the LOOK icon here is for looking at an inventory item. Let's LOOK at the ring."
			)
			(7
				(ourCursor setMotion: MoveTo 86 119 self)
			)
			(8
				(invEye setCel: 1)
				(= seconds 2)
			)
			(9
				(invEye setCel: 0 stopUpd:)
				(ourCursor cel: 1 setMotion: MoveTo 89 76 self)
			)
			(10
				(= seconds 2)
			)
			(11
				(gMessager say: 0 0 2 3 self) ; "Alexander's ring is made of the purest gold and has the insignia of the royal family of Daventry on its face."
			)
			(12
				(ourCursor setMotion: MoveTo 117 119 self)
			)
			(13
				(gMessager say: 0 0 2 4 self) ; "The HAND icon is for manipulating an object in your inventory window.  Try this with everything new you get. HAND does different things, depending on the item; it can let you read something, eat something, open something, and so on. Sometimes there's even an item hidden INSIDE another item, and the only way to find it is with HAND."
			)
			(14
				(gMessager say: 0 0 2 5 self) ; "Of course, sometimes HAND on an item just gets a little more descriptive detail or says that you can't DO anything with the item at all. Let's try HAND on the ring."
			)
			(15
				(invHand setCel: 1)
				(= seconds 2)
			)
			(16
				(invHand setCel: 0 stopUpd:)
				(ourCursor cel: 2 setMotion: MoveTo 89 76 self)
			)
			(17
				(gMessager say: 0 0 2 6 self) ; "Alexander is already wearing his ring."
			)
			(18
				(ourCursor setMotion: MoveTo 174 119 self)
			)
			(19
				(= seconds 2)
			)
			(20
				(gMessager say: 0 0 2 7 self) ; "The TALK icon lets you try to talk to an inventory item. Although most inventory items will have nothing to say, a few can get downright wordy! Let's try TALKing to the ring."
			)
			(21
				(invTalk setCel: 1)
				(= seconds 2)
			)
			(22
				(invTalk setCel: 0 stopUpd:)
				(ourCursor cel: 3 setMotion: MoveTo 89 76 self)
			)
			(23
				(gMessager say: 0 0 2 8 self) ; "Reminiscing of home is fine, but the ring is not a very good listener."
			)
			(24
				(ourCursor setCel: 7 setMotion: MoveTo 203 119 self)
			)
			(25
				(= seconds 2)
			)
			(26
				(gMessager say: 0 0 2 9 self) ; "The MORE button becomes useful later in the game, when you have many items in inventory. If there is more than one page of inventory, clicking on the MORE button will work on either page to flip between the pages."
			)
			(27
				(gMessager say: 0 0 2 10 self) ; "When there's not another page of inventory, you'll see this message:"
			)
			(28
				(invMore setCel: 1)
				(= seconds 2)
			)
			(29
				(invMore setCel: 0 stopUpd:)
				(= cycles 2)
			)
			(30
				(gMessager say: 0 0 2 11 self) ; "This is the only page of inventory."
			)
			(31
				(ourCursor setMotion: MoveTo 146 119 self)
			)
			(32
				(= seconds 2)
			)
			(33
				(gMessager say: 0 0 2 12 self) ; "Finally, the ARROW icon lets you select an item to be your CURRENT inventory icon. That item's icon will then appear on the icon bar in the CURRENT inventory icon window and be one of your active cursors when you cycle cursors. Click on the ARROW, then on the item. Your cursor will now become the selected item."
			)
			(34
				(invArrow setCel: 1)
				(= seconds 2)
			)
			(35
				(invArrow setCel: 0 stopUpd:)
				(ourCursor cel: 7 setMotion: MoveTo 89 76 self)
			)
			(36
				(ourCursor view: 990 setLoop: 2 cel: 14)
				(= seconds 2)
			)
			(37
				(gMessager say: 0 0 2 13 self) ; "Once you have an item's cursor, you can also try to use that item on another inventory item in the inventory window. For example, you might have a KEY and want to use that KEY on another inventory item such as a LOCKED BOX. To do that, you would use the arrow to select the KEY, then click that KEY icon on the BOX in the inventory window."
			)
			(38
				(gMessager say: 0 0 2 14 self) ; "We only have one item right now, but be sure to try this out once you've picked up a few objects in the game."
			)
			(39
				(ourCursor setMotion: MoveTo 232 119 self)
			)
			(40
				(gMessager say: 0 0 2 15 self) ; "Once you've selected an icon to be current (or even if you haven't), you can just click on the OK button to erase the inventory window and return you to the game."
			)
			(41
				(invOk setCel: 1)
				(= seconds 2)
			)
			(42
				(theInvWindow dispose:)
				(invEye dispose:)
				(invHand dispose:)
				(invArrow dispose:)
				(invTalk dispose:)
				(invMore dispose:)
				(invOk dispose:)
				(= local1 0)
				(= local0 0)
				(= cycles 2)
			)
			(43
				(DrawPic (gCurRoom picture:) 9)
				(ourCursor setMotion: MoveTo 202 23 self)
			)
			(44
				(theCurInvIconMask
					view: 990
					setLoop: 2
					ignoreActors: 1
					illegalBits: 0
					ignoreHorizon: 1
					cel: 14
					posn: 199 9
					show:
					stopUpd:
				)
				(theWalkIcon show: stopUpd:)
				(theHandIcon show: stopUpd:)
				(theLookIcon show: stopUpd:)
				(theTalkIcon show: stopUpd:)
				(theCurInvIcon show: stopUpd:)
				(theInvIcon show: stopUpd:)
				(theControlIcon show: stopUpd:)
				(ourCursor view: 998 setLoop: 1 setCel: 7)
				(= cycles 2)
			)
			(45
				(gMessager say: 0 0 2 16 self) ; "See? The ring is now in the CURRENT inventory icon window and is also the cursor. The RING icon or cursor looks like a ring. Every inventory item in the game has its own icon that looks like that item."
			)
			(46
				(gMessager say: 0 0 2 17 self) ; "Inventory objects are used to solve puzzles in the game. To use an item, click the item's icon on an object on the screen. That means; try to use the item on the object."
			)
			(47
				(gMessager say: 0 0 2 18 self) ; "For example, we can try to throw the ring in the sea by clicking RING on the ocean on the screen."
			)
			(48
				(theWalkIcon hide:)
				(theHandIcon hide:)
				(theLookIcon hide:)
				(theTalkIcon hide:)
				(theCurInvIcon hide:)
				(theCurInvIconMask hide:)
				(theInvIcon hide:)
				(theControlIcon hide:)
				(ourCursor
					view: 990
					setLoop: 2
					cel: 14
					setMotion: MoveTo 79 162 self
				)
			)
			(49
				(= seconds 2)
			)
			(50
				(gMessager say: 0 0 2 19 self) ; "Alexander doesn't want to throw his royal ring in the sea! It has great sentimental value to him!"
			)
			(51
				(gMessager say: 0 0 2 20 self) ; "It's a good idea to always try any inventory item you get on me, Alexander. If I had a guitar, for example, you could click the GUITAR icon on me, and I would then play the guitar. Let's try it with the ring."
			)
			(52
				(ourCursor setMotion: MoveTo 168 90 self)
			)
			(53
				(gMessager say: 0 0 2 21 self) ; "Alexander is already wearing his royal insignia ring."
			)
			(54
				(gMessager say: 0 0 2 22 self) ; "Other examples of puzzles that might involve clicking an inventory item on an object on the screen include: using a KEY on a locked door on the screen, using MONEY on a greedy guard who might be bribed, or using a SHOVEL to dig in a garden."
			)
			(55
				(gMessager say: 0 0 2 23 self) ; "Before we move on to SYSTEMS, here's something you'll find at times in the game; sometimes during certain scenes or while certain insets are up, you might notice that part or all of your icon bar is disabled."
			)
			(56
				(ourCursor setMotion: MoveTo 23 23 self)
			)
			(57
				(theWalkIcon setCel: 2 show: stopUpd:)
				(theHandIcon setCel: 2 show: stopUpd:)
				(theLookIcon show: stopUpd:)
				(theTalkIcon show: stopUpd:)
				(theCurInvIcon show: stopUpd:)
				(theCurInvIconMask
					view: 980
					setLoop: 4
					setCel: 1
					posn: 176 7
					show:
					stopUpd:
				)
				(theInvIcon show: stopUpd:)
				(theControlIcon show: stopUpd:)
				(ourCursor view: 998 setLoop: 1 setCel: 7)
				(= cycles 2)
			)
			(58
				(gMessager say: 0 0 2 24 self) ; "Look at your icon bar. If there is no color outline around a particular icon, it is disabled and you may not select that icon at the current point in the game. For example, right now WALK and HAND are disabled. Disabled icons will become available to you again after you finish with the current scene or inset."
			)
			(59
				(client setScript: controlPanelScript)
			)
		)
	)
)

(instance controlPanelScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ourCursor setMotion: MoveTo 297 23 self)
			)
			(1
				(theWalkIcon show: stopUpd:)
				(theHandIcon show: stopUpd:)
				(theLookIcon show: stopUpd:)
				(theTalkIcon show: stopUpd:)
				(theCurInvIcon show: stopUpd:)
				(theCurInvIconMask show: stopUpd:)
				(theInvIcon show: stopUpd:)
				(theControlIcon show: stopUpd:)
				(ourCursor setCel: 7)
				(= cycles 2)
			)
			(2
				(gMessager say: 0 0 1 1 self) ; "The last button on your icon bar is the SYSTEMS button. Clicking on the SYSTEMS button will bring up the game's control panel."
			)
			(3
				(theControlIcon setCel: 1)
				(= seconds 2)
			)
			(4
				(theControlIcon setCel: 0)
				(= seconds 2)
			)
			(5
				(theWalkIcon hide:)
				(theHandIcon hide:)
				(theLookIcon hide:)
				(theTalkIcon hide:)
				(theCurInvIcon hide:)
				(theCurInvIconMask hide:)
				(theInvIcon hide:)
				(theControlIcon hide:)
				(= cycles 2)
			)
			(6
				(= local1 1)
				(theControlPanel init: stopUpd:)
				(saveBut init: stopUpd:)
				(restoreBut init: stopUpd:)
				(restartBut init: stopUpd:)
				(quitBut init: stopUpd:)
				(aboutBut init: stopUpd:)
				(modeBut init: stopUpd:)
				(playBut init: stopUpd:)
				(= cycles 2)
			)
			(7
				(gMessager say: 0 0 1 2 self) ; "This is the control panel. From here you may select game options. You can SAVE, RESTORE, RESTART, QUIT, see game information under ABOUT, and PLAY. There are also three sliders: DETAIL, VOLUME, and SPEED. You can also see your current score."
			)
			(8
				(ourCursor setMotion: MoveTo 100 48 self)
			)
			(9
				(gMessager say: 0 0 1 3 self) ; "The SAVE button is for saving the current state of your game. This lets you try something dangerous and have a way to get back to where you were before you tried it. SAVE OFTEN, whenever you make progress in the game. That way, if I should happen to...uh...get in trouble, you can avoid extra time by just restoring."
			)
			(10
				(saveBut setCel: 1)
				(= seconds 2)
			)
			(11
				(saveBut setCel: 0 stopUpd:)
				(ourCursor setMotion: MoveTo 100 68 self)
			)
			(12
				(gMessager say: 0 0 1 4 self) ; "The RESTORE button is for restoring. You may restore any one of the games that you saved. If there was a sequence that you particularly enjoyed, you may view it again and again."
			)
			(13
				(restoreBut setCel: 1)
				(= seconds 2)
			)
			(14
				(restoreBut setCel: 0 stopUpd:)
				(ourCursor setMotion: MoveTo 100 88 self)
			)
			(15
				(gMessager say: 0 0 1 5 self) ; "The RESTART button will take you all the way back to the beginning of the game so you can play a new game from scratch. Remember that if you restart, the current state of the game is lost. It would probably be a good idea to save before you restart."
			)
			(16
				(restartBut setCel: 1)
				(= seconds 2)
			)
			(17
				(restartBut setCel: 0 stopUpd:)
				(ourCursor setMotion: MoveTo 100 108 self)
			)
			(18
				(gMessager say: 0 0 1 6 self) ; "The QUIT button is for leaving the game entirely and returning to your operating system."
			)
			(19
				(quitBut setCel: 1)
				(= seconds 2)
			)
			(20
				(= local0 1)
				(quitBut setCel: 0 stopUpd:)
				(ourCursor setMotion: MoveTo 100 128 self)
			)
			(21
				(gMessager say: 0 0 1 7 self) ; "The ABOUT button is an information and help button. It will give you information about this game and the King's Quest series. There's also a beginner's walk-thru and a tips section available through the ABOUT button. Look at one or both if you're having problems figuring out what to do."
			)
			(22
				(aboutBut setCel: 1)
				(= seconds 2)
			)
			(23
				(aboutBut setCel: 0 stopUpd:)
				(ourCursor setMotion: MoveTo 100 148 self)
			)
			(24
				(gMessager say: 0 0 1 8 self) ; "The PLAY button is to leave the control panel and return to the game."
			)
			(25
				(playBut setCel: 1)
				(= seconds 2)
			)
			(26
				(playBut setCel: 0 stopUpd:)
				(ourCursor setMotion: MoveTo 187 150 self)
			)
			(27
				(if (& gMsgType $0002)
					(= seconds 2)
				else
					(KQ6Print
						posn: 10 10
						width: 290
						addText:
							{The MODE button lets you switch from speech to text during play.}
						init: self
					)
				)
			)
			(28
				(modeBut setCel: 1)
				(= seconds 2)
			)
			(29
				(modeBut setLoop: 9 setCel: 0)
				(= seconds 2)
			)
			(30
				(modeBut setCel: 1)
				(= seconds 1)
			)
			(31
				(modeBut setLoop: 8 setCel: 0 stopUpd:)
				(ourCursor setMotion: MoveTo 147 116 self)
			)
			(32
				(gMessager say: 0 0 1 9 self) ; "The DETAIL slider is to adjust the amount of detail in the game. If you feel that the game is running too slow, you may turn this down. Superfluous animation will stop. This is a help on slower machines."
			)
			(33
				(ourCursor setMotion: MoveTo 187 116 self)
			)
			(34
				(gMessager say: 0 0 1 10 self) ; "The VOLUME slider is to adjust the volume in the game. This is only applicable for certain sound cards. This will not work on the PC internal speaker."
			)
			(35
				(ourCursor setMotion: MoveTo 227 116 self)
			)
			(36
				(gMessager say: 0 0 1 11 self) ; "The SPEED slider will adjust my speed. It will not affect any other animation in the game."
			)
			(37
				(theControlPanel dispose:)
				(saveBut dispose:)
				(restoreBut dispose:)
				(restartBut dispose:)
				(quitBut dispose:)
				(aboutBut dispose:)
				(modeBut dispose:)
				(playBut dispose:)
				(= cycles 2)
			)
			(38
				(= local1 0)
				(client setScript: doneScript)
			)
		)
	)
)

(instance doneScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 0 4 1 self) ; "There's just two more important things about the interface that will help your gameplay. First, when you have a close-up inset of something (such as a box) on the screen, click OUTSIDE the inset to exit or clear the inset."
			)
			(1
				(gMessager say: 0 0 4 2 self) ; "Second, during long dialogues, clicking the right button will skip messages and speed through the scene. BE CAREFUL with that right button, though! You don't want to clear any messages you haven't yet read or you will most likely miss important clues!"
			)
			(2
				(gMessager say: 0 0 4 3 self) ; "Well, that's the game interface. If you have a hard time getting started, you might want to look at the 'Beginner's Walk-Thru,' available through the ABOUT button. Also make sure you check out the 'Tips on playing King's Quest VI' section under the ABOUT button for strategy tips on mastering the game."
			)
			(3
				(gMessager say: 0 0 4 4 self) ; "There is much to be done before you and I accomplish our mission. Have fun and remember--take your time and really explore. There are a lot of details in this game. Take the time to look around and savor everything. GOOD LUCK!"
			)
			(4
				(ourCursor hide:)
				(= seconds 2)
			)
			(5
				(restartCode doit: 1)
			)
		)
	)
)

(instance objectGlitter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 10))
			)
			(1
				(= state -1)
				(client cel: 0 setCycle: End self)
			)
		)
	)
)

(instance takeRingScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (!= (gEgo loop:) 1)
					(gEgo setHeading: 315 self)
				else
					(self cue:)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo
					normal: 0
					setSpeed: 6
					view: 201
					loop: 4
					cel: 0
					setScale: 0
					setCycle: End self
				)
				(royalRing dispose:)
			)
			(3
				(gEgo
					posn: (royalRing approachX:) (royalRing approachY:)
					reset: 7
					setScale: Scaler 100 50 112 57
					get: 39 ; royalRing
				)
				(= cycles 2)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ourCursor of Actor
	(properties
		x 120
		y 120
		view 998
		cycleSpeed 0
		moveSpeed 0
	)

	(method (init)
		(self setLoop: 1 setPri: 15)
		(super init: &rest)
	)
)

(instance theWalkIcon of Actor
	(properties
		x 4
		y 7
		view 980
		priority 14
		signal 4112
	)
)

(instance theHandIcon of Actor
	(properties
		x 47
		y 7
		view 980
		loop 1
		priority 14
		signal 4112
	)
)

(instance theLookIcon of Actor
	(properties
		x 90
		y 7
		view 980
		loop 2
		priority 14
		signal 4112
	)
)

(instance theTalkIcon of Actor
	(properties
		x 133
		y 7
		view 980
		loop 3
		priority 14
		signal 4112
	)
)

(instance theCurInvIcon of Actor
	(properties
		x 176
		y 7
		view 980
		loop 4
		priority 14
		signal 4112
	)
)

(instance theCurInvIconMask of Actor
	(properties
		x 176
		y 7
		view 980
		loop 4
		cel 1
		priority 14
		signal 4112
	)
)

(instance theInvIcon of Actor
	(properties
		x 238
		y 7
		view 980
		loop 5
		priority 14
		signal 4112
	)
)

(instance theControlIcon of Actor
	(properties
		x 281
		y 7
		view 980
		loop 6
		priority 14
		signal 4112
	)
)

(instance royalRing of Prop
	(properties
		x 104
		y 134
		sightAngle 45
		approachX 134
		approachY 136
		view 202
		loop 2
	)

	(method (init)
		(self cel: 0 setCycle: End setScript: (Clone objectGlitter))
		(super init: &rest)
	)
)

(instance theControlPanel of Actor
	(properties
		x 58
		y 20
		view 1205
		priority 15
		signal 16
	)

	(method (init)
		(super init: &rest)
		(self addToPic:)
	)

	(method (dispose)
		(super dispose: &rest)
		(DrawPic (gCurRoom picture:))
	)
)

(instance saveBut of Actor
	(properties
		x 76
		y 36
		view 947
		loop 2
		priority 15
		signal 16
	)
)

(instance restoreBut of Actor
	(properties
		x 76
		y 56
		view 947
		loop 3
		priority 15
		signal 16
	)
)

(instance restartBut of Actor
	(properties
		x 76
		y 76
		view 947
		loop 4
		priority 15
		signal 16
	)
)

(instance quitBut of Actor
	(properties
		x 76
		y 96
		view 947
		loop 5
		priority 15
		signal 16
	)
)

(instance aboutBut of Actor
	(properties
		x 76
		y 116
		view 947
		loop 6
		priority 15
		signal 16
	)
)

(instance modeBut of Actor
	(properties
		x 161
		y 136
		view 947
		loop 8
		priority 15
		signal 16
	)
)

(instance playBut of Actor
	(properties
		x 76
		y 136
		view 947
		loop 7
		priority 15
		signal 16
	)
)

(instance theInvWindow of Actor
	(properties
		x 63
		y 63
		view 1205
		loop 2
		priority 15
	)
)

(instance invEye of Actor
	(properties
		x 86
		y 121
		view 901
		loop 2
		priority 15
		signal 16
	)
)

(instance invHand of Actor
	(properties
		x 116
		y 121
		view 901
		priority 15
		signal 16
	)
)

(instance invArrow of Actor
	(properties
		x 145
		y 121
		view 901
		loop 4
		priority 15
		signal 16
	)
)

(instance invTalk of Actor
	(properties
		x 174
		y 121
		view 901
		loop 5
		priority 15
		signal 16
	)
)

(instance invMore of Actor
	(properties
		x 203
		y 121
		view 901
		loop 6
		priority 15
		signal 16
	)
)

(instance invOk of Actor
	(properties
		x 232
		y 121
		view 901
		loop 3
		priority 15
		signal 16
	)
)

(instance Alex_Demo of Kq6Talker
	(properties
		name {Alex Demo}
		view 1205
		loop 1
		disposeWhenDone 1
	)

	(method (init)
		(if local1
			(if local0
				(self
					cel: 1
					x: 167
					y: 75
					talkWidth: 290
					textX: -158
					textY: -65
					keepWindow: 0
				)
			else
				(self
					cel: 1
					x: 167
					y: 75
					talkWidth: 290
					textX: -158
					textY: 45
					keepWindow: 0
				)
			)
			(super init: 0 0 0 &rest)
		else
			(self
				cel: 1
				x: 167
				y: 75
				talkWidth: 290
				textX: -158
				textY: 32
				keepWindow: 0
			)
			(super init: 0 0 tMouthA &rest)
		)
	)
)

(instance tMouthA of Prop
	(properties
		view 1205
		loop 1
	)
)

