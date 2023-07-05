;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use Teller)
(use n814)
(use Print)
(use Talker)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm31 0
	erasmus 1
	fenrus 2
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
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	[local21 10]
	[local31 7] = [0 11 12 -16 -5 -17 999]
	[local38 6] = [0 28 -4 -10 -6 999]
	[local44 5] = [0 20 27 19 999]
	[local49 6] = [0 21 13 -26 9 999]
	[local55 3] = [0 -23 999]
	[local58 3] = [0 -8 999]
	[local61 4] = [0 15 24 999]
	[local65 4] = [0 14 25 999]
	[local69 3] = [0 22 999]
	[local72 3] = [0 -7 999]
	[local75 3] = [0 18 999]
	[local78 15]
	[local93 12] = [0 -16 -5 -17 -10 -4 -6 -26 -23 -8 -7 999]
	[local105 4] = [0 12 11 999]
	[local109 6]
	[local115 2] = [0 999]
)

(instance rm31 of Rm
	(properties
		picture 31
		style 4
	)

	(method (dispose)
		(SetFlag 21)
		(gWalkHandler delete: self)
		(= gUseSortedFeatures local16)
		(super dispose:)
	)

	(method (init)
		(= [local78 0] @local31)
		(= [local78 1] @local38)
		(= [local78 2] @local44)
		(= [local78 3] @local49)
		(= [local78 4] @local55)
		(= [local78 5] @local58)
		(= [local78 6] @local61)
		(= [local78 7] @local65)
		(= [local78 8] @local69)
		(= [local78 9] @local72)
		(= [local78 10] @local75)
		(= [local78 11] 999)
		(= [local109 0] @local105)
		(= [local109 1] 999)
		(gWalkHandler add: self)
		(LoadMany rsVIEW 31 199 530 1034 1031)
		(LoadMany rsSOUND 2028 36)
		(Load rsMESSAGE 31)
		(= local5 (Random 50 100))
		(= local6 100)
		(= local7 (Random 0 7))
		(= local13 1)
		(= local14 1)
		(SL enable:)
		(super init: &rest)
		(= local16 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(NormalEgo)
		(if (== gPrevRoomNum 32) ; wizGame
			(door loop: 6 cel: 4 init:)
		else
			(door init:)
		)
		(egoHead init: posn: 500 500 hide:)
		(pillars init: setOnMeCheck: 1 2)
		(curtain init: setOnMeCheck: 1 4)
		(table init: setOnMeCheck: 1 8)
		(stairs init: setOnMeCheck: 1 16)
		(wWindow init: setOnMeCheck: 1 32)
		(fenrusPad init: setOnMeCheck: 1 64)
		(gStone init: setOnMeCheck: 1 128)
		(pStone init: setOnMeCheck: 1 256)
		(walls init: setOnMeCheck: 1 512)
		(wizLegs addToPic:)
		(wizChair addToPic:)
		(egoChair addToPic:)
		(cup init:)
		(erasmusTeller init: wizard @local31 @local78 @local93)
		(wizard init: setPri: 15 actions: erasmusTeller)
		(gTheIconBar disable: 5 7 8)
		(if (== gPrevRoomNum 32) ; wizGame
			(fenrusTeller init: fenrusBody @local105 @local109 @local115)
			(fenrusBody init: setCel: 8 setPri: 15 actions: fenrusTeller)
			(self setScript: gameOver)
		else
			(gEgo init: actions: egoActions)
			(cheese init:)
			(gLongSong number: 117 loop: -1 init: play:)
			(self setScript: intoTheTower)
		)
	)

	(method (doit)
		(if (not (IsFlag 360))
			(if (== local15 1)
				(Palette palANIMATE 232 246 -1)
				(Palette palANIMATE 247 254 -1)
			)
			(if local0
				(= local0 0)
				(= local14 0)
				(= local13 0)
				(gTheIconBar disable: 1 4 2 3 6)
				(self setScript: teleportOut)
			)
			(cond
				((gCurRoom script:))
				((and local13 (> local6 1))
					(-- local6)
				)
				((== local6 1)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(HandsOff)
					(= local13 0)
					(= local14 0)
					(if (== local7 7)
						(= local7 0)
					else
						(++ local7)
					)
					(switch local7
						(0
							(= local18 4)
							(= local19 31)
						)
						(1
							(= local18 3)
							(= local19 32)
						)
						(2
							(= local18 3)
							(= local19 33)
						)
						(3
							(= local18 3)
							(= local19 34)
						)
						(4
							(= local18 4)
							(= local19 35)
						)
						(5
							(= local18 2)
							(= local19 36)
						)
						(6
							(= local18 5)
							(= local19 37)
						)
						(7
							(= local18 3)
							(= local19 38)
						)
					)
					(self setScript: tellJoke)
				)
			)
			(cond
				((gCurRoom script:))
				((and local14 (> local5 1))
					(-- local5)
				)
				((== local5 1)
					(= local5 (Random 450 750))
					(= local13 0)
					(wizard setScript: drinkTea)
				)
			)
			(super doit:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gTheIconBar disable: 1 4 2 3 6)
				(= local1 5)
				(gCurRoom setScript: teleportOut)
			)
			(52 ; Sleep
				(gTheIconBar disable: 1 4 2 3 6)
				(= local1 6)
				(= local13 0)
				(gCurRoom setScript: teleportOut)
			)
			(51 ; openSpell
				(gTheIconBar disable: 1 4 2 3 6)
				(= local1 4)
				(= local13 0)
				(gCurRoom setScript: teleportOut)
			)
			(50 ; detectMagicSpell
				(gTheIconBar disable: 1 4 2 3 6)
				(= local1 4)
				(= local13 0)
				(gCurRoom setScript: teleportOut)
			)
			(79 ; zapSpell
				(gTheIconBar disable: 1 4 2 3 6)
				(= local1 4)
				(= local13 0)
				(gCurRoom setScript: teleportOut)
			)
			(77 ; triggerSpell or Pickup Inventory
				(gTheIconBar disable: 1 4 2 3 6)
				(= local1 4)
				(= local13 0)
				(gCurRoom setScript: teleportOut)
			)
			(78 ; dazzleSpell
				(gTheIconBar disable: 1 4 2 3 6)
				(= local1 4)
				(= local13 0)
				(gCurRoom setScript: teleportOut)
			)
			(80 ; calmSpell
				(gTheIconBar disable: 1 4 2 3 6)
				(= local1 4)
				(= local13 0)
				(gCurRoom setScript: teleportOut)
			)
			(82 ; fetchSpell
				(gTheIconBar disable: 1 4 2 3 6)
				(= local1 4)
				(= local13 0)
				(gCurRoom setScript: teleportOut)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wizard of Actor
	(properties
		x 67
		y 108
		noun 4
		view 31
		loop 1
		cycleSpeed 1
	)
)

(instance erasmusTeller of Teller
	(properties)

	(method (showDialog)
		(super showDialog: -17 (IsFlag 353))
	)

	(method (doChild)
		(if (== query -17)
			(super doChild: query)
			(return query)
		else
			(super doChild: query)
			(return query)
		)
	)

	(method (doVerb theVerb invItem)
		(egoHead setCel: 0)
		(switch theVerb
			(2 ; Talk
				(= local14 0)
				(= local13 0)
				(+= local6 5)
				(SolvePuzzle 659 1)
				(if local4
					(if local10
						(gMessager say: 10 0 39 1) ; "It would be polite to wait until Erasmus puts down his cup of tea before asking any more questions."
					else
						(gMessager say: 10 0 39 2) ; "It would be best to wait until Erasmus puts down his cup of tea before asking any questions."
					)
				else
					(super doVerb: theVerb &rest)
					(= local14 1)
					(= local13 1)
				)
			)
			(4 ; Do
				(gTheIconBar disable: 1 4 2 3 6)
				(= local1 3)
				(= local13 0)
				(gCurRoom setScript: teleportOut)
			)
			(81 ; flameDartSpell
				(gTheIconBar disable: 1 4 2 3 6)
				(= local1 4)
				(= local13 0)
				(gCurRoom setScript: teleportOut)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wizLegs of View
	(properties
		x 69
		y 128
		view 31
		loop 2
		priority 8
		signal 16400
	)

	(method (doVerb)
		(wizard doVerb: &rest)
	)
)

(instance wizChair of View
	(properties
		x 60
		y 120
		view 31
		cel 3
		priority 8
		signal 16400
	)
)

(instance egoChair of View
	(properties
		x 161
		y 116
		view 31
		cel 2
		priority 5
		signal 16400
	)
)

(instance cheese of Actor
	(properties
		x 128
		y 116
		noun 1
		view 31
	)
)

(instance egoHead of Actor
	(properties
		x 161
		y 87
		view 31
		loop 4
	)
)

(instance cup of View
	(properties
		x 78
		y 103
		noun 2
		view 31
		cel 1
		priority 8
		signal 16400
	)

	(method (doVerb)
		(if local3
			(gMessager say: 2 1 0 1) ; "The tea in the cup sitting on the table seems to refill itself as the wizard drinks."
		else
			(gMessager say: 2 1 0 2) ; "The tea in the cup has a strange aroma."
		)
	)
)

(instance erasmus of Talker
	(properties
		x 10
		y 10
		view 1034
		talkWidth 180
		textX 21
		textY 110
	)

	(method (init)
		(= font gUserFont)
		(super init: wizBust wizEyes wizMouth &rest)
	)

	(method (doit)
		(egoHead setCel: 0)
		(super doit:)
	)
)

(instance wizBust of Prop
	(properties
		view 1034
	)
)

(instance wizMouth of Prop
	(properties
		nsTop 53
		nsLeft 54
		view 1034
		loop 1
	)
)

(instance wizEyes of Prop
	(properties
		nsTop 41
		nsLeft 52
		view 1034
		loop 2
	)
)

(instance fenrus of Talker
	(properties
		x 190
		y 10
		view 1031
		talkWidth 210
		textX -120
		textY 110
	)

	(method (init)
		(= font gUserFont)
		(super init: fenrusBust fenrusEyes fenrusMouth &rest)
	)

	(method (doit)
		(egoHead setCel: 1)
		(super doit:)
	)
)

(instance fenrusBust of Prop
	(properties
		view 1031
	)
)

(instance fenrusMouth of Prop
	(properties
		nsTop 63
		nsLeft 7
		view 1031
		loop 1
	)
)

(instance fenrusEyes of Prop
	(properties
		nsTop 44
		nsLeft 11
		view 1031
		loop 2
	)
)

(instance fenrusBody of Prop
	(properties
		x 115
		y 182
		noun 6
		view 199
	)
)

(instance fenrusTeller of Teller
	(properties)

	(method (doVerb theVerb invItem)
		(egoHead setCel: 1)
		(switch theVerb
			(4 ; Do
				(= local1 3)
				(gTheIconBar disable: 1 4 2 3 6)
				(= local13 0)
				(gCurRoom setScript: teleportOut)
			)
			(51 ; openSpell
				(gTheIconBar disable: 1 4 2 3 6)
				(= local1 4)
				(= local13 0)
				(gCurRoom setScript: teleportOut)
			)
			(50 ; detectMagicSpell
				(gTheIconBar disable: 1 4 2 3 6)
				(= local1 4)
				(= local13 0)
				(gCurRoom setScript: teleportOut)
			)
			(77 ; triggerSpell or Pickup Inventory
				(gTheIconBar disable: 1 4 2 3 6)
				(= local1 4)
				(= local13 0)
				(gCurRoom setScript: teleportOut)
			)
			(78 ; dazzleSpell
				(gTheIconBar disable: 1 4 2 3 6)
				(= local1 4)
				(= local13 0)
				(gCurRoom setScript: teleportOut)
			)
			(80 ; calmSpell
				(gTheIconBar disable: 1 4 2 3 6)
				(= local1 4)
				(= local13 0)
				(gCurRoom setScript: teleportOut)
			)
			(81 ; flameDartSpell
				(gTheIconBar disable: 1 4 2 3 6)
				(= local1 4)
				(= local13 0)
				(gCurRoom setScript: teleportOut)
			)
			(82 ; fetchSpell
				(gTheIconBar disable: 1 4 2 3 6)
				(= local1 4)
				(= local13 0)
				(gCurRoom setScript: teleportOut)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Magic of Prop
	(properties
		view 530
		cycleSpeed 2
	)
)

(instance door of Prop
	(properties
		x 131
		view 31
		loop 6
		signal 16384
		cycleSpeed 8
	)

	(method (init)
		(if (== gPrevRoomNum 32) ; wizGame
			(self cel: 5)
			(= local15 1)
		else
			(self cel: 0)
		)
		(super init:)
	)
)

(instance pillars of Feature
	(properties
		noun 8
		nsBottom 189
		nsRight 319
		sightAngle 360
	)
)

(instance curtain of Feature
	(properties
		noun 3
		nsBottom 189
		nsRight 319
		sightAngle 360
	)
)

(instance table of Feature
	(properties
		noun 12
		nsBottom 189
		nsRight 319
		sightAngle 360
	)
)

(instance stairs of Feature
	(properties
		noun 11
		nsBottom 189
		nsRight 319
		sightAngle 360
	)
)

(instance wWindow of Feature
	(properties
		noun 14
		nsBottom 189
		nsRight 319
		sightAngle 360
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if gNight
				(gMessager say: 14 1 40) ; "That's odd. You could have sworn it was nighttime, yet daylight is streaming in through the window. When is this place, anyway?"
			else
				(gMessager say: 14 1) ; "To the east, the peaks of the Wolf's Bane Mountains are clearly visible."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fenrusPad of Feature
	(properties
		noun 5
		nsBottom 189
		nsRight 319
		sightAngle 360
	)
)

(instance gStone of Feature
	(properties
		noun 7
		nsBottom 189
		nsRight 319
		sightAngle 360
	)
)

(instance pStone of Feature
	(properties
		noun 9
		nsBottom 189
		nsRight 319
		sightAngle 360
	)
)

(instance walls of Feature
	(properties
		noun 13
		nsBottom 189
		nsRight 319
		sightAngle 360
	)
)

(instance tellJoke of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local14 0)
				(gMessager say: 10 0 local19 1 self)
			)
			(1
				1
				(repeat
					(switch
						(Print
							addButton: 0 10 0 0 2 0 19 31 ; "No."
							addButton: 1 10 0 0 1 0 0 31 ; "Yes."
							ticks: -1
							init:
						)
						(0
							(self changeState: 3)
							(break)
						)
						(1
							(self changeState: 2)
							(break)
						)
					)
				)
			)
			(2
				2
				(if (== local18 2)
					(gMessager say: 10 0 local19 2)
				else
					(gMessager say: 10 0 local19 3)
				)
				(if (!= local19 2)
					(++ local8)
				)
				(if (== local8 7)
					(= local1 2)
					(= local0 1)
				)
				(self changeState: 6)
			)
			(3
				3
				(if (== local18 2)
					(gMessager say: 10 0 local19 2)
					(self changeState: 6)
				else
					(gMessager say: 10 0 local19 2 self)
				)
			)
			(4
				4
				(if (== local18 3)
					(self changeState: 6)
				else
					(gMessager say: 10 0 local19 4 self)
				)
			)
			(5
				5
				(if (== local18 4)
					(self cue:)
				else
					(gMessager say: 10 0 local19 5 self)
				)
			)
			(6
				6
				(= local14 1)
				(= local13 1)
				(gTheIconBar enable: 1 2 3 4 6)
				(User canInput: 1)
				(= local6 (Random 300 400))
				(self dispose:)
			)
		)
	)
)

(instance intoTheTower of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local20 ((gTheIconBar curIcon:) cursor:))
				(= cycles 1)
			)
			(1
				(gEgo
					setPri: 8
					setLoop: 7
					posn: 250 208
					setMotion: MoveTo 191 167 self
				)
			)
			(2
				(NormalEgo)
				(gEgo setMotion: MoveTo 177 145 self)
			)
			(3
				(gMessager say: 10 0 30 1 self) ; "Come in and sit down."
			)
			(4
				(gEgo setMotion: MoveTo 179 129 self)
			)
			(5
				(gEgo setPri: 6 setMotion: MoveTo 162 118 self)
			)
			(6
				(gEgo
					view: 31
					setLoop: 5
					setCel: 0
					posn: 162 118
					setCycle: CT 4 1 self
				)
				(egoInChair init:)
			)
			(7
				(gMessager say: 10 0 30 2 self) ; "Fenrus, our guest has arrived."
				(gEgo setCel: 5 signal: (| (gEgo signal:) $0001))
				(egoHead posn: 161 88 show:)
			)
			(8
				(fenrusTeller init: fenrusBody @local105 @local109 @local115)
				(fenrusBody
					init:
					setPri: 15
					setCycle: CT 4 1 self
					actions: fenrusTeller
				)
			)
			(9
				(fenrusSound play:)
				(fenrusBody setCycle: End self)
			)
			(10
				(fenrusBody setLoop: 1 cel: 0 setCycle: End self)
			)
			(11
				(gMessager say: 10 0 30 3 self) ; "Cheese, please!"
			)
			(12
				(cheese
					setLoop: 0
					setMotion: MoveTo (fenrusBody x:) (- (fenrusBody y:) 5) self
				)
			)
			(13
				(cheese dispose:)
				(fenrusBody setLoop: 5 setCel: 0 setCycle: End self)
			)
			(14
				(fenrusBody setCycle: Beg self)
			)
			(15
				(= local17 (Random 10 15))
				(fenrusBody setLoop: 1 setCel: 0 setCycle: End)
				(= seconds 3)
			)
			(16
				(gMessager say: 10 0 30 4 self) ; "Ahh!"
			)
			(17
				(if (>= [gEgoStats 12] 10) ; magic
					(self cue:)
				else
					(gTheIconBar enable: 1 2 3 4 6)
					(User canInput: 1)
					(= local13 1)
					(= local14 1)
					(client setScript: 0)
				)
			)
			(18
				(gGame setCursor: local20)
				(= local11 0)
				(if (IsFlag 266)
					(client setScript: intoMaze)
				else
					(client setScript: askSpell)
				)
			)
		)
	)
)

(instance intoMaze of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 266)
					(gMessager say: 4 0 2 12 self) ; "Nice to see you back. Shall we play a game of Mage's Maze?"
				else
					(gMessager say: 4 0 2 11 self) ; "Ready to play Mage's Maze?"
				)
			)
			(1
				(repeat
					(switch
						(Print
							addButton: 0 10 0 0 2 0 0 31 ; "No."
							addButton: 1 10 0 0 1 0 19 31 ; "Yes."
							ticks: -1
							init:
						)
						(0
							(self changeState: 2)
							(break)
						)
						(1
							(self changeState: 4)
							(break)
						)
					)
				)
			)
			(2
				(gMessager say: 4 0 2 13 self) ; "Oh, well. It is a good game. Good practice, too. Maybe we can play the next time you visit."
			)
			(3
				(gTheIconBar enable: 1 2 3 4 6)
				(User canInput: 1)
				(= local13 1)
				(= local14 1)
				(self dispose:)
			)
			(4
				(if
					(and
						[gEgoStats 142] ; ???
						[gEgoStats 144] ; ???
						[gEgoStats 148] ; ???
						[gEgoStats 149] ; ???
					)
					(SetFlag 266)
				)
				(client setScript: goGame)
				(self dispose:)
			)
		)
	)
)

