;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 850)
(include sci.sh)
(use Main)
(use n001)
(use Interface)
(use LoadMany)
(use Save)
(use Motion)
(use Game)
(use Menu)
(use Actor)
(use System)

(public
	closingCredits 0
)

(local
	moonCel
	mainTitle
	I
	[star 5]
	[starX 5] = [53 170 224 30 284]
	[starY 5] = [16 78 46 84 67]
	[star2X 5] = [53 285 196 85 178]
	[star2Y 5] = [16 16 80 65 14]
	[starPalette 5] = [1 2 3 3 2]
	[bgColor 7] = [13 12 11 10 9 7 3]
	[creditStr 20] = [{Jerry Moore} {Cheryl Loyd} {Doug Herring} {Nate Larsen} {Eric Kasner} {Desie Hartman} {Dean La Rocca} {Tamra Dayton} {Harry McLaughlin} {Corey Cole} {Mark Wilden} {Brian K. Hughes} {Jerry Shaw} {Robert Lee Mallory} {Randy MacNeill} {Gary Kamigawachi} {Robert E. Heitman} {Mark Seibert} {Chris Braymen} {The Whole Gang}]
	[descStr 20] = [{Mr. Science} {No-stress graphics} {Only his wit is sharper than his blade.} {I taught Mr. Science everything he knows.} {Give me some slack.} {I'll be at the candy machine.} {Has anyone got change for a dollar?} {Velcro Mama} {The Joisey Boy} {Owner, Graduate, and\nSole Employee of the\nFamous Programmer's\nCorrespondence School. } {Alleys and plazas are my life.} {Monty Python's summer replacement.} {Spellcaster Master} {Edit, compile, test...\nEdit, compile, beep...\nEdit, compile, test... } {It came from Q.A.} {You want me to work HOW MUCH OVERTIME??} {Quick and Courteous\nCameo Coding } {Whambos and Thuds} {Binks and Thweeps} {Jeff Stephenson, Robert E. Heitman\nDan Foy, Pablo Ghenis, Larry Scott\nEric Hart, J. Mark Hood, John Rettig\nand a cast of several. }]
)

(procedure (AddStars &tmp i)
	(for ((= i 0)) (< i 5) ((++ i))
		((= [star i] (aStar new:))
			cel: i
			x: [starX i]
			y: [starY i]
			palette: [starPalette i]
			init:
			setCycle: Fwd
		)
	)
)

(procedure (MoveStars &tmp i)
	(for ((= i 0)) (< i 5) ((++ i))
		([star i] x: [star2X i] y: [star2Y i] show:)
	)
)

(procedure (NamePrint &tmp pX pY)
	(creditWindow back: [bgColor (Random 0 6)])
	(= pX (if (== I 19) -1 else 85))
	(= pY 40)
	(Print
		[descStr I]
		#at
		pX
		pY
		#title
		[creditStr I]
		#width
		(if (== I 19) 230 else 135)
		#mode
		1
		#window
		creditWindow
		#dispose
	)
	(++ I)
)

(instance closingCredits of Rm
	(properties
		picture 663
		style 42
	)

	(method (init)
		(LoadMany rsVIEW 860 845 850 846 847)
		(Load rsPIC 662)
		(Load rsSOUND 832)
		(= global61 1)
		(moon init:)
		(Title init: hide:)
		(torso init: setCycle: Fwd)
		(egoHead init: setCycle: Fwd)
		(leftArm init: setCycle: Fwd)
		(rightArm init: setCycle: Fwd)
		(reins init: setCycle: Fwd)
		(= gDebugging 0)
		(AddStars)
		(gKeyDownHandler add: self)
		(gMouseDownHandler add: self)
		(super init: &rest)
		(gCurRoom overlay: 659 42)
		(InitAddToPics saurTop saurBottom waist)
		(self setScript: rollTheCredits)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(event claimed: 1)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_F2))
			(soundOnOff)
		)
		(if (not (gCurRoom script:))
			(if
				(or
					(and (== (event type:) evMOUSEBUTTON) (!= (event modifiers:) emSHIFT))
					(and
						(== (event type:) evKEYBOARD)
						(or (== (event message:) KEY_CONTROL) (== (event message:) KEY_RETURN))
					)
				)
				(= gQuit 1)
			)
			(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_F9))
				(gGame restart:)
			)
		)
	)
)

