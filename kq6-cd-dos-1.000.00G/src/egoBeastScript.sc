;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 84)
(include sci.sh)
(use Main)
(use Kq6Sound)
(use KQ6Print)
(use n913)
(use Print)
(use Window)
(use Motion)
(use Game)
(use System)

(public
	egoBeastScript 0
)

(instance egoBeastScript of Script
	(properties)

	(method (changeState newState &tmp temp0 [temp1 200])
		(switch (= state newState)
			(0
				(gGame handsOff: killSound: 1)
				(gTheIconBar disable: 5 6)
				(localMusic2 loop: -1 number: 972 play:)
				(gMessager say: 3 0 7 1 self 0) ; "Alexander feels a strange sensation come over him...."
			)
			(1
				(gMessager say: 3 0 7 2 self 0) ; "His skin begins to itch...."
			)
			(2
				(localMusic number: 974 play:)
				(gEgo
					view: 910
					normal: 0
					cycleSpeed: 10
					setLoop: 0
					setCycle: End self
				)
			)
			(3
				(localMusic number: 974 play:)
				(gEgo setCycle: Beg self)
			)
			(4
				(localMusic number: 974 play:)
				(gEgo setCycle: End self)
			)
			(5
				(gMessager say: 3 0 7 3 self 0) ; "His head throbs...."
			)
			(6
				(gMessager say: 3 0 7 4 self 0) ; "(ANIMAL-LIKE) UH-<growl> OH!"
			)
			(7
				(localMusic2 number: 973 loop: 1 play:)
				(gEgo setLoop: 1 setCel: 0 cycleSpeed: 10 setCycle: End self)
			)
			(8
				(SetFlag 59)
				(KQ6Print
					say: 0 3 0 7 5 0 0 0 ; "WHEE WHEE WHEE WHEE!!!"
					posn: 10 30
					width: 289
					modeless: 1
					init:
				)
				(= seconds 4)
			)
			(9
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(localMusic2 stop:)
				(= cycles 1)
			)
			(10
				(Sounds eachElementDo: #stop)
				(localMusic flags: 1 number: 970 loop: 1 play:)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 98 10)
				(Message msgGET 916 0 0 2 1 @temp1) ; "Was that the beast you could do?"
				(Display @temp1 dsCOORD 30 11 dsWIDTH 260 dsCOLOR 16 dsFONT gUserFont dsALIGN alCENTER)
				(Display @temp1 dsCOORD 29 10 dsWIDTH 260 dsCOLOR 47 dsFONT gUserFont dsALIGN alCENTER)
				(gEgo
					view: 910
					loop: 1
					cel: (gEgo lastCel:)
					normal: 0
					setScale: 0
					scaleX: 128
					scaleY: 128
					posn: 151 97
					setMotion: 0
					show:
				)
				(= cycles 2)
			)
			(11
				(if (& gMsgType $0002)
					(DoAudio audPLAY 916 0 0 2 1)
				)
				(gGame setCursor: gNormalCursor)
				(repeat
					(switch
						(= temp0
							(Print
								window: deathWindow
								posn: 70 130
								addButton: 1 {Restore} 0 15
								addButton: 2 {Restart} 70 15
								addButton: 3 {Quit} 140 15
								init:
							)
						)
						(1
							(gGame restore:)
						)
						(2
							(gGame restart: 1)
						)
						(3
							(= gQuit 1)
							(break)
						)
					)
				)
			)
		)
	)
)

(instance deathWindow of SysWindow
	(properties)

	(method (open)
		(= color 47)
		(= back 0)
		(super open: &rest)
	)
)

(instance localMusic of Kq6Sound
	(properties)
)

(instance localMusic2 of Kq6Sound
	(properties)
)