(instance askSpell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 353)
				(gMessager say: 4 0 2 (+ 1 (* 2 local11)) self)
			)
			(1
				(repeat
					(switch
						(Print
							addButton: 0 10 0 0 2 0 0 31 ; "No."
							addButton: 1 10 0 0 1 0 19 31 ; "Yes."
							ticks: -1
							init:
						)
						(0
							(self changeState: 2)
							(break)
						)
						(1
							(self changeState: 4)
							(break)
						)
					)
				)
			)
			(2
				(gMessager say: 4 0 2 (+ 2 (* 2 local11)) self)
			)
			(3
				(gTheIconBar enable: 1 2 3 4 6)
				(User canInput: 1)
				(= local13 1)
				(= local14 1)
				(self dispose:)
			)
			(4
				(if (< local11 3)
					(++ local11)
					(self changeState: 0)
				else
					(self cue:)
				)
			)
			(5
				(gMessager say: 4 0 2 9 self) ; "Wonderful! Then you can play a game of Mage's Maze with me. You do want to play, don't you?"
			)
			(6
				(repeat
					(switch
						(Print
							addButton: 0 10 0 0 2 0 0 31 ; "No."
							addButton: 1 10 0 0 1 0 19 31 ; "Yes."
							ticks: -1
							init:
						)
						(0
							(= register 0)
							(self changeState: 7)
							(break)
						)
						(1
							(= register 1)
							(self changeState: 7)
							(break)
						)
					)
				)
			)
			(7
				(if [gEgoStats 20] ; dazzleSpell
					(self cue:)
				else
					(gMessager say: 4 0 2 10 self) ; "I'll teach you the Dazzle spell if you win."
				)
			)
			(8
				(if register
					(client setScript: goGame)
				else
					(client setScript: intoMaze)
				)
			)
		)
	)
)