(instance saurTop of PicView
	(properties
		x 40
		y 118
		shiftClick 0
		view 860
		loop 5
		priority 15
		signal 16
		palette 2
	)
)

(instance saurBottom of PicView
	(properties
		x 34
		y 189
		shiftClick 0
		view 860
		loop 6
		priority 15
		signal 16
		palette 2
	)
)

(instance waist of PicView
	(properties
		x 120
		y 189
		shiftClick 0
		view 860
		loop 7
		priority 15
		signal 16400
		palette 2
	)
)

(instance torso of Prop
	(properties
		x 118
		y 178
		shiftClick 0
		view 860
		loop 4
		priority 15
		signal 16
		palette 2
		cycleSpeed 2
	)
)

(instance egoHead of Prop
	(properties
		x 122
		y 130
		shiftClick 0
		view 860
		priority 14
		signal 16
		palette 2
		cycleSpeed 2
	)
)

(instance leftArm of Prop
	(properties
		x 141
		y 186
		shiftClick 0
		view 860
		loop 2
		priority 14
		signal 16
		palette 2
		cycleSpeed 2
	)
)

(instance rightArm of Prop
	(properties
		x 91
		y 180
		shiftClick 0
		view 860
		loop 3
		priority 14
		signal 16
		palette 2
		cycleSpeed 2
	)
)

(instance reins of Prop
	(properties
		x 74
		y 148
		shiftClick 0
		view 860
		loop 1
		priority 14
		signal 16
		palette 2
		cycleSpeed 3
	)
)

(instance moon of Prop
	(properties
		x 280
		y 71
		description {the moon}
		view 845
		signal 28688
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 1) (not (gCurRoom script:)))
			(Print 850 0 67 -1 20 30 0 70 250 28 12 35 theOtherWindow) ; "Ha Ha Ha Haaaaaaah Ha Haah Ha Ha Haaaah Ha Haaaa!"
		)
	)
)

(instance Title of View
	(properties
		x 155
		y 15
		shiftClick 0
		view 850
		priority 15
		signal 16
		palette 2
	)
)

(instance creditWindow of SysWindow
	(properties
		back 12
	)
)

(instance theOtherWindow of SysWindow
	(properties
		back 11
	)
)