(instance gameOver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(doorSound play:)
				(gEgo
					view: 31
					setLoop: 5
					setCel: 5
					setCycle: 0
					posn: 162 118
					setPri: 6
					actions: egoActions
					init:
				)
				(egoHead posn: 161 88 show:)
				(door loop: 6 cel: 4 setCycle: Beg self)
			)
			(2
				(doorSound stop:)
				(door stopUpd:)
				(= local15 0)
				(gMessager say: 10 0 29 1 self) ; "I do so enjoy playing the Mage's Maze."
			)
			(3
				(gEgo signal: (| (gEgo signal:) $0001))
				(= local13 1)
				(= local14 1)
				(gTheIconBar enable: 1 2 3 4 6)
				(User canInput: 1)
				(gGame setCursor: 940)
				(self dispose:)
			)
		)
	)
)

(instance drinkTea of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4 1)
				(= local14 0)
				(wizard cel: 1)
				(cup hide:)
				(= ticks 4)
			)
			(1
				(wizard cycleSpeed: 12 setCycle: End self)
			)
			(2
				(= ticks 120)
			)
			(3
				(wizard setCycle: Beg self)
			)
			(4
				(cup show:)
				(= local4 0)
				(= local14 1)
				(= local13 1)
				(= local3 1)
				(wizard setCel: 0 setScript: 0 stopUpd:)
				(= ticks 1)
			)
		)
	)
)