(instance rollTheCredits of Script
	(properties)

	(method (changeState newState &tmp changeTitle)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(SetCursor gTheCursor 0)
				(= cycles 20)
			)
			(2
				(self changeState: 4)
			)
			(3
				(= cycles 20)
			)
			(4
				(Title show:)
				(= seconds 3)
			)
			(5
				(NamePrint)
				(moon x: (+ (moon x:) 4) y: (- (moon y:) 1))
				(if (== I 20)
					(= seconds 6)
				else
					(= seconds 3)
				)
			)
			(6
				(cls)
				(= cycles 5)
			)
			(7
				(= changeTitle 0)
				(switch mainTitle
					(0
						(if (== I 9)
							(= changeTitle 1)
						)
					)
					(1
						(if (== I 17)
							(= changeTitle 1)
						)
					)
					(2
						(if (== I 19)
							(= changeTitle 1)
						)
					)
					(3
						(if (== I 20)
							(= changeTitle 1)
						)
					)
					(else
						(= changeTitle 1)
					)
				)
				(if changeTitle
					(if (== (++ mainTitle) 4)
						(self cue:)
					else
						(Title setLoop: (+ (Title loop:) 1) hide:)
						(self changeState: 3)
					)
				else
					(self changeState: 5)
				)
			)
			(8
				(Title dispose:)
				(= cycles 5)
			)
			(9
				(gMiscSound fade:)
				(Print 850 1 #at -1 20 #width 250 #mode 1 #window theOtherWindow #time 15) ; "And so, as the moon moves slowly through the starry sky above the mountains and the desert of Shapeir, our Hero bids a fond "Adieu" to his latest set of adventures and miserable puns. Where will the road lead next...?"
				(theOtherWindow back: 12)
				(Print ; "But wait! There's more to come in the next thrilling saga of "Quest for Glory" by Lori and Corey."
					850
					2
					67
					-1
					20
					70
					250
					29
					12
					30
					1
					35
					theOtherWindow
					25
					8
				)
				(self cue:)
			)
			(10
				(gFeatures eachElementDo: #dispose release:)
				(gMiscSound number: 832 playBed:)
				(torso dispose:)
				(egoHead dispose:)
				(leftArm dispose:)
				(rightArm dispose:)
				(reins dispose:)
				(gCurRoom drawPic: 662 41 overlay: 659 41)
				(moon x: (- (moon x:) 320))
				(MoveStars)
				(InitAddToPics quest For glory III)
				(shadows init:)
				(Of init:)
				(darkness init:)
				(= seconds 5)
			)
			(11
				(++ moonCel)
				(moon setCel: moonCel)
				(if (< 1 moonCel 5)
					(shadows palette: moonCel forceUpd:)
					(Of palette: moonCel forceUpd:)
					(darkness palette: moonCel forceUpd:)
				)
				(= cycles 8)
			)
			(12
				(if (< moonCel 5)
					(self changeState: 11)
				else
					(= seconds 6)
				)
			)
			(13
				(SetCursor gNormalCursor (HaveMouse))
				(gMiscSound stop:)
				(gSpareSound fade:)
				(self dispose:)
			)
		)
	)
)

(instance quest of PicView
	(properties
		x 122
		y 47
		description {whatever}
		view 846
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (and (not (gCurRoom script:)) (== theVerb 1))
			(HighPrint 850 3) ; "Our next game..."
		)
	)
)

(instance For of PicView
	(properties
		x 134
		y 73
		description {whatever}
		view 846
		cel 1
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (and (not (gCurRoom script:)) (== theVerb 1))
			(HighPrint 850 3) ; "Our next game..."
		)
	)
)

(instance glory of PicView
	(properties
		x 212
		y 77
		description {whatever}
		view 846
		cel 2
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (and (not (gCurRoom script:)) (== theVerb 1))
			(HighPrint 850 3) ; "Our next game..."
		)
	)
)

(instance III of PicView
	(properties
		x 290
		y 75
		description {whatever}
		view 846
		loop 1
		priority 15
		signal 16400
	)

	(method (doVerb theVerb)
		(if (and (not (gCurRoom script:)) (== theVerb 1))
			(HighPrint 850 3) ; "Our next game..."
		)
	)
)

(instance shadows of View
	(properties
		x 87
		y 149
		description {whatever}
		view 846
		loop 2
		priority 2
		signal 16401
	)

	(method (doVerb theVerb)
		(if (and (not (gCurRoom script:)) (== theVerb 1))
			(HighPrint 850 3) ; "Our next game..."
		)
	)
)

(instance Of of View
	(properties
		x 174
		y 169
		description {whatever}
		view 846
		loop 2
		cel 1
		priority 15
		signal 16401
	)

	(method (doVerb theVerb)
		(if (and (not (gCurRoom script:)) (== theVerb 1))
			(HighPrint 850 3) ; "Our next game..."
		)
	)
)

(instance darkness of View
	(properties
		x 254
		y 181
		description {whatever}
		view 846
		loop 2
		cel 2
		priority 15
		signal 16401
	)

	(method (doVerb theVerb)
		(if (and (not (gCurRoom script:)) (== theVerb 1))
			(HighPrint 850 3) ; "Our next game..."
		)
	)
)

(instance aStar of Prop
	(properties
		description {whatever}
		view 847
		signal 24592
		cycleSpeed 2
	)

	(method (doVerb theVerb)
		(if (and (not (gCurRoom script:)) (== theVerb 1))
			(HighPrint 850 4) ; "Twinkle, twinkle."
		)
	)
)