(instance goGame of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(self cue:)
				(doorSound play:)
			)
			(1
				(= local15 1)
				(door setCycle: End self)
			)
			(2
				(= seconds 5)
			)
			(3
				(doorSound stop:)
				(SetFlag 353)
				(gLongSong fade:)
				(gCurRoom newRoom: 32) ; wizGame
			)
		)
	)
)

(instance teleportOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(= local6 0)
				(= local5 0)
				(wizard setScript: 0)
				(if (> local1 4)
					(= local1 4)
				)
				(= ticks 30)
			)
			(2
				(gMessager say: 4 0 3 local1 self)
			)
			(3
				(wizard setLoop: 3 cel: 0 setCycle: End self)
			)
			(4
				(Magic
					ignoreActors:
					setPri: (+ (gEgo priority:) 1)
					posn: (- (gEgo x:) 2) (gEgo y:)
					init:
					setCycle: CT 5 1 self
				)
			)
			(5
				(gEgo hide:)
				(egoHead hide:)
				(egoInChair dispose:)
				(fenrusSound play:)
				(Magic setCycle: CT 3 -1 self)
			)
			(6
				(Magic setCycle: End self)
			)
			(7
				(SetFlag 142)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 400 -32761)
				(= ticks 12)
			)
			(8
				(gCurRoom newRoom: 28)
			)
		)
	)
)

(instance fenrusSound of Sound
	(properties
		number 2028
	)
)

(instance doorSound of Sound
	(properties
		number 36
	)
)

(instance egoInChair of Feature
	(properties
		x 160
		y 4
		z 100
		nsTop 87
		nsLeft 147
		nsBottom 121
		nsRight 174
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Walk
			(gTheIconBar disable: 1 4 3 6)
			(= local1 5)
			(gCurRoom setScript: teleportOut)
		else
			(egoChair doVerb: theVerb &rest)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(not (== (event message:) JOY_NULL))
				(== (gTheIconBar curIcon:) (gTheIconBar walkIconItem:))
				(& (event type:) $0040) ; direction
			)
			(gTheIconBar disable: 1 4 3 6)
			(= local1 5)
			(gCurRoom setScript: teleportOut)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event)
		)
	)

	(method (init)
		(super init: &rest)
		(gDirectionHandler add: self)
	)

	(method (dispose)
		(gDirectionHandler delete: self)
		(super dispose:)
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Walk
			(gTheIconBar disable: 1 4 2 3 6)
			(= local1 5)
			(gCurRoom setScript: teleportOut)
			(return 1)
		else
			(return 0)
		)
	)
)

